/**
 * 
 */
package br.gov.camara.edemocracia.portlets.bloqueioforum;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Portlet para bloqueio de um forum
 * 
 * @author p_7339
 *
 */
public class BloqueioForumApplication extends WebApplication {

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends Page> getHomePage() {
		return BloqueioForumHome.class;
	}

}
