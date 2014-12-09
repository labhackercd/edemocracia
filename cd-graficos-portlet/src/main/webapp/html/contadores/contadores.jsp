<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.model.GroupConstants"%>
<%@page import="br.gov.camara.edemocracia.portlets.graficos.service.impl.GroupComparator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.TimeZoneUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="br.gov.camara.edemocracia.portlets.graficos.DadosConsolidados"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:defineObjects />
<theme:defineObjects />

Clique <a href="<portlet:resourceURL />">aqui</a> para download dos dados.


<%
	Map<Long, DadosConsolidados> dados = (Map<Long, DadosConsolidados>)request.getAttribute("dados");
	List<Group> grupos = (List<Group>) request.getAttribute("grupos");
	List<Group> gruposCopy = new  ArrayList(grupos);
	Collections.sort(gruposCopy,new GroupComparator());
	Map<String, String> meses = (Map<String, String>) request.getAttribute("meses");
%>
<c:forEach var="grupo" items="<%= gruposCopy %>">
	<c:choose>
		<c:when test="${grupo != null }">
			<h2>${grupo.descriptiveName}</h2>
			<c:set var="dc" value="${dados[grupo.groupId]}" scope="page" />
		</c:when>
		<c:otherwise>
			<h2>Resumo do portal (exceto comunidades privadas)</h2>
			<c:set var="dc" value="<%= dados.get(null) %>" scope="page" />
		</c:otherwise>
	</c:choose>
	<table>
		<tr class="results-row">
			<td>Total de membros</td>
			<td>${dc.numeroMembros}</td>
		</tr>
		<tr class="results-header">
			<td>Portlet</td>
			<td>Comentários</td>
			<td>Postagens</td>
			<td>Tópicos criados</td>
			<td>Visualizações</td>
			<td>Mensagens</td>
			<td>Sugestões</td>
		</tr>
		<tr class="results-row" >
			<td>Forum</td>
			<td> - </td>
			<td>${dc.forumTotalPostagens}</td>
			<td>${dc.forumTopicosCriados}</td>
			<td>${dc.forumVisualizacoes}</td>
			<td> - </td>
			<td> - </td>
		</tr>
		<tr class="results-row" >
			<td>Blogs</td>
			<td>${dc.blogsComentarios}</td>
			<td> - </td>
			<td> - </td>
			<td> - </td>
			<td> - </td>
			<td> - </td>
		</tr>
		<tr class="results-row" >
			<td>Wiki</td>
			<td>${dc.wikiComentarios}</td>
			<td> - </td>
			<td> - </td>
			<td> - </td>
			<td> - </td>
			<td> - </td>
		</tr>	
		<tr class="results-row" >
			<td >Bibliotecas virtuais</td>
			<td>${dc.bibliotecaComentarios}</td>
			<td> - </td>
			<td> - </td>
			<td> - </td>
			<td> - </td>
			<td> - </td>
		</tr>
		<tr class="results-row" > 
			<td >Salas de bate-papo</td> 
			<td> - </td>
			<td> - </td>
			<td> - </td>
			<td> - </td>
			<td>${dc.batepapoMensagens}</td>
			<td> - </td>
		</tr>
		<tr class="results-row" > 
			<td >Wikilegis</td> 
			<td>${dc.wikilegisComentarios}</td>
			<td> - </td>
			<td> - </td>
			<td> - </td>
			<td> - </td>
			<td>${dc.wikilegisSugestoes}</td>
		</tr>
	</table>
	<hr />
</c:forEach>