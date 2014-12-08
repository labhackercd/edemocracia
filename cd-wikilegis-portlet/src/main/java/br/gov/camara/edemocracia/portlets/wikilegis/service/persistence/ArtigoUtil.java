package br.gov.camara.edemocracia.portlets.wikilegis.service.persistence;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the artigo service. This utility wraps {@link ArtigoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see ArtigoPersistence
 * @see ArtigoPersistenceImpl
 * @generated
 */
public class ArtigoUtil {
    private static ArtigoPersistence _persistence;

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
    public static void clearCache(Artigo artigo) {
        getPersistence().clearCache(artigo);
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
    public static List<Artigo> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Artigo> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Artigo> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Artigo update(Artigo artigo, boolean merge)
        throws SystemException {
        return getPersistence().update(artigo, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Artigo update(Artigo artigo, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(artigo, merge, serviceContext);
    }

    /**
    * Caches the artigo in the entity cache if it is enabled.
    *
    * @param artigo the artigo
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo) {
        getPersistence().cacheResult(artigo);
    }

    /**
    * Caches the artigos in the entity cache if it is enabled.
    *
    * @param artigos the artigos
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> artigos) {
        getPersistence().cacheResult(artigos);
    }

    /**
    * Creates a new artigo with the primary key. Does not add the artigo to the database.
    *
    * @param artigoId the primary key for the new artigo
    * @return the new artigo
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo create(
        long artigoId) {
        return getPersistence().create(artigoId);
    }

    /**
    * Removes the artigo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param artigoId the primary key of the artigo
    * @return the artigo that was removed
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a artigo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo remove(
        long artigoId)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(artigoId);
    }

    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo updateImpl(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(artigo, merge);
    }

    /**
    * Returns the artigo with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException} if it could not be found.
    *
    * @param artigoId the primary key of the artigo
    * @return the artigo
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a artigo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo findByPrimaryKey(
        long artigoId)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(artigoId);
    }

    /**
    * Returns the artigo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param artigoId the primary key of the artigo
    * @return the artigo, or <code>null</code> if a artigo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo fetchByPrimaryKey(
        long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(artigoId);
    }

    /**
    * Returns all the artigos where groupId = &#63; and estruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @return the matching artigos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> findByG_E(
        long groupId, long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_E(groupId, estruturaId);
    }

    /**
    * Returns a range of all the artigos where groupId = &#63; and estruturaId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @param start the lower bound of the range of artigos
    * @param end the upper bound of the range of artigos (not inclusive)
    * @return the range of matching artigos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> findByG_E(
        long groupId, long estruturaId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_E(groupId, estruturaId, start, end);
    }

    /**
    * Returns an ordered range of all the artigos where groupId = &#63; and estruturaId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @param start the lower bound of the range of artigos
    * @param end the upper bound of the range of artigos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching artigos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> findByG_E(
        long groupId, long estruturaId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_E(groupId, estruturaId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first artigo in the ordered set where groupId = &#63; and estruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching artigo
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a matching artigo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo findByG_E_First(
        long groupId, long estruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_E_First(groupId, estruturaId, orderByComparator);
    }

    /**
    * Returns the first artigo in the ordered set where groupId = &#63; and estruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching artigo, or <code>null</code> if a matching artigo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo fetchByG_E_First(
        long groupId, long estruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_E_First(groupId, estruturaId, orderByComparator);
    }

    /**
    * Returns the last artigo in the ordered set where groupId = &#63; and estruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching artigo
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a matching artigo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo findByG_E_Last(
        long groupId, long estruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_E_Last(groupId, estruturaId, orderByComparator);
    }

    /**
    * Returns the last artigo in the ordered set where groupId = &#63; and estruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching artigo, or <code>null</code> if a matching artigo could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo fetchByG_E_Last(
        long groupId, long estruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_E_Last(groupId, estruturaId, orderByComparator);
    }

    /**
    * Returns the artigos before and after the current artigo in the ordered set where groupId = &#63; and estruturaId = &#63;.
    *
    * @param artigoId the primary key of the current artigo
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next artigo
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a artigo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo[] findByG_E_PrevAndNext(
        long artigoId, long groupId, long estruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_E_PrevAndNext(artigoId, groupId, estruturaId,
            orderByComparator);
    }

    /**
    * Returns all the artigos.
    *
    * @return the artigos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the artigos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of artigos
    * @param end the upper bound of the range of artigos (not inclusive)
    * @return the range of artigos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the artigos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of artigos
    * @param end the upper bound of the range of artigos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of artigos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the artigos where groupId = &#63; and estruturaId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_E(long groupId, long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_E(groupId, estruturaId);
    }

    /**
    * Removes all the artigos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of artigos where groupId = &#63; and estruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @return the number of matching artigos
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_E(long groupId, long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_E(groupId, estruturaId);
    }

    /**
    * Returns the number of artigos.
    *
    * @return the number of artigos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the contribuicaos associated with the artigo.
    *
    * @param pk the primary key of the artigo
    * @return the contribuicaos associated with the artigo
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> getContribuicaos(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getContribuicaos(pk);
    }

    /**
    * Returns a range of all the contribuicaos associated with the artigo.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the artigo
    * @param start the lower bound of the range of artigos
    * @param end the upper bound of the range of artigos (not inclusive)
    * @return the range of contribuicaos associated with the artigo
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> getContribuicaos(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getContribuicaos(pk, start, end);
    }

    /**
    * Returns an ordered range of all the contribuicaos associated with the artigo.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the artigo
    * @param start the lower bound of the range of artigos
    * @param end the upper bound of the range of artigos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of contribuicaos associated with the artigo
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> getContribuicaos(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .getContribuicaos(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of contribuicaos associated with the artigo.
    *
    * @param pk the primary key of the artigo
    * @return the number of contribuicaos associated with the artigo
    * @throws SystemException if a system exception occurred
    */
    public static int getContribuicaosSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getContribuicaosSize(pk);
    }

    /**
    * Returns <code>true</code> if the contribuicao is associated with the artigo.
    *
    * @param pk the primary key of the artigo
    * @param contribuicaoPK the primary key of the contribuicao
    * @return <code>true</code> if the contribuicao is associated with the artigo; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsContribuicao(long pk, long contribuicaoPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsContribuicao(pk, contribuicaoPK);
    }

    /**
    * Returns <code>true</code> if the artigo has any contribuicaos associated with it.
    *
    * @param pk the primary key of the artigo to check for associations with contribuicaos
    * @return <code>true</code> if the artigo has any contribuicaos associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsContribuicaos(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsContribuicaos(pk);
    }

    public static ArtigoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ArtigoPersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.wikilegis.service.ClpSerializer.getServletContextName(),
                    ArtigoPersistence.class.getName());

            ReferenceRegistry.registerReference(ArtigoUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(ArtigoPersistence persistence) {
    }
}
