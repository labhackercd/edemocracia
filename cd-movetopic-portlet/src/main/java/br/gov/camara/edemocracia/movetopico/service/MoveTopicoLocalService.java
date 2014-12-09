package br.gov.camara.edemocracia.movetopico.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the move topico local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ricardo Lima
 * @see MoveTopicoLocalServiceUtil
 * @see br.gov.camara.edemocracia.movetopico.service.base.MoveTopicoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.movetopico.service.impl.MoveTopicoLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MoveTopicoLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MoveTopicoLocalServiceUtil} to access the move topico local service. Add custom service methods to {@link br.gov.camara.edemocracia.movetopico.service.impl.MoveTopicoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<br.gov.camara.edemocracia.movetopico.model.Topico> getTopicosPorComunidadeEForum(
        long idComunidade, long idForum);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getForunsComunidade(
        long idComunidade);

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portal.model.Group> getComunidadesComPermissaoParaMover(
        long idUsuario, long idComunidadeOrigem);

    public void moveTopico(
        br.gov.camara.edemocracia.movetopico.model.InfoMoverTopico info)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
