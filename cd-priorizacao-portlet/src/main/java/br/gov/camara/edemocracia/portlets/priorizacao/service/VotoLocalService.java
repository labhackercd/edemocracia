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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the voto local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author robson
 * @see VotoLocalServiceUtil
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.base.VotoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.impl.VotoLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface VotoLocalService extends BaseLocalService, InvokableLocalService,
    PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link VotoLocalServiceUtil} to access the voto local service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.priorizacao.service.impl.VotoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the voto to the database. Also notifies the appropriate model listeners.
    *
    * @param voto the voto
    * @return the voto that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto addVoto(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new voto with the primary key. Does not add the voto to the database.
    *
    * @param votoId the primary key for the new voto
    * @return the new voto
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto createVoto(
        long votoId);

    /**
    * Deletes the voto with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param votoId the primary key of the voto
    * @return the voto that was removed
    * @throws PortalException if a voto with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto deleteVoto(
        long votoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the voto from the database. Also notifies the appropriate model listeners.
    *
    * @param voto the voto
    * @return the voto that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto deleteVoto(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchVoto(
        long votoId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the voto with the primary key.
    *
    * @param votoId the primary key of the voto
    * @return the voto
    * @throws PortalException if a voto with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto getVoto(
        long votoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the votos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of votos
    * @param end the upper bound of the range of votos (not inclusive)
    * @return the range of votos
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> getVotos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of votos.
    *
    * @return the number of votos
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getVotosCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the voto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param voto the voto
    * @return the voto that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto updateVoto(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the voto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param voto the voto
    * @param merge whether to merge the voto with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the voto that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto updateVoto(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    * Conta os votos por identificador de proposta
    *
    * @param propostaId
    * @return
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getVotosByPropostaId(long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Conta os votos por usuário
    *
    * @param groupId
    * @param userId
    * @return
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getVotosByUsuarioId(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Retorna o número de votos disponíveis de um usuário
    *
    * @param groupId
    * @param userId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getVotosDisponiveisByUsuarioId(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Exclui um voto na propsota especificada
    *
    * @param propostaId
    * @param userId
    * @throws SystemException
    * @throws PortalException
    */
    public void deleteVoto(long propostaId, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adiciona um voto
    *
    * @param propostaId
    * @param userName
    * @param userUuid
    * @param userId
    * @throws SystemException
    * @throws PortalException
    */
    public void addVoto(long propostaId, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Lista os votos do usuário na proposta especificada
    *
    * @param propostaId
    * @param userId
    * @return
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto getVotoPorPropostaIdUserId(
        long propostaId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Verifica se há usuários que colocaram mais votos do que o informado pelo
    * parâmetro.
    *
    * Utilizado para verificar se é possível mudar a configuração
    *
    * @param
    * @param votosPorProposta
    * @return
    */
    public boolean existemUsuariosComMaisVotosPorProposta(long groupId,
        int votosPorProposta)
        throws com.liferay.portal.kernel.exception.SystemException;

    public boolean existemUsuariosComMaisVotos(long groupId, int totalVotos)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Lista todos os votos da proposta especificada
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
