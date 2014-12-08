/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.components;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.parser.XmlTag;
import org.apache.wicket.model.IModel;

/**
 * Adiciona uma âncora em HTML
 * 
 * @author robson
 *
 */
public class Anchor extends WebComponent {

	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param model
	 */
	public Anchor(String id, IModel<?> model) {
		super(id, model);
	}

	/**
	 * @param id
	 */
	public Anchor(String id) {
		super(id);
	}
	
	/**
	 * @see org.apache.wicket.Component#onComponentTagBody(org.apache.wicket.markup.MarkupStream,
	 *      org.apache.wicket.markup.ComponentTag)
	 */
	@Override
	protected void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
	{
		replaceComponentTagBody(markupStream, openTag, "");
	}

	/**
	 * @see org.apache.wicket.Component#onComponentTag(org.apache.wicket.markup.ComponentTag)
	 */
	@Override
	protected void onComponentTag(ComponentTag tag)
	{
		super.onComponentTag(tag);
		tag.setType(XmlTag.OPEN);
		tag.put("id", getDefaultModelObjectAsString());
		tag.put("name", getDefaultModelObjectAsString());
	}
}
