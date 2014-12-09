package br.gov.camara.edemocracia.portlets.chat.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChatRoomTwitter}.
 * </p>
 *
 * @author    Ricardo Lima
 * @see       ChatRoomTwitter
 * @generated
 */
public class ChatRoomTwitterWrapper implements ChatRoomTwitter,
    ModelWrapper<ChatRoomTwitter> {
    private ChatRoomTwitter _chatRoomTwitter;

    public ChatRoomTwitterWrapper(ChatRoomTwitter chatRoomTwitter) {
        _chatRoomTwitter = chatRoomTwitter;
    }

    public Class<?> getModelClass() {
        return ChatRoomTwitter.class;
    }

    public String getModelClassName() {
        return ChatRoomTwitter.class.getName();
    }

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

    /**
    * Returns the primary key of this chat room twitter.
    *
    * @return the primary key of this chat room twitter
    */
    public long getPrimaryKey() {
        return _chatRoomTwitter.getPrimaryKey();
    }

    /**
    * Sets the primary key of this chat room twitter.
    *
    * @param primaryKey the primary key of this chat room twitter
    */
    public void setPrimaryKey(long primaryKey) {
        _chatRoomTwitter.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the twitter ID of this chat room twitter.
    *
    * @return the twitter ID of this chat room twitter
    */
    public long getTwitterId() {
        return _chatRoomTwitter.getTwitterId();
    }

    /**
    * Sets the twitter ID of this chat room twitter.
    *
    * @param twitterId the twitter ID of this chat room twitter
    */
    public void setTwitterId(long twitterId) {
        _chatRoomTwitter.setTwitterId(twitterId);
    }

    /**
    * Returns the twitter title of this chat room twitter.
    *
    * @return the twitter title of this chat room twitter
    */
    public java.lang.String getTwitterTitle() {
        return _chatRoomTwitter.getTwitterTitle();
    }

    /**
    * Sets the twitter title of this chat room twitter.
    *
    * @param twitterTitle the twitter title of this chat room twitter
    */
    public void setTwitterTitle(java.lang.String twitterTitle) {
        _chatRoomTwitter.setTwitterTitle(twitterTitle);
    }

    /**
    * Returns the twitter description of this chat room twitter.
    *
    * @return the twitter description of this chat room twitter
    */
    public java.lang.String getTwitterDescription() {
        return _chatRoomTwitter.getTwitterDescription();
    }

    /**
    * Sets the twitter description of this chat room twitter.
    *
    * @param twitterDescription the twitter description of this chat room twitter
    */
    public void setTwitterDescription(java.lang.String twitterDescription) {
        _chatRoomTwitter.setTwitterDescription(twitterDescription);
    }

    /**
    * Returns the twitter enabled of this chat room twitter.
    *
    * @return the twitter enabled of this chat room twitter
    */
    public boolean getTwitterEnabled() {
        return _chatRoomTwitter.getTwitterEnabled();
    }

    /**
    * Returns <code>true</code> if this chat room twitter is twitter enabled.
    *
    * @return <code>true</code> if this chat room twitter is twitter enabled; <code>false</code> otherwise
    */
    public boolean isTwitterEnabled() {
        return _chatRoomTwitter.isTwitterEnabled();
    }

    /**
    * Sets whether this chat room twitter is twitter enabled.
    *
    * @param twitterEnabled the twitter enabled of this chat room twitter
    */
    public void setTwitterEnabled(boolean twitterEnabled) {
        _chatRoomTwitter.setTwitterEnabled(twitterEnabled);
    }

    /**
    * Returns the twitter hashtag of this chat room twitter.
    *
    * @return the twitter hashtag of this chat room twitter
    */
    public java.lang.String getTwitterHashtag() {
        return _chatRoomTwitter.getTwitterHashtag();
    }

    /**
    * Sets the twitter hashtag of this chat room twitter.
    *
    * @param twitterHashtag the twitter hashtag of this chat room twitter
    */
    public void setTwitterHashtag(java.lang.String twitterHashtag) {
        _chatRoomTwitter.setTwitterHashtag(twitterHashtag);
    }

    /**
    * Returns the twitter data widget ID of this chat room twitter.
    *
    * @return the twitter data widget ID of this chat room twitter
    */
    public java.lang.String getTwitterDataWidgetId() {
        return _chatRoomTwitter.getTwitterDataWidgetId();
    }

    /**
    * Sets the twitter data widget ID of this chat room twitter.
    *
    * @param twitterDataWidgetId the twitter data widget ID of this chat room twitter
    */
    public void setTwitterDataWidgetId(java.lang.String twitterDataWidgetId) {
        _chatRoomTwitter.setTwitterDataWidgetId(twitterDataWidgetId);
    }

    public boolean isNew() {
        return _chatRoomTwitter.isNew();
    }

    public void setNew(boolean n) {
        _chatRoomTwitter.setNew(n);
    }

    public boolean isCachedModel() {
        return _chatRoomTwitter.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _chatRoomTwitter.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _chatRoomTwitter.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _chatRoomTwitter.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _chatRoomTwitter.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _chatRoomTwitter.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _chatRoomTwitter.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ChatRoomTwitterWrapper((ChatRoomTwitter) _chatRoomTwitter.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter chatRoomTwitter) {
        return _chatRoomTwitter.compareTo(chatRoomTwitter);
    }

    @Override
    public int hashCode() {
        return _chatRoomTwitter.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter> toCacheModel() {
        return _chatRoomTwitter.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter toEscapedModel() {
        return new ChatRoomTwitterWrapper(_chatRoomTwitter.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _chatRoomTwitter.toString();
    }

    public java.lang.String toXmlString() {
        return _chatRoomTwitter.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _chatRoomTwitter.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public ChatRoomTwitter getWrappedChatRoomTwitter() {
        return _chatRoomTwitter;
    }

    public ChatRoomTwitter getWrappedModel() {
        return _chatRoomTwitter;
    }

    public void resetOriginalValues() {
        _chatRoomTwitter.resetOriginalValues();
    }
}
