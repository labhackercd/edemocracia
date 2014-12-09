package br.gov.camara.edemocracia.portlets.chat.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the chat room video local service. This utility wraps {@link br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomVideoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomVideoLocalService
 * @see br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomVideoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomVideoLocalServiceImpl
 * @generated
 */
public class ChatRoomVideoLocalServiceUtil {
    private static ChatRoomVideoLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomVideoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the chat room video to the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoomVideo the chat room video
    * @return the chat room video that was added
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo addChatRoomVideo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addChatRoomVideo(chatRoomVideo);
    }

    /**
    * Creates a new chat room video with the primary key. Does not add the chat room video to the database.
    *
    * @param videoId the primary key for the new chat room video
    * @return the new chat room video
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo createChatRoomVideo(
        long videoId) {
        return getService().createChatRoomVideo(videoId);
    }

    /**
    * Deletes the chat room video with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param videoId the primary key of the chat room video
    * @return the chat room video that was removed
    * @throws PortalException if a chat room video with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo deleteChatRoomVideo(
        long videoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteChatRoomVideo(videoId);
    }

    /**
    * Deletes the chat room video from the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoomVideo the chat room video
    * @return the chat room video that was removed
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo deleteChatRoomVideo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteChatRoomVideo(chatRoomVideo);
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

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo fetchChatRoomVideo(
        long videoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchChatRoomVideo(videoId);
    }

    /**
    * Returns the chat room video with the primary key.
    *
    * @param videoId the primary key of the chat room video
    * @return the chat room video
    * @throws PortalException if a chat room video with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo getChatRoomVideo(
        long videoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getChatRoomVideo(videoId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the chat room videos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of chat room videos
    * @param end the upper bound of the range of chat room videos (not inclusive)
    * @return the range of chat room videos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo> getChatRoomVideos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getChatRoomVideos(start, end);
    }

    /**
    * Returns the number of chat room videos.
    *
    * @return the number of chat room videos
    * @throws SystemException if a system exception occurred
    */
    public static int getChatRoomVideosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getChatRoomVideosCount();
    }

    /**
    * Updates the chat room video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoomVideo the chat room video
    * @return the chat room video that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo updateChatRoomVideo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateChatRoomVideo(chatRoomVideo);
    }

    /**
    * Updates the chat room video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoomVideo the chat room video
    * @param merge whether to merge the chat room video with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the chat room video that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo updateChatRoomVideo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateChatRoomVideo(chatRoomVideo, merge);
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

    /**
    * Retorna o video cadastrado para a sala Se não encontrar o video retorna
    * null
    *
    * @param videoId
    * @return
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo getVideo(
        long videoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getVideo(videoId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ChatRoomVideoLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ChatRoomVideoLocalService.class.getName());

            if (invokableLocalService instanceof ChatRoomVideoLocalService) {
                _service = (ChatRoomVideoLocalService) invokableLocalService;
            } else {
                _service = new ChatRoomVideoLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ChatRoomVideoLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(ChatRoomVideoLocalService service) {
    }
}
