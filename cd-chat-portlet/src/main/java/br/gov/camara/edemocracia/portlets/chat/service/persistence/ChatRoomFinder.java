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
