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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the voto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see VotoPersistenceImpl
 * @see VotoUtil
 * @generated
 */
public interface VotoPersistence extends BasePersistence<Voto> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link VotoUtil} to access the voto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the voto in the entity cache if it is enabled.
    *
    * @param voto the voto
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto);

    /**
    * Caches the votos in the entity cache if it is enabled.
    *
    * @param votos the votos
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> votos);

    /**
    * Creates a new voto with the primary key. Does not add the voto to the database.
    *
    * @param votoId the primary key for the new voto
    * @return the new voto
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto create(
        long votoId);

    /**
    * Removes the voto with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param votoId the primary key of the voto
    * @return the voto that was removed
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a voto with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto remove(
        long votoId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto updateImpl(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the voto with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException} if it could not be found.
    *
    * @param votoId the primary key of the voto
    * @return the voto
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a voto with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto findByPrimaryKey(
        long votoId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the voto with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param votoId the primary key of the voto
    * @return the voto, or <code>null</code> if a voto with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByPrimaryKey(
        long votoId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the votos where propostaId = &#63;.
    *
    * @param propostaId the proposta ID
    * @return the matching votos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findByP(
        long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findByP(
        long propostaId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findByP(
        long propostaId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first voto in the ordered set where propostaId = &#63;.
    *
    * @param propostaId the proposta ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching voto
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto findByP_First(
        long propostaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first voto in the ordered set where propostaId = &#63;.
    *
    * @param propostaId the proposta ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching voto, or <code>null</code> if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByP_First(
        long propostaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last voto in the ordered set where propostaId = &#63;.
    *
    * @param propostaId the proposta ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching voto
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto findByP_Last(
        long propostaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last voto in the ordered set where propostaId = &#63;.
    *
    * @param propostaId the proposta ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching voto, or <code>null</code> if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByP_Last(
        long propostaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto[] findByP_PrevAndNext(
        long votoId, long propostaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the voto where propostaId = &#63; and userId = &#63; or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException} if it could not be found.
    *
    * @param propostaId the proposta ID
    * @param userId the user ID
    * @return the matching voto
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto findByP_U(
        long propostaId, long userId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the voto where propostaId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param propostaId the proposta ID
    * @param userId the user ID
    * @return the matching voto, or <code>null</code> if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByP_U(
        long propostaId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the voto where propostaId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param propostaId the proposta ID
    * @param userId the user ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching voto, or <code>null</code> if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByP_U(
        long propostaId, long userId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the votos where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching votos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findByU(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findByU(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findByU(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first voto in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching voto
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto findByU_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first voto in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching voto, or <code>null</code> if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByU_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last voto in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching voto
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto findByU_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last voto in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching voto, or <code>null</code> if a matching voto could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchByU_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto[] findByU_PrevAndNext(
        long votoId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the votos.
    *
    * @return the votos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the votos where propostaId = &#63; from the database.
    *
    * @param propostaId the proposta ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByP(long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the voto where propostaId = &#63; and userId = &#63; from the database.
    *
    * @param propostaId the proposta ID
    * @param userId the user ID
    * @return the voto that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto removeByP_U(
        long propostaId, long userId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the votos where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByU(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the votos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of votos where propostaId = &#63;.
    *
    * @param propostaId the proposta ID
    * @return the number of matching votos
    * @throws SystemException if a system exception occurred
    */
    public int countByP(long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of votos where propostaId = &#63; and userId = &#63;.
    *
    * @param propostaId the proposta ID
    * @param userId the user ID
    * @return the number of matching votos
    * @throws SystemException if a system exception occurred
    */
    public int countByP_U(long propostaId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of votos where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching votos
    * @throws SystemException if a system exception occurred
    */
    public int countByU(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of votos.
    *
    * @return the number of votos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
