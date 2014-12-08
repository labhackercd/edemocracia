/**
 * 
 */
package br.gov.camara.edemocracia.portlets.priorizacao.service.impl;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * Compara duas propostas
 * 
 * @author robson
 *
 */
public class PropostaComparator extends OrderByComparator {

	@Override
	public String getOrderBy() {
		return "identificador";
	}
	
	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.util.OrderByComparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object obj1, Object obj2) {
		if (obj1 == obj2)
			return 0;
		if (obj1 != null && obj1.equals(obj2))
			return 0;
		
		return ((Proposta)obj1).getIdentificador().compareTo(((Proposta)obj2).getIdentificador());
	}

}
