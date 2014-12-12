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
package br.gov.camara.edemocracia.portlets.participacao.beans;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.icefaces.ace.event.DateSelectEvent;

@ManagedBean(name = "relatorio")
@ViewScoped
public class RelatorioParticipacaoBean implements Serializable {

	private static final long serialVersionUID = -6725959597922446287L;
	private Date dataInicio;
	private Date dataFim;
	private boolean periodoEnabled;
	//Chave do atributo que é armazenado na sessão contendo as comunidades selecionadas pelo usuário
	private String keyComunidadesSelecionadas;
	
	@PostConstruct
	private void init() {
		keyComunidadesSelecionadas = String.valueOf((int) (Math.random() * 10000000));
		dataInicio = new Date(System.currentTimeMillis());
		dataFim = new Date(System.currentTimeMillis());
		
	}

    /**
     * Link para o resource
     * 
     * @return
     */
    public String getRecursoParticipacao() {
    	return "participacao:comunidades_" + getKeyComunidadesSelecionadas();
    }

    public void dataInicioListener(DateSelectEvent event) {
    	this.dataInicio = event.getDate();
    }

    public void dataFimListener(DateSelectEvent event) {
    	this.dataFim = event.getDate();
    }

    public Date getDataFim() {
    	return dataFim;
    }

    public void setDataFim(Date dataFim) {
    	this.dataFim = dataFim;
    }

    public Date getDataInicio() {
    	return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
    	this.dataInicio = dataInicio;
    }

    public boolean isPeriodoEnabled() {
    	return periodoEnabled;
    }

    public void setPeriodoEnabled(boolean periodoEnabled) {
    	this.periodoEnabled = periodoEnabled;
    }

    public String getKeyComunidadesSelecionadas() {
    	return keyComunidadesSelecionadas;
    }

    public void setKeyComunidadesSelecionadas(String keyComunidadesSelecionadas) {
    	this.keyComunidadesSelecionadas = keyComunidadesSelecionadas;
    }
}
