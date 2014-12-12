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
package br.gov.camara.edemocracia.portlets.chat.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChatRoomMessage}.
 * </p>
 *
 * @author    Ricardo Lima
 * @see       ChatRoomMessage
 * @generated
 */
public class ChatRoomMessageWrapper implements ChatRoomMessage,
    ModelWrapper<ChatRoomMessage> {
    private ChatRoomMessage _chatRoomMessage;

    public ChatRoomMessageWrapper(ChatRoomMessage chatRoomMessage) {
        _chatRoomMessage = chatRoomMessage;
    }

    public Class<?> getModelClass() {
        return ChatRoomMessage.class;
    }

    public String getModelClassName() {
        return ChatRoomMessage.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("chatMessageId", getChatMessageId());
        attributes.put("parentMessageId", getParentMessageId());
        attributes.put("chatRoomId", getChatRoomId());
        attributes.put("exportedPosition", getExportedPosition());
        attributes.put("exportedRemoved", getExportedRemoved());
        attributes.put("messageType", getMessageType());
        attributes.put("messageStatus", getMessageStatus());
        attributes.put("senderId", getSenderId());
        attributes.put("senderName", getSenderName());
        attributes.put("senderUF", getSenderUF());
        attributes.put("senderEmail", getSenderEmail());
        attributes.put("senderType", getSenderType());
        attributes.put("messageText", getMessageText());
        attributes.put("textType", getTextType());
        attributes.put("messageTS", getMessageTS());
        attributes.put("messagePublic", getMessagePublic());
        attributes.put("adminMessage", getAdminMessage());
        attributes.put("recipientUserId", getRecipientUserId());
        attributes.put("recipientUserName", getRecipientUserName());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long chatMessageId = (Long) attributes.get("chatMessageId");

        if (chatMessageId != null) {
            setChatMessageId(chatMessageId);
        }

        Long parentMessageId = (Long) attributes.get("parentMessageId");

        if (parentMessageId != null) {
            setParentMessageId(parentMessageId);
        }

        Long chatRoomId = (Long) attributes.get("chatRoomId");

        if (chatRoomId != null) {
            setChatRoomId(chatRoomId);
        }

        Long exportedPosition = (Long) attributes.get("exportedPosition");

        if (exportedPosition != null) {
            setExportedPosition(exportedPosition);
        }

        Boolean exportedRemoved = (Boolean) attributes.get("exportedRemoved");

        if (exportedRemoved != null) {
            setExportedRemoved(exportedRemoved);
        }

        Integer messageType = (Integer) attributes.get("messageType");

        if (messageType != null) {
            setMessageType(messageType);
        }

        Integer messageStatus = (Integer) attributes.get("messageStatus");

        if (messageStatus != null) {
            setMessageStatus(messageStatus);
        }

        Long senderId = (Long) attributes.get("senderId");

        if (senderId != null) {
            setSenderId(senderId);
        }

        String senderName = (String) attributes.get("senderName");

        if (senderName != null) {
            setSenderName(senderName);
        }

        Long senderUF = (Long) attributes.get("senderUF");

        if (senderUF != null) {
            setSenderUF(senderUF);
        }

        String senderEmail = (String) attributes.get("senderEmail");

        if (senderEmail != null) {
            setSenderEmail(senderEmail);
        }

        Integer senderType = (Integer) attributes.get("senderType");

        if (senderType != null) {
            setSenderType(senderType);
        }

        String messageText = (String) attributes.get("messageText");

        if (messageText != null) {
            setMessageText(messageText);
        }

        Integer textType = (Integer) attributes.get("textType");

        if (textType != null) {
            setTextType(textType);
        }

        Date messageTS = (Date) attributes.get("messageTS");

        if (messageTS != null) {
            setMessageTS(messageTS);
        }

        Boolean messagePublic = (Boolean) attributes.get("messagePublic");

        if (messagePublic != null) {
            setMessagePublic(messagePublic);
        }

        Boolean adminMessage = (Boolean) attributes.get("adminMessage");

        if (adminMessage != null) {
            setAdminMessage(adminMessage);
        }

        Long recipientUserId = (Long) attributes.get("recipientUserId");

        if (recipientUserId != null) {
            setRecipientUserId(recipientUserId);
        }

        String recipientUserName = (String) attributes.get("recipientUserName");

        if (recipientUserName != null) {
            setRecipientUserName(recipientUserName);
        }
    }

    /**
    * Returns the primary key of this chat room message.
    *
    * @return the primary key of this chat room message
    */
    public long getPrimaryKey() {
        return _chatRoomMessage.getPrimaryKey();
    }

    /**
    * Sets the primary key of this chat room message.
    *
    * @param primaryKey the primary key of this chat room message
    */
    public void setPrimaryKey(long primaryKey) {
        _chatRoomMessage.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the chat message ID of this chat room message.
    *
    * @return the chat message ID of this chat room message
    */
    public long getChatMessageId() {
        return _chatRoomMessage.getChatMessageId();
    }

    /**
    * Sets the chat message ID of this chat room message.
    *
    * @param chatMessageId the chat message ID of this chat room message
    */
    public void setChatMessageId(long chatMessageId) {
        _chatRoomMessage.setChatMessageId(chatMessageId);
    }

    /**
    * Returns the parent message ID of this chat room message.
    *
    * @return the parent message ID of this chat room message
    */
    public long getParentMessageId() {
        return _chatRoomMessage.getParentMessageId();
    }

    /**
    * Sets the parent message ID of this chat room message.
    *
    * @param parentMessageId the parent message ID of this chat room message
    */
    public void setParentMessageId(long parentMessageId) {
        _chatRoomMessage.setParentMessageId(parentMessageId);
    }

    /**
    * Returns the chat room ID of this chat room message.
    *
    * @return the chat room ID of this chat room message
    */
    public long getChatRoomId() {
        return _chatRoomMessage.getChatRoomId();
    }

    /**
    * Sets the chat room ID of this chat room message.
    *
    * @param chatRoomId the chat room ID of this chat room message
    */
    public void setChatRoomId(long chatRoomId) {
        _chatRoomMessage.setChatRoomId(chatRoomId);
    }

    /**
    * Returns the exported position of this chat room message.
    *
    * @return the exported position of this chat room message
    */
    public long getExportedPosition() {
        return _chatRoomMessage.getExportedPosition();
    }

    /**
    * Sets the exported position of this chat room message.
    *
    * @param exportedPosition the exported position of this chat room message
    */
    public void setExportedPosition(long exportedPosition) {
        _chatRoomMessage.setExportedPosition(exportedPosition);
    }

    /**
    * Returns the exported removed of this chat room message.
    *
    * @return the exported removed of this chat room message
    */
    public boolean getExportedRemoved() {
        return _chatRoomMessage.getExportedRemoved();
    }

    /**
    * Returns <code>true</code> if this chat room message is exported removed.
    *
    * @return <code>true</code> if this chat room message is exported removed; <code>false</code> otherwise
    */
    public boolean isExportedRemoved() {
        return _chatRoomMessage.isExportedRemoved();
    }

    /**
    * Sets whether this chat room message is exported removed.
    *
    * @param exportedRemoved the exported removed of this chat room message
    */
    public void setExportedRemoved(boolean exportedRemoved) {
        _chatRoomMessage.setExportedRemoved(exportedRemoved);
    }

    /**
    * Returns the message type of this chat room message.
    *
    * @return the message type of this chat room message
    */
    public int getMessageType() {
        return _chatRoomMessage.getMessageType();
    }

    /**
    * Sets the message type of this chat room message.
    *
    * @param messageType the message type of this chat room message
    */
    public void setMessageType(int messageType) {
        _chatRoomMessage.setMessageType(messageType);
    }

    /**
    * Returns the message status of this chat room message.
    *
    * @return the message status of this chat room message
    */
    public int getMessageStatus() {
        return _chatRoomMessage.getMessageStatus();
    }

    /**
    * Sets the message status of this chat room message.
    *
    * @param messageStatus the message status of this chat room message
    */
    public void setMessageStatus(int messageStatus) {
        _chatRoomMessage.setMessageStatus(messageStatus);
    }

    /**
    * Returns the sender ID of this chat room message.
    *
    * @return the sender ID of this chat room message
    */
    public long getSenderId() {
        return _chatRoomMessage.getSenderId();
    }

    /**
    * Sets the sender ID of this chat room message.
    *
    * @param senderId the sender ID of this chat room message
    */
    public void setSenderId(long senderId) {
        _chatRoomMessage.setSenderId(senderId);
    }

    /**
    * Returns the sender name of this chat room message.
    *
    * @return the sender name of this chat room message
    */
    public java.lang.String getSenderName() {
        return _chatRoomMessage.getSenderName();
    }

    /**
    * Sets the sender name of this chat room message.
    *
    * @param senderName the sender name of this chat room message
    */
    public void setSenderName(java.lang.String senderName) {
        _chatRoomMessage.setSenderName(senderName);
    }

    /**
    * Returns the sender u f of this chat room message.
    *
    * @return the sender u f of this chat room message
    */
    public long getSenderUF() {
        return _chatRoomMessage.getSenderUF();
    }

    /**
    * Sets the sender u f of this chat room message.
    *
    * @param senderUF the sender u f of this chat room message
    */
    public void setSenderUF(long senderUF) {
        _chatRoomMessage.setSenderUF(senderUF);
    }

    /**
    * Returns the sender email of this chat room message.
    *
    * @return the sender email of this chat room message
    */
    public java.lang.String getSenderEmail() {
        return _chatRoomMessage.getSenderEmail();
    }

    /**
    * Sets the sender email of this chat room message.
    *
    * @param senderEmail the sender email of this chat room message
    */
    public void setSenderEmail(java.lang.String senderEmail) {
        _chatRoomMessage.setSenderEmail(senderEmail);
    }

    /**
    * Returns the sender type of this chat room message.
    *
    * @return the sender type of this chat room message
    */
    public int getSenderType() {
        return _chatRoomMessage.getSenderType();
    }

    /**
    * Sets the sender type of this chat room message.
    *
    * @param senderType the sender type of this chat room message
    */
    public void setSenderType(int senderType) {
        _chatRoomMessage.setSenderType(senderType);
    }

    /**
    * Returns the message text of this chat room message.
    *
    * @return the message text of this chat room message
    */
    public java.lang.String getMessageText() {
        return _chatRoomMessage.getMessageText();
    }

    /**
    * Sets the message text of this chat room message.
    *
    * @param messageText the message text of this chat room message
    */
    public void setMessageText(java.lang.String messageText) {
        _chatRoomMessage.setMessageText(messageText);
    }

    /**
    * Returns the text type of this chat room message.
    *
    * @return the text type of this chat room message
    */
    public int getTextType() {
        return _chatRoomMessage.getTextType();
    }

    /**
    * Sets the text type of this chat room message.
    *
    * @param textType the text type of this chat room message
    */
    public void setTextType(int textType) {
        _chatRoomMessage.setTextType(textType);
    }

    /**
    * Returns the message t s of this chat room message.
    *
    * @return the message t s of this chat room message
    */
    public java.util.Date getMessageTS() {
        return _chatRoomMessage.getMessageTS();
    }

    /**
    * Sets the message t s of this chat room message.
    *
    * @param messageTS the message t s of this chat room message
    */
    public void setMessageTS(java.util.Date messageTS) {
        _chatRoomMessage.setMessageTS(messageTS);
    }

    /**
    * Returns the message public of this chat room message.
    *
    * @return the message public of this chat room message
    */
    public boolean getMessagePublic() {
        return _chatRoomMessage.getMessagePublic();
    }

    /**
    * Returns <code>true</code> if this chat room message is message public.
    *
    * @return <code>true</code> if this chat room message is message public; <code>false</code> otherwise
    */
    public boolean isMessagePublic() {
        return _chatRoomMessage.isMessagePublic();
    }

    /**
    * Sets whether this chat room message is message public.
    *
    * @param messagePublic the message public of this chat room message
    */
    public void setMessagePublic(boolean messagePublic) {
        _chatRoomMessage.setMessagePublic(messagePublic);
    }

    /**
    * Returns the admin message of this chat room message.
    *
    * @return the admin message of this chat room message
    */
    public boolean getAdminMessage() {
        return _chatRoomMessage.getAdminMessage();
    }

    /**
    * Returns <code>true</code> if this chat room message is admin message.
    *
    * @return <code>true</code> if this chat room message is admin message; <code>false</code> otherwise
    */
    public boolean isAdminMessage() {
        return _chatRoomMessage.isAdminMessage();
    }

    /**
    * Sets whether this chat room message is admin message.
    *
    * @param adminMessage the admin message of this chat room message
    */
    public void setAdminMessage(boolean adminMessage) {
        _chatRoomMessage.setAdminMessage(adminMessage);
    }

    /**
    * Returns the recipient user ID of this chat room message.
    *
    * @return the recipient user ID of this chat room message
    */
    public long getRecipientUserId() {
        return _chatRoomMessage.getRecipientUserId();
    }

    /**
    * Sets the recipient user ID of this chat room message.
    *
    * @param recipientUserId the recipient user ID of this chat room message
    */
    public void setRecipientUserId(long recipientUserId) {
        _chatRoomMessage.setRecipientUserId(recipientUserId);
    }

    /**
    * Returns the recipient user uuid of this chat room message.
    *
    * @return the recipient user uuid of this chat room message
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getRecipientUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomMessage.getRecipientUserUuid();
    }

    /**
    * Sets the recipient user uuid of this chat room message.
    *
    * @param recipientUserUuid the recipient user uuid of this chat room message
    */
    public void setRecipientUserUuid(java.lang.String recipientUserUuid) {
        _chatRoomMessage.setRecipientUserUuid(recipientUserUuid);
    }

    /**
    * Returns the recipient user name of this chat room message.
    *
    * @return the recipient user name of this chat room message
    */
    public java.lang.String getRecipientUserName() {
        return _chatRoomMessage.getRecipientUserName();
    }

    /**
    * Sets the recipient user name of this chat room message.
    *
    * @param recipientUserName the recipient user name of this chat room message
    */
    public void setRecipientUserName(java.lang.String recipientUserName) {
        _chatRoomMessage.setRecipientUserName(recipientUserName);
    }

    public boolean isNew() {
        return _chatRoomMessage.isNew();
    }

    public void setNew(boolean n) {
        _chatRoomMessage.setNew(n);
    }

    public boolean isCachedModel() {
        return _chatRoomMessage.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _chatRoomMessage.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _chatRoomMessage.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _chatRoomMessage.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _chatRoomMessage.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _chatRoomMessage.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _chatRoomMessage.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ChatRoomMessageWrapper((ChatRoomMessage) _chatRoomMessage.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage chatRoomMessage) {
        return _chatRoomMessage.compareTo(chatRoomMessage);
    }

    @Override
    public int hashCode() {
        return _chatRoomMessage.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> toCacheModel() {
        return _chatRoomMessage.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage toEscapedModel() {
        return new ChatRoomMessageWrapper(_chatRoomMessage.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _chatRoomMessage.toString();
    }

    public java.lang.String toXmlString() {
        return _chatRoomMessage.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _chatRoomMessage.persist();
    }

    public com.liferay.portal.kernel.json.JSONObject getJSON() {
        return _chatRoomMessage.getJSON();
    }

    public java.lang.String getFormattedText(java.util.TimeZone tz) {
        return _chatRoomMessage.getFormattedText(tz);
    }

    public java.lang.String getMessageXMLForExport(java.util.TimeZone tz) {
        return _chatRoomMessage.getMessageXMLForExport(tz);
    }

    public java.lang.String getMessageHTMLForExport(java.util.TimeZone tz) {
        return _chatRoomMessage.getMessageHTMLForExport(tz);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public ChatRoomMessage getWrappedChatRoomMessage() {
        return _chatRoomMessage;
    }

    public ChatRoomMessage getWrappedModel() {
        return _chatRoomMessage;
    }

    public void resetOriginalValues() {
        _chatRoomMessage.resetOriginalValues();
    }
}
