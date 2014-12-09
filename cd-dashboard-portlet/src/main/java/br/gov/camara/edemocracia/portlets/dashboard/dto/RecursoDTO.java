package br.gov.camara.edemocracia.portlets.dashboard.dto;

import java.io.Serializable;

public class RecursoDTO implements Serializable {
	
	private static final long serialVersionUID = 129323594317167229L;

	private long groupId;
	private String tituloComunidade;
	private String titulo;
	private int quantidade;
	private int classificacao;
	private long id;
	
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getTituloComunidade() {
		return tituloComunidade;
	}
	public void setTituloComunidade(String tituloComunidade) {
		this.tituloComunidade = tituloComunidade;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
