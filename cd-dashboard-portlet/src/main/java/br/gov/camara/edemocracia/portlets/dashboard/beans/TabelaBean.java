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
package br.gov.camara.edemocracia.portlets.dashboard.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.gov.camara.edemocracia.portlets.dashboard.VisualizacaoDados;
import br.gov.camara.edemocracia.portlets.dashboard.dto.RecursoDTO;

@ViewScoped
@ManagedBean
public class TabelaBean implements Serializable {
	
	private static final long serialVersionUID = -4460239256300692441L;

	@ManagedProperty(value = "#{initBean}")
	private InitBean initBean;
	private List<RecursoDTO> dados;
	private boolean possuiDados;
	
	@PostConstruct()
	private void init(){
		dados = initBean.getDados();
		
		if(dados != null && !dados.isEmpty()) {
			possuiDados = true;
		}
	}
	
	public boolean isVisualizacaoTabela(){
		return initBean.getConfig() != null && initBean.getConfig().getModoVisualizacao() == VisualizacaoDados.Tabela.getValue(); 
	}
	
	public List<RecursoDTO> getDados() {
		return dados;
	}
	
	public void setInitBean(InitBean initBean) {
		this.initBean = initBean;
	}
	
	public InitBean getInitBean() {
		return initBean;
	}
	
	public boolean isPossuiDados() {
		return possuiDados;
	}
}
