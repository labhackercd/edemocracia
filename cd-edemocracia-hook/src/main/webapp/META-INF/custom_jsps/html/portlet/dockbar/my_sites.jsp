<%@ page import="com.liferay.portal.service.permission.*" %>
<%@ page import="com.liferay.portal.service.*" %>
<%@ page import="com.liferay.portal.security.permission.*" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.portal.util.*" %>
<%@ page import="com.liferay.portal.model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.liferay.portlet.*" %>

<%
int max = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:my_sites:max"));

if (max <= 0) {
	max = PropsValues.MY_SITES_MAX_ELEMENTS;
}

List<Group> mySites = user.getMySites(true, max);
%>

<c:if test="<%= !mySites.isEmpty() %>">
	<p class="my-places-title">Minhas Comunidades</p>
	<ul class="taglib-my-sites">

		<%
		PortletURL portletURL = new PortletURLImpl(request, PortletKeys.SITE_REDIRECTOR, plid, PortletRequest.ACTION_PHASE);

		portletURL.setWindowState(WindowState.NORMAL);
		portletURL.setPortletMode(PortletMode.VIEW);

		portletURL.setParameter("struts_action", "/my_sites/view");

		for (Group mySite : mySites) {
			// Meu perfil - não deverá ser exibido aqui
			if (mySite.isUser() || mySite.isControlPanel())
				continue;

			String escapedSiteName = HtmlUtil.escape(mySite.getName());

			boolean organizationCommunity = mySite.isOrganization();
			boolean regularCommunity = mySite.isCommunity();
			int publicLayoutsPageCount = mySite.getPublicLayoutsPageCount();
			int privateLayoutsPageCount = mySite.getPrivateLayoutsPageCount();

			Organization organization = null;

			String publicAddPageHREF = null;
			String privateAddPageHREF = null;

			if (organizationCommunity) {
				organization = OrganizationLocalServiceUtil.getOrganization(mySite.getOrganizationId());

				if (OrganizationPermissionUtil.contains(permissionChecker, organization.getOrganizationId(), ActionKeys.MANAGE_LAYOUTS)) {
					PortletURL addPageURL = new PortletURLImpl(request, PortletKeys.MY_SITES, plid, PortletRequest.ACTION_PHASE);

					addPageURL.setWindowState(WindowState.NORMAL);
					addPageURL.setPortletMode(PortletMode.VIEW);

					addPageURL.setParameter("struts_action", "/my_sites/edit_pages");
					addPageURL.setParameter("redirect", currentURL);
					addPageURL.setParameter("groupId", String.valueOf(mySite.getGroupId()));
					addPageURL.setParameter("privateLayout", Boolean.FALSE.toString());

					publicAddPageHREF = addPageURL.toString();

					addPageURL.setParameter("privateLayout", Boolean.TRUE.toString());

					privateAddPageHREF = addPageURL.toString();
				}
			}
			else if (regularCommunity) {
				if (GroupPermissionUtil.contains(permissionChecker, mySite.getGroupId(), ActionKeys.MANAGE_LAYOUTS)) {
					PortletURL addPageURL = new PortletURLImpl(request, PortletKeys.MY_SITES, plid, PortletRequest.ACTION_PHASE);

					addPageURL.setWindowState(WindowState.NORMAL);
					addPageURL.setPortletMode(PortletMode.VIEW);

					addPageURL.setParameter("struts_action", "/my_sites/edit_pages");
					addPageURL.setParameter("redirect", currentURL);
					addPageURL.setParameter("groupId", String.valueOf(mySite.getGroupId()));
					addPageURL.setParameter("privateLayout", Boolean.FALSE.toString());

					publicAddPageHREF = addPageURL.toString();

					addPageURL.setParameter("privateLayout", Boolean.TRUE.toString());

					privateAddPageHREF = addPageURL.toString();
				}
			}

			boolean showPublicPlace = true;

			boolean hasPowerUserRole = RoleLocalServiceUtil.hasUserRole(user.getUserId(), user.getCompanyId(), RoleConstants.POWER_USER, true);

			if (publicLayoutsPageCount == 0) {
				showPublicPlace = PropsValues.MY_SITES_SHOW_PUBLIC_SITES_WITH_NO_LAYOUTS;
			}

			boolean showPrivatePlace = true;

			if (privateLayoutsPageCount == 0) {
				showPrivatePlace = PropsValues.MY_SITES_SHOW_PRIVATE_SITES_WITH_NO_LAYOUTS;
			}
		%>

			<c:if test="<%= showPublicPlace || showPrivatePlace %>">
				<c:choose>
					<c:when test='<%= PropsValues.MY_SITES_DISPLAY_STYLE.equals("simple") %>'>

						<%
						portletURL.setParameter("groupId", String.valueOf(mySite.getGroupId()));
						portletURL.setParameter("privateLayout", Boolean.FALSE.toString());

						boolean firstCommunity = false;

						if (mySites.indexOf(mySite) == 0) {
							firstCommunity = true;
						}

						boolean lastCommunity = false;

						if (mySites.size()	== (mySites.indexOf(mySite) + 1)) {
							lastCommunity = true;
						}

						boolean selectedCommunity = false;

						if (layout != null) {
							if (layout.getGroupId() == mySite.getGroupId()) {
								selectedCommunity = true;
							}
						}

						boolean selectedPlace = false;

						if (layout != null) {
							if (!layout.isPrivateLayout() && (layout.getGroupId() == mySite.getGroupId())) {
								selectedPlace = true;
							}
						}

						String cssClass = "public-community";

						if (firstCommunity) {
							cssClass += " first";
						}

						if (lastCommunity) {
							cssClass += " last";
						}

						if (selectedCommunity) {
							cssClass += " current-community";
						}

						if (selectedPlace) {
							cssClass += " current-site";
						}
						%>

						<c:if test="<%= showPublicPlace && publicLayoutsPageCount > 0 %>">
							<li class="<%= cssClass %>">
								<a href="<%= HtmlUtil.escape(portletURL.toString()) %>" onclick="Liferay.Util.forcePost(this); return false;">
									<span class="site-name">
										<c:choose>
											<c:when test="<%= organizationCommunity %>">
												<%= HtmlUtil.escape(organization.getName()) %>
											</c:when>
											<c:when test="<%= mySite.getName().equals(GroupConstants.GUEST) %>">
												<%= HtmlUtil.escape(themeDisplay.getAccount().getName()) %>
											</c:when>
											<c:otherwise>
												<%= mySite.getName() %>
											</c:otherwise>
										</c:choose>
									</span>

									<c:if test="<%= privateLayoutsPageCount > 0 %>">
										<span class="site-type"><liferay-ui:message key="public" /></span>
									</c:if>
								</a>
							</li>
						</c:if>

						<%
						portletURL.setParameter("privateLayout", Boolean.TRUE.toString());

						selectedPlace = false;

						if (layout != null) {
							selectedPlace = layout.isPrivateLayout() && (layout.getGroupId() == mySite.getGroupId());
						}

						cssClass = "private-community";

						if (selectedCommunity) {
							cssClass += " current-community";
						}

						if (selectedPlace) {
							cssClass += " current-site";
						}
						%>

						<c:if test="<%= showPrivatePlace && privateLayoutsPageCount > 0 %>">
							<li class="<%= cssClass %>">
								<a href="<%= HtmlUtil.escape(portletURL.toString()) %>" onclick="Liferay.Util.forcePost(this); return false;">
									<span class="site-name">
										<c:choose>
											<c:when test="<%= organizationCommunity %>">
												<%= HtmlUtil.escape(organization.getName()) %>
											</c:when>
											<c:when test="<%= mySite.getName().equals(GroupConstants.GUEST) %>">
												<%= HtmlUtil.escape(themeDisplay.getAccount().getName()) %>
											</c:when>
											<c:otherwise>
												<%= mySite.getName() %>
											</c:otherwise>
										</c:choose>
									</span>

									<c:if test="<%= publicLayoutsPageCount > 0 %>">
										<span class="site-type"><liferay-ui:message key="private" /></span>
									</c:if>
								</a>
							</li>
						</c:if>
					</c:when>
					<c:when test='<%= PropsValues.MY_SITES_DISPLAY_STYLE.equals("classic") %>'>

						<%
						boolean selectedCommunity = false;

						if (layout != null) {
							if (layout.getGroupId() == mySite.getGroupId()) {
								selectedCommunity = true;
							}
						}
						%>

						<li class="<%= selectedCommunity ? "current-community" : "" %>">
							<h3>
								<a href="javascript:;">
									<c:choose>
										<c:when test="<%= organizationCommunity %>">
											<%= HtmlUtil.escape(organization.getName()) %>
										</c:when>
										<c:otherwise>
											<%= mySite.getName() %>
										</c:otherwise>
									</c:choose>
								</a>
							</h3>

							<ul>

								<%
								portletURL.setParameter("groupId", String.valueOf(mySite.getGroupId()));
								portletURL.setParameter("privateLayout", Boolean.FALSE.toString());

								boolean selectedPlace = false;

								if (layout != null) {
									selectedPlace = !layout.isPrivateLayout() && (layout.getGroupId() == mySite.getGroupId());
								}
								%>

								<c:if test="<%= showPublicPlace %>">
									<li class="public <%= selectedPlace ? "current" : "" %>">
										<a href="<%= publicLayoutsPageCount > 0 ? HtmlUtil.escape(portletURL.toString()) : "javascript:;" %>"

										<c:if test="<%= publicLayoutsPageCount > 0 %>">
											onclick="Liferay.Util.forcePost(this); return false;"
										</c:if>

										><liferay-ui:message key="public-pages" /> <span class="page-count">(<%= publicLayoutsPageCount %>)</span></a>

										<c:if test="<%= publicAddPageHREF != null %>">
											<a class="add-page" href="<%= HtmlUtil.escape(publicAddPageHREF) %>" onclick="Liferay.Util.forcePost(this); return false;"><liferay-ui:message key="manage-pages" /></a>
										</c:if>
									</li>
								</c:if>

								<%
								portletURL.setParameter("groupId", String.valueOf(mySite.getGroupId()));
								portletURL.setParameter("privateLayout", Boolean.TRUE.toString());

								selectedPlace = false;

								if (layout != null) {
									selectedPlace = layout.isPrivateLayout() && (layout.getGroupId() == mySite.getGroupId());
								}
								%>

								<c:if test="<%= showPrivatePlace %>">
									<li class="private <%= selectedPlace ? "current" : "" %>">
										<a href="<%= privateLayoutsPageCount > 0 ? HtmlUtil.escape(portletURL.toString()) : "javascript:;" %>"

										<c:if test="<%= privateLayoutsPageCount > 0 %>">
											onclick="Liferay.Util.forcePost(this); return false;"
										</c:if>

										><liferay-ui:message key="private-pages" /> <span class="page-count">(<%= privateLayoutsPageCount %>)</span></a>

										<c:if test="<%= privateAddPageHREF != null %>">
											<a class="add-page" href="<%= HtmlUtil.escape(privateAddPageHREF) %>" onclick="Liferay.Util.forcePost(this); return false;"><liferay-ui:message key="manage-pages" /></a>
										</c:if>
									</li>
								</c:if>
							</ul>
						</li>
					</c:when>
				</c:choose>
			</c:if>
		<%
		}
		%>
	</ul>
</c:if>
<%
Group guest = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST);
try {
	Layout layoutComunidades = LayoutLocalServiceUtil.getFriendlyURLLayout(guest.getGroupId(), false, "/comunidades");
	String urlComunidades = PortalUtil.getLayoutURL(layoutComunidades, themeDisplay);
%>
	<p class="all-communities">
		<a href="<%= urlComunidades %>" title="Veja todas as comunidades e controle sua participação nelas">Ver todas as comunidades</a>
	</p>
<%
} catch (com.liferay.portal.NoSuchLayoutException e) {
}
%>