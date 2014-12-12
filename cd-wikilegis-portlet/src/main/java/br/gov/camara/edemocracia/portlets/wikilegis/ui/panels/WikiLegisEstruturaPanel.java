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
package br.gov.camara.edemocracia.portlets.wikilegis.ui.panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.IModel;

import br.gov.camara.edemocracia.portlets.wikilegis.EstruturaDisplay;
import br.gov.camara.edemocracia.portlets.wikilegis.ui.components.Anchor;

/**
 * @author rpdmiranda
 * 
 */
public class WikiLegisEstruturaPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public WikiLegisEstruturaPanel(String id, IModel<EstruturaDisplay> model) {
		super(id, model);

		Anchor anchor = new Anchor("nodeName", new ComponentPropertyModel<String>("nodeName"));
		add(anchor);
		Label l = new Label("textoFormatado", new ComponentPropertyModel<String>("textoFormatado"));
		l.setEscapeModelStrings(false);
		add(l);
	}

}
