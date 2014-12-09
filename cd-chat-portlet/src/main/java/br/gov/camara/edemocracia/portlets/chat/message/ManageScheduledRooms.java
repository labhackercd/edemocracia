/**
 * 
 */
package br.gov.camara.edemocracia.portlets.chat.message;

import java.util.Date;

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

/**
 * @author robson
 * 
 */
public class ManageScheduledRooms implements MessageListener {

	private static Log log = LogFactoryUtil.getLog(ManageScheduledRooms.class);

	/**
	 * @see com.liferay.portal.kernel.messaging.MessageListener#receive(com.liferay.portal.kernel.messaging.Message)
	 */
	@Override
	public void receive(Message message) {
		try {
			ChatRoomLocalServiceUtil.checkScheduledRoomState(new Date());
		} catch (Exception e) {
			log.error("Erro notificando as salas fechadas", e);
		}

	}

}
