package br.gov.camara.edemocracia.portlets.chat.service.persistence;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the chat room user service. This utility wraps {@link ChatRoomUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomUserPersistence
 * @see ChatRoomUserPersistenceImpl
 * @generated
 */
public class ChatRoomUserUtil {
    private static ChatRoomUserPersistence _persistence;

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
    public static void clearCache(ChatRoomUser chatRoomUser) {
        getPersistence().clearCache(chatRoomUser);
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
    public static List<ChatRoomUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ChatRoomUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ChatRoomUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static ChatRoomUser update(ChatRoomUser chatRoomUser, boolean merge)
        throws SystemException {
        return getPersistence().update(chatRoomUser, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static ChatRoomUser update(ChatRoomUser chatRoomUser, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(chatRoomUser, merge, serviceContext);
    }

    /**
    * Caches the chat room user in the entity cache if it is enabled.
    *
    * @param chatRoomUser the chat room user
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser) {
        getPersistence().cacheResult(chatRoomUser);
    }

    /**
    * Caches the chat room users in the entity cache if it is enabled.
    *
    * @param chatRoomUsers the chat room users
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> chatRoomUsers) {
        getPersistence().cacheResult(chatRoomUsers);
    }

    /**
    * Creates a new chat room user with the primary key. Does not add the chat room user to the database.
    *
    * @param chatUserId the primary key for the new chat room user
    * @return the new chat room user
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser create(
        long chatUserId) {
        return getPersistence().create(chatUserId);
    }

    /**
    * Removes the chat room user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param chatUserId the primary key of the chat room user
    * @return the chat room user that was removed
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser remove(
        long chatUserId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(chatUserId);
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(chatRoomUser, merge);
    }

    /**
    * Returns the chat room user with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException} if it could not be found.
    *
    * @param chatUserId the primary key of the chat room user
    * @return the chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByPrimaryKey(
        long chatUserId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(chatUserId);
    }

    /**
    * Returns the chat room user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param chatUserId the primary key of the chat room user
    * @return the chat room user, or <code>null</code> if a chat room user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByPrimaryKey(
        long chatUserId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(chatUserId);
    }

    /**
    * Returns all the chat room users where chatRoomId = &#63; and userId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @return the matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByCR_U(
        long chatRoomId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCR_U(chatRoomId, userId);
    }

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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByCR_U(
        long chatRoomId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCR_U(chatRoomId, userId, start, end);
    }

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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByCR_U(
        long chatRoomId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCR_U(chatRoomId, userId, start, end, orderByComparator);
    }

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
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByCR_U_First(
        long chatRoomId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCR_U_First(chatRoomId, userId, orderByComparator);
    }

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63; and userId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByCR_U_First(
        long chatRoomId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCR_U_First(chatRoomId, userId, orderByComparator);
    }

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
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByCR_U_Last(
        long chatRoomId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCR_U_Last(chatRoomId, userId, orderByComparator);
    }

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63; and userId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByCR_U_Last(
        long chatRoomId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCR_U_Last(chatRoomId, userId, orderByComparator);
    }

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
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] findByCR_U_PrevAndNext(
        long chatUserId, long chatRoomId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCR_U_PrevAndNext(chatUserId, chatRoomId, userId,
            orderByComparator);
    }

    /**
    * Returns all the chat room users where chatRoomId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @return the matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByCR(
        long chatRoomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCR(chatRoomId);
    }

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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByCR(
        long chatRoomId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCR(chatRoomId, start, end);
    }

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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByCR(
        long chatRoomId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCR(chatRoomId, start, end, orderByComparator);
    }

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByCR_First(
        long chatRoomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCR_First(chatRoomId, orderByComparator);
    }

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByCR_First(
        long chatRoomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCR_First(chatRoomId, orderByComparator);
    }

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByCR_Last(
        long chatRoomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCR_Last(chatRoomId, orderByComparator);
    }

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByCR_Last(
        long chatRoomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCR_Last(chatRoomId, orderByComparator);
    }

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
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] findByCR_PrevAndNext(
        long chatUserId, long chatRoomId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCR_PrevAndNext(chatUserId, chatRoomId,
            orderByComparator);
    }

    /**
    * Returns all the chat room users where chatRoomId = &#63; and userName = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @return the matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByName(
        long chatRoomId, java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByName(chatRoomId, userName);
    }

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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByName(
        long chatRoomId, java.lang.String userName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByName(chatRoomId, userName, start, end);
    }

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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByName(
        long chatRoomId, java.lang.String userName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByName(chatRoomId, userName, start, end,
            orderByComparator);
    }

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
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByName_First(
        long chatRoomId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByName_First(chatRoomId, userName, orderByComparator);
    }

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63; and userName = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByName_First(
        long chatRoomId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByName_First(chatRoomId, userName, orderByComparator);
    }

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
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByName_Last(
        long chatRoomId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByName_Last(chatRoomId, userName, orderByComparator);
    }

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63; and userName = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByName_Last(
        long chatRoomId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByName_Last(chatRoomId, userName, orderByComparator);
    }

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
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] findByName_PrevAndNext(
        long chatUserId, long chatRoomId, java.lang.String userName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByName_PrevAndNext(chatUserId, chatRoomId, userName,
            orderByComparator);
    }

    /**
    * Returns all the chat room users where chatRoomId = &#63; and userEmail = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @return the matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByEmail(
        long chatRoomId, java.lang.String userEmail)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail(chatRoomId, userEmail);
    }

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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByEmail(
        long chatRoomId, java.lang.String userEmail, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail(chatRoomId, userEmail, start, end);
    }

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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findByEmail(
        long chatRoomId, java.lang.String userEmail, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEmail(chatRoomId, userEmail, start, end,
            orderByComparator);
    }

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
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByEmail_First(
        long chatRoomId, java.lang.String userEmail,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEmail_First(chatRoomId, userEmail, orderByComparator);
    }

    /**
    * Returns the first chat room user in the ordered set where chatRoomId = &#63; and userEmail = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByEmail_First(
        long chatRoomId, java.lang.String userEmail,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEmail_First(chatRoomId, userEmail, orderByComparator);
    }

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
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser findByEmail_Last(
        long chatRoomId, java.lang.String userEmail,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEmail_Last(chatRoomId, userEmail, orderByComparator);
    }

    /**
    * Returns the last chat room user in the ordered set where chatRoomId = &#63; and userEmail = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching chat room user, or <code>null</code> if a matching chat room user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser fetchByEmail_Last(
        long chatRoomId, java.lang.String userEmail,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEmail_Last(chatRoomId, userEmail, orderByComparator);
    }

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
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] findByEmail_PrevAndNext(
        long chatUserId, long chatRoomId, java.lang.String userEmail,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEmail_PrevAndNext(chatUserId, chatRoomId, userEmail,
            orderByComparator);
    }

    /**
    * Returns all the chat room users.
    *
    * @return the chat room users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the chat room users where chatRoomId = &#63; and userId = &#63; from the database.
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCR_U(long chatRoomId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCR_U(chatRoomId, userId);
    }

    /**
    * Removes all the chat room users where chatRoomId = &#63; from the database.
    *
    * @param chatRoomId the chat room ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCR(long chatRoomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCR(chatRoomId);
    }

    /**
    * Removes all the chat room users where chatRoomId = &#63; and userName = &#63; from the database.
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByName(long chatRoomId, java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByName(chatRoomId, userName);
    }

    /**
    * Removes all the chat room users where chatRoomId = &#63; and userEmail = &#63; from the database.
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @throws SystemException if a system exception occurred
    */
    public static void removeByEmail(long chatRoomId, java.lang.String userEmail)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByEmail(chatRoomId, userEmail);
    }

    /**
    * Removes all the chat room users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of chat room users where chatRoomId = &#63; and userId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userId the user ID
    * @return the number of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public static int countByCR_U(long chatRoomId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCR_U(chatRoomId, userId);
    }

    /**
    * Returns the number of chat room users where chatRoomId = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @return the number of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public static int countByCR(long chatRoomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCR(chatRoomId);
    }

    /**
    * Returns the number of chat room users where chatRoomId = &#63; and userName = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userName the user name
    * @return the number of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public static int countByName(long chatRoomId, java.lang.String userName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByName(chatRoomId, userName);
    }

    /**
    * Returns the number of chat room users where chatRoomId = &#63; and userEmail = &#63;.
    *
    * @param chatRoomId the chat room ID
    * @param userEmail the user email
    * @return the number of matching chat room users
    * @throws SystemException if a system exception occurred
    */
    public static int countByEmail(long chatRoomId, java.lang.String userEmail)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEmail(chatRoomId, userEmail);
    }

    /**
    * Returns the number of chat room users.
    *
    * @return the number of chat room users
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ChatRoomUserPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ChatRoomUserPersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.chat.service.ClpSerializer.getServletContextName(),
                    ChatRoomUserPersistence.class.getName());

            ReferenceRegistry.registerReference(ChatRoomUserUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(ChatRoomUserPersistence persistence) {
    }
}
