/**
 * 
 */
package br.gov.camara.edemocracia.portlets.cadastrousuarios.beans;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;

import com.liferay.faces.portal.context.LiferayFacesContext;

import br.gov.camara.edemocracia.util.ClassPathResourceUtil;
import br.gov.camara.edemocracia.util.UrlRewriterUtil;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.PasswordPolicy;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.TicketConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.TicketLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

/**
 * @author p_7339
 * 
 */
public class LiferayCadastroUtil {

	private static final Log _log = LogFactoryUtil.getLog(LiferayCadastroUtil.class);

	private static final String _PRIVATE_GROUP_SERVLET_MAPPING = PropsUtil.get(PropsKeys.LAYOUT_FRIENDLY_URL_PRIVATE_GROUP_SERVLET_MAPPING);

	private static final String _PRIVATE_USER_SERVLET_MAPPING = PropsUtil.get(PropsKeys.LAYOUT_FRIENDLY_URL_PRIVATE_USER_SERVLET_MAPPING);

	private static final String _PUBLIC_GROUP_SERVLET_MAPPING = PropsUtil.get(PropsKeys.LAYOUT_FRIENDLY_URL_PUBLIC_SERVLET_MAPPING);

	private static final long EXPIRATION_TIME = 1000 * 60 * 24 * 30 * 3; //90 dias em milissegundos

	private static final String UNREGISTER_USER_PORTLET_ID = "cdunregisteruserportlet_WAR_cdregisteruserportlet";
	private static String UNREGISTER_USER_PORTLET_NAME = "cdunregisteruserportlet_WAR_cdregisteruserportlet";//"cdunregisteruserportlet_WAR_cdregisteruserportlet_INSTANCE_5itvcJ5cWSoE"; //"cd-unregisteruser-portlet";

	private static long getPlidFromFriendlyURL(long companyId, String friendlyURL) {
		if (Validator.isNull(friendlyURL)) {
			return LayoutConstants.DEFAULT_PLID;
		}

		String[] urlParts = friendlyURL.split("\\/", 4);

		if ((friendlyURL.charAt(0) != CharPool.SLASH) && (urlParts.length != 4)) {
			return LayoutConstants.DEFAULT_PLID;
		}

		boolean privateLayout = true;

		String urlPrefix = StringPool.SLASH + urlParts[1];

		if (_PUBLIC_GROUP_SERVLET_MAPPING.equals(urlPrefix)) {
			privateLayout = false;
		} else if (_PRIVATE_GROUP_SERVLET_MAPPING.equals(urlPrefix) || _PRIVATE_USER_SERVLET_MAPPING.equals(urlPrefix)) {
			privateLayout = true;
		} else {
			return LayoutConstants.DEFAULT_PLID;
		}

		Group group = null;

		try {
			group = GroupLocalServiceUtil.getFriendlyURLGroup(companyId, StringPool.SLASH + urlParts[2]);
		} catch (Exception e) {
		}

		if (group != null) {
			Layout layout = null;

			try {
				String layoutFriendlyURL = null;

				if (urlParts.length == 4) {
					layoutFriendlyURL = StringPool.SLASH + urlParts[3];
					layout = LayoutLocalServiceUtil.getFriendlyURLLayout(group.getGroupId(), privateLayout, layoutFriendlyURL);
				} else {
					List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(group.getGroupId(), privateLayout, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);
					for (Layout cur : layouts) {
						if (!cur.isHidden()) {
							layout = cur;
							break;
						}
					}
					if (layout == null)
						return LayoutConstants.DEFAULT_PLID;
				}
				return layout.getPlid();
			} catch (Exception e) {
			}
		}

		return LayoutConstants.DEFAULT_PLID;
	}

	/**
	 * Obtem a última URL acessada pelo usuário, antes da página de cadastro
	 * 
	 * @param req
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	public static long getUltimaPaginaVisitada() throws PortalException, SystemException {
		LiferayFacesContext facesContext = LiferayFacesContext.getInstance();
		long companyId = facesContext.getCompanyId();
		PortletRequest req = facesContext.getPortletRequest();

		LastPath lp = (LastPath) req.getPortletSession().getAttribute(WebKeys.LAST_PATH, PortletSession.APPLICATION_SCOPE);

		// Plid da página para onde redirecionar de volta: ou para a
		// página de onde veio
		// ou para a página incial
		long plid = LayoutConstants.DEFAULT_PLID;
		if (lp != null) {
			plid = getPlidFromFriendlyURL(companyId, lp.getContextPath() + lp.getPath());
			_log.info("PLID : " + plid + " lp " + lp.getContextPath() + lp.getPath());
		} else {
			_log.info("LP NULL");
		}

		// Página inicial
		if (plid == LayoutConstants.DEFAULT_PLID) {
			Group grupoGuest = GroupLocalServiceUtil.getGroup(companyId, GroupConstants.GUEST);
			try {
				Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(grupoGuest.getGroupId(), false, "/principal");
				plid = layout.getPlid();
			} catch (NoSuchLayoutException e) {
				plid = LayoutLocalServiceUtil.getDefaultPlid(grupoGuest.getGroupId(), false);
			}
		}
		return plid;
	}

	/**
	 * 
	 * @param user
	 * @param companyId
	 * @param plid
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 * @throws IOException
	 */
	public static void enviaEmailMudancaSenha(User user, long companyId, long plid, ServiceContext serviceContext) {

		try {
			Company company = CompanyLocalServiceUtil.getCompany(companyId);
			// Cria o ticket para mudança de senha
			PasswordPolicy passwordPolicy = user.getPasswordPolicy();
			Date expirationDate = new Date(System.currentTimeMillis() + (passwordPolicy.getResetTicketMaxAge() * 1000));

			Ticket ticket = TicketLocalServiceUtil.addTicket(companyId, User.class.getName(), user.getUserId(), TicketConstants.TYPE_PASSWORD, null,
			        expirationDate, serviceContext);

			String passwordResetURL = serviceContext.getPortalURL() + serviceContext.getPathMain() + "/portal/update_password?p_l_id=" + plid + "&ticketKey="
			        + ticket.getKey();

			// Altera para a porta 80
			if (passwordResetURL.startsWith("https"))
				passwordResetURL = UrlRewriterUtil.convertToHttp(passwordResetURL);

			String bodyText = ClassPathResourceUtil.loadResource("templates/admin/email_new_user_body.tmpl");
			String subjectText = ClassPathResourceUtil.loadResource("templates/admin/email_new_user_subject.tmpl");
			InternetAddress from;
			InternetAddress to;
			String toAddress = user.getEmailAddress();
			String toName = user.getFullName();
			String fromName = company.getAdminName();
			String fromAddress = company.getEmailAddress();

			// Constrói os endereços de email
			try {
				from = new InternetAddress(fromAddress, fromName);
				to = new InternetAddress(toAddress, toName);
			} catch (IOException e) {
				// Loga e retorna sem gerar o email
				_log.error("Erro ao gerar endereços", e);
				return;
			}

			bodyText = bodyText.replace("[$TO_NAME$]", toName);
			bodyText = bodyText.replace("[$PORTAL_URL$]", company.getVirtualHostname());
			bodyText = bodyText.replace("[$CONFIRM_URL$]", passwordResetURL);
			bodyText = bodyText.replace("[$TO_ADDRESS$]", toAddress);
			bodyText = bodyText.replace("[$USER_ID$]", String.valueOf(user.getUserId()));
			bodyText = bodyText.replace("[$USER_SCREENNAME$]", user.getScreenName());
			bodyText = bodyText.replace("[$FROM_NAME$]", fromName);
			bodyText = bodyText.replace("[$FROM_ADDRESS$]", fromAddress);

			subjectText = subjectText.replace("[$PORTAL_URL$]", company.getVirtualHostname());
			subjectText = subjectText.replace("[$TO_NAME$]", toName);
			subjectText = subjectText.replace("[$CONFIRM_URL$]", passwordResetURL);
			subjectText = subjectText.replace("[$TO_ADDRESS$]", toAddress);
			subjectText = subjectText.replace("[$USER_ID$]", String.valueOf(user.getUserId()));
			subjectText = subjectText.replace("[$USER_SCREENNAME$]", user.getScreenName());
			subjectText = subjectText.replace("[$FROM_NAME$]", fromName);
			subjectText = subjectText.replace("[$FROM_ADDRESS$]", fromAddress);

			MailMessage message = new MailMessage(from, to, subjectText, bodyText, true);

			MailServiceUtil.sendEmail(message);
		} catch (PortalException e) {
			_log.error("Erro ao enviar email de cadastro de usuário", e);
		} catch (SystemException e) {
			_log.error("Erro ao enviar email de cadastro de usuário", e);
		}
	}

	/**
	 * 
	 * @param user
	 * @param companyId
	 * @param plid
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 * @throws IOException
	 */
	public static void enviaEmailDescadastrar(User user, long companyId, String email, ServiceContext serviceContext) {

		try {
			Company company = CompanyLocalServiceUtil.getCompany(companyId);

			Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

			Ticket ticket = TicketLocalServiceUtil.addTicket(companyId, User.class.getName(), user.getUserId(), TicketConstants.TYPE_EMAIL_ADDRESS, null,
			        expirationDate, serviceContext);

//			LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
			String userUnregisterURLString = "";
			try{
				
				FacesContext facesContext = FacesContext.getCurrentInstance();
				PortletRequest portletRequest = (PortletRequest) facesContext.getExternalContext().getRequest();

				ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
				long groupId = themeDisplay.getLayout().getGroupId();

				long plid = PortalUtil.getPlidFromPortletId(groupId, UNREGISTER_USER_PORTLET_ID);
				PortletURL userUnregisterURL = PortletURLFactoryUtil.create(portletRequest, UNREGISTER_USER_PORTLET_NAME, plid, PortletRequest.RENDER_PHASE);
				
				
//				PortletURL userUnregisterURL = liferayFacesContext.createRenderURL();
		//			userUnregisterURL.addProperty("email", email);
//				userUnregisterURL.addProperty("ticketKey", ticket.getKey());
//				userUnregisterURL.addProperty("userId", Long.toString(user.getUserId()));
				userUnregisterURL.setParameter("ticketKey", ticket.getKey());
				userUnregisterURL.setParameter("paramUserId", Long.toString(user.getUserId()));
//				System.out.println(userUnregisterURL);
				userUnregisterURLString = userUnregisterURL.toString();
			} catch(Exception e) {
				System.out.println("Erro ao gerar link");
				e.printStackTrace();
			}
			
			String bodyText = ClassPathResourceUtil.loadResource("templates/admin/email_new_user_body.tmpl");
			String subjectText = ClassPathResourceUtil.loadResource("templates/admin/email_new_user_subject.tmpl");
			InternetAddress from;
			InternetAddress to;
			String toAddress = user.getEmailAddress();
			String toName = user.getFullName();
			String fromName = company.getAdminName();
			String fromAddress = company.getEmailAddress();

			// Constrói os endereços de email
			try {
				from = new InternetAddress(fromAddress, fromName);
				to = new InternetAddress(toAddress, toName);
			} catch (IOException e) {
				// Loga e retorna sem gerar o email
				_log.error("Erro ao gerar endereços", e);
				return;
			}

			bodyText = bodyText.replace("[$TO_NAME$]", toName);
			bodyText = bodyText.replace("[$PORTAL_URL$]", company.getVirtualHostname());
			bodyText = bodyText.replace("[$CONFIRM_URL$]", userUnregisterURLString.toString());
			bodyText = bodyText.replace("[$TO_ADDRESS$]", toAddress);
			bodyText = bodyText.replace("[$USER_ID$]", String.valueOf(user.getUserId()));
			bodyText = bodyText.replace("[$USER_SCREENNAME$]", user.getScreenName());
			bodyText = bodyText.replace("[$FROM_NAME$]", fromName);
			bodyText = bodyText.replace("[$FROM_ADDRESS$]", fromAddress);

			subjectText = subjectText.replace("[$PORTAL_URL$]", company.getVirtualHostname());
			subjectText = subjectText.replace("[$TO_NAME$]", toName);
			subjectText = subjectText.replace("[$CONFIRM_URL$]", userUnregisterURLString);
			subjectText = subjectText.replace("[$TO_ADDRESS$]", toAddress);
			subjectText = subjectText.replace("[$USER_ID$]", String.valueOf(user.getUserId()));
			subjectText = subjectText.replace("[$USER_SCREENNAME$]", user.getScreenName());
			subjectText = subjectText.replace("[$FROM_NAME$]", fromName);
			subjectText = subjectText.replace("[$FROM_ADDRESS$]", fromAddress);

			MailMessage message = new MailMessage(from, to, subjectText, bodyText, true);

			MailServiceUtil.sendEmail(message);
		} catch (PortalException e) {
			_log.error("Erro ao enviar email de cadastro de usuário", e);
		} catch (SystemException e) {
			_log.error("Erro ao enviar email de cadastro de usuário", e);
		}
	}
}
