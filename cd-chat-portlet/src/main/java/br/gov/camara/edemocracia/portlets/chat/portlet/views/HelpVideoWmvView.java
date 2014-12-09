package br.gov.camara.edemocracia.portlets.chat.portlet.views;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import br.gov.camara.edemocracia.portlets.chat.portlet.ChatRoomView;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class HelpVideoWmvView extends AbstractView {

	@Override
	public ChatRoomView processView(RenderRequest request, RenderResponse response) throws PortalException, SystemException {

		return ChatRoomView.HELP;
	}

}
