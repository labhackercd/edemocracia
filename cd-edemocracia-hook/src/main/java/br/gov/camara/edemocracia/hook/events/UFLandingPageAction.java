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
package br.gov.camara.edemocracia.hook.events;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * @author Robson Miranda
 * 
 *         Redireciona para a página de UF, caso o usuário não tenha cadastrado
 *         nenhum endereço no Brasil
 */
public class UFLandingPageAction extends Action {

    @Override
    public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {

	try {
	    doRun(request, response);
	} catch (Exception e) {
	    throw new ActionException(e);
	}
    }

    protected void doRun(HttpServletRequest request, HttpServletResponse response) throws Exception {

	Company company = PortalUtil.getCompany(request);

	// Apenas para a comunidade default (e-democracia)
	String defaultWebId = PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID);
	if (!company.getWebId().equals(defaultWebId)) {
	    return;
	}

	// Verifica se realmente está autenticado
	User user = PortalUtil.getUser(request);
	if (user.isDefaultUser())
	    return;

	Country brazil = CountryServiceUtil.getCountryByA2("BR");

	// Verirfica se tem endereço no brasil
	for (Address address : user.getAddresses()) {
	    if (address.getCountryId() == brazil.getCountryId()) {
		try {
		    Region region = RegionServiceUtil.getRegion(address.getRegionId());
		    if (region.getCountryId() == brazil.getCountryId())
			return;
		} catch (PortalException e) {
		    // Ignore: Região não encontrada
		}
	    }
	}

	HttpSession session = request.getSession();
	LastPath oldLastPath = (LastPath) session.getAttribute(WebKeys.LAST_PATH);

	// Vai para a página principal
	if (oldLastPath == null) {
	    oldLastPath = new LastPath("", "/principal", new HashMap<String, String[]>());
	}

	HashMap<String, String[]> params = new HashMap<String, String[]>();
	params.put("lp", new String[] { oldLastPath.getContextPath() + oldLastPath.getPath() });
	LastPath newLastPath = new LastPath("", "/web/public/uf", params);
	session.setAttribute(WebKeys.LAST_PATH, newLastPath);
	_log.info("User logged in, redirect to page:" + newLastPath);
	if (session.getAttribute("FACEBOOK_USER_ID") != null && !"/login/login_redirect".equals(request.getParameter("_58_struts_action"))) {
	    String lastPath = newLastPath.getPath();
	    lastPath = HttpUtil.addParameter(lastPath, "lp", params.get("lp")[0]);
	    response.sendRedirect(lastPath);
	    _log.debug("Usuário do facebook redirecionado para cadastro de UF");
	}
    }

    private static Log _log = LogFactoryUtil.getLog(UFLandingPageAction.class);

}