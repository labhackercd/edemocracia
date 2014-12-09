package br.gov.camara.edemocracia.portlets.guiadiscussao.service.persistence;

import br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robson
 * @see FasePersistenceImpl
 * @see FaseUtil
 * @generated
 */
public interface FasePersistence extends BasePersistence<Fase> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link FaseUtil} to access the fase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the fase in the entity cache if it is enabled.
    *
    * @param fase the fase
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fase);

    /**
    * Caches the fases in the entity cache if it is enabled.
    *
    * @param fases the fases
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> fases);

    /**
    * Creates a new fase with the primary key. Does not add the fase to the database.
    *
    * @param faseId the primary key for the new fase
    * @return the new fase
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase create(
        long faseId);

    /**
    * Removes the fase with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param faseId the primary key of the fase
    * @return the fase that was removed
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a fase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase remove(
        long faseId)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase updateImpl(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fase,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the fase with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException} if it could not be found.
    *
    * @param faseId the primary key of the fase
    * @return the fase
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a fase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase findByPrimaryKey(
        long faseId)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the fase with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param faseId the primary key of the fase
    * @return the fase, or <code>null</code> if a fase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fetchByPrimaryKey(
        long faseId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the fases where configuracaoId = &#63;.
    *
    * @param configuracaoId the configuracao ID
    * @return the matching fases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> findByConfiguracaoId(
        long configuracaoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the fases where configuracaoId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param configuracaoId the configuracao ID
    * @param start the lower bound of the range of fases
    * @param end the upper bound of the range of fases (not inclusive)
    * @return the range of matching fases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> findByConfiguracaoId(
        long configuracaoId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the fases where configuracaoId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param configuracaoId the configuracao ID
    * @param start the lower bound of the range of fases
    * @param end the upper bound of the range of fases (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching fases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> findByConfiguracaoId(
        long configuracaoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first fase in the ordered set where configuracaoId = &#63;.
    *
    * @param configuracaoId the configuracao ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching fase
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a matching fase could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase findByConfiguracaoId_First(
        long configuracaoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first fase in the ordered set where configuracaoId = &#63;.
    *
    * @param configuracaoId the configuracao ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching fase, or <code>null</code> if a matching fase could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fetchByConfiguracaoId_First(
        long configuracaoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last fase in the ordered set where configuracaoId = &#63;.
    *
    * @param configuracaoId the configuracao ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching fase
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a matching fase could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase findByConfiguracaoId_Last(
        long configuracaoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last fase in the ordered set where configuracaoId = &#63;.
    *
    * @param configuracaoId the configuracao ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching fase, or <code>null</code> if a matching fase could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fetchByConfiguracaoId_Last(
        long configuracaoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the fases before and after the current fase in the ordered set where configuracaoId = &#63;.
    *
    * @param faseId the primary key of the current fase
    * @param configuracaoId the configuracao ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next fase
    * @throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException if a fase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase[] findByConfiguracaoId_PrevAndNext(
        long faseId, long configuracaoId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.NoSuchFaseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the fases.
    *
    * @return the fases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the fases.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of fases
    * @param end the upper bound of the range of fases (not inclusive)
    * @return the range of fases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the fases.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of fases
    * @param end the upper bound of the range of fases (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of fases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the fases where configuracaoId = &#63; from the database.
    *
    * @param configuracaoId the configuracao ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByConfiguracaoId(long configuracaoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the fases from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of fases where configuracaoId = &#63;.
    *
    * @param configuracaoId the configuracao ID
    * @return the number of matching fases
    * @throws SystemException if a system exception occurred
    */
    public int countByConfiguracaoId(long configuracaoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of fases.
    *
    * @return the number of fases
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
