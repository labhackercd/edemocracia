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
package br.gov.camara.edemocracia.portlets.priorizacao.ui.components;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.RequestCycle;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.protocol.http.WebRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLFactoryUtil;

/**
 * Link para a página de permissões do Liferay
 * 
 * @author robson
 * 
 */
public class GroupPermissionLink extends ExternalLink {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4242164386936174026L;

	public GroupPermissionLink(String id, final String modelResource, final String modelResourceDescription) {
		super(id, new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				return buildHref(modelResource, modelResourceDescription);
			}
		});
	}

	/**
	 * Código copiado de PermissionsURLTag
	 * 
	 * @param modelResource
	 * @param modelResourceDescription
	 * @return
	 */
	private static String buildHref(String modelResource, String modelResourceDescription) {

		HttpServletRequest request = ((WebRequest) RequestCycle.get().getRequest()).getHttpServletRequest();

		String resourcePrimKey;
		try {
			resourcePrimKey = Long.toString(PortalUtil.getScopeGroupId(request));
		} catch (Exception e) {
			throw new RuntimeException("Unable to find scopeGroupId");
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		Layout layout = themeDisplay.getLayout();

		String redirect = PortalUtil.getCurrentURL(request);

		PortletURL portletURL = PortletURLFactoryUtil.create(request, PortletKeys.PORTLET_CONFIGURATION, layout.getPlid(),
				PortletRequest.RENDER_PHASE);

		try {
			if (themeDisplay.isStatePopUp()) {
				portletURL.setWindowState(LiferayWindowState.POP_UP);
			} else {
				portletURL.setWindowState(WindowState.MAXIMIZED);
			}
		} catch (WindowStateException e) {
			// TODO Log
		}

		portletURL.setParameter("struts_action", "/portlet_configuration/edit_permissions");
		portletURL.setParameter("redirect", redirect);

		if (!themeDisplay.isStateMaximized()) {
			portletURL.setParameter("returnToFullPageURL", redirect);
		}

		portletURL.setParameter("portletResource", portletDisplay.getId());
		portletURL.setParameter("modelResource", modelResource);
		portletURL.setParameter("modelResourceDescription", modelResourceDescription);
		portletURL.setParameter("resourcePrimKey", resourcePrimKey);

		return portletURL.toString();

	}

}
