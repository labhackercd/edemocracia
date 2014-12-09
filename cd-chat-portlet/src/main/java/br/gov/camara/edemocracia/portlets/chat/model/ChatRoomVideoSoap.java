package br.gov.camara.edemocracia.portlets.chat.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Ricardo Lima
 * @generated
 */
public class ChatRoomVideoSoap implements Serializable {
    private long _videoId;
    private String _videoTitle;
    private String _videoSubtitle;
    private String _videoDescription;
    private boolean _videoEnabled;
    private String _videoUrl;
    private String _videoType;

    public ChatRoomVideoSoap() {
    }

    public static ChatRoomVideoSoap toSoapModel(ChatRoomVideo model) {
        ChatRoomVideoSoap soapModel = new ChatRoomVideoSoap();

        soapModel.setVideoId(model.getVideoId());
        soapModel.setVideoTitle(model.getVideoTitle());
        soapModel.setVideoSubtitle(model.getVideoSubtitle());
        soapModel.setVideoDescription(model.getVideoDescription());
        soapModel.setVideoEnabled(model.getVideoEnabled());
        soapModel.setVideoUrl(model.getVideoUrl());
        soapModel.setVideoType(model.getVideoType());

        return soapModel;
    }

    public static ChatRoomVideoSoap[] toSoapModels(ChatRoomVideo[] models) {
        ChatRoomVideoSoap[] soapModels = new ChatRoomVideoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ChatRoomVideoSoap[][] toSoapModels(ChatRoomVideo[][] models) {
        ChatRoomVideoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ChatRoomVideoSoap[models.length][models[0].length];
        } else {
            soapModels = new ChatRoomVideoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ChatRoomVideoSoap[] toSoapModels(List<ChatRoomVideo> models) {
        List<ChatRoomVideoSoap> soapModels = new ArrayList<ChatRoomVideoSoap>(models.size());

        for (ChatRoomVideo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ChatRoomVideoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _videoId;
    }

    public void setPrimaryKey(long pk) {
        setVideoId(pk);
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
}
