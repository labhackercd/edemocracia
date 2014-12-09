package br.gov.camara.edemocracia.portlets.guiadiscussao.service.impl;

import java.util.List;
import java.util.Map;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.AcaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.base.AcaoLocalServiceBaseImpl;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.persistence.AcaoPersistence;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the acao local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.guiadiscussao.service.AcaoLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Robson
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.service.base.AcaoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.service.AcaoLocalServiceUtil
 */
public class AcaoLocalServiceImpl extends AcaoLocalServiceBaseImpl {

	public Acao addAcao(Acao acao) throws SystemException {
		AcaoPersistence acaoPersistence = getAcaoPersistence();
		Acao novaAcao = acaoPersistence.create(getCounterLocalService()
				.increment(Acao.class.getName()));
		novaAcao.setIconeId(acao.getIconeId());
		novaAcao.setTexto(acao.getTexto());
		novaAcao.setUrlExterna(acao.getUrlExterna());
		novaAcao.setUrlLink(acao.getUrlLink());
		int totalDeAcoes = acaoPersistence.countByFaseId(acao.getFaseId());
		novaAcao.setOrdem(totalDeAcoes + 1);
		novaAcao.setFaseId(acao.getFaseId());
		return acaoPersistence.update(novaAcao, false);

	}

	public void excluirAcao(long acaoId) throws PortalException,
			SystemException {

		Acao acao = getAcao(acaoId);

		List<Acao> acoes = AcaoLocalServiceUtil.getAcoesByFaseId(acao
				.getFaseId());

		// Atualiza a ordem das demais acões
		for (Acao outraAcao : acoes) {
			if (outraAcao.getOrdem() > acao.getOrdem()) {
				outraAcao.setOrdem(outraAcao.getOrdem() - 1);
				acaoPersistence.update(outraAcao, false);
			}
		}

		deleteAcao(acao);
	}

	public List<Acao> getAcoesByFaseId(long faseId) throws SystemException {
		return acaoPersistence.findByFaseId(faseId);
	}
	
	/**
	 * Atualiza a ordem das ações
	 * 
	 * @param faseId
	 * @param novaOrdenacao mapa com o id da ação e a nova ordem 
	 * @throws SystemException
	 */
	public void atualizarOrdenacaoDasAcoes(Long faseId, Map<Long, Integer> novaOrdenacao) throws SystemException{
		List<Acao> acoes = AcaoLocalServiceUtil.getAcoesByFaseId(faseId);
		
		for(Acao acao : acoes){
			acao.setOrdem(novaOrdenacao.get(acao.getAcaoId()));
			acaoPersistence.update(acao, false);
		}
		
	}
}
