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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link br.gov.camara.edemocracia.portlets.chat.service.http.ChatRoomServiceSoap}.
 *
 * @author    Ricardo Lima
 * @see       br.gov.camara.edemocracia.portlets.chat.service.http.ChatRoomServiceSoap
 * @generated
 */
public class ChatRoomSoap implements Serializable {
    private long _roomId;
    private String _roomName;
    private String _description;
    private int _openPolicy;
    private int _status;
    private Date _openFrom;
    private Date _openUntil;
    private boolean _moderated;
    private int _capacity;
    private int _maxSimultaneousUsersSpying;
    private int _maxSimultaneousUsers;
    private boolean _anonymousAllowed;
    private long _guestId;
    private String _guestName;
    private long _companyId;
    private long _groupId;
    private boolean _usePolicyEnabled;
    private String _usePolicyURL;
    private long _imageId;
    private long _videoLiveId;
    private long _videoRecordedId;
    private Date _createDate;

    public ChatRoomSoap() {
    }

    public static ChatRoomSoap toSoapModel(ChatRoom model) {
        ChatRoomSoap soapModel = new ChatRoomSoap();

        soapModel.setRoomId(model.getRoomId());
        soapModel.setRoomName(model.getRoomName());
        soapModel.setDescription(model.getDescription());
        soapModel.setOpenPolicy(model.getOpenPolicy());
        soapModel.setStatus(model.getStatus());
        soapModel.setOpenFrom(model.getOpenFrom());
        soapModel.setOpenUntil(model.getOpenUntil());
        soapModel.setModerated(model.getModerated());
        soapModel.setCapacity(model.getCapacity());
        soapModel.setMaxSimultaneousUsersSpying(model.getMaxSimultaneousUsersSpying());
        soapModel.setMaxSimultaneousUsers(model.getMaxSimultaneousUsers());
        soapModel.setAnonymousAllowed(model.getAnonymousAllowed());
        soapModel.setGuestId(model.getGuestId());
        soapModel.setGuestName(model.getGuestName());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setUsePolicyEnabled(model.getUsePolicyEnabled());
        soapModel.setUsePolicyURL(model.getUsePolicyURL());
        soapModel.setImageId(model.getImageId());
        soapModel.setVideoLiveId(model.getVideoLiveId());
        soapModel.setVideoRecordedId(model.getVideoRecordedId());
        soapModel.setCreateDate(model.getCreateDate());

        return soapModel;
    }

    public static ChatRoomSoap[] toSoapModels(ChatRoom[] models) {
        ChatRoomSoap[] soapModels = new ChatRoomSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ChatRoomSoap[][] toSoapModels(ChatRoom[][] models) {
        ChatRoomSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ChatRoomSoap[models.length][models[0].length];
        } else {
            soapModels = new ChatRoomSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ChatRoomSoap[] toSoapModels(List<ChatRoom> models) {
        List<ChatRoomSoap> soapModels = new ArrayList<ChatRoomSoap>(models.size());

        for (ChatRoom model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ChatRoomSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _roomId;
    }

    public void setPrimaryKey(long pk) {
        setRoomId(pk);
    }

    public long getRoomId() {
        return _roomId;
    }

    public void setRoomId(long roomId) {
        _roomId = roomId;
    }

    public String getRoomName() {
        return _roomName;
    }

    public void setRoomName(String roomName) {
        _roomName = roomName;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public int getOpenPolicy() {
        return _openPolicy;
    }

    public void setOpenPolicy(int openPolicy) {
        _openPolicy = openPolicy;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public Date getOpenFrom() {
        return _openFrom;
    }

    public void setOpenFrom(Date openFrom) {
        _openFrom = openFrom;
    }

    public Date getOpenUntil() {
        return _openUntil;
    }

    public void setOpenUntil(Date openUntil) {
        _openUntil = openUntil;
    }

    public boolean getModerated() {
        return _moderated;
    }

    public boolean isModerated() {
        return _moderated;
    }

    public void setModerated(boolean moderated) {
        _moderated = moderated;
    }

    public int getCapacity() {
        return _capacity;
    }

    public void setCapacity(int capacity) {
        _capacity = capacity;
    }

    public int getMaxSimultaneousUsersSpying() {
        return _maxSimultaneousUsersSpying;
    }

    public void setMaxSimultaneousUsersSpying(int maxSimultaneousUsersSpying) {
        _maxSimultaneousUsersSpying = maxSimultaneousUsersSpying;
    }

    public int getMaxSimultaneousUsers() {
        return _maxSimultaneousUsers;
    }

    public void setMaxSimultaneousUsers(int maxSimultaneousUsers) {
        _maxSimultaneousUsers = maxSimultaneousUsers;
    }

    public boolean getAnonymousAllowed() {
        return _anonymousAllowed;
    }

    public boolean isAnonymousAllowed() {
        return _anonymousAllowed;
    }

    public void setAnonymousAllowed(boolean anonymousAllowed) {
        _anonymousAllowed = anonymousAllowed;
    }

    public long getGuestId() {
        return _guestId;
    }

    public void setGuestId(long guestId) {
        _guestId = guestId;
    }

    public String getGuestName() {
        return _guestName;
    }

    public void setGuestName(String guestName) {
        _guestName = guestName;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public boolean getUsePolicyEnabled() {
        return _usePolicyEnabled;
    }

    public boolean isUsePolicyEnabled() {
        return _usePolicyEnabled;
    }

    public void setUsePolicyEnabled(boolean usePolicyEnabled) {
        _usePolicyEnabled = usePolicyEnabled;
    }

    public String getUsePolicyURL() {
        return _usePolicyURL;
    }

    public void setUsePolicyURL(String usePolicyURL) {
        _usePolicyURL = usePolicyURL;
    }

    public long getImageId() {
        return _imageId;
    }

    public void setImageId(long imageId) {
        _imageId = imageId;
    }

    public long getVideoLiveId() {
        return _videoLiveId;
    }

    public void setVideoLiveId(long videoLiveId) {
        _videoLiveId = videoLiveId;
    }

    public long getVideoRecordedId() {
        return _videoRecordedId;
    }

    public void setVideoRecordedId(long videoRecordedId) {
        _videoRecordedId = videoRecordedId;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }
}
