package br.gov.camara.edemocracia.portlets.wikilegis.service.persistence;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the contribuicao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see ContribuicaoPersistenceImpl
 * @see ContribuicaoUtil
 * @generated
 */
public interface ContribuicaoPersistence extends BasePersistence<Contribuicao> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ContribuicaoUtil} to access the contribuicao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the contribuicao in the entity cache if it is enabled.
    *
    * @param contribuicao the contribuicao
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao contribuicao);

    /**
    * Caches the contribuicaos in the entity cache if it is enabled.
    *
    * @param contribuicaos the contribuicaos
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> contribuicaos);

    /**
    * Creates a new contribuicao with the primary key. Does not add the contribuicao to the database.
    *
    * @param contribuicaoId the primary key for the new contribuicao
    * @return the new contribuicao
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao create(
        long contribuicaoId);

    /**
    * Removes the contribuicao with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contribuicaoId the primary key of the contribuicao
    * @return the contribuicao that was removed
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException if a contribuicao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao remove(
        long contribuicaoId)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao updateImpl(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao contribuicao,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contribuicao with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException} if it could not be found.
    *
    * @param contribuicaoId the primary key of the contribuicao
    * @return the contribuicao
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException if a contribuicao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao findByPrimaryKey(
        long contribuicaoId)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contribuicao with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param contribuicaoId the primary key of the contribuicao
    * @return the contribuicao, or <code>null</code> if a contribuicao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao fetchByPrimaryKey(
        long contribuicaoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the contribuicaos where artigoId = &#63;.
    *
    * @param artigoId the artigo ID
    * @return the matching contribuicaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> findByA(
        long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the contribuicaos where artigoId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param artigoId the artigo ID
    * @param start the lower bound of the range of contribuicaos
    * @param end the upper bound of the range of contribuicaos (not inclusive)
    * @return the range of matching contribuicaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> findByA(
        long artigoId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the contribuicaos where artigoId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param artigoId the artigo ID
    * @param start the lower bound of the range of contribuicaos
    * @param end the upper bound of the range of contribuicaos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching contribuicaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> findByA(
        long artigoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contribuicao in the ordered set where artigoId = &#63;.
    *
    * @param artigoId the artigo ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contribuicao
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException if a matching contribuicao could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao findByA_First(
        long artigoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first contribuicao in the ordered set where artigoId = &#63;.
    *
    * @param artigoId the artigo ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching contribuicao, or <code>null</code> if a matching contribuicao could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao fetchByA_First(
        long artigoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contribuicao in the ordered set where artigoId = &#63;.
    *
    * @param artigoId the artigo ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contribuicao
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException if a matching contribuicao could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao findByA_Last(
        long artigoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last contribuicao in the ordered set where artigoId = &#63;.
    *
    * @param artigoId the artigo ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching contribuicao, or <code>null</code> if a matching contribuicao could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao fetchByA_Last(
        long artigoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contribuicaos before and after the current contribuicao in the ordered set where artigoId = &#63;.
    *
    * @param contribuicaoId the primary key of the current contribuicao
    * @param artigoId the artigo ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next contribuicao
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException if a contribuicao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao[] findByA_PrevAndNext(
        long contribuicaoId, long artigoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the contribuicaos.
    *
    * @return the contribuicaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the contribuicaos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of contribuicaos
    * @param end the upper bound of the range of contribuicaos (not inclusive)
    * @return the range of contribuicaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the contribuicaos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of contribuicaos
    * @param end the upper bound of the range of contribuicaos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of contribuicaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contribuicaos where artigoId = &#63; from the database.
    *
    * @param artigoId the artigo ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByA(long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contribuicaos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contribuicaos where artigoId = &#63;.
    *
    * @param artigoId the artigo ID
    * @return the number of matching contribuicaos
    * @throws SystemException if a system exception occurred
    */
    public int countByA(long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contribuicaos.
    *
    * @return the number of contribuicaos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
