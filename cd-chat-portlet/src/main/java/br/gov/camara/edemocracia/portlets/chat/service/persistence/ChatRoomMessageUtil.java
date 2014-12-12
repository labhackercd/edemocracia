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
package br.gov.camara.edemocracia.portlets.chat.service.persistence;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the chat room message service. This utility wraps {@link ChatRoomMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomMessagePersistence
 * @see ChatRoomMessagePersistenceImpl
 * @generated
 */
public class ChatRoomMessageUtil {
    private static ChatRoomMessagePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(ChatRoomMessage chatRoomMessage) {
        getPersistence().clearCache(chatRoomMessage);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<ChatRoomMessage> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ChatRoomMessage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ChatRoomMessage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static ChatRoomMessage update(ChatRoomMessage chatRoomMessage,
        boolean merge) throws SystemException {
        return getPersistence().update(chatRoomMessage, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static ChatRoomMessage update(ChatRoomMessage chatRoomMessage,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(chatRoomMessage, merge, serviceContext);
    }

    /**
    * Caches the chat room message in the entity cache if it is enabled.
    *
    * @param chatRoomMessage the chat room message
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage chatRoomMessage) {
        getPersistence().cacheResult(chatRoomMessage);
    }

    /**
    * Caches the chat room messages in the entity cache if it is enabled.
    *
    * @param chatRoomMessages the chat room messages
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> chatRoomMessages) {
        getPersistence().cacheResult(chatRoomMessages);
    }

    /**
    * Creates a new chat room message with the primary key. Does not add the chat room message to the database.
    *
    * @param chatMessageId the primary key for the new chat room message
    * @return the new chat room message
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage create(
        long chatMessageId) {
        return getPersistence().create(chatMessageId);
    }

    /**
    * Removes the chat room message with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param chatMessageId the primary key of the chat room message
    * @return the chat room message that was removed
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a chat room message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage remove(
        long chatMessageId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(chatMessageId);
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage chatRoomMessage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(chatRoomMessage, merge);
    }

    /**
    * Returns the chat room message with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException} if it could not be found.
    *
    * @param chatMessageId the primary key of the chat room message
    * @return the chat room message
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a chat room message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage findByPrimaryKey(
        long chatMessageId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(chatMessageId);
    }

    /**
    * Returns the chat room message with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param chatMessageId the primary key of the chat room message
    * @return the chat room message, or <code>null</code> if a chat room message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage fetchByPrimaryKey(
        long chatMessageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(chatMessageId);
    }

    /**
    * Returns all the chat room messages where messagePublic = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @return the matching chat room messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findByPublic(
        boolean messagePublic, java.util.Date messageTS)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPublic(messagePublic, messageTS);
    }

    /**
    * Returns a range of all the chat room messages where messagePublic = &#63; and messageTS = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @param start the lower bound of the range of chat room messages
    * @param end the upper bound of the range of chat room messages (not inclusive)
    * @return the range of matching chat room messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findByPublic(
        boolean messagePublic, java.util.Date messageTS, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPublic(messagePublic, messageTS, start, end);
    }

    /**
    * Returns an ordered range of all the chat room messages where messagePublic = &#63; and messageTS = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @param start the lower bound of the range of chat room messages
    * @param end the upper bound of the range of chat room messages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching chat room messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findByPublic(
        boolean messagePublic, java.util.Date messageTS, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPublic(messagePublic, messageTS, start, end,
            orderByComparator);
    }

    /**
    * Returns the first chat room message in the ordered set where messagePublic = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room message
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a matching chat room message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage findByPublic_First(
        boolean messagePublic, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPublic_First(messagePublic, messageTS,
            orderByComparator);
    }

    /**
    * Returns the first chat room message in the ordered set where messagePublic = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room message, or <code>null</code> if a matching chat room message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage fetchByPublic_First(
        boolean messagePublic, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPublic_First(messagePublic, messageTS,
            orderByComparator);
    }

    /**
    * Returns the last chat room message in the ordered set where messagePublic = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room message
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a matching chat room message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage findByPublic_Last(
        boolean messagePublic, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPublic_Last(messagePublic, messageTS,
            orderByComparator);
    }

    /**
    * Returns the last chat room message in the ordered set where messagePublic = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room message, or <code>null</code> if a matching chat room message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage fetchByPublic_Last(
        boolean messagePublic, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPublic_Last(messagePublic, messageTS,
            orderByComparator);
    }

    /**
    * Returns the chat room messages before and after the current chat room message in the ordered set where messagePublic = &#63; and messageTS = &#63;.
    *
    * @param chatMessageId the primary key of the current chat room message
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next chat room message
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a chat room message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] findByPublic_PrevAndNext(
        long chatMessageId, boolean messagePublic, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPublic_PrevAndNext(chatMessageId, messagePublic,
            messageTS, orderByComparator);
    }

    /**
    * Returns all the chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @return the matching chat room messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findByPrivateUser(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPrivateUser(messagePublic, recipientUserId, messageTS);
    }

    /**
    * Returns a range of all the chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @param start the lower bound of the range of chat room messages
    * @param end the upper bound of the range of chat room messages (not inclusive)
    * @return the range of matching chat room messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findByPrivateUser(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPrivateUser(messagePublic, recipientUserId,
            messageTS, start, end);
    }

    /**
    * Returns an ordered range of all the chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @param start the lower bound of the range of chat room messages
    * @param end the upper bound of the range of chat room messages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching chat room messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findByPrivateUser(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPrivateUser(messagePublic, recipientUserId,
            messageTS, start, end, orderByComparator);
    }

    /**
    * Returns the first chat room message in the ordered set where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room message
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a matching chat room message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage findByPrivateUser_First(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPrivateUser_First(messagePublic, recipientUserId,
            messageTS, orderByComparator);
    }

    /**
    * Returns the first chat room message in the ordered set where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room message, or <code>null</code> if a matching chat room message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage fetchByPrivateUser_First(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPrivateUser_First(messagePublic, recipientUserId,
            messageTS, orderByComparator);
    }

    /**
    * Returns the last chat room message in the ordered set where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room message
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a matching chat room message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage findByPrivateUser_Last(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPrivateUser_Last(messagePublic, recipientUserId,
            messageTS, orderByComparator);
    }

    /**
    * Returns the last chat room message in the ordered set where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room message, or <code>null</code> if a matching chat room message could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage fetchByPrivateUser_Last(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPrivateUser_Last(messagePublic, recipientUserId,
            messageTS, orderByComparator);
    }

    /**
    * Returns the chat room messages before and after the current chat room message in the ordered set where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
    *
    * @param chatMessageId the primary key of the current chat room message
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next chat room message
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a chat room message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] findByPrivateUser_PrevAndNext(
        long chatMessageId, boolean messagePublic, long recipientUserId,
        java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPrivateUser_PrevAndNext(chatMessageId, messagePublic,
            recipientUserId, messageTS, orderByComparator);
    }

    /**
    * Returns all the chat room messages.
    *
    * @return the chat room messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the chat room messages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of chat room messages
    * @param end the upper bound of the range of chat room messages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of chat room messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the chat room messages where messagePublic = &#63; and messageTS = &#63; from the database.
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPublic(boolean messagePublic,
        java.util.Date messageTS)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPublic(messagePublic, messageTS);
    }

    /**
    * Removes all the chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63; from the database.
    *
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPrivateUser(boolean messagePublic,
        long recipientUserId, java.util.Date messageTS)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByPrivateUser(messagePublic, recipientUserId, messageTS);
    }

    /**
    * Removes all the chat room messages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of chat room messages where messagePublic = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @return the number of matching chat room messages
    * @throws SystemException if a system exception occurred
    */
    public static int countByPublic(boolean messagePublic,
        java.util.Date messageTS)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPublic(messagePublic, messageTS);
    }

    /**
    * Returns the number of chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @return the number of matching chat room messages
    * @throws SystemException if a system exception occurred
    */
    public static int countByPrivateUser(boolean messagePublic,
        long recipientUserId, java.util.Date messageTS)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByPrivateUser(messagePublic, recipientUserId, messageTS);
    }

    /**
    * Returns the number of chat room messages.
    *
    * @return the number of chat room messages
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ChatRoomMessagePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ChatRoomMessagePersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.chat.service.ClpSerializer.getServletContextName(),
                    ChatRoomMessagePersistence.class.getName());

            ReferenceRegistry.registerReference(ChatRoomMessageUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(ChatRoomMessagePersistence persistence) {
    }
}
