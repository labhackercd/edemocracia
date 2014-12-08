/**
 * 
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
