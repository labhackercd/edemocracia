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
package br.gov.camara.edemocracia.portlets.wikilegis.service.persistence;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the estrutura service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see EstruturaPersistenceImpl
 * @see EstruturaUtil
 * @generated
 */
public interface EstruturaPersistence extends BasePersistence<Estrutura> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EstruturaUtil} to access the estrutura persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the estrutura in the entity cache if it is enabled.
    *
    * @param estrutura the estrutura
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura);

    /**
    * Caches the estruturas in the entity cache if it is enabled.
    *
    * @param estruturas the estruturas
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> estruturas);

    /**
    * Creates a new estrutura with the primary key. Does not add the estrutura to the database.
    *
    * @param estruturaId the primary key for the new estrutura
    * @return the new estrutura
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura create(
        long estruturaId);

    /**
    * Removes the estrutura with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param estruturaId the primary key of the estrutura
    * @return the estrutura that was removed
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura remove(
        long estruturaId)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura updateImpl(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the estrutura with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException} if it could not be found.
    *
    * @param estruturaId the primary key of the estrutura
    * @return the estrutura
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura findByPrimaryKey(
        long estruturaId)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the estrutura with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param estruturaId the primary key of the estrutura
    * @return the estrutura, or <code>null</code> if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura fetchByPrimaryKey(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the estruturas where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @return the matching estruturas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> findByG_P(
        long groupId, long paiEstruturaId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> findByG_P(
        long groupId, long paiEstruturaId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> findByG_P(
        long groupId, long paiEstruturaId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura findByG_P_First(
        long groupId, long paiEstruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first estrutura in the ordered set where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching estrutura, or <code>null</code> if a matching estrutura could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura fetchByG_P_First(
        long groupId, long paiEstruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura findByG_P_Last(
        long groupId, long paiEstruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last estrutura in the ordered set where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching estrutura, or <code>null</code> if a matching estrutura could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura fetchByG_P_Last(
        long groupId, long paiEstruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura[] findByG_P_PrevAndNext(
        long estruturaId, long groupId, long paiEstruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the estruturas.
    *
    * @return the estruturas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the estruturas where groupId = &#63; and paiEstruturaId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_P(long groupId, long paiEstruturaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the estruturas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of estruturas where groupId = &#63; and paiEstruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param paiEstruturaId the pai estrutura ID
    * @return the number of matching estruturas
    * @throws SystemException if a system exception occurred
    */
    public int countByG_P(long groupId, long paiEstruturaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of estruturas.
    *
    * @return the number of estruturas
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
