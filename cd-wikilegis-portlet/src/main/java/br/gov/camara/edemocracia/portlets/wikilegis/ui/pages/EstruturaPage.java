package br.gov.camara.edemocracia.portlets.wikilegis.ui.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.AlterarEstruturaPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.NovaEstruturaPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.WikiLegisMenuPanel;

/**
 * Página de edição da estrutura do texto
 * 
 * @author robson
 * 
 */
public class EstruturaPage extends WebPage {
	
	public EstruturaPage() {
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		init();
	}
	
	private void init() {
		
		initMensagens();
		initMenuWikilegis();
		initNovoAgrupamento();
		initAlterarAgrupamento();
		
	}

	private void initMensagens() {
		add( new FeedbackPanel("mensagens"));
	}

	private void initNovoAgrupamento() {
		add(new NovaEstruturaPanel("novoAgrupamento"));
	}

	private void initAlterarAgrupamento() {
		add(new AlterarEstruturaPanel("alterarAgrupamento"));
	}

	private void initMenuWikilegis() {
		add(new WikiLegisMenuPanel("menuWikilegis"));
	}

}
