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
package br.gov.camara.edemocracia.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.htmlparser.jericho.Attribute;
import net.htmlparser.jericho.CharacterReference;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.EndTagType;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.HTMLElements;
import net.htmlparser.jericho.OutputDocument;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTag;
import net.htmlparser.jericho.StartTagType;
import net.htmlparser.jericho.Tag;

/**
 * @author robson
 */
public class HtmlStripper {

	private static final Set<String> ALLOWED_TAGS = new HashSet<String>(Arrays.asList(
			HTMLElementName.BR, HTMLElementName.P, HTMLElementName.EM,
	        HTMLElementName.STRONG, HTMLElementName.I, HTMLElementName.U,
	        HTMLElementName.SPAN, HTMLElementName.OL, HTMLElementName.UL,
	        HTMLElementName.LI, HTMLElementName.A));
	private static final Set<String> ALLOWED_ATTRIBUTES = new HashSet<String>(Arrays.asList("alt", "href", "target"));
	
	private static final Object VALID_MARKER = new Object();

	private final Set<String> allowedTags;
	private final Set<String> allowedAttributes;

	public HtmlStripper() {
		allowedTags = new HashSet<String>(ALLOWED_TAGS);
		allowedAttributes = new HashSet<String>(ALLOWED_ATTRIBUTES);
	}
	
	/**
	 * Retira tags indesejadas
	 * 
	 * @param html
	 * @return
	 */
	public String strip(String html) {
		if (html == null)
			return "";
		Source source = new Source(html);
		source.fullSequentialParse();
		OutputDocument output = new OutputDocument(source);
		List<Tag> tags = source.getAllTags();
		int pos = 0;
		for (Tag tag : tags) {
			if (processTag(tag, output)) {
				tag.setUserData(VALID_MARKER);
			} else {
				output.remove(tag);
			}
			reencodeTextSegment(source, output, pos, tag.getBegin());
			pos = tag.getEnd();
		}
		reencodeTextSegment(source, output, pos, source.getEnd());
		return output.toString();
	}
	
	//retorna referência para o próprio objeto para permitir "method-chaining"
	/**
	 * Adds an allowed tag name
	 * @param tagName tag name without < or >
	 * @return this. For method-chaining
	 */
	public HtmlStripper addAllowedTag(String tagName) {
		allowedTags.add(tagName);
		return this;
	}
	
	/**
	 * Adds allowed tag names
	 * @param tagNames tag names without < or >
	 * @return this. For method-chaining
	 */
	public HtmlStripper addAllowedTags(String... tagNames) {
		for (String tagName : tagNames) {
			addAllowedTag(tagName);
		}
		return this;
	}
	
	/**
	 * Removes allowed tag name
	 * @param tagName
	 * @return this. For method-chaining
	 */
	public HtmlStripper removeAllowedTag(String tagName) {
		allowedTags.remove(tagName);
		return this;
	}
	
	/**
	 * Adds allowed attribute name
	 * @param attributeName attribute name without ' or "
	 * @return this. For method-chaining
	 */
	public HtmlStripper addAllowedAttribute(String attributeName) {
		allowedAttributes.add(attributeName);
		return this;
	}
	
	/**
	 * Adds allowed attribute names
	 * @param attributeNames attribute name without ' or "
	 * @return this. For method-chaining
	 */
	public HtmlStripper addAllowedAttributes(String... attributeNames) {
		for (String attributeName : attributeNames) {
			addAllowedAttribute(attributeName);
		}
		return this;
	}
	
	/**
	 * Removes allowed attribute name
	 * @param attributeName attribute name without ' or "
	 * @return this. For method-chaining
	 */
	public HtmlStripper removeAllowedAttribute(String attributeName) {
		allowedAttributes.remove(attributeName);
		return this;
	}
	
	public HtmlStripper clearAllowedTags() {
		allowedTags.clear();
		return this;
	}
	
	public HtmlStripper clearAllowedAttributes() {
		allowedAttributes.clear();
		return this;
	}

	private void reencodeTextSegment(Source source, OutputDocument output, int begin, int end) {
		if (begin >= end)
			return;
		Segment textSegment = new Segment(source, begin, end);
		String decodedText = CharacterReference.decode(textSegment);
		String encodedText = CharacterReference.encode(decodedText);
		output.replace(textSegment, encodedText);
	}

	private boolean processTag(Tag tag, OutputDocument output) {
		String elementName = tag.getName().toLowerCase();
		if (!allowedTags.contains(elementName))
			return false;
		if (tag.getTagType() == StartTagType.NORMAL) {
			Element element = tag.getElement();
			if (HTMLElements.getEndTagRequiredElementNames().contains(elementName)) {
				if (element.getEndTag() == null)
					return false; // reject start tag if its required end tag is
					              // missing
			} else if (HTMLElements.getEndTagOptionalElementNames().contains(elementName)) {
				if (elementName == HTMLElementName.LI && !isValidLITag(tag))
					return false; // reject invalid LI tags
				if (element.getEndTag() == null)
					// insert optional end tag if it is missing
					output.insert(element.getEnd(), getEndTagHTML(elementName));
			}
			output.replace(tag, getStartTagHTML(element.getStartTag()));
		} else if (tag.getTagType() == EndTagType.NORMAL) {
			if (tag.getElement() == null)
				return false; // reject end tags that aren't associated with a
				              // start tag
			if (elementName == HTMLElementName.LI && !isValidLITag(tag))
				return false; // reject invalid LI tags
			output.replace(tag, getEndTagHTML(elementName));
		} else {
			return false; // reject abnormal tags
		}
		return true;
	}

	private CharSequence getStartTagHTML(StartTag startTag) {
		// tidies and filters out non-approved attributes
		StringBuilder sb = new StringBuilder();
		sb.append('<').append(startTag.getName());
		for (Attribute attribute : startTag.getAttributes()) {
			if (allowedAttributes.contains(attribute.getKey())) {
				sb.append(' ').append(attribute.getName());
				if (attribute.getValue() != null) {
					sb.append("=\"");
					sb.append(CharacterReference.encode(attribute.getValue()));
					sb.append('"');
				}
			}
		}
		if (startTag.getElement().getEndTag() == null && !HTMLElements.getEndTagOptionalElementNames().contains(startTag.getName()))
			sb.append(" /");
		sb.append('>');
		return sb;
	}

	private static String getEndTagHTML(String tagName) {
		return "</" + tagName + ">";
	}

	private boolean isValidLITag(Tag tag) {
		Element parentElement = tag.getElement().getParentElement();
		if (parentElement == null)
			return false; // ignore LI elements without a parent
		if (parentElement.getStartTag().getUserData() != VALID_MARKER)
			return false; // ignore LI elements who's parent is not valid
		// only accept LI tags who's immediate parent is UL or OL.
		return parentElement.getName() == HTMLElementName.UL || parentElement.getName() == HTMLElementName.OL; 
	}
}
