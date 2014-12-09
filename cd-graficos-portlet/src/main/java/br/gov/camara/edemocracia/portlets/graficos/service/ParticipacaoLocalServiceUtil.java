package br.gov.camara.edemocracia.portlets.graficos.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the participacao local service. This utility wraps {@link br.gov.camara.edemocracia.portlets.graficos.service.impl.ParticipacaoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robson Miranda
 * @see ParticipacaoLocalService
 * @see br.gov.camara.edemocracia.portlets.graficos.service.base.ParticipacaoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.graficos.service.impl.ParticipacaoLocalServiceImpl
 * @generated
 */
public class ParticipacaoLocalServiceUtil {
    private static ParticipacaoLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.graficos.service.impl.ParticipacaoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
    * Lista todas as comunidades pÃƒÂºblicas, privadas e restritas da companhia
    *
    * @throws SystemException
    */
    public static java.util.List<com.liferay.portal.model.Group> getComunidadesDisponiveis(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getComunidadesDisponiveis(companyId);
    }

    /**
    * Recupera todos os dados dos usuÃƒÂ¡rios que participaram das comunidades
    * especificadas.
    *
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO> getDadosComunidade(
        java.util.List<java.lang.Long> groups)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDadosComunidade(groups);
    }

    /**
    * Recupera todos os dados dos usuÃƒÂ¡rios que participaram das comunidades
    * especificadas.
    *
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO> getDadosComunidade(
        java.util.List<java.lang.Long> groups, java.util.Date dataInicio,
        java.util.Date dataFim)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDadosComunidade(groups, dataInicio, dataFim);
    }

    /**
    * Recupera todos os dados dos usuÃƒÂ¡rios que participaram da comunidade
    * especificada.
    */
    public static br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO getDadosComunidade(
        java.lang.Long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDadosComunidade(groupId);
    }

    /**
    * Recupera todos os dados dos usuÃƒÂ¡rios que participaram da comunidade
    * especificada dentro do periodo especificado.
    */
    public static br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO getDadosComunidade(
        java.lang.Long groupId, java.util.Date dataInicio,
        java.util.Date dataFim)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDadosComunidade(groupId, dataInicio, dataFim);
    }

    public static void clearService() {
        _service = null;
    }

    public static ParticipacaoLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ParticipacaoLocalService.class.getName());

            if (invokableLocalService instanceof ParticipacaoLocalService) {
                _service = (ParticipacaoLocalService) invokableLocalService;
            } else {
                _service = new ParticipacaoLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ParticipacaoLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(ParticipacaoLocalService service) {
    }
}
