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
package br.gov.camara.edemocracia.portlets.chat.model.impl;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ChatRoom in entity cache.
 *
 * @author Ricardo Lima
 * @see ChatRoom
 * @generated
 */
public class ChatRoomCacheModel implements CacheModel<ChatRoom>, Serializable {
    public long roomId;
    public String roomName;
    public String description;
    public int openPolicy;
    public int status;
    public long openFrom;
    public long openUntil;
    public boolean moderated;
    public int capacity;
    public int maxSimultaneousUsersSpying;
    public int maxSimultaneousUsers;
    public boolean anonymousAllowed;
    public long guestId;
    public String guestName;
    public long companyId;
    public long groupId;
    public boolean usePolicyEnabled;
    public String usePolicyURL;
    public long imageId;
    public long videoLiveId;
    public long videoRecordedId;
    public long createDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(45);

        sb.append("{roomId=");
        sb.append(roomId);
        sb.append(", roomName=");
        sb.append(roomName);
        sb.append(", description=");
        sb.append(description);
        sb.append(", openPolicy=");
        sb.append(openPolicy);
        sb.append(", status=");
        sb.append(status);
        sb.append(", openFrom=");
        sb.append(openFrom);
        sb.append(", openUntil=");
        sb.append(openUntil);
        sb.append(", moderated=");
        sb.append(moderated);
        sb.append(", capacity=");
        sb.append(capacity);
        sb.append(", maxSimultaneousUsersSpying=");
        sb.append(maxSimultaneousUsersSpying);
        sb.append(", maxSimultaneousUsers=");
        sb.append(maxSimultaneousUsers);
        sb.append(", anonymousAllowed=");
        sb.append(anonymousAllowed);
        sb.append(", guestId=");
        sb.append(guestId);
        sb.append(", guestName=");
        sb.append(guestName);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", usePolicyEnabled=");
        sb.append(usePolicyEnabled);
        sb.append(", usePolicyURL=");
        sb.append(usePolicyURL);
        sb.append(", imageId=");
        sb.append(imageId);
        sb.append(", videoLiveId=");
        sb.append(videoLiveId);
        sb.append(", videoRecordedId=");
        sb.append(videoRecordedId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append("}");

        return sb.toString();
    }

    public ChatRoom toEntityModel() {
        ChatRoomImpl chatRoomImpl = new ChatRoomImpl();

        chatRoomImpl.setRoomId(roomId);

        if (roomName == null) {
            chatRoomImpl.setRoomName(StringPool.BLANK);
        } else {
            chatRoomImpl.setRoomName(roomName);
        }

        if (description == null) {
            chatRoomImpl.setDescription(StringPool.BLANK);
        } else {
            chatRoomImpl.setDescription(description);
        }

        chatRoomImpl.setOpenPolicy(openPolicy);
        chatRoomImpl.setStatus(status);

        if (openFrom == Long.MIN_VALUE) {
            chatRoomImpl.setOpenFrom(null);
        } else {
            chatRoomImpl.setOpenFrom(new Date(openFrom));
        }

        if (openUntil == Long.MIN_VALUE) {
            chatRoomImpl.setOpenUntil(null);
        } else {
            chatRoomImpl.setOpenUntil(new Date(openUntil));
        }

        chatRoomImpl.setModerated(moderated);
        chatRoomImpl.setCapacity(capacity);
        chatRoomImpl.setMaxSimultaneousUsersSpying(maxSimultaneousUsersSpying);
        chatRoomImpl.setMaxSimultaneousUsers(maxSimultaneousUsers);
        chatRoomImpl.setAnonymousAllowed(anonymousAllowed);
        chatRoomImpl.setGuestId(guestId);

        if (guestName == null) {
            chatRoomImpl.setGuestName(StringPool.BLANK);
        } else {
            chatRoomImpl.setGuestName(guestName);
        }

        chatRoomImpl.setCompanyId(companyId);
        chatRoomImpl.setGroupId(groupId);
        chatRoomImpl.setUsePolicyEnabled(usePolicyEnabled);

        if (usePolicyURL == null) {
            chatRoomImpl.setUsePolicyURL(StringPool.BLANK);
        } else {
            chatRoomImpl.setUsePolicyURL(usePolicyURL);
        }

        chatRoomImpl.setImageId(imageId);
        chatRoomImpl.setVideoLiveId(videoLiveId);
        chatRoomImpl.setVideoRecordedId(videoRecordedId);

        if (createDate == Long.MIN_VALUE) {
            chatRoomImpl.setCreateDate(null);
        } else {
            chatRoomImpl.setCreateDate(new Date(createDate));
        }

        chatRoomImpl.resetOriginalValues();

        return chatRoomImpl;
    }
}
