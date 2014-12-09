package br.gov.camara.edemocracia.portlets.chat.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the chat room remote service. This utility wraps {@link br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomService
 * @see br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomServiceImpl
 * @generated
 */
public class ChatRoomServiceUtil {
    private static ChatRoomService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Acrecenta uma sala de bate-papo
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom addChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addChatRoom(chatRoom);
    }

    /**
    * Exclui uma sala de bate-papo
    *
    * @throws SystemException
    * @throws PortalException
    */
    public static void deleteChatRoom(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteChatRoom(roomId);
    }

    /**
    * Verifica se o usuário pode moderar uma sala
    *
    * @throws SystemException
    * @throws PortalException
    */
    public static boolean canModerate(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().canModerate(roomId);
    }

    /**
    * Verifica se o usuário pode entrar na sala.
    *
    * Verifica, através das permissões, se a sala está aberta e da quantidade
    * de usuários na sala, se o usuário pode entrar
    *
    * @param roomId
    * @return
    * @throws SystemException
    * @throws PortalException
    */
    public static boolean canJoin(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().canJoin(roomId);
    }

    /**
    * Verifica se pode espiar
    *
    * @param roomId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static boolean canSpy(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().canSpy(roomId);
    }

    /**
    * Obtém o número de usuários na sala
    *
    * @param roomId
    * @return
    * @throws SystemException
    */
    public static long getUsersCountInChatRoom(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getUsersCountInChatRoom(roomId);
    }

    /**
    * Obtém o nome da comunidade em que a sala está
    *
    * @param roomId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static java.lang.String getChatRoomCommunityName(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getChatRoomCommunityName(roomId);
    }

    /**
    * Adiciona um usuário autenticado na sala
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addChatUser(
        long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addChatUser(roomId, timestamp);
    }

    /**
    * Adiciona um usuário anônimo na sala de bate-papo
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addAnonUser(
        long roomId, java.util.Date timestamp, java.lang.String name,
        java.lang.String email, long uf)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addAnonUser(roomId, timestamp, name, email, uf);
    }

    public static br.gov.camara.edemocracia.portlets.chat.service.UserActivityId addSpyUser(
        long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addSpyUser(roomId, timestamp);
    }

    /**
    * Aprova uma mensagem
    */
    public static void approveMessage(long roomId, long messageId,
        boolean approved, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().approveMessage(roomId, messageId, approved, timestamp);
    }

    /**
    * Bane um usuário
    */
    public static void banUser(long roomId, long chatUserId,
        java.util.Date timestamp, boolean banned)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().banUser(roomId, chatUserId, timestamp, banned);
    }

    /**
    * Lista todas as salas no grupo
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom[] findAllInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findAllInGroup(groupId);
    }

    /**
    * Retorna todas as salas abertas nesta comunidade Para usuários que tem
    * permissão de moderação, retorna também as salas fechadas sem histórico
    * definido
    *
    * @param groupId
    * @return
    * @throws SystemException
    * @throws PrincipalException
    */
    public static br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findOpenRoomsInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findOpenRoomsInGroup(groupId);
    }

    /**
    * Retorna todas as salas abertas na instancia do portal Para usuários que
    * tem permissão de moderação, retorna também as salas fechadas sem
    * histórico definido.
    *
    * @param companyId
    * @return
    * @throws SystemException
    * @throws PrincipalException
    */
    public static br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findOpenAndEnterableClosedRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findOpenAndEnterableClosedRoomsInCompany(companyId);
    }

    public static br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findScheduledRoomsInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findScheduledRoomsInGroup(groupId);
    }

    public static br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findScheduledRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findScheduledRoomsInCompany(companyId);
    }

    /**
    * Retorna todas as salas que tiveram seu histórico definido
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findExportedRoomsInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findExportedRoomsInGroup(groupId);
    }

    /**
    * Retorna todas as salas que tiveram seu histórico definido em uma
    * instancia do portal
    *
    * @param companyId
    * @return
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findExportedRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findExportedRoomsInCompany(companyId);
    }

    /**
    * Obtém a atualização das informações da sala
    */
    public static java.lang.String getJSONUpdate(long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId,
        java.util.Date since, boolean firstUpdate)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getJSONUpdate(roomId, userActivityId, since, firstUpdate);
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] getMessagesForExport(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getMessagesForExport(roomId);
    }

    public static java.util.List<br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean> findAllChatRoomParticipants(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findAllChatRoomParticipants(roomId);
    }

    /**
    * Conta a quantidade de usuários que entrou na sala
    */
    public static long getUserCount(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getUserCount(roomId);
    }

    public static void saveExportedMessages(long roomId,
        java.lang.Long[] messages)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().saveExportedMessages(roomId, messages);
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] getMessagesWithIds(
        long roomId, java.lang.Long[] messages)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getMessagesWithIds(roomId, messages);
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoom getRoom(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getRoom(roomId);
    }

    /**
    * Obtém o usuário de chat a partir do usuário autenticado
    *
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser getChatUserFromPortalUser(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getChatUserFromPortalUser(roomId);
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] getUsersInChatRoom(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getUsersInChatRoom(roomId);
    }

    /**
    * Abre a sala de chat
    */
    public static void openChatRoom(long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().openChatRoom(roomId, timestamp);
    }

    /**
    * Fecha a sala de chat
    *
    * @param roomId
    * @param timestamp
    */
    public static void closeChatRoom(long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().closeChatRoom(roomId, timestamp);
    }

    /**
    * Posta uma nova mensagem
    *
    * Se a sala estiver fechada, ignora a postagem, a não ser que seja
    * moderador
    */
    public static void postMessage(
        br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType type,
        long chatUserId, long roomId, java.util.Date timestamp,
        java.lang.String message, boolean pub, boolean admin,
        long recipientUser, int textType)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService()
            .postMessage(type, chatUserId, roomId, timestamp, message, pub,
            admin, recipientUser, textType);
    }

    /**
    * Remove um usuário da sala
    */
    public static void removeChatUser(long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId,
        java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().removeChatUser(roomId, userActivityId, timestamp);
    }

    /**
    * Atualiza a sala
    */
    public static void updateChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().updateChatRoom(room, merge);
    }

    public static void clearService() {
        _service = null;
    }

    public static ChatRoomService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ChatRoomService.class.getName());

            if (invokableService instanceof ChatRoomService) {
                _service = (ChatRoomService) invokableService;
            } else {
                _service = new ChatRoomServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(ChatRoomServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(ChatRoomService service) {
    }
}
