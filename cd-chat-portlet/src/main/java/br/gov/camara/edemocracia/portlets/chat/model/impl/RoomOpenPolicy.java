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
