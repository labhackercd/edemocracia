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

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the fase service. This utility wraps {@link FasePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robson
 * @see FasePersistence
 * @see FasePersistenceImpl
 * @generated
 */
public class FaseUtil {
    private static FasePersistence _persistence;

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
    public static void clearCache(Fase fase) {
        getPersistence().clearCache(fase);
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
    public static List<Fase> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Fase> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Fase> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Fase update(Fase fase, boolean merge)
        throws SystemException {
        return getPersistence().update(fase, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Fase update(Fase fase, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(fase, merge, serviceContext);
    }

    /**
    * Caches the fase in the entity cache if it is enabled.
    *
    * @param fase the fase
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fase) {
        getPersistence().cacheResult(fase);
    }

    /**
    * Caches the fases in the entity cache if it is enabled.
    *
    * @param fases the fases
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> fases) {
        getPersistence().cacheResult(fases);
    }

    /**
    * Creates a new fase with the primary key. Does not add the fase to the database.
    *
    * @param faseId the primary key for the new fase
    * @return the new fase
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase create(
        long faseId) {
        return getPersistence().create(faseId);
    }

    /**
    * Removes the fase with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param faseId the primary key of the fase
    * @return the fase that was removed
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a fase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase remove(
        long faseId)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(faseId);
    }

    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase updateImpl(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fase,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(fase, merge);
    }

    /**
    * Returns the fase with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException} if it could not be found.
    *
    * @param faseId the primary key of the fase
    * @return the fase
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a fase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase findByPrimaryKey(
        long faseId)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(faseId);
    }

    /**
    * Returns the fase with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param faseId the primary key of the fase
    * @return the fase, or <code>null</code> if a fase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fetchByPrimaryKey(
        long faseId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(faseId);
    }

    /**
    * Returns all the fases where configuracaoId = &#63;.
    *
    * @param configuracaoId the configuracao ID
    * @return the matching fases
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> findByConfiguracaoId(
        long configuracaoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByConfiguracaoId(configuracaoId);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> findByConfiguracaoId(
        long configuracaoId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByConfiguracaoId(configuracaoId, start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> findByConfiguracaoId(
        long configuracaoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByConfiguracaoId(configuracaoId, start, end,
            orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase findByConfiguracaoId_First(
        long configuracaoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByConfiguracaoId_First(configuracaoId, orderByComparator);
    }

    /**
    * Returns the first fase in the ordered set where configuracaoId = &#63;.
    *
    * @param configuracaoId the configuracao ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching fase, or <code>null</code> if a matching fase could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fetchByConfiguracaoId_First(
        long configuracaoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByConfiguracaoId_First(configuracaoId,
            orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase findByConfiguracaoId_Last(
        long configuracaoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByConfiguracaoId_Last(configuracaoId, orderByComparator);
    }

    /**
    * Returns the last fase in the ordered set where configuracaoId = &#63;.
    *
    * @param configuracaoId the configuracao ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching fase, or <code>null</code> if a matching fase could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fetchByConfiguracaoId_Last(
        long configuracaoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByConfiguracaoId_Last(configuracaoId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase[] findByConfiguracaoId_PrevAndNext(
        long faseId, long configuracaoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByConfiguracaoId_PrevAndNext(faseId, configuracaoId,
            orderByComparator);
    }

    /**
    * Returns all the fases.
    *
    * @return the fases
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the fases where configuracaoId = &#63; from the database.
    *
    * @param configuracaoId the configuracao ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByConfiguracaoId(long configuracaoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByConfiguracaoId(configuracaoId);
    }

    /**
    * Removes all the fases from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of fases where configuracaoId = &#63;.
    *
    * @param configuracaoId the configuracao ID
    * @return the number of matching fases
    * @throws SystemException if a system exception occurred
    */
    public static int countByConfiguracaoId(long configuracaoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByConfiguracaoId(configuracaoId);
    }

    /**
    * Returns the number of fases.
    *
    * @return the number of fases
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static FasePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (FasePersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.guiadiscussao.service.ClpSerializer.getServletContextName(),
                    FasePersistence.class.getName());

            ReferenceRegistry.registerReference(FaseUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(FasePersistence persistence) {
    }
}
