<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<portlet:defineObjects />

<div>
	<h1>Erro ao entrar na sala</h1>
	
	<p class="ajuda">
		<liferay-ui:error key="cant-join" message="cant-join" />
		<liferay-ui:error key="cant-moderate" message="cant-moderate" />
		<liferay-ui:error key="cant-spy" message="cant-spy" />
		<liferay-ui:error key="user-banned" message="user-banned" />
		<liferay-ui:error key="room-closed" message="room-closed" />
		<liferay-ui:error key="user-must-join-audience" message="user-must-join-audience" />
		<liferay-ui:error key="no-access" message="no-access"/>
		<liferay-ui:error key="missing-name" message="missing-name" />
		<liferay-ui:error key="name-too-long" message="name-too-long" />
		<liferay-ui:error key="missing-email" message="missing-email" />
		<liferay-ui:error key="email-too-long" message="email-too-long" />
		<liferay-ui:error key="invalid-email" message="invalid-email" />
		<liferay-ui:error key="room-cant-find" message="room-cant-find" />
	</p>
</div>