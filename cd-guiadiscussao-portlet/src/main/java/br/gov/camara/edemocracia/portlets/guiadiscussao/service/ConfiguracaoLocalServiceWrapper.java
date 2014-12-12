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
package br.gov.camara.edemocracia.portlets.guiadiscussao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ConfiguracaoLocalService}.
 * </p>
 *
 * @author    Robson
 * @see       ConfiguracaoLocalService
 * @generated
 */
public class ConfiguracaoLocalServiceWrapper implements ConfiguracaoLocalService,
    ServiceWrapper<ConfiguracaoLocalService> {
    private ConfiguracaoLocalService _configuracaoLocalService;

    public ConfiguracaoLocalServiceWrapper(
        ConfiguracaoLocalService configuracaoLocalService) {
        _configuracaoLocalService = configuracaoLocalService;
    }

    /**
    * Adds the configuracao to the database. Also notifies the appropriate model listeners.
    *
    * @param configuracao the configuracao
    * @return the configuracao that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao addConfiguracao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao configuracao)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _configuracaoLocalService.addConfiguracao(configuracao);
    }

    /**
    * Creates a new configuracao with the primary key. Does not add the configuracao to the database.
    *
    * @param configuracaoId the primary key for the new configuracao
    * @return the new configuracao
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao createConfiguracao(
        long configuracaoId) {
        return _configuracaoLocalService.createConfiguracao(configuracaoId);
    }

    /**
    * Deletes the configuracao with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param configuracaoId the primary key of the configuracao
    * @return the configuracao that was removed
    * @throws PortalException if a configuracao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao deleteConfiguracao(
        long configuracaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _configuracaoLocalService.deleteConfiguracao(configuracaoId);
    }

    /**
    * Deletes the configuracao from the database. Also notifies the appropriate model listeners.
    *
    * @param configuracao the configuracao
    * @return the configuracao that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao deleteConfiguracao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao configuracao)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _configuracaoLocalService.deleteConfiguracao(configuracao);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _configuracaoLocalService.dynamicQuery();
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
        return _configuracaoLocalService.dynamicQuery(dynamicQuery);
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
        return _configuracaoLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _configuracaoLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _configuracaoLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao fetchConfiguracao(
        long configuracaoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _configuracaoLocalService.fetchConfiguracao(configuracaoId);
    }

    /**
    * Returns the configuracao with the primary key.
    *
    * @param configuracaoId the primary key of the configuracao
    * @return the configuracao
    * @throws PortalException if a configuracao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao getConfiguracao(
        long configuracaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _configuracaoLocalService.getConfiguracao(configuracaoId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _configuracaoLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao> getConfiguracaos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _configuracaoLocalService.getConfiguracaos(start, end);
    }

    /**
    * Returns the number of configuracaos.
    *
    * @return the number of configuracaos
    * @throws SystemException if a system exception occurred
    */
    public int getConfiguracaosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _configuracaoLocalService.getConfiguracaosCount();
    }

    /**
    * Updates the configuracao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param configuracao the configuracao
    * @return the configuracao that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao updateConfiguracao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao configuracao)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _configuracaoLocalService.updateConfiguracao(configuracao);
    }

    /**
    * Updates the configuracao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param configuracao the configuracao
    * @param merge whether to merge the configuracao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the configuracao that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao updateConfiguracao(
        br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao configuracao,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _configuracaoLocalService.updateConfiguracao(configuracao, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _configuracaoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _configuracaoLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _configuracaoLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao getByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _configuracaoLocalService.getByGroupId(groupId);
    }

    public void marcarFaseComoAtual(long faseId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _configuracaoLocalService.marcarFaseComoAtual(faseId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ConfiguracaoLocalService getWrappedConfiguracaoLocalService() {
        return _configuracaoLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedConfiguracaoLocalService(
        ConfiguracaoLocalService configuracaoLocalService) {
        _configuracaoLocalService = configuracaoLocalService;
    }

    public ConfiguracaoLocalService getWrappedService() {
        return _configuracaoLocalService;
    }

    public void setWrappedService(
        ConfiguracaoLocalService configuracaoLocalService) {
        _configuracaoLocalService = configuracaoLocalService;
    }
}
