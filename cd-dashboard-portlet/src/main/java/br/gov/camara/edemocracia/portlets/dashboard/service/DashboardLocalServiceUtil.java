package br.gov.camara.edemocracia.portlets.dashboard.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the dashboard local service. This utility wraps {@link br.gov.camara.edemocracia.portlets.dashboard.service.impl.DashboardLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Bruno
 * @see DashboardLocalService
 * @see br.gov.camara.edemocracia.portlets.dashboard.service.base.DashboardLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.dashboard.service.impl.DashboardLocalServiceImpl
 * @generated
 */
public class DashboardLocalServiceUtil {
    private static DashboardLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.dashboard.service.impl.DashboardLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Lista todas as comunidades públicas, privadas e restritas da companhia
    *
    * @throws SystemException
    */
    public static java.util.List<com.liferay.portal.model.Group> getComunidadesDisponiveis(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getComunidadesDisponiveis(companyId);
    }

    public static java.util.List<br.gov.camara.edemocracia.portlets.dashboard.dto.RecursoDTO> getRecursosComMaiorParticipacao(
        long companyId,
        br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao config,
        java.lang.String portletInstanceId,
        br.gov.camara.edemocracia.portlets.dashboard.Recurso recurso)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getRecursosComMaiorParticipacao(companyId, config,
            portletInstanceId, recurso);
    }

    public static void clearService() {
        _service = null;
    }

    public static DashboardLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DashboardLocalService.class.getName());

            if (invokableLocalService instanceof DashboardLocalService) {
                _service = (DashboardLocalService) invokableLocalService;
            } else {
                _service = new DashboardLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(DashboardLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(DashboardLocalService service) {
    }
}
