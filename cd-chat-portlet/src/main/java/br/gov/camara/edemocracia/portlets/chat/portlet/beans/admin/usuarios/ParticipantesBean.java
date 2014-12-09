/**
 * 
 */
package br.gov.camara.edemocracia.portlets.chat.portlet.beans.admin.usuarios;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author rpdmiranda
 * 
 */
@ManagedBean(name = "participantes")
@RequestScoped
public class ParticipantesBean {

	private List<ChatRoomUserBean> lista;

	private long salaId;

	/**
	 * Maior quantidade de usuários na sala simultaneamente
	 */
	private int maxUsuariosSimultaneos;
	/**
	 * Maior quantidade de usuários espiando a sala simultaneamente
	 */
	private int maxUsuariosEspiandoSimultaneos;
	
	private int capacidade;
	
	private long totalParticipantes;
	
	private int totalParticipacoes;
	

	/**
	 * Carrega a lista de usuários da sala especificada como parâmetro
	 */
	@PostConstruct
	public void init() {
		salaId = 0;

		String param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (param != null) {
			try {
				salaId = Long.parseLong(param);
			} catch (NumberFormatException e) {
				// Ignore
			}
		}

		if (salaId == 0l) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage("room-cant-find");
			lista = null;
		} else {
			try {
				lista = ChatRoomServiceUtil.findAllChatRoomParticipants(salaId);
				totalParticipantes = ChatRoomServiceUtil.getUserCount(salaId);
			} catch (PortalException e) {
				LiferayFacesContext.getInstance().addGlobalErrorMessage("room-cant-find");
				lista = null;
				totalParticipacoes = 0;
				totalParticipantes = 0;
			} catch (SystemException e) {
				throw new RuntimeException(e);
			}
		}
		
		if (lista!= null) {
			totalParticipacoes = lista.size();
		}
		
		try {
			ChatRoom room = ChatRoomServiceUtil.getRoom(salaId);
			maxUsuariosEspiandoSimultaneos = room.getMaxSimultaneousUsersSpying();
			maxUsuariosSimultaneos = room.getMaxSimultaneousUsers();
			capacidade = room.getCapacity();
		} catch (PortalException e) {
			LiferayFacesContext.getInstance().addGlobalErrorMessage("room-cant-find");
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return the lista
	 */
	public List<ChatRoomUserBean> getLista() {
		return lista;
	}

	/**
	 * Esta consulta diferencia os usuários que entraram no chat considerando o username, e-mail e uf
	 * 
	 * @return o número total de participações do chat
	 * 
	 */
	public int getTotalParticipacoes() {
		return totalParticipacoes;
	}
	
	/**
	 * Esta consulta diferencia os usuários que entraram no chat considerando apenas o e-mail
	 * 
	 * @return o número de participantes do chat
	 */
	public long getTotalParticipantes() {
		return totalParticipantes;
	}
	
	/**
	 * Obtém o nome do recurso de exportação de usuários
	 * 
	 * @return
	 */
	public String getRecursoParticipantes() {
		return "chat:usr_" + salaId;
	}

	public int getMaxUsuariosEspiandoSimultaneos() {
		return maxUsuariosEspiandoSimultaneos;
	}

	public int getMaxUsuariosSimultaneos() {
		return maxUsuariosSimultaneos;
	}

	public int getCapacidade() {
	    return capacidade;
    }
	
}
