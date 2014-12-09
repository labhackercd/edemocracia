package br.gov.camara.edemocracia.portlets.chat.service.persistence;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the chat room twitter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomTwitterPersistenceImpl
 * @see ChatRoomTwitterUtil
 * @generated
 */
public interface ChatRoomTwitterPersistence extends BasePersistence<ChatRoomTwitter> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ChatRoomTwitterUtil} to access the chat room twitter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the chat room twitter in the entity cache if it is enabled.
    *
    * @param chatRoomTwitter the chat room twitter
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter chatRoomTwitter);

    /**
    * Caches the chat room twitters in the entity cache if it is enabled.
    *
    * @param chatRoomTwitters the chat room twitters
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter> chatRoomTwitters);

    /**
    * Creates a new chat room twitter with the primary key. Does not add the chat room twitter to the database.
    *
    * @param twitterId the primary key for the new chat room twitter
    * @return the new chat room twitter
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter create(
        long twitterId);

    /**
    * Removes the chat room twitter with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param twitterId the primary key of the chat room twitter
    * @return the chat room twitter that was removed
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException if a chat room twitter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter remove(
        long twitterId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter chatRoomTwitter,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room twitter with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException} if it could not be found.
    *
    * @param twitterId the primary key of the chat room twitter
    * @return the chat room twitter
    * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException if a chat room twitter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter findByPrimaryKey(
        long twitterId)
        throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the chat room twitter with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param twitterId the primary key of the chat room twitter
    * @return the chat room twitter, or <code>null</code> if a chat room twitter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter fetchByPrimaryKey(
        long twitterId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the chat room twitters.
    *
    * @return the chat room twitters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the chat room twitters from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of chat room twitters.
    *
    * @return the number of chat room twitters
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
