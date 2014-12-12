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
package br.gov.camara.edemocracia.portlets.chat.portlet.views;

import java.util.Arrays;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.gov.camara.edemocracia.portlets.chat.ChatRoomBean;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletConstants;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletRequestUtil;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatRoomView;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author robson
 * 
 */
public class ListView extends AbstractView {

	@Override
	public ChatRoomView processView(RenderRequest request, RenderResponse response) throws PortalException, SystemException {
		long groupId = ChatPortletRequestUtil.getScopeGroupIdFromRequest(request);

		// Salas abertas
		ChatRoomBean[] openRooms = ChatRoomServiceUtil.findOpenRoomsInGroup(groupId);
		request.setAttribute(ChatPortletConstants.OPEN_ROOMS_LIST_ATTRIBUTE, Arrays.asList(openRooms));
		
		// Salas agendadas
		ChatRoomBean[] scheduledRooms = ChatRoomServiceUtil.findScheduledRoomsInGroup(groupId);
		request.setAttribute(ChatPortletConstants.SCHEDULED_ROOMS_LIST_ATTRIBUTE, Arrays.asList(scheduledRooms));

		// Salas com histórico definidos
		ChatRoomBean[] exportedRooms = ChatRoomServiceUtil.findExportedRoomsInGroup(groupId);
		request.setAttribute(ChatPortletConstants.EXPORTED_ROOMS_LIST_ATTRIBUTE, Arrays.asList(exportedRooms));

		return ChatRoomView.LIST;
	}

}
