package br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper;

import java.util.Date;

public class ContribuicaoWrapper {
	
	private String artigo;
	private String usuario;
	private String sugestao;
	private String justificativa;
	private Date data;
	
	public ContribuicaoWrapper() {
	}

	public String getArtigo() {
		return artigo;
	}

	public void setArtigo(String artigo) {
		this.artigo = artigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
