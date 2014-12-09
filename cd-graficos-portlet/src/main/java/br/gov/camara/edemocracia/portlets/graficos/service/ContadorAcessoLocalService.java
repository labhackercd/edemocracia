package br.gov.camara.edemocracia.portlets.graficos.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the contador acesso local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robson Miranda
 * @see ContadorAcessoLocalServiceUtil
 * @see br.gov.camara.edemocracia.portlets.graficos.service.base.ContadorAcessoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.graficos.service.impl.ContadorAcessoLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ContadorAcessoLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ContadorAcessoLocalServiceUtil} to access the contador acesso local service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.graficos.service.impl.ContadorAcessoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the contador acesso to the database. Also notifies the appropriate model listeners.
    *
    * @param contadorAcesso the contador acesso
    * @return the contador acesso that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso addContadorAcesso(
        br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso contadorAcesso)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new contador acesso with the primary key. Does not add the contador acesso to the database.
    *
    * @param contadorId the primary key for the new contador acesso
    * @return the new contador acesso
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso createContadorAcesso(
        long contadorId);

    /**
    * Deletes the contador acesso with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contadorId the primary key of the contador acesso
    * @return the contador acesso that was removed
    * @throws PortalException if a contador acesso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso deleteContadorAcesso(
        long contadorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the contador acesso from the database. Also notifies the appropriate model listeners.
    *
    * @param contadorAcesso the contador acesso
    * @return the contador acesso that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso deleteContadorAcesso(
        br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso contadorAcesso)
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
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso fetchContadorAcesso(
        long contadorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contador acesso with the primary key.
    *
    * @param contadorId the primary key of the contador acesso
    * @return the contador acesso
    * @throws PortalException if a contador acesso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso getContadorAcesso(
        long contadorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the contador acessos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of contador acessos
    * @param end the upper bound of the range of contador acessos (not inclusive)
    * @return the range of contador acessos
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso> getContadorAcessos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contador acessos.
    *
    * @return the number of contador acessos
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getContadorAcessosCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the contador acesso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contadorAcesso the contador acesso
    * @return the contador acesso that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso updateContadorAcesso(
        br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso contadorAcesso)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the contador acesso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contadorAcesso the contador acesso
    * @param merge whether to merge the contador acesso with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the contador acesso that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso updateContadorAcesso(
        br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso contadorAcesso,
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
    * Exporta os dados de uma compania em CSV
    *
    * @param companyId
    * @return
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getCSV(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException;

    /**
    * ObtÃ©m os dados consolidados atÃ© o dia de hoje
    *
    * @param companyId
    * @return
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.Map<java.lang.Long, br.gov.camara.edemocracia.portlets.graficos.DadosConsolidados> getDadosConsolidados(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;
}
