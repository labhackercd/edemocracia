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

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ChatRoomUser in entity cache.
 *
 * @author Ricardo Lima
 * @see ChatRoomUser
 * @generated
 */
public class ChatRoomUserCacheModel implements CacheModel<ChatRoomUser>,
    Serializable {
    public long chatUserId;
    public long chatRoomId;
    public long userId;
    public String userName;
    public long userImgId;
    public long userUF;
    public String userEmail;
    public boolean banned;
    public int userType;
    public long joinedTS;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{chatUserId=");
        sb.append(chatUserId);
        sb.append(", chatRoomId=");
        sb.append(chatRoomId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", userImgId=");
        sb.append(userImgId);
        sb.append(", userUF=");
        sb.append(userUF);
        sb.append(", userEmail=");
        sb.append(userEmail);
        sb.append(", banned=");
        sb.append(banned);
        sb.append(", userType=");
        sb.append(userType);
        sb.append(", joinedTS=");
        sb.append(joinedTS);
        sb.append("}");

        return sb.toString();
    }

    public ChatRoomUser toEntityModel() {
        ChatRoomUserImpl chatRoomUserImpl = new ChatRoomUserImpl();

        chatRoomUserImpl.setChatUserId(chatUserId);
        chatRoomUserImpl.setChatRoomId(chatRoomId);
        chatRoomUserImpl.setUserId(userId);

        if (userName == null) {
            chatRoomUserImpl.setUserName(StringPool.BLANK);
        } else {
            chatRoomUserImpl.setUserName(userName);
        }

        chatRoomUserImpl.setUserImgId(userImgId);
        chatRoomUserImpl.setUserUF(userUF);

        if (userEmail == null) {
            chatRoomUserImpl.setUserEmail(StringPool.BLANK);
        } else {
            chatRoomUserImpl.setUserEmail(userEmail);
        }

        chatRoomUserImpl.setBanned(banned);
        chatRoomUserImpl.setUserType(userType);

        if (joinedTS == Long.MIN_VALUE) {
            chatRoomUserImpl.setJoinedTS(null);
        } else {
            chatRoomUserImpl.setJoinedTS(new Date(joinedTS));
        }

        chatRoomUserImpl.resetOriginalValues();

        return chatRoomUserImpl;
    }
}
