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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.RequestCycle;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.protocol.http.WebRequest;

import br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.ElementoDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.EstruturaDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.service.EstruturaLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.behaviour.WicketAjaxJsPatch;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.NavegadorPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.WikiLegisArtigoPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.WikiLegisEstruturaPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.WikiLegisMenuPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;
import br.gov.camara.liferay.comum.StaticImage;

import com.google.common.collect.Iterators;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * @author robson
 * 
 */
public class HomePage extends WebPage {

	private static final Log LOG = LogFactoryUtil.getLog(HomePage.class);

	public HomePage() {
		if (!UIUtils.getThemeDisplay().getUser().getDefaultUser()) {
			add(JavascriptPackageResource.getHeaderContribution("html/js/liferay/liferay_restart_session.js"));
		}
		add(new WicketAjaxJsPatch());
		init();
	}

	/**
	 * Cria os componentes
	 */
	private void init() {

		// Monta o menu com funções administrativas
		initMenuWikilegis();

		// Título do projeto de lei
		initTituloProjetoLei();

		initImgExpandir();

		// Título da Descrição do Projeto de Lei
		initTituloDescricaoProjeto();

		// Descricao do Projeto
		initDescricaoProjeto();

		// Monta o painel de estrutura
		initNavegador();
		
		// Monta o quadro com o plugin do facebook
		initPlugins();

		// Monta a lista de elementos raiz
		initFilhos();
	}

	private void initImgExpandir() {

		String imgAbrirArvore;

		add(JavascriptPackageResource.getHeaderContribution("html/js/liferay/arvore.js"));
		imgAbrirArvore = UIUtils.getThemeDisplay().getPathThemeImages() + "/custom/iconeRecolher.gif";

		StaticImage img = new StaticImage("imgExpandir", imgAbrirArvore);
		add(img);
	}

	private void initTituloDescricaoProjeto() {
		add(new Label("tituloDescricaoProjeto", new AbstractReadOnlyModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return UIUtils.getPortletPreferences().getValue("tituloDescricao", "Altere este título em \"Preferências\"");
			}
		}));
	}

	private void initDescricaoProjeto() {
		Label descricaoProjeto = new Label("descricaoProjeto", new AbstractReadOnlyModel<String>() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return UIUtils.getPortletPreferences().getValue("descricaoProjeto", "Altere esta descrição em \"Preferências\" ");
			}
		});
		descricaoProjeto.setEscapeModelStrings(false);
		add(descricaoProjeto);

	}

	private void initTituloProjetoLei() {
		add(new Label("tituloProjetoLei", new AbstractReadOnlyModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return UIUtils.getPortletPreferences().getValue("titulo", "Altere o título em \"Preferências\"");
			}
		}));
	}
	
	private void initPlugins(){
		Label plugins = new Label("plugins");
		plugins.setVisible(Boolean.parseBoolean(UIUtils.getPortletPreferences().getValue("habilitaPlugins", "false")));
		
		String urlComunidade = getURLComunidade();
		String urlToShare = StringPool.BLANK;
		
		if(urlComunidade != null){
			urlToShare = "//www.facebook.com/plugins/like.php?href=#LINK#&amp;send=false&amp;layout=standard&amp;width=235&amp;";
			urlToShare = urlToShare.replace("#LINK#", urlComunidade);
			plugins.add(new SimpleAttributeModifier("src",urlToShare));
		}
		add(plugins);
	}

	private void initMenuWikilegis() {
		add(new WikiLegisMenuPanel("menuWikilegis"));
	}

	private void initNavegador() {
		add(new NavegadorPanel("navegador"));
	}

	private void initFilhos() {

		HttpServletRequest req = ((WebRequest) RequestCycle.get().getRequest()).getHttpServletRequest();
		ThemeDisplay td = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
		final long groupId = td.getScopeGroupId();

		RefreshingView<ElementoDisplay> filhos = new RefreshingView<ElementoDisplay>("filhos") {

			@Override
			protected Iterator<IModel<ElementoDisplay>> getItemModels() {
				Collection<ElementoDisplay> elementos;
				try {
					elementos = WikiLegisServiceUtil.listaElementos(groupId);
				} catch (SystemException e) {
					return Iterators.emptyIterator();
				} catch (PortalException e) {
					return Iterators.emptyIterator();
				}
				List<IModel<ElementoDisplay>> retorno = new ArrayList<IModel<ElementoDisplay>>();
				for (ElementoDisplay elemento : elementos) {
					final long entradaId = elemento.getId();
					final boolean artigo = elemento instanceof ArtigoDisplay;
					retorno.add(new LoadableDetachableModel<ElementoDisplay>(elemento) {
						@Override
						protected ElementoDisplay load() {
							try {
								if (artigo)
									return WikiLegisServiceUtil.getArtigoDisplay(entradaId);
								else
									return new EstruturaDisplay(EstruturaLocalServiceUtil.getEstrutura(entradaId));
							} catch (PortalException e) {
								return null;
							} catch (SystemException e) {
								return null;
							}
						}
					});
				}
				return retorno.iterator();
			}

			@SuppressWarnings("unchecked")
			@Override
			protected void populateItem(Item<ElementoDisplay> item) {
				IModel<? extends ElementoDisplay> model = item.getModel();
				if (model.getObject() instanceof ArtigoDisplay) {
					item.add(new WikiLegisArtigoPanel("filho", (IModel<ArtigoDisplay>) model));
				} else
					item.add(new WikiLegisEstruturaPanel("filho", (IModel<EstruturaDisplay>) model));
			}
		};
		add(filhos);
	}
	
	/**
	 * Retorna a url da comunidade, se não encontrar retorna null.
	 * 
	 * @return
	 */
	private String getURLComunidade(){
		String url = PortalUtil.getPortalURL(UIUtils.getHttpServletRequest());
		try {
			url = url + PortalUtil.getLayoutURL(UIUtils.getThemeDisplay());
		
		} catch (PortalException e) {
			try {
				url = url + PortalUtil.getPathFriendlyURLPublic() + UIUtils.getThemeDisplay().getLayout().getGroup().getFriendlyURL() +  UIUtils.getThemeDisplay().getLayout().getFriendlyURL();
		
			} catch (PortalException e1) {
				LOG.error("Erro ao obter url da comunidade.", e1);
				 return null;
			} catch (SystemException e1) {
				throw new RuntimeException(e);
			}
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
		
		return url;
	}
	
}
