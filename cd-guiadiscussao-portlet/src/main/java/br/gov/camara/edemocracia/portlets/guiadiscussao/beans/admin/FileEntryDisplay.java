package br.gov.camara.edemocracia.portlets.guiadiscussao.beans.admin;

import java.io.Serializable;


public class FileEntryDisplay implements Serializable {
	
	private static final long serialVersionUID = -7453732802008956349L;
	private long fileEntryId;
	private String tituloDoArquivo;
	private String urlImagem;
	
	public FileEntryDisplay(long fileEntryId, String tituloDoArquivo, String urlImagem) {
		this.fileEntryId = fileEntryId;
		this.tituloDoArquivo = tituloDoArquivo;
		this.urlImagem = urlImagem;
	}
	
	public long getFileEntryId() {
		return fileEntryId;
	}
	
	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}
	
	public String getTituloDoArquivo() {
		return tituloDoArquivo;
	}
	
	public void setTituloDoArquivo(String tituloDoArquivo) {
		this.tituloDoArquivo = tituloDoArquivo;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}
	
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	
	@Override
	public String toString() {
		return Long.toString(fileEntryId) ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (fileEntryId ^ (fileEntryId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileEntryDisplay other = (FileEntryDisplay) obj;
		if (fileEntryId != other.fileEntryId)
			return false;
		return true;
	}

	
}
