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
package br.gov.camara.edemocracia.portlets.graficos;

import java.io.Serializable;
import java.util.Date;

/**
 * Dados consolidados de uma comunidade
 * 
 * @author robson
 *
 */
public class DadosConsolidados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	private Date dataGeracao;

	private int numeroMembros;
	
	private int forumTotalPostagens;
	
	private int forumTopicosCriados;
	
	private int forumVisualizacoes;
	
	private int wikiComentarios;
	
	private int wikilegisComentarios;
	
	private int wikilegisSugestoes;
	
	private int blogsComentarios;
	
	private int bibliotecaComentarios;
	
	private int batepapoMensagens;

	/**
	 * @return the dataGeracao
	 */
	public final Date getDataGeracao() {
		return dataGeracao;
	}

	/**
	 * @param dataGeracao the dataGeracao to set
	 */
	public final void setDataGeracao(Date dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	/**
	 * @return the numeroMembros
	 */
	public final int getNumeroMembros() {
		return numeroMembros;
	}

	/**
	 * @param numeroMembros the numeroMembros to set
	 */
	public final void setNumeroMembros(int numeroMembros) {
		this.numeroMembros = numeroMembros;
	}

	/**
	 * @return the forumTotalPostagens
	 */
	public final int getForumTotalPostagens() {
		return forumTotalPostagens;
	}

	/**
	 * @param forumTotalPostagens the forumTotalPostagens to set
	 */
	public final void setForumTotalPostagens(int forumTotalPostagens) {
		this.forumTotalPostagens = forumTotalPostagens;
	}

	/**
	 * @return the forumTopicosCriados
	 */
	public final int getForumTopicosCriados() {
		return forumTopicosCriados;
	}

	/**
	 * @param forumTopicosCriados the forumTopicosCriados to set
	 */
	public final void setForumTopicosCriados(int forumTopicosCriados) {
		this.forumTopicosCriados = forumTopicosCriados;
	}


	/**
	 * @return the forumVisualizacoes
	 */
	public final int getForumVisualizacoes() {
		return forumVisualizacoes;
	}

	/**
	 * @param forumVisualizacoes the forumVisualizacoes to set
	 */
	public final void setForumVisualizacoes(int forumVisualizacoes) {
		this.forumVisualizacoes = forumVisualizacoes;
	}

	/**
	 * @return the wikiComentarios
	 */
	public final int getWikiComentarios() {
		return wikiComentarios;
	}

	/**
	 * @param wikiComentarios the wikiComentarios to set
	 */
	public final void setWikiComentarios(int wikiComentarios) {
		this.wikiComentarios = wikiComentarios;
	}

	/**
	 * @return the wikilegisComentarios
	 */
	public final int getWikilegisComentarios() {
		return wikilegisComentarios;
	}

	/**
	 * @param wikilegisComentarios the wikilegisComentarios to set
	 */
	public final void setWikilegisComentarios(int wikilegisComentarios) {
		this.wikilegisComentarios = wikilegisComentarios;
	}

	/**
	 * @return the wikilegisSugestoes
	 */
	public final int getWikilegisSugestoes() {
		return wikilegisSugestoes;
	}

	/**
	 * @param wikilegisSugestoes the wikilegisSugestoes to set
	 */
	public final void setWikilegisSugestoes(int wikilegisSugestoes) {
		this.wikilegisSugestoes = wikilegisSugestoes;
	}

	/**
	 * @return the blogsComentarios
	 */
	public final int getBlogsComentarios() {
		return blogsComentarios;
	}

	/**
	 * @param blogsComentarios the blogsComentarios to set
	 */
	public final void setBlogsComentarios(int blogsComentarios) {
		this.blogsComentarios = blogsComentarios;
	}

	/**
	 * @return the bibliotecaComentarios
	 */
	public final int getBibliotecaComentarios() {
		return bibliotecaComentarios;
	}

	/**
	 * @param bibliotecaComentarios the bibliotecaComentarios to set
	 */
	public final void setBibliotecaComentarios(int bibliotecaComentarios) {
		this.bibliotecaComentarios = bibliotecaComentarios;
	}

	/**
	 * @return the batepapoMensagens
	 */
	public final int getBatepapoMensagens() {
		return batepapoMensagens;
	}

	/**
	 * @param batepapoMensagens the batepapoMensagens to set
	 */
	public final void setBatepapoMensagens(int batepapoMensagens) {
		this.batepapoMensagens = batepapoMensagens;
	}

	/**
	 * Acumula os dados coletados de outra fonte
	 * @param outro
	 */
	public void adiciona(DadosConsolidados outro) {
		forumTotalPostagens += outro.forumTotalPostagens;
		forumTopicosCriados += outro.forumTopicosCriados;
		forumVisualizacoes += outro.forumVisualizacoes;
		wikiComentarios += outro.wikiComentarios;
		wikilegisComentarios += outro.wikilegisComentarios;
		wikilegisSugestoes += outro.wikilegisSugestoes;
		blogsComentarios += outro.blogsComentarios;
		bibliotecaComentarios += outro.bibliotecaComentarios;
		batepapoMensagens += outro.batepapoMensagens;
	}
	
	
}
