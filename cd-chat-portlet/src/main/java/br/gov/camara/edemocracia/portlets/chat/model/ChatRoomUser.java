package br.gov.camara.edemocracia.portlets.chat.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the ChatRoomUser service. Represents a row in the &quot;CDChat_ChatRoomUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Ricardo Lima
 * @see ChatRoomUserModel
 * @see br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserImpl
 * @see br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserModelImpl
 * @generated
 */
public interface ChatRoomUser extends ChatRoomUserModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public com.liferay.portal.kernel.json.JSONObject getJSON();

    /**
    * Verifica se o usuário é moderador da sala
    *
    * @return
    */
    public boolean isModerator();
}
