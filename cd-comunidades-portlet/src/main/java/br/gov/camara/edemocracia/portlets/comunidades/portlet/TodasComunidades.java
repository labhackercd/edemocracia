package br.gov.camara.edemocracia.portlets.comunidades.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.gov.camara.edemocracia.portlets.comunidades.ElementoComunidade;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class TodasComunidades extends MVCPortlet {

    private static Log _log = LogFactoryUtil.getLog(TodasComunidades.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

	ThemeDisplay td = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

	List<Group> comunidadesAtivas = getComunidadesAtivas(renderRequest, td);
	List<ElementoComunidade> page = getPage(comunidadesAtivas, td);

	renderRequest.setAttribute("comunidadesAtivas", page);
	renderRequest.setAttribute("pageSize", comunidadesAtivas.size());
	renderRequest.setAttribute("currentPage", 1);
	renderRequest.setAttribute("pageTotal", 1);

	List<Group> comunidadesEncerradas = getComunidadesEncerradas(renderRequest, td);
	List<ElementoComunidade> pageEncerradas = getPage(comunidadesEncerradas, td);

	renderRequest.setAttribute("comunidadesEncerradas", pageEncerradas);
	renderRequest.setAttribute("pageSize", comunidadesEncerradas.size());
	renderRequest.setAttribute("currentPage", 1);
	renderRequest.setAttribute("pageTotal", 1);

	super.doView(renderRequest, renderResponse);

    }

    private ElementoComunidade makeElementoComunidade(Group grp, ThemeDisplay td) throws SystemException, PortalException {
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

    private List<ElementoComunidade> getPage(List<Group> page, ThemeDisplay td) {

	ArrayList<ElementoComunidade> ret = new ArrayList<ElementoComunidade>();
	for (Group group : page) {
	    try {

		ret.add(makeElementoComunidade(group, td));
	    } catch (PortalException e) {
		// TODO LOG
		e.printStackTrace();
	    } catch (SystemException e) {
		// TODO LOG
		e.printStackTrace();
	    }
	}
	return ret;
    }

    private List<Group> getComunidadesAtivas(PortletRequest renderRequest, ThemeDisplay td) {

	List<Group> comunidades = Collections.<Group> emptyList();

	try {

	    DynamicQuery query = DynamicQueryFactoryUtil.forClass(Group.class, PortalClassLoaderUtil.getClassLoader());
	    query.add(RestrictionsFactoryUtil.eq("companyId", td.getCompanyId()));
	    query.add(RestrictionsFactoryUtil.eq("active", true));
	    query.add(RestrictionsFactoryUtil.in("type", new Object[] { GroupConstants.TYPE_SITE_OPEN, GroupConstants.TYPE_SITE_RESTRICTED }));
	    query.add(RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.in("name", new Object[] { GroupConstants.GUEST, GroupConstants.CONTROL_PANEL, "" })));
	    // query.add(RestrictionsFactoryUtil.ne("groupId",
	    // td.getScopeGroupId()));
	    query.add(RestrictionsFactoryUtil.eq("classNameId", PortalUtil.getClassNameId(Group.class)));
	    query.addOrder(OrderFactoryUtil.desc("name"));

	    @SuppressWarnings("unchecked")
	    List<Group> groups = GroupLocalServiceUtil.dynamicQuery(query);

	    comunidades = new ArrayList<Group>(groups.size());

	    for (Group grp : groups) {

		if (grp.getPublicLayoutsPageCount() != 0) {
		    Boolean finished = (Boolean) grp.getExpandoBridge().getAttribute("Encerrada");
		    if (finished == null || !finished)
			comunidades.add(grp);
		}

	    }

	} catch (SystemException e) {
	    _log.error(e);
	}

	return comunidades;
    }

    private List<Group> getComunidadesEncerradas(PortletRequest renderRequest, ThemeDisplay td) {

	List<Group> comunidades = Collections.<Group> emptyList();

	try {

	    DynamicQuery query = DynamicQueryFactoryUtil.forClass(Group.class, PortalClassLoaderUtil.getClassLoader());
	    query.add(RestrictionsFactoryUtil.eq("companyId", td.getCompanyId()));
	    query.add(RestrictionsFactoryUtil.eq("active", true));
	    query.add(RestrictionsFactoryUtil.in("type", new Object[] { GroupConstants.TYPE_SITE_OPEN, GroupConstants.TYPE_SITE_RESTRICTED }));
	    query.add(RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.in("name", new Object[] { GroupConstants.GUEST, GroupConstants.CONTROL_PANEL, "" })));
	    // query.add(RestrictionsFactoryUtil.ne("groupId",
	    // td.getScopeGroupId()));
	    query.add(RestrictionsFactoryUtil.eq("classNameId", PortalUtil.getClassNameId(Group.class)));
	    query.addOrder(OrderFactoryUtil.desc("name"));

	    @SuppressWarnings("unchecked")
	    List<Group> groups = GroupLocalServiceUtil.dynamicQuery(query);

	    comunidades = new ArrayList<Group>(groups.size());

	    for (Group grp : groups) {
		if (grp.getPublicLayoutsPageCount() != 0) {
		    Boolean finished = (Boolean) grp.getExpandoBridge().getAttribute("Encerrada");
		    if (finished != null && finished)
			comunidades.add(grp);
		}
	    }

	} catch (SystemException e) {
	    _log.error(e);
	}

	return comunidades;
    }

}
