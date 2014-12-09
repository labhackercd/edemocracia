/**
 * 
 */
package br.gov.camara.edemocracia.portlets.contadores;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import br.gov.camara.edemocracia.portlets.graficos.DadosConsolidados;
import br.gov.camara.edemocracia.portlets.graficos.service.ContadorAcessoLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortlet;
import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * @author robson
 * 
 */
public class ContadoresPortlet extends LiferayPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response) throws PortletException, java.io.IOException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(
				"/html/contadores/contadores.jsp");

		long companyId = PortalUtil.getCompanyId(request);

		try {
			if (hasPermission(request)) {
				Map<Long, DadosConsolidados> dados = ContadorAcessoLocalServiceUtil.getDadosConsolidados(companyId);
				request.setAttribute("dados", dados);

				ArrayList<Group> grupos = new ArrayList<Group>();
				for (Long groupId : dados.keySet()) {
					if (groupId != null) {
						try {
							grupos.add(GroupLocalServiceUtil.getGroup(groupId));
						} catch (PortalException e) {
						}
					} else {
						grupos.add(null);
					}
				}
				request.setAttribute("grupos", grupos);
			} else {
				request.setAttribute("dados", Collections.EMPTY_MAP);
			}

		} catch (SystemException e) {
			if (e.getCause() == null)
				throw new PortletException(e);
			else
				throw new PortletException(e.getCause());
		}

		portletRequestDispatcher.include(request, response);
	}

	/**
	 * Verifica se o usuário possui permissões
	 * 
	 * @param request
	 * @return
	 */
	private boolean hasPermission(PortletRequest request) {
		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String name = td.getPortletDisplay().getRootPortletId();
		String primKey;
		if ("".equals(name) || name == null) {
			name = PortalUtil.getPortletId(request);
			primKey = td.getLayout().getPlid() + LiferayPortletSession.LAYOUT_SEPARATOR + name;
		} else {
			primKey = td.getPortletDisplay().getResourcePK();
		}
		return td.getPermissionChecker().hasPermission(td.getScopeGroupId(), name, primKey, "VIEW");
	}

	/**
	 * Fornece o arquivo CSV
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {

		if (hasPermission(resourceRequest)) {

			resourceResponse.setContentType("text/csv; charset=ISO-8859-1");
			resourceResponse.setCharacterEncoding("ISO-8859-1");
			resourceResponse.setProperty("content-disposition", "attachment;filename=contadores.csv");

			OutputStream os = resourceResponse.getPortletOutputStream();
			Writer writer = new OutputStreamWriter(os, Charset.forName(resourceResponse.getCharacterEncoding()));

			long companyId = PortalUtil.getCompanyId(resourceRequest);
			try {
				writer.write(ContadorAcessoLocalServiceUtil.getCSV(companyId));
			} catch (SystemException e) {
				throw new PortletException(e);
			}
			writer.flush();
		} else {
			super.serveResource(resourceRequest, resourceResponse);
		}

	}

}
