/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao;
import br.gov.camara.edemocracia.portlets.wikilegis.service.ContribuicaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.components.ArtigoLabel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.components.UserImage;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.model.ContribuicaoDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.AlterarContribuicaoBoxPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.WikiLegisMenuPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;

import com.google.common.collect.Iterators;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Lista as contribuições e permite sua edição
 * 
 * @author rpdmiranda
 * 
 */
public class ContribuicaoPage extends WebPage {
	
	/**
	 * Constrói a página de visualização de contribuiçõe
	 * 
	 * @param pp
	 */
	public ContribuicaoPage(PageParameters pp) {
		super(pp);
		
		boolean sugestoesEnabled = Boolean.parseBoolean(UIUtils.getPortletPreferences().getValue("habilitaSugestoes", "true"));
		
		if(sugestoesEnabled) {		
			final long artigoId = pp.getAsLong("artigo", 0l);
			Artigo artigo;
			try {
				artigo = WikiLegisServiceUtil.getArtigo(artigoId);
			} catch (PortalException e) {
				// TODO Log
				throw new RestartResponseException(HomePage.class);
			} catch (SystemException e) {
				// TODO Log
				throw new RuntimeException(e);
			}
			setDefaultModel(new LoadableDetachableModel<Artigo>(artigo) {
	
				private static final long serialVersionUID = 1L;
	
				@Override
				protected Artigo load() {
					try {
						return WikiLegisServiceUtil.getArtigo(artigoId);
					} catch (Exception e) {
						// TODO Log
						throw new RuntimeException(e);
					}
				}
			});
			init(); 
		} else {
			throw new RestartResponseException(HomePage.class);
		}
	}

	private Artigo getModelObject() {
		return (Artigo) getDefaultModelObject();
	}

	// //////////////////////////////////////////
	// Componentes
	// //////////////////////////////////////////
	private RefreshingView<ContribuicaoDisplay> contribuicoes;
	private Form<Void> form;
	private TextArea<String> textoArtigo;
	private TextArea<String> descricao;
	private AlterarContribuicaoBoxPanel alterarContribuicaoBox;
	private static final Log LOG = LogFactoryUtil.getLog(ContribuicaoPage.class);
	
	private void init() {
		initMenuWikilegis();
		initPlugins();
		add(new ArtigoLabel("texto", new ComponentPropertyModel<String>("texto"), true));
		add(new ArtigoLabel("legislacaoVigente", new ComponentPropertyModel<String>("legislacaoVigente"), false) {
			private static final long serialVersionUID = 1L;
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(!getDefaultModelObjectAsString().trim().isEmpty());
			}			

		});
		initContribuicoes();
		initForm();
		initTextoTextArea();
		initDescricao();
		initEnviar();
		initCancelar();
		initAlterarContribuicao();
	}

	

	private void initMenuWikilegis() {
		add(new WikiLegisMenuPanel("menuWikilegis"));		
	}
	
	private void initPlugins() {
		WebMarkupContainer plugins = new WebMarkupContainer("plugins");
		plugins.add(new WebMarkupContainer("share").add(new SimpleAttributeModifier("addthis:url", PortalUtil.getCurrentCompleteURL(UIUtils.getHttpServletRequest()))));
		plugins.setVisible(Boolean.parseBoolean(UIUtils.getPortletPreferences().getValue("habilitaPlugins", "false")));
		add(plugins);
	}
	
	private void initContribuicoes() {
		contribuicoes = new RefreshingView<ContribuicaoDisplay>("contribuicoes") {

			private static final long serialVersionUID = 1L;

			@Override
			protected Iterator<IModel<ContribuicaoDisplay>> getItemModels() {
				return listaContribuicoes();
			}

			@Override
			protected void populateItem(final Item<ContribuicaoDisplay> item) {
				item.add(new UserImage("userId"));
				item.add(new Label("userName"));
				item.add(new ArtigoLabel("texto"));
				item.add(new Label("descricao") {
					private static final long serialVersionUID = 1L;

					@Override
					protected void onConfigure() {
						super.onConfigure();
						setVisible(getDefaultModelObjectAsString().trim().length() > 0);
					}
				});				
				item.add(new AjaxLink<Void>("alterar") {
					private static final long serialVersionUID = 1L;

					@Override
					protected void onConfigure() {
						super.onConfigure();
						if(!(UIUtils.possuiPermissoes("UPDATE_PROPOSITION") || UIUtils.isOwner(item.getModelObject().getUserId(),"UPDATE_PROPOSITION")))
							setVisible(false);
					}
					
					@Override
					public void onClick(AjaxRequestTarget target) {
						alterarContribuicaoBox.editarArtigo(item.getModelObject());
						target.addComponent(alterarContribuicaoBox);
						target.appendJavascript(" $('#dialog').fadeIn(400);");
						target.appendJavascript("$('.modalWindow .close').click(function (){ $('#mask').hide(); $('.modalWindow').hide();});");
					}
					
				});
				final long id = item.getModelObject().getContribuicaoId();
				item.add(new Link<Void>("excluir"){
					
					@Override
					protected void onConfigure() {
						super.onConfigure();
						if(!(UIUtils.possuiPermissoes("DELETE_PROPOSITION") || UIUtils.isOwner(item.getModelObject().getUserId(),"DELETE_PROPOSITION")))
							setVisible(false);
					}
					
					private static final long serialVersionUID = 1L;
					@Override
					public void onClick() {
						try {
							WikiLegisServiceUtil.removeContribuicao(id);
						} catch (PortalException e) {
							LOG.error("Erro ao remover a contribuição.",e);
						} catch (SystemException e) {							
							LOG.error("Erro ao remover a contribuição",e);
						}								
					}
					
				});
			}
		};		
		add(contribuicoes);
	}

	private void initForm() {
		form = new Form<Void>("form") {
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void onConfigure() {
				super.onConfigure();				
				/**
				 * Não mostra o formulário se o usuário não tiver permissão para contribuir
				 */
				setVisible(UIUtils.possuiPermissoes("PROPOSE"));
			}

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
	

	private void initTextoTextArea() {
		String texto = getModelObject() != null ? getModelObject().getTexto()
				: "";
		textoArtigo = new TextArea<String>("textoArtigo", Model.of(texto));
		textoArtigo.setOutputMarkupId(true);
		form.add(textoArtigo);
	}

	private void initDescricao() {
		descricao = new TextArea<String>("descricao", Model.of(""));
		descricao.setOutputMarkupId(true);
		form.add(descricao);
	}

	private void initEnviar() {
		form.add(new Button("enviar"));
	}

	private void initCancelar() {
		BookmarkablePageLink<HomePage> cancelar = new BookmarkablePageLink<HomePage>("cancelar", HomePage.class);
		form.add(cancelar);
	}

	private void initAlterarContribuicao() {
		alterarContribuicaoBox = new AlterarContribuicaoBoxPanel("alterarContribuicaoBox");
		alterarContribuicaoBox.setOutputMarkupId(true);
		add(alterarContribuicaoBox);
	}
	
	/**
	 * Lista as contribuições para o artigo atual
	 * 
	 * @return
	 */
	private Iterator<IModel<ContribuicaoDisplay>> listaContribuicoes() {
		Artigo artigo = getModelObject();
		
		if (artigo == null)
			return Iterators.emptyIterator();

		List<Contribuicao> contribuicoes;
		try {
			contribuicoes = WikiLegisServiceUtil.listaContribuicoes(artigo.getArtigoId());
		} catch (SystemException e1) {
			// TODO log
			LOG.error("Erro ao obter lista de contribuições do artigo.Param artigoId=\""+artigo.getArtigoId()+"\"" ,e1);
			return Iterators.emptyIterator();
		}
		ArrayList<IModel<ContribuicaoDisplay>> retorno = new ArrayList<IModel<ContribuicaoDisplay>>();
		for (Contribuicao contribuicao : contribuicoes) {
			final long contribuicaoId = contribuicao.getContribuicaoId();
			ContribuicaoDisplay display = new ContribuicaoDisplay(contribuicao);
			retorno.add(new CompoundPropertyModel<ContribuicaoDisplay>(new LoadableDetachableModel<ContribuicaoDisplay>(display) {

				private static final long serialVersionUID = 1L;

				@Override
				protected ContribuicaoDisplay load() {
					try {
						return new ContribuicaoDisplay(ContribuicaoLocalServiceUtil.getContribuicao(contribuicaoId));
					} catch (PortalException e) {
						// TODO LOG
						LOG.error("Erro ao obter contribuição.Param contribuicaoId = \""+contribuicaoId+"\"",e);
						return null;
					} catch (SystemException e) {
						// TODO LOG
						LOG.error("Erro ao obter contribuição.Param contribuicaoId=\""+contribuicaoId+"\" ",e);
						return null;
					}
				}
			}));
		}
		return retorno.iterator();
	}
	
	/**
	 * Grava o novo comentário
	 */
	private void gravaAlteracoes() {
		Artigo artigo = getModelObject();
		String textoContribuicao = textoArtigo.getModelObject();
		String descricaoContribuicao = descricao.getModelObject();

		try {
			WikiLegisServiceUtil.adicionaContribuicao(artigo.getArtigoId(), textoContribuicao, descricaoContribuicao);
		} catch (SystemException e) {
			LOG.error("Erro ao gravar comentário",e);
		} catch (NoSuchArtigoException e) {
			LOG.error("Erro ao gravar comentário",e);
		} catch (PortalException e) {
			LOG.error("Erro ao gravar comentário",e);
		}
		setResponsePage(HomePage.class);
		setRedirect(true);
	}
	
}