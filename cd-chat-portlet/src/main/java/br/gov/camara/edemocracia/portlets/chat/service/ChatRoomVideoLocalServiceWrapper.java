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
package br.gov.camara.edemocracia.portlets.chat.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ChatRoomVideoLocalService}.
 * </p>
 *
 * @author    Ricardo Lima
 * @see       ChatRoomVideoLocalService
 * @generated
 */
public class ChatRoomVideoLocalServiceWrapper
    implements ChatRoomVideoLocalService,
        ServiceWrapper<ChatRoomVideoLocalService> {
    private ChatRoomVideoLocalService _chatRoomVideoLocalService;

    public ChatRoomVideoLocalServiceWrapper(
        ChatRoomVideoLocalService chatRoomVideoLocalService) {
        _chatRoomVideoLocalService = chatRoomVideoLocalService;
    }

    /**
    * Adds the chat room video to the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoomVideo the chat room video
    * @return the chat room video that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo addChatRoomVideo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomVideoLocalService.addChatRoomVideo(chatRoomVideo);
    }

    /**
    * Creates a new chat room video with the primary key. Does not add the chat room video to the database.
    *
    * @param videoId the primary key for the new chat room video
    * @return the new chat room video
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo createChatRoomVideo(
        long videoId) {
        return _chatRoomVideoLocalService.createChatRoomVideo(videoId);
    }

    /**
    * Deletes the chat room video with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param videoId the primary key of the chat room video
    * @return the chat room video that was removed
    * @throws PortalException if a chat room video with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo deleteChatRoomVideo(
        long videoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomVideoLocalService.deleteChatRoomVideo(videoId);
    }

    /**
    * Deletes the chat room video from the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoomVideo the chat room video
    * @return the chat room video that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo deleteChatRoomVideo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomVideoLocalService.deleteChatRoomVideo(chatRoomVideo);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _chatRoomVideoLocalService.dynamicQuery();
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
        return _chatRoomVideoLocalService.dynamicQuery(dynamicQuery);
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
        return _chatRoomVideoLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _chatRoomVideoLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
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
        return _chatRoomVideoLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo fetchChatRoomVideo(
        long videoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomVideoLocalService.fetchChatRoomVideo(videoId);
    }

    /**
    * Returns the chat room video with the primary key.
    *
    * @param videoId the primary key of the chat room video
    * @return the chat room video
    * @throws PortalException if a chat room video with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo getChatRoomVideo(
        long videoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomVideoLocalService.getChatRoomVideo(videoId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomVideoLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo> getChatRoomVideos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomVideoLocalService.getChatRoomVideos(start, end);
    }

    /**
    * Returns the number of chat room videos.
    *
    * @return the number of chat room videos
    * @throws SystemException if a system exception occurred
    */
    public int getChatRoomVideosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomVideoLocalService.getChatRoomVideosCount();
    }

    /**
    * Updates the chat room video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoomVideo the chat room video
    * @return the chat room video that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo updateChatRoomVideo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomVideoLocalService.updateChatRoomVideo(chatRoomVideo);
    }

    /**
    * Updates the chat room video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoomVideo the chat room video
    * @param merge whether to merge the chat room video with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the chat room video that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo updateChatRoomVideo(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomVideoLocalService.updateChatRoomVideo(chatRoomVideo,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _chatRoomVideoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _chatRoomVideoLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _chatRoomVideoLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Retorna o video cadastrado para a sala Se não encontrar o video retorna
    * null
    *
    * @param videoId
    * @return
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo getVideo(
        long videoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomVideoLocalService.getVideo(videoId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ChatRoomVideoLocalService getWrappedChatRoomVideoLocalService() {
        return _chatRoomVideoLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedChatRoomVideoLocalService(
        ChatRoomVideoLocalService chatRoomVideoLocalService) {
        _chatRoomVideoLocalService = chatRoomVideoLocalService;
    }

    public ChatRoomVideoLocalService getWrappedService() {
        return _chatRoomVideoLocalService;
    }

    public void setWrappedService(
        ChatRoomVideoLocalService chatRoomVideoLocalService) {
        _chatRoomVideoLocalService = chatRoomVideoLocalService;
    }
}
