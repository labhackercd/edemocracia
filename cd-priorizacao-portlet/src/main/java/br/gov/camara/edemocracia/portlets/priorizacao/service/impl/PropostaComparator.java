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
