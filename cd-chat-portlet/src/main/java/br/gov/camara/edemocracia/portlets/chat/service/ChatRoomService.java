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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * The interface for the chat room remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ricardo Lima
 * @see ChatRoomServiceUtil
 * @see br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ChatRoomService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ChatRoomServiceUtil} to access the chat room remote service. Add custom service methods to {@link br.gov.camara.edemocracia.portlets.chat.service.impl.ChatRoomServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
    * Acrecenta uma sala de bate-papo
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom addChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Exclui uma sala de bate-papo
    *
    * @throws SystemException
    * @throws PortalException
    */
    public void deleteChatRoom(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Verifica se o usuário pode moderar uma sala
    *
    * @throws SystemException
    * @throws PortalException
    */
    public boolean canModerate(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
            com.liferay.portal.kernel.exception.SystemException;

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
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Obtém o número de usuários na sala
    *
    * @param roomId
    * @return
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public long getUsersCountInChatRoom(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Obtém o nome da comunidade em que a sala está
    *
    * @param roomId
    * @return
    * @throws PortalException
    * @throws SystemException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getChatRoomCommunityName(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adiciona um usuário autenticado na sala
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addChatUser(
        long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adiciona um usuário anônimo na sala de bate-papo
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addAnonUser(
        long roomId, java.util.Date timestamp, java.lang.String name,
        java.lang.String email, long uf)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.chat.service.UserActivityId addSpyUser(
        long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Aprova uma mensagem
    */
    public void approveMessage(long roomId, long messageId, boolean approved,
        java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Bane um usuário
    */
    public void banUser(long roomId, long chatUserId, java.util.Date timestamp,
        boolean banned)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Lista todas as salas no grupo
    */
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom[] findAllInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findScheduledRoomsInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findScheduledRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Retorna todas as salas que tiveram seu histórico definido
    *
    * @param groupId
    * @return
    * @throws SystemException
    */
    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findExportedRoomsInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Obtém a atualização das informações da sala
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getJSONUpdate(long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId,
        java.util.Date since, boolean firstUpdate)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] getMessagesForExport(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean> findAllChatRoomParticipants(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Conta a quantidade de usuários que entrou na sala
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public long getUserCount(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public void saveExportedMessages(long roomId, java.lang.Long[] messages)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] getMessagesWithIds(
        long roomId, java.lang.Long[] messages)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom getRoom(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Obtém o usuário de chat a partir do usuário autenticado
    *
    * @throws PortalException
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser getChatUserFromPortalUser(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] getUsersInChatRoom(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Abre a sala de chat
    */
    public void openChatRoom(long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Fecha a sala de chat
    *
    * @param roomId
    * @param timestamp
    */
    public void closeChatRoom(long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Remove um usuário da sala
    */
    public void removeChatUser(long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId,
        java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Atualiza a sala
    */
    public void updateChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;
}
