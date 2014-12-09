package br.gov.camara.edemocracia.portlets.chat;

import com.liferay.portal.kernel.exception.SystemException;

public class RoomWithSameNameInCommunityException extends SystemException {

	private static final long serialVersionUID = 8120859583531911537L;

	public RoomWithSameNameInCommunityException() {
		super();
	}

	public RoomWithSameNameInCommunityException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RoomWithSameNameInCommunityException(String msg) {
		super(msg);
	}

	public RoomWithSameNameInCommunityException(Throwable cause) {
		super(cause);
	}

}
