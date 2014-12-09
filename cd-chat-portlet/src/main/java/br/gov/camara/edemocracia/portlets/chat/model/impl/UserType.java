package br.gov.camara.edemocracia.portlets.chat.model.impl;

public enum UserType {
	Standard(0, "standard"), Moderator(1, "moderator"), SpecialGuest(2, "special-guest");

	private int value;
	private String xmlAttribute;

	private UserType(int value, String xmlAttribute) {
		this.value = value;
		this.xmlAttribute = xmlAttribute;
	}

	public static UserType withValue(int value) {
		UserType[] types = UserType.values();
		UserType result = Standard;
		for (UserType type : types) {
			if (type.getValue() == value) {
				result = type;
			}
		}
		return result;
	}

	public int getValue() {
		return value;
	}

	public String getXMLAttribute() {
		return xmlAttribute;
	}

}
