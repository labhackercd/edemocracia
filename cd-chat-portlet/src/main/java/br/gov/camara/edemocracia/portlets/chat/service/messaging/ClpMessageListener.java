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
package br.gov.camara.edemocracia.portlets.chat.service.messaging;

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomMessageLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomTwitterLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomUserLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomVideoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.chat.service.ClpSerializer;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ChatRoomLocalServiceUtil.clearService();

            ChatRoomServiceUtil.clearService();
            ChatRoomMessageLocalServiceUtil.clearService();

            ChatRoomTwitterLocalServiceUtil.clearService();

            ChatRoomUserLocalServiceUtil.clearService();

            ChatRoomVideoLocalServiceUtil.clearService();
        }
    }
}
