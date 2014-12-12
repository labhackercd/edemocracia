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
package br.gov.camara.edemocracia.portlets.wikilegis.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EstruturaLocalService}.
 * </p>
 *
 * @author    robson
 * @see       EstruturaLocalService
 * @generated
 */
public class EstruturaLocalServiceWrapper implements EstruturaLocalService,
    ServiceWrapper<EstruturaLocalService> {
    private EstruturaLocalService _estruturaLocalService;

    public EstruturaLocalServiceWrapper(
        EstruturaLocalService estruturaLocalService) {
        _estruturaLocalService = estruturaLocalService;
    }

    /**
    * Adds the estrutura to the database. Also notifies the appropriate model listeners.
    *
    * @param estrutura the estrutura
    * @return the estrutura that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura addEstrutura(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.addEstrutura(estrutura);
    }

    /**
    * Creates a new estrutura with the primary key. Does not add the estrutura to the database.
    *
    * @param estruturaId the primary key for the new estrutura
    * @return the new estrutura
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura createEstrutura(
        long estruturaId) {
        return _estruturaLocalService.createEstrutura(estruturaId);
    }

    /**
    * Deletes the estrutura with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param estruturaId the primary key of the estrutura
    * @return the estrutura that was removed
    * @throws PortalException if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura deleteEstrutura(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.deleteEstrutura(estruturaId);
    }

    /**
    * Deletes the estrutura from the database. Also notifies the appropriate model listeners.
    *
    * @param estrutura the estrutura
    * @return the estrutura that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura deleteEstrutura(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.deleteEstrutura(estrutura);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _estruturaLocalService.dynamicQuery();
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
        return _estruturaLocalService.dynamicQuery(dynamicQuery);
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
        return _estruturaLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _estruturaLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _estruturaLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura fetchEstrutura(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.fetchEstrutura(estruturaId);
    }

    /**
    * Returns the estrutura with the primary key.
    *
    * @param estruturaId the primary key of the estrutura
    * @return the estrutura
    * @throws PortalException if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura getEstrutura(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.getEstrutura(estruturaId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> getEstruturas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.getEstruturas(start, end);
    }

    /**
    * Returns the number of estruturas.
    *
    * @return the number of estruturas
    * @throws SystemException if a system exception occurred
    */
    public int getEstruturasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.getEstruturasCount();
    }

    /**
    * Updates the estrutura in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param estrutura the estrutura
    * @return the estrutura that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura updateEstrutura(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.updateEstrutura(estrutura);
    }

    /**
    * Updates the estrutura in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param estrutura the estrutura
    * @param merge whether to merge the estrutura with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the estrutura that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura updateEstrutura(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.updateEstrutura(estrutura, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _estruturaLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _estruturaLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _estruturaLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Lista todos os nÃƒÂ³s
    *
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> listaTodos(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.listaTodos(groupId);
    }

    /**
    * Lista os elementos filhos
    *
    * @param groupId
    * @param estruturaPaiId
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> listaFilhos(
        long groupId, long estruturaPaiId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.listaFilhos(groupId, estruturaPaiId);
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
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura criaEstrutura(
        long groupId, long paiEstruturaId, long depoisDeEstruturaId,
        java.lang.String texto)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.criaEstrutura(groupId, paiEstruturaId,
            depoisDeEstruturaId, texto);
    }

    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura atualizaEstrutura(
        long estruturaId, long groupId, long estruturaPaiId,
        long depoisDeEstruturaId, java.lang.String texto)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _estruturaLocalService.atualizaEstrutura(estruturaId, groupId,
            estruturaPaiId, depoisDeEstruturaId, texto);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public EstruturaLocalService getWrappedEstruturaLocalService() {
        return _estruturaLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedEstruturaLocalService(
        EstruturaLocalService estruturaLocalService) {
        _estruturaLocalService = estruturaLocalService;
    }

    public EstruturaLocalService getWrappedService() {
        return _estruturaLocalService;
    }

    public void setWrappedService(EstruturaLocalService estruturaLocalService) {
        _estruturaLocalService = estruturaLocalService;
    }
}
