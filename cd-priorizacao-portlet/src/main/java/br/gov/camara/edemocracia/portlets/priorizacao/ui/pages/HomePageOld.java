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

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.PageParameters;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.protocol.http.WebRequest;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.panels.MenuPanel;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Página inicial de apresentação das propostas
 * 
 * @author robson
 * 
 */
public class HomePageOld extends WebPage {

	private RefreshingView<Eixo> eixos;
	private static final Log LOG = LogFactoryUtil
			.getLog(HomePageOld.class);
	
	public HomePageOld() {
		
		initMenu();
		initEixos();
		
	}
	
	private void initMenu() {
		add(new MenuPanel("menu"));
	}

	private void initEixos() {
		eixos = new RefreshingView<Eixo>("eixos") {

			@Override
			protected Iterator<IModel<Eixo>> getItemModels() {
				return listEixos();
			}

			@Override
			protected void populateItem(Item<Eixo> item) {
				item.add(new Label("titulo", new ComponentPropertyModel<String>("titulo")));
				item.add(new Label("sumario", new ComponentPropertyModel<String>("sumario")));

				final Long eixoId = item.getModelObject() != null ? item.getModelObject().getEixoId() : null;
				RefreshingView<Proposta> propostas = new RefreshingView<Proposta>("propostas") {

					@Override
					protected Iterator<IModel<Proposta>> getItemModels() {
						return listPropostas(eixoId);
					}

					@Override
					protected void populateItem(Item<Proposta> item) {
						PageParameters params = new PageParameters();
						if (item.getModelObject() != null)
							params.put("proposta", item.getModelObject().getPropostaId());
						BookmarkablePageLink<Void> link = new BookmarkablePageLink<Void>("link", VotacaoPage.class, params);
						link.add(new Label("identificador"));
						item.add(link);
						item.add(new Label("ementa"));
					}
				};
				propostas.setVisible(getPropostasCount(eixoId) != 0);
				item.add(propostas);
			}
		};
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
				for (Proposta proposta : PriorizacaoServiceUtil.listarPropostasPorEixoId(eixoId)) {
					final long propostaId = proposta.getPropostaId();
					retorno.add(new CompoundPropertyModel<Proposta>(new LoadableDetachableModel<Proposta>(proposta) {
						@Override
						protected Proposta load() {
							try {
								return PriorizacaoServiceUtil.getProposta(propostaId);
							} catch (PortalException e) {
								//TODO Log
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
	
	private int getPropostasCount(long eixoId){
		try {
			return PriorizacaoServiceUtil.getPropostasCountByEixoId(eixoId);
		} catch (SystemException e) {
			//TODO
			LOG.error("Erro ao obter número de propostas do eixo",e);
		}
		return 0;
	}
	

	/**
	 * Obtém a lista de eixos
	 * 
	 * @return
	 */
	private Iterator<IModel<Eixo>> listEixos() {
		ArrayList<IModel<Eixo>> retorno = new ArrayList<IModel<Eixo>>();

		HttpServletRequest request = ((WebRequest) (RequestCycle.get()).getRequest()).getHttpServletRequest();

		try {
			long scopeGroupId = PortalUtil.getScopeGroupId(request);

			for (Eixo eixo : PriorizacaoServiceUtil.listarEixos(scopeGroupId)) {
				final long eixoId = eixo.getEixoId();
				retorno.add(new LoadableDetachableModel<Eixo>(eixo) {
					@Override
					protected Eixo load() {
						try {
							return PriorizacaoServiceUtil.getEixo(eixoId);
						} catch (PortalException e) {
							// TODO Log
							LOG.error("Erro ao obter eixo.");
							return null;
						} catch (SystemException e) {
							// TODO Log
							LOG.error("Erro ao obter eixo.");
							return null;
						}
					}
				});
			}
		} catch (PortalException e) {
			// TODO Log
			LOG.error("Erro ao obter lista de eixos.", e);
		} catch (SystemException e) {
			// TODO Log
			LOG.error("Erro ao obter lista de eixos.", e);
		}
		return retorno.iterator();
	}
}
