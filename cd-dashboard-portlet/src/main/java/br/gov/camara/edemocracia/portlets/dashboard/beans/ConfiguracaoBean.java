package br.gov.camara.edemocracia.portlets.dashboard.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import br.gov.camara.edemocracia.portlets.dashboard.Recurso;
import br.gov.camara.edemocracia.portlets.dashboard.VisualizacaoDados;
import br.gov.camara.edemocracia.portlets.dashboard.cache.util.DashboardCacheUtil;
import br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao;
import br.gov.camara.edemocracia.portlets.dashboard.manager.ConfiguracaoManager;
import br.gov.camara.edemocracia.portlets.dashboard.service.DashboardLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.ClassNameServiceUtil;
import com.liferay.util.portlet.PortletProps;

@ManagedBean(name = "configBean")
@RequestScoped
public class ConfiguracaoBean implements Serializable {

	private static final long serialVersionUID = 1450749541796782156L;
	private static final Log _log = LogFactoryUtil.getLog(ConfiguracaoBean.class);

	private List<Group> comunidades;
	private Configuracao config;
	private String textoAjuda;
	
	private List<Recurso> recursos;

	@PostConstruct
	private void init() {
		carregarConfiguracao();
		carregarTextoAjudaDeConfiguracao();
		carregarComunidadesDisponiveis();
		carregarRecursosDisponiveis();
	}

	private void carregarComunidadesDisponiveis() {
		try {
			comunidades = DashboardLocalServiceUtil
					.getComunidadesDisponiveis(LiferayFacesContext
							.getInstance().getCompanyId());

		} catch (SystemException e) {
			mostrarMensagemDeErro("Erro ao recuperar comunidades disponíveis.");
			_log.error("Erro ao recuperar comunidades disponíveis.", e);
		}
	}

	private void carregarConfiguracao() {
		try {
			Configuracao config = ConfiguracaoManager.getConfiguracao();
			if (config == null) {
				this.config = Configuracao.getConfiguracaoPadrao();
			} else {
				this.config = config;
			}
		} catch (JSONException e) {
			mostrarMensagemDeErro("Erro ao carregar configuração.");
			_log.error("Ocorreu um erro ao carregar configuracao.", e);
		}
	}
	
	private void carregarTextoAjudaDeConfiguracao(){
		Recurso recursoSelecionado = Recurso.withValue(config.getRecurso());
		String ajuda = PortletProps.get("ajuda." + recursoSelecionado.toString().toLowerCase());
		textoAjuda = recursoSelecionado.getLabelConfiguracao() + ": " + ajuda;
	}
	
	/**
	 * Verifica se os portlets que contem os recursos 
	 * disponiveis no dashboard estão instalados.
	 * 
	 */
	private void carregarRecursosDisponiveis() {
		recursos = new ArrayList<Recurso>();
		Recurso[] recursosCadastrados = Recurso.values();
		for (Recurso recurso : recursosCadastrados) {
			
			long classNameId = 0;
			
			try {
				classNameId = ClassNameServiceUtil.fetchClassNameId(recurso.getClassName());
				
			} catch (Exception ex) {
				_log.error("Erro ao recuperar classNameIds. ", ex);
			}

			if (classNameId != 0) {
				recursos.add(recurso);
			}
		}
	}
	
	public void exibirAjuda(final AjaxBehaviorEvent event){
		carregarTextoAjudaDeConfiguracao();
	}

	public String gravarConfiguracoes() throws JSONException {

		try {
			ConfiguracaoManager.salvarConfiguracao(config);
			String portletInstanceId = (String) LiferayFacesContext.getInstance().getRequestAttribute("PORTLET_ID");
			DashboardCacheUtil.limparTodos(portletInstanceId);
			mostrarMensagemDeSucesso("Configurações gravadas com sucesso!");

		} catch (ReadOnlyException e) {
			mostrarMensagemDeErro("Erro ao salvar configuração.");
			_log.error("Erro ao salvar configuração.", e);
		} catch (ValidatorException e) {
			mostrarMensagemDeErro("Erro ao salvar configuração.");
			_log.error("Erro ao salvar configuração.", e);
		} catch (IOException e) {
			mostrarMensagemDeErro("Erro ao salvar configuração.");
			_log.error("Erro ao salvar configuração.", e);
		} catch (Exception e) {
			mostrarMensagemDeErro("Erro ao salvar configuração.");
			_log.error("Erro ao salvar configuração.", e);
		}

		return null;
	}

	private void mostrarMensagemDeErro(String mensagem) {
		LiferayFacesContext.getInstance().addGlobalErrorMessage(mensagem);
	}

	private void mostrarMensagemDeSucesso(String mensagem) {
		LiferayFacesContext.getInstance().addGlobalInfoMessage(mensagem);
	}

	public VisualizacaoDados[] getModosVisualizacao() {
		return VisualizacaoDados.values();
	}
	
	public List<Recurso> getRecursos(){
		return recursos;
	}

	public List<Group> getComunidades() {
		return comunidades;
	}

	public void setComunidades(List<Group> comunidades) {
		this.comunidades = comunidades;
	}

	public Configuracao getConfig() {
		return config;
	}

	public void setConfig(Configuracao config) {
		this.config = config;
	}
	
	public String getTextoAjuda() {
		return textoAjuda;
	}

}
