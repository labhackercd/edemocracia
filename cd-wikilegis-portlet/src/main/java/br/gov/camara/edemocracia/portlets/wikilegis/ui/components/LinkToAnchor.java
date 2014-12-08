/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.components;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

/**
 * Link para uma âncora no documento
 * 
 * @author robson
 * 
 */
public class LinkToAnchor extends WebMarkupContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LinkToAnchor(String id, IModel<?> model) {
		super(id, model);
	}

	public LinkToAnchor(String id) {
		super(id);
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
		checkComponentTag(tag, "a");
		tag.put("href", "#" + getDefaultModelObjectAsString());
	}
	
}
