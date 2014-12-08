/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.util;

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
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTag;
import net.htmlparser.jericho.StartTagType;
import net.htmlparser.jericho.Tag;

/**
 * @author robson
 * 
 */
public class HtmlStripperDiscussion {

	private static final Set<String> ALLOWED_TAGS = new HashSet<String>(
			Arrays.asList(HTMLElementName.A));
	private static final Set<String> ALLOWED_ATTRIBUTES = new HashSet<String>(
			Arrays.asList("name"));

	private final Set<String> allowedTags;
	private final Set<String> allowedAttributes;

	public HtmlStripperDiscussion() {
		allowedTags = new HashSet<String>(ALLOWED_TAGS);
		allowedAttributes = new HashSet<String>(ALLOWED_ATTRIBUTES);
	}

	private static final Object VALID_MARKER = new Object();

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

		for (Tag tag : tags) {
			if (processTag(tag, output)) {
				tag.setUserData(VALID_MARKER);
			} else {
				output.remove(tag);
			}
//			reencodeTextSegment(source, output, pos, tag.getBegin());
		}
//		reencodeTextSegment(source, output, pos, source.getEnd());
		return output.toString();
	}

	private boolean processTag(Tag tag, OutputDocument output) {
		String elementName = tag.getName().toLowerCase();
		if (!allowedTags.contains(elementName))
			return false;
		if (tag.getTagType() == StartTagType.NORMAL) {
			Element element = tag.getElement();
			if (HTMLElements.getEndTagRequiredElementNames().contains(
					elementName)) {
				if (element.getEndTag() == null)
					return false; // reject start tag if its required end tag is
									// missing
			} else if (HTMLElements.getEndTagOptionalElementNames().contains(
					elementName)) {
				if (elementName == HTMLElementName.LI && !isValidLITag(tag))
					return false; // reject invalid LI tags
				if (element.getEndTag() == null)
					output.insert(element.getEnd(), getEndTagHTML(elementName)); // insert
																					// optional
																					// end
																					// tag
																					// if
																					// it
																					// is
																					// missing
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
		if (startTag.getElement().getEndTag() == null
				&& !HTMLElements.getEndTagOptionalElementNames().contains(
						startTag.getName()))
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
		return parentElement.getName() == HTMLElementName.UL
				|| parentElement.getName() == HTMLElementName.OL; // only accept
																	// LI tags
																	// who's
																	// immediate
																	// parent is
																	// UL or OL.
	}
}