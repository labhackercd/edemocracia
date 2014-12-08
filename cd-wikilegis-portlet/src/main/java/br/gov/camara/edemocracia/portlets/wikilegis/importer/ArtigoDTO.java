package br.gov.camara.edemocracia.portlets.wikilegis.importer;
/**
 * 
 */

/**
 * @author p_7339
 *
 */
public class ArtigoDTO {

	private final String proposta;
	
	private final String vigente;
	
	public ArtigoDTO(String proposta, String vigente) {
		this.proposta = proposta;
		this.vigente = vigente;
	}

	/**
	 * @return the proposta
	 */
	public final String getProposta() {
		return proposta;
	}

	/**
	 * @return the vigente
	 */
	public final String getVigente() {
		return vigente;
	}
}
