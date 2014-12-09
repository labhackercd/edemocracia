<%@page import="br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="br.gov.camara.edemocracia.portlets.chat.model.ChatRoom" %>
<%@ page import="br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@page import="br.gov.camara.edemocracia.portlets.chat.model.impl.RoomStatus"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ChatRoom room = (ChatRoom) row.getObject();
	String primkey = String.valueOf(room.getPrimaryKey());
	Date now = new Date();
	DateFormat dfAbrir = new SimpleDateFormat("'Fechada (Abertura em 'dd/MM/yyyy' - 'HH:mm')'");
	DateFormat dfFechada = new SimpleDateFormat("'Fechada (Encerrada em 'dd/MM/yyyy' - 'HH:mm')'");
	dfAbrir.setTimeZone(timeZone);
	dfFechada.setTimeZone(timeZone);
	
	String status;
	if (room.isOpen(now)) {
		status = "Aberta";
	} else {
		if (room.getOpenUntil() != null && room.getOpenUntil().before(now))
			status = dfFechada.format(room.getOpenUntil());
		else if (room.getOpenFrom() != null && now.before(room.getOpenFrom()))
			status = dfAbrir.format(room.getOpenFrom());
		else
			status = "Fechada";
	}
%>
<%= status %>