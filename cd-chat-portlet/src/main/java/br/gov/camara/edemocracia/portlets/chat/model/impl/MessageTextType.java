package br.gov.camara.edemocracia.portlets.chat.model.impl;

public enum MessageTextType {

	Talk(0, "fala", "para"), Ask(1, "pergunta", "para"), Answer(2, "responde", "para"), Agree(3, "concorda", "com"), Disagree(4, "discorda", "de");

	private int value;
	private String verb;
	private String preposition;

	private MessageTextType(int value, String verb, String preposition) {
		this.value = value;
		this.verb = verb;
		this.preposition = preposition;
	}

	public int getValue() {
		return value;
	}

	public String getVerb() {
		return verb;
	}

	public String getPreposition() {
		return preposition;
	}

	public static MessageTextType withValue(int value) {
		MessageTextType[] textTypes = MessageTextType.values();
		MessageTextType result = Talk;
		for (MessageTextType textType : textTypes) {
			if (textType.getValue() == value) {
				result = textType;
			}
		}
		return result;
	}

}
