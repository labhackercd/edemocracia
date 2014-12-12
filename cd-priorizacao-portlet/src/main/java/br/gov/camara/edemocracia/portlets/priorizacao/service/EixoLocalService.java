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
 * The interface for the eixo local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author robson
 * @see EixoLocalServiceUtil
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.base.EixoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.priorizacao.service.impl.EixoLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface EixoLocalService extends BaseLocalService, InvokableLocalService,
    PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EixoLocalServiceUtil} to access the eixo local service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.priorizacao.service.impl.EixoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the eixo to the database. Also notifies the appropriate model listeners.
    *
    * @param eixo the eixo
    * @return the eixo that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo addEixo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new eixo with the primary key. Does not add the eixo to the database.
    *
    * @param eixoId the primary key for the new eixo
    * @return the new eixo
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo createEixo(
        long eixoId);

    /**
    * Deletes the eixo with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param eixoId the primary key of the eixo
    * @return the eixo that was removed
    * @throws PortalException if a eixo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo deleteEixo(
        long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the eixo from the database. Also notifies the appropriate model listeners.
    *
    * @param eixo the eixo
    * @return the eixo that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo deleteEixo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo)
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
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo fetchEixo(
        long eixoId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the eixo with the primary key.
    *
    * @param eixoId the primary key of the eixo
    * @return the eixo
    * @throws PortalException if a eixo with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo getEixo(
        long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the eixos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of eixos
    * @param end the upper bound of the range of eixos (not inclusive)
    * @return the range of eixos
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> getEixos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of eixos.
    *
    * @return the number of eixos
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getEixosCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the eixo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param eixo the eixo
    * @return the eixo that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo updateEixo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the eixo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param eixo the eixo
    * @param merge whether to merge the eixo with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the eixo that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo updateEixo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo,
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
    * Lista todos os eixos
    *
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo> listarEixosPorGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Cria um eixo na posição especificada
    *
    * @param groupId
    * @param categoryId
    * @param sumario
    * @param titulo
    * @param eixoAnteriorId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo addEixo(
        long groupId, long categoryId, java.lang.String sumario,
        java.lang.String titulo, long eixoAnteriorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Atualiza um eixo
    *
    * @param eixoId
    * @param sumario
    * @param titulo
    * @param eixoAnteriorId
    * @param categoryId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo updateEixo(
        long eixoId, java.lang.String sumario, java.lang.String titulo,
        long eixoAnteriorId, long categoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Remove o eixo especificado
    *
    * @param eixo
    * @throws SystemException
    */
    public void excluirEixo(
        br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo eixo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Remove um eixo e suas propostas
    *
    * @param eixoId
    * @throws PortalException
    * @throws SystemException
    */
    public void excluirEixo(long eixoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Retorna o a quantidade de eixos cadastrados na comunidade especificada
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getEixosCountByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;
}
