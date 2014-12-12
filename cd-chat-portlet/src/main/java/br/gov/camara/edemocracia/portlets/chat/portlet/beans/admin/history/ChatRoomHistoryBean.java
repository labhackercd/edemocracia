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
package br.gov.camara.edemocracia.portlets.chat.portlet.beans.admin.history;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.portlet.PortletConfig;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage;
import br.gov.camara.edemocracia.portlets.chat.model.impl.UserType;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Bean para escolha das mensagens que aparecerão no histórico
 * 
 * @author p_7339
 * 
 */
@ManagedBean(name = "historyExport")
@ViewScoped
public class ChatRoomHistoryBean implements Serializable {

	private static final long serialVersionUID = -2396774052709497689L;

	private static final Log _log = LogFactoryUtil.getLog(ChatRoomHistoryBean.class);

	private ChatRoom room;
	private ChatRoomMessage[] messages;
	private String exportedMessages;
	private TimeZone tz;

	/**
	 * Recupera a sala pelo parâmetro
	 * 
	 * @throws IOException
	 */
	@PostConstruct
	public void init() {

		LiferayFacesContext facesContext = LiferayFacesContext.getInstance();
		tz = facesContext.getThemeDisplay().getTimeZone();
		Locale locale = facesContext.getLocale();
		PortletConfig portletConfig = facesContext.getPortletConfig();

		// ////////////////////////////////////////////////////////////////////////////////
		// Carrega a sala atual
		room = null;
		exportedMessages = "";
		messages = new ChatRoomMessage[0];

		String param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (param != null) {
			try {
				long roomId = Long.parseLong(param);
				room = ChatRoomServiceUtil.getRoom(roomId);
			} catch (NumberFormatException e) {
				// Ignore
			} catch (PortalException e) {
				// Ignore
			} catch (SystemException e) {
				throw new RuntimeException(e);
			}
		}

		if (room == null) { // Sala não encontrada
			facesContext.addGlobalErrorMessage(LanguageUtil.get(portletConfig, locale, "room-cant-find"));
			try {
				facesContext.getExternalContext().redirect("/xhtml/admin/index.xhtml");
			} catch (IOException e) {

			}
			return;
		}

		if (room.isOpen()) { // Sala aberta?
			facesContext.addGlobalErrorMessage(LanguageUtil.get(portletConfig, locale, "room-cant-export-opened-room"));
			try {
				facesContext.getExternalContext().redirect("/xhtml/admin/index.xhtml");
			} catch (IOException e) {

			}
			room = null;
			return;
		}

		// ////////////////////////////////////////////////////////////////////////////////
		// Carrega as mensagens que já foram exportadas
		StringBuilder sb = new StringBuilder();
		try {
			messages = ChatRoomServiceUtil.getMessagesForExport(room.getRoomId());
		} catch (PortalException e) {
			messages = new ChatRoomMessage[0];
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
		for (ChatRoomMessage message : messages) {
			if (sb.length() != 0)
				sb.append(' ');
			if (message.isExportedRemoved())
				sb.append('-');
			sb.append(message.getChatMessageId());
		}
		exportedMessages = sb.toString();
	}

	/**
	 * Obtém o CSS para uma mensagem
	 * 
	 * @param message
	 * @return
	 */
	public String getCssClassForMessage(ChatRoomMessage message) {
		String css = "";
		if (message.getSenderType() == UserType.Moderator.getValue())
			css = "cdchat_moderator";
		else if (message.getSenderType() == UserType.SpecialGuest.getValue())
			css = "cdchat_special_guest";

		if (message.isExportedRemoved())
			css += " cdchat_removed_message";
		else
			css += " cdchat_exported_message";

		return css;
	}

	/**
	 * @return the exportedMessages
	 */
	public String getExportedMessages() {
		return exportedMessages;
	}

	/**
	 * @param exportedMessages
	 *            the exportedMessages to set
	 */
	public void setExportedMessages(String exportedMessages) {
		this.exportedMessages = exportedMessages;
	}

	/**
	 * Obtém o nome da sala
	 * 
	 * @return
	 */
	public String getRoomName() {
		if (room == null)
			return "";
		else
			return room.getRoomName();
	}

	/**
	 * 
	 * @param message
	 * @return
	 */
	public String getImageStatusForMessage(ChatRoomMessage message) {
		String prefix = LiferayFacesContext.getInstance().getExternalContext().getRequestContextPath();
		if (!message.isExportedRemoved()) {
			return prefix + "/html/images/reject.png";
		} else {
			return prefix + "/html/images/approve.png";
		}
	}

	/**
	 * Grava o novo histórico
	 * 
	 * @return
	 */
	public String save() {

		String[] msgsIdsString = exportedMessages.split(" ");
		int msgsLength = msgsIdsString.length;
		List<Long> msgsIds = new ArrayList<Long>(msgsLength);

		for (int i = 0; i < msgsLength; i++) {
			try {
				long item = Long.parseLong(msgsIdsString[i]);
				msgsIds.add(item);
			} catch (NumberFormatException nfe) {
				// skip
			}
		}

		Flash flash = LiferayFacesContext.getInstance().getExternalContext().getFlash();
		flash.setKeepMessages(true);
		try {
			ChatRoomServiceUtil.saveExportedMessages(room.getRoomId(), msgsIds.toArray(new Long[msgsIds.size()]));
			LiferayFacesContext.getInstance().addGlobalSuccessInfoMessage();
		} catch (PortalException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage("Falha ao gravar histórico");
			_log.error(e);
		} catch (SystemException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage("Falha ao gravar histórico");
			_log.error(e);
		}

		return "saved";
	}

	/**
	 * @return the messages
	 */
	public ChatRoomMessage[] getMessages() {
		return messages;
	}

	/**
	 * @return the room
	 */
	public ChatRoom getRoom() {
		return room;
	}

	/**
	 * @return the tz
	 */
	public TimeZone getTz() {
		return tz;
	}
}
