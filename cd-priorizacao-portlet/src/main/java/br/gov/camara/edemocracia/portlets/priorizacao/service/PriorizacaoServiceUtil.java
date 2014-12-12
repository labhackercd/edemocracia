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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the priorizacao remote service. This utility wraps {@link br.gov.camara.edemocracia.portlets.priorizacao.service.impl.PriorizacaoServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author robson
 * @see PriorizacaoService
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.base.PriorizacaoServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.impl.PriorizacaoServiceImpl
 * @generated
 */
public class PriorizacaoServiceUtil {
    private static PriorizacaoService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.priorizacao.service.impl.PriorizacaoServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
    * Obtém um eixo com o identificador informado
    *
    * @param eixoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo getEixo(
        long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEixo(eixoId);
    }

    /**
    * Lista todos os eixos da comunidade
    *
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> listarEixos(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().listarEixos(groupId);
    }

    /**
    * Lista as propostas e seu estado, de um eixo específico
    *
    * @param eixoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay> listarPropostaDisplay(
        long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().listarPropostaDisplay(eixoId);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo addEixo(
        long groupId, long categoryId, java.lang.String sumario,
        java.lang.String titulo, long eixoAnteriorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addEixo(groupId, categoryId, sumario, titulo, eixoAnteriorId);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo updateEixo(
        long eixoId, java.lang.String sumario, java.lang.String titulo,
        long eixoAnteriorId, long categoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateEixo(eixoId, sumario, titulo, eixoAnteriorId,
            categoryId);
    }

    /**
    * Remove o eixo com identificador informado e suas respectivas propostas
    *
    * @param eixoId
    * @throws PortalException
    * @throws SystemException
    */
    public static void deleteEixo(long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteEixo(eixoId);
    }

    /**
    * Obtém a proposta com identificador informado
    *
    * @param propostaId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta getProposta(
        long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getProposta(propostaId);
    }

    /**
    * Lista todas as propostas do eixo especificado
    *
    * @param eixoId
    * @return
    * @throws SystemException
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> listarPropostasPorEixoId(
        long eixoId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().listarPropostasPorEixoId(eixoId);
    }

    /**
    * Remove a proposta e os votos vinculados a proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public static void deleteProposta(long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteProposta(propostaId);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta updateProposta(
        long propostaId, long eixoId, java.lang.String ementa,
        java.lang.String texto, long threadId, java.lang.String identificador)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateProposta(propostaId, eixoId, ementa, texto, threadId,
            identificador);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta addProposta(
        long groupId, long eixoId, java.lang.String ementa,
        java.lang.String texto, long threadId, java.lang.String identificador)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addProposta(groupId, eixoId, ementa, texto, threadId,
            identificador);
    }

    /**
    * Adiciona um voto na proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public static void addVoto(long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().addVoto(propostaId);
    }

    /**
    * Remove um voto na proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public static void deleteVoto(long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteVoto(propostaId);
    }

    /**
    * Obtém a categoria especificada
    *
    * @param categoryId
    * @return
    */
    public static com.liferay.portlet.messageboards.model.MBCategory getMBCategory(
        long categoryId) {
        return getService().getMBCategory(categoryId);
    }

    /**
    * Lista as categorias da comunidade
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    public static java.util.List<com.liferay.portlet.messageboards.model.MBCategory> listarCategorias(
        long groupId, long parentCategoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().listarCategorias(groupId, parentCategoryId);
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
    public static java.util.List<com.liferay.portlet.messageboards.model.MBThread> listarTopicosPorCategoryId(
        long groupId, long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().listarTopicosPorCategoryId(groupId, categoryId);
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
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSumarioPriorizacao(groupId, campos);
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
        long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPropostaDisplay(propostaId);
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
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getVotosUsuario(groupId);
    }

    /**
    * Retorna a configuração definida para a comunidade especificada
    *
    * @param scopeGroupId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao getConfiguracaoPorGrupo(
        long scopeGroupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getConfiguracaoPorGrupo(scopeGroupId);
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
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao updateConfiguracao(
        long groupId, int maximoVotos, int maxVotosProposta,
        boolean votacaoAberta)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateConfiguracao(groupId, maximoVotos, maxVotosProposta,
            votacaoAberta);
    }

    /**
    * Retorna a quantidade de eixos cadastrados para a comunidade especificada
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    public static int getEixosCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getEixosCountByGroupId(groupId);
    }

    /**
    * Retorna a quantidade de propostas cadastrada para o eixo especificado
    *
    * @param eixoId
    * @return
    * @throws SystemException
    */
    public static int getPropostasCountByEixoId(long eixoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getPropostasCountByEixoId(eixoId);
    }

    /**
    * Retorna todos os votos realizados na proposta especificada
    * propostaId
    *
    * @param propostaId
    * @return
    * @throws SystemException
    */
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> getVotosPorPropostaId(
        long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getVotosPorPropostaId(propostaId);
    }

    public static void clearService() {
        _service = null;
    }

    public static PriorizacaoService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    PriorizacaoService.class.getName());

            if (invokableService instanceof PriorizacaoService) {
                _service = (PriorizacaoService) invokableService;
            } else {
                _service = new PriorizacaoServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(PriorizacaoServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(PriorizacaoService service) {
    }
}
