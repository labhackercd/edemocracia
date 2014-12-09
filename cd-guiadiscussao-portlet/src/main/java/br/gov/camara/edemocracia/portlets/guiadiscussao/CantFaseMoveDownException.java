package br.gov.camara.edemocracia.portlets.guiadiscussao;

import com.liferay.portal.kernel.exception.PortalException;

public class CantFaseMoveDownException extends PortalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4838015552764092560L;

	public CantFaseMoveDownException() {
		super();
	}
	
	public CantFaseMoveDownException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CantFaseMoveDownException(String msg) {
		super(msg);
	}

	public CantFaseMoveDownException(Throwable cause) {
		super(cause);
	}
	
}
