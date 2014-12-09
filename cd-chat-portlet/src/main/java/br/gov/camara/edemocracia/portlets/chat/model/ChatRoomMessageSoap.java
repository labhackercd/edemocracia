package br.gov.camara.edemocracia.portlets.chat.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Ricardo Lima
 * @generated
 */
public class ChatRoomMessageSoap implements Serializable {
    private long _chatMessageId;
    private long _parentMessageId;
    private long _chatRoomId;
    private long _exportedPosition;
    private boolean _exportedRemoved;
    private int _messageType;
    private int _messageStatus;
    private long _senderId;
    private String _senderName;
    private long _senderUF;
    private String _senderEmail;
    private int _senderType;
    private String _messageText;
    private int _textType;
    private Date _messageTS;
    private boolean _messagePublic;
    private boolean _adminMessage;
    private long _recipientUserId;
    private String _recipientUserName;

    public ChatRoomMessageSoap() {
    }

    public static ChatRoomMessageSoap toSoapModel(ChatRoomMessage model) {
        ChatRoomMessageSoap soapModel = new ChatRoomMessageSoap();

        soapModel.setChatMessageId(model.getChatMessageId());
        soapModel.setParentMessageId(model.getParentMessageId());
        soapModel.setChatRoomId(model.getChatRoomId());
        soapModel.setExportedPosition(model.getExportedPosition());
        soapModel.setExportedRemoved(model.getExportedRemoved());
        soapModel.setMessageType(model.getMessageType());
        soapModel.setMessageStatus(model.getMessageStatus());
        soapModel.setSenderId(model.getSenderId());
        soapModel.setSenderName(model.getSenderName());
        soapModel.setSenderUF(model.getSenderUF());
        soapModel.setSenderEmail(model.getSenderEmail());
        soapModel.setSenderType(model.getSenderType());
        soapModel.setMessageText(model.getMessageText());
        soapModel.setTextType(model.getTextType());
        soapModel.setMessageTS(model.getMessageTS());
        soapModel.setMessagePublic(model.getMessagePublic());
        soapModel.setAdminMessage(model.getAdminMessage());
        soapModel.setRecipientUserId(model.getRecipientUserId());
        soapModel.setRecipientUserName(model.getRecipientUserName());

        return soapModel;
    }

    public static ChatRoomMessageSoap[] toSoapModels(ChatRoomMessage[] models) {
        ChatRoomMessageSoap[] soapModels = new ChatRoomMessageSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ChatRoomMessageSoap[][] toSoapModels(
        ChatRoomMessage[][] models) {
        ChatRoomMessageSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ChatRoomMessageSoap[models.length][models[0].length];
        } else {
            soapModels = new ChatRoomMessageSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ChatRoomMessageSoap[] toSoapModels(
        List<ChatRoomMessage> models) {
        List<ChatRoomMessageSoap> soapModels = new ArrayList<ChatRoomMessageSoap>(models.size());

        for (ChatRoomMessage model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ChatRoomMessageSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _chatMessageId;
    }

    public void setPrimaryKey(long pk) {
        setChatMessageId(pk);
    }

    public long getChatMessageId() {
        return _chatMessageId;
    }

    public void setChatMessageId(long chatMessageId) {
        _chatMessageId = chatMessageId;
    }

    public long getParentMessageId() {
        return _parentMessageId;
    }

    public void setParentMessageId(long parentMessageId) {
        _parentMessageId = parentMessageId;
    }

    public long getChatRoomId() {
        return _chatRoomId;
    }

    public void setChatRoomId(long chatRoomId) {
        _chatRoomId = chatRoomId;
    }

    public long getExportedPosition() {
        return _exportedPosition;
    }

    public void setExportedPosition(long exportedPosition) {
        _exportedPosition = exportedPosition;
    }

    public boolean getExportedRemoved() {
        return _exportedRemoved;
    }

    public boolean isExportedRemoved() {
        return _exportedRemoved;
    }

    public void setExportedRemoved(boolean exportedRemoved) {
        _exportedRemoved = exportedRemoved;
    }

    public int getMessageType() {
        return _messageType;
    }

    public void setMessageType(int messageType) {
        _messageType = messageType;
    }

    public int getMessageStatus() {
        return _messageStatus;
    }

    public void setMessageStatus(int messageStatus) {
        _messageStatus = messageStatus;
    }

    public long getSenderId() {
        return _senderId;
    }

    public void setSenderId(long senderId) {
        _senderId = senderId;
    }

    public String getSenderName() {
        return _senderName;
    }

    public void setSenderName(String senderName) {
        _senderName = senderName;
    }

    public long getSenderUF() {
        return _senderUF;
    }

    public void setSenderUF(long senderUF) {
        _senderUF = senderUF;
    }

    public String getSenderEmail() {
        return _senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        _senderEmail = senderEmail;
    }

    public int getSenderType() {
        return _senderType;
    }

    public void setSenderType(int senderType) {
        _senderType = senderType;
    }

    public String getMessageText() {
        return _messageText;
    }

    public void setMessageText(String messageText) {
        _messageText = messageText;
    }

    public int getTextType() {
        return _textType;
    }

    public void setTextType(int textType) {
        _textType = textType;
    }

    public Date getMessageTS() {
        return _messageTS;
    }

    public void setMessageTS(Date messageTS) {
        _messageTS = messageTS;
    }

    public boolean getMessagePublic() {
        return _messagePublic;
    }

    public boolean isMessagePublic() {
        return _messagePublic;
    }

    public void setMessagePublic(boolean messagePublic) {
        _messagePublic = messagePublic;
    }

    public boolean getAdminMessage() {
        return _adminMessage;
    }

    public boolean isAdminMessage() {
        return _adminMessage;
    }

    public void setAdminMessage(boolean adminMessage) {
        _adminMessage = adminMessage;
    }

    public long getRecipientUserId() {
        return _recipientUserId;
    }

    public void setRecipientUserId(long recipientUserId) {
        _recipientUserId = recipientUserId;
    }

    public String getRecipientUserName() {
        return _recipientUserName;
    }

    public void setRecipientUserName(String recipientUserName) {
        _recipientUserName = recipientUserName;
    }
}
