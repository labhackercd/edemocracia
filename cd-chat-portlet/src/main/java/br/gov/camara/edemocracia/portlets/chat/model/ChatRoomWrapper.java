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
 * This class is a wrapper for {@link ChatRoom}.
 * </p>
 *
 * @author    Ricardo Lima
 * @see       ChatRoom
 * @generated
 */
public class ChatRoomWrapper implements ChatRoom, ModelWrapper<ChatRoom> {
    private ChatRoom _chatRoom;

    public ChatRoomWrapper(ChatRoom chatRoom) {
        _chatRoom = chatRoom;
    }

    public Class<?> getModelClass() {
        return ChatRoom.class;
    }

    public String getModelClassName() {
        return ChatRoom.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("roomId", getRoomId());
        attributes.put("roomName", getRoomName());
        attributes.put("description", getDescription());
        attributes.put("openPolicy", getOpenPolicy());
        attributes.put("status", getStatus());
        attributes.put("openFrom", getOpenFrom());
        attributes.put("openUntil", getOpenUntil());
        attributes.put("moderated", getModerated());
        attributes.put("capacity", getCapacity());
        attributes.put("maxSimultaneousUsersSpying",
            getMaxSimultaneousUsersSpying());
        attributes.put("maxSimultaneousUsers", getMaxSimultaneousUsers());
        attributes.put("anonymousAllowed", getAnonymousAllowed());
        attributes.put("guestId", getGuestId());
        attributes.put("guestName", getGuestName());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("usePolicyEnabled", getUsePolicyEnabled());
        attributes.put("usePolicyURL", getUsePolicyURL());
        attributes.put("imageId", getImageId());
        attributes.put("videoLiveId", getVideoLiveId());
        attributes.put("videoRecordedId", getVideoRecordedId());
        attributes.put("createDate", getCreateDate());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long roomId = (Long) attributes.get("roomId");

        if (roomId != null) {
            setRoomId(roomId);
        }

        String roomName = (String) attributes.get("roomName");

        if (roomName != null) {
            setRoomName(roomName);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Integer openPolicy = (Integer) attributes.get("openPolicy");

        if (openPolicy != null) {
            setOpenPolicy(openPolicy);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Date openFrom = (Date) attributes.get("openFrom");

        if (openFrom != null) {
            setOpenFrom(openFrom);
        }

        Date openUntil = (Date) attributes.get("openUntil");

        if (openUntil != null) {
            setOpenUntil(openUntil);
        }

        Boolean moderated = (Boolean) attributes.get("moderated");

        if (moderated != null) {
            setModerated(moderated);
        }

        Integer capacity = (Integer) attributes.get("capacity");

        if (capacity != null) {
            setCapacity(capacity);
        }

        Integer maxSimultaneousUsersSpying = (Integer) attributes.get(
                "maxSimultaneousUsersSpying");

        if (maxSimultaneousUsersSpying != null) {
            setMaxSimultaneousUsersSpying(maxSimultaneousUsersSpying);
        }

        Integer maxSimultaneousUsers = (Integer) attributes.get(
                "maxSimultaneousUsers");

        if (maxSimultaneousUsers != null) {
            setMaxSimultaneousUsers(maxSimultaneousUsers);
        }

        Boolean anonymousAllowed = (Boolean) attributes.get("anonymousAllowed");

        if (anonymousAllowed != null) {
            setAnonymousAllowed(anonymousAllowed);
        }

        Long guestId = (Long) attributes.get("guestId");

        if (guestId != null) {
            setGuestId(guestId);
        }

        String guestName = (String) attributes.get("guestName");

        if (guestName != null) {
            setGuestName(guestName);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Boolean usePolicyEnabled = (Boolean) attributes.get("usePolicyEnabled");

        if (usePolicyEnabled != null) {
            setUsePolicyEnabled(usePolicyEnabled);
        }

        String usePolicyURL = (String) attributes.get("usePolicyURL");

        if (usePolicyURL != null) {
            setUsePolicyURL(usePolicyURL);
        }

        Long imageId = (Long) attributes.get("imageId");

        if (imageId != null) {
            setImageId(imageId);
        }

        Long videoLiveId = (Long) attributes.get("videoLiveId");

        if (videoLiveId != null) {
            setVideoLiveId(videoLiveId);
        }

        Long videoRecordedId = (Long) attributes.get("videoRecordedId");

        if (videoRecordedId != null) {
            setVideoRecordedId(videoRecordedId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }
    }

    /**
    * Returns the primary key of this chat room.
    *
    * @return the primary key of this chat room
    */
    public long getPrimaryKey() {
        return _chatRoom.getPrimaryKey();
    }

    /**
    * Sets the primary key of this chat room.
    *
    * @param primaryKey the primary key of this chat room
    */
    public void setPrimaryKey(long primaryKey) {
        _chatRoom.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the room ID of this chat room.
    *
    * @return the room ID of this chat room
    */
    public long getRoomId() {
        return _chatRoom.getRoomId();
    }

    /**
    * Sets the room ID of this chat room.
    *
    * @param roomId the room ID of this chat room
    */
    public void setRoomId(long roomId) {
        _chatRoom.setRoomId(roomId);
    }

    /**
    * Returns the room name of this chat room.
    *
    * @return the room name of this chat room
    */
    public java.lang.String getRoomName() {
        return _chatRoom.getRoomName();
    }

    /**
    * Sets the room name of this chat room.
    *
    * @param roomName the room name of this chat room
    */
    public void setRoomName(java.lang.String roomName) {
        _chatRoom.setRoomName(roomName);
    }

    /**
    * Returns the description of this chat room.
    *
    * @return the description of this chat room
    */
    public java.lang.String getDescription() {
        return _chatRoom.getDescription();
    }

    /**
    * Sets the description of this chat room.
    *
    * @param description the description of this chat room
    */
    public void setDescription(java.lang.String description) {
        _chatRoom.setDescription(description);
    }

    /**
    * Returns the open policy of this chat room.
    *
    * @return the open policy of this chat room
    */
    public int getOpenPolicy() {
        return _chatRoom.getOpenPolicy();
    }

    /**
    * Sets the open policy of this chat room.
    *
    * @param openPolicy the open policy of this chat room
    */
    public void setOpenPolicy(int openPolicy) {
        _chatRoom.setOpenPolicy(openPolicy);
    }

    /**
    * Returns the status of this chat room.
    *
    * @return the status of this chat room
    */
    public int getStatus() {
        return _chatRoom.getStatus();
    }

    /**
    * Sets the status of this chat room.
    *
    * @param status the status of this chat room
    */
    public void setStatus(int status) {
        _chatRoom.setStatus(status);
    }

    /**
    * Returns the open from of this chat room.
    *
    * @return the open from of this chat room
    */
    public java.util.Date getOpenFrom() {
        return _chatRoom.getOpenFrom();
    }

    /**
    * Sets the open from of this chat room.
    *
    * @param openFrom the open from of this chat room
    */
    public void setOpenFrom(java.util.Date openFrom) {
        _chatRoom.setOpenFrom(openFrom);
    }

    /**
    * Returns the open until of this chat room.
    *
    * @return the open until of this chat room
    */
    public java.util.Date getOpenUntil() {
        return _chatRoom.getOpenUntil();
    }

    /**
    * Sets the open until of this chat room.
    *
    * @param openUntil the open until of this chat room
    */
    public void setOpenUntil(java.util.Date openUntil) {
        _chatRoom.setOpenUntil(openUntil);
    }

    /**
    * Returns the moderated of this chat room.
    *
    * @return the moderated of this chat room
    */
    public boolean getModerated() {
        return _chatRoom.getModerated();
    }

    /**
    * Returns <code>true</code> if this chat room is moderated.
    *
    * @return <code>true</code> if this chat room is moderated; <code>false</code> otherwise
    */
    public boolean isModerated() {
        return _chatRoom.isModerated();
    }

    /**
    * Sets whether this chat room is moderated.
    *
    * @param moderated the moderated of this chat room
    */
    public void setModerated(boolean moderated) {
        _chatRoom.setModerated(moderated);
    }

    /**
    * Returns the capacity of this chat room.
    *
    * @return the capacity of this chat room
    */
    public int getCapacity() {
        return _chatRoom.getCapacity();
    }

    /**
    * Sets the capacity of this chat room.
    *
    * @param capacity the capacity of this chat room
    */
    public void setCapacity(int capacity) {
        _chatRoom.setCapacity(capacity);
    }

    /**
    * Returns the max simultaneous users spying of this chat room.
    *
    * @return the max simultaneous users spying of this chat room
    */
    public int getMaxSimultaneousUsersSpying() {
        return _chatRoom.getMaxSimultaneousUsersSpying();
    }

    /**
    * Sets the max simultaneous users spying of this chat room.
    *
    * @param maxSimultaneousUsersSpying the max simultaneous users spying of this chat room
    */
    public void setMaxSimultaneousUsersSpying(int maxSimultaneousUsersSpying) {
        _chatRoom.setMaxSimultaneousUsersSpying(maxSimultaneousUsersSpying);
    }

    /**
    * Returns the max simultaneous users of this chat room.
    *
    * @return the max simultaneous users of this chat room
    */
    public int getMaxSimultaneousUsers() {
        return _chatRoom.getMaxSimultaneousUsers();
    }

    /**
    * Sets the max simultaneous users of this chat room.
    *
    * @param maxSimultaneousUsers the max simultaneous users of this chat room
    */
    public void setMaxSimultaneousUsers(int maxSimultaneousUsers) {
        _chatRoom.setMaxSimultaneousUsers(maxSimultaneousUsers);
    }

    /**
    * Returns the anonymous allowed of this chat room.
    *
    * @return the anonymous allowed of this chat room
    */
    public boolean getAnonymousAllowed() {
        return _chatRoom.getAnonymousAllowed();
    }

    /**
    * Returns <code>true</code> if this chat room is anonymous allowed.
    *
    * @return <code>true</code> if this chat room is anonymous allowed; <code>false</code> otherwise
    */
    public boolean isAnonymousAllowed() {
        return _chatRoom.isAnonymousAllowed();
    }

    /**
    * Sets whether this chat room is anonymous allowed.
    *
    * @param anonymousAllowed the anonymous allowed of this chat room
    */
    public void setAnonymousAllowed(boolean anonymousAllowed) {
        _chatRoom.setAnonymousAllowed(anonymousAllowed);
    }

    /**
    * Returns the guest ID of this chat room.
    *
    * @return the guest ID of this chat room
    */
    public long getGuestId() {
        return _chatRoom.getGuestId();
    }

    /**
    * Sets the guest ID of this chat room.
    *
    * @param guestId the guest ID of this chat room
    */
    public void setGuestId(long guestId) {
        _chatRoom.setGuestId(guestId);
    }

    /**
    * Returns the guest name of this chat room.
    *
    * @return the guest name of this chat room
    */
    public java.lang.String getGuestName() {
        return _chatRoom.getGuestName();
    }

    /**
    * Sets the guest name of this chat room.
    *
    * @param guestName the guest name of this chat room
    */
    public void setGuestName(java.lang.String guestName) {
        _chatRoom.setGuestName(guestName);
    }

    /**
    * Returns the company ID of this chat room.
    *
    * @return the company ID of this chat room
    */
    public long getCompanyId() {
        return _chatRoom.getCompanyId();
    }

    /**
    * Sets the company ID of this chat room.
    *
    * @param companyId the company ID of this chat room
    */
    public void setCompanyId(long companyId) {
        _chatRoom.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this chat room.
    *
    * @return the group ID of this chat room
    */
    public long getGroupId() {
        return _chatRoom.getGroupId();
    }

    /**
    * Sets the group ID of this chat room.
    *
    * @param groupId the group ID of this chat room
    */
    public void setGroupId(long groupId) {
        _chatRoom.setGroupId(groupId);
    }

    /**
    * Returns the use policy enabled of this chat room.
    *
    * @return the use policy enabled of this chat room
    */
    public boolean getUsePolicyEnabled() {
        return _chatRoom.getUsePolicyEnabled();
    }

    /**
    * Returns <code>true</code> if this chat room is use policy enabled.
    *
    * @return <code>true</code> if this chat room is use policy enabled; <code>false</code> otherwise
    */
    public boolean isUsePolicyEnabled() {
        return _chatRoom.isUsePolicyEnabled();
    }

    /**
    * Sets whether this chat room is use policy enabled.
    *
    * @param usePolicyEnabled the use policy enabled of this chat room
    */
    public void setUsePolicyEnabled(boolean usePolicyEnabled) {
        _chatRoom.setUsePolicyEnabled(usePolicyEnabled);
    }

    /**
    * Returns the use policy u r l of this chat room.
    *
    * @return the use policy u r l of this chat room
    */
    public java.lang.String getUsePolicyURL() {
        return _chatRoom.getUsePolicyURL();
    }

    /**
    * Sets the use policy u r l of this chat room.
    *
    * @param usePolicyURL the use policy u r l of this chat room
    */
    public void setUsePolicyURL(java.lang.String usePolicyURL) {
        _chatRoom.setUsePolicyURL(usePolicyURL);
    }

    /**
    * Returns the image ID of this chat room.
    *
    * @return the image ID of this chat room
    */
    public long getImageId() {
        return _chatRoom.getImageId();
    }

    /**
    * Sets the image ID of this chat room.
    *
    * @param imageId the image ID of this chat room
    */
    public void setImageId(long imageId) {
        _chatRoom.setImageId(imageId);
    }

    /**
    * Returns the video live ID of this chat room.
    *
    * @return the video live ID of this chat room
    */
    public long getVideoLiveId() {
        return _chatRoom.getVideoLiveId();
    }

    /**
    * Sets the video live ID of this chat room.
    *
    * @param videoLiveId the video live ID of this chat room
    */
    public void setVideoLiveId(long videoLiveId) {
        _chatRoom.setVideoLiveId(videoLiveId);
    }

    /**
    * Returns the video recorded ID of this chat room.
    *
    * @return the video recorded ID of this chat room
    */
    public long getVideoRecordedId() {
        return _chatRoom.getVideoRecordedId();
    }

    /**
    * Sets the video recorded ID of this chat room.
    *
    * @param videoRecordedId the video recorded ID of this chat room
    */
    public void setVideoRecordedId(long videoRecordedId) {
        _chatRoom.setVideoRecordedId(videoRecordedId);
    }

    /**
    * Returns the create date of this chat room.
    *
    * @return the create date of this chat room
    */
    public java.util.Date getCreateDate() {
        return _chatRoom.getCreateDate();
    }

    /**
    * Sets the create date of this chat room.
    *
    * @param createDate the create date of this chat room
    */
    public void setCreateDate(java.util.Date createDate) {
        _chatRoom.setCreateDate(createDate);
    }

    public boolean isNew() {
        return _chatRoom.isNew();
    }

    public void setNew(boolean n) {
        _chatRoom.setNew(n);
    }

    public boolean isCachedModel() {
        return _chatRoom.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _chatRoom.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _chatRoom.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _chatRoom.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _chatRoom.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _chatRoom.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _chatRoom.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ChatRoomWrapper((ChatRoom) _chatRoom.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom) {
        return _chatRoom.compareTo(chatRoom);
    }

    @Override
    public int hashCode() {
        return _chatRoom.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> toCacheModel() {
        return _chatRoom.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom toEscapedModel() {
        return new ChatRoomWrapper(_chatRoom.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _chatRoom.toString();
    }

    public java.lang.String toXmlString() {
        return _chatRoom.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _chatRoom.persist();
    }

    public java.lang.String getNameAsFilename() {
        return _chatRoom.getNameAsFilename();
    }

    /**
    * Verifica se a sala está aberta
    *
    * @param when
    * @return
    */
    public boolean isOpen(java.util.Date when) {
        return _chatRoom.isOpen(when);
    }

    /**
    * Altera política de abertura atualizando outras informações se for necessário
    *
    * @param newOpenPolicy
    * @param openFrom
    * @param openUntil
    */
    public void changeOpenPolicy(
        br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy newOpenPolicy,
        java.util.Date openFrom, java.util.Date openUntil) {
        _chatRoom.changeOpenPolicy(newOpenPolicy, openFrom, openUntil);
    }

    /**
    * Verifica se a sala está aberta no momento atual
    *
    * @return
    */
    public boolean isOpen() {
        return _chatRoom.isOpen();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public ChatRoom getWrappedChatRoom() {
        return _chatRoom;
    }

    public ChatRoom getWrappedModel() {
        return _chatRoom;
    }

    public void resetOriginalValues() {
        _chatRoom.resetOriginalValues();
    }
}
