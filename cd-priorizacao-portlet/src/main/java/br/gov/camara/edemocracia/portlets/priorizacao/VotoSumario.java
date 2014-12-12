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
import java.util.Date;

/**
 * Sumário de um voto
 * 
 * @author bruno
 *
 */
public class VotoSumario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private final Date data;
	private final String username;
	private final String userUF;
	private final int numeroVotos;
	
	/**
	 * 
	 * @param data
	 * @param username
	 * @param userUF
	 * @param numeroVotos
	 */
	public VotoSumario(Date data, String username, String userUF,int numeroVotos) {
		this.data = data;
		this.username = username;
		this.userUF = userUF;
		this.numeroVotos = numeroVotos;
	}
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @return the userUF
	 */
	public String getUserUF() {
		return userUF;
	}
	
	/**
	 * @return the numeroVotos
	 */
	public int getNumeroVotos() {
		return numeroVotos;
	}
	
	
}
