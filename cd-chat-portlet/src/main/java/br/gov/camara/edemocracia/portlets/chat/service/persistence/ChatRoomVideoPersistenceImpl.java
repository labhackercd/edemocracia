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

import br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomVideoImpl;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomVideoModelImpl;
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
 * The persistence implementation for the chat room video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomVideoPersistence
 * @see ChatRoomVideoUtil
 * @generated
 */
public class ChatRoomVideoPersistenceImpl extends BasePersistenceImpl<ChatRoomVideo>
    implements ChatRoomVideoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ChatRoomVideoUtil} to access the chat room video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ChatRoomVideoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChatRoomVideoModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomVideoModelImpl.FINDER_CACHE_ENABLED,
            ChatRoomVideoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChatRoomVideoModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomVideoModelImpl.FINDER_CACHE_ENABLED,
            ChatRoomVideoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChatRoomVideoModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomVideoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CHATROOMVIDEO = "SELECT chatRoomVideo FROM ChatRoomVideo chatRoomVideo";
    private static final String _SQL_COUNT_CHATROOMVIDEO = "SELECT COUNT(chatRoomVideo) FROM ChatRoomVideo chatRoomVideo";
    private static final String _ORDER_BY_ENTITY_ALIAS = "chatRoomVideo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChatRoomVideo exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ChatRoomVideoPersistenceImpl.class);
    private static ChatRoomVideo _nullChatRoomVideo = new ChatRoomVideoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ChatRoomVideo> toCacheModel() {
                return _nullChatRoomVideoCacheModel;
            }
        };

    private static CacheModel<ChatRoomVideo> _nullChatRoomVideoCacheModel = new CacheModel<ChatRoomVideo>() {
            public ChatRoomVideo toEntityModel() {
                return _nullChatRoomVideo;
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
     * Caches the chat room video in the entity cache if it is enabled.
     *
     * @param chatRoomVideo the chat room video
     */
    public void cacheResult(ChatRoomVideo chatRoomVideo) {
        EntityCacheUtil.putResult(ChatRoomVideoModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomVideoImpl.class, chatRoomVideo.getPrimaryKey(),
            chatRoomVideo);

        chatRoomVideo.resetOriginalValues();
    }

    /**
     * Caches the chat room videos in the entity cache if it is enabled.
     *
     * @param chatRoomVideos the chat room videos
     */
    public void cacheResult(List<ChatRoomVideo> chatRoomVideos) {
        for (ChatRoomVideo chatRoomVideo : chatRoomVideos) {
            if (EntityCacheUtil.getResult(
                        ChatRoomVideoModelImpl.ENTITY_CACHE_ENABLED,
                        ChatRoomVideoImpl.class, chatRoomVideo.getPrimaryKey()) == null) {
                cacheResult(chatRoomVideo);
            } else {
                chatRoomVideo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all chat room videos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ChatRoomVideoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ChatRoomVideoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the chat room video.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ChatRoomVideo chatRoomVideo) {
        EntityCacheUtil.removeResult(ChatRoomVideoModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomVideoImpl.class, chatRoomVideo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ChatRoomVideo> chatRoomVideos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ChatRoomVideo chatRoomVideo : chatRoomVideos) {
            EntityCacheUtil.removeResult(ChatRoomVideoModelImpl.ENTITY_CACHE_ENABLED,
                ChatRoomVideoImpl.class, chatRoomVideo.getPrimaryKey());
        }
    }

    /**
     * Creates a new chat room video with the primary key. Does not add the chat room video to the database.
     *
     * @param videoId the primary key for the new chat room video
     * @return the new chat room video
     */
    public ChatRoomVideo create(long videoId) {
        ChatRoomVideo chatRoomVideo = new ChatRoomVideoImpl();

        chatRoomVideo.setNew(true);
        chatRoomVideo.setPrimaryKey(videoId);

        return chatRoomVideo;
    }

    /**
     * Removes the chat room video with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param videoId the primary key of the chat room video
     * @return the chat room video that was removed
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException if a chat room video with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomVideo remove(long videoId)
        throws NoSuchChatRoomVideoException, SystemException {
        return remove(Long.valueOf(videoId));
    }

    /**
     * Removes the chat room video with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the chat room video
     * @return the chat room video that was removed
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException if a chat room video with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoomVideo remove(Serializable primaryKey)
        throws NoSuchChatRoomVideoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ChatRoomVideo chatRoomVideo = (ChatRoomVideo) session.get(ChatRoomVideoImpl.class,
                    primaryKey);

            if (chatRoomVideo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchChatRoomVideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(chatRoomVideo);
        } catch (NoSuchChatRoomVideoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ChatRoomVideo removeImpl(ChatRoomVideo chatRoomVideo)
        throws SystemException {
        chatRoomVideo = toUnwrappedModel(chatRoomVideo);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, chatRoomVideo);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(chatRoomVideo);

        return chatRoomVideo;
    }

    @Override
    public ChatRoomVideo updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo chatRoomVideo,
        boolean merge) throws SystemException {
        chatRoomVideo = toUnwrappedModel(chatRoomVideo);

        boolean isNew = chatRoomVideo.isNew();

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, chatRoomVideo, merge);

            chatRoomVideo.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(ChatRoomVideoModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomVideoImpl.class, chatRoomVideo.getPrimaryKey(),
            chatRoomVideo);

        return chatRoomVideo;
    }

    protected ChatRoomVideo toUnwrappedModel(ChatRoomVideo chatRoomVideo) {
        if (chatRoomVideo instanceof ChatRoomVideoImpl) {
            return chatRoomVideo;
        }

        ChatRoomVideoImpl chatRoomVideoImpl = new ChatRoomVideoImpl();

        chatRoomVideoImpl.setNew(chatRoomVideo.isNew());
        chatRoomVideoImpl.setPrimaryKey(chatRoomVideo.getPrimaryKey());

        chatRoomVideoImpl.setVideoId(chatRoomVideo.getVideoId());
        chatRoomVideoImpl.setVideoTitle(chatRoomVideo.getVideoTitle());
        chatRoomVideoImpl.setVideoSubtitle(chatRoomVideo.getVideoSubtitle());
        chatRoomVideoImpl.setVideoDescription(chatRoomVideo.getVideoDescription());
        chatRoomVideoImpl.setVideoEnabled(chatRoomVideo.isVideoEnabled());
        chatRoomVideoImpl.setVideoUrl(chatRoomVideo.getVideoUrl());
        chatRoomVideoImpl.setVideoType(chatRoomVideo.getVideoType());

        return chatRoomVideoImpl;
    }

    /**
     * Returns the chat room video with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the chat room video
     * @return the chat room video
     * @throws com.liferay.portal.NoSuchModelException if a chat room video with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoomVideo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the chat room video with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException} if it could not be found.
     *
     * @param videoId the primary key of the chat room video
     * @return the chat room video
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException if a chat room video with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomVideo findByPrimaryKey(long videoId)
        throws NoSuchChatRoomVideoException, SystemException {
        ChatRoomVideo chatRoomVideo = fetchByPrimaryKey(videoId);

        if (chatRoomVideo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + videoId);
            }

            throw new NoSuchChatRoomVideoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                videoId);
        }

        return chatRoomVideo;
    }

    /**
     * Returns the chat room video with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the chat room video
     * @return the chat room video, or <code>null</code> if a chat room video with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoomVideo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the chat room video with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param videoId the primary key of the chat room video
     * @return the chat room video, or <code>null</code> if a chat room video with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomVideo fetchByPrimaryKey(long videoId)
        throws SystemException {
        ChatRoomVideo chatRoomVideo = (ChatRoomVideo) EntityCacheUtil.getResult(ChatRoomVideoModelImpl.ENTITY_CACHE_ENABLED,
                ChatRoomVideoImpl.class, videoId);

        if (chatRoomVideo == _nullChatRoomVideo) {
            return null;
        }

        if (chatRoomVideo == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                chatRoomVideo = (ChatRoomVideo) session.get(ChatRoomVideoImpl.class,
                        Long.valueOf(videoId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (chatRoomVideo != null) {
                    cacheResult(chatRoomVideo);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ChatRoomVideoModelImpl.ENTITY_CACHE_ENABLED,
                        ChatRoomVideoImpl.class, videoId, _nullChatRoomVideo);
                }

                closeSession(session);
            }
        }

        return chatRoomVideo;
    }

    /**
     * Returns all the chat room videos.
     *
     * @return the chat room videos
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomVideo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<ChatRoomVideo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    public List<ChatRoomVideo> findAll(int start, int end,
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

        List<ChatRoomVideo> list = (List<ChatRoomVideo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CHATROOMVIDEO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CHATROOMVIDEO;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<ChatRoomVideo>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ChatRoomVideo>) QueryUtil.list(q,
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
     * Removes all the chat room videos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (ChatRoomVideo chatRoomVideo : findAll()) {
            remove(chatRoomVideo);
        }
    }

    /**
     * Returns the number of chat room videos.
     *
     * @return the number of chat room videos
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CHATROOMVIDEO);

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
     * Initializes the chat room video persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ChatRoomVideo>> listenersList = new ArrayList<ModelListener<ChatRoomVideo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ChatRoomVideo>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ChatRoomVideoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
