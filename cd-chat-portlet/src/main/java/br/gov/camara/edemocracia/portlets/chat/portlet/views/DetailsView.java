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
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletRequestUtil;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatRoomView;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

public class DetailsView extends AbstractView {

	@Override
	protected ChatRoomView processView(RenderRequest request, RenderResponse response) throws PortalException, SystemException {

		// Verifica se a sala foi especificada
		User user = ChatPortletRequestUtil.getUserFromRequest(request);
		ChatRoom room = getRoom(request);

		if (room == null) {
			return addRoomNotFoundMessage(request, user);
		}
		
		//Testa se o usuario atual tem permissão para entrar ou espiar a sala
		boolean canJoin = ChatRoomServiceUtil.canJoin(room.getRoomId());
		boolean canSpy = ChatRoomServiceUtil.canSpy(room.getRoomId());
		
		request.setAttribute("canJoin", canJoin);
		request.setAttribute("canSpy", canSpy);
		
		return ChatRoomView.DETAILS;
	}

}
