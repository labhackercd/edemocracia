<%@page import="br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletConstants"%>
<%@page import="br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletUtil"%>
<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@include file="verificarProxy.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page
	import="br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil"%>
<%@page
	import="br.gov.camara.edemocracia.portlets.chat.portlet.ChatPermissionChecker"%>
<%@page
	import="br.gov.camara.edemocracia.portlets.chat.model.impl.RoomStatus"%>
<%@page import="br.gov.camara.edemocracia.portlets.chat.ChatRoomBean"%>

<%@page import="javax.portlet.PortletPreferences"%>

<liferay-ui:error key="cant-join" message="cant-join" />
<liferay-ui:error key="cant-moderate" message="cant-moderate" />
<liferay-ui:error key="cant-spy" message="cant-spy" />
<liferay-ui:error key="user-banned" message="user-banned" />
<liferay-ui:error key="room-closed" message="room-closed" />
<liferay-ui:error key="user-must-join-audience"
	message="user-must-join-audience" />
<liferay-ui:error key="no-access" message="no-access" />

<liferay-theme:defineObjects />
<portlet:defineObjects />

<c:set value='<%=renderRequest.getPreferences().getValue("addthis_texto_descricao", "") %>' var="texto_descricao" scope="request" />
<c:set value='<%=renderRequest.getPreferences().getValue("addthis_utilizar_link_para_sala", "true") %>' var="usar_link_sala_no_evento" scope="request" />

<portlet:renderURL var="rerenderUrl">
	<portlet:param name="<%= ChatPortletConstants.VIEW_PARAM %>" value="list"/>
</portlet:renderURL>

<script>
//<![CDATA[
           function reload() {
        	   window.location = '<%=rerenderUrl%>';
           }
//]]>
</script>

<script type="text/javascript" src="http://js.addthisevent.com/atemay.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/addthisevent.js"></script>
<link href="<%=request.getContextPath() %>/css/addthis.css" rel="stylesheet" type="text/css"></link>

<div class="lista_bp_abertos">

	<h3 class="portlet-title modificado">Salas Abertas</h3>
	<a href="#" class="lnk-botao modificado" onclick="reload();return false;">Recarregar</a> 
	<div style="clear: both"></div>

	<liferay-ui:search-container curParam="salasAbertas"
		emptyResultsMessage="no-chat-room">

		<liferay-ui:search-container-results>
			<%
				List<ChatRoomBean> openRooms = (List<ChatRoomBean>) request
								.getAttribute(ChatPortletConstants.OPEN_ROOMS_LIST_ATTRIBUTE);
						results = ListUtil.subList(openRooms,
								searchContainer.getStart(),
								searchContainer.getEnd());
						total = openRooms.size();
						pageContext.setAttribute("results", results);
						pageContext.setAttribute("total", total);
			%>
		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="br.gov.camara.edemocracia.portlets.chat.ChatRoomBean"
			keyProperty="roomId" modelVar="room">

			<liferay-ui:search-container-column-text name="Nome" property="roomName" />
			<liferay-ui:search-container-column-text name="Situa&ccedil;&atilde;o" property="status" />
			<liferay-ui:search-container-column-text name="Nº participantes"
				value="<%=Long.toString(ChatRoomServiceUtil
							.getUsersCountInChatRoom(room.getRoomId()))%>" />

			<liferay-ui:search-container-column-text cssClass="center" name="Entrar">
				<c:if test="${room.canJoin}">
					<portlet:actionURL name="enterChatRoom" var="enterURL">
						<portlet:param name="roomId" value="<%=String.valueOf(room.getRoomId())%>" />
					</portlet:actionURL>
					<a href="<%=enterURL%>" title="Entrar">
						<img alt="Entrar" src="<%=request.getContextPath()%>/html/images/ico_bp_entrar.png">
					</a>
				</c:if>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text cssClass="center" name="Espiar">
				<c:if test="${room.canSpy}">
					<portlet:actionURL name="enterChatSpy" var="audienceURL">
						<portlet:param name="roomId"
							value="<%=String.valueOf(room.getRoomId())%>" />
					</portlet:actionURL>
					<a href="<%=audienceURL%>" title="Espiar">
						<img alt="Espiar" src="<%=request.getContextPath()%>/html/images/ico_bp_espiar.png">
					</a>
				</c:if>
			</liferay-ui:search-container-column-text>

		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator paginate="false" />

	</liferay-ui:search-container>
</div>

<c:if test="${not empty scheduledRooms}">
	<div class="lista_bp_agendados">

		<h3 class="portlet-title">Salas Agendadas</h3>

		<liferay-ui:search-container curParam="salasAgendadas" emptyResultsMessage="no-chat-room" >

			<liferay-ui:search-container-results>
				<%
					List<ChatRoomBean> scheduledRooms = (List<ChatRoomBean>) request
										.getAttribute(ChatPortletConstants.SCHEDULED_ROOMS_LIST_ATTRIBUTE);
								results = ListUtil.subList(scheduledRooms,
										searchContainer.getStart(),
										searchContainer.getEnd());
								total = scheduledRooms.size();
								pageContext.setAttribute("results", results);
								pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>

			<liferay-ui:search-container-row
				className="br.gov.camara.edemocracia.portlets.chat.ChatRoomBean"
				keyProperty="roomId" modelVar="room">

				<liferay-ui:search-container-column-text name="Nome" property="roomName" />
				<liferay-ui:search-container-column-text name="Situa&ccedil;&atilde;o" property="status" />
				<liferay-ui:search-container-column-text cssClass="center col-entrar" name="Detalhes">
						<portlet:actionURL name="enterChatRoom" var="enterURL">
							<portlet:param name="roomId" value="<%=String.valueOf(room.getRoomId())%>" />
						</portlet:actionURL>
						<a href="<%=enterURL%>" title="Detalhes">
							<img alt="Detalhes" src="<%=request.getContextPath()%>/html/images/ico_bp_detalhes.png" />
						</a>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="Agendar" cssClass="center" >
					<a href="http://edemocracia.camara.gov.br" class="addthisevent" title="Marcar este evento na agenda">
	    				<span class="_start"><fmt:formatDate type="both" dateStyle="short" timeStyle="medium" timeZone="<%=themeDisplay.getUser().getTimeZone()%>"  value="<%=room.getOpenFrom() %>" /></span>
	    				<span class="_end"><fmt:formatDate type="both" dateStyle="short" timeStyle="medium"  timeZone="<%=themeDisplay.getUser().getTimeZone()%>" value="<%=room.getOpenUntil() %>" /></span>
	    				<span class="_zonecode">24</span>
	    				<span class="_summary">Chat: <%=StringEscapeUtils.escapeHtml(room.getRoomName())%></span>
	    				<span class="_description"> 
	    					<c:choose>
		  						 <c:when test="${not empty texto_descricao}">
		     						${texto_descricao}
		   						</c:when>
		   						<c:otherwise>
									Bate-papo agendado no portal edemocracia. Para mais detalhes acesse:
		   						</c:otherwise>
							</c:choose>
							<c:if test="${usar_link_sala_no_evento eq 'true' or empty usar_link_sala_no_evento}">
								${enterURL}
							</c:if>
						</span>
	    				<span class="_location">Brasilia - DF, Brasil</span>
	    				<span class="_organizer">e-Democracia</span>
	    				<span class="_organizer_email">edemocracia@camara.gov.br</span>
		   				<span class="_facebook_event"></span>
	    				<span class="_all_day_event">false</span>
		   				<span class="_date_format">DD/MM/YYYY</span>
					</a>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false"/>

		</liferay-ui:search-container>

	</div>
</c:if>


<c:if test="${not empty exportedRooms}">
	<div class="lista_bp_fechados">

		<h3 class="portlet-title">Salas Fechadas</h3>

		<liferay-ui:search-container curParam="salasFechadas"
			emptyResultsMessage="no-chat-room" delta="5">

			<liferay-ui:search-container-results>
				<%
					List<ChatRoomBean> exportedRooms = (List<ChatRoomBean>) request
										.getAttribute(ChatPortletConstants.EXPORTED_ROOMS_LIST_ATTRIBUTE);
								results = ListUtil.subList(exportedRooms,
										searchContainer.getStart(),
										searchContainer.getEnd());
								total = exportedRooms.size();
								pageContext.setAttribute("results", results);
								pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>

			<liferay-ui:search-container-row
				className="br.gov.camara.edemocracia.portlets.chat.ChatRoomBean"
				keyProperty="roomId" modelVar="room">

				<liferay-ui:search-container-column-text name="Nome" property="roomName" />
				<liferay-ui:search-container-column-text name="Situa&ccedil;&atilde;o" property="status" />

				<liferay-ui:search-container-column-text name="Ver histórico" cssClass="center">
					<portlet:renderURL var="viewHistoryURL">
						<portlet:param name="<%=ChatPortletConstants.VIEW_PARAM %>" value="history" />
						<portlet:param name="roomId" value="<%=String.valueOf(room.getRoomId())%>" />
					</portlet:renderURL>
					<a href="<%=viewHistoryURL%>" title="Ver histórico"> 
						<img alt="Ver histórico" src="<%=request.getContextPath()%>/html/images/ico_bp_historico.png">
					</a>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />

		</liferay-ui:search-container>

	</div>
</c:if>
