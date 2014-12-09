package br.gov.camara.edemocracia.portlets.chat.model.impl;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing ChatRoomTwitter in entity cache.
 *
 * @author Ricardo Lima
 * @see ChatRoomTwitter
 * @generated
 */
public class ChatRoomTwitterCacheModel implements CacheModel<ChatRoomTwitter>,
    Serializable {
    public long twitterId;
    public String twitterTitle;
    public String twitterDescription;
    public boolean twitterEnabled;
    public String twitterHashtag;
    public String twitterDataWidgetId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{twitterId=");
        sb.append(twitterId);
        sb.append(", twitterTitle=");
        sb.append(twitterTitle);
        sb.append(", twitterDescription=");
        sb.append(twitterDescription);
        sb.append(", twitterEnabled=");
        sb.append(twitterEnabled);
        sb.append(", twitterHashtag=");
        sb.append(twitterHashtag);
        sb.append(", twitterDataWidgetId=");
        sb.append(twitterDataWidgetId);
        sb.append("}");

        return sb.toString();
    }

    public ChatRoomTwitter toEntityModel() {
        ChatRoomTwitterImpl chatRoomTwitterImpl = new ChatRoomTwitterImpl();

        chatRoomTwitterImpl.setTwitterId(twitterId);

        if (twitterTitle == null) {
            chatRoomTwitterImpl.setTwitterTitle(StringPool.BLANK);
        } else {
            chatRoomTwitterImpl.setTwitterTitle(twitterTitle);
        }

        if (twitterDescription == null) {
            chatRoomTwitterImpl.setTwitterDescription(StringPool.BLANK);
        } else {
            chatRoomTwitterImpl.setTwitterDescription(twitterDescription);
        }

        chatRoomTwitterImpl.setTwitterEnabled(twitterEnabled);

        if (twitterHashtag == null) {
            chatRoomTwitterImpl.setTwitterHashtag(StringPool.BLANK);
        } else {
            chatRoomTwitterImpl.setTwitterHashtag(twitterHashtag);
        }

        if (twitterDataWidgetId == null) {
            chatRoomTwitterImpl.setTwitterDataWidgetId(StringPool.BLANK);
        } else {
            chatRoomTwitterImpl.setTwitterDataWidgetId(twitterDataWidgetId);
        }

        chatRoomTwitterImpl.resetOriginalValues();

        return chatRoomTwitterImpl;
    }
}
