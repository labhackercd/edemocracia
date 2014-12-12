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

import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the proposta service. This utility wraps {@link PropostaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see PropostaPersistence
 * @see PropostaPersistenceImpl
 * @generated
 */
public class PropostaUtil {
    private static PropostaPersistence _persistence;

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
    public static void clearCache(Proposta proposta) {
        getPersistence().clearCache(proposta);
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
    public static List<Proposta> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Proposta> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Proposta> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Proposta update(Proposta proposta, boolean merge)
        throws SystemException {
        return getPersistence().update(proposta, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Proposta update(Proposta proposta, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(proposta, merge, serviceContext);
    }

    /**
    * Caches the proposta in the entity cache if it is enabled.
    *
    * @param proposta the proposta
    */
    public static void cacheResult(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta proposta) {
        getPersistence().cacheResult(proposta);
    }

    /**
    * Caches the propostas in the entity cache if it is enabled.
    *
    * @param propostas the propostas
    */
    public static void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> propostas) {
        getPersistence().cacheResult(propostas);
    }

    /**
    * Creates a new proposta with the primary key. Does not add the proposta to the database.
    *
    * @param propostaId the primary key for the new proposta
    * @return the new proposta
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta create(
        long propostaId) {
        return getPersistence().create(propostaId);
    }

    /**
    * Removes the proposta with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param propostaId the primary key of the proposta
    * @return the proposta that was removed
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a proposta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta remove(
        long propostaId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(propostaId);
    }

    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta updateImpl(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta proposta,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(proposta, merge);
    }

    /**
    * Returns the proposta with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException} if it could not be found.
    *
    * @param propostaId the primary key of the proposta
    * @return the proposta
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a proposta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByPrimaryKey(
        long propostaId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(propostaId);
    }

    /**
    * Returns the proposta with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param propostaId the primary key of the proposta
    * @return the proposta, or <code>null</code> if a proposta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByPrimaryKey(
        long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(propostaId);
    }

    /**
    * Returns all the propostas where eixoId = &#63;.
    *
    * @param eixoId the eixo ID
    * @return the matching propostas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByE(
        long eixoId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByE(eixoId);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByE(
        long eixoId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByE(eixoId, start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByE(
        long eixoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByE(eixoId, start, end, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByE_First(
        long eixoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByE_First(eixoId, orderByComparator);
    }

    /**
    * Returns the first proposta in the ordered set where eixoId = &#63;.
    *
    * @param eixoId the eixo ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposta, or <code>null</code> if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByE_First(
        long eixoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByE_First(eixoId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByE_Last(
        long eixoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByE_Last(eixoId, orderByComparator);
    }

    /**
    * Returns the last proposta in the ordered set where eixoId = &#63;.
    *
    * @param eixoId the eixo ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposta, or <code>null</code> if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByE_Last(
        long eixoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByE_Last(eixoId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta[] findByE_PrevAndNext(
        long propostaId, long eixoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByE_PrevAndNext(propostaId, eixoId, orderByComparator);
    }

    /**
    * Returns all the propostas where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching propostas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByG(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG(groupId);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByG(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG(groupId, start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByG(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG(groupId, start, end, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByG_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_First(groupId, orderByComparator);
    }

    /**
    * Returns the first proposta in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposta, or <code>null</code> if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByG_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByG_First(groupId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByG_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last proposta in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposta, or <code>null</code> if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByG_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByG_Last(groupId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta[] findByG_PrevAndNext(
        long propostaId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_PrevAndNext(propostaId, groupId, orderByComparator);
    }

    /**
    * Returns all the propostas where identificador = &#63; and groupId = &#63;.
    *
    * @param identificador the identificador
    * @param groupId the group ID
    * @return the matching propostas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByI_G(
        java.lang.String identificador, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByI_G(identificador, groupId);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByI_G(
        java.lang.String identificador, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByI_G(identificador, groupId, start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByI_G(
        java.lang.String identificador, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByI_G(identificador, groupId, start, end,
            orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByI_G_First(
        java.lang.String identificador, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByI_G_First(identificador, groupId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByI_G_First(
        java.lang.String identificador, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByI_G_First(identificador, groupId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByI_G_Last(
        java.lang.String identificador, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByI_G_Last(identificador, groupId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByI_G_Last(
        java.lang.String identificador, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByI_G_Last(identificador, groupId, orderByComparator);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta[] findByI_G_PrevAndNext(
        long propostaId, java.lang.String identificador, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByI_G_PrevAndNext(propostaId, identificador, groupId,
            orderByComparator);
    }

    /**
    * Returns all the propostas.
    *
    * @return the propostas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the propostas where eixoId = &#63; from the database.
    *
    * @param eixoId the eixo ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByE(long eixoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByE(eixoId);
    }

    /**
    * Removes all the propostas where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG(groupId);
    }

    /**
    * Removes all the propostas where identificador = &#63; and groupId = &#63; from the database.
    *
    * @param identificador the identificador
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByI_G(java.lang.String identificador, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByI_G(identificador, groupId);
    }

    /**
    * Removes all the propostas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of propostas where eixoId = &#63;.
    *
    * @param eixoId the eixo ID
    * @return the number of matching propostas
    * @throws SystemException if a system exception occurred
    */
    public static int countByE(long eixoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByE(eixoId);
    }

    /**
    * Returns the number of propostas where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching propostas
    * @throws SystemException if a system exception occurred
    */
    public static int countByG(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG(groupId);
    }

    /**
    * Returns the number of propostas where identificador = &#63; and groupId = &#63;.
    *
    * @param identificador the identificador
    * @param groupId the group ID
    * @return the number of matching propostas
    * @throws SystemException if a system exception occurred
    */
    public static int countByI_G(java.lang.String identificador, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByI_G(identificador, groupId);
    }

    /**
    * Returns the number of propostas.
    *
    * @return the number of propostas
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PropostaPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PropostaPersistence) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.priorizacao.service.ClpSerializer.getServletContextName(),
                    PropostaPersistence.class.getName());

            ReferenceRegistry.registerReference(PropostaUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(PropostaPersistence persistence) {
    }
}
