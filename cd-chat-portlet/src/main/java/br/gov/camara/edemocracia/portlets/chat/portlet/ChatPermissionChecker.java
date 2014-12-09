package br.gov.camara.edemocracia.portlets.chat.portlet;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class ChatPermissionChecker {

	private final boolean canJoin;
	private final boolean canSpy;
	private final boolean open;
	private final boolean canModerate;

	private static final Log LOG = LogFactoryUtil.getLog(ChatPermissionChecker.class);

	public ChatPermissionChecker(ChatRoom room) throws PortalException, SystemException {
		canSpy = canSpy(room);
		canModerate = canModerate(room);
		canJoin = canJoin(room);
		open = room.isOpen();
	}

	public boolean isCanJoin() {
		return canJoin;
	}

	public boolean isCanSpy() {
		return canSpy;
	}

	public boolean isOpen() {
		return open;
	}

	public boolean isCanModerate() {
		return canModerate;
	}

	private boolean canSpy(ChatRoom room) {
		try {
			return ChatRoomServiceUtil.canSpy(room.getRoomId());
		} catch (SystemException e) {
			LOG.error("Erro verificando Perfil do usuario", e);
		} catch (PortalException e) {
			LOG.error("Erro verificando Perfil do usuario", e);
		}
		return false;
	}

	private boolean canModerate(ChatRoom chatRoom) {
		try {
			return ChatRoomServiceUtil.canModerate(chatRoom.getRoomId());
		} catch (SystemException e) {
			LOG.error("Erro verificando Perfil do usuario", e);
		} catch (PortalException e) {
			LOG.error("Erro verificando Perfil do usuario", e);
		}
		return false;
	}

	private boolean canJoin(ChatRoom chatRoom) {
		try {
			return ChatRoomServiceUtil.canJoin(chatRoom.getRoomId());
		} catch (SystemException e) {
			LOG.error("Erro verificando Perfil do usuario", e);
		} catch (PortalException e) {
			LOG.error("Erro verificando Perfil do usuario", e);
		}
		return false;
	}
}
