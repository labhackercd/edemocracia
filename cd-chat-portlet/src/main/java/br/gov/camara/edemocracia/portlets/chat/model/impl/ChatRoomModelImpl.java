package br.gov.camara.edemocracia.portlets.chat.model.impl;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomModel;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ChatRoom service. Represents a row in the &quot;CDChat_ChatRoom&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link br.gov.camara.edemocracia.portlets.chat.model.ChatRoomModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChatRoomImpl}.
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomImpl
 * @see br.gov.camara.edemocracia.portlets.chat.model.ChatRoom
 * @see br.gov.camara.edemocracia.portlets.chat.model.ChatRoomModel
 * @generated
 */
@JSON(strict = true)
public class ChatRoomModelImpl extends BaseModelImpl<ChatRoom>
    implements ChatRoomModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a chat room model instance should use the {@link br.gov.camara.edemocracia.portlets.chat.model.ChatRoom} interface instead.
     */
    public static final String TABLE_NAME = "CDChat_ChatRoom";
    public static final Object[][] TABLE_COLUMNS = {
            { "roomId", Types.BIGINT },
            { "roomName", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "openPolicy", Types.INTEGER },
            { "status", Types.INTEGER },
            { "openFrom", Types.TIMESTAMP },
            { "openUntil", Types.TIMESTAMP },
            { "moderated", Types.BOOLEAN },
            { "capacity", Types.INTEGER },
            { "maxSimultaneousUsersSpying", Types.INTEGER },
            { "maxSimultaneousUsers", Types.INTEGER },
            { "anonymousAllowed", Types.BOOLEAN },
            { "guestId", Types.BIGINT },
            { "guestName", Types.VARCHAR },
            { "companyId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "usePolicyEnabled", Types.BOOLEAN },
            { "usePolicyURL", Types.VARCHAR },
            { "imageId", Types.BIGINT },
            { "videoLiveId", Types.BIGINT },
            { "videoRecordedId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table CDChat_ChatRoom (roomId LONG not null primary key,roomName VARCHAR(75) null,description VARCHAR(3900) null,openPolicy INTEGER,status INTEGER,openFrom DATE null,openUntil DATE null,moderated BOOLEAN,capacity INTEGER,maxSimultaneousUsersSpying INTEGER,maxSimultaneousUsers INTEGER,anonymousAllowed BOOLEAN,guestId LONG,guestName VARCHAR(75) null,companyId LONG,groupId LONG,usePolicyEnabled BOOLEAN,usePolicyURL VARCHAR(300) null,imageId LONG,videoLiveId LONG,videoRecordedId LONG,createDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table CDChat_ChatRoom";
    public static final String ORDER_BY_JPQL = " ORDER BY chatRoom.createDate DESC, chatRoom.roomId DESC";
    public static final String ORDER_BY_SQL = " ORDER BY CDChat_ChatRoom.createDate DESC, CDChat_ChatRoom.roomId DESC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.br.gov.camara.edemocracia.portlets.chat.model.ChatRoom"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.br.gov.camara.edemocracia.portlets.chat.model.ChatRoom"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.br.gov.camara.edemocracia.portlets.chat.model.ChatRoom"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long GROUPID_COLUMN_BITMASK = 2L;
    public static long ROOMNAME_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.br.gov.camara.edemocracia.portlets.chat.model.ChatRoom"));
    private static ClassLoader _classLoader = ChatRoom.class.getClassLoader();
    private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
            ChatRoom.class
        };
    private long _roomId;
    private String _roomName;
    private String _originalRoomName;
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
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private boolean _usePolicyEnabled;
    private String _usePolicyURL;
    private long _imageId;
    private long _videoLiveId;
    private long _videoRecordedId;
    private Date _createDate;
    private long _columnBitmask;
    private ChatRoom _escapedModelProxy;

    public ChatRoomModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ChatRoom toModel(ChatRoomSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ChatRoom model = new ChatRoomImpl();

        model.setRoomId(soapModel.getRoomId());
        model.setRoomName(soapModel.getRoomName());
        model.setDescription(soapModel.getDescription());
        model.setOpenPolicy(soapModel.getOpenPolicy());
        model.setStatus(soapModel.getStatus());
        model.setOpenFrom(soapModel.getOpenFrom());
        model.setOpenUntil(soapModel.getOpenUntil());
        model.setModerated(soapModel.getModerated());
        model.setCapacity(soapModel.getCapacity());
        model.setMaxSimultaneousUsersSpying(soapModel.getMaxSimultaneousUsersSpying());
        model.setMaxSimultaneousUsers(soapModel.getMaxSimultaneousUsers());
        model.setAnonymousAllowed(soapModel.getAnonymousAllowed());
        model.setGuestId(soapModel.getGuestId());
        model.setGuestName(soapModel.getGuestName());
        model.setCompanyId(soapModel.getCompanyId());
        model.setGroupId(soapModel.getGroupId());
        model.setUsePolicyEnabled(soapModel.getUsePolicyEnabled());
        model.setUsePolicyURL(soapModel.getUsePolicyURL());
        model.setImageId(soapModel.getImageId());
        model.setVideoLiveId(soapModel.getVideoLiveId());
        model.setVideoRecordedId(soapModel.getVideoRecordedId());
        model.setCreateDate(soapModel.getCreateDate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ChatRoom> toModels(ChatRoomSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ChatRoom> models = new ArrayList<ChatRoom>(soapModels.length);

        for (ChatRoomSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
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

    public Class<?> getModelClass() {
        return ChatRoom.class;
    }

    public String getModelClassName() {
        return ChatRoom.class.getName();
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

    @JSON
    public long getRoomId() {
        return _roomId;
    }

    public void setRoomId(long roomId) {
        _columnBitmask = -1L;

        _roomId = roomId;
    }

    @JSON
    public String getRoomName() {
        if (_roomName == null) {
            return StringPool.BLANK;
        } else {
            return _roomName;
        }
    }

    public void setRoomName(String roomName) {
        _columnBitmask |= ROOMNAME_COLUMN_BITMASK;

        if (_originalRoomName == null) {
            _originalRoomName = _roomName;
        }

        _roomName = roomName;
    }

    public String getOriginalRoomName() {
        return GetterUtil.getString(_originalRoomName);
    }

    @JSON
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    public void setDescription(String description) {
        _description = description;
    }

    @JSON
    public int getOpenPolicy() {
        return _openPolicy;
    }

    public void setOpenPolicy(int openPolicy) {
        _openPolicy = openPolicy;
    }

    @JSON
    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    @JSON
    public Date getOpenFrom() {
        return _openFrom;
    }

    public void setOpenFrom(Date openFrom) {
        _openFrom = openFrom;
    }

    @JSON
    public Date getOpenUntil() {
        return _openUntil;
    }

    public void setOpenUntil(Date openUntil) {
        _openUntil = openUntil;
    }

    @JSON
    public boolean getModerated() {
        return _moderated;
    }

    public boolean isModerated() {
        return _moderated;
    }

    public void setModerated(boolean moderated) {
        _moderated = moderated;
    }

    @JSON
    public int getCapacity() {
        return _capacity;
    }

    public void setCapacity(int capacity) {
        _capacity = capacity;
    }

    @JSON
    public int getMaxSimultaneousUsersSpying() {
        return _maxSimultaneousUsersSpying;
    }

    public void setMaxSimultaneousUsersSpying(int maxSimultaneousUsersSpying) {
        _maxSimultaneousUsersSpying = maxSimultaneousUsersSpying;
    }

    @JSON
    public int getMaxSimultaneousUsers() {
        return _maxSimultaneousUsers;
    }

    public void setMaxSimultaneousUsers(int maxSimultaneousUsers) {
        _maxSimultaneousUsers = maxSimultaneousUsers;
    }

    @JSON
    public boolean getAnonymousAllowed() {
        return _anonymousAllowed;
    }

    public boolean isAnonymousAllowed() {
        return _anonymousAllowed;
    }

    public void setAnonymousAllowed(boolean anonymousAllowed) {
        _anonymousAllowed = anonymousAllowed;
    }

    @JSON
    public long getGuestId() {
        return _guestId;
    }

    public void setGuestId(long guestId) {
        _guestId = guestId;
    }

    @JSON
    public String getGuestName() {
        if (_guestName == null) {
            return StringPool.BLANK;
        } else {
            return _guestName;
        }
    }

    public void setGuestName(String guestName) {
        _guestName = guestName;
    }

    @JSON
    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @JSON
    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _columnBitmask |= GROUPID_COLUMN_BITMASK;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = _groupId;
        }

        _groupId = groupId;
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
    }

    @JSON
    public boolean getUsePolicyEnabled() {
        return _usePolicyEnabled;
    }

    public boolean isUsePolicyEnabled() {
        return _usePolicyEnabled;
    }

    public void setUsePolicyEnabled(boolean usePolicyEnabled) {
        _usePolicyEnabled = usePolicyEnabled;
    }

    @JSON
    public String getUsePolicyURL() {
        if (_usePolicyURL == null) {
            return StringPool.BLANK;
        } else {
            return _usePolicyURL;
        }
    }

    public void setUsePolicyURL(String usePolicyURL) {
        _usePolicyURL = usePolicyURL;
    }

    @JSON
    public long getImageId() {
        return _imageId;
    }

    public void setImageId(long imageId) {
        _imageId = imageId;
    }

    @JSON
    public long getVideoLiveId() {
        return _videoLiveId;
    }

    public void setVideoLiveId(long videoLiveId) {
        _videoLiveId = videoLiveId;
    }

    @JSON
    public long getVideoRecordedId() {
        return _videoRecordedId;
    }

    public void setVideoRecordedId(long videoRecordedId) {
        _videoRecordedId = videoRecordedId;
    }

    @JSON
    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _columnBitmask = -1L;

        _createDate = createDate;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            ChatRoom.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public ChatRoom toEscapedModel() {
        if (_escapedModelProxy == null) {
            _escapedModelProxy = (ChatRoom) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelProxyInterfaces,
                    new AutoEscapeBeanHandler(this));
        }

        return _escapedModelProxy;
    }

    @Override
    public Object clone() {
        ChatRoomImpl chatRoomImpl = new ChatRoomImpl();

        chatRoomImpl.setRoomId(getRoomId());
        chatRoomImpl.setRoomName(getRoomName());
        chatRoomImpl.setDescription(getDescription());
        chatRoomImpl.setOpenPolicy(getOpenPolicy());
        chatRoomImpl.setStatus(getStatus());
        chatRoomImpl.setOpenFrom(getOpenFrom());
        chatRoomImpl.setOpenUntil(getOpenUntil());
        chatRoomImpl.setModerated(getModerated());
        chatRoomImpl.setCapacity(getCapacity());
        chatRoomImpl.setMaxSimultaneousUsersSpying(getMaxSimultaneousUsersSpying());
        chatRoomImpl.setMaxSimultaneousUsers(getMaxSimultaneousUsers());
        chatRoomImpl.setAnonymousAllowed(getAnonymousAllowed());
        chatRoomImpl.setGuestId(getGuestId());
        chatRoomImpl.setGuestName(getGuestName());
        chatRoomImpl.setCompanyId(getCompanyId());
        chatRoomImpl.setGroupId(getGroupId());
        chatRoomImpl.setUsePolicyEnabled(getUsePolicyEnabled());
        chatRoomImpl.setUsePolicyURL(getUsePolicyURL());
        chatRoomImpl.setImageId(getImageId());
        chatRoomImpl.setVideoLiveId(getVideoLiveId());
        chatRoomImpl.setVideoRecordedId(getVideoRecordedId());
        chatRoomImpl.setCreateDate(getCreateDate());

        chatRoomImpl.resetOriginalValues();

        return chatRoomImpl;
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

        ChatRoom chatRoom = null;

        try {
            chatRoom = (ChatRoom) obj;
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
    public void resetOriginalValues() {
        ChatRoomModelImpl chatRoomModelImpl = this;

        chatRoomModelImpl._originalRoomName = chatRoomModelImpl._roomName;

        chatRoomModelImpl._originalCompanyId = chatRoomModelImpl._companyId;

        chatRoomModelImpl._setOriginalCompanyId = false;

        chatRoomModelImpl._originalGroupId = chatRoomModelImpl._groupId;

        chatRoomModelImpl._setOriginalGroupId = false;

        chatRoomModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ChatRoom> toCacheModel() {
        ChatRoomCacheModel chatRoomCacheModel = new ChatRoomCacheModel();

        chatRoomCacheModel.roomId = getRoomId();

        chatRoomCacheModel.roomName = getRoomName();

        String roomName = chatRoomCacheModel.roomName;

        if ((roomName != null) && (roomName.length() == 0)) {
            chatRoomCacheModel.roomName = null;
        }

        chatRoomCacheModel.description = getDescription();

        String description = chatRoomCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            chatRoomCacheModel.description = null;
        }

        chatRoomCacheModel.openPolicy = getOpenPolicy();

        chatRoomCacheModel.status = getStatus();

        Date openFrom = getOpenFrom();

        if (openFrom != null) {
            chatRoomCacheModel.openFrom = openFrom.getTime();
        } else {
            chatRoomCacheModel.openFrom = Long.MIN_VALUE;
        }

        Date openUntil = getOpenUntil();

        if (openUntil != null) {
            chatRoomCacheModel.openUntil = openUntil.getTime();
        } else {
            chatRoomCacheModel.openUntil = Long.MIN_VALUE;
        }

        chatRoomCacheModel.moderated = getModerated();

        chatRoomCacheModel.capacity = getCapacity();

        chatRoomCacheModel.maxSimultaneousUsersSpying = getMaxSimultaneousUsersSpying();

        chatRoomCacheModel.maxSimultaneousUsers = getMaxSimultaneousUsers();

        chatRoomCacheModel.anonymousAllowed = getAnonymousAllowed();

        chatRoomCacheModel.guestId = getGuestId();

        chatRoomCacheModel.guestName = getGuestName();

        String guestName = chatRoomCacheModel.guestName;

        if ((guestName != null) && (guestName.length() == 0)) {
            chatRoomCacheModel.guestName = null;
        }

        chatRoomCacheModel.companyId = getCompanyId();

        chatRoomCacheModel.groupId = getGroupId();

        chatRoomCacheModel.usePolicyEnabled = getUsePolicyEnabled();

        chatRoomCacheModel.usePolicyURL = getUsePolicyURL();

        String usePolicyURL = chatRoomCacheModel.usePolicyURL;

        if ((usePolicyURL != null) && (usePolicyURL.length() == 0)) {
            chatRoomCacheModel.usePolicyURL = null;
        }

        chatRoomCacheModel.imageId = getImageId();

        chatRoomCacheModel.videoLiveId = getVideoLiveId();

        chatRoomCacheModel.videoRecordedId = getVideoRecordedId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            chatRoomCacheModel.createDate = createDate.getTime();
        } else {
            chatRoomCacheModel.createDate = Long.MIN_VALUE;
        }

        return chatRoomCacheModel;
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