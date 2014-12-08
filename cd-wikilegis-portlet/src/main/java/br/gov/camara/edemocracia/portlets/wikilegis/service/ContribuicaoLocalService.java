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
 * The interface for the contribuicao local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author robson
 * @see ContribuicaoLocalServiceUtil
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.base.ContribuicaoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.impl.ContribuicaoLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ContribuicaoLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ContribuicaoLocalServiceUtil} to access the contribuicao local service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.wikilegis.service.impl.ContribuicaoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the contribuicao to the database. Also notifies the appropriate model listeners.
    *
    * @param contribuicao the contribuicao
    * @return the contribuicao that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao addContribuicao(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao contribuicao)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new contribuicao with the primary key. Does not add the contribuicao to the database.
    *
    * @param contribuicaoId the primary key for the new contribuicao
    * @return the new contribuicao
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao createContribuicao(
        long contribuicaoId);

    /**
    * Deletes the contribuicao with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contribuicaoId the primary key of the contribuicao
    * @return the contribuicao that was removed
    * @throws PortalException if a contribuicao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao deleteContribuicao(
        long contribuicaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the contribuicao from the database. Also notifies the appropriate model listeners.
    *
    * @param contribuicao the contribuicao
    * @return the contribuicao that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao deleteContribuicao(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao contribuicao)
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
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao fetchContribuicao(
        long contribuicaoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contribuicao with the primary key.
    *
    * @param contribuicaoId the primary key of the contribuicao
    * @return the contribuicao
    * @throws PortalException if a contribuicao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao getContribuicao(
        long contribuicaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> getContribuicaos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contribuicaos.
    *
    * @return the number of contribuicaos
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getContribuicaosCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the contribuicao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contribuicao the contribuicao
    * @return the contribuicao that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao updateContribuicao(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao contribuicao)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the contribuicao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contribuicao the contribuicao
    * @param merge whether to merge the contribuicao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the contribuicao that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao updateContribuicao(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao contribuicao,
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
    * Lista todas as contribuiÃ§Ãµes do artigo
    *
    * @param artigoId
    Lista as contribuiÃ§Ãµes do artigo especificado
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> listaContribuicoes(
        long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Cria uma nova contribuiÃ§Ã£o para o artigo especificado
    *
    * @param userId
    * @param artigoId
    * @param textoArtigo
    * @param descricao
    * @throws SystemException
    * @throws PortalException
    */
    public void criaContribuicao(long userId, long artigoId,
        java.lang.String textoArtigo, java.lang.String descricao)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Conta o nÃºmero de contribuiÃ§Ãµes para um artigo
    *
    * @param artigoId
    * @return
    * @throws SystemException
    */
    public int contaContribuicoes(long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Atualiza a contribuicao especificada
    *
    * @param contribuicaoId
    * @param textoArtigo
    * @param descricao
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao atualizaContribuicao(
        long contribuicaoId, java.lang.String textoArtigo,
        java.lang.String descricao)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
