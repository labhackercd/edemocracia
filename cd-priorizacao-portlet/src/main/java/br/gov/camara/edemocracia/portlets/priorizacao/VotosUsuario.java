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
