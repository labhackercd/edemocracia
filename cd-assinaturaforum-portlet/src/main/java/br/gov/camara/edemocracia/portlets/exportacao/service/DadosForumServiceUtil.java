package br.gov.camara.edemocracia.portlets.exportacao.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the dados forum remote service. This utility wraps {@link br.gov.camara.edemocracia.portlets.exportacao.service.impl.DadosForumServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author bruno
 * @see DadosForumService
 * @see br.gov.camara.edemocracia.portlets.exportacao.service.base.DadosForumServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.exportacao.service.impl.DadosForumServiceImpl
 * @generated
 */
public class DadosForumServiceUtil {
    private static DadosForumService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.exportacao.service.impl.DadosForumServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
    * Retorna os dados para exportaÃƒÂ§ÃƒÂ£o
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.exportacao.wrapper.DadosForumWrapper> getDadosForumExportacao(
        java.lang.Long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDadosForumExportacao(groupId);
    }

    /**
    * Retorna os dados para exportaÃƒÂ§ÃƒÂ£o para administradores
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.exportacao.wrapper.DadosForumAdminWrapper> getDadosForumAdminExportacao(
        java.lang.Long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDadosForumAdminExportacao(groupId);
    }

    public static void clearService() {
        _service = null;
    }

    public static DadosForumService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DadosForumService.class.getName());

            if (invokableService instanceof DadosForumService) {
                _service = (DadosForumService) invokableService;
            } else {
                _service = new DadosForumServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(DadosForumServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(DadosForumService service) {
    }
}
