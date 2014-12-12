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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class OutrasComunidades
 */
public class OutrasComunidades extends ListaComunidadesPortlet {

	private static Log _log = LogFactoryUtil.getLog(OutrasComunidades.class);

	@Override
	protected List<Group> getComunidades(PortletRequest renderRequest, ThemeDisplay td) {
		List<Group> comunidades = Collections.<Group> emptyList();

		try {
			// Consulta feita na mão para evitar cache trashing
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(Group.class, PortalClassLoaderUtil.getClassLoader());
			query.add(RestrictionsFactoryUtil.eq("companyId", td.getCompanyId()));
			query.add(RestrictionsFactoryUtil.eq("active", true));
			query.add(RestrictionsFactoryUtil.in("type", new Object[] {GroupConstants.TYPE_SITE_OPEN, GroupConstants.TYPE_SITE_RESTRICTED} ));
			query.add(RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.in("name", new Object[] {GroupConstants.GUEST, GroupConstants.CONTROL_PANEL, ""})));
			query.add(RestrictionsFactoryUtil.ne("groupId", td.getScopeGroupId()));
			query.add(RestrictionsFactoryUtil.eq("classNameId", PortalUtil.getClassNameId(Group.class)));
			query.addOrder(OrderFactoryUtil.asc("name"));
			
			@SuppressWarnings("unchecked")
			List<Group> groups = GroupLocalServiceUtil.dynamicQuery(query) ;
			
			comunidades = new ArrayList<Group>(groups.size());
			for (Group grp : groups) {
				if (grp.getPublicLayoutsPageCount() != 0)
					comunidades.add(grp);
			}
		} catch (SystemException e) {
			_log.error(e);
		}
		return comunidades;
	}

	@Override
	protected String getTitulo() {
		return "Outras Comunidades";
	}

}
