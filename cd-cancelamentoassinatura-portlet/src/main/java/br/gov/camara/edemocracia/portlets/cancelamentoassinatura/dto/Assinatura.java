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
package br.gov.camara.edemocracia.portlets.cancelamentoassinatura.dto;

/**
 * Detalhes de uma assinatura
 * 
 * @author p_7339
 *
 */
public class Assinatura {
	
	private String comunidade;
	
	private TipoAssinatura tipo;
	
	private String nome;
	
	private String identificador;

	/**
	 * @return the comunidade
	 */
	public String getComunidade() {
		return comunidade;
	}

	/**
	 * @param comunidade the comunidade to set
	 */
	public void setComunidade(String comunidade) {
		this.comunidade = comunidade;
	}

	/**
	 * @return the tipo
	 */
	public TipoAssinatura getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoAssinatura tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

}
