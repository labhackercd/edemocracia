package br.gov.camara.edemocracia.portlets.priorizacao.service.impl;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;

import com.liferay.portal.kernel.util.OrderByComparator;

public class EixoComparator extends OrderByComparator {

	private static final long serialVersionUID = 1L;

	@Override
	public int compare(Object obj1, Object obj2) {
		if (obj1 == obj2)
			return 0;
		if (obj1 != null && obj1.equals(obj2))
			return 0;
		
		if ( ((Eixo)obj1).getOrdem() <= ((Eixo)obj2).getOrdem())
			return -1;
		return 1;
	}
	
	@Override
	public String getOrderBy() {
		return "ordem";
	}
	
}
