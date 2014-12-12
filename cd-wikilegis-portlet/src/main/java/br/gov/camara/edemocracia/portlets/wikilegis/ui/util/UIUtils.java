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
package br.gov.camara.edemocracia.portlets.wikilegis.ui.util;

import java.util.Locale;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.RequestCycle;
import org.apache.wicket.protocol.http.WebRequest;

import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * @author robson
 * 
 */
public final class UIUtils {

	private UIUtils() {

	}

	/**
	 * Obtém o theme display
	 * 
	 * @return
	 */
	public static ThemeDisplay getThemeDisplay() {
		HttpServletRequest req = getHttpServletRequest();
		return (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
	}

	public static HttpServletRequest getHttpServletRequest() {
		HttpServletRequest req = ((WebRequest) RequestCycle.get().getRequest())
				.getHttpServletRequest();
		return req;
	}

	/**
	 * Obtém o locale
	 * 
	 * @return
	 */
	public static Locale getUserLocale() {
		return getThemeDisplay().getLocale();
	}

	/**
	 * Verifica se o usuário possui as permissões especificadas
	 * 
	 * @param actionId
	 * @return
	 */
	public static boolean possuiPermissoes(String actionId) {
		ThemeDisplay td = getThemeDisplay();
		String name = td.getPortletDisplay().getRootPortletId();
		String primKey;
		if ("".equals(name) || name == null) {
			name = PortalUtil.getPortletId(getHttpServletRequest());
			primKey = td.getLayout().getPlid()
					+ LiferayPortletSession.LAYOUT_SEPARATOR + name;
		} else {
			primKey = td.getPortletDisplay().getResourcePK();
		}
		return td.getPermissionChecker().hasPermission(td.getScopeGroupId(),
				name, primKey, actionId);
	}

	/**
	 * Obtem o identificador do grupo
	 * 
	 * @return
	 */
	public static long getScopeGroupId() {
		return getThemeDisplay().getScopeGroupId();
	}

	/**
	 * Obtém as preferências do portlet
	 * @return
	 */
	public static PortletPreferences getPortletPreferences() {
		HttpServletRequest req = getHttpServletRequest();
		PortletRequest preq = (PortletRequest) req.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);
		return preq.getPreferences();
	}
	
	public static PortletRequest getPortletRequest(){
		HttpServletRequest req = getHttpServletRequest();
		PortletRequest preq = (PortletRequest) req.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);
		return preq;		
	} 
	
	/**
	 * Nunca deve ser chamado dentro de um método ON...
	 * @return 
	 */
	public static RenderResponse getRenderResponse(){
		HttpServletRequest req = getHttpServletRequest();
		RenderResponse rreq = (RenderResponse) req.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);
		return rreq;		
	}
	
	/**
	 * Verifica se o usuário é o dono do recurso e possui as permissões especificadas
	 * @param ownerId
	 * @param actionId
	 * @return
	 */
	public static boolean isOwner(long ownerId, String actionId){
		ThemeDisplay td = getThemeDisplay();
		String name = td.getPortletDisplay().getRootPortletId();
		String primKey;
		if ("".equals(name) || name == null) {
			name = PortalUtil.getPortletId(getHttpServletRequest());
			primKey = td.getLayout().getPlid()
					+ LiferayPortletSession.LAYOUT_SEPARATOR + name;
		} else {
			primKey = td.getPortletDisplay().getResourcePK();
		}
		return td.getPermissionChecker().hasOwnerPermission(td.getCompanyId(), name, primKey, ownerId, actionId);
	}
	
}
