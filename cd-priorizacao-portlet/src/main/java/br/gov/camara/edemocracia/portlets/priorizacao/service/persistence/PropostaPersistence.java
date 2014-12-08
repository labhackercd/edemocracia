package br.gov.camara.edemocracia.portlets.priorizacao.service.persistence;

import br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the proposta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see PropostaPersistenceImpl
 * @see PropostaUtil
 * @generated
 */
public interface PropostaPersistence extends BasePersistence<Proposta> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PropostaUtil} to access the proposta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the proposta in the entity cache if it is enabled.
    *
    * @param proposta the proposta
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta proposta);

    /**
    * Caches the propostas in the entity cache if it is enabled.
    *
    * @param propostas the propostas
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> propostas);

    /**
    * Creates a new proposta with the primary key. Does not add the proposta to the database.
    *
    * @param propostaId the primary key for the new proposta
    * @return the new proposta
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta create(
        long propostaId);

    /**
    * Removes the proposta with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param propostaId the primary key of the proposta
    * @return the proposta that was removed
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a proposta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta remove(
        long propostaId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta updateImpl(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta proposta,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposta with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException} if it could not be found.
    *
    * @param propostaId the primary key of the proposta
    * @return the proposta
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a proposta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByPrimaryKey(
        long propostaId)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the proposta with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param propostaId the primary key of the proposta
    * @return the proposta, or <code>null</code> if a proposta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByPrimaryKey(
        long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the propostas where eixoId = &#63;.
    *
    * @param eixoId the eixo ID
    * @return the matching propostas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByE(
        long eixoId) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByE(
        long eixoId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByE(
        long eixoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposta in the ordered set where eixoId = &#63;.
    *
    * @param eixoId the eixo ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposta
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByE_First(
        long eixoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposta in the ordered set where eixoId = &#63;.
    *
    * @param eixoId the eixo ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposta, or <code>null</code> if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByE_First(
        long eixoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposta in the ordered set where eixoId = &#63;.
    *
    * @param eixoId the eixo ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposta
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByE_Last(
        long eixoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposta in the ordered set where eixoId = &#63;.
    *
    * @param eixoId the eixo ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposta, or <code>null</code> if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByE_Last(
        long eixoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta[] findByE_PrevAndNext(
        long propostaId, long eixoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the propostas where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching propostas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByG(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByG(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByG(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposta in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposta
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByG_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposta in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposta, or <code>null</code> if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByG_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposta in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposta
    * @throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByG_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposta in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposta, or <code>null</code> if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByG_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta[] findByG_PrevAndNext(
        long propostaId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the propostas where identificador = &#63; and groupId = &#63;.
    *
    * @param identificador the identificador
    * @param groupId the group ID
    * @return the matching propostas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByI_G(
        java.lang.String identificador, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByI_G(
        java.lang.String identificador, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findByI_G(
        java.lang.String identificador, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByI_G_First(
        java.lang.String identificador, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first proposta in the ordered set where identificador = &#63; and groupId = &#63;.
    *
    * @param identificador the identificador
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching proposta, or <code>null</code> if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByI_G_First(
        java.lang.String identificador, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta findByI_G_Last(
        java.lang.String identificador, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last proposta in the ordered set where identificador = &#63; and groupId = &#63;.
    *
    * @param identificador the identificador
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching proposta, or <code>null</code> if a matching proposta could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchByI_G_Last(
        java.lang.String identificador, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta[] findByI_G_PrevAndNext(
        long propostaId, java.lang.String identificador, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the propostas.
    *
    * @return the propostas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the propostas where eixoId = &#63; from the database.
    *
    * @param eixoId the eixo ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByE(long eixoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the propostas where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByG(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the propostas where identificador = &#63; and groupId = &#63; from the database.
    *
    * @param identificador the identificador
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByI_G(java.lang.String identificador, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the propostas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of propostas where eixoId = &#63;.
    *
    * @param eixoId the eixo ID
    * @return the number of matching propostas
    * @throws SystemException if a system exception occurred
    */
    public int countByE(long eixoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of propostas where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching propostas
    * @throws SystemException if a system exception occurred
    */
    public int countByG(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of propostas where identificador = &#63; and groupId = &#63;.
    *
    * @param identificador the identificador
    * @param groupId the group ID
    * @return the number of matching propostas
    * @throws SystemException if a system exception occurred
    */
    public int countByI_G(java.lang.String identificador, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of propostas.
    *
    * @return the number of propostas
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
