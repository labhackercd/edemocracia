package br.gov.camara.edemocracia.portlets.wikilegis.service.http;

import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    robson
 * @see       WikiLegisServiceHttp
 * @see       br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil
 * @generated
 */
public class WikiLegisServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(WikiLegisServiceSoap.class);

    /**
    * ObtÃ©m informaÃ§Ãµes para exibiÃ§Ã£o de um artigo
    *
    * @param artigoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay getArtigoDisplay(
        long artigoId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay returnValue =
                WikiLegisServiceUtil.getArtigoDisplay(artigoId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
        long groupId) throws RemoteException {
        try {
            java.util.Collection<br.gov.camara.edemocracia.portlets.wikilegis.ElementoDisplay> returnValue =
                WikiLegisServiceUtil.listaElementos(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Monta a lista de estruturas para visualizaÃ§Ã£o no menu
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.EstruturaDisplay[] listaEstrutura(
        long groupId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.EstruturaDisplay> returnValue =
                WikiLegisServiceUtil.listaEstrutura(groupId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.wikilegis.EstruturaDisplay[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

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
    public static void editaArtigo(long artigoId, long estruturaId,
        long anteriorArtigoId, java.lang.String textoArtigo,
        java.lang.String legislacaoVigente) throws RemoteException {
        try {
            WikiLegisServiceUtil.editaArtigo(artigoId, estruturaId,
                anteriorArtigoId, textoArtigo, legislacaoVigente);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Exclui um artigo
    *
    * TODO Verificar permissÃµes no modelo
    *
    * @param artigoId
    * @throws SystemException
    * @throws PortalException
    */
    public static void excluiArtigo(long artigoId) throws RemoteException {
        try {
            WikiLegisServiceUtil.excluiArtigo(artigoId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
    * @return Artigo o artigo recÃ©m-criado
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.ArtigoSoap criaArtigo(
        long groupId, long noId, long anteriorArtigoId,
        java.lang.String textoArtigo, java.lang.String legislacaoVigente)
        throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo returnValue =
                WikiLegisServiceUtil.criaArtigo(groupId, noId,
                    anteriorArtigoId, textoArtigo, legislacaoVigente);

            return br.gov.camara.edemocracia.portlets.wikilegis.model.ArtigoSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Lista as contribuiÃ§Ãµes para o artigo especificado
    *
    * @param artigoId
    * @return
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao[] listaContribuicoes(
        long artigoId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao> returnValue =
                WikiLegisServiceUtil.listaContribuicoes(artigoId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Adiciona uma contribuiÃ§Ã£o no artigo especificado
    *
    * @param artigoId
    * @param textoArtigo
    * @param descricao
    * @throws SystemException
    * @throws PortalException
    */
    public static void adicionaContribuicao(long artigoId,
        java.lang.String textoArtigo, java.lang.String descricao)
        throws RemoteException {
        try {
            WikiLegisServiceUtil.adicionaContribuicao(artigoId, textoArtigo,
                descricao);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Exclui uma contribuiÃ§Ã£o
    *
    * @param contribuicaoId
    * @throws SystemException
    * @throws PortalException
    */
    public static void removeContribuicao(long contribuicaoId)
        throws RemoteException {
        try {
            WikiLegisServiceUtil.removeContribuicao(contribuicaoId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Lista os nÃ³s filhos da estrutura
    *
    * @param groupId
    * @param paiEstruturaId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura[] listaEstruturaFilhos(
        long groupId, long paiEstruturaId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> returnValue =
                WikiLegisServiceUtil.listaEstruturaFilhos(groupId,
                    paiEstruturaId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Lista os artigos filhos do nÃ³ de estrutura especificado
    *
    * @param groupId
    * @param paiEstruturaId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo[] listaArtigos(
        long groupId, long paiEstruturaId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo> returnValue =
                WikiLegisServiceUtil.listaArtigos(groupId, paiEstruturaId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

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
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.EstruturaSoap criaEstrutura(
        long groupId, long paiId, long antesDeId, java.lang.String nome)
        throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura returnValue =
                WikiLegisServiceUtil.criaEstrutura(groupId, paiId, antesDeId,
                    nome);

            return br.gov.camara.edemocracia.portlets.wikilegis.model.EstruturaSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * ObtÃ©m a estrutura com o identificador informado
    *
    * @param estruturaId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.EstruturaSoap getEstrutura(
        long estruturaId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura returnValue =
                WikiLegisServiceUtil.getEstrutura(estruturaId);

            return br.gov.camara.edemocracia.portlets.wikilegis.model.EstruturaSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * ObtÃ©m o artigo com o identificador informado
    *
    * @param artigoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.ArtigoSoap getArtigo(
        long artigoId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.wikilegis.model.Artigo returnValue =
                WikiLegisServiceUtil.getArtigo(artigoId);

            return br.gov.camara.edemocracia.portlets.wikilegis.model.ArtigoSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Atualiza um elemento da estrutura
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.model.EstruturaSoap atualizaEstrutura(
        long estruturaId, long groupId, long estruturaPaiId,
        long depoisDeEstruturaId, java.lang.String texto)
        throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura returnValue =
                WikiLegisServiceUtil.atualizaEstrutura(estruturaId, groupId,
                    estruturaPaiId, depoisDeEstruturaId, texto);

            return br.gov.camara.edemocracia.portlets.wikilegis.model.EstruturaSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Acrescenta um comentÃ¡rio
    *
    * @param artigoId
    * @param comentarioPaiId
    * @param texto
    * @throws SystemException
    * @throws PortalException
    */
    public static void postaComentario(long artigoId, long comentarioPaiId,
        java.lang.String texto) throws RemoteException {
        try {
            WikiLegisServiceUtil.postaComentario(artigoId, comentarioPaiId,
                texto);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Exclui um comentÃ¡rio de uma mensagem
    *
    * @param artigoId
    * @param messageId
    * @throws PortalException
    * @throws SystemException
    */
    public static void excluiComentario(long artigoId, long messageId)
        throws RemoteException {
        try {
            WikiLegisServiceUtil.excluiComentario(artigoId, messageId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

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
    public static com.liferay.portlet.messageboards.model.MBMessage atualizaComentario(
        java.lang.String body, long artigoId, long messageId, long userId)
        throws RemoteException {
        try {
            com.liferay.portlet.messageboards.model.MBMessage returnValue = WikiLegisServiceUtil.atualizaComentario(body,
                    artigoId, messageId, userId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static br.gov.camara.edemocracia.portlets.wikilegis.model.ContribuicaoSoap atualizaContribuicao(
        long contribuicaoId, java.lang.String textoArtigo,
        java.lang.String descricao) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.wikilegis.model.Contribuicao returnValue =
                WikiLegisServiceUtil.atualizaContribuicao(contribuicaoId,
                    textoArtigo, descricao);

            return br.gov.camara.edemocracia.portlets.wikilegis.model.ContribuicaoSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Retorna uma lista de contribuiÃ§Ãµes (wrapper) para exportaÃ§Ã£o
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ContribuicaoWrapper[] exportaContribuicoes(
        long groupId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ContribuicaoWrapper> returnValue =
                WikiLegisServiceUtil.exportaContribuicoes(groupId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ContribuicaoWrapper[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Retorna uma lista de comentÃ¡rios (wrapper) para exportaÃ§Ã£o
    */
    public static br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ComentarioWrapper[] exportaComentarios(
        long groupId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ComentarioWrapper> returnValue =
                WikiLegisServiceUtil.exportaComentarios(groupId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.wikilegis.exporter.wrapper.ComentarioWrapper[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
