package br.gov.camara.edemocracia.portlets.guiadiscussao.service.messaging;

import br.gov.camara.edemocracia.portlets.guiadiscussao.service.AcaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.ClpSerializer;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.ConfiguracaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.guiadiscussao.service.FaseLocalServiceUtil;

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
            AcaoLocalServiceUtil.clearService();

            ConfiguracaoLocalServiceUtil.clearService();

            FaseLocalServiceUtil.clearService();
        }
    }
}
