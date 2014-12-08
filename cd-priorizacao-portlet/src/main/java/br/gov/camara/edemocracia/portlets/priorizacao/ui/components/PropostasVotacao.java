/**
 * 
 */
package br.gov.camara.edemocracia.portlets.priorizacao.ui.components;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.PageParameters;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay;
import br.gov.camara.edemocracia.portlets.priorizacao.TotalVotosExcedidoException;
import br.gov.camara.edemocracia.portlets.priorizacao.VotosPorPropostaExcedidoException;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.priorizacao.service.ConfiguracaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.pages.HomePage;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.pages.VotacaoPage;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author p_7339
 * 
 */
public class PropostasVotacao extends Panel {

	private static final long serialVersionUID = 1L;

	private PropertyListView<PropostaDisplay> propostasList;

//	private List<Long> propostasOrdenadas;

	private boolean isVotacaoAberta() {
		try {
			Configuracao config = ConfiguracaoLocalServiceUtil
					.getConfiguracaoPorGrupo(UIUtils.getScopeGroupId());
			return config.isVotacaoAberta();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Formulário
	 */
	private Form<?> form;

	public PropostasVotacao(String id, IModel<List<PropostaDisplay>> propostas) {
		super(id, propostas);

		final String context = RequestCycle.get().getRequest()
				.getRelativePathPrefixToContextRoot();

		final boolean permissaoParaVotar = UIUtils.possuiPermissoes(
				"br.gov.camara.edemocracia.portlets.priorizacao", "VOTE");
		final boolean votacaoAberta = permissaoParaVotar && isVotacaoAberta();

		form = new Form<Object>("form");
		add(form);
		form.add(new WebMarkupContainer("votos") {
			@Override
			public boolean isVisible() {
				return permissaoParaVotar;
			}
		});
		propostasList = new PropertyListView<PropostaDisplay>("propostas",
				new LoadableDetachableModel<List<PropostaDisplay>>() {

					@Override
					public List<PropostaDisplay> load() {
						return PropostasVotacao.this.getModelObject();
					}

				}) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(final ListItem<PropostaDisplay> item) {
				final long propostaId = item.getModelObject().getProposta()
						.getPropostaId();
				PageParameters parameters = new PageParameters();
				parameters.add("proposta",Long.toString(propostaId));
				BookmarkablePageLink<VotacaoPage> propostaIdentificadorLink = new BookmarkablePageLink<VotacaoPage>("proposta.identificadorLink", VotacaoPage.class, parameters);
				Label propostaIdentificadorSpan = new Label("proposta.identificadorSPAN",item.getModelObject().getProposta().getIdentificador());
				
				//Configurando visibilidade
				boolean textoPropostaEmpty = item.getModelObject().getProposta().getTexto().isEmpty();
				propostaIdentificadorLink.setVisible(!textoPropostaEmpty);
				propostaIdentificadorSpan.setVisible(textoPropostaEmpty);
				
				if (item.getModelObject().getVotosUsuario() > 0) {
					// item.add(new AttributeModifier("style", true,
					// Model.of("background-color: #f3f3f3;")));

					propostaIdentificadorLink.add(new Label("proposta.identificador")
					.add(new AttributeModifier("style", true, Model
							.of("font-weight:bold;"))));
					
					item.add(propostaIdentificadorLink.add((new AttributeModifier("style", true, Model
									.of("font-weight:bold;")))));
					item.add(propostaIdentificadorSpan.add(new AttributeModifier("style", true, Model
									.of("font-weight:bold;"))));
					item.add(new Label("proposta.ementa")
							.add(new AttributeModifier("style", true, Model
									.of("font-weight:bold;"))));

				} else {
					propostaIdentificadorLink.add(new Label("proposta.identificador"));
					item.add(propostaIdentificadorLink);
					item.add(propostaIdentificadorSpan);
					item.add(new Label("proposta.ementa"));

				}
				
				
				// item.add(new Label("totalVotos").setVisible(item
				// .getModelObject().getTotalVotos() > 0));
				// item.add(new Label("votosUsuario").setVisible(item
				// .getModelObject().getVotosUsuario() > 0));

				AjaxButton cancelarVoto = new AjaxButton("cancelarVoto", form) {

					@Override
					protected void onSubmit(AjaxRequestTarget target,
							Form<?> form) {
						target.addComponent(form);
						PropostasVotacao.this.onAjaxRequest(target);
						try {
							PriorizacaoServiceUtil.deleteVoto(propostaId);
						} catch (SystemException e) {
							throw new RuntimeException(e);
						} catch (PortalException e) {
							error("Proposta excluída");
							throw new RestartResponseException(HomePage.class);
						}
					}

					@Override
					public boolean isVisible() {
						return votacaoAberta;
					}
				};
				
				cancelarVoto.add(new WebComponent("icone") {
					@Override
					protected void onComponentTag(ComponentTag tag) {
						super.onComponentTag(tag);
						checkComponentTag(tag, "img");
						String imageUrl;
						if (item.getModelObject().isPodeCancelarVoto())
							imageUrl = "ico_menos.png";
						else
							imageUrl = "ico_menos_inativo.png";
						tag.put("src", context + "html/imagens/" + imageUrl);
					}
				});
				item.add(cancelarVoto);

				item.add(new WebComponent("votosUsuario") {
					protected void onComponentTag(ComponentTag tag) {
						super.onComponentTag(tag);
						checkComponentTag(tag, "img");
						Integer votos = (Integer) getDefaultModelObject();
						if (votos == null)
							votos = 0;
						tag.put("src", context + "html/imagens/ico_check"
								+ votos + ".png");
					}

					@Override
					public boolean isVisible() {
						return permissaoParaVotar;
					}
				});
				AjaxButton votar = new AjaxButton("votar", form) {
					@Override
					protected void onSubmit(AjaxRequestTarget target,
							Form<?> form) {
						target.addComponent(form);
						PropostasVotacao.this.onAjaxRequest(target);
						try {
							PriorizacaoServiceUtil.addVoto(propostaId);
						} catch (TotalVotosExcedidoException e) {
							error("Você já excedeu a quantidade máxima de votos");
						} catch (VotosPorPropostaExcedidoException e) {
							error("Você já votou o máximo de vezes nesta proposta");
						} catch (SystemException e) {
							throw new RuntimeException(e);
						} catch (PortalException e) {
							error("Proposta excluída");
							throw new RestartResponseException(HomePage.class);
						}
					}

					@Override
					public boolean isVisible() {
						return votacaoAberta;
					}
				};

				votar.add(new WebComponent("icone") {
					@Override
					protected void onComponentTag(ComponentTag tag) {
						super.onComponentTag(tag);
						checkComponentTag(tag, "img");
						String imageUrl;
						if (item.getModelObject().isPodeVotar())
							imageUrl = "ico_mais.png";
						else
							imageUrl = "ico_mais_inativo.png";
						tag.put("src", context + "html/imagens/" + imageUrl);
					}
				});
				item.add(votar);

			}
		};

		form.add(propostasList);
	}
	
	public void rerenderComponent(AjaxRequestTarget target) {
		target.addComponent(form);
	}

//	private final ReentrantLock lock = new ReentrantLock();

	/**
	 * Retorna a lista em uma ordem consistente entre todas as chamadas
	 * 
	 * @return
	 *
	private List<PropostaDisplay> getPropostasOrdenadas() {
		if (propostasOrdenadas != null) {
			return ordenaPropostas();
		}
		lock.lock();
		try {
			if (propostasOrdenadas != null) {
				return ordenaPropostas();
			}
			ArrayList<Long> ordem = new ArrayList<Long>();
			for (PropostaDisplay proposta : getModelObject())
				ordem.add(proposta.getProposta().getPropostaId());

			propostasOrdenadas = ordem;
		} finally {
			lock.unlock();
		}
		return getModelObject();
	}

	private List<PropostaDisplay> ordenaPropostas() {

		HashMap<Long, PropostaDisplay> propostas = new HashMap<Long, PropostaDisplay>();
		for (PropostaDisplay proposta : getModelObject())
			propostas.put(proposta.getProposta().getPropostaId(), proposta);

		List<PropostaDisplay> retorno = new ArrayList<PropostaDisplay>();
		for (Long propostaId : propostasOrdenadas) {
			PropostaDisplay pd = propostas.get(propostaId);
			if (pd != null) {
				retorno.add(pd);
				propostas.remove(propostaId);
			}
		}

		// Adiciona ao final da lista as novas propostas
		if (!propostas.isEmpty()) {
			lock.lock();
			try {
				ArrayList<Long> novaListaOrdenada = new ArrayList<Long>(
						propostasOrdenadas);
				for (Long propostaId : novaListaOrdenada) {
					propostas.remove(propostaId);
				}
				for (PropostaDisplay pd : propostas.values()) {
					retorno.add(pd);
					novaListaOrdenada.add(pd.getProposta().getPropostaId());
				}
				propostasOrdenadas = novaListaOrdenada;
			} finally {
				lock.unlock();
			}
		}
		return retorno;
	}*/

	/**
	 * Método chamado quando houver alguma requisição AJAX
	 * 
	 * @param target
	 */
	protected void onAjaxRequest(AjaxRequestTarget target) {
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public IModel<List<PropostaDisplay>> getModel() {
		return (IModel<List<PropostaDisplay>>) getDefaultModel();
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PropostaDisplay> getModelObject() {
		return (List<PropostaDisplay>) getDefaultModelObject();
	}

}
