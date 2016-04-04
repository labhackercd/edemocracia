package br.gov.camara.edemocracia.cas;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.util.WebKeys;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.CommonUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsValues;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.Saml11TicketValidator;
import org.jasig.cas.client.validation.TicketValidator;

public class CASFilter extends com.liferay.portal.servlet.filters.sso.cas.CASFilter {
    public static final String CAS_PRINCIPAL = "CAS_PRINCIPAL";

	@SuppressWarnings("UnusedDeclaration")
    public static void reload(long companyId) {
        _ticketValidators.remove(companyId);
    }

	@Override
	public boolean isFilterEnabled(HttpServletRequest request, HttpServletResponse response) {
		return super.isFilterEnabled(request, response);
	}

	protected Log getLog() {
        return _log;
    }

    protected TicketValidator getTicketValidator(long companyId) throws Exception {

        TicketValidator ticketValidator = _ticketValidators.get(companyId);

        if (ticketValidator != null) {
            return ticketValidator;
        }

        String serverName = PrefsPropsUtil.getString(
                companyId, PropsKeys.CAS_SERVER_NAME, PropsValues.CAS_SERVER_NAME);
        String serverUrl = PrefsPropsUtil.getString(
                companyId, PropsKeys.CAS_SERVER_URL, PropsValues.CAS_SERVER_URL);
        String loginUrl = PrefsPropsUtil.getString(
                companyId, PropsKeys.CAS_LOGIN_URL, PropsValues.CAS_LOGIN_URL);

        Saml11TicketValidator samlTicketValidator = new Saml11TicketValidator(serverUrl);

		// TODO FIXME We should really use a better name.
		long ticketTolerance = PrefsPropsUtil.getLong(
				companyId, "cas.saml.ticket.tolerance", 1000L);

		samlTicketValidator.setTolerance(ticketTolerance);

        Map<String, String> parameters = new HashMap<String, String>();

        parameters.put("serverName", serverName);
        parameters.put("casServerUrlPrefix", serverUrl);
        parameters.put("casServerLoginUrl", loginUrl);
        parameters.put("redirectAfterValidation", "false");

        samlTicketValidator.setCustomParameters(parameters);

        _ticketValidators.put(companyId, samlTicketValidator);

        return samlTicketValidator;
    }

    @Override
	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

		HttpSession session = request.getSession();

		long companyId = PortalUtil.getCompanyId(request);

		String pathInfo = request.getPathInfo();

		Object forceLogout = session.getAttribute(WebKeys.CAS_FORCE_LOGOUT);

		if (forceLogout != null) {
			session.removeAttribute(WebKeys.CAS_FORCE_LOGOUT);

			String logoutUrl = PrefsPropsUtil.getString(
				companyId, PropsKeys.CAS_LOGOUT_URL,
				PropsValues.CAS_LOGOUT_URL);

			response.sendRedirect(logoutUrl);

			return;
		}

		if (pathInfo.contains("/portal/logout")) {
			session.invalidate();

			String logoutUrl = PrefsPropsUtil.getString(
				companyId, PropsKeys.CAS_LOGOUT_URL,
				PropsValues.CAS_LOGOUT_URL);

			response.sendRedirect(logoutUrl);

			return;
		} else {
			String login = (String) session.getAttribute(WebKeys.CAS_LOGIN);

			if (Validator.isNotNull(login)) {
				processFilter(CASFilter.class, request, response, filterChain);
				return;
			}

			String serverName = PrefsPropsUtil.getString(
				companyId, PropsKeys.CAS_SERVER_NAME,
				PropsValues.CAS_SERVER_NAME);

			String serviceUrl = PrefsPropsUtil.getString(
				companyId, PropsKeys.CAS_SERVICE_URL,
				PropsValues.CAS_SERVICE_URL);

			if (Validator.isNull(serviceUrl)) {
				serviceUrl = CommonUtils.constructServiceUrl(
					request, response, serviceUrl, serverName, "ticket", false);
			}

			String ticket = ParamUtil.getString(request, "ticket");

			if (Validator.isNull(ticket)) {
				String loginUrl = PrefsPropsUtil.getString(
					companyId, PropsKeys.CAS_LOGIN_URL,
					PropsValues.CAS_LOGIN_URL);

				loginUrl = HttpUtil.addParameter(
					loginUrl, "service", serviceUrl);

				response.sendRedirect(loginUrl);
				return;
			}

            TicketValidator ticketValidator = getTicketValidator(companyId);

			Assertion assertion = ticketValidator.validate(ticket, serviceUrl);

			if (assertion != null) {
				AttributePrincipal attributePrincipal = assertion.getPrincipal();

				login = attributePrincipal.getName();

				session.setAttribute(WebKeys.CAS_LOGIN, login);
                session.setAttribute(CAS_PRINCIPAL, attributePrincipal);
			}
		}

		processFilter(CASFilter.class, request, response, filterChain);
	}

    private static Log _log = LogFactoryUtil.getLog(CASFilter.class);
    private static Map<Long, TicketValidator> _ticketValidators = new ConcurrentHashMap<Long, TicketValidator>();

}
