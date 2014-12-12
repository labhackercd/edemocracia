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

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the chat room video service. This utility wraps {@link ChatRoomVideoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomVideoPersistence
 * @see ChatRoomVideoPersistenceImpl
 * @generated
 */
public class ChatRoomVideoUtil {
    private static ChatRoomVideoPersistence _persistence;

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
    public static void clearCache(ChatRoomVideo chatRoomVideo) {
        getPersistence().clearCache(chatRoomVideo);
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
    public static List<ChatRoomVideo> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ChatRoomVideo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ChatRoomVideo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static ChatRoomVideo update(ChatRoomVideo chatRoomVideo,
        boolean merge) throws SystemException {
        return getPersistence().update(chatRoomVideo, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static ChatRoomVideo update(ChatRoomVideo chatRoomVideo,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(chatRoomVideo, merge, serviceContext);
    }

    /**
    * Caches the chat room video in the entity cache if it is enabled.
    *
    * @param chatRoomVideo the chat room video
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo) {
        getPersistence().cacheResult(chatRoomVideo);
    }

    /**
    * Caches the chat room videos in the entity cache if it is enabled.
    *
    * @param chatRoomVideos the chat room videos
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo> chatRoomVideos) {
        getPersistence().cacheResult(chatRoomVideos);
    }

    /**
    * Creates a new chat room video with the primary key. Does not add the chat room video to the database.
    *
    * @param videoId the primary key for the new chat room video
    * @return the new chat room video
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo create(
        long videoId) {
        return getPersistence().create(videoId);
    }

    /**
    * Removes the chat room video with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param videoId the primary key of the chat room video
    * @return the chat room video that was removed
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException if a chat room video with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo remove(
        long videoId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(videoId);
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(chatRoomVideo, merge);
    }

    /**
    * Returns the chat room video with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException} if it could not be found.
    *
    * @param videoId the primary key of the chat room video
    * @return the chat room video
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException if a chat room video with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo findByPrimaryKey(
        long videoId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(videoId);
    }

    /**
    * Returns the chat room video with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param videoId the primary key of the chat room video
    * @return the chat room video, or <code>null</code> if a chat room video with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo fetchByPrimaryKey(
        long videoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(videoId);
    }

    /**
    * Returns all the chat room videos.
    *
    * @return the chat room videos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the chat room videos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of chat room videos
    * @param end the upper bound of the range of chat room videos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of chat room videos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the chat room videos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of chat room videos.
    *
    * @return the number of chat room videos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ChatRoomVideoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ChatRoomVideoPersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.chat.service.ClpSerializer.getServletContextName(),
                    ChatRoomVideoPersistence.class.getName());

            ReferenceRegistry.registerReference(ChatRoomVideoUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(ChatRoomVideoPersistence persistence) {
    }
}
