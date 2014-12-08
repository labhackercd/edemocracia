/**
 * 
 */
package br.gov.camara.edemocracia.portlets.priorizacao.ui;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import br.gov.camara.edemocracia.portlets.priorizacao.ui.admin.pages.HomePage;

/**
 * @author rpdmiranda
 *
 */
public class ConfigPriorizacaoApplication extends WebApplication {

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends Page> getHomePage() {
		// TODO Auto-generated method stub
		return HomePage.class;
	}
	
	@Override
	protected void init() {
		super.init();
		getMarkupSettings().setStripWicketTags(true);
		getMarkupSettings().setDefaultAfterDisabledLink("");
		getMarkupSettings().setDefaultBeforeDisabledLink("");
		getMarkupSettings().setStripComments(true);

	}
}
