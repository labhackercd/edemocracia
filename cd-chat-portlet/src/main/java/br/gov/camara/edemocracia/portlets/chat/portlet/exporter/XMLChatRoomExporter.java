package br.gov.camara.edemocracia.portlets.chat.portlet.exporter;

import static org.apache.commons.lang.StringEscapeUtils.escapeXml;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage;
import br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

class XMLChatRoomExporter implements ChatRoomExporter {

	private ChatRoomService service;

	public XMLChatRoomExporter(ChatRoomService service) {
		this.service = service;
	}

	@Override
	public String exportChatRoom(long chatRoomId, TimeZone tz) throws PortalException, SystemException {
		StringBuilder sb = new StringBuilder();

		ChatRoom chatRoom = service.getRoom(chatRoomId);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		df.setTimeZone(tz);
		int alwaysOpenPolicy = RoomOpenPolicy.Always.getValue();
		ChatRoomMessage[] msgs = service.getMessagesForExport(chatRoomId);

		sb.append("<chat>\n");
		sb.append("<title>");
		sb.append(escapeXml(chatRoom.getRoomName()));
		sb.append("</title>\n");
		sb.append("<description>");
		sb.append(escapeXml(chatRoom.getDescription()));
		sb.append("</description>\n");
		sb.append("<totalusers>");
		sb.append(chatRoom.getMaxSimultaneousUsers());
		sb.append("</totalusers>\n");
		sb.append("<totalusersspying>");
		sb.append(chatRoom.getMaxSimultaneousUsersSpying());
		sb.append("</totalusersspying>\n");
		sb.append("<capacity>");
		sb.append(chatRoom.getCapacity());
		sb.append("</capacity>\n");
		if (chatRoom.getOpenPolicy() != alwaysOpenPolicy) {
			// Adicionado para tratar casos de inconsistências de um bug já resolvido 
			if (chatRoom.getOpenFrom() != null) {
				sb.append("<dateopen>");
				sb.append(df.format(chatRoom.getOpenFrom()));
				sb.append("</dateopen>\n");
			}
			
			sb.append("<dateuntil>");
			sb.append(df.format(chatRoom.getOpenUntil()));
			sb.append("</dateuntil>\n");
		}
		sb.append("<messages>\n");
		for (ChatRoomMessage msg : msgs) {
			if (!msg.getExportedRemoved()) {
				sb.append(msg.getMessageXMLForExport(tz) + "\n");
			}
		}
		sb.append("</messages>\n");
		sb.append("</chat>");
		return sb.toString();
	}

	@Override
	public String getFilename(long chatRoomId) throws PortalException, SystemException {
		ChatRoom room = service.getRoom(chatRoomId);
		return "export-" + room.getNameAsFilename() + ".xml";
	}

}
