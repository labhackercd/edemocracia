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
package br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.pages.eixo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RefreshingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.panels.PriorizacaoAdminMenuPanel;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.components.ExcluirEixoLink;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;

import com.google.common.collect.Iterators;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.messageboards.model.MBCategory;

public class GerenciarEixosPage extends WebPage {

	private RefreshingView<Eixo> eixos;
	private static final Log LOG = LogFactoryUtil.getLog(GerenciarEixosPage.class);
	private WebMarkupContainer eixosContainer;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		initMenuPriorizacao();
		initAdicionarEixo();
		initMensagensFeedback();
		initEixosContainer();
		initEixos();
		
	}
		
	private void initMenuPriorizacao() {
		add(new PriorizacaoAdminMenuPanel("menuPriorizacao"));
	}
	
	private void initAdicionarEixo() {
		add(new Link<Void>("adicionarEixo"){
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				PageParameters parameters = new PageParameters();
//				parameters.put("eixoId", "");
				setResponsePage(EixoPage.class,parameters);
			}
			
		});
	}

	private void initMensagensFeedback() {
		add( new FeedbackPanel("mensagensFeedback"));
	}
	
	private void initEixosContainer() {
		eixosContainer = new WebMarkupContainer("eixosContainer");
		
		if(getEixosCount() != 0){
			eixosContainer.setVisible(true);
		} else {
			eixosContainer.setVisible(false);
			warn("Nenhum eixo cadastrado.");
		}
		add(eixosContainer);
	}
	
	private void initEixos() {
		eixos = new RefreshingView<Eixo>("eixos") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(Item<Eixo> item) {
				item.add(new Label("titulo",Model.of(item.getModelObject().getTitulo())));
				item.add(new Label("categoria",Model.of(getCategory(item.getModelObject().getCategoryId()).getName())));
				item.add(new UpdateEixoLink("update", item.getModelObject().getEixoId()));
				item.add(new ExcluirEixoLink("excluir", item.getModelObject().getEixoId()){
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						super.onClick();
						setResponsePage(GerenciarEixosPage.class);
					}
				});
			}
			
			@Override
			protected Iterator<IModel<Eixo>> getItemModels() {
				return listarEixos();
			}
						
		};
	
		eixosContainer.add(eixos);
	}
	
	private Iterator<IModel<Eixo>>listarEixos(){

		try{
			List<Eixo> eixos = PriorizacaoServiceUtil.listarEixos(UIUtils.getScopeGroupId());
			ArrayList<IModel<Eixo>> retorno = new ArrayList<IModel<Eixo>>();
			for(Eixo eixo : eixos){
				retorno.add(new Model<Eixo>(eixo));
			}
			return retorno.iterator();					
		}catch(SystemException e){					
			return Iterators.emptyIterator();
		}
	}
	
	private MBCategory getCategory(long categoryId){
		return PriorizacaoServiceUtil.getMBCategory(categoryId);
	}
	
	private int getEixosCount(){
		
		try {
			return PriorizacaoServiceUtil.getEixosCountByGroupId(UIUtils.getScopeGroupId());
		} catch (SystemException e) {
			LOG.error("Erro ao obter quantidade de eixos");
		}
		return 0;
	}
 	
	class UpdateEixoLink extends Link<EixoPage> {
		private static final long serialVersionUID = 1L;
		private long eixoId;
		public UpdateEixoLink(String id,long eixoId) {
			super(id);
			this.eixoId = eixoId;
		}		
		@Override
		public void onClick() {
			PageParameters parameters = new PageParameters();
			parameters.put("eixoId", String.valueOf(eixoId));
			setResponsePage(EixoPage.class,parameters);
		}
	}
	
	

}
