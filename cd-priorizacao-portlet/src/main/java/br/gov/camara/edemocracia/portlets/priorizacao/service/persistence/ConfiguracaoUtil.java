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

import br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the configuracao service. This utility wraps {@link ConfiguracaoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see ConfiguracaoPersistence
 * @see ConfiguracaoPersistenceImpl
 * @generated
 */
public class ConfiguracaoUtil {
    private static ConfiguracaoPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Configuracao configuracao) {
        getPersistence().clearCache(configuracao);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Configuracao> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Configuracao> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Configuracao> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Configuracao update(Configuracao configuracao, boolean merge)
        throws SystemException {
        return getPersistence().update(configuracao, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Configuracao update(Configuracao configuracao, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(configuracao, merge, serviceContext);
    }

    /**
    * Caches the configuracao in the entity cache if it is enabled.
    *
    * @param configuracao the configuracao
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao configuracao) {
        getPersistence().cacheResult(configuracao);
    }

    /**
    * Caches the configuracaos in the entity cache if it is enabled.
    *
    * @param configuracaos the configuracaos
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao> configuracaos) {
        getPersistence().cacheResult(configuracaos);
    }

    /**
    * Creates a new configuracao with the primary key. Does not add the configuracao to the database.
    *
    * @param configuracaoId the primary key for the new configuracao
    * @return the new configuracao
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao create(
        long configuracaoId) {
        return getPersistence().create(configuracaoId);
    }

    /**
    * Removes the configuracao with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param configuracaoId the primary key of the configuracao
    * @return the configuracao that was removed
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException if a configuracao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao remove(
        long configuracaoId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(configuracaoId);
    }

    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao updateImpl(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao configuracao,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(configuracao, merge);
    }

    /**
    * Returns the configuracao with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException} if it could not be found.
    *
    * @param configuracaoId the primary key of the configuracao
    * @return the configuracao
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException if a configuracao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao findByPrimaryKey(
        long configuracaoId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(configuracaoId);
    }

    /**
    * Returns the configuracao with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param configuracaoId the primary key of the configuracao
    * @return the configuracao, or <code>null</code> if a configuracao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao fetchByPrimaryKey(
        long configuracaoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(configuracaoId);
    }

    /**
    * Returns the configuracao where groupId = &#63; or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException} if it could not be found.
    *
    * @param groupId the group ID
    * @return the matching configuracao
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException if a matching configuracao could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao findByG(
        long groupId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG(groupId);
    }

    /**
    * Returns the configuracao where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param groupId the group ID
    * @return the matching configuracao, or <code>null</code> if a matching configuracao could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao fetchByG(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByG(groupId);
    }

    /**
    * Returns the configuracao where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching configuracao, or <code>null</code> if a matching configuracao could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao fetchByG(
        long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByG(groupId, retrieveFromCache);
    }

    /**
    * Returns all the configuracaos.
    *
    * @return the configuracaos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes the configuracao where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @return the configuracao that was removed
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao removeByG(
        long groupId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByG(groupId);
    }

    /**
    * Removes all the configuracaos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of configuracaos where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching configuracaos
    * @throws SystemException if a system exception occurred
    */
    public static int countByG(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG(groupId);
    }

    /**
    * Returns the number of configuracaos.
    *
    * @return the number of configuracaos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ConfiguracaoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ConfiguracaoPersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.priorizacao.service.ClpSerializer.getServletContextName(),
                    ConfiguracaoPersistence.class.getName());

            ReferenceRegistry.registerReference(ConfiguracaoUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(ConfiguracaoPersistence persistence) {
    }
}
