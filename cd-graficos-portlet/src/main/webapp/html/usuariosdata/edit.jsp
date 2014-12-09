<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<jsp:useBean id="tipoGrafico" scope="request" type="java.lang.Integer" />

<portlet:actionURL var="form_action" name="updateGraphType" />

<form action="<%= form_action %>" method="post">
<fieldset>
<label for="<portlet:namespace />tipografico">Gr&aacute;fico</label>
<select id="<portlet:namespace />tipografico" name="<portlet:namespace />tipografico">
	<option value="1" <% if(tipoGrafico == 1) { %>selected="selected" <% } %> >Usu&aacute;rios inscritos por Data</option>
	<option value="2" <% if(tipoGrafico == 2) { %>selected="selected" <% } %> >Usu&aacute;rios inscritos por Unidade da Federa&ccedil;&atilde;o</option>
	<option value="3" <% if(tipoGrafico == 3) { %>selected="selected" <% } %> >Uso do e-Democracia</option>
</select>
<input type="submit" value="Atualizar" />
</fieldset>
</form>