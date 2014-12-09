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
