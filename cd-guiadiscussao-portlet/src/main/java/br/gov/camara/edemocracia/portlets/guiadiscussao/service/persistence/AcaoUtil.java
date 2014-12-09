package br.gov.camara.edemocracia.portlets.guiadiscussao.service.persistence;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the acao service. This utility wraps {@link AcaoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robson
 * @see AcaoPersistence
 * @see AcaoPersistenceImpl
 * @generated
 */
public class AcaoUtil {
    private static AcaoPersistence _persistence;

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
    public static void clearCache(Acao acao) {
        getPersistence().clearCache(acao);
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
    public static List<Acao> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Acao> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Acao> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Acao update(Acao acao, boolean merge)
        throws SystemException {
        return getPersistence().update(acao, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Acao update(Acao acao, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(acao, merge, serviceContext);
    }

    /**
    * Caches the acao in the entity cache if it is enabled.
    *
    * @param acao the acao
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao) {
        getPersistence().cacheResult(acao);
    }

    /**
    * Caches the acaos in the entity cache if it is enabled.
    *
    * @param acaos the acaos
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> acaos) {
        getPersistence().cacheResult(acaos);
    }

    /**
    * Creates a new acao with the primary key. Does not add the acao to the database.
    *
    * @param acaoId the primary key for the new acao
    * @return the new acao
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao create(
        long acaoId) {
        return getPersistence().create(acaoId);
    }

    /**
    * Removes the acao with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param acaoId the primary key of the acao
    * @return the acao that was removed
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException if a acao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao remove(
        long acaoId)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(acaoId);
    }

    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao updateImpl(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(acao, merge);
    }

    /**
    * Returns the acao with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException} if it could not be found.
    *
    * @param acaoId the primary key of the acao
    * @return the acao
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException if a acao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao findByPrimaryKey(
        long acaoId)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(acaoId);
    }

    /**
    * Returns the acao with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param acaoId the primary key of the acao
    * @return the acao, or <code>null</code> if a acao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao fetchByPrimaryKey(
        long acaoId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(acaoId);
    }

    /**
    * Returns all the acaos where faseId = &#63;.
    *
    * @param faseId the fase ID
    * @return the matching acaos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> findByFaseId(
        long faseId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFaseId(faseId);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> findByFaseId(
        long faseId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFaseId(faseId, start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> findByFaseId(
        long faseId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFaseId(faseId, start, end, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao findByFaseId_First(
        long faseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFaseId_First(faseId, orderByComparator);
    }

    /**
    * Returns the first acao in the ordered set where faseId = &#63;.
    *
    * @param faseId the fase ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching acao, or <code>null</code> if a matching acao could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao fetchByFaseId_First(
        long faseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByFaseId_First(faseId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao findByFaseId_Last(
        long faseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFaseId_Last(faseId, orderByComparator);
    }

    /**
    * Returns the last acao in the ordered set where faseId = &#63;.
    *
    * @param faseId the fase ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching acao, or <code>null</code> if a matching acao could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao fetchByFaseId_Last(
        long faseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByFaseId_Last(faseId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao[] findByFaseId_PrevAndNext(
        long acaoId, long faseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFaseId_PrevAndNext(acaoId, faseId, orderByComparator);
    }

    /**
    * Returns all the acaos.
    *
    * @return the acaos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the acaos where faseId = &#63; from the database.
    *
    * @param faseId the fase ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByFaseId(long faseId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByFaseId(faseId);
    }

    /**
    * Removes all the acaos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of acaos where faseId = &#63;.
    *
    * @param faseId the fase ID
    * @return the number of matching acaos
    * @throws SystemException if a system exception occurred
    */
    public static int countByFaseId(long faseId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByFaseId(faseId);
    }

    /**
    * Returns the number of acaos.
    *
    * @return the number of acaos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static AcaoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (AcaoPersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.guiadiscussao.service.ClpSerializer.getServletContextName(),
                    AcaoPersistence.class.getName());

            ReferenceRegistry.registerReference(AcaoUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(AcaoPersistence persistence) {
    }
}
