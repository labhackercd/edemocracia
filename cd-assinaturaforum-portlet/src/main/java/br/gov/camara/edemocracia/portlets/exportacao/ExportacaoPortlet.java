package br.gov.camara.edemocracia.portlets.exportacao;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.sql.SQLException;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import br.gov.camara.edemocracia.portlets.exportacao.csv.ExportacaoCSV;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortlet;
import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class ExportacaoPortlet extends LiferayPortlet {
	
	private static final Log LOG = LogFactoryUtil.getLog(ExportacaoPortlet.class);

	@Override
	protected void doView(RenderRequest request, RenderResponse response) throws PortletException, java.io.IOException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(
				"/html/exportacao/exportacao.jsp");
		portletRequestDispatcher.include(request, response);
	}

	/**
	 * Verifica se o usuário possui permissões
	 * 
	 * @param request
	 * @return
	 */
	private boolean hasPermission(PortletRequest request, boolean admin_data) {
		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String name = td.getPortletDisplay().getRootPortletId();
		String primKey;
		if ("".equals(name) || name == null) {
			name = PortalUtil.getPortletId(request);
			primKey = td.getLayout().getPlid() + LiferayPortletSession.LAYOUT_SEPARATOR + name;
		} else {
			primKey = td.getPortletDisplay().getResourcePK();
		}
		
		boolean userAdmin = td.getPermissionChecker().isCommunityAdmin(td.getScopeGroupId());
		boolean hasPermission = td.getPermissionChecker().hasPermission(td.getScopeGroupId(), name, primKey, "VIEW");
		
		if(admin_data)
			return (userAdmin && hasPermission); 
		else
			return hasPermission ;
	}

	/**
	 * Fornece o arquivo CSV
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {

		ThemeDisplay td = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean dadosAdmin = Boolean.parseBoolean(resourceRequest.getParameter("ad"));
		long groupId = td.getScopeGroupId();
		
		if (hasPermission(resourceRequest,dadosAdmin)) {

			resourceResponse.setContentType("text/csv; charset=ISO-8859-1");
			resourceResponse.setCharacterEncoding("ISO-8859-1");
			resourceResponse.setProperty("content-disposition", "attachment;filename=propostas.csv");

			OutputStream os = resourceResponse.getPortletOutputStream();
			Writer writer = new OutputStreamWriter(os, Charset.forName(resourceResponse.getCharacterEncoding()));

			try {
				ExportacaoCSV.getCSV(groupId, writer, dadosAdmin);
				
			} catch (SystemException e) {
				LOG.error("Erro ao exportar dados do fórum",e);
				throw new PortletException(e);
			} catch (SQLException e) {
				LOG.error("Erro ao exportar dados do fórum",e);
				throw new PortletException(e);
			} catch (PortalException e) {
				LOG.error("Erro ao exportar dados do fórum",e);
				throw new PortletException(e);
			}finally{
				writer.flush();
				writer.close();
			}
			
		} else {
			//Ideal setar a propriedade status code, mas há um bug no liferay 6.0.5 e foi corrigido somente no liferay 6.1
			//resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "550");
			resourceResponse.getWriter().write("<h1>550 Permissão negada</h1>");
			super.serveResource(resourceRequest, resourceResponse);
		}

	}
	
}
