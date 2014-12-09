package br.gov.camara.edemocracia.portlets.chat.service.persistence;

import br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomTwitterImpl;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomTwitterModelImpl;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomMessagePersistence;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomPersistence;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomTwitterPersistence;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomUserPersistence;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomVideoPersistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the chat room twitter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomTwitterPersistence
 * @see ChatRoomTwitterUtil
 * @generated
 */
public class ChatRoomTwitterPersistenceImpl extends BasePersistenceImpl<ChatRoomTwitter>
    implements ChatRoomTwitterPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ChatRoomTwitterUtil} to access the chat room twitter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ChatRoomTwitterImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChatRoomTwitterModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomTwitterModelImpl.FINDER_CACHE_ENABLED,
            ChatRoomTwitterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChatRoomTwitterModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomTwitterModelImpl.FINDER_CACHE_ENABLED,
            ChatRoomTwitterImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChatRoomTwitterModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomTwitterModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CHATROOMTWITTER = "SELECT chatRoomTwitter FROM ChatRoomTwitter chatRoomTwitter";
    private static final String _SQL_COUNT_CHATROOMTWITTER = "SELECT COUNT(chatRoomTwitter) FROM ChatRoomTwitter chatRoomTwitter";
    private static final String _ORDER_BY_ENTITY_ALIAS = "chatRoomTwitter.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChatRoomTwitter exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ChatRoomTwitterPersistenceImpl.class);
    private static ChatRoomTwitter _nullChatRoomTwitter = new ChatRoomTwitterImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ChatRoomTwitter> toCacheModel() {
                return _nullChatRoomTwitterCacheModel;
            }
        };

    private static CacheModel<ChatRoomTwitter> _nullChatRoomTwitterCacheModel = new CacheModel<ChatRoomTwitter>() {
            public ChatRoomTwitter toEntityModel() {
                return _nullChatRoomTwitter;
            }
        };

    @BeanReference(type = ChatRoomPersistence.class)
    protected ChatRoomPersistence chatRoomPersistence;
    @BeanReference(type = ChatRoomMessagePersistence.class)
    protected ChatRoomMessagePersistence chatRoomMessagePersistence;
    @BeanReference(type = ChatRoomTwitterPersistence.class)
    protected ChatRoomTwitterPersistence chatRoomTwitterPersistence;
    @BeanReference(type = ChatRoomUserPersistence.class)
    protected ChatRoomUserPersistence chatRoomUserPersistence;
    @BeanReference(type = ChatRoomVideoPersistence.class)
    protected ChatRoomVideoPersistence chatRoomVideoPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the chat room twitter in the entity cache if it is enabled.
     *
     * @param chatRoomTwitter the chat room twitter
     */
    public void cacheResult(ChatRoomTwitter chatRoomTwitter) {
        EntityCacheUtil.putResult(ChatRoomTwitterModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomTwitterImpl.class, chatRoomTwitter.getPrimaryKey(),
            chatRoomTwitter);

        chatRoomTwitter.resetOriginalValues();
    }

    /**
     * Caches the chat room twitters in the entity cache if it is enabled.
     *
     * @param chatRoomTwitters the chat room twitters
     */
    public void cacheResult(List<ChatRoomTwitter> chatRoomTwitters) {
        for (ChatRoomTwitter chatRoomTwitter : chatRoomTwitters) {
            if (EntityCacheUtil.getResult(
                        ChatRoomTwitterModelImpl.ENTITY_CACHE_ENABLED,
                        ChatRoomTwitterImpl.class,
                        chatRoomTwitter.getPrimaryKey()) == null) {
                cacheResult(chatRoomTwitter);
            } else {
                chatRoomTwitter.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all chat room twitters.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ChatRoomTwitterImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ChatRoomTwitterImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the chat room twitter.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ChatRoomTwitter chatRoomTwitter) {
        EntityCacheUtil.removeResult(ChatRoomTwitterModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomTwitterImpl.class, chatRoomTwitter.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ChatRoomTwitter> chatRoomTwitters) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ChatRoomTwitter chatRoomTwitter : chatRoomTwitters) {
            EntityCacheUtil.removeResult(ChatRoomTwitterModelImpl.ENTITY_CACHE_ENABLED,
                ChatRoomTwitterImpl.class, chatRoomTwitter.getPrimaryKey());
        }
    }

    /**
     * Creates a new chat room twitter with the primary key. Does not add the chat room twitter to the database.
     *
     * @param twitterId the primary key for the new chat room twitter
     * @return the new chat room twitter
     */
    public ChatRoomTwitter create(long twitterId) {
        ChatRoomTwitter chatRoomTwitter = new ChatRoomTwitterImpl();

        chatRoomTwitter.setNew(true);
        chatRoomTwitter.setPrimaryKey(twitterId);

        return chatRoomTwitter;
    }

    /**
     * Removes the chat room twitter with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param twitterId the primary key of the chat room twitter
     * @return the chat room twitter that was removed
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException if a chat room twitter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomTwitter remove(long twitterId)
        throws NoSuchChatRoomTwitterException, SystemException {
        return remove(Long.valueOf(twitterId));
    }

    /**
     * Removes the chat room twitter with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the chat room twitter
     * @return the chat room twitter that was removed
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException if a chat room twitter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoomTwitter remove(Serializable primaryKey)
        throws NoSuchChatRoomTwitterException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ChatRoomTwitter chatRoomTwitter = (ChatRoomTwitter) session.get(ChatRoomTwitterImpl.class,
                    primaryKey);

            if (chatRoomTwitter == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchChatRoomTwitterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(chatRoomTwitter);
        } catch (NoSuchChatRoomTwitterException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ChatRoomTwitter removeImpl(ChatRoomTwitter chatRoomTwitter)
        throws SystemException {
        chatRoomTwitter = toUnwrappedModel(chatRoomTwitter);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, chatRoomTwitter);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(chatRoomTwitter);

        return chatRoomTwitter;
    }

    @Override
    public ChatRoomTwitter updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter chatRoomTwitter,
        boolean merge) throws SystemException {
        chatRoomTwitter = toUnwrappedModel(chatRoomTwitter);

        boolean isNew = chatRoomTwitter.isNew();

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, chatRoomTwitter, merge);

            chatRoomTwitter.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(ChatRoomTwitterModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomTwitterImpl.class, chatRoomTwitter.getPrimaryKey(),
            chatRoomTwitter);

        return chatRoomTwitter;
    }

    protected ChatRoomTwitter toUnwrappedModel(ChatRoomTwitter chatRoomTwitter) {
        if (chatRoomTwitter instanceof ChatRoomTwitterImpl) {
            return chatRoomTwitter;
        }

        ChatRoomTwitterImpl chatRoomTwitterImpl = new ChatRoomTwitterImpl();

        chatRoomTwitterImpl.setNew(chatRoomTwitter.isNew());
        chatRoomTwitterImpl.setPrimaryKey(chatRoomTwitter.getPrimaryKey());

        chatRoomTwitterImpl.setTwitterId(chatRoomTwitter.getTwitterId());
        chatRoomTwitterImpl.setTwitterTitle(chatRoomTwitter.getTwitterTitle());
        chatRoomTwitterImpl.setTwitterDescription(chatRoomTwitter.getTwitterDescription());
        chatRoomTwitterImpl.setTwitterEnabled(chatRoomTwitter.isTwitterEnabled());
        chatRoomTwitterImpl.setTwitterHashtag(chatRoomTwitter.getTwitterHashtag());
        chatRoomTwitterImpl.setTwitterDataWidgetId(chatRoomTwitter.getTwitterDataWidgetId());

        return chatRoomTwitterImpl;
    }

    /**
     * Returns the chat room twitter with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the chat room twitter
     * @return the chat room twitter
     * @throws com.liferay.portal.NoSuchModelException if a chat room twitter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoomTwitter findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the chat room twitter with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException} if it could not be found.
     *
     * @param twitterId the primary key of the chat room twitter
     * @return the chat room twitter
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException if a chat room twitter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomTwitter findByPrimaryKey(long twitterId)
        throws NoSuchChatRoomTwitterException, SystemException {
        ChatRoomTwitter chatRoomTwitter = fetchByPrimaryKey(twitterId);

        if (chatRoomTwitter == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + twitterId);
            }

            throw new NoSuchChatRoomTwitterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                twitterId);
        }

        return chatRoomTwitter;
    }

    /**
     * Returns the chat room twitter with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the chat room twitter
     * @return the chat room twitter, or <code>null</code> if a chat room twitter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoomTwitter fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the chat room twitter with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param twitterId the primary key of the chat room twitter
     * @return the chat room twitter, or <code>null</code> if a chat room twitter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomTwitter fetchByPrimaryKey(long twitterId)
        throws SystemException {
        ChatRoomTwitter chatRoomTwitter = (ChatRoomTwitter) EntityCacheUtil.getResult(ChatRoomTwitterModelImpl.ENTITY_CACHE_ENABLED,
                ChatRoomTwitterImpl.class, twitterId);

        if (chatRoomTwitter == _nullChatRoomTwitter) {
            return null;
        }

        if (chatRoomTwitter == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                chatRoomTwitter = (ChatRoomTwitter) session.get(ChatRoomTwitterImpl.class,
                        Long.valueOf(twitterId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (chatRoomTwitter != null) {
                    cacheResult(chatRoomTwitter);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ChatRoomTwitterModelImpl.ENTITY_CACHE_ENABLED,
                        ChatRoomTwitterImpl.class, twitterId,
                        _nullChatRoomTwitter);
                }

                closeSession(session);
            }
        }

        return chatRoomTwitter;
    }

    /**
     * Returns all the chat room twitters.
     *
     * @return the chat room twitters
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomTwitter> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<ChatRoomTwitter> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    public List<ChatRoomTwitter> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<ChatRoomTwitter> list = (List<ChatRoomTwitter>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CHATROOMTWITTER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CHATROOMTWITTER;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<ChatRoomTwitter>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ChatRoomTwitter>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the chat room twitters from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (ChatRoomTwitter chatRoomTwitter : findAll()) {
            remove(chatRoomTwitter);
        }
    }

    /**
     * Returns the number of chat room twitters.
     *
     * @return the number of chat room twitters
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CHATROOMTWITTER);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the chat room twitter persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ChatRoomTwitter>> listenersList = new ArrayList<ModelListener<ChatRoomTwitter>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ChatRoomTwitter>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ChatRoomTwitterImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
