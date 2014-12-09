package br.gov.camara.edemocracia.portlets.chat.portlet.exporter;

import java.util.TimeZone;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage;
import br.gov.camara.edemocracia.portlets.chat.model.impl.UserType;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

class HTMLChatRoomExporter implements ChatRoomExporter {

	private ChatRoomService service;

	public HTMLChatRoomExporter(ChatRoomService service) {
		this.service = service;
	}

	@Override
	public String exportChatRoom(long chatRoomId, TimeZone tz) throws PortalException, SystemException {
		StringBuilder sb = new StringBuilder();

		ChatRoomMessage[] msgs = service.getMessagesForExport(chatRoomId);
		ChatRoom room = service.getRoom(chatRoomId);
		sb.append("<html>\n<head>\n<title>");
		sb.append("Exporta&ccedil;&atilde;o - ");
		sb.append(room.getRoomName());
		sb.append("</title>\n</head>\n<body>\n<h1>");
		sb.append(room.getRoomName());
		sb.append("</h1>\n<p>");
		sb.append(room.getDescription());
		sb.append("</p>\n<ul>\n");
		for (ChatRoomMessage msg : msgs) {
			if (!msg.getExportedRemoved()) {
				sb.append("<li");
				if (msg.getSenderType() == UserType.SpecialGuest.getValue()) {
					sb.append(" class=\"cdchat_special_guest\" ");
				} else if (msg.getSenderType() == UserType.Moderator.getValue()) {
					sb.append(" class=\"cdchat_moderator\" ");
				}
				sb.append(">");
				sb.append(msg.getFormattedText(tz));
				sb.append("</li>\n");
			}
		}
		sb.append("</ul>\n</body>\n</html>");

		return sb.toString();
	}

	@Override
	public String getFilename(long chatRoomId) throws PortalException, SystemException {
		ChatRoom room = service.getRoom(chatRoomId);
		return "export-" + room.getNameAsFilename() + ".html";
	}

}
