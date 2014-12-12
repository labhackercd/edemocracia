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

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the chat room service. This utility wraps {@link ChatRoomPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomPersistence
 * @see ChatRoomPersistenceImpl
 * @generated
 */
public class ChatRoomUtil {
    private static ChatRoomPersistence _persistence;

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
    public static void clearCache(ChatRoom chatRoom) {
        getPersistence().clearCache(chatRoom);
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
    public static List<ChatRoom> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ChatRoom> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ChatRoom> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static ChatRoom update(ChatRoom chatRoom, boolean merge)
        throws SystemException {
        return getPersistence().update(chatRoom, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static ChatRoom update(ChatRoom chatRoom, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(chatRoom, merge, serviceContext);
    }

    /**
    * Caches the chat room in the entity cache if it is enabled.
    *
    * @param chatRoom the chat room
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom) {
        getPersistence().cacheResult(chatRoom);
    }

    /**
    * Caches the chat rooms in the entity cache if it is enabled.
    *
    * @param chatRooms the chat rooms
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> chatRooms) {
        getPersistence().cacheResult(chatRooms);
    }

    /**
    * Creates a new chat room with the primary key. Does not add the chat room to the database.
    *
    * @param roomId the primary key for the new chat room
    * @return the new chat room
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom create(
        long roomId) {
        return getPersistence().create(roomId);
    }

    /**
    * Removes the chat room with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param roomId the primary key of the chat room
    * @return the chat room that was removed
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom remove(
        long roomId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(roomId);
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(chatRoom, merge);
    }

    /**
    * Returns the chat room with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException} if it could not be found.
    *
    * @param roomId the primary key of the chat room
    * @return the chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByPrimaryKey(
        long roomId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(roomId);
    }

    /**
    * Returns the chat room with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param roomId the primary key of the chat room
    * @return the chat room, or <code>null</code> if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByPrimaryKey(
        long roomId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(roomId);
    }

    /**
    * Returns all the chat rooms where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the chat rooms where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of chat rooms
    * @param end the upper bound of the range of chat rooms (not inclusive)
    * @return the range of matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the chat rooms where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of chat rooms
    * @param end the upper bound of the range of chat rooms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first chat room in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the first chat room in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room, or <code>null</code> if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last chat room in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the last chat room in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room, or <code>null</code> if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the chat rooms before and after the current chat room in the ordered set where companyId = &#63;.
    *
    * @param roomId the primary key of the current chat room
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom[] findByCompanyId_PrevAndNext(
        long roomId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(roomId, companyId,
            orderByComparator);
    }

    /**
    * Returns all the chat rooms where roomName = &#63; and groupId = &#63;.
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @return the matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByGroupRoomName(
        java.lang.String roomName, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupRoomName(roomName, groupId);
    }

    /**
    * Returns a range of all the chat rooms where roomName = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @param start the lower bound of the range of chat rooms
    * @param end the upper bound of the range of chat rooms (not inclusive)
    * @return the range of matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByGroupRoomName(
        java.lang.String roomName, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupRoomName(roomName, groupId, start, end);
    }

    /**
    * Returns an ordered range of all the chat rooms where roomName = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @param start the lower bound of the range of chat rooms
    * @param end the upper bound of the range of chat rooms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByGroupRoomName(
        java.lang.String roomName, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupRoomName(roomName, groupId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first chat room in the ordered set where roomName = &#63; and groupId = &#63;.
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByGroupRoomName_First(
        java.lang.String roomName, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupRoomName_First(roomName, groupId,
            orderByComparator);
    }

    /**
    * Returns the first chat room in the ordered set where roomName = &#63; and groupId = &#63;.
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room, or <code>null</code> if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByGroupRoomName_First(
        java.lang.String roomName, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGroupRoomName_First(roomName, groupId,
            orderByComparator);
    }

    /**
    * Returns the last chat room in the ordered set where roomName = &#63; and groupId = &#63;.
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByGroupRoomName_Last(
        java.lang.String roomName, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupRoomName_Last(roomName, groupId,
            orderByComparator);
    }

    /**
    * Returns the last chat room in the ordered set where roomName = &#63; and groupId = &#63;.
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room, or <code>null</code> if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByGroupRoomName_Last(
        java.lang.String roomName, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByGroupRoomName_Last(roomName, groupId,
            orderByComparator);
    }

    /**
    * Returns the chat rooms before and after the current chat room in the ordered set where roomName = &#63; and groupId = &#63;.
    *
    * @param roomId the primary key of the current chat room
    * @param roomName the room name
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom[] findByGroupRoomName_PrevAndNext(
        long roomId, java.lang.String roomName, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupRoomName_PrevAndNext(roomId, roomName, groupId,
            orderByComparator);
    }

    /**
    * Returns all the chat rooms where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the chat rooms where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of chat rooms
    * @param end the upper bound of the range of chat rooms (not inclusive)
    * @return the range of matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the chat rooms where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of chat rooms
    * @param end the upper bound of the range of chat rooms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first chat room in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first chat room in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room, or <code>null</code> if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last chat room in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last chat room in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room, or <code>null</code> if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the chat rooms before and after the current chat room in the ordered set where groupId = &#63;.
    *
    * @param roomId the primary key of the current chat room
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom[] findByGroupId_PrevAndNext(
        long roomId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(roomId, groupId, orderByComparator);
    }

    /**
    * Returns all the chat rooms.
    *
    * @return the chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the chat rooms.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of chat rooms
    * @param end the upper bound of the range of chat rooms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the chat rooms where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Removes all the chat rooms where roomName = &#63; and groupId = &#63; from the database.
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupRoomName(java.lang.String roomName,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupRoomName(roomName, groupId);
    }

    /**
    * Removes all the chat rooms where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Removes all the chat rooms from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of chat rooms where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns the number of chat rooms where roomName = &#63; and groupId = &#63;.
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @return the number of matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupRoomName(java.lang.String roomName,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupRoomName(roomName, groupId);
    }

    /**
    * Returns the number of chat rooms where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns the number of chat rooms.
    *
    * @return the number of chat rooms
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the chat room users associated with the chat room.
    *
    * @param pk the primary key of the chat room
    * @return the chat room users associated with the chat room
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> getChatRoomUsers(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getChatRoomUsers(pk);
    }

    /**
    * Returns a range of all the chat room users associated with the chat room.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the chat room
    * @param start the lower bound of the range of chat rooms
    * @param end the upper bound of the range of chat rooms (not inclusive)
    * @return the range of chat room users associated with the chat room
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> getChatRoomUsers(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getChatRoomUsers(pk, start, end);
    }

    /**
    * Returns an ordered range of all the chat room users associated with the chat room.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the chat room
    * @param start the lower bound of the range of chat rooms
    * @param end the upper bound of the range of chat rooms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of chat room users associated with the chat room
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> getChatRoomUsers(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .getChatRoomUsers(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of chat room users associated with the chat room.
    *
    * @param pk the primary key of the chat room
    * @return the number of chat room users associated with the chat room
    * @throws SystemException if a system exception occurred
    */
    public static int getChatRoomUsersSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getChatRoomUsersSize(pk);
    }

    /**
    * Returns <code>true</code> if the chat room user is associated with the chat room.
    *
    * @param pk the primary key of the chat room
    * @param chatRoomUserPK the primary key of the chat room user
    * @return <code>true</code> if the chat room user is associated with the chat room; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsChatRoomUser(long pk, long chatRoomUserPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsChatRoomUser(pk, chatRoomUserPK);
    }

    /**
    * Returns <code>true</code> if the chat room has any chat room users associated with it.
    *
    * @param pk the primary key of the chat room to check for associations with chat room users
    * @return <code>true</code> if the chat room has any chat room users associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsChatRoomUsers(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsChatRoomUsers(pk);
    }

    /**
    * Returns all the chat room messages associated with the chat room.
    *
    * @param pk the primary key of the chat room
    * @return the chat room messages associated with the chat room
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> getChatRoomMessages(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getChatRoomMessages(pk);
    }

    /**
    * Returns a range of all the chat room messages associated with the chat room.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the chat room
    * @param start the lower bound of the range of chat rooms
    * @param end the upper bound of the range of chat rooms (not inclusive)
    * @return the range of chat room messages associated with the chat room
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> getChatRoomMessages(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getChatRoomMessages(pk, start, end);
    }

    /**
    * Returns an ordered range of all the chat room messages associated with the chat room.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the chat room
    * @param start the lower bound of the range of chat rooms
    * @param end the upper bound of the range of chat rooms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of chat room messages associated with the chat room
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> getChatRoomMessages(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .getChatRoomMessages(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of chat room messages associated with the chat room.
    *
    * @param pk the primary key of the chat room
    * @return the number of chat room messages associated with the chat room
    * @throws SystemException if a system exception occurred
    */
    public static int getChatRoomMessagesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getChatRoomMessagesSize(pk);
    }

    /**
    * Returns <code>true</code> if the chat room message is associated with the chat room.
    *
    * @param pk the primary key of the chat room
    * @param chatRoomMessagePK the primary key of the chat room message
    * @return <code>true</code> if the chat room message is associated with the chat room; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsChatRoomMessage(long pk,
        long chatRoomMessagePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsChatRoomMessage(pk, chatRoomMessagePK);
    }

    /**
    * Returns <code>true</code> if the chat room has any chat room messages associated with it.
    *
    * @param pk the primary key of the chat room to check for associations with chat room messages
    * @return <code>true</code> if the chat room has any chat room messages associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsChatRoomMessages(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsChatRoomMessages(pk);
    }

    public static ChatRoomPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ChatRoomPersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.chat.service.ClpSerializer.getServletContextName(),
                    ChatRoomPersistence.class.getName());

            ReferenceRegistry.registerReference(ChatRoomUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(ChatRoomPersistence persistence) {
    }
}
