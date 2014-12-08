/**
 * 
 */
package br.gov.camara.edemocracia.portlets;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author P_7339
 * 
 */
public class RodapePaginaPortlet extends MVCPortlet {
	
	private static final Log LOG = LogFactoryUtil.getLog(RodapePaginaPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		// Busca as páginas da comunidade "guest"
		ThemeDisplay td = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		LinkedHashMap<String, String> links = new LinkedHashMap<String, String>();
		try {
			Group grupo = GroupLocalServiceUtil.getGroup(td.getCompanyId(),
					GroupConstants.GUEST);
			LayoutSet paginas = grupo.getPublicLayoutSet();
			if (paginas.getPageCount() > 0) {
				List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(
						grupo.getGroupId(), false, GroupConstants.DEFAULT_PARENT_GROUP_ID);

				for (Layout layout : layouts) {
					String url = PortalUtil.getLayoutFullURL(layout, td);
					links.put(layout.getName(td.getLocale()), url);
				}
			}
		} catch (Exception e) {
			LOG.error("Erro ao recuperar páginas da comunidade guest", e);
		}
		renderRequest.setAttribute("links", links);

		super.doView(renderRequest, renderResponse);
	}
}
