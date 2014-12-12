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

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomTwitterLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class ChatRoomTwitterClp extends BaseModelImpl<ChatRoomTwitter>
    implements ChatRoomTwitter {
    private long _twitterId;
    private String _twitterTitle;
    private String _twitterDescription;
    private boolean _twitterEnabled;
    private String _twitterHashtag;
    private String _twitterDataWidgetId;
    private BaseModel<?> _chatRoomTwitterRemoteModel;

    public ChatRoomTwitterClp() {
    }

    public Class<?> getModelClass() {
        return ChatRoomTwitter.class;
    }

    public String getModelClassName() {
        return ChatRoomTwitter.class.getName();
    }

    public long getPrimaryKey() {
        return _twitterId;
    }

    public void setPrimaryKey(long primaryKey) {
        setTwitterId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_twitterId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("twitterId", getTwitterId());
        attributes.put("twitterTitle", getTwitterTitle());
        attributes.put("twitterDescription", getTwitterDescription());
        attributes.put("twitterEnabled", getTwitterEnabled());
        attributes.put("twitterHashtag", getTwitterHashtag());
        attributes.put("twitterDataWidgetId", getTwitterDataWidgetId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long twitterId = (Long) attributes.get("twitterId");

        if (twitterId != null) {
            setTwitterId(twitterId);
        }

        String twitterTitle = (String) attributes.get("twitterTitle");

        if (twitterTitle != null) {
            setTwitterTitle(twitterTitle);
        }

        String twitterDescription = (String) attributes.get(
                "twitterDescription");

        if (twitterDescription != null) {
            setTwitterDescription(twitterDescription);
        }

        Boolean twitterEnabled = (Boolean) attributes.get("twitterEnabled");

        if (twitterEnabled != null) {
            setTwitterEnabled(twitterEnabled);
        }

        String twitterHashtag = (String) attributes.get("twitterHashtag");

        if (twitterHashtag != null) {
            setTwitterHashtag(twitterHashtag);
        }

        String twitterDataWidgetId = (String) attributes.get(
                "twitterDataWidgetId");

        if (twitterDataWidgetId != null) {
            setTwitterDataWidgetId(twitterDataWidgetId);
        }
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

    public BaseModel<?> getChatRoomTwitterRemoteModel() {
        return _chatRoomTwitterRemoteModel;
    }

    public void setChatRoomTwitterRemoteModel(
        BaseModel<?> chatRoomTwitterRemoteModel) {
        _chatRoomTwitterRemoteModel = chatRoomTwitterRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ChatRoomTwitterLocalServiceUtil.addChatRoomTwitter(this);
        } else {
            ChatRoomTwitterLocalServiceUtil.updateChatRoomTwitter(this);
        }
    }

    @Override
    public ChatRoomTwitter toEscapedModel() {
        return (ChatRoomTwitter) Proxy.newProxyInstance(ChatRoomTwitter.class.getClassLoader(),
            new Class[] { ChatRoomTwitter.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ChatRoomTwitterClp clone = new ChatRoomTwitterClp();

        clone.setTwitterId(getTwitterId());
        clone.setTwitterTitle(getTwitterTitle());
        clone.setTwitterDescription(getTwitterDescription());
        clone.setTwitterEnabled(getTwitterEnabled());
        clone.setTwitterHashtag(getTwitterHashtag());
        clone.setTwitterDataWidgetId(getTwitterDataWidgetId());

        return clone;
    }

    public int compareTo(ChatRoomTwitter chatRoomTwitter) {
        long primaryKey = chatRoomTwitter.getPrimaryKey();

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

        ChatRoomTwitterClp chatRoomTwitter = null;

        try {
            chatRoomTwitter = (ChatRoomTwitterClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = chatRoomTwitter.getPrimaryKey();

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
        StringBundler sb = new StringBundler(13);

        sb.append("{twitterId=");
        sb.append(getTwitterId());
        sb.append(", twitterTitle=");
        sb.append(getTwitterTitle());
        sb.append(", twitterDescription=");
        sb.append(getTwitterDescription());
        sb.append(", twitterEnabled=");
        sb.append(getTwitterEnabled());
        sb.append(", twitterHashtag=");
        sb.append(getTwitterHashtag());
        sb.append(", twitterDataWidgetId=");
        sb.append(getTwitterDataWidgetId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>twitterId</column-name><column-value><![CDATA[");
        sb.append(getTwitterId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>twitterTitle</column-name><column-value><![CDATA[");
        sb.append(getTwitterTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>twitterDescription</column-name><column-value><![CDATA[");
        sb.append(getTwitterDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>twitterEnabled</column-name><column-value><![CDATA[");
        sb.append(getTwitterEnabled());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>twitterHashtag</column-name><column-value><![CDATA[");
        sb.append(getTwitterHashtag());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>twitterDataWidgetId</column-name><column-value><![CDATA[");
        sb.append(getTwitterDataWidgetId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
