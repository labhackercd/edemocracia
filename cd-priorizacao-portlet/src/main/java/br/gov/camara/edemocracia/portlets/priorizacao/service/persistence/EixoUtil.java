package br.gov.camara.edemocracia.portlets.priorizacao.service.persistence;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the eixo service. This utility wraps {@link EixoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see EixoPersistence
 * @see EixoPersistenceImpl
 * @generated
 */
public class EixoUtil {
    private static EixoPersistence _persistence;

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
    public static void clearCache(Eixo eixo) {
        getPersistence().clearCache(eixo);
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
    public static List<Eixo> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Eixo> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Eixo> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Eixo update(Eixo eixo, boolean merge)
        throws SystemException {
        return getPersistence().update(eixo, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Eixo update(Eixo eixo, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(eixo, merge, serviceContext);
    }

    /**
    * Caches the eixo in the entity cache if it is enabled.
    *
    * @param eixo the eixo
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo) {
        getPersistence().cacheResult(eixo);
    }

    /**
    * Caches the eixos in the entity cache if it is enabled.
    *
    * @param eixos the eixos
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> eixos) {
        getPersistence().cacheResult(eixos);
    }

    /**
    * Creates a new eixo with the primary key. Does not add the eixo to the database.
    *
    * @param eixoId the primary key for the new eixo
    * @return the new eixo
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo create(
        long eixoId) {
        return getPersistence().create(eixoId);
    }

    /**
    * Removes the eixo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param eixoId the primary key of the eixo
    * @return the eixo that was removed
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException if a eixo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo remove(
        long eixoId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(eixoId);
    }

    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo updateImpl(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(eixo, merge);
    }

    /**
    * Returns the eixo with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException} if it could not be found.
    *
    * @param eixoId the primary key of the eixo
    * @return the eixo
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException if a eixo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo findByPrimaryKey(
        long eixoId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(eixoId);
    }

    /**
    * Returns the eixo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param eixoId the primary key of the eixo
    * @return the eixo, or <code>null</code> if a eixo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo fetchByPrimaryKey(
        long eixoId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(eixoId);
    }

    /**
    * Returns all the eixos where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching eixos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> findByG(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG(groupId);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> findByG(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG(groupId, start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> findByG(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG(groupId, start, end, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo findByG_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_First(groupId, orderByComparator);
    }

    /**
    * Returns the first eixo in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching eixo, or <code>null</code> if a matching eixo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo fetchByG_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByG_First(groupId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo findByG_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last eixo in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching eixo, or <code>null</code> if a matching eixo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo fetchByG_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByG_Last(groupId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo[] findByG_PrevAndNext(
        long eixoId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_PrevAndNext(eixoId, groupId, orderByComparator);
    }

    /**
    * Returns all the eixos.
    *
    * @return the eixos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the eixos where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG(groupId);
    }

    /**
    * Removes all the eixos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of eixos where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching eixos
    * @throws SystemException if a system exception occurred
    */
    public static int countByG(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG(groupId);
    }

    /**
    * Returns the number of eixos.
    *
    * @return the number of eixos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EixoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EixoPersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.priorizacao.service.ClpSerializer.getServletContextName(),
                    EixoPersistence.class.getName());

            ReferenceRegistry.registerReference(EixoUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(EixoPersistence persistence) {
    }
}
