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
