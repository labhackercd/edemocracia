package br.gov.camara.edemocracia.movetopico.model;

import java.io.Serializable;

public class InfoMoverTopico implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7699230421962126424L;
	
	private final long idUsuario;
	private final long idComunidadeOrigem;
	private final String nomeComunidadeOrigem;
	private final String urlComunidadeOrigem;
	private long idForumOrigem;
	private String nomeForumOrigem;
	private long idTopico;
	private String nomeTopico;
	private long idComunidadeDestino;
	private String nomeComunidadeDestino;
	private String urlComunidadeDestino;
	private long idForumDestino;
	private String nomeForumDestino;
	
	public String getNomeComunidadeOrigem() {
		return nomeComunidadeOrigem;
	}
	
	public String getUrlComunidadeOrigem() {
		return urlComunidadeOrigem;
	}

	
	public String getNomeForumOrigem() {
		return nomeForumOrigem;
	}

	public void setNomeForumOrigem(String nomeForumOrigem) {
		this.nomeForumOrigem = nomeForumOrigem;
	}

	public String getNomeTopico() {
		return nomeTopico;
	}

	public void setNomeTopico(String nomeTopico) {
		this.nomeTopico = nomeTopico;
	}

	public String getNomeComunidadeDestino() {
		return nomeComunidadeDestino;
	}

	public void setNomeComunidadeDestino(String nomeComunidadeDestino) {
		this.nomeComunidadeDestino = nomeComunidadeDestino;
	}

	public String getUrlComunidadeDestino() {
		return urlComunidadeDestino;
	}

	public void setUrlComunidadeDestino(String urlComunidadeDestino) {
		this.urlComunidadeDestino = urlComunidadeDestino;
	}

	public String getNomeForumDestino() {
		return nomeForumDestino;
	}

	public void setNomeForumDestino(String nomeTopicoDestino) {
		this.nomeForumDestino = nomeTopicoDestino;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public InfoMoverTopico(long idUsuario, long idComunidadeOrigem, String nomeComunidadeOrigem, String urlComunidadeOrigem) {
		
		this.idUsuario = idUsuario;
		this.idComunidadeOrigem = idComunidadeOrigem;
		this.nomeComunidadeOrigem = nomeComunidadeOrigem;
		this.urlComunidadeOrigem = urlComunidadeOrigem;

	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public long getIdComunidadeOrigem() {
		return idComunidadeOrigem;
	}


	public long getIdForumOrigem() {
		return idForumOrigem;
	}

	public void setIdForumOrigem(long idForumOrigem) {
		this.idForumOrigem = idForumOrigem;
	}

	public long getIdTopico() {
		return idTopico;
	}

	public void setIdTopico(long idTopico) {
		this.idTopico = idTopico;
	}

	public long getIdComunidadeDestino() {
		return idComunidadeDestino;
	}

	public void setIdComunidadeDestino(long idComunidadeDestino) {
		this.idComunidadeDestino = idComunidadeDestino;
	}

	public long getIdForumDestino() {
		return idForumDestino;
	}

	public void setIdForumDestino(long idForumDestino) {
		this.idForumDestino = idForumDestino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idForumOrigem ^ (idForumOrigem >>> 32));
		result = prime * result
				+ (int) (idComunidadeOrigem ^ (idComunidadeOrigem >>> 32));
		result = prime * result
				+ (int) (idForumDestino ^ (idForumDestino >>> 32));
		result = prime * result
				+ (int) (idComunidadeDestino ^ (idComunidadeDestino >>> 32));
		result = prime * result + (int) (idTopico ^ (idTopico >>> 32));
		result = prime * result + (int) (idUsuario ^ (idUsuario >>> 32));
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
		InfoMoverTopico other = (InfoMoverTopico) obj;
		if (idForumOrigem != other.idForumOrigem)
			return false;
		if (idComunidadeOrigem != other.idComunidadeOrigem)
			return false;
		if (idForumDestino != other.idForumDestino)
			return false;
		if (idComunidadeDestino != other.idComunidadeDestino)
			return false;
		if (idTopico != other.idTopico)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InfoMoverTopico [idUsuario=" + idUsuario
				+ ", idComunidadeOrigem=" + idComunidadeOrigem
				+ ", idForumOrigem=" + idForumOrigem + ", idTopico=" + idTopico
				+ ", idComunidadeDestino=" + idComunidadeDestino
				+ ", idForumDestino=" + idForumDestino + "]";
	}

	

}
