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
package br.gov.camara.edemocracia.portlets.wikilegis.ui;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import br.gov.camara.edemocracia.portlets.wikilegis.ui.pages.ConfiguracaoPage;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.pages.ContribuicaoPage;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.pages.HomePage;

/**
 * @author robson
 *
 */
public class WikilegisApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}
	@Override
	protected void init() {
		super.init();
		getMarkupSettings().setStripWicketTags(true);
		getMarkupSettings().setDefaultAfterDisabledLink("");
		getMarkupSettings().setDefaultBeforeDisabledLink("");
		mountBookmarkablePage("edit", ConfiguracaoPage.class);
		mountBookmarkablePage("artigo", ContribuicaoPage.class);

	}
}
