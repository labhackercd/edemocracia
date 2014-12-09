<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>

<%@page import="org.apache.commons.lang.StringEscapeUtils" %>
<%@page import="java.util.Calendar" %>


<portlet:defineObjects />
<theme:defineObjects />

<jsp:useBean id="update_ts" scope="request" type="java.util.Date" />
<jsp:useBean id="room" scope="request" type="br.gov.camara.edemocracia.portlets.chat.model.ChatRoom" />
<jsp:useBean id="userActivityId" scope="request" type="br.gov.camara.edemocracia.portlets.chat.service.UserActivityId" /> 
<c:set var="twitter" value='<%=request.getAttribute("twitter") %>' scope="request" />
<c:set var="videoLive" value='<%=request.getAttribute("videoLive") %>' scope="request" />

<c:set var="standAlone" value='<%=Boolean.valueOf(portletConfig.getInitParameter(ChatPortletConstants.STAND_ALONE))%>'/>
<c:set var="ns"><portlet:namespace /></c:set>

<% Calendar cal = Calendar.getInstance();
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

<portlet:resourceURL var="updateURL" id="cdchatupdate"/>
<portlet:resourceURL var="postMessageURL" id="cdchatpostmsg"/>


<portlet:actionURL var="leaveURL" name="leaveChatRoom">
	<portlet:param name="roomId" value="${room.roomId}" />
	<portlet:param name="userActivityId" value="${userActivityId}" />
	<portlet:param name="<%=ChatPortletConstants.PREVIOUS_PAGE_LINK %>" value="${previousPageLink}" />
</portlet:actionURL>

<script type="text/javascript" src="<%= renderRequest.getContextPath() %>/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%= renderRequest.getContextPath() %>/js/jquery-ui-1.8.9.custom.min.js"></script>
<script type="text/javascript" src="<%= renderRequest.getContextPath() %>/js/cdjsutils.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/chatmodule.js"></script>

<script type="text/javascript">
	$(document).ready(function () {
		
		var inAudience = <%= userActivityId.isSpyUser() %>;

		var setup = {
				roomId: <%= room.getRoomId() %>,
				currentUserId: "<%= userActivityId.getAsString() %>",
				usrAudience: inAudience,
				initialSince: new Date(Date.UTC(<%=year%>,<%=month%>,<%=day%>,<%=hour%>,<%=minute%>,<%=second%>,<%=ms%>)),
				updateURL: "<%=updateURL %>",
				postMsgURL: "<%=postMessageURL%>",
				ns: "${ns}",
				contextPath: "<%= renderRequest.getContextPath() %>"      
			};
				
		var chatModule = CD.eDemocracia.chat.chatModule(setup);

		chatModule.updateTimer();
		
		<% if(!userActivityId.isSpyUser()) { %>
		$("#${ns}msgForm").submit(chatModule.postMessage);
		$("#${ns}usrid_-1").click(chatModule.userClick);
		$("#${ns}textType").change(chatModule.textTypeChange);
		<% } %>
		
	}); 
</script>

<div class="cabecalho">
<%	if (room.getImageId() != 0) { %>
		<img src="<%=PortalUtil.getPathImage()%>/chat/?img_id=${room.imageId}" alt="<%=StringEscapeUtils.escapeHtml(room.getRoomName())%>">
<%	} %>
  <div class="descricao">
    <h1><%= StringEscapeUtils.escapeHtml(room.getRoomName()) %></h1>
    <div> <%= room.getDescription() %></div>
  </div>
</div>
<br />

<p class="cdchat_room-controls">
	<a href="${leaveURL}" id="${ns}leave" class="lnk-botao">Sair da Sala</a>
</p>
<div class="cdchat_cleardiv"></div>
<div class="cdchat_navbar">
	<% if(!userActivityId.isSpyUser()) { %>
	<p class="instrucao">
		Para enviar mensagem a um participante específico, selecione-o na lista.
	</p>
	<% } %>
	<ul id="${ns}usrslist" class="cdchat_usrlist">
		<li id="${ns}usrid_-1" class="cdchat_user cdchat_selected_user" title="Enviar mensagem para Todos">
			<img style="width: 25px;" src="<%=contextPath%>/html/images/group.png" />&nbsp;Todos
		</li>
	</ul>
</div>

<c:if test="${not standAlone and ((not empty videoLive and videoLive.videoEnabled) or (not empty twitter and twitter.twitterEnabled and not empty twitter.twitterDataWidgetId))}">
	<div class="cdchat_twitter-video">
	
		<c:if test="${videoLive.videoEnabled}">
			<%@ include file="video.jspf"  %>
		</c:if>
		<c:if test="${twitter.twitterEnabled and not empty twitter.twitterDataWidgetId}">
			<%@ include file="twitter.jspf"  %>
		</c:if>
	
	</div>
</c:if>

<div class="cdchat_msg-container <%= userActivityId.isSpyUser() ? "salaEspiar" : "" %> ">
<ul id="${ns}msglist" class="<%= userActivityId.isSpyUser() ? "cdchat_audience_msglist" : "cdchat_msglist" %>">
</ul>
<p class="cdchat_autoscroll_chkbox">
 <span id="${ns}roomClosed" style="text-align: left; float: left; display: none;">Esta sala está fechada. Apenas moderadores podem enviar mensagens.</span>
 <input type="checkbox" id="${ns}autoscroll" checked="checked" /><label for="${ns}autoscroll">Rolagem Autom&aacute;tica</label>
</p>
<% if(!userActivityId.isSpyUser()) { %>
<form id="${ns}msgForm" class="cdchat_msgForm">
<p><select id="${ns}textType" name="${ns}textType" >
		<option value="0" selected="selected">Falar</option>
		<option value="1">Perguntar</option>
		<option value="2">Responder</option>
		<option value="3">Concordar</option>
		<option value="4">Discordar</option>
</select> <span id="${ns}text_type_preposition">para</span> <span class="cdchat_sendto_user">Todos</span></p>
<input type="text" id="${ns}msg" class="${ns}msgFormItem" maxlength="3000" /><input type="submit" class="${ns}msgFormItem" value="Enviar" /><label class="cdchat_private"><input type="checkbox" class="${ns}msgFormItem" id="${ns}private" disabled="disabled" />Enviar mensagem reservada</label>
</form>	
<% } %>
</div>