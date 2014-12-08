/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura;
import br.gov.camara.edemocracia.portlets.wikilegis.util.StringUtils;

/**
 * @author rpdmiranda
 *
 */
public class EstruturaDisplay extends ElementoDisplay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<EstruturaDisplay> filhos;

	public EstruturaDisplay(Estrutura estrutura) {
		super(estrutura.getEstruturaId(), estrutura.getPaiEstruturaId(), estrutura.getTexto());
	}
	
	/**
	 * Adiciona um elemento filho
	 * @param estrutura
	 * @return 
	 */
	public EstruturaDisplay adicionaFilho(Estrutura estrutura) {
		if (filhos == null)
			 filhos = new ArrayList<EstruturaDisplay>();
		EstruturaDisplay filho = new EstruturaDisplay(estrutura); 
		filhos.add(filho);
		return filho;
	}

	/**
	 * @return the filhos
	 */
	public List<EstruturaDisplay> getFilhos() {
		if (filhos == null)
			return Collections.emptyList();
		else
			return filhos;
	}

	/**
	 * @return Link para o nó da estrutura
	 */
	@Override
    public String getNodeName() {
    	return "node_" + getId();
    }
    
    @Override
    protected String formata(String texto) {
		return StringUtils.formataEstrutura(texto);
    }
}
