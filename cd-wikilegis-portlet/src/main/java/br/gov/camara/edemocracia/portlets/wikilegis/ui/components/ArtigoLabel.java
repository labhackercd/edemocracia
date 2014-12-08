/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.components;

import java.util.Locale;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import br.gov.camara.edemocracia.portlets.wikilegis.ui.util.UIUtils;
import br.gov.camara.edemocracia.portlets.wikilegis.util.StringUtils;

/**
 * @author robson
 * 
 */
public class ArtigoLabel extends Label {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean primeiraLinhaInline;
	/**
	 * @param id
	 */
	public ArtigoLabel(String id) {
		super(id);
	}

	/**
	 * @param id
	 * @param label
	 */
	public ArtigoLabel(String id, String label, boolean primeiraLinhaInline) {
		super(id, label);
		this.primeiraLinhaInline = primeiraLinhaInline;
	}

	/**
	 * @param id
	 * @param model
	 */
	public ArtigoLabel(String id, IModel<?> model, boolean primeiraLinhaInline) {
		super(id, model);
		this.primeiraLinhaInline = primeiraLinhaInline;
	}

	/**
	 * 
	 */
	@Override
	protected void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
		Object obj = getDefaultModelObject();
		String artigo = "";
		Locale locale = UIUtils.getUserLocale();
		if (obj != null) {
			if (obj instanceof String)
				artigo = ((String) obj).trim();
			else
				artigo = getConverter(obj.getClass()).convertToString(obj, locale).trim();
		}
		artigo = StringUtils.formataArtigo(artigo, primeiraLinhaInline);
		replaceComponentTagBody(markupStream, openTag, artigo);
	}

}
