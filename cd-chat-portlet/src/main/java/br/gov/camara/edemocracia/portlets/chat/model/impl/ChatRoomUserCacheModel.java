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
