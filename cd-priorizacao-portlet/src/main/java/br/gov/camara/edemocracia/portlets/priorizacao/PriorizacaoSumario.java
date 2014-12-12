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
import java.util.Collections;
import java.util.List;

/**
 * @author robson
 *
 */
public class PriorizacaoSumario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final List<EixoSumario> eixos;
	
	private final int totalVotos;

	private final List<PropostaSumario> propostas;

	/**
	 * @param eixos
	 * @param todasPropostas 
	 * @param totalVotos
	 */
	public PriorizacaoSumario(List<EixoSumario> eixos, List<PropostaSumario> propostas, int totalVotos) {
		this.eixos = Collections.unmodifiableList(eixos);
		this.propostas = Collections.unmodifiableList(propostas);
		this.totalVotos = totalVotos;
	}

	/**
	 * @return the eixos
	 */
	public List<EixoSumario> getEixos() {
		return eixos;
	}

	/**
	 * @return the propostas
	 */
	public List<PropostaSumario> getPropostas() {
		return propostas;
	}

	/**
	 * @return the totalVotos
	 */
	public int getTotalVotos() {
		return totalVotos;
	}
}
