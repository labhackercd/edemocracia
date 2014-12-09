package br.gov.camara.edemocracia.portlets.chat.service.persistence;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the chat room twitter service. This utility wraps {@link ChatRoomTwitterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomTwitterPersistence
 * @see ChatRoomTwitterPersistenceImpl
 * @generated
 */
public class ChatRoomTwitterUtil {
    private static ChatRoomTwitterPersistence _persistence;

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
    public static void clearCache(ChatRoomTwitter chatRoomTwitter) {
        getPersistence().clearCache(chatRoomTwitter);
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
    public static List<ChatRoomTwitter> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ChatRoomTwitter> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ChatRoomTwitter> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static ChatRoomTwitter update(ChatRoomTwitter chatRoomTwitter,
        boolean merge) throws SystemException {
        return getPersistence().update(chatRoomTwitter, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static ChatRoomTwitter update(ChatRoomTwitter chatRoomTwitter,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(chatRoomTwitter, merge, serviceContext);
    }

    /**
    * Caches the chat room twitter in the entity cache if it is enabled.
    *
    * @param chatRoomTwitter the chat room twitter
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter chatRoomTwitter) {
        getPersistence().cacheResult(chatRoomTwitter);
    }

    /**
    * Caches the chat room twitters in the entity cache if it is enabled.
    *
    * @param chatRoomTwitters the chat room twitters
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter> chatRoomTwitters) {
        getPersistence().cacheResult(chatRoomTwitters);
    }

    /**
    * Creates a new chat room twitter with the primary key. Does not add the chat room twitter to the database.
    *
    * @param twitterId the primary key for the new chat room twitter
    * @return the new chat room twitter
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter create(
        long twitterId) {
        return getPersistence().create(twitterId);
    }

    /**
    * Removes the chat room twitter with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param twitterId the primary key of the chat room twitter
    * @return the chat room twitter that was removed
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException if a chat room twitter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter remove(
        long twitterId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(twitterId);
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter chatRoomTwitter,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(chatRoomTwitter, merge);
    }

    /**
    * Returns the chat room twitter with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException} if it could not be found.
    *
    * @param twitterId the primary key of the chat room twitter
    * @return the chat room twitter
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException if a chat room twitter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter findByPrimaryKey(
        long twitterId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(twitterId);
    }

    /**
    * Returns the chat room twitter with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param twitterId the primary key of the chat room twitter
    * @return the chat room twitter, or <code>null</code> if a chat room twitter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter fetchByPrimaryKey(
        long twitterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(twitterId);
    }

    /**
    * Returns all the chat room twitters.
    *
    * @return the chat room twitters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the chat room twitters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of chat room twitters
    * @param end the upper bound of the range of chat room twitters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of chat room twitters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the chat room twitters from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of chat room twitters.
    *
    * @return the number of chat room twitters
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ChatRoomTwitterPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ChatRoomTwitterPersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.chat.service.ClpSerializer.getServletContextName(),
                    ChatRoomTwitterPersistence.class.getName());

            ReferenceRegistry.registerReference(ChatRoomTwitterUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(ChatRoomTwitterPersistence persistence) {
    }
}
