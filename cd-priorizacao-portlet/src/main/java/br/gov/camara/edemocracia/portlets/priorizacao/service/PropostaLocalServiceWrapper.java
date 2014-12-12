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
package br.gov.camara.edemocracia.portlets.priorizacao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PropostaLocalService}.
 * </p>
 *
 * @author    robson
 * @see       PropostaLocalService
 * @generated
 */
public class PropostaLocalServiceWrapper implements PropostaLocalService,
    ServiceWrapper<PropostaLocalService> {
    private PropostaLocalService _propostaLocalService;

    public PropostaLocalServiceWrapper(
        PropostaLocalService propostaLocalService) {
        _propostaLocalService = propostaLocalService;
    }

    /**
    * Adds the proposta to the database. Also notifies the appropriate model listeners.
    *
    * @param proposta the proposta
    * @return the proposta that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta addProposta(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta proposta)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.addProposta(proposta);
    }

    /**
    * Creates a new proposta with the primary key. Does not add the proposta to the database.
    *
    * @param propostaId the primary key for the new proposta
    * @return the new proposta
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta createProposta(
        long propostaId) {
        return _propostaLocalService.createProposta(propostaId);
    }

    /**
    * Deletes the proposta with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param propostaId the primary key of the proposta
    * @return the proposta that was removed
    * @throws PortalException if a proposta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta deleteProposta(
        long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.deleteProposta(propostaId);
    }

    /**
    * Deletes the proposta from the database. Also notifies the appropriate model listeners.
    *
    * @param proposta the proposta
    * @return the proposta that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta deleteProposta(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta proposta)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.deleteProposta(proposta);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _propostaLocalService.dynamicQuery();
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
        return _propostaLocalService.dynamicQuery(dynamicQuery);
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
        return _propostaLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _propostaLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _propostaLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta fetchProposta(
        long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.fetchProposta(propostaId);
    }

    /**
    * Returns the proposta with the primary key.
    *
    * @param propostaId the primary key of the proposta
    * @return the proposta
    * @throws PortalException if a proposta with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta getProposta(
        long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.getProposta(propostaId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the propostas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of propostas
    * @param end the upper bound of the range of propostas (not inclusive)
    * @return the range of propostas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> getPropostas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.getPropostas(start, end);
    }

    /**
    * Returns the number of propostas.
    *
    * @return the number of propostas
    * @throws SystemException if a system exception occurred
    */
    public int getPropostasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.getPropostasCount();
    }

    /**
    * Updates the proposta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param proposta the proposta
    * @return the proposta that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta updateProposta(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta proposta)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.updateProposta(proposta);
    }

    /**
    * Updates the proposta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param proposta the proposta
    * @param merge whether to merge the proposta with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the proposta that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta updateProposta(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta proposta,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.updateProposta(proposta, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _propostaLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _propostaLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _propostaLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Lista todas as propostas vinculadas ao eixo especificado
    *
    * @param eixoId
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> listarPropostasPorEixoId(
        long eixoId) throws com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.listarPropostasPorEixoId(eixoId);
    }

    /**
    * Cria uma proposta
    *
    * @param groupId
    * @param eixoId
    * @param ementa
    * @param texto
    * @param threadId
    * @param identificador
    * @throws PortalException
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta addProposta(
        long groupId, long eixoId, java.lang.String ementa,
        java.lang.String texto, long threadId, java.lang.String identificador)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.addProposta(groupId, eixoId, ementa,
            texto, threadId, identificador);
    }

    /**
    * Atualiza a proposta especificada
    *
    * @param propostaId
    * @param eixoId
    * @param ementa
    * @param texto
    * @param threadId
    * @param identificador
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta updateProposta(
        long propostaId, long eixoId, java.lang.String ementa,
        java.lang.String texto, long threadId, java.lang.String identificador)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.updateProposta(propostaId, eixoId, ementa,
            texto, threadId, identificador);
    }

    /**
    * Deleta a proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public void excluirProposta(long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _propostaLocalService.excluirProposta(propostaId);
    }

    /**
    * Deleta a proposta especificada
    */
    public void excluirProposta(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta proposta)
        throws com.liferay.portal.kernel.exception.SystemException {
        _propostaLocalService.excluirProposta(proposta);
    }

    /**
    * Retorna a quantidade de propostas cadastradas para o eixo especificado
    *
    * @param eixoId
    * @return
    * @throws SystemException
    */
    public int getPropostasCountByEixoId(long eixoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.getPropostasCountByEixoId(eixoId);
    }

    /**
    * Lista o estado da votação para cada proposta, de acordo com as permissões
    * do usuário
    *
    * @param userId
    * @param eixoId
    * @param podeVerVotos
    * @param podeVotar
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay> findPropostaDisplayPorUsuarioEixoId(
        long userId, long eixoId, boolean podeVerVotos, boolean podeVotar)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _propostaLocalService.findPropostaDisplayPorUsuarioEixoId(userId,
            eixoId, podeVerVotos, podeVotar);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public PropostaLocalService getWrappedPropostaLocalService() {
        return _propostaLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedPropostaLocalService(
        PropostaLocalService propostaLocalService) {
        _propostaLocalService = propostaLocalService;
    }

    public PropostaLocalService getWrappedService() {
        return _propostaLocalService;
    }

    public void setWrappedService(PropostaLocalService propostaLocalService) {
        _propostaLocalService = propostaLocalService;
    }
}
