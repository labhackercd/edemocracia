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
package br.gov.camara.edemocracia.portlets.wikilegis.ui.panels;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.components.Anchor;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.pages.ContribuicaoPage;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.pages.EdicaoArtigoPage;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.ActionKeys;

/**
 * @author robson
 * 
 */
public class WikiLegisArtigoPanel extends Panel {

	private static final long serialVersionUID = 1L;

	/**
	 * Obtém o artigo associado a este painel
	 * 
	 * @return
	 */
	private ArtigoDisplay getModelObject() {
		return (ArtigoDisplay) getDefaultModelObject();
	}

	/**
	 * Modelo do artigo associado
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private IModel<ArtigoDisplay> getModel() {
		return (IModel<ArtigoDisplay>) getDefaultModel();
	}

	// /////////////
	// Campos de formulário
	// /////////////
	private AjaxLink<Void> mostrarComentarios;
	private WebMarkupContainer containerIconeComentarios;
	private WebMarkupContainer containerIconeSugestoes;
	private AjaxLink<Void> mostrarLegislacao;
	private AjaxLink<Void> ocultarLegislacao;
	private Link<Void> editar;
	private Link<ContribuicaoPage> mostrarContribuicoes;
	private Label textoFormatado;
	private Label legislacaoVigenteFormatada;
	private ComentariosPanel comentarios;
	private WebMarkupContainer legislacaoVigenteRegiao;
	private WebMarkupContainer comentariosRegiao;
	private WebMarkupContainer containerNumeroComentarios;
	private WebMarkupContainer containerNumeroContribuicoes;
	private Label numeroComentarios;
	private Label numeroSugestoes;

	/**
	 * @param id
	 * @param model
	 */
	public WikiLegisArtigoPanel(String id, IModel<ArtigoDisplay> model) {
		super(id);
		if (!(model instanceof CompoundPropertyModel<?>))
			setDefaultModel(new CompoundPropertyModel<ArtigoDisplay>(model));
		else
			setDefaultModel(model);

		initNodeName();
		initContainerNumeroComentarios();
		initNumeroComentarios();
		initContainerIconeComentarios();
		initMostrarComentarios();
		initContainerNumeroContribuicoes();
		initNumeroContribuicoes();
		initEditar();
		initContainerIconeContribuicoes();
		initMostrarContribuicoes();
		initMostrarLegislacao();
		initTextoFormatado();
		initLegislacaoVigenteRegiao();
		initLegislacaoVigenteFormatada();
		initOcultarLegislacao();
		initComentariosRegiao();
		initComentarios();
	}

	private void initContainerNumeroComentarios() {
		containerNumeroComentarios = new WebMarkupContainer("containerNumeroComentarios"){
			private static final long serialVersionUID = 1L;
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(getModelObject().getNumeroComentarios() != 0);
			}
		};
		containerNumeroComentarios.setOutputMarkupId(true);
		containerNumeroComentarios.setOutputMarkupPlaceholderTag(true);
		add(containerNumeroComentarios);
	}

	private void initNumeroComentarios() {
		numeroComentarios = new Label("numeroComentarios");
		containerNumeroComentarios.add(numeroComentarios);
	}

	private void initContainerNumeroContribuicoes() {
		containerNumeroContribuicoes = new WebMarkupContainer("containerNumeroContribuicoes"){
			private static final long serialVersionUID = 1L;
			@Override
			protected void onConfigure() {
				super.onConfigure();
				boolean sugestoesEnabled = Boolean.parseBoolean(UIUtils.getPortletPreferences().getValue("habilitaSugestoes", "true"));
				
				if(sugestoesEnabled){
					setVisible(getModelObject().getNumeroSugestoes() != 0);
				} else {
					setVisible(false);
				}
				

			}
		};
		containerNumeroContribuicoes.setOutputMarkupId(true);
		containerNumeroContribuicoes.setOutputMarkupPlaceholderTag(true);
		add(containerNumeroContribuicoes);		
	}
	
	private void initNumeroContribuicoes() {
		numeroSugestoes = new Label("numeroSugestoes");
		containerNumeroContribuicoes.add(numeroSugestoes);
	}

	/**
	 * Cria o campo com o link
	 */
	private void initNodeName() {
		Anchor nodeName = new Anchor("nodeName", new ComponentPropertyModel<String>("nodeName"));
		add(nodeName);
	}

	private void initLegislacaoVigenteRegiao() {
		legislacaoVigenteRegiao = new WebMarkupContainer("legislacaoVigenteRegiao");
		legislacaoVigenteRegiao.setVisible(false);
		legislacaoVigenteRegiao.setOutputMarkupId(true);
		legislacaoVigenteRegiao.setOutputMarkupPlaceholderTag(true);
		add(legislacaoVigenteRegiao);
	}

	private void initLegislacaoVigenteFormatada() {
		legislacaoVigenteFormatada = new Label("legislacaoVigenteFormatada");
		legislacaoVigenteFormatada.setEscapeModelStrings(false);
		legislacaoVigenteRegiao.add(legislacaoVigenteFormatada);
	}

	private void initComentariosRegiao() {
		comentariosRegiao = new WebMarkupContainer("comentariosRegiao");
		comentariosRegiao.setVisible(false);
		comentariosRegiao.setOutputMarkupId(true);
		comentariosRegiao.setOutputMarkupPlaceholderTag(true);
		add(comentariosRegiao);
	}


	private void initComentarios() {
		comentarios = new ComentariosPanel("comentarios", new ComponentPropertyModel<ArtigoDisplay>("")) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onComentariosChanged(AjaxRequestTarget target) {
				// Recarrega o modelo
				final long artigoId = WikiLegisArtigoPanel.this.getModelObject().getId(); 
				WikiLegisArtigoPanel.this.setDefaultModel(new CompoundPropertyModel<ArtigoDisplay>(new LoadableDetachableModel<ArtigoDisplay>() {

					@Override
					protected ArtigoDisplay load() {
						try {
							return WikiLegisServiceUtil.getArtigoDisplay(artigoId);
						} catch (PortalException e) {
							return null;
						} catch (SystemException e) {
							// TODO LOG
							return null;
						}
					}
				}));
				if (target != null) {
					target.addComponent(containerIconeComentarios);
					target.addComponent(containerNumeroComentarios);
				}
			}
		};
		comentariosRegiao.add(comentarios);
	}

	private void initTextoFormatado() {
		textoFormatado = new Label("textoFormatado");
		textoFormatado.setEscapeModelStrings(false);
		add(textoFormatado);
	}

	private void initMostrarLegislacao() {
		mostrarLegislacao = new AjaxLink<Void>("mostrarLegislacao") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
				ArtigoDisplay objeto = WikiLegisArtigoPanel.this.getModelObject();
				setVisible(objeto != null && objeto.getLegislacaoVigente() != null
						&& !objeto.getLegislacaoVigente().trim().isEmpty());
			}

			@Override
			public void onClick(AjaxRequestTarget target) {
				legislacaoVigenteRegiao.setVisible(!legislacaoVigenteRegiao.isVisible());
				if (target != null)
					target.addComponent(legislacaoVigenteRegiao);
			}

		};
		add(mostrarLegislacao);
	}

	private void initContainerIconeContribuicoes() {
		containerIconeSugestoes = new WebMarkupContainer("containerIconeSugestoes") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(Boolean.parseBoolean(UIUtils.getPortletPreferences().getValue("habilitaSugestoes", "true")));
				
				ArtigoDisplay objeto = WikiLegisArtigoPanel.this.getModelObject();
				if (objeto.getNumeroSugestoes() != 0)
					add(new SimpleAttributeModifier("class", "iconesSugestaoWikilegis"));

			}
		};
		containerIconeSugestoes.setOutputMarkupId(true);
		add(containerIconeSugestoes);
	}

	private void initMostrarContribuicoes() {
		PageParameters pp = new PageParameters();
		ArtigoDisplay elemento = (ArtigoDisplay) getDefaultModelObject();
		pp.add("artigo", Long.toString(elemento.getId()));

		mostrarContribuicoes = new BookmarkablePageLink<ContribuicaoPage>("mostrarContribuicoes", ContribuicaoPage.class, pp);
		containerIconeSugestoes.add(mostrarContribuicoes);
	}

	private void initEditar() {
		PageParameters pp = new PageParameters();
		ArtigoDisplay elemento = (ArtigoDisplay) getDefaultModelObject();
		pp.add("0", Long.toString(elemento.getId()));

		editar = new BookmarkablePageLink<Void>("editar", EdicaoArtigoPage.class, pp) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(UIUtils.possuiPermissoes(ActionKeys.CONFIGURATION));
			}
		};
		add(editar);
	}

	private void initContainerIconeComentarios() {
		containerIconeComentarios = new WebMarkupContainer("containerIconeComentarios") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
				ArtigoDisplay objeto = WikiLegisArtigoPanel.this.getModelObject();
				if (objeto.getNumeroComentarios() != 0)
					add(new SimpleAttributeModifier("class", "iconesComentarioWikilegis"));
				else
					add(new SimpleAttributeModifier("class", "demaisIconesWikilegis"));

			}
		};
		containerIconeComentarios.setOutputMarkupId(true);
		add(containerIconeComentarios);

	}

	private void initMostrarComentarios() {
		mostrarComentarios = new AjaxLink<Void>("mostrarComentarios") {
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick(AjaxRequestTarget target) {
				comentariosRegiao.setVisible(!comentariosRegiao.isVisible());
				if (target != null)
					target.addComponent(comentariosRegiao);
			}

		};
		mostrarComentarios.setOutputMarkupId(true);
		containerIconeComentarios.add(mostrarComentarios);
	}

	private void initOcultarLegislacao() {
		ocultarLegislacao = new AjaxLink<Void>("ocultarLegislacao") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
				ArtigoDisplay objeto = WikiLegisArtigoPanel.this.getModelObject();
				setVisible(objeto != null && objeto.getLegislacaoVigente() != null
						&& !objeto.getLegislacaoVigente().trim().isEmpty());
			}

			@Override
			public void onClick(AjaxRequestTarget target) {
				legislacaoVigenteRegiao.setVisible(false);
				if (target != null)
					target.addComponent(legislacaoVigenteRegiao);
			}

		};
		legislacaoVigenteRegiao.add(ocultarLegislacao);

	}

	public void ocultaComentarios(AjaxRequestTarget target) {
		comentariosRegiao.setVisible(false);
		if (target != null)
			target.addComponent(comentariosRegiao);
	}
}
