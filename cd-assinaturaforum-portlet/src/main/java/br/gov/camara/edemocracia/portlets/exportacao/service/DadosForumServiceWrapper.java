package br.gov.camara.edemocracia.portlets.exportacao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DadosForumService}.
 * </p>
 *
 * @author    bruno
 * @see       DadosForumService
 * @generated
 */
public class DadosForumServiceWrapper implements DadosForumService,
    ServiceWrapper<DadosForumService> {
    private DadosForumService _dadosForumService;

    public DadosForumServiceWrapper(DadosForumService dadosForumService) {
        _dadosForumService = dadosForumService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _dadosForumService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dadosForumService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dadosForumService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Retorna os dados para exportaÃƒÂ§ÃƒÂ£o
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.exportacao.wrapper.DadosForumWrapper> getDadosForumExportacao(
        java.lang.Long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dadosForumService.getDadosForumExportacao(groupId);
    }

    /**
    * Retorna os dados para exportaÃƒÂ§ÃƒÂ£o para administradores
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.exportacao.wrapper.DadosForumAdminWrapper> getDadosForumAdminExportacao(
        java.lang.Long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _dadosForumService.getDadosForumAdminExportacao(groupId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public DadosForumService getWrappedDadosForumService() {
        return _dadosForumService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedDadosForumService(DadosForumService dadosForumService) {
        _dadosForumService = dadosForumService;
    }

    public DadosForumService getWrappedService() {
        return _dadosForumService;
    }

    public void setWrappedService(DadosForumService dadosForumService) {
        _dadosForumService = dadosForumService;
    }
}
