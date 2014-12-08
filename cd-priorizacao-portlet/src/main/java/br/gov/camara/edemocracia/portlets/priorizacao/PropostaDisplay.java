/**
 * 
 */
package br.gov.camara.edemocracia.portlets.priorizacao;

import java.io.Serializable;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;

/**
 * Dados da proposta
 * 
 * @author robson
 *
 */
public class PropostaDisplay implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Proposta
	 */
	private final Proposta proposta;
	
	/**
	 * Eixo
	 */
	private final Eixo eixo;
	
	/**
	 * Total de votos que esta proposta já recebeu
	 */
	private final int totalVotos;
	
	/**
	 * Total de votos que o usuário já deu à esta proposta
	 */
	private final int votosUsuario;
	
	/**
	 * Indica se o usuário pode votar ou não nesta proposta
	 */
	private final boolean podeVotar;
	
	/**
	 * Total de votos disponíveis do usuário
	 */
	private final int votosDisponiveis;

	/**
	 * O usuário pode cancelar este voto?
	 */
	private final boolean podeCancelarVoto;

	/**
	 * @param proposta
	 * @param eixo TODO
	 * @param totalVotos
	 * @param votosUsuario
	 * @param votosDisponiveis
	 * @param podeVotar
	 * @param podeCancelarVoto 
	 */
	public PropostaDisplay(Proposta proposta, Eixo eixo, int totalVotos, int votosUsuario, int votosDisponiveis, boolean podeVotar, boolean podeCancelarVoto) {
		this.proposta = proposta;
		this.eixo = eixo;
		this.totalVotos = totalVotos;
		this.votosUsuario = votosUsuario;
		this.votosDisponiveis = votosDisponiveis;
		this.podeVotar = podeVotar;
		this.podeCancelarVoto = podeCancelarVoto;
	}

	/**
	 * @return the proposta
	 */
	public Proposta getProposta() {
		return proposta;
	}

	/**
	 * @return the eixo
	 */
	public Eixo getEixo() {
		return eixo;
	}

	/**
	 * @return the totalVotos
	 */
	public int getTotalVotos() {
		return totalVotos;
	}

	/**
	 * @return the votosUsuario
	 */
	public int getVotosUsuario() {
		return votosUsuario;
	}

	/**
	 * @return the votosDisponiveis
	 */
	public int getVotosDisponiveis() {
		return votosDisponiveis;
	}

	/**
	 * @return the podeVotar
	 */
	public boolean isPodeVotar() {
		return podeVotar;
	}

	/**
	 * @return the podeCancelarVoto
	 */
	public boolean isPodeCancelarVoto() {
		return podeCancelarVoto;
	}
	
}
