package br.gov.camara.edemocracia.portlets.graficos.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The interface for the participacao local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robson Miranda
 * @see ParticipacaoLocalServiceUtil
 * @see br.gov.camara.edemocracia.portlets.graficos.service.base.ParticipacaoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.graficos.service.impl.ParticipacaoLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ParticipacaoLocalService extends BaseLocalService,
    InvokableLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ParticipacaoLocalServiceUtil} to access the participacao local service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.graficos.service.impl.ParticipacaoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
    * Lista todas as comunidades pÃºblicas, privadas e restritas da companhia
    *
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portal.model.Group> getComunidadesDisponiveis(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Recupera todos os dados dos usuÃ¡rios que participaram das comunidades
    * especificadas.
    *
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO> getDadosComunidade(
        java.util.List<java.lang.Long> groups)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Recupera todos os dados dos usuÃ¡rios que participaram das comunidades
    * especificadas.
    *
    * @throws SystemException
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO> getDadosComunidade(
        java.util.List<java.lang.Long> groups, java.util.Date dataInicio,
        java.util.Date dataFim)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Recupera todos os dados dos usuÃ¡rios que participaram da comunidade
    * especificada.
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO getDadosComunidade(
        java.lang.Long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Recupera todos os dados dos usuÃ¡rios que participaram da comunidade
    * especificada dentro do periodo especificado.
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.graficos.DadosComunidadeDTO getDadosComunidade(
        java.lang.Long groupId, java.util.Date dataInicio,
        java.util.Date dataFim)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
