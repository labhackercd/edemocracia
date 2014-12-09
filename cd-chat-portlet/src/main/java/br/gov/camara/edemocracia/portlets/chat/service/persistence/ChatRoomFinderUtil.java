package br.gov.camara.edemocracia.portlets.chat.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class ChatRoomFinderUtil {
    private static ChatRoomFinder _finder;

    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findOpenAndEnterableClosedRoomsInCompany(
        long companyId, boolean userLogado)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .findOpenAndEnterableClosedRoomsInCompany(companyId,
            userLogado);
    }

    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean> findAllChatRoomParticipants(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getFinder().findAllChatRoomParticipants(roomId);
    }

    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findScheduledRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().findScheduledRoomsInCompany(companyId);
    }

    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findExportedRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().findExportedRoomsInCompany(companyId);
    }

    public static void removerUsuariosBanidosDeSalasFechadas() {
        getFinder().removerUsuariosBanidosDeSalasFechadas();
    }

    public static void incrementarNumeroMaximoDeParticipantes(long companyId,
        long roomId) {
        getFinder().incrementarNumeroMaximoDeParticipantes(companyId, roomId);
    }

    public static void incrementarNumeroMaximoDeEspioes(long companyId,
        long roomId) {
        getFinder().incrementarNumeroMaximoDeEspioes(companyId, roomId);
    }

    public static ChatRoomFinder getFinder() {
        if (_finder == null) {
            _finder = (ChatRoomFinder) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.chat.service.ClpSerializer.getServletContextName(),
                    ChatRoomFinder.class.getName());

            ReferenceRegistry.registerReference(ChatRoomFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(ChatRoomFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(ChatRoomFinderUtil.class, "_finder");
    }
}
