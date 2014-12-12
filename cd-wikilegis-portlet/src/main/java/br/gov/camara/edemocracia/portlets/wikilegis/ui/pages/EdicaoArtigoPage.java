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
package br.gov.camara.edemocracia.portlets.wikilegis.ui.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;
import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.components.ArtigoLabel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.components.EstruturaLabel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.model.PosicaoArtigo;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.PosicaoArtigoPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.WikiLegisMenuPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.ActionKeys;

/**
 * @author robson
 * 
 */
public class EdicaoArtigoPage extends WebPage {

	private static final Log LOG = LogFactoryUtil.getLog(EdicaoArtigoPage.class);

	private Artigo getModelObject() {
		return (Artigo) getDefaultModelObject();
	}

	/**
	 * Constrói a página de edição
	 * 
	 * @param pp
	 */
	public EdicaoArtigoPage(PageParameters pp) {
		super(pp);

		final long idArtigo = pp.getAsLong("0", 0l);
		if (idArtigo == 0l)
			throw new RestartResponseException(NovoArtigoPage.class);

		// Verifica se pode editar
		if (!UIUtils.possuiPermissoes(ActionKeys.CONFIGURATION))
			throw new RestartResponseException(HomePage.class);

		Artigo artigo;
		try {
			artigo = WikiLegisServiceUtil.getArtigo(idArtigo);
		} catch (PortalException e) {
			throw new RestartResponseException(HomePage.class);
		} catch (SystemException e) {
			// TODO Log
			throw new RuntimeException("Unable to get article");
		}
		IModel<Artigo> modelo = new LoadableDetachableModel<Artigo>(artigo) {

			@Override
			protected Artigo load() {
				try {
					return WikiLegisServiceUtil.getArtigo(idArtigo);
				} catch (Exception e) {
					// TODO Log
					throw new RuntimeException("Unable to get article");
				}
			}
		};
		setDefaultModel(modelo);
		init();
	}

	private Form<Void> form;
	private ArtigoLabel artigoLabel;
	private EstruturaLabel estruturaLabel;
	private TextArea<String> textoArtigo;
	private TextArea<String> legislacaoVigente;
	private PosicaoArtigoPanel posicaoArtigo;

	private void init() {

		initMenuWikilegis();
		initLabelArtigo();
		initLabelLegislacaoVigente();
		initForm();
		initTextoTextArea();
		initLegislacaoVigente();
		initPosicaoArtigo();
		initEnviarButton();
		initExcluirButton();
		initCancelarButton();
	}

	private void initMenuWikilegis() {
		add(new WikiLegisMenuPanel("menuWikilegis"));
	}

	private void initForm() {
		form = new Form<Void>("form") {
			/**
			 * Realizar validações
			 */
			@Override
			protected void onSubmit() {
				gravaAlteracoes();
			}
		};
		add(form);
	}

	private void initLabelArtigo() {
		// String texto = getModelObject() != null ?
		// getModelObject().getTexto(): "";
		artigoLabel = new ArtigoLabel("labelArtigo", new ComponentPropertyModel<String>("texto"), true);
		add(artigoLabel);

	}

	private void initLabelLegislacaoVigente() {
		estruturaLabel = new EstruturaLabel("labelLegislacao", new ComponentPropertyModel<String>("legislacaoVigente"));
		add(estruturaLabel);
	}

	private void initTextoTextArea() {
		String texto = getModelObject() != null ? getModelObject().getTexto() : "";
		textoArtigo = new TextArea<String>("textoArtigo", Model.of(texto));
		textoArtigo.setOutputMarkupId(true);
		form.add(textoArtigo);
	}

	private void initLegislacaoVigente() {
		String texto = getModelObject() != null ? getModelObject().getLegislacaoVigente() : "";
		legislacaoVigente = new TextArea<String>("legislacaoVigente", Model.of(texto));
		legislacaoVigente.setOutputMarkupId(true);
		form.add(legislacaoVigente);
	}

	private void initPosicaoArtigo() {
		PosicaoArtigo posicao;
		Artigo artigo = getModelObject();
		if (artigo == null) {
			posicao = new PosicaoArtigo(0l, 0l);
		} else {
			posicao = new PosicaoArtigo(artigo.getEstruturaId(), artigo.getArtigoId());
		}
		posicaoArtigo = new PosicaoArtigoPanel("posicao", new Model<PosicaoArtigo>(posicao), artigo.getArtigoId());
		form.add(posicaoArtigo);
	}

	private void initEnviarButton() {
		form.add(new Button("enviar"));
	}
	
	/**
	 * Exclui um artigo
	 */
	private void initExcluirButton() {
		Button btn = new Button("excluir") {
			@Override
			public void onSubmit() {
				try {
					WikiLegisServiceUtil.excluiArtigo(EdicaoArtigoPage.this.getModelObject().getArtigoId());
				} catch (Exception e) {
					LOG.error("Erro ao excluir artigo", e);
				}
				setResponsePage(HomePage.class);
				setRedirect(true);
			}
		};
		btn.setDefaultFormProcessing(false);
		form.add(btn);
	}

	private void initCancelarButton() {
		form.add(new BookmarkablePageLink<HomePage>("cancelar", HomePage.class));
	}

	// //////////////////////////////
	//
	// //////////////////////////////
	private void gravaAlteracoes() {
		Artigo artigo = getModelObject();
		String texto = textoArtigo.getModelObject();
		String emVigor = legislacaoVigente.getModelObject();
		PosicaoArtigo posicao = posicaoArtigo.getModelObject();
		try {

			WikiLegisServiceUtil.editaArtigo(artigo.getArtigoId(), posicao.getEstruturaPaiId(), posicao.getArtigoAnteriorId(), texto,
					emVigor);
		} catch (SystemException e) {
			// XXX
			LOG.error("Erro ao gravar alterações do artigo.", e);
		} catch (PortalException e) {
			// XXX
			LOG.error("Erro ao gravar alterações do artigo.", e);
		}
		setResponsePage(HomePage.class);
		setRedirect(true);
	}
}
