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

import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;
import static org.apache.commons.lang.StringEscapeUtils.escapeXml;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * The model implementation for the ChatRoomMessage service. Represents a row in
 * the &quot;CDChat_ChatRoomMessage&quot; database table, with each column
 * mapped to a property of this class.
 * 
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the
 * {@link br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this class directly. All methods that expect a chat room
 * message model instance should use the {@link ChatRoomMessage} interface
 * instead.
 * </p>
 */
public class ChatRoomMessageImpl extends ChatRoomMessageBaseImpl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChatRoomMessageImpl() {
	}

	public JSONObject getJSON() {

		JSONObject obj = JSONFactoryUtil.createJSONObject();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		obj.put("id", getChatMessageId());
		obj.put("parent", getParentMessageId());
		obj.put("type", getMessageType());
		obj.put("ts", df.format(getMessageTS()));
		obj.put("status", getMessageStatus());
		obj.put("pub", getMessagePublic());
		obj.put("admin", getAdminMessage());
		obj.put("sender", escapeHtml(getSenderName()));
		obj.put("senderId", getSenderId());
		obj.put("senderType", getSenderType());
		obj.put("recipientUser", escapeHtml(getRecipientUserName()));
		obj.put("text", escapeHtml(getMessageText()));
		obj.put("textType", getTextType());

		return obj;
	}

	public String getFormattedText(TimeZone tz) {
		StringBuilder sb = new StringBuilder();
		sb.append("<em>(");
		sb.append(getMessageTimestamp(tz));
		sb.append(")</em> - ");
		MessageType messageType = MessageType.withValue(getMessageType());
		sb.append(messageType.formattedMessage(this));
		return sb.toString();
	}

	private String getMessageTimestamp(TimeZone tz) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		df.setTimeZone(tz);
		return df.format(getMessageTS());
	}

	public String getMessageXMLForExport(TimeZone tz) {
		StringBuilder sb = new StringBuilder("<message>");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		sb.append("<timestamp>");
		sb.append(df.format(getMessageTS()));
		sb.append("</timestamp>");
		sb.append("<sender");
		if (getSenderType() != UserType.Standard.getValue()) {
			sb.append(" type=\"");
			sb.append(UserType.withValue(getSenderType()).getXMLAttribute());
			sb.append("\" ");
		}
		sb.append(">");
		sb.append(escapeXml(getSenderName()));
		sb.append("</sender>");
		if (getRecipientUserId() != 0) {
			sb.append("<recipient>");
			sb.append(escapeXml(getRecipientUserName()));
			sb.append("</recipient>");
		}
		sb.append("<text>");
		sb.append(escapeXml(getMessageText()));
		sb.append("</text>");
		sb.append("</message>");
		return sb.toString();
	}

	public String getMessageHTMLForExport(TimeZone tz) {
		StringBuilder sb = new StringBuilder("<li>");
		// DateFormat df =
		return sb.toString();
	}

}
