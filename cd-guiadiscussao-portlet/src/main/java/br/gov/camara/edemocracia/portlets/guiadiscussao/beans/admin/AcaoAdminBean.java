package br.gov.camara.edemocracia.portlets.guiadiscussao.beans.admin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.portlet.PortletConfig;

import org.apache.commons.lang3.StringUtils;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.AcaoImpl;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.AcaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.util.BibliotecaImagensUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean(name = "acaoAdminBean")
@ViewScoped
public class AcaoAdminBean implements Serializable {

	private static final long serialVersionUID = 6480110332533932448L;
	private Acao acao;

	// Utilizados para componente <componente:linkPainel/>
	private Boolean urlExterna;
	private String linkComunidade;
	private String linkExterno;

	private List<FileEntryDisplay> icones;
	private FileEntryDisplay iconeSelecionado;

	@ManagedProperty(value = "#{faseAdminBean}")
	private FaseAdminBean faseAdmin;

	private static final Log LOG = LogFactoryUtil.getLog(AcaoAdminBean.class);

	public AcaoAdminBean() {
		this.acao = new AcaoImpl();
	}

	@PostConstruct
	private void init() {
		carregarIconesDaBiblioteca();
	}

	public void novaAcao(Long faseId) {
		this.acao = new AcaoImpl();
		this.acao.setFaseId(faseId);
		this.urlExterna = Boolean.FALSE;
		this.linkComunidade = "";
		this.linkExterno = "";
		this.iconeSelecionado = null;
	}

	public void editarAcao() {
		Long acaoId = Long.parseLong(LiferayFacesContext.getInstance()
				.getRequestParameter("acaoId"));

		try {
			Acao acao = AcaoLocalServiceUtil.getAcao(acaoId);
			if (acao == null) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(
						"#{i18n['acao-nao-encontrada']}");
			} else {
				this.acao = acao;
				this.urlExterna = this.acao.getUrlExterna();
				if (this.acao.getUrlExterna()) {
					this.linkExterno = acao.getUrlLink();
					this.linkComunidade = "";
				} else {
					this.linkComunidade = acao.getUrlLink();
					this.linkExterno = "";
				}
				long iconeId = acao.getIconeId();
				if (iconeId != 0) {
					try {
						FileEntryDisplay icone = BibliotecaImagensUtil
								.getFileEntryDisplay(iconeId);
						iconeSelecionado = icone;
					} catch (PortalException e) {
						iconeSelecionado = BibliotecaImagensUtil
								.getImagemPadrao();
					}
				}
			}

		} catch (PortalException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"#{i18n['acao-nao-encontrada']}");
			LOG.error("Erro ao editar ação.Ação não encontrada.", e);
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

	}

	public void salvarAcao() {

		if(validarDados()){

			acao.setUrlExterna(urlExterna);
			if (urlExterna) {
				acao.setUrlLink(linkExterno);
			} else {
				acao.setUrlLink(linkComunidade);
			}
	
			acao.setIconeId(iconeSelecionado.getFileEntryId());
	
			try {
				if (this.acao.getAcaoId() == 0) {
					AcaoLocalServiceUtil.addAcao(acao);
				} else {
					AcaoLocalServiceUtil.updateAcao(acao, true);
				}
	
			} catch (SystemException e) {
				throw new RuntimeException(e);
			}
	
			this.acao = new AcaoImpl();
			urlExterna = false;
			linkExterno = "";
			linkComunidade = "";
			this.iconeSelecionado = null;
			faseAdmin.atualizaFases();
		
		}
	}

	public String excluirAcao() {

		Long acaoId = Long.parseLong(LiferayFacesContext.getInstance()
				.getRequestParameter("acaoId"));

		try {
			Acao acao = AcaoLocalServiceUtil.getAcao(acaoId);
			if (acao != null) {
				AcaoLocalServiceUtil.excluirAcao(acao.getAcaoId());
				LiferayFacesContext.getInstance().addGlobalInfoMessage(
						"#{i18n['acao-excluida-sucesso']}");
			} else {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(
						"#{i18n['acao-nao-encontrada']}");
			}

		} catch (PortalException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					"#{i18n['acao-nao-encontrada']}");
			LOG.error("Erro ao excluir ação.", e);
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

		faseAdmin.atualizaFases();

		// Força a reconstrução da árvore e componentes
		return "index?faces-redirect=true";
	}

	/**
	 * Salva a ordem das ações da fase selecionada
	 */
	public void salvarOrdenacao() {

		DadosFaseDisplay dadosFase = faseAdmin.getDadosFaseSelecionada();

		// Mapeando da nova ordenação
		int ordem = 1;
		Map<Long, Integer> novaOrdenacao = new HashMap<Long, Integer>();
		for (Acao acao : dadosFase.getAcoes()) {
			novaOrdenacao.put(acao.getAcaoId(), ordem);
			ordem++;
		}
		try {
			AcaoLocalServiceUtil.atualizarOrdenacaoDasAcoes(dadosFase.getFase()
					.getFaseId(), novaOrdenacao);
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}

		faseAdmin.atualizaFases();
	}

	/**
	 * Retorna url da imagem
	 * 
	 * @return
	 */
	public String getUrlIconeAcao(long iconeId) {
		return BibliotecaImagensUtil.getUrlImagem(iconeId);
	}

	private void carregarIconesDaBiblioteca() {
		this.icones = BibliotecaImagensUtil.getTodosIconesAcoes();
	}
	
	/**
	 * Valida os dados obrigatórios da ação
	 * @return
	 */
	private boolean validarDados() {
		Locale locale = LiferayFacesContext.getInstance().getLocale();
		PortletConfig config = LiferayFacesContext.getInstance()
				.getPortletConfig();
		boolean dadosOk = true;

		if (urlExterna) {
			if (StringUtils.isBlank(linkExterno)) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage(
						"digite-url-externa");
				dadosOk = false;
			}
		}

		if (StringUtils.isBlank(acao.getTexto())) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage(
					LanguageUtil.get(config, locale, "texto-acao-obrigatorio"));
			dadosOk = false;
		}

		return dadosOk;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public FaseAdminBean getFaseAdmin() {
		return faseAdmin;
	}

	public void setFaseAdmin(FaseAdminBean faseAdmin) {
		this.faseAdmin = faseAdmin;
	}

	public String getLinkComunidade() {
		return linkComunidade;
	}

	public void setLinkComunidade(String linkComunidade) {
		this.linkComunidade = linkComunidade;
	}

	public String getLinkExterno() {
		return linkExterno;
	}

	public void setLinkExterno(String linkExterno) {
		this.linkExterno = linkExterno;
	}

	public Boolean getUrlExterna() {
		return urlExterna;
	}

	public void setUrlExterna(Boolean urlExterna) {
		this.urlExterna = urlExterna;
	}

	public List<FileEntryDisplay> getIcones() {
		return icones;
	}

	public void setIcones(List<FileEntryDisplay> icones) {
		this.icones = icones;
	}

	public FileEntryDisplay getIconeSelecionado() {
		return iconeSelecionado;
	}

	public void setIconeSelecionado(FileEntryDisplay iconeSelecionado) {
		this.iconeSelecionado = iconeSelecionado;
	}

}