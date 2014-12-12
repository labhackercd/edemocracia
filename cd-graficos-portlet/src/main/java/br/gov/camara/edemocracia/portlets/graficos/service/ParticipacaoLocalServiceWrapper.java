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
 * This class is a wrapper for {@link ParticipacaoLocalService}.
 * </p>
 *
 * @author    Robson Miranda
 * @see       ParticipacaoLocalService
 * @generated
 */
public class ParticipacaoLocalServiceWrapper implements ParticipacaoLocalService,
    ServiceWrapper<ParticipacaoLocalService> {
    private ParticipacaoLocalService _participacaoLocalService;

    public ParticipacaoLocalServiceWrapper(
        ParticipacaoLocalService participacaoLocalService) {
        _participacaoLocalService = participacaoLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _participacaoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _participacaoLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _participacaoLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Lista todas as comunidades pÃƒÂºblicas, privadas e restritas da companhia
    *
    * @throws SystemException
    */
    public java.util.List<com.liferay.portal.model.Group> getComunidadesDisponiveis(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _participacaoLocalService.getComunidadesDisponiveis(companyId);
    }

    /**
    * Recupera todos os dados dos usuÃƒÂ¡rios que participaram das comunidades
    * especificadas.
    *
    * @throws SystemException
    * @throws PortalException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO> getDadosComunidade(
        java.util.List<java.lang.Long> groups)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _participacaoLocalService.getDadosComunidade(groups);
    }

    /**
    * Recupera todos os dados dos usuÃƒÂ¡rios que participaram das comunidades
    * especificadas.
    *
    * @throws SystemException
    * @throws PortalException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO> getDadosComunidade(
        java.util.List<java.lang.Long> groups, java.util.Date dataInicio,
        java.util.Date dataFim)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _participacaoLocalService.getDadosComunidade(groups, dataInicio,
            dataFim);
    }

    /**
    * Recupera todos os dados dos usuÃƒÂ¡rios que participaram da comunidade
    * especificada.
    */
    public br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO getDadosComunidade(
        java.lang.Long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _participacaoLocalService.getDadosComunidade(groupId);
    }

    /**
    * Recupera todos os dados dos usuÃƒÂ¡rios que participaram da comunidade
    * especificada dentro do periodo especificado.
    */
    public br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO getDadosComunidade(
        java.lang.Long groupId, java.util.Date dataInicio,
        java.util.Date dataFim)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _participacaoLocalService.getDadosComunidade(groupId,
            dataInicio, dataFim);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ParticipacaoLocalService getWrappedParticipacaoLocalService() {
        return _participacaoLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedParticipacaoLocalService(
        ParticipacaoLocalService participacaoLocalService) {
        _participacaoLocalService = participacaoLocalService;
    }

    public ParticipacaoLocalService getWrappedService() {
        return _participacaoLocalService;
    }

    public void setWrappedService(
        ParticipacaoLocalService participacaoLocalService) {
        _participacaoLocalService = participacaoLocalService;
    }
}
