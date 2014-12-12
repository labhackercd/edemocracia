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
