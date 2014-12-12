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
