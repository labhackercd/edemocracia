/**
 * 
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
