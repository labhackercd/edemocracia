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

import org.apache.wicket.PageParameters;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.LoadableDetachableModel;

import br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay;
import br.gov.camara.edemocracia.portlets.priorizacao.TotalVotosExcedidoException;
import br.gov.camara.edemocracia.portlets.priorizacao.VotosPorPropostaExcedidoException;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.priorizacao.service.ConfiguracaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.panels.MenuPanel;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Página de votação de uma proposta
 * 
 * @author robson
 * 
 */
public class VotacaoPage extends WebPage {

	private PropostaDisplay getModelObject() {
		return (PropostaDisplay) getDefaultModelObject();
	}

	private WebMarkupContainer votacaoContainer;
	private FeedbackPanel feedbackPanel;
	private Label totalVotos;
//	private Label votosUsuario;
	private Label votosDisponiveis;
	
	private Form<?> form;
	private final long propostaId;
	private static final Log LOG = LogFactoryUtil
			.getLog(VotacaoPage.class);
	
	public VotacaoPage(PageParameters parameters) {
		super(parameters);

		propostaId = parameters.getLong("proposta", -1l);
		if (propostaId <= 0)
			throw new RestartResponseException(HomePage.class);

		PropostaDisplay proposta = null;
		try {
			proposta = PriorizacaoServiceUtil.getPropostaDisplay(propostaId);
		} catch (PortalException e) {
			// TODO Log
			LOG.error("Erro ao obter proposta", e);
		} catch (SystemException e) {
			// TODO Log
			LOG.error("Erro ao obter proposta", e);
		}
		
		if (proposta == null)
			throw new RestartResponseException(HomePage.class);

		setDefaultModel(new CompoundPropertyModel<PropostaDisplay>(new LoadableDetachableModel<PropostaDisplay>(proposta) {

			@Override
			protected PropostaDisplay load() {
				try {
					return PriorizacaoServiceUtil.getPropostaDisplay(propostaId);
				} catch (PortalException e) {
					// TODO Log
					LOG.error("Erro ao obter proposta",e);
					return null;
				} catch (SystemException e) {
					// TODO Log
					LOG.error("Erro ao obter proposta", e);
					return null;
				}
			}
		}));
		
		init();
	}
	
	/**
	 * Configura a visibilidade dos elementos de votação
	 */
	@Override
	protected void onConfigure() {
		super.onConfigure();
		
		configuraVisibilidade();
	}

	/**
	 * 
	 */
	private void configuraVisibilidade() {
		if (getDefaultModelObject() == null) {
			throw new RestartResponseException(HomePage.class);
		}
		
		totalVotos.setVisible(getModelObject().getTotalVotos() > 0);
//		votosUsuario.setVisible(getModelObject().getVotosUsuario() > 0);
		votosDisponiveis.setVisible(getModelObject().isPodeVotar() && getModelObject().getVotosDisponiveis() > 0);
	}
	
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
	 * Cria os componentes
	 */
	private void init() {
		
		final String context = RequestCycle.get().getRequest()
				.getRelativePathPrefixToContextRoot();
		final boolean permissaoParaVotar = UIUtils.possuiPermissoes(
				"br.gov.camara.edemocracia.portlets.priorizacao", "VOTE");
		final boolean votacaoAberta = permissaoParaVotar && isVotacaoAberta();
		form = new Form<Object>("form");
		add(form);
		
		
		add(new MenuPanel("menu"));
		add(new BookmarkablePageLink<Void>("voltar", HomePage.class));
		add(new Label("proposta.identificador"));
		add(new Label("eixo.titulo"));
		
		votacaoContainer = new WebMarkupContainer("votacaoContainer");
		votacaoContainer.setOutputMarkupId(true);
		add(votacaoContainer);
		
		votacaoContainer.add(feedbackPanel = new FeedbackPanel("feedbackPanel"));
		votacaoContainer.add(totalVotos = new Label("totalVotos"));
//		votacaoContainer.add(votosUsuario = new Label("votosUsuario"));
		votacaoContainer.add(votosDisponiveis = new Label("votosDisponiveis"));
		votacaoContainer.add(form);
		
		AjaxButton cancelarVoto = new AjaxButton("cancelarVoto", form) {

			@Override
			protected void onSubmit(AjaxRequestTarget target,
					Form<?> form) {
				target.addComponent(form);
				VotacaoPage.this.onAjaxRequest(target);
				try {
					PriorizacaoServiceUtil.deleteVoto(propostaId);
				} catch (SystemException e) {
					throw new RuntimeException(e);
				} catch (PortalException e) {
					error("Proposta excluída");
					throw new RestartResponseException(HomePage.class);
				}
				
				// Força recarregar o modelo
				VotacaoPage.this.getDefaultModel().detach();
				
				// Atualiza a visibilidade
				configuraVisibilidade();
				
				target.addComponent(votacaoContainer);
				
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
				if (getModelObject().isPodeCancelarVoto())
					imageUrl = "ico_menos.png";
				else
					imageUrl = "ico_menos_inativo.png";
				tag.put("src", context + "html/imagens/" + imageUrl);
			}
		});
		form.add(cancelarVoto);

		form.add(new WebComponent("votosUsuario") {
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
				VotacaoPage.this.onAjaxRequest(target);
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
				
				// Força recarregar o modelo
				VotacaoPage.this.getDefaultModel().detach();
				
				// Atualiza a visibilidade
				configuraVisibilidade();
				
				target.addComponent(votacaoContainer);
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
				if (getModelObject().isPodeVotar())
					imageUrl = "ico_mais.png";
				else
					imageUrl = "ico_mais_inativo.png";
				tag.put("src", context + "html/imagens/" + imageUrl);
			}
		});
		form.add(votar);
		
		
		add( new Label("proposta.texto").setEscapeModelStrings(false));
	}
	
	/**
	 * Método chamado quando houver alguma requisição AJAX
	 * 
	 * @param target
	 */
	protected void onAjaxRequest(AjaxRequestTarget target) {
	}
	
}
