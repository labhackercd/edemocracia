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
