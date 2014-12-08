/**
 * 
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
