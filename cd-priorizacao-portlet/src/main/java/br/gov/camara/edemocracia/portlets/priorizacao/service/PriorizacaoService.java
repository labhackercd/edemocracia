package br.gov.camara.edemocracia.portlets.priorizacao.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * The interface for the priorizacao remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author robson
 * @see PriorizacaoServiceUtil
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.base.PriorizacaoServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.impl.PriorizacaoServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface PriorizacaoService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PriorizacaoServiceUtil} to access the priorizacao remote service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.priorizacao.service.impl.PriorizacaoServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
    * Obtém um eixo com o identificador informado
    *
    * @param eixoId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo getEixo(
        long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Lista todos os eixos da comunidade
    *
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> listarEixos(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
            com.liferay.portal.kernel.exception.SystemException;

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
            com.liferay.portal.kernel.exception.SystemException;

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
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Remove o eixo com identificador informado e suas respectivas propostas
    *
    * @param eixoId
    * @throws PortalException
    * @throws SystemException
    */
    public void deleteEixo(long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Obtém a proposta com identificador informado
    *
    * @param propostaId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta getProposta(
        long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Lista todas as propostas do eixo especificado
    *
    * @param eixoId
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Proposta> listarPropostasPorEixoId(
        long eixoId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Remove a proposta e os votos vinculados a proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public void deleteProposta(long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
            com.liferay.portal.kernel.exception.SystemException;

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
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adiciona um voto na proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public void addVoto(long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Remove um voto na proposta especificada
    *
    * @param propostaId
    * @throws PortalException
    * @throws SystemException
    */
    public void deleteVoto(long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Obtém a categoria especificada
    *
    * @param categoryId
    * @return
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBCategory getMBCategory(
        long categoryId);

    /**
    * Lista as categorias da comunidade
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> listarCategorias(
        long groupId, long parentCategoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.priorizacao.PriorizacaoSumario getSumarioPriorizacao(
        long groupId,
        br.gov.camara.edemocracia.portlets.priorizacao.OrdemProposta[] campos)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Obtém as informações para a votação em uma proposta
    *
    * @param propostaId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay getPropostaDisplay(
        long propostaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Retorna o número de votos que o usuário já deu e a quantidade de votos disponíveis
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.priorizacao.VotosUsuario getVotosUsuario(
        long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Retorna a configuração definida para a comunidade especificada
    *
    * @param scopeGroupId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Configuracao getConfiguracaoPorGrupo(
        long scopeGroupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Retorna a quantidade de eixos cadastrados para a comunidade especificada
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getEixosCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Retorna a quantidade de propostas cadastrada para o eixo especificado
    *
    * @param eixoId
    * @return
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getPropostasCountByEixoId(long eixoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Retorna todos os votos realizados na proposta especificada
    * propostaId
    *
    * @param propostaId
    * @return
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> getVotosPorPropostaId(
        long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException;
}
