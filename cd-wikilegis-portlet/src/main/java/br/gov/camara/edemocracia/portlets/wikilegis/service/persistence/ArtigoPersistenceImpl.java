package br.gov.camara.edemocracia.portlets.wikilegis.service.persistence;

import br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException;
import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;
import br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ArtigoImpl;
import br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ArtigoModelImpl;
import br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.ArtigoPersistence;
import br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.ContribuicaoPersistence;
import br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.EstruturaPersistence;

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
 * The persistence implementation for the artigo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see ArtigoPersistence
 * @see ArtigoUtil
 * @generated
 */
public class ArtigoPersistenceImpl extends BasePersistenceImpl<Artigo>
    implements ArtigoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ArtigoUtil} to access the artigo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ArtigoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_E = new FinderPath(ArtigoModelImpl.ENTITY_CACHE_ENABLED,
            ArtigoModelImpl.FINDER_CACHE_ENABLED, ArtigoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_E",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E = new FinderPath(ArtigoModelImpl.ENTITY_CACHE_ENABLED,
            ArtigoModelImpl.FINDER_CACHE_ENABLED, ArtigoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_E",
            new String[] { Long.class.getName(), Long.class.getName() },
            ArtigoModelImpl.GROUPID_COLUMN_BITMASK |
            ArtigoModelImpl.ESTRUTURAID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_G_E = new FinderPath(ArtigoModelImpl.ENTITY_CACHE_ENABLED,
            ArtigoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_E",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ArtigoModelImpl.ENTITY_CACHE_ENABLED,
            ArtigoModelImpl.FINDER_CACHE_ENABLED, ArtigoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ArtigoModelImpl.ENTITY_CACHE_ENABLED,
            ArtigoModelImpl.FINDER_CACHE_ENABLED, ArtigoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ArtigoModelImpl.ENTITY_CACHE_ENABLED,
            ArtigoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_GET_CONTRIBUICAOS = new FinderPath(br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoModelImpl.FINDER_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoImpl.class,
            br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.ContribuicaoPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getContribuicaos",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_CONTRIBUICAOS.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_CONTRIBUICAOS_SIZE = new FinderPath(br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoModelImpl.FINDER_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoImpl.class,
            br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.ContribuicaoPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getContribuicaosSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_CONTRIBUICAOS_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_CONTRIBUICAO = new FinderPath(br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoModelImpl.ENTITY_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoModelImpl.FINDER_CACHE_ENABLED,
            br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoImpl.class,
            br.gov.camara.edemocracia.portlets.wikilegis.service.persistence.ContribuicaoPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "containsContribuicao",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _SQL_SELECT_ARTIGO = "SELECT artigo FROM Artigo artigo";
    private static final String _SQL_SELECT_ARTIGO_WHERE = "SELECT artigo FROM Artigo artigo WHERE ";
    private static final String _SQL_COUNT_ARTIGO = "SELECT COUNT(artigo) FROM Artigo artigo";
    private static final String _SQL_COUNT_ARTIGO_WHERE = "SELECT COUNT(artigo) FROM Artigo artigo WHERE ";
    private static final String _SQL_GETCONTRIBUICAOS = "SELECT {CDWL_Contribuicao.*} FROM CDWL_Contribuicao INNER JOIN CDWL_Artigo ON (CDWL_Artigo.artigoId = CDWL_Contribuicao.artigoId) WHERE (CDWL_Artigo.artigoId = ?)";
    private static final String _SQL_GETCONTRIBUICAOSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM CDWL_Contribuicao WHERE artigoId = ?";
    private static final String _SQL_CONTAINSCONTRIBUICAO = "SELECT COUNT(*) AS COUNT_VALUE FROM CDWL_Contribuicao WHERE artigoId = ? AND contribuicaoId = ?";
    private static final String _FINDER_COLUMN_G_E_GROUPID_2 = "artigo.groupId = ? AND ";
    private static final String _FINDER_COLUMN_G_E_ESTRUTURAID_2 = "artigo.estruturaId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "artigo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Artigo exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Artigo exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ArtigoPersistenceImpl.class);
    private static Artigo _nullArtigo = new ArtigoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Artigo> toCacheModel() {
                return _nullArtigoCacheModel;
            }
        };

    private static CacheModel<Artigo> _nullArtigoCacheModel = new CacheModel<Artigo>() {
            public Artigo toEntityModel() {
                return _nullArtigo;
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
    protected ContainsContribuicao containsContribuicao;

    /**
     * Caches the artigo in the entity cache if it is enabled.
     *
     * @param artigo the artigo
     */
    public void cacheResult(Artigo artigo) {
        EntityCacheUtil.putResult(ArtigoModelImpl.ENTITY_CACHE_ENABLED,
            ArtigoImpl.class, artigo.getPrimaryKey(), artigo);

        artigo.resetOriginalValues();
    }

    /**
     * Caches the artigos in the entity cache if it is enabled.
     *
     * @param artigos the artigos
     */
    public void cacheResult(List<Artigo> artigos) {
        for (Artigo artigo : artigos) {
            if (EntityCacheUtil.getResult(
                        ArtigoModelImpl.ENTITY_CACHE_ENABLED, ArtigoImpl.class,
                        artigo.getPrimaryKey()) == null) {
                cacheResult(artigo);
            } else {
                artigo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all artigos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ArtigoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ArtigoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the artigo.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Artigo artigo) {
        EntityCacheUtil.removeResult(ArtigoModelImpl.ENTITY_CACHE_ENABLED,
            ArtigoImpl.class, artigo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Artigo> artigos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Artigo artigo : artigos) {
            EntityCacheUtil.removeResult(ArtigoModelImpl.ENTITY_CACHE_ENABLED,
                ArtigoImpl.class, artigo.getPrimaryKey());
        }
    }

    /**
     * Creates a new artigo with the primary key. Does not add the artigo to the database.
     *
     * @param artigoId the primary key for the new artigo
     * @return the new artigo
     */
    public Artigo create(long artigoId) {
        Artigo artigo = new ArtigoImpl();

        artigo.setNew(true);
        artigo.setPrimaryKey(artigoId);

        return artigo;
    }

    /**
     * Removes the artigo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param artigoId the primary key of the artigo
     * @return the artigo that was removed
     * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a artigo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Artigo remove(long artigoId)
        throws NoSuchArtigoException, SystemException {
        return remove(Long.valueOf(artigoId));
    }

    /**
     * Removes the artigo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the artigo
     * @return the artigo that was removed
     * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a artigo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Artigo remove(Serializable primaryKey)
        throws NoSuchArtigoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Artigo artigo = (Artigo) session.get(ArtigoImpl.class, primaryKey);

            if (artigo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchArtigoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(artigo);
        } catch (NoSuchArtigoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Artigo removeImpl(Artigo artigo) throws SystemException {
        artigo = toUnwrappedModel(artigo);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, artigo);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(artigo);

        return artigo;
    }

    @Override
    public Artigo updateImpl(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo,
        boolean merge) throws SystemException {
        artigo = toUnwrappedModel(artigo);

        boolean isNew = artigo.isNew();

        ArtigoModelImpl artigoModelImpl = (ArtigoModelImpl) artigo;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, artigo, merge);

            artigo.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ArtigoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((artigoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(artigoModelImpl.getOriginalGroupId()),
                        Long.valueOf(artigoModelImpl.getOriginalEstruturaId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_E, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E,
                    args);

                args = new Object[] {
                        Long.valueOf(artigoModelImpl.getGroupId()),
                        Long.valueOf(artigoModelImpl.getEstruturaId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_E, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E,
                    args);
            }
        }

        EntityCacheUtil.putResult(ArtigoModelImpl.ENTITY_CACHE_ENABLED,
            ArtigoImpl.class, artigo.getPrimaryKey(), artigo);

        return artigo;
    }

    protected Artigo toUnwrappedModel(Artigo artigo) {
        if (artigo instanceof ArtigoImpl) {
            return artigo;
        }

        ArtigoImpl artigoImpl = new ArtigoImpl();

        artigoImpl.setNew(artigo.isNew());
        artigoImpl.setPrimaryKey(artigo.getPrimaryKey());

        artigoImpl.setArtigoId(artigo.getArtigoId());
        artigoImpl.setCompanyId(artigo.getCompanyId());
        artigoImpl.setGroupId(artigo.getGroupId());
        artigoImpl.setEstruturaId(artigo.getEstruturaId());
        artigoImpl.setOrdem(artigo.getOrdem());
        artigoImpl.setTexto(artigo.getTexto());
        artigoImpl.setLegislacaoVigente(artigo.getLegislacaoVigente());

        return artigoImpl;
    }

    /**
     * Returns the artigo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the artigo
     * @return the artigo
     * @throws com.liferay.portal.NoSuchModelException if a artigo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Artigo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the artigo with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException} if it could not be found.
     *
     * @param artigoId the primary key of the artigo
     * @return the artigo
     * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a artigo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Artigo findByPrimaryKey(long artigoId)
        throws NoSuchArtigoException, SystemException {
        Artigo artigo = fetchByPrimaryKey(artigoId);

        if (artigo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + artigoId);
            }

            throw new NoSuchArtigoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                artigoId);
        }

        return artigo;
    }

    /**
     * Returns the artigo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the artigo
     * @return the artigo, or <code>null</code> if a artigo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Artigo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the artigo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param artigoId the primary key of the artigo
     * @return the artigo, or <code>null</code> if a artigo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Artigo fetchByPrimaryKey(long artigoId) throws SystemException {
        Artigo artigo = (Artigo) EntityCacheUtil.getResult(ArtigoModelImpl.ENTITY_CACHE_ENABLED,
                ArtigoImpl.class, artigoId);

        if (artigo == _nullArtigo) {
            return null;
        }

        if (artigo == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                artigo = (Artigo) session.get(ArtigoImpl.class,
                        Long.valueOf(artigoId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (artigo != null) {
                    cacheResult(artigo);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ArtigoModelImpl.ENTITY_CACHE_ENABLED,
                        ArtigoImpl.class, artigoId, _nullArtigo);
                }

                closeSession(session);
            }
        }

        return artigo;
    }

    /**
     * Returns all the artigos where groupId = &#63; and estruturaId = &#63;.
     *
     * @param groupId the group ID
     * @param estruturaId the estrutura ID
     * @return the matching artigos
     * @throws SystemException if a system exception occurred
     */
    public List<Artigo> findByG_E(long groupId, long estruturaId)
        throws SystemException {
        return findByG_E(groupId, estruturaId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the artigos where groupId = &#63; and estruturaId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param estruturaId the estrutura ID
     * @param start the lower bound of the range of artigos
     * @param end the upper bound of the range of artigos (not inclusive)
     * @return the range of matching artigos
     * @throws SystemException if a system exception occurred
     */
    public List<Artigo> findByG_E(long groupId, long estruturaId, int start,
        int end) throws SystemException {
        return findByG_E(groupId, estruturaId, start, end, null);
    }

    /**
     * Returns an ordered range of all the artigos where groupId = &#63; and estruturaId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param estruturaId the estrutura ID
     * @param start the lower bound of the range of artigos
     * @param end the upper bound of the range of artigos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching artigos
     * @throws SystemException if a system exception occurred
     */
    public List<Artigo> findByG_E(long groupId, long estruturaId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_E;
            finderArgs = new Object[] { groupId, estruturaId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_E;
            finderArgs = new Object[] {
                    groupId, estruturaId,
                    
                    start, end, orderByComparator
                };
        }

        List<Artigo> list = (List<Artigo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Artigo artigo : list) {
                if ((groupId != artigo.getGroupId()) ||
                        (estruturaId != artigo.getEstruturaId())) {
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

            query.append(_SQL_SELECT_ARTIGO_WHERE);

            query.append(_FINDER_COLUMN_G_E_GROUPID_2);

            query.append(_FINDER_COLUMN_G_E_ESTRUTURAID_2);

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

                qPos.add(groupId);

                qPos.add(estruturaId);

                list = (List<Artigo>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first artigo in the ordered set where groupId = &#63; and estruturaId = &#63;.
     *
     * @param groupId the group ID
     * @param estruturaId the estrutura ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching artigo
     * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a matching artigo could not be found
     * @throws SystemException if a system exception occurred
     */
    public Artigo findByG_E_First(long groupId, long estruturaId,
        OrderByComparator orderByComparator)
        throws NoSuchArtigoException, SystemException {
        Artigo artigo = fetchByG_E_First(groupId, estruturaId, orderByComparator);

        if (artigo != null) {
            return artigo;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", estruturaId=");
        msg.append(estruturaId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchArtigoException(msg.toString());
    }

    /**
     * Returns the first artigo in the ordered set where groupId = &#63; and estruturaId = &#63;.
     *
     * @param groupId the group ID
     * @param estruturaId the estrutura ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching artigo, or <code>null</code> if a matching artigo could not be found
     * @throws SystemException if a system exception occurred
     */
    public Artigo fetchByG_E_First(long groupId, long estruturaId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Artigo> list = findByG_E(groupId, estruturaId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last artigo in the ordered set where groupId = &#63; and estruturaId = &#63;.
     *
     * @param groupId the group ID
     * @param estruturaId the estrutura ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching artigo
     * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a matching artigo could not be found
     * @throws SystemException if a system exception occurred
     */
    public Artigo findByG_E_Last(long groupId, long estruturaId,
        OrderByComparator orderByComparator)
        throws NoSuchArtigoException, SystemException {
        Artigo artigo = fetchByG_E_Last(groupId, estruturaId, orderByComparator);

        if (artigo != null) {
            return artigo;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", estruturaId=");
        msg.append(estruturaId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchArtigoException(msg.toString());
    }

    /**
     * Returns the last artigo in the ordered set where groupId = &#63; and estruturaId = &#63;.
     *
     * @param groupId the group ID
     * @param estruturaId the estrutura ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching artigo, or <code>null</code> if a matching artigo could not be found
     * @throws SystemException if a system exception occurred
     */
    public Artigo fetchByG_E_Last(long groupId, long estruturaId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByG_E(groupId, estruturaId);

        List<Artigo> list = findByG_E(groupId, estruturaId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the artigos before and after the current artigo in the ordered set where groupId = &#63; and estruturaId = &#63;.
     *
     * @param artigoId the primary key of the current artigo
     * @param groupId the group ID
     * @param estruturaId the estrutura ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next artigo
     * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a artigo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Artigo[] findByG_E_PrevAndNext(long artigoId, long groupId,
        long estruturaId, OrderByComparator orderByComparator)
        throws NoSuchArtigoException, SystemException {
        Artigo artigo = findByPrimaryKey(artigoId);

        Session session = null;

        try {
            session = openSession();

            Artigo[] array = new ArtigoImpl[3];

            array[0] = getByG_E_PrevAndNext(session, artigo, groupId,
                    estruturaId, orderByComparator, true);

            array[1] = artigo;

            array[2] = getByG_E_PrevAndNext(session, artigo, groupId,
                    estruturaId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Artigo getByG_E_PrevAndNext(Session session, Artigo artigo,
        long groupId, long estruturaId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ARTIGO_WHERE);

        query.append(_FINDER_COLUMN_G_E_GROUPID_2);

        query.append(_FINDER_COLUMN_G_E_ESTRUTURAID_2);

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

        qPos.add(groupId);

        qPos.add(estruturaId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(artigo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Artigo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the artigos.
     *
     * @return the artigos
     * @throws SystemException if a system exception occurred
     */
    public List<Artigo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the artigos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of artigos
     * @param end the upper bound of the range of artigos (not inclusive)
     * @return the range of artigos
     * @throws SystemException if a system exception occurred
     */
    public List<Artigo> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the artigos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of artigos
     * @param end the upper bound of the range of artigos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of artigos
     * @throws SystemException if a system exception occurred
     */
    public List<Artigo> findAll(int start, int end,
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

        List<Artigo> list = (List<Artigo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ARTIGO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ARTIGO;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Artigo>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Artigo>) QueryUtil.list(q, getDialect(),
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
     * Removes all the artigos where groupId = &#63; and estruturaId = &#63; from the database.
     *
     * @param groupId the group ID
     * @param estruturaId the estrutura ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByG_E(long groupId, long estruturaId)
        throws SystemException {
        for (Artigo artigo : findByG_E(groupId, estruturaId)) {
            remove(artigo);
        }
    }

    /**
     * Removes all the artigos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Artigo artigo : findAll()) {
            remove(artigo);
        }
    }

    /**
     * Returns the number of artigos where groupId = &#63; and estruturaId = &#63;.
     *
     * @param groupId the group ID
     * @param estruturaId the estrutura ID
     * @return the number of matching artigos
     * @throws SystemException if a system exception occurred
     */
    public int countByG_E(long groupId, long estruturaId)
        throws SystemException {
        Object[] finderArgs = new Object[] { groupId, estruturaId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_E,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_ARTIGO_WHERE);

            query.append(_FINDER_COLUMN_G_E_GROUPID_2);

            query.append(_FINDER_COLUMN_G_E_ESTRUTURAID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(estruturaId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_E, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of artigos.
     *
     * @return the number of artigos
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_ARTIGO);

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
     * Returns all the contribuicaos associated with the artigo.
     *
     * @param pk the primary key of the artigo
     * @return the contribuicaos associated with the artigo
     * @throws SystemException if a system exception occurred
     */
    public List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> getContribuicaos(
        long pk) throws SystemException {
        return getContribuicaos(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the contribuicaos associated with the artigo.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the artigo
     * @param start the lower bound of the range of artigos
     * @param end the upper bound of the range of artigos (not inclusive)
     * @return the range of contribuicaos associated with the artigo
     * @throws SystemException if a system exception occurred
     */
    public List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> getContribuicaos(
        long pk, int start, int end) throws SystemException {
        return getContribuicaos(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the contribuicaos associated with the artigo.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param pk the primary key of the artigo
     * @param start the lower bound of the range of artigos
     * @param end the upper bound of the range of artigos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of contribuicaos associated with the artigo
     * @throws SystemException if a system exception occurred
     */
    public List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> getContribuicaos(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> list =
            (List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao>) FinderCacheUtil.getResult(FINDER_PATH_GET_CONTRIBUICAOS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETCONTRIBUICAOS.concat(ORDER_BY_CLAUSE)
                                               .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETCONTRIBUICAOS;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("CDWL_Contribuicao",
                    br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_CONTRIBUICAOS,
                        finderArgs);
                } else {
                    contribuicaoPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_CONTRIBUICAOS,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of contribuicaos associated with the artigo.
     *
     * @param pk the primary key of the artigo
     * @return the number of contribuicaos associated with the artigo
     * @throws SystemException if a system exception occurred
     */
    public int getContribuicaosSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_CONTRIBUICAOS_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETCONTRIBUICAOSSIZE);

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

                FinderCacheUtil.putResult(FINDER_PATH_GET_CONTRIBUICAOS_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the contribuicao is associated with the artigo.
     *
     * @param pk the primary key of the artigo
     * @param contribuicaoPK the primary key of the contribuicao
     * @return <code>true</code> if the contribuicao is associated with the artigo; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsContribuicao(long pk, long contribuicaoPK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, contribuicaoPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_CONTRIBUICAO,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsContribuicao.contains(pk,
                            contribuicaoPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_CONTRIBUICAO,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the artigo has any contribuicaos associated with it.
     *
     * @param pk the primary key of the artigo to check for associations with contribuicaos
     * @return <code>true</code> if the artigo has any contribuicaos associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsContribuicaos(long pk) throws SystemException {
        if (getContribuicaosSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Initializes the artigo persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Artigo>> listenersList = new ArrayList<ModelListener<Artigo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Artigo>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        containsContribuicao = new ContainsContribuicao();
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ArtigoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    protected class ContainsContribuicao {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsContribuicao() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSCONTRIBUICAO,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long artigoId, long contribuicaoId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(artigoId), new Long(contribuicaoId)
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
