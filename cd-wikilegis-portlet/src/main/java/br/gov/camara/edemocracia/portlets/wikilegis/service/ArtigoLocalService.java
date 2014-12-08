package br.gov.camara.edemocracia.portlets.wikilegis.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the artigo local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author robson
 * @see ArtigoLocalServiceUtil
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.base.ArtigoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.impl.ArtigoLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ArtigoLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ArtigoLocalServiceUtil} to access the artigo local service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.wikilegis.service.impl.ArtigoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the artigo to the database. Also notifies the appropriate model listeners.
    *
    * @param artigo the artigo
    * @return the artigo that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo addArtigo(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new artigo with the primary key. Does not add the artigo to the database.
    *
    * @param artigoId the primary key for the new artigo
    * @return the new artigo
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo createArtigo(
        long artigoId);

    /**
    * Deletes the artigo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param artigoId the primary key of the artigo
    * @return the artigo that was removed
    * @throws PortalException if a artigo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo deleteArtigo(
        long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the artigo from the database. Also notifies the appropriate model listeners.
    *
    * @param artigo the artigo
    * @return the artigo that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo deleteArtigo(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo fetchArtigo(
        long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the artigo with the primary key.
    *
    * @param artigoId the primary key of the artigo
    * @return the artigo
    * @throws PortalException if a artigo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo getArtigo(
        long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> getArtigos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of artigos.
    *
    * @return the number of artigos
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getArtigosCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the artigo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param artigo the artigo
    * @return the artigo that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo updateArtigo(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the artigo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param artigo the artigo
    * @param merge whether to merge the artigo with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the artigo that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo updateArtigo(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo artigo,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    /**
    * Lista os filhos do pai especificado
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> listaArtigos(
        long groupId, long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Lista os filhos do pai especificado, jÃ¡ formatados para visualizaÃ§Ã£o
    *
    * @param groupId
    * @param estruturaId
    * @return
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay> listaArtigoDisplay(
        long groupId, long estruturaId);

    /**
    * Lista todos os artigos do grupo especificadoz
    *
    * @param groupId
    * @return
    */
    public java.util.Map<java.lang.Long, java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay>> listaArtigoDisplay(
        long groupId);

    /**
    * Cria um artigo no nÃ³ especificado
    *
    * @param groupId
    * @param estruturaId
    * @param texto
    * @param legislacaoVigente
    * @param ordem
    * @throws SystemException
    * @throws PortalException
    * @return Artigo artigo recÃ©m-criado
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo criaArtigo(
        long groupId, long estruturaId, long anteriorArtigoId,
        java.lang.String texto, java.lang.String legislacaoVigente)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Exclui um artigo e seus comentÃ¡rios
    *
    * @param artigoId
    * @throws SystemException
    * @throws PortalException
    */
    public void excluiArtigo(long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Atualiza um artigo
    *
    * @param userId
    * @param artigoId
    * @param textoArtigo
    * @param legislacaoVigente
    * @throws SystemException
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo atualizaArtigo(
        long userId, long artigoId, long estruturaId, long anteriorArtigoId,
        java.lang.String textoArtigo, java.lang.String legislacaoVigente)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
