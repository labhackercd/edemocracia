package br.gov.camara.edemocracia.portlets.chat.portlet.exporter;

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

public class ChatRoomExporterFactory {

	public static ChatRoomExporter create(String format) {
		if (format.equalsIgnoreCase("xml")) {
			return new XMLChatRoomExporter(ChatRoomServiceUtil.getService());
		} else if (format.equalsIgnoreCase("html")) {
			return new HTMLChatRoomExporter(ChatRoomServiceUtil.getService());
		} else {
			throw new IllegalArgumentException("Formato não reconhecido");
		}

	}

}
