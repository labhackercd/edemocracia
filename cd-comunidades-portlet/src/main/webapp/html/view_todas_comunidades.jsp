<%
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
%>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>

<%@page import="br.gov.camara.edemocracia.portlets.comunidades.ElementoComunidade"%>

<jsp:useBean id="comunidadesAtivas" type="java.util.List<br.gov.camara.edemocracia.portlets.comunidades.ElementoComunidade>" scope="request" />
<jsp:useBean id="comunidadesEncerradas" type="java.util.List<br.gov.camara.edemocracia.portlets.comunidades.ElementoComunidade>" scope="request" />

<portlet:defineObjects />
<theme:defineObjects/>



<ul class="listaComunidades">
	<h2>Ativas</h2>
	<% for(ElementoComunidade comunidade : comunidadesAtivas) { %>
		<li class="">
			<a href="<%= comunidade.getUrl() %>">
				<img alt="<%= comunidade.getNome() %>" src="<%= comunidade.getUrlImagem() %>">
			<span class="nome"><%= comunidade.getNome() %></span>
			</a>
		</li>
	<% } %>

</ul>
<ul class="listaComunidades">
	<h2>Encerradas</h2>
	<% for(ElementoComunidade comunidade : comunidadesEncerradas) { %>
		<li class="">
			<a href="<%= comunidade.getUrl() %>">
				<img alt="<%= comunidade.getNome() %>" src="<%= comunidade.getUrlImagem() %>">
			<span class="nome"><%= comunidade.getNome() %></span>
			</a>
		</li>
	<% } %>

</ul>