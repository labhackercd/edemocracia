package br.gov.camara.edemocracia.portlets.guiadiscussao;

import com.liferay.portal.kernel.exception.PortalException;

public class CantFaseMoveUpException extends PortalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1062736865440031991L;
	
	public CantFaseMoveUpException() {
		super();
	}
	
	public CantFaseMoveUpException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CantFaseMoveUpException(String msg) {
		super(msg);
	}

	public CantFaseMoveUpException(Throwable cause) {
		super(cause);
	}
	
}
