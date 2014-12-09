package br.gov.camara.edemocracia.portlets.chat.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageImpl;
import br.gov.camara.edemocracia.portlets.chat.model.impl.MessageStatus;
import br.gov.camara.edemocracia.portlets.chat.model.impl.MessageTextType;
import br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType;
import br.gov.camara.edemocracia.portlets.chat.model.impl.UserType;
import br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomMessageLocalServiceBaseImpl;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomMessagePersistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the chat room message local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.chat.service.ChatRoomMessageLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.portlets.chat.service.ChatRoomMessageLocalServiceUtil}
 * to access the chat room message local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Ricardo Lima
 * @see br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomMessageLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.chat.service.ChatRoomMessageLocalServiceUtil
 */
public class ChatRoomMessageLocalServiceImpl extends ChatRoomMessageLocalServiceBaseImpl {

	/**
	 * Obtém uma mensagem vazia
	 */
	public ChatRoomMessage getNullMessage() {
		ChatRoomMessage result = new ChatRoomMessageImpl();
		result.setMessageType(MessageType.Null.getValue());
		result.setMessageStatus(MessageStatus.Approved.getValue());
		result.setAdminMessage(false);
		result.setChatMessageId(0);
		result.setChatRoomId(0);
		result.setMessagePublic(false);
		result.setMessageText("");
		result.setMessageTS(new Date());
		result.setParentMessageId(0);
		result.setRecipientUserId(0);
		result.setSenderId(0);
		result.setRecipientUserName("");
		result.setSenderName("");
		return result;
	}

	private boolean isMessageAlwaysApproved(ChatRoomMessage roomMessage, ChatRoom room, ChatRoomUser sender) throws PortalException, SystemException {
		if (!room.isModerated())
			return true;

		if (roomMessage.getMessageType() != MessageType.Standard.getValue())
			return true;

		if (!roomMessage.isMessagePublic())
			return true;

		// Moderador
		if (sender.getUserType() == UserType.Moderator.getValue() || sender.getUserType() == UserType.SpecialGuest.getValue())
			return true;

		return false;
	}

	/**
	 * Cria uma nova mensagem
	 * 
	 * @param type
	 * @param room
	 * @param timestamp
	 * @param message
	 * @param pub
	 * @param admin
	 * @param textType
	 * @param chatUserId
	 * @param roomId
	 * @param recipientUser
	 * @throws SystemException
	 * @throws PortalException
	 */
	@Override
	public void postMessage(MessageType type, ChatRoomUser sender, ChatRoom room, Date timestamp, String message, boolean pub, boolean admin,
	        ChatRoomUser recipient, int textType) throws SystemException, PortalException {

		if (sender == null && type == MessageType.Standard)
			throw new IllegalArgumentException();

		ChatRoomMessage msg = createChatRoomMessage(getCounterLocalService().increment(ChatRoomMessage.class.getName()));
		msg.setChatRoomId(room.getRoomId());

		if (sender != null) {
			msg.setSenderId(sender.getChatUserId());
			msg.setSenderName(sender.getUserName());
			msg.setSenderEmail(sender.getUserEmail());
			msg.setSenderUF(sender.getUserUF());
			msg.setSenderType(sender.getUserType());
		} else {
			msg.setSenderId(-1);
			msg.setSenderName("");
			msg.setSenderEmail("");
			msg.setSenderType(UserType.Moderator.getValue());
			msg.setSenderUF(-1);
		}

		msg.setMessageType(type.getValue());
		msg.setParentMessageId(0L);
		msg.setMessageTS(timestamp);
		msg.setMessagePublic(pub);
		msg.setAdminMessage(admin);
		msg.setMessageText(message);
		msg.setRecipientUserId(recipient == null ? -1 : recipient.getChatUserId());
		msg.setTextType(textType);

		if (recipient != null) {
			msg.setRecipientUserName(recipient.getUserName());
		}
		if (sender == null || isMessageAlwaysApproved(msg, room, sender)) {
			msg.setMessageStatus(MessageStatus.Approved.getValue());
		} else {
			msg.setMessageStatus(MessageStatus.Pending.getValue());
			createPendingMessage(room, msg, sender);
		}

		updateChatRoomMessage(msg, false);
	}

	private void createPendingMessage(ChatRoom room, ChatRoomMessage message, ChatRoomUser sender) throws SystemException {
		ChatRoomMessagePersistence messagePersistence = getChatRoomMessagePersistence();

		ChatRoomMessage pendingMessage = messagePersistence.create(getCounterLocalService().increment(ChatRoomMessage.class.getName()));
		pendingMessage.setChatRoomId(room.getRoomId());
		pendingMessage.setMessageType(MessageType.AwatingApproval.getValue());
		pendingMessage.setTextType(MessageTextType.Talk.getValue());
		pendingMessage.setMessageStatus(MessageStatus.Approved.getValue());
		pendingMessage.setMessagePublic(false);
		pendingMessage.setAdminMessage(false);
		pendingMessage.setMessageTS(message.getMessageTS());
		pendingMessage.setMessageText("Sua mensagem está aguardando aprovação do moderador");

		pendingMessage.setParentMessageId(message.getChatMessageId());
		pendingMessage.setSenderId(message.getSenderId());
		pendingMessage.setSenderName(sender.getUserName());
		pendingMessage.setSenderType(sender.getUserType());

		pendingMessage.setRecipientUserId(0);
		pendingMessage.setRecipientUserName("");
		updateChatRoomMessage(pendingMessage, false);
	}

	/**
	 * Aprova uma mensagem
	 * 
	 * @param message
	 * @param timestamp
	 * @param approved
	 * @throws SystemException
	 */
	@Override
	public void approveMessage(ChatRoomMessage message, Date timestamp, boolean approved) throws SystemException {
		if (message.getMessageStatus() != MessageStatus.Pending.getValue())
			return;

		ChatRoomMessagePersistence messagePersistence = getChatRoomMessagePersistence();
		ChatRoomMessage reply = messagePersistence.create(getCounterLocalService().increment(ChatRoomMessage.class.getName()));
		reply.setChatRoomId(message.getChatRoomId());
		reply.setMessageTS(timestamp);
		reply.setParentMessageId(message.getChatMessageId());
		reply.setAdminMessage(message.getAdminMessage());
		reply.setMessagePublic(message.getMessagePublic());
		reply.setTextType(message.getTextType());

		if (approved) {
			reply.setMessageType(MessageType.Approved.getValue());
			reply.setMessageStatus(MessageStatus.Approved.getValue());
			message.setMessageStatus(MessageStatus.Moderated.getValue());
		} else {
			reply.setMessageType(MessageType.Rejected.getValue());
			reply.setMessageStatus(MessageStatus.Rejected.getValue());
			message.setMessageStatus(MessageStatus.Moderated.getValue());
		}

		reply.setSenderId(message.getSenderId());
		reply.setSenderName(message.getSenderName());
		reply.setSenderType(message.getSenderType());
		reply.setSenderEmail(message.getSenderEmail());
		reply.setSenderUF(message.getSenderUF());
		reply.setRecipientUserId(message.getRecipientUserId());
		reply.setRecipientUserName(message.getRecipientUserName());
		reply.setMessageText(message.getMessageText());

		getChatRoomMessagePersistence().update(reply, false);
		getChatRoomMessagePersistence().update(message, true);
	}

	/**
	 * Obtém mensagens desde um determinado momento
	 * 
	 * @param room
	 *            Sala de bate-papo
	 * 
	 * @param user
	 *            Usuário para obter as mensagens. Se for null, retorna apenas
	 *            as mensagens públicas
	 * @throws SystemException
	 */
	@Override
	public final ChatRoomMessage[] getMessagesForUserSince(ChatRoom room, ChatRoomUser user, Date since) throws SystemException {

		long userId = (user == null) ? -1l : user.getChatUserId();
		boolean moderator = (user == null) ? false : user.getUserType() != UserType.Standard.getValue();

		ChatRoomMessage[] result;
		DynamicQuery q;
		if (moderator) {
			// Moderador - Todas as mensagens, exceto as não públicas
			q = DynamicQueryFactoryUtil
			        .forClass(ChatRoomMessage.class)
			        .add(PropertyFactoryUtil.forName("chatRoomId").eq(room.getRoomId()))
			        .add(PropertyFactoryUtil.forName("messageTS").gt(since))
			        .add(PropertyFactoryUtil.forName("messageStatus").ne(MessageStatus.Moderated.getValue()))
			        .add(RestrictionsFactoryUtil.or(
			                PropertyFactoryUtil.forName("messagePublic").eq(true),
			                RestrictionsFactoryUtil.and(
			                        PropertyFactoryUtil.forName("messagePublic").eq(false),
			                        RestrictionsFactoryUtil.or(PropertyFactoryUtil.forName("senderId").eq(userId),
			                                PropertyFactoryUtil.forName("recipientUserId").eq(userId)))));
		} else {
			// Status == Rejeitada && Tipo == Rejeitada && sender == userId
			q = DynamicQueryFactoryUtil
			        .forClass(ChatRoomMessage.class)
			        .add(PropertyFactoryUtil.forName("chatRoomId").eq(room.getRoomId()))
			        .add(PropertyFactoryUtil.forName("messageStatus").eq(MessageStatus.Approved.getValue()))
			        .add(PropertyFactoryUtil.forName("adminMessage").eq(false))
			        .add(PropertyFactoryUtil.forName("messageTS").gt(since))
			        .add(RestrictionsFactoryUtil.or(
			                PropertyFactoryUtil.forName("messagePublic").eq(true),
			                RestrictionsFactoryUtil.and(
			                        PropertyFactoryUtil.forName("messagePublic").eq(false),
			                        RestrictionsFactoryUtil.or(PropertyFactoryUtil.forName("senderId").eq(userId),
			                                PropertyFactoryUtil.forName("recipientUserId").eq(userId)))));
		}

		List<?> lr = getChatRoomMessageLocalService().dynamicQuery(q);
		result = new ChatRoomMessage[lr.size()];
		return lr.toArray(result);
	}
	
	@Override
	public final ChatRoomMessage[] getMessagesForUserUntil(ChatRoom room, ChatRoomUser user, Date until) throws SystemException {

		long userId = (user == null) ? -1l : user.getChatUserId();
		boolean moderator = (user == null) ? false : user.getUserType() != UserType.Standard.getValue();
		
		Calendar calendarUntil = Calendar.getInstance();
		calendarUntil.setTime(until);
		calendarUntil.set(Calendar.HOUR_OF_DAY, 0);
		calendarUntil.set(Calendar.MINUTE, 00);
		calendarUntil.set(Calendar.SECOND, 00);
		calendarUntil.set(Calendar.MILLISECOND, 00);
		Date untilWithZeroHourDate = new Date(calendarUntil.getTimeInMillis());
		
		ChatRoomMessage[] result;
		DynamicQuery q;
		if (moderator) {
			// Moderador - Todas as mensagens, exceto as não públicas
			q = DynamicQueryFactoryUtil
			        .forClass(ChatRoomMessage.class)
			        .add(PropertyFactoryUtil.forName("chatRoomId").eq(room.getRoomId()))
			        .add(PropertyFactoryUtil.forName("messageTS").ge(untilWithZeroHourDate))
			        .add(PropertyFactoryUtil.forName("messageTS").le(until))
			        .add(PropertyFactoryUtil.forName("messageStatus").ne(MessageStatus.Moderated.getValue()))
			        .add(RestrictionsFactoryUtil.or(
			                PropertyFactoryUtil.forName("messagePublic").eq(true),
			                RestrictionsFactoryUtil.and(
			                        PropertyFactoryUtil.forName("messagePublic").eq(false),
			                        RestrictionsFactoryUtil.or(PropertyFactoryUtil.forName("senderId").eq(userId),
			                                PropertyFactoryUtil.forName("recipientUserId").eq(userId)))));
		} else {
			// Status == Rejeitada && Tipo == Rejeitada && sender == userId
			q = DynamicQueryFactoryUtil
			        .forClass(ChatRoomMessage.class)
			        .add(PropertyFactoryUtil.forName("chatRoomId").eq(room.getRoomId()))
			        .add(PropertyFactoryUtil.forName("messageStatus").eq(MessageStatus.Approved.getValue()))
			        .add(PropertyFactoryUtil.forName("adminMessage").eq(false))
			        .add(PropertyFactoryUtil.forName("messageTS").ge(untilWithZeroHourDate))
			        .add(PropertyFactoryUtil.forName("messageTS").le(until))
			        .add(RestrictionsFactoryUtil.or(
			                PropertyFactoryUtil.forName("messagePublic").eq(true),
			                RestrictionsFactoryUtil.and(
			                        PropertyFactoryUtil.forName("messagePublic").eq(false),
			                        RestrictionsFactoryUtil.or(PropertyFactoryUtil.forName("senderId").eq(userId),
			                                PropertyFactoryUtil.forName("recipientUserId").eq(userId)))));
		}

		List<?> lr = getChatRoomMessageLocalService().dynamicQuery(q);
		result = new ChatRoomMessage[lr.size()];
		return lr.toArray(result);
	}

}
