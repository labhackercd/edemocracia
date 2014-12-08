package br.gov.camara.edemocracia.portlets.wikilegis.ui.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.ResourceLink;

import br.gov.camara.edemocracia.portlets.wikilegis.ui.panels.WikiLegisMenuPanel;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.resources.CSVComentariosResource;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.resources.CSVContribuicaoResource;


public class ExportacaoPage extends WebPage{
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		initMenuWikilegis();
		initExportarContribuicoes();
		initExportarComentarios();
	}
	
	public ExportacaoPage() {

	}
	
	private void initMenuWikilegis() {
		add(new WikiLegisMenuPanel("menuWikilegis"));
	}
	
	private void initExportarComentarios() {
		add(new ResourceLink<Void>("exportarComentarios", new CSVComentariosResource()));
	}

	private void initExportarContribuicoes() {
		add(new ResourceLink<Void>("exportarContribuicoes", new CSVContribuicaoResource()));
	}
		
}
