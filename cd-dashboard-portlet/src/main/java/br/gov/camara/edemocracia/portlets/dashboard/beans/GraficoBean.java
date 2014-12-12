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

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.PieChartModel;

import br.gov.camara.edemocracia.portlets.dashboard.VisualizacaoDados;
import br.gov.camara.edemocracia.portlets.dashboard.dto.RecursoDTO;

@ViewScoped
@ManagedBean
public class GraficoBean {

	@ManagedProperty(value = "#{initBean}")
	private InitBean initBean;

	private List<RecursoDTO> dados;
	private PieChartModel dadosGrafico;
	private int totalDePostagens;
	private int indexRecursoSelecionado;
	private RecursoDTO recursoSelecionado;
	private boolean possuiDados;
	private boolean exibeDetalhes;

	private String classeCssParaLegenda;
	private String classeCssGrafico;

	@PostConstruct()
	private void init() {
		configurarClassesCssParaGrafico();
		
		dados = initBean.getDados();
		
		possuiDados = dados != null && !dados.isEmpty();
		
		if (possuiDados) {
			preencherDadosGrafico();
		}
		
		indexRecursoSelecionado = -1;

	}
	
	private void configurarClassesCssParaGrafico() {
		
		if(initBean.getConfig() != null) {
			
			if (initBean.getConfig().getQtdDeRecursos() == 15) {
				classeCssParaLegenda = "lgLabel15";
				classeCssGrafico = "painelGraficoGrd";
			} else {
				classeCssParaLegenda = "lgLabel";
				classeCssGrafico = "painelGrafico";
			}
		}
		
	}

	private void preencherDadosGrafico() {

		dadosGrafico = new PieChartModel();

		int contador = 1;
		for (RecursoDTO recurso : dados) {
			String descricaoTopico = criarDescricao(contador, recurso);
			int participacoes = recurso.getQuantidade();
			totalDePostagens += participacoes;
			dadosGrafico.set(descricaoTopico, participacoes);
			contador++;
		}
		
	}

	private String criarDescricao(int classificacao, RecursoDTO dados) {
		StringBuilder builder = new StringBuilder();
		builder.append("<span class='" + classeCssParaLegenda +  "'>");
		builder.append(classificacao + ". ");
		builder.append(dados.getTituloComunidade());
		
		if (!initBean.getRecurso().isQuantitativoGeral()) {
			builder.append(" <br />");
			builder.append(" <span class='lgTopico'>");
			builder.append(dados.getTitulo());
			builder.append("</span>");
		}
		
		builder.append("</span>");

		return builder.toString();
	}

	public void itemSelect(ItemSelectEvent event) {
		recursoSelecionado = dados.get(event.getItemIndex());
		indexRecursoSelecionado = event.getItemIndex();
		exibeDetalhes = true;
	}

	public boolean isVisualizacaoGrafico() {
		return initBean.getConfig() != null && initBean.getConfig().getModoVisualizacao() == VisualizacaoDados.Grafico.getValue();
	}
	
	public String getClasseCssGrafico() {
		return classeCssGrafico;
	}

	public PieChartModel getDadosGrafico() {
		return dadosGrafico;
	}

	public InitBean getInitBean() {
		return initBean;
	}

	public void setInitBean(InitBean initBean) {
		this.initBean = initBean;
	}

	public boolean isPossuiDados() {
		return possuiDados;
	}

	public RecursoDTO getRecursoSelecionado() {
		return recursoSelecionado;
	}

	public boolean isExibeDetalhes() {
		return exibeDetalhes;
	}

	public int getTotalDePostagens() {
		return totalDePostagens;
	}
	
	public int getIndexRecursoSelecionado() {
		return indexRecursoSelecionado;
	}
}
