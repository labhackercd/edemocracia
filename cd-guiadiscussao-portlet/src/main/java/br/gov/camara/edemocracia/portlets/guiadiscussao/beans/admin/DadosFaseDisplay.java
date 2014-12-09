package br.gov.camara.edemocracia.portlets.guiadiscussao.beans.admin;

import java.io.Serializable;
import java.util.List;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase;

public class DadosFaseDisplay implements Serializable {

	private static final long serialVersionUID = -1625645619273141514L;
	private Fase fase;
	private List<Acao> acoes;
	
	public DadosFaseDisplay(Fase fase, List<Acao> acoes) {
		this.fase = fase;
		this.acoes = acoes;
	}
	
	public List<Acao> getAcoes() {
		return acoes;
	}
	
	public Fase getFase() {
		return fase;
	}
	
	public void setAcoes(List<Acao> acoes) {
		this.acoes = acoes;
	}
	
	public void setFase(Fase fase) {
		this.fase = fase;
	}

}
