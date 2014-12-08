/**
 * 
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
