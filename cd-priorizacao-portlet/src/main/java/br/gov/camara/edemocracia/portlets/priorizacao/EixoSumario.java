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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author robson
 * 
 */
public class EixoSumario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final long eixoId;

	private final String nome;

	private final List<PropostaSumario> propostas = new ArrayList<PropostaSumario>();

	private int totalVotos;

	/**
	 * @param eixoId
	 * @param eixo
	 */
	public EixoSumario(long eixoId, String nome) {
		this.eixoId = eixoId;
		this.nome = nome;
	}

	/**
	 * @return the eixoId
	 */
	public long getEixoId() {
		return eixoId;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the totalVotos
	 */
	public int getTotalVotos() {
		return totalVotos;
	}

	/**
	 * @return the propostas
	 */
	public List<PropostaSumario> getPropostas() {
		return Collections.unmodifiableList(propostas);
	}

	/**
	 * Adiciona uma proposta a este eixo
	 * 
	 * @param propostaId
	 * @param identificador
	 * @param ementa
	 * @param votosProposta
	 * @return
	 */
	public PropostaSumario adicionaProposta(long propostaId,
			String identificador, String ementa, int votosProposta,
			List<VotoSumario> votos) {

		PropostaSumario propostaSumario = new PropostaSumario(propostaId, this,
				identificador, ementa, votosProposta, votos);
		propostas.add(propostaSumario);
		totalVotos += votosProposta;
		return propostaSumario;
	}

	public List<PropostaSumario> getPropostasOrdenadas() {
		ArrayList<PropostaSumario> propostasOrdenadas = new ArrayList<PropostaSumario>(
				propostas);
		Collections.sort(propostasOrdenadas, new Comparator<PropostaSumario>() {
			@Override
			public int compare(PropostaSumario o1, PropostaSumario o2) {
				if (o1.getNumeroVotos() > o2.getNumeroVotos())
					return -1;
				else if (o1.getNumeroVotos() == o2.getNumeroVotos())
					return 0;
				else
					return 1;
			}
		});
		return propostasOrdenadas;
	}

}
