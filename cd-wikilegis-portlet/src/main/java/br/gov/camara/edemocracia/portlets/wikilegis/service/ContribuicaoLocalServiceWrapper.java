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
 * This class is a wrapper for {@link ContribuicaoLocalService}.
 * </p>
 *
 * @author    robson
 * @see       ContribuicaoLocalService
 * @generated
 */
public class ContribuicaoLocalServiceWrapper implements ContribuicaoLocalService,
    ServiceWrapper<ContribuicaoLocalService> {
    private ContribuicaoLocalService _contribuicaoLocalService;

    public ContribuicaoLocalServiceWrapper(
        ContribuicaoLocalService contribuicaoLocalService) {
        _contribuicaoLocalService = contribuicaoLocalService;
    }

    /**
    * Adds the contribuicao to the database. Also notifies the appropriate model listeners.
    *
    * @param contribuicao the contribuicao
    * @return the contribuicao that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao addContribuicao(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao contribuicao)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.addContribuicao(contribuicao);
    }

    /**
    * Creates a new contribuicao with the primary key. Does not add the contribuicao to the database.
    *
    * @param contribuicaoId the primary key for the new contribuicao
    * @return the new contribuicao
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao createContribuicao(
        long contribuicaoId) {
        return _contribuicaoLocalService.createContribuicao(contribuicaoId);
    }

    /**
    * Deletes the contribuicao with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contribuicaoId the primary key of the contribuicao
    * @return the contribuicao that was removed
    * @throws PortalException if a contribuicao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao deleteContribuicao(
        long contribuicaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.deleteContribuicao(contribuicaoId);
    }

    /**
    * Deletes the contribuicao from the database. Also notifies the appropriate model listeners.
    *
    * @param contribuicao the contribuicao
    * @return the contribuicao that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao deleteContribuicao(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao contribuicao)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.deleteContribuicao(contribuicao);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _contribuicaoLocalService.dynamicQuery();
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
        return _contribuicaoLocalService.dynamicQuery(dynamicQuery);
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
        return _contribuicaoLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _contribuicaoLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _contribuicaoLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao fetchContribuicao(
        long contribuicaoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.fetchContribuicao(contribuicaoId);
    }

    /**
    * Returns the contribuicao with the primary key.
    *
    * @param contribuicaoId the primary key of the contribuicao
    * @return the contribuicao
    * @throws PortalException if a contribuicao with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao getContribuicao(
        long contribuicaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.getContribuicao(contribuicaoId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the contribuicaos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of contribuicaos
    * @param end the upper bound of the range of contribuicaos (not inclusive)
    * @return the range of contribuicaos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> getContribuicaos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.getContribuicaos(start, end);
    }

    /**
    * Returns the number of contribuicaos.
    *
    * @return the number of contribuicaos
    * @throws SystemException if a system exception occurred
    */
    public int getContribuicaosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.getContribuicaosCount();
    }

    /**
    * Updates the contribuicao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contribuicao the contribuicao
    * @return the contribuicao that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao updateContribuicao(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao contribuicao)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.updateContribuicao(contribuicao);
    }

    /**
    * Updates the contribuicao in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contribuicao the contribuicao
    * @param merge whether to merge the contribuicao with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the contribuicao that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao updateContribuicao(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao contribuicao,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.updateContribuicao(contribuicao, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _contribuicaoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _contribuicaoLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _contribuicaoLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Lista todas as contribuiÃƒÂ§ÃƒÂµes do artigo
    *
    * @param artigoId
    Lista as contribuiÃƒÂ§ÃƒÂµes do artigo especificado
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> listaContribuicoes(
        long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.listaContribuicoes(artigoId);
    }

    /**
    * Cria uma nova contribuiÃƒÂ§ÃƒÂ£o para o artigo especificado
    *
    * @param userId
    * @param artigoId
    * @param textoArtigo
    * @param descricao
    * @throws SystemException
    * @throws PortalException
    */
    public void criaContribuicao(long userId, long artigoId,
        java.lang.String textoArtigo, java.lang.String descricao)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _contribuicaoLocalService.criaContribuicao(userId, artigoId,
            textoArtigo, descricao);
    }

    /**
    * Conta o nÃƒÂºmero de contribuiÃƒÂ§ÃƒÂµes para um artigo
    *
    * @param artigoId
    * @return
    * @throws SystemException
    */
    public int contaContribuicoes(long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.contaContribuicoes(artigoId);
    }

    /**
    * Atualiza a contribuicao especificada
    *
    * @param contribuicaoId
    * @param textoArtigo
    * @param descricao
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao atualizaContribuicao(
        long contribuicaoId, java.lang.String textoArtigo,
        java.lang.String descricao)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _contribuicaoLocalService.atualizaContribuicao(contribuicaoId,
            textoArtigo, descricao);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ContribuicaoLocalService getWrappedContribuicaoLocalService() {
        return _contribuicaoLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedContribuicaoLocalService(
        ContribuicaoLocalService contribuicaoLocalService) {
        _contribuicaoLocalService = contribuicaoLocalService;
    }

    public ContribuicaoLocalService getWrappedService() {
        return _contribuicaoLocalService;
    }

    public void setWrappedService(
        ContribuicaoLocalService contribuicaoLocalService) {
        _contribuicaoLocalService = contribuicaoLocalService;
    }
}
