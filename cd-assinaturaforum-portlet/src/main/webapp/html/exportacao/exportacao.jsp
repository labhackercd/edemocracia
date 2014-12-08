<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:defineObjects />
<theme:defineObjects />

<portlet:resourceURL var="csvURL" >
	<portlet:param name="ad" value="" />
</portlet:resourceURL>
<portlet:resourceURL var="csvAdminURL" >
	<portlet:param name="ad" value="true" />
</portlet:resourceURL>

<%
	ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	long groupId = td.getPortletGroupId();
%>

<div style="clear: both;overflow: hidden; margin: 0;padding: 0;" >
	<div style ="float:right;" >
		<a  class="taglib-icon" href="${csvURL}"><img class="icon" src="/html/themes/control_panel/images/common/download.png" alt="" id="aui-3-2-0PR1-1711" ><span class="taglib-text" >Download dos dados</span></a>
		<c:if test="<%=td.getPermissionChecker().isCommunityAdmin(groupId)   %>">
			<a class="taglib-icon" href="${csvAdminURL}"><img class="icon" src="/html/themes/control_panel/images/common/assign.png" alt="" id="aui-3-2-0PR1-11173"><span class="taglib-text" >Dados para administradores</span></a> 
		</c:if>
	</div>
</div>