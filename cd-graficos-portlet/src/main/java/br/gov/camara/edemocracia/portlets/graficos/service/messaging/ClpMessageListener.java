package br.gov.camara.edemocracia.portlets.graficos.service.messaging;

import br.gov.camara.edemocracia.portlets.graficos.service.ClpSerializer;
import br.gov.camara.edemocracia.portlets.graficos.service.ContadorAcessoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.graficos.service.GraficosLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.graficos.service.ParticipacaoLocalServiceUtil;

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
            ContadorAcessoLocalServiceUtil.clearService();

            GraficosLocalServiceUtil.clearService();

            ParticipacaoLocalServiceUtil.clearService();
        }
    }
}
