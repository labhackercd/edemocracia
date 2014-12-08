package br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.pages;

import org.apache.wicket.markup.html.WebPage;

import br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.panels.PriorizacaoAdminMenuPanel;

public class HomePage extends WebPage{
	
	public HomePage() {
		initMenu();
	}
	
	
	private void initMenu() {
		add(new PriorizacaoAdminMenuPanel("menuPriorizacao"));
	}
	
}
