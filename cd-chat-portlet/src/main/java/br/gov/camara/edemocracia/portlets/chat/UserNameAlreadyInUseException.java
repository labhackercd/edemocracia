/**
 * 
 */
package br.gov.camara.edemocracia.portlets.chat;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author robson
 * 
 */
public class UserNameAlreadyInUseException extends PortalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final List<String> suggestions;

	public UserNameAlreadyInUseException(List<String> suggestions) {
		this.suggestions = Collections.unmodifiableList(suggestions);
	}

	/**
	 * @return the suggestions
	 */
	public final List<String> getSuggestions() {
		return suggestions;
	}

}
