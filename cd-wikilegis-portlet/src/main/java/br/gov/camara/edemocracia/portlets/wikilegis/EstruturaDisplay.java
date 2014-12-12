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
