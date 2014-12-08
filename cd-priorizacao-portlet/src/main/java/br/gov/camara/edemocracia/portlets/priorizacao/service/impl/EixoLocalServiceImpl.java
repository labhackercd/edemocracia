package br.gov.camara.edemocracia.portlets.priorizacao.service.impl;

import java.util.List;

import br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PropostaLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.service.base.EixoLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupServiceUtil;

/**
 * The implementation of the eixo local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.priorizacao.service.EixoLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.priorizacao.service.EixoLocalServiceUtil}
 * to access the eixo local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author robson
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.base.EixoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.EixoLocalServiceUtil
 */
public class EixoLocalServiceImpl extends EixoLocalServiceBaseImpl {

	/**
	 * Lista todos os eixos
	 * 
	 * @return
	 * @throws SystemException
	 */
	public List<Eixo> listarEixosPorGroupId(long groupId) throws SystemException {
		return eixoPersistence.findByG(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,new EixoComparator());
	}
	
	/**
	 * Cria um eixo na posição especificada
	 * 
	 * @param groupId
	 * @param categoryId
	 * @param sumario
	 * @param titulo
	 * @param eixoAnteriorId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public Eixo addEixo(long groupId, long categoryId, String sumario,
			String titulo, long eixoAnteriorId) throws SystemException,
			PortalException {

		Group group = GroupServiceUtil.getGroup(groupId);
		long companyId = group.getCompanyId();

		// Insere o eixo na posição correta
		int ordem = atualizarPosicaoEixos(groupId, eixoAnteriorId);

		Eixo eixo = createEixo(counterLocalService.increment());
		eixo.setOrdem(ordem);
		eixo.setGroupId(groupId);
		eixo.setCompanyId(companyId);
		eixo.setSumario(sumario);
		eixo.setTitulo(titulo);
		eixo.setCategoryId(categoryId);

		return eixoPersistence.update(eixo, true);
	}
	
	/**
	 * Atualiza um eixo
	 * 
	 * @param eixoId
	 * @param sumario
	 * @param titulo
	 * @param eixoAnteriorId
	 * @param categoryId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */	
	@Transactional(rollbackFor = NoSuchEixoException.class)
	public Eixo updateEixo(long eixoId, String sumario,
			String titulo, long eixoAnteriorId, long categoryId)
			throws SystemException, PortalException {
		
		if(sumario == null) 
			sumario = "";
		sumario = sumario.trim();
		
		if(titulo == null) 
			titulo = "";
		titulo = titulo.trim();
		
		Eixo eixo = eixoPersistence.findByPrimaryKey(eixoId);
		eixo.setSumario(sumario);
		eixo.setTitulo(titulo);	
		eixo.setCategoryId(categoryId);
		
		int ordemAnterior = eixo.getOrdem(); 
		eixo.setOrdem(-1);
		eixoPersistence.update(eixo, false);
		
		List<Eixo> eixos = listarEixosPorGroupId(eixo.getGroupId());
		
		for (Eixo anterior : eixos) {
			if (anterior.getOrdem() > ordemAnterior) {
				anterior.setOrdem(anterior.getOrdem() - 1);
				eixoPersistence.update(anterior, false);
			}
		}
		
		int ordem = atualizarPosicaoEixos(eixo.getGroupId(), eixoAnteriorId);
		eixo.setOrdem(ordem);
		
		return eixoPersistence.update(eixo,false);
	}
	
	private int atualizarPosicaoEixos(long groupId, long eixoAnteriorId)
			throws PortalException, SystemException {
		int ordem = 0;
		if (eixoAnteriorId > 0l) {
			Eixo anterior = getEixo(eixoAnteriorId);
			ordem = anterior.getOrdem() + 1;
		}
		List<Eixo> antigos = eixoPersistence.findByG(groupId);
		for (Eixo antigo : antigos) {
			if (antigo.getOrdem() >= ordem) {
				antigo.setOrdem(antigo.getOrdem() + 1);
				eixoPersistence.update(antigo, false);
			}
		}

		return ordem;
	}
	
	/**
	 * Remove o eixo especificado
	 * 
	 * @param eixo
	 * @throws SystemException
	 */
	public void excluirEixo(Eixo eixo) throws SystemException {

		List<Proposta> propostas = propostaPersistence.findByE(eixo.getEixoId());

		//Deletando todas as propostas do eixo
		for(Proposta proposta: propostas){
			long propostaId = proposta.getPropostaId();			
			votoPersistence.removeByP(propostaId);
			PropostaLocalServiceUtil.deleteProposta(proposta);
		}

		int ordemAnterior = eixo.getOrdem(); 
		List<Eixo> eixos = listarEixosPorGroupId(eixo.getGroupId());
		for (Eixo anterior : eixos) {
			if (anterior.getOrdem() > ordemAnterior) {
				anterior.setOrdem(anterior.getOrdem() - 1);
				eixoPersistence.update(anterior, false);
			}
		}
		
		//Deletando eixo
		super.deleteEixo(eixo);
	}
	
	/**
	 * Remove um eixo e suas propostas
	 * 
	 * @param eixoId
	 * @throws PortalException
	 * @throws SystemException
	 */	
	public void excluirEixo(long eixoId) throws PortalException, SystemException{
		
		deleteEixo(eixoPersistence.findByPrimaryKey(eixoId));
	}
	
	/**
	 * Retorna o a quantidade de eixos cadastrados na comunidade especificada
	 * 
	 * @param groupId
	 * @return
	 * @throws SystemException
	 */
	public int getEixosCountByGroupId(long groupId) throws SystemException{
		return eixoPersistence.countByG(groupId); 
	}
	

}
