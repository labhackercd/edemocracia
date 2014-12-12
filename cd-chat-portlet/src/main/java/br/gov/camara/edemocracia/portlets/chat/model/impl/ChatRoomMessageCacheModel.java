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

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ChatRoomMessage in entity cache.
 *
 * @author Ricardo Lima
 * @see ChatRoomMessage
 * @generated
 */
public class ChatRoomMessageCacheModel implements CacheModel<ChatRoomMessage>,
    Serializable {
    public long chatMessageId;
    public long parentMessageId;
    public long chatRoomId;
    public long exportedPosition;
    public boolean exportedRemoved;
    public int messageType;
    public int messageStatus;
    public long senderId;
    public String senderName;
    public long senderUF;
    public String senderEmail;
    public int senderType;
    public String messageText;
    public int textType;
    public long messageTS;
    public boolean messagePublic;
    public boolean adminMessage;
    public long recipientUserId;
    public String recipientUserName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(39);

        sb.append("{chatMessageId=");
        sb.append(chatMessageId);
        sb.append(", parentMessageId=");
        sb.append(parentMessageId);
        sb.append(", chatRoomId=");
        sb.append(chatRoomId);
        sb.append(", exportedPosition=");
        sb.append(exportedPosition);
        sb.append(", exportedRemoved=");
        sb.append(exportedRemoved);
        sb.append(", messageType=");
        sb.append(messageType);
        sb.append(", messageStatus=");
        sb.append(messageStatus);
        sb.append(", senderId=");
        sb.append(senderId);
        sb.append(", senderName=");
        sb.append(senderName);
        sb.append(", senderUF=");
        sb.append(senderUF);
        sb.append(", senderEmail=");
        sb.append(senderEmail);
        sb.append(", senderType=");
        sb.append(senderType);
        sb.append(", messageText=");
        sb.append(messageText);
        sb.append(", textType=");
        sb.append(textType);
        sb.append(", messageTS=");
        sb.append(messageTS);
        sb.append(", messagePublic=");
        sb.append(messagePublic);
        sb.append(", adminMessage=");
        sb.append(adminMessage);
        sb.append(", recipientUserId=");
        sb.append(recipientUserId);
        sb.append(", recipientUserName=");
        sb.append(recipientUserName);
        sb.append("}");

        return sb.toString();
    }

    public ChatRoomMessage toEntityModel() {
        ChatRoomMessageImpl chatRoomMessageImpl = new ChatRoomMessageImpl();

        chatRoomMessageImpl.setChatMessageId(chatMessageId);
        chatRoomMessageImpl.setParentMessageId(parentMessageId);
        chatRoomMessageImpl.setChatRoomId(chatRoomId);
        chatRoomMessageImpl.setExportedPosition(exportedPosition);
        chatRoomMessageImpl.setExportedRemoved(exportedRemoved);
        chatRoomMessageImpl.setMessageType(messageType);
        chatRoomMessageImpl.setMessageStatus(messageStatus);
        chatRoomMessageImpl.setSenderId(senderId);

        if (senderName == null) {
            chatRoomMessageImpl.setSenderName(StringPool.BLANK);
        } else {
            chatRoomMessageImpl.setSenderName(senderName);
        }

        chatRoomMessageImpl.setSenderUF(senderUF);

        if (senderEmail == null) {
            chatRoomMessageImpl.setSenderEmail(StringPool.BLANK);
        } else {
            chatRoomMessageImpl.setSenderEmail(senderEmail);
        }

        chatRoomMessageImpl.setSenderType(senderType);

        if (messageText == null) {
            chatRoomMessageImpl.setMessageText(StringPool.BLANK);
        } else {
            chatRoomMessageImpl.setMessageText(messageText);
        }

        chatRoomMessageImpl.setTextType(textType);

        if (messageTS == Long.MIN_VALUE) {
            chatRoomMessageImpl.setMessageTS(null);
        } else {
            chatRoomMessageImpl.setMessageTS(new Date(messageTS));
        }

        chatRoomMessageImpl.setMessagePublic(messagePublic);
        chatRoomMessageImpl.setAdminMessage(adminMessage);
        chatRoomMessageImpl.setRecipientUserId(recipientUserId);

        if (recipientUserName == null) {
            chatRoomMessageImpl.setRecipientUserName(StringPool.BLANK);
        } else {
            chatRoomMessageImpl.setRecipientUserName(recipientUserName);
        }

        chatRoomMessageImpl.resetOriginalValues();

        return chatRoomMessageImpl;
    }
}
