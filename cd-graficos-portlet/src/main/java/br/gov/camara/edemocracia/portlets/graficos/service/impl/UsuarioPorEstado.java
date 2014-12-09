/**
 * 
 */
package br.gov.camara.edemocracia.portlets.graficos.service.impl;

import java.io.Serializable;

/**
 * @author robson
 *
 */
public class UsuarioPorEstado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String uf;
	
	private final int numero;

	public String getUf() {
		return uf;
	}

	public int getNumero() {
		return numero;
	}
	
	public UsuarioPorEstado(String uf, int numero) {
		this.uf = uf;
		this.numero = numero;
	}

}
