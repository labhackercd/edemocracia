/**
 * 
 */
package br.gov.camara.edemocracia.portlets.inscricaoforum;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * @author P_7339
 *
 */
public class AssinaturaForumApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

}
