/**
 * 
 */
package br.gov.camara.edemocracia.portlets.chat.portlet.views;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatPortletConstants;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatRoomView;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author P_7339
 * 
 */
public class ErrorView extends AbstractView {

	@Override
	public ChatRoomView processView(RenderRequest request, RenderResponse response) throws PortalException, SystemException {
		ChatRoom room = getRoom(request);
		if (room == null)
			request.setAttribute(ChatPortletConstants.ROOM_ATTRIBUTE, null);

		return ChatRoomView.ERROR;
	}

}
