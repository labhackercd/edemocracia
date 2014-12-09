package br.gov.camara.edemocracia.portlets.cadastrousuarios.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang.StringUtils;

import br.gov.camara.edemocracia.portlets.libs.Biblioteca;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.TicketLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;

@ManagedBean(name = "descadastro")
@RequestScoped
public class DescadastrarBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// http://SERVER_NAME/c/portal/logout
	private static final String URL_LOGOUT = "/c/portal/logout";
	private static final String URL_HOME = "/web/public/home";

	private static final Log _log = LogFactoryUtil.getLog(DescadastrarBean.class);

	private static final long ID_USER_DEFAULT = 10134;

	@ManagedProperty("#{param.ticketKey}")
	private String ticketKey;

	@ManagedProperty("#{param.paramUserId}")
	private String paramUserId;

	private String nomeUsuario;

	@ManagedProperty("#{param.email}")
	private String email;

	private String captchaText;

	private Boolean mostrarConfirmacao;

	private Boolean mostrarMensagemLogout;

	private boolean usuarioCadastrado;

	private boolean emailEnviadoParaUsuario;

	@PostConstruct
	public void init() {

		try {
			if (paramUserId != null) {
				Long userId = new Long(this.paramUserId);
				User user = UserServiceUtil.getUserById(userId);
				email = user.getEmailAddress();
				nomeUsuario = user.getFirstName();
				mostrarConfirmacao = false;
				mostrarMensagemLogout = false;
				if (ticketKey != null && !ticketKey.equals("")) {
					if (isLoggedIn()) {
						mostrarMensagemLogout = true;
					} else {
						mostrarConfirmacao = true;
					}
				}
				usuarioCadastrado = true;

			} else {
				nomeUsuario = "Usuário";
			}

		} catch (NoSuchUserException e) {
			_log.warn("Usuário não encontrado com a chave primária ." + paramUserId, e);
			adicionarMensagemDeErro("Erro ao recuperar dados.");
		} catch (PortalException e) {
			_log.error("Ocorreu um erro ao inicializar dados.", e);
			adicionarMensagemDeErro("Erro ao recuperar dados");

		} catch (SystemException e) {
			_log.error("Ocorreu um erro ao inicializar dados.", e);
			adicionarMensagemDeErro("Erro ao recuperar dados");
		}

	}

	public void enviaEmail() {

		boolean emailValido = validarEmail(email);
		boolean captchaValido = validarCaptcha(captchaText);

		if (emailValido && captchaValido) {

			try {

				long companyId = LiferayFacesContext.getInstance().getCompanyId();
				User user = UserServiceUtil.getUserByEmailAddress(companyId, email);
				ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), LiferayFacesContext.getInstance().getPortletRequest());
				LiferayCadastroUtil.enviaEmailDescadastrar(user, companyId, email, serviceContext);
				adicionarMensagemDeSucesso("Email enviado. Por favor cheque sua caixa de entrada para continuar com o processo de descadastramento.");

				emailEnviadoParaUsuario = true;

			} catch (NoSuchUserException e) {
				_log.warn("Usuário não encontrado com o email: " + email, e);
				adicionarMensagemDeErro("Erro ao recuperar dados.");
			} catch (PortalException e) {
				_log.error("Ocorreu um erro ao enviar email para: " + email, e);
				adicionarMensagemDeErro("Erro ao recuperar dados.");
			} catch (SystemException e) {
				_log.error("Ocorreu um erro ao enviar email para: " + email, e);
				adicionarMensagemDeErro("Erro ao recuperar dados.");
			}

		} else {
			captchaText = "";
		}
	}

	private boolean validarCaptcha(String captchaText) {

		if (StringUtils.isBlank(captchaText)) {
			adicionarMensagemDeErro("Digite o captcha.");
			return false;
		} else if (!Biblioteca.validarCaptcha(captchaText)) {
			adicionarMensagemDeErro(" Captcha inválido. Digite novamente.");
			return false;
		} else {
			return true;
		}

	}

	private boolean validarEmail(String email) {
		if (StringUtils.isBlank(email)) {
			adicionarMensagemDeErro("Informe o e-mail.");
			return false;

		} else if (!Biblioteca.validarEmail(email)) {
			adicionarMensagemDeErro("E-mail inválido.");
			return false;
		} else {
			return true;
		}
	}

	public void descadastrar() {
		try {
			Long userId = new Long(this.paramUserId);
			User user = UserServiceUtil.getUserById(userId);
			Ticket ticket = TicketLocalServiceUtil.getTicket(ticketKey);
			if (userId == user.getUserId()) {
				if (isLoggedIn()) {
					logout();
				}
				deletaUsuario(user);
				TicketLocalServiceUtil.deleteTicket(ticket);

			}

			adicionarMensagemDeSucesso("Você foi descadastrado do portal edemocracia.");
			usuarioCadastrado = false;

		} catch (PortalException e) {
			_log.error("Ocorreu um erro ao descadastrar usuário.", e);
			adicionarMensagemDeErro("Ocorreu um erro ao descadastrar usuário");
		} catch (SystemException e) {
			_log.error("Ocorreu um erro ao descadastrar usuário.", e);
			adicionarMensagemDeErro("Ocorreu um erro ao descadastrar usuário");
		} catch (Exception e) {
			_log.error("Ocorreu um erro ao descadastrar usuário.", e);
			adicionarMensagemDeErro("Ocorreu um erro ao descadastrar usuário");
		}
	}

	private boolean isLoggedIn() {
		try {
			Long userId = new Long(Long.toString(LiferayFacesContext.getInstance().getUserId()));
			if (userId == ID_USER_DEFAULT) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private void logout() throws IOException {
		LiferayFacesContext.getInstance().getExternalContext().redirect(URL_LOGOUT);
	}

	private void deletaUsuario(User user) throws SystemException {
		try {
			UserLocalServiceUtil.deleteUser(user.getUserId());
		} catch (PortalException e) {
			adicionarMensagemDeErro("Erro ao descadastrar usuário");
			_log.error("Erro ao deletar usuário.", e);
		}
	}

	public void voltarParaHome() {
		try {
			LiferayFacesContext.getInstance().getExternalContext().redirect(URL_HOME);
		} catch (IOException e) {
			_log.error("Ocorreu um erro ao redirecionar para home page.", e);
		}
	}

	private void adicionarMensagemDeErro(String mensagem) {
		LiferayFacesContext.getInstance().addGlobalErrorMessage(mensagem);
	}

	private void adicionarMensagemDeSucesso(String mensagem) {
		LiferayFacesContext.getInstance().addGlobalInfoMessage(mensagem);
	}

	public String getCaptchaText() {
		return captchaText;
	}

	public void setCaptchaText(String captchaText) {
		this.captchaText = captchaText;
	}

	public Boolean getMostrarConfirmacao() {
		return mostrarConfirmacao;
	}

	public void setMostrarConfirmacao(Boolean mostrarConfirmacao) {
		this.mostrarConfirmacao = mostrarConfirmacao;
	}

	public Boolean getMostrarMensagemLogout() {
		return mostrarMensagemLogout;
	}

	public void setMostrarMensagemLogout(Boolean mostrarMensagemLogout) {
		this.mostrarMensagemLogout = mostrarMensagemLogout;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getTicketKey() {
		return ticketKey;
	}

	public void setTicketKey(String ticketKey) {
		this.ticketKey = ticketKey;
	}

	public String getEmail() {
		return email;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParamUserId() {
		return paramUserId;
	}

	public void setParamUserId(String userId) {
		this.paramUserId = userId;
	}

	public boolean isUsuarioCadastrado() {
		return usuarioCadastrado;
	}

	public boolean isEmailEnviadoParaUsuario() {
		return emailEnviadoParaUsuario;
	}

}
