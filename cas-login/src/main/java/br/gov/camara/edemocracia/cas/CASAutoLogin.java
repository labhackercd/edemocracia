package br.gov.camara.edemocracia.cas;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AutoLogin;
import com.liferay.portal.security.ldap.PortalLDAPImporterUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;
import org.jasig.cas.client.authentication.AttributePrincipal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

public class CASAutoLogin implements AutoLogin {

	public String[] login(
		HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		String[] credentials = null;

		try {
			long companyId = PortalUtil.getCompanyId(request);

			if (!PrefsPropsUtil.getBoolean(
					companyId, PropsKeys.CAS_AUTH_ENABLED,
					PropsValues.CAS_AUTH_ENABLED)) {

				return credentials;
			}

			String login = (String) session.getAttribute(WebKeys.CAS_LOGIN);


			if (Validator.isNull(login)) {
				Object noSuchUserException = session.getAttribute(
						WebKeys.CAS_NO_SUCH_USER_EXCEPTION);

				if (noSuchUserException == null) {
					return credentials;
				}

				session.removeAttribute(WebKeys.CAS_NO_SUCH_USER_EXCEPTION);

				session.setAttribute(WebKeys.CAS_FORCE_LOGOUT, Boolean.TRUE);

				String redirect = PrefsPropsUtil.getString(
						companyId, PropsKeys.CAS_NO_SUCH_USER_REDIRECT_URL,
						PropsValues.CAS_NO_SUCH_USER_REDIRECT_URL);

				request.setAttribute(AutoLogin.AUTO_LOGIN_REDIRECT, redirect);

				return credentials;
			}

			String authType = PrefsPropsUtil.getString(
					companyId, PropsKeys.COMPANY_SECURITY_AUTH_TYPE,
					PropsValues.COMPANY_SECURITY_AUTH_TYPE);

			User user = null;

			if (PrefsPropsUtil.getBoolean(
					companyId, PropsKeys.CAS_IMPORT_FROM_LDAP,
					PropsValues.CAS_IMPORT_FROM_LDAP)) {

				try {
					if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
						user = PortalLDAPImporterUtil.importLDAPUser(
								companyId, StringPool.BLANK, login);
					} else {
						user = PortalLDAPImporterUtil.importLDAPUser(
								companyId, login, StringPool.BLANK);
					}
				} catch (SystemException se) {
					// Do nothing.
				}
			}

			if (user == null) {
				try {
					if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
						user = UserLocalServiceUtil.getUserByScreenName(
								companyId, login);
					} else {
						user = UserLocalServiceUtil.getUserByEmailAddress(
								companyId, login);
					}
				} catch (NoSuchUserException e) {
					AttributePrincipal principal =
                            (AttributePrincipal) session.getAttribute(CASFilter.CAS_PRINCIPAL);

					if (principal == null)
						throw new NoSuchUserException("No user nor principal.", e);

					user = addUser(companyId, login, principal);
				}
			}

			String redirect = ParamUtil.getString(request, "redirect");

			if (Validator.isNotNull(redirect)) {
				request.setAttribute(AutoLogin.AUTO_LOGIN_REDIRECT, redirect);
			}

			credentials = new String[3];

			credentials[0] = String.valueOf(user.getUserId());
			credentials[1] = user.getPassword();
			credentials[2] = Boolean.TRUE.toString();

			return credentials;
		} catch (Exception e) {
			_log.error(e, e);
		}

		return credentials;
	}

	private User addUser(long companyId, String login, AttributePrincipal principal)
			throws SystemException, PortalException {
        Map<String, Object> attrs = principal.getAttributes();

        String firstName = MapUtil.getString(attrs, "firstName", stringBefore(login, "@"));
		String middleName = MapUtil.getString(attrs, "middleName", null);
		String lastName = MapUtil.getString(attrs, "lastName", null);

        return UserLocalServiceUtil.addUser(
                /* creatorUserId */ 0, companyId, /* autoPassword */ true,
                /* password1 */ null, /* password2 */ null,
                /* autoScreenName */ true, /* screenName */ null,
                /* emailAddress */ login, /* facebookId */ 0, /* openId */ "",
                /* locale */ Locale.getDefault(), firstName, middleName,
                lastName, /* prefixId */ 0, /* suffixId */ 0, /* male */ false,
                /* birthdayMonth */ 0, /* birthdayDay */ 1, /* birthdayYear */ 1970,
                /* jobTitle */ null, /* groupIds */ new long[] {companyId},
                /* organizationIds */ null, /* roleIds */ null,
                /* userGroupIds */ new long[] {}, /* sendEmail */ false,
                new ServiceContext());
    }

	private static String stringBefore(String s, String c) {
		int i = s.indexOf(c);
		return i < 0 ? s : s.substring(0, i);
	}

    private static Log _log = LogFactoryUtil.getLog(CASAutoLogin.class);
}