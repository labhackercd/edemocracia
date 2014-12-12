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

import br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageImpl;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageModelImpl;
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
import com.liferay.portal.kernel.util.CalendarUtil;
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
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the chat room message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomMessagePersistence
 * @see ChatRoomMessageUtil
 * @generated
 */
public class ChatRoomMessagePersistenceImpl extends BasePersistenceImpl<ChatRoomMessage>
    implements ChatRoomMessagePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ChatRoomMessageUtil} to access the chat room message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ChatRoomMessageImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLIC = new FinderPath(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomMessageModelImpl.FINDER_CACHE_ENABLED,
            ChatRoomMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByPublic",
            new String[] {
                Boolean.class.getName(), Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLIC =
        new FinderPath(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomMessageModelImpl.FINDER_CACHE_ENABLED,
            ChatRoomMessageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublic",
            new String[] { Boolean.class.getName(), Date.class.getName() },
            ChatRoomMessageModelImpl.MESSAGEPUBLIC_COLUMN_BITMASK |
            ChatRoomMessageModelImpl.MESSAGETS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PUBLIC = new FinderPath(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublic",
            new String[] { Boolean.class.getName(), Date.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRIVATEUSER =
        new FinderPath(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomMessageModelImpl.FINDER_CACHE_ENABLED,
            ChatRoomMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByPrivateUser",
            new String[] {
                Boolean.class.getName(), Long.class.getName(),
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIVATEUSER =
        new FinderPath(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomMessageModelImpl.FINDER_CACHE_ENABLED,
            ChatRoomMessageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrivateUser",
            new String[] {
                Boolean.class.getName(), Long.class.getName(),
                Date.class.getName()
            },
            ChatRoomMessageModelImpl.MESSAGEPUBLIC_COLUMN_BITMASK |
            ChatRoomMessageModelImpl.RECIPIENTUSERID_COLUMN_BITMASK |
            ChatRoomMessageModelImpl.MESSAGETS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PRIVATEUSER = new FinderPath(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrivateUser",
            new String[] {
                Boolean.class.getName(), Long.class.getName(),
                Date.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomMessageModelImpl.FINDER_CACHE_ENABLED,
            ChatRoomMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomMessageModelImpl.FINDER_CACHE_ENABLED,
            ChatRoomMessageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CHATROOMMESSAGE = "SELECT chatRoomMessage FROM ChatRoomMessage chatRoomMessage";
    private static final String _SQL_SELECT_CHATROOMMESSAGE_WHERE = "SELECT chatRoomMessage FROM ChatRoomMessage chatRoomMessage WHERE ";
    private static final String _SQL_COUNT_CHATROOMMESSAGE = "SELECT COUNT(chatRoomMessage) FROM ChatRoomMessage chatRoomMessage";
    private static final String _SQL_COUNT_CHATROOMMESSAGE_WHERE = "SELECT COUNT(chatRoomMessage) FROM ChatRoomMessage chatRoomMessage WHERE ";
    private static final String _FINDER_COLUMN_PUBLIC_MESSAGEPUBLIC_2 = "chatRoomMessage.messagePublic = ? AND ";
    private static final String _FINDER_COLUMN_PUBLIC_MESSAGETS_1 = "chatRoomMessage.messageTS IS NULL";
    private static final String _FINDER_COLUMN_PUBLIC_MESSAGETS_2 = "chatRoomMessage.messageTS = ?";
    private static final String _FINDER_COLUMN_PRIVATEUSER_MESSAGEPUBLIC_2 = "chatRoomMessage.messagePublic = ? AND ";
    private static final String _FINDER_COLUMN_PRIVATEUSER_RECIPIENTUSERID_2 = "chatRoomMessage.recipientUserId = ? AND ";
    private static final String _FINDER_COLUMN_PRIVATEUSER_MESSAGETS_1 = "chatRoomMessage.messageTS IS NULL";
    private static final String _FINDER_COLUMN_PRIVATEUSER_MESSAGETS_2 = "chatRoomMessage.messageTS = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "chatRoomMessage.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChatRoomMessage exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChatRoomMessage exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ChatRoomMessagePersistenceImpl.class);
    private static ChatRoomMessage _nullChatRoomMessage = new ChatRoomMessageImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ChatRoomMessage> toCacheModel() {
                return _nullChatRoomMessageCacheModel;
            }
        };

    private static CacheModel<ChatRoomMessage> _nullChatRoomMessageCacheModel = new CacheModel<ChatRoomMessage>() {
            public ChatRoomMessage toEntityModel() {
                return _nullChatRoomMessage;
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
     * Caches the chat room message in the entity cache if it is enabled.
     *
     * @param chatRoomMessage the chat room message
     */
    public void cacheResult(ChatRoomMessage chatRoomMessage) {
        EntityCacheUtil.putResult(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomMessageImpl.class, chatRoomMessage.getPrimaryKey(),
            chatRoomMessage);

        chatRoomMessage.resetOriginalValues();
    }

    /**
     * Caches the chat room messages in the entity cache if it is enabled.
     *
     * @param chatRoomMessages the chat room messages
     */
    public void cacheResult(List<ChatRoomMessage> chatRoomMessages) {
        for (ChatRoomMessage chatRoomMessage : chatRoomMessages) {
            if (EntityCacheUtil.getResult(
                        ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
                        ChatRoomMessageImpl.class,
                        chatRoomMessage.getPrimaryKey()) == null) {
                cacheResult(chatRoomMessage);
            } else {
                chatRoomMessage.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all chat room messages.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ChatRoomMessageImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ChatRoomMessageImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the chat room message.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ChatRoomMessage chatRoomMessage) {
        EntityCacheUtil.removeResult(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomMessageImpl.class, chatRoomMessage.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ChatRoomMessage> chatRoomMessages) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ChatRoomMessage chatRoomMessage : chatRoomMessages) {
            EntityCacheUtil.removeResult(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
                ChatRoomMessageImpl.class, chatRoomMessage.getPrimaryKey());
        }
    }

    /**
     * Creates a new chat room message with the primary key. Does not add the chat room message to the database.
     *
     * @param chatMessageId the primary key for the new chat room message
     * @return the new chat room message
     */
    public ChatRoomMessage create(long chatMessageId) {
        ChatRoomMessage chatRoomMessage = new ChatRoomMessageImpl();

        chatRoomMessage.setNew(true);
        chatRoomMessage.setPrimaryKey(chatMessageId);

        return chatRoomMessage;
    }

    /**
     * Removes the chat room message with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param chatMessageId the primary key of the chat room message
     * @return the chat room message that was removed
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a chat room message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage remove(long chatMessageId)
        throws NoSuchChatRoomMessageException, SystemException {
        return remove(Long.valueOf(chatMessageId));
    }

    /**
     * Removes the chat room message with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the chat room message
     * @return the chat room message that was removed
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a chat room message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoomMessage remove(Serializable primaryKey)
        throws NoSuchChatRoomMessageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ChatRoomMessage chatRoomMessage = (ChatRoomMessage) session.get(ChatRoomMessageImpl.class,
                    primaryKey);

            if (chatRoomMessage == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchChatRoomMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(chatRoomMessage);
        } catch (NoSuchChatRoomMessageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ChatRoomMessage removeImpl(ChatRoomMessage chatRoomMessage)
        throws SystemException {
        chatRoomMessage = toUnwrappedModel(chatRoomMessage);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, chatRoomMessage);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(chatRoomMessage);

        return chatRoomMessage;
    }

    @Override
    public ChatRoomMessage updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage chatRoomMessage,
        boolean merge) throws SystemException {
        chatRoomMessage = toUnwrappedModel(chatRoomMessage);

        boolean isNew = chatRoomMessage.isNew();

        ChatRoomMessageModelImpl chatRoomMessageModelImpl = (ChatRoomMessageModelImpl) chatRoomMessage;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, chatRoomMessage, merge);

            chatRoomMessage.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ChatRoomMessageModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((chatRoomMessageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLIC.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Boolean.valueOf(chatRoomMessageModelImpl.getOriginalMessagePublic()),
                        
                        chatRoomMessageModelImpl.getOriginalMessageTS()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLIC, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLIC,
                    args);

                args = new Object[] {
                        Boolean.valueOf(chatRoomMessageModelImpl.getMessagePublic()),
                        
                        chatRoomMessageModelImpl.getMessageTS()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLIC, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLIC,
                    args);
            }

            if ((chatRoomMessageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIVATEUSER.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Boolean.valueOf(chatRoomMessageModelImpl.getOriginalMessagePublic()),
                        Long.valueOf(chatRoomMessageModelImpl.getOriginalRecipientUserId()),
                        
                        chatRoomMessageModelImpl.getOriginalMessageTS()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRIVATEUSER,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIVATEUSER,
                    args);

                args = new Object[] {
                        Boolean.valueOf(chatRoomMessageModelImpl.getMessagePublic()),
                        Long.valueOf(chatRoomMessageModelImpl.getRecipientUserId()),
                        
                        chatRoomMessageModelImpl.getMessageTS()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRIVATEUSER,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIVATEUSER,
                    args);
            }
        }

        EntityCacheUtil.putResult(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomMessageImpl.class, chatRoomMessage.getPrimaryKey(),
            chatRoomMessage);

        return chatRoomMessage;
    }

    protected ChatRoomMessage toUnwrappedModel(ChatRoomMessage chatRoomMessage) {
        if (chatRoomMessage instanceof ChatRoomMessageImpl) {
            return chatRoomMessage;
        }

        ChatRoomMessageImpl chatRoomMessageImpl = new ChatRoomMessageImpl();

        chatRoomMessageImpl.setNew(chatRoomMessage.isNew());
        chatRoomMessageImpl.setPrimaryKey(chatRoomMessage.getPrimaryKey());

        chatRoomMessageImpl.setChatMessageId(chatRoomMessage.getChatMessageId());
        chatRoomMessageImpl.setParentMessageId(chatRoomMessage.getParentMessageId());
        chatRoomMessageImpl.setChatRoomId(chatRoomMessage.getChatRoomId());
        chatRoomMessageImpl.setExportedPosition(chatRoomMessage.getExportedPosition());
        chatRoomMessageImpl.setExportedRemoved(chatRoomMessage.isExportedRemoved());
        chatRoomMessageImpl.setMessageType(chatRoomMessage.getMessageType());
        chatRoomMessageImpl.setMessageStatus(chatRoomMessage.getMessageStatus());
        chatRoomMessageImpl.setSenderId(chatRoomMessage.getSenderId());
        chatRoomMessageImpl.setSenderName(chatRoomMessage.getSenderName());
        chatRoomMessageImpl.setSenderUF(chatRoomMessage.getSenderUF());
        chatRoomMessageImpl.setSenderEmail(chatRoomMessage.getSenderEmail());
        chatRoomMessageImpl.setSenderType(chatRoomMessage.getSenderType());
        chatRoomMessageImpl.setMessageText(chatRoomMessage.getMessageText());
        chatRoomMessageImpl.setTextType(chatRoomMessage.getTextType());
        chatRoomMessageImpl.setMessageTS(chatRoomMessage.getMessageTS());
        chatRoomMessageImpl.setMessagePublic(chatRoomMessage.isMessagePublic());
        chatRoomMessageImpl.setAdminMessage(chatRoomMessage.isAdminMessage());
        chatRoomMessageImpl.setRecipientUserId(chatRoomMessage.getRecipientUserId());
        chatRoomMessageImpl.setRecipientUserName(chatRoomMessage.getRecipientUserName());

        return chatRoomMessageImpl;
    }

    /**
     * Returns the chat room message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the chat room message
     * @return the chat room message
     * @throws com.liferay.portal.NoSuchModelException if a chat room message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoomMessage findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the chat room message with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException} if it could not be found.
     *
     * @param chatMessageId the primary key of the chat room message
     * @return the chat room message
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a chat room message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage findByPrimaryKey(long chatMessageId)
        throws NoSuchChatRoomMessageException, SystemException {
        ChatRoomMessage chatRoomMessage = fetchByPrimaryKey(chatMessageId);

        if (chatRoomMessage == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + chatMessageId);
            }

            throw new NoSuchChatRoomMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                chatMessageId);
        }

        return chatRoomMessage;
    }

    /**
     * Returns the chat room message with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the chat room message
     * @return the chat room message, or <code>null</code> if a chat room message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoomMessage fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the chat room message with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param chatMessageId the primary key of the chat room message
     * @return the chat room message, or <code>null</code> if a chat room message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage fetchByPrimaryKey(long chatMessageId)
        throws SystemException {
        ChatRoomMessage chatRoomMessage = (ChatRoomMessage) EntityCacheUtil.getResult(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
                ChatRoomMessageImpl.class, chatMessageId);

        if (chatRoomMessage == _nullChatRoomMessage) {
            return null;
        }

        if (chatRoomMessage == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                chatRoomMessage = (ChatRoomMessage) session.get(ChatRoomMessageImpl.class,
                        Long.valueOf(chatMessageId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (chatRoomMessage != null) {
                    cacheResult(chatRoomMessage);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
                        ChatRoomMessageImpl.class, chatMessageId,
                        _nullChatRoomMessage);
                }

                closeSession(session);
            }
        }

        return chatRoomMessage;
    }

    /**
     * Returns all the chat room messages where messagePublic = &#63; and messageTS = &#63;.
     *
     * @param messagePublic the message public
     * @param messageTS the message t s
     * @return the matching chat room messages
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomMessage> findByPublic(boolean messagePublic,
        Date messageTS) throws SystemException {
        return findByPublic(messagePublic, messageTS, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the chat room messages where messagePublic = &#63; and messageTS = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param messagePublic the message public
     * @param messageTS the message t s
     * @param start the lower bound of the range of chat room messages
     * @param end the upper bound of the range of chat room messages (not inclusive)
     * @return the range of matching chat room messages
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomMessage> findByPublic(boolean messagePublic,
        Date messageTS, int start, int end) throws SystemException {
        return findByPublic(messagePublic, messageTS, start, end, null);
    }

    /**
     * Returns an ordered range of all the chat room messages where messagePublic = &#63; and messageTS = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param messagePublic the message public
     * @param messageTS the message t s
     * @param start the lower bound of the range of chat room messages
     * @param end the upper bound of the range of chat room messages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching chat room messages
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomMessage> findByPublic(boolean messagePublic,
        Date messageTS, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLIC;
            finderArgs = new Object[] { messagePublic, messageTS };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLIC;
            finderArgs = new Object[] {
                    messagePublic, messageTS,
                    
                    start, end, orderByComparator
                };
        }

        List<ChatRoomMessage> list = (List<ChatRoomMessage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ChatRoomMessage chatRoomMessage : list) {
                if ((messagePublic != chatRoomMessage.getMessagePublic()) ||
                        !Validator.equals(messageTS,
                            chatRoomMessage.getMessageTS())) {
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

            query.append(_SQL_SELECT_CHATROOMMESSAGE_WHERE);

            query.append(_FINDER_COLUMN_PUBLIC_MESSAGEPUBLIC_2);

            if (messageTS == null) {
                query.append(_FINDER_COLUMN_PUBLIC_MESSAGETS_1);
            } else {
                query.append(_FINDER_COLUMN_PUBLIC_MESSAGETS_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ChatRoomMessageModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(messagePublic);

                if (messageTS != null) {
                    qPos.add(CalendarUtil.getTimestamp(messageTS));
                }

                list = (List<ChatRoomMessage>) QueryUtil.list(q, getDialect(),
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
     * Returns the first chat room message in the ordered set where messagePublic = &#63; and messageTS = &#63;.
     *
     * @param messagePublic the message public
     * @param messageTS the message t s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room message
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a matching chat room message could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage findByPublic_First(boolean messagePublic,
        Date messageTS, OrderByComparator orderByComparator)
        throws NoSuchChatRoomMessageException, SystemException {
        ChatRoomMessage chatRoomMessage = fetchByPublic_First(messagePublic,
                messageTS, orderByComparator);

        if (chatRoomMessage != null) {
            return chatRoomMessage;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("messagePublic=");
        msg.append(messagePublic);

        msg.append(", messageTS=");
        msg.append(messageTS);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomMessageException(msg.toString());
    }

    /**
     * Returns the first chat room message in the ordered set where messagePublic = &#63; and messageTS = &#63;.
     *
     * @param messagePublic the message public
     * @param messageTS the message t s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room message, or <code>null</code> if a matching chat room message could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage fetchByPublic_First(boolean messagePublic,
        Date messageTS, OrderByComparator orderByComparator)
        throws SystemException {
        List<ChatRoomMessage> list = findByPublic(messagePublic, messageTS, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last chat room message in the ordered set where messagePublic = &#63; and messageTS = &#63;.
     *
     * @param messagePublic the message public
     * @param messageTS the message t s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching chat room message
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a matching chat room message could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage findByPublic_Last(boolean messagePublic,
        Date messageTS, OrderByComparator orderByComparator)
        throws NoSuchChatRoomMessageException, SystemException {
        ChatRoomMessage chatRoomMessage = fetchByPublic_Last(messagePublic,
                messageTS, orderByComparator);

        if (chatRoomMessage != null) {
            return chatRoomMessage;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("messagePublic=");
        msg.append(messagePublic);

        msg.append(", messageTS=");
        msg.append(messageTS);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomMessageException(msg.toString());
    }

    /**
     * Returns the last chat room message in the ordered set where messagePublic = &#63; and messageTS = &#63;.
     *
     * @param messagePublic the message public
     * @param messageTS the message t s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching chat room message, or <code>null</code> if a matching chat room message could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage fetchByPublic_Last(boolean messagePublic,
        Date messageTS, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByPublic(messagePublic, messageTS);

        List<ChatRoomMessage> list = findByPublic(messagePublic, messageTS,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the chat room messages before and after the current chat room message in the ordered set where messagePublic = &#63; and messageTS = &#63;.
     *
     * @param chatMessageId the primary key of the current chat room message
     * @param messagePublic the message public
     * @param messageTS the message t s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next chat room message
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a chat room message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage[] findByPublic_PrevAndNext(long chatMessageId,
        boolean messagePublic, Date messageTS,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomMessageException, SystemException {
        ChatRoomMessage chatRoomMessage = findByPrimaryKey(chatMessageId);

        Session session = null;

        try {
            session = openSession();

            ChatRoomMessage[] array = new ChatRoomMessageImpl[3];

            array[0] = getByPublic_PrevAndNext(session, chatRoomMessage,
                    messagePublic, messageTS, orderByComparator, true);

            array[1] = chatRoomMessage;

            array[2] = getByPublic_PrevAndNext(session, chatRoomMessage,
                    messagePublic, messageTS, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ChatRoomMessage getByPublic_PrevAndNext(Session session,
        ChatRoomMessage chatRoomMessage, boolean messagePublic, Date messageTS,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CHATROOMMESSAGE_WHERE);

        query.append(_FINDER_COLUMN_PUBLIC_MESSAGEPUBLIC_2);

        if (messageTS == null) {
            query.append(_FINDER_COLUMN_PUBLIC_MESSAGETS_1);
        } else {
            query.append(_FINDER_COLUMN_PUBLIC_MESSAGETS_2);
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
            query.append(ChatRoomMessageModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(messagePublic);

        if (messageTS != null) {
            qPos.add(CalendarUtil.getTimestamp(messageTS));
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(chatRoomMessage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ChatRoomMessage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
     *
     * @param messagePublic the message public
     * @param recipientUserId the recipient user ID
     * @param messageTS the message t s
     * @return the matching chat room messages
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomMessage> findByPrivateUser(boolean messagePublic,
        long recipientUserId, Date messageTS) throws SystemException {
        return findByPrivateUser(messagePublic, recipientUserId, messageTS,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param messagePublic the message public
     * @param recipientUserId the recipient user ID
     * @param messageTS the message t s
     * @param start the lower bound of the range of chat room messages
     * @param end the upper bound of the range of chat room messages (not inclusive)
     * @return the range of matching chat room messages
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomMessage> findByPrivateUser(boolean messagePublic,
        long recipientUserId, Date messageTS, int start, int end)
        throws SystemException {
        return findByPrivateUser(messagePublic, recipientUserId, messageTS,
            start, end, null);
    }

    /**
     * Returns an ordered range of all the chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param messagePublic the message public
     * @param recipientUserId the recipient user ID
     * @param messageTS the message t s
     * @param start the lower bound of the range of chat room messages
     * @param end the upper bound of the range of chat room messages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching chat room messages
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomMessage> findByPrivateUser(boolean messagePublic,
        long recipientUserId, Date messageTS, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIVATEUSER;
            finderArgs = new Object[] { messagePublic, recipientUserId, messageTS };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRIVATEUSER;
            finderArgs = new Object[] {
                    messagePublic, recipientUserId, messageTS,
                    
                    start, end, orderByComparator
                };
        }

        List<ChatRoomMessage> list = (List<ChatRoomMessage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ChatRoomMessage chatRoomMessage : list) {
                if ((messagePublic != chatRoomMessage.getMessagePublic()) ||
                        (recipientUserId != chatRoomMessage.getRecipientUserId()) ||
                        !Validator.equals(messageTS,
                            chatRoomMessage.getMessageTS())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_CHATROOMMESSAGE_WHERE);

            query.append(_FINDER_COLUMN_PRIVATEUSER_MESSAGEPUBLIC_2);

            query.append(_FINDER_COLUMN_PRIVATEUSER_RECIPIENTUSERID_2);

            if (messageTS == null) {
                query.append(_FINDER_COLUMN_PRIVATEUSER_MESSAGETS_1);
            } else {
                query.append(_FINDER_COLUMN_PRIVATEUSER_MESSAGETS_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ChatRoomMessageModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(messagePublic);

                qPos.add(recipientUserId);

                if (messageTS != null) {
                    qPos.add(CalendarUtil.getTimestamp(messageTS));
                }

                list = (List<ChatRoomMessage>) QueryUtil.list(q, getDialect(),
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
     * Returns the first chat room message in the ordered set where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
     *
     * @param messagePublic the message public
     * @param recipientUserId the recipient user ID
     * @param messageTS the message t s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room message
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a matching chat room message could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage findByPrivateUser_First(boolean messagePublic,
        long recipientUserId, Date messageTS,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomMessageException, SystemException {
        ChatRoomMessage chatRoomMessage = fetchByPrivateUser_First(messagePublic,
                recipientUserId, messageTS, orderByComparator);

        if (chatRoomMessage != null) {
            return chatRoomMessage;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("messagePublic=");
        msg.append(messagePublic);

        msg.append(", recipientUserId=");
        msg.append(recipientUserId);

        msg.append(", messageTS=");
        msg.append(messageTS);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomMessageException(msg.toString());
    }

    /**
     * Returns the first chat room message in the ordered set where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
     *
     * @param messagePublic the message public
     * @param recipientUserId the recipient user ID
     * @param messageTS the message t s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room message, or <code>null</code> if a matching chat room message could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage fetchByPrivateUser_First(boolean messagePublic,
        long recipientUserId, Date messageTS,
        OrderByComparator orderByComparator) throws SystemException {
        List<ChatRoomMessage> list = findByPrivateUser(messagePublic,
                recipientUserId, messageTS, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last chat room message in the ordered set where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
     *
     * @param messagePublic the message public
     * @param recipientUserId the recipient user ID
     * @param messageTS the message t s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching chat room message
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a matching chat room message could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage findByPrivateUser_Last(boolean messagePublic,
        long recipientUserId, Date messageTS,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomMessageException, SystemException {
        ChatRoomMessage chatRoomMessage = fetchByPrivateUser_Last(messagePublic,
                recipientUserId, messageTS, orderByComparator);

        if (chatRoomMessage != null) {
            return chatRoomMessage;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("messagePublic=");
        msg.append(messagePublic);

        msg.append(", recipientUserId=");
        msg.append(recipientUserId);

        msg.append(", messageTS=");
        msg.append(messageTS);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomMessageException(msg.toString());
    }

    /**
     * Returns the last chat room message in the ordered set where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
     *
     * @param messagePublic the message public
     * @param recipientUserId the recipient user ID
     * @param messageTS the message t s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching chat room message, or <code>null</code> if a matching chat room message could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage fetchByPrivateUser_Last(boolean messagePublic,
        long recipientUserId, Date messageTS,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPrivateUser(messagePublic, recipientUserId, messageTS);

        List<ChatRoomMessage> list = findByPrivateUser(messagePublic,
                recipientUserId, messageTS, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the chat room messages before and after the current chat room message in the ordered set where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
     *
     * @param chatMessageId the primary key of the current chat room message
     * @param messagePublic the message public
     * @param recipientUserId the recipient user ID
     * @param messageTS the message t s
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next chat room message
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException if a chat room message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoomMessage[] findByPrivateUser_PrevAndNext(long chatMessageId,
        boolean messagePublic, long recipientUserId, Date messageTS,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomMessageException, SystemException {
        ChatRoomMessage chatRoomMessage = findByPrimaryKey(chatMessageId);

        Session session = null;

        try {
            session = openSession();

            ChatRoomMessage[] array = new ChatRoomMessageImpl[3];

            array[0] = getByPrivateUser_PrevAndNext(session, chatRoomMessage,
                    messagePublic, recipientUserId, messageTS,
                    orderByComparator, true);

            array[1] = chatRoomMessage;

            array[2] = getByPrivateUser_PrevAndNext(session, chatRoomMessage,
                    messagePublic, recipientUserId, messageTS,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ChatRoomMessage getByPrivateUser_PrevAndNext(Session session,
        ChatRoomMessage chatRoomMessage, boolean messagePublic,
        long recipientUserId, Date messageTS,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CHATROOMMESSAGE_WHERE);

        query.append(_FINDER_COLUMN_PRIVATEUSER_MESSAGEPUBLIC_2);

        query.append(_FINDER_COLUMN_PRIVATEUSER_RECIPIENTUSERID_2);

        if (messageTS == null) {
            query.append(_FINDER_COLUMN_PRIVATEUSER_MESSAGETS_1);
        } else {
            query.append(_FINDER_COLUMN_PRIVATEUSER_MESSAGETS_2);
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
            query.append(ChatRoomMessageModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(messagePublic);

        qPos.add(recipientUserId);

        if (messageTS != null) {
            qPos.add(CalendarUtil.getTimestamp(messageTS));
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(chatRoomMessage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ChatRoomMessage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the chat room messages.
     *
     * @return the chat room messages
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomMessage> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the chat room messages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of chat room messages
     * @param end the upper bound of the range of chat room messages (not inclusive)
     * @return the range of chat room messages
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomMessage> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the chat room messages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of chat room messages
     * @param end the upper bound of the range of chat room messages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of chat room messages
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoomMessage> findAll(int start, int end,
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

        List<ChatRoomMessage> list = (List<ChatRoomMessage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CHATROOMMESSAGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CHATROOMMESSAGE.concat(ChatRoomMessageModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<ChatRoomMessage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ChatRoomMessage>) QueryUtil.list(q,
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
     * Removes all the chat room messages where messagePublic = &#63; and messageTS = &#63; from the database.
     *
     * @param messagePublic the message public
     * @param messageTS the message t s
     * @throws SystemException if a system exception occurred
     */
    public void removeByPublic(boolean messagePublic, Date messageTS)
        throws SystemException {
        for (ChatRoomMessage chatRoomMessage : findByPublic(messagePublic,
                messageTS)) {
            remove(chatRoomMessage);
        }
    }

    /**
     * Removes all the chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63; from the database.
     *
     * @param messagePublic the message public
     * @param recipientUserId the recipient user ID
     * @param messageTS the message t s
     * @throws SystemException if a system exception occurred
     */
    public void removeByPrivateUser(boolean messagePublic,
        long recipientUserId, Date messageTS) throws SystemException {
        for (ChatRoomMessage chatRoomMessage : findByPrivateUser(
                messagePublic, recipientUserId, messageTS)) {
            remove(chatRoomMessage);
        }
    }

    /**
     * Removes all the chat room messages from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (ChatRoomMessage chatRoomMessage : findAll()) {
            remove(chatRoomMessage);
        }
    }

    /**
     * Returns the number of chat room messages where messagePublic = &#63; and messageTS = &#63;.
     *
     * @param messagePublic the message public
     * @param messageTS the message t s
     * @return the number of matching chat room messages
     * @throws SystemException if a system exception occurred
     */
    public int countByPublic(boolean messagePublic, Date messageTS)
        throws SystemException {
        Object[] finderArgs = new Object[] { messagePublic, messageTS };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PUBLIC,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CHATROOMMESSAGE_WHERE);

            query.append(_FINDER_COLUMN_PUBLIC_MESSAGEPUBLIC_2);

            if (messageTS == null) {
                query.append(_FINDER_COLUMN_PUBLIC_MESSAGETS_1);
            } else {
                query.append(_FINDER_COLUMN_PUBLIC_MESSAGETS_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(messagePublic);

                if (messageTS != null) {
                    qPos.add(CalendarUtil.getTimestamp(messageTS));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLIC,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of chat room messages where messagePublic = &#63; and recipientUserId = &#63; and messageTS = &#63;.
     *
     * @param messagePublic the message public
     * @param recipientUserId the recipient user ID
     * @param messageTS the message t s
     * @return the number of matching chat room messages
     * @throws SystemException if a system exception occurred
     */
    public int countByPrivateUser(boolean messagePublic, long recipientUserId,
        Date messageTS) throws SystemException {
        Object[] finderArgs = new Object[] {
                messagePublic, recipientUserId, messageTS
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PRIVATEUSER,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_CHATROOMMESSAGE_WHERE);

            query.append(_FINDER_COLUMN_PRIVATEUSER_MESSAGEPUBLIC_2);

            query.append(_FINDER_COLUMN_PRIVATEUSER_RECIPIENTUSERID_2);

            if (messageTS == null) {
                query.append(_FINDER_COLUMN_PRIVATEUSER_MESSAGETS_1);
            } else {
                query.append(_FINDER_COLUMN_PRIVATEUSER_MESSAGETS_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(messagePublic);

                qPos.add(recipientUserId);

                if (messageTS != null) {
                    qPos.add(CalendarUtil.getTimestamp(messageTS));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PRIVATEUSER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of chat room messages.
     *
     * @return the number of chat room messages
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CHATROOMMESSAGE);

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
     * Initializes the chat room message persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ChatRoomMessage>> listenersList = new ArrayList<ModelListener<ChatRoomMessage>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ChatRoomMessage>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ChatRoomMessageImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
