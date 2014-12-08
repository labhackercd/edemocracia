/**
 * 
 */
package br.gov.camara.edemocracia.portlets.wikilegis.ui.model;

import java.io.Serializable;
import java.text.DateFormat;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;

/**
 * Dados para visualização de comentário
 * 
 * @author robson
 * 
 */
public class ComentarioDisplay implements Serializable {

	private final long messageId;
	private final String anchor;
	private final String body;
	private final long senderId;
	private final String senderName;
	private final String when;
	private final String inReplyToName;
	private final String parentMessageName;

	public ComentarioDisplay(MBMessage message, DateFormat df) throws SystemException {
		this.messageId = message.getMessageId();
		this.anchor = "hmhp_message_" + message.getMessageId();
		this.body = message.getBody(true);
		this.senderId = message.getUserId();
		String senderName = message.getUserName();
		if (this.senderId > 0l) {
			try {
				senderName = UserLocalServiceUtil.getUser(senderId).getFullName();
			} catch (PortalException e) {
			}
		}
		this.senderName = senderName;
		this.when = df.format(message.getModifiedDate());
		
		String inReplyToName = null;
		String parentMessageName = null;
		if (message.getParentMessageId() > 0l) {
			MBMessage parent;
			try {
				parent = MBMessageLocalServiceUtil.getMessage(message.getParentMessageId());
				if (!parent.isRoot()) {
					parentMessageName = "hmhp_message_" + parent.getMessageId();
					inReplyToName = parent.getUserName();
					if (parent.getUserId() > 0) {
						try {
							inReplyToName = UserLocalServiceUtil.getUser(parent.getUserId()).getFullName();
						} catch (PortalException e) {
						}
					}
				}
			} catch (PortalException e) {
			}
		}
		this.inReplyToName = inReplyToName;
		this.parentMessageName = parentMessageName;
	}

	/**
	 * @return the messageId
	 */
	public long getMessageId() {
		return messageId;
	}

	public String getAnchor() {
		return anchor;
	}

	public String getBody() {
		return body;
	}

	public long getSenderId() {
		return senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getWhen() {
		return when;
	}

	public String getInReplyToName() {
		return inReplyToName;
	}

	public String getParentMessageName() {
		return parentMessageName;
	}

}
