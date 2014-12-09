/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.gov.camara.edemocracia.portlets.chat.service.impl;

import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import br.gov.camara.edemocracia.portlets.chat.AccessDeniedException;
import br.gov.camara.edemocracia.portlets.chat.CantRemoveOpenedChatRoom;
import br.gov.camara.edemocracia.portlets.chat.ChatRoomBean;
import br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean;
import br.gov.camara.edemocracia.portlets.chat.RoomWithSameNameInCommunityException;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;
import br.gov.camara.edemocracia.portlets.chat.model.impl.MessageStatus;
import br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomStatus;
import br.gov.camara.edemocracia.portlets.chat.model.impl.UserType;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPermissionChecker;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomMessageLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomUserLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.UserActivityId;
import br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomServiceBaseImpl;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomFinderUtil;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomPersistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the chat room remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.chat.service.ChatRoomService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil}
 * to access the chat room remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author Ricardo Lima
 * @see br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil
 */
public class ChatRoomServiceImpl extends ChatRoomServiceBaseImpl {

	private static final String MESSAGE_TS_FIELD = "messageTS";
	private static final String ADMIN_MESSAGE_FIELD = "adminMessage";
	private static final String MESSAGE_STATUS_FIELD = "messageStatus";
	private static final String CHAT_ROOM_ID_FIELD = "chatRoomId";
	private static final String MESSAGE_PUBLIC_FIELD = "messagePublic";
	private static final String GROUP_ID_FIELD = "groupId";

	private static final Log LOG = LogFactoryUtil.getLog(ChatRoomServiceImpl.class);
	
	/**
	 * Acrecenta uma sala de bate-papo
	 */
	public final ChatRoom addChatRoom(ChatRoom chatRoom) throws SystemException {

		ChatRoomPersistence roomPersistence = getChatRoomPersistence();
		List<ChatRoom> rooms = roomPersistence.findByGroupRoomName(chatRoom.getRoomName(), chatRoom.getGroupId());
		if (rooms.size() > 0) {
			throw new RoomWithSameNameInCommunityException();
		}
		ChatRoom room = roomPersistence.create(getCounterLocalService().increment(ChatRoom.class.getName()));
		room.setRoomName(chatRoom.getRoomName());
		room.setDescription(chatRoom.getDescription());
		room.setModerated(chatRoom.getModerated());
		room.setCapacity(chatRoom.getCapacity());
		room.setAnonymousAllowed(chatRoom.getAnonymousAllowed());
		room.setOpenPolicy(chatRoom.getOpenPolicy());
		room.setOpenFrom(chatRoom.getOpenFrom());
		room.setOpenUntil(chatRoom.getOpenUntil());
		room.setGuestId(chatRoom.getGuestId());
		room.setGuestName(chatRoom.getGuestName());
		room.setCompanyId(chatRoom.getCompanyId());
		room.setGroupId(chatRoom.getGroupId());
		room.setImageId(chatRoom.getImageId());
		room.setVideoLiveId(chatRoom.getVideoLiveId());
		room.setVideoRecordedId(chatRoom.getVideoRecordedId());
		room.setUsePolicyEnabled(chatRoom.getUsePolicyEnabled());
		room.setUsePolicyURL(chatRoom.getUsePolicyURL());
		room.setCreateDate(new Date());

		return roomPersistence.update(room, false);
	}

	/**
	 * Exclui uma sala de bate-papo
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public final void deleteChatRoom(long roomId) throws PortalException, SystemException {
		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(roomId);
		if (room != null) {
			if (ChatRoomLocalServiceUtil.getUsersCountInChatRoom(roomId) > 0 && room.isOpen()) {
				throw new CantRemoveOpenedChatRoom();
			} else {
				ChatRoomLocalServiceUtil.deleteChatRoom(room);
			}
		}
	}

	/**
	 * Verifica se o usuário pode moderar uma sala
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public final boolean canModerate(long roomId) throws PortalException, SystemException {
		User user = getGuestOrUser();
		if (user.isDefaultUser())
			return false;
		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(roomId);
		if (user.getUserId() == room.getGuestId())
			return true;

		long groupId = room.getGroupId();
		return getPermissionChecker().hasPermission(groupId, "br.gov.camara.edemocracia.portlets.chat.model", groupId, "MODERATE");
	}

	/**
	 * Verifica se o usuário possui permissões
	 * 
	 * @param room
	 * @param spy
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private final boolean havePermission(ChatRoom room, boolean spy) throws PortalException, SystemException {
		User user = getGuestOrUser();
		long groupId = room.getGroupId();
		if (user.isDefaultUser() && !room.isAnonymousAllowed())
			return false;
		if (spy)
			return getPermissionChecker().hasPermission(groupId, "br.gov.camara.edemocracia.portlets.chat.model", groupId, "SPY");
		else
			return getPermissionChecker().hasPermission(groupId, "br.gov.camara.edemocracia.portlets.chat.model", groupId, "JOIN");
	}

	/**
	 * Verifica se o usuário pode entrar na sala.
	 * 
	 * Verifica, através das permissões, se a sala está aberta e da quantidade
	 * de usuários na sala, se o usuário pode entrar
	 * 
	 * @param roomId
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public final boolean canJoin(long roomId) throws PortalException, SystemException {
		User portalUser = getGuestOrUser();
		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(roomId);

		ChatRoomUser chatUser = ChatRoomUserLocalServiceUtil.findByPortalUser(room, portalUser);
		if (chatUser != null && chatUser.isBanned())
			return false;

		if (canModerate(roomId)) {
			return true;
		}

		if (!havePermission(room, false))
			return false;

		if (!room.isOpen())
			return false;

		return ChatRoomLocalServiceUtil.roomHaveSpaceLeft(room);
	}

	/**
	 * Verifica se pode espiar
	 * 
	 * @param roomId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public final boolean canSpy(long roomId) throws PortalException, SystemException {
		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(roomId);

		if (!room.isOpen())
			return false;

		return havePermission(room, true);
	}

	private boolean canView(ChatRoom room) throws PrincipalException {
		long groupId = room.getGroupId();
		return getPermissionChecker().hasPermission(groupId, "br.gov.camara.edemocracia.portlets.chat.model", groupId, "VIEW");
	}

	/**
	 * Obtém o número de usuários na sala
	 * 
	 * @param roomId
	 * @return
	 * @throws SystemException
	 */
	@Override
	public final long getUsersCountInChatRoom(long roomId) throws SystemException {
		return ChatRoomLocalServiceUtil.getUsersCountInChatRoom(roomId);
	}

	/**
	 * Obtém o nome da comunidade em que a sala está
	 * 
	 * @param roomId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@Override
	public final String getChatRoomCommunityName(long roomId) throws PortalException, SystemException {
		ChatRoom chatRoom = ChatRoomLocalServiceUtil.getChatRoom(roomId);
		try {
			Group group = GroupLocalServiceUtil.getGroup(chatRoom.getGroupId());
			return group.getName();
		} catch (PortalException e) {
			return null;
		}
	}

	/**
	 * Adiciona um usuário autenticado na sala
	 */
	@Override
	public final ChatRoomUser addChatUser(long roomId, Date timestamp) throws SystemException, PortalException {

		User portalUser = getGuestOrUser();
		if (portalUser.isDefaultUser())
			throw new AccessDeniedException();

		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(roomId);

		if (canModerate(roomId))
			return ChatRoomLocalServiceUtil.addModeratorToRoom(room, portalUser, timestamp);
		else {
			if (!havePermission(room, false))
				throw new AccessDeniedException();
			return ChatRoomLocalServiceUtil.addUserToRoom(room, portalUser, timestamp);
		}
	}

	/**
	 * Adiciona um usuário anônimo na sala de bate-papo
	 */
	@Override
	public final ChatRoomUser addAnonUser(long roomId, Date timestamp, String name, String email, long uf) throws PortalException, SystemException {

		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(roomId);
		if (!havePermission(room, false))
			throw new AccessDeniedException();

		return ChatRoomLocalServiceUtil.addAnonUser(room, timestamp, name, email, uf);
	}

	@Override
	public final UserActivityId addSpyUser(long roomId, Date timestamp) throws PortalException, SystemException {
		User user = getGuestOrUser();

		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(roomId);
		if (!havePermission(room, true))
			throw new AccessDeniedException();

		return ChatRoomLocalServiceUtil.addSpyUser(room, timestamp, user);
	}

	/**
	 * Aprova uma mensagem
	 */
	@Override
	public final void approveMessage(long roomId, long messageId, boolean approved, Date timestamp) throws SystemException, PortalException {

		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(roomId);
		ChatRoomUser user = ChatRoomUserLocalServiceUtil.findByPortalUser(room, getGuestOrUser());
		if (user == null || !user.isModerator())
			throw new AccessDeniedException();

		ChatRoomMessage msg = getChatRoomMessageLocalService().getChatRoomMessage(messageId);
		if (msg.getChatRoomId() != roomId)
			return;

		ChatRoomMessageLocalServiceUtil.approveMessage(msg, timestamp, approved);
		ChatRoomLocalServiceUtil.updateUserTimestamp(roomId, UserActivityId.forPersistentUser(user.getChatUserId()));
	}

	/**
	 * Bane um usuário
	 */
	@Override
	public final void banUser(long roomId, long chatUserId, Date timestamp, boolean banned) throws SystemException, PortalException {

		ChatRoom sala = ChatRoomLocalServiceUtil.getChatRoom(roomId);
		ChatRoomUser moderador = ChatRoomUserLocalServiceUtil.findByPortalUser(sala, getGuestOrUser());
		ChatRoomUser usuarioParaBanir = ChatRoomUserLocalServiceUtil.fetchChatRoomUser(chatUserId);
		ChatRoomLocalServiceUtil.banirUsuario(sala, moderador, usuarioParaBanir, timestamp, banned);
	}

	/**
	 * Lista todas as salas no grupo
	 */
	public final ChatRoom[] findAllInGroup(long groupId) throws SystemException {
		ChatRoom[] result;
		List<ChatRoom> rs = getChatRoomPersistence().findByGroupId(groupId);

		result = new ChatRoom[(rs.size())];
		return rs.toArray(result);

	}

	/**
	 * Retorna todas as salas abertas nesta comunidade Para usuários que tem
	 * permissão de moderação, retorna também as salas fechadas sem histórico
	 * definido
	 * 
	 * @param groupId
	 * @return
	 * @throws SystemException
	 * @throws PrincipalException
	 */
	public final ChatRoomBean[] findOpenRoomsInGroup(long groupId) throws SystemException {

		DynamicQuery q = DynamicQueryFactoryUtil.forClass(ChatRoom.class).add(PropertyFactoryUtil.forName(GROUP_ID_FIELD).eq(groupId));
		return findOpenAndEnterableClosedRooms(q);
	}

	/**
	 * Retorna todas as salas abertas na instancia do portal Para usuários que
	 * tem permissão de moderação, retorna também as salas fechadas sem
	 * histórico definido.
	 * 
	 * @param companyId
	 * @return
	 * @throws SystemException
	 * @throws PrincipalException
	 */
	public final ChatRoomBean[] findOpenAndEnterableClosedRoomsInCompany(long companyId) throws SystemException {
		// Configurando query

		User user = getCurrentUser();
		boolean userLogado = false;
		if (user != null) {
			userLogado = true;
		}

		List<ChatRoom> rs = ChatRoomFinderUtil.findOpenAndEnterableClosedRoomsInCompany(companyId, userLogado);
		List<ChatRoomBean> retorno = new ArrayList<ChatRoomBean>();

		// Verificando permissões
		for (ChatRoom chatRoom : rs) {
			ChatPermissionChecker checker = getChatPermissionChecker(chatRoom);

			if (checker.isCanJoin() || checker.isCanSpy()) {

				boolean isOpen = chatRoom.getStatus() == RoomStatus.Opened.getValue();
				ChatRoomBean room = convertToChatRoomBean(chatRoom, checker.isCanJoin(), checker.isCanSpy(), isOpen);
				retorno.add(room);
			}
		}

		ChatRoomBean[] result = new ChatRoomBean[(retorno.size())];
		return retorno.toArray(result);
	}

	private ChatRoomBean[] findOpenAndEnterableClosedRooms(DynamicQuery q) throws SystemException {
		// Configurando query

		User user = getCurrentUser();

		if (user != null) {
			q.add(RestrictionsFactoryUtil.or(
			        PropertyFactoryUtil.forName("status").eq(RoomStatus.Opened.getValue()),
			        RestrictionsFactoryUtil.and(PropertyFactoryUtil.forName("status").eq(RoomStatus.Closed.getValue()),
			                PropertyFactoryUtil.forName("openPolicy").eq(RoomOpenPolicy.Manual.getValue()))));
		} else {
			q.add(PropertyFactoryUtil.forName("status").eq(RoomStatus.Opened.getValue()));

		}
		q.addOrder(OrderFactoryUtil.desc("groupId"));
		q.addOrder(OrderFactoryUtil.desc("createDate"));
		q.addOrder(OrderFactoryUtil.desc("roomId"));

		@SuppressWarnings("unchecked")
		List<ChatRoom> rs = (List<ChatRoom>) getChatRoomLocalService().dynamicQuery(q);
		List<ChatRoomBean> retorno = new ArrayList<ChatRoomBean>();

		// Verificando permissões
		for (ChatRoom chatRoom : rs) {
			ChatPermissionChecker checker = getChatPermissionChecker(chatRoom);

			if (checker.isCanJoin() || checker.isCanSpy()) {

				boolean isOpen = chatRoom.getStatus() == RoomStatus.Opened.getValue();
				ChatRoomBean room = convertToChatRoomBean(chatRoom, checker.isCanJoin(), checker.isCanSpy(), isOpen);
				retorno.add(room);
			}
		}

		ChatRoomBean[] result = new ChatRoomBean[(retorno.size())];
		return retorno.toArray(result);
	}

	public final ChatRoomBean[] findScheduledRoomsInGroup(long groupId) throws SystemException {
		DynamicQuery q = DynamicQueryFactoryUtil.forClass(ChatRoom.class).add(PropertyFactoryUtil.forName(GROUP_ID_FIELD).eq(groupId));
		q.add(PropertyFactoryUtil.forName("openPolicy").eq(RoomOpenPolicy.Scheduled.getValue()));
		q.add(PropertyFactoryUtil.forName("openFrom").gt(new Date()));
		q.addOrder(OrderFactoryUtil.desc("groupId"));
		q.addOrder(OrderFactoryUtil.asc("openFrom"));

		@SuppressWarnings("unchecked")
		List<ChatRoom> rs = (List<ChatRoom>) getChatRoomLocalService().dynamicQuery(q);
		List<ChatRoomBean> retorno = new ArrayList<ChatRoomBean>();
		for (ChatRoom chatRoom : rs) {
			ChatPermissionChecker checker = getChatPermissionChecker(chatRoom);
			retorno.add(convertToChatRoomBean(chatRoom, checker.isCanJoin(), checker.isCanSpy(), false));
		}

		ChatRoomBean[] result = new ChatRoomBean[(retorno.size())];
		return retorno.toArray(result);
	}

	public final ChatRoomBean[] findScheduledRoomsInCompany(long companyId) throws SystemException {

		List<ChatRoom> rs = ChatRoomFinderUtil.findScheduledRoomsInCompany(companyId);
		List<ChatRoomBean> retorno = new ArrayList<ChatRoomBean>();
		for (ChatRoom chatRoom : rs) {
			ChatPermissionChecker checker = getChatPermissionChecker(chatRoom);
			retorno.add(convertToChatRoomBean(chatRoom, checker.isCanJoin(), checker.isCanSpy(), false));
		}

		ChatRoomBean[] result = new ChatRoomBean[(retorno.size())];
		return retorno.toArray(result);
	}

	private ChatPermissionChecker getChatPermissionChecker(ChatRoom chatRoom) {
		try {
			return new ChatPermissionChecker(chatRoom);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao recuperar ChatPermissionChecker", e);
		}
	}

	private User getCurrentUser() {
		try {
			return getGuestOrUser();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao recuperar usuário atual", e);
		}
	}

	private ChatRoomBean convertToChatRoomBean(ChatRoom chatRoom, boolean canJoin, boolean canSpy, boolean isOpen) {
		User user = getCurrentUser();

		return new ChatRoomBean(chatRoom.getRoomId(), chatRoom.getRoomName(), canJoin, canSpy, chatRoom.getOpenFrom(), chatRoom.getOpenUntil(), isOpen,
		        getStatusRoom(chatRoom, user.getTimeZone()));
	}

	/**
	 * Retorna todas as salas que tiveram seu histórico definido
	 * 
	 * @param groupId
	 * @return
	 * @throws SystemException
	 */
	public final ChatRoomBean[] findExportedRoomsInGroup(long groupId) throws SystemException {
		DynamicQuery q = DynamicQueryFactoryUtil.forClass(ChatRoom.class).add(PropertyFactoryUtil.forName(GROUP_ID_FIELD).eq(groupId));
		q.add(PropertyFactoryUtil.forName("status").eq(RoomStatus.Exported.getValue()));
		q.addOrder(OrderFactoryUtil.desc("groupId"));
		q.addOrder(OrderFactoryUtil.desc("createDate"));
		q.addOrder(OrderFactoryUtil.desc("roomId"));

		@SuppressWarnings("unchecked")
		List<ChatRoom> rs = (List<ChatRoom>) getChatRoomLocalService().dynamicQuery(q);
		List<ChatRoomBean> retorno = new ArrayList<ChatRoomBean>();

		for (ChatRoom chatRoom : rs) {
			// TODO: Verificar
			// if (false) {
			// try {
			// if (canView(chatRoom)) {
			// retorno.add(convertToChatRoomBean(chatRoom, false, false,
			// false));
			// }
			// } catch (PrincipalException e) {
			// throw new
			// SystemException("Erro ao checar permissão de visualizar.", e);
			// }
			// } else {
			retorno.add(convertToChatRoomBean(chatRoom, false, false, false));
			// }
		}

		ChatRoomBean[] result = new ChatRoomBean[(retorno.size())];

		return retorno.toArray(result);
	}

	/**
	 * Retorna todas as salas que tiveram seu histórico definido em uma
	 * instancia do portal
	 * 
	 * @param companyId
	 * @return
	 * @throws SystemException
	 */
	public final ChatRoomBean[] findExportedRoomsInCompany(long companyId) throws SystemException {
		List<ChatRoom> rs = ChatRoomFinderUtil.findExportedRoomsInCompany(companyId);
		List<ChatRoomBean> retorno = new ArrayList<ChatRoomBean>();
		for (ChatRoom chatRoom : rs) {
			try {
				if (canView(chatRoom)) {
					retorno.add(convertToChatRoomBean(chatRoom, false, false, false));
				}
			} catch (PrincipalException e) {
				throw new SystemException("Erro ao checar permissão de visualizar.", e);
			}
		}

		ChatRoomBean[] result = new ChatRoomBean[(retorno.size())];
		return retorno.toArray(result);

	}

	/**
	 * Obtém a atualização das informações da sala
	 */
	public final String getJSONUpdate(long roomId, UserActivityId userActivityId, Date since, boolean firstUpdate) throws SystemException, PortalException {
		JSONObject jsonResult = JSONFactoryUtil.createJSONObject();
		
		if (userActivityId == null) {
			jsonResult.put("error", "No userActivityId informed");
			return jsonResult.toString();
		}

		ChatRoom room = getRoom(roomId);
		ChatRoomUser user = null;

		if (userActivityId.isPersistentUser()) {
			user = getChatRoomUserPersistence().fetchByPrimaryKey(userActivityId.getChatUserId());
		}
		if (user != null && user.getChatRoomId() != roomId) {
			return jsonResult.toString();
		}
		Date now = new Date();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));

		jsonResult.put("id", room.getRoomId());
		jsonResult.put("name", escapeHtml(room.getRoomName()));
		jsonResult.put("openPolicy", room.getOpenPolicy());
		jsonResult.put("status", room.getStatus());
		jsonResult.put("openFrom", room.getOpenFrom());
		jsonResult.put("openUntil", room.getOpenUntil());
		jsonResult.put("since", df.format(since));
		jsonResult.put("closed", !room.isOpen(now));

		ChatRoomUser[] users = getUsersInChatRoom(roomId);
		
		ChatRoomMessage[] msgs;
		if (firstUpdate) {
			msgs = ChatRoomMessageLocalServiceUtil.getMessagesForUserUntil(room, user, since);
		} else {
			msgs = ChatRoomMessageLocalServiceUtil.getMessagesForUserSince(room, user, since);
		}

		JSONArray jsUsers = JSONFactoryUtil.createJSONArray();
		for (ChatRoomUser u : users) {
			jsUsers.put(u.getJSON());
		}
		jsonResult.put("users", jsUsers);
		JSONArray jsMsgs = JSONFactoryUtil.createJSONArray();
		for (ChatRoomMessage msg : msgs) {
			jsMsgs.put(msg.getJSON());
		}
		jsonResult.put("msgs", jsMsgs);
		if (room.isOpen(now) || (user != null && user.isModerator())) {
			ChatRoomLocalServiceUtil.updateUserTimestamp(roomId, userActivityId);
		}

		return jsonResult.toString();
	}

	public final ChatRoomMessage[] getMessagesForExport(long roomId) throws SystemException, PortalException {

		ChatRoom room = getChatRoomLocalService().getChatRoom(roomId);
		DynamicQuery q = DynamicQueryFactoryUtil
		        .forClass(ChatRoomMessage.class)
		        .add(PropertyFactoryUtil.forName(CHAT_ROOM_ID_FIELD).eq(roomId))
		        .add(PropertyFactoryUtil.forName(MESSAGE_PUBLIC_FIELD).eq(true))
		        .add(PropertyFactoryUtil.forName(ADMIN_MESSAGE_FIELD).eq(false))
		        .add(PropertyFactoryUtil.forName(MESSAGE_STATUS_FIELD).eq(MessageStatus.Approved.getValue()))
		        .add(RestrictionsFactoryUtil.or(PropertyFactoryUtil.forName("senderType").eq(UserType.SpecialGuest.getValue()),
		                PropertyFactoryUtil.forName("messageType").in(new Object[] { MessageType.Standard.getValue(), MessageType.Approved.getValue() })));
		if (room.getStatus() != RoomStatus.Exported.getValue()) {
			q.addOrder(OrderFactoryUtil.asc(MESSAGE_TS_FIELD));
		} else {
			q.addOrder(OrderFactoryUtil.asc("exportedPosition"));
		}

		List<?> lm = getChatRoomMessageLocalService().dynamicQuery(q);
		ChatRoomMessage[] result = new ChatRoomMessage[lm.size()];
		return lm.toArray(result);

	}

	public final List<ChatRoomUserBean> findAllChatRoomParticipants(long roomId) throws PortalException, SystemException {
		return ChatRoomFinderUtil.findAllChatRoomParticipants(roomId);
	}

	/**
	 * Conta a quantidade de usuários que entrou na sala
	 */
	public final long getUserCount(long roomId) throws SystemException, PortalException {

		DynamicQuery q = DynamicQueryFactoryUtil.forClass(ChatRoomMessage.class).add(PropertyFactoryUtil.forName(CHAT_ROOM_ID_FIELD).eq(roomId))
		        .add(PropertyFactoryUtil.forName(MESSAGE_PUBLIC_FIELD).eq(true)).add(PropertyFactoryUtil.forName(ADMIN_MESSAGE_FIELD).eq(false))
		        .add(PropertyFactoryUtil.forName(MESSAGE_STATUS_FIELD).eq(MessageStatus.Approved.getValue()))
		        .add(PropertyFactoryUtil.forName("messageType").eq(MessageType.UserEntered.getValue()))
		        .setProjection(ProjectionFactoryUtil.countDistinct("senderEmail"));

		List<?> lm = getChatRoomMessageLocalService().dynamicQuery(q);
		long count = ((Number) lm.get(0)).longValue();
		return count;

	}

	public final void saveExportedMessages(long roomId, Long[] messages) throws SystemException, PortalException {
		Long[] absMessages = new Long[messages.length];
		for (int msgIdx = 0; msgIdx < messages.length; msgIdx++) {
			absMessages[msgIdx] = Math.abs(messages[msgIdx]);
		}

		final int BATCH_SIZE = 500;
		int i = 0;

		for (int posicao = 0; posicao < absMessages.length; posicao += BATCH_SIZE) {

			// Dividindo array em blocos de 500
			int batchSize = Math.min(BATCH_SIZE, absMessages.length - posicao);
			Long[] absMessagesPart = new Long[batchSize];
			System.arraycopy(absMessages, posicao, absMessagesPart, 0, batchSize);

			// Atualizando mensagens
			ChatRoomMessage[] msgs = getMessagesWithIds(roomId, absMessagesPart);
			for (ChatRoomMessage msg : msgs) {
				msg.setExportedPosition(i);
				msg.setExportedRemoved(messages[i] < 0);
				getChatRoomMessageLocalService().updateChatRoomMessage(msg, true);
				i++;
			}

		}

		ChatRoom room = getChatRoomLocalService().getChatRoom(roomId);
		room.setStatus(RoomStatus.Exported.getValue());
		updateChatRoom(room, true);

	}

	public final ChatRoomMessage[] getMessagesWithIds(long roomId, Long[] messages) throws SystemException {
		int msgslen = messages.length;

		DynamicQuery q = DynamicQueryFactoryUtil.forClass(ChatRoomMessage.class).add(PropertyFactoryUtil.forName(CHAT_ROOM_ID_FIELD).eq(roomId))
		        .add(PropertyFactoryUtil.forName("chatMessageId").in(messages));
		List<?> lm = getChatRoomMessageLocalService().dynamicQuery(q);
		Map<Long, ChatRoomMessage> msgsMap = new HashMap<Long, ChatRoomMessage>();
		for (Object omsg : lm) {
			ChatRoomMessage msg = (ChatRoomMessage) omsg;
			msgsMap.put(msg.getChatMessageId(), msg);
		}
		ChatRoomMessage[] result = new ChatRoomMessage[lm.size()];
		for (int i = 0; i < msgslen; i++) {
			result[i] = msgsMap.get(messages[i]);
		}
		return result;
	}

	public final ChatRoom getRoom(long roomId) throws PortalException, SystemException {
		ChatRoom result = getChatRoomLocalService().getChatRoom(roomId);
		if (result.getGuestId() != 0 && (result.getGuestName() == null || result.getGuestName().length() == 0)) {

			User u = UserLocalServiceUtil.getUserById(result.getGuestId());
			result.setGuestName(u.getFullName());

		}
		return result;
	}

	/**
	 * Obtém o usuário de chat a partir do usuário autenticado
	 * 
	 * @throws PortalException
	 */
	@Override
	public final ChatRoomUser getChatUserFromPortalUser(long roomId) throws SystemException, PortalException {
		User portalUser = getGuestOrUser();
		if (portalUser.isDefaultUser())
			return null;

		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(roomId);
		return ChatRoomUserLocalServiceUtil.findByPortalUser(room, portalUser);
	}

	public final ChatRoomUser[] getUsersInChatRoom(long roomId) throws SystemException, PortalException {

		ChatRoomUser[] result = null;
		DynamicQuery q = DynamicQueryFactoryUtil.forClass(ChatRoomUser.class).add(PropertyFactoryUtil.forName(CHAT_ROOM_ID_FIELD).eq(roomId))
		        .addOrder(OrderFactoryUtil.desc("userType")).addOrder(OrderFactoryUtil.asc("userName"));
		List<?> lr = getChatRoomUserLocalService().dynamicQuery(q);

		result = new ChatRoomUser[lr.size()];
		return lr.toArray(result);
	}

	/**
	 * Abre a sala de chat
	 */
	@Override
	public final void openChatRoom(long roomId, Date timestamp) throws PortalException, SystemException {
		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(roomId);
		ChatRoomUser user = ChatRoomUserLocalServiceUtil.findByPortalUser(room, getGuestOrUser());
		if (user == null || !user.isModerator())
			throw new AccessDeniedException();

		if (room.getOpenPolicy() == RoomOpenPolicy.Manual.getValue() && room.getStatus() == RoomStatus.Closed.getValue()) {
			room.setStatus(RoomStatus.Opened.getValue());
			room.setOpenFrom(timestamp);
			room.setOpenUntil(null);
			updateChatRoom(room, true);
			
			logChatRoomUserActivity(room, user, true);
		}
	}

	/**
	 * Fecha a sala de chat
	 * 
	 * @param roomId
	 * @param timestamp
	 */
	@Override
	public final void closeChatRoom(long roomId, Date timestamp) throws PortalException, SystemException {
		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(roomId);
		ChatRoomUser user = ChatRoomUserLocalServiceUtil.findByPortalUser(room, getGuestOrUser());
		if (user == null || !user.isModerator())
			throw new AccessDeniedException();

		if ((room.getOpenPolicy() == RoomOpenPolicy.Manual.getValue() || room.getOpenPolicy() == RoomOpenPolicy.Scheduled.getValue())
		        && room.getStatus() == RoomStatus.Opened.getValue()) {
			room.setStatus(RoomStatus.Closed.getValue());
			room.setOpenUntil(timestamp);
			ChatRoomMessageLocalServiceUtil.postMessage(MessageType.RoomClosed, user, room, timestamp, "fechou a sala", true, false, null, 0);
			updateChatRoom(room, true);
			
			logChatRoomUserActivity(room, user, false);
			
			// Remove os usuários desta sala
			// ChatRoomLocalServiceUtil.removeAllUsersFromRoom(room, timestamp);
		}
	}

	/**
	 * Posta uma nova mensagem
	 * 
	 * Se a sala estiver fechada, ignora a postagem, a não ser que seja
	 * moderador
	 */
	public final void postMessage(MessageType type, long chatUserId, long roomId, Date timestamp, String message, boolean pub, boolean admin,
	        long recipientUser, int textType) throws SystemException, PortalException {

		ChatRoom room = ChatRoomLocalServiceUtil.getChatRoom(roomId);

		ChatRoomUser sender = ChatRoomUserLocalServiceUtil.getChatRoomUser(chatUserId);
		if (!sender.isModerator()) {
			admin = false;
		}

		// Se a sala estiver fechada, ignora.
		if (!room.isOpen() && !sender.isModerator()) {
			return;
		}

		// Se o usuário estiver banido, ignora.
		if (sender.isBanned()) {
			return;
		}

		ChatRoomUser recipient = null;

		// Se o destinatário não existir, ignora a mensagem, caso seja reservada
		if (recipientUser > 0) {
			try {
				recipient = ChatRoomUserLocalServiceUtil.getChatRoomUser(recipientUser);
			} catch (PortalException e) {
				if (!pub) {
					ChatRoomLocalServiceUtil.updateUserTimestamp(roomId, UserActivityId.forPersistentUser(sender.getChatUserId()));
					return;
				}
			}
		}

		ChatRoomMessageLocalServiceUtil.postMessage(type, sender, room, timestamp, message, pub, admin, recipient, textType);
		ChatRoomLocalServiceUtil.updateUserTimestamp(roomId, UserActivityId.forPersistentUser(sender.getChatUserId()));
	}

	/**
	 * Remove um usuário da sala
	 */
	@Override
	public final void removeChatUser(long roomId, UserActivityId userActivityId, Date timestamp) throws SystemException, PortalException {
		if (userActivityId.isPersistentUser()) {
			ChatRoomUser user = ChatRoomUserLocalServiceUtil.getChatRoomUser(userActivityId.getChatUserId());
			if (user.getChatRoomId() != roomId) {
				return;
			}
			ChatRoomLocalServiceUtil.removeUser(user, timestamp);
		} else {
			ChatRoomLocalServiceUtil.removeSpyUser(roomId, userActivityId);
		}
	}

	/**
	 * Atualiza a sala
	 */
	public final void updateChatRoom(ChatRoom room, boolean merge) throws SystemException {
		RoomOpenPolicy policy = RoomOpenPolicy.withValue(room.getOpenPolicy());
		switch (policy) {
		case Always:
			room.setStatus(RoomStatus.Opened.getValue());
			break;
		case Scheduled:
			Date now = new Date();
			if (room.getStatus() != RoomStatus.Exported.getValue()) {
				if (now.after(room.getOpenFrom()) && now.before(room.getOpenUntil())) {
					room.setStatus(RoomStatus.Opened.getValue());
				} else {
					room.setStatus(RoomStatus.Closed.getValue());
				}
			}
			break;
		default:
			break;
		}
		getChatRoomLocalService().updateChatRoom(room, merge);

	}

	private String getStatusRoom(ChatRoom room, TimeZone tz) {

		String status;
		if (room.isOpen()) {
			if (room.getOpenPolicy() == RoomOpenPolicy.Scheduled.getValue()) {
				DateFormat dfAbertura = new SimpleDateFormat("'Aberta desde 'dd/MM/yyyy' - 'HH:mm");
				dfAbertura.setTimeZone(tz);
				status = dfAbertura.format(room.getOpenFrom());
			} else {
				status = "Aberta";
			}

		} else {

			Date now = new Date();
			DateFormat dfAbrir = new SimpleDateFormat("'Abertura em 'dd/MM/yyyy' - 'HH:mm");
			DateFormat dfFechada = new SimpleDateFormat("'Fechada (Encerrada em 'dd/MM/yyyy' - 'HH:mm')'");
			dfAbrir.setTimeZone(tz);
			dfFechada.setTimeZone(tz);

			if (room.getOpenUntil() != null && room.getOpenUntil().before(now))
				status = dfFechada.format(room.getOpenUntil());
			else if (room.getOpenFrom() != null && now.before(room.getOpenFrom()))
				status = dfAbrir.format(room.getOpenFrom());
			else
				status = "Fechada";

		}
		return status;
	}
	
	/**
	 * Faz um log das atividades de abertura e fechamento das salas do batepapo por usuário
	 * 
	 * @param room
	 * @param user
	 * @param openingRoom
	 */
	private void logChatRoomUserActivity(ChatRoom room , ChatRoomUser user , boolean openingRoom){
		String activity = openingRoom ? "aberta" : "fechada";
		
		long userId = -1;
		String userEmail = "email não detectado" ;
		if (user != null) {
			userId = user.getUserId();
			userEmail = user.getUserEmail();
		} 
		
		long roomId = -1;
		String roomName = "nome não detectado";
		if(room != null) {
			roomId = room.getRoomId();
			roomName = room.getRoomName();
		}
		
		LOG.info("Sala " + roomId + " ("+ roomName +") foi "+ activity + " pelo usuário " + userId + " (" + userEmail +")");
	}

}
