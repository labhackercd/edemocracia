<%@taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<jsp:useBean id="podeAssinarAComunidade" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="podeSairDaComunidade" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="urlAcao" type="java.lang.String" scope="request" />

<portlet:defineObjects />
<theme:defineObjects />

<div class="acao">
	<liferay-ui:success key="membro-usuario" message="membro-usuario" />
	<liferay-ui:success key="descadastrado-usuario" message="descadastrado-usuario" />
	<liferay-ui:error key="erro-descadastrar-usuario" message="erro-descadastrar-usuario" />
	<liferay-ui:error key="erro-cadastrar-usuario" message="erro-cadastrar-usuario" />

	<c:if test="${podeAssinarAComunidade}">
		<div class="participar">
			<a href="${urlAcao}">
				<img src="${pageContext.request.contextPath}/images/btn_participar_comunidade.jpg"/>
			</a>
		</div>
	</c:if>
	
	<c:if test="${podeSairDaComunidade}">
		<div class="participar">
			<a href="${urlAcao}">
				<img src="${pageContext.request.contextPath}/images/btn_deixar_comunidade.jpg"/>
			</a>
		</div>
	</c:if>	

</div>