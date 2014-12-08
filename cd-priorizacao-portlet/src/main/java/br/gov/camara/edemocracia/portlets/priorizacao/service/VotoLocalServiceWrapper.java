package br.gov.camara.edemocracia.portlets.priorizacao.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VotoLocalService}.
 * </p>
 *
 * @author    robson
 * @see       VotoLocalService
 * @generated
 */
public class VotoLocalServiceWrapper implements VotoLocalService,
    ServiceWrapper<VotoLocalService> {
    private VotoLocalService _votoLocalService;

    public VotoLocalServiceWrapper(VotoLocalService votoLocalService) {
        _votoLocalService = votoLocalService;
    }

    /**
    * Adds the voto to the database. Also notifies the appropriate model listeners.
    *
    * @param voto the voto
    * @return the voto that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto addVoto(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.addVoto(voto);
    }

    /**
    * Creates a new voto with the primary key. Does not add the voto to the database.
    *
    * @param votoId the primary key for the new voto
    * @return the new voto
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto createVoto(
        long votoId) {
        return _votoLocalService.createVoto(votoId);
    }

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
            com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.deleteVoto(votoId);
    }

    /**
    * Deletes the voto from the database. Also notifies the appropriate model listeners.
    *
    * @param voto the voto
    * @return the voto that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto deleteVoto(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.deleteVoto(voto);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _votoLocalService.dynamicQuery();
    }

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
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.dynamicQuery(dynamicQuery);
    }

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
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.dynamicQuery(dynamicQuery, start, end);
    }

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
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.dynamicQueryCount(dynamicQuery);
    }

    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchVoto(
        long votoId) throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.fetchVoto(votoId);
    }

    /**
    * Returns the voto with the primary key.
    *
    * @param votoId the primary key of the voto
    * @return the voto
    * @throws PortalException if a voto with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto getVoto(
        long votoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.getVoto(votoId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.getPersistedModel(primaryKeyObj);
    }

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
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> getVotos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.getVotos(start, end);
    }

    /**
    * Returns the number of votos.
    *
    * @return the number of votos
    * @throws SystemException if a system exception occurred
    */
    public int getVotosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.getVotosCount();
    }

    /**
    * Updates the voto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param voto the voto
    * @return the voto that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto updateVoto(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.updateVoto(voto);
    }

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
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.updateVoto(voto, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _votoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _votoLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _votoLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Conta os votos por identificador de proposta
    *
    * @param propostaId
    * @return
    * @throws SystemException
    */
    public int getVotosByPropostaId(long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.getVotosByPropostaId(propostaId);
    }

    /**
    * Conta os votos por usuário
    *
    * @param groupId
    * @param userId
    * @return
    * @throws SystemException
    */
    public int getVotosByUsuarioId(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.getVotosByUsuarioId(groupId, userId);
    }

    /**
    * Retorna o número de votos disponíveis de um usuário
    *
    * @param groupId
    * @param userId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public int getVotosDisponiveisByUsuarioId(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.getVotosDisponiveisByUsuarioId(groupId, userId);
    }

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
            com.liferay.portal.kernel.exception.SystemException {
        _votoLocalService.deleteVoto(propostaId, userId);
    }

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
            com.liferay.portal.kernel.exception.SystemException {
        _votoLocalService.addVoto(propostaId, userId);
    }

    /**
    * Lista os votos do usuário na proposta especificada
    *
    * @param propostaId
    * @param userId
    * @return
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Voto getVotoPorPropostaIdUserId(
        long propostaId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.getVotoPorPropostaIdUserId(propostaId, userId);
    }

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
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.existemUsuariosComMaisVotosPorProposta(groupId,
            votosPorProposta);
    }

    public boolean existemUsuariosComMaisVotos(long groupId, int totalVotos)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.existemUsuariosComMaisVotos(groupId, totalVotos);
    }

    /**
    * Lista todos os votos da proposta especificada
    *
    * @param propostaId
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> getVotosPorPropostaId(
        long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _votoLocalService.getVotosPorPropostaId(propostaId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public VotoLocalService getWrappedVotoLocalService() {
        return _votoLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedVotoLocalService(VotoLocalService votoLocalService) {
        _votoLocalService = votoLocalService;
    }

    public VotoLocalService getWrappedService() {
        return _votoLocalService;
    }

    public void setWrappedService(VotoLocalService votoLocalService) {
        _votoLocalService = votoLocalService;
    }
}
