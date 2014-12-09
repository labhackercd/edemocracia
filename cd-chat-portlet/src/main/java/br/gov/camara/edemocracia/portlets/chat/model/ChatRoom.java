package br.gov.camara.edemocracia.portlets.chat.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the ChatRoom service. Represents a row in the &quot;CDChat_ChatRoom&quot; database table, with each column mapped to a property of this class.
 *
 * @author Ricardo Lima
 * @see ChatRoomModel
 * @see br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomImpl
 * @see br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomModelImpl
 * @generated
 */
public interface ChatRoom extends ChatRoomModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public java.lang.String getNameAsFilename();

    /**
    * Verifica se a sala está aberta
    *
    * @param when
    * @return
    */
    public boolean isOpen(java.util.Date when);

    /**
    * Altera política de abertura atualizando outras informações se for necessário
    *
    * @param newOpenPolicy
    * @param openFrom
    * @param openUntil
    */
    public void changeOpenPolicy(
        br.gov.camara.edemocracia.portlets.chat.model.impl.RoomOpenPolicy newOpenPolicy,
        java.util.Date openFrom, java.util.Date openUntil);

    /**
    * Verifica se a sala está aberta no momento atual
    *
    * @return
    */
    public boolean isOpen();
}
