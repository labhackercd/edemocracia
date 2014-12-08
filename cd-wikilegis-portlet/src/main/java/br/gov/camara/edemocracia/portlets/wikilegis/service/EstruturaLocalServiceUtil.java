package br.gov.camara.edemocracia.portlets.wikilegis.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the estrutura local service. This utility wraps {@link br.gov.camara.edemocracia.portlets.wikilegis.service.impl.EstruturaLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author robson
 * @see EstruturaLocalService
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.base.EstruturaLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.impl.EstruturaLocalServiceImpl
 * @generated
 */
public class EstruturaLocalServiceUtil {
    private static EstruturaLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.wikilegis.service.impl.EstruturaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the estrutura to the database. Also notifies the appropriate model listeners.
    *
    * @param estrutura the estrutura
    * @return the estrutura that was added
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura addEstrutura(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addEstrutura(estrutura);
    }

    /**
    * Creates a new estrutura with the primary key. Does not add the estrutura to the database.
    *
    * @param estruturaId the primary key for the new estrutura
    * @return the new estrutura
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura createEstrutura(
        long estruturaId) {
        return getService().createEstrutura(estruturaId);
    }

    /**
    * Deletes the estrutura with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param estruturaId the primary key of the estrutura
    * @return the estrutura that was removed
    * @throws PortalException if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura deleteEstrutura(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteEstrutura(estruturaId);
    }

    /**
    * Deletes the estrutura from the database. Also notifies the appropriate model listeners.
    *
    * @param estrutura the estrutura
    * @return the estrutura that was removed
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura deleteEstrutura(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteEstrutura(estrutura);
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

    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura fetchEstrutura(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchEstrutura(estruturaId);
    }

    /**
    * Returns the estrutura with the primary key.
    *
    * @param estruturaId the primary key of the estrutura
    * @return the estrutura
    * @throws PortalException if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura getEstrutura(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEstrutura(estruturaId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the estruturas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of estruturas
    * @param end the upper bound of the range of estruturas (not inclusive)
    * @return the range of estruturas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> getEstruturas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getEstruturas(start, end);
    }

    /**
    * Returns the number of estruturas.
    *
    * @return the number of estruturas
    * @throws SystemException if a system exception occurred
    */
    public static int getEstruturasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getEstruturasCount();
    }

    /**
    * Updates the estrutura in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param estrutura the estrutura
    * @return the estrutura that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura updateEstrutura(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateEstrutura(estrutura);
    }

    /**
    * Updates the estrutura in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param estrutura the estrutura
    * @param merge whether to merge the estrutura with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the estrutura that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura updateEstrutura(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateEstrutura(estrutura, merge);
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

    /**
    * Lista todos os nÃƒÂ³s
    *
    * @return
    * @throws SystemException
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> listaTodos(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().listaTodos(groupId);
    }

    /**
    * Lista os elementos filhos
    *
    * @param groupId
    * @param estruturaPaiId
    * @return
    * @throws SystemException
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> listaFilhos(
        long groupId, long estruturaPaiId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().listaFilhos(groupId, estruturaPaiId);
    }

    /**
    * Cria uma nova estrutura
    *
    * @param groupId
    * @param paiEstruturaId
    * @param depoisDeEstruturaId
    * @param texto
    * @throws SystemException
    * @throws PortalException
    * @return Estrutura recÃƒÂ©m-criada
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura criaEstrutura(
        long groupId, long paiEstruturaId, long depoisDeEstruturaId,
        java.lang.String texto)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .criaEstrutura(groupId, paiEstruturaId, depoisDeEstruturaId,
            texto);
    }

    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura atualizaEstrutura(
        long estruturaId, long groupId, long estruturaPaiId,
        long depoisDeEstruturaId, java.lang.String texto)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .atualizaEstrutura(estruturaId, groupId, estruturaPaiId,
            depoisDeEstruturaId, texto);
    }

    public static void clearService() {
        _service = null;
    }

    public static EstruturaLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    EstruturaLocalService.class.getName());

            if (invokableLocalService instanceof EstruturaLocalService) {
                _service = (EstruturaLocalService) invokableLocalService;
            } else {
                _service = new EstruturaLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(EstruturaLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(EstruturaLocalService service) {
    }
}
