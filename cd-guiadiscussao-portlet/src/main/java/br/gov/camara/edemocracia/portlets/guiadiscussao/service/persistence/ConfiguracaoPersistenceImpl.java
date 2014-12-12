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

import br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchConfiguracaoException;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.ConfiguracaoImpl;
import br.gov.camara.edemocracia.portlets.guiadiscussao.model.impl.ConfiguracaoModelImpl;
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
 * The persistence implementation for the configuracao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robson
 * @see ConfiguracaoPersistence
 * @see ConfiguracaoUtil
 * @generated
 */
public class ConfiguracaoPersistenceImpl extends BasePersistenceImpl<Configuracao>
    implements ConfiguracaoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ConfiguracaoUtil} to access the configuracao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ConfiguracaoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_GROUPID = new FinderPath(ConfiguracaoModelImpl.ENTITY_CACHE_ENABLED,
            ConfiguracaoModelImpl.FINDER_CACHE_ENABLED, ConfiguracaoImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByGroupId",
            new String[] { Long.class.getName() },
            ConfiguracaoModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ConfiguracaoModelImpl.ENTITY_CACHE_ENABLED,
            ConfiguracaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConfiguracaoModelImpl.ENTITY_CACHE_ENABLED,
            ConfiguracaoModelImpl.FINDER_CACHE_ENABLED, ConfiguracaoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConfiguracaoModelImpl.ENTITY_CACHE_ENABLED,
            ConfiguracaoModelImpl.FINDER_CACHE_ENABLED, ConfiguracaoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConfiguracaoModelImpl.ENTITY_CACHE_ENABLED,
            ConfiguracaoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CONFIGURACAO = "SELECT configuracao FROM Configuracao configuracao";
    private static final String _SQL_SELECT_CONFIGURACAO_WHERE = "SELECT configuracao FROM Configuracao configuracao WHERE ";
    private static final String _SQL_COUNT_CONFIGURACAO = "SELECT COUNT(configuracao) FROM Configuracao configuracao";
    private static final String _SQL_COUNT_CONFIGURACAO_WHERE = "SELECT COUNT(configuracao) FROM Configuracao configuracao WHERE ";
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "configuracao.groupId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "configuracao.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Configuracao exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Configuracao exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ConfiguracaoPersistenceImpl.class);
    private static Configuracao _nullConfiguracao = new ConfiguracaoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Configuracao> toCacheModel() {
                return _nullConfiguracaoCacheModel;
            }
        };

    private static CacheModel<Configuracao> _nullConfiguracaoCacheModel = new CacheModel<Configuracao>() {
            public Configuracao toEntityModel() {
                return _nullConfiguracao;
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
     * Caches the configuracao in the entity cache if it is enabled.
     *
     * @param configuracao the configuracao
     */
    public void cacheResult(Configuracao configuracao) {
        EntityCacheUtil.putResult(ConfiguracaoModelImpl.ENTITY_CACHE_ENABLED,
            ConfiguracaoImpl.class, configuracao.getPrimaryKey(), configuracao);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
            new Object[] { Long.valueOf(configuracao.getGroupId()) },
            configuracao);

        configuracao.resetOriginalValues();
    }

    /**
     * Caches the configuracaos in the entity cache if it is enabled.
     *
     * @param configuracaos the configuracaos
     */
    public void cacheResult(List<Configuracao> configuracaos) {
        for (Configuracao configuracao : configuracaos) {
            if (EntityCacheUtil.getResult(
                        ConfiguracaoModelImpl.ENTITY_CACHE_ENABLED,
                        ConfiguracaoImpl.class, configuracao.getPrimaryKey()) == null) {
                cacheResult(configuracao);
            } else {
                configuracao.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all configuracaos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ConfiguracaoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ConfiguracaoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the configuracao.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Configuracao configuracao) {
        EntityCacheUtil.removeResult(ConfiguracaoModelImpl.ENTITY_CACHE_ENABLED,
            ConfiguracaoImpl.class, configuracao.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(configuracao);
    }

    @Override
    public void clearCache(List<Configuracao> configuracaos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Configuracao configuracao : configuracaos) {
            EntityCacheUtil.removeResult(ConfiguracaoModelImpl.ENTITY_CACHE_ENABLED,
                ConfiguracaoImpl.class, configuracao.getPrimaryKey());

            clearUniqueFindersCache(configuracao);
        }
    }

    protected void clearUniqueFindersCache(Configuracao configuracao) {
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID,
            new Object[] { Long.valueOf(configuracao.getGroupId()) });
    }

    /**
     * Creates a new configuracao with the primary key. Does not add the configuracao to the database.
     *
     * @param configuracaoId the primary key for the new configuracao
     * @return the new configuracao
     */
    public Configuracao create(long configuracaoId) {
        Configuracao configuracao = new ConfiguracaoImpl();

        configuracao.setNew(true);
        configuracao.setPrimaryKey(configuracaoId);

        return configuracao;
    }

    /**
     * Removes the configuracao with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param configuracaoId the primary key of the configuracao
     * @return the configuracao that was removed
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchConfiguracaoException if a configuracao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Configuracao remove(long configuracaoId)
        throws NoSuchConfiguracaoException, SystemException {
        return remove(Long.valueOf(configuracaoId));
    }

    /**
     * Removes the configuracao with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the configuracao
     * @return the configuracao that was removed
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchConfiguracaoException if a configuracao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Configuracao remove(Serializable primaryKey)
        throws NoSuchConfiguracaoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Configuracao configuracao = (Configuracao) session.get(ConfiguracaoImpl.class,
                    primaryKey);

            if (configuracao == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchConfiguracaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(configuracao);
        } catch (NoSuchConfiguracaoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Configuracao removeImpl(Configuracao configuracao)
        throws SystemException {
        configuracao = toUnwrappedModel(configuracao);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, configuracao);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(configuracao);

        return configuracao;
    }

    @Override
    public Configuracao updateImpl(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao configuracao,
        boolean merge) throws SystemException {
        configuracao = toUnwrappedModel(configuracao);

        boolean isNew = configuracao.isNew();

        ConfiguracaoModelImpl configuracaoModelImpl = (ConfiguracaoModelImpl) configuracao;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, configuracao, merge);

            configuracao.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ConfiguracaoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(ConfiguracaoModelImpl.ENTITY_CACHE_ENABLED,
            ConfiguracaoImpl.class, configuracao.getPrimaryKey(), configuracao);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
                new Object[] { Long.valueOf(configuracao.getGroupId()) },
                configuracao);
        } else {
            if ((configuracaoModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(configuracaoModelImpl.getOriginalGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID, args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
                    new Object[] { Long.valueOf(configuracao.getGroupId()) },
                    configuracao);
            }
        }

        return configuracao;
    }

    protected Configuracao toUnwrappedModel(Configuracao configuracao) {
        if (configuracao instanceof ConfiguracaoImpl) {
            return configuracao;
        }

        ConfiguracaoImpl configuracaoImpl = new ConfiguracaoImpl();

        configuracaoImpl.setNew(configuracao.isNew());
        configuracaoImpl.setPrimaryKey(configuracao.getPrimaryKey());

        configuracaoImpl.setConfiguracaoId(configuracao.getConfiguracaoId());
        configuracaoImpl.setGroupId(configuracao.getGroupId());
        configuracaoImpl.setFaseAtualId(configuracao.getFaseAtualId());
        configuracaoImpl.setTextoBanner(configuracao.getTextoBanner());
        configuracaoImpl.setImagemIdBanner(configuracao.getImagemIdBanner());
        configuracaoImpl.setUrlBanner(configuracao.getUrlBanner());
        configuracaoImpl.setUrlExterna(configuracao.isUrlExterna());
        configuracaoImpl.setTituloBanner(configuracao.getTituloBanner());

        return configuracaoImpl;
    }

    /**
     * Returns the configuracao with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the configuracao
     * @return the configuracao
     * @throws com.liferay.portal.NoSuchModelException if a configuracao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Configuracao findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the configuracao with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchConfiguracaoException} if it could not be found.
     *
     * @param configuracaoId the primary key of the configuracao
     * @return the configuracao
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchConfiguracaoException if a configuracao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Configuracao findByPrimaryKey(long configuracaoId)
        throws NoSuchConfiguracaoException, SystemException {
        Configuracao configuracao = fetchByPrimaryKey(configuracaoId);

        if (configuracao == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + configuracaoId);
            }

            throw new NoSuchConfiguracaoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                configuracaoId);
        }

        return configuracao;
    }

    /**
     * Returns the configuracao with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the configuracao
     * @return the configuracao, or <code>null</code> if a configuracao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Configuracao fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the configuracao with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param configuracaoId the primary key of the configuracao
     * @return the configuracao, or <code>null</code> if a configuracao with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Configuracao fetchByPrimaryKey(long configuracaoId)
        throws SystemException {
        Configuracao configuracao = (Configuracao) EntityCacheUtil.getResult(ConfiguracaoModelImpl.ENTITY_CACHE_ENABLED,
                ConfiguracaoImpl.class, configuracaoId);

        if (configuracao == _nullConfiguracao) {
            return null;
        }

        if (configuracao == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                configuracao = (Configuracao) session.get(ConfiguracaoImpl.class,
                        Long.valueOf(configuracaoId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (configuracao != null) {
                    cacheResult(configuracao);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ConfiguracaoModelImpl.ENTITY_CACHE_ENABLED,
                        ConfiguracaoImpl.class, configuracaoId,
                        _nullConfiguracao);
                }

                closeSession(session);
            }
        }

        return configuracao;
    }

    /**
     * Returns the configuracao where groupId = &#63; or throws a {@link br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchConfiguracaoException} if it could not be found.
     *
     * @param groupId the group ID
     * @return the matching configuracao
     * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchConfiguracaoException if a matching configuracao could not be found
     * @throws SystemException if a system exception occurred
     */
    public Configuracao findByGroupId(long groupId)
        throws NoSuchConfiguracaoException, SystemException {
        Configuracao configuracao = fetchByGroupId(groupId);

        if (configuracao == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchConfiguracaoException(msg.toString());
        }

        return configuracao;
    }

    /**
     * Returns the configuracao where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param groupId the group ID
     * @return the matching configuracao, or <code>null</code> if a matching configuracao could not be found
     * @throws SystemException if a system exception occurred
     */
    public Configuracao fetchByGroupId(long groupId) throws SystemException {
        return fetchByGroupId(groupId, true);
    }

    /**
     * Returns the configuracao where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching configuracao, or <code>null</code> if a matching configuracao could not be found
     * @throws SystemException if a system exception occurred
     */
    public Configuracao fetchByGroupId(long groupId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPID,
                    finderArgs, this);
        }

        if (result instanceof Configuracao) {
            Configuracao configuracao = (Configuracao) result;

            if ((groupId != configuracao.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_CONFIGURACAO_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                List<Configuracao> list = q.list();

                result = list;

                Configuracao configuracao = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
                        finderArgs, list);
                } else {
                    configuracao = list.get(0);

                    cacheResult(configuracao);

                    if ((configuracao.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
                            finderArgs, configuracao);
                    }
                }

                return configuracao;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (Configuracao) result;
            }
        }
    }

    /**
     * Returns all the configuracaos.
     *
     * @return the configuracaos
     * @throws SystemException if a system exception occurred
     */
    public List<Configuracao> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the configuracaos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of configuracaos
     * @param end the upper bound of the range of configuracaos (not inclusive)
     * @return the range of configuracaos
     * @throws SystemException if a system exception occurred
     */
    public List<Configuracao> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the configuracaos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of configuracaos
     * @param end the upper bound of the range of configuracaos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of configuracaos
     * @throws SystemException if a system exception occurred
     */
    public List<Configuracao> findAll(int start, int end,
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

        List<Configuracao> list = (List<Configuracao>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CONFIGURACAO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CONFIGURACAO;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Configuracao>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Configuracao>) QueryUtil.list(q, getDialect(),
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
     * Removes the configuracao where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @return the configuracao that was removed
     * @throws SystemException if a system exception occurred
     */
    public Configuracao removeByGroupId(long groupId)
        throws NoSuchConfiguracaoException, SystemException {
        Configuracao configuracao = findByGroupId(groupId);

        return remove(configuracao);
    }

    /**
     * Removes all the configuracaos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Configuracao configuracao : findAll()) {
            remove(configuracao);
        }
    }

    /**
     * Returns the number of configuracaos where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching configuracaos
     * @throws SystemException if a system exception occurred
     */
    public int countByGroupId(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONFIGURACAO_WHERE);

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
     * Returns the number of configuracaos.
     *
     * @return the number of configuracaos
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CONFIGURACAO);

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
     * Initializes the configuracao persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Configuracao>> listenersList = new ArrayList<ModelListener<Configuracao>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Configuracao>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ConfiguracaoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
