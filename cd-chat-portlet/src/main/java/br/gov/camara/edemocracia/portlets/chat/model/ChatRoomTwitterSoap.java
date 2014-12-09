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
public class ChatRoomTwitterSoap implements Serializable {
    private long _twitterId;
    private String _twitterTitle;
    private String _twitterDescription;
    private boolean _twitterEnabled;
    private String _twitterHashtag;
    private String _twitterDataWidgetId;

    public ChatRoomTwitterSoap() {
    }

    public static ChatRoomTwitterSoap toSoapModel(ChatRoomTwitter model) {
        ChatRoomTwitterSoap soapModel = new ChatRoomTwitterSoap();

        soapModel.setTwitterId(model.getTwitterId());
        soapModel.setTwitterTitle(model.getTwitterTitle());
        soapModel.setTwitterDescription(model.getTwitterDescription());
        soapModel.setTwitterEnabled(model.getTwitterEnabled());
        soapModel.setTwitterHashtag(model.getTwitterHashtag());
        soapModel.setTwitterDataWidgetId(model.getTwitterDataWidgetId());

        return soapModel;
    }

    public static ChatRoomTwitterSoap[] toSoapModels(ChatRoomTwitter[] models) {
        ChatRoomTwitterSoap[] soapModels = new ChatRoomTwitterSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ChatRoomTwitterSoap[][] toSoapModels(
        ChatRoomTwitter[][] models) {
        ChatRoomTwitterSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ChatRoomTwitterSoap[models.length][models[0].length];
        } else {
            soapModels = new ChatRoomTwitterSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ChatRoomTwitterSoap[] toSoapModels(
        List<ChatRoomTwitter> models) {
        List<ChatRoomTwitterSoap> soapModels = new ArrayList<ChatRoomTwitterSoap>(models.size());

        for (ChatRoomTwitter model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ChatRoomTwitterSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _twitterId;
    }

    public void setPrimaryKey(long pk) {
        setTwitterId(pk);
    }

    public long getTwitterId() {
        return _twitterId;
    }

    public void setTwitterId(long twitterId) {
        _twitterId = twitterId;
    }

    public String getTwitterTitle() {
        return _twitterTitle;
    }

    public void setTwitterTitle(String twitterTitle) {
        _twitterTitle = twitterTitle;
    }

    public String getTwitterDescription() {
        return _twitterDescription;
    }

    public void setTwitterDescription(String twitterDescription) {
        _twitterDescription = twitterDescription;
    }

    public boolean getTwitterEnabled() {
        return _twitterEnabled;
    }

    public boolean isTwitterEnabled() {
        return _twitterEnabled;
    }

    public void setTwitterEnabled(boolean twitterEnabled) {
        _twitterEnabled = twitterEnabled;
    }

    public String getTwitterHashtag() {
        return _twitterHashtag;
    }

    public void setTwitterHashtag(String twitterHashtag) {
        _twitterHashtag = twitterHashtag;
    }

    public String getTwitterDataWidgetId() {
        return _twitterDataWidgetId;
    }

    public void setTwitterDataWidgetId(String twitterDataWidgetId) {
        _twitterDataWidgetId = twitterDataWidgetId;
    }
}
