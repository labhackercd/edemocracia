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
package br.gov.camara.edemocracia.portlets.cadastrousuarios.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import br.gov.camara.edemocracia.portlets.libs.Biblioteca;
import br.gov.camara.edemocracia.portlets.libs.Validacao;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthException;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.service.persistence.AddressUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.announcements.model.AnnouncementsDelivery;
import com.liferay.portlet.announcements.service.AnnouncementsDeliveryLocalServiceUtil;
import com.liferay.portlet.announcements.service.persistence.AnnouncementsDeliveryUtil;

/**
 * @author p_7339
 * 
 */
@ManagedBean(name = "cadastro")
@RequestScoped
public class CadastroBean {

	private String nome;

	private String email;
	// Confirmação do e-mail
	private String email2;

	private String senha;
	// Confirmação da senha do usuário
	private String senha2;

	private Long uf;
	private boolean aceiteTermosUso;
	private String captchaText;

	private boolean cadastroCompleto;

	private static final Log _log = LogFactoryUtil.getLog(CadastroBean.class);
	private static final String tokenDadosDoForm = "DADOS_FORM_SUPPORT";
	private static final String tokenCadastroCompleto = "C_C";

	private static final String NAMESPACE_SERVLET_REQUEST_FQCN = "com.liferay.portal.servlet.NamespaceServletRequest";

	@PostConstruct
	private void init() {
		carregarERemoverDadosDoFormDaSessao();
		verificarSeCadastroCompleto();

	}

	public void cadastrar() {
		LiferayFacesContext facesContext = LiferayFacesContext.getInstance();
		long companyId = facesContext.getCompanyId();

		Validacao validacao = Biblioteca.validarCampos(companyId, nome, email, email2, senha, senha2, aceiteTermosUso, uf, captchaText);
		boolean dadosValidos = validacao.getValidar();
		boolean cadastradoComSucesso = false;

		if (dadosValidos) {
			cadastrarUsuario();
			cadastradoComSucesso = true;

		} else {
			// Adicionando as mensagens de erro de validação
			for (String msg : validacao.getMensagem()) {
				adicionarMensagemDeErro(msg);
			}

			salvarDadosDoFormNaSessao();
		}

		redirecionarParaURLDeOrigemViaHTTP(cadastradoComSucesso);
	}

	private void redirecionarParaURLDeOrigemViaHTTP(boolean cadastradoComSucesso) {
		try {
			LiferayFacesContext facesContext = LiferayFacesContext.getInstance();
			String layoutURL = PortalUtil.getLayoutURL(facesContext.getThemeDisplay());
			String portalURL = facesContext.getThemeDisplay().getPortalURL();

			// Para ambiente local usar esse redirect...
//			final String defaultLocalRedirectURL = portalURL + layoutURL;

			// Para ambiente de produção usar este redirect...
			final String defaultProductionRedirectURL = layoutURL;
			
			String defaultRedirect = defaultProductionRedirectURL; 

			String redirect = StringPool.BLANK;

			if (isLastPathEnabled() && cadastradoComSucesso) {

				String lastPath = getLastPath();

				if (lastPath != null) {
					boolean autenticado = tentarAutenticar();
					if (autenticado) {
						redirect = portalURL + lastPath;
					} else {
						redirect = defaultRedirect;
					}

				} else {
					redirect = defaultRedirect;
				}

			} else {
				redirect = defaultRedirect + "?saveLastPath=0";
			}

			limparDadosDoBean();

			facesContext.getExternalContext().redirect(redirect);

		} catch (SystemException e) {
			_log.error("Erro ao redirecionar para HTTP", e);
			adicionarMensagemDeErro("falha-redirecionamento");
		} catch (IOException e) {
			_log.error("Erro ao redirecionar para HTTP", e);
			adicionarMensagemDeErro("falha-redirecionamento");
		} catch (PortalException e) {
			_log.error("Erro ao redirecionar para HTTP", e);
			adicionarMensagemDeErro("falha-redirecionamento");
		}
	}

	private boolean tentarAutenticar() {
		MethodKey method = new MethodKey("com.liferay.portlet.login.util.LoginUtil", "login", new Class[] { HttpServletRequest.class,
				HttpServletResponse.class, String.class, String.class, boolean.class, String.class });

		ActionRequest request = (ActionRequest) LiferayFacesContext.getInstance().getPortletRequest();
		ActionResponse response = (ActionResponse) LiferayFacesContext.getInstance().getPortletResponse();
		HttpServletRequest httpServletRequest = getHttpServletRequest(request);

		try {
			PortalClassInvoker.invoke(false, method, httpServletRequest, PortalUtil.getHttpServletResponse(response), email, senha, false,
					CompanyConstants.AUTH_TYPE_EA);

			PortletSession session = request.getPortletSession(false);
			if (session != null)
				session.removeAttribute("email");

			return true;

		} catch (Exception e) {
			if (e instanceof AuthException) {
				Throwable cause = e.getCause();
				if (cause != null)
					SessionErrors.add(request, cause.getClass());
				else
					SessionErrors.add(request, e.getClass());
			} else {
				SessionErrors.add(request, e.getClass());
			}
			return false;
		}
	}

	private String getLastPath() {
		PortletRequest request = LiferayFacesContext.getInstance().getPortletRequest();
		LastPath lp = getLastPath(request);

		if (lp != null) {
			return lp.getContextPath() + lp.getPath();
		} else {
			return null;
		}
	}

	private LastPath getLastPath(PortletRequest request) {
		HttpServletRequest httpServletRequest = getHttpServletRequest(request);
		return (LastPath) httpServletRequest.getSession().getAttribute("LAST_PATH");
	}
	
	private boolean isLastPathEnabled() {
		String saveLastPath = PropsUtil.get(PropsKeys.AUTH_FORWARD_BY_LAST_PATH);
		return saveLastPath != null ? Boolean.parseBoolean(saveLastPath) : false;
	}

	public HttpServletRequest getHttpServletRequest(PortletRequest portletRequest) {

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);

		// If the request object is a wrapper that handles special namespacing considerations for portlet session
		// attributes, then get the inner-most wrapped request. This will ensure that the following call to
		// LoginUtil.login(...) will be able to work with a session that has an attribute map shared by the portal.
		if (httpServletRequest.getClass().getName().equals(NAMESPACE_SERVLET_REQUEST_FQCN)) {

			while (httpServletRequest instanceof HttpServletRequestWrapper) {
				HttpServletRequestWrapper httpServletRequestWrapper = (HttpServletRequestWrapper) httpServletRequest;
				httpServletRequest = (HttpServletRequest) httpServletRequestWrapper.getRequest();
			}
		}
		
		return httpServletRequest;
	}

	private void cadastrarUsuario() {
		LiferayFacesContext facesContext = LiferayFacesContext.getInstance();
		String primeiroNome = Biblioteca.retornaPrimeiro(nome);
		String meioNome = Biblioteca.retornaMeio(nome);
		String ultimoNome = Biblioteca.retornaUltima(nome);

		User user;
		long companyId = facesContext.getCompanyId();

		try {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), facesContext.getPortletRequest());

			user = UserServiceUtil.addUser(companyId, false, senha, senha, true, null, email, 0, "", LocaleUtil.getDefault(), primeiroNome, meioNome,
					ultimoNome, 0, 0, true, 1, 1, 1970, "", null, null, null, null, false, serviceContext);

			criarEnderecoParaUsuario(companyId, user);

			// inclusão de email para anúncios e alertas.
			String[] listaAnuncios = PropsUtil.getArray(PropsKeys.ANNOUNCEMENTS_ENTRY_TYPES);
			List<String> lista = new ArrayList<String>();

			for (String cont : listaAnuncios) {
				if (!lista.contains(cont))
					lista.add(cont);
			}

			for (String anuncioValor : lista) {
				AnnouncementsDelivery announcementsDelivery = AnnouncementsDeliveryUtil.create(CounterLocalServiceUtil.increment(AnnouncementsDelivery.class
						.getName()));
				announcementsDelivery.setCompanyId(companyId);
				announcementsDelivery.setUserId(user.getUserId());
				announcementsDelivery.setType(anuncioValor);
				announcementsDelivery.setEmail(true);

				AnnouncementsDeliveryLocalServiceUtil.addAnnouncementsDelivery(announcementsDelivery);
			}

			// Envia o e-mail para a mudança de senha
			LiferayCadastroUtil.enviaEmailDescadastrar(user, companyId, email, serviceContext);

			// limparDadosDoBean();

			adicionarMensagemDeSucesso("cadastro-sucesso");

			getSessionMap().put(tokenCadastroCompleto, true);

		} catch (PortalException e) {
			_log.error("Erro ao cadastrar usuário", e);
			adicionarMensagemDeErro("cadastro-falha");

		} catch (SystemException e) {
			_log.error("Erro ao cadastrar usuário", e);
			adicionarMensagemDeErro("cadastro-falha");
		}
	}

	private Address criarEnderecoParaUsuario(Long companyId, User usuario) throws SystemException {

		Address address = AddressUtil.create(CounterLocalServiceUtil.increment(Address.class.getName()));

		address.setCompanyId(companyId);
		address.setCity("-");
		address.setStreet1("-");
		address.setZip("-");
		address.setPrimary(true);
		address.setMailing(false);
		address.setCountryId(48);
		address.setRegionId(uf);
		address.setUserId(usuario.getUserId());
		address.setUserName(usuario.getFullName());
		address.setCreateDate(new Date());
		address.setModifiedDate(new Date());
		address.setTypeId(11000);

		// Relacionamento com o contato
		address.setClassPK(usuario.getContactId());
		address.setClassNameId(PortalUtil.getClassNameId(Contact.class.getName()));

		return AddressLocalServiceUtil.addAddress(address);
	}

	public List<SelectItem> getUfs() {
		ArrayList<SelectItem> retorno = new ArrayList<SelectItem>();

		try {
			long brasilId = CountryServiceUtil.getCountryByA2("BR").getCountryId();

			List<Region> regioes = RegionServiceUtil.getRegions(brasilId);
			for (Region regiao : regioes) {
				retorno.add(new SelectItem(regiao.getRegionId(), regiao.getName()));
			}
		} catch (PortalException e) {
			_log.error("Erro ao obter regiões", e);
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
		return retorno;
	}

	private void limparDadosDoBean() {
		nome = "";
		email = "";
		email2 = "";
		senha = "";
		senha2 = "";
		captchaText = "";
		aceiteTermosUso = false;
		uf = null;
	}

	/**
	 * Este método foi necessário devido a perda dos dados preenchidos pelo
	 * usuário ao fazer o redirect de volta para http
	 */
	private void salvarDadosDoFormNaSessao() {

		Map<String, String> dados = new HashMap<String, String>();
		dados.put("nome", nome);
		dados.put("email", email);
		dados.put("email2", email2);
		dados.put("uf", uf != null ? uf.toString() : null);
		dados.put("termosDeUso", Boolean.toString(aceiteTermosUso));

		getSessionMap().put(tokenDadosDoForm, dados);
	}

	private void carregarERemoverDadosDoFormDaSessao() {

		@SuppressWarnings("unchecked")
		Map<String, String> dados = (Map<String, String>) getSessionMap().remove(tokenDadosDoForm);

		if (dados != null && !dados.isEmpty()) {
			this.nome = dados.get("nome");
			this.email = dados.get("email");
			this.email2 = dados.get("email2");
			this.aceiteTermosUso = Boolean.valueOf(dados.get("termosDeUso"));
			String uf = dados.get("uf");
			if (uf != null) {
				this.uf = Long.parseLong(uf);
			}
		}

	}

	private void verificarSeCadastroCompleto() {
		Object object = getSessionMap().remove(tokenCadastroCompleto);
		if (object != null) {
			cadastroCompleto = Boolean.parseBoolean(object.toString());
		}
	}

	private void adicionarMensagemDeErro(String key) {
		LiferayFacesContext facesContext = LiferayFacesContext.getInstance();
		facesContext.addGlobalErrorMessage(LanguageUtil.get(facesContext.getPortletConfig(), facesContext.getLocale(), key));
	}

	private void adicionarMensagemDeSucesso(String key) {
		LiferayFacesContext facesContext = LiferayFacesContext.getInstance();
		facesContext.addGlobalInfoMessage(LanguageUtil.get(facesContext.getPortletConfig(), facesContext.getLocale(), key));
	}

	private Map<String, Object> getSessionMap() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	public Long getUf() {
		return uf;
	}

	public void setUf(Long uf) {
		this.uf = uf;
	}

	public String getCaptchaText() {
		return captchaText;
	}

	public void setCaptchaText(String captchaText) {
		this.captchaText = captchaText;
	}

	public boolean isAceiteTermosUso() {
		return aceiteTermosUso;
	}

	public void setAceiteTermosUso(boolean aceiteTermosUso) {
		this.aceiteTermosUso = aceiteTermosUso;
	}

	public boolean isCadastroCompleto() {
		return cadastroCompleto;
	}

}
