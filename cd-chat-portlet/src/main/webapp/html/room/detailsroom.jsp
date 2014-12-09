<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletConstants"%>

<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<jsp:useBean id="room"
	type="br.gov.camara.edemocracia.portlets.chat.model.ChatRoom"
	scope="request" />

<liferay-ui:error key="cant-join" message="cant-join" />
<liferay-ui:error key="cant-moderate" message="cant-moderate" />
<liferay-ui:error key="cant-spy" message="cant-spy" />
<liferay-ui:error key="user-banned" message="user-banned" />
<liferay-ui:error key="room-closed" message="room-closed" />
<liferay-ui:error key="user-must-join-audience"
	message="user-must-join-audience" />
<liferay-ui:error key="no-access" message="no-access" />

<c:set var="standAlone"
	value='<%=Boolean.valueOf(portletConfig.getInitParameter(ChatPortletConstants.STAND_ALONE))%>' />

<portlet:actionURL name="enterChatRoom" var="enterURL">
	<portlet:param name="roomId" value="<%=String.valueOf(room.getRoomId())%>" />
</portlet:actionURL>

<portlet:actionURL name="listChatRooms" var="listViewURL"/>

<div class="acessoBatePapo">

	<div class="titulo">
		<h2><%=StringEscapeUtils.escapeHtml(room.getRoomName())%></h2>

		<c:choose>
			<c:when test="${not empty previousPageLink}">
				<a class="botaoVoltar" href="${previousPageLink}">Lista completa
					de salas </a>
			</c:when>
			<c:otherwise>
				<a class="botaoVoltar" href="${listViewURL}">Lista de salas </a>
			</c:otherwise>
		</c:choose>
		<div style="clear: both;"></div>
	</div>
	<c:if test="<%=!room.isOpen()%>">
		<h2>Sala fechada</h2>
	</c:if>

	<div class="grid-line">
		<div class="grid-cell size4of5 last-cell">
			<div class="descricao">
				<c:if test="<%=room.getImageId() != 0%>">
					<img
						src="<%=PortalUtil.getPathImage()%>/chat/?img_id=${room.imageId}"
						alt="<%=StringEscapeUtils.escapeHtml(room.getRoomName())%>">
				</c:if>
				<div><%=room.getDescription()%></div>
			</div>

			<c:if test="${room.usePolicyEnabled}">
				<div class="politicaDeUso">
					<p class="ajuda">
						Ao utilizar este serviço, o usuário atesta que concorda com nossa
						<a target="_blank" href="${room.usePolicyURL}">política de uso</a><br />
					</p>
				</div>
			</c:if>
		</div>
	</div>

	<c:if test="<%=room.isOpen()%>">
		<div class="painelEntrar" >
		
		 	 <c:choose>
		 	 
            	 <c:when test="<%= themeDisplay.isSignedIn() %>">
                 	
                 	<c:if test="${requestScope.canJoin}">
						<a href="<%=enterURL%>" class="lnk-botao" style = "margin-right: 12px;" title="Entrar">Entrar na Sala</a>
					</c:if>
					<c:if test="${requestScope.canSpy}">
						<portlet:actionURL name="enterChatSpy" var="audienceURL">
							<portlet:param name="roomId"
								value="<%=String.valueOf(room.getRoomId())%>" />
						</portlet:actionURL>
						<a href="<%=audienceURL%>" class="lnk-botao" title="Espiar">Espiar</a>
					</c:if>
					
	             </c:when>
	             
	             <c:otherwise>
	             
	             	<c:if test="${requestScope.canJoin or requestScope.canSpy}">
						<a href="<%=enterURL%>" class="lnk-botao" title="Participar">Participar</a>
					</c:if>
					
	             </c:otherwise>
	             
			</c:choose>
				
		</div>
	</c:if>
	
	<%@ include file="painelagendar.jspf" %>

</div>