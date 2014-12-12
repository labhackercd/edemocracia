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

import br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException;
import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;
import br.gov.camara.edemocracia.portlets.priorizacao.model.impl.PropostaImpl;
import br.gov.camara.edemocracia.portlets.priorizacao.model.impl.PropostaModelImpl;
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
 * The persistence implementation for the proposta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see PropostaPersistence
 * @see PropostaUtil
 * @generated
 */
public class PropostaPersistenceImpl extends BasePersistenceImpl<Proposta>
    implements PropostaPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PropostaUtil} to access the proposta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PropostaImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_E = new FinderPath(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaModelImpl.FINDER_CACHE_ENABLED, PropostaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByE",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_E = new FinderPath(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaModelImpl.FINDER_CACHE_ENABLED, PropostaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByE",
            new String[] { Long.class.getName() },
            PropostaModelImpl.EIXOID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_E = new FinderPath(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByE",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G = new FinderPath(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaModelImpl.FINDER_CACHE_ENABLED, PropostaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G = new FinderPath(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaModelImpl.FINDER_CACHE_ENABLED, PropostaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG",
            new String[] { Long.class.getName() },
            PropostaModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_G = new FinderPath(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_I_G = new FinderPath(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaModelImpl.FINDER_CACHE_ENABLED, PropostaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByI_G",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_I_G = new FinderPath(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaModelImpl.FINDER_CACHE_ENABLED, PropostaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByI_G",
            new String[] { String.class.getName(), Long.class.getName() },
            PropostaModelImpl.IDENTIFICADOR_COLUMN_BITMASK |
            PropostaModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_I_G = new FinderPath(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByI_G",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaModelImpl.FINDER_CACHE_ENABLED, PropostaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaModelImpl.FINDER_CACHE_ENABLED, PropostaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_PROPOSTA = "SELECT proposta FROM Proposta proposta";
    private static final String _SQL_SELECT_PROPOSTA_WHERE = "SELECT proposta FROM Proposta proposta WHERE ";
    private static final String _SQL_COUNT_PROPOSTA = "SELECT COUNT(proposta) FROM Proposta proposta";
    private static final String _SQL_COUNT_PROPOSTA_WHERE = "SELECT COUNT(proposta) FROM Proposta proposta WHERE ";
    private static final String _FINDER_COLUMN_E_EIXOID_2 = "proposta.eixoId = ?";
    private static final String _FINDER_COLUMN_G_GROUPID_2 = "proposta.groupId = ?";
    private static final String _FINDER_COLUMN_I_G_IDENTIFICADOR_1 = "proposta.identificador IS NULL AND ";
    private static final String _FINDER_COLUMN_I_G_IDENTIFICADOR_2 = "proposta.identificador = ? AND ";
    private static final String _FINDER_COLUMN_I_G_IDENTIFICADOR_3 = "(proposta.identificador IS NULL OR proposta.identificador = ?) AND ";
    private static final String _FINDER_COLUMN_I_G_GROUPID_2 = "proposta.groupId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "proposta.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Proposta exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Proposta exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PropostaPersistenceImpl.class);
    private static Proposta _nullProposta = new PropostaImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Proposta> toCacheModel() {
                return _nullPropostaCacheModel;
            }
        };

    private static CacheModel<Proposta> _nullPropostaCacheModel = new CacheModel<Proposta>() {
            public Proposta toEntityModel() {
                return _nullProposta;
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
     * Caches the proposta in the entity cache if it is enabled.
     *
     * @param proposta the proposta
     */
    public void cacheResult(Proposta proposta) {
        EntityCacheUtil.putResult(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaImpl.class, proposta.getPrimaryKey(), proposta);

        proposta.resetOriginalValues();
    }

    /**
     * Caches the propostas in the entity cache if it is enabled.
     *
     * @param propostas the propostas
     */
    public void cacheResult(List<Proposta> propostas) {
        for (Proposta proposta : propostas) {
            if (EntityCacheUtil.getResult(
                        PropostaModelImpl.ENTITY_CACHE_ENABLED,
                        PropostaImpl.class, proposta.getPrimaryKey()) == null) {
                cacheResult(proposta);
            } else {
                proposta.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all propostas.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PropostaImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PropostaImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the proposta.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Proposta proposta) {
        EntityCacheUtil.removeResult(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaImpl.class, proposta.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Proposta> propostas) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Proposta proposta : propostas) {
            EntityCacheUtil.removeResult(PropostaModelImpl.ENTITY_CACHE_ENABLED,
                PropostaImpl.class, proposta.getPrimaryKey());
        }
    }

    /**
     * Creates a new proposta with the primary key. Does not add the proposta to the database.
     *
     * @param propostaId the primary key for the new proposta
     * @return the new proposta
     */
    public Proposta create(long propostaId) {
        Proposta proposta = new PropostaImpl();

        proposta.setNew(true);
        proposta.setPrimaryKey(propostaId);

        return proposta;
    }

    /**
     * Removes the proposta with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param propostaId the primary key of the proposta
     * @return the proposta that was removed
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a proposta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta remove(long propostaId)
        throws NoSuchPropostaException, SystemException {
        return remove(Long.valueOf(propostaId));
    }

    /**
     * Removes the proposta with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the proposta
     * @return the proposta that was removed
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a proposta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposta remove(Serializable primaryKey)
        throws NoSuchPropostaException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Proposta proposta = (Proposta) session.get(PropostaImpl.class,
                    primaryKey);

            if (proposta == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPropostaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(proposta);
        } catch (NoSuchPropostaException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Proposta removeImpl(Proposta proposta) throws SystemException {
        proposta = toUnwrappedModel(proposta);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, proposta);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(proposta);

        return proposta;
    }

    @Override
    public Proposta updateImpl(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta proposta,
        boolean merge) throws SystemException {
        proposta = toUnwrappedModel(proposta);

        boolean isNew = proposta.isNew();

        PropostaModelImpl propostaModelImpl = (PropostaModelImpl) proposta;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, proposta, merge);

            proposta.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !PropostaModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((propostaModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_E.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(propostaModelImpl.getOriginalEixoId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_E, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_E,
                    args);

                args = new Object[] { Long.valueOf(propostaModelImpl.getEixoId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_E, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_E,
                    args);
            }

            if ((propostaModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(propostaModelImpl.getOriginalGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G,
                    args);

                args = new Object[] { Long.valueOf(propostaModelImpl.getGroupId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G,
                    args);
            }

            if ((propostaModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_I_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        propostaModelImpl.getOriginalIdentificador(),
                        Long.valueOf(propostaModelImpl.getOriginalGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_I_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_I_G,
                    args);

                args = new Object[] {
                        propostaModelImpl.getIdentificador(),
                        Long.valueOf(propostaModelImpl.getGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_I_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_I_G,
                    args);
            }
        }

        EntityCacheUtil.putResult(PropostaModelImpl.ENTITY_CACHE_ENABLED,
            PropostaImpl.class, proposta.getPrimaryKey(), proposta);

        return proposta;
    }

    protected Proposta toUnwrappedModel(Proposta proposta) {
        if (proposta instanceof PropostaImpl) {
            return proposta;
        }

        PropostaImpl propostaImpl = new PropostaImpl();

        propostaImpl.setNew(proposta.isNew());
        propostaImpl.setPrimaryKey(proposta.getPrimaryKey());

        propostaImpl.setPropostaId(proposta.getPropostaId());
        propostaImpl.setCompanyId(proposta.getCompanyId());
        propostaImpl.setGroupId(proposta.getGroupId());
        propostaImpl.setEixoId(proposta.getEixoId());
        propostaImpl.setIdentificador(proposta.getIdentificador());
        propostaImpl.setEmenta(proposta.getEmenta());
        propostaImpl.setTexto(proposta.getTexto());
        propostaImpl.setThreadId(proposta.getThreadId());

        return propostaImpl;
    }

    /**
     * Returns the proposta with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the proposta
     * @return the proposta
     * @throws com.liferay.portal.NoSuchModelException if a proposta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposta findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the proposta with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException} if it could not be found.
     *
     * @param propostaId the primary key of the proposta
     * @return the proposta
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a proposta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta findByPrimaryKey(long propostaId)
        throws NoSuchPropostaException, SystemException {
        Proposta proposta = fetchByPrimaryKey(propostaId);

        if (proposta == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + propostaId);
            }

            throw new NoSuchPropostaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                propostaId);
        }

        return proposta;
    }

    /**
     * Returns the proposta with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the proposta
     * @return the proposta, or <code>null</code> if a proposta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Proposta fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the proposta with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param propostaId the primary key of the proposta
     * @return the proposta, or <code>null</code> if a proposta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta fetchByPrimaryKey(long propostaId)
        throws SystemException {
        Proposta proposta = (Proposta) EntityCacheUtil.getResult(PropostaModelImpl.ENTITY_CACHE_ENABLED,
                PropostaImpl.class, propostaId);

        if (proposta == _nullProposta) {
            return null;
        }

        if (proposta == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                proposta = (Proposta) session.get(PropostaImpl.class,
                        Long.valueOf(propostaId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (proposta != null) {
                    cacheResult(proposta);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(PropostaModelImpl.ENTITY_CACHE_ENABLED,
                        PropostaImpl.class, propostaId, _nullProposta);
                }

                closeSession(session);
            }
        }

        return proposta;
    }

    /**
     * Returns all the propostas where eixoId = &#63;.
     *
     * @param eixoId the eixo ID
     * @return the matching propostas
     * @throws SystemException if a system exception occurred
     */
    public List<Proposta> findByE(long eixoId) throws SystemException {
        return findByE(eixoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the propostas where eixoId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param eixoId the eixo ID
     * @param start the lower bound of the range of propostas
     * @param end the upper bound of the range of propostas (not inclusive)
     * @return the range of matching propostas
     * @throws SystemException if a system exception occurred
     */
    public List<Proposta> findByE(long eixoId, int start, int end)
        throws SystemException {
        return findByE(eixoId, start, end, null);
    }

    /**
     * Returns an ordered range of all the propostas where eixoId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param eixoId the eixo ID
     * @param start the lower bound of the range of propostas
     * @param end the upper bound of the range of propostas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching propostas
     * @throws SystemException if a system exception occurred
     */
    public List<Proposta> findByE(long eixoId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_E;
            finderArgs = new Object[] { eixoId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_E;
            finderArgs = new Object[] { eixoId, start, end, orderByComparator };
        }

        List<Proposta> list = (List<Proposta>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Proposta proposta : list) {
                if ((eixoId != proposta.getEixoId())) {
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

            query.append(_SQL_SELECT_PROPOSTA_WHERE);

            query.append(_FINDER_COLUMN_E_EIXOID_2);

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

                qPos.add(eixoId);

                list = (List<Proposta>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first proposta in the ordered set where eixoId = &#63;.
     *
     * @param eixoId the eixo ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching proposta
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a matching proposta could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta findByE_First(long eixoId,
        OrderByComparator orderByComparator)
        throws NoSuchPropostaException, SystemException {
        Proposta proposta = fetchByE_First(eixoId, orderByComparator);

        if (proposta != null) {
            return proposta;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eixoId=");
        msg.append(eixoId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPropostaException(msg.toString());
    }

    /**
     * Returns the first proposta in the ordered set where eixoId = &#63;.
     *
     * @param eixoId the eixo ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching proposta, or <code>null</code> if a matching proposta could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta fetchByE_First(long eixoId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Proposta> list = findByE(eixoId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last proposta in the ordered set where eixoId = &#63;.
     *
     * @param eixoId the eixo ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching proposta
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a matching proposta could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta findByE_Last(long eixoId,
        OrderByComparator orderByComparator)
        throws NoSuchPropostaException, SystemException {
        Proposta proposta = fetchByE_Last(eixoId, orderByComparator);

        if (proposta != null) {
            return proposta;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eixoId=");
        msg.append(eixoId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPropostaException(msg.toString());
    }

    /**
     * Returns the last proposta in the ordered set where eixoId = &#63;.
     *
     * @param eixoId the eixo ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching proposta, or <code>null</code> if a matching proposta could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta fetchByE_Last(long eixoId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByE(eixoId);

        List<Proposta> list = findByE(eixoId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the propostas before and after the current proposta in the ordered set where eixoId = &#63;.
     *
     * @param propostaId the primary key of the current proposta
     * @param eixoId the eixo ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next proposta
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a proposta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta[] findByE_PrevAndNext(long propostaId, long eixoId,
        OrderByComparator orderByComparator)
        throws NoSuchPropostaException, SystemException {
        Proposta proposta = findByPrimaryKey(propostaId);

        Session session = null;

        try {
            session = openSession();

            Proposta[] array = new PropostaImpl[3];

            array[0] = getByE_PrevAndNext(session, proposta, eixoId,
                    orderByComparator, true);

            array[1] = proposta;

            array[2] = getByE_PrevAndNext(session, proposta, eixoId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Proposta getByE_PrevAndNext(Session session, Proposta proposta,
        long eixoId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PROPOSTA_WHERE);

        query.append(_FINDER_COLUMN_E_EIXOID_2);

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

        qPos.add(eixoId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(proposta);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Proposta> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the propostas where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching propostas
     * @throws SystemException if a system exception occurred
     */
    public List<Proposta> findByG(long groupId) throws SystemException {
        return findByG(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the propostas where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of propostas
     * @param end the upper bound of the range of propostas (not inclusive)
     * @return the range of matching propostas
     * @throws SystemException if a system exception occurred
     */
    public List<Proposta> findByG(long groupId, int start, int end)
        throws SystemException {
        return findByG(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the propostas where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of propostas
     * @param end the upper bound of the range of propostas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching propostas
     * @throws SystemException if a system exception occurred
     */
    public List<Proposta> findByG(long groupId, int start, int end,
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

        List<Proposta> list = (List<Proposta>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Proposta proposta : list) {
                if ((groupId != proposta.getGroupId())) {
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

            query.append(_SQL_SELECT_PROPOSTA_WHERE);

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

                list = (List<Proposta>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first proposta in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching proposta
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a matching proposta could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta findByG_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchPropostaException, SystemException {
        Proposta proposta = fetchByG_First(groupId, orderByComparator);

        if (proposta != null) {
            return proposta;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPropostaException(msg.toString());
    }

    /**
     * Returns the first proposta in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching proposta, or <code>null</code> if a matching proposta could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta fetchByG_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Proposta> list = findByG(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last proposta in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching proposta
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a matching proposta could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta findByG_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchPropostaException, SystemException {
        Proposta proposta = fetchByG_Last(groupId, orderByComparator);

        if (proposta != null) {
            return proposta;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPropostaException(msg.toString());
    }

    /**
     * Returns the last proposta in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching proposta, or <code>null</code> if a matching proposta could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta fetchByG_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByG(groupId);

        List<Proposta> list = findByG(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the propostas before and after the current proposta in the ordered set where groupId = &#63;.
     *
     * @param propostaId the primary key of the current proposta
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next proposta
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a proposta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta[] findByG_PrevAndNext(long propostaId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchPropostaException, SystemException {
        Proposta proposta = findByPrimaryKey(propostaId);

        Session session = null;

        try {
            session = openSession();

            Proposta[] array = new PropostaImpl[3];

            array[0] = getByG_PrevAndNext(session, proposta, groupId,
                    orderByComparator, true);

            array[1] = proposta;

            array[2] = getByG_PrevAndNext(session, proposta, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Proposta getByG_PrevAndNext(Session session, Proposta proposta,
        long groupId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PROPOSTA_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(proposta);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Proposta> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the propostas where identificador = &#63; and groupId = &#63;.
     *
     * @param identificador the identificador
     * @param groupId the group ID
     * @return the matching propostas
     * @throws SystemException if a system exception occurred
     */
    public List<Proposta> findByI_G(String identificador, long groupId)
        throws SystemException {
        return findByI_G(identificador, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the propostas where identificador = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param identificador the identificador
     * @param groupId the group ID
     * @param start the lower bound of the range of propostas
     * @param end the upper bound of the range of propostas (not inclusive)
     * @return the range of matching propostas
     * @throws SystemException if a system exception occurred
     */
    public List<Proposta> findByI_G(String identificador, long groupId,
        int start, int end) throws SystemException {
        return findByI_G(identificador, groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the propostas where identificador = &#63; and groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param identificador the identificador
     * @param groupId the group ID
     * @param start the lower bound of the range of propostas
     * @param end the upper bound of the range of propostas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching propostas
     * @throws SystemException if a system exception occurred
     */
    public List<Proposta> findByI_G(String identificador, long groupId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_I_G;
            finderArgs = new Object[] { identificador, groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_I_G;
            finderArgs = new Object[] {
                    identificador, groupId,
                    
                    start, end, orderByComparator
                };
        }

        List<Proposta> list = (List<Proposta>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Proposta proposta : list) {
                if (!Validator.equals(identificador, proposta.getIdentificador()) ||
                        (groupId != proposta.getGroupId())) {
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

            query.append(_SQL_SELECT_PROPOSTA_WHERE);

            if (identificador == null) {
                query.append(_FINDER_COLUMN_I_G_IDENTIFICADOR_1);
            } else {
                if (identificador.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_I_G_IDENTIFICADOR_3);
                } else {
                    query.append(_FINDER_COLUMN_I_G_IDENTIFICADOR_2);
                }
            }

            query.append(_FINDER_COLUMN_I_G_GROUPID_2);

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

                if (identificador != null) {
                    qPos.add(identificador);
                }

                qPos.add(groupId);

                list = (List<Proposta>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first proposta in the ordered set where identificador = &#63; and groupId = &#63;.
     *
     * @param identificador the identificador
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching proposta
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a matching proposta could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta findByI_G_First(String identificador, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchPropostaException, SystemException {
        Proposta proposta = fetchByI_G_First(identificador, groupId,
                orderByComparator);

        if (proposta != null) {
            return proposta;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("identificador=");
        msg.append(identificador);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPropostaException(msg.toString());
    }

    /**
     * Returns the first proposta in the ordered set where identificador = &#63; and groupId = &#63;.
     *
     * @param identificador the identificador
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching proposta, or <code>null</code> if a matching proposta could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta fetchByI_G_First(String identificador, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Proposta> list = findByI_G(identificador, groupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last proposta in the ordered set where identificador = &#63; and groupId = &#63;.
     *
     * @param identificador the identificador
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching proposta
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a matching proposta could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta findByI_G_Last(String identificador, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchPropostaException, SystemException {
        Proposta proposta = fetchByI_G_Last(identificador, groupId,
                orderByComparator);

        if (proposta != null) {
            return proposta;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("identificador=");
        msg.append(identificador);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPropostaException(msg.toString());
    }

    /**
     * Returns the last proposta in the ordered set where identificador = &#63; and groupId = &#63;.
     *
     * @param identificador the identificador
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching proposta, or <code>null</code> if a matching proposta could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta fetchByI_G_Last(String identificador, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByI_G(identificador, groupId);

        List<Proposta> list = findByI_G(identificador, groupId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the propostas before and after the current proposta in the ordered set where identificador = &#63; and groupId = &#63;.
     *
     * @param propostaId the primary key of the current proposta
     * @param identificador the identificador
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next proposta
     * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a proposta with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Proposta[] findByI_G_PrevAndNext(long propostaId,
        String identificador, long groupId, OrderByComparator orderByComparator)
        throws NoSuchPropostaException, SystemException {
        Proposta proposta = findByPrimaryKey(propostaId);

        Session session = null;

        try {
            session = openSession();

            Proposta[] array = new PropostaImpl[3];

            array[0] = getByI_G_PrevAndNext(session, proposta, identificador,
                    groupId, orderByComparator, true);

            array[1] = proposta;

            array[2] = getByI_G_PrevAndNext(session, proposta, identificador,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Proposta getByI_G_PrevAndNext(Session session, Proposta proposta,
        String identificador, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_PROPOSTA_WHERE);

        if (identificador == null) {
            query.append(_FINDER_COLUMN_I_G_IDENTIFICADOR_1);
        } else {
            if (identificador.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_I_G_IDENTIFICADOR_3);
            } else {
                query.append(_FINDER_COLUMN_I_G_IDENTIFICADOR_2);
            }
        }

        query.append(_FINDER_COLUMN_I_G_GROUPID_2);

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

        if (identificador != null) {
            qPos.add(identificador);
        }

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(proposta);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Proposta> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the propostas.
     *
     * @return the propostas
     * @throws SystemException if a system exception occurred
     */
    public List<Proposta> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the propostas.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of propostas
     * @param end the upper bound of the range of propostas (not inclusive)
     * @return the range of propostas
     * @throws SystemException if a system exception occurred
     */
    public List<Proposta> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the propostas.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of propostas
     * @param end the upper bound of the range of propostas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of propostas
     * @throws SystemException if a system exception occurred
     */
    public List<Proposta> findAll(int start, int end,
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

        List<Proposta> list = (List<Proposta>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_PROPOSTA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_PROPOSTA;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Proposta>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Proposta>) QueryUtil.list(q, getDialect(),
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
     * Removes all the propostas where eixoId = &#63; from the database.
     *
     * @param eixoId the eixo ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByE(long eixoId) throws SystemException {
        for (Proposta proposta : findByE(eixoId)) {
            remove(proposta);
        }
    }

    /**
     * Removes all the propostas where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByG(long groupId) throws SystemException {
        for (Proposta proposta : findByG(groupId)) {
            remove(proposta);
        }
    }

    /**
     * Removes all the propostas where identificador = &#63; and groupId = &#63; from the database.
     *
     * @param identificador the identificador
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByI_G(String identificador, long groupId)
        throws SystemException {
        for (Proposta proposta : findByI_G(identificador, groupId)) {
            remove(proposta);
        }
    }

    /**
     * Removes all the propostas from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Proposta proposta : findAll()) {
            remove(proposta);
        }
    }

    /**
     * Returns the number of propostas where eixoId = &#63;.
     *
     * @param eixoId the eixo ID
     * @return the number of matching propostas
     * @throws SystemException if a system exception occurred
     */
    public int countByE(long eixoId) throws SystemException {
        Object[] finderArgs = new Object[] { eixoId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_E,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PROPOSTA_WHERE);

            query.append(_FINDER_COLUMN_E_EIXOID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(eixoId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_E, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of propostas where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching propostas
     * @throws SystemException if a system exception occurred
     */
    public int countByG(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_PROPOSTA_WHERE);

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
     * Returns the number of propostas where identificador = &#63; and groupId = &#63;.
     *
     * @param identificador the identificador
     * @param groupId the group ID
     * @return the number of matching propostas
     * @throws SystemException if a system exception occurred
     */
    public int countByI_G(String identificador, long groupId)
        throws SystemException {
        Object[] finderArgs = new Object[] { identificador, groupId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_I_G,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_PROPOSTA_WHERE);

            if (identificador == null) {
                query.append(_FINDER_COLUMN_I_G_IDENTIFICADOR_1);
            } else {
                if (identificador.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_I_G_IDENTIFICADOR_3);
                } else {
                    query.append(_FINDER_COLUMN_I_G_IDENTIFICADOR_2);
                }
            }

            query.append(_FINDER_COLUMN_I_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (identificador != null) {
                    qPos.add(identificador);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_I_G, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of propostas.
     *
     * @return the number of propostas
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_PROPOSTA);

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
     * Initializes the proposta persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Proposta>> listenersList = new ArrayList<ModelListener<Proposta>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Proposta>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PropostaImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
