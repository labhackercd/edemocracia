package br.gov.camara.edemocracia.portlets.chat.service.persistence;

public interface ChatRoomFinder {
    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findOpenAndEnterableClosedRoomsInCompany(
        long companyId, boolean userLogado)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean> findAllChatRoomParticipants(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findScheduledRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<br.gov.camara.edemocracia.portlets.chat.model.ChatRoom> findExportedRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public void removerUsuariosBanidosDeSalasFechadas();

    public void incrementarNumeroMaximoDeParticipantes(long companyId,
        long roomId);

    public void incrementarNumeroMaximoDeEspioes(long companyId, long roomId);
}
