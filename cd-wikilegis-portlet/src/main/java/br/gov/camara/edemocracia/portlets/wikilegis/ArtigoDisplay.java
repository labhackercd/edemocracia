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
