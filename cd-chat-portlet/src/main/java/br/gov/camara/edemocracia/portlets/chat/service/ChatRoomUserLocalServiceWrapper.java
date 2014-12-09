package br.gov.camara.edemocracia.portlets.chat.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ChatRoomUserLocalService}.
 * </p>
 *
 * @author    Ricardo Lima
 * @see       ChatRoomUserLocalService
 * @generated
 */
public class ChatRoomUserLocalServiceWrapper implements ChatRoomUserLocalService,
    ServiceWrapper<ChatRoomUserLocalService> {
    private ChatRoomUserLocalService _chatRoomUserLocalService;

    public ChatRoomUserLocalServiceWrapper(
        ChatRoomUserLocalService chatRoomUserLocalService) {
        _chatRoomUserLocalService = chatRoomUserLocalService;
    }

    /**
    * Adds the chat room user to the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoomUser the chat room user
    * @return the chat room user that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addChatRoomUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.addChatRoomUser(chatRoomUser);
    }

    /**
    * Creates a new chat room user with the primary key. Does not add the chat room user to the database.
    *
    * @param chatUserId the primary key for the new chat room user
    * @return the new chat room user
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser createChatRoomUser(
        long chatUserId) {
        return _chatRoomUserLocalService.createChatRoomUser(chatUserId);
    }

    /**
    * Deletes the chat room user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param chatUserId the primary key of the chat room user
    * @return the chat room user that was removed
    * @throws PortalException if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser deleteChatRoomUser(
        long chatUserId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.deleteChatRoomUser(chatUserId);
    }

    /**
    * Deletes the chat room user from the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoomUser the chat room user
    * @return the chat room user that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser deleteChatRoomUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.deleteChatRoomUser(chatRoomUser);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _chatRoomUserLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchChatRoomUser(
        long chatUserId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.fetchChatRoomUser(chatUserId);
    }

    /**
    * Returns the chat room user with the primary key.
    *
    * @param chatUserId the primary key of the chat room user
    * @return the chat room user
    * @throws PortalException if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser getChatRoomUser(
        long chatUserId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.getChatRoomUser(chatUserId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the chat room users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of chat room users
    * @param end the upper bound of the range of chat room users (not inclusive)
    * @return the range of chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> getChatRoomUsers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.getChatRoomUsers(start, end);
    }

    /**
    * Returns the number of chat room users.
    *
    * @return the number of chat room users
    * @throws SystemException if a system exception occurred
    */
    public int getChatRoomUsersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.getChatRoomUsersCount();
    }

    /**
    * Updates the chat room user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoomUser the chat room user
    * @return the chat room user that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser updateChatRoomUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.updateChatRoomUser(chatRoomUser);
    }

    /**
    * Updates the chat room user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoomUser the chat room user
    * @param merge whether to merge the chat room user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the chat room user that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser updateChatRoomUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.updateChatRoomUser(chatRoomUser, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _chatRoomUserLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _chatRoomUserLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _chatRoomUserLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public boolean existsUserNameInChatRoom(long chatRoomId,
        java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.existsUserNameInChatRoom(chatRoomId,
            userName);
    }

    public boolean existsUserEmailInChatRoom(long chatRoomId,
        java.lang.String userEmail)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.existsUserEmailInChatRoom(chatRoomId,
            userEmail);
    }

    /**
    * Retorna o usuário da sala que contém o nome completo especificado
    *
    * @param chatRoom
    * @param userName
    * @return
    * @throws SystemException
    */
    public boolean isUserNameInUse(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom,
        java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.isUserNameInUse(chatRoom, userName);
    }

    /**
    * Obtém o usuário do chat associado ao usuário do portal
    *
    * @param user
    * @return
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByPortalUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        com.liferay.portal.model.User user)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomUserLocalService.findByPortalUser(room, user);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ChatRoomUserLocalService getWrappedChatRoomUserLocalService() {
        return _chatRoomUserLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedChatRoomUserLocalService(
        ChatRoomUserLocalService chatRoomUserLocalService) {
        _chatRoomUserLocalService = chatRoomUserLocalService;
    }

    public ChatRoomUserLocalService getWrappedService() {
        return _chatRoomUserLocalService;
    }

    public void setWrappedService(
        ChatRoomUserLocalService chatRoomUserLocalService) {
        _chatRoomUserLocalService = chatRoomUserLocalService;
    }
}
