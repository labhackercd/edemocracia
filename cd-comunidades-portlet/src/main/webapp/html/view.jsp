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

<jsp:useBean id="comunidades" type="java.util.List<br.gov.camara.edemocracia.portlets.comunidades.ElementoComunidade>" scope="request" />
<jsp:useBean id="pageSize" type="java.lang.Integer" scope="request"/>
<jsp:useBean id="currentPage" type="java.lang.Integer" scope="request"/>
<jsp:useBean id="pageTotal" type="java.lang.Integer" scope="request"/>
<jsp:useBean id="titulo" type="java.lang.String" scope="request" />

<portlet:defineObjects />
<theme:defineObjects/>

<portlet:renderURL var="first">
	<portlet:param name="currentPage" value="1" />
</portlet:renderURL>

<portlet:renderURL var="last">
	<portlet:param name="currentPage" value="<%= pageTotal.toString() %>" />
</portlet:renderURL>

<portlet:renderURL var="previous">
	<portlet:param name="currentPage" value="<%= Integer.toString(currentPage != 1 ? currentPage - 1 : currentPage) %>"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="next">
	<portlet:param name="currentPage" value="<%= Integer.toString(currentPage != pageTotal ? currentPage + 1 : currentPage) %>"></portlet:param>
</portlet:renderURL>


<h2><%= titulo %></h2>
<ul>
<% for(ElementoComunidade comunidade : comunidades) { %>
	  
	  <li><a href="<%= comunidade.getUrl() %>"><img src="<%= comunidade.getUrlImagem() %>" /><%= comunidade.getNome() %></a></li> 
<% } %>
</ul>
<ul class="navegacao">
<li><% if(currentPage != 1) { %><a href="<%= first %>"<% } else { %><span<% } %> class="first">Primeira<% if(currentPage != 1) { %></a><% } else { %></span><% } %></li>	
<li><% if(currentPage != 1) { %><a href="<%= previous %>"<% } else { %><span<% } %> class="previous">Anterior<% if(currentPage != 1) { %></a><% } else { %></span><% } %></li>
<li><% if(currentPage != pageTotal) { %><a href="<%= next %>"<% } else { %><span<% } %> class="next">Pr&oacute;xima<% if(currentPage != pageTotal) { %></a><% } else { %></span><% } %></li>
<li><% if(currentPage != pageTotal) { %><a href="<%= last %>"<% } else { %><span<% } %> class="last">&Uacute;ltima<% if(currentPage != pageTotal) { %></a><% } else { %></span><% } %></li>
</ul>