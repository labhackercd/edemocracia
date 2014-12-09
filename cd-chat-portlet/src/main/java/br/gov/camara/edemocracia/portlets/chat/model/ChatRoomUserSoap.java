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
public class ChatRoomUserSoap implements Serializable {
    private long _chatUserId;
    private long _chatRoomId;
    private long _userId;
    private String _userName;
    private long _userImgId;
    private long _userUF;
    private String _userEmail;
    private boolean _banned;
    private int _userType;
    private Date _joinedTS;

    public ChatRoomUserSoap() {
    }

    public static ChatRoomUserSoap toSoapModel(ChatRoomUser model) {
        ChatRoomUserSoap soapModel = new ChatRoomUserSoap();

        soapModel.setChatUserId(model.getChatUserId());
        soapModel.setChatRoomId(model.getChatRoomId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setUserImgId(model.getUserImgId());
        soapModel.setUserUF(model.getUserUF());
        soapModel.setUserEmail(model.getUserEmail());
        soapModel.setBanned(model.getBanned());
        soapModel.setUserType(model.getUserType());
        soapModel.setJoinedTS(model.getJoinedTS());

        return soapModel;
    }

    public static ChatRoomUserSoap[] toSoapModels(ChatRoomUser[] models) {
        ChatRoomUserSoap[] soapModels = new ChatRoomUserSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ChatRoomUserSoap[][] toSoapModels(ChatRoomUser[][] models) {
        ChatRoomUserSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ChatRoomUserSoap[models.length][models[0].length];
        } else {
            soapModels = new ChatRoomUserSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ChatRoomUserSoap[] toSoapModels(List<ChatRoomUser> models) {
        List<ChatRoomUserSoap> soapModels = new ArrayList<ChatRoomUserSoap>(models.size());

        for (ChatRoomUser model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ChatRoomUserSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _chatUserId;
    }

    public void setPrimaryKey(long pk) {
        setChatUserId(pk);
    }

    public long getChatUserId() {
        return _chatUserId;
    }

    public void setChatUserId(long chatUserId) {
        _chatUserId = chatUserId;
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
}
