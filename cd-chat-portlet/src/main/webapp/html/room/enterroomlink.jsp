<%@page import="br.gov.camara.edemocracia.portlets.chat.portlet.ChatPermissionChecker"%>
<%@page import="br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="br.gov.camara.edemocracia.portlets.chat.model.ChatRoom" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@page import="br.gov.camara.edemocracia.portlets.chat.model.impl.RoomStatus"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<% ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
   ChatRoom room = (ChatRoom) row.getObject();
   String primkey = String.valueOf(room.getPrimaryKey());
   long roomId = room.getRoomId();
   ChatPermissionChecker checker = new ChatPermissionChecker(room);
%>

<liferay-ui:icon-menu>
	<portlet:actionURL name="enterChatRoom" var="enterURL">
		<portlet:param name="roomId" value="<%= primkey %>" />
	</portlet:actionURL>
	<portlet:actionURL name="enterChatSpy" var="audienceURL">
		<portlet:param name="roomId" value="<%= primkey %>" />
	</portlet:actionURL>
	<portlet:actionURL name="viewHistory" var="viewHistoryURL">
		<portlet:param name="roomId" value="<%= primkey %>" />
	</portlet:actionURL>
	<%
		if(checker.isOpen() || checker.isCanModerate() && room.getStatus() != RoomStatus.Exported.getValue() ) { 
			if(checker.isCanJoin()) { %>
				<liferay-ui:icon image="join" url="<%= enterURL.toString() %>" message="room-enter"/>
	<% 		}
			if (checker.isCanSpy()) { %>
				<liferay-ui:icon image="guest_icon" url="<%= audienceURL.toString() %>" message="room-audience"/>
	<%		}
			if(room.getStatus() == RoomStatus.Exported.getValue()) { %>
				<liferay-ui:icon image="download" url="<%= viewHistoryURL %>" message="room-view-history" />
	<%		} 
		} else if(room.getStatus() == RoomStatus.Exported.getValue()) { %>
			<liferay-ui:icon image="download" url="<%= viewHistoryURL %>" message="room-view-history" />
	<%	} %>
</liferay-ui:icon-menu>