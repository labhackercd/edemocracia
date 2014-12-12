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
