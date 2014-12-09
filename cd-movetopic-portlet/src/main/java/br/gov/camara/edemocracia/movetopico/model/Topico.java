package br.gov.camara.edemocracia.movetopico.model;

public class Topico {
	
	private final long id;
	private final String assunto;
	
	public Topico(long id, String assunto) {
		this.id = id;
		this.assunto = assunto;
	}

	public long getId() {
		return id;
	}

	public String getAssunto() {
		return assunto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Topico other = (Topico) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return assunto;
	}
	
	
	
	

}
