/**
 * 
 */
package br.gov.camara.edemocracia.portlets.chat.portlet.views;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang.StringUtils;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletConstants;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletRequestUtil;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatRoomView;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomTwitterLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomVideoLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.model.User;

/**
 * @author P_7339
 * 
 */
public abstract class AbstractView {

	/**
	 * Processa uma visão
	 * 
	 * @param request
	 * @param response
	 * @return A visão que deve ser renderizada. Caso não seja a mesma que levou
	 *         à esta visão, deve-se chamar o método processView da classe
	 *         correspondente à nova visão. Nunca retornar null!
	 * 
	 * @throws PortalException
	 * @throws SystemException
	 */
	public final ChatRoomView process(RenderRequest request, RenderResponse response) throws PortalException, SystemException {
		setPreviousPageLinkAtribute(request);
		
		return processView(request, response);
	}

	protected abstract ChatRoomView processView(RenderRequest request, RenderResponse response) throws PortalException, SystemException;

	/**
	 * Obtém a sala a partir do atributo da requsição
	 * 
	 * @param request
	 * @return
	 */
	protected ChatRoom getRoom(RenderRequest request) {
		return (ChatRoom) request.getAttribute(ChatPortletConstants.ROOM_ATTRIBUTE);
	}

	/**
	 * Adiciona mensagem de sala não encontrada e retorna a visão correta
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	protected ChatRoomView addRoomNotFoundMessage(PortletRequest request, User user) {
		SessionErrors.add(request, "room-cant-find");
		if (user.isDefaultUser())
			return ChatRoomView.ERROR;
		else
			return ChatRoomView.LIST;
	}

	protected ChatRoomTwitter getChatRoomTwitter(RenderRequest request) throws PortalException, SystemException {
		ChatRoom room = (ChatRoom) request.getAttribute(ChatPortletConstants.ROOM_ATTRIBUTE);
		ChatRoomTwitter chatRoomTwitter = ChatRoomTwitterLocalServiceUtil.getTwitter(room.getRoomId());
		return chatRoomTwitter;
	}

	protected ChatRoomVideo getChatRoomVideoLive(RenderRequest request) throws PortalException, SystemException {
		ChatRoom room = (ChatRoom) request.getAttribute(ChatPortletConstants.ROOM_ATTRIBUTE);
		ChatRoomVideo chatRoomVideoLive = ChatRoomVideoLocalServiceUtil.getVideo(room.getVideoLiveId());
		return chatRoomVideoLive;
	}

	protected ChatRoomVideo getChatRoomVideoRecorded(RenderRequest request) throws PortalException, SystemException {
		ChatRoom room = (ChatRoom) request.getAttribute(ChatPortletConstants.ROOM_ATTRIBUTE);
		ChatRoomVideo chatRoomVideoRecorded = ChatRoomVideoLocalServiceUtil.getVideo(room.getVideoRecordedId());
		return chatRoomVideoRecorded;
	}

	private void setPreviousPageLinkAtribute(RenderRequest request) {
		String previousPageLink = request.getParameter(ChatPortletConstants.PREVIOUS_PAGE_LINK);
		if (StringUtils.isEmpty(previousPageLink)) {
			return;
		}
		if (ChatPortletRequestUtil.isUrlToSameHost(request, previousPageLink)) {
			request.setAttribute(ChatPortletConstants.PREVIOUS_PAGE_LINK, previousPageLink);
		}
	}
}