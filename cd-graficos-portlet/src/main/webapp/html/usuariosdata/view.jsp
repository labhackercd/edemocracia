<%
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<jsp:useBean id="url" scope="request" type="java.lang.String" />
<jsp:useBean id="showTimeRange" scope="request" type="java.lang.Boolean" />

<% if (showTimeRange) { %>
	<portlet:actionURL var="form_action" name="updateDateRange" />
	
	<jsp:useBean id="start" scope="request" type="java.lang.String" />
	<jsp:useBean id="end" scope="request" type="java.lang.String" />

	<form action="<%= form_action %>" method="post">
	<fieldset>
	<label for="<portlet:namespace />start">De</label>
	<input type="text" class="graphDatePicker" id="<portlet:namespace />start" name="<portlet:namespace />start" value="<%= start %>" />
	<label for="<portlet:namespace />end">Até</label>
	<input type="text" class="graphDatePicker" id="<portlet:namespace />end" name="<portlet:namespace />end" value="<%= end %>"  />
	<input type="submit" value="Atualizar" />
	</fieldset>
	</form>
<% } %>

<img src="<%= url %>" alt="Usuários por Data" />

