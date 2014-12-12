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
package br.gov.camara.edemocracia.portlets.priorizacao.service.persistence;

import br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;
import br.gov.camara.edemocracia.portlets.priorizacao.model.impl.EixoImpl;
import br.gov.camara.edemocracia.portlets.priorizacao.model.impl.EixoModelImpl;
import br.gov.camara.edemocracia.portlets.priorizacao.service.persistence.ConfiguracaoPersistence;
import br.gov.camara.edemocracia.portlets.priorizacao.service.persistence.EixoPersistence;
import br.gov.camara.edemocracia.portlets.priorizacao.service.persistence.PropostaPersistence;
import br.gov.camara.edemocracia.portlets.priorizacao.service.persistence.VotoPersistence;

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
 * The persistence implementation for the eixo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see EixoPersistence
 * @see EixoUtil
 * @generated
 */
public class EixoPersistenceImpl extends BasePersistenceImpl<Eixo>
    implements EixoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link EixoUtil} to access the eixo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = EixoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G = new FinderPath(EixoModelImpl.ENTITY_CACHE_ENABLED,
            EixoModelImpl.FINDER_CACHE_ENABLED, EixoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G = new FinderPath(EixoModelImpl.ENTITY_CACHE_ENABLED,
            EixoModelImpl.FINDER_CACHE_ENABLED, EixoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG",
            new String[] { Long.class.getName() },
            EixoModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_G = new FinderPath(EixoModelImpl.ENTITY_CACHE_ENABLED,
            EixoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EixoModelImpl.ENTITY_CACHE_ENABLED,
            EixoModelImpl.FINDER_CACHE_ENABLED, EixoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EixoModelImpl.ENTITY_CACHE_ENABLED,
            EixoModelImpl.FINDER_CACHE_ENABLED, EixoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EixoModelImpl.ENTITY_CACHE_ENABLED,
            EixoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_EIXO = "SELECT eixo FROM Eixo eixo";
    private static final String _SQL_SELECT_EIXO_WHERE = "SELECT eixo FROM Eixo eixo WHERE ";
    private static final String _SQL_COUNT_EIXO = "SELECT COUNT(eixo) FROM Eixo eixo";
    private static final String _SQL_COUNT_EIXO_WHERE = "SELECT COUNT(eixo) FROM Eixo eixo WHERE ";
    private static final String _FINDER_COLUMN_G_GROUPID_2 = "eixo.groupId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "eixo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Eixo exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Eixo exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(EixoPersistenceImpl.class);
    private static Eixo _nullEixo = new EixoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Eixo> toCacheModel() {
                return _nullEixoCacheModel;
            }
        };

    private static CacheModel<Eixo> _nullEixoCacheModel = new CacheModel<Eixo>() {
            public Eixo toEntityModel() {
                return _nullEixo;
            }
        };

    @BeanReference(type = ConfiguracaoPersistence.class)
    protected ConfiguracaoPersistence configuracaoPersistence;
    @BeanReference(type = EixoPersistence.class)
    protected EixoPersistence eixoPersistence;
    @BeanReference(type = PropostaPersistence.class)
    protected PropostaPersistence propostaPersistence;
    @BeanReference(type = VotoPersistence.class)
    protected VotoPersistence votoPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the eixo in the entity cache if it is enabled.
     *
     * @param eixo the eixo
     */
    public void cacheResult(Eixo eixo) {
        EntityCacheUtil.putResult(EixoModelImpl.ENTITY_CACHE_ENABLED,
            EixoImpl.class, eixo.getPrimaryKey(), eixo);

        eixo.resetOriginalValues();
    }

    /**
     * Caches the eixos in the entity cache if it is enabled.
     *
     * @param eixos the eixos
     */
    public void cacheResult(List<Eixo> eixos) {
        for (Eixo eixo : eixos) {
            if (EntityCacheUtil.getResult(EixoModelImpl.ENTITY_CACHE_ENABLED,
                        EixoImpl.class, eixo.getPrimaryKey()) == null) {
                cacheResult(eixo);
            } else {
                eixo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all eixos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(EixoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(EixoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the eixo.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Eixo eixo) {
        EntityCacheUtil.removeResult(EixoModelImpl.ENTITY_CACHE_ENABLED,
            EixoImpl.class, eixo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Eixo> eixos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Eixo eixo : eixos) {
            EntityCacheUtil.removeResult(EixoModelImpl.ENTITY_CACHE_ENABLED,
                EixoImpl.class, eixo.getPrimaryKey());
        }
    }

    /**
     * Creates a new eixo with the primary key. Does not add the eixo to the database.
     *
     * @param eixoId the primary key for the new eixo
     * @return the new eixo
     */
    public Eixo create(long eixoId) {
        Eixo eixo = new EixoImpl();

        eixo.setNew(true);
        eixo.setPrimaryKey(eixoId);

        return eixo;
    }

    /**
     * Removes the eixo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param eixoId the primary key of the eixo
     * @return the eixo that was removed
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException if a eixo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Eixo remove(long eixoId) throws NoSuchEixoException, SystemException {
        return remove(Long.valueOf(eixoId));
    }

    /**
     * Removes the eixo with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the eixo
     * @return the eixo that was removed
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException if a eixo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Eixo remove(Serializable primaryKey)
        throws NoSuchEixoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Eixo eixo = (Eixo) session.get(EixoImpl.class, primaryKey);

            if (eixo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchEixoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(eixo);
        } catch (NoSuchEixoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Eixo removeImpl(Eixo eixo) throws SystemException {
        eixo = toUnwrappedModel(eixo);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, eixo);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(eixo);

        return eixo;
    }

    @Override
    public Eixo updateImpl(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo,
        boolean merge) throws SystemException {
        eixo = toUnwrappedModel(eixo);

        boolean isNew = eixo.isNew();

        EixoModelImpl eixoModelImpl = (EixoModelImpl) eixo;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, eixo, merge);

            eixo.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !EixoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((eixoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(eixoModelImpl.getOriginalGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G,
                    args);

                args = new Object[] { Long.valueOf(eixoModelImpl.getGroupId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G,
                    args);
            }
        }

        EntityCacheUtil.putResult(EixoModelImpl.ENTITY_CACHE_ENABLED,
            EixoImpl.class, eixo.getPrimaryKey(), eixo);

        return eixo;
    }

    protected Eixo toUnwrappedModel(Eixo eixo) {
        if (eixo instanceof EixoImpl) {
            return eixo;
        }

        EixoImpl eixoImpl = new EixoImpl();

        eixoImpl.setNew(eixo.isNew());
        eixoImpl.setPrimaryKey(eixo.getPrimaryKey());

        eixoImpl.setEixoId(eixo.getEixoId());
        eixoImpl.setCompanyId(eixo.getCompanyId());
        eixoImpl.setGroupId(eixo.getGroupId());
        eixoImpl.setCategoryId(eixo.getCategoryId());
        eixoImpl.setTitulo(eixo.getTitulo());
        eixoImpl.setSumario(eixo.getSumario());
        eixoImpl.setOrdem(eixo.getOrdem());

        return eixoImpl;
    }

    /**
     * Returns the eixo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the eixo
     * @return the eixo
     * @throws com.liferay.portal.NoSuchModelException if a eixo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Eixo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the eixo with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException} if it could not be found.
     *
     * @param eixoId the primary key of the eixo
     * @return the eixo
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException if a eixo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Eixo findByPrimaryKey(long eixoId)
        throws NoSuchEixoException, SystemException {
        Eixo eixo = fetchByPrimaryKey(eixoId);

        if (eixo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + eixoId);
            }

            throw new NoSuchEixoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                eixoId);
        }

        return eixo;
    }

    /**
     * Returns the eixo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the eixo
     * @return the eixo, or <code>null</code> if a eixo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Eixo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the eixo with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param eixoId the primary key of the eixo
     * @return the eixo, or <code>null</code> if a eixo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Eixo fetchByPrimaryKey(long eixoId) throws SystemException {
        Eixo eixo = (Eixo) EntityCacheUtil.getResult(EixoModelImpl.ENTITY_CACHE_ENABLED,
                EixoImpl.class, eixoId);

        if (eixo == _nullEixo) {
            return null;
        }

        if (eixo == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                eixo = (Eixo) session.get(EixoImpl.class, Long.valueOf(eixoId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (eixo != null) {
                    cacheResult(eixo);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(EixoModelImpl.ENTITY_CACHE_ENABLED,
                        EixoImpl.class, eixoId, _nullEixo);
                }

                closeSession(session);
            }
        }

        return eixo;
    }

    /**
     * Returns all the eixos where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching eixos
     * @throws SystemException if a system exception occurred
     */
    public List<Eixo> findByG(long groupId) throws SystemException {
        return findByG(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the eixos where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of eixos
     * @param end the upper bound of the range of eixos (not inclusive)
     * @return the range of matching eixos
     * @throws SystemException if a system exception occurred
     */
    public List<Eixo> findByG(long groupId, int start, int end)
        throws SystemException {
        return findByG(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the eixos where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of eixos
     * @param end the upper bound of the range of eixos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching eixos
     * @throws SystemException if a system exception occurred
     */
    public List<Eixo> findByG(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<Eixo> list = (List<Eixo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Eixo eixo : list) {
                if ((groupId != eixo.getGroupId())) {
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

            query.append(_SQL_SELECT_EIXO_WHERE);

            query.append(_FINDER_COLUMN_G_GROUPID_2);

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

                list = (List<Eixo>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first eixo in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching eixo
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException if a matching eixo could not be found
     * @throws SystemException if a system exception occurred
     */
    public Eixo findByG_First(long groupId, OrderByComparator orderByComparator)
        throws NoSuchEixoException, SystemException {
        Eixo eixo = fetchByG_First(groupId, orderByComparator);

        if (eixo != null) {
            return eixo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEixoException(msg.toString());
    }

    /**
     * Returns the first eixo in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching eixo, or <code>null</code> if a matching eixo could not be found
     * @throws SystemException if a system exception occurred
     */
    public Eixo fetchByG_First(long groupId, OrderByComparator orderByComparator)
        throws SystemException {
        List<Eixo> list = findByG(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last eixo in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching eixo
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException if a matching eixo could not be found
     * @throws SystemException if a system exception occurred
     */
    public Eixo findByG_Last(long groupId, OrderByComparator orderByComparator)
        throws NoSuchEixoException, SystemException {
        Eixo eixo = fetchByG_Last(groupId, orderByComparator);

        if (eixo != null) {
            return eixo;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEixoException(msg.toString());
    }

    /**
     * Returns the last eixo in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching eixo, or <code>null</code> if a matching eixo could not be found
     * @throws SystemException if a system exception occurred
     */
    public Eixo fetchByG_Last(long groupId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByG(groupId);

        List<Eixo> list = findByG(groupId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the eixos before and after the current eixo in the ordered set where groupId = &#63;.
     *
     * @param eixoId the primary key of the current eixo
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next eixo
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException if a eixo with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Eixo[] findByG_PrevAndNext(long eixoId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchEixoException, SystemException {
        Eixo eixo = findByPrimaryKey(eixoId);

        Session session = null;

        try {
            session = openSession();

            Eixo[] array = new EixoImpl[3];

            array[0] = getByG_PrevAndNext(session, eixo, groupId,
                    orderByComparator, true);

            array[1] = eixo;

            array[2] = getByG_PrevAndNext(session, eixo, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Eixo getByG_PrevAndNext(Session session, Eixo eixo, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EIXO_WHERE);

        query.append(_FINDER_COLUMN_G_GROUPID_2);

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

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(eixo);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Eixo> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the eixos.
     *
     * @return the eixos
     * @throws SystemException if a system exception occurred
     */
    public List<Eixo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the eixos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of eixos
     * @param end the upper bound of the range of eixos (not inclusive)
     * @return the range of eixos
     * @throws SystemException if a system exception occurred
     */
    public List<Eixo> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the eixos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of eixos
     * @param end the upper bound of the range of eixos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of eixos
     * @throws SystemException if a system exception occurred
     */
    public List<Eixo> findAll(int start, int end,
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

        List<Eixo> list = (List<Eixo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_EIXO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_EIXO;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Eixo>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Eixo>) QueryUtil.list(q, getDialect(), start,
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
     * Removes all the eixos where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByG(long groupId) throws SystemException {
        for (Eixo eixo : findByG(groupId)) {
            remove(eixo);
        }
    }

    /**
     * Removes all the eixos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Eixo eixo : findAll()) {
            remove(eixo);
        }
    }

    /**
     * Returns the number of eixos where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching eixos
     * @throws SystemException if a system exception occurred
     */
    public int countByG(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EIXO_WHERE);

            query.append(_FINDER_COLUMN_G_GROUPID_2);

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

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of eixos.
     *
     * @return the number of eixos
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_EIXO);

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
     * Initializes the eixo persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Eixo>> listenersList = new ArrayList<ModelListener<Eixo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Eixo>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(EixoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
