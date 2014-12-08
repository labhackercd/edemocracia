package br.gov.camara.edemocracia.portlets.wikilegis.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * The interface for the wiki legis remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author robson
 * @see WikiLegisServiceUtil
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.base.WikiLegisServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.impl.WikiLegisServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface WikiLegisService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link WikiLegisServiceUtil} to access the wiki legis remote service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.wikilegis.service.impl.WikiLegisServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    /**
    * ObtÃ©m informaÃ§Ãµes para exibiÃ§Ã£o de um artigo
    *
    * @param artigoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay getArtigoDisplay(
        long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Monta a lista de estruturas para visualizaÃ§Ã£o no menu
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.EstruturaDisplay> listaEstrutura(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Edita o artigo especificado, criando uma nova versÃ£o
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
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Exclui um artigo
    *
    * TODO Verificar permissÃµes no modelo
    *
    * @param artigoId
    * @throws SystemException
    * @throws PortalException
    */
    public void excluiArtigo(long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Cria um novo artigo
    *
    * @param groupId
    * @param noId
    * @param anteriorArtigoId
    * @param textoArtigo
    * @throws SystemException
    * @throws PortalException
    * @return Artigo o artigo recÃ©m-criado
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo criaArtigo(
        long groupId, long noId, long anteriorArtigoId,
        java.lang.String textoArtigo, java.lang.String legislacaoVigente)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Lista as contribuiÃ§Ãµes para o artigo especificado
    *
    * @param artigoId
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> listaContribuicoes(
        long artigoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adiciona uma contribuiÃ§Ã£o no artigo especificado
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
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Exclui uma contribuiÃ§Ã£o
    *
    * @param contribuicaoId
    * @throws SystemException
    * @throws PortalException
    */
    public void removeContribuicao(long contribuicaoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Lista os nÃ³s filhos da estrutura
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
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Lista os artigos filhos do nÃ³ de estrutura especificado
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
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Cria uma novo nÃ³ na estrutura
    *
    * @param groupId
    * @param paiId
    * @param antesDeId
    * @param nome
    * @throws SystemException
    * @throws PortalException
    * @return Estrutura recÃ©m-criada
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura criaEstrutura(
        long groupId, long paiId, long antesDeId, java.lang.String nome)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * ObtÃ©m a estrutura com o identificador informado
    *
    * @param estruturaId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura getEstrutura(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * ObtÃ©m o artigo com o identificador informado
    *
    * @param artigoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo getArtigo(
        long artigoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Atualiza um elemento da estrutura
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura atualizaEstrutura(
        long estruturaId, long groupId, long estruturaPaiId,
        long depoisDeEstruturaId, java.lang.String texto)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Acrescenta um comentÃ¡rio
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
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Exclui um comentÃ¡rio de uma mensagem
    *
    * @param artigoId
    * @param messageId
    * @throws PortalException
    * @throws SystemException
    */
    public void excluiComentario(long artigoId, long messageId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Atualiza um comentÃ¡rio
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
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao atualizaContribuicao(
        long contribuicaoId, java.lang.String textoArtigo,
        java.lang.String descricao)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Retorna uma lista de contribuiÃ§Ãµes (wrapper) para exportaÃ§Ã£o
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ContribuicaoWrapper> exportaContribuicoes(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Retorna uma lista de comentÃ¡rios (wrapper) para exportaÃ§Ã£o
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ComentarioWrapper> exportaComentarios(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;
}
