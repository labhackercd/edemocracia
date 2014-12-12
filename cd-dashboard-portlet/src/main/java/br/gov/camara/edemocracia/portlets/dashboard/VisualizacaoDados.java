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
package br.gov.camara.edemocracia.portlets.dashboard;

public enum VisualizacaoDados {
	
	Tabela(1,"Tabela") , Grafico(2,"Gráfico com Porcentagem");
	
	private int value;
	private String label;
	
	private VisualizacaoDados(int value, String label) {
		this.value = value;
		this.label = label;
	}
	
	public static VisualizacaoDados withValue(int value) {
		VisualizacaoDados retorno = VisualizacaoDados.Tabela;
		for (VisualizacaoDados visualizacao : VisualizacaoDados.values()) {
			if (visualizacao.getValue() == value) {
				retorno = visualizacao;
			}
		}
		
		return retorno;
	}
	
	public String getLabel() {
		return label;
	}
	
	public int getValue() {
		return value;
	}
	
}
