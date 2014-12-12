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
