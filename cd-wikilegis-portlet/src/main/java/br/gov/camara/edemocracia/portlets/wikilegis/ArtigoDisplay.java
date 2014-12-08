/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis;

import java.io.Serializable;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;
import br.gov.camara.edemocracia.portlets.wikilegis.util.StringUtils;

/**
 * @author rpdmiranda
 *
 */
public class ArtigoDisplay extends ElementoDisplay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Legislação vigente
	 */
	private final String legislacaoVigente;

	/**
	 * Legislação vigente já formatada
	 */
	private final String legislacaoVigenteFormatada;

	private int numeroComentarios;

	private int numeroSugestoes;
	
	/**
	 * @param artigo
	 */
	public ArtigoDisplay(Artigo artigo, int numeroComentarios, int numeroSugestoes) {
		super(artigo.getArtigoId(), artigo.getEstruturaId(), artigo.getTexto());
		this.legislacaoVigente = artigo.getLegislacaoVigente();
		this.legislacaoVigenteFormatada = StringUtils.formataArtigo(this.legislacaoVigente, false);
		this.numeroComentarios = numeroComentarios;
		this.numeroSugestoes = numeroSugestoes;
	}

	/**
	 * @return the legislacaoVigente
	 */
	public final String getLegislacaoVigente() {
		return legislacaoVigente;
	}
	
	/**
	 * @return the legislacaoVigenteFormatado
	 */
	public final String getLegislacaoVigenteFormatada() {
		return legislacaoVigenteFormatada;
	}

	/**
	 * @return the numeroComentarios
	 */
	public final int getNumeroComentarios() {
		return numeroComentarios;
	}

	/**
	 * @param numeroComentarios the numeroComentarios to set
	 */
	public final void setNumeroComentarios(int numeroComentarios) {
		this.numeroComentarios = numeroComentarios;
	}

	/**
	 * @return the numeroSugestoes
	 */
	public final int getNumeroSugestoes() {
		return numeroSugestoes;
	}

	/**
	 * @param numeroSugestoes the numeroSugestoes to set
	 */
	public final void setNumeroSugestoes(int numeroSugestoes) {
		this.numeroSugestoes = numeroSugestoes;
	}

	@Override
	public String getNodeName() {
		return "article_" + getId();
	}
	
	@Override
	protected String formata(String texto) {
		return StringUtils.formataArtigo(texto, true);
	}
	
}
