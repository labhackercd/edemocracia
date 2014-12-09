package br.gov.camara.edemocracia.portlets.dashboard.service.base;

import br.gov.camara.edemocracia.portlets.dashboard.service.DashboardLocalServiceUtil;

import java.util.Arrays;


public class DashboardLocalServiceClpInvoker {
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;

    public DashboardLocalServiceClpInvoker() {
        _methodName18 = "getBeanIdentifier";

        _methodParameterTypes18 = new String[] {  };

        _methodName19 = "setBeanIdentifier";

        _methodParameterTypes19 = new String[] { "java.lang.String" };

        _methodName22 = "getComunidadesDisponiveis";

        _methodParameterTypes22 = new String[] { "long" };

        _methodName23 = "getRecursosComMaiorParticipacao";

        _methodParameterTypes23 = new String[] {
                "long",
                "br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao",
                "java.lang.String",
                "br.gov.camara.edemocracia.portlets.dashboard.Recurso"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            return DashboardLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            DashboardLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName22.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
            return DashboardLocalServiceUtil.getComunidadesDisponiveis(((Long) arguments[0]).longValue());
        }

        if (_methodName23.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
            return DashboardLocalServiceUtil.getRecursosComMaiorParticipacao(((Long) arguments[0]).longValue(),
                (br.gov.camara.edemocracia.portlets.dashboard.dto.Configuracao) arguments[1],
                (java.lang.String) arguments[2],
                (br.gov.camara.edemocracia.portlets.dashboard.Recurso) arguments[3]);
        }

        throw new UnsupportedOperationException();
    }
}
