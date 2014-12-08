<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.service.CompanyLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.liferay.portal.model.GroupConstants" %>
<%@page import="com.liferay.portal.model.User" %>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@page import="com.liferay.portal.model.Group" %>
<%@page import="java.util.List" %>


<jsp:useBean id="links" type="java.util.Map" scope="request" />

<portlet:defineObjects />
<theme:defineObjects/>
<div id="rodape">
	<ul>
<%
	Iterator<Map.Entry<String, String>> iter = (Iterator<Map.Entry<String, String>>)links.entrySet().iterator();
	while (iter.hasNext()) {
		Map.Entry<String, String> entry = iter.next();
		String url = HtmlUtil.escapeHREF(entry.getValue());
		String nome = HtmlUtil.escape(entry.getKey());
		boolean ultimo = !iter.hasNext();
		String cssClass = ultimo?"ultimo":"";
%>
		<li class="<c:out value="<%=cssClass%>"/>"><a href="<c:out value="<%= url %>"/>"><c:out value="<%= nome %>"/></a></li>
<%
	}
%>
	</ul>
</div>