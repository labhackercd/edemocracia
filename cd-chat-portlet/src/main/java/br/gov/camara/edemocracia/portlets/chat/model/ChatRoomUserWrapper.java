package br.gov.camara.edemocracia.portlets.chat.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChatRoomUser}.
 * </p>
 *
 * @author    Ricardo Lima
 * @see       ChatRoomUser
 * @generated
 */
public class ChatRoomUserWrapper implements ChatRoomUser,
    ModelWrapper<ChatRoomUser> {
    private ChatRoomUser _chatRoomUser;

    public ChatRoomUserWrapper(ChatRoomUser chatRoomUser) {
        _chatRoomUser = chatRoomUser;
    }

    public Class<?> getModelClass() {
        return ChatRoomUser.class;
    }

    public String getModelClassName() {
        return ChatRoomUser.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("chatUserId", getChatUserId());
        attributes.put("chatRoomId", getChatRoomId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("userImgId", getUserImgId());
        attributes.put("userUF", getUserUF());
        attributes.put("userEmail", getUserEmail());
        attributes.put("banned", getBanned());
        attributes.put("userType", getUserType());
        attributes.put("joinedTS", getJoinedTS());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long chatUserId = (Long) attributes.get("chatUserId");

        if (chatUserId != null) {
            setChatUserId(chatUserId);
        }

        Long chatRoomId = (Long) attributes.get("chatRoomId");

        if (chatRoomId != null) {
            setChatRoomId(chatRoomId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Long userImgId = (Long) attributes.get("userImgId");

        if (userImgId != null) {
            setUserImgId(userImgId);
        }

        Long userUF = (Long) attributes.get("userUF");

        if (userUF != null) {
            setUserUF(userUF);
        }

        String userEmail = (String) attributes.get("userEmail");

        if (userEmail != null) {
            setUserEmail(userEmail);
        }

        Boolean banned = (Boolean) attributes.get("banned");

        if (banned != null) {
            setBanned(banned);
        }

        Integer userType = (Integer) attributes.get("userType");

        if (userType != null) {
            setUserType(userType);
        }

        Date joinedTS = (Date) attributes.get("joinedTS");

        if (joinedTS != null) {
            setJoinedTS(joinedTS);
        }
    }

    /**
    * Returns the primary key of this chat room user.
    *
    * @return the primary key of this chat room user
    */
    public long getPrimaryKey() {
        return _chatRoomUser.getPrimaryKey();
    }

    /**
    * Sets the primary key of this chat room user.
    *
    * @param primaryKey the primary key of this chat room user
    */
    public void setPrimaryKey(long primaryKey) {
        _chatRoomUser.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the chat user ID of this chat room user.
    *
    * @return the chat user ID of this chat room user
    */
    public long getChatUserId() {
        return _chatRoomUser.getChatUserId();
    }

    /**
    * Sets the chat user ID of this chat room user.
    *
    * @param chatUserId the chat user ID of this chat room user
    */
    public void setChatUserId(long chatUserId) {
        _chatRoomUser.setChatUserId(chatUserId);
    }

    /**
    * Returns the chat user uuid of this chat room user.
    *
    * @return the chat user uuid of this chat room user
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getChatUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUser.getChatUserUuid();
    }

    /**
    * Sets the chat user uuid of this chat room user.
    *
    * @param chatUserUuid the chat user uuid of this chat room user
    */
    public void setChatUserUuid(java.lang.String chatUserUuid) {
        _chatRoomUser.setChatUserUuid(chatUserUuid);
    }

    /**
    * Returns the chat room ID of this chat room user.
    *
    * @return the chat room ID of this chat room user
    */
    public long getChatRoomId() {
        return _chatRoomUser.getChatRoomId();
    }

    /**
    * Sets the chat room ID of this chat room user.
    *
    * @param chatRoomId the chat room ID of this chat room user
    */
    public void setChatRoomId(long chatRoomId) {
        _chatRoomUser.setChatRoomId(chatRoomId);
    }

    /**
    * Returns the user ID of this chat room user.
    *
    * @return the user ID of this chat room user
    */
    public long getUserId() {
        return _chatRoomUser.getUserId();
    }

    /**
    * Sets the user ID of this chat room user.
    *
    * @param userId the user ID of this chat room user
    */
    public void setUserId(long userId) {
        _chatRoomUser.setUserId(userId);
    }

    /**
    * Returns the user uuid of this chat room user.
    *
    * @return the user uuid of this chat room user
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUser.getUserUuid();
    }

    /**
    * Sets the user uuid of this chat room user.
    *
    * @param userUuid the user uuid of this chat room user
    */
    public void setUserUuid(java.lang.String userUuid) {
        _chatRoomUser.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this chat room user.
    *
    * @return the user name of this chat room user
    */
    public java.lang.String getUserName() {
        return _chatRoomUser.getUserName();
    }

    /**
    * Sets the user name of this chat room user.
    *
    * @param userName the user name of this chat room user
    */
    public void setUserName(java.lang.String userName) {
        _chatRoomUser.setUserName(userName);
    }

    /**
    * Returns the user img ID of this chat room user.
    *
    * @return the user img ID of this chat room user
    */
    public long getUserImgId() {
        return _chatRoomUser.getUserImgId();
    }

    /**
    * Sets the user img ID of this chat room user.
    *
    * @param userImgId the user img ID of this chat room user
    */
    public void setUserImgId(long userImgId) {
        _chatRoomUser.setUserImgId(userImgId);
    }

    /**
    * Returns the user u f of this chat room user.
    *
    * @return the user u f of this chat room user
    */
    public long getUserUF() {
        return _chatRoomUser.getUserUF();
    }

    /**
    * Sets the user u f of this chat room user.
    *
    * @param userUF the user u f of this chat room user
    */
    public void setUserUF(long userUF) {
        _chatRoomUser.setUserUF(userUF);
    }

    /**
    * Returns the user email of this chat room user.
    *
    * @return the user email of this chat room user
    */
    public java.lang.String getUserEmail() {
        return _chatRoomUser.getUserEmail();
    }

    /**
    * Sets the user email of this chat room user.
    *
    * @param userEmail the user email of this chat room user
    */
    public void setUserEmail(java.lang.String userEmail) {
        _chatRoomUser.setUserEmail(userEmail);
    }

    /**
    * Returns the banned of this chat room user.
    *
    * @return the banned of this chat room user
    */
    public boolean getBanned() {
        return _chatRoomUser.getBanned();
    }

    /**
    * Returns <code>true</code> if this chat room user is banned.
    *
    * @return <code>true</code> if this chat room user is banned; <code>false</code> otherwise
    */
    public boolean isBanned() {
        return _chatRoomUser.isBanned();
    }

    /**
    * Sets whether this chat room user is banned.
    *
    * @param banned the banned of this chat room user
    */
    public void setBanned(boolean banned) {
        _chatRoomUser.setBanned(banned);
    }

    /**
    * Returns the user type of this chat room user.
    *
    * @return the user type of this chat room user
    */
    public int getUserType() {
        return _chatRoomUser.getUserType();
    }

    /**
    * Sets the user type of this chat room user.
    *
    * @param userType the user type of this chat room user
    */
    public void setUserType(int userType) {
        _chatRoomUser.setUserType(userType);
    }

    /**
    * Returns the joined t s of this chat room user.
    *
    * @return the joined t s of this chat room user
    */
    public java.util.Date getJoinedTS() {
        return _chatRoomUser.getJoinedTS();
    }

    /**
    * Sets the joined t s of this chat room user.
    *
    * @param joinedTS the joined t s of this chat room user
    */
    public void setJoinedTS(java.util.Date joinedTS) {
        _chatRoomUser.setJoinedTS(joinedTS);
    }

    public boolean isNew() {
        return _chatRoomUser.isNew();
    }

    public void setNew(boolean n) {
        _chatRoomUser.setNew(n);
    }

    public boolean isCachedModel() {
        return _chatRoomUser.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _chatRoomUser.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _chatRoomUser.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _chatRoomUser.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _chatRoomUser.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _chatRoomUser.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _chatRoomUser.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ChatRoomUserWrapper((ChatRoomUser) _chatRoomUser.clone());
    }

    public int compareTo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser) {
        return _chatRoomUser.compareTo(chatRoomUser);
    }

    @Override
    public int hashCode() {
        return _chatRoomUser.hashCode();
    }

    public com.liferay.portal.model.CacheModel<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> toCacheModel() {
        return _chatRoomUser.toCacheModel();
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser toEscapedModel() {
        return new ChatRoomUserWrapper(_chatRoomUser.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _chatRoomUser.toString();
    }

    public java.lang.String toXmlString() {
        return _chatRoomUser.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _chatRoomUser.persist();
    }

    public com.liferay.portal.kernel.json.JSONObject getJSON() {
        return _chatRoomUser.getJSON();
    }

    /**
    * Verifica se o usuário é moderador da sala
    *
    * @return
    */
    public boolean isModerator() {
        return _chatRoomUser.isModerator();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public ChatRoomUser getWrappedChatRoomUser() {
        return _chatRoomUser;
    }

    public ChatRoomUser getWrappedModel() {
        return _chatRoomUser;
    }

    public void resetOriginalValues() {
        _chatRoomUser.resetOriginalValues();
    }
}
