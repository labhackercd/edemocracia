<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.model.GroupConstants"%>
<%
	
	String url = PortalUtil.getHomeURL(request);
	boolean isCommunity = true;

	ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	
	
	if(td.getScopeGroup().getName().trim().equalsIgnoreCase("Guest")){
		url = td.getPortalURL() + "/";
		isCommunity = false;
	}else{
		//url = td.getPortalURL() + PortalUtil.getGroupFriendlyURL(td.getScopeGroup(), false, td);
		url = td.getPortalURL() + "/web" + td.getLayout().getGroup().getFriendlyURL();
		isCommunity = true;
		
	}
	
%>


<%if (!td.getLayout().getGroup().getName().equals(GroupConstants.CONTROL_PANEL)) { %>
<div class="compartilhe">
	<span class="titulo">

	<%if(isCommunity == false){%>
		Compartilhe o e-Democracia
	<%}else{ %>
		Compartilhe esta Comunidade
	<%} %>

	</span>
	
    	<!-- AddThis Button BEGIN -->
		<div class="addthis_toolbox addthis_default_style addthis_20x20_style" id="share" addthis:url="<%=url%>">
			<a class="addthis_button_facebook"></a>
			<a class="addthis_button_google_plusone_share"></a>
			<a class="addthis_button_twitter"></a>
			<a class="addthis_button_email"></a>
			<a class="addthis_button_compact"></a>
		</div>
		<script type="text/javascript">var addthis_config = {"data_track_addressbar":true};</script>
		<script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=codis"></script>
		<!-- AddThis Button END -->
</div>
<%} %>
