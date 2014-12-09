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
