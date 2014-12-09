package br.gov.camara.edemocracia.portlets.exportacao.service.http;

import br.gov.camara.edemocracia.portlets.exportacao.service.DadosForumServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link br.gov.camara.edemocracia.portlets.exportacao.service.DadosForumServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    bruno
 * @see       DadosForumServiceHttp
 * @see       br.gov.camara.edemocracia.portlets.exportacao.service.DadosForumServiceUtil
 * @generated
 */
public class DadosForumServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(DadosForumServiceSoap.class);

    /**
    * Retorna os dados para exportaÃ§Ã£o
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.exportacao.wrapper.DadosForumWrapper[] getDadosForumExportacao(
        java.lang.Long groupId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.exportacao.wrapper.DadosForumWrapper> returnValue =
                DadosForumServiceUtil.getDadosForumExportacao(groupId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.exportacao.wrapper.DadosForumWrapper[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Retorna os dados para exportaÃ§Ã£o para administradores
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.exportacao.wrapper.DadosForumAdminWrapper[] getDadosForumAdminExportacao(
        java.lang.Long groupId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.exportacao.wrapper.DadosForumAdminWrapper> returnValue =
                DadosForumServiceUtil.getDadosForumAdminExportacao(groupId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.exportacao.wrapper.DadosForumAdminWrapper[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
