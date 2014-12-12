/**
 * Copyright (c) 2009-2014 Câmara dos Deputados. Todos os direitos reservados.
 *
 * e-Democracia é um software livre; você pode redistribuí-lo e/ou modificá-lo dentro
 * dos termos da Licença Pública Geral Menor GNU como publicada pela Fundação do 
 * Software Livre (FSF); na versão 2.1 da Licença, ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser  útil, mas SEM NENHUMA GARANTIA;
 * sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR.
 * Veja a Licença Pública Geral Menor GNU para maiores detalhes. 
 */
package br.gov.camara.edemocracia.portlets.graficos.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ContadorAcessoLocalService}.
 * </p>
 *
 * @author    Robson Miranda
 * @see       ContadorAcessoLocalService
 * @generated
 */
public class ContadorAcessoLocalServiceWrapper
    implements ContadorAcessoLocalService,
        ServiceWrapper<ContadorAcessoLocalService> {
    private ContadorAcessoLocalService _contadorAcessoLocalService;

    public ContadorAcessoLocalServiceWrapper(
        ContadorAcessoLocalService contadorAcessoLocalService) {
        _contadorAcessoLocalService = contadorAcessoLocalService;
    }

    /**
    * Adds the contador acesso to the database. Also notifies the appropriate model listeners.
    *
    * @param contadorAcesso the contador acesso
    * @return the contador acesso that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso addContadorAcesso(
        br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso contadorAcesso)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contadorAcessoLocalService.addContadorAcesso(contadorAcesso);
    }

    /**
    * Creates a new contador acesso with the primary key. Does not add the contador acesso to the database.
    *
    * @param contadorId the primary key for the new contador acesso
    * @return the new contador acesso
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso createContadorAcesso(
        long contadorId) {
        return _contadorAcessoLocalService.createContadorAcesso(contadorId);
    }

    /**
    * Deletes the contador acesso with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contadorId the primary key of the contador acesso
    * @return the contador acesso that was removed
    * @throws PortalException if a contador acesso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso deleteContadorAcesso(
        long contadorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contadorAcessoLocalService.deleteContadorAcesso(contadorId);
    }

    /**
    * Deletes the contador acesso from the database. Also notifies the appropriate model listeners.
    *
    * @param contadorAcesso the contador acesso
    * @return the contador acesso that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso deleteContadorAcesso(
        br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso contadorAcesso)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contadorAcessoLocalService.deleteContadorAcesso(contadorAcesso);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _contadorAcessoLocalService.dynamicQuery();
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
        return _contadorAcessoLocalService.dynamicQuery(dynamicQuery);
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
        return _contadorAcessoLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _contadorAcessoLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
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
        return _contadorAcessoLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso fetchContadorAcesso(
        long contadorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contadorAcessoLocalService.fetchContadorAcesso(contadorId);
    }

    /**
    * Returns the contador acesso with the primary key.
    *
    * @param contadorId the primary key of the contador acesso
    * @return the contador acesso
    * @throws PortalException if a contador acesso with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso getContadorAcesso(
        long contadorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contadorAcessoLocalService.getContadorAcesso(contadorId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contadorAcessoLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the contador acessos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of contador acessos
    * @param end the upper bound of the range of contador acessos (not inclusive)
    * @return the range of contador acessos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso> getContadorAcessos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contadorAcessoLocalService.getContadorAcessos(start, end);
    }

    /**
    * Returns the number of contador acessos.
    *
    * @return the number of contador acessos
    * @throws SystemException if a system exception occurred
    */
    public int getContadorAcessosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contadorAcessoLocalService.getContadorAcessosCount();
    }

    /**
    * Updates the contador acesso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contadorAcesso the contador acesso
    * @return the contador acesso that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso updateContadorAcesso(
        br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso contadorAcesso)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contadorAcessoLocalService.updateContadorAcesso(contadorAcesso);
    }

    /**
    * Updates the contador acesso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contadorAcesso the contador acesso
    * @param merge whether to merge the contador acesso with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the contador acesso that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso updateContadorAcesso(
        br.gov.camara.edemocracia.portlets.graficos.model.ContadorAcesso contadorAcesso,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contadorAcessoLocalService.updateContadorAcesso(contadorAcesso,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _contadorAcessoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _contadorAcessoLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _contadorAcessoLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Exporta os dados de uma compania em CSV
    *
    * @param companyId
    * @return
    * @throws SystemException
    */
    public java.lang.String getCSV(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException,
            java.io.IOException {
        return _contadorAcessoLocalService.getCSV(companyId);
    }

    /**
    * ObtÃƒÂ©m os dados consolidados atÃƒÂ© o dia de hoje
    *
    * @param companyId
    * @return
    * @throws SystemException
    */
    public java.util.Map<java.lang.Long, br.gov.camara.edemocracia.portlets.graficos.DadosConsolidados> getDadosConsolidados(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contadorAcessoLocalService.getDadosConsolidados(companyId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ContadorAcessoLocalService getWrappedContadorAcessoLocalService() {
        return _contadorAcessoLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedContadorAcessoLocalService(
        ContadorAcessoLocalService contadorAcessoLocalService) {
        _contadorAcessoLocalService = contadorAcessoLocalService;
    }

    public ContadorAcessoLocalService getWrappedService() {
        return _contadorAcessoLocalService;
    }

    public void setWrappedService(
        ContadorAcessoLocalService contadorAcessoLocalService) {
        _contadorAcessoLocalService = contadorAcessoLocalService;
    }
}
