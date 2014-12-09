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
