/**
 * Copyright (c) 2009-2014 Câmara dos Deputados. Todos os direitos reservados.
 *
 * e-Democracia é um software livre; você pode redistribuí-lo e/ou modificá-lo dentro
 * dos termos da Licença Pública Geral Menor GNU como publicada pela Fundação do 
 * Software Livre (FSF); na versão 2.1 da Licença, ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser  útil, mas SEM NENHUMA GARANTIA;
 * sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR.
 * Veja a Licença Pública Geral Menor GNU para maiores detalhes. 
 */
package br.gov.camara.edemocracia.hook.portal;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.StrutsAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;

public class CDUpdatePasswordAction extends BaseStrutsAction {
	
	@Override
	public String execute(StrutsAction originalStrutsAction,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String retorno = originalStrutsAction.execute(originalStrutsAction, request, response);
		
		retorno = verificaRedirecionamentoParaHttp(request, response, retorno);
		return retorno;
	}

	private String verificaRedirecionamentoParaHttp(HttpServletRequest request,
			HttpServletResponse response, String retorno) throws IOException {
		if ("portal.update_password".equals(retorno) && !Validator.isNull(ParamUtil.getString(request, Constants.CMD))) {
			String ticketKey = ParamUtil.getString(request, "ticketKey");
			String plid = ParamUtil.getString(request, "p_l_id");
			String doAsUserId = ParamUtil.getString(request, "doAsUserId");
			String urlHttp = PortalUtil.getPortalURL(request, false) + Portal.PATH_MAIN + "/portal/update_password";
			if (!Validator.isNull(ticketKey))
				urlHttp = HttpUtil.addParameter(urlHttp, "ticketKey", ticketKey);
			if (!Validator.isNull(plid))
				urlHttp = HttpUtil.addParameter(urlHttp, "p_l_id", plid);
			if (!Validator.isNull(doAsUserId))
				urlHttp = HttpUtil.addParameter(urlHttp, "doAsUserId", doAsUserId);
			response.sendRedirect(urlHttp);
			return null;
		} else {
			return retorno;
		}
	}

}
