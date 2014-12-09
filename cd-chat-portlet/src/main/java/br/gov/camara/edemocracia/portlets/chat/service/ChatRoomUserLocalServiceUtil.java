package br.gov.camara.edemocracia.portlets.chat.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the chat room user local service. This utility wraps {@link br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomUserLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomUserLocalService
 * @see br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomUserLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomUserLocalServiceImpl
 * @generated
 */
public class ChatRoomUserLocalServiceUtil {
    private static ChatRoomUserLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the chat room user to the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoomUser the chat room user
    * @return the chat room user that was added
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addChatRoomUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addChatRoomUser(chatRoomUser);
    }

    /**
    * Creates a new chat room user with the primary key. Does not add the chat room user to the database.
    *
    * @param chatUserId the primary key for the new chat room user
    * @return the new chat room user
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser createChatRoomUser(
        long chatUserId) {
        return getService().createChatRoomUser(chatUserId);
    }

    /**
    * Deletes the chat room user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param chatUserId the primary key of the chat room user
    * @return the chat room user that was removed
    * @throws PortalException if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser deleteChatRoomUser(
        long chatUserId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteChatRoomUser(chatUserId);
    }

    /**
    * Deletes the chat room user from the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoomUser the chat room user
    * @return the chat room user that was removed
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser deleteChatRoomUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteChatRoomUser(chatRoomUser);
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

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchChatRoomUser(
        long chatUserId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchChatRoomUser(chatUserId);
    }

    /**
    * Returns the chat room user with the primary key.
    *
    * @param chatUserId the primary key of the chat room user
    * @return the chat room user
    * @throws PortalException if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser getChatRoomUser(
        long chatUserId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getChatRoomUser(chatUserId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> getChatRoomUsers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getChatRoomUsers(start, end);
    }

    /**
    * Returns the number of chat room users.
    *
    * @return the number of chat room users
    * @throws SystemException if a system exception occurred
    */
    public static int getChatRoomUsersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getChatRoomUsersCount();
    }

    /**
    * Updates the chat room user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoomUser the chat room user
    * @return the chat room user that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser updateChatRoomUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateChatRoomUser(chatRoomUser);
    }

    /**
    * Updates the chat room user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoomUser the chat room user
    * @param merge whether to merge the chat room user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the chat room user that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser updateChatRoomUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateChatRoomUser(chatRoomUser, merge);
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

    public static boolean existsUserNameInChatRoom(long chatRoomId,
        java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().existsUserNameInChatRoom(chatRoomId, userName);
    }

    public static boolean existsUserEmailInChatRoom(long chatRoomId,
        java.lang.String userEmail)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().existsUserEmailInChatRoom(chatRoomId, userEmail);
    }

    /**
    * Retorna o usuário da sala que contém o nome completo especificado
    *
    * @param chatRoom
    * @param userName
    * @return
    * @throws SystemException
    */
    public static boolean isUserNameInUse(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom,
        java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().isUserNameInUse(chatRoom, userName);
    }

    /**
    * Obtém o usuário do chat associado ao usuário do portal
    *
    * @param user
    * @return
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByPortalUser(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        com.liferay.portal.model.User user)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPortalUser(room, user);
    }

    public static void clearService() {
        _service = null;
    }

    public static ChatRoomUserLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ChatRoomUserLocalService.class.getName());

            if (invokableLocalService instanceof ChatRoomUserLocalService) {
                _service = (ChatRoomUserLocalService) invokableLocalService;
            } else {
                _service = new ChatRoomUserLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ChatRoomUserLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(ChatRoomUserLocalService service) {
    }
}
