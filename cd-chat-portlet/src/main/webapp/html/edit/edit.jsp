<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="javax.portlet.PortletPreferences"%>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />

<liferay-ui:success key="success" message="Preferências gravadas com sucesso." />
<liferay-ui:error  key="failure" message="Não foi possível gravar as preferências para este portlet." />

<c:set value='<%=Boolean.valueOf(renderRequest.getPreferences().getValue("addthis_utilizar_link_para_sala", "true")) ? "checked" : "" %>' var="addthis_utilizar_link_para_sala" scope="request" />
<c:set value='<%=renderRequest.getPreferences().getValue("addthis_texto_descricao", "") %>' var="addthis_texto_descricao" scope="request" />

<portlet:actionURL name="savePortletPreferences" var="saveURL"/>

<form action="${saveURL}" method="post" class="vForm">

	<h4>Configurações do AddThisEvent</h4>

	<div style="margin-top: 15px;">
		<span>Personalizar texto de descrição do evento</span>
		<textarea name="<portlet:namespace/>addthis_texto_descricao" style="margin-top: 10px; width: 500px;" rows="3" cols="1">${addthis_texto_descricao}</textarea>
		<span style="font-size: 0.9em;">*Se não informado, será usado o texto padrão.</span>
	</div>
	
	<div style="margin-top: 15px;">
		<input id="addthis_utilizar_link_para_sala" type="checkbox" style="display: inline;"  value="true" name="<portlet:namespace/>addthis_utilizar_link_para_sala" ${addthis_utilizar_link_para_sala} /> 
		<label for="addthis_utilizar_link_para_sala" >Utilizar link para sala no final da descrição do evento</label>	
	</div>
	
	<div style="margin-top: 25px;">
		<input type="submit" value="Gravar" />
	</div>
	
</form>

