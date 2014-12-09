package br.gov.camara.edemocracia.portlets.chat.portlet;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.UserActivityId;

public class ChatPortletSessionUtil {

	private static final Log LOG = LogFactoryUtil.getLog(ChatPortletSessionUtil.class);
	
	public static void removeUserFromRoomAndSession(PortletRequest request, long chatRoomId) {
		
		UserActivityId userActivityId = removeUserFromSession(request, chatRoomId);
		
		if (userActivityId != null) {
			try {
				ChatRoomServiceUtil.removeChatUser(chatRoomId, userActivityId, new Date());
			} catch(NoSuchChatRoomUserException ignore) {
				//Ignorar - Caso onde o usuário se logou em dois browsers diferentes
			} catch (Exception ignore) {
				LOG.warn("Erro ao remover usuário ", ignore);
			}
		}
	}
	
	/**
	 * Recupera o {@link UserActivityId} da sessão e confirma se o dono deste id ainda está na sala,
	 * seja espiando ou como um usuário participante do bate-papo. Se o id estiver na sessão e não estiver 
	 * na sala, limpa da sessão o id 
	 * @param request
	 * @param chatRoomId
	 * @return {@link UserActivityId} validado, ou null, caso tenha sido encontrada alguma inconsistência (
	 * que pode ocorrer após usuários serem removidos do bate-papo por inatividade)
	 */
	public static UserActivityId getValidatedUserActivityIdInRoom(PortletRequest request, Long chatRoomId) {
		if (chatRoomId == null) {
			return null;
		}
		UserActivityId idFromSession = getUserActivityIdInRoom(request, chatRoomId);
		if (idFromSession != null && !ChatRoomLocalServiceUtil.isUserInRoom(chatRoomId, idFromSession)) {
			removeUserFromSession(request, chatRoomId);
			return null;
		}
		return idFromSession;
	}

	@SuppressWarnings("unchecked")
	private static UserActivityId removeUserFromSession(PortletRequest request, Long chatRoomId) {
		PortletSession session = request.getPortletSession();
        Map<Long, UserActivityId> roomsMap = (Map<Long, UserActivityId>) session.getAttribute(ChatPortletConstants.LOGGED_ROOMS_ATTRIBUTE, PortletSession.APPLICATION_SCOPE);
		if (roomsMap != null) {
			return roomsMap.remove(chatRoomId);
		}
		return null;
    }

	@SuppressWarnings("unchecked")
	public static UserActivityId getUserActivityIdInRoom(PortletRequest request, Long chatRoomId) {
		PortletSession session = request.getPortletSession();

		Map<Long, UserActivityId> roomsMap = (Map<Long, UserActivityId>) session.getAttribute(ChatPortletConstants.LOGGED_ROOMS_ATTRIBUTE, PortletSession.APPLICATION_SCOPE);
		if (roomsMap == null) {
			return null;
		}
		return roomsMap.get(chatRoomId);
	}

	@SuppressWarnings("unchecked")
	public static void addUserToSession(PortletRequest request, long roomId, UserActivityId userActivityId) {
		PortletSession session = request.getPortletSession();
		Map<Long, UserActivityId> roomsMap = (Map<Long, UserActivityId>) session.getAttribute(ChatPortletConstants.LOGGED_ROOMS_ATTRIBUTE, PortletSession.APPLICATION_SCOPE);
		if (roomsMap == null) {
			roomsMap = new HashMap<Long, UserActivityId>();
			session.setAttribute(ChatPortletConstants.LOGGED_ROOMS_ATTRIBUTE, roomsMap, PortletSession.APPLICATION_SCOPE);
		}
		roomsMap.put(roomId, userActivityId);
		
	}
}
