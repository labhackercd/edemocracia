package br.gov.camara.edemocracia.portlets.priorizacao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PriorizacaoService}.
 * </p>
 *
 * @author    robson
 * @see       PriorizacaoService
 * @generated
 */
public class PriorizacaoServiceWrapper implements PriorizacaoService,
    ServiceWrapper<PriorizacaoService> {
    private PriorizacaoService _priorizacaoService;

    public PriorizacaoServiceWrapper(PriorizacaoService priorizacaoService) {
        _priorizacaoService = priorizacaoService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _priorizacaoService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _priorizacaoService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _priorizacaoService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Obtém um eixo com o identificador informado
    *
    * @param eixoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo getEixo(
        long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.getEixo(eixoId);
    }

    /**
    * Lista todos os eixos da comunidade
    *
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> listarEixos(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.listarEixos(groupId);
    }

    /**
    * Lista as propostas e seu estado, de um eixo específico
    *
    * @param eixoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay> listarPropostaDisplay(
        long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.listarPropostaDisplay(eixoId);
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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo addEixo(
        long groupId, long categoryId, java.lang.String sumario,
        java.lang.String titulo, long eixoAnteriorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.addEixo(groupId, categoryId, sumario,
            titulo, eixoAnteriorId);
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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo updateEixo(
        long eixoId, java.lang.String sumario, java.lang.String titulo,
        long eixoAnteriorId, long categoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.updateEixo(eixoId, sumario, titulo,
            eixoAnteriorId, categoryId);
    }

    /**
    * Remove o eixo com identificador informado e suas respectivas propostas
    *
    * @param eixoId
    * @throws PortalException
    * @throws SystemException
    */
    public void deleteEixo(long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _priorizacaoService.deleteEixo(eixoId);
    }

    /**
    * Obtém a proposta com identificador informado
    *
    * @param propostaId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta getProposta(
        long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.getProposta(propostaId);
    }

    /**
    * Lista todas as propostas do eixo especificado
    *
    * @param eixoId
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> listarPropostasPorEixoId(
        long eixoId) throws com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.listarPropostasPorEixoId(eixoId);
    }

    /**
    * Remove a proposta e os votos vinculados a proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public void deleteProposta(long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _priorizacaoService.deleteProposta(propostaId);
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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta updateProposta(
        long propostaId, long eixoId, java.lang.String ementa,
        java.lang.String texto, long threadId, java.lang.String identificador)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.updateProposta(propostaId, eixoId, ementa,
            texto, threadId, identificador);
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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta addProposta(
        long groupId, long eixoId, java.lang.String ementa,
        java.lang.String texto, long threadId, java.lang.String identificador)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.addProposta(groupId, eixoId, ementa, texto,
            threadId, identificador);
    }

    /**
    * Adiciona um voto na proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public void addVoto(long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _priorizacaoService.addVoto(propostaId);
    }

    /**
    * Remove um voto na proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public void deleteVoto(long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _priorizacaoService.deleteVoto(propostaId);
    }

    /**
    * Obtém a categoria especificada
    *
    * @param categoryId
    * @return
    */
    public com.liferay.portlet.messageboards.model.MBCategory getMBCategory(
        long categoryId) {
        return _priorizacaoService.getMBCategory(categoryId);
    }

    /**
    * Lista as categorias da comunidade
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> listarCategorias(
        long groupId, long parentCategoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.listarCategorias(groupId, parentCategoryId);
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
    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> listarTopicosPorCategoryId(
        long groupId, long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.listarTopicosPorCategoryId(groupId,
            categoryId);
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
    public br.gov.camara.edemocracia.portlets.priorizacao.PriorizacaoSumario getSumarioPriorizacao(
        long groupId,
        br.gov.camara.edemocracia.portlets.priorizacao.OrdemProposta[] campos)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.getSumarioPriorizacao(groupId, campos);
    }

    /**
    * Obtém as informações para a votação em uma proposta
    *
    * @param propostaId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay getPropostaDisplay(
        long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.getPropostaDisplay(propostaId);
    }

    /**
    * Retorna o número de votos que o usuário já deu e a quantidade de votos disponíveis
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.VotosUsuario getVotosUsuario(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.getVotosUsuario(groupId);
    }

    /**
    * Retorna a configuração definida para a comunidade especificada
    *
    * @param scopeGroupId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao getConfiguracaoPorGrupo(
        long scopeGroupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.getConfiguracaoPorGrupo(scopeGroupId);
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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao updateConfiguracao(
        long groupId, int maximoVotos, int maxVotosProposta,
        boolean votacaoAberta)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.updateConfiguracao(groupId, maximoVotos,
            maxVotosProposta, votacaoAberta);
    }

    /**
    * Retorna a quantidade de eixos cadastrados para a comunidade especificada
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    public int getEixosCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.getEixosCountByGroupId(groupId);
    }

    /**
    * Retorna a quantidade de propostas cadastrada para o eixo especificado
    *
    * @param eixoId
    * @return
    * @throws SystemException
    */
    public int getPropostasCountByEixoId(long eixoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.getPropostasCountByEixoId(eixoId);
    }

    /**
    * Retorna todos os votos realizados na proposta especificada
    * propostaId
    *
    * @param propostaId
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> getVotosPorPropostaId(
        long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _priorizacaoService.getVotosPorPropostaId(propostaId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public PriorizacaoService getWrappedPriorizacaoService() {
        return _priorizacaoService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedPriorizacaoService(
        PriorizacaoService priorizacaoService) {
        _priorizacaoService = priorizacaoService;
    }

    public PriorizacaoService getWrappedService() {
        return _priorizacaoService;
    }

    public void setWrappedService(PriorizacaoService priorizacaoService) {
        _priorizacaoService = priorizacaoService;
    }
}
