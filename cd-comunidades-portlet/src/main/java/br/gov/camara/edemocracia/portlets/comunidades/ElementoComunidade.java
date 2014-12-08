package br.gov.camara.edemocracia.portlets.comunidades;

public class ElementoComunidade {
	
	private String url;
	private String nome;
	private String urlImagem;
	
	public ElementoComunidade(String url, String nome, String urlImagem) {
		this.url = url;
		this.nome = nome;
		this.urlImagem = urlImagem;
	}

	public String getUrl() {
		return url;
	}

	public String getNome() {
		return nome;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		ElementoComunidade other = (ElementoComunidade) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
