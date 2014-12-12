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

import br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Voto;
import br.gov.camara.edemocracia.portlets.priorizacao.model.impl.VotoImpl;
import br.gov.camara.edemocracia.portlets.priorizacao.model.impl.VotoModelImpl;
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
 * The persistence implementation for the voto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see VotoPersistence
 * @see VotoUtil
 * @generated
 */
public class VotoPersistenceImpl extends BasePersistenceImpl<Voto>
    implements VotoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link VotoUtil} to access the voto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = VotoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_P = new FinderPath(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoModelImpl.FINDER_CACHE_ENABLED, VotoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P = new FinderPath(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoModelImpl.FINDER_CACHE_ENABLED, VotoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP",
            new String[] { Long.class.getName() },
            VotoModelImpl.PROPOSTAID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_P = new FinderPath(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_P_U = new FinderPath(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoModelImpl.FINDER_CACHE_ENABLED, VotoImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByP_U",
            new String[] { Long.class.getName(), Long.class.getName() },
            VotoModelImpl.PROPOSTAID_COLUMN_BITMASK |
            VotoModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_P_U = new FinderPath(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_U",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U = new FinderPath(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoModelImpl.FINDER_CACHE_ENABLED, VotoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U = new FinderPath(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoModelImpl.FINDER_CACHE_ENABLED, VotoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU",
            new String[] { Long.class.getName() },
            VotoModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_U = new FinderPath(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoModelImpl.FINDER_CACHE_ENABLED, VotoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoModelImpl.FINDER_CACHE_ENABLED, VotoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_VOTO = "SELECT voto FROM Voto voto";
    private static final String _SQL_SELECT_VOTO_WHERE = "SELECT voto FROM Voto voto WHERE ";
    private static final String _SQL_COUNT_VOTO = "SELECT COUNT(voto) FROM Voto voto";
    private static final String _SQL_COUNT_VOTO_WHERE = "SELECT COUNT(voto) FROM Voto voto WHERE ";
    private static final String _FINDER_COLUMN_P_PROPOSTAID_2 = "voto.propostaId = ?";
    private static final String _FINDER_COLUMN_P_U_PROPOSTAID_2 = "voto.propostaId = ? AND ";
    private static final String _FINDER_COLUMN_P_U_USERID_2 = "voto.userId = ?";
    private static final String _FINDER_COLUMN_U_USERID_2 = "voto.userId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "voto.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Voto exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Voto exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(VotoPersistenceImpl.class);
    private static Voto _nullVoto = new VotoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Voto> toCacheModel() {
                return _nullVotoCacheModel;
            }
        };

    private static CacheModel<Voto> _nullVotoCacheModel = new CacheModel<Voto>() {
            public Voto toEntityModel() {
                return _nullVoto;
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
     * Caches the voto in the entity cache if it is enabled.
     *
     * @param voto the voto
     */
    public void cacheResult(Voto voto) {
        EntityCacheUtil.putResult(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoImpl.class, voto.getPrimaryKey(), voto);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_P_U,
            new Object[] {
                Long.valueOf(voto.getPropostaId()),
                Long.valueOf(voto.getUserId())
            }, voto);

        voto.resetOriginalValues();
    }

    /**
     * Caches the votos in the entity cache if it is enabled.
     *
     * @param votos the votos
     */
    public void cacheResult(List<Voto> votos) {
        for (Voto voto : votos) {
            if (EntityCacheUtil.getResult(VotoModelImpl.ENTITY_CACHE_ENABLED,
                        VotoImpl.class, voto.getPrimaryKey()) == null) {
                cacheResult(voto);
            } else {
                voto.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all votos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(VotoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(VotoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the voto.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Voto voto) {
        EntityCacheUtil.removeResult(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoImpl.class, voto.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(voto);
    }

    @Override
    public void clearCache(List<Voto> votos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Voto voto : votos) {
            EntityCacheUtil.removeResult(VotoModelImpl.ENTITY_CACHE_ENABLED,
                VotoImpl.class, voto.getPrimaryKey());

            clearUniqueFindersCache(voto);
        }
    }

    protected void clearUniqueFindersCache(Voto voto) {
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_P_U,
            new Object[] {
                Long.valueOf(voto.getPropostaId()),
                Long.valueOf(voto.getUserId())
            });
    }

    /**
     * Creates a new voto with the primary key. Does not add the voto to the database.
     *
     * @param votoId the primary key for the new voto
     * @return the new voto
     */
    public Voto create(long votoId) {
        Voto voto = new VotoImpl();

        voto.setNew(true);
        voto.setPrimaryKey(votoId);

        return voto;
    }

    /**
     * Removes the voto with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param votoId the primary key of the voto
     * @return the voto that was removed
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a voto with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto remove(long votoId) throws NoSuchVotoException, SystemException {
        return remove(Long.valueOf(votoId));
    }

    /**
     * Removes the voto with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the voto
     * @return the voto that was removed
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a voto with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Voto remove(Serializable primaryKey)
        throws NoSuchVotoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Voto voto = (Voto) session.get(VotoImpl.class, primaryKey);

            if (voto == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchVotoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(voto);
        } catch (NoSuchVotoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Voto removeImpl(Voto voto) throws SystemException {
        voto = toUnwrappedModel(voto);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, voto);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(voto);

        return voto;
    }

    @Override
    public Voto updateImpl(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto,
        boolean merge) throws SystemException {
        voto = toUnwrappedModel(voto);

        boolean isNew = voto.isNew();

        VotoModelImpl votoModelImpl = (VotoModelImpl) voto;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, voto, merge);

            voto.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !VotoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((votoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(votoModelImpl.getOriginalPropostaId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P,
                    args);

                args = new Object[] { Long.valueOf(votoModelImpl.getPropostaId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P,
                    args);
            }

            if ((votoModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(votoModelImpl.getOriginalUserId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U,
                    args);

                args = new Object[] { Long.valueOf(votoModelImpl.getUserId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U,
                    args);
            }
        }

        EntityCacheUtil.putResult(VotoModelImpl.ENTITY_CACHE_ENABLED,
            VotoImpl.class, voto.getPrimaryKey(), voto);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_P_U,
                new Object[] {
                    Long.valueOf(voto.getPropostaId()),
                    Long.valueOf(voto.getUserId())
                }, voto);
        } else {
            if ((votoModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_P_U.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(votoModelImpl.getOriginalPropostaId()),
                        Long.valueOf(votoModelImpl.getOriginalUserId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_U, args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_P_U, args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_P_U,
                    new Object[] {
                        Long.valueOf(voto.getPropostaId()),
                        Long.valueOf(voto.getUserId())
                    }, voto);
            }
        }

        return voto;
    }

    protected Voto toUnwrappedModel(Voto voto) {
        if (voto instanceof VotoImpl) {
            return voto;
        }

        VotoImpl votoImpl = new VotoImpl();

        votoImpl.setNew(voto.isNew());
        votoImpl.setPrimaryKey(voto.getPrimaryKey());

        votoImpl.setVotoId(voto.getVotoId());
        votoImpl.setPropostaId(voto.getPropostaId());
        votoImpl.setUserId(voto.getUserId());
        votoImpl.setUserName(voto.getUserName());
        votoImpl.setNumeroVotos(voto.getNumeroVotos());
        votoImpl.setVotosDisponiveis(voto.getVotosDisponiveis());
        votoImpl.setData(voto.getData());

        return votoImpl;
    }

    /**
     * Returns the voto with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the voto
     * @return the voto
     * @throws com.liferay.portal.NoSuchModelException if a voto with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Voto findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the voto with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException} if it could not be found.
     *
     * @param votoId the primary key of the voto
     * @return the voto
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a voto with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto findByPrimaryKey(long votoId)
        throws NoSuchVotoException, SystemException {
        Voto voto = fetchByPrimaryKey(votoId);

        if (voto == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + votoId);
            }

            throw new NoSuchVotoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                votoId);
        }

        return voto;
    }

    /**
     * Returns the voto with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the voto
     * @return the voto, or <code>null</code> if a voto with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Voto fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the voto with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param votoId the primary key of the voto
     * @return the voto, or <code>null</code> if a voto with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto fetchByPrimaryKey(long votoId) throws SystemException {
        Voto voto = (Voto) EntityCacheUtil.getResult(VotoModelImpl.ENTITY_CACHE_ENABLED,
                VotoImpl.class, votoId);

        if (voto == _nullVoto) {
            return null;
        }

        if (voto == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                voto = (Voto) session.get(VotoImpl.class, Long.valueOf(votoId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (voto != null) {
                    cacheResult(voto);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(VotoModelImpl.ENTITY_CACHE_ENABLED,
                        VotoImpl.class, votoId, _nullVoto);
                }

                closeSession(session);
            }
        }

        return voto;
    }

    /**
     * Returns all the votos where propostaId = &#63;.
     *
     * @param propostaId the proposta ID
     * @return the matching votos
     * @throws SystemException if a system exception occurred
     */
    public List<Voto> findByP(long propostaId) throws SystemException {
        return findByP(propostaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the votos where propostaId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param propostaId the proposta ID
     * @param start the lower bound of the range of votos
     * @param end the upper bound of the range of votos (not inclusive)
     * @return the range of matching votos
     * @throws SystemException if a system exception occurred
     */
    public List<Voto> findByP(long propostaId, int start, int end)
        throws SystemException {
        return findByP(propostaId, start, end, null);
    }

    /**
     * Returns an ordered range of all the votos where propostaId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param propostaId the proposta ID
     * @param start the lower bound of the range of votos
     * @param end the upper bound of the range of votos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching votos
     * @throws SystemException if a system exception occurred
     */
    public List<Voto> findByP(long propostaId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P;
            finderArgs = new Object[] { propostaId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_P;
            finderArgs = new Object[] { propostaId, start, end, orderByComparator };
        }

        List<Voto> list = (List<Voto>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Voto voto : list) {
                if ((propostaId != voto.getPropostaId())) {
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

            query.append(_SQL_SELECT_VOTO_WHERE);

            query.append(_FINDER_COLUMN_P_PROPOSTAID_2);

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

                qPos.add(propostaId);

                list = (List<Voto>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first voto in the ordered set where propostaId = &#63;.
     *
     * @param propostaId the proposta ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching voto
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a matching voto could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto findByP_First(long propostaId,
        OrderByComparator orderByComparator)
        throws NoSuchVotoException, SystemException {
        Voto voto = fetchByP_First(propostaId, orderByComparator);

        if (voto != null) {
            return voto;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("propostaId=");
        msg.append(propostaId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchVotoException(msg.toString());
    }

    /**
     * Returns the first voto in the ordered set where propostaId = &#63;.
     *
     * @param propostaId the proposta ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching voto, or <code>null</code> if a matching voto could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto fetchByP_First(long propostaId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Voto> list = findByP(propostaId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last voto in the ordered set where propostaId = &#63;.
     *
     * @param propostaId the proposta ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching voto
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a matching voto could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto findByP_Last(long propostaId,
        OrderByComparator orderByComparator)
        throws NoSuchVotoException, SystemException {
        Voto voto = fetchByP_Last(propostaId, orderByComparator);

        if (voto != null) {
            return voto;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("propostaId=");
        msg.append(propostaId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchVotoException(msg.toString());
    }

    /**
     * Returns the last voto in the ordered set where propostaId = &#63;.
     *
     * @param propostaId the proposta ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching voto, or <code>null</code> if a matching voto could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto fetchByP_Last(long propostaId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByP(propostaId);

        List<Voto> list = findByP(propostaId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the votos before and after the current voto in the ordered set where propostaId = &#63;.
     *
     * @param votoId the primary key of the current voto
     * @param propostaId the proposta ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next voto
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a voto with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto[] findByP_PrevAndNext(long votoId, long propostaId,
        OrderByComparator orderByComparator)
        throws NoSuchVotoException, SystemException {
        Voto voto = findByPrimaryKey(votoId);

        Session session = null;

        try {
            session = openSession();

            Voto[] array = new VotoImpl[3];

            array[0] = getByP_PrevAndNext(session, voto, propostaId,
                    orderByComparator, true);

            array[1] = voto;

            array[2] = getByP_PrevAndNext(session, voto, propostaId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Voto getByP_PrevAndNext(Session session, Voto voto,
        long propostaId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_VOTO_WHERE);

        query.append(_FINDER_COLUMN_P_PROPOSTAID_2);

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

        qPos.add(propostaId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(voto);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Voto> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns the voto where propostaId = &#63; and userId = &#63; or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException} if it could not be found.
     *
     * @param propostaId the proposta ID
     * @param userId the user ID
     * @return the matching voto
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a matching voto could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto findByP_U(long propostaId, long userId)
        throws NoSuchVotoException, SystemException {
        Voto voto = fetchByP_U(propostaId, userId);

        if (voto == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("propostaId=");
            msg.append(propostaId);

            msg.append(", userId=");
            msg.append(userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchVotoException(msg.toString());
        }

        return voto;
    }

    /**
     * Returns the voto where propostaId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param propostaId the proposta ID
     * @param userId the user ID
     * @return the matching voto, or <code>null</code> if a matching voto could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto fetchByP_U(long propostaId, long userId)
        throws SystemException {
        return fetchByP_U(propostaId, userId, true);
    }

    /**
     * Returns the voto where propostaId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param propostaId the proposta ID
     * @param userId the user ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching voto, or <code>null</code> if a matching voto could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto fetchByP_U(long propostaId, long userId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { propostaId, userId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_P_U,
                    finderArgs, this);
        }

        if (result instanceof Voto) {
            Voto voto = (Voto) result;

            if ((propostaId != voto.getPropostaId()) ||
                    (userId != voto.getUserId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_VOTO_WHERE);

            query.append(_FINDER_COLUMN_P_U_PROPOSTAID_2);

            query.append(_FINDER_COLUMN_P_U_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(propostaId);

                qPos.add(userId);

                List<Voto> list = q.list();

                result = list;

                Voto voto = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_P_U,
                        finderArgs, list);
                } else {
                    voto = list.get(0);

                    cacheResult(voto);

                    if ((voto.getPropostaId() != propostaId) ||
                            (voto.getUserId() != userId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_P_U,
                            finderArgs, voto);
                    }
                }

                return voto;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_P_U,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (Voto) result;
            }
        }
    }

    /**
     * Returns all the votos where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching votos
     * @throws SystemException if a system exception occurred
     */
    public List<Voto> findByU(long userId) throws SystemException {
        return findByU(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the votos where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of votos
     * @param end the upper bound of the range of votos (not inclusive)
     * @return the range of matching votos
     * @throws SystemException if a system exception occurred
     */
    public List<Voto> findByU(long userId, int start, int end)
        throws SystemException {
        return findByU(userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the votos where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of votos
     * @param end the upper bound of the range of votos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching votos
     * @throws SystemException if a system exception occurred
     */
    public List<Voto> findByU(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Voto> list = (List<Voto>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Voto voto : list) {
                if ((userId != voto.getUserId())) {
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

            query.append(_SQL_SELECT_VOTO_WHERE);

            query.append(_FINDER_COLUMN_U_USERID_2);

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

                qPos.add(userId);

                list = (List<Voto>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first voto in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching voto
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a matching voto could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto findByU_First(long userId, OrderByComparator orderByComparator)
        throws NoSuchVotoException, SystemException {
        Voto voto = fetchByU_First(userId, orderByComparator);

        if (voto != null) {
            return voto;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchVotoException(msg.toString());
    }

    /**
     * Returns the first voto in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching voto, or <code>null</code> if a matching voto could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto fetchByU_First(long userId, OrderByComparator orderByComparator)
        throws SystemException {
        List<Voto> list = findByU(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last voto in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching voto
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a matching voto could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto findByU_Last(long userId, OrderByComparator orderByComparator)
        throws NoSuchVotoException, SystemException {
        Voto voto = fetchByU_Last(userId, orderByComparator);

        if (voto != null) {
            return voto;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchVotoException(msg.toString());
    }

    /**
     * Returns the last voto in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching voto, or <code>null</code> if a matching voto could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto fetchByU_Last(long userId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByU(userId);

        List<Voto> list = findByU(userId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the votos before and after the current voto in the ordered set where userId = &#63;.
     *
     * @param votoId the primary key of the current voto
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next voto
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a voto with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Voto[] findByU_PrevAndNext(long votoId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchVotoException, SystemException {
        Voto voto = findByPrimaryKey(votoId);

        Session session = null;

        try {
            session = openSession();

            Voto[] array = new VotoImpl[3];

            array[0] = getByU_PrevAndNext(session, voto, userId,
                    orderByComparator, true);

            array[1] = voto;

            array[2] = getByU_PrevAndNext(session, voto, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Voto getByU_PrevAndNext(Session session, Voto voto, long userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_VOTO_WHERE);

        query.append(_FINDER_COLUMN_U_USERID_2);

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

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(voto);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Voto> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the votos.
     *
     * @return the votos
     * @throws SystemException if a system exception occurred
     */
    public List<Voto> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the votos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of votos
     * @param end the upper bound of the range of votos (not inclusive)
     * @return the range of votos
     * @throws SystemException if a system exception occurred
     */
    public List<Voto> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the votos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of votos
     * @param end the upper bound of the range of votos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of votos
     * @throws SystemException if a system exception occurred
     */
    public List<Voto> findAll(int start, int end,
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

        List<Voto> list = (List<Voto>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_VOTO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_VOTO;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Voto>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Voto>) QueryUtil.list(q, getDialect(), start,
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
     * Removes all the votos where propostaId = &#63; from the database.
     *
     * @param propostaId the proposta ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByP(long propostaId) throws SystemException {
        for (Voto voto : findByP(propostaId)) {
            remove(voto);
        }
    }

    /**
     * Removes the voto where propostaId = &#63; and userId = &#63; from the database.
     *
     * @param propostaId the proposta ID
     * @param userId the user ID
     * @return the voto that was removed
     * @throws SystemException if a system exception occurred
     */
    public Voto removeByP_U(long propostaId, long userId)
        throws NoSuchVotoException, SystemException {
        Voto voto = findByP_U(propostaId, userId);

        return remove(voto);
    }

    /**
     * Removes all the votos where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByU(long userId) throws SystemException {
        for (Voto voto : findByU(userId)) {
            remove(voto);
        }
    }

    /**
     * Removes all the votos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Voto voto : findAll()) {
            remove(voto);
        }
    }

    /**
     * Returns the number of votos where propostaId = &#63;.
     *
     * @param propostaId the proposta ID
     * @return the number of matching votos
     * @throws SystemException if a system exception occurred
     */
    public int countByP(long propostaId) throws SystemException {
        Object[] finderArgs = new Object[] { propostaId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_P,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_VOTO_WHERE);

            query.append(_FINDER_COLUMN_P_PROPOSTAID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(propostaId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_P, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of votos where propostaId = &#63; and userId = &#63;.
     *
     * @param propostaId the proposta ID
     * @param userId the user ID
     * @return the number of matching votos
     * @throws SystemException if a system exception occurred
     */
    public int countByP_U(long propostaId, long userId)
        throws SystemException {
        Object[] finderArgs = new Object[] { propostaId, userId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_P_U,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_VOTO_WHERE);

            query.append(_FINDER_COLUMN_P_U_PROPOSTAID_2);

            query.append(_FINDER_COLUMN_P_U_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(propostaId);

                qPos.add(userId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_P_U, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of votos where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching votos
     * @throws SystemException if a system exception occurred
     */
    public int countByU(long userId) throws SystemException {
        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_VOTO_WHERE);

            query.append(_FINDER_COLUMN_U_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of votos.
     *
     * @return the number of votos
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_VOTO);

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
     * Initializes the voto persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.priorizacao.model.Voto")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Voto>> listenersList = new ArrayList<ModelListener<Voto>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Voto>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(VotoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
