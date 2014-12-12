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

import br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserImpl;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserModelImpl;
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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
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
 * The persistence implementation for the chat room user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomUserPersistence
 * @see ChatRoomUserUtil
 * @generated
 */
public class ChatRoomUserPersistenceImpl extends BasePersistenceImpl<ChatRoomUser>
    implements ChatRoomUserPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ChatRoomUserUtil} to access the chat room user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ChatRoomUserImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CR_U = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, ChatRoomUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCR_U",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CR_U = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, ChatRoomUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCR_U",
            new String[] { Long.class.getName(), Long.class.getName() },
            ChatRoomUserModelImpl.CHATROOMID_COLUMN_BITMASK |
            ChatRoomUserModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CR_U = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCR_U",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CR = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, ChatRoomUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCR",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CR = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, ChatRoomUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCR",
            new String[] { Long.class.getName() },
            ChatRoomUserModelImpl.CHATROOMID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CR = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCR",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, ChatRoomUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, ChatRoomUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
            new String[] { Long.class.getName(), String.class.getName() },
            ChatRoomUserModelImpl.CHATROOMID_COLUMN_BITMASK |
            ChatRoomUserModelImpl.USERNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { Long.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, ChatRoomUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, ChatRoomUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
            new String[] { Long.class.getName(), String.class.getName() },
            ChatRoomUserModelImpl.CHATROOMID_COLUMN_BITMASK |
            ChatRoomUserModelImpl.USEREMAIL_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
            new String[] { Long.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, ChatRoomUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, ChatRoomUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CHATROOMUSER = "SELECT chatRoomUser FROM ChatRoomUser chatRoomUser";
    private static final String _SQL_SELECT_CHATROOMUSER_WHERE = "SELECT chatRoomUser FROM ChatRoomUser chatRoomUser WHERE ";
    private static final String _SQL_COUNT_CHATROOMUSER = "SELECT COUNT(chatRoomUser) FROM ChatRoomUser chatRoomUser";
    private static final String _SQL_COUNT_CHATROOMUSER_WHERE = "SELECT COUNT(chatRoomUser) FROM ChatRoomUser chatRoomUser WHERE ";
    private static final String _FINDER_COLUMN_CR_U_CHATROOMID_2 = "chatRoomUser.chatRoomId = ? AND ";
    private static final String _FINDER_COLUMN_CR_U_USERID_2 = "chatRoomUser.userId = ?";
    private static final String _FINDER_COLUMN_CR_CHATROOMID_2 = "chatRoomUser.chatRoomId = ?";
    private static final String _FINDER_COLUMN_NAME_CHATROOMID_2 = "chatRoomUser.chatRoomId = ? AND ";
    private static final String _FINDER_COLUMN_NAME_USERNAME_1 = "chatRoomUser.userName IS NULL";
    private static final String _FINDER_COLUMN_NAME_USERNAME_2 = "chatRoomUser.userName = ?";
    private static final String _FINDER_COLUMN_NAME_USERNAME_3 = "(chatRoomUser.userName IS NULL OR chatRoomUser.userName = ?)";
    private static final String _FINDER_COLUMN_EMAIL_CHATROOMID_2 = "chatRoomUser.chatRoomId = ? AND ";
    private static final String _FINDER_COLUMN_EMAIL_USEREMAIL_1 = "chatRoomUser.userEmail IS NULL";
    private static final String _FINDER_COLUMN_EMAIL_USEREMAIL_2 = "chatRoomUser.userEmail = ?";
    private static final String _FINDER_COLUMN_EMAIL_USEREMAIL_3 = "(chatRoomUser.userEmail IS NULL OR chatRoomUser.userEmail = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "chatRoomUser.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChatRoomUser exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChatRoomUser exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ChatRoomUserPersistenceImpl.class);
    private static ChatRoomUser _nullChatRoomUser = new ChatRoomUserImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ChatRoomUser> toCacheModel() {
                return _nullChatRoomUserCacheModel;
            }
        };

    private static CacheModel<ChatRoomUser> _nullChatRoomUserCacheModel = new CacheModel<ChatRoomUser>() {
            public ChatRoomUser toEntityModel() {
                return _nullChatRoomUser;
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
     * Caches the chat room user in the entity cache if it is enabled.
     *
     * @param chatRoomUser the chat room user
     */
    public void cacheResult(ChatRoomUser chatRoomUser) {
        EntityCacheUtil.putResult(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserImpl.class, chatRoomUser.getPrimaryKey(), chatRoomUser);

        chatRoomUser.resetOriginalValues();
    }

    /**
     * Caches the chat room users in the entity cache if it is enabled.
     *
     * @param chatRoomUsers the chat room users
     */
    public void cacheResult(List<ChatRoomUser> chatRoomUsers) {
        for (ChatRoomUser chatRoomUser : chatRoomUsers) {
            if (EntityCacheUtil.getResult(
                        ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
                        ChatRoomUserImpl.class, chatRoomUser.getPrimaryKey()) == null) {
                cacheResult(chatRoomUser);
            } else {
                chatRoomUser.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all chat room users.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ChatRoomUserImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ChatRoomUserImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the chat room user.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ChatRoomUser chatRoomUser) {
        EntityCacheUtil.removeResult(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserImpl.class, chatRoomUser.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ChatRoomUser> chatRoomUsers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ChatRoomUser chatRoomUser : chatRoomUsers) {
            EntityCacheUtil.removeResult(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
                ChatRoomUserImpl.class, chatRoomUser.getPrimaryKey());
        }
    }

    /**
     * Creates a new chat room user with the primary key. Does not add the chat room user to the database.
     *
     * @param chatUserId the primary key for the new chat room user
     * @return the new chat room user
     */
    public ChatRoomUser create(long chatUserId) {
        ChatRoomUser chatRoomUser = new ChatRoomUserImpl();

        chatRoomUser.setNew(true);
        chatRoomUser.setPrimaryKey(chatUserId);

        return chatRoomUser;
    }

    /**
     * Removes the chat room user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param chatUserId the primary key of the chat room user
     * @return the chat room user that was removed
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a chat room user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomUser remove(long chatUserId)
        throws NoSuchChatRoomUserException, SystemException {
        return remove(Long.valueOf(chatUserId));
    }

    /**
     * Removes the chat room user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the chat room user
     * @return the chat room user that was removed
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a chat room user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoomUser remove(Serializable primaryKey)
        throws NoSuchChatRoomUserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ChatRoomUser chatRoomUser = (ChatRoomUser) session.get(ChatRoomUserImpl.class,
                    primaryKey);

            if (chatRoomUser == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchChatRoomUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(chatRoomUser);
        } catch (NoSuchChatRoomUserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ChatRoomUser removeImpl(ChatRoomUser chatRoomUser)
        throws SystemException {
        chatRoomUser = toUnwrappedModel(chatRoomUser);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, chatRoomUser);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(chatRoomUser);

        return chatRoomUser;
    }

    @Override
    public ChatRoomUser updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser chatRoomUser,
        boolean merge) throws SystemException {
        chatRoomUser = toUnwrappedModel(chatRoomUser);

        boolean isNew = chatRoomUser.isNew();

        ChatRoomUserModelImpl chatRoomUserModelImpl = (ChatRoomUserModelImpl) chatRoomUser;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, chatRoomUser, merge);

            chatRoomUser.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ChatRoomUserModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((chatRoomUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CR_U.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(chatRoomUserModelImpl.getOriginalChatRoomId()),
                        Long.valueOf(chatRoomUserModelImpl.getOriginalUserId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CR_U, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CR_U,
                    args);

                args = new Object[] {
                        Long.valueOf(chatRoomUserModelImpl.getChatRoomId()),
                        Long.valueOf(chatRoomUserModelImpl.getUserId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CR_U, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CR_U,
                    args);
            }

            if ((chatRoomUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CR.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(chatRoomUserModelImpl.getOriginalChatRoomId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CR, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CR,
                    args);

                args = new Object[] {
                        Long.valueOf(chatRoomUserModelImpl.getChatRoomId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CR, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CR,
                    args);
            }

            if ((chatRoomUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(chatRoomUserModelImpl.getOriginalChatRoomId()),
                        
                        chatRoomUserModelImpl.getOriginalUserName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);

                args = new Object[] {
                        Long.valueOf(chatRoomUserModelImpl.getChatRoomId()),
                        
                        chatRoomUserModelImpl.getUserName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);
            }

            if ((chatRoomUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(chatRoomUserModelImpl.getOriginalChatRoomId()),
                        
                        chatRoomUserModelImpl.getOriginalUserEmail()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
                    args);

                args = new Object[] {
                        Long.valueOf(chatRoomUserModelImpl.getChatRoomId()),
                        
                        chatRoomUserModelImpl.getUserEmail()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
                    args);
            }
        }

        EntityCacheUtil.putResult(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomUserImpl.class, chatRoomUser.getPrimaryKey(), chatRoomUser);

        return chatRoomUser;
    }

    protected ChatRoomUser toUnwrappedModel(ChatRoomUser chatRoomUser) {
        if (chatRoomUser instanceof ChatRoomUserImpl) {
            return chatRoomUser;
        }

        ChatRoomUserImpl chatRoomUserImpl = new ChatRoomUserImpl();

        chatRoomUserImpl.setNew(chatRoomUser.isNew());
        chatRoomUserImpl.setPrimaryKey(chatRoomUser.getPrimaryKey());

        chatRoomUserImpl.setChatUserId(chatRoomUser.getChatUserId());
        chatRoomUserImpl.setChatRoomId(chatRoomUser.getChatRoomId());
        chatRoomUserImpl.setUserId(chatRoomUser.getUserId());
        chatRoomUserImpl.setUserName(chatRoomUser.getUserName());
        chatRoomUserImpl.setUserImgId(chatRoomUser.getUserImgId());
        chatRoomUserImpl.setUserUF(chatRoomUser.getUserUF());
        chatRoomUserImpl.setUserEmail(chatRoomUser.getUserEmail());
        chatRoomUserImpl.setBanned(chatRoomUser.isBanned());
        chatRoomUserImpl.setUserType(chatRoomUser.getUserType());
        chatRoomUserImpl.setJoinedTS(chatRoomUser.getJoinedTS());

        return chatRoomUserImpl;
    }

    /**
     * Returns the chat room user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the chat room user
     * @return the chat room user
     * @throws com.liferay.portal.NoSuchModelException if a chat room user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoomUser findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the chat room user with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException} if it could not be found.
     *
     * @param chatUserId the primary key of the chat room user
     * @return the chat room user
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a chat room user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomUser findByPrimaryKey(long chatUserId)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = fetchByPrimaryKey(chatUserId);

        if (chatRoomUser == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + chatUserId);
            }

            throw new NoSuchChatRoomUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                chatUserId);
        }

        return chatRoomUser;
    }

    /**
     * Returns the chat room user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the chat room user
     * @return the chat room user, or <code>null</code> if a chat room user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoomUser fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the chat room user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param chatUserId the primary key of the chat room user
     * @return the chat room user, or <code>null</code> if a chat room user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomUser fetchByPrimaryKey(long chatUserId)
        throws SystemException {
        ChatRoomUser chatRoomUser = (ChatRoomUser) EntityCacheUtil.getResult(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
                ChatRoomUserImpl.class, chatUserId);

        if (chatRoomUser == _nullChatRoomUser) {
            return null;
        }

        if (chatRoomUser == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                chatRoomUser = (ChatRoomUser) session.get(ChatRoomUserImpl.class,
                        Long.valueOf(chatUserId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (chatRoomUser != null) {
                    cacheResult(chatRoomUser);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
                        ChatRoomUserImpl.class, chatUserId, _nullChatRoomUser);
                }

                closeSession(session);
            }
        }

        return chatRoomUser;
    }

    /**
     * Returns all the chat room users where chatRoomId = &#63; and userId = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @param userId the user ID
     * @return the matching chat room users
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomUser> findByCR_U(long chatRoomId, long userId)
        throws SystemException {
        return findByCR_U(chatRoomId, userId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    public List<ChatRoomUser> findByCR_U(long chatRoomId, long userId,
        int start, int end) throws SystemException {
        return findByCR_U(chatRoomId, userId, start, end, null);
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
    public List<ChatRoomUser> findByCR_U(long chatRoomId, long userId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CR_U;
            finderArgs = new Object[] { chatRoomId, userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CR_U;
            finderArgs = new Object[] {
                    chatRoomId, userId,
                    
                    start, end, orderByComparator
                };
        }

        List<ChatRoomUser> list = (List<ChatRoomUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ChatRoomUser chatRoomUser : list) {
                if ((chatRoomId != chatRoomUser.getChatRoomId()) ||
                        (userId != chatRoomUser.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_CHATROOMUSER_WHERE);

            query.append(_FINDER_COLUMN_CR_U_CHATROOMID_2);

            query.append(_FINDER_COLUMN_CR_U_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ChatRoomUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(chatRoomId);

                qPos.add(userId);

                list = (List<ChatRoomUser>) QueryUtil.list(q, getDialect(),
                        start, end);
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
     * Returns the first chat room user in the ordered set where chatRoomId = &#63; and userId = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room user
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomUser findByCR_U_First(long chatRoomId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = fetchByCR_U_First(chatRoomId, userId,
                orderByComparator);

        if (chatRoomUser != null) {
            return chatRoomUser;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("chatRoomId=");
        msg.append(chatRoomId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomUserException(msg.toString());
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
    public ChatRoomUser fetchByCR_U_First(long chatRoomId, long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ChatRoomUser> list = findByCR_U(chatRoomId, userId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public ChatRoomUser findByCR_U_Last(long chatRoomId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = fetchByCR_U_Last(chatRoomId, userId,
                orderByComparator);

        if (chatRoomUser != null) {
            return chatRoomUser;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("chatRoomId=");
        msg.append(chatRoomId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomUserException(msg.toString());
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
    public ChatRoomUser fetchByCR_U_Last(long chatRoomId, long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCR_U(chatRoomId, userId);

        List<ChatRoomUser> list = findByCR_U(chatRoomId, userId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public ChatRoomUser[] findByCR_U_PrevAndNext(long chatUserId,
        long chatRoomId, long userId, OrderByComparator orderByComparator)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = findByPrimaryKey(chatUserId);

        Session session = null;

        try {
            session = openSession();

            ChatRoomUser[] array = new ChatRoomUserImpl[3];

            array[0] = getByCR_U_PrevAndNext(session, chatRoomUser, chatRoomId,
                    userId, orderByComparator, true);

            array[1] = chatRoomUser;

            array[2] = getByCR_U_PrevAndNext(session, chatRoomUser, chatRoomId,
                    userId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ChatRoomUser getByCR_U_PrevAndNext(Session session,
        ChatRoomUser chatRoomUser, long chatRoomId, long userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CHATROOMUSER_WHERE);

        query.append(_FINDER_COLUMN_CR_U_CHATROOMID_2);

        query.append(_FINDER_COLUMN_CR_U_USERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }
        else {
            query.append(ChatRoomUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(chatRoomId);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(chatRoomUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ChatRoomUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the chat room users where chatRoomId = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @return the matching chat room users
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomUser> findByCR(long chatRoomId)
        throws SystemException {
        return findByCR(chatRoomId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<ChatRoomUser> findByCR(long chatRoomId, int start, int end)
        throws SystemException {
        return findByCR(chatRoomId, start, end, null);
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
    public List<ChatRoomUser> findByCR(long chatRoomId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CR;
            finderArgs = new Object[] { chatRoomId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CR;
            finderArgs = new Object[] { chatRoomId, start, end, orderByComparator };
        }

        List<ChatRoomUser> list = (List<ChatRoomUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ChatRoomUser chatRoomUser : list) {
                if ((chatRoomId != chatRoomUser.getChatRoomId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CHATROOMUSER_WHERE);

            query.append(_FINDER_COLUMN_CR_CHATROOMID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ChatRoomUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(chatRoomId);

                list = (List<ChatRoomUser>) QueryUtil.list(q, getDialect(),
                        start, end);
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
     * Returns the first chat room user in the ordered set where chatRoomId = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room user
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomUser findByCR_First(long chatRoomId,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = fetchByCR_First(chatRoomId,
                orderByComparator);

        if (chatRoomUser != null) {
            return chatRoomUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("chatRoomId=");
        msg.append(chatRoomId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomUserException(msg.toString());
    }

    /**
     * Returns the first chat room user in the ordered set where chatRoomId = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room user, or <code>null</code> if a matching chat room user could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomUser fetchByCR_First(long chatRoomId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ChatRoomUser> list = findByCR(chatRoomId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public ChatRoomUser findByCR_Last(long chatRoomId,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = fetchByCR_Last(chatRoomId, orderByComparator);

        if (chatRoomUser != null) {
            return chatRoomUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("chatRoomId=");
        msg.append(chatRoomId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomUserException(msg.toString());
    }

    /**
     * Returns the last chat room user in the ordered set where chatRoomId = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching chat room user, or <code>null</code> if a matching chat room user could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomUser fetchByCR_Last(long chatRoomId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCR(chatRoomId);

        List<ChatRoomUser> list = findByCR(chatRoomId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public ChatRoomUser[] findByCR_PrevAndNext(long chatUserId,
        long chatRoomId, OrderByComparator orderByComparator)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = findByPrimaryKey(chatUserId);

        Session session = null;

        try {
            session = openSession();

            ChatRoomUser[] array = new ChatRoomUserImpl[3];

            array[0] = getByCR_PrevAndNext(session, chatRoomUser, chatRoomId,
                    orderByComparator, true);

            array[1] = chatRoomUser;

            array[2] = getByCR_PrevAndNext(session, chatRoomUser, chatRoomId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ChatRoomUser getByCR_PrevAndNext(Session session,
        ChatRoomUser chatRoomUser, long chatRoomId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CHATROOMUSER_WHERE);

        query.append(_FINDER_COLUMN_CR_CHATROOMID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }
        else {
            query.append(ChatRoomUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(chatRoomId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(chatRoomUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ChatRoomUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the chat room users where chatRoomId = &#63; and userName = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @param userName the user name
     * @return the matching chat room users
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomUser> findByName(long chatRoomId, String userName)
        throws SystemException {
        return findByName(chatRoomId, userName, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    public List<ChatRoomUser> findByName(long chatRoomId, String userName,
        int start, int end) throws SystemException {
        return findByName(chatRoomId, userName, start, end, null);
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
    public List<ChatRoomUser> findByName(long chatRoomId, String userName,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { chatRoomId, userName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] {
                    chatRoomId, userName,
                    
                    start, end, orderByComparator
                };
        }

        List<ChatRoomUser> list = (List<ChatRoomUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ChatRoomUser chatRoomUser : list) {
                if ((chatRoomId != chatRoomUser.getChatRoomId()) ||
                        !Validator.equals(userName, chatRoomUser.getUserName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_CHATROOMUSER_WHERE);

            query.append(_FINDER_COLUMN_NAME_CHATROOMID_2);

            if (userName == null) {
                query.append(_FINDER_COLUMN_NAME_USERNAME_1);
            } else {
                if (userName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_NAME_USERNAME_3);
                } else {
                    query.append(_FINDER_COLUMN_NAME_USERNAME_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ChatRoomUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(chatRoomId);

                if (userName != null) {
                    qPos.add(userName);
                }

                list = (List<ChatRoomUser>) QueryUtil.list(q, getDialect(),
                        start, end);
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
     * Returns the first chat room user in the ordered set where chatRoomId = &#63; and userName = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @param userName the user name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room user
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomUser findByName_First(long chatRoomId, String userName,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = fetchByName_First(chatRoomId, userName,
                orderByComparator);

        if (chatRoomUser != null) {
            return chatRoomUser;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("chatRoomId=");
        msg.append(chatRoomId);

        msg.append(", userName=");
        msg.append(userName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomUserException(msg.toString());
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
    public ChatRoomUser fetchByName_First(long chatRoomId, String userName,
        OrderByComparator orderByComparator) throws SystemException {
        List<ChatRoomUser> list = findByName(chatRoomId, userName, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public ChatRoomUser findByName_Last(long chatRoomId, String userName,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = fetchByName_Last(chatRoomId, userName,
                orderByComparator);

        if (chatRoomUser != null) {
            return chatRoomUser;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("chatRoomId=");
        msg.append(chatRoomId);

        msg.append(", userName=");
        msg.append(userName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomUserException(msg.toString());
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
    public ChatRoomUser fetchByName_Last(long chatRoomId, String userName,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByName(chatRoomId, userName);

        List<ChatRoomUser> list = findByName(chatRoomId, userName, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public ChatRoomUser[] findByName_PrevAndNext(long chatUserId,
        long chatRoomId, String userName, OrderByComparator orderByComparator)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = findByPrimaryKey(chatUserId);

        Session session = null;

        try {
            session = openSession();

            ChatRoomUser[] array = new ChatRoomUserImpl[3];

            array[0] = getByName_PrevAndNext(session, chatRoomUser, chatRoomId,
                    userName, orderByComparator, true);

            array[1] = chatRoomUser;

            array[2] = getByName_PrevAndNext(session, chatRoomUser, chatRoomId,
                    userName, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ChatRoomUser getByName_PrevAndNext(Session session,
        ChatRoomUser chatRoomUser, long chatRoomId, String userName,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CHATROOMUSER_WHERE);

        query.append(_FINDER_COLUMN_NAME_CHATROOMID_2);

        if (userName == null) {
            query.append(_FINDER_COLUMN_NAME_USERNAME_1);
        } else {
            if (userName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_USERNAME_3);
            } else {
                query.append(_FINDER_COLUMN_NAME_USERNAME_2);
            }
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }
        else {
            query.append(ChatRoomUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(chatRoomId);

        if (userName != null) {
            qPos.add(userName);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(chatRoomUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ChatRoomUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the chat room users where chatRoomId = &#63; and userEmail = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @param userEmail the user email
     * @return the matching chat room users
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomUser> findByEmail(long chatRoomId, String userEmail)
        throws SystemException {
        return findByEmail(chatRoomId, userEmail, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    public List<ChatRoomUser> findByEmail(long chatRoomId, String userEmail,
        int start, int end) throws SystemException {
        return findByEmail(chatRoomId, userEmail, start, end, null);
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
    public List<ChatRoomUser> findByEmail(long chatRoomId, String userEmail,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
            finderArgs = new Object[] { chatRoomId, userEmail };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
            finderArgs = new Object[] {
                    chatRoomId, userEmail,
                    
                    start, end, orderByComparator
                };
        }

        List<ChatRoomUser> list = (List<ChatRoomUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ChatRoomUser chatRoomUser : list) {
                if ((chatRoomId != chatRoomUser.getChatRoomId()) ||
                        !Validator.equals(userEmail, chatRoomUser.getUserEmail())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_CHATROOMUSER_WHERE);

            query.append(_FINDER_COLUMN_EMAIL_CHATROOMID_2);

            if (userEmail == null) {
                query.append(_FINDER_COLUMN_EMAIL_USEREMAIL_1);
            } else {
                if (userEmail.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_EMAIL_USEREMAIL_3);
                } else {
                    query.append(_FINDER_COLUMN_EMAIL_USEREMAIL_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ChatRoomUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(chatRoomId);

                if (userEmail != null) {
                    qPos.add(userEmail);
                }

                list = (List<ChatRoomUser>) QueryUtil.list(q, getDialect(),
                        start, end);
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
     * Returns the first chat room user in the ordered set where chatRoomId = &#63; and userEmail = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @param userEmail the user email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room user
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException if a matching chat room user could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomUser findByEmail_First(long chatRoomId, String userEmail,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = fetchByEmail_First(chatRoomId, userEmail,
                orderByComparator);

        if (chatRoomUser != null) {
            return chatRoomUser;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("chatRoomId=");
        msg.append(chatRoomId);

        msg.append(", userEmail=");
        msg.append(userEmail);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomUserException(msg.toString());
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
    public ChatRoomUser fetchByEmail_First(long chatRoomId, String userEmail,
        OrderByComparator orderByComparator) throws SystemException {
        List<ChatRoomUser> list = findByEmail(chatRoomId, userEmail, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public ChatRoomUser findByEmail_Last(long chatRoomId, String userEmail,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = fetchByEmail_Last(chatRoomId, userEmail,
                orderByComparator);

        if (chatRoomUser != null) {
            return chatRoomUser;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("chatRoomId=");
        msg.append(chatRoomId);

        msg.append(", userEmail=");
        msg.append(userEmail);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomUserException(msg.toString());
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
    public ChatRoomUser fetchByEmail_Last(long chatRoomId, String userEmail,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByEmail(chatRoomId, userEmail);

        List<ChatRoomUser> list = findByEmail(chatRoomId, userEmail, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public ChatRoomUser[] findByEmail_PrevAndNext(long chatUserId,
        long chatRoomId, String userEmail, OrderByComparator orderByComparator)
        throws NoSuchChatRoomUserException, SystemException {
        ChatRoomUser chatRoomUser = findByPrimaryKey(chatUserId);

        Session session = null;

        try {
            session = openSession();

            ChatRoomUser[] array = new ChatRoomUserImpl[3];

            array[0] = getByEmail_PrevAndNext(session, chatRoomUser,
                    chatRoomId, userEmail, orderByComparator, true);

            array[1] = chatRoomUser;

            array[2] = getByEmail_PrevAndNext(session, chatRoomUser,
                    chatRoomId, userEmail, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ChatRoomUser getByEmail_PrevAndNext(Session session,
        ChatRoomUser chatRoomUser, long chatRoomId, String userEmail,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CHATROOMUSER_WHERE);

        query.append(_FINDER_COLUMN_EMAIL_CHATROOMID_2);

        if (userEmail == null) {
            query.append(_FINDER_COLUMN_EMAIL_USEREMAIL_1);
        } else {
            if (userEmail.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAIL_USEREMAIL_3);
            } else {
                query.append(_FINDER_COLUMN_EMAIL_USEREMAIL_2);
            }
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }
        else {
            query.append(ChatRoomUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(chatRoomId);

        if (userEmail != null) {
            qPos.add(userEmail);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(chatRoomUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ChatRoomUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the chat room users.
     *
     * @return the chat room users
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomUser> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<ChatRoomUser> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    public List<ChatRoomUser> findAll(int start, int end,
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

        List<ChatRoomUser> list = (List<ChatRoomUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CHATROOMUSER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CHATROOMUSER.concat(ChatRoomUserModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<ChatRoomUser>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ChatRoomUser>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the chat room users where chatRoomId = &#63; and userId = &#63; from the database.
     *
     * @param chatRoomId the chat room ID
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByCR_U(long chatRoomId, long userId)
        throws SystemException {
        for (ChatRoomUser chatRoomUser : findByCR_U(chatRoomId, userId)) {
            remove(chatRoomUser);
        }
    }

    /**
     * Removes all the chat room users where chatRoomId = &#63; from the database.
     *
     * @param chatRoomId the chat room ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByCR(long chatRoomId) throws SystemException {
        for (ChatRoomUser chatRoomUser : findByCR(chatRoomId)) {
            remove(chatRoomUser);
        }
    }

    /**
     * Removes all the chat room users where chatRoomId = &#63; and userName = &#63; from the database.
     *
     * @param chatRoomId the chat room ID
     * @param userName the user name
     * @throws SystemException if a system exception occurred
     */
    public void removeByName(long chatRoomId, String userName)
        throws SystemException {
        for (ChatRoomUser chatRoomUser : findByName(chatRoomId, userName)) {
            remove(chatRoomUser);
        }
    }

    /**
     * Removes all the chat room users where chatRoomId = &#63; and userEmail = &#63; from the database.
     *
     * @param chatRoomId the chat room ID
     * @param userEmail the user email
     * @throws SystemException if a system exception occurred
     */
    public void removeByEmail(long chatRoomId, String userEmail)
        throws SystemException {
        for (ChatRoomUser chatRoomUser : findByEmail(chatRoomId, userEmail)) {
            remove(chatRoomUser);
        }
    }

    /**
     * Removes all the chat room users from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (ChatRoomUser chatRoomUser : findAll()) {
            remove(chatRoomUser);
        }
    }

    /**
     * Returns the number of chat room users where chatRoomId = &#63; and userId = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @param userId the user ID
     * @return the number of matching chat room users
     * @throws SystemException if a system exception occurred
     */
    public int countByCR_U(long chatRoomId, long userId)
        throws SystemException {
        Object[] finderArgs = new Object[] { chatRoomId, userId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CR_U,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CHATROOMUSER_WHERE);

            query.append(_FINDER_COLUMN_CR_U_CHATROOMID_2);

            query.append(_FINDER_COLUMN_CR_U_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(chatRoomId);

                qPos.add(userId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CR_U,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of chat room users where chatRoomId = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @return the number of matching chat room users
     * @throws SystemException if a system exception occurred
     */
    public int countByCR(long chatRoomId) throws SystemException {
        Object[] finderArgs = new Object[] { chatRoomId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CR,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CHATROOMUSER_WHERE);

            query.append(_FINDER_COLUMN_CR_CHATROOMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(chatRoomId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CR, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of chat room users where chatRoomId = &#63; and userName = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @param userName the user name
     * @return the number of matching chat room users
     * @throws SystemException if a system exception occurred
     */
    public int countByName(long chatRoomId, String userName)
        throws SystemException {
        Object[] finderArgs = new Object[] { chatRoomId, userName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CHATROOMUSER_WHERE);

            query.append(_FINDER_COLUMN_NAME_CHATROOMID_2);

            if (userName == null) {
                query.append(_FINDER_COLUMN_NAME_USERNAME_1);
            } else {
                if (userName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_NAME_USERNAME_3);
                } else {
                    query.append(_FINDER_COLUMN_NAME_USERNAME_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(chatRoomId);

                if (userName != null) {
                    qPos.add(userName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of chat room users where chatRoomId = &#63; and userEmail = &#63;.
     *
     * @param chatRoomId the chat room ID
     * @param userEmail the user email
     * @return the number of matching chat room users
     * @throws SystemException if a system exception occurred
     */
    public int countByEmail(long chatRoomId, String userEmail)
        throws SystemException {
        Object[] finderArgs = new Object[] { chatRoomId, userEmail };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAIL,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CHATROOMUSER_WHERE);

            query.append(_FINDER_COLUMN_EMAIL_CHATROOMID_2);

            if (userEmail == null) {
                query.append(_FINDER_COLUMN_EMAIL_USEREMAIL_1);
            } else {
                if (userEmail.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_EMAIL_USEREMAIL_3);
                } else {
                    query.append(_FINDER_COLUMN_EMAIL_USEREMAIL_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(chatRoomId);

                if (userEmail != null) {
                    qPos.add(userEmail);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of chat room users.
     *
     * @return the number of chat room users
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CHATROOMUSER);

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
     * Initializes the chat room user persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ChatRoomUser>> listenersList = new ArrayList<ModelListener<ChatRoomUser>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ChatRoomUser>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ChatRoomUserImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
