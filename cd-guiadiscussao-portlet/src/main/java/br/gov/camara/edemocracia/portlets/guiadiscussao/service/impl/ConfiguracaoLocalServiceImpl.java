package br.gov.camara.edemocracia.portlets.guiadiscussao.service.impl;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.FaseLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.base.ConfiguracaoLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the configuracao local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.guiadiscussao.service.ConfiguracaoLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Robson
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.service.base.ConfiguracaoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.service.ConfiguracaoLocalServiceUtil
 */
public class ConfiguracaoLocalServiceImpl extends
		ConfiguracaoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.gov.camara.edemocracia
	 * .portlets.guiadiscussao.service.ConfiguracaoLocalServiceUtil} to access
	 * the configuracao local service.
	 */
	public Configuracao getByGroupId(long groupId) throws SystemException {
		Configuracao config = configuracaoPersistence.fetchByGroupId(groupId);
		if (config == null) {
			config = createConfiguracao(counterLocalService.increment());
			config.setGroupId(groupId);
			configuracaoPersistence.update(config, true);
		}

		return config;
	}

	public void marcarFaseComoAtual(long faseId) throws PortalException,
			SystemException {

		Fase fase = FaseLocalServiceUtil.getFase(faseId);

		long configuracaoId = fase.getConfiguracaoId();
		Configuracao configuracao = getConfiguracaoLocalService()
				.getConfiguracao(configuracaoId);

		configuracao.setFaseAtualId(fase.getFaseId());
		configuracaoPersistence.update(configuracao, false);

	}

}
