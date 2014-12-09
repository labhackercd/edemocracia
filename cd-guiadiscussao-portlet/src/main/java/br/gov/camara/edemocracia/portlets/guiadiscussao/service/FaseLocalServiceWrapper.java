package br.gov.camara.edemocracia.portlets.guiadiscussao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link FaseLocalService}.
 * </p>
 *
 * @author    Robson
 * @see       FaseLocalService
 * @generated
 */
public class FaseLocalServiceWrapper implements FaseLocalService,
    ServiceWrapper<FaseLocalService> {
    private FaseLocalService _faseLocalService;

    public FaseLocalServiceWrapper(FaseLocalService faseLocalService) {
        _faseLocalService = faseLocalService;
    }

    /**
    * Adds the fase to the database. Also notifies the appropriate model listeners.
    *
    * @param fase the fase
    * @return the fase that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase addFase(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fase)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _faseLocalService.addFase(fase);
    }

    /**
    * Creates a new fase with the primary key. Does not add the fase to the database.
    *
    * @param faseId the primary key for the new fase
    * @return the new fase
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase createFase(
        long faseId) {
        return _faseLocalService.createFase(faseId);
    }

    /**
    * Deletes the fase with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param faseId the primary key of the fase
    * @return the fase that was removed
    * @throws PortalException if a fase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase deleteFase(
        long faseId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _faseLocalService.deleteFase(faseId);
    }

    /**
    * Deletes the fase from the database. Also notifies the appropriate model listeners.
    *
    * @param fase the fase
    * @return the fase that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase deleteFase(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fase)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _faseLocalService.deleteFase(fase);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _faseLocalService.dynamicQuery();
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
        return _faseLocalService.dynamicQuery(dynamicQuery);
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
        return _faseLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _faseLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _faseLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fetchFase(
        long faseId) throws com.liferay.portal.kernel.exception.SystemException {
        return _faseLocalService.fetchFase(faseId);
    }

    /**
    * Returns the fase with the primary key.
    *
    * @param faseId the primary key of the fase
    * @return the fase
    * @throws PortalException if a fase with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase getFase(
        long faseId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _faseLocalService.getFase(faseId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _faseLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the fases.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of fases
    * @param end the upper bound of the range of fases (not inclusive)
    * @return the range of fases
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> getFases(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _faseLocalService.getFases(start, end);
    }

    /**
    * Returns the number of fases.
    *
    * @return the number of fases
    * @throws SystemException if a system exception occurred
    */
    public int getFasesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _faseLocalService.getFasesCount();
    }

    /**
    * Updates the fase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param fase the fase
    * @return the fase that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase updateFase(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fase)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _faseLocalService.updateFase(fase);
    }

    /**
    * Updates the fase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param fase the fase
    * @param merge whether to merge the fase with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the fase that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase updateFase(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fase,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _faseLocalService.updateFase(fase, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _faseLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _faseLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _faseLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase criaFase(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase fase)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _faseLocalService.criaFase(fase);
    }

    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase> getFasesByConfiguracaoId(
        long configuracaoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _faseLocalService.getFasesByConfiguracaoId(configuracaoId);
    }

    public void excluirFase(long faseId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _faseLocalService.excluirFase(faseId);
    }

    public void moverFaseParaCima(long faseId)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.CantFaseMoveUpException,
            com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _faseLocalService.moverFaseParaCima(faseId);
    }

    public void moverFaseParaBaixo(long faseId)
        throws br.gov.camara.edemocracia.portlets.guiadiscussao.CantFaseMoveDownException,
            com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _faseLocalService.moverFaseParaBaixo(faseId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public FaseLocalService getWrappedFaseLocalService() {
        return _faseLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedFaseLocalService(FaseLocalService faseLocalService) {
        _faseLocalService = faseLocalService;
    }

    public FaseLocalService getWrappedService() {
        return _faseLocalService;
    }

    public void setWrappedService(FaseLocalService faseLocalService) {
        _faseLocalService = faseLocalService;
    }
}
