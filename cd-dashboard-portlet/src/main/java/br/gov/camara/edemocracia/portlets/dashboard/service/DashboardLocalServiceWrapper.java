package br.gov.camara.edemocracia.portlets.dashboard.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DashboardLocalService}.
 * </p>
 *
 * @author    Bruno
 * @see       DashboardLocalService
 * @generated
 */
public class DashboardLocalServiceWrapper implements DashboardLocalService,
    ServiceWrapper<DashboardLocalService> {
    private DashboardLocalService _dashboardLocalService;

    public DashboardLocalServiceWrapper(
        DashboardLocalService dashboardLocalService) {
        _dashboardLocalService = dashboardLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _dashboardLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dashboardLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dashboardLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Lista todas as comunidades públicas, privadas e restritas da companhia
    *
    * @throws SystemException
    */
    public java.util.List<com.liferay.portal.model.Group> getComunidadesDisponiveis(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dashboardLocalService.getComunidadesDisponiveis(companyId);
    }

    public java.util.List<br.gov.camara.edemocracia.portlets.dashboard.dto.RecursoDTO> getRecursosComMaiorParticipacao(
        long companyId,
        br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao config,
        java.lang.String portletInstanceId,
        br.gov.camara.edemocracia.portlets.dashboard.Recurso recurso)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _dashboardLocalService.getRecursosComMaiorParticipacao(companyId,
            config, portletInstanceId, recurso);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public DashboardLocalService getWrappedDashboardLocalService() {
        return _dashboardLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedDashboardLocalService(
        DashboardLocalService dashboardLocalService) {
        _dashboardLocalService = dashboardLocalService;
    }

    public DashboardLocalService getWrappedService() {
        return _dashboardLocalService;
    }

    public void setWrappedService(DashboardLocalService dashboardLocalService) {
        _dashboardLocalService = dashboardLocalService;
    }
}
