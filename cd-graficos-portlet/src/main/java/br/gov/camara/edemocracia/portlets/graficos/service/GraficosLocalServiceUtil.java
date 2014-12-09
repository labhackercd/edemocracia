package br.gov.camara.edemocracia.portlets.graficos.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the graficos local service. This utility wraps {@link br.gov.camara.edemocracia.portlets.graficos.service.impl.GraficosLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robson Miranda
 * @see GraficosLocalService
 * @see br.gov.camara.edemocracia.portlets.graficos.service.base.GraficosLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.graficos.service.impl.GraficosLocalServiceImpl
 * @generated
 */
public class GraficosLocalServiceUtil {
    private static GraficosLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.graficos.service.impl.GraficosLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
    * Retorna os usuÃƒÂ¡rios por UF
    *
    * @param companyId
    TODO
    * @param pais
    * @return
    */
    public static java.util.Map<java.lang.String, java.lang.Integer> getUsuariosPorUf(
        long companyId, com.liferay.portal.model.Country pais) {
        return getService().getUsuariosPorUf(companyId, pais);
    }

    public static java.util.Map<java.lang.String, java.lang.Integer> getUsuariosPorData(
        long companyId, java.util.TimeZone tz, java.util.Date inicio,
        java.util.Date fim) {
        return getService().getUsuariosPorData(companyId, tz, inicio, fim);
    }

    /**
    * Busca a atividade na faixa de tempo especificada
    *
    * @param companyId
    * @param inicio
    * @param fim
    * @return
    */
    public static java.util.Map<java.lang.String, java.lang.Integer> getAtividadePorData(
        long companyId, java.util.TimeZone tz, java.util.Date inicio,
        java.util.Date fim) {
        return getService().getAtividadePorData(companyId, tz, inicio, fim);
    }

    public static void clearService() {
        _service = null;
    }

    public static GraficosLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    GraficosLocalService.class.getName());

            if (invokableLocalService instanceof GraficosLocalService) {
                _service = (GraficosLocalService) invokableLocalService;
            } else {
                _service = new GraficosLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(GraficosLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(GraficosLocalService service) {
    }
}
