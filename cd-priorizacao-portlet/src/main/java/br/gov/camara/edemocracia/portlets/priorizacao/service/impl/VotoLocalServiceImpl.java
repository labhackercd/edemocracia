package br.gov.camara.edemocracia.portlets.priorizacao.service.impl;

import java.util.Date;
import java.util.List;

import br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException;
import br.gov.camara.edemocracia.portlets.priorizacao.TotalVotosExcedidoException;
import br.gov.camara.edemocracia.portlets.priorizacao.VotacaoFechadaException;
import br.gov.camara.edemocracia.portlets.priorizacao.VotosPorPropostaExcedidoException;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Voto;
import br.gov.camara.edemocracia.portlets.priorizacao.service.base.VotoLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the voto local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.priorizacao.service.VotoLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.priorizacao.service.VotoLocalServiceUtil}
 * to access the voto local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author robson
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.base.VotoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.VotoLocalServiceUtil
 */
public class VotoLocalServiceImpl extends VotoLocalServiceBaseImpl {

	/**
	 * Conta os votos por identificador de proposta
	 * 
	 * @param propostaId
	 * @return
	 * @throws SystemException
	 */
	@Override
	public int getVotosByPropostaId(long propostaId) throws SystemException {
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Voto.class);
		dq.add(RestrictionsFactoryUtil.eq("propostaId", propostaId));
		dq.setProjection(ProjectionFactoryUtil.sum("numeroVotos"));
		List<?> ret = dynamicQuery(dq);
		if (ret.isEmpty() || ret.get(0) == null)
			return 0;
		else
			return ((Number) ret.get(0)).intValue();
	}

	/**
	 * Conta os votos por usuário
	 * 
	 * @param groupId
	 * @param userId
	 * @return
	 * @throws SystemException
	 */
	public int getVotosByUsuarioId(long groupId, long userId)
			throws SystemException {

		DynamicQuery dqEixo = DynamicQueryFactoryUtil.forClass(Eixo.class);
		dqEixo.setProjection(ProjectionFactoryUtil.property("eixoId"));
		dqEixo.add(RestrictionsFactoryUtil.eq("groupId", groupId));

		DynamicQuery dqProposta = DynamicQueryFactoryUtil
				.forClass(Proposta.class);
		dqProposta.setProjection(ProjectionFactoryUtil.property("propostaId"));
		dqProposta.add(PropertyFactoryUtil.forName("eixoId").in(dqEixo));

		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(Voto.class);
		dq.add(RestrictionsFactoryUtil.eq("userId", userId));
		dq.add(PropertyFactoryUtil.forName("propostaId").in(dqProposta));
		dq.setProjection(ProjectionFactoryUtil.sum("numeroVotos"));
		List<?> ret = dynamicQuery(dq);
		if (ret.isEmpty() || ret.get(0) == null)
			return 0;
		else
			return ((Number) ret.get(0)).intValue();
	}

	/**
	 * Retorna o número de votos disponíveis de um usuário
	 * 
	 * @param groupId
	 * @param userId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public int getVotosDisponiveisByUsuarioId(long groupId, long userId)
			throws SystemException, PortalException {
		Configuracao config = configuracaoLocalService
				.getConfiguracaoPorGrupo(groupId);
		int maximoDisponivel = config.getMaximoVotos();
		int disponiveis = maximoDisponivel
				- getVotosByUsuarioId(groupId, userId);
		if (disponiveis < 0)
			return 0;
		else
			return disponiveis;
	}

	/**
	 * Exclui um voto na propsota especificada
	 * 
	 * @param propostaId
	 * @param userId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void deleteVoto(long propostaId, long userId)
			throws SystemException, PortalException {
		User user = UserLocalServiceUtil.getUser(userId);
		if (user.isDefaultUser())
			return;

		Proposta proposta = propostaLocalService.getProposta(propostaId);
		Configuracao config = configuracaoLocalService
				.getConfiguracaoPorGrupo(proposta.getGroupId());
		if (!config.isVotacaoAberta()) {
			throw new VotacaoFechadaException();
		}
		
		Voto voto = votoPersistence.fetchByP_U(propostaId, userId);
		if (voto == null || voto.getNumeroVotos() <= 0)
			return;
		
		voto.setNumeroVotos(voto.getNumeroVotos()-1);
		voto.setVotosDisponiveis(voto.getVotosDisponiveis()+1);
		voto.setData(new Date());
		if (voto.getNumeroVotos() <= 0) {
			deleteVoto(voto);
		} else {
			updateVoto(voto);
		}
	}

	/**
	 * Adiciona um voto
	 * 
	 * @param propostaId
	 * @param userName
	 * @param userUuid
	 * @param userId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void addVoto(long propostaId, long userId) throws SystemException,
			PortalException {
		User user = UserLocalServiceUtil.getUser(userId);
		if (user.isDefaultUser())
			return;

		Proposta proposta = propostaLocalService.getProposta(propostaId);
		Configuracao config = configuracaoLocalService
				.getConfiguracaoPorGrupo(proposta.getGroupId());
		
		if (!config.isVotacaoAberta()) {
			throw new VotacaoFechadaException();
		}
		
		int totalVotos = getVotosDisponiveisByUsuarioId(proposta.getGroupId(),
				user.getUserId());
		if (totalVotos <= 0)
			throw new TotalVotosExcedidoException();

		Voto voto;
		try {
			voto = votoPersistence.findByP_U(propostaId, userId);
		} catch (NoSuchVotoException e) {
			voto = createVoto(counterLocalService.increment());

			voto.setUserId(user.getUserId());
			voto.setUserUuid(user.getUserUuid().trim());
			voto.setPropostaId(propostaId);
			voto.setVotosDisponiveis(config.getMaxVotosProposta());
			voto.setData(new Date());
		}

		if (voto.getVotosDisponiveis() <= 0)
			throw new VotosPorPropostaExcedidoException();

		voto.setUserName(user.getFullName().trim());
		voto.setVotosDisponiveis(voto.getVotosDisponiveis() - 1);
		voto.setNumeroVotos(voto.getNumeroVotos() + 1);
		voto.setData(new Date());

		votoPersistence.update(voto, false);
	}

	/**
	 * Lista os votos do usuário na proposta especificada
	 * 
	 * @param propostaId
	 * @param userId
	 * @return
	 * @throws SystemException
	 */
	@Override
	public Voto getVotoPorPropostaIdUserId(long propostaId, long userId)
			throws SystemException {
		return votoPersistence.fetchByP_U(propostaId, userId);
	}

	/**
	 * Verifica se há usuários que colocaram mais votos do que o informado pelo
	 * parâmetro.
	 * 
	 * Utilizado para verificar se é possível mudar a configuração
	 * 
	 * @param
	 * @param votosPorProposta
	 * @return
	 */
	@Override
	public boolean existemUsuariosComMaisVotosPorProposta(long groupId,
			int votosPorProposta) throws SystemException {
		return votoFinder.countUserIdComMaisVotosPorProposta(groupId,
				votosPorProposta) > 0;
	}

	@Override
	public boolean existemUsuariosComMaisVotos(long groupId, int totalVotos)
			throws SystemException {
		return votoFinder.countUserIdComMaisVotosTotal(groupId, totalVotos) > 0;
	}
	
	/**
	 * Lista todos os votos da proposta especificada
	 * 
	 * @param propostaId
	 * @return
	 * @throws SystemException
	 */
	public List<Voto> getVotosPorPropostaId(long propostaId) throws SystemException{
		return votoPersistence.findByP(propostaId);
	}
}
