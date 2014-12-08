package br.gov.camara.edemocracia.portlets.wikilegis.service.persistence;

import br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the artigo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author robson
 * @see ArtigoPersistenceImpl
 * @see ArtigoUtil
 * @generated
 */
public interface ArtigoPersistence extends BasePersistence<Artigo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ArtigoUtil} to access the artigo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the artigo in the entity cache if it is enabled.
    *
    * @param artigo the artigo
    */
    public void cacheResult(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo);

    /**
    * Caches the artigos in the entity cache if it is enabled.
    *
    * @param artigos the artigos
    */
    public void cacheResult(
        java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> artigos);

    /**
    * Creates a new artigo with the primary key. Does not add the artigo to the database.
    *
    * @param artigoId the primary key for the new artigo
    * @return the new artigo
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo create(
        long artigoId);

    /**
    * Removes the artigo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param artigoId the primary key of the artigo
    * @return the artigo that was removed
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a artigo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo remove(
        long artigoId)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo updateImpl(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the artigo with the primary key or throws a {@link br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException} if it could not be found.
    *
    * @param artigoId the primary key of the artigo
    * @return the artigo
    * @throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException if a artigo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo findByPrimaryKey(
        long artigoId)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the artigo with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param artigoId the primary key of the artigo
    * @return the artigo, or <code>null</code> if a artigo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo fetchByPrimaryKey(
        long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the artigos where groupId = &#63; and estruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @return the matching artigos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> findByG_E(
        long groupId, long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> findByG_E(
        long groupId, long estruturaId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> findByG_E(
        long groupId, long estruturaId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo findByG_E_First(
        long groupId, long estruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first artigo in the ordered set where groupId = &#63; and estruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching artigo, or <code>null</code> if a matching artigo could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo fetchByG_E_First(
        long groupId, long estruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo findByG_E_Last(
        long groupId, long estruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last artigo in the ordered set where groupId = &#63; and estruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching artigo, or <code>null</code> if a matching artigo could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo fetchByG_E_Last(
        long groupId, long estruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo[] findByG_E_PrevAndNext(
        long artigoId, long groupId, long estruturaId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the artigos.
    *
    * @return the artigos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the artigos where groupId = &#63; and estruturaId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_E(long groupId, long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the artigos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of artigos where groupId = &#63; and estruturaId = &#63;.
    *
    * @param groupId the group ID
    * @param estruturaId the estrutura ID
    * @return the number of matching artigos
    * @throws SystemException if a system exception occurred
    */
    public int countByG_E(long groupId, long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of artigos.
    *
    * @return the number of artigos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the contribuicaos associated with the artigo.
    *
    * @param pk the primary key of the artigo
    * @return the contribuicaos associated with the artigo
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> getContribuicaos(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> getContribuicaos(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> getContribuicaos(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contribuicaos associated with the artigo.
    *
    * @param pk the primary key of the artigo
    * @return the number of contribuicaos associated with the artigo
    * @throws SystemException if a system exception occurred
    */
    public int getContribuicaosSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the contribuicao is associated with the artigo.
    *
    * @param pk the primary key of the artigo
    * @param contribuicaoPK the primary key of the contribuicao
    * @return <code>true</code> if the contribuicao is associated with the artigo; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsContribuicao(long pk, long contribuicaoPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the artigo has any contribuicaos associated with it.
    *
    * @param pk the primary key of the artigo to check for associations with contribuicaos
    * @return <code>true</code> if the artigo has any contribuicaos associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsContribuicaos(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;
}
