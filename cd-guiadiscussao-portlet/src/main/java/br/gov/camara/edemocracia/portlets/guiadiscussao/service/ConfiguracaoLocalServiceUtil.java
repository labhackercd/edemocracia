package br.gov.camara.edemocracia.portlets.guiadiscussao.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the configuracao local service. This utility wraps {@link br.gov.camara.edemocracia.portlets.guiadiscussao.service.impl.ConfiguracaoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robson
 * @see ConfiguracaoLocalService
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.service.base.ConfiguracaoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.guiadiscussao.service.impl.ConfiguracaoLocalServiceImpl
 * @generated
 */
public class ConfiguracaoLocalServiceUtil {
    private static ConfiguracaoLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.guiadiscussao.service.impl.ConfiguracaoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the configuracao to the database. Also notifies the appropriate model listeners.
    *
    * @param configuracao the configuracao
    * @return the configuracao that was added
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao addConfiguracao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao configuracao)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addConfiguracao(configuracao);
    }

    /**
    * Creates a new configuracao with the primary key. Does not add the configuracao to the database.
    *
    * @param configuracaoId the primary key for the new configuracao
    * @return the new configuracao
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao createConfiguracao(
        long configuracaoId) {
        return getService().createConfiguracao(configuracaoId);
    }

    /**
    * Deletes the configuracao with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param configuracaoId the primary key of the configuracao
    * @return the configuracao that was removed
    * @throws PortalException if a configuracao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao deleteConfiguracao(
        long configuracaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteConfiguracao(configuracaoId);
    }

    /**
    * Deletes the configuracao from the database. Also notifies the appropriate model listeners.
    *
    * @param configuracao the configuracao
    * @return the configuracao that was removed
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao deleteConfiguracao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao configuracao)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteConfiguracao(configuracao);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao fetchConfiguracao(
        long configuracaoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchConfiguracao(configuracaoId);
    }

    /**
    * Returns the configuracao with the primary key.
    *
    * @param configuracaoId the primary key of the configuracao
    * @return the configuracao
    * @throws PortalException if a configuracao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao getConfiguracao(
        long configuracaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getConfiguracao(configuracaoId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the configuracaos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of configuracaos
    * @param end the upper bound of the range of configuracaos (not inclusive)
    * @return the range of configuracaos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao> getConfiguracaos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getConfiguracaos(start, end);
    }

    /**
    * Returns the number of configuracaos.
    *
    * @return the number of configuracaos
    * @throws SystemException if a system exception occurred
    */
    public static int getConfiguracaosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getConfiguracaosCount();
    }

    /**
    * Updates the configuracao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param configuracao the configuracao
    * @return the configuracao that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao updateConfiguracao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao configuracao)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateConfiguracao(configuracao);
    }

    /**
    * Updates the configuracao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param configuracao the configuracao
    * @param merge whether to merge the configuracao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the configuracao that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao updateConfiguracao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao configuracao,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateConfiguracao(configuracao, merge);
    }

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

    public static br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao getByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getByGroupId(groupId);
    }

    public static void marcarFaseComoAtual(long faseId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().marcarFaseComoAtual(faseId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ConfiguracaoLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ConfiguracaoLocalService.class.getName());

            if (invokableLocalService instanceof ConfiguracaoLocalService) {
                _service = (ConfiguracaoLocalService) invokableLocalService;
            } else {
                _service = new ConfiguracaoLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ConfiguracaoLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(ConfiguracaoLocalService service) {
    }
}
