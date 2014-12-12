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
package br.gov.camara.edemocracia.movetopico.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the move topico local service. This utility wraps {@link br.gov.camara.edemocracia.movetopico.service.impl.MoveTopicoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ricardo Lima
 * @see MoveTopicoLocalService
 * @see br.gov.camara.edemocracia.movetopico.service.base.MoveTopicoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.movetopico.service.impl.MoveTopicoLocalServiceImpl
 * @generated
 */
public class MoveTopicoLocalServiceUtil {
    private static MoveTopicoLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.movetopico.service.impl.MoveTopicoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

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

    public static java.util.List<br.gov.camara.edemocracia.movetopico.model.Topico> getTopicosPorComunidadeEForum(
        long idComunidade, long idForum) {
        return getService().getTopicosPorComunidadeEForum(idComunidade, idForum);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getForunsComunidade(
        long idComunidade) {
        return getService().getForunsComunidade(idComunidade);
    }

    public static java.util.List<com.liferay.portal.model.Group> getComunidadesComPermissaoParaMover(
        long idUsuario, long idComunidadeOrigem) {
        return getService()
                   .getComunidadesComPermissaoParaMover(idUsuario,
            idComunidadeOrigem);
    }

    public static void moveTopico(
        br.gov.camara.edemocracia.movetopico.model.InfoMoverTopico info)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().moveTopico(info);
    }

    public static void clearService() {
        _service = null;
    }

    public static MoveTopicoLocalService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MoveTopicoLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    MoveTopicoLocalService.class.getName(), portletClassLoader);

            _service = new MoveTopicoLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(MoveTopicoLocalServiceUtil.class,
                "_service");
            MethodCache.remove(MoveTopicoLocalService.class);
        }

        return _service;
    }

    public void setService(MoveTopicoLocalService service) {
        MethodCache.remove(MoveTopicoLocalService.class);

        _service = service;

        ReferenceRegistry.registerReference(MoveTopicoLocalServiceUtil.class,
            "_service");
        MethodCache.remove(MoveTopicoLocalService.class);
    }
}
