package br.gov.camara.edemocracia.portlets.guiadiscussao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AcaoLocalService}.
 * </p>
 *
 * @author    Robson
 * @see       AcaoLocalService
 * @generated
 */
public class AcaoLocalServiceWrapper implements AcaoLocalService,
    ServiceWrapper<AcaoLocalService> {
    private AcaoLocalService _acaoLocalService;

    public AcaoLocalServiceWrapper(AcaoLocalService acaoLocalService) {
        _acaoLocalService = acaoLocalService;
    }

    /**
    * Adds the acao to the database. Also notifies the appropriate model listeners.
    *
    * @param acao the acao
    * @return the acao that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao addAcao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _acaoLocalService.addAcao(acao);
    }

    /**
    * Creates a new acao with the primary key. Does not add the acao to the database.
    *
    * @param acaoId the primary key for the new acao
    * @return the new acao
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao createAcao(
        long acaoId) {
        return _acaoLocalService.createAcao(acaoId);
    }

    /**
    * Deletes the acao with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param acaoId the primary key of the acao
    * @return the acao that was removed
    * @throws PortalException if a acao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao deleteAcao(
        long acaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _acaoLocalService.deleteAcao(acaoId);
    }

    /**
    * Deletes the acao from the database. Also notifies the appropriate model listeners.
    *
    * @param acao the acao
    * @return the acao that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao deleteAcao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _acaoLocalService.deleteAcao(acao);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _acaoLocalService.dynamicQuery();
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
        return _acaoLocalService.dynamicQuery(dynamicQuery);
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
        return _acaoLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _acaoLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _acaoLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao fetchAcao(
        long acaoId) throws com.liferay.portal.kernel.exception.SystemException {
        return _acaoLocalService.fetchAcao(acaoId);
    }

    /**
    * Returns the acao with the primary key.
    *
    * @param acaoId the primary key of the acao
    * @return the acao
    * @throws PortalException if a acao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao getAcao(
        long acaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _acaoLocalService.getAcao(acaoId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _acaoLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the acaos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of acaos
    * @param end the upper bound of the range of acaos (not inclusive)
    * @return the range of acaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> getAcaos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _acaoLocalService.getAcaos(start, end);
    }

    /**
    * Returns the number of acaos.
    *
    * @return the number of acaos
    * @throws SystemException if a system exception occurred
    */
    public int getAcaosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _acaoLocalService.getAcaosCount();
    }

    /**
    * Updates the acao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param acao the acao
    * @return the acao that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao updateAcao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _acaoLocalService.updateAcao(acao);
    }

    /**
    * Updates the acao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param acao the acao
    * @param merge whether to merge the acao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the acao that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao updateAcao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao acao,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _acaoLocalService.updateAcao(acao, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _acaoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _acaoLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _acaoLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    public void excluirAcao(long acaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _acaoLocalService.excluirAcao(acaoId);
    }

    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Acao> getAcoesByFaseId(
        long faseId) throws com.liferay.portal.kernel.exception.SystemException {
        return _acaoLocalService.getAcoesByFaseId(faseId);
    }

    /**
    * Atualiza a ordem das ações
    *
    * @param faseId
    * @param novaOrdenacao mapa com o id da ação e a nova ordem
    * @throws SystemException
    */
    public void atualizarOrdenacaoDasAcoes(java.lang.Long faseId,
        java.util.Map<java.lang.Long, java.lang.Integer> novaOrdenacao)
        throws com.liferay.portal.kernel.exception.SystemException {
        _acaoLocalService.atualizarOrdenacaoDasAcoes(faseId, novaOrdenacao);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public AcaoLocalService getWrappedAcaoLocalService() {
        return _acaoLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedAcaoLocalService(AcaoLocalService acaoLocalService) {
        _acaoLocalService = acaoLocalService;
    }

    public AcaoLocalService getWrappedService() {
        return _acaoLocalService;
    }

    public void setWrappedService(AcaoLocalService acaoLocalService) {
        _acaoLocalService = acaoLocalService;
    }
}
