package br.gov.camara.edemocracia.portlets.priorizacao;

import java.io.Serializable;

public class VotosUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4001858145734309743L;

	/**
	 * Total de votos do usuário
	 */
	private final int totalVotos;
	
	/**
	 * Total de votos disponíveis
	 */
	private final int votosDisponiveis;

	public VotosUsuario(int totalVotos, int votosDisponiveis) {
		super();
		this.totalVotos = totalVotos;
		this.votosDisponiveis = votosDisponiveis;
	}

	/**
	 * @return the totalVotos
	 */
	public final int getTotalVotos() {
		return totalVotos;
	}

	/**
	 * @return the votosDisponiveis
	 */
	public final int getVotosDisponiveis() {
		return votosDisponiveis;
	}
	
	
}
