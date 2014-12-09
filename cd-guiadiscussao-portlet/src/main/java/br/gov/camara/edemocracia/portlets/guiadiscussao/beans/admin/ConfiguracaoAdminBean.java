package br.gov.camara.edemocracia.portlets.guiadiscussao.beans.admin;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.ConfiguracaoLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean(name = "configuracaoAdminBean")
@ViewScoped
public class ConfiguracaoAdminBean implements Serializable {

	private static final long serialVersionUID = -2274903637024992025L;
	private Configuracao config;
	
	private static final Log LOG = LogFactoryUtil
			.getLog(ConfiguracaoAdminBean.class);

	@PostConstruct
	private void init() {
		atualizaConfiguracao();
	}

	public void marcarAtual(long faseId) {
		try {
			ConfiguracaoLocalServiceUtil.marcarFaseComoAtual(faseId);
		} catch (PortalException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"#{i18n['fase-nao-encontrada']}");
			// TODO pensar melhor
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

		atualizaConfiguracao();
	}
	
	public void atualizaConfiguracao() {

		try {
			this.config = ConfiguracaoLocalServiceUtil
					.getByGroupId(LiferayFacesContext.getInstance()
							.getScopeGroupId());
			
		} catch (SystemException e) {
			LOG.error("Erro ao recuperar configuração para esta comunidade.", e);
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"Erro ao recuperar configuração para esta comunidade.");
		}
	}
	
	public Configuracao getConfig() {
		return config;
	}

	public void setConfig(Configuracao config) {
		this.config = config;
	}
	
}
