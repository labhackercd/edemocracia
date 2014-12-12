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
package br.gov.camara.edemocracia.portlets.dashboard.manager;

import java.io.IOException;

import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.json.JSONException;

public class ConfiguracaoManager {
	
	private static final String CONFIGURACAO_KEY = "config";
	
	public static void salvarConfiguracao(Configuracao config) throws ReadOnlyException, ValidatorException, IOException{
		
		PortletPreferences portletPrefs = LiferayFacesContext.getInstance().getPortletPreferences();
		portletPrefs.setValue(CONFIGURACAO_KEY, config.convertToJSON());
	    portletPrefs.store();
	    
	}
	
	/**
	 * Recupera as configurações do portlet
	 * 
	 * Se não encontrar retorna null
	 * 
	 * @return
	 * @throws JSONException
	 */
	public static Configuracao getConfiguracao() throws JSONException {
		
		PortletPreferences portletPrefs = LiferayFacesContext.getInstance().getPortletPreferences();
		String json = portletPrefs.getValue(CONFIGURACAO_KEY, null);
		
		if (json != null) {
			return Configuracao.createFromJSON(json);
		} else {
			return null;
		}
		
	}
	
}
