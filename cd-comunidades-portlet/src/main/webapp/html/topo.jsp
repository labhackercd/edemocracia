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


<jsp:useBean id="titulo" type="java.lang.String" scope="request" />
<jsp:useBean id="imagem" type="java.lang.String" scope="request" />
<jsp:useBean id="descricao" type="java.lang.String" scope="request" />
<jsp:useBean id="podeAssinar" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="urlInscricao" type="java.lang.String" scope="request" />
<jsp:useBean id="urlInicial" type="java.lang.String" scope="request" />

<portlet:defineObjects />
<theme:defineObjects/>

<div id="topoComunidades">
	<div class="descricao">
		<a href="<%= urlInicial %>" title="Ir para a página inicial da comunidade">
			<img src="<%= imagem %>" alt="<c:out value="<%= titulo %>"/>">
		</a>
		<h1>
			<a href="<%= urlInicial %>" title="Ir para a página inicial da comunidade"><c:out value="<%= titulo %>"/></a>
		</h1>
		<p>
			<c:out value="<%= descricao %>" />
		</p>
			
	</div>

</div>
