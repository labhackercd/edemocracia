<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>

<%@page import="com.liferay.portal.service.CountryServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.model.Region"%>
<%@page import="com.liferay.portal.service.RegionServiceUtil"%>
<%@page import="com.liferay.portal.model.Contact"%>
<%@page import="com.liferay.portal.service.AddressLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.Address"%>


<%@page import="com.liferay.portal.model.Country"%>
<%@page import="com.liferay.counter.service.CounterLocalServiceUtil"%>

<portlet:defineObjects />
<theme:defineObjects />

<jsp:useBean id="uf" scope="request" class="java.lang.String" />
<jsp:useBean id="endCompleto" scope="request" type="java.lang.Boolean" />
<jsp:useBean id="lp" scope="request" class="java.lang.String" />

<portlet:actionURL name="chooseUF" var="chooseUFURL" />

<%
if(endCompleto) {%>
	<label for="<portlet:namespace />uf">Todos os endereços estão completos.</label><br />
<%} else {%>
	<form id="ufs" name="ufs" action="${chooseUFURL}" method="post" >
		<input type="hidden" name="<portlet:namespace />lp" value="${lp}" />
		<fieldset>
			<div class="itensCadastro">
				<label for="<portlet:namespace />uf">Selecione sua UF</label><br />
				<select id="<portlet:namespace />uf" name="uf">
					<option value="0">Selecione...</option>
					<%
					long brasilId = CountryServiceUtil.getCountryByA2("BR").getCountryId();
					List<Region> regiao = RegionServiceUtil.getRegions(brasilId); 
					for (Region region : regiao) {
						if(uf.equals(""+region.getRegionId())) {
							%><option SELECTED value="<%=region.getRegionId() %>"><%=region.getName() %></option><%
						} else {
							%><option value="<%=region.getRegionId() %>"><%=region.getName() %></option><%
						} 
					}
					%>
				</select>
				<div class="itensCadastro"><br />
				<input type="submit" value="Cadastrar" />
				</div>
			</div>
		</fieldset>
	</form>
<%} %>
