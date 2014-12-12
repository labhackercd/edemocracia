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
 * This class is a wrapper for {@link GraficosLocalService}.
 * </p>
 *
 * @author    Robson Miranda
 * @see       GraficosLocalService
 * @generated
 */
public class GraficosLocalServiceWrapper implements GraficosLocalService,
    ServiceWrapper<GraficosLocalService> {
    private GraficosLocalService _graficosLocalService;

    public GraficosLocalServiceWrapper(
        GraficosLocalService graficosLocalService) {
        _graficosLocalService = graficosLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _graficosLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _graficosLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _graficosLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
    * Retorna os usuÃƒÂ¡rios por UF
    *
    * @param companyId
    TODO
    * @param pais
    * @return
    */
    public java.util.Map<java.lang.String, java.lang.Integer> getUsuariosPorUf(
        long companyId, com.liferay.portal.model.Country pais) {
        return _graficosLocalService.getUsuariosPorUf(companyId, pais);
    }

    public java.util.Map<java.lang.String, java.lang.Integer> getUsuariosPorData(
        long companyId, java.util.TimeZone tz, java.util.Date inicio,
        java.util.Date fim) {
        return _graficosLocalService.getUsuariosPorData(companyId, tz, inicio,
            fim);
    }

    /**
    * Busca a atividade na faixa de tempo especificada
    *
    * @param companyId
    * @param inicio
    * @param fim
    * @return
    */
    public java.util.Map<java.lang.String, java.lang.Integer> getAtividadePorData(
        long companyId, java.util.TimeZone tz, java.util.Date inicio,
        java.util.Date fim) {
        return _graficosLocalService.getAtividadePorData(companyId, tz, inicio,
            fim);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public GraficosLocalService getWrappedGraficosLocalService() {
        return _graficosLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedGraficosLocalService(
        GraficosLocalService graficosLocalService) {
        _graficosLocalService = graficosLocalService;
    }

    public GraficosLocalService getWrappedService() {
        return _graficosLocalService;
    }

    public void setWrappedService(GraficosLocalService graficosLocalService) {
        _graficosLocalService = graficosLocalService;
    }
}
