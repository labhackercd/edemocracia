package br.gov.camara.edemocracia.movetopico;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import br.gov.camara.edemocracia.movetopico.view.HomePage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @author Ricardo Lima - ricardo.lima@camara.gov.br
 *
 */
public class MoveTopicoApplication extends WebApplication
{    
	/**
	 * Constructor
	 */
	public MoveTopicoApplication()
	{
	}
	
//	protected SpringComponentInjector getSpringInjector()
//	{
//		return new SpringComponentInjector(this);
//	}

//	@Override
//	protected void init() {
//		super.init();
//		addComponentInstantiationListener(getSpringInjector());
//
//	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

}
