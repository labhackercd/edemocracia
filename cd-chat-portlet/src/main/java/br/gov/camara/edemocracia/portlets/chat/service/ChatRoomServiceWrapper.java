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
package br.gov.camara.edemocracia.portlets.chat.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ChatRoomService}.
 * </p>
 *
 * @author    Ricardo Lima
 * @see       ChatRoomService
 * @generated
 */
public class ChatRoomServiceWrapper implements ChatRoomService,
    ServiceWrapper<ChatRoomService> {
    private ChatRoomService _chatRoomService;

    public ChatRoomServiceWrapper(ChatRoomService chatRoomService) {
        _chatRoomService = chatRoomService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _chatRoomService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _chatRoomService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _chatRoomService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * Acrecenta uma sala de bate-papo
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom addChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.addChatRoom(chatRoom);
    }

    /**
    * Exclui uma sala de bate-papo
    *
    * @throws SystemException
    * @throws PortalException
    */
    public void deleteChatRoom(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _chatRoomService.deleteChatRoom(roomId);
    }

    /**
    * Verifica se o usuário pode moderar uma sala
    *
    * @throws SystemException
    * @throws PortalException
    */
    public boolean canModerate(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.canModerate(roomId);
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
    public boolean canJoin(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.canJoin(roomId);
    }

    /**
    * Verifica se pode espiar
    *
    * @param roomId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public boolean canSpy(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.canSpy(roomId);
    }

    /**
    * Obtém o número de usuários na sala
    *
    * @param roomId
    * @return
    * @throws SystemException
    */
    public long getUsersCountInChatRoom(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.getUsersCountInChatRoom(roomId);
    }

    /**
    * Obtém o nome da comunidade em que a sala está
    *
    * @param roomId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    public java.lang.String getChatRoomCommunityName(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.getChatRoomCommunityName(roomId);
    }

    /**
    * Adiciona um usuário autenticado na sala
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addChatUser(
        long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.addChatUser(roomId, timestamp);
    }

    /**
    * Adiciona um usuário anônimo na sala de bate-papo
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addAnonUser(
        long roomId, java.util.Date timestamp, java.lang.String name,
        java.lang.String email, long uf)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.addAnonUser(roomId, timestamp, name, email, uf);
    }

    public br.gov.camara.edemocracia.portlets.chat.service.UserActivityId addSpyUser(
        long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.addSpyUser(roomId, timestamp);
    }

    /**
    * Aprova uma mensagem
    */
    public void approveMessage(long roomId, long messageId, boolean approved,
        java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _chatRoomService.approveMessage(roomId, messageId, approved, timestamp);
    }

    /**
    * Bane um usuário
    */
    public void banUser(long roomId, long chatUserId, java.util.Date timestamp,
        boolean banned)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _chatRoomService.banUser(roomId, chatUserId, timestamp, banned);
    }

    /**
    * Lista todas as salas no grupo
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom[] findAllInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.findAllInGroup(groupId);
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
    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findOpenRoomsInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.findOpenRoomsInGroup(groupId);
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
    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findOpenAndEnterableClosedRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.findOpenAndEnterableClosedRoomsInCompany(companyId);
    }

    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findScheduledRoomsInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.findScheduledRoomsInGroup(groupId);
    }

    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findScheduledRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.findScheduledRoomsInCompany(companyId);
    }

    /**
    * Retorna todas as salas que tiveram seu histórico definido
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findExportedRoomsInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.findExportedRoomsInGroup(groupId);
    }

    /**
    * Retorna todas as salas que tiveram seu histórico definido em uma
    * instancia do portal
    *
    * @param companyId
    * @return
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findExportedRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.findExportedRoomsInCompany(companyId);
    }

    /**
    * Obtém a atualização das informações da sala
    */
    public java.lang.String getJSONUpdate(long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId,
        java.util.Date since, boolean firstUpdate)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.getJSONUpdate(roomId, userActivityId, since,
            firstUpdate);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] getMessagesForExport(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.getMessagesForExport(roomId);
    }

    public java.util.List<br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean> findAllChatRoomParticipants(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.findAllChatRoomParticipants(roomId);
    }

    /**
    * Conta a quantidade de usuários que entrou na sala
    */
    public long getUserCount(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.getUserCount(roomId);
    }

    public void saveExportedMessages(long roomId, java.lang.Long[] messages)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _chatRoomService.saveExportedMessages(roomId, messages);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] getMessagesWithIds(
        long roomId, java.lang.Long[] messages)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.getMessagesWithIds(roomId, messages);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom getRoom(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.getRoom(roomId);
    }

    /**
    * Obtém o usuário de chat a partir do usuário autenticado
    *
    * @throws PortalException
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser getChatUserFromPortalUser(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.getChatUserFromPortalUser(roomId);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] getUsersInChatRoom(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _chatRoomService.getUsersInChatRoom(roomId);
    }

    /**
    * Abre a sala de chat
    */
    public void openChatRoom(long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _chatRoomService.openChatRoom(roomId, timestamp);
    }

    /**
    * Fecha a sala de chat
    *
    * @param roomId
    * @param timestamp
    */
    public void closeChatRoom(long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _chatRoomService.closeChatRoom(roomId, timestamp);
    }

    /**
    * Posta uma nova mensagem
    *
    * Se a sala estiver fechada, ignora a postagem, a não ser que seja
    * moderador
    */
    public void postMessage(
        br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType type,
        long chatUserId, long roomId, java.util.Date timestamp,
        java.lang.String message, boolean pub, boolean admin,
        long recipientUser, int textType)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _chatRoomService.postMessage(type, chatUserId, roomId, timestamp,
            message, pub, admin, recipientUser, textType);
    }

    /**
    * Remove um usuário da sala
    */
    public void removeChatUser(long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId,
        java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _chatRoomService.removeChatUser(roomId, userActivityId, timestamp);
    }

    /**
    * Atualiza a sala
    */
    public void updateChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        _chatRoomService.updateChatRoom(room, merge);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ChatRoomService getWrappedChatRoomService() {
        return _chatRoomService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedChatRoomService(ChatRoomService chatRoomService) {
        _chatRoomService = chatRoomService;
    }

    public ChatRoomService getWrappedService() {
        return _chatRoomService;
    }

    public void setWrappedService(ChatRoomService chatRoomService) {
        _chatRoomService = chatRoomService;
    }
}
