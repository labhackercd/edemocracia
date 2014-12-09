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
