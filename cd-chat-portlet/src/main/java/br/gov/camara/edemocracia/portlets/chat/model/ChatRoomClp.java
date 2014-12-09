package br.gov.camara.edemocracia.portlets.chat.model;

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ChatRoomClp extends BaseModelImpl<ChatRoom> implements ChatRoom {
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
    private BaseModel<?> _chatRoomRemoteModel;

    public ChatRoomClp() {
    }

    public Class<?> getModelClass() {
        return ChatRoom.class;
    }

    public String getModelClassName() {
        return ChatRoom.class.getName();
    }

    public long getPrimaryKey() {
        return _roomId;
    }

    public void setPrimaryKey(long primaryKey) {
        setRoomId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_roomId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public void changeOpenPolicy(
        br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy newOpenPolicy,
        java.util.Date openFrom, java.util.Date openUntil) {
        throw new UnsupportedOperationException();
    }

    public java.lang.String getNameAsFilename() {
        throw new UnsupportedOperationException();
    }

    public boolean isOpen(java.util.Date when) {
        throw new UnsupportedOperationException();
    }

    public boolean isOpen() {
        throw new UnsupportedOperationException();
    }

    public BaseModel<?> getChatRoomRemoteModel() {
        return _chatRoomRemoteModel;
    }

    public void setChatRoomRemoteModel(BaseModel<?> chatRoomRemoteModel) {
        _chatRoomRemoteModel = chatRoomRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ChatRoomLocalServiceUtil.addChatRoom(this);
        } else {
            ChatRoomLocalServiceUtil.updateChatRoom(this);
        }
    }

    @Override
    public ChatRoom toEscapedModel() {
        return (ChatRoom) Proxy.newProxyInstance(ChatRoom.class.getClassLoader(),
            new Class[] { ChatRoom.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ChatRoomClp clone = new ChatRoomClp();

        clone.setRoomId(getRoomId());
        clone.setRoomName(getRoomName());
        clone.setDescription(getDescription());
        clone.setOpenPolicy(getOpenPolicy());
        clone.setStatus(getStatus());
        clone.setOpenFrom(getOpenFrom());
        clone.setOpenUntil(getOpenUntil());
        clone.setModerated(getModerated());
        clone.setCapacity(getCapacity());
        clone.setMaxSimultaneousUsersSpying(getMaxSimultaneousUsersSpying());
        clone.setMaxSimultaneousUsers(getMaxSimultaneousUsers());
        clone.setAnonymousAllowed(getAnonymousAllowed());
        clone.setGuestId(getGuestId());
        clone.setGuestName(getGuestName());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setUsePolicyEnabled(getUsePolicyEnabled());
        clone.setUsePolicyURL(getUsePolicyURL());
        clone.setImageId(getImageId());
        clone.setVideoLiveId(getVideoLiveId());
        clone.setVideoRecordedId(getVideoRecordedId());
        clone.setCreateDate(getCreateDate());

        return clone;
    }

    public int compareTo(ChatRoom chatRoom) {
        int value = 0;

        value = DateUtil.compareTo(getCreateDate(), chatRoom.getCreateDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        if (getRoomId() < chatRoom.getRoomId()) {
            value = -1;
        } else if (getRoomId() > chatRoom.getRoomId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

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

        ChatRoomClp chatRoom = null;

        try {
            chatRoom = (ChatRoomClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = chatRoom.getPrimaryKey();

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
        StringBundler sb = new StringBundler(45);

        sb.append("{roomId=");
        sb.append(getRoomId());
        sb.append(", roomName=");
        sb.append(getRoomName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", openPolicy=");
        sb.append(getOpenPolicy());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", openFrom=");
        sb.append(getOpenFrom());
        sb.append(", openUntil=");
        sb.append(getOpenUntil());
        sb.append(", moderated=");
        sb.append(getModerated());
        sb.append(", capacity=");
        sb.append(getCapacity());
        sb.append(", maxSimultaneousUsersSpying=");
        sb.append(getMaxSimultaneousUsersSpying());
        sb.append(", maxSimultaneousUsers=");
        sb.append(getMaxSimultaneousUsers());
        sb.append(", anonymousAllowed=");
        sb.append(getAnonymousAllowed());
        sb.append(", guestId=");
        sb.append(getGuestId());
        sb.append(", guestName=");
        sb.append(getGuestName());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", usePolicyEnabled=");
        sb.append(getUsePolicyEnabled());
        sb.append(", usePolicyURL=");
        sb.append(getUsePolicyURL());
        sb.append(", imageId=");
        sb.append(getImageId());
        sb.append(", videoLiveId=");
        sb.append(getVideoLiveId());
        sb.append(", videoRecordedId=");
        sb.append(getVideoRecordedId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(70);

        sb.append("<model><model-name>");
        sb.append("br.gov.camara.edemocracia.portlets.chat.model.ChatRoom");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>roomId</column-name><column-value><![CDATA[");
        sb.append(getRoomId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>roomName</column-name><column-value><![CDATA[");
        sb.append(getRoomName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>openPolicy</column-name><column-value><![CDATA[");
        sb.append(getOpenPolicy());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>openFrom</column-name><column-value><![CDATA[");
        sb.append(getOpenFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>openUntil</column-name><column-value><![CDATA[");
        sb.append(getOpenUntil());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>moderated</column-name><column-value><![CDATA[");
        sb.append(getModerated());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>capacity</column-name><column-value><![CDATA[");
        sb.append(getCapacity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maxSimultaneousUsersSpying</column-name><column-value><![CDATA[");
        sb.append(getMaxSimultaneousUsersSpying());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maxSimultaneousUsers</column-name><column-value><![CDATA[");
        sb.append(getMaxSimultaneousUsers());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>anonymousAllowed</column-name><column-value><![CDATA[");
        sb.append(getAnonymousAllowed());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>guestId</column-name><column-value><![CDATA[");
        sb.append(getGuestId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>guestName</column-name><column-value><![CDATA[");
        sb.append(getGuestName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>usePolicyEnabled</column-name><column-value><![CDATA[");
        sb.append(getUsePolicyEnabled());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>usePolicyURL</column-name><column-value><![CDATA[");
        sb.append(getUsePolicyURL());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>imageId</column-name><column-value><![CDATA[");
        sb.append(getImageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>videoLiveId</column-name><column-value><![CDATA[");
        sb.append(getVideoLiveId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>videoRecordedId</column-name><column-value><![CDATA[");
        sb.append(getVideoRecordedId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
