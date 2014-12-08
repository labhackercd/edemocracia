package br.gov.camara.edemocracia.portlets.exportacao.service.base;

import br.gov.camara.edemocracia.portlets.exportacao.service.DadosForumServiceUtil;

import java.util.Arrays;


public class DadosForumServiceClpInvoker {
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;

    public DadosForumServiceClpInvoker() {
        _methodName18 = "getBeanIdentifier";

        _methodParameterTypes18 = new String[] {  };

        _methodName19 = "setBeanIdentifier";

        _methodParameterTypes19 = new String[] { "java.lang.String" };

        _methodName22 = "getDadosForumExportacao";

        _methodParameterTypes22 = new String[] { "java.lang.Long" };

        _methodName23 = "getDadosForumAdminExportacao";

        _methodParameterTypes23 = new String[] { "java.lang.Long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            return DadosForumServiceUtil.getBeanIdentifier();
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            DadosForumServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName22.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
            return DadosForumServiceUtil.getDadosForumExportacao((java.lang.Long) arguments[0]);
        }

        if (_methodName23.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
            return DadosForumServiceUtil.getDadosForumAdminExportacao((java.lang.Long) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
