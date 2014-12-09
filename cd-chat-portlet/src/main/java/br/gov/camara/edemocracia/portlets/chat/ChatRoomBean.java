package br.gov.camara.edemocracia.portlets.chat;

import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * Wrapper da ChatRoom
 * 
 * @author p_882148
 * 
 */
public class ChatRoomBean {

	private long roomId;
	private boolean canJoin;
	private boolean canSpy;
	private String roomName;
	private Date openUntil;
	private Date openFrom;
	private boolean open;
	private String status;

	public ChatRoomBean() {
	}

	public ChatRoomBean(long roomId, String roomName, boolean canJoin, boolean canSpy, Date openFrom, Date openUntil, boolean open, String status) {
		this.roomId = roomId;
		this.roomName = roomName;
		this.canJoin = canJoin;
		this.canSpy = canSpy;
		this.openFrom = openFrom;
		this.openUntil = openUntil;
		this.open = open;
		this.status = status;
	}
	
	public String getOpenFromInAddThisFormat(TimeZone tz) {
		return DateFormatUtils.format(openFrom, "dd-MM-yyyy HH:mm:ss" ,tz);
	}
	
	public String getOpenUntilInAddThisFormat(TimeZone tz) {
		return DateFormatUtils.format(openUntil, "dd-MM-yyyy HH:mm:ss" , tz);
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public boolean isCanJoin() {
		return canJoin;
	}

	public void setCanJoin(boolean canJoin) {
		this.canJoin = canJoin;
	}

	public boolean isCanSpy() {
		return canSpy;
	}

	public void setCanSpy(boolean canSpy) {
		this.canSpy = canSpy;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Date getOpenUntil() {
		return openUntil;
	}

	public void setOpenUntil(Date openUntil) {
		this.openUntil = openUntil;
	}

	public Date getOpenFrom() {
		return openFrom;
	}

	public void setOpenFrom(Date openFrom) {
		this.openFrom = openFrom;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (canJoin ? 1231 : 1237);
		result = prime * result + (canSpy ? 1231 : 1237);
		result = prime * result + ((openFrom == null) ? 0 : openFrom.hashCode());
		result = prime * result + ((openUntil == null) ? 0 : openUntil.hashCode());
		result = prime * result + (int) (roomId ^ (roomId >>> 32));
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatRoomBean other = (ChatRoomBean) obj;
		if (canJoin != other.canJoin)
			return false;
		if (canSpy != other.canSpy)
			return false;
		if (openFrom == null) {
			if (other.openFrom != null)
				return false;
		} else if (!openFrom.equals(other.openFrom))
			return false;
		if (openUntil == null) {
			if (other.openUntil != null)
				return false;
		} else if (!openUntil.equals(other.openUntil))
			return false;
		if (roomId != other.roomId)
			return false;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		return true;
	}

}
