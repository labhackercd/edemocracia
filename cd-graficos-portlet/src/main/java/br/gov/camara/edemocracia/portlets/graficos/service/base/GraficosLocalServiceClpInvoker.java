package br.gov.camara.edemocracia.portlets.graficos.service.base;

import br.gov.camara.edemocracia.portlets.graficos.service.GraficosLocalServiceUtil;

import java.util.Arrays;


public class GraficosLocalServiceClpInvoker {
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;
    private String _methodName30;
    private String[] _methodParameterTypes30;

    public GraficosLocalServiceClpInvoker() {
        _methodName24 = "getBeanIdentifier";

        _methodParameterTypes24 = new String[] {  };

        _methodName25 = "setBeanIdentifier";

        _methodParameterTypes25 = new String[] { "java.lang.String" };

        _methodName28 = "getUsuariosPorUf";

        _methodParameterTypes28 = new String[] {
                "long", "com.liferay.portal.model.Country"
            };

        _methodName29 = "getUsuariosPorData";

        _methodParameterTypes29 = new String[] {
                "long", "java.util.TimeZone", "java.util.Date", "java.util.Date"
            };

        _methodName30 = "getAtividadePorData";

        _methodParameterTypes30 = new String[] {
                "long", "java.util.TimeZone", "java.util.Date", "java.util.Date"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            return GraficosLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            GraficosLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return GraficosLocalServiceUtil.getUsuariosPorUf(((Long) arguments[0]).longValue(),
                (com.liferay.portal.model.Country) arguments[1]);
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            return GraficosLocalServiceUtil.getUsuariosPorData(((Long) arguments[0]).longValue(),
                (java.util.TimeZone) arguments[1],
                (java.util.Date) arguments[2], (java.util.Date) arguments[3]);
        }

        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            return GraficosLocalServiceUtil.getAtividadePorData(((Long) arguments[0]).longValue(),
                (java.util.TimeZone) arguments[1],
                (java.util.Date) arguments[2], (java.util.Date) arguments[3]);
        }

        throw new UnsupportedOperationException();
    }
}
