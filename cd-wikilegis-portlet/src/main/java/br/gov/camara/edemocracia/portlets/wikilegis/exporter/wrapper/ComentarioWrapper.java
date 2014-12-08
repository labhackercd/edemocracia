package br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper;

import java.util.Date;

public class ComentarioWrapper {
	
	private String artigo;
	private String usuario;
	private String comentario;
	private Date dataCriacao;
	
	public ComentarioWrapper() {
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}

