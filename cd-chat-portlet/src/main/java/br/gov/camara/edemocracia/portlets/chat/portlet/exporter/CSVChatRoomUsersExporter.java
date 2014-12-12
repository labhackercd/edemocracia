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
package br.gov.camara.edemocracia.portlets.chat.portlet.exporter;

import java.util.List;

import br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean;

public class CSVChatRoomUsersExporter {

	private static StringBuilder sb;

	public CSVChatRoomUsersExporter() {

	}

	public static String export(List<ChatRoomUserBean> users) {

		sb = new StringBuilder();

		insertColumn("Nome");
		insertColumn("Email");
		insertColumn("UF");
		lineEnd();

		for (ChatRoomUserBean user : users) {

			insertColumn(user.getUserName());
			insertColumn(user.getUserEmail());
			insertColumn(user.getUserUF());
			lineEnd();
		}

		return sb.toString();
	}

	private static void insertColumn(String coluna) {
		sb.append("\"" + coluna + "\"").append(";");
	}

	private static void lineEnd() {
		sb.append("\n");
	}

}
