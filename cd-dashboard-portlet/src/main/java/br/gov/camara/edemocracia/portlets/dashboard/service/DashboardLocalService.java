package br.gov.camara.edemocracia.portlets.dashboard.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The interface for the dashboard local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno
 * @see DashboardLocalServiceUtil
 * @see br.gov.camara.edemocracia.portlets.dashboard.service.base.DashboardLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.dashboard.service.impl.DashboardLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface DashboardLocalService extends BaseLocalService,
    InvokableLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DashboardLocalServiceUtil} to access the dashboard local service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.dashboard.service.impl.DashboardLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

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
    * Lista todas as comunidades públicas, privadas e restritas da companhia
    *
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portal.model.Group> getComunidadesDisponiveis(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.dashboard.dto.RecursoDTO> getRecursosComMaiorParticipacao(
        long companyId,
        br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao config,
        java.lang.String portletInstanceId,
        br.gov.camara.edemocracia.portlets.dashboard.Recurso recurso)
        throws com.liferay.portal.kernel.exception.SystemException;
}
