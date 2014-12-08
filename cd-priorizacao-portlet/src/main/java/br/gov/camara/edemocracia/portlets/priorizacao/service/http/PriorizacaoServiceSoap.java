package br.gov.camara.edemocracia.portlets.priorizacao.service.http;

import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil} service utility. The
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
 * @see       PriorizacaoServiceHttp
 * @see       br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil
 * @generated
 */
public class PriorizacaoServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(PriorizacaoServiceSoap.class);

    /**
    * Obtém um eixo com o identificador informado
    *
    * @param eixoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.EixoSoap getEixo(
        long eixoId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo returnValue =
                PriorizacaoServiceUtil.getEixo(eixoId);

            return br.gov.camara.edemocracia.portlets.priorizacao.model.EixoSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Lista todos os eixos da comunidade
    *
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo[] listarEixos(
        long groupId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> returnValue =
                PriorizacaoServiceUtil.listarEixos(groupId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Lista as propostas e seu estado, de um eixo específico
    *
    * @param eixoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay[] listarPropostaDisplay(
        long eixoId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay> returnValue =
                PriorizacaoServiceUtil.listarPropostaDisplay(eixoId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Cria um eixo na posição informada
    *
    * @param groupId
    * @param categoryId
    * @param sumario
    * @param titulo
    * @param eixoAnteriorId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.EixoSoap addEixo(
        long groupId, long categoryId, java.lang.String sumario,
        java.lang.String titulo, long eixoAnteriorId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo returnValue =
                PriorizacaoServiceUtil.addEixo(groupId, categoryId, sumario,
                    titulo, eixoAnteriorId);

            return br.gov.camara.edemocracia.portlets.priorizacao.model.EixoSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Atualiza o eixo com o identificador informado
    *
    * @param eixoId
    * @param sumario
    * @param titulo
    * @param eixoAnteriorId
    * @param categoryId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.EixoSoap updateEixo(
        long eixoId, java.lang.String sumario, java.lang.String titulo,
        long eixoAnteriorId, long categoryId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo returnValue =
                PriorizacaoServiceUtil.updateEixo(eixoId, sumario, titulo,
                    eixoAnteriorId, categoryId);

            return br.gov.camara.edemocracia.portlets.priorizacao.model.EixoSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Remove o eixo com identificador informado e suas respectivas propostas
    *
    * @param eixoId
    * @throws PortalException
    * @throws SystemException
    */
    public static void deleteEixo(long eixoId) throws RemoteException {
        try {
            PriorizacaoServiceUtil.deleteEixo(eixoId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Obtém a proposta com identificador informado
    *
    * @param propostaId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.PropostaSoap getProposta(
        long propostaId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta returnValue =
                PriorizacaoServiceUtil.getProposta(propostaId);

            return br.gov.camara.edemocracia.portlets.priorizacao.model.PropostaSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Lista todas as propostas do eixo especificado
    *
    * @param eixoId
    * @return
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta[] listarPropostasPorEixoId(
        long eixoId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> returnValue =
                PriorizacaoServiceUtil.listarPropostasPorEixoId(eixoId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Remove a proposta e os votos vinculados a proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public static void deleteProposta(long propostaId)
        throws RemoteException {
        try {
            PriorizacaoServiceUtil.deleteProposta(propostaId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.PropostaSoap updateProposta(
        long propostaId, long eixoId, java.lang.String ementa,
        java.lang.String texto, long threadId, java.lang.String identificador)
        throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta returnValue =
                PriorizacaoServiceUtil.updateProposta(propostaId, eixoId,
                    ementa, texto, threadId, identificador);

            return br.gov.camara.edemocracia.portlets.priorizacao.model.PropostaSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Cria uma proposta no eixo especificado
    *
    * @param groupId
    * @param eixoId
    * @param ementa
    * @param texto
    * @param threadId
    * @param identificador
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.PropostaSoap addProposta(
        long groupId, long eixoId, java.lang.String ementa,
        java.lang.String texto, long threadId, java.lang.String identificador)
        throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta returnValue =
                PriorizacaoServiceUtil.addProposta(groupId, eixoId, ementa,
                    texto, threadId, identificador);

            return br.gov.camara.edemocracia.portlets.priorizacao.model.PropostaSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Adiciona um voto na proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public static void addVoto(long propostaId) throws RemoteException {
        try {
            PriorizacaoServiceUtil.addVoto(propostaId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Remove um voto na proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public static void deleteVoto(long propostaId) throws RemoteException {
        try {
            PriorizacaoServiceUtil.deleteVoto(propostaId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Obtém a categoria especificada
    *
    * @param categoryId
    * @return
    */
    public static com.liferay.portlet.messageboards.model.MBCategory getMBCategory(
        long categoryId) throws RemoteException {
        try {
            com.liferay.portlet.messageboards.model.MBCategory returnValue = PriorizacaoServiceUtil.getMBCategory(categoryId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Lista as categorias da comunidade
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    public static com.liferay.portlet.messageboards.model.MBCategory[] listarCategorias(
        long groupId, long parentCategoryId) throws RemoteException {
        try {
            java.util.List<com.liferay.portlet.messageboards.model.MBCategory> returnValue =
                PriorizacaoServiceUtil.listarCategorias(groupId,
                    parentCategoryId);

            return returnValue.toArray(new com.liferay.portlet.messageboards.model.MBCategory[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Lista os tópicos da categoria especificada
    *
    * @param groupId
    * @param categoryId
    * @param start
    * @param end
    * @return
    * @throws SystemException
    */
    public static com.liferay.portlet.messageboards.model.MBThread[] listarTopicosPorCategoryId(
        long groupId, long categoryId) throws RemoteException {
        try {
            java.util.List<com.liferay.portlet.messageboards.model.MBThread> returnValue =
                PriorizacaoServiceUtil.listarTopicosPorCategoryId(groupId,
                    categoryId);

            return returnValue.toArray(new com.liferay.portlet.messageboards.model.MBThread[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Lista o sumário da priorização (para gráficos)
    *
    * @param groupId
    * @param campos
    Ordem dos campos que devem ser ordenados. Se vazio, deixa a
    lista em ordem aleatória
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.PriorizacaoSumario getSumarioPriorizacao(
        long groupId,
        br.gov.camara.edemocracia.portlets.priorizacao.OrdemProposta[] campos)
        throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.priorizacao.PriorizacaoSumario returnValue =
                PriorizacaoServiceUtil.getSumarioPriorizacao(groupId, campos);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Obtém as informações para a votação em uma proposta
    *
    * @param propostaId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay getPropostaDisplay(
        long propostaId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay returnValue =
                PriorizacaoServiceUtil.getPropostaDisplay(propostaId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Retorna o número de votos que o usuário já deu e a quantidade de votos disponíveis
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.VotosUsuario getVotosUsuario(
        long groupId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.priorizacao.VotosUsuario returnValue =
                PriorizacaoServiceUtil.getVotosUsuario(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Retorna a configuração definida para a comunidade especificada
    *
    * @param scopeGroupId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.ConfiguracaoSoap getConfiguracaoPorGrupo(
        long scopeGroupId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao returnValue =
                PriorizacaoServiceUtil.getConfiguracaoPorGrupo(scopeGroupId);

            return br.gov.camara.edemocracia.portlets.priorizacao.model.ConfiguracaoSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Atualiza a configuração para a comunidade especificada
    *
    * @param groupId
    * @param maximoVotos
    * @param maxVotosProposta
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.ConfiguracaoSoap updateConfiguracao(
        long groupId, int maximoVotos, int maxVotosProposta,
        boolean votacaoAberta) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao returnValue =
                PriorizacaoServiceUtil.updateConfiguracao(groupId, maximoVotos,
                    maxVotosProposta, votacaoAberta);

            return br.gov.camara.edemocracia.portlets.priorizacao.model.ConfiguracaoSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Retorna a quantidade de eixos cadastrados para a comunidade especificada
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    public static int getEixosCountByGroupId(long groupId)
        throws RemoteException {
        try {
            int returnValue = PriorizacaoServiceUtil.getEixosCountByGroupId(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Retorna a quantidade de propostas cadastrada para o eixo especificado
    *
    * @param eixoId
    * @return
    * @throws SystemException
    */
    public static int getPropostasCountByEixoId(long eixoId)
        throws RemoteException {
        try {
            int returnValue = PriorizacaoServiceUtil.getPropostasCountByEixoId(eixoId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Retorna todos os votos realizados na proposta especificada
    * propostaId
    *
    * @param propostaId
    * @return
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto[] getVotosPorPropostaId(
        long propostaId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> returnValue =
                PriorizacaoServiceUtil.getVotosPorPropostaId(propostaId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.priorizacao.model.Voto[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
