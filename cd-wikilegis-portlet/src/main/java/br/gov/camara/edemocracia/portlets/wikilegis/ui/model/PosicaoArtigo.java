/**
 * 
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
