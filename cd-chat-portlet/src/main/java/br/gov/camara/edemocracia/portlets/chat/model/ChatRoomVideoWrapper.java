package br.gov.camara.edemocracia.portlets.chat.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChatRoomVideo}.
 * </p>
 *
 * @author    Ricardo Lima
 * @see       ChatRoomVideo
 * @generated
 */
public class ChatRoomVideoWrapper implements ChatRoomVideo,
    ModelWrapper<ChatRoomVideo> {
    private ChatRoomVideo _chatRoomVideo;

    public ChatRoomVideoWrapper(ChatRoomVideo chatRoomVideo) {
        _chatRoomVideo = chatRoomVideo;
    }

    public Class<?> getModelClass() {
        return ChatRoomVideo.class;
    }

    public String getModelClassName() {
        return ChatRoomVideo.class.getName();
    }

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

    /**
    * Returns the primary key of this chat room video.
    *
    * @return the primary key of this chat room video
    */
    public long getPrimaryKey() {
        return _chatRoomVideo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this chat room video.
    *
    * @param primaryKey the primary key of this chat room video
    */
    public void setPrimaryKey(long primaryKey) {
        _chatRoomVideo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the video ID of this chat room video.
    *
    * @return the video ID of this chat room video
    */
    public long getVideoId() {
        return _chatRoomVideo.getVideoId();
    }

    /**
    * Sets the video ID of this chat room video.
    *
    * @param videoId the video ID of this chat room video
    */
    public void setVideoId(long videoId) {
        _chatRoomVideo.setVideoId(videoId);
    }

    /**
    * Returns the video title of this chat room video.
    *
    * @return the video title of this chat room video
    */
    public java.lang.String getVideoTitle() {
        return _chatRoomVideo.getVideoTitle();
    }

    /**
    * Sets the video title of this chat room video.
    *
    * @param videoTitle the video title of this chat room video
    */
    public void setVideoTitle(java.lang.String videoTitle) {
        _chatRoomVideo.setVideoTitle(videoTitle);
    }

    /**
    * Returns the video subtitle of this chat room video.
    *
    * @return the video subtitle of this chat room video
    */
    public java.lang.String getVideoSubtitle() {
        return _chatRoomVideo.getVideoSubtitle();
    }

    /**
    * Sets the video subtitle of this chat room video.
    *
    * @param videoSubtitle the video subtitle of this chat room video
    */
    public void setVideoSubtitle(java.lang.String videoSubtitle) {
        _chatRoomVideo.setVideoSubtitle(videoSubtitle);
    }

    /**
    * Returns the video description of this chat room video.
    *
    * @return the video description of this chat room video
    */
    public java.lang.String getVideoDescription() {
        return _chatRoomVideo.getVideoDescription();
    }

    /**
    * Sets the video description of this chat room video.
    *
    * @param videoDescription the video description of this chat room video
    */
    public void setVideoDescription(java.lang.String videoDescription) {
        _chatRoomVideo.setVideoDescription(videoDescription);
    }

    /**
    * Returns the video enabled of this chat room video.
    *
    * @return the video enabled of this chat room video
    */
    public boolean getVideoEnabled() {
        return _chatRoomVideo.getVideoEnabled();
    }

    /**
    * Returns <code>true</code> if this chat room video is video enabled.
    *
    * @return <code>true</code> if this chat room video is video enabled; <code>false</code> otherwise
    */
    public boolean isVideoEnabled() {
        return _chatRoomVideo.isVideoEnabled();
    }

    /**
    * Sets whether this chat room video is video enabled.
    *
    * @param videoEnabled the video enabled of this chat room video
    */
    public void setVideoEnabled(boolean videoEnabled) {
        _chatRoomVideo.setVideoEnabled(videoEnabled);
    }

    /**
    * Returns the video url of this chat room video.
    *
    * @return the video url of this chat room video
    */
    public java.lang.String getVideoUrl() {
        return _chatRoomVideo.getVideoUrl();
    }

    /**
    * Sets the video url of this chat room video.
    *
    * @param videoUrl the video url of this chat room video
    */
    public void setVideoUrl(java.lang.String videoUrl) {
        _chatRoomVideo.setVideoUrl(videoUrl);
    }

    /**
    * Returns the video type of this chat room video.
    *
    * @return the video type of this chat room video
    */
    public java.lang.String getVideoType() {
        return _chatRoomVideo.getVideoType();
    }

    /**
    * Sets the video type of this chat room video.
    *
    * @param videoType the video type of this chat room video
    */
    public void setVideoType(java.lang.String videoType) {
        _chatRoomVideo.setVideoType(videoType);
    }

    public boolean isNew() {
        return _chatRoomVideo.isNew();
    }

    public void setNew(boolean n) {
        _chatRoomVideo.setNew(n);
    }

    public boolean isCachedModel() {
        return _chatRoomVideo.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _chatRoomVideo.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _chatRoomVideo.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _chatRoomVideo.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _chatRoomVideo.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _chatRoomVideo.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _chatRoomVideo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ChatRoomVideoWrapper((ChatRoomVideo) _chatRoomVideo.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo) {
        return _chatRoomVideo.compareTo(chatRoomVideo);
    }

    @Override
    public int hashCode() {
        return _chatRoomVideo.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo> toCacheModel() {
        return _chatRoomVideo.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo toEscapedModel() {
        return new ChatRoomVideoWrapper(_chatRoomVideo.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _chatRoomVideo.toString();
    }

    public java.lang.String toXmlString() {
        return _chatRoomVideo.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _chatRoomVideo.persist();
    }

    /**
    * Retorna o link de streaming do video do webcamara
    *
    * @param nomPontoAlta - quando o video do chat é configurado para webcamara, o dado que identifica o canal (nomPontoAlta) é guardado no campo videoURL
    * @return
    */
    public java.lang.String montaLinkStreamingVideo(
        java.lang.String nomPontoAlta) {
        return _chatRoomVideo.montaLinkStreamingVideo(nomPontoAlta);
    }

    /**
    * Retorna o link do vídeo
    *
    * Se for webcamara, retornará o link do streaming já montado
    *
    * @return
    */
    public java.lang.String getVideoLinkAoVivo() {
        return _chatRoomVideo.getVideoLinkAoVivo();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public ChatRoomVideo getWrappedChatRoomVideo() {
        return _chatRoomVideo;
    }

    public ChatRoomVideo getWrappedModel() {
        return _chatRoomVideo;
    }

    public void resetOriginalValues() {
        _chatRoomVideo.resetOriginalValues();
    }
}
