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

/**
 * @author rpdmiranda
 *
 */
public class PosicaoArtigo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final long estruturaPaiId;
	
	private final long artigoAnteriorId;

	public PosicaoArtigo(long paiId, long artigoAnteriorId) {
		this.estruturaPaiId = paiId;
		this.artigoAnteriorId = artigoAnteriorId;
	}

	/**
	 * @return the estruturaPaiId
	 */
	public long getEstruturaPaiId() {
		return estruturaPaiId;
	}

	/**
	 * @return the artigoAnteriorId
	 */
	public long getArtigoAnteriorId() {
		return artigoAnteriorId;
	}
}
