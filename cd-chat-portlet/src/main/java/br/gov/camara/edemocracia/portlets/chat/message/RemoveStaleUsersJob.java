package br.gov.camara.edemocracia.portlets.chat.message;

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

public class RemoveStaleUsersJob implements MessageListener {

	private static Log log = LogFactoryUtil.getLog(RemoveStaleUsersJob.class);

	@Override
	public void receive(Message message) {
		try {
			ChatRoomLocalServiceUtil.removerUsuariosInativos();
		} catch (SystemException e) {
			log.error("Erro removendo usuários antigos", e);
		} catch (PortalException e) {
			log.error("Erro removendo usuários antigos", e);
		}

		ChatRoomLocalServiceUtil.removerUsuariosBanidosDeSalasFechadas();
	}
}
