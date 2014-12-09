package br.gov.camara.edemocracia.portlets.guiadiscussao.service.persistence;

import br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.FaseImpl;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.FaseModelImpl;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.persistence.AcaoPersistence;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.persistence.ConfiguracaoPersistence;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.persistence.FasePersistence;

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
 * The persistence implementation for the fase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robson
 * @see FasePersistence
 * @see FaseUtil
 * @generated
 */
public class FasePersistenceImpl extends BasePersistenceImpl<Fase>
    implements FasePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link FaseUtil} to access the fase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = FaseImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONFIGURACAOID =
        new FinderPath(FaseModelImpl.ENTITY_CACHE_ENABLED,
            FaseModelImpl.FINDER_CACHE_ENABLED, FaseImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConfiguracaoId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURACAOID =
        new FinderPath(FaseModelImpl.ENTITY_CACHE_ENABLED,
            FaseModelImpl.FINDER_CACHE_ENABLED, FaseImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConfiguracaoId",
            new String[] { Long.class.getName() },
            FaseModelImpl.CONFIGURACAOID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CONFIGURACAOID = new FinderPath(FaseModelImpl.ENTITY_CACHE_ENABLED,
            FaseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConfiguracaoId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FaseModelImpl.ENTITY_CACHE_ENABLED,
            FaseModelImpl.FINDER_CACHE_ENABLED, FaseImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FaseModelImpl.ENTITY_CACHE_ENABLED,
            FaseModelImpl.FINDER_CACHE_ENABLED, FaseImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FaseModelImpl.ENTITY_CACHE_ENABLED,
            FaseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_FASE = "SELECT fase FROM Fase fase";
    private static final String _SQL_SELECT_FASE_WHERE = "SELECT fase FROM Fase fase WHERE ";
    private static final String _SQL_COUNT_FASE = "SELECT COUNT(fase) FROM Fase fase";
    private static final String _SQL_COUNT_FASE_WHERE = "SELECT COUNT(fase) FROM Fase fase WHERE ";
    private static final String _FINDER_COLUMN_CONFIGURACAOID_CONFIGURACAOID_2 = "fase.configuracaoId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "fase.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Fase exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Fase exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(FasePersistenceImpl.class);
    private static Fase _nullFase = new FaseImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Fase> toCacheModel() {
                return _nullFaseCacheModel;
            }
        };

    private static CacheModel<Fase> _nullFaseCacheModel = new CacheModel<Fase>() {
            public Fase toEntityModel() {
                return _nullFase;
            }
        };

    @BeanReference(type = AcaoPersistence.class)
    protected AcaoPersistence acaoPersistence;
    @BeanReference(type = ConfiguracaoPersistence.class)
    protected ConfiguracaoPersistence configuracaoPersistence;
    @BeanReference(type = FasePersistence.class)
    protected FasePersistence fasePersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the fase in the entity cache if it is enabled.
     *
     * @param fase the fase
     */
    public void cacheResult(Fase fase) {
        EntityCacheUtil.putResult(FaseModelImpl.ENTITY_CACHE_ENABLED,
            FaseImpl.class, fase.getPrimaryKey(), fase);

        fase.resetOriginalValues();
    }

    /**
     * Caches the fases in the entity cache if it is enabled.
     *
     * @param fases the fases
     */
    public void cacheResult(List<Fase> fases) {
        for (Fase fase : fases) {
            if (EntityCacheUtil.getResult(FaseModelImpl.ENTITY_CACHE_ENABLED,
                        FaseImpl.class, fase.getPrimaryKey()) == null) {
                cacheResult(fase);
            } else {
                fase.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all fases.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(FaseImpl.class.getName());
        }

        EntityCacheUtil.clearCache(FaseImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the fase.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Fase fase) {
        EntityCacheUtil.removeResult(FaseModelImpl.ENTITY_CACHE_ENABLED,
            FaseImpl.class, fase.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Fase> fases) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Fase fase : fases) {
            EntityCacheUtil.removeResult(FaseModelImpl.ENTITY_CACHE_ENABLED,
                FaseImpl.class, fase.getPrimaryKey());
        }
    }

    /**
     * Creates a new fase with the primary key. Does not add the fase to the database.
     *
     * @param faseId the primary key for the new fase
     * @return the new fase
     */
    public Fase create(long faseId) {
        Fase fase = new FaseImpl();

        fase.setNew(true);
        fase.setPrimaryKey(faseId);

        return fase;
    }

    /**
     * Removes the fase with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param faseId the primary key of the fase
     * @return the fase that was removed
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a fase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Fase remove(long faseId) throws NoSuchFaseException, SystemException {
        return remove(Long.valueOf(faseId));
    }

    /**
     * Removes the fase with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the fase
     * @return the fase that was removed
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a fase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Fase remove(Serializable primaryKey)
        throws NoSuchFaseException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Fase fase = (Fase) session.get(FaseImpl.class, primaryKey);

            if (fase == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchFaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(fase);
        } catch (NoSuchFaseException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Fase removeImpl(Fase fase) throws SystemException {
        fase = toUnwrappedModel(fase);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, fase);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(fase);

        return fase;
    }

    @Override
    public Fase updateImpl(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fase,
        boolean merge) throws SystemException {
        fase = toUnwrappedModel(fase);

        boolean isNew = fase.isNew();

        FaseModelImpl faseModelImpl = (FaseModelImpl) fase;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, fase, merge);

            fase.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !FaseModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((faseModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURACAOID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(faseModelImpl.getOriginalConfiguracaoId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONFIGURACAOID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURACAOID,
                    args);

                args = new Object[] {
                        Long.valueOf(faseModelImpl.getConfiguracaoId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONFIGURACAOID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURACAOID,
                    args);
            }
        }

        EntityCacheUtil.putResult(FaseModelImpl.ENTITY_CACHE_ENABLED,
            FaseImpl.class, fase.getPrimaryKey(), fase);

        return fase;
    }

    protected Fase toUnwrappedModel(Fase fase) {
        if (fase instanceof FaseImpl) {
            return fase;
        }

        FaseImpl faseImpl = new FaseImpl();

        faseImpl.setNew(fase.isNew());
        faseImpl.setPrimaryKey(fase.getPrimaryKey());

        faseImpl.setFaseId(fase.getFaseId());
        faseImpl.setConfiguracaoId(fase.getConfiguracaoId());
        faseImpl.setOrdem(fase.getOrdem());
        faseImpl.setTitulo(fase.getTitulo());

        return faseImpl;
    }

    /**
     * Returns the fase with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the fase
     * @return the fase
     * @throws com.liferay.portal.NoSuchModelException if a fase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Fase findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the fase with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException} if it could not be found.
     *
     * @param faseId the primary key of the fase
     * @return the fase
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a fase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Fase findByPrimaryKey(long faseId)
        throws NoSuchFaseException, SystemException {
        Fase fase = fetchByPrimaryKey(faseId);

        if (fase == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + faseId);
            }

            throw new NoSuchFaseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                faseId);
        }

        return fase;
    }

    /**
     * Returns the fase with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the fase
     * @return the fase, or <code>null</code> if a fase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Fase fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the fase with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param faseId the primary key of the fase
     * @return the fase, or <code>null</code> if a fase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Fase fetchByPrimaryKey(long faseId) throws SystemException {
        Fase fase = (Fase) EntityCacheUtil.getResult(FaseModelImpl.ENTITY_CACHE_ENABLED,
                FaseImpl.class, faseId);

        if (fase == _nullFase) {
            return null;
        }

        if (fase == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                fase = (Fase) session.get(FaseImpl.class, Long.valueOf(faseId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (fase != null) {
                    cacheResult(fase);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(FaseModelImpl.ENTITY_CACHE_ENABLED,
                        FaseImpl.class, faseId, _nullFase);
                }

                closeSession(session);
            }
        }

        return fase;
    }

    /**
     * Returns all the fases where configuracaoId = &#63;.
     *
     * @param configuracaoId the configuracao ID
     * @return the matching fases
     * @throws SystemException if a system exception occurred
     */
    public List<Fase> findByConfiguracaoId(long configuracaoId)
        throws SystemException {
        return findByConfiguracaoId(configuracaoId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the fases where configuracaoId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param configuracaoId the configuracao ID
     * @param start the lower bound of the range of fases
     * @param end the upper bound of the range of fases (not inclusive)
     * @return the range of matching fases
     * @throws SystemException if a system exception occurred
     */
    public List<Fase> findByConfiguracaoId(long configuracaoId, int start,
        int end) throws SystemException {
        return findByConfiguracaoId(configuracaoId, start, end, null);
    }

    /**
     * Returns an ordered range of all the fases where configuracaoId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param configuracaoId the configuracao ID
     * @param start the lower bound of the range of fases
     * @param end the upper bound of the range of fases (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching fases
     * @throws SystemException if a system exception occurred
     */
    public List<Fase> findByConfiguracaoId(long configuracaoId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGURACAOID;
            finderArgs = new Object[] { configuracaoId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONFIGURACAOID;
            finderArgs = new Object[] {
                    configuracaoId,
                    
                    start, end, orderByComparator
                };
        }

        List<Fase> list = (List<Fase>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Fase fase : list) {
                if ((configuracaoId != fase.getConfiguracaoId())) {
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

            query.append(_SQL_SELECT_FASE_WHERE);

            query.append(_FINDER_COLUMN_CONFIGURACAOID_CONFIGURACAOID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(FaseModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(configuracaoId);

                list = (List<Fase>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first fase in the ordered set where configuracaoId = &#63;.
     *
     * @param configuracaoId the configuracao ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching fase
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a matching fase could not be found
     * @throws SystemException if a system exception occurred
     */
    public Fase findByConfiguracaoId_First(long configuracaoId,
        OrderByComparator orderByComparator)
        throws NoSuchFaseException, SystemException {
        Fase fase = fetchByConfiguracaoId_First(configuracaoId,
                orderByComparator);

        if (fase != null) {
            return fase;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("configuracaoId=");
        msg.append(configuracaoId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFaseException(msg.toString());
    }

    /**
     * Returns the first fase in the ordered set where configuracaoId = &#63;.
     *
     * @param configuracaoId the configuracao ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching fase, or <code>null</code> if a matching fase could not be found
     * @throws SystemException if a system exception occurred
     */
    public Fase fetchByConfiguracaoId_First(long configuracaoId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Fase> list = findByConfiguracaoId(configuracaoId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last fase in the ordered set where configuracaoId = &#63;.
     *
     * @param configuracaoId the configuracao ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching fase
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a matching fase could not be found
     * @throws SystemException if a system exception occurred
     */
    public Fase findByConfiguracaoId_Last(long configuracaoId,
        OrderByComparator orderByComparator)
        throws NoSuchFaseException, SystemException {
        Fase fase = fetchByConfiguracaoId_Last(configuracaoId, orderByComparator);

        if (fase != null) {
            return fase;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("configuracaoId=");
        msg.append(configuracaoId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchFaseException(msg.toString());
    }

    /**
     * Returns the last fase in the ordered set where configuracaoId = &#63;.
     *
     * @param configuracaoId the configuracao ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching fase, or <code>null</code> if a matching fase could not be found
     * @throws SystemException if a system exception occurred
     */
    public Fase fetchByConfiguracaoId_Last(long configuracaoId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByConfiguracaoId(configuracaoId);

        List<Fase> list = findByConfiguracaoId(configuracaoId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the fases before and after the current fase in the ordered set where configuracaoId = &#63;.
     *
     * @param faseId the primary key of the current fase
     * @param configuracaoId the configuracao ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next fase
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a fase with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Fase[] findByConfiguracaoId_PrevAndNext(long faseId,
        long configuracaoId, OrderByComparator orderByComparator)
        throws NoSuchFaseException, SystemException {
        Fase fase = findByPrimaryKey(faseId);

        Session session = null;

        try {
            session = openSession();

            Fase[] array = new FaseImpl[3];

            array[0] = getByConfiguracaoId_PrevAndNext(session, fase,
                    configuracaoId, orderByComparator, true);

            array[1] = fase;

            array[2] = getByConfiguracaoId_PrevAndNext(session, fase,
                    configuracaoId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Fase getByConfiguracaoId_PrevAndNext(Session session, Fase fase,
        long configuracaoId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_FASE_WHERE);

        query.append(_FINDER_COLUMN_CONFIGURACAOID_CONFIGURACAOID_2);

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
            query.append(FaseModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(configuracaoId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(fase);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Fase> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the fases.
     *
     * @return the fases
     * @throws SystemException if a system exception occurred
     */
    public List<Fase> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the fases.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of fases
     * @param end the upper bound of the range of fases (not inclusive)
     * @return the range of fases
     * @throws SystemException if a system exception occurred
     */
    public List<Fase> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the fases.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of fases
     * @param end the upper bound of the range of fases (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of fases
     * @throws SystemException if a system exception occurred
     */
    public List<Fase> findAll(int start, int end,
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

        List<Fase> list = (List<Fase>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_FASE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_FASE.concat(FaseModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Fase>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Fase>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the fases where configuracaoId = &#63; from the database.
     *
     * @param configuracaoId the configuracao ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByConfiguracaoId(long configuracaoId)
        throws SystemException {
        for (Fase fase : findByConfiguracaoId(configuracaoId)) {
            remove(fase);
        }
    }

    /**
     * Removes all the fases from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Fase fase : findAll()) {
            remove(fase);
        }
    }

    /**
     * Returns the number of fases where configuracaoId = &#63;.
     *
     * @param configuracaoId the configuracao ID
     * @return the number of matching fases
     * @throws SystemException if a system exception occurred
     */
    public int countByConfiguracaoId(long configuracaoId)
        throws SystemException {
        Object[] finderArgs = new Object[] { configuracaoId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONFIGURACAOID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_FASE_WHERE);

            query.append(_FINDER_COLUMN_CONFIGURACAOID_CONFIGURACAOID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(configuracaoId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONFIGURACAOID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of fases.
     *
     * @return the number of fases
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_FASE);

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
     * Initializes the fase persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Fase>> listenersList = new ArrayList<ModelListener<Fase>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Fase>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(FaseImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
