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
package br.gov.camara.edemocracia.portlets.wikilegis.service.impl;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author robson
 *
 */
public class ArtigoComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	/**
	 * @see com.liferay.portal.kernel.util.OrderByComparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object obj1, Object obj2) {
		if (obj1 == obj2)
			return 0;
		if (obj1 != null && obj1.equals(obj2))
			return 0;
		
		if ( ((Artigo)obj1).getOrdem() <= ((Artigo)obj2).getOrdem())
			return -1;
		return 1;
	}

	/**
	 * @see OrderByComparator#getOrderBy()
	 */
	@Override
	public String getOrderBy() {
		return "ordem";
	}
}
