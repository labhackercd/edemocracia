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
