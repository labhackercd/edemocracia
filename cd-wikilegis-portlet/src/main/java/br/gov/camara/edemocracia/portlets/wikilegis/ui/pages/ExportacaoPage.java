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
