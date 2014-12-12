/**
 * Copyright (c) 2009-2014 Câmara dos Deputados. Todos os direitos reservados.
 *
 * e-Democracia é um software livre; você pode redistribuí-lo e/ou modificá-lo dentro
 * dos termos da Licença Pública Geral Menor GNU como publicada pela Fundação do 
 * Software Livre (FSF); na versão 2.1 da Licença, ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser  útil, mas SEM NENHUMA GARANTIA;
 * sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR.
 * Veja a Licença Pública Geral Menor GNU para maiores detalhes. 
 */
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
