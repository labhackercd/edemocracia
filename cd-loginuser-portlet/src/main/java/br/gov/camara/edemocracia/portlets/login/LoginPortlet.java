/**
 * 
 */
package br.gov.camara.edemocracia.portlets.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSecurityException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.facebook.FacebookConnectUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthException;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class LoginPortlet extends GenericPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(LoginPortlet.class);
	
	private static final String tokenOldLastPath = "L_O_LP";

	@RenderMode(name = "VIEW")
	public void preparaVisualizacao(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		carregarERemoverLastPathDaSessao(request);
		
		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User usuario = td.getUser();
		if (!usuario.isDefaultUser()) {
			obtemNomeDoUsuario(request, td, usuario);
		} else {
			preparaUrlSubmissaoFormulario(request, response);
		}
		
		getPortletContext().getRequestDispatcher("/view.jsp").include(request, response);
	}

	private void preparaUrlSubmissaoFormulario(RenderRequest request, RenderResponse response) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Company company = themeDisplay.getCompany();
		PortletURL actionUrl = response.createActionURL();
		actionUrl.setParameter(ActionRequest.ACTION_NAME, "autentica");

		try {
			actionUrl.setSecure(true);
		} catch (PortletSecurityException e) {
			LOG.error("Unable to set secure URL", e);
		}
		request.setAttribute("action-url", actionUrl.toString());

		String facebookAuthURL = null;
		try {
			if (FacebookConnectUtil.isEnabled(company.getCompanyId())) {
				String facebookAuthRedirectURL = FacebookConnectUtil.getRedirectURL(themeDisplay.getCompanyId());
				facebookAuthRedirectURL = HttpUtil.addParameter(facebookAuthRedirectURL, "redirect",
						PortalUtil.getPortalURL(request) + PortalUtil.getCurrentURL(request));

				facebookAuthURL = FacebookConnectUtil.getAuthURL(themeDisplay.getCompanyId());
				facebookAuthURL = HttpUtil.addParameter(facebookAuthURL, "client_id", FacebookConnectUtil.getAppId(themeDisplay.getCompanyId()));
				facebookAuthURL = HttpUtil.addParameter(facebookAuthURL, "redirect_uri", facebookAuthRedirectURL);
				facebookAuthURL = HttpUtil.addParameter(facebookAuthURL, "scope", "email");
			}
		} catch (SystemException e) {
			facebookAuthURL = null;
		}
		request.setAttribute("facebook-auth-url", facebookAuthURL);

		PortletSession session = request.getPortletSession(false);
		if (session != null) {
			request.setAttribute("email", session.getAttribute("email"));
			session.removeAttribute("email");
		}

	}

	private void obtemNomeDoUsuario(RenderRequest request, ThemeDisplay td, User usuario) {
		Locale locale = td.getLocale();
		String nome = HtmlUtil.escape(usuario.getFullName());
		if (td.isShowMyAccountIcon()) {
			nome = "<a href=\"" + HtmlUtil.escape(td.getURLMyAccount().toString()) + "\">" + nome + "</a>";
		}

		request.setAttribute("logged-in", LanguageUtil.format(locale, "you-are-signed-in-as-x", nome));
	}

	@ProcessAction(name = "autentica")
	public void autenticaUsuario(ActionRequest request, ActionResponse response) throws IOException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		if (tentaAutenticar(request, response, email, senha)) {
			PortletSession session = request.getPortletSession(false);
			if (session != null) {
				session.removeAttribute("email");
			}
			redirecionaParaUfOuAtual(request, response, email);
		} else {
			request.getPortletSession().setAttribute("email", email);
		}
	}

	private boolean tentaAutenticar(ActionRequest request, ActionResponse response, String email, String senha) {
		MethodKey method = new MethodKey("com.liferay.portlet.login.util.LoginUtil", "login", new Class[] { HttpServletRequest.class,
				HttpServletResponse.class, String.class, String.class, boolean.class, String.class });

		try {
			PortalClassInvoker.invoke(false, method, PortalUtil.getHttpServletRequest(request), PortalUtil.getHttpServletResponse(response), email, senha,
					false, CompanyConstants.AUTH_TYPE_EA);
			return true;

		} catch (Exception e) {
			if (e instanceof AuthException) {
				Throwable cause = e.getCause();
				if (cause != null) {
					SessionErrors.add(request, cause.getClass());
					salvarLastPathNaSessao(request);
				} else {
					SessionErrors.add(request, e.getClass());
					salvarLastPathNaSessao(request);
				}
			} else {
				SessionErrors.add(request, e.getClass());
			}
			return false;
		}
	}

	private void redirecionaParaUfOuAtual(ActionRequest request, ActionResponse response, String login) throws IOException {

		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String currentUrl = obtemUrlAtual(td);
		if (currentUrl == null)
			return;

		try {
			Company company = PortalUtil.getCompany(request);

			if (!isComunidadeEDemocracia(response, currentUrl, company)) {
				response.sendRedirect(currentUrl);
				return;
			}

			User user = UserLocalServiceUtil.getUserByEmailAddress(company.getCompanyId(), login);

			if (!possuiEnderecoNoBrasil(response, user)) {
				redirecionaParaEscolhaUf(response, td, currentUrl, company);
			} else {

				String saveLastPath = PropsUtil.get(PropsKeys.AUTH_FORWARD_BY_LAST_PATH);
				boolean saveLastPathEnabled = saveLastPath != null ? Boolean.parseBoolean(saveLastPath) : false;
				// Habilitado redirecionamento depois do login para última tela
				// visitada
				if (saveLastPathEnabled) {
					String lastPath = getLastPath(request);
					if (Validator.isNotNull(lastPath)) {
						response.sendRedirect(lastPath);
					} else {
						response.sendRedirect(currentUrl);
					}
				} else {
					response.sendRedirect(currentUrl);
				}

			}

		} catch (Exception e) {
			// Erro. Vai para a página atual mesmo
			response.sendRedirect(currentUrl);
		}
	}
	
	private void carregarERemoverLastPathDaSessao(PortletRequest portletRequest) {
		
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);

		@SuppressWarnings("unchecked")
		Map<String, LastPath> dados = (Map<String, LastPath>) httpServletRequest.getSession().getAttribute(tokenOldLastPath);

		if (dados != null && !dados.isEmpty()) {
			LastPath oldLastPath = dados.get("oldLastPath");
			
			HttpSession session = httpServletRequest.getSession();
			session.setAttribute(WebKeys.LAST_PATH, oldLastPath);
		}
		
		httpServletRequest.getSession().removeAttribute(tokenOldLastPath);
	}
	
	private void salvarLastPathNaSessao(PortletRequest portletRequest) {
	
		LastPath lastPath = getLastPathObject(portletRequest);
		String urlCadastro = "/web/public/cadastro";
		String lastPathCompleto = lastPath.getContextPath() + lastPath.getPath();
		
		if (!lastPathCompleto.equalsIgnoreCase(urlCadastro)){
			Map<String, LastPath> dados = new HashMap<String, LastPath>();
			dados.put("oldLastPath", lastPath);
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(portletRequest);
			httpRequest.getSession().setAttribute(tokenOldLastPath, dados);
		}
	}

	private String getLastPath(PortletRequest request) {
		LastPath lp = getLastPathObject(request);

		return lp.getContextPath() + lp.getPath();
	}
	
	private LastPath getLastPathObject(PortletRequest request) {
		HttpServletRequest originalRequest = PortalUtil.getHttpServletRequest(request);
		LastPath lp = (LastPath) originalRequest.getSession().getAttribute("LAST_PATH");

		return lp;
	}

	private String obtemUrlAtual(ThemeDisplay td) {
		String currentUrl;
		try {
			currentUrl = PortalUtil.getLayoutFriendlyURL(td.getLayout(), td);
		} catch (PortalException e) {
			LOG.error("Error redirecting - ignoring", e);
			return null;
		} catch (SystemException e) {
			LOG.error("Error redirecting - ignoring", e);
			return null;
		}
		return currentUrl;
	}

	private boolean isComunidadeEDemocracia(ActionResponse response, String currentUrl, Company company) throws IOException {
		String defaultWebId = PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID);
		if (!company.getWebId().equals(defaultWebId)) {
			return false;
		} else {
			return true;
		}
	}

	private boolean possuiEnderecoNoBrasil(ActionResponse response, User user) throws PortalException, SystemException, IOException {
		Country brazil = CountryServiceUtil.getCountryByA2("BR");

		for (Address address : user.getAddresses()) {
			if (address.getCountryId() == brazil.getCountryId()) {
				try {
					Region region = RegionServiceUtil.getRegion(address.getRegionId());
					if (region.getCountryId() == brazil.getCountryId()) {
						return true;
					}
				} catch (PortalException e) {
					// Ignore: Região não encontrada
				}
			}
		}
		return false;
	}

	private void redirecionaParaEscolhaUf(ActionResponse response, ThemeDisplay td, String currentUrl, Company company) throws PortalException,
			SystemException, IOException {
		Group guestGroup = GroupLocalServiceUtil.getGroup(company.getCompanyId(), GroupConstants.GUEST);
		Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(guestGroup.getGroupId(), false, "/uf");
		String url = PortalUtil.getLayoutFriendlyURL(layout, td);
		url = HttpUtil.addParameter(url, "lp", currentUrl);
		response.sendRedirect(url);
	}
}
