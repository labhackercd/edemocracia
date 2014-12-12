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
package br.gov.camara.edemocracia.portlets.comunidades.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.gov.camara.edemocracia.portlets.comunidades.ElementoComunidade;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public abstract class ListaComunidadesPortlet extends MVCPortlet {

	public ListaComunidadesPortlet() {
		super();
	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay td = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		List<Group> comunidades = getComunidades(renderRequest, td);
		int pageSize = getPageSize(renderRequest);
		int pageTotal = getPageTotal(comunidades, pageSize);
		int currentPage = getCurrentPage(renderRequest, pageTotal);
		List<ElementoComunidade> page = getPage(comunidades, td,
				pageSize, currentPage);

		String titulo = getTitulo();

		renderRequest.setAttribute("comunidades", page);
		renderRequest.setAttribute("pageSize", pageSize);
		renderRequest.setAttribute("currentPage", currentPage);
		renderRequest.setAttribute("pageTotal", pageTotal);
		renderRequest.setAttribute("titulo", titulo);
		super.doView(renderRequest, renderResponse);
	}

	private ElementoComunidade makeElementoComunidade(Group grp,
			ThemeDisplay td)
			throws SystemException, PortalException {
		long plid;
		long grpId = grp.getGroupId();
		if (grp.getPrivateLayoutsPageCount() > 0)
			plid = LayoutLocalServiceUtil.getDefaultPlid(grpId, true);
		else
			plid = LayoutLocalServiceUtil.getDefaultPlid(grpId, false);
		Layout layout = LayoutLocalServiceUtil.getLayout(plid);
		
		String grpUrl = PortalUtil.getLayoutURL(layout, td, true);
		String grpName = grp.getName();
		String grpImgUrl = CommunityIconFinder.findUrl(td, grpId);
		return new ElementoComunidade(grpUrl, grpName, grpImgUrl);

	}

	private int getPageSize(RenderRequest renderRequest) {
		PortletPreferences pp = renderRequest.getPreferences();

		int pageSize = 5;

		String strPageSize = pp.getValue("comm_page_size", Integer
				.toString(pageSize));

		try {
			pageSize = Integer.parseInt(strPageSize);
		} catch (NumberFormatException nfe) {
			//
		}
		return pageSize;
	}

	private int getPageTotal(List<Group> comunidades, int pageSize) {
		int size = comunidades.size();
		return (size % pageSize == 0) && size > 0 ? size / pageSize : size
				/ pageSize + 1;
	}

	private int getCurrentPage(RenderRequest renderRequest, int pageTotal) {
		int currentPage = ParamUtil.getInteger(renderRequest, "currentPage", 1);
		currentPage = currentPage <= pageTotal ? currentPage : pageTotal;
		currentPage = currentPage >= 1 ? currentPage : 1;
		return currentPage;
	}

	private List<ElementoComunidade> getPage(
			List<Group> comunidades, ThemeDisplay td, int pageSize, int currentPage) {
		int size = comunidades.size();
		List<Group> page = size == 0 ? comunidades : comunidades
				.subList((currentPage - 1) * pageSize, Math.min(size,
						currentPage * pageSize));
		
		ArrayList<ElementoComunidade> ret = new ArrayList<ElementoComunidade>();
		for (Group group : page) {
			try {
				ret.add(makeElementoComunidade(group, td));
			} catch (PortalException e) {
				// TODO LOG
			} catch (SystemException e) {
				// TODO LOG
			}
		}
		return ret;
	}

	protected abstract List<Group> getComunidades(
			PortletRequest renderRequest, ThemeDisplay td);

	protected abstract String getTitulo();

}