<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@page import="br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletRequestUtil"%>
<%@page import="br.gov.camara.edemocracia.portlets.chat.portlet.ChatRoomPortlet" %>
<%@page import="br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletConstants" %>
<%@page import="br.gov.camara.edemocracia.portlets.chat.portlet.ChatRoomView" %>
<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.service.RegionServiceUtil"%>
<%@page import="com.liferay.portal.model.Region"%>
<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.portal.service.CountryServiceUtil"%>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<jsp:useBean id="room" type="br.gov.camara.edemocracia.portlets.chat.model.ChatRoom" scope="request" />
<jsp:useBean id="regions" type="java.util.List<Region>" scope="request" />
<jsp:useBean id="suggestions" type="java.util.List<String>" scope="request" />
<jsp:useBean id="apelido" type="java.lang.String" scope="request" />
<jsp:useBean id="email" type="java.lang.String" scope="request" />
<jsp:useBean id="uf" type="java.lang.Long" scope="request" />
<jsp:useBean id="isOpen" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="canJoin" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="canSpy" type="java.lang.Boolean" scope="request" />
<c:set var="twitter" value='<%=request.getAttribute("twitter") %>' />
<c:set var="videoLive" value='<%=request.getAttribute("videoLive") %>' scope="request" />

<c:set var="standAlone" value='<%=Boolean.valueOf(portletConfig.getInitParameter(ChatPortletConstants.STAND_ALONE))%>'/>
<portlet:actionURL name="enterChatAnon" var="enterURL">
	<portlet:param name="roomId" value="<%= Long.toString(room.getRoomId()) %>" />
</portlet:actionURL>

<portlet:actionURL name="enterChatSpy" var="audienceURL">
	<portlet:param name="roomId" value="<%= Long.toString(room.getRoomId()) %>" />
	<c:if test="${not empty previousPageLink}">
		<portlet:param name="<%=ChatPortletConstants.PREVIOUS_PAGE_LINK %>" value="${previousPageLink}" />
	</c:if>
</portlet:actionURL>

<portlet:actionURL name="listChatRooms" var="listViewURL"/>
	
<script type="text/javascript">
<!--
function change_nick(link) {
	var suggestion = $(link).text();
	$('#<portlet:namespace/>apelido').val(suggestion); 
}
//-->
</script>

<div class="acessoBatePapo">    
	<div class="titulo">
		<h2><%= StringEscapeUtils.escapeHtml(room.getRoomName()) %></h2>
		
		<c:choose>
		      <c:when test="${not empty previousPageLink}">
				<a class="botaoVoltar" href="${previousPageLink}">Lista completa de salas </a>
		      </c:when>
		      <c:otherwise>
				<a class="botaoVoltar" href="${listViewURL}">Lista de salas </a>
		      </c:otherwise>
		</c:choose>
		<div style="clear: both;"> </div>
	</div>
	<c:choose>
		<c:when test="<%= isOpen %>">
			<div class="grid-line"> <!-- inicio grid-line -->
			
				<div class="grid-cell size3of5">
					<div class="descricao">
						<c:if test="<%= room.getImageId() != 0 %>">
							<img src="<%=PortalUtil.getPathImage()%>/chat/?img_id=${room.imageId}" alt="<%=StringEscapeUtils.escapeHtml(room.getRoomName())%>">
						</c:if>
						<div><%= room.getDescription() %></div>
					</div>
				</div>
				
				<div class="grid-cell size2of5 last-cell">
							<div class="entrar">
								<c:if test="<%= canJoin %>">
									<form action="${enterURL}" method="post" class="vForm">
										<ul class="fieldList">
											<li>
												<label for="<portlet:namespace/>apelido">Apelido</label>
												<input id="<portlet:namespace/>apelido" type="text" name="nome" value="${apelido}" title="Seu apelido na sala de bate-papo" maxlength="75"/>
											</li>
											<c:if test="<%= !suggestions.isEmpty() %>">
												<li>
													<div class="boxDottedChat">
													<h4>Sugestões de Apelido</h4>
													<ul>
														<c:forEach var="suggestion" items="${suggestions}">
															<li><a href="#" onclick="change_nick(this);"><c:out value="${suggestion}" /></a></li>
														</c:forEach>
													</ul>	
													</div>
												</li>
											</c:if>
											<li>
												<label for="email">E-mail</label>
												<input id="email" type="text" name="email" value="${email}" maxlength="75"/>
											</li>
											<li>
												<div class="uf">
													<label for="uf">UF</label>
													<select id="uf" name="uf">
														<option value="">-</option>
														<%
															for (Region estado : regions) {
																if (estado.getRegionId() == uf) {
														%>
														<option selected value="<%=estado.getRegionId()%>"><%=estado.getRegionCode()%></option>
														<%
																} else {
														%>
														<option value="<%=estado.getRegionId()%>"><%=estado.getRegionCode()%></option>
														<%
																}
															}
														%>
													</select>
												</div>
												
												<input type="hidden" name="previousPageLink" value="${previousPageLink}" />
												<input type="submit" name="comando" value="Entrar na Sala" /> 
											</li>
										</ul>
									</form>
								</c:if>
							</div>

		
							<div class="espiar">
								<p class="ajuda">
									<liferay-ui:error key="cant-join" message="cant-join" />
									<liferay-ui:error key="cant-moderate" message="cant-moderate" />
									<liferay-ui:error key="cant-spy" message="cant-spy" />
									<liferay-ui:error key="user-banned" message="user-banned" />
									<liferay-ui:error key="user-must-join-audience"	message="user-must-join-audience" />
									<liferay-ui:error key="no-access" message="no-access"/>
									<liferay-ui:error key="invalid-region" message="invalid-region"/>
									<liferay-ui:error key="missing-name" message="missing-name" />
									<liferay-ui:error key="name-too-long" message="name-too-long" />
									<liferay-ui:error key="missing-email" message="missing-email" />
									<liferay-ui:error key="email-too-long" message="email-too-long" />
									<liferay-ui:error key="invalid-email" message="invalid-email" />
									<liferay-ui:error key="name-already-exists-scope-room" message="name-already-exists-scope-room" />
									<liferay-ui:error key="email-already-exists-scope-room" message="email-already-exists-scope-room" />
									<liferay-ui:error key="name-already-exists-scope-portal" message="name-already-exists-scope-portal" />
									<liferay-ui:error key="email-already-exists-scope-portal" message="email-already-exists-scope-portal" />  
								</p>
								<c:if test="<%= canSpy %>">
									<p class="ajuda">
										Para ver os participantes e as últimas mensagens da sala, clique em "Espiar"
									</p>
									<a class="botao" href="${audienceURL}">Espiar</a><br/>
								</c:if>
							</div>		
							
							<c:if test="${room.usePolicyEnabled}">
								<div class="politicaDeUso" >
									<p class="ajuda">
										Ao utilizar este serviço, o usuário  atesta que concorda com nossa <a target="_blank" href="${room.usePolicyURL}">política de uso</a><br/>	
									</p>
								</div>
							</c:if>					
					</div>
			</div> <!-- final grid-line -->

 			<c:if test="${not standAlone and ((not empty twitter and twitter.twitterEnabled ) or (not empty videoLive and videoLive.videoEnabled)) }">
				
				<div class="grid-line cdchat_twitter-video-horizontal "> <!-- inicio grid-line -->
					
					<div class="grid-cell size2of5">
	
						<c:if test="${videoLive.videoEnabled}">
							<%@ include file="video.jspf"  %>
						</c:if>
	
					</div>
						
					<div class="grid-cell size3of5 last-cell">
					
						<c:if test="${twitter.twitterEnabled and not empty twitter.twitterDataWidgetId}">				
								<%@ include file="twitter.jspf"  %>
						</c:if>
					
					</div>
					
				</div> <!-- final grid-line -->
			
			</c:if>
				
		</c:when>
		<c:otherwise>
			<h2>Sala fechada</h2>
			
			<div class="grid-line">
				<div class="grid-cell size4of5 last-cell">
					<div class="descricao">
						<c:if test="<%= room.getImageId() != 0 %>">
							<img src="<%=PortalUtil.getPathImage()%>/chat/?img_id=${room.imageId}" alt="<%=StringEscapeUtils.escapeHtml(room.getRoomName())%>">
						</c:if>
						<div><%= room.getDescription() %></div>
					</div>
				</div>
			</div>
			
			<%@ include file="painelagendar.jspf" %>
			
		</c:otherwise>	
	</c:choose>
</div>