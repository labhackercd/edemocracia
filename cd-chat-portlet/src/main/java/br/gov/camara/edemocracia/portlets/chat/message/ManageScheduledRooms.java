/**
 * Copyright (c) 2009-2014 Câmara dos Deputados. Todos os direitos reservados.
 *
 * e-Democracia é um software livre; você pode redistribuí-lo e/ou modificá-lo dentro
 * dos termos da Licença Pública Geral Menor GNU como publicada pela Fundação do 
 * Software Livre (FSF); na versão 2.1 da Licença, ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser  útil, mas SEM NENHUMA GARANTIA;
 * sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR.
 * Veja a Licença Pública Geral Menor GNU para maiores detalhes. 
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
