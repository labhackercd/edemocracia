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
