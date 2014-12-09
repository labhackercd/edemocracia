package br.gov.camara.edemocracia.portlets.chat.model.impl;

public enum RoomOpenPolicy {
	Always(0, "room-policy-always"), Manual(1, "room-policy-manual"), Scheduled(2, "room-policy-scheduled");

	private int value;
	private String msg;

	private RoomOpenPolicy(int value, String msg) {
		this.value = value;
		this.msg = msg;
	}

	public static RoomOpenPolicy withValue(int value) {
		RoomOpenPolicy[] policies = RoomOpenPolicy.values();
		RoomOpenPolicy result = Always;
		for (RoomOpenPolicy policy : policies) {
			if (policy.getValue() == value) {
				result = policy;
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
