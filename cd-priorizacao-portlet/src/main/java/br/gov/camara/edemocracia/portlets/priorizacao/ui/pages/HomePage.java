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
package br.gov.camara.edemocracia.portlets.priorizacao.ui.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.RequestCycle;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebRequest;

import br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay;
import br.gov.camara.edemocracia.portlets.priorizacao.VotosUsuario;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.components.PropostasVotacao;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.panels.MenuPanel;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;
import br.gov.camara.liferay.comum.StaticImage;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Página inicial de apresentação das propostas
 * 
 * @author robson
 * 
 */
public class HomePage extends WebPage {

	private WebMarkupContainer votos;
	private PropertyListView<Eixo> eixos;
	private static final Log LOG = LogFactoryUtil.getLog(HomePage.class);

	public HomePage() {
		initVotosUsuario();
		initAjuda();
		initMenu();
		initEixos();

	}

	private void initMenu() {
		add(new MenuPanel("menu"));
	}
	
	private void initAjuda() {
		PortletPreferences pp = UIUtils.getPortletPreferences();
		String mensagem = pp.getValue("mensagem", "");
		if (mensagem == null)
			mensagem = "";
		String url = pp.getValue("url", "");
		if (url == null)
			url = "";
		
		if (mensagem.isEmpty()) {
			WebMarkupContainer link = new WebMarkupContainer("link");
			link.add(new Label("mensagem"));
			link.setVisible(false);
			votos.add(link);
		} else {
			ExternalLink link = new ExternalLink("link", Model.of(url));
			if (url.isEmpty())
				link.setEnabled(false);
			link.add(new Label("mensagem", Model.of(mensagem)));
			votos.add(link);
		}
		
	}

	/**
	 * Número de votos disponível para o usuário
	 */
	private void initVotosUsuario() {
		votos = new WebMarkupContainer("votos",
				new CompoundPropertyModel<VotosUsuario>(
						new LoadableDetachableModel<VotosUsuario>() {
							@Override
							protected VotosUsuario load() {
								try {
									HttpServletRequest request = ((WebRequest) (RequestCycle
											.get()).getRequest())
											.getHttpServletRequest();
									long scopeGroupId = PortalUtil
											.getScopeGroupId(request);
									return PriorizacaoServiceUtil
											.getVotosUsuario(scopeGroupId);
								} catch (PortalException e) {
									throw new RuntimeException(e);
								} catch (SystemException e) {
									throw new RuntimeException(e);
								}
							}
						})) {
			@Override
			protected void onConfigure() {
				super.onConfigure();
				if (getDefaultModelObject() == null)
					setVisible(false);
				else {
					VotosUsuario votosUsuario = (VotosUsuario) getDefaultModelObject();
					setVisible(votosUsuario.getTotalVotos() > 0
							|| votosUsuario.getVotosDisponiveis() > 0);
				}
			}
		};
		votos.setOutputMarkupId(true);
		add(votos);
		votos.add(new Label("votosDisponiveis") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 2740627999411702017L;

			@Override
			protected void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
			{
				String texto;
				int votos = ((Integer)getDefaultModelObject());
				if (votos > 1)
					texto = LanguageUtil.format(UIUtils.getUserLocale(), "you-have-x-available-votes", votos);
				else if (votos == 1)
					texto = LanguageUtil.get(UIUtils.getUserLocale(), "you-have-1-available-vote");
				else
					texto = LanguageUtil.get(UIUtils.getUserLocale(), "you-do-not-have-available-votes");
				replaceComponentTagBody(markupStream, openTag, texto);
			}
			
			@Override
			protected void onConfigure() {
				super.onConfigure();
				if (getDefaultModelObject() != null
						&& ((Integer) getDefaultModelObject()) > 0)
					setVisible(true);
				else
					setVisible(false);
			}
		});
		votos.add(new Label("totalVotos") {
			/**
			 * 
			 */
			private static final long serialVersionUID = -5536952667180535257L;
			@Override
			protected void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
			{
				String texto;
				int votos = ((Integer)getDefaultModelObject());
				if (votos > 1)
					texto = LanguageUtil.format(UIUtils.getUserLocale(), "you-have-voted-x-times", votos);
				else if (votos == 1)
					texto = LanguageUtil.get(UIUtils.getUserLocale(), "you-have-voted-1-time");
				else
					texto = LanguageUtil.get(UIUtils.getUserLocale(), "you-do-not-voted");
				replaceComponentTagBody(markupStream, openTag, texto);
			}
			@Override
			protected void onConfigure() {
				super.onConfigure();
				if (getDefaultModelObject() != null
						&& ((Integer) getDefaultModelObject()) > 0)
					setVisible(true);
				else
					setVisible(false);
			}
		});
	}

	private void initEixos() {
		LoadableDetachableModel<List<Eixo>> eixosModel = new LoadableDetachableModel<List<Eixo>>() {
			@Override
			protected List<Eixo> load() {
				try {
					HttpServletRequest request = ((WebRequest) (RequestCycle
							.get()).getRequest()).getHttpServletRequest();
					long scopeGroupId = PortalUtil.getScopeGroupId(request);
					return PriorizacaoServiceUtil.listarEixos(scopeGroupId);
				} catch (SystemException e) {
					return null;
				} catch (PortalException e) {
					return null;
				}
			}
		};
		final String iconeExpandirUrl = UIUtils.getThemeDisplay().getPathThemeImages() + "/custom/iconeExpandir.gif";
		eixos = new PropertyListView<Eixo>("eixos", eixosModel) {
			@Override
			protected void populateItem(ListItem<Eixo> item) {
				item.setVisible(item.getModelObject() != null);

				final Long eixoId = item.getModelObject() != null ? item
						.getModelObject().getEixoId() : null;
				LoadableDetachableModel<List<PropostaDisplay>> propostasModel = new LoadableDetachableModel<List<PropostaDisplay>>() {
					@Override
					protected List<PropostaDisplay> load() {
						try {
							if (eixoId != null)
								return PriorizacaoServiceUtil
										.listarPropostaDisplay(eixoId);
							else
								return null;
						} catch (SystemException e) {
							return null;
						} catch (PortalException e) {
							return null;
						}
					}
				};

				item.add(new StaticImage("abrir", iconeExpandirUrl)); // Imagem
				item.add(new Label("titulo"));
				item.add(new Label("sumario"));

				final PropostasVotacao propostas = new PropostasVotacao("propostas",
						propostasModel) {
					@Override
					protected void onAjaxRequest(final AjaxRequestTarget target) {
						target.addComponent(votos);
						final PropostasVotacao thisComponent = this;
						// Atualiza todos os eixos
						eixos.visitChildren(PropostasVotacao.class, new IVisitor<PropostasVotacao>() {
							@Override
							public Object component(PropostasVotacao component) {
								if (component != thisComponent) {
									component.rerenderComponent(target);
								}
								return CONTINUE_TRAVERSAL_BUT_DONT_GO_DEEPER;
							}
						});
					}
				};
				propostas.setVisible(getPropostasCount(eixoId) != 0);
				item.add(propostas);
			}
		};
		eixos.setReuseItems(true);
		add(eixos);
	}

	/**
	 * Obtém a lista de propostas de um eixo
	 * 
	 * @param eixoId
	 * @return
	 */
	private Iterator<IModel<Proposta>> listPropostas(Long eixoId) {
		ArrayList<IModel<Proposta>> retorno = new ArrayList<IModel<Proposta>>();
		if (eixoId != null) {
			try {
				for (Proposta proposta : PriorizacaoServiceUtil
						.listarPropostasPorEixoId(eixoId)) {
					final long propostaId = proposta.getPropostaId();
					retorno.add(new CompoundPropertyModel<Proposta>(
							new LoadableDetachableModel<Proposta>(proposta) {
								@Override
								protected Proposta load() {
									try {
										return PriorizacaoServiceUtil
												.getProposta(propostaId);
									} catch (PortalException e) {
										// TODO Log
										LOG.error("Erro ao obter proposta.", e);
										return null;
									} catch (SystemException e) {
										// TODO Log
										LOG.error("Erro ao obter proposta.", e);
										return null;
									}
								}
							}));
				}
			} catch (SystemException e) {
				// TODO Log
			}
		}

		return retorno.iterator();
	}

	private int getPropostasCount(long eixoId) {
		try {
			return PriorizacaoServiceUtil.getPropostasCountByEixoId(eixoId);
		} catch (SystemException e) {
			// TODO
			LOG.error("Erro ao obter número de propostas do eixo", e);
		}
		return 0;
	}
}
