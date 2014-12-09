package br.gov.camara.edemocracia.movetopico.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link MoveTopicoLocalService}.
 * </p>
 *
 * @author    Ricardo Lima
 * @see       MoveTopicoLocalService
 * @generated
 */
public class MoveTopicoLocalServiceWrapper implements MoveTopicoLocalService,
    ServiceWrapper<MoveTopicoLocalService> {
    private MoveTopicoLocalService _moveTopicoLocalService;

    public MoveTopicoLocalServiceWrapper(
        MoveTopicoLocalService moveTopicoLocalService) {
        _moveTopicoLocalService = moveTopicoLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _moveTopicoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _moveTopicoLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.util.List<br.gov.camara.edemocracia.movetopico.model.Topico> getTopicosPorComunidadeEForum(
        long idComunidade, long idForum) {
        return _moveTopicoLocalService.getTopicosPorComunidadeEForum(idComunidade,
            idForum);
    }

    public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getForunsComunidade(
        long idComunidade) {
        return _moveTopicoLocalService.getForunsComunidade(idComunidade);
    }

    public java.util.List<com.liferay.portal.model.Group> getComunidadesComPermissaoParaMover(
        long idUsuario, long idComunidadeOrigem) {
        return _moveTopicoLocalService.getComunidadesComPermissaoParaMover(idUsuario,
            idComunidadeOrigem);
    }

    public void moveTopico(
        br.gov.camara.edemocracia.movetopico.model.InfoMoverTopico info)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _moveTopicoLocalService.moveTopico(info);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public MoveTopicoLocalService getWrappedMoveTopicoLocalService() {
        return _moveTopicoLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedMoveTopicoLocalService(
        MoveTopicoLocalService moveTopicoLocalService) {
        _moveTopicoLocalService = moveTopicoLocalService;
    }

    public MoveTopicoLocalService getWrappedService() {
        return _moveTopicoLocalService;
    }

    public void setWrappedService(MoveTopicoLocalService moveTopicoLocalService) {
        _moveTopicoLocalService = moveTopicoLocalService;
    }
}
