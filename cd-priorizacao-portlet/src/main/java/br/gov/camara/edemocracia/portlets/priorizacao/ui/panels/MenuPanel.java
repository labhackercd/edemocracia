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
