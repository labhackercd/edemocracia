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

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.LoadableDetachableModel;

import br.gov.camara.edemocracia.portlets.priorizacao.EixoSumario;
import br.gov.camara.edemocracia.portlets.priorizacao.OrdemProposta;
import br.gov.camara.edemocracia.portlets.priorizacao.PriorizacaoSumario;
import br.gov.camara.edemocracia.portlets.priorizacao.PropostaSumario;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.service.util.PriorizacaoPermissionsUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.panels.MenuPanel;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.util.UIUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * Sumário da priorização
 * 
 * @author robson
 * 
 */
public class SumarioPage extends WebPage {

	private static final Log LOG = LogFactoryUtil.getLog(SumarioPage.class);
	private boolean podeVerVotos;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		initPodeVerVotos();
	}
	
	public SumarioPage() {

		LoadableDetachableModel<PriorizacaoSumario> model = new LoadableDetachableModel<PriorizacaoSumario>() {

			@Override
			protected PriorizacaoSumario load() {
				long groupId = UIUtils.getScopeGroupId();
				try {
					return PriorizacaoServiceUtil.getSumarioPriorizacao(
							groupId,
							new OrdemProposta[] {OrdemProposta.VOTOS});
				} catch (SystemException e) {
					throw new RuntimeException(e);
				}
			}
		};
		setDefaultModel(new CompoundPropertyModel<PriorizacaoSumario>(model));
		
		add(new MenuPanel("menu"));
		add(new Label("totalVotos"));
		add(new PropertyListView<EixoSumario>("eixos") {

			@Override
			protected void populateItem(ListItem<EixoSumario> item) {
				item.setVisible(getPropostasCount(item.getModelObject().getEixoId()) != 0);
				item.add(new Label("nome"));
				item.add(new Label("totalVotos"));
				item.add(new WebMarkupContainer("colunaVotos").setVisible(podeVerVotos));
				item.add(new PropertyListView<PropostaSumario>("propostasOrdenadas") {

					@Override
					protected void populateItem(ListItem<PropostaSumario> item) {
						item.add(new Label("identificador"));
						item.add(new Label("nome"));
						item.add(new Label("numeroVotos").setVisible(podeVerVotos));
					}
				});
			}
		});

	}

	private void initPodeVerVotos(){
		ThemeDisplay td = UIUtils.getThemeDisplay();
		podeVerVotos = PriorizacaoPermissionsUtil
				.hasPermission(td.getPermissionChecker(),td.getScopeGroupId(),"VIEW_VOTE");		
	}
	
	private int getPropostasCount(long eixoId) {
		try {
			return PriorizacaoServiceUtil.getPropostasCountByEixoId(eixoId);
		} catch (SystemException e) {
			LOG.error("Erro ao obter número de propostas do eixo", e);
		}
		return 0;
	}

}
