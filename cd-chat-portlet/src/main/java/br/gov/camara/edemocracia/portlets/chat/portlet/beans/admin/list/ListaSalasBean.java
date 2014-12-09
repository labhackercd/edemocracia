package br.gov.camara.edemocracia.portlets.chat.portlet.beans.admin.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.gov.camara.edemocracia.portlets.chat.CantRemoveOpenedChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomStatus;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * Listagem das salas de bate-papo
 * 
 * @author p_7339
 * 
 */
@ManagedBean(name = "listaSalas")
@RequestScoped
public class ListaSalasBean {

	/**
	 * Lista as salas do site atual
	 * 
	 * @return
	 */
	public List<ChatRoom> getSalas() {
		try {
			ChatRoom[] rooms = ChatRoomServiceUtil.findAllInGroup(LiferayFacesContext.getInstance().getScopeGroupId());

			return Collections.unmodifiableList(Arrays.asList(rooms));
		} catch (SystemException e) {
			return Collections.emptyList();
		}
	}

	/**
	 * Remove a sala especificada
	 * 
	 * @param roomId
	 * @return
	 */
	public Object remove(long roomId) {
		try {
			ChatRoom room = ChatRoomServiceUtil.getRoom(roomId);
			if (room != null) {
				try {
					ChatRoomServiceUtil.deleteChatRoom(room.getRoomId());
					LiferayFacesContext.getInstance().addGlobalInfoMessage("room-delete-success");
				} catch (CantRemoveOpenedChatRoom e) {
					LiferayFacesContext.getInstance().addGlobalErrorMessage("room-cant-delete-open-room");
				}
			} else {
				LiferayFacesContext.getInstance().addGlobalErrorMessage("room-cant-find");
			}
		} catch (PortalException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage("room-cant-find");
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	/**
	 * Status da sala
	 * 
	 * @param roomStatusId
	 * @return
	 */
	public String getNomeStatus(int roomStatusId) {
		RoomStatus status = RoomStatus.withValue(roomStatusId);
		return status.getMsg();
	}

	/**
	 * Política de abertura da sala
	 * 
	 * @param openPolicyId
	 * @return
	 */
	public String getNomePoliticaAbertura(int openPolicyId) {
		RoomOpenPolicy policy = RoomOpenPolicy.withValue(openPolicyId);
		return policy.getMsg();
	}
}
