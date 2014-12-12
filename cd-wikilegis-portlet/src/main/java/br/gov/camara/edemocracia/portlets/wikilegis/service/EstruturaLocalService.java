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
package br.gov.camara.edemocracia.portlets.wikilegis.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the estrutura local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author robson
 * @see EstruturaLocalServiceUtil
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.base.EstruturaLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.wikilegis.service.impl.EstruturaLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface EstruturaLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EstruturaLocalServiceUtil} to access the estrutura local service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.wikilegis.service.impl.EstruturaLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the estrutura to the database. Also notifies the appropriate model listeners.
    *
    * @param estrutura the estrutura
    * @return the estrutura that was added
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura addEstrutura(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new estrutura with the primary key. Does not add the estrutura to the database.
    *
    * @param estruturaId the primary key for the new estrutura
    * @return the new estrutura
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura createEstrutura(
        long estruturaId);

    /**
    * Deletes the estrutura with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param estruturaId the primary key of the estrutura
    * @return the estrutura that was removed
    * @throws PortalException if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura deleteEstrutura(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the estrutura from the database. Also notifies the appropriate model listeners.
    *
    * @param estrutura the estrutura
    * @return the estrutura that was removed
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura deleteEstrutura(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura)
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
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura fetchEstrutura(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the estrutura with the primary key.
    *
    * @param estruturaId the primary key of the estrutura
    * @return the estrutura
    * @throws PortalException if a estrutura with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura getEstrutura(
        long estruturaId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the estruturas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of estruturas
    * @param end the upper bound of the range of estruturas (not inclusive)
    * @return the range of estruturas
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> getEstruturas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of estruturas.
    *
    * @return the number of estruturas
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getEstruturasCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the estrutura in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param estrutura the estrutura
    * @return the estrutura that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura updateEstrutura(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the estrutura in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param estrutura the estrutura
    * @param merge whether to merge the estrutura with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the estrutura that was updated
    * @throws SystemException if a system exception occurred
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura updateEstrutura(
        br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura estrutura,
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
    * Lista todos os nÃ³s
    *
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> listaTodos(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Lista os elementos filhos
    *
    * @param groupId
    * @param estruturaPaiId
    * @return
    * @throws SystemException
    */
    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura> listaFilhos(
        long groupId, long estruturaPaiId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Cria uma nova estrutura
    *
    * @param groupId
    * @param paiEstruturaId
    * @param depoisDeEstruturaId
    * @param texto
    * @throws SystemException
    * @throws PortalException
    * @return Estrutura recÃ©m-criada
    */
    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura criaEstrutura(
        long groupId, long paiEstruturaId, long depoisDeEstruturaId,
        java.lang.String texto)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.wikilegis.model.Estrutura atualizaEstrutura(
        long estruturaId, long groupId, long estruturaPaiId,
        long depoisDeEstruturaId, java.lang.String texto)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
