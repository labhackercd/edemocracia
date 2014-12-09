package br.gov.camara.edemocracia.portlets.chat.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the ChatRoomVideo service. Represents a row in the &quot;CDChat_ChatRoomVideo&quot; database table, with each column mapped to a property of this class.
 *
 * @author Ricardo Lima
 * @see ChatRoomVideoModel
 * @see br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomVideoImpl
 * @see br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomVideoModelImpl
 * @generated
 */
public interface ChatRoomVideo extends ChatRoomVideoModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomVideoImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Retorna o link de streaming do video do webcamara
    *
    * @param nomPontoAlta - quando o video do chat é configurado para webcamara, o dado que identifica o canal (nomPontoAlta) é guardado no campo videoURL
    * @return
    */
    public java.lang.String montaLinkStreamingVideo(
        java.lang.String nomPontoAlta);

    /**
    * Retorna o link do vídeo
    *
    * Se for webcamara, retornará o link do streaming já montado
    *
    * @return
    */
    public java.lang.String getVideoLinkAoVivo();
}
