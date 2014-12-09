<%
	if (request.getRemoteAddr() != null && (request.getRemoteAddr().equals("10.1.0.60")
			|| request.getRemoteAddr().equals("10.1.0.70"))
			|| (request.getHeader("X-Forwarded-For") != null && (request
					.getHeader("X-Forwarded-For").indexOf("10.1.0.70") != -1 || request
					.getHeader("X-Forwarded-For").indexOf("10.1.0.60") != -1))) {
%>
<div class="portlet-msg-error">Procure a Central de Atendimento do CENIN para corrigir as configurações de proxy do seu browser</div>
<%
	}
%>