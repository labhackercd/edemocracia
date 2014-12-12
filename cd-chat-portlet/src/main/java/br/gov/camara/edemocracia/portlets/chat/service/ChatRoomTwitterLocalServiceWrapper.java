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
 * This class is a wrapper for {@link ChatRoomTwitterLocalService}.
 * </p>
 *
 * @author    Ricardo Lima
 * @see       ChatRoomTwitterLocalService
 * @generated
 */
public class ChatRoomTwitterLocalServiceWrapper
    implements ChatRoomTwitterLocalService,
        ServiceWrapper<ChatRoomTwitterLocalService> {
    private ChatRoomTwitterLocalService _chatRoomTwitterLocalService;

    public ChatRoomTwitterLocalServiceWrapper(
        ChatRoomTwitterLocalService chatRoomTwitterLocalService) {
        _chatRoomTwitterLocalService = chatRoomTwitterLocalService;
    }

    /**
    * Adds the chat room twitter to the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoomTwitter the chat room twitter
    * @return the chat room twitter that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter addChatRoomTwitter(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter chatRoomTwitter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomTwitterLocalService.addChatRoomTwitter(chatRoomTwitter);
    }

    /**
    * Creates a new chat room twitter with the primary key. Does not add the chat room twitter to the database.
    *
    * @param twitterId the primary key for the new chat room twitter
    * @return the new chat room twitter
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter createChatRoomTwitter(
        long twitterId) {
        return _chatRoomTwitterLocalService.createChatRoomTwitter(twitterId);
    }

    /**
    * Deletes the chat room twitter with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param twitterId the primary key of the chat room twitter
    * @return the chat room twitter that was removed
    * @throws PortalException if a chat room twitter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter deleteChatRoomTwitter(
        long twitterId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomTwitterLocalService.deleteChatRoomTwitter(twitterId);
    }

    /**
    * Deletes the chat room twitter from the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoomTwitter the chat room twitter
    * @return the chat room twitter that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter deleteChatRoomTwitter(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter chatRoomTwitter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomTwitterLocalService.deleteChatRoomTwitter(chatRoomTwitter);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _chatRoomTwitterLocalService.dynamicQuery();
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
        return _chatRoomTwitterLocalService.dynamicQuery(dynamicQuery);
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
        return _chatRoomTwitterLocalService.dynamicQuery(dynamicQuery, start,
            end);
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
        return _chatRoomTwitterLocalService.dynamicQuery(dynamicQuery, start,
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
        return _chatRoomTwitterLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter fetchChatRoomTwitter(
        long twitterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomTwitterLocalService.fetchChatRoomTwitter(twitterId);
    }

    /**
    * Returns the chat room twitter with the primary key.
    *
    * @param twitterId the primary key of the chat room twitter
    * @return the chat room twitter
    * @throws PortalException if a chat room twitter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter getChatRoomTwitter(
        long twitterId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomTwitterLocalService.getChatRoomTwitter(twitterId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomTwitterLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the chat room twitters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of chat room twitters
    * @param end the upper bound of the range of chat room twitters (not inclusive)
    * @return the range of chat room twitters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter> getChatRoomTwitters(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomTwitterLocalService.getChatRoomTwitters(start, end);
    }

    /**
    * Returns the number of chat room twitters.
    *
    * @return the number of chat room twitters
    * @throws SystemException if a system exception occurred
    */
    public int getChatRoomTwittersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomTwitterLocalService.getChatRoomTwittersCount();
    }

    /**
    * Updates the chat room twitter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoomTwitter the chat room twitter
    * @return the chat room twitter that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter updateChatRoomTwitter(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter chatRoomTwitter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomTwitterLocalService.updateChatRoomTwitter(chatRoomTwitter);
    }

    /**
    * Updates the chat room twitter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoomTwitter the chat room twitter
    * @param merge whether to merge the chat room twitter with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the chat room twitter that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter updateChatRoomTwitter(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter chatRoomTwitter,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomTwitterLocalService.updateChatRoomTwitter(chatRoomTwitter,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _chatRoomTwitterLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _chatRoomTwitterLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _chatRoomTwitterLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Retorna o twitter cadastrado para a sala Caso não encontre, retorna null
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter getTwitter(
        long twitterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomTwitterLocalService.getTwitter(twitterId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ChatRoomTwitterLocalService getWrappedChatRoomTwitterLocalService() {
        return _chatRoomTwitterLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedChatRoomTwitterLocalService(
        ChatRoomTwitterLocalService chatRoomTwitterLocalService) {
        _chatRoomTwitterLocalService = chatRoomTwitterLocalService;
    }

    public ChatRoomTwitterLocalService getWrappedService() {
        return _chatRoomTwitterLocalService;
    }

    public void setWrappedService(
        ChatRoomTwitterLocalService chatRoomTwitterLocalService) {
        _chatRoomTwitterLocalService = chatRoomTwitterLocalService;
    }
}
