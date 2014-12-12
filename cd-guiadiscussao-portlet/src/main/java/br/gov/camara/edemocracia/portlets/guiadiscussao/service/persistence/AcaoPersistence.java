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

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the acao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robson
 * @see AcaoPersistenceImpl
 * @see AcaoUtil
 * @generated
 */
public interface AcaoPersistence extends BasePersistence<Acao> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AcaoUtil} to access the acao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the acao in the entity cache if it is enabled.
    *
    * @param acao the acao
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao);

    /**
    * Caches the acaos in the entity cache if it is enabled.
    *
    * @param acaos the acaos
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> acaos);

    /**
    * Creates a new acao with the primary key. Does not add the acao to the database.
    *
    * @param acaoId the primary key for the new acao
    * @return the new acao
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao create(
        long acaoId);

    /**
    * Removes the acao with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param acaoId the primary key of the acao
    * @return the acao that was removed
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException if a acao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao remove(
        long acaoId)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao updateImpl(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the acao with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException} if it could not be found.
    *
    * @param acaoId the primary key of the acao
    * @return the acao
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException if a acao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao findByPrimaryKey(
        long acaoId)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the acao with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param acaoId the primary key of the acao
    * @return the acao, or <code>null</code> if a acao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao fetchByPrimaryKey(
        long acaoId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the acaos where faseId = &#63;.
    *
    * @param faseId the fase ID
    * @return the matching acaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> findByFaseId(
        long faseId) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> findByFaseId(
        long faseId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> findByFaseId(
        long faseId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first acao in the ordered set where faseId = &#63;.
    *
    * @param faseId the fase ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching acao
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException if a matching acao could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao findByFaseId_First(
        long faseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first acao in the ordered set where faseId = &#63;.
    *
    * @param faseId the fase ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching acao, or <code>null</code> if a matching acao could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao fetchByFaseId_First(
        long faseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last acao in the ordered set where faseId = &#63;.
    *
    * @param faseId the fase ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching acao
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException if a matching acao could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao findByFaseId_Last(
        long faseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last acao in the ordered set where faseId = &#63;.
    *
    * @param faseId the fase ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching acao, or <code>null</code> if a matching acao could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao fetchByFaseId_Last(
        long faseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao[] findByFaseId_PrevAndNext(
        long acaoId, long faseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchAcaoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the acaos.
    *
    * @return the acaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the acaos where faseId = &#63; from the database.
    *
    * @param faseId the fase ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByFaseId(long faseId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the acaos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of acaos where faseId = &#63;.
    *
    * @param faseId the fase ID
    * @return the number of matching acaos
    * @throws SystemException if a system exception occurred
    */
    public int countByFaseId(long faseId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of acaos.
    *
    * @return the number of acaos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
