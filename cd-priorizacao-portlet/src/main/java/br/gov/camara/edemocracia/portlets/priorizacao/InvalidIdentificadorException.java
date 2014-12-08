package br.gov.camara.edemocracia.portlets.priorizacao;

import com.liferay.portal.kernel.exception.PortalException;

public class InvalidIdentificadorException extends PortalException {

	private static final long serialVersionUID = 1L;

	public InvalidIdentificadorException() {
		super();
	}

	public InvalidIdentificadorException(String msg) {
		super(msg);
	}

	public InvalidIdentificadorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidIdentificadorException(Throwable cause) {
		super(cause);
	}
	
}
