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
package br.gov.camara.edemocracia.portlets.priorizacao;

import java.io.Serializable;
import java.util.List;

/**
 * Sumário de uma proposta
 * 
 * @author robson
 *
 */
public class PropostaSumario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final EixoSumario eixo;

	private final long propostaId;
	
	private final String identificador;
	
	private final String nome;
	
	private final int numeroVotos;

	private final List<VotoSumario> votos;
	
	/**
	 * @param propostaId
	 * @param identificador
	 * @param nome
	 * @param numeroVotos
	 * @param votos
	 */
	public PropostaSumario(long propostaId, EixoSumario eixo, String identificador, String nome, int numeroVotos, List<VotoSumario> votos) {
		this.propostaId = propostaId;
		this.eixo = eixo;
		this.identificador = identificador;
		this.nome = nome;
		this.numeroVotos = numeroVotos;
		this.votos = votos;
	}

	/**
	 * @return the eixo
	 */
	public EixoSumario getEixo() {
		return eixo;
	}

	/**
	 * @return the propostaId
	 */
	public long getPropostaId() {
		return propostaId;
	}

	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the numeroVotos
	 */
	public int getNumeroVotos() {
		return numeroVotos;
	}

	/**
	 * 
	 * @return the votos
	 */
	public List<VotoSumario> getVotos() {
		return votos;
	}
	
	
	
}
