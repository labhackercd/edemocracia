package br.gov.camara.edemocracia.portlets.chat;

import com.liferay.portal.kernel.exception.PortalException;

public class CantRemoveOpenedChatRoom extends PortalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2609797954287263985L;

	public CantRemoveOpenedChatRoom() {
		super();
	}

	public CantRemoveOpenedChatRoom(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CantRemoveOpenedChatRoom(String msg) {
		super(msg);
	}

	public CantRemoveOpenedChatRoom(Throwable cause) {
		super(cause);
	}

}
