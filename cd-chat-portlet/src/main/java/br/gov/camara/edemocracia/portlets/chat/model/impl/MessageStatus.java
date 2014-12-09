package br.gov.camara.edemocracia.portlets.chat.model.impl;

public enum MessageStatus {
	Pending(0), Approved(1), Rejected(-1), Moderated(2);

	private int value;

	private MessageStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static MessageStatus withValue(int value) {
		MessageStatus[] statuses = MessageStatus.values();
		MessageStatus result = Pending;
		for (MessageStatus status : statuses) {
			if (status.getValue() == value) {
				result = status;
			}
		}
		return result;
	}

}
