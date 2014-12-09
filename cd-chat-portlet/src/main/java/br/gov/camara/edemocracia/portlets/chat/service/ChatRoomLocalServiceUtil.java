package br.gov.camara.edemocracia.portlets.chat.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the chat room local service. This utility wraps {@link br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomLocalService
 * @see br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomLocalServiceImpl
 * @generated
 */
public class ChatRoomLocalServiceUtil {
    private static ChatRoomLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the chat room to the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoom the chat room
    * @return the chat room that was added
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom addChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addChatRoom(chatRoom);
    }

    /**
    * Creates a new chat room with the primary key. Does not add the chat room to the database.
    *
    * @param roomId the primary key for the new chat room
    * @return the new chat room
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom createChatRoom(
        long roomId) {
        return getService().createChatRoom(roomId);
    }

    /**
    * Deletes the chat room with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param roomId the primary key of the chat room
    * @return the chat room that was removed
    * @throws PortalException if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom deleteChatRoom(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteChatRoom(roomId);
    }

    /**
    * Deletes the chat room from the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoom the chat room
    * @return the chat room that was removed
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom deleteChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteChatRoom(chatRoom);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchChatRoom(
        long roomId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchChatRoom(roomId);
    }

    /**
    * Returns the chat room with the primary key.
    *
    * @param roomId the primary key of the chat room
    * @return the chat room
    * @throws PortalException if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom getChatRoom(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getChatRoom(roomId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> getChatRooms(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getChatRooms(start, end);
    }

    /**
    * Returns the number of chat rooms.
    *
    * @return the number of chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static int getChatRoomsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getChatRoomsCount();
    }

    /**
    * Updates the chat room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoom the chat room
    * @return the chat room that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom updateChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateChatRoom(chatRoom);
    }

    /**
    * Updates the chat room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoom the chat room
    * @param merge whether to merge the chat room with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the chat room that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom updateChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateChatRoom(chatRoom, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findOpenAndEnterableClosedRoomsInCompany(
        long companyId, boolean userLogado)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findOpenAndEnterableClosedRoomsInCompany(companyId,
            userLogado);
    }

    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findScheduledRoomsInCompany(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findScheduledRoomsInCompany(groupId);
    }

    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findExportedRoomsInCompany(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findExportedRoomsInCompany(groupId);
    }

    /**
    * Lista os nomes de usuário na sala que começam pelo nome especificado
    *
    * @param room
    * @param name
    * @return
    * @throws SystemException
    */
    public static java.util.HashSet<java.lang.String> listUsersStartingBy(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().listUsersStartingBy(room, name);
    }

    /**
    * Verifica se há usuários no portal com o mesmo fullname
    *
    * @param fullName
    * @return
    */
    public static boolean isFullNameInUseInPortal(long companyId,
        java.lang.String fullName) {
        return getService().isFullNameInUseInPortal(companyId, fullName);
    }

    /**
    * Conta o número de usuários na sala
    *
    * @param roomId
    * @return
    * @throws SystemException
    */
    public static long getUsersCountInChatRoom(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getUsersCountInChatRoom(roomId);
    }

    /**
    * Verifica se há espaço na sala
    *
    * @param room
    * @return
    * @throws SystemException
    */
    public static boolean roomHaveSpaceLeft(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().roomHaveSpaceLeft(room);
    }

    /**
    * Adiciona um usuário autenticado em uma sala de bate-papo
    *
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addUserToRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        com.liferay.portal.model.User portalUser, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addUserToRoom(room, portalUser, timestamp);
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
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addModeratorToRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        com.liferay.portal.model.User portalUser, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addModeratorToRoom(room, portalUser, timestamp);
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
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addAnonUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        java.util.Date timestamp, java.lang.String name,
        java.lang.String email, long uf)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addAnonUser(room, timestamp, name, email, uf);
    }

    public static br.gov.camara.edemocracia.portlets.chat.service.UserActivityId addSpyUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        java.util.Date timestamp, com.liferay.portal.model.User user)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addSpyUser(room, timestamp, user);
    }

    public static void banirUsuario(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom sala,
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser moderador,
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser usuarioParaBanir,
        java.util.Date timestamp, boolean banido)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService()
            .banirUsuario(sala, moderador, usuarioParaBanir, timestamp, banido);
    }

    public static boolean isUserInRoom(java.lang.Long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId) {
        return getService().isUserInRoom(roomId, userActivityId);
    }

    public static void updateUserTimestamp(java.lang.Long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId) {
        getService().updateUserTimestamp(roomId, userActivityId);
    }

    public static void removeSpyUser(java.lang.Long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().removeSpyUser(roomId, userActivityId);
    }

    /**
    * Remove um usuário da sala de bate-papo
    *
    * @param user
    * @param timestamp
    */
    public static void removeUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser user,
        java.util.Date timestamp) {
        getService().removeUser(user, timestamp);
    }

    /**
    * Ajusta o estado das salas agendadas
    *
    * @param timestamp
    */
    public static void checkScheduledRoomState(java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().checkScheduledRoomState(timestamp);
    }

    public static void removerUsuariosInativos()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().removerUsuariosInativos();
    }

    public static void removerUsuariosBanidosDeSalasFechadas() {
        getService().removerUsuariosBanidosDeSalasFechadas();
    }

    public static void synchronizeActivityManagerAndDatabase() {
        getService().synchronizeActivityManagerAndDatabase();
    }

    public static void clearService() {
        _service = null;
    }

    public static ChatRoomLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ChatRoomLocalService.class.getName());

            if (invokableLocalService instanceof ChatRoomLocalService) {
                _service = (ChatRoomLocalService) invokableLocalService;
            } else {
                _service = new ChatRoomLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ChatRoomLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(ChatRoomLocalService service) {
    }
}
