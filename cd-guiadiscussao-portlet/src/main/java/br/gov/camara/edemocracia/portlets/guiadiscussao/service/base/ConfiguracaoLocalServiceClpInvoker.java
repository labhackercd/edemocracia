package br.gov.camara.edemocracia.portlets.guiadiscussao.service.base;

import br.gov.camara.edemocracia.portlets.guiadiscussao.service.ConfiguracaoLocalServiceUtil;

import java.util.Arrays;


public class ConfiguracaoLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName44;
    private String[] _methodParameterTypes44;
    private String _methodName45;
    private String[] _methodParameterTypes45;
    private String _methodName50;
    private String[] _methodParameterTypes50;
    private String _methodName51;
    private String[] _methodParameterTypes51;

    public ConfiguracaoLocalServiceClpInvoker() {
        _methodName0 = "addConfiguracao";

        _methodParameterTypes0 = new String[] {
                "br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao"
            };

        _methodName1 = "createConfiguracao";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteConfiguracao";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteConfiguracao";

        _methodParameterTypes3 = new String[] {
                "br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "fetchConfiguracao";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getConfiguracao";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getConfiguracaos";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getConfiguracaosCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateConfiguracao";

        _methodParameterTypes14 = new String[] {
                "br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao"
            };

        _methodName15 = "updateConfiguracao";

        _methodParameterTypes15 = new String[] {
                "br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao",
                "boolean"
            };

        _methodName44 = "getBeanIdentifier";

        _methodParameterTypes44 = new String[] {  };

        _methodName45 = "setBeanIdentifier";

        _methodParameterTypes45 = new String[] { "java.lang.String" };

        _methodName50 = "getByGroupId";

        _methodParameterTypes50 = new String[] { "long" };

        _methodName51 = "marcarFaseComoAtual";

        _methodParameterTypes51 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.addConfiguracao((br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.createConfiguracao(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.deleteConfiguracao(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.deleteConfiguracao((br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.fetchConfiguracao(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.getConfiguracao(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.getConfiguracaos(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.getConfiguracaosCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.updateConfiguracao((br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.updateConfiguracao((br.gov.camara.edemocracia.portlets.guiadiscussao.model.Configuracao) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName44.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            ConfiguracaoLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return ConfiguracaoLocalServiceUtil.getByGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            ConfiguracaoLocalServiceUtil.marcarFaseComoAtual(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
