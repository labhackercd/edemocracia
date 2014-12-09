<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>

<%@page
	import="br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy"%>
<%@page
	import="br.gov.camara.edemocracia.portlets.chat.model.impl.RoomStatus"%>
<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@page import="java.util.Calendar"%>


<portlet:defineObjects />
<theme:defineObjects />

<jsp:useBean id="update_ts" scope="request" type="java.util.Date" />
<jsp:useBean id="room" scope="request"
	type="br.gov.camara.edemocracia.portlets.chat.model.ChatRoom" />
<jsp:useBean id="userActivityId" scope="request" type="br.gov.camara.edemocracia.portlets.chat.service.UserActivityId" /> 
<c:set var="twitter" value='<%=request.getAttribute("twitter") %>'  scope="request" />
<c:set var="videoLive" value='<%=request.getAttribute("videoLive") %>' scope="request" />

<c:set var="ns">
	<portlet:namespace />
</c:set>

<%
	Calendar cal = Calendar.getInstance();
	cal.setTime(update_ts);
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int day = cal.get(Calendar.DAY_OF_MONTH);
	int hour = cal.get(Calendar.HOUR_OF_DAY);
	int minute = cal.get(Calendar.MINUTE);
	int second = cal.get(Calendar.SECOND);
	int ms = cal.get(Calendar.MILLISECOND);
	String contextPath = renderRequest.getContextPath();
%>

<portlet:resourceURL var="updateURL" id="cdchatupdate" />
<portlet:resourceURL var="postMessageURL" id="cdchatpostmsg" />
<portlet:resourceURL var="approveMessageURL" id="cdchatapprovemsg" />
<portlet:resourceURL var="rejectMessageURL" id="cdchatrejectmsg" />
<portlet:resourceURL var="banUserURL" id="cdchatbanuser" />
<portlet:resourceURL var="unbanUserURL" id="cdchatunbanuser" />
<portlet:resourceURL var="openRoomURL" id="cdchatopenroom" />
<portlet:resourceURL var="closeRoomURL" id="cdchatcloseroom" />


<portlet:actionURL var="leaveURL" name="leaveChatRoom">
	<portlet:param name="roomId" value="${room.roomId}" />
	<portlet:param name="userActivityId" value="${userActivityId}" />
	<portlet:param name="<%=ChatPortletConstants.PREVIOUS_PAGE_LINK %>" value="${previousPageLink}" />
</portlet:actionURL>

<script type="text/javascript"
	src="<%=renderRequest.getContextPath()%>/js/jquery-ui-1.8.9.custom.min.js"></script>
<script type="text/javascript"
	src="<%=renderRequest.getContextPath()%>/js/cdjsutils.js"></script>
<script type="text/javascript"
	src="<%=contextPath%>/js/moderatorchatmodule.js"></script>
<script type="text/javascript">

	$(document).ready(function () {	
		
		var setup = {
				roomId: <%=room.getRoomId()%>,
				currentUserId:  "<%= userActivityId.getAsString() %>",
				userInAudience: <%=userActivityId.isSpyUser()%>,
				initialSince: new Date(Date.UTC(<%=year%>,<%=month%>,<%=day%>,<%=hour%>,<%=minute%>,<%=second%>,<%=ms%>)),
				updateURL: "<%=updateURL%>",
				postMessageURL: "<%=postMessageURL%>",
				banUserURL: "<%=banUserURL%>",
				unbanUserURL: "<%=unbanUserURL%>",
				approveMessageURL: "<%=approveMessageURL%>",
				rejectMessageURL: "<%=rejectMessageURL%>",
				openRoomURL: "<%=openRoomURL%>",
				closeRoomURL: "<%=closeRoomURL%>",
				portletNamespace: "${ns}",
				contextPath: "<%=contextPath%>"
		};
		
		var chatModule = CD.eDemocracia.chat.moderatorChatModule(setup);

		chatModule.updateTimer();

		$("#${ns}msgForm").submit(function() {
			return chatModule.postMessage(false);
		});
		$("#${ns}admmsgForm").submit(function() {
			return chatModule.postMessage(true);
		});
		$("#${ns}usrid_-1").click(chatModule.userClick);
		$("[name=${ns}banButton]").click(chatModule.banUser);
		$("[name=${ns}unbanButton]").click(chatModule.unbanUser);
		$("#${ns}textType").change(chatModule.textTypeChange);
		<% if(room.getGuestName().trim().length()>0) {%> 
		$("#${ns}sendAsChkbox").click(chatModule.sendAsChkboxClick);
		<% } %>
<%if ((room.getOpenPolicy() == RoomOpenPolicy.Manual.getValue()) || (room.getOpenPolicy() == RoomOpenPolicy.Scheduled.getValue()) ) {
				if (room.getStatus() == RoomStatus.Closed.getValue()) {%>
	$("#${ns}openRoomSpan a").click(chatModule.openRoom);
	$("#${ns}closeRoomSpan").addClass("desativado");
<%} else if (room.getStatus() == RoomStatus.Opened.getValue()) {%>
	$("#${ns}closeRoomSpan a").click(chatModule.closeRoom);
	$("#${ns}openRoomSpan").addClass("desativado");
	
<%}
			}%>
	});
</script>

<div class="cabecalho">
<%	if (room.getImageId() != 0) { %>
		<img src="<%=PortalUtil.getPathImage()%>/chat/?img_id=${room.imageId}" alt="<%=StringEscapeUtils.escapeHtml(room.getRoomName())%>">
<%	} %>
  <div class="descricao">
    <h1><%= StringEscapeUtils.escapeHtml(room.getRoomName()) %></h1>
    <div><%= room.getDescription() %></div>
  </div>
</div>

<p class="cdchat_room-controls">
<%
	if ((room.getOpenPolicy() == RoomOpenPolicy.Manual.getValue()) || (room.getOpenPolicy() == RoomOpenPolicy.Scheduled.getValue())) {
%>
	 
<% if (room.getOpenPolicy() == RoomOpenPolicy.Manual.getValue()) { %> 
	<span id="${ns}openRoomSpan" class="lnk-botao">
	
<%	 if (room.getStatus() == RoomStatus.Closed.getValue()) { %> 
	 	<a href="#" onclick="return false;"> 
<%   } %>
	 Abrir Sala 
<%	 if (room.getStatus() == RoomStatus.Closed.getValue()) { %>
	 	</a> 
<%   } %>

	</span> 
<% } %> 
	 
 	 &nbsp;<span id="${ns}closeRoomSpan" class="lnk-botao"> 
 <%
 	if (room.getStatus() == RoomStatus.Opened.getValue()) {
 %> <a href="#" onclick="return false;"> <%
 	}
 %> Fechar Sala <%
 	if (room.getStatus() == RoomStatus.Opened.getValue()) {
 %> </a> <%
 	}
 %> </span>
<%
	}
%>
	&nbsp;<a href="${leaveURL}" id="${ns}leave" class="lnk-botao">Sair da Sala</a>

</p>
<div class="cdchat_cleardiv"></div>
<div class="cdchat_navbar">
	<p class="instrucao">
		Para enviar mensagem a um participante específico, selecione-o na lista.
	</p>
	<ul id="${ns}usrslist" class="cdchat_moderatorusrlist">
		<li id="${ns}usrid_-1" class="cdchat_user cdchat_selected_user"
			title="Enviar mensagem para Todos"><img style="width: 25px;"
			src="<%=contextPath%>/html/images/group.png" alt="Todos" />&nbsp;Todos
		</li>
	</ul>
	<form id="${ns}banForm">
		<input type="submit" value="Banir" name="${ns}banButton"
			disabled="disabled" />&nbsp;<input type="submit" value="Desbanir"
			name="${ns}unbanButton" disabled="disabled" />
	</form>
	<p class="instrucao">
		Usuários banidos
	</p>
	<ul id="${ns}banusrlist" class="cdchat_moderatorbanuserlist"></ul>
</div>

<c:if test="${(not empty videoLive and videoLive.videoEnabled) or (not empty twitter and twitter.twitterEnabled and not empty twitter.twitterDataWidgetId) }">
	<div class="cdchat_twitter-video">
	
		<c:if test="${videoLive.videoEnabled}">
			<%@ include file="video.jspf"  %>
		</c:if>
		<c:if test="${twitter.twitterEnabled and not empty twitter.twitterDataWidgetId}">
			<%@ include file="twitter.jspf"  %>
		</c:if>
	
	</div>
</c:if>

<div class="cdchat_msg-container">
	<ul id="${ns}msglist" class="cdchat_msglist">
	</ul>
	<p class="cdchat_autoscroll_chkbox">
		<input type="checkbox" id="${ns}autoscroll" checked="checked" /><label
			for="${ns}autoscroll">Rolagem Autom&aacute;tica</label>
	</p>
	<form id="${ns}msgForm" class="cdchat_msgForm">
		<p>
			<select id="${ns}textType" name="${ns}textType">
				<option value="0" selected="selected">Falar</option>
				<option value="1">Perguntar</option>
				<option value="2">Responder</option>
				<option value="3">Concordar</option>
				<option value="4">Discordar</option>
			</select>
			<% if(room.getGuestName().trim().length()>0) { %>
			<input type="checkbox" id="${ns}sendAsChkbox" disabled="disabled" /> 
			<label for="${ns}sendAsSelect">como</label> <select id="${ns}sendAsSelect"
				disabled="disabled">
				<option value="<%=room.getGuestId()%>" selected="selected"><%=room.getGuestName()%></option>
			</select> 
			<% } %>
			<span id="${ns}text_type_preposition">para</span> <span
				class="cdchat_sendto_user">Todos</span>
		</p>
		<input type="text" id="${ns}msg" class="${ns}msgFormItem" 
			maxlength="3000" /><input type="submit" value="Enviar"
			class="${ns}msgFormItem" /><label class="cdchat_private"><input
			type="checkbox" class="${ns}msgFormItem" id="${ns}private"
			disabled="disabled" />Enviar mensagem reservada</label>
	</form>
</div>

<div class="cdchat_msg-container cdchat_adm-msg-container">
	<h3>Mensagens administrativas</h3>
	<ul id="${ns}admmsglist" class="cdchat_admmsglist">
	</ul>
	<p class="cdchat_autoscroll_chkbox">
		<input type="checkbox" id="${ns}autoscrolladm" checked="checked" /><label
			for="${ns}autoscrolladm">Rolagem Autom&aacute;tica</label>
	</p>
	<form id="${ns}admmsgForm" class="cdchat_msgForm">
		<p>
			<input type="text" id="${ns}admmsg" class="${ns}msgFormItem"
				maxlength="3000" />&nbsp;<input type="submit"
				value="Enviar" class="${ns}msgFormItem" />
		</p>
	</form>
</div>




