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
