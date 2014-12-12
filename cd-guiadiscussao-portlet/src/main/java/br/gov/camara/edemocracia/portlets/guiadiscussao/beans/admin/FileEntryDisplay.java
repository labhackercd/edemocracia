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
