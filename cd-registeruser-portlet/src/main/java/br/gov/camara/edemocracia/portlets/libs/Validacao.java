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
package br.gov.camara.edemocracia.portlets.libs;

import java.util.List;

public class Validacao {
	
	private Boolean validar;
	private List<String> mensagem;
	
	public Validacao(Boolean validar, List<String> mensagem) {
		super();
		this.validar = validar;
		this.mensagem = mensagem;
	}
	
	public Boolean getValidar() {
		return validar;
	}
	public void setValidar(Boolean validar) {
		this.validar = validar;
	}
	
	public List<String> getMensagem() {
		return mensagem;
	}
	public void setMensagem(List<String> mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
