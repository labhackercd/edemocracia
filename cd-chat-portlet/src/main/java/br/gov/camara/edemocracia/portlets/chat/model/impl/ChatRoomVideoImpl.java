package br.gov.camara.edemocracia.portlets.chat.model.impl;

import br.gov.camara.edemocracia.portlets.chat.portlet.beans.admin.editroom.ChatVideoType;

/**
 * The extended model implementation for the ChatRoomVideo service. Represents a
 * row in the &quot;CDChat_ChatRoomVideo&quot; database table, with each column
 * mapped to a property of this class.
 * 
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo}
 * interface.
 * </p>
 * 
 * @author Ricardo Lima
 */
public class ChatRoomVideoImpl extends ChatRoomVideoBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this class directly. All methods that expect a chat room
	 * video model instance should use the {@link
	 * br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo} interface
	 * instead.
	 */
	public ChatRoomVideoImpl() {
	}
	
	private final static String LINK_SERVIDOR_AO_VIVO = "stream.camara.gov.br";

	/**
	 * Retorna o link de streaming do video do webcamara
	 * @param nomPontoAlta - quando o video do chat é configurado para webcamara, o dado que identifica o canal (nomPontoAlta) é guardado no campo videoURL  
	 * @return
	 */
	public String montaLinkStreamingVideo(String nomPontoAlta) {
		StringBuilder linkStreamingVideo = new StringBuilder();
		linkStreamingVideo.append("rtsp://");
		linkStreamingVideo.append(LINK_SERVIDOR_AO_VIVO);
		linkStreamingVideo.append("/");
		linkStreamingVideo.append(nomPontoAlta);
		return linkStreamingVideo.toString();
	}
	
	/**
	 * Retorna o link do vídeo 
	 * 
	 * Se for webcamara, retornará o link do streaming já montado
	 * 
	 * @return  
	 */
	public String getVideoLinkAoVivo() {
		if (getVideoType().equalsIgnoreCase(ChatVideoType.WebCamara.toString())) {
			return montaLinkStreamingVideo(getVideoUrl());
		} else {
			return getVideoUrl();
		}
	}
}
