package br.gov.camara.edemocracia.portlets.chat.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import br.gov.camara.edemocracia.portlets.chat.AccessDeniedException;
import br.gov.camara.edemocracia.portlets.chat.ChatRoomClosedException;
import br.gov.camara.edemocracia.portlets.chat.ChatRoomFullException;
import br.gov.camara.edemocracia.portlets.chat.InvalidUserNameException;
import br.gov.camara.edemocracia.portlets.chat.RoomMessagesAlreadyExportedException;
import br.gov.camara.edemocracia.portlets.chat.UserBannedException;
import br.gov.camara.edemocracia.portlets.chat.UserNameAlreadyInUseException;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;
import br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomStatus;
import br.gov.camara.edemocracia.portlets.chat.model.impl.UserType;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomMessageLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomUserLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatUserActivityManager;
import br.gov.camara.edemocracia.portlets.chat.service.UserActivityId;
import br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomLocalServiceBaseImpl;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomFinderUtil;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomUserPersistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.DefaultFullNameGenerator;
import com.liferay.portal.security.auth.FullNameGenerator;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the chat room local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil}
 * to access the chat room local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Ricardo Lima
 * @see br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil
 */
public class ChatRoomLocalServiceImpl extends ChatRoomLocalServiceBaseImpl {

	private static final Log LOG = LogFactoryUtil.getLog(ChatRoomLocalServiceImpl.class);

	private ChatUserActivityManager userActivityManager = new ChatUserActivityManagerLocalMap();

	public List<ChatRoom> findOpenAndEnterableClosedRoomsInCompany(long companyId, boolean userLogado) throws SystemException {
		return ChatRoomFinderUtil.findOpenAndEnterableClosedRoomsInCompany(companyId, userLogado);
	}

	public List<ChatRoom> findScheduledRoomsInCompany(long groupId) throws SystemException {
		return ChatRoomFinderUtil.findScheduledRoomsInCompany(groupId);
	}

	public List<ChatRoom> findExportedRoomsInCompany(long groupId) throws SystemException {
		return ChatRoomFinderUtil.findExportedRoomsInCompany(groupId);
	}

	/**
	 * Lista os nomes de usuário na sala que começam pelo nome especificado
	 * 
	 * @param room
	 * @param name
	 * @return
	 * @throws SystemException
	 */
	@SuppressWarnings("unchecked")
	public HashSet<String> listUsersStartingBy(ChatRoom room, String name) throws SystemException {
		int pos;
		StringBuilder like = new StringBuilder(name);
		pos = 0;
		while (pos < like.length()) {
			char chr = like.charAt(pos);
			if (chr == '_' || chr == '%' || chr == '[' || chr == ']') {
				like.replace(pos, pos + 1, "[" + chr + "]");
				pos += 3;
			} else {
				pos++;
			}
		}
		like.append('%');

		DynamicQuery q = DynamicQueryFactoryUtil.forClass(ChatRoomUser.class);
		q.add(PropertyFactoryUtil.forName("chatRoomId").eq(room.getRoomId()));
		q.add(PropertyFactoryUtil.forName("userName").like(like.toString()));
		q.setProjection(ProjectionFactoryUtil.property("userName"));
		return new HashSet<String>(dynamicQuery(q));
	}

	/**
	 * Verifica se há usuários no portal com o mesmo fullname
	 * 
	 * @param fullName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean isFullNameInUseInPortal(long companyId, String fullName) {
		FullNameGenerator fullNameGenerator = new DefaultFullNameGenerator();
		String[] name = fullNameGenerator.splitFullName(fullName);

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(User.class, PortalClassLoaderUtil.getClassLoader());
		query.setProjection(ProjectionFactoryUtil.property("userId"));
		query.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		query.add(PropertyFactoryUtil.forName("firstName").eq(name[0]));
		query.add(PropertyFactoryUtil.forName("middleName").eq(name[1]));
		query.add(PropertyFactoryUtil.forName("lastName").eq(name[2]));

		List<Long> list = null;

		try {
			list = UserLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			LOG.error(e);
		}

		return list != null && !list.isEmpty();
	}

	/**
	 * Conta o número de usuários na sala
	 * 
	 * @param roomId
	 * @return
	 * @throws SystemException
	 */
	@Override
	public final long getUsersCountInChatRoom(long roomId) throws SystemException {
		return userActivityManager.getNumberOfUsersInRoom(roomId);
	}

	/**
	 * Verifica se há espaço na sala
	 * 
	 * @param room
	 * @return
	 * @throws SystemException
	 */
	@Override
	public boolean roomHaveSpaceLeft(ChatRoom room) throws SystemException {
		return getUsersCountInChatRoom(room.getRoomId()) < room.getCapacity();
	}

	/**
	 * Adiciona um usuário autenticado em uma sala de bate-papo
	 * 
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public ChatRoomUser addUserToRoom(ChatRoom room, User portalUser, Date timestamp) throws PortalException, SystemException {

		if (!room.isOpen(timestamp))
			throw new ChatRoomClosedException();

		// Se o usuário já estiver na sala, reusa, caso seja possível
		List<ChatRoomUser> result = getChatRoomUserPersistence().findByCR_U(room.getRoomId(), portalUser.getUserId());
		if (!result.isEmpty()) {
			ChatRoomUser user = result.get(0);
			if (user.isBanned()) {
				throw new UserBannedException();
			}
			if (user.isModerator()) {
				removeUser(user, timestamp, true);
			} else {
				return user;
			}
		}

		// Se a sala estiver cheia...
		if (!roomHaveSpaceLeft(room))
			throw new ChatRoomFullException();

		return addAuthenticatedUserToRoom(portalUser, UserType.Standard, room, timestamp);
	}

	/**
	 * Adiciona um moderador na sala de bate-papo.
	 * 
	 * Permite ao moderador entrar na sala de bate-papo, independente do estado
	 * 
	 * @param room
	 * @param portalUser
	 * @param timestamp
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public ChatRoomUser addModeratorToRoom(ChatRoom room, User portalUser, Date timestamp) throws PortalException, SystemException {
		if (room.getStatus() == RoomStatus.Exported.getValue())
			throw new RoomMessagesAlreadyExportedException();

		UserType userType = (portalUser.getUserId() == room.getGuestId()) ? UserType.SpecialGuest : UserType.Moderator;

		// Se o usuário já estiver na sala, reusa, caso seja possível
		List<ChatRoomUser> result = getChatRoomUserPersistence().findByCR_U(room.getRoomId(), portalUser.getUserId());
		if (!result.isEmpty()) {
			ChatRoomUser user = result.get(0);
			if (user.getUserType() == UserType.Standard.getValue()) {
				removeUser(user, timestamp, true);
			} else if (user.getUserType() != userType.getValue()) {
				removeUser(user, timestamp, true);
			} else if (user.getUserType() == UserType.SpecialGuest.getValue() && room.getGuestId() != portalUser.getUserId()) {
				removeUser(user, timestamp, true);
			} else {
				// Já era moderador
				return user;
			}
		}

		return addAuthenticatedUserToRoom(portalUser, userType, room, timestamp);
	}

	private ChatRoomUser addAuthenticatedUserToRoom(User portalUser, UserType userType, ChatRoom room, Date timestamp) throws SystemException, PortalException {

		ChatRoomUserPersistence userPersistence = getChatRoomUserPersistence();

		ChatRoomUser user = userPersistence.create(getCounterLocalService().increment(ChatRoomUser.class.getName()));
		user.setChatRoomId(room.getRoomId());

		user.setUserType(userType.getValue());
		user.setJoinedTS(timestamp);
		user.setBanned(false);
		user.setUserId(portalUser.getUserId());
		user.setUserImgId(portalUser.getPortraitId());
		user.setUserName(portalUser.getFullName());

		List<Address> addresses = AddressLocalServiceUtil.getAddresses(room.getCompanyId(), Contact.class.getName(), portalUser.getContactId());
		if (addresses.size() > 0) {
			user.setUserUF(addresses.get(0).getRegionId());
		} else {
			user.setUserUF(-1);
		}

		user.setUserEmail(portalUser.getEmailAddress());

		user = userPersistence.update(user, false);

		userActivityManager.addUser(room.getRoomId(), UserActivityId.forPersistentUser(user.getChatUserId()));

		postUserEnteredMessage(room, timestamp, user);

		updateMaxSimultaneousUsers(room);

		return user;
	}

	/**
	 * Adiciona um usuário anônimo
	 * 
	 * @param room
	 * @param timestamp
	 * @param name
	 * @param email
	 * @param uf
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public ChatRoomUser addAnonUser(ChatRoom room, Date timestamp, String name, String email, long uf) throws PortalException, SystemException {

		if (!room.isOpen(timestamp))
			throw new ChatRoomClosedException();

		if (!roomHaveSpaceLeft(room))
			throw new ChatRoomFullException();

		ChatRoomUser result = null;

		if (verificaSeNomeEmUsoNaSala(room, name)) {
			constroiSugestaoDeNome(room, name);
		}

		ChatRoomUser user = ChatRoomUserLocalServiceUtil.createChatRoomUser(getCounterLocalService().increment(ChatRoomUser.class.getName()));
		user.setChatRoomId(room.getRoomId());
		user.setUserType(UserType.Standard.getValue());
		user.setJoinedTS(timestamp);
		user.setBanned(false);
		user.setUserId(-1);
		user.setUserImgId(0);
		user.setUserName(name);
		user.setUserUF(uf);
		user.setUserEmail(email);
		result = ChatRoomUserLocalServiceUtil.updateChatRoomUser(user, false);

		userActivityManager.addUser(room.getRoomId(), UserActivityId.forPersistentUser(user.getChatUserId()));

		postUserEnteredMessage(room, timestamp, user);

		updateMaxSimultaneousUsers(room);

		return result;
	}

	private void updateMaxSimultaneousUsers(ChatRoom room) {
		long currentSimultaneousUsers = userActivityManager.getNumberOfUsersInRoom(room.getRoomId());
		if (currentSimultaneousUsers > room.getMaxSimultaneousUsers()) {
			chatRoomFinder.incrementarNumeroMaximoDeParticipantes(room.getCompanyId(), room.getRoomId());
		}
	}

	private void updateMaxSimultaneousUsersSpying(ChatRoom room) {
		long currentSimultaneousUsersSpying = userActivityManager.getNumberOfUsersSpyingInRoom(room.getRoomId());
		if (currentSimultaneousUsersSpying > room.getMaxSimultaneousUsersSpying()) {
			chatRoomFinder.incrementarNumeroMaximoDeEspioes(room.getCompanyId(), room.getRoomId());
		}
	}

	private boolean verificaSeNomeEmUsoNaSala(ChatRoom room, String name) throws SystemException, InvalidUserNameException, UserNameAlreadyInUseException {
		boolean userExists = ChatRoomUserLocalServiceUtil.isUserNameInUse(room, name);
		if (!userExists)
			userExists = ChatRoomLocalServiceUtil.isFullNameInUseInPortal(room.getCompanyId(), name);

		return userExists;
	}

	private void constroiSugestaoDeNome(ChatRoom room, String name) throws InvalidUserNameException, SystemException, UserNameAlreadyInUseException {
		name = retiraNumerosAoFinalDoNome(name);

		HashSet<String> existingUserNames = ChatRoomLocalServiceUtil.listUsersStartingBy(room, name);

		// Cria sugestões com números aleatórios
		ArrayList<String> suggestions = new ArrayList<String>();
		if (!existingUserNames.contains(name) && !ChatRoomLocalServiceUtil.isFullNameInUseInPortal(room.getCompanyId(), name))
			suggestions.add(name);

		int capacity = Math.min(100, room.getCapacity());
		while (suggestions.size() < 5) {
			String suggestion = name + Integer.toString((int) (Math.random() * capacity) + 1);
			if (!suggestions.contains(suggestion) && !existingUserNames.contains(suggestion)
					&& !ChatRoomLocalServiceUtil.isFullNameInUseInPortal(room.getCompanyId(), suggestion))
				suggestions.add(suggestion);
		}

		throw new UserNameAlreadyInUseException(suggestions);
	}

	private String retiraNumerosAoFinalDoNome(String name) throws InvalidUserNameException {
		int pos = name.length() - 1;
		while (pos >= 0) {
			char chr = name.charAt(pos);
			if (!Character.isDigit(chr))
				break;
			pos--;
		}
		name = name.substring(0, pos + 1).trim();
		if (name.isEmpty())
			throw new InvalidUserNameException();
		return name;
	}

	private void postUserEnteredMessage(ChatRoom room, Date timestamp, ChatRoomUser user) throws PortalException, SystemException {
		ChatRoomMessageLocalServiceUtil.postMessage(MessageType.UserEntered, user, room, timestamp, "entrou na sala", true, false, null, 0);
	}

	@Override
	public UserActivityId addSpyUser(ChatRoom room, Date timestamp, User user) throws PortalException, SystemException {
		if (!room.isOpen(timestamp)) {
			throw new ChatRoomClosedException();
		}

		if (!user.isDefaultUser()) {
			removerUsuarioSePresenteNaSalaENaoFoiBanido(room.getRoomId(), user);
		}

		UserActivityId idUser = UserActivityId.forNewSpyUser();
		userActivityManager.addUser(room.getRoomId(), idUser);

		updateMaxSimultaneousUsersSpying(room);

		return idUser;
	}

	public void banirUsuario(ChatRoom sala, ChatRoomUser moderador, ChatRoomUser usuarioParaBanir, Date timestamp, boolean banido) throws SystemException,
			PortalException {
		if (!sala.isOpen(timestamp))
			throw new ChatRoomClosedException();
		if (moderador == null || !moderador.isModerator())
			throw new AccessDeniedException();
		if (usuarioParaBanir == null || usuarioParaBanir.getUserType() != UserType.Standard.getValue())
			return;

		usuarioParaBanir.setBanned(banido);
		ChatRoomUserLocalServiceUtil.updateChatRoomUser(usuarioParaBanir);

		if (banido) {
			ChatRoomMessageLocalServiceUtil.postMessage(MessageType.UserBanned, usuarioParaBanir, sala, timestamp, "foi banido", true, false, null, 0);
			userActivityManager.removeUser(sala.getRoomId(), UserActivityId.forPersistentUser(usuarioParaBanir.getChatUserId()));
		} else {
			ChatRoomMessageLocalServiceUtil.postMessage(MessageType.UserUnBanned, usuarioParaBanir, sala, timestamp, "não está mais banido", true, false, null, 0);
			ChatRoomUserLocalServiceUtil.deleteChatRoomUser(usuarioParaBanir.getChatUserId());
		}
		// Timestamp do moderador
		updateUserTimestamp(sala.getRoomId(), UserActivityId.forPersistentUser(moderador.getChatUserId()));
	}

	private void removerUsuarioSePresenteNaSalaENaoFoiBanido(long roomId, User user) throws SystemException {
		List<ChatRoomUser> result = getChatRoomUserPersistence().findByCR_U(roomId, user.getUserId());
		if (!result.isEmpty()) {
			ChatRoomUser chatRoomUser = result.get(0);
			if (!chatRoomUser.isBanned()) {
				removeUser(chatRoomUser, new Date(), true);
			}
		}
	}

	public boolean isUserInRoom(Long roomId, UserActivityId userActivityId) {
		if (roomId == null || userActivityId == null) {
			throw new IllegalArgumentException("Os parâmetros roomId e userActivityId não podem ser null ");
		}

		return userActivityManager.isUserInRoom(roomId, userActivityId);
	}

	public void updateUserTimestamp(Long roomId, UserActivityId userActivityId) {
		userActivityManager.updateUserLastActivity(roomId, userActivityId);
	}

	public void removeSpyUser(Long roomId, UserActivityId userActivityId) throws PortalException, SystemException {
		userActivityManager.removeUser(roomId, userActivityId);
	}

	/**
	 * Remove um usuário da sala de bate-papo
	 * 
	 * @param user
	 * @param timestamp
	 */
	@Override
	public void removeUser(ChatRoomUser user, Date timestamp) {
		removeUser(user, timestamp, false);
	}

	/**
	 * Remove um usuário da sala
	 * 
	 * @param user
	 * @param timestamp
	 * @param force
	 */
	private void removeUser(ChatRoomUser user, Date timestamp, boolean force) {
		// Utilizando roomId do usuário porque a sala pode não existir mais no banco de dados
		long roomId = user.getChatRoomId();
		
		ChatRoom room = fetchChatRoomQuietly(roomId);

		postUserLeftMessage(user, timestamp, room);

		removeUserFromDatabase(user, timestamp, force, room);
		
		userActivityManager.removeUser(roomId, UserActivityId.forPersistentUser(user.getChatUserId()));
	}

	private ChatRoom fetchChatRoomQuietly(long roomId) {
		try {
			return ChatRoomLocalServiceUtil.fetchChatRoom(roomId);
		} catch (SystemException e) {
			return null;
		}
	}

	private void removeUserFromDatabase(ChatRoomUser user, Date timestamp, boolean force, ChatRoom room) {
		if (force || !user.isBanned() || room == null || !room.isOpen(timestamp)) {
			try {
				ChatRoomUserLocalServiceUtil.deleteChatRoomUser(user);
			} catch (SystemException e) {
				// Ignore
			}
		}
	}

	private void postUserLeftMessage(ChatRoomUser user, Date timestamp, ChatRoom room) {
		try {
			if (room != null && !user.isBanned()) {
				ChatRoomMessageLocalServiceUtil.postMessage(MessageType.UserLeft, user, room, timestamp, "saiu da sala", true, false, null, 0);
			}
		} catch (PortalException e) {
			// Ignore
		} catch (SystemException e) {
			// Ignore
		}
	}

	/**
	 * Ajusta o estado das salas agendadas
	 * 
	 * @param timestamp
	 */
	public void checkScheduledRoomState(Date timestamp) throws SystemException {

		// Verifica as salas que deveriam estar fechadas
		DynamicQuery openedRoomsToClose = DynamicQueryFactoryUtil.forClass(ChatRoom.class);
		openedRoomsToClose.add(PropertyFactoryUtil.forName("openPolicy").eq(RoomOpenPolicy.Scheduled.getValue()));
		openedRoomsToClose.add(PropertyFactoryUtil.forName("status").eq(RoomStatus.Opened.getValue()));
		openedRoomsToClose.add(RestrictionsFactoryUtil.or(PropertyFactoryUtil.forName("openFrom").gt(timestamp),
				PropertyFactoryUtil.forName("openUntil").lt(timestamp)));

		@SuppressWarnings("unchecked")
		List<ChatRoom> toClose = dynamicQuery(openedRoomsToClose);
		for (ChatRoom room : toClose) {
			try {
				ChatRoomMessageLocalServiceUtil.postMessage(MessageType.RoomClosed, null, room, timestamp, "fechou a sala", true, false, null, 0);
			} catch (Exception error) {
				LOG.warn("Erro ao postar mensagem de fechamento de sala", error);
			}
			room.setStatus(RoomStatus.Closed.getValue());
			updateChatRoom(room);
			
			logJobActivity(room, false);
		}

		// Verifica as salas que deveriam estar abertas
		DynamicQuery closedRoomsToOpen = DynamicQueryFactoryUtil.forClass(ChatRoom.class);
		closedRoomsToOpen.add(PropertyFactoryUtil.forName("openPolicy").eq(RoomOpenPolicy.Scheduled.getValue()));
		closedRoomsToOpen.add(PropertyFactoryUtil.forName("status").eq(RoomStatus.Closed.getValue()));
		closedRoomsToOpen.add(RestrictionsFactoryUtil.or(PropertyFactoryUtil.forName("openFrom").isNull(), PropertyFactoryUtil.forName("openFrom").le(timestamp)));
		closedRoomsToOpen
				.add(RestrictionsFactoryUtil.or(PropertyFactoryUtil.forName("openUntil").isNull(), PropertyFactoryUtil.forName("openUntil").ge(timestamp)));
		@SuppressWarnings("unchecked")
		List<ChatRoom> toOpen = dynamicQuery(closedRoomsToOpen);
		for (ChatRoom room : toOpen) {
			room.setStatus(RoomStatus.Opened.getValue());
			updateChatRoom(room);
			
			logJobActivity(room, true);
		}
	}

	public void removerUsuariosInativos() throws SystemException, PortalException {
		Collection<UserActivityId> usuariosInativos = userActivityManager.removeInactiveUsers();
		List<Object> chatRoomUserIdsUsuariosInativos = new ArrayList<Object>();
		for (UserActivityId id : usuariosInativos) {
			if (id.isPersistentUser()) {
				chatRoomUserIdsUsuariosInativos.add(id.getChatUserId());
			}
		}

		for (int posicaoInicial = 0; posicaoInicial < chatRoomUserIdsUsuariosInativos.size(); posicaoInicial += 50) {
			int posicaoFinal = Math.min(chatRoomUserIdsUsuariosInativos.size(), posicaoInicial + 50);
			List<Object> pedaco = chatRoomUserIdsUsuariosInativos.subList(posicaoInicial, posicaoFinal);
			DynamicQuery q = DynamicQueryFactoryUtil.forClass(ChatRoomUser.class).add(PropertyFactoryUtil.forName("chatUserId").in(pedaco));

			@SuppressWarnings("unchecked")
			List<ChatRoomUser> inactivePersistentUsers = getChatRoomUserLocalService().dynamicQuery(q);

			Date timestamp = new Date();
			for (ChatRoomUser user : inactivePersistentUsers) {
				removeUser(user, timestamp, true);
			}
		}
	}

	public void removerUsuariosBanidosDeSalasFechadas() {
		chatRoomFinder.removerUsuariosBanidosDeSalasFechadas();
	}

	public void synchronizeActivityManagerAndDatabase() {
		try {
			Date timestamp = new Date();
			List<ChatRoomUser> allChatRoomUsers = ChatRoomUserLocalServiceUtil.getChatRoomUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (ChatRoomUser chatRoomUser : allChatRoomUsers) {
				UserActivityId userActivityId = UserActivityId.forPersistentUser(chatRoomUser.getChatUserId());
				if (!userActivityManager.isUserInRoom(chatRoomUser.getChatRoomId(), userActivityId) && !chatRoomUser.isBanned()) {
					removeUser(chatRoomUser, timestamp, true);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao sincronizar o activityManager e o banco de dados.", e);
		}
	}
	
	/**
	 * Faz um log das atividades de abertura e fechamento das salas pelo Job.
	 * 
	 * @param room
	 * @param openingRoom
	 */
	private void logJobActivity(ChatRoom room, boolean openingRoom) {
		String activity = openingRoom ? "aberta" : "fechada";
		
		long roomId = -1;
		String roomName = "nome não detectado";
		if(room != null) {
			roomId = room.getRoomId();
			roomName = room.getRoomName();
		}
		
		LOG.info("Sala " + roomId + " ("+ roomName+") foi "+ activity +" pelo Job.");
	}
}
