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
package br.gov.camara.edemocracia.portlets.dashboard.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.camara.edemocracia.portlets.dashboard.Recurso;
import br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao;
import br.gov.camara.edemocracia.portlets.dashboard.dto.RecursoDTO;
import br.gov.camara.edemocracia.portlets.dashboard.manager.ConfiguracaoManager;
import br.gov.camara.edemocracia.portlets.dashboard.service.DashboardLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.portlet.PortletProps;

@ViewScoped
@ManagedBean
public class InitBean implements Serializable {

	private static final long serialVersionUID = 6111144509335400635L;
	private static final Log _log = LogFactoryUtil.getLog(InitBean.class);
	
	private List<RecursoDTO> dados;
	private Configuracao config = null;
	private boolean configurarPortlet;
	private Recurso recurso;

	@PostConstruct()
	private void init(){
		
		carregarConfiguracao();
		
		if (config == null ) {
			configurarPortlet = true;
			return;
		} else {
			recurso = Recurso.withValue(config.getRecurso());
		}
		
		carregarDados();
	}
	
	private void carregarConfiguracao() {
		
		try {
			config = ConfiguracaoManager.getConfiguracao();

		} catch (JSONException e) {
			mostrarMensagemDeErro("Erro ao recuperar dados.");
			_log.error("Erro ao recuperar dados.",e);
		}
		
	}
	
	private void carregarDados() {
		if (config != null) {
			long companyId = LiferayFacesContext.getInstance().getCompanyId();
			String portletInstanceId = LiferayFacesContext.getInstance().getPortletInstanceId();
			
			try {
				dados = DashboardLocalServiceUtil.getRecursosComMaiorParticipacao(companyId, config, portletInstanceId, recurso);
			
			} catch (SystemException e) {
				dados = new ArrayList<RecursoDTO>();
				mostrarMensagemDeErro("Erro ao recuperar dados.");
				_log.error("Erro ao recuperar dados.",e);
			}
		}
	}
	
	public String getTituloDoPortlet(){
		Recurso recursoSelecionado = Recurso.withValue(config.getRecurso());
		String titulo = PortletProps.get("titulo." + recursoSelecionado.toString().toLowerCase());
		return titulo;
	}
	
	public boolean getConfigurarPortlet() {
		return configurarPortlet;
	}
	
	public List<RecursoDTO> getDados() {
		return dados;
	}

	private void mostrarMensagemDeErro(String mensagem) {
		LiferayFacesContext.getInstance().addGlobalErrorMessage(mensagem);
	}
	
	public Configuracao getConfig() {
		return config;
	}
	
	public Recurso getRecurso() {
		return recurso;
	}
	
}
