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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the chat room video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomVideoPersistenceImpl
 * @see ChatRoomVideoUtil
 * @generated
 */
public interface ChatRoomVideoPersistence extends BasePersistence<ChatRoomVideo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ChatRoomVideoUtil} to access the chat room video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the chat room video in the entity cache if it is enabled.
    *
    * @param chatRoomVideo the chat room video
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo);

    /**
    * Caches the chat room videos in the entity cache if it is enabled.
    *
    * @param chatRoomVideos the chat room videos
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo> chatRoomVideos);

    /**
    * Creates a new chat room video with the primary key. Does not add the chat room video to the database.
    *
    * @param videoId the primary key for the new chat room video
    * @return the new chat room video
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo create(
        long videoId);

    /**
    * Removes the chat room video with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param videoId the primary key of the chat room video
    * @return the chat room video that was removed
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException if a chat room video with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo remove(
        long videoId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room video with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException} if it could not be found.
    *
    * @param videoId the primary key of the chat room video
    * @return the chat room video
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException if a chat room video with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo findByPrimaryKey(
        long videoId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room video with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param videoId the primary key of the chat room video
    * @return the chat room video, or <code>null</code> if a chat room video with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo fetchByPrimaryKey(
        long videoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat room videos.
    *
    * @return the chat room videos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat room videos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room videos.
    *
    * @return the number of chat room videos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
