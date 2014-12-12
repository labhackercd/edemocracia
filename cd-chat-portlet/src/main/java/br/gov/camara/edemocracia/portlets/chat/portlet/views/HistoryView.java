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

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomStatus;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletConstants;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatRoomView;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * @author robson
 * 
 */
public class HistoryView extends AbstractView {

	@Override
	public ChatRoomView processView(RenderRequest request, RenderResponse response) throws PortalException, SystemException {
		ChatRoom room = getRoom(request);
		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if (room == null) {
			return addRoomNotFoundMessage(request, td.getUser());
		} else if (room.getStatus() != RoomStatus.Exported.getValue()) {
			SessionErrors.add(request, "room-not-exported");
			if (td.getUser().isDefaultUser())
				return ChatRoomView.ERROR;
			else
				return ChatRoomView.LIST;
		}
		ChatRoomMessage[] messages = ChatRoomServiceUtil.getMessagesForExport(room.getRoomId());
		request.setAttribute("messages", messages);

		ChatRoomVideo chatRoomVideoRecorded = getChatRoomVideoRecorded(request);
		request.setAttribute(ChatPortletConstants.VIDEO_RECORDED_ATTRIBUTE, chatRoomVideoRecorded);
		ChatRoomTwitter chatRoomTwitter = getChatRoomTwitter(request);
		request.setAttribute(ChatPortletConstants.TWITTER_ATTRIBUTE, chatRoomTwitter);

		long usersCount = ChatRoomServiceUtil.getUserCount(room.getRoomId());
		request.setAttribute(ChatPortletConstants.USERS_COUNT_ATTRIBUTE, usersCount);

		return ChatRoomView.HISTORY;
	}

}
