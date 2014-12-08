package br.gov.camara.edemocracia.portlets.wikilegis.service.persistence;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the estrutura service. This utility wraps {@link EstruturaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see EstruturaPersistence
 * @see EstruturaPersistenceImpl
 * @generated
 */
public class EstruturaUtil {
    private static EstruturaPersistence _persistence;

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
    public static void clearCache(Estrutura estrutura) {
        getPersistence().clearCache(estrutura);
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
    public static List<Estrutura> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Estrutura> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Estrutura> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Estrutura update(Estrutura estrutura, boolean merge)
        throws SystemException {
        return getPersistence().update(estrutura, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Estrutura update(Estrutura estrutura, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(estrutura, merge, serviceContext);
    }

    /**
    * Caches the estrutura in the entity cache if it is enabled.
    *
    * @param estrutura the estrutura
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura) {
        getPersistence().cacheResult(estrutura);
    }

    /**
    * Caches the estruturas in the entity cache if it is enabled.
    *
    * @param estruturas the estruturas
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> estruturas) {
        getPersistence().cacheResult(estruturas);
    }

    /**
    * Creates a new estrutura with the primary key. Does not add the estrutura to the database.
    *
    * @param estruturaId the primary key for the new estrutura
    * @return the new estrutura
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura create(
        long estruturaId) {
        return getPersistence().create(estruturaId);
    }

    /**
    * Removes the estrutura with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param estruturaId the primary key of the estrutura
    * @return the estrutura that was removed
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura remove(
        long estruturaId)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(estruturaId);
    }

    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura updateImpl(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(estrutura, merge);
    }

    /**
    * Returns the estrutura with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException} if it could not be found.
    *
    * @param estruturaId the primary key of the estrutura
    * @return the estrutura
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura findByPrimaryKey(
        long estruturaId)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(estruturaId);
    }

    /**
    * Returns the estrutura with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param estruturaId the primary key of the estrutura
    * @return the estrutura, or <code>null</code> if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura fetchByPrimaryKey(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(estruturaId);
    }

    /**
    * Returns all the estruturas where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @return the matching estruturas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> findByG_P(
        long groupId, long paiEstruturaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_P(groupId, paiEstruturaId);
    }

    /**
    * Returns a range of all the estruturas where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @param start the lower bound of the range of estruturas
    * @param end the upper bound of the range of estruturas (not inclusive)
    * @return the range of matching estruturas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> findByG_P(
        long groupId, long paiEstruturaId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_P(groupId, paiEstruturaId, start, end);
    }

    /**
    * Returns an ordered range of all the estruturas where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @param start the lower bound of the range of estruturas
    * @param end the upper bound of the range of estruturas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching estruturas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> findByG_P(
        long groupId, long paiEstruturaId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_P(groupId, paiEstruturaId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first estrutura in the ordered set where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching estrutura
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException if a matching estrutura could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura findByG_P_First(
        long groupId, long paiEstruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_P_First(groupId, paiEstruturaId, orderByComparator);
    }

    /**
    * Returns the first estrutura in the ordered set where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching estrutura, or <code>null</code> if a matching estrutura could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura fetchByG_P_First(
        long groupId, long paiEstruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_P_First(groupId, paiEstruturaId, orderByComparator);
    }

    /**
    * Returns the last estrutura in the ordered set where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching estrutura
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException if a matching estrutura could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura findByG_P_Last(
        long groupId, long paiEstruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_P_Last(groupId, paiEstruturaId, orderByComparator);
    }

    /**
    * Returns the last estrutura in the ordered set where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching estrutura, or <code>null</code> if a matching estrutura could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura fetchByG_P_Last(
        long groupId, long paiEstruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_P_Last(groupId, paiEstruturaId, orderByComparator);
    }

    /**
    * Returns the estruturas before and after the current estrutura in the ordered set where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * @param estruturaId the primary key of the current estrutura
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next estrutura
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura[] findByG_P_PrevAndNext(
        long estruturaId, long groupId, long paiEstruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_P_PrevAndNext(estruturaId, groupId, paiEstruturaId,
            orderByComparator);
    }

    /**
    * Returns all the estruturas.
    *
    * @return the estruturas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the estruturas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of estruturas
    * @param end the upper bound of the range of estruturas (not inclusive)
    * @return the range of estruturas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the estruturas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of estruturas
    * @param end the upper bound of the range of estruturas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of estruturas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the estruturas where groupId = &#63; and paiEstruturaId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_P(long groupId, long paiEstruturaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_P(groupId, paiEstruturaId);
    }

    /**
    * Removes all the estruturas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of estruturas where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @return the number of matching estruturas
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_P(long groupId, long paiEstruturaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_P(groupId, paiEstruturaId);
    }

    /**
    * Returns the number of estruturas.
    *
    * @return the number of estruturas
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EstruturaPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EstruturaPersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.wikilegis.service.ClpSerializer.getServletContextName(),
                    EstruturaPersistence.class.getName());

            ReferenceRegistry.registerReference(EstruturaUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(EstruturaPersistence persistence) {
    }
}
