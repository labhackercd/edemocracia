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

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the chat room user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomUserPersistenceImpl
 * @see ChatRoomUserUtil
 * @generated
 */
public interface ChatRoomUserPersistence extends BasePersistence<ChatRoomUser> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ChatRoomUserUtil} to access the chat room user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the chat room user in the entity cache if it is enabled.
    *
    * @param chatRoomUser the chat room user
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser);

    /**
    * Caches the chat room users in the entity cache if it is enabled.
    *
    * @param chatRoomUsers the chat room users
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> chatRoomUsers);

    /**
    * Creates a new chat room user with the primary key. Does not add the chat room user to the database.
    *
    * @param chatUserId the primary key for the new chat room user
    * @return the new chat room user
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser create(
        long chatUserId);

    /**
    * Removes the chat room user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param chatUserId the primary key of the chat room user
    * @return the chat room user that was removed
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser remove(
        long chatUserId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room user with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException} if it could not be found.
    *
    * @param chatUserId the primary key of the chat room user
    * @return the chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByPrimaryKey(
        long chatUserId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param chatUserId the primary key of the chat room user
    * @return the chat room user, or <code>null</code> if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByPrimaryKey(
        long chatUserId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat room users where chatRoomId = &#63; and userId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @return the matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByCR_U(
        long chatRoomId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the chat room users where chatRoomId = &#63; and userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @param start the lower bound of the range of chat room users
    * @param end the upper bound of the range of chat room users (not inclusive)
    * @return the range of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByCR_U(
        long chatRoomId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the chat room users where chatRoomId = &#63; and userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @param start the lower bound of the range of chat room users
    * @param end the upper bound of the range of chat room users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByCR_U(
        long chatRoomId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63; and userId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByCR_U_First(
        long chatRoomId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63; and userId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByCR_U_First(
        long chatRoomId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63; and userId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByCR_U_Last(
        long chatRoomId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63; and userId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByCR_U_Last(
        long chatRoomId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room users before and after the current chat room user in the ordered set where chatRoomId = &#63; and userId = &#63;.
    *
    * @param chatUserId the primary key of the current chat room user
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] findByCR_U_PrevAndNext(
        long chatUserId, long chatRoomId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat room users where chatRoomId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @return the matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByCR(
        long chatRoomId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the chat room users where chatRoomId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param chatRoomId the chat room ID
    * @param start the lower bound of the range of chat room users
    * @param end the upper bound of the range of chat room users (not inclusive)
    * @return the range of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByCR(
        long chatRoomId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the chat room users where chatRoomId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param chatRoomId the chat room ID
    * @param start the lower bound of the range of chat room users
    * @param end the upper bound of the range of chat room users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByCR(
        long chatRoomId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByCR_First(
        long chatRoomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByCR_First(
        long chatRoomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByCR_Last(
        long chatRoomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByCR_Last(
        long chatRoomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room users before and after the current chat room user in the ordered set where chatRoomId = &#63;.
    *
    * @param chatUserId the primary key of the current chat room user
    * @param chatRoomId the chat room ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] findByCR_PrevAndNext(
        long chatUserId, long chatRoomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat room users where chatRoomId = &#63; and userName = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @return the matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByName(
        long chatRoomId, java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the chat room users where chatRoomId = &#63; and userName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @param start the lower bound of the range of chat room users
    * @param end the upper bound of the range of chat room users (not inclusive)
    * @return the range of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByName(
        long chatRoomId, java.lang.String userName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the chat room users where chatRoomId = &#63; and userName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @param start the lower bound of the range of chat room users
    * @param end the upper bound of the range of chat room users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByName(
        long chatRoomId, java.lang.String userName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63; and userName = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByName_First(
        long chatRoomId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63; and userName = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByName_First(
        long chatRoomId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63; and userName = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByName_Last(
        long chatRoomId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63; and userName = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByName_Last(
        long chatRoomId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room users before and after the current chat room user in the ordered set where chatRoomId = &#63; and userName = &#63;.
    *
    * @param chatUserId the primary key of the current chat room user
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] findByName_PrevAndNext(
        long chatUserId, long chatRoomId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat room users where chatRoomId = &#63; and userEmail = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @return the matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByEmail(
        long chatRoomId, java.lang.String userEmail)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the chat room users where chatRoomId = &#63; and userEmail = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @param start the lower bound of the range of chat room users
    * @param end the upper bound of the range of chat room users (not inclusive)
    * @return the range of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByEmail(
        long chatRoomId, java.lang.String userEmail, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the chat room users where chatRoomId = &#63; and userEmail = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @param start the lower bound of the range of chat room users
    * @param end the upper bound of the range of chat room users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByEmail(
        long chatRoomId, java.lang.String userEmail, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63; and userEmail = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByEmail_First(
        long chatRoomId, java.lang.String userEmail,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63; and userEmail = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByEmail_First(
        long chatRoomId, java.lang.String userEmail,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63; and userEmail = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByEmail_Last(
        long chatRoomId, java.lang.String userEmail,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63; and userEmail = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByEmail_Last(
        long chatRoomId, java.lang.String userEmail,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room users before and after the current chat room user in the ordered set where chatRoomId = &#63; and userEmail = &#63;.
    *
    * @param chatUserId the primary key of the current chat room user
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] findByEmail_PrevAndNext(
        long chatUserId, long chatRoomId, java.lang.String userEmail,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat room users.
    *
    * @return the chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the chat room users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of chat room users
    * @param end the upper bound of the range of chat room users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of chat room users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat room users where chatRoomId = &#63; and userId = &#63; from the database.
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCR_U(long chatRoomId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat room users where chatRoomId = &#63; from the database.
    *
    * @param chatRoomId the chat room ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCR(long chatRoomId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat room users where chatRoomId = &#63; and userName = &#63; from the database.
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @throws SystemException if a system exception occurred
    */
    public void removeByName(long chatRoomId, java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat room users where chatRoomId = &#63; and userEmail = &#63; from the database.
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @throws SystemException if a system exception occurred
    */
    public void removeByEmail(long chatRoomId, java.lang.String userEmail)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat room users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room users where chatRoomId = &#63; and userId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @return the number of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public int countByCR_U(long chatRoomId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room users where chatRoomId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @return the number of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public int countByCR(long chatRoomId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room users where chatRoomId = &#63; and userName = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @return the number of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public int countByName(long chatRoomId, java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room users where chatRoomId = &#63; and userEmail = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @return the number of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public int countByEmail(long chatRoomId, java.lang.String userEmail)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room users.
    *
    * @return the number of chat room users
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
