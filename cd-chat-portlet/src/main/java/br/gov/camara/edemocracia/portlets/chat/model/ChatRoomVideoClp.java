package br.gov.camara.edemocracia.portlets.chat.model;

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomVideoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class ChatRoomVideoClp extends BaseModelImpl<ChatRoomVideo>
    implements ChatRoomVideo {
    private long _videoId;
    private String _videoTitle;
    private String _videoSubtitle;
    private String _videoDescription;
    private boolean _videoEnabled;
    private String _videoUrl;
    private String _videoType;
    private BaseModel<?> _chatRoomVideoRemoteModel;

    public ChatRoomVideoClp() {
    }

    public Class<?> getModelClass() {
        return ChatRoomVideo.class;
    }

    public String getModelClassName() {
        return ChatRoomVideo.class.getName();
    }

    public long getPrimaryKey() {
        return _videoId;
    }

    public void setPrimaryKey(long primaryKey) {
        setVideoId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_videoId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("videoId", getVideoId());
        attributes.put("videoTitle", getVideoTitle());
        attributes.put("videoSubtitle", getVideoSubtitle());
        attributes.put("videoDescription", getVideoDescription());
        attributes.put("videoEnabled", getVideoEnabled());
        attributes.put("videoUrl", getVideoUrl());
        attributes.put("videoType", getVideoType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long videoId = (Long) attributes.get("videoId");

        if (videoId != null) {
            setVideoId(videoId);
        }

        String videoTitle = (String) attributes.get("videoTitle");

        if (videoTitle != null) {
            setVideoTitle(videoTitle);
        }

        String videoSubtitle = (String) attributes.get("videoSubtitle");

        if (videoSubtitle != null) {
            setVideoSubtitle(videoSubtitle);
        }

        String videoDescription = (String) attributes.get("videoDescription");

        if (videoDescription != null) {
            setVideoDescription(videoDescription);
        }

        Boolean videoEnabled = (Boolean) attributes.get("videoEnabled");

        if (videoEnabled != null) {
            setVideoEnabled(videoEnabled);
        }

        String videoUrl = (String) attributes.get("videoUrl");

        if (videoUrl != null) {
            setVideoUrl(videoUrl);
        }

        String videoType = (String) attributes.get("videoType");

        if (videoType != null) {
            setVideoType(videoType);
        }
    }

    public long getVideoId() {
        return _videoId;
    }

    public void setVideoId(long videoId) {
        _videoId = videoId;
    }

    public String getVideoTitle() {
        return _videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        _videoTitle = videoTitle;
    }

    public String getVideoSubtitle() {
        return _videoSubtitle;
    }

    public void setVideoSubtitle(String videoSubtitle) {
        _videoSubtitle = videoSubtitle;
    }

    public String getVideoDescription() {
        return _videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        _videoDescription = videoDescription;
    }

    public boolean getVideoEnabled() {
        return _videoEnabled;
    }

    public boolean isVideoEnabled() {
        return _videoEnabled;
    }

    public void setVideoEnabled(boolean videoEnabled) {
        _videoEnabled = videoEnabled;
    }

    public String getVideoUrl() {
        return _videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        _videoUrl = videoUrl;
    }

    public String getVideoType() {
        return _videoType;
    }

    public void setVideoType(String videoType) {
        _videoType = videoType;
    }

    public java.lang.String montaLinkStreamingVideo(
        java.lang.String nomPontoAlta) {
        throw new UnsupportedOperationException();
    }

    public java.lang.String getVideoLinkAoVivo() {
        throw new UnsupportedOperationException();
    }

    public BaseModel<?> getChatRoomVideoRemoteModel() {
        return _chatRoomVideoRemoteModel;
    }

    public void setChatRoomVideoRemoteModel(
        BaseModel<?> chatRoomVideoRemoteModel) {
        _chatRoomVideoRemoteModel = chatRoomVideoRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ChatRoomVideoLocalServiceUtil.addChatRoomVideo(this);
        } else {
            ChatRoomVideoLocalServiceUtil.updateChatRoomVideo(this);
        }
    }

    @Override
    public ChatRoomVideo toEscapedModel() {
        return (ChatRoomVideo) Proxy.newProxyInstance(ChatRoomVideo.class.getClassLoader(),
            new Class[] { ChatRoomVideo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ChatRoomVideoClp clone = new ChatRoomVideoClp();

        clone.setVideoId(getVideoId());
        clone.setVideoTitle(getVideoTitle());
        clone.setVideoSubtitle(getVideoSubtitle());
        clone.setVideoDescription(getVideoDescription());
        clone.setVideoEnabled(getVideoEnabled());
        clone.setVideoUrl(getVideoUrl());
        clone.setVideoType(getVideoType());

        return clone;
    }

    public int compareTo(ChatRoomVideo chatRoomVideo) {
        long primaryKey = chatRoomVideo.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ChatRoomVideoClp chatRoomVideo = null;

        try {
            chatRoomVideo = (ChatRoomVideoClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = chatRoomVideo.getPrimaryKey();

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
        StringBundler sb = new StringBundler(15);

        sb.append("{videoId=");
        sb.append(getVideoId());
        sb.append(", videoTitle=");
        sb.append(getVideoTitle());
        sb.append(", videoSubtitle=");
        sb.append(getVideoSubtitle());
        sb.append(", videoDescription=");
        sb.append(getVideoDescription());
        sb.append(", videoEnabled=");
        sb.append(getVideoEnabled());
        sb.append(", videoUrl=");
        sb.append(getVideoUrl());
        sb.append(", videoType=");
        sb.append(getVideoType());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>videoId</column-name><column-value><![CDATA[");
        sb.append(getVideoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>videoTitle</column-name><column-value><![CDATA[");
        sb.append(getVideoTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>videoSubtitle</column-name><column-value><![CDATA[");
        sb.append(getVideoSubtitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>videoDescription</column-name><column-value><![CDATA[");
        sb.append(getVideoDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>videoEnabled</column-name><column-value><![CDATA[");
        sb.append(getVideoEnabled());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>videoUrl</column-name><column-value><![CDATA[");
        sb.append(getVideoUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>videoType</column-name><column-value><![CDATA[");
        sb.append(getVideoType());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
