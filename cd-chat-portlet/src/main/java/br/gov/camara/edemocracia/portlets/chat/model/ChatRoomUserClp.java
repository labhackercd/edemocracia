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

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomUserLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ChatRoomUserClp extends BaseModelImpl<ChatRoomUser>
    implements ChatRoomUser {
    private long _chatUserId;
    private String _chatUserUuid;
    private long _chatRoomId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private long _userImgId;
    private long _userUF;
    private String _userEmail;
    private boolean _banned;
    private int _userType;
    private Date _joinedTS;
    private BaseModel<?> _chatRoomUserRemoteModel;

    public ChatRoomUserClp() {
    }

    public Class<?> getModelClass() {
        return ChatRoomUser.class;
    }

    public String getModelClassName() {
        return ChatRoomUser.class.getName();
    }

    public long getPrimaryKey() {
        return _chatUserId;
    }

    public void setPrimaryKey(long primaryKey) {
        setChatUserId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_chatUserId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("chatUserId", getChatUserId());
        attributes.put("chatRoomId", getChatRoomId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("userImgId", getUserImgId());
        attributes.put("userUF", getUserUF());
        attributes.put("userEmail", getUserEmail());
        attributes.put("banned", getBanned());
        attributes.put("userType", getUserType());
        attributes.put("joinedTS", getJoinedTS());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long chatUserId = (Long) attributes.get("chatUserId");

        if (chatUserId != null) {
            setChatUserId(chatUserId);
        }

        Long chatRoomId = (Long) attributes.get("chatRoomId");

        if (chatRoomId != null) {
            setChatRoomId(chatRoomId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Long userImgId = (Long) attributes.get("userImgId");

        if (userImgId != null) {
            setUserImgId(userImgId);
        }

        Long userUF = (Long) attributes.get("userUF");

        if (userUF != null) {
            setUserUF(userUF);
        }

        String userEmail = (String) attributes.get("userEmail");

        if (userEmail != null) {
            setUserEmail(userEmail);
        }

        Boolean banned = (Boolean) attributes.get("banned");

        if (banned != null) {
            setBanned(banned);
        }

        Integer userType = (Integer) attributes.get("userType");

        if (userType != null) {
            setUserType(userType);
        }

        Date joinedTS = (Date) attributes.get("joinedTS");

        if (joinedTS != null) {
            setJoinedTS(joinedTS);
        }
    }

    public long getChatUserId() {
        return _chatUserId;
    }

    public void setChatUserId(long chatUserId) {
        _chatUserId = chatUserId;
    }

    public String getChatUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getChatUserId(), "uuid", _chatUserUuid);
    }

    public void setChatUserUuid(String chatUserUuid) {
        _chatUserUuid = chatUserUuid;
    }

    public long getChatRoomId() {
        return _chatRoomId;
    }

    public void setChatRoomId(long chatRoomId) {
        _chatRoomId = chatRoomId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public long getUserImgId() {
        return _userImgId;
    }

    public void setUserImgId(long userImgId) {
        _userImgId = userImgId;
    }

    public long getUserUF() {
        return _userUF;
    }

    public void setUserUF(long userUF) {
        _userUF = userUF;
    }

    public String getUserEmail() {
        return _userEmail;
    }

    public void setUserEmail(String userEmail) {
        _userEmail = userEmail;
    }

    public boolean getBanned() {
        return _banned;
    }

    public boolean isBanned() {
        return _banned;
    }

    public void setBanned(boolean banned) {
        _banned = banned;
    }

    public int getUserType() {
        return _userType;
    }

    public void setUserType(int userType) {
        _userType = userType;
    }

    public Date getJoinedTS() {
        return _joinedTS;
    }

    public void setJoinedTS(Date joinedTS) {
        _joinedTS = joinedTS;
    }

    public com.liferay.portal.kernel.json.JSONObject getJSON() {
        throw new UnsupportedOperationException();
    }

    public boolean isModerator() {
        throw new UnsupportedOperationException();
    }

    public BaseModel<?> getChatRoomUserRemoteModel() {
        return _chatRoomUserRemoteModel;
    }

    public void setChatRoomUserRemoteModel(BaseModel<?> chatRoomUserRemoteModel) {
        _chatRoomUserRemoteModel = chatRoomUserRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ChatRoomUserLocalServiceUtil.addChatRoomUser(this);
        } else {
            ChatRoomUserLocalServiceUtil.updateChatRoomUser(this);
        }
    }

    @Override
    public ChatRoomUser toEscapedModel() {
        return (ChatRoomUser) Proxy.newProxyInstance(ChatRoomUser.class.getClassLoader(),
            new Class[] { ChatRoomUser.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ChatRoomUserClp clone = new ChatRoomUserClp();

        clone.setChatUserId(getChatUserId());
        clone.setChatRoomId(getChatRoomId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setUserImgId(getUserImgId());
        clone.setUserUF(getUserUF());
        clone.setUserEmail(getUserEmail());
        clone.setBanned(getBanned());
        clone.setUserType(getUserType());
        clone.setJoinedTS(getJoinedTS());

        return clone;
    }

    public int compareTo(ChatRoomUser chatRoomUser) {
        int value = 0;

        if (getUserType() < chatRoomUser.getUserType()) {
            value = -1;
        } else if (getUserType() > chatRoomUser.getUserType()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        value = getUserName().compareTo(chatRoomUser.getUserName());

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

        ChatRoomUserClp chatRoomUser = null;

        try {
            chatRoomUser = (ChatRoomUserClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = chatRoomUser.getPrimaryKey();

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
        StringBundler sb = new StringBundler(21);

        sb.append("{chatUserId=");
        sb.append(getChatUserId());
        sb.append(", chatRoomId=");
        sb.append(getChatRoomId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", userImgId=");
        sb.append(getUserImgId());
        sb.append(", userUF=");
        sb.append(getUserUF());
        sb.append(", userEmail=");
        sb.append(getUserEmail());
        sb.append(", banned=");
        sb.append(getBanned());
        sb.append(", userType=");
        sb.append(getUserType());
        sb.append(", joinedTS=");
        sb.append(getJoinedTS());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>chatUserId</column-name><column-value><![CDATA[");
        sb.append(getChatUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>chatRoomId</column-name><column-value><![CDATA[");
        sb.append(getChatRoomId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userImgId</column-name><column-value><![CDATA[");
        sb.append(getUserImgId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userUF</column-name><column-value><![CDATA[");
        sb.append(getUserUF());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userEmail</column-name><column-value><![CDATA[");
        sb.append(getUserEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>banned</column-name><column-value><![CDATA[");
        sb.append(getBanned());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userType</column-name><column-value><![CDATA[");
        sb.append(getUserType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>joinedTS</column-name><column-value><![CDATA[");
        sb.append(getJoinedTS());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
