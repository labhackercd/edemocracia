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
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the voto local service. This utility wraps {@link br.gov.camara.edemocracia.portlets.priorizacao.service.impl.VotoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author robson
 * @see VotoLocalService
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.base.VotoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.impl.VotoLocalServiceImpl
 * @generated
 */
public class VotoLocalServiceUtil {
    private static VotoLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.priorizacao.service.impl.VotoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the voto to the database. Also notifies the appropriate model listeners.
    *
    * @param voto the voto
    * @return the voto that was added
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto addVoto(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addVoto(voto);
    }

    /**
    * Creates a new voto with the primary key. Does not add the voto to the database.
    *
    * @param votoId the primary key for the new voto
    * @return the new voto
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto createVoto(
        long votoId) {
        return getService().createVoto(votoId);
    }

    /**
    * Deletes the voto with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param votoId the primary key of the voto
    * @return the voto that was removed
    * @throws PortalException if a voto with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto deleteVoto(
        long votoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteVoto(votoId);
    }

    /**
    * Deletes the voto from the database. Also notifies the appropriate model listeners.
    *
    * @param voto the voto
    * @return the voto that was removed
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto deleteVoto(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteVoto(voto);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto fetchVoto(
        long votoId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchVoto(votoId);
    }

    /**
    * Returns the voto with the primary key.
    *
    * @param votoId the primary key of the voto
    * @return the voto
    * @throws PortalException if a voto with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto getVoto(
        long votoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getVoto(votoId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Voto> getVotos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getVotos(start, end);
    }

    /**
    * Returns the number of votos.
    *
    * @return the number of votos
    * @throws SystemException if a system exception occurred
    */
    public static int getVotosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getVotosCount();
    }

    /**
    * Updates the voto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param voto the voto
    * @return the voto that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto updateVoto(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateVoto(voto);
    }

    /**
    * Updates the voto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param voto the voto
    * @param merge whether to merge the voto with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the voto that was updated
    * @throws SystemException if a system exception occurred
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto updateVoto(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Voto voto,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateVoto(voto, merge);
    }

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
    * Conta os votos por identificador de proposta
    *
    * @param propostaId
    * @return
    * @throws SystemException
    */
    public static int getVotosByPropostaId(long propostaId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getVotosByPropostaId(propostaId);
    }

    /**
    * Conta os votos por usuário
    *
    * @param groupId
    * @param userId
    * @return
    * @throws SystemException
    */
    public static int getVotosByUsuarioId(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getVotosByUsuarioId(groupId, userId);
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
    public static int getVotosDisponiveisByUsuarioId(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getVotosDisponiveisByUsuarioId(groupId, userId);
    }

    /**
    * Exclui um voto na propsota especificada
    *
    * @param propostaId
    * @param userId
    * @throws SystemException
    * @throws PortalException
    */
    public static void deleteVoto(long propostaId, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteVoto(propostaId, userId);
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
    public static void addVoto(long propostaId, long userId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().addVoto(propostaId, userId);
    }

    /**
    * Lista os votos do usuário na proposta especificada
    *
    * @param propostaId
    * @param userId
    * @return
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.priorizacao.model.Voto getVotoPorPropostaIdUserId(
        long propostaId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getVotoPorPropostaIdUserId(propostaId, userId);
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
    public static boolean existemUsuariosComMaisVotosPorProposta(long groupId,
        int votosPorProposta)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .existemUsuariosComMaisVotosPorProposta(groupId,
            votosPorProposta);
    }

    public static boolean existemUsuariosComMaisVotos(long groupId,
        int totalVotos)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().existemUsuariosComMaisVotos(groupId, totalVotos);
    }

    /**
    * Lista todos os votos da proposta especificada
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

    public static VotoLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    VotoLocalService.class.getName());

            if (invokableLocalService instanceof VotoLocalService) {
                _service = (VotoLocalService) invokableLocalService;
            } else {
                _service = new VotoLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(VotoLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(VotoLocalService service) {
    }
}
