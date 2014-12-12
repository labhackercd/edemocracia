/**
 * Copyright (c) 2009-2014 Câmara dos Deputados. Todos os direitos reservados.
 *
 * e-Democracia é um software livre; você pode redistribuí-lo e/ou modificá-lo dentro
 * dos termos da Licença Pública Geral Menor GNU como publicada pela Fundação do 
 * Software Livre (FSF); na versão 2.1 da Licença, ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser  útil, mas SEM NENHUMA GARANTIA;
 * sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR.
 * Veja a Licença Pública Geral Menor GNU para maiores detalhes. 
 */
package br.gov.camara.edemocracia.portlets.priorizacao.service.impl;

import java.util.List;

import br.gov.camara.edemocracia.portlets.priorizacao.UsuariosComMaisVotosPorPropostaException;
import br.gov.camara.edemocracia.portlets.priorizacao.UsuariosComMaisVotosTotaisException;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Voto;
import br.gov.camara.edemocracia.portlets.priorizacao.service.base.ConfiguracaoLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;

/**
 * The implementation of the configuracao local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.gov.camara.edemocracia.portlets.priorizacao.service.ConfiguracaoLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link br.gov.camara.edemocracia.portlets.priorizacao.service.ConfiguracaoLocalServiceUtil} to access the configuracao local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author robson
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.base.ConfiguracaoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.ConfiguracaoLocalServiceUtil
 */
public class ConfiguracaoLocalServiceImpl
    extends ConfiguracaoLocalServiceBaseImpl {
	
	/**
	 * Retorna a configuração definida na comunidade especificada
	 * 
	 * @param groupId
	 * @return
	 * @throws SystemException
	 * @throws PortalException 
	 */
	public Configuracao getConfiguracaoPorGrupo(long groupId) throws SystemException, PortalException{
		Configuracao config = configuracaoPersistence.fetchByG(groupId);
		if (config == null) {
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			config = createConfiguracao(counterLocalService.increment());
			config.setGroupId(groupId);
			config.setCompanyId(group.getCompanyId());
			config.setMaximoVotos(20);
			config.setMaxVotosProposta(5);
			configuracaoPersistence.update(config, true);
		}
		return config;
	}

	
	/**
	 * Atualiza a configuração da comunidade especificada
	 * 
	 * @param groupId
	 * @param maximoVotos
	 * @param maxVotosProposta
	 * @return
	 * @throws SystemException
	 * @throws PortalException 
	 */
	public Configuracao updateConfiguracao(long groupId, int maximoVotos, int maxVotosProposta, boolean votacaoAberta) throws SystemException, PortalException{
		
		Configuracao configuracao = getConfiguracaoPorGrupo(groupId);
		
		// Verifica se não haverá comprometimento dos votos já colocados
		if (maxVotosProposta < configuracao.getMaxVotosProposta()) {
			if (votoLocalService.existemUsuariosComMaisVotosPorProposta(groupId, maxVotosProposta))
				throw new UsuariosComMaisVotosPorPropostaException();
		}
		if (maximoVotos < configuracao.getMaximoVotos()) {
			if (votoLocalService.existemUsuariosComMaisVotos(groupId, maximoVotos))
				throw new UsuariosComMaisVotosTotaisException();
		}

		
		// Atualiza os dados de votos pendentes dos usuários por proposta
		int diferenca = maxVotosProposta - configuracao.getMaxVotosProposta();
		if (diferenca != 0) {
			DynamicQuery qP = DynamicQueryFactoryUtil.forClass(Proposta.class);
			qP.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
			qP.setProjection(ProjectionFactoryUtil.property("propostaId"));
			DynamicQuery q = DynamicQueryFactoryUtil.forClass(Voto.class);
			q.add(PropertyFactoryUtil.forName("propostaId").in(qP));
			
			@SuppressWarnings("unchecked")
			List<Voto> votos = dynamicQuery(q);
			for (Voto voto : votos) {
				voto.setVotosDisponiveis(voto.getVotosDisponiveis() + diferenca);
				votoLocalService.updateVoto(voto);
			}
		}
		
		
		configuracao.setMaximoVotos(maximoVotos);
		configuracao.setMaxVotosProposta(maxVotosProposta);
		configuracao.setVotacaoAberta(votacaoAberta);
		Configuracao config = configuracaoPersistence.update(configuracao, false);
		
		return config;
	} 
	
}
