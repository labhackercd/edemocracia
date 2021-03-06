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
public class EstruturaLabel extends Label {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 */
	public EstruturaLabel(String id) {
		super(id);
	}

	/**
	 * @param id
	 * @param label
	 */
	public EstruturaLabel(String id, String label) {
		super(id, label);
	}

	/**
	 * @param id
	 * @param model
	 */
	public EstruturaLabel(String id, IModel<?> model) {
		super(id, model);
	}

	/**
	 * 
	 */
	@Override
	protected void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
		Object obj = getDefaultModelObject();
		String estrutura = "";
		Locale locale = UIUtils.getUserLocale();
		if (obj != null) {
			if (obj instanceof String)
				estrutura = ((String) obj).trim();
			else
				estrutura = getConverter(obj.getClass()).convertToString(obj, locale).trim();
		}
		estrutura = StringUtils.formataEstrutura(estrutura);
		replaceComponentTagBody(markupStream, openTag, estrutura);
	}

}
