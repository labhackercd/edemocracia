package br.gov.camara.edemocracia.portlets.chat.model.impl;

import java.util.Date;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;

/**
 * The model implementation for the ChatRoom service. Represents a row in the
 * &quot;CDChat_ChatRoom&quot; database table, with each column mapped to a
 * property of this class.
 * 
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link br.gov.camara.edemocracia.portlets.chat.model.ChatRoom}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this class directly. All methods that expect a chat room
 * model instance should use the {@link ChatRoom} interface instead.
 * </p>
 */
public class ChatRoomImpl extends ChatRoomBaseImpl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChatRoomImpl() {
	}

	@Override
	public String getNameAsFilename() {
		return getRoomName().toLowerCase().replaceAll(" ", "_");
	}

	/**
	 * Verifica se a sala está aberta
	 * 
	 * @param when
	 * @return
	 */
	@Override
	public boolean isOpen(Date when) {
		if (getOpenPolicy() == RoomOpenPolicy.Always.getValue()) {
			return true;
		}
		if (getOpenPolicy() == RoomOpenPolicy.Manual.getValue()) {
			return getStatus() == RoomStatus.Opened.getValue();
		}
		if (getOpenPolicy() == RoomOpenPolicy.Scheduled.getValue()) {
			Date from = getOpenFrom() != null ? getOpenFrom() : when;
			Date until = getOpenUntil() != null ? getOpenUntil() : when;

			return (from.before(when) || from.equals(when)) && (when.before(until) || when.equals(until));
		}
		return false;
	}
	
	/**
	 * Altera política de abertura atualizando outras informações se for necessário
	 * @param newOpenPolicy
	 * @param openFrom
	 * @param openUntil
	 */
	public void changeOpenPolicy(RoomOpenPolicy newOpenPolicy, Date openFrom, Date openUntil) {
		if (newOpenPolicy == RoomOpenPolicy.Scheduled) {
			setOpenFrom(openFrom);
			setOpenUntil(openUntil);
		} else if (newOpenPolicy == RoomOpenPolicy.Always) {
			setStatus(RoomStatus.Opened.getValue());
			setOpenFrom(null);
			setOpenUntil(null);
		} else if (newOpenPolicy == RoomOpenPolicy.Manual && getStatus() == RoomStatus.Opened.getValue() && getOpenFrom() == null) {
			setOpenFrom(new Date());
		}
		setOpenPolicy(newOpenPolicy.getValue());
	}

	/**
	 * Verifica se a sala está aberta no momento atual
	 * 
	 * @return
	 */
	@Override
	public boolean isOpen() {
		return isOpen(new Date());
	}
	
}
