package br.gov.camara.edemocracia.portlets.guiadiscussao.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the acao local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robson
 * @see AcaoLocalServiceUtil
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.service.base.AcaoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.service.impl.AcaoLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface AcaoLocalService extends BaseLocalService, InvokableLocalService,
    PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AcaoLocalServiceUtil} to access the acao local service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.guiadiscussao.service.impl.AcaoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the acao to the database. Also notifies the appropriate model listeners.
    *
    * @param acao the acao
    * @return the acao that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao addAcao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new acao with the primary key. Does not add the acao to the database.
    *
    * @param acaoId the primary key for the new acao
    * @return the new acao
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao createAcao(
        long acaoId);

    /**
    * Deletes the acao with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param acaoId the primary key of the acao
    * @return the acao that was removed
    * @throws PortalException if a acao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao deleteAcao(
        long acaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the acao from the database. Also notifies the appropriate model listeners.
    *
    * @param acao the acao
    * @return the acao that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao deleteAcao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao)
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
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao fetchAcao(
        long acaoId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the acao with the primary key.
    *
    * @param acaoId the primary key of the acao
    * @return the acao
    * @throws PortalException if a acao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao getAcao(
        long acaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> getAcaos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of acaos.
    *
    * @return the number of acaos
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getAcaosCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the acao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param acao the acao
    * @return the acao that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao updateAcao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the acao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param acao the acao
    * @param merge whether to merge the acao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the acao that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao updateAcao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao,
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

    public void excluirAcao(long acaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> getAcoesByFaseId(
        long faseId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Atualiza a ordem das ações
    *
    * @param faseId
    * @param novaOrdenacao mapa com o id da ação e a nova ordem
    * @throws SystemException
    */
    public void atualizarOrdenacaoDasAcoes(java.lang.Long faseId,
        java.util.Map<java.lang.Long, java.lang.Integer> novaOrdenacao)
        throws com.liferay.portal.kernel.exception.SystemException;
}
