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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the chat room message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomMessagePersistenceImpl
 * @see ChatRoomMessageUtil
 * @generated
 */
public interface ChatRoomMessagePersistence extends BasePersistence<ChatRoomMessage> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ChatRoomMessageUtil} to access the chat room message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the chat room message in the entity cache if it is enabled.
    *
    * @param chatRoomMessage the chat room message
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage chatRoomMessage);

    /**
    * Caches the chat room messages in the entity cache if it is enabled.
    *
    * @param chatRoomMessages the chat room messages
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> chatRoomMessages);

    /**
    * Creates a new chat room message with the primary key. Does not add the chat room message to the database.
    *
    * @param chatMessageId the primary key for the new chat room message
    * @return the new chat room message
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage create(
        long chatMessageId);

    /**
    * Removes the chat room message with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param chatMessageId the primary key of the chat room message
    * @return the chat room message that was removed
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a chat room message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage remove(
        long chatMessageId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage chatRoomMessage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room message with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException} if it could not be found.
    *
    * @param chatMessageId the primary key of the chat room message
    * @return the chat room message
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a chat room message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage findByPrimaryKey(
        long chatMessageId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room message with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param chatMessageId the primary key of the chat room message
    * @return the chat room message, or <code>null</code> if a chat room message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage fetchByPrimaryKey(
        long chatMessageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat room messages where messagePublic = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @return the matching chat room messages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findByPublic(
        boolean messagePublic, java.util.Date messageTS)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findByPublic(
        boolean messagePublic, java.util.Date messageTS, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findByPublic(
        boolean messagePublic, java.util.Date messageTS, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage findByPublic_First(
        boolean messagePublic, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room message in the ordered set where messagePublic = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room message, or <code>null</code> if a matching chat room message could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage fetchByPublic_First(
        boolean messagePublic, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage findByPublic_Last(
        boolean messagePublic, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room message in the ordered set where messagePublic = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room message, or <code>null</code> if a matching chat room message could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage fetchByPublic_Last(
        boolean messagePublic, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] findByPublic_PrevAndNext(
        long chatMessageId, boolean messagePublic, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @return the matching chat room messages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findByPrivateUser(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findByPrivateUser(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findByPrivateUser(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage findByPrivateUser_First(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage fetchByPrivateUser_First(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage findByPrivateUser_Last(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage fetchByPrivateUser_Last(
        boolean messagePublic, long recipientUserId, java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] findByPrivateUser_PrevAndNext(
        long chatMessageId, boolean messagePublic, long recipientUserId,
        java.util.Date messageTS,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat room messages.
    *
    * @return the chat room messages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat room messages where messagePublic = &#63; and messageTS = &#63; from the database.
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @throws SystemException if a system exception occurred
    */
    public void removeByPublic(boolean messagePublic, java.util.Date messageTS)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63; from the database.
    *
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @throws SystemException if a system exception occurred
    */
    public void removeByPrivateUser(boolean messagePublic,
        long recipientUserId, java.util.Date messageTS)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat room messages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room messages where messagePublic = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param messageTS the message t s
    * @return the number of matching chat room messages
    * @throws SystemException if a system exception occurred
    */
    public int countByPublic(boolean messagePublic, java.util.Date messageTS)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
    *
    * @param messagePublic the message public
    * @param recipientUserId the recipient user ID
    * @param messageTS the message t s
    * @return the number of matching chat room messages
    * @throws SystemException if a system exception occurred
    */
    public int countByPrivateUser(boolean messagePublic, long recipientUserId,
        java.util.Date messageTS)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room messages.
    *
    * @return the number of chat room messages
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
