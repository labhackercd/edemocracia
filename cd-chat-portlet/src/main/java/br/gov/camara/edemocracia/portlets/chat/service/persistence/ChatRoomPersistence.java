package br.gov.camara.edemocracia.portlets.chat.service.persistence;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the chat room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomPersistenceImpl
 * @see ChatRoomUtil
 * @generated
 */
public interface ChatRoomPersistence extends BasePersistence<ChatRoom> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ChatRoomUtil} to access the chat room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the chat room in the entity cache if it is enabled.
    *
    * @param chatRoom the chat room
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom);

    /**
    * Caches the chat rooms in the entity cache if it is enabled.
    *
    * @param chatRooms the chat rooms
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> chatRooms);

    /**
    * Creates a new chat room with the primary key. Does not add the chat room to the database.
    *
    * @param roomId the primary key for the new chat room
    * @return the new chat room
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom create(
        long roomId);

    /**
    * Removes the chat room with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param roomId the primary key of the chat room
    * @return the chat room that was removed
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom remove(
        long roomId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException} if it could not be found.
    *
    * @param roomId the primary key of the chat room
    * @return the chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByPrimaryKey(
        long roomId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param roomId the primary key of the chat room
    * @return the chat room, or <code>null</code> if a chat room with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByPrimaryKey(
        long roomId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat rooms where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room, or <code>null</code> if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room in the ordered set where companyId = &#63;.
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room, or <code>null</code> if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom[] findByCompanyId_PrevAndNext(
        long roomId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat rooms where roomName = &#63; and groupId = &#63;.
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @return the matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByGroupRoomName(
        java.lang.String roomName, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByGroupRoomName(
        java.lang.String roomName, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByGroupRoomName(
        java.lang.String roomName, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByGroupRoomName_First(
        java.lang.String roomName, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room in the ordered set where roomName = &#63; and groupId = &#63;.
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room, or <code>null</code> if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByGroupRoomName_First(
        java.lang.String roomName, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByGroupRoomName_Last(
        java.lang.String roomName, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room in the ordered set where roomName = &#63; and groupId = &#63;.
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room, or <code>null</code> if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByGroupRoomName_Last(
        java.lang.String roomName, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom[] findByGroupRoomName_PrevAndNext(
        long roomId, java.lang.String roomName, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat rooms where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first chat room in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room, or <code>null</code> if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last chat room in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room, or <code>null</code> if a matching chat room could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom[] findByGroupId_PrevAndNext(
        long roomId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat rooms.
    *
    * @return the chat rooms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat rooms where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat rooms where roomName = &#63; and groupId = &#63; from the database.
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupRoomName(java.lang.String roomName, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat rooms where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat rooms from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat rooms where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat rooms where roomName = &#63; and groupId = &#63;.
    *
    * @param roomName the room name
    * @param groupId the group ID
    * @return the number of matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupRoomName(java.lang.String roomName, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat rooms where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching chat rooms
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat rooms.
    *
    * @return the number of chat rooms
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat room users associated with the chat room.
    *
    * @param pk the primary key of the chat room
    * @return the chat room users associated with the chat room
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> getChatRoomUsers(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> getChatRoomUsers(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> getChatRoomUsers(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room users associated with the chat room.
    *
    * @param pk the primary key of the chat room
    * @return the number of chat room users associated with the chat room
    * @throws SystemException if a system exception occurred
    */
    public int getChatRoomUsersSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the chat room user is associated with the chat room.
    *
    * @param pk the primary key of the chat room
    * @param chatRoomUserPK the primary key of the chat room user
    * @return <code>true</code> if the chat room user is associated with the chat room; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsChatRoomUser(long pk, long chatRoomUserPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the chat room has any chat room users associated with it.
    *
    * @param pk the primary key of the chat room to check for associations with chat room users
    * @return <code>true</code> if the chat room has any chat room users associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsChatRoomUsers(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat room messages associated with the chat room.
    *
    * @param pk the primary key of the chat room
    * @return the chat room messages associated with the chat room
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> getChatRoomMessages(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> getChatRoomMessages(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> getChatRoomMessages(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room messages associated with the chat room.
    *
    * @param pk the primary key of the chat room
    * @return the number of chat room messages associated with the chat room
    * @throws SystemException if a system exception occurred
    */
    public int getChatRoomMessagesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the chat room message is associated with the chat room.
    *
    * @param pk the primary key of the chat room
    * @param chatRoomMessagePK the primary key of the chat room message
    * @return <code>true</code> if the chat room message is associated with the chat room; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsChatRoomMessage(long pk, long chatRoomMessagePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the chat room has any chat room messages associated with it.
    *
    * @param pk the primary key of the chat room to check for associations with chat room messages
    * @return <code>true</code> if the chat room has any chat room messages associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsChatRoomMessages(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;
}
