package br.gov.camara.edemocracia.portlets.wikilegis.service.persistence;

import br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao;
import br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoImpl;
import br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoModelImpl;
import br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.ArtigoPersistence;
import br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.ContribuicaoPersistence;
import br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.EstruturaPersistence;

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
 * The persistence implementation for the contribuicao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see ContribuicaoPersistence
 * @see ContribuicaoUtil
 * @generated
 */
public class ContribuicaoPersistenceImpl extends BasePersistenceImpl<Contribuicao>
    implements ContribuicaoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ContribuicaoUtil} to access the contribuicao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ContribuicaoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_A = new FinderPath(ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
            ContribuicaoModelImpl.FINDER_CACHE_ENABLED, ContribuicaoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByA",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A = new FinderPath(ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
            ContribuicaoModelImpl.FINDER_CACHE_ENABLED, ContribuicaoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByA",
            new String[] { Long.class.getName() },
            ContribuicaoModelImpl.ARTIGOID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_A = new FinderPath(ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
            ContribuicaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
            ContribuicaoModelImpl.FINDER_CACHE_ENABLED, ContribuicaoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
            ContribuicaoModelImpl.FINDER_CACHE_ENABLED, ContribuicaoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
            ContribuicaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CONTRIBUICAO = "SELECT contribuicao FROM Contribuicao contribuicao";
    private static final String _SQL_SELECT_CONTRIBUICAO_WHERE = "SELECT contribuicao FROM Contribuicao contribuicao WHERE ";
    private static final String _SQL_COUNT_CONTRIBUICAO = "SELECT COUNT(contribuicao) FROM Contribuicao contribuicao";
    private static final String _SQL_COUNT_CONTRIBUICAO_WHERE = "SELECT COUNT(contribuicao) FROM Contribuicao contribuicao WHERE ";
    private static final String _FINDER_COLUMN_A_ARTIGOID_2 = "contribuicao.artigoId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "contribuicao.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Contribuicao exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Contribuicao exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ContribuicaoPersistenceImpl.class);
    private static Contribuicao _nullContribuicao = new ContribuicaoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Contribuicao> toCacheModel() {
                return _nullContribuicaoCacheModel;
            }
        };

    private static CacheModel<Contribuicao> _nullContribuicaoCacheModel = new CacheModel<Contribuicao>() {
            public Contribuicao toEntityModel() {
                return _nullContribuicao;
            }
        };

    @BeanReference(type = ArtigoPersistence.class)
    protected ArtigoPersistence artigoPersistence;
    @BeanReference(type = ContribuicaoPersistence.class)
    protected ContribuicaoPersistence contribuicaoPersistence;
    @BeanReference(type = EstruturaPersistence.class)
    protected EstruturaPersistence estruturaPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the contribuicao in the entity cache if it is enabled.
     *
     * @param contribuicao the contribuicao
     */
    public void cacheResult(Contribuicao contribuicao) {
        EntityCacheUtil.putResult(ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
            ContribuicaoImpl.class, contribuicao.getPrimaryKey(), contribuicao);

        contribuicao.resetOriginalValues();
    }

    /**
     * Caches the contribuicaos in the entity cache if it is enabled.
     *
     * @param contribuicaos the contribuicaos
     */
    public void cacheResult(List<Contribuicao> contribuicaos) {
        for (Contribuicao contribuicao : contribuicaos) {
            if (EntityCacheUtil.getResult(
                        ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
                        ContribuicaoImpl.class, contribuicao.getPrimaryKey()) == null) {
                cacheResult(contribuicao);
            } else {
                contribuicao.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all contribuicaos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ContribuicaoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ContribuicaoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the contribuicao.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Contribuicao contribuicao) {
        EntityCacheUtil.removeResult(ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
            ContribuicaoImpl.class, contribuicao.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Contribuicao> contribuicaos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Contribuicao contribuicao : contribuicaos) {
            EntityCacheUtil.removeResult(ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
                ContribuicaoImpl.class, contribuicao.getPrimaryKey());
        }
    }

    /**
     * Creates a new contribuicao with the primary key. Does not add the contribuicao to the database.
     *
     * @param contribuicaoId the primary key for the new contribuicao
     * @return the new contribuicao
     */
    public Contribuicao create(long contribuicaoId) {
        Contribuicao contribuicao = new ContribuicaoImpl();

        contribuicao.setNew(true);
        contribuicao.setPrimaryKey(contribuicaoId);

        return contribuicao;
    }

    /**
     * Removes the contribuicao with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param contribuicaoId the primary key of the contribuicao
     * @return the contribuicao that was removed
     * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException if a contribuicao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Contribuicao remove(long contribuicaoId)
        throws NoSuchContribuicaoException, SystemException {
        return remove(Long.valueOf(contribuicaoId));
    }

    /**
     * Removes the contribuicao with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the contribuicao
     * @return the contribuicao that was removed
     * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException if a contribuicao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contribuicao remove(Serializable primaryKey)
        throws NoSuchContribuicaoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Contribuicao contribuicao = (Contribuicao) session.get(ContribuicaoImpl.class,
                    primaryKey);

            if (contribuicao == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchContribuicaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(contribuicao);
        } catch (NoSuchContribuicaoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Contribuicao removeImpl(Contribuicao contribuicao)
        throws SystemException {
        contribuicao = toUnwrappedModel(contribuicao);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, contribuicao);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(contribuicao);

        return contribuicao;
    }

    @Override
    public Contribuicao updateImpl(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao contribuicao,
        boolean merge) throws SystemException {
        contribuicao = toUnwrappedModel(contribuicao);

        boolean isNew = contribuicao.isNew();

        ContribuicaoModelImpl contribuicaoModelImpl = (ContribuicaoModelImpl) contribuicao;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, contribuicao, merge);

            contribuicao.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ContribuicaoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((contribuicaoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(contribuicaoModelImpl.getOriginalArtigoId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A,
                    args);

                args = new Object[] {
                        Long.valueOf(contribuicaoModelImpl.getArtigoId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A,
                    args);
            }
        }

        EntityCacheUtil.putResult(ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
            ContribuicaoImpl.class, contribuicao.getPrimaryKey(), contribuicao);

        return contribuicao;
    }

    protected Contribuicao toUnwrappedModel(Contribuicao contribuicao) {
        if (contribuicao instanceof ContribuicaoImpl) {
            return contribuicao;
        }

        ContribuicaoImpl contribuicaoImpl = new ContribuicaoImpl();

        contribuicaoImpl.setNew(contribuicao.isNew());
        contribuicaoImpl.setPrimaryKey(contribuicao.getPrimaryKey());

        contribuicaoImpl.setContribuicaoId(contribuicao.getContribuicaoId());
        contribuicaoImpl.setArtigoId(contribuicao.getArtigoId());
        contribuicaoImpl.setTexto(contribuicao.getTexto());
        contribuicaoImpl.setDescricao(contribuicao.getDescricao());
        contribuicaoImpl.setData(contribuicao.getData());
        contribuicaoImpl.setUserId(contribuicao.getUserId());
        contribuicaoImpl.setUserName(contribuicao.getUserName());

        return contribuicaoImpl;
    }

    /**
     * Returns the contribuicao with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the contribuicao
     * @return the contribuicao
     * @throws com.liferay.portal.NoSuchModelException if a contribuicao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contribuicao findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the contribuicao with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException} if it could not be found.
     *
     * @param contribuicaoId the primary key of the contribuicao
     * @return the contribuicao
     * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException if a contribuicao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Contribuicao findByPrimaryKey(long contribuicaoId)
        throws NoSuchContribuicaoException, SystemException {
        Contribuicao contribuicao = fetchByPrimaryKey(contribuicaoId);

        if (contribuicao == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + contribuicaoId);
            }

            throw new NoSuchContribuicaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                contribuicaoId);
        }

        return contribuicao;
    }

    /**
     * Returns the contribuicao with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the contribuicao
     * @return the contribuicao, or <code>null</code> if a contribuicao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contribuicao fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the contribuicao with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param contribuicaoId the primary key of the contribuicao
     * @return the contribuicao, or <code>null</code> if a contribuicao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Contribuicao fetchByPrimaryKey(long contribuicaoId)
        throws SystemException {
        Contribuicao contribuicao = (Contribuicao) EntityCacheUtil.getResult(ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
                ContribuicaoImpl.class, contribuicaoId);

        if (contribuicao == _nullContribuicao) {
            return null;
        }

        if (contribuicao == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                contribuicao = (Contribuicao) session.get(ContribuicaoImpl.class,
                        Long.valueOf(contribuicaoId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (contribuicao != null) {
                    cacheResult(contribuicao);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
                        ContribuicaoImpl.class, contribuicaoId,
                        _nullContribuicao);
                }

                closeSession(session);
            }
        }

        return contribuicao;
    }

    /**
     * Returns all the contribuicaos where artigoId = &#63;.
     *
     * @param artigoId the artigo ID
     * @return the matching contribuicaos
     * @throws SystemException if a system exception occurred
     */
    public List<Contribuicao> findByA(long artigoId) throws SystemException {
        return findByA(artigoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the contribuicaos where artigoId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param artigoId the artigo ID
     * @param start the lower bound of the range of contribuicaos
     * @param end the upper bound of the range of contribuicaos (not inclusive)
     * @return the range of matching contribuicaos
     * @throws SystemException if a system exception occurred
     */
    public List<Contribuicao> findByA(long artigoId, int start, int end)
        throws SystemException {
        return findByA(artigoId, start, end, null);
    }

    /**
     * Returns an ordered range of all the contribuicaos where artigoId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param artigoId the artigo ID
     * @param start the lower bound of the range of contribuicaos
     * @param end the upper bound of the range of contribuicaos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching contribuicaos
     * @throws SystemException if a system exception occurred
     */
    public List<Contribuicao> findByA(long artigoId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A;
            finderArgs = new Object[] { artigoId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_A;
            finderArgs = new Object[] { artigoId, start, end, orderByComparator };
        }

        List<Contribuicao> list = (List<Contribuicao>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Contribuicao contribuicao : list) {
                if ((artigoId != contribuicao.getArtigoId())) {
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
                query = new StringBundler(2);
            }

            query.append(_SQL_SELECT_CONTRIBUICAO_WHERE);

            query.append(_FINDER_COLUMN_A_ARTIGOID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(artigoId);

                list = (List<Contribuicao>) QueryUtil.list(q, getDialect(),
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
     * Returns the first contribuicao in the ordered set where artigoId = &#63;.
     *
     * @param artigoId the artigo ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching contribuicao
     * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException if a matching contribuicao could not be found
     * @throws SystemException if a system exception occurred
     */
    public Contribuicao findByA_First(long artigoId,
        OrderByComparator orderByComparator)
        throws NoSuchContribuicaoException, SystemException {
        Contribuicao contribuicao = fetchByA_First(artigoId, orderByComparator);

        if (contribuicao != null) {
            return contribuicao;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("artigoId=");
        msg.append(artigoId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContribuicaoException(msg.toString());
    }

    /**
     * Returns the first contribuicao in the ordered set where artigoId = &#63;.
     *
     * @param artigoId the artigo ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching contribuicao, or <code>null</code> if a matching contribuicao could not be found
     * @throws SystemException if a system exception occurred
     */
    public Contribuicao fetchByA_First(long artigoId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Contribuicao> list = findByA(artigoId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last contribuicao in the ordered set where artigoId = &#63;.
     *
     * @param artigoId the artigo ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching contribuicao
     * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException if a matching contribuicao could not be found
     * @throws SystemException if a system exception occurred
     */
    public Contribuicao findByA_Last(long artigoId,
        OrderByComparator orderByComparator)
        throws NoSuchContribuicaoException, SystemException {
        Contribuicao contribuicao = fetchByA_Last(artigoId, orderByComparator);

        if (contribuicao != null) {
            return contribuicao;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("artigoId=");
        msg.append(artigoId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContribuicaoException(msg.toString());
    }

    /**
     * Returns the last contribuicao in the ordered set where artigoId = &#63;.
     *
     * @param artigoId the artigo ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching contribuicao, or <code>null</code> if a matching contribuicao could not be found
     * @throws SystemException if a system exception occurred
     */
    public Contribuicao fetchByA_Last(long artigoId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByA(artigoId);

        List<Contribuicao> list = findByA(artigoId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the contribuicaos before and after the current contribuicao in the ordered set where artigoId = &#63;.
     *
     * @param contribuicaoId the primary key of the current contribuicao
     * @param artigoId the artigo ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next contribuicao
     * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException if a contribuicao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Contribuicao[] findByA_PrevAndNext(long contribuicaoId,
        long artigoId, OrderByComparator orderByComparator)
        throws NoSuchContribuicaoException, SystemException {
        Contribuicao contribuicao = findByPrimaryKey(contribuicaoId);

        Session session = null;

        try {
            session = openSession();

            Contribuicao[] array = new ContribuicaoImpl[3];

            array[0] = getByA_PrevAndNext(session, contribuicao, artigoId,
                    orderByComparator, true);

            array[1] = contribuicao;

            array[2] = getByA_PrevAndNext(session, contribuicao, artigoId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Contribuicao getByA_PrevAndNext(Session session,
        Contribuicao contribuicao, long artigoId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTRIBUICAO_WHERE);

        query.append(_FINDER_COLUMN_A_ARTIGOID_2);

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

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(artigoId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(contribuicao);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Contribuicao> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the contribuicaos.
     *
     * @return the contribuicaos
     * @throws SystemException if a system exception occurred
     */
    public List<Contribuicao> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the contribuicaos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of contribuicaos
     * @param end the upper bound of the range of contribuicaos (not inclusive)
     * @return the range of contribuicaos
     * @throws SystemException if a system exception occurred
     */
    public List<Contribuicao> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the contribuicaos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of contribuicaos
     * @param end the upper bound of the range of contribuicaos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of contribuicaos
     * @throws SystemException if a system exception occurred
     */
    public List<Contribuicao> findAll(int start, int end,
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

        List<Contribuicao> list = (List<Contribuicao>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CONTRIBUICAO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CONTRIBUICAO;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Contribuicao>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Contribuicao>) QueryUtil.list(q, getDialect(),
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
     * Removes all the contribuicaos where artigoId = &#63; from the database.
     *
     * @param artigoId the artigo ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByA(long artigoId) throws SystemException {
        for (Contribuicao contribuicao : findByA(artigoId)) {
            remove(contribuicao);
        }
    }

    /**
     * Removes all the contribuicaos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Contribuicao contribuicao : findAll()) {
            remove(contribuicao);
        }
    }

    /**
     * Returns the number of contribuicaos where artigoId = &#63;.
     *
     * @param artigoId the artigo ID
     * @return the number of matching contribuicaos
     * @throws SystemException if a system exception occurred
     */
    public int countByA(long artigoId) throws SystemException {
        Object[] finderArgs = new Object[] { artigoId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_A,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONTRIBUICAO_WHERE);

            query.append(_FINDER_COLUMN_A_ARTIGOID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(artigoId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of contribuicaos.
     *
     * @return the number of contribuicaos
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CONTRIBUICAO);

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
     * Initializes the contribuicao persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Contribuicao>> listenersList = new ArrayList<ModelListener<Contribuicao>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Contribuicao>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ContribuicaoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
