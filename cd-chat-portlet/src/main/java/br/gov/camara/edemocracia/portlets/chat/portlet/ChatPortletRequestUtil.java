package br.gov.camara.edemocracia.portlets.chat.portlet;

import java.net.MalformedURLException;
import java.net.URL;

import javax.portlet.PortletRequest;

import br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomUserLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.UserActivityId;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * @author P_7339
 * 
 */
public class ChatPortletRequestUtil {

	public static long getScopeGroupIdFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		return themeDisplay.getScopeGroupId();
	}

	public static User getUserFromRequest(PortletRequest request) {
		ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		return td.getUser();
	}

	public static ChatRoom getChatRoomFromRequest(PortletRequest req) throws PortalException, SystemException {
		long roomId = ParamUtil.get(req, ChatPortletConstants.ROOM_ID_PARAM, -1);
		if (roomId == -1)
			return null;

		try {
			ChatRoom room = ChatRoomServiceUtil.getRoom(roomId);
			if (room.getGroupId() != getScopeGroupIdFromRequest(req))
				return null;
			return room;
		} catch (NoSuchChatRoomException e) {
			return null;
		}
	}

	/**
	 * Obtém o usuário da sala atual
	 * Retorna null se não encontrar ou se o usuário atual estiver espiando
	 * 
	 * @param req
	 * @param chatRoomId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static ChatRoomUser getChatRoomUser(PortletRequest req, Long chatRoomId) throws PortalException, SystemException {

		ChatRoomUser chatRoomUser = null;
		
		UserActivityId userActivityId = ChatPortletSessionUtil.getUserActivityIdInRoom(req, chatRoomId);
		if (userActivityId != null && userActivityId.isPersistentUser()) {
			chatRoomUser = ChatRoomUserLocalServiceUtil.fetchChatRoomUser(userActivityId.getChatUserId());
		} 
		
		return chatRoomUser;
	}

	public static boolean isUrlToSameHost(PortletRequest request, String pageLink) {
		URL url;
		try {
			url = new URL(pageLink);
		} catch (MalformedURLException e) {
			return false;
		}
		String host = url.getHost();
		String serverName = request.getServerName();
		if (serverName.equalsIgnoreCase(host)) {
			return true;
		}
		return false;
	}
}
