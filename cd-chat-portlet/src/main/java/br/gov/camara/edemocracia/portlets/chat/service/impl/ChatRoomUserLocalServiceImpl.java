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
package br.gov.camara.edemocracia.portlets.chat.service.impl;

import java.util.List;

import br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;
import br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomUserLocalServiceBaseImpl;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomUserUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

/**
 * The implementation of the chat room user local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.chat.service.ChatRoomUserLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.chat.service.ChatRoomUserLocalServiceUtil}
 * to access the chat room user local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Ricardo Lima
 * @see br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomUserLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.chat.service.ChatRoomUserLocalServiceUtil
 */
public class ChatRoomUserLocalServiceImpl extends ChatRoomUserLocalServiceBaseImpl {

	public boolean existsUserNameInChatRoom(long chatRoomId, String userName) throws SystemException {
		boolean exists = false;
		try {
			exists = ChatRoomUserUtil.findByName_First(chatRoomId, userName, null) != null;
		} catch (NoSuchChatRoomUserException ex) {

		}
		return exists;
	}

	public boolean existsUserEmailInChatRoom(long chatRoomId, String userEmail) throws SystemException {
		boolean exists = false;
		try {
			exists = ChatRoomUserUtil.findByEmail_First(chatRoomId, userEmail, null) != null;
		} catch (NoSuchChatRoomUserException ex) {

		}
		return exists;
	}

	/**
	 * Retorna o usuário da sala que contém o nome completo especificado
	 * 
	 * @param chatRoom
	 * @param userName
	 * @return
	 * @throws SystemException
	 */
	@Override
	public boolean isUserNameInUse(ChatRoom chatRoom, String userName) throws SystemException {
		List<ChatRoomUser> rooms = getChatRoomUserPersistence().findByName(chatRoom.getRoomId(), userName.trim());
		return (!rooms.isEmpty());
	}

	/**
	 * Obtém o usuário do chat associado ao usuário do portal
	 * 
	 * @param user
	 * @return
	 * @throws SystemException
	 */
	@Override
	public ChatRoomUser findByPortalUser(ChatRoom room, User user) throws SystemException {
		if (user.isDefaultUser())
			return null;

		List<ChatRoomUser> users = getChatRoomUserPersistence().findByCR_U(room.getRoomId(), user.getUserId());
		if (users.isEmpty())
			return null;
		return users.get(0);
	}
}
