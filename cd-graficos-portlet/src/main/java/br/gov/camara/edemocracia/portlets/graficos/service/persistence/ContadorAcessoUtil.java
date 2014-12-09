package br.gov.camara.edemocracia.portlets.graficos.service.persistence;

import br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the contador acesso service. This utility wraps {@link ContadorAcessoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robson Miranda
 * @see ContadorAcessoPersistence
 * @see ContadorAcessoPersistenceImpl
 * @generated
 */
public class ContadorAcessoUtil {
    private static ContadorAcessoPersistence _persistence;

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
    public static void clearCache(ContadorAcesso contadorAcesso) {
        getPersistence().clearCache(contadorAcesso);
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
    public static List<ContadorAcesso> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ContadorAcesso> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ContadorAcesso> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static ContadorAcesso update(ContadorAcesso contadorAcesso,
        boolean merge) throws SystemException {
        return getPersistence().update(contadorAcesso, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static ContadorAcesso update(ContadorAcesso contadorAcesso,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(contadorAcesso, merge, serviceContext);
    }

    /**
    * Caches the contador acesso in the entity cache if it is enabled.
    *
    * @param contadorAcesso the contador acesso
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso contadorAcesso) {
        getPersistence().cacheResult(contadorAcesso);
    }

    /**
    * Caches the contador acessos in the entity cache if it is enabled.
    *
    * @param contadorAcessos the contador acessos
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso> contadorAcessos) {
        getPersistence().cacheResult(contadorAcessos);
    }

    /**
    * Creates a new contador acesso with the primary key. Does not add the contador acesso to the database.
    *
    * @param contadorId the primary key for the new contador acesso
    * @return the new contador acesso
    */
    public static br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso create(
        long contadorId) {
        return getPersistence().create(contadorId);
    }

    /**
    * Removes the contador acesso with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contadorId the primary key of the contador acesso
    * @return the contador acesso that was removed
    * @throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException if a contador acesso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso remove(
        long contadorId)
        throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(contadorId);
    }

    public static br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso updateImpl(
        br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso contadorAcesso,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(contadorAcesso, merge);
    }

    /**
    * Returns the contador acesso with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException} if it could not be found.
    *
    * @param contadorId the primary key of the contador acesso
    * @return the contador acesso
    * @throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException if a contador acesso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso findByPrimaryKey(
        long contadorId)
        throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(contadorId);
    }

    /**
    * Returns the contador acesso with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param contadorId the primary key of the contador acesso
    * @return the contador acesso, or <code>null</code> if a contador acesso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso fetchByPrimaryKey(
        long contadorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(contadorId);
    }

    /**
    * Returns all the contador acessos where companyId = &#63; and data = &#63;.
    *
    * @param companyId the company ID
    * @param data the data
    * @return the matching contador acessos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso> findByC_D(
        long companyId, java.util.Date data)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_D(companyId, data);
    }

    /**
    * Returns a range of all the contador acessos where companyId = &#63; and data = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param data the data
    * @param start the lower bound of the range of contador acessos
    * @param end the upper bound of the range of contador acessos (not inclusive)
    * @return the range of matching contador acessos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso> findByC_D(
        long companyId, java.util.Date data, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_D(companyId, data, start, end);
    }

    /**
    * Returns an ordered range of all the contador acessos where companyId = &#63; and data = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param data the data
    * @param start the lower bound of the range of contador acessos
    * @param end the upper bound of the range of contador acessos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contador acessos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso> findByC_D(
        long companyId, java.util.Date data, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_D(companyId, data, start, end, orderByComparator);
    }

    /**
    * Returns the first contador acesso in the ordered set where companyId = &#63; and data = &#63;.
    *
    * @param companyId the company ID
    * @param data the data
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contador acesso
    * @throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException if a matching contador acesso could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso findByC_D_First(
        long companyId, java.util.Date data,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_D_First(companyId, data, orderByComparator);
    }

    /**
    * Returns the first contador acesso in the ordered set where companyId = &#63; and data = &#63;.
    *
    * @param companyId the company ID
    * @param data the data
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contador acesso, or <code>null</code> if a matching contador acesso could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso fetchByC_D_First(
        long companyId, java.util.Date data,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_D_First(companyId, data, orderByComparator);
    }

    /**
    * Returns the last contador acesso in the ordered set where companyId = &#63; and data = &#63;.
    *
    * @param companyId the company ID
    * @param data the data
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contador acesso
    * @throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException if a matching contador acesso could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso findByC_D_Last(
        long companyId, java.util.Date data,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_D_Last(companyId, data, orderByComparator);
    }

    /**
    * Returns the last contador acesso in the ordered set where companyId = &#63; and data = &#63;.
    *
    * @param companyId the company ID
    * @param data the data
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contador acesso, or <code>null</code> if a matching contador acesso could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso fetchByC_D_Last(
        long companyId, java.util.Date data,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_D_Last(companyId, data, orderByComparator);
    }

    /**
    * Returns the contador acessos before and after the current contador acesso in the ordered set where companyId = &#63; and data = &#63;.
    *
    * @param contadorId the primary key of the current contador acesso
    * @param companyId the company ID
    * @param data the data
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contador acesso
    * @throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException if a contador acesso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso[] findByC_D_PrevAndNext(
        long contadorId, long companyId, java.util.Date data,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.graficos.NoSuchContadorAcessoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_D_PrevAndNext(contadorId, companyId, data,
            orderByComparator);
    }

    /**
    * Returns all the contador acessos.
    *
    * @return the contador acessos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the contador acessos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of contador acessos
    * @param end the upper bound of the range of contador acessos (not inclusive)
    * @return the range of contador acessos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the contador acessos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of contador acessos
    * @param end the upper bound of the range of contador acessos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of contador acessos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the contador acessos where companyId = &#63; and data = &#63; from the database.
    *
    * @param companyId the company ID
    * @param data the data
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_D(long companyId, java.util.Date data)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_D(companyId, data);
    }

    /**
    * Removes all the contador acessos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of contador acessos where companyId = &#63; and data = &#63;.
    *
    * @param companyId the company ID
    * @param data the data
    * @return the number of matching contador acessos
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_D(long companyId, java.util.Date data)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_D(companyId, data);
    }

    /**
    * Returns the number of contador acessos.
    *
    * @return the number of contador acessos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ContadorAcessoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ContadorAcessoPersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.graficos.service.ClpSerializer.getServletContextName(),
                    ContadorAcessoPersistence.class.getName());

            ReferenceRegistry.registerReference(ContadorAcessoUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(ContadorAcessoPersistence persistence) {
    }
}
