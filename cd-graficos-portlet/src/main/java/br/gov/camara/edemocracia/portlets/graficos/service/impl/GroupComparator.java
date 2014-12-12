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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.Group;


public class GroupComparator extends OrderByComparator {
	
	private static final long serialVersionUID = 1L;

	@Override
	public int compare(Object obj1, Object obj2) {
		
		String groupName1;
		try {
			if(obj1 == null)
				return -1;
			groupName1 = ((Group)obj1).getDescriptiveName();
		} catch (PortalException e) {
			groupName1 = "";
		} catch (SystemException e) {
			groupName1 = "";
		}
		
		String groupName2;
		try {
			if(obj2 == null)
				return 1;
			groupName2 = ((Group)obj2).getDescriptiveName();
		} catch (PortalException e) {
			groupName2 = "";
		} catch (SystemException e) {
			groupName2 = "";
		}
		
		return groupName1.toLowerCase().compareTo(groupName2.toLowerCase());
	}

}
