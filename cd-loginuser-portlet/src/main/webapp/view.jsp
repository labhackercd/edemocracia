<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@ page import="com.liferay.portal.kernel.facebook.FacebookConnectUtil"%>
<%@ page import="com.liferay.portal.*"%>
<%@ page import="com.liferay.portal.model.*"%>
<%@ page import="com.liferay.portal.theme.*"%>
<%@ page import="com.liferay.portal.security.auth.AuthException"%>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<portlet:defineObjects />
<%
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	Company company = themeDisplay.getCompany();
%>
<c:choose>
	<c:when test='<%= request.getAttribute("logged-in") != null %>'>
		<%= request.getAttribute("logged-in") %>
	</c:when>
	<c:otherwise>
		<form method="post" action='<%= request.getAttribute("action-url") %>'>
			<div class="mensagensErro">
				<liferay-ui:error exception="<%= AuthException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-login-because-the-maximum-number-of-users-has-been-reached" />
				<liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
				<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
				<liferay-ui:error exception="<%= UserEmailAddressException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= UserLockoutException.class %>" message="this-account-has-been-locked" />
				<liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= UserScreenNameException.class %>" message="authentication-failed" />
			</div>
		
			
			<c:if test='<%=request.getAttribute("facebook-auth-url") != null%>'>
				<div style="float: right;margin-top: 6px;vertical-align: top;margin-left: 7px;">
						<%
							String appId = FacebookConnectUtil.getAppId(company.getCompanyId());
							String portalURL = HttpUtil.encodeURL(themeDisplay.getPortalURL());
							String facebookURL = "https://graph.facebook.com/oauth/authorize?client_id=" + appId + "&redirect_uri=" + portalURL + "%2Fc%2Flogin%2Ffacebook_connect_oauth&scope=email";	
						%>
					<a href="<%=request.getAttribute("facebook-auth-url")%>"><img src="/e-democracia-theme/images/custom/btn_login_facebook.png"></a>
				</div>
			</c:if>
			
			<fieldset>
				<label for="<portlet:namespace/>email">E-Mail</label>
				<input type="text" name="<portlet:namespace/>email" value="${email}"/>
				<label for="<portlet:namespace/>senha">Senha</label>
				<input type="password" name="<portlet:namespace/>senha" value=""/>
				<input type="submit" value="Acessar" />
			</fieldset>
			<div class="linksLogin">
	            <a href="/web/public/cadastro" class="linkCadastro">Cadastre-se para participar</a>
                <a href="/web/public/cadastro?p_p_id=58&_58_struts_action=%2Flogin%2Fforgot_password" class="linkEsqueci">Esqueci a senha</a>
            </div>

			
			
		</form>
	</c:otherwise>
</c:choose>
