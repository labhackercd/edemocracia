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

import java.util.Collections;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPermissionChecker;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletConstants;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletRequestUtil;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatRoomView;
import br.gov.camara.edemocracia.util.FlashScopeUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;

/**
 * @author P_7339
 * 
 */
public class AnonView extends AbstractView {

	@Override
	public ChatRoomView processView(RenderRequest request, RenderResponse response) throws PortalException, SystemException {

		// Verifica se a sala foi especificada
		User user = ChatPortletRequestUtil.getUserFromRequest(request);
		ChatRoom room = getRoom(request);

		if (room == null)
			return addRoomNotFoundMessage(request, user);
		
		ChatRoomUser chatUser = ChatPortletRequestUtil.getChatRoomUser(request, room.getRoomId());
		
		// Verifica o acesso
		// Se já estiver logado, vai direto para a sala de chat
		if (chatUser != null && !chatUser.isBanned())
			return ChatRoomView.VIEW;

		// Se for usuário autenticado, vai para a listagem
		if (!user.isDefaultUser()) {
			return ChatRoomView.LIST;
		}

		// Pode entrar anônimo?
		if (!room.isAnonymousAllowed()) {
			SessionErrors.add(request, "cant-join");
			return ChatRoomView.ERROR;
		}

		// Copia os dados para a requisição
		FlashScopeUtil.copyToRequest(request, ChatPortletConstants.EMAIL_PARAM, ParamUtil.get(request, ChatPortletConstants.EMAIL_PARAM, ""));
		FlashScopeUtil.copyToRequest(request, ChatPortletConstants.NICKNAME_PARAM, ParamUtil.get(request, ChatPortletConstants.NICKNAME_PARAM, ""));
		FlashScopeUtil.copyToRequest(request, ChatPortletConstants.REGION_ID_PARAM, ParamUtil.getLong(request, ChatPortletConstants.REGION_ID_PARAM, 0l));
		FlashScopeUtil.copyToRequest(request, ChatPortletConstants.NAME_SUGGESTIONS, Collections.emptyList());

		Country brasil = CountryServiceUtil.getCountryByA2("BR");
		request.setAttribute("regions", RegionServiceUtil.getRegions(brasil.getCountryId()));

		ChatPermissionChecker checker = new ChatPermissionChecker(room);
		request.setAttribute(ChatPortletConstants.CAN_JOIN_ATTRIBUTE, checker.isCanJoin());
		request.setAttribute(ChatPortletConstants.CAN_SPY_ATTRIBUTE, checker.isCanSpy());
		request.setAttribute(ChatPortletConstants.IS_OPEN_ATTRIBUTE, checker.isOpen());
		
		ChatRoomTwitter chatRoomTwitter = getChatRoomTwitter(request);
		request.setAttribute(ChatPortletConstants.TWITTER_ATTRIBUTE, chatRoomTwitter);
		ChatRoomVideo chatRoomVideoLive = getChatRoomVideoLive(request);
		request.setAttribute(ChatPortletConstants.VIDEO_LIVE_ATTRIBUTE, chatRoomVideoLive);

		return ChatRoomView.ANON;
	}

}
