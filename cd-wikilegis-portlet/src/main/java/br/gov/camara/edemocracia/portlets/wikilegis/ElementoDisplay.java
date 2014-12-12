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

/**
 * @author robson
 *
 */
public abstract class ElementoDisplay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador do nó ou do artigo
	 */
	private final long id;
	
	/**
	 * Identificador da estrutura pai
	 */
	private final long paiEstruturaId;
	
	/**
	 * Texto do artigo ou título
	 */
	private final String texto;
	
	/**
	 * Texto formatado (em HTML)
	 */
	private final String textoFormatado;
	

	public ElementoDisplay(long estruturaId, long paiEstruturaId, String texto) {
		this.id = estruturaId;
		this.paiEstruturaId = paiEstruturaId;
		this.texto = texto;
		this.textoFormatado = formata(texto);
	}

	public final long getId() {
		return id;
	}


	public final long getPaiEstruturaId() {
		return paiEstruturaId;
	}


	public final String getTexto() {
		return texto;
	}
	
	/**
	 * Obtém o link para este elemento
	 * @return
	 */
	public String getLink() {
		return "#" + getNodeName();
	}
	
	/**
	 * Obtém o nome deste elemento
	 * @return
	 */
	public abstract String getNodeName();


	/**
	 * Formata o texto para HTML
	 * @param texto
	 * @return
	 */
	protected abstract String formata(String texto);


}
