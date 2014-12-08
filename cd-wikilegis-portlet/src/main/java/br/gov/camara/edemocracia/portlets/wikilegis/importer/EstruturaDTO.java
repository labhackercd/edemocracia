package br.gov.camara.edemocracia.portlets.wikilegis.importer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 * Dados para estrutura
 * 
 * @author p_7339
 *
 */
public class EstruturaDTO {

	private final EstruturaDTO pai;
	private final String nome;
	
	private final List<EstruturaDTO> filhos = new ArrayList<EstruturaDTO>();
	private final List<ArtigoDTO> artigos = new ArrayList<ArtigoDTO>();
	
	public EstruturaDTO(EstruturaDTO pai, String nome) {
		this.pai = pai;
		this.nome = nome;
		if (this.pai != null)
			pai.filhos.add(this);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(nome);
		if (!filhos.isEmpty()) {
			sb.append(":");
			Iterator<EstruturaDTO> iter = filhos.iterator();
			while (iter.hasNext()) {
				sb.append(iter.next());
				if (iter.hasNext())
					sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
		
	}
	
	public void adiconaArtigo(ArtigoDTO artigo) {
		artigos.add(artigo);
	}

	/**
	 * @return the filhos
	 */
	public final List<EstruturaDTO> getFilhos() {
		return filhos;
	}

	/**
	 * @return the pai
	 */
	public final EstruturaDTO getPai() {
		return pai;
	}

	/**
	 * @return the nome
	 */
	public final String getNome() {
		return nome;
	}

	/**
	 * @return the artigos
	 */
	public final List<ArtigoDTO> getArtigos() {
		return Collections.unmodifiableList(artigos);
	}
}
