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
