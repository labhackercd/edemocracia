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
package br.gov.camara.edemocracia.portlets.priorizacao.ui.panels;

import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.markup.html.panel.Panel;

import br.gov.camara.edemocracia.portlets.priorizacao.ui.pages.HomePage;	
import br.gov.camara.edemocracia.portlets.priorizacao.ui.components.MenuLink;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.pages.SumarioAleatorioPage;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.pages.SumarioPage;
import br.gov.camara.edemocracia.portlets.priorizacao.ui.resources.CsvVotacaoResource;

public class MenuPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public MenuPanel(String id) {
		super(id);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		initInicio();
		initSituacaoVotacao();
//		initSituacaoAleatoria();
		initDados();
	}
	
	private void initInicio(){
		add(new MenuLink<HomePage>("inicio", HomePage.class));
	}
	
	private void initSituacaoVotacao(){
		add(new MenuLink<SumarioPage>("situacaoVotacao", SumarioPage.class));
	}
	
	private void initSituacaoAleatoria(){
		add(new MenuLink<SumarioAleatorioPage>("situacaoAleatoria", SumarioAleatorioPage.class));
	}
	
	private void initDados() {
		add(new ResourceLink<Void>("dados", new CsvVotacaoResource()));
	}

}
