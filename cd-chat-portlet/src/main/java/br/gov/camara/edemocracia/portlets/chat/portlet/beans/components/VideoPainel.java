package br.gov.camara.edemocracia.portlets.chat.portlet.beans.components;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.component.UISelectOne;

import br.gov.camara.edemocracia.portlets.chat.dao.DAOWebcamara;
import br.gov.camara.edemocracia.portlets.chat.portlet.beans.admin.editroom.ChatVideoType;
import br.gov.camara.edemocracia.portlets.chat.wrapper.CanalWrapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@FacesComponent(value = "videoPainel")
public class VideoPainel extends UINamingContainer implements Serializable {

	private static final long serialVersionUID = 8643619054400898594L;

	private static final Log LOG = LogFactoryUtil.getLog(VideoPainel.class);

	private List<CanalWrapper> canais;

	private Boolean showWebCamaraOption;

	private UISelectOne selectTipo;

	public VideoPainel() {
		canais = DAOWebcamara.getMapeamentoCanais();

	}

	public ChatVideoType[] getVideoTypes() {
		if (showWebCamaraOption) {
			return ChatVideoType.values();

		} else {
			List<ChatVideoType> types = new LinkedList<ChatVideoType>();
			for (ChatVideoType type : ChatVideoType.values()) {
				if (!type.equals(ChatVideoType.WebCamara)) {
					types.add(type);
				}
			}
			ChatVideoType[] typesReturn = new ChatVideoType[types.size()];
			types.toArray(typesReturn);
			return typesReturn;
		}
	}
	
	
	public boolean isInputTextRender(){
		String selecionado = (String) selectTipo.getValue();
		ChatVideoType value = ChatVideoType.fromString(selecionado);
		if(value == ChatVideoType.wmv || value == ChatVideoType.flash || value == null && !showWebCamaraOption){
			return true;
		}
		return false;
	}
	
	
	public boolean isTextAreaRender(){
		String selecionado = (String) selectTipo.getValue();
		ChatVideoType value = ChatVideoType.fromString(selecionado);
		if(value == ChatVideoType.youtube){
			return true;
		}
		return false;
	}
	
	public boolean isSelectBoxRender(){
		String selecionado = (String) selectTipo.getValue();
		ChatVideoType value = ChatVideoType.fromString(selecionado);
		if(value == ChatVideoType.WebCamara || value == null && showWebCamaraOption){
			return true;
		}
		return false;
	}
	
	public String getPanelLabelVideoValue() {
		String selecionado = (String) selectTipo.getValue();
		ChatVideoType value = ChatVideoType.fromString(selecionado);
		if(value == ChatVideoType.youtube) {
			return "Iframe* ";
		}
		if(value == ChatVideoType.WebCamara) {
			return "Escolha* ";
		}
		return "URL* ";
	}
	
	public String getHelpMessagesVideo() {
		String selecionado = (String) selectTipo.getValue();
		ChatVideoType value = ChatVideoType.fromString(selecionado);
		if(value == ChatVideoType.youtube) {
			return "Para tipo 'youtube' utilize o embed com o tamanho: <br /> 'width:230px' e 'height:200px'.";
		}
		if(value == ChatVideoType.WebCamara) {
			return "Para tipo 'WebCamara' escolha uma das opções de <br /> streaming disponíveis.";
		}
		return "Para tipo 'wmv' e 'flash' coloque apenas a url do streaming <br /> ou arquivo de vídeo.";
	}

	public List<CanalWrapper> getCanais() {
		return canais;
	}

	public Boolean getShowWebCamaraOption() {
		return showWebCamaraOption;
	}

	public void setShowWebCamaraOption(Boolean showWebCamaraOption) {
		this.showWebCamaraOption = showWebCamaraOption;
	}

	public UISelectOne getSelectTipo() {
		return selectTipo;
	}

	public void setSelectTipo(UISelectOne selectTipo) {
		this.selectTipo = selectTipo;
	}

}
