package br.gov.camara.edemocracia.portlets.chat.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ChatRoomLocalService}.
 * </p>
 *
 * @author    Ricardo Lima
 * @see       ChatRoomLocalService
 * @generated
 */
public class ChatRoomLocalServiceWrapper implements ChatRoomLocalService,
    ServiceWrapper<ChatRoomLocalService> {
    private ChatRoomLocalService _chatRoomLocalService;

    public ChatRoomLocalServiceWrapper(
        ChatRoomLocalService chatRoomLocalService) {
        _chatRoomLocalService = chatRoomLocalService;
    }

    /**
    * Adds the chat room to the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoom the chat room
    * @return the chat room that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom addChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.addChatRoom(chatRoom);
    }

    /**
    * Creates a new chat room with the primary key. Does not add the chat room to the database.
    *
    * @param roomId the primary key for the new chat room
    * @return the new chat room
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom createChatRoom(
        long roomId) {
        return _chatRoomLocalService.createChatRoom(roomId);
    }

    /**
    * Deletes the chat room with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param roomId the primary key of the chat room
    * @return the chat room that was removed
    * @throws PortalException if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom deleteChatRoom(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.deleteChatRoom(roomId);
    }

    /**
    * Deletes the chat room from the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoom the chat room
    * @return the chat room that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom deleteChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.deleteChatRoom(chatRoom);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _chatRoomLocalService.dynamicQuery();
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
        return _chatRoomLocalService.dynamicQuery(dynamicQuery);
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
        return _chatRoomLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _chatRoomLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _chatRoomLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchChatRoom(
        long roomId) throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.fetchChatRoom(roomId);
    }

    /**
    * Returns the chat room with the primary key.
    *
    * @param roomId the primary key of the chat room
    * @return the chat room
    * @throws PortalException if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom getChatRoom(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.getChatRoom(roomId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the chat rooms.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of chat rooms
    * @param end the upper bound of the range of chat rooms (not inclusive)
    * @return the range of chat rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> getChatRooms(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.getChatRooms(start, end);
    }

    /**
    * Returns the number of chat rooms.
    *
    * @return the number of chat rooms
    * @throws SystemException if a system exception occurred
    */
    public int getChatRoomsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.getChatRoomsCount();
    }

    /**
    * Updates the chat room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoom the chat room
    * @return the chat room that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom updateChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.updateChatRoom(chatRoom);
    }

    /**
    * Updates the chat room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoom the chat room
    * @param merge whether to merge the chat room with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the chat room that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom updateChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.updateChatRoom(chatRoom, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _chatRoomLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _chatRoomLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _chatRoomLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findOpenAndEnterableClosedRoomsInCompany(
        long companyId, boolean userLogado)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.findOpenAndEnterableClosedRoomsInCompany(companyId,
            userLogado);
    }

    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findScheduledRoomsInCompany(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.findScheduledRoomsInCompany(groupId);
    }

    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findExportedRoomsInCompany(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.findExportedRoomsInCompany(groupId);
    }

    /**
    * Lista os nomes de usuário na sala que começam pelo nome especificado
    *
    * @param room
    * @param name
    * @return
    * @throws SystemException
    */
    public java.util.HashSet<java.lang.String> listUsersStartingBy(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.listUsersStartingBy(room, name);
    }

    /**
    * Verifica se há usuários no portal com o mesmo fullname
    *
    * @param fullName
    * @return
    */
    public boolean isFullNameInUseInPortal(long companyId,
        java.lang.String fullName) {
        return _chatRoomLocalService.isFullNameInUseInPortal(companyId, fullName);
    }

    /**
    * Conta o número de usuários na sala
    *
    * @param roomId
    * @return
    * @throws SystemException
    */
    public long getUsersCountInChatRoom(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.getUsersCountInChatRoom(roomId);
    }

    /**
    * Verifica se há espaço na sala
    *
    * @param room
    * @return
    * @throws SystemException
    */
    public boolean roomHaveSpaceLeft(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.roomHaveSpaceLeft(room);
    }

    /**
    * Adiciona um usuário autenticado em uma sala de bate-papo
    *
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addUserToRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        com.liferay.portal.model.User portalUser, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.addUserToRoom(room, portalUser, timestamp);
    }

    /**
    * Adiciona um moderador na sala de bate-papo.
    *
    * Permite ao moderador entrar na sala de bate-papo, independente do estado
    *
    * @param room
    * @param portalUser
    * @param timestamp
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addModeratorToRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        com.liferay.portal.model.User portalUser, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.addModeratorToRoom(room, portalUser,
            timestamp);
    }

    /**
    * Adiciona um usuário anônimo
    *
    * @param room
    * @param timestamp
    * @param name
    * @param email
    * @param uf
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addAnonUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        java.util.Date timestamp, java.lang.String name,
        java.lang.String email, long uf)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.addAnonUser(room, timestamp, name, email,
            uf);
    }

    public br.gov.camara.edemocracia.portlets.chat.service.UserActivityId addSpyUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        java.util.Date timestamp, com.liferay.portal.model.User user)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomLocalService.addSpyUser(room, timestamp, user);
    }

    public void banirUsuario(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom sala,
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser moderador,
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser usuarioParaBanir,
        java.util.Date timestamp, boolean banido)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _chatRoomLocalService.banirUsuario(sala, moderador, usuarioParaBanir,
            timestamp, banido);
    }

    public boolean isUserInRoom(java.lang.Long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId) {
        return _chatRoomLocalService.isUserInRoom(roomId, userActivityId);
    }

    public void updateUserTimestamp(java.lang.Long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId) {
        _chatRoomLocalService.updateUserTimestamp(roomId, userActivityId);
    }

    public void removeSpyUser(java.lang.Long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _chatRoomLocalService.removeSpyUser(roomId, userActivityId);
    }

    /**
    * Remove um usuário da sala de bate-papo
    *
    * @param user
    * @param timestamp
    */
    public void removeUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser user,
        java.util.Date timestamp) {
        _chatRoomLocalService.removeUser(user, timestamp);
    }

    /**
    * Ajusta o estado das salas agendadas
    *
    * @param timestamp
    */
    public void checkScheduledRoomState(java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.SystemException {
        _chatRoomLocalService.checkScheduledRoomState(timestamp);
    }

    public void removerUsuariosInativos()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _chatRoomLocalService.removerUsuariosInativos();
    }

    public void removerUsuariosBanidosDeSalasFechadas() {
        _chatRoomLocalService.removerUsuariosBanidosDeSalasFechadas();
    }

    public void synchronizeActivityManagerAndDatabase() {
        _chatRoomLocalService.synchronizeActivityManagerAndDatabase();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ChatRoomLocalService getWrappedChatRoomLocalService() {
        return _chatRoomLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedChatRoomLocalService(
        ChatRoomLocalService chatRoomLocalService) {
        _chatRoomLocalService = chatRoomLocalService;
    }

    public ChatRoomLocalService getWrappedService() {
        return _chatRoomLocalService;
    }

    public void setWrappedService(ChatRoomLocalService chatRoomLocalService) {
        _chatRoomLocalService = chatRoomLocalService;
    }
}
