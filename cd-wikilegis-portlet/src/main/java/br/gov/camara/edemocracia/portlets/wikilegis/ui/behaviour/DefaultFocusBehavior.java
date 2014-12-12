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
package br.gov.camara.edemocracia.portlets.wikilegis.ui.behaviour;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.form.FormComponent;

/**
 * @see http://www.nabble.com/Default-Focus-Behavior--td15934889.html
 */
public class DefaultFocusBehavior extends AbstractBehavior {
	private static final long serialVersionUID = -4891399118136854774L;

	private Component component;

	@Override
	public void bind(Component component) {
		if (!(component instanceof FormComponent)) {
			throw new IllegalArgumentException("DefaultFocusBehavior: component must be instanceof FormComponent");
		}
		this.component = component;
		component.setOutputMarkupId(true);
	}

	@Override
	public void renderHead(IHeaderResponse iHeaderResponse) {
		super.renderHead(iHeaderResponse);
		iHeaderResponse.renderOnLoadJavascript("document.getElementById('" + component.getMarkupId() + "').focus();");
	}
}