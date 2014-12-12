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
package br.gov.camara.edemocracia.portlets.graficos.service.impl;

import br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO;

import com.liferay.portal.kernel.util.OrderByComparator;

public class DadosComunidadeDTOComparator extends OrderByComparator {
	
	private static final long serialVersionUID = -8193388877946341047L;

	@Override
	public int compare(Object obj1, Object obj2) {

		if(obj1 == null)
			return -1;
		String nomeComunidade1 = ((DadosComunidadeDTO)obj1).getNomeComunidade();
		
		if(obj2 == null)
			return 1;
		
		String nomeComunidade2 = ((DadosComunidadeDTO)obj2).getNomeComunidade();

		return nomeComunidade1.toLowerCase().compareTo(nomeComunidade2.toLowerCase());
	}

}
