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

import br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the eixo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see EixoPersistenceImpl
 * @see EixoUtil
 * @generated
 */
public interface EixoPersistence extends BasePersistence<Eixo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EixoUtil} to access the eixo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the eixo in the entity cache if it is enabled.
    *
    * @param eixo the eixo
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo);

    /**
    * Caches the eixos in the entity cache if it is enabled.
    *
    * @param eixos the eixos
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> eixos);

    /**
    * Creates a new eixo with the primary key. Does not add the eixo to the database.
    *
    * @param eixoId the primary key for the new eixo
    * @return the new eixo
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo create(
        long eixoId);

    /**
    * Removes the eixo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param eixoId the primary key of the eixo
    * @return the eixo that was removed
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException if a eixo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo remove(
        long eixoId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo updateImpl(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the eixo with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException} if it could not be found.
    *
    * @param eixoId the primary key of the eixo
    * @return the eixo
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException if a eixo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo findByPrimaryKey(
        long eixoId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the eixo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param eixoId the primary key of the eixo
    * @return the eixo, or <code>null</code> if a eixo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo fetchByPrimaryKey(
        long eixoId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the eixos where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching eixos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> findByG(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> findByG(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> findByG(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first eixo in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching eixo
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException if a matching eixo could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo findByG_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first eixo in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching eixo, or <code>null</code> if a matching eixo could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo fetchByG_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last eixo in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching eixo
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException if a matching eixo could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo findByG_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last eixo in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching eixo, or <code>null</code> if a matching eixo could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo fetchByG_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo[] findByG_PrevAndNext(
        long eixoId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the eixos.
    *
    * @return the eixos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the eixos where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByG(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the eixos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of eixos where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching eixos
    * @throws SystemException if a system exception occurred
    */
    public int countByG(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of eixos.
    *
    * @return the number of eixos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
