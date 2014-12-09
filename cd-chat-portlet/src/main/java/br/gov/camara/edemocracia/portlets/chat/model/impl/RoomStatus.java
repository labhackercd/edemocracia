package br.gov.camara.edemocracia.portlets.chat.model.impl;

public enum RoomStatus {
	Closed(0, "room-status-closed"), Opened(1, "room-status-opened"), Exported(2, "room-status-exported");

	private int value;
	private String msg;

	private RoomStatus(int value, String msg) {
		this.value = value;
		this.msg = msg;
	}

	public static RoomStatus withValue(int value) {
		RoomStatus[] statuses = RoomStatus.values();
		RoomStatus result = Closed;
		for (RoomStatus status : statuses) {
			if (status.getValue() == value) {
				result = status;
			}
		}
		return result;
	}

	public int getValue() {
		return value;
	}

	public String getMsg() {
		return msg;
	}
}
