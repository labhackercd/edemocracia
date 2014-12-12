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

import br.gov.camara.edemocracia.portlets.priorizacao.model.Voto;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the voto service. This utility wraps {@link VotoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see VotoPersistence
 * @see VotoPersistenceImpl
 * @generated
 */
public class VotoUtil {
    private static VotoPersistence _persistence;

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
    public static void clearCache(Voto voto) {
        getPersistence().clearCache(voto);
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
    public static List<Voto> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Voto> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Voto> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Voto update(Voto voto, boolean merge)
        throws SystemException {
        return getPersistence().update(voto, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Voto update(Voto voto, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(voto, merge, serviceContext);
    }

    /**
    * Caches the voto in the entity cache if it is enabled.
    *
    * @param voto the voto
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto) {
        getPersistence().cacheResult(voto);
    }

    /**
    * Caches the votos in the entity cache if it is enabled.
    *
    * @param votos the votos
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> votos) {
        getPersistence().cacheResult(votos);
    }

    /**
    * Creates a new voto with the primary key. Does not add the voto to the database.
    *
    * @param votoId the primary key for the new voto
    * @return the new voto
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto create(
        long votoId) {
        return getPersistence().create(votoId);
    }

    /**
    * Removes the voto with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param votoId the primary key of the voto
    * @return the voto that was removed
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a voto with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto remove(
        long votoId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(votoId);
    }

    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto updateImpl(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(voto, merge);
    }

    /**
    * Returns the voto with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException} if it could not be found.
    *
    * @param votoId the primary key of the voto
    * @return the voto
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a voto with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto findByPrimaryKey(
        long votoId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(votoId);
    }

    /**
    * Returns the voto with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param votoId the primary key of the voto
    * @return the voto, or <code>null</code> if a voto with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByPrimaryKey(
        long votoId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(votoId);
    }

    /**
    * Returns all the votos where propostaId = &#63;.
    *
    * @param propostaId the proposta ID
    * @return the matching votos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findByP(
        long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByP(propostaId);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findByP(
        long propostaId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByP(propostaId, start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findByP(
        long propostaId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByP(propostaId, start, end, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto findByP_First(
        long propostaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByP_First(propostaId, orderByComparator);
    }

    /**
    * Returns the first voto in the ordered set where propostaId = &#63;.
    *
    * @param propostaId the proposta ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching voto, or <code>null</code> if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByP_First(
        long propostaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByP_First(propostaId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto findByP_Last(
        long propostaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByP_Last(propostaId, orderByComparator);
    }

    /**
    * Returns the last voto in the ordered set where propostaId = &#63;.
    *
    * @param propostaId the proposta ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching voto, or <code>null</code> if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByP_Last(
        long propostaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByP_Last(propostaId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto[] findByP_PrevAndNext(
        long votoId, long propostaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByP_PrevAndNext(votoId, propostaId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto findByP_U(
        long propostaId, long userId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByP_U(propostaId, userId);
    }

    /**
    * Returns the voto where propostaId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param propostaId the proposta ID
    * @param userId the user ID
    * @return the matching voto, or <code>null</code> if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByP_U(
        long propostaId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByP_U(propostaId, userId);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByP_U(
        long propostaId, long userId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByP_U(propostaId, userId, retrieveFromCache);
    }

    /**
    * Returns all the votos where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching votos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findByU(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU(userId);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findByU(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU(userId, start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findByU(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU(userId, start, end, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto findByU_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_First(userId, orderByComparator);
    }

    /**
    * Returns the first voto in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching voto, or <code>null</code> if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByU_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByU_First(userId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto findByU_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByU_Last(userId, orderByComparator);
    }

    /**
    * Returns the last voto in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching voto, or <code>null</code> if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByU_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByU_Last(userId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto[] findByU_PrevAndNext(
        long votoId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByU_PrevAndNext(votoId, userId, orderByComparator);
    }

    /**
    * Returns all the votos.
    *
    * @return the votos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the votos where propostaId = &#63; from the database.
    *
    * @param propostaId the proposta ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByP(long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByP(propostaId);
    }

    /**
    * Removes the voto where propostaId = &#63; and userId = &#63; from the database.
    *
    * @param propostaId the proposta ID
    * @param userId the user ID
    * @return the voto that was removed
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto removeByP_U(
        long propostaId, long userId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByP_U(propostaId, userId);
    }

    /**
    * Removes all the votos where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByU(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByU(userId);
    }

    /**
    * Removes all the votos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of votos where propostaId = &#63;.
    *
    * @param propostaId the proposta ID
    * @return the number of matching votos
    * @throws SystemException if a system exception occurred
    */
    public static int countByP(long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByP(propostaId);
    }

    /**
    * Returns the number of votos where propostaId = &#63; and userId = &#63;.
    *
    * @param propostaId the proposta ID
    * @param userId the user ID
    * @return the number of matching votos
    * @throws SystemException if a system exception occurred
    */
    public static int countByP_U(long propostaId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByP_U(propostaId, userId);
    }

    /**
    * Returns the number of votos where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching votos
    * @throws SystemException if a system exception occurred
    */
    public static int countByU(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByU(userId);
    }

    /**
    * Returns the number of votos.
    *
    * @return the number of votos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static VotoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (VotoPersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.priorizacao.service.ClpSerializer.getServletContextName(),
                    VotoPersistence.class.getName());

            ReferenceRegistry.registerReference(VotoUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(VotoPersistence persistence) {
    }
}
