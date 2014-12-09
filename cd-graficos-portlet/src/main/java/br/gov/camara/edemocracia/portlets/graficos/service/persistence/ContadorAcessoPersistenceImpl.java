package br.gov.camara.edemocracia.portlets.graficos.service.persistence;

import br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException;
import br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso;
import br.gov.camara.edemocracia.portlets.graficos.model.impl.ContadorAcessoImpl;
import br.gov.camara.edemocracia.portlets.graficos.model.impl.ContadorAcessoModelImpl;
import br.gov.camara.edemocracia.portlets.graficos.service.persistence.ContadorAcessoPersistence;

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
 * The persistence implementation for the contador acesso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robson Miranda
 * @see ContadorAcessoPersistence
 * @see ContadorAcessoUtil
 * @generated
 */
public class ContadorAcessoPersistenceImpl extends BasePersistenceImpl<ContadorAcesso>
    implements ContadorAcessoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ContadorAcessoUtil} to access the contador acesso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ContadorAcessoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_D = new FinderPath(ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
            ContadorAcessoModelImpl.FINDER_CACHE_ENABLED,
            ContadorAcessoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByC_D",
            new String[] {
                Long.class.getName(), Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_D = new FinderPath(ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
            ContadorAcessoModelImpl.FINDER_CACHE_ENABLED,
            ContadorAcessoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_D",
            new String[] { Long.class.getName(), Date.class.getName() },
            ContadorAcessoModelImpl.COMPANYID_COLUMN_BITMASK |
            ContadorAcessoModelImpl.DATA_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_D = new FinderPath(ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
            ContadorAcessoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_D",
            new String[] { Long.class.getName(), Date.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
            ContadorAcessoModelImpl.FINDER_CACHE_ENABLED,
            ContadorAcessoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
            ContadorAcessoModelImpl.FINDER_CACHE_ENABLED,
            ContadorAcessoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
            ContadorAcessoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CONTADORACESSO = "SELECT contadorAcesso FROM ContadorAcesso contadorAcesso";
    private static final String _SQL_SELECT_CONTADORACESSO_WHERE = "SELECT contadorAcesso FROM ContadorAcesso contadorAcesso WHERE ";
    private static final String _SQL_COUNT_CONTADORACESSO = "SELECT COUNT(contadorAcesso) FROM ContadorAcesso contadorAcesso";
    private static final String _SQL_COUNT_CONTADORACESSO_WHERE = "SELECT COUNT(contadorAcesso) FROM ContadorAcesso contadorAcesso WHERE ";
    private static final String _FINDER_COLUMN_C_D_COMPANYID_2 = "contadorAcesso.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_D_DATA_1 = "contadorAcesso.data IS NULL";
    private static final String _FINDER_COLUMN_C_D_DATA_2 = "contadorAcesso.data = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "contadorAcesso.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContadorAcesso exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContadorAcesso exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ContadorAcessoPersistenceImpl.class);
    private static ContadorAcesso _nullContadorAcesso = new ContadorAcessoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ContadorAcesso> toCacheModel() {
                return _nullContadorAcessoCacheModel;
            }
        };

    private static CacheModel<ContadorAcesso> _nullContadorAcessoCacheModel = new CacheModel<ContadorAcesso>() {
            public ContadorAcesso toEntityModel() {
                return _nullContadorAcesso;
            }
        };

    @BeanReference(type = ContadorAcessoPersistence.class)
    protected ContadorAcessoPersistence contadorAcessoPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the contador acesso in the entity cache if it is enabled.
     *
     * @param contadorAcesso the contador acesso
     */
    public void cacheResult(ContadorAcesso contadorAcesso) {
        EntityCacheUtil.putResult(ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
            ContadorAcessoImpl.class, contadorAcesso.getPrimaryKey(),
            contadorAcesso);

        contadorAcesso.resetOriginalValues();
    }

    /**
     * Caches the contador acessos in the entity cache if it is enabled.
     *
     * @param contadorAcessos the contador acessos
     */
    public void cacheResult(List<ContadorAcesso> contadorAcessos) {
        for (ContadorAcesso contadorAcesso : contadorAcessos) {
            if (EntityCacheUtil.getResult(
                        ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
                        ContadorAcessoImpl.class, contadorAcesso.getPrimaryKey()) == null) {
                cacheResult(contadorAcesso);
            } else {
                contadorAcesso.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all contador acessos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ContadorAcessoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ContadorAcessoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the contador acesso.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ContadorAcesso contadorAcesso) {
        EntityCacheUtil.removeResult(ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
            ContadorAcessoImpl.class, contadorAcesso.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ContadorAcesso> contadorAcessos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ContadorAcesso contadorAcesso : contadorAcessos) {
            EntityCacheUtil.removeResult(ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
                ContadorAcessoImpl.class, contadorAcesso.getPrimaryKey());
        }
    }

    /**
     * Creates a new contador acesso with the primary key. Does not add the contador acesso to the database.
     *
     * @param contadorId the primary key for the new contador acesso
     * @return the new contador acesso
     */
    public ContadorAcesso create(long contadorId) {
        ContadorAcesso contadorAcesso = new ContadorAcessoImpl();

        contadorAcesso.setNew(true);
        contadorAcesso.setPrimaryKey(contadorId);

        return contadorAcesso;
    }

    /**
     * Removes the contador acesso with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param contadorId the primary key of the contador acesso
     * @return the contador acesso that was removed
     * @throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException if a contador acesso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ContadorAcesso remove(long contadorId)
        throws NoSuchContadorAcessoException, SystemException {
        return remove(Long.valueOf(contadorId));
    }

    /**
     * Removes the contador acesso with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the contador acesso
     * @return the contador acesso that was removed
     * @throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException if a contador acesso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContadorAcesso remove(Serializable primaryKey)
        throws NoSuchContadorAcessoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ContadorAcesso contadorAcesso = (ContadorAcesso) session.get(ContadorAcessoImpl.class,
                    primaryKey);

            if (contadorAcesso == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchContadorAcessoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(contadorAcesso);
        } catch (NoSuchContadorAcessoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ContadorAcesso removeImpl(ContadorAcesso contadorAcesso)
        throws SystemException {
        contadorAcesso = toUnwrappedModel(contadorAcesso);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, contadorAcesso);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(contadorAcesso);

        return contadorAcesso;
    }

    @Override
    public ContadorAcesso updateImpl(
        br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso contadorAcesso,
        boolean merge) throws SystemException {
        contadorAcesso = toUnwrappedModel(contadorAcesso);

        boolean isNew = contadorAcesso.isNew();

        ContadorAcessoModelImpl contadorAcessoModelImpl = (ContadorAcessoModelImpl) contadorAcesso;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, contadorAcesso, merge);

            contadorAcesso.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ContadorAcessoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((contadorAcessoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_D.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(contadorAcessoModelImpl.getOriginalCompanyId()),
                        
                        contadorAcessoModelImpl.getOriginalData()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_D, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_D,
                    args);

                args = new Object[] {
                        Long.valueOf(contadorAcessoModelImpl.getCompanyId()),
                        
                        contadorAcessoModelImpl.getData()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_D, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_D,
                    args);
            }
        }

        EntityCacheUtil.putResult(ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
            ContadorAcessoImpl.class, contadorAcesso.getPrimaryKey(),
            contadorAcesso);

        return contadorAcesso;
    }

    protected ContadorAcesso toUnwrappedModel(ContadorAcesso contadorAcesso) {
        if (contadorAcesso instanceof ContadorAcessoImpl) {
            return contadorAcesso;
        }

        ContadorAcessoImpl contadorAcessoImpl = new ContadorAcessoImpl();

        contadorAcessoImpl.setNew(contadorAcesso.isNew());
        contadorAcessoImpl.setPrimaryKey(contadorAcesso.getPrimaryKey());

        contadorAcessoImpl.setContadorId(contadorAcesso.getContadorId());
        contadorAcessoImpl.setCompanyId(contadorAcesso.getCompanyId());
        contadorAcessoImpl.setData(contadorAcesso.getData());
        contadorAcessoImpl.setDataAtualizacao(contadorAcesso.getDataAtualizacao());
        contadorAcessoImpl.setCache(contadorAcesso.getCache());

        return contadorAcessoImpl;
    }

    /**
     * Returns the contador acesso with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the contador acesso
     * @return the contador acesso
     * @throws com.liferay.portal.NoSuchModelException if a contador acesso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContadorAcesso findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the contador acesso with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException} if it could not be found.
     *
     * @param contadorId the primary key of the contador acesso
     * @return the contador acesso
     * @throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException if a contador acesso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ContadorAcesso findByPrimaryKey(long contadorId)
        throws NoSuchContadorAcessoException, SystemException {
        ContadorAcesso contadorAcesso = fetchByPrimaryKey(contadorId);

        if (contadorAcesso == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + contadorId);
            }

            throw new NoSuchContadorAcessoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                contadorId);
        }

        return contadorAcesso;
    }

    /**
     * Returns the contador acesso with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the contador acesso
     * @return the contador acesso, or <code>null</code> if a contador acesso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ContadorAcesso fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the contador acesso with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param contadorId the primary key of the contador acesso
     * @return the contador acesso, or <code>null</code> if a contador acesso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ContadorAcesso fetchByPrimaryKey(long contadorId)
        throws SystemException {
        ContadorAcesso contadorAcesso = (ContadorAcesso) EntityCacheUtil.getResult(ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
                ContadorAcessoImpl.class, contadorId);

        if (contadorAcesso == _nullContadorAcesso) {
            return null;
        }

        if (contadorAcesso == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                contadorAcesso = (ContadorAcesso) session.get(ContadorAcessoImpl.class,
                        Long.valueOf(contadorId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (contadorAcesso != null) {
                    cacheResult(contadorAcesso);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ContadorAcessoModelImpl.ENTITY_CACHE_ENABLED,
                        ContadorAcessoImpl.class, contadorId,
                        _nullContadorAcesso);
                }

                closeSession(session);
            }
        }

        return contadorAcesso;
    }

    /**
     * Returns all the contador acessos where companyId = &#63; and data = &#63;.
     *
     * @param companyId the company ID
     * @param data the data
     * @return the matching contador acessos
     * @throws SystemException if a system exception occurred
     */
    public List<ContadorAcesso> findByC_D(long companyId, Date data)
        throws SystemException {
        return findByC_D(companyId, data, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the contador acessos where companyId = &#63; and data = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param data the data
     * @param start the lower bound of the range of contador acessos
     * @param end the upper bound of the range of contador acessos (not inclusive)
     * @return the range of matching contador acessos
     * @throws SystemException if a system exception occurred
     */
    public List<ContadorAcesso> findByC_D(long companyId, Date data, int start,
        int end) throws SystemException {
        return findByC_D(companyId, data, start, end, null);
    }

    /**
     * Returns an ordered range of all the contador acessos where companyId = &#63; and data = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param data the data
     * @param start the lower bound of the range of contador acessos
     * @param end the upper bound of the range of contador acessos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching contador acessos
     * @throws SystemException if a system exception occurred
     */
    public List<ContadorAcesso> findByC_D(long companyId, Date data, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_D;
            finderArgs = new Object[] { companyId, data };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_D;
            finderArgs = new Object[] {
                    companyId, data,
                    
                    start, end, orderByComparator
                };
        }

        List<ContadorAcesso> list = (List<ContadorAcesso>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ContadorAcesso contadorAcesso : list) {
                if ((companyId != contadorAcesso.getCompanyId()) ||
                        !Validator.equals(data, contadorAcesso.getData())) {
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
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_CONTADORACESSO_WHERE);

            query.append(_FINDER_COLUMN_C_D_COMPANYID_2);

            if (data == null) {
                query.append(_FINDER_COLUMN_C_D_DATA_1);
            } else {
                query.append(_FINDER_COLUMN_C_D_DATA_2);
            }

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

                qPos.add(companyId);

                if (data != null) {
                    qPos.add(CalendarUtil.getTimestamp(data));
                }

                list = (List<ContadorAcesso>) QueryUtil.list(q, getDialect(),
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
     * Returns the first contador acesso in the ordered set where companyId = &#63; and data = &#63;.
     *
     * @param companyId the company ID
     * @param data the data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching contador acesso
     * @throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException if a matching contador acesso could not be found
     * @throws SystemException if a system exception occurred
     */
    public ContadorAcesso findByC_D_First(long companyId, Date data,
        OrderByComparator orderByComparator)
        throws NoSuchContadorAcessoException, SystemException {
        ContadorAcesso contadorAcesso = fetchByC_D_First(companyId, data,
                orderByComparator);

        if (contadorAcesso != null) {
            return contadorAcesso;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", data=");
        msg.append(data);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContadorAcessoException(msg.toString());
    }

    /**
     * Returns the first contador acesso in the ordered set where companyId = &#63; and data = &#63;.
     *
     * @param companyId the company ID
     * @param data the data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching contador acesso, or <code>null</code> if a matching contador acesso could not be found
     * @throws SystemException if a system exception occurred
     */
    public ContadorAcesso fetchByC_D_First(long companyId, Date data,
        OrderByComparator orderByComparator) throws SystemException {
        List<ContadorAcesso> list = findByC_D(companyId, data, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last contador acesso in the ordered set where companyId = &#63; and data = &#63;.
     *
     * @param companyId the company ID
     * @param data the data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching contador acesso
     * @throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException if a matching contador acesso could not be found
     * @throws SystemException if a system exception occurred
     */
    public ContadorAcesso findByC_D_Last(long companyId, Date data,
        OrderByComparator orderByComparator)
        throws NoSuchContadorAcessoException, SystemException {
        ContadorAcesso contadorAcesso = fetchByC_D_Last(companyId, data,
                orderByComparator);

        if (contadorAcesso != null) {
            return contadorAcesso;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", data=");
        msg.append(data);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchContadorAcessoException(msg.toString());
    }

    /**
     * Returns the last contador acesso in the ordered set where companyId = &#63; and data = &#63;.
     *
     * @param companyId the company ID
     * @param data the data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching contador acesso, or <code>null</code> if a matching contador acesso could not be found
     * @throws SystemException if a system exception occurred
     */
    public ContadorAcesso fetchByC_D_Last(long companyId, Date data,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_D(companyId, data);

        List<ContadorAcesso> list = findByC_D(companyId, data, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the contador acessos before and after the current contador acesso in the ordered set where companyId = &#63; and data = &#63;.
     *
     * @param contadorId the primary key of the current contador acesso
     * @param companyId the company ID
     * @param data the data
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next contador acesso
     * @throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException if a contador acesso with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ContadorAcesso[] findByC_D_PrevAndNext(long contadorId,
        long companyId, Date data, OrderByComparator orderByComparator)
        throws NoSuchContadorAcessoException, SystemException {
        ContadorAcesso contadorAcesso = findByPrimaryKey(contadorId);

        Session session = null;

        try {
            session = openSession();

            ContadorAcesso[] array = new ContadorAcessoImpl[3];

            array[0] = getByC_D_PrevAndNext(session, contadorAcesso, companyId,
                    data, orderByComparator, true);

            array[1] = contadorAcesso;

            array[2] = getByC_D_PrevAndNext(session, contadorAcesso, companyId,
                    data, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ContadorAcesso getByC_D_PrevAndNext(Session session,
        ContadorAcesso contadorAcesso, long companyId, Date data,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CONTADORACESSO_WHERE);

        query.append(_FINDER_COLUMN_C_D_COMPANYID_2);

        if (data == null) {
            query.append(_FINDER_COLUMN_C_D_DATA_1);
        } else {
            query.append(_FINDER_COLUMN_C_D_DATA_2);
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

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (data != null) {
            qPos.add(CalendarUtil.getTimestamp(data));
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(contadorAcesso);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ContadorAcesso> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the contador acessos.
     *
     * @return the contador acessos
     * @throws SystemException if a system exception occurred
     */
    public List<ContadorAcesso> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the contador acessos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of contador acessos
     * @param end the upper bound of the range of contador acessos (not inclusive)
     * @return the range of contador acessos
     * @throws SystemException if a system exception occurred
     */
    public List<ContadorAcesso> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the contador acessos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of contador acessos
     * @param end the upper bound of the range of contador acessos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of contador acessos
     * @throws SystemException if a system exception occurred
     */
    public List<ContadorAcesso> findAll(int start, int end,
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

        List<ContadorAcesso> list = (List<ContadorAcesso>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CONTADORACESSO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CONTADORACESSO;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<ContadorAcesso>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ContadorAcesso>) QueryUtil.list(q,
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
     * Removes all the contador acessos where companyId = &#63; and data = &#63; from the database.
     *
     * @param companyId the company ID
     * @param data the data
     * @throws SystemException if a system exception occurred
     */
    public void removeByC_D(long companyId, Date data)
        throws SystemException {
        for (ContadorAcesso contadorAcesso : findByC_D(companyId, data)) {
            remove(contadorAcesso);
        }
    }

    /**
     * Removes all the contador acessos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (ContadorAcesso contadorAcesso : findAll()) {
            remove(contadorAcesso);
        }
    }

    /**
     * Returns the number of contador acessos where companyId = &#63; and data = &#63;.
     *
     * @param companyId the company ID
     * @param data the data
     * @return the number of matching contador acessos
     * @throws SystemException if a system exception occurred
     */
    public int countByC_D(long companyId, Date data) throws SystemException {
        Object[] finderArgs = new Object[] { companyId, data };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_D,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_CONTADORACESSO_WHERE);

            query.append(_FINDER_COLUMN_C_D_COMPANYID_2);

            if (data == null) {
                query.append(_FINDER_COLUMN_C_D_DATA_1);
            } else {
                query.append(_FINDER_COLUMN_C_D_DATA_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (data != null) {
                    qPos.add(CalendarUtil.getTimestamp(data));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_D, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of contador acessos.
     *
     * @return the number of contador acessos
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CONTADORACESSO);

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
     * Initializes the contador acesso persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ContadorAcesso>> listenersList = new ArrayList<ModelListener<ContadorAcesso>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ContadorAcesso>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ContadorAcessoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
