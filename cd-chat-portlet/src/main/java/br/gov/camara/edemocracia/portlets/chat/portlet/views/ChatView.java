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

import java.util.Calendar;
import java.util.Date;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang.StringUtils;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletConstants;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletRequestUtil;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletSessionUtil;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletUtil;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatRoomView;
import br.gov.camara.edemocracia.portlets.chat.service.UserActivityId;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.model.User;

/**
 * @author P_7339
 * 
 */
public class ChatView extends AbstractView {

	@Override
	public ChatRoomView processView(RenderRequest request, RenderResponse response) throws PortalException, SystemException {

		User user = ChatPortletRequestUtil.getUserFromRequest(request);
		ChatRoom room = getRoom(request);
		
		if (room == null) {
			return addRoomNotFoundMessage(request, user);
		}
		
		ChatRoomUser chatUser = ChatPortletRequestUtil.getChatRoomUser(request, room.getRoomId());
		
		UserActivityId userActivityId = ChatPortletSessionUtil.getUserActivityIdInRoom(request, room.getRoomId());
		boolean spying = userActivityId != null && userActivityId.isSpyUser();
		
		if(!spying) {
			
			if (chatUser == null) {
				return resolveDestinationView(request, user, room, "cant-join");
			}
			if (chatUser.getBanned()) {
				// Usuário banido
				SessionErrors.add(request, "user-banned");
				return resolveDestinationView(request, user, room, null);
			}
			
		}

		Date since = ChatPortletUtil.addToDate(new Date(), Calendar.MINUTE, -ChatPortletConstants.THIRTY_MINUTES);
		request.setAttribute(ChatPortletConstants.UPDATE_TS_ATTRIBUTE, since);

		ChatRoomTwitter chatRoomTwitter = getChatRoomTwitter(request);
		request.setAttribute(ChatPortletConstants.TWITTER_ATTRIBUTE, chatRoomTwitter);
		ChatRoomVideo chatRoomVideoLive = getChatRoomVideoLive(request);
		request.setAttribute(ChatPortletConstants.VIDEO_LIVE_ATTRIBUTE, chatRoomVideoLive);
		
		if (!spying && chatUser.isModerator()) {
			return ChatRoomView.MODERATE;
		} else {
			return ChatRoomView.VIEW;
		}
	}

	private ChatRoomView resolveDestinationView(RenderRequest request, User user, ChatRoom room, String optionalErrorMessageKey) {
		if (user.isDefaultUser()) {
			if (room.isAnonymousAllowed()) {
				return ChatRoomView.ANON;
			} else {
				if (StringUtils.isNotBlank(optionalErrorMessageKey)) {
					SessionErrors.add(request, optionalErrorMessageKey);
				}
				return ChatRoomView.ERROR;
			}
		} else {
			return ChatRoomView.LIST;
		}
	}
}
