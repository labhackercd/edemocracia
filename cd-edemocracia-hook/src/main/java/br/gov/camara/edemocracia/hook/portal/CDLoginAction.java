/**
 * 
 */
package br.gov.camara.edemocracia.hook.portal;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.portlet.WindowStateFactory;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLFactoryUtil;

/**
 * Autentica, mas redirecionando para o portlet de login através de HTTP
 * 
 * @author p_7339
 * 
 */
public class CDLoginAction extends BaseStrutsAction {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.AUTH_LOGIN_DISABLED))) {
			response.sendRedirect(themeDisplay.getPathMain()
					+ PropsUtil.get(PropsKeys.AUTH_LOGIN_DISABLED_PATH));

			return null;
		}

		String login = ParamUtil.getString(request, "login");
		String password = request.getParameter("password");
		boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");
		String authType = ParamUtil.getString(request, "authType");

		if (Validator.isNotNull(login) && Validator.isNotNull(password)) {
			MethodKey method = new MethodKey(
					"com.liferay.portlet.login.util.LoginUtil", "login",
					new Class[] { HttpServletRequest.class,
							HttpServletResponse.class, String.class,
							String.class, boolean.class, String.class });

			PortalClassInvoker.invoke(false, method, request, response, login,
					password, rememberMe, authType);
		}

		HttpSession session = request.getSession();

		if ((session.getAttribute("j_username") != null)
				&& (session.getAttribute("j_password") != null)) {

			if (GetterUtil.getBoolean(PropsUtil
					.get(PropsKeys.PORTAL_JAAS_ENABLE))) {
				return "/portal/touch_protected.jsp";
			} else {
				response.sendRedirect(themeDisplay.getPathMain());

				return null;
			}
		}

		String redirect = PortalUtil.getSiteLoginURL(themeDisplay);

		if (Validator.isNull(redirect)) {
			redirect = PropsUtil.get(PropsKeys.AUTH_LOGIN_URL);
		}

		if (Validator.isNull(redirect)) {
			PortletURL portletURL = PortletURLFactoryUtil.create(request,
					PortletKeys.LOGIN, themeDisplay.getPlid(),
					PortletRequest.RENDER_PHASE);

			portletURL.setWindowState(getWindowState(request));
			portletURL.setPortletMode(PortletMode.VIEW);

			portletURL.setParameter("saveLastPath", "0");
			portletURL.setParameter("struts_action", "/login/login");

			redirect = portletURL.toString();
		}

		String loginRedirect = ParamUtil.getString(request, "redirect");

		if (Validator.isNotNull(loginRedirect)) {
			if (PrefsPropsUtil.getBoolean(themeDisplay.getCompanyId(),
					PropsKeys.CAS_AUTH_ENABLED, GetterUtil.getBoolean(PropsUtil
							.get(PropsKeys.CAS_AUTH_ENABLED)))) {

				redirect = loginRedirect;
			} else {
				String loginPortletNamespace = PortalUtil
						.getPortletNamespace(PropsUtil
								.get(PropsKeys.AUTH_LOGIN_PORTLET_NAME));

				String loginRedirectParameter = loginPortletNamespace
						+ "redirect";

				redirect = HttpUtil.setParameter(redirect, "p_p_id",
						PropsUtil.get(PropsKeys.AUTH_LOGIN_PORTLET_NAME));
				redirect = HttpUtil
						.setParameter(redirect, "p_p_lifecycle", "0");
				redirect = HttpUtil.setParameter(redirect,
						loginRedirectParameter, loginRedirect);
			}
		}

		response.sendRedirect(redirect);

		return null;
	}

	protected WindowState getWindowState(HttpServletRequest request) {
		WindowState windowState = WindowState.MAXIMIZED;

		String windowStateString = ParamUtil.getString(request, "windowState");

		if (Validator.isNotNull(windowStateString)) {
			windowState = WindowStateFactory.getWindowState(windowStateString);
		}

		return windowState;
	}
}
