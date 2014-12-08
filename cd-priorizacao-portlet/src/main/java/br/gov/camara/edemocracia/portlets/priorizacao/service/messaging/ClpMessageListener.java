package br.gov.camara.edemocracia.portlets.priorizacao.service.messaging;

import br.gov.camara.edemocracia.portlets.priorizacao.service.ClpSerializer;
import br.gov.camara.edemocracia.portlets.priorizacao.service.ConfiguracaoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.service.EixoLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.service.PropostaLocalServiceUtil;
import br.gov.camara.edemocracia.portlets.priorizacao.service.VotoLocalServiceUtil;

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
            ConfiguracaoLocalServiceUtil.clearService();

            EixoLocalServiceUtil.clearService();

            PriorizacaoServiceUtil.clearService();
            PropostaLocalServiceUtil.clearService();

            VotoLocalServiceUtil.clearService();
        }
    }
}
