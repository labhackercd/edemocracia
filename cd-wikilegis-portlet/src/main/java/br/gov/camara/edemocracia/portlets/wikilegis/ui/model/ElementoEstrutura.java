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
package br.gov.camara.edemocracia.portlets.wikilegis.ui.model;

import java.io.Serializable;

public class ElementoEstrutura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final long estruturaId;
	private final String texto;

	public ElementoEstrutura(long estruturaId, String texto) {
		this.estruturaId = estruturaId;
		this.texto = texto;
	}

	public long getEstruturaId() {
		return estruturaId;
	}

	public String getTexto() {
		return texto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (estruturaId ^ (estruturaId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ElementoEstrutura))
			return false;
		ElementoEstrutura other = (ElementoEstrutura) obj;
		if (estruturaId != other.estruturaId)
			return false;
		return true;
	}
	
	
}