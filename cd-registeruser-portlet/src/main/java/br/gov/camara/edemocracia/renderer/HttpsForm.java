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
package br.gov.camara.edemocracia.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import com.sun.faces.renderkit.Attribute;
import com.sun.faces.renderkit.AttributeManager;
import com.sun.faces.renderkit.RenderKitUtils;
import com.sun.faces.renderkit.html_basic.FormRenderer;

public class HttpsForm extends FormRenderer {

	private static final Attribute[] ATTRIBUTES = AttributeManager.getAttributes(AttributeManager.Key.FORMFORM);

	private boolean writeStateAtEnd;

	@Override
	public void decode(FacesContext context, UIComponent component) {
		super.decode(context, component);

	}

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		rendererParamsNotNull(context, component);

		if (!shouldEncode(component)) {
			return;
		}

		ResponseWriter writer = context.getResponseWriter();
		assert (writer != null);
		String clientId = component.getClientId(context);
		// since method and action are rendered here they are not added
		// to the pass through attributes in Util class.
		writer.write('\n');
		writer.startElement("form", component);
		writer.writeAttribute("id", clientId, "clientId");
		writer.writeAttribute("name", clientId, "name");
		writer.writeAttribute("method", "post", null);
		writer.writeAttribute("action", getActionStr(context), null);
		String styleClass = (String) component.getAttributes().get("styleClass");
		if (styleClass != null) {
			writer.writeAttribute("class", styleClass, "styleClass");
		}
		String acceptcharset = (String) component.getAttributes().get("acceptcharset");
		if (acceptcharset != null) {
			writer.writeAttribute("accept-charset", acceptcharset, "acceptcharset");
		}

		RenderKitUtils.renderPassThruAttributes(context, writer, component, ATTRIBUTES);
		writer.writeText("\n", component, null);

		// this hidden field will be checked in the decode method to
		// determine if this form has been submitted.
		writer.startElement("input", component);
		writer.writeAttribute("type", "hidden", "type");
		writer.writeAttribute("name", clientId, "clientId");
		writer.writeAttribute("value", clientId, "value");
		writer.endElement("input");
		writer.write('\n');

		// Write out special hidden field for partial submits
		String viewId = context.getViewRoot().getViewId();
		String actionURL = context.getApplication().getViewHandler().getActionURL(context, viewId);
		ExternalContext externalContext = context.getExternalContext();
		String encodedActionURL = externalContext.encodeActionURL(actionURL);
		String encodedPartialActionURL = externalContext.encodePartialActionURL(actionURL);
		if (encodedPartialActionURL != null) {
			if (!encodedPartialActionURL.equals(encodedActionURL)) {
				writer.startElement("input", component);
				writer.writeAttribute("type", "hidden", "type");
				writer.writeAttribute("name", "javax.faces.encodedURL", null);
				writer.writeAttribute("value", encodedPartialActionURL, "value");
				writer.endElement("input");
				writer.write('\n');
			}
		}

		if (!writeStateAtEnd) {
			context.getApplication().getViewHandler().writeState(context);
			writer.write('\n');
		}

	}

	@Override
	public void encodeEnd(FacesContext arg0, UIComponent arg1) throws IOException {
		super.encodeEnd(arg0, arg1);
	}

	private static String getActionStr(FacesContext context) {
		String viewId = context.getViewRoot().getViewId();
		String actionURL = context.getApplication().getViewHandler().getActionURL(context, viewId);
		String urlWithoutHTTPS = context.getExternalContext().encodeActionURL(actionURL);

		return changeURLForHTTPS(urlWithoutHTTPS);

	}

	private static String changeURLForHTTPS(String url) {
//		return url.replace("http://localhost:8080", "https://localhost:8443");
		return url.replace("http://", "https://");
	};

}
