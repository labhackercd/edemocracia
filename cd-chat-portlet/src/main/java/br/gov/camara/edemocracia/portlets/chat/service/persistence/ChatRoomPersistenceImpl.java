package br.gov.camara.edemocracia.portlets.chat.service.persistence;

import br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomImpl;
import br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomModelImpl;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomMessagePersistence;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomPersistence;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomTwitterPersistence;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomUserPersistence;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomVideoPersistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
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
 * The persistence implementation for the chat room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomPersistence
 * @see ChatRoomUtil
 * @generated
 */
public class ChatRoomPersistenceImpl extends BasePersistenceImpl<ChatRoom>
    implements ChatRoomPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ChatRoomUtil} to access the chat room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ChatRoomImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomModelImpl.FINDER_CACHE_ENABLED, ChatRoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomModelImpl.FINDER_CACHE_ENABLED, ChatRoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            ChatRoomModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPROOMNAME =
        new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomModelImpl.FINDER_CACHE_ENABLED, ChatRoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupRoomName",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPROOMNAME =
        new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomModelImpl.FINDER_CACHE_ENABLED, ChatRoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupRoomName",
            new String[] { String.class.getName(), Long.class.getName() },
            ChatRoomModelImpl.ROOMNAME_COLUMN_BITMASK |
            ChatRoomModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPROOMNAME = new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupRoomName",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomModelImpl.FINDER_CACHE_ENABLED, ChatRoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomModelImpl.FINDER_CACHE_ENABLED, ChatRoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            ChatRoomModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomModelImpl.FINDER_CACHE_ENABLED, ChatRoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomModelImpl.FINDER_CACHE_ENABLED, ChatRoomImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_GET_CHATROOMUSERS = new FinderPath(br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserModelImpl.FINDER_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserImpl.class,
            br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomUserPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getChatRoomUsers",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_CHATROOMUSERS.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_CHATROOMUSERS_SIZE = new FinderPath(br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserModelImpl.FINDER_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserImpl.class,
            br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomUserPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getChatRoomUsersSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_CHATROOMUSERS_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_CHATROOMUSER = new FinderPath(br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserModelImpl.ENTITY_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserModelImpl.FINDER_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserImpl.class,
            br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomUserPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "containsChatRoomUser",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_GET_CHATROOMMESSAGES = new FinderPath(br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageModelImpl.FINDER_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageImpl.class,
            br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomMessagePersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getChatRoomMessages",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_CHATROOMMESSAGES.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_CHATROOMMESSAGES_SIZE = new FinderPath(br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageModelImpl.FINDER_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageImpl.class,
            br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomMessagePersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getChatRoomMessagesSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_CHATROOMMESSAGES_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_CHATROOMMESSAGE = new FinderPath(br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageModelImpl.ENTITY_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageModelImpl.FINDER_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageImpl.class,
            br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomMessagePersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "containsChatRoomMessage",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _SQL_SELECT_CHATROOM = "SELECT chatRoom FROM ChatRoom chatRoom";
    private static final String _SQL_SELECT_CHATROOM_WHERE = "SELECT chatRoom FROM ChatRoom chatRoom WHERE ";
    private static final String _SQL_COUNT_CHATROOM = "SELECT COUNT(chatRoom) FROM ChatRoom chatRoom";
    private static final String _SQL_COUNT_CHATROOM_WHERE = "SELECT COUNT(chatRoom) FROM ChatRoom chatRoom WHERE ";
    private static final String _SQL_GETCHATROOMUSERS = "SELECT {CDChat_ChatRoomUser.*} FROM CDChat_ChatRoomUser INNER JOIN CDChat_ChatRoom ON (CDChat_ChatRoom.roomId = CDChat_ChatRoomUser.roomId) WHERE (CDChat_ChatRoom.roomId = ?)";
    private static final String _SQL_GETCHATROOMUSERSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM CDChat_ChatRoomUser WHERE roomId = ?";
    private static final String _SQL_CONTAINSCHATROOMUSER = "SELECT COUNT(*) AS COUNT_VALUE FROM CDChat_ChatRoomUser WHERE roomId = ? AND chatUserId = ?";
    private static final String _SQL_GETCHATROOMMESSAGES = "SELECT {CDChat_ChatRoomMessage.*} FROM CDChat_ChatRoomMessage INNER JOIN CDChat_ChatRoom ON (CDChat_ChatRoom.roomId = CDChat_ChatRoomMessage.roomId) WHERE (CDChat_ChatRoom.roomId = ?)";
    private static final String _SQL_GETCHATROOMMESSAGESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM CDChat_ChatRoomMessage WHERE roomId = ?";
    private static final String _SQL_CONTAINSCHATROOMMESSAGE = "SELECT COUNT(*) AS COUNT_VALUE FROM CDChat_ChatRoomMessage WHERE roomId = ? AND chatMessageId = ?";
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "chatRoom.companyId = ?";
    private static final String _FINDER_COLUMN_GROUPROOMNAME_ROOMNAME_1 = "chatRoom.roomName IS NULL AND ";
    private static final String _FINDER_COLUMN_GROUPROOMNAME_ROOMNAME_2 = "chatRoom.roomName = ? AND ";
    private static final String _FINDER_COLUMN_GROUPROOMNAME_ROOMNAME_3 = "(chatRoom.roomName IS NULL OR chatRoom.roomName = ?) AND ";
    private static final String _FINDER_COLUMN_GROUPROOMNAME_GROUPID_2 = "chatRoom.groupId = ?";
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "chatRoom.groupId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "chatRoom.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChatRoom exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChatRoom exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ChatRoomPersistenceImpl.class);
    private static ChatRoom _nullChatRoom = new ChatRoomImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ChatRoom> toCacheModel() {
                return _nullChatRoomCacheModel;
            }
        };

    private static CacheModel<ChatRoom> _nullChatRoomCacheModel = new CacheModel<ChatRoom>() {
            public ChatRoom toEntityModel() {
                return _nullChatRoom;
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
    protected ContainsChatRoomUser containsChatRoomUser;
    protected ContainsChatRoomMessage containsChatRoomMessage;

    /**
     * Caches the chat room in the entity cache if it is enabled.
     *
     * @param chatRoom the chat room
     */
    public void cacheResult(ChatRoom chatRoom) {
        EntityCacheUtil.putResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomImpl.class, chatRoom.getPrimaryKey(), chatRoom);

        chatRoom.resetOriginalValues();
    }

    /**
     * Caches the chat rooms in the entity cache if it is enabled.
     *
     * @param chatRooms the chat rooms
     */
    public void cacheResult(List<ChatRoom> chatRooms) {
        for (ChatRoom chatRoom : chatRooms) {
            if (EntityCacheUtil.getResult(
                        ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
                        ChatRoomImpl.class, chatRoom.getPrimaryKey()) == null) {
                cacheResult(chatRoom);
            } else {
                chatRoom.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all chat rooms.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ChatRoomImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ChatRoomImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the chat room.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ChatRoom chatRoom) {
        EntityCacheUtil.removeResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomImpl.class, chatRoom.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ChatRoom> chatRooms) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ChatRoom chatRoom : chatRooms) {
            EntityCacheUtil.removeResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
                ChatRoomImpl.class, chatRoom.getPrimaryKey());
        }
    }

    /**
     * Creates a new chat room with the primary key. Does not add the chat room to the database.
     *
     * @param roomId the primary key for the new chat room
     * @return the new chat room
     */
    public ChatRoom create(long roomId) {
        ChatRoom chatRoom = new ChatRoomImpl();

        chatRoom.setNew(true);
        chatRoom.setPrimaryKey(roomId);

        return chatRoom;
    }

    /**
     * Removes the chat room with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param roomId the primary key of the chat room
     * @return the chat room that was removed
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a chat room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom remove(long roomId)
        throws NoSuchChatRoomException, SystemException {
        return remove(Long.valueOf(roomId));
    }

    /**
     * Removes the chat room with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the chat room
     * @return the chat room that was removed
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a chat room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoom remove(Serializable primaryKey)
        throws NoSuchChatRoomException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ChatRoom chatRoom = (ChatRoom) session.get(ChatRoomImpl.class,
                    primaryKey);

            if (chatRoom == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchChatRoomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(chatRoom);
        } catch (NoSuchChatRoomException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ChatRoom removeImpl(ChatRoom chatRoom) throws SystemException {
        chatRoom = toUnwrappedModel(chatRoom);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, chatRoom);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(chatRoom);

        return chatRoom;
    }

    @Override
    public ChatRoom updateImpl(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom,
        boolean merge) throws SystemException {
        chatRoom = toUnwrappedModel(chatRoom);

        boolean isNew = chatRoom.isNew();

        ChatRoomModelImpl chatRoomModelImpl = (ChatRoomModelImpl) chatRoom;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, chatRoom, merge);

            chatRoom.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ChatRoomModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((chatRoomModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(chatRoomModelImpl.getOriginalCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] {
                        Long.valueOf(chatRoomModelImpl.getCompanyId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((chatRoomModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPROOMNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        chatRoomModelImpl.getOriginalRoomName(),
                        Long.valueOf(chatRoomModelImpl.getOriginalGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPROOMNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPROOMNAME,
                    args);

                args = new Object[] {
                        chatRoomModelImpl.getRoomName(),
                        Long.valueOf(chatRoomModelImpl.getGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPROOMNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPROOMNAME,
                    args);
            }

            if ((chatRoomModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(chatRoomModelImpl.getOriginalGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { Long.valueOf(chatRoomModelImpl.getGroupId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
            ChatRoomImpl.class, chatRoom.getPrimaryKey(), chatRoom);

        return chatRoom;
    }

    protected ChatRoom toUnwrappedModel(ChatRoom chatRoom) {
        if (chatRoom instanceof ChatRoomImpl) {
            return chatRoom;
        }

        ChatRoomImpl chatRoomImpl = new ChatRoomImpl();

        chatRoomImpl.setNew(chatRoom.isNew());
        chatRoomImpl.setPrimaryKey(chatRoom.getPrimaryKey());

        chatRoomImpl.setRoomId(chatRoom.getRoomId());
        chatRoomImpl.setRoomName(chatRoom.getRoomName());
        chatRoomImpl.setDescription(chatRoom.getDescription());
        chatRoomImpl.setOpenPolicy(chatRoom.getOpenPolicy());
        chatRoomImpl.setStatus(chatRoom.getStatus());
        chatRoomImpl.setOpenFrom(chatRoom.getOpenFrom());
        chatRoomImpl.setOpenUntil(chatRoom.getOpenUntil());
        chatRoomImpl.setModerated(chatRoom.isModerated());
        chatRoomImpl.setCapacity(chatRoom.getCapacity());
        chatRoomImpl.setMaxSimultaneousUsersSpying(chatRoom.getMaxSimultaneousUsersSpying());
        chatRoomImpl.setMaxSimultaneousUsers(chatRoom.getMaxSimultaneousUsers());
        chatRoomImpl.setAnonymousAllowed(chatRoom.isAnonymousAllowed());
        chatRoomImpl.setGuestId(chatRoom.getGuestId());
        chatRoomImpl.setGuestName(chatRoom.getGuestName());
        chatRoomImpl.setCompanyId(chatRoom.getCompanyId());
        chatRoomImpl.setGroupId(chatRoom.getGroupId());
        chatRoomImpl.setUsePolicyEnabled(chatRoom.isUsePolicyEnabled());
        chatRoomImpl.setUsePolicyURL(chatRoom.getUsePolicyURL());
        chatRoomImpl.setImageId(chatRoom.getImageId());
        chatRoomImpl.setVideoLiveId(chatRoom.getVideoLiveId());
        chatRoomImpl.setVideoRecordedId(chatRoom.getVideoRecordedId());
        chatRoomImpl.setCreateDate(chatRoom.getCreateDate());

        return chatRoomImpl;
    }

    /**
     * Returns the chat room with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the chat room
     * @return the chat room
     * @throws com.liferay.portal.NoSuchModelException if a chat room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoom findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the chat room with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException} if it could not be found.
     *
     * @param roomId the primary key of the chat room
     * @return the chat room
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a chat room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom findByPrimaryKey(long roomId)
        throws NoSuchChatRoomException, SystemException {
        ChatRoom chatRoom = fetchByPrimaryKey(roomId);

        if (chatRoom == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + roomId);
            }

            throw new NoSuchChatRoomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                roomId);
        }

        return chatRoom;
    }

    /**
     * Returns the chat room with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the chat room
     * @return the chat room, or <code>null</code> if a chat room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ChatRoom fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the chat room with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param roomId the primary key of the chat room
     * @return the chat room, or <code>null</code> if a chat room with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom fetchByPrimaryKey(long roomId) throws SystemException {
        ChatRoom chatRoom = (ChatRoom) EntityCacheUtil.getResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
                ChatRoomImpl.class, roomId);

        if (chatRoom == _nullChatRoom) {
            return null;
        }

        if (chatRoom == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                chatRoom = (ChatRoom) session.get(ChatRoomImpl.class,
                        Long.valueOf(roomId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (chatRoom != null) {
                    cacheResult(chatRoom);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ChatRoomModelImpl.ENTITY_CACHE_ENABLED,
                        ChatRoomImpl.class, roomId, _nullChatRoom);
                }

                closeSession(session);
            }
        }

        return chatRoom;
    }

    /**
     * Returns all the chat rooms where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching chat rooms
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoom> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

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
    public List<ChatRoom> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

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
    public List<ChatRoom> findByCompanyId(long companyId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId, start, end, orderByComparator };
        }

        List<ChatRoom> list = (List<ChatRoom>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ChatRoom chatRoom : list) {
                if ((companyId != chatRoom.getCompanyId())) {
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

            query.append(_SQL_SELECT_CHATROOM_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ChatRoomModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                list = (List<ChatRoom>) QueryUtil.list(q, getDialect(), start,
                        end);
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
     * Returns the first chat room in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomException, SystemException {
        ChatRoom chatRoom = fetchByCompanyId_First(companyId, orderByComparator);

        if (chatRoom != null) {
            return chatRoom;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomException(msg.toString());
    }

    /**
     * Returns the first chat room in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room, or <code>null</code> if a matching chat room could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ChatRoom> list = findByCompanyId(companyId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last chat room in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching chat room
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomException, SystemException {
        ChatRoom chatRoom = fetchByCompanyId_Last(companyId, orderByComparator);

        if (chatRoom != null) {
            return chatRoom;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomException(msg.toString());
    }

    /**
     * Returns the last chat room in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching chat room, or <code>null</code> if a matching chat room could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        List<ChatRoom> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    public ChatRoom[] findByCompanyId_PrevAndNext(long roomId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomException, SystemException {
        ChatRoom chatRoom = findByPrimaryKey(roomId);

        Session session = null;

        try {
            session = openSession();

            ChatRoom[] array = new ChatRoomImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, chatRoom, companyId,
                    orderByComparator, true);

            array[1] = chatRoom;

            array[2] = getByCompanyId_PrevAndNext(session, chatRoom, companyId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ChatRoom getByCompanyId_PrevAndNext(Session session,
        ChatRoom chatRoom, long companyId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CHATROOM_WHERE);

        query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
            query.append(ChatRoomModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(chatRoom);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ChatRoom> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the chat rooms where roomName = &#63; and groupId = &#63;.
     *
     * @param roomName the room name
     * @param groupId the group ID
     * @return the matching chat rooms
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoom> findByGroupRoomName(String roomName, long groupId)
        throws SystemException {
        return findByGroupRoomName(roomName, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

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
    public List<ChatRoom> findByGroupRoomName(String roomName, long groupId,
        int start, int end) throws SystemException {
        return findByGroupRoomName(roomName, groupId, start, end, null);
    }

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
    public List<ChatRoom> findByGroupRoomName(String roomName, long groupId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPROOMNAME;
            finderArgs = new Object[] { roomName, groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPROOMNAME;
            finderArgs = new Object[] {
                    roomName, groupId,
                    
                    start, end, orderByComparator
                };
        }

        List<ChatRoom> list = (List<ChatRoom>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ChatRoom chatRoom : list) {
                if (!Validator.equals(roomName, chatRoom.getRoomName()) ||
                        (groupId != chatRoom.getGroupId())) {
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

            query.append(_SQL_SELECT_CHATROOM_WHERE);

            if (roomName == null) {
                query.append(_FINDER_COLUMN_GROUPROOMNAME_ROOMNAME_1);
            } else {
                if (roomName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_GROUPROOMNAME_ROOMNAME_3);
                } else {
                    query.append(_FINDER_COLUMN_GROUPROOMNAME_ROOMNAME_2);
                }
            }

            query.append(_FINDER_COLUMN_GROUPROOMNAME_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ChatRoomModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (roomName != null) {
                    qPos.add(roomName);
                }

                qPos.add(groupId);

                list = (List<ChatRoom>) QueryUtil.list(q, getDialect(), start,
                        end);
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
     * Returns the first chat room in the ordered set where roomName = &#63; and groupId = &#63;.
     *
     * @param roomName the room name
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom findByGroupRoomName_First(String roomName, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomException, SystemException {
        ChatRoom chatRoom = fetchByGroupRoomName_First(roomName, groupId,
                orderByComparator);

        if (chatRoom != null) {
            return chatRoom;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("roomName=");
        msg.append(roomName);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomException(msg.toString());
    }

    /**
     * Returns the first chat room in the ordered set where roomName = &#63; and groupId = &#63;.
     *
     * @param roomName the room name
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room, or <code>null</code> if a matching chat room could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom fetchByGroupRoomName_First(String roomName, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ChatRoom> list = findByGroupRoomName(roomName, groupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    public ChatRoom findByGroupRoomName_Last(String roomName, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomException, SystemException {
        ChatRoom chatRoom = fetchByGroupRoomName_Last(roomName, groupId,
                orderByComparator);

        if (chatRoom != null) {
            return chatRoom;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("roomName=");
        msg.append(roomName);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomException(msg.toString());
    }

    /**
     * Returns the last chat room in the ordered set where roomName = &#63; and groupId = &#63;.
     *
     * @param roomName the room name
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching chat room, or <code>null</code> if a matching chat room could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom fetchByGroupRoomName_Last(String roomName, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupRoomName(roomName, groupId);

        List<ChatRoom> list = findByGroupRoomName(roomName, groupId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    public ChatRoom[] findByGroupRoomName_PrevAndNext(long roomId,
        String roomName, long groupId, OrderByComparator orderByComparator)
        throws NoSuchChatRoomException, SystemException {
        ChatRoom chatRoom = findByPrimaryKey(roomId);

        Session session = null;

        try {
            session = openSession();

            ChatRoom[] array = new ChatRoomImpl[3];

            array[0] = getByGroupRoomName_PrevAndNext(session, chatRoom,
                    roomName, groupId, orderByComparator, true);

            array[1] = chatRoom;

            array[2] = getByGroupRoomName_PrevAndNext(session, chatRoom,
                    roomName, groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ChatRoom getByGroupRoomName_PrevAndNext(Session session,
        ChatRoom chatRoom, String roomName, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CHATROOM_WHERE);

        if (roomName == null) {
            query.append(_FINDER_COLUMN_GROUPROOMNAME_ROOMNAME_1);
        } else {
            if (roomName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_GROUPROOMNAME_ROOMNAME_3);
            } else {
                query.append(_FINDER_COLUMN_GROUPROOMNAME_ROOMNAME_2);
            }
        }

        query.append(_FINDER_COLUMN_GROUPROOMNAME_GROUPID_2);

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
            query.append(ChatRoomModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (roomName != null) {
            qPos.add(roomName);
        }

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(chatRoom);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ChatRoom> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the chat rooms where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching chat rooms
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoom> findByGroupId(long groupId) throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    public List<ChatRoom> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

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
    public List<ChatRoom> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<ChatRoom> list = (List<ChatRoom>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ChatRoom chatRoom : list) {
                if ((groupId != chatRoom.getGroupId())) {
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

            query.append(_SQL_SELECT_CHATROOM_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ChatRoomModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                list = (List<ChatRoom>) QueryUtil.list(q, getDialect(), start,
                        end);
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
     * Returns the first chat room in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomException, SystemException {
        ChatRoom chatRoom = fetchByGroupId_First(groupId, orderByComparator);

        if (chatRoom != null) {
            return chatRoom;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomException(msg.toString());
    }

    /**
     * Returns the first chat room in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching chat room, or <code>null</code> if a matching chat room could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ChatRoom> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last chat room in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching chat room
     * @throws br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException if a matching chat room could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomException, SystemException {
        ChatRoom chatRoom = fetchByGroupId_Last(groupId, orderByComparator);

        if (chatRoom != null) {
            return chatRoom;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchChatRoomException(msg.toString());
    }

    /**
     * Returns the last chat room in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching chat room, or <code>null</code> if a matching chat room could not be found
     * @throws SystemException if a system exception occurred
     */
    public ChatRoom fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        List<ChatRoom> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    public ChatRoom[] findByGroupId_PrevAndNext(long roomId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchChatRoomException, SystemException {
        ChatRoom chatRoom = findByPrimaryKey(roomId);

        Session session = null;

        try {
            session = openSession();

            ChatRoom[] array = new ChatRoomImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, chatRoom, groupId,
                    orderByComparator, true);

            array[1] = chatRoom;

            array[2] = getByGroupId_PrevAndNext(session, chatRoom, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ChatRoom getByGroupId_PrevAndNext(Session session,
        ChatRoom chatRoom, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CHATROOM_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
            query.append(ChatRoomModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(chatRoom);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ChatRoom> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the chat rooms.
     *
     * @return the chat rooms
     * @throws SystemException if a system exception occurred
     */
    public List<ChatRoom> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    public List<ChatRoom> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    public List<ChatRoom> findAll(int start, int end,
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

        List<ChatRoom> list = (List<ChatRoom>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CHATROOM);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CHATROOM.concat(ChatRoomModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<ChatRoom>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ChatRoom>) QueryUtil.list(q, getDialect(),
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
     * Removes all the chat rooms where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByCompanyId(long companyId) throws SystemException {
        for (ChatRoom chatRoom : findByCompanyId(companyId)) {
            remove(chatRoom);
        }
    }

    /**
     * Removes all the chat rooms where roomName = &#63; and groupId = &#63; from the database.
     *
     * @param roomName the room name
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByGroupRoomName(String roomName, long groupId)
        throws SystemException {
        for (ChatRoom chatRoom : findByGroupRoomName(roomName, groupId)) {
            remove(chatRoom);
        }
    }

    /**
     * Removes all the chat rooms where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByGroupId(long groupId) throws SystemException {
        for (ChatRoom chatRoom : findByGroupId(groupId)) {
            remove(chatRoom);
        }
    }

    /**
     * Removes all the chat rooms from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (ChatRoom chatRoom : findAll()) {
            remove(chatRoom);
        }
    }

    /**
     * Returns the number of chat rooms where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching chat rooms
     * @throws SystemException if a system exception occurred
     */
    public int countByCompanyId(long companyId) throws SystemException {
        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CHATROOM_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of chat rooms where roomName = &#63; and groupId = &#63;.
     *
     * @param roomName the room name
     * @param groupId the group ID
     * @return the number of matching chat rooms
     * @throws SystemException if a system exception occurred
     */
    public int countByGroupRoomName(String roomName, long groupId)
        throws SystemException {
        Object[] finderArgs = new Object[] { roomName, groupId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPROOMNAME,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CHATROOM_WHERE);

            if (roomName == null) {
                query.append(_FINDER_COLUMN_GROUPROOMNAME_ROOMNAME_1);
            } else {
                if (roomName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_GROUPROOMNAME_ROOMNAME_3);
                } else {
                    query.append(_FINDER_COLUMN_GROUPROOMNAME_ROOMNAME_2);
                }
            }

            query.append(_FINDER_COLUMN_GROUPROOMNAME_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (roomName != null) {
                    qPos.add(roomName);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPROOMNAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of chat rooms where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching chat rooms
     * @throws SystemException if a system exception occurred
     */
    public int countByGroupId(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CHATROOM_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of chat rooms.
     *
     * @return the number of chat rooms
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CHATROOM);

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
     * Returns all the chat room users associated with the chat room.
     *
     * @param pk the primary key of the chat room
     * @return the chat room users associated with the chat room
     * @throws SystemException if a system exception occurred
     */
    public List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> getChatRoomUsers(
        long pk) throws SystemException {
        return getChatRoomUsers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

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
    public List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> getChatRoomUsers(
        long pk, int start, int end) throws SystemException {
        return getChatRoomUsers(pk, start, end, null);
    }

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
    public List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> getChatRoomUsers(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser> list = (List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser>) FinderCacheUtil.getResult(FINDER_PATH_GET_CHATROOMUSERS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETCHATROOMUSERS.concat(ORDER_BY_CLAUSE)
                                               .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETCHATROOMUSERS.concat(br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserModelImpl.ORDER_BY_SQL);
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("CDChat_ChatRoomUser",
                    br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_CHATROOMUSERS,
                        finderArgs);
                } else {
                    chatRoomUserPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_CHATROOMUSERS,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of chat room users associated with the chat room.
     *
     * @param pk the primary key of the chat room
     * @return the number of chat room users associated with the chat room
     * @throws SystemException if a system exception occurred
     */
    public int getChatRoomUsersSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_CHATROOMUSERS_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETCHATROOMUSERSSIZE);

                q.addScalar(COUNT_COLUMN_NAME,
                    com.liferay.portal.kernel.dao.orm.Type.LONG);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_GET_CHATROOMUSERS_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the chat room user is associated with the chat room.
     *
     * @param pk the primary key of the chat room
     * @param chatRoomUserPK the primary key of the chat room user
     * @return <code>true</code> if the chat room user is associated with the chat room; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsChatRoomUser(long pk, long chatRoomUserPK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, chatRoomUserPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_CHATROOMUSER,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsChatRoomUser.contains(pk,
                            chatRoomUserPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_CHATROOMUSER,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the chat room has any chat room users associated with it.
     *
     * @param pk the primary key of the chat room to check for associations with chat room users
     * @return <code>true</code> if the chat room has any chat room users associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsChatRoomUsers(long pk) throws SystemException {
        if (getChatRoomUsersSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns all the chat room messages associated with the chat room.
     *
     * @param pk the primary key of the chat room
     * @return the chat room messages associated with the chat room
     * @throws SystemException if a system exception occurred
     */
    public List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> getChatRoomMessages(
        long pk) throws SystemException {
        return getChatRoomMessages(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

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
    public List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> getChatRoomMessages(
        long pk, int start, int end) throws SystemException {
        return getChatRoomMessages(pk, start, end, null);
    }

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
    public List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> getChatRoomMessages(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage> list =
            (List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage>) FinderCacheUtil.getResult(FINDER_PATH_GET_CHATROOMMESSAGES,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETCHATROOMMESSAGES.concat(ORDER_BY_CLAUSE)
                                                  .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETCHATROOMMESSAGES.concat(br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageModelImpl.ORDER_BY_SQL);
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("CDChat_ChatRoomMessage",
                    br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_CHATROOMMESSAGES,
                        finderArgs);
                } else {
                    chatRoomMessagePersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_CHATROOMMESSAGES,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of chat room messages associated with the chat room.
     *
     * @param pk the primary key of the chat room
     * @return the number of chat room messages associated with the chat room
     * @throws SystemException if a system exception occurred
     */
    public int getChatRoomMessagesSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_CHATROOMMESSAGES_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETCHATROOMMESSAGESSIZE);

                q.addScalar(COUNT_COLUMN_NAME,
                    com.liferay.portal.kernel.dao.orm.Type.LONG);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_GET_CHATROOMMESSAGES_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the chat room message is associated with the chat room.
     *
     * @param pk the primary key of the chat room
     * @param chatRoomMessagePK the primary key of the chat room message
     * @return <code>true</code> if the chat room message is associated with the chat room; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsChatRoomMessage(long pk, long chatRoomMessagePK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, chatRoomMessagePK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_CHATROOMMESSAGE,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsChatRoomMessage.contains(pk,
                            chatRoomMessagePK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_CHATROOMMESSAGE,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the chat room has any chat room messages associated with it.
     *
     * @param pk the primary key of the chat room to check for associations with chat room messages
     * @return <code>true</code> if the chat room has any chat room messages associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsChatRoomMessages(long pk) throws SystemException {
        if (getChatRoomMessagesSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Initializes the chat room persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.chat.model.ChatRoom")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ChatRoom>> listenersList = new ArrayList<ModelListener<ChatRoom>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ChatRoom>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        containsChatRoomUser = new ContainsChatRoomUser();

        containsChatRoomMessage = new ContainsChatRoomMessage();
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ChatRoomImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    protected class ContainsChatRoomUser {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsChatRoomUser() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSCHATROOMUSER,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long roomId, long chatUserId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(roomId), new Long(chatUserId)
                    });

            if (results.size() > 0) {
                Integer count = results.get(0);

                if (count.intValue() > 0) {
                    return true;
                }
            }

            return false;
        }
    }

    protected class ContainsChatRoomMessage {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsChatRoomMessage() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSCHATROOMMESSAGE,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long roomId, long chatMessageId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(roomId), new Long(chatMessageId)
                    });

            if (results.size() > 0) {
                Integer count = results.get(0);

                if (count.intValue() > 0) {
                    return true;
                }
            }

            return false;
        }
    }
}
