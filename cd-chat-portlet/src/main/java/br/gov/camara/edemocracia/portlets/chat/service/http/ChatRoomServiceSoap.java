package br.gov.camara.edemocracia.portlets.chat.service.http;

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link br.gov.camara.edemocracia.portlets.chat.model.ChatRoomSoap}.
 * If the method in the service utility returns a
 * {@link br.gov.camara.edemocracia.portlets.chat.model.ChatRoom}, that is translated to a
 * {@link br.gov.camara.edemocracia.portlets.chat.model.ChatRoomSoap}. Methods that SOAP cannot
 * safely wire are skipped.
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
 * @author    Ricardo Lima
 * @see       ChatRoomServiceHttp
 * @see       br.gov.camara.edemocracia.portlets.chat.model.ChatRoomSoap
 * @see       br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil
 * @generated
 */
public class ChatRoomServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(ChatRoomServiceSoap.class);

    /**
    * Acrecenta uma sala de bate-papo
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomSoap addChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomSoap chatRoom)
        throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.model.ChatRoom returnValue = ChatRoomServiceUtil.addChatRoom(br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomModelImpl.toModel(
                        chatRoom));

            return br.gov.camara.edemocracia.portlets.chat.model.ChatRoomSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Exclui uma sala de bate-papo
    *
    * @throws SystemException
    * @throws PortalException
    */
    public static void deleteChatRoom(long roomId) throws RemoteException {
        try {
            ChatRoomServiceUtil.deleteChatRoom(roomId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Verifica se o usuário pode moderar uma sala
    *
    * @throws SystemException
    * @throws PortalException
    */
    public static boolean canModerate(long roomId) throws RemoteException {
        try {
            boolean returnValue = ChatRoomServiceUtil.canModerate(roomId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
    public static boolean canJoin(long roomId) throws RemoteException {
        try {
            boolean returnValue = ChatRoomServiceUtil.canJoin(roomId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Verifica se pode espiar
    *
    * @param roomId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public static boolean canSpy(long roomId) throws RemoteException {
        try {
            boolean returnValue = ChatRoomServiceUtil.canSpy(roomId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Obtém o número de usuários na sala
    *
    * @param roomId
    * @return
    * @throws SystemException
    */
    public static long getUsersCountInChatRoom(long roomId)
        throws RemoteException {
        try {
            long returnValue = ChatRoomServiceUtil.getUsersCountInChatRoom(roomId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
        throws RemoteException {
        try {
            java.lang.String returnValue = ChatRoomServiceUtil.getChatRoomCommunityName(roomId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Adiciona um usuário autenticado na sala
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUserSoap addChatUser(
        long roomId, java.util.Date timestamp) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser returnValue =
                ChatRoomServiceUtil.addChatUser(roomId, timestamp);

            return br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUserSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Adiciona um usuário anônimo na sala de bate-papo
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUserSoap addAnonUser(
        long roomId, java.util.Date timestamp, java.lang.String name,
        java.lang.String email, long uf) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser returnValue =
                ChatRoomServiceUtil.addAnonUser(roomId, timestamp, name, email,
                    uf);

            return br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUserSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static br.gov.camara.edemocracia.portlets.chat.service.UserActivityId addSpyUser(
        long roomId, java.util.Date timestamp) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.service.UserActivityId returnValue =
                ChatRoomServiceUtil.addSpyUser(roomId, timestamp);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Aprova uma mensagem
    */
    public static void approveMessage(long roomId, long messageId,
        boolean approved, java.util.Date timestamp) throws RemoteException {
        try {
            ChatRoomServiceUtil.approveMessage(roomId, messageId, approved,
                timestamp);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Bane um usuário
    */
    public static void banUser(long roomId, long chatUserId,
        java.util.Date timestamp, boolean banned) throws RemoteException {
        try {
            ChatRoomServiceUtil.banUser(roomId, chatUserId, timestamp, banned);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Lista todas as salas no grupo
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomSoap[] findAllInGroup(
        long groupId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.model.ChatRoom[] returnValue =
                ChatRoomServiceUtil.findAllInGroup(groupId);

            return br.gov.camara.edemocracia.portlets.chat.model.ChatRoomSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
        long groupId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] returnValue = ChatRoomServiceUtil.findOpenRoomsInGroup(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
        long companyId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] returnValue = ChatRoomServiceUtil.findOpenAndEnterableClosedRoomsInCompany(companyId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findScheduledRoomsInGroup(
        long groupId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] returnValue = ChatRoomServiceUtil.findScheduledRoomsInGroup(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findScheduledRoomsInCompany(
        long companyId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] returnValue = ChatRoomServiceUtil.findScheduledRoomsInCompany(companyId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Retorna todas as salas que tiveram seu histórico definido
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    public static br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findExportedRoomsInGroup(
        long groupId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] returnValue = ChatRoomServiceUtil.findExportedRoomsInGroup(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
        long companyId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] returnValue = ChatRoomServiceUtil.findExportedRoomsInCompany(companyId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Obtém a atualização das informações da sala
    */
    public static java.lang.String getJSONUpdate(long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId,
        java.util.Date since, boolean firstUpdate) throws RemoteException {
        try {
            java.lang.String returnValue = ChatRoomServiceUtil.getJSONUpdate(roomId,
                    userActivityId, since, firstUpdate);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessageSoap[] getMessagesForExport(
        long roomId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] returnValue =
                ChatRoomServiceUtil.getMessagesForExport(roomId);

            return br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessageSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean[] findAllChatRoomParticipants(
        long roomId) throws RemoteException {
        try {
            java.util.List<br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean> returnValue =
                ChatRoomServiceUtil.findAllChatRoomParticipants(roomId);

            return returnValue.toArray(new br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Conta a quantidade de usuários que entrou na sala
    */
    public static long getUserCount(long roomId) throws RemoteException {
        try {
            long returnValue = ChatRoomServiceUtil.getUserCount(roomId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void saveExportedMessages(long roomId,
        java.lang.Long[] messages) throws RemoteException {
        try {
            ChatRoomServiceUtil.saveExportedMessages(roomId, messages);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessageSoap[] getMessagesWithIds(
        long roomId, java.lang.Long[] messages) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] returnValue =
                ChatRoomServiceUtil.getMessagesWithIds(roomId, messages);

            return br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessageSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomSoap getRoom(
        long roomId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.model.ChatRoom returnValue = ChatRoomServiceUtil.getRoom(roomId);

            return br.gov.camara.edemocracia.portlets.chat.model.ChatRoomSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Obtém o usuário de chat a partir do usuário autenticado
    *
    * @throws PortalException
    */
    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUserSoap getChatUserFromPortalUser(
        long roomId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser returnValue =
                ChatRoomServiceUtil.getChatUserFromPortalUser(roomId);

            return br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUserSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUserSoap[] getUsersInChatRoom(
        long roomId) throws RemoteException {
        try {
            br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] returnValue =
                ChatRoomServiceUtil.getUsersInChatRoom(roomId);

            return br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUserSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Abre a sala de chat
    */
    public static void openChatRoom(long roomId, java.util.Date timestamp)
        throws RemoteException {
        try {
            ChatRoomServiceUtil.openChatRoom(roomId, timestamp);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Fecha a sala de chat
    *
    * @param roomId
    * @param timestamp
    */
    public static void closeChatRoom(long roomId, java.util.Date timestamp)
        throws RemoteException {
        try {
            ChatRoomServiceUtil.closeChatRoom(roomId, timestamp);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
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
        long recipientUser, int textType) throws RemoteException {
        try {
            ChatRoomServiceUtil.postMessage(type, chatUserId, roomId,
                timestamp, message, pub, admin, recipientUser, textType);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Remove um usuário da sala
    */
    public static void removeChatUser(long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId,
        java.util.Date timestamp) throws RemoteException {
        try {
            ChatRoomServiceUtil.removeChatUser(roomId, userActivityId, timestamp);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    /**
    * Atualiza a sala
    */
    public static void updateChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoomSoap room,
        boolean merge) throws RemoteException {
        try {
            ChatRoomServiceUtil.updateChatRoom(br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomModelImpl.toModel(
                    room), merge);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
