package br.gov.camara.edemocracia.portlets.guiadiscussao.beans.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.portlet.PortletConfig;

import org.apache.commons.lang3.StringUtils;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.ConfiguracaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.util.BibliotecaImagensUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;

@ManagedBean(name = "bannerAdminBean")
@ViewScoped
public class BannerAdminBean implements Serializable {

	private static final long serialVersionUID = -3790226197232888263L;

	// Lista com imagens cadastradas na biblioteca de documentos
	private List<FileEntryDisplay> imagens;
	// Imagem da biblioteca selecionada pelo usuário
	private FileEntryDisplay imagemSelecionada;

	private String tituloBanner;
	private String textoBanner;

	// Utilizados para componente <componente:linkPainel/>
	private Boolean urlExterna;
	private String linkComunidade;
	private String linkExterno;

	@ManagedProperty(value = "#{configuracaoAdminBean}")
	private ConfiguracaoAdminBean configuracaoAdminBean;

	@PostConstruct
	private void init() {
		carregarImagensDaBiblioteca();
		carregarDadosBanner();
	}

	/**
	 * Carrega todas as imagens que estão cadastradas na biblioteca de
	 * documentos da comunidade
	 */
	private void carregarImagensDaBiblioteca() {
		imagens = new ArrayList<FileEntryDisplay>();
		long groupId = LiferayFacesContext.getInstance().getThemeDisplay()
				.getScopeGroupId();
		imagens = BibliotecaImagensUtil.getTodasImagensDaBiblioteca(groupId);

	}

	/**
	 * Carrega os dados do banner que estão cadastrados para esta configuracao
	 * 
	 * @param config
	 */
	public void carregarDadosBanner() {

		Configuracao config = configuracaoAdminBean.getConfig();
		if (config.getImagemIdBanner() != 0) {
			try {
				imagemSelecionada = BibliotecaImagensUtil
						.getFileEntryDisplay(config.getImagemIdBanner());
			} catch (PortalException e) {
				imagemSelecionada = BibliotecaImagensUtil
						.getImagemPadraoBanner();
			}

		}

		tituloBanner = config.getTituloBanner();
		textoBanner = config.getTextoBanner();
		urlExterna = Boolean.valueOf(config.getUrlExterna());

		// Carregando dados do link externo
		if (urlExterna) {
			linkExterno = config.getUrlBanner();
			linkComunidade = "";
		} else {
			linkComunidade = config.getUrlBanner();
			linkExterno = "";
		}

	}

	public void salvarBanner() {
		if (validarDados()) {
			if (configuracaoAdminBean.getConfig().getConfiguracaoId() != 0) {
				Configuracao configuracaoAtual = configuracaoAdminBean
						.getConfig();
				configuracaoAtual.setImagemIdBanner(imagemSelecionada
						.getFileEntryId());
				configuracaoAtual.setTextoBanner(textoBanner);
				configuracaoAtual.setTituloBanner(tituloBanner);
				configuracaoAtual.setUrlExterna(urlExterna);

				// Tratamento de qual url salvar
				if (urlExterna) {
					configuracaoAtual.setUrlBanner(linkExterno);
				} else {
					configuracaoAtual.setUrlBanner(linkComunidade);
				}

				try {
					ConfiguracaoLocalServiceUtil.updateConfiguracao(
							configuracaoAdminBean.getConfig(), true);
				} catch (SystemException e) {
					throw new RuntimeException(e);
				}

			}
		}
		configuracaoAdminBean.atualizaConfiguracao();
	}

	/**
	 * Valida os dados obrigatórios do banner
	 * 
	 * @return
	 */
	private boolean validarDados() {

		Locale locale = LiferayFacesContext.getInstance().getLocale();
		PortletConfig config = LiferayFacesContext.getInstance()
				.getPortletConfig();
		boolean dadosOk = true;

		if (StringUtils.isBlank(tituloBanner)) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					LanguageUtil.get(config, locale,
							"titulo-banner-obrigatorio"));
			dadosOk = false;
		}

		if (StringUtils.isBlank(textoBanner)) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					LanguageUtil.get(config, locale,
							"descricao-banner-obrigatorio"));
			dadosOk = false;
		}

		if (urlExterna) {
			if (StringUtils.isBlank(linkExterno)) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(
						"digite-url-externa");
				dadosOk = false;
			}
		}

		return dadosOk;
	}

	public List<FileEntryDisplay> getImagens() {
		return imagens;
	}

	public FileEntryDisplay getImagemSelecionada() {
		return imagemSelecionada;
	}

	public void setImagemSelecionada(FileEntryDisplay imagemSelecionada) {
		this.imagemSelecionada = imagemSelecionada;
	}

	public Boolean getUrlExterna() {
		return urlExterna;
	}

	public void setUrlExterna(Boolean urlExterna) {
		this.urlExterna = urlExterna;
	}

	public String getLinkExterno() {
		return linkExterno;
	}

	public void setLinkExterno(String linkExterno) {
		this.linkExterno = linkExterno;
	}

	public String getLinkComunidade() {
		return linkComunidade;
	}

	public void setLinkComunidade(String linkComunidade) {
		this.linkComunidade = linkComunidade;
	}

	public String getTituloBanner() {
		return tituloBanner;
	}

	public void setTituloBanner(String tituloBanner) {
		this.tituloBanner = tituloBanner;
	}

	public String getTextoBanner() {
		return textoBanner;
	}

	public void setTextoBanner(String textoBanner) {
		this.textoBanner = textoBanner;
	}

	public ConfiguracaoAdminBean getConfiguracaoAdminBean() {
		return configuracaoAdminBean;
	}

	public void setConfiguracaoAdminBean(
			ConfiguracaoAdminBean configuracaoAdminBean) {
		this.configuracaoAdminBean = configuracaoAdminBean;
	}
}
