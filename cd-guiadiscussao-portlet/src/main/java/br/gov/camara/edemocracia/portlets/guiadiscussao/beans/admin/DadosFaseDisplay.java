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
