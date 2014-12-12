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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the chat room message local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomMessageLocalServiceUtil
 * @see br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomMessageLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomMessageLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ChatRoomMessageLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ChatRoomMessageLocalServiceUtil} to access the chat room message local service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomMessageLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the chat room message to the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoomMessage the chat room message
    * @return the chat room message that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage addChatRoomMessage(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage chatRoomMessage)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new chat room message with the primary key. Does not add the chat room message to the database.
    *
    * @param chatMessageId the primary key for the new chat room message
    * @return the new chat room message
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage createChatRoomMessage(
        long chatMessageId);

    /**
    * Deletes the chat room message with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param chatMessageId the primary key of the chat room message
    * @return the chat room message that was removed
    * @throws PortalException if a chat room message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage deleteChatRoomMessage(
        long chatMessageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the chat room message from the database. Also notifies the appropriate model listeners.
    *
    * @param chatRoomMessage the chat room message
    * @return the chat room message that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage deleteChatRoomMessage(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage chatRoomMessage)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

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
        throws com.liferay.portal.kernel.exception.SystemException;

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
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage fetchChatRoomMessage(
        long chatMessageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room message with the primary key.
    *
    * @param chatMessageId the primary key of the chat room message
    * @return the chat room message
    * @throws PortalException if a chat room message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage getChatRoomMessage(
        long chatMessageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the chat room messages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of chat room messages
    * @param end the upper bound of the range of chat room messages (not inclusive)
    * @return the range of chat room messages
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> getChatRoomMessages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room messages.
    *
    * @return the number of chat room messages
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getChatRoomMessagesCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the chat room message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoomMessage the chat room message
    * @return the chat room message that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage updateChatRoomMessage(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage chatRoomMessage)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the chat room message in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param chatRoomMessage the chat room message
    * @param merge whether to merge the chat room message with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the chat room message that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage updateChatRoomMessage(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage chatRoomMessage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    /**
    * Obtém uma mensagem vazia
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage getNullMessage();

    /**
    * Cria uma nova mensagem
    *
    * @param type
    * @param room
    * @param timestamp
    * @param message
    * @param pub
    * @param admin
    * @param textType
    * @param chatUserId
    * @param roomId
    * @param recipientUser
    * @throws SystemException
    * @throws PortalException
    */
    public void postMessage(
        br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType type,
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser sender,
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        java.util.Date timestamp, java.lang.String message, boolean pub,
        boolean admin,
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser recipient,
        int textType)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Aprova uma mensagem
    *
    * @param message
    * @param timestamp
    * @param approved
    * @throws SystemException
    */
    public void approveMessage(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage message,
        java.util.Date timestamp, boolean approved)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Obtém mensagens desde um determinado momento
    *
    * @param room
    Sala de bate-papo
    * @param user
    Usuário para obter as mensagens. Se for null, retorna apenas
    as mensagens públicas
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] getMessagesForUserSince(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser user,
        java.util.Date since)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] getMessagesForUserUntil(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser user,
        java.util.Date until)
        throws com.liferay.portal.kernel.exception.SystemException;
}
