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

import com.liferay.portal.NoSuchModelException;

/**
 * @author Ricardo Lima
 */
public class NoSuchChatRoomMessageException extends NoSuchModelException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 662550742200330430L;

	public NoSuchChatRoomMessageException() {
		super();
	}

	public NoSuchChatRoomMessageException(String msg) {
		super(msg);
	}

	public NoSuchChatRoomMessageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchChatRoomMessageException(Throwable cause) {
		super(cause);
	}

}