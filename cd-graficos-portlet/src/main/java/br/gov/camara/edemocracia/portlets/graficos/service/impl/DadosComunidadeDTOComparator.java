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
