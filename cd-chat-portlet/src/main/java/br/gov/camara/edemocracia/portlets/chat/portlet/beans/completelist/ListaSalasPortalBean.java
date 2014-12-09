package br.gov.camara.edemocracia.portlets.chat.portlet.beans.completelist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.gov.camara.edemocracia.portlets.chat.ChatRoomBean;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * Listagem das salas de bate-papo de uma instancia do portal
 * 
 * 
 */
@ManagedBean(name = "listaSalasPortal")
@RequestScoped
public class ListaSalasPortalBean {

	public List<ChatRoomBean> getSalasAbertasEFechadasEntraveis() {
		try {
			ChatRoomBean[] rooms = ChatRoomServiceUtil.findOpenAndEnterableClosedRoomsInCompany(LiferayFacesContext.getInstance().getCompanyId());
			return Collections.unmodifiableList(Arrays.asList(rooms));
		} catch (SystemException e) {
			return Collections.emptyList();
		}
	}


	public List<ChatRoomBean> getSalasAgendadas() {
		try {
			ChatRoomBean[] rooms = ChatRoomServiceUtil.findScheduledRoomsInCompany(LiferayFacesContext.getInstance().getCompanyId());
			return Collections.unmodifiableList(Arrays.asList(rooms));
		} catch (SystemException e) {
			return Collections.emptyList();
		}
	}


	public List<ChatRoomBean> getSalasFechadasExportadas() {
		try {
			ChatRoomBean[] rooms = ChatRoomServiceUtil.findExportedRoomsInCompany(LiferayFacesContext.getInstance().getCompanyId());
			return Collections.unmodifiableList(Arrays.asList(rooms));
		} catch (SystemException e) {
			return Collections.emptyList();
		} 
	}

	public long getQuantiaParticipantesSala(int roomId){
		try {
	        return ChatRoomServiceUtil.getUsersCountInChatRoom(roomId);
        } catch (SystemException e) {
	       return 0L;
        }
	}
	
	public String getNomeComunidadeSala(long roomId){
		try {
	        return ChatRoomServiceUtil.getChatRoomCommunityName(roomId);
        } catch (SystemException e) {
	       return "";
        } catch (PortalException e) {
	        throw new RuntimeException(e);
        }
	}
	
}

