package br.gov.camara.edemocracia.portlets.priorizacao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EixoLocalService}.
 * </p>
 *
 * @author    robson
 * @see       EixoLocalService
 * @generated
 */
public class EixoLocalServiceWrapper implements EixoLocalService,
    ServiceWrapper<EixoLocalService> {
    private EixoLocalService _eixoLocalService;

    public EixoLocalServiceWrapper(EixoLocalService eixoLocalService) {
        _eixoLocalService = eixoLocalService;
    }

    /**
    * Adds the eixo to the database. Also notifies the appropriate model listeners.
    *
    * @param eixo the eixo
    * @return the eixo that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo addEixo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.addEixo(eixo);
    }

    /**
    * Creates a new eixo with the primary key. Does not add the eixo to the database.
    *
    * @param eixoId the primary key for the new eixo
    * @return the new eixo
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo createEixo(
        long eixoId) {
        return _eixoLocalService.createEixo(eixoId);
    }

    /**
    * Deletes the eixo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param eixoId the primary key of the eixo
    * @return the eixo that was removed
    * @throws PortalException if a eixo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo deleteEixo(
        long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.deleteEixo(eixoId);
    }

    /**
    * Deletes the eixo from the database. Also notifies the appropriate model listeners.
    *
    * @param eixo the eixo
    * @return the eixo that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo deleteEixo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.deleteEixo(eixo);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _eixoLocalService.dynamicQuery();
    }

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
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.dynamicQuery(dynamicQuery);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.dynamicQuery(dynamicQuery, start, end);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo fetchEixo(
        long eixoId) throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.fetchEixo(eixoId);
    }

    /**
    * Returns the eixo with the primary key.
    *
    * @param eixoId the primary key of the eixo
    * @return the eixo
    * @throws PortalException if a eixo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo getEixo(
        long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.getEixo(eixoId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the eixos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of eixos
    * @param end the upper bound of the range of eixos (not inclusive)
    * @return the range of eixos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> getEixos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.getEixos(start, end);
    }

    /**
    * Returns the number of eixos.
    *
    * @return the number of eixos
    * @throws SystemException if a system exception occurred
    */
    public int getEixosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.getEixosCount();
    }

    /**
    * Updates the eixo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param eixo the eixo
    * @return the eixo that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo updateEixo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.updateEixo(eixo);
    }

    /**
    * Updates the eixo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param eixo the eixo
    * @param merge whether to merge the eixo with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the eixo that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo updateEixo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.updateEixo(eixo, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _eixoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _eixoLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _eixoLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Lista todos os eixos
    *
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> listarEixosPorGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.listarEixosPorGroupId(groupId);
    }

    /**
    * Cria um eixo na posição especificada
    *
    * @param groupId
    * @param categoryId
    * @param sumario
    * @param titulo
    * @param eixoAnteriorId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo addEixo(
        long groupId, long categoryId, java.lang.String sumario,
        java.lang.String titulo, long eixoAnteriorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.addEixo(groupId, categoryId, sumario, titulo,
            eixoAnteriorId);
    }

    /**
    * Atualiza um eixo
    *
    * @param eixoId
    * @param sumario
    * @param titulo
    * @param eixoAnteriorId
    * @param categoryId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo updateEixo(
        long eixoId, java.lang.String sumario, java.lang.String titulo,
        long eixoAnteriorId, long categoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.updateEixo(eixoId, sumario, titulo,
            eixoAnteriorId, categoryId);
    }

    /**
    * Remove o eixo especificado
    *
    * @param eixo
    * @throws SystemException
    */
    public void excluirEixo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo)
        throws com.liferay.portal.kernel.exception.SystemException {
        _eixoLocalService.excluirEixo(eixo);
    }

    /**
    * Remove um eixo e suas propostas
    *
    * @param eixoId
    * @throws PortalException
    * @throws SystemException
    */
    public void excluirEixo(long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _eixoLocalService.excluirEixo(eixoId);
    }

    /**
    * Retorna o a quantidade de eixos cadastrados na comunidade especificada
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    public int getEixosCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eixoLocalService.getEixosCountByGroupId(groupId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public EixoLocalService getWrappedEixoLocalService() {
        return _eixoLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedEixoLocalService(EixoLocalService eixoLocalService) {
        _eixoLocalService = eixoLocalService;
    }

    public EixoLocalService getWrappedService() {
        return _eixoLocalService;
    }

    public void setWrappedService(EixoLocalService eixoLocalService) {
        _eixoLocalService = eixoLocalService;
    }
}
