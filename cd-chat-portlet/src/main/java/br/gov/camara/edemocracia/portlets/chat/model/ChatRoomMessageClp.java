package br.gov.camara.edemocracia.portlets.chat.model;

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomMessageLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ChatRoomMessageClp extends BaseModelImpl<ChatRoomMessage>
    implements ChatRoomMessage {
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
    private String _recipientUserUuid;
    private String _recipientUserName;
    private BaseModel<?> _chatRoomMessageRemoteModel;

    public ChatRoomMessageClp() {
    }

    public Class<?> getModelClass() {
        return ChatRoomMessage.class;
    }

    public String getModelClassName() {
        return ChatRoomMessage.class.getName();
    }

    public long getPrimaryKey() {
        return _chatMessageId;
    }

    public void setPrimaryKey(long primaryKey) {
        setChatMessageId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_chatMessageId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public String getRecipientUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getRecipientUserId(), "uuid",
            _recipientUserUuid);
    }

    public void setRecipientUserUuid(String recipientUserUuid) {
        _recipientUserUuid = recipientUserUuid;
    }

    public String getRecipientUserName() {
        return _recipientUserName;
    }

    public void setRecipientUserName(String recipientUserName) {
        _recipientUserName = recipientUserName;
    }

    public java.lang.String getMessageHTMLForExport(java.util.TimeZone tz) {
        throw new UnsupportedOperationException();
    }

    public com.liferay.portal.kernel.json.JSONObject getJSON() {
        throw new UnsupportedOperationException();
    }

    public java.lang.String getFormattedText(java.util.TimeZone tz) {
        throw new UnsupportedOperationException();
    }

    public java.lang.String getMessageXMLForExport(java.util.TimeZone tz) {
        throw new UnsupportedOperationException();
    }

    public BaseModel<?> getChatRoomMessageRemoteModel() {
        return _chatRoomMessageRemoteModel;
    }

    public void setChatRoomMessageRemoteModel(
        BaseModel<?> chatRoomMessageRemoteModel) {
        _chatRoomMessageRemoteModel = chatRoomMessageRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ChatRoomMessageLocalServiceUtil.addChatRoomMessage(this);
        } else {
            ChatRoomMessageLocalServiceUtil.updateChatRoomMessage(this);
        }
    }

    @Override
    public ChatRoomMessage toEscapedModel() {
        return (ChatRoomMessage) Proxy.newProxyInstance(ChatRoomMessage.class.getClassLoader(),
            new Class[] { ChatRoomMessage.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ChatRoomMessageClp clone = new ChatRoomMessageClp();

        clone.setChatMessageId(getChatMessageId());
        clone.setParentMessageId(getParentMessageId());
        clone.setChatRoomId(getChatRoomId());
        clone.setExportedPosition(getExportedPosition());
        clone.setExportedRemoved(getExportedRemoved());
        clone.setMessageType(getMessageType());
        clone.setMessageStatus(getMessageStatus());
        clone.setSenderId(getSenderId());
        clone.setSenderName(getSenderName());
        clone.setSenderUF(getSenderUF());
        clone.setSenderEmail(getSenderEmail());
        clone.setSenderType(getSenderType());
        clone.setMessageText(getMessageText());
        clone.setTextType(getTextType());
        clone.setMessageTS(getMessageTS());
        clone.setMessagePublic(getMessagePublic());
        clone.setAdminMessage(getAdminMessage());
        clone.setRecipientUserId(getRecipientUserId());
        clone.setRecipientUserName(getRecipientUserName());

        return clone;
    }

    public int compareTo(ChatRoomMessage chatRoomMessage) {
        int value = 0;

        value = DateUtil.compareTo(getMessageTS(),
                chatRoomMessage.getMessageTS());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ChatRoomMessageClp chatRoomMessage = null;

        try {
            chatRoomMessage = (ChatRoomMessageClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = chatRoomMessage.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(39);

        sb.append("{chatMessageId=");
        sb.append(getChatMessageId());
        sb.append(", parentMessageId=");
        sb.append(getParentMessageId());
        sb.append(", chatRoomId=");
        sb.append(getChatRoomId());
        sb.append(", exportedPosition=");
        sb.append(getExportedPosition());
        sb.append(", exportedRemoved=");
        sb.append(getExportedRemoved());
        sb.append(", messageType=");
        sb.append(getMessageType());
        sb.append(", messageStatus=");
        sb.append(getMessageStatus());
        sb.append(", senderId=");
        sb.append(getSenderId());
        sb.append(", senderName=");
        sb.append(getSenderName());
        sb.append(", senderUF=");
        sb.append(getSenderUF());
        sb.append(", senderEmail=");
        sb.append(getSenderEmail());
        sb.append(", senderType=");
        sb.append(getSenderType());
        sb.append(", messageText=");
        sb.append(getMessageText());
        sb.append(", textType=");
        sb.append(getTextType());
        sb.append(", messageTS=");
        sb.append(getMessageTS());
        sb.append(", messagePublic=");
        sb.append(getMessagePublic());
        sb.append(", adminMessage=");
        sb.append(getAdminMessage());
        sb.append(", recipientUserId=");
        sb.append(getRecipientUserId());
        sb.append(", recipientUserName=");
        sb.append(getRecipientUserName());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(61);

        sb.append("<model><model-name>");
        sb.append(
            "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>chatMessageId</column-name><column-value><![CDATA[");
        sb.append(getChatMessageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentMessageId</column-name><column-value><![CDATA[");
        sb.append(getParentMessageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>chatRoomId</column-name><column-value><![CDATA[");
        sb.append(getChatRoomId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>exportedPosition</column-name><column-value><![CDATA[");
        sb.append(getExportedPosition());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>exportedRemoved</column-name><column-value><![CDATA[");
        sb.append(getExportedRemoved());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageType</column-name><column-value><![CDATA[");
        sb.append(getMessageType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageStatus</column-name><column-value><![CDATA[");
        sb.append(getMessageStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>senderId</column-name><column-value><![CDATA[");
        sb.append(getSenderId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>senderName</column-name><column-value><![CDATA[");
        sb.append(getSenderName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>senderUF</column-name><column-value><![CDATA[");
        sb.append(getSenderUF());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>senderEmail</column-name><column-value><![CDATA[");
        sb.append(getSenderEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>senderType</column-name><column-value><![CDATA[");
        sb.append(getSenderType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageText</column-name><column-value><![CDATA[");
        sb.append(getMessageText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>textType</column-name><column-value><![CDATA[");
        sb.append(getTextType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageTS</column-name><column-value><![CDATA[");
        sb.append(getMessageTS());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messagePublic</column-name><column-value><![CDATA[");
        sb.append(getMessagePublic());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>adminMessage</column-name><column-value><![CDATA[");
        sb.append(getAdminMessage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>recipientUserId</column-name><column-value><![CDATA[");
        sb.append(getRecipientUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>recipientUserName</column-name><column-value><![CDATA[");
        sb.append(getRecipientUserName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
