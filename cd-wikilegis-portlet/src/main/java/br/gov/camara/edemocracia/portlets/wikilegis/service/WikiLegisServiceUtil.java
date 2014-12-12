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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the wiki legis remote service. This utility wraps {@link br.gov.camara.edemocracia.portlets.wikilegis.service.impl.WikiLegisServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author robson
 * @see WikiLegisService
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.base.WikiLegisServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.impl.WikiLegisServiceImpl
 * @generated
 */
public class WikiLegisServiceUtil {
    private static WikiLegisService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.wikilegis.service.impl.WikiLegisServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * ObtÃƒÂ©m informaÃƒÂ§ÃƒÂµes para exibiÃƒÂ§ÃƒÂ£o de um artigo
    *
    * @param artigoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay getArtigoDisplay(
        long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getArtigoDisplay(artigoId);
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
    public static java.util.Collection<br.gov.camara.edemocracia.portlets.wikilegis.ElementoDisplay> listaElementos(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().listaElementos(groupId);
    }

    /**
    * Monta a lista de estruturas para visualizaÃƒÂ§ÃƒÂ£o no menu
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.EstruturaDisplay> listaEstrutura(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().listaEstrutura(groupId);
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
    public static void editaArtigo(long artigoId, long estruturaId,
        long anteriorArtigoId, java.lang.String textoArtigo,
        java.lang.String legislacaoVigente)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService()
            .editaArtigo(artigoId, estruturaId, anteriorArtigoId, textoArtigo,
            legislacaoVigente);
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
    public static void excluiArtigo(long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().excluiArtigo(artigoId);
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
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo criaArtigo(
        long groupId, long noId, long anteriorArtigoId,
        java.lang.String textoArtigo, java.lang.String legislacaoVigente)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .criaArtigo(groupId, noId, anteriorArtigoId, textoArtigo,
            legislacaoVigente);
    }

    /**
    * Lista as contribuiÃƒÂ§ÃƒÂµes para o artigo especificado
    *
    * @param artigoId
    * @return
    * @throws SystemException
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> listaContribuicoes(
        long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().listaContribuicoes(artigoId);
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
    public static void adicionaContribuicao(long artigoId,
        java.lang.String textoArtigo, java.lang.String descricao)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().adicionaContribuicao(artigoId, textoArtigo, descricao);
    }

    /**
    * Exclui uma contribuiÃƒÂ§ÃƒÂ£o
    *
    * @param contribuicaoId
    * @throws SystemException
    * @throws PortalException
    */
    public static void removeContribuicao(long contribuicaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().removeContribuicao(contribuicaoId);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> listaEstruturaFilhos(
        long groupId, long paiEstruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().listaEstruturaFilhos(groupId, paiEstruturaId);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> listaArtigos(
        long groupId, long paiEstruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().listaArtigos(groupId, paiEstruturaId);
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
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura criaEstrutura(
        long groupId, long paiId, long antesDeId, java.lang.String nome)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().criaEstrutura(groupId, paiId, antesDeId, nome);
    }

    /**
    * ObtÃƒÂ©m a estrutura com o identificador informado
    *
    * @param estruturaId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura getEstrutura(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEstrutura(estruturaId);
    }

    /**
    * ObtÃƒÂ©m o artigo com o identificador informado
    *
    * @param artigoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo getArtigo(
        long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getArtigo(artigoId);
    }

    /**
    * Atualiza um elemento da estrutura
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura atualizaEstrutura(
        long estruturaId, long groupId, long estruturaPaiId,
        long depoisDeEstruturaId, java.lang.String texto)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .atualizaEstrutura(estruturaId, groupId, estruturaPaiId,
            depoisDeEstruturaId, texto);
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
    public static void postaComentario(long artigoId, long comentarioPaiId,
        java.lang.String texto)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().postaComentario(artigoId, comentarioPaiId, texto);
    }

    /**
    * Exclui um comentÃƒÂ¡rio de uma mensagem
    *
    * @param artigoId
    * @param messageId
    * @throws PortalException
    * @throws SystemException
    */
    public static void excluiComentario(long artigoId, long messageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().excluiComentario(artigoId, messageId);
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
    public static com.liferay.portlet.messageboards.model.MBMessage atualizaComentario(
        java.lang.String body, long artigoId, long messageId, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().atualizaComentario(body, artigoId, messageId, userId);
    }

    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao atualizaContribuicao(
        long contribuicaoId, java.lang.String textoArtigo,
        java.lang.String descricao)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .atualizaContribuicao(contribuicaoId, textoArtigo, descricao);
    }

    /**
    * Retorna uma lista de contribuiÃƒÂ§ÃƒÂµes (wrapper) para exportaÃƒÂ§ÃƒÂ£o
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ContribuicaoWrapper> exportaContribuicoes(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().exportaContribuicoes(groupId);
    }

    /**
    * Retorna uma lista de comentÃƒÂ¡rios (wrapper) para exportaÃƒÂ§ÃƒÂ£o
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ComentarioWrapper> exportaComentarios(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().exportaComentarios(groupId);
    }

    public static void clearService() {
        _service = null;
    }

    public static WikiLegisService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    WikiLegisService.class.getName());

            if (invokableService instanceof WikiLegisService) {
                _service = (WikiLegisService) invokableService;
            } else {
                _service = new WikiLegisServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(WikiLegisServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(WikiLegisService service) {
    }
}
