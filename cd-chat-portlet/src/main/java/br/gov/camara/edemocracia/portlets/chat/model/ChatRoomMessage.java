package br.gov.camara.edemocracia.portlets.chat.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the ChatRoomMessage service. Represents a row in the &quot;CDChat_ChatRoomMessage&quot; database table, with each column mapped to a property of this class.
 *
 * @author Ricardo Lima
 * @see ChatRoomMessageModel
 * @see br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageImpl
 * @see br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageModelImpl
 * @generated
 */
public interface ChatRoomMessage extends ChatRoomMessageModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public com.liferay.portal.kernel.json.JSONObject getJSON();

    public java.lang.String getFormattedText(java.util.TimeZone tz);

    public java.lang.String getMessageXMLForExport(java.util.TimeZone tz);

    public java.lang.String getMessageHTMLForExport(java.util.TimeZone tz);
}
