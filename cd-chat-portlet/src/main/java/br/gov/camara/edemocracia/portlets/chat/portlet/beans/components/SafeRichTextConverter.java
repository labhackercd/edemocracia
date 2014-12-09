package br.gov.camara.edemocracia.portlets.chat.portlet.beans.components;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

/**
 * Conversor de Strings provenientes de componentes de texto rico que remove elementos inseguros 
 * do texto, como códigos javascript.
 * @author Victor Bortone
 */
@FacesConverter("br.gov.camara.edemocracia.SafeRichTextConverter")
public class SafeRichTextConverter implements Converter {

	private static final PolicyFactory POLICY = new HtmlPolicyBuilder()
			.allowCommonInlineFormattingElements()
			.allowCommonBlockElements()
			.allowStandardUrlProtocols()
			.allowWithoutAttributes("div", "span")
			.allowAttributes("style").globally()
			.allowAttributes("href").onElements("a")
			.allowAttributes("size", "face", "color", "id").onElements("font")
			.allowElements("a", "em", "dfn", "hr")
			.allowStandardUrlProtocols()
			.toFactory();
	
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		return POLICY.sanitize(value);
    }

	@Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}
	    return value.toString();
    }
}
