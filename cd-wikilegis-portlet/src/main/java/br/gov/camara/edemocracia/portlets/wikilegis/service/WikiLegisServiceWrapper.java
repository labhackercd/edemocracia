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
 * This class is a wrapper for {@link WikiLegisService}.
 * </p>
 *
 * @author    robson
 * @see       WikiLegisService
 * @generated
 */
public class WikiLegisServiceWrapper implements WikiLegisService,
    ServiceWrapper<WikiLegisService> {
    private WikiLegisService _wikiLegisService;

    public WikiLegisServiceWrapper(WikiLegisService wikiLegisService) {
        _wikiLegisService = wikiLegisService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _wikiLegisService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _wikiLegisService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _wikiLegisService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * ObtÃƒÂ©m informaÃƒÂ§ÃƒÂµes para exibiÃƒÂ§ÃƒÂ£o de um artigo
    *
    * @param artigoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay getArtigoDisplay(
        long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.getArtigoDisplay(artigoId);
    }

    /**
    * Lista todos os elementos da wikilegis especificada
    *
    * @param companyId
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public java.util.Collection<br.gov.camara.edemocracia.portlets.wikilegis.ElementoDisplay> listaElementos(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.listaElementos(groupId);
    }

    /**
    * Monta a lista de estruturas para visualizaÃƒÂ§ÃƒÂ£o no menu
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.EstruturaDisplay> listaEstrutura(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.listaEstrutura(groupId);
    }

    /**
    * Edita o artigo especificado, criando uma nova versÃƒÂ£o
    *
    * @param artigoId
    * @param estruturaId
    * @param textoArtigo
    * @param legislacaoVigente
    * @param anteriorArtigoId
    * @throws SystemException
    * @throws PortalException
    */
    public void editaArtigo(long artigoId, long estruturaId,
        long anteriorArtigoId, java.lang.String textoArtigo,
        java.lang.String legislacaoVigente)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _wikiLegisService.editaArtigo(artigoId, estruturaId, anteriorArtigoId,
            textoArtigo, legislacaoVigente);
    }

    /**
    * Exclui um artigo
    *
    * TODO Verificar permissÃƒÂµes no modelo
    *
    * @param artigoId
    * @throws SystemException
    * @throws PortalException
    */
    public void excluiArtigo(long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _wikiLegisService.excluiArtigo(artigoId);
    }

    /**
    * Cria um novo artigo
    *
    * @param groupId
    * @param noId
    * @param anteriorArtigoId
    * @param textoArtigo
    * @throws SystemException
    * @throws PortalException
    * @return Artigo o artigo recÃƒÂ©m-criado
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo criaArtigo(
        long groupId, long noId, long anteriorArtigoId,
        java.lang.String textoArtigo, java.lang.String legislacaoVigente)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.criaArtigo(groupId, noId, anteriorArtigoId,
            textoArtigo, legislacaoVigente);
    }

    /**
    * Lista as contribuiÃƒÂ§ÃƒÂµes para o artigo especificado
    *
    * @param artigoId
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> listaContribuicoes(
        long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.listaContribuicoes(artigoId);
    }

    /**
    * Adiciona uma contribuiÃƒÂ§ÃƒÂ£o no artigo especificado
    *
    * @param artigoId
    * @param textoArtigo
    * @param descricao
    * @throws SystemException
    * @throws PortalException
    */
    public void adicionaContribuicao(long artigoId,
        java.lang.String textoArtigo, java.lang.String descricao)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _wikiLegisService.adicionaContribuicao(artigoId, textoArtigo, descricao);
    }

    /**
    * Exclui uma contribuiÃƒÂ§ÃƒÂ£o
    *
    * @param contribuicaoId
    * @throws SystemException
    * @throws PortalException
    */
    public void removeContribuicao(long contribuicaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _wikiLegisService.removeContribuicao(contribuicaoId);
    }

    /**
    * Lista os nÃƒÂ³s filhos da estrutura
    *
    * @param groupId
    * @param paiEstruturaId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> listaEstruturaFilhos(
        long groupId, long paiEstruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.listaEstruturaFilhos(groupId, paiEstruturaId);
    }

    /**
    * Lista os artigos filhos do nÃƒÂ³ de estrutura especificado
    *
    * @param groupId
    * @param paiEstruturaId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> listaArtigos(
        long groupId, long paiEstruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.listaArtigos(groupId, paiEstruturaId);
    }

    /**
    * Cria uma novo nÃƒÂ³ na estrutura
    *
    * @param groupId
    * @param paiId
    * @param antesDeId
    * @param nome
    * @throws SystemException
    * @throws PortalException
    * @return Estrutura recÃƒÂ©m-criada
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura criaEstrutura(
        long groupId, long paiId, long antesDeId, java.lang.String nome)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.criaEstrutura(groupId, paiId, antesDeId, nome);
    }

    /**
    * ObtÃƒÂ©m a estrutura com o identificador informado
    *
    * @param estruturaId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura getEstrutura(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.getEstrutura(estruturaId);
    }

    /**
    * ObtÃƒÂ©m o artigo com o identificador informado
    *
    * @param artigoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo getArtigo(
        long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.getArtigo(artigoId);
    }

    /**
    * Atualiza um elemento da estrutura
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura atualizaEstrutura(
        long estruturaId, long groupId, long estruturaPaiId,
        long depoisDeEstruturaId, java.lang.String texto)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.atualizaEstrutura(estruturaId, groupId,
            estruturaPaiId, depoisDeEstruturaId, texto);
    }

    /**
    * Acrescenta um comentÃƒÂ¡rio
    *
    * @param artigoId
    * @param comentarioPaiId
    * @param texto
    * @throws SystemException
    * @throws PortalException
    */
    public void postaComentario(long artigoId, long comentarioPaiId,
        java.lang.String texto)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _wikiLegisService.postaComentario(artigoId, comentarioPaiId, texto);
    }

    /**
    * Exclui um comentÃƒÂ¡rio de uma mensagem
    *
    * @param artigoId
    * @param messageId
    * @throws PortalException
    * @throws SystemException
    */
    public void excluiComentario(long artigoId, long messageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _wikiLegisService.excluiComentario(artigoId, messageId);
    }

    /**
    * Atualiza um comentÃƒÂ¡rio
    *
    * @param body
    * @param artigoId
    * @param messageId
    * @param userId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public com.liferay.portlet.messageboards.model.MBMessage atualizaComentario(
        java.lang.String body, long artigoId, long messageId, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.atualizaComentario(body, artigoId, messageId,
            userId);
    }

    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao atualizaContribuicao(
        long contribuicaoId, java.lang.String textoArtigo,
        java.lang.String descricao)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.atualizaContribuicao(contribuicaoId,
            textoArtigo, descricao);
    }

    /**
    * Retorna uma lista de contribuiÃƒÂ§ÃƒÂµes (wrapper) para exportaÃƒÂ§ÃƒÂ£o
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ContribuicaoWrapper> exportaContribuicoes(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.exportaContribuicoes(groupId);
    }

    /**
    * Retorna uma lista de comentÃƒÂ¡rios (wrapper) para exportaÃƒÂ§ÃƒÂ£o
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ComentarioWrapper> exportaComentarios(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _wikiLegisService.exportaComentarios(groupId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public WikiLegisService getWrappedWikiLegisService() {
        return _wikiLegisService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedWikiLegisService(WikiLegisService wikiLegisService) {
        _wikiLegisService = wikiLegisService;
    }

    public WikiLegisService getWrappedService() {
        return _wikiLegisService;
    }

    public void setWrappedService(WikiLegisService wikiLegisService) {
        _wikiLegisService = wikiLegisService;
    }
}
