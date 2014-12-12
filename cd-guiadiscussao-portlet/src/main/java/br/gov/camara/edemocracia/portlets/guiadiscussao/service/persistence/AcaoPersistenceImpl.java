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
package br.gov.camara.edemocracia.portlets.guiadiscussao.service.persistence;

import br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.AcaoImpl;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.AcaoModelImpl;
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
 * The persistence implementation for the acao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robson
 * @see AcaoPersistence
 * @see AcaoUtil
 * @generated
 */
public class AcaoPersistenceImpl extends BasePersistenceImpl<Acao>
    implements AcaoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AcaoUtil} to access the acao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AcaoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FASEID = new FinderPath(AcaoModelImpl.ENTITY_CACHE_ENABLED,
            AcaoModelImpl.FINDER_CACHE_ENABLED, AcaoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFaseId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FASEID =
        new FinderPath(AcaoModelImpl.ENTITY_CACHE_ENABLED,
            AcaoModelImpl.FINDER_CACHE_ENABLED, AcaoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFaseId",
            new String[] { Long.class.getName() },
            AcaoModelImpl.FASEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_FASEID = new FinderPath(AcaoModelImpl.ENTITY_CACHE_ENABLED,
            AcaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFaseId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AcaoModelImpl.ENTITY_CACHE_ENABLED,
            AcaoModelImpl.FINDER_CACHE_ENABLED, AcaoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AcaoModelImpl.ENTITY_CACHE_ENABLED,
            AcaoModelImpl.FINDER_CACHE_ENABLED, AcaoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AcaoModelImpl.ENTITY_CACHE_ENABLED,
            AcaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_ACAO = "SELECT acao FROM Acao acao";
    private static final String _SQL_SELECT_ACAO_WHERE = "SELECT acao FROM Acao acao WHERE ";
    private static final String _SQL_COUNT_ACAO = "SELECT COUNT(acao) FROM Acao acao";
    private static final String _SQL_COUNT_ACAO_WHERE = "SELECT COUNT(acao) FROM Acao acao WHERE ";
    private static final String _FINDER_COLUMN_FASEID_FASEID_2 = "acao.faseId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "acao.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Acao exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Acao exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AcaoPersistenceImpl.class);
    private static Acao _nullAcao = new AcaoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Acao> toCacheModel() {
                return _nullAcaoCacheModel;
            }
        };

    private static CacheModel<Acao> _nullAcaoCacheModel = new CacheModel<Acao>() {
            public Acao toEntityModel() {
                return _nullAcao;
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
     * Caches the acao in the entity cache if it is enabled.
     *
     * @param acao the acao
     */
    public void cacheResult(Acao acao) {
        EntityCacheUtil.putResult(AcaoModelImpl.ENTITY_CACHE_ENABLED,
            AcaoImpl.class, acao.getPrimaryKey(), acao);

        acao.resetOriginalValues();
    }

    /**
     * Caches the acaos in the entity cache if it is enabled.
     *
     * @param acaos the acaos
     */
    public void cacheResult(List<Acao> acaos) {
        for (Acao acao : acaos) {
            if (EntityCacheUtil.getResult(AcaoModelImpl.ENTITY_CACHE_ENABLED,
                        AcaoImpl.class, acao.getPrimaryKey()) == null) {
                cacheResult(acao);
            } else {
                acao.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all acaos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AcaoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AcaoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the acao.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Acao acao) {
        EntityCacheUtil.removeResult(AcaoModelImpl.ENTITY_CACHE_ENABLED,
            AcaoImpl.class, acao.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Acao> acaos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Acao acao : acaos) {
            EntityCacheUtil.removeResult(AcaoModelImpl.ENTITY_CACHE_ENABLED,
                AcaoImpl.class, acao.getPrimaryKey());
        }
    }

    /**
     * Creates a new acao with the primary key. Does not add the acao to the database.
     *
     * @param acaoId the primary key for the new acao
     * @return the new acao
     */
    public Acao create(long acaoId) {
        Acao acao = new AcaoImpl();

        acao.setNew(true);
        acao.setPrimaryKey(acaoId);

        return acao;
    }

    /**
     * Removes the acao with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param acaoId the primary key of the acao
     * @return the acao that was removed
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException if a acao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Acao remove(long acaoId) throws NoSuchAcaoException, SystemException {
        return remove(Long.valueOf(acaoId));
    }

    /**
     * Removes the acao with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the acao
     * @return the acao that was removed
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException if a acao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Acao remove(Serializable primaryKey)
        throws NoSuchAcaoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Acao acao = (Acao) session.get(AcaoImpl.class, primaryKey);

            if (acao == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAcaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(acao);
        } catch (NoSuchAcaoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Acao removeImpl(Acao acao) throws SystemException {
        acao = toUnwrappedModel(acao);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, acao);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(acao);

        return acao;
    }

    @Override
    public Acao updateImpl(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao,
        boolean merge) throws SystemException {
        acao = toUnwrappedModel(acao);

        boolean isNew = acao.isNew();

        AcaoModelImpl acaoModelImpl = (AcaoModelImpl) acao;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, acao, merge);

            acao.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !AcaoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((acaoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FASEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(acaoModelImpl.getOriginalFaseId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FASEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FASEID,
                    args);

                args = new Object[] { Long.valueOf(acaoModelImpl.getFaseId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FASEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FASEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(AcaoModelImpl.ENTITY_CACHE_ENABLED,
            AcaoImpl.class, acao.getPrimaryKey(), acao);

        return acao;
    }

    protected Acao toUnwrappedModel(Acao acao) {
        if (acao instanceof AcaoImpl) {
            return acao;
        }

        AcaoImpl acaoImpl = new AcaoImpl();

        acaoImpl.setNew(acao.isNew());
        acaoImpl.setPrimaryKey(acao.getPrimaryKey());

        acaoImpl.setAcaoId(acao.getAcaoId());
        acaoImpl.setFaseId(acao.getFaseId());
        acaoImpl.setOrdem(acao.getOrdem());
        acaoImpl.setTexto(acao.getTexto());
        acaoImpl.setUrlExterna(acao.isUrlExterna());
        acaoImpl.setUrlLink(acao.getUrlLink());
        acaoImpl.setIconeId(acao.getIconeId());

        return acaoImpl;
    }

    /**
     * Returns the acao with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the acao
     * @return the acao
     * @throws com.liferay.portal.NoSuchModelException if a acao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Acao findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the acao with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException} if it could not be found.
     *
     * @param acaoId the primary key of the acao
     * @return the acao
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException if a acao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Acao findByPrimaryKey(long acaoId)
        throws NoSuchAcaoException, SystemException {
        Acao acao = fetchByPrimaryKey(acaoId);

        if (acao == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + acaoId);
            }

            throw new NoSuchAcaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                acaoId);
        }

        return acao;
    }

    /**
     * Returns the acao with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the acao
     * @return the acao, or <code>null</code> if a acao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Acao fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the acao with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param acaoId the primary key of the acao
     * @return the acao, or <code>null</code> if a acao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Acao fetchByPrimaryKey(long acaoId) throws SystemException {
        Acao acao = (Acao) EntityCacheUtil.getResult(AcaoModelImpl.ENTITY_CACHE_ENABLED,
                AcaoImpl.class, acaoId);

        if (acao == _nullAcao) {
            return null;
        }

        if (acao == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                acao = (Acao) session.get(AcaoImpl.class, Long.valueOf(acaoId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (acao != null) {
                    cacheResult(acao);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(AcaoModelImpl.ENTITY_CACHE_ENABLED,
                        AcaoImpl.class, acaoId, _nullAcao);
                }

                closeSession(session);
            }
        }

        return acao;
    }

    /**
     * Returns all the acaos where faseId = &#63;.
     *
     * @param faseId the fase ID
     * @return the matching acaos
     * @throws SystemException if a system exception occurred
     */
    public List<Acao> findByFaseId(long faseId) throws SystemException {
        return findByFaseId(faseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the acaos where faseId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param faseId the fase ID
     * @param start the lower bound of the range of acaos
     * @param end the upper bound of the range of acaos (not inclusive)
     * @return the range of matching acaos
     * @throws SystemException if a system exception occurred
     */
    public List<Acao> findByFaseId(long faseId, int start, int end)
        throws SystemException {
        return findByFaseId(faseId, start, end, null);
    }

    /**
     * Returns an ordered range of all the acaos where faseId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param faseId the fase ID
     * @param start the lower bound of the range of acaos
     * @param end the upper bound of the range of acaos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching acaos
     * @throws SystemException if a system exception occurred
     */
    public List<Acao> findByFaseId(long faseId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FASEID;
            finderArgs = new Object[] { faseId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FASEID;
            finderArgs = new Object[] { faseId, start, end, orderByComparator };
        }

        List<Acao> list = (List<Acao>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Acao acao : list) {
                if ((faseId != acao.getFaseId())) {
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

            query.append(_SQL_SELECT_ACAO_WHERE);

            query.append(_FINDER_COLUMN_FASEID_FASEID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(AcaoModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(faseId);

                list = (List<Acao>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first acao in the ordered set where faseId = &#63;.
     *
     * @param faseId the fase ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching acao
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException if a matching acao could not be found
     * @throws SystemException if a system exception occurred
     */
    public Acao findByFaseId_First(long faseId,
        OrderByComparator orderByComparator)
        throws NoSuchAcaoException, SystemException {
        Acao acao = fetchByFaseId_First(faseId, orderByComparator);

        if (acao != null) {
            return acao;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("faseId=");
        msg.append(faseId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAcaoException(msg.toString());
    }

    /**
     * Returns the first acao in the ordered set where faseId = &#63;.
     *
     * @param faseId the fase ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching acao, or <code>null</code> if a matching acao could not be found
     * @throws SystemException if a system exception occurred
     */
    public Acao fetchByFaseId_First(long faseId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Acao> list = findByFaseId(faseId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last acao in the ordered set where faseId = &#63;.
     *
     * @param faseId the fase ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching acao
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException if a matching acao could not be found
     * @throws SystemException if a system exception occurred
     */
    public Acao findByFaseId_Last(long faseId,
        OrderByComparator orderByComparator)
        throws NoSuchAcaoException, SystemException {
        Acao acao = fetchByFaseId_Last(faseId, orderByComparator);

        if (acao != null) {
            return acao;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("faseId=");
        msg.append(faseId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchAcaoException(msg.toString());
    }

    /**
     * Returns the last acao in the ordered set where faseId = &#63;.
     *
     * @param faseId the fase ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching acao, or <code>null</code> if a matching acao could not be found
     * @throws SystemException if a system exception occurred
     */
    public Acao fetchByFaseId_Last(long faseId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByFaseId(faseId);

        List<Acao> list = findByFaseId(faseId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the acaos before and after the current acao in the ordered set where faseId = &#63;.
     *
     * @param acaoId the primary key of the current acao
     * @param faseId the fase ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next acao
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException if a acao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Acao[] findByFaseId_PrevAndNext(long acaoId, long faseId,
        OrderByComparator orderByComparator)
        throws NoSuchAcaoException, SystemException {
        Acao acao = findByPrimaryKey(acaoId);

        Session session = null;

        try {
            session = openSession();

            Acao[] array = new AcaoImpl[3];

            array[0] = getByFaseId_PrevAndNext(session, acao, faseId,
                    orderByComparator, true);

            array[1] = acao;

            array[2] = getByFaseId_PrevAndNext(session, acao, faseId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Acao getByFaseId_PrevAndNext(Session session, Acao acao,
        long faseId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_ACAO_WHERE);

        query.append(_FINDER_COLUMN_FASEID_FASEID_2);

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
            query.append(AcaoModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(faseId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(acao);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Acao> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the acaos.
     *
     * @return the acaos
     * @throws SystemException if a system exception occurred
     */
    public List<Acao> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the acaos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of acaos
     * @param end the upper bound of the range of acaos (not inclusive)
     * @return the range of acaos
     * @throws SystemException if a system exception occurred
     */
    public List<Acao> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the acaos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of acaos
     * @param end the upper bound of the range of acaos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of acaos
     * @throws SystemException if a system exception occurred
     */
    public List<Acao> findAll(int start, int end,
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

        List<Acao> list = (List<Acao>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_ACAO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_ACAO.concat(AcaoModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Acao>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Acao>) QueryUtil.list(q, getDialect(), start,
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
     * Removes all the acaos where faseId = &#63; from the database.
     *
     * @param faseId the fase ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByFaseId(long faseId) throws SystemException {
        for (Acao acao : findByFaseId(faseId)) {
            remove(acao);
        }
    }

    /**
     * Removes all the acaos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Acao acao : findAll()) {
            remove(acao);
        }
    }

    /**
     * Returns the number of acaos where faseId = &#63;.
     *
     * @param faseId the fase ID
     * @return the number of matching acaos
     * @throws SystemException if a system exception occurred
     */
    public int countByFaseId(long faseId) throws SystemException {
        Object[] finderArgs = new Object[] { faseId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FASEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_ACAO_WHERE);

            query.append(_FINDER_COLUMN_FASEID_FASEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(faseId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FASEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of acaos.
     *
     * @return the number of acaos
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_ACAO);

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
     * Initializes the acao persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Acao>> listenersList = new ArrayList<ModelListener<Acao>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Acao>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AcaoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
