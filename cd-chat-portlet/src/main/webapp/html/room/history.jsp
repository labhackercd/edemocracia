<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Calendar"  %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="org.apache.commons.lang.StringEscapeUtils" %>


<%@page import="br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy"%>
<%@page import="br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>

<%@page import="com.liferay.portal.model.User"%>

<%@page import="br.gov.camara.edemocracia.portlets.chat.model.impl.UserType"%>
<%@page import="java.util.TimeZone"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>

<jsp:useBean id="messages" type="br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[]" scope="request" />
<jsp:useBean id="room" type="br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomImpl" scope="request" />

<c:set var="twitter" value='<%=request.getAttribute(ChatPortletConstants.TWITTER_ATTRIBUTE) %>' />
<c:set var="videoRecorded" value='<%=request.getAttribute(ChatPortletConstants.VIDEO_RECORDED_ATTRIBUTE) %>' scope="request" />

<portlet:actionURL name="listChatRooms" var="listViewURL"/>

<portlet:resourceURL id="cdchatexport" var="exportURL" />
<portlet:defineObjects/>

<c:set var="ns"><portlet:namespace /></c:set>

<% 	
   	NumberFormat nf = NumberFormat.getInstance();
   	nf.setMinimumIntegerDigits(2);
   	TimeZone tz = TimeZone.getDefault();
	ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	User user = td.getUser();
   	if(user != null) {
   		tz = user.getTimeZone();
   	}
%>

<liferay-ui:success key="room-export-success" message="room-export-success" />
<liferay-ui:error key="load-messages-for-export-exception" message="load-messages-for-export-exception" />
<script type="text/javascript" src="<%= renderRequest.getContextPath() %>/js/jquery-ui-1.8.9.custom.min.js"></script>
<script type="text/javascript" src="<%= renderRequest.getContextPath() %>/js/cdjsutils.js"></script>
<script type="text/javascript" src="<%= renderRequest.getContextPath() %>/js/export.js"></script>
<h1>Mensagens da sala <c:out value="<%= room.getRoomName() %>" /></h1>
  <div> <%= room.getDescription() %></div>
<br />
<p>
	<c:choose>
		<c:when test="${not empty previousPageLink}">
			&nbsp;<a href="${previousPageLink}" class="lnk-botao">Voltar</a>
		</c:when>
		<c:otherwise>
			&nbsp;<a href="${listViewURL}" class="lnk-botao">Voltar</a>
		</c:otherwise>
	</c:choose>
</p>

<c:if test="${(not empty videoRecorded and videoRecorded.videoEnabled) or (not empty twitter and twitter.twitterEnabled and not empty twitter.twitterDataWidgetId)}">
	<div class="cdchat_twitter-video">

		<c:if test="${videoRecorded.videoEnabled}">
			<%@ include file="videoRecorded.jspf"  %>		
		</c:if>
		
		<c:if test="${twitter.twitterEnabled and not empty twitter.twitterDataWidgetId}">
			<%@ include file="twitter.jspf"  %>
		</c:if>

	</div>
</c:if>

<div class="cdchat_msg-container">

	<ul class="cdchat_expmsglist" id="${ns}exportmsglist">
	<% for(ChatRoomMessage msg : messages) { 
		  String cssClass = ""; 
		  if(msg.getSenderType() == UserType.Moderator.getValue()) {
			   cssClass="cdchat_moderator"; 
		  } else if(msg.getSenderType() == UserType.SpecialGuest.getValue()) {  
		       cssClass="cdchat_special_guest";
		  } 
	%>
		<% if(!msg.isExportedRemoved()) { %>
			<li id="${ns}msg_<%= msg.getChatMessageId() %>" class="<%= cssClass %>" >
			<%= msg.getFormattedText(tz) %>
			</li>
		<% } %>
	<% } %>
	</ul>
	
	<p>${usersCount} participante(s)</p>
	
	<form name="${ns}exportRoom" action="${exportURL}" method="post">
	<input type="hidden" name="${ns}roomId" value="<%= Long.toString(room.getRoomId()) %>" />
	<label for="${ns}format">Formato:</label>
	<input type="radio" id="${ns}format" name="${ns}format" value="html" checked="checked">HTML</input>
	<input type="radio" name="${ns}format" value="xml">XML</input>
	<input type="submit" value="Salvar" />
	</form>

</div>