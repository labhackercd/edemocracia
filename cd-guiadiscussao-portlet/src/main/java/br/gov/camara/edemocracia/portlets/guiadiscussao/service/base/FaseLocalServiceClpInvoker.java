package br.gov.camara.edemocracia.portlets.guiadiscussao.service.base;

import br.gov.camara.edemocracia.portlets.guiadiscussao.service.FaseLocalServiceUtil;

import java.util.Arrays;


public class FaseLocalServiceClpInvoker {
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
    private String _methodName52;
    private String[] _methodParameterTypes52;
    private String _methodName53;
    private String[] _methodParameterTypes53;
    private String _methodName54;
    private String[] _methodParameterTypes54;

    public FaseLocalServiceClpInvoker() {
        _methodName0 = "addFase";

        _methodParameterTypes0 = new String[] {
                "br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase"
            };

        _methodName1 = "createFase";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteFase";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteFase";

        _methodParameterTypes3 = new String[] {
                "br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase"
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

        _methodName9 = "fetchFase";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getFase";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getFases";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getFasesCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateFase";

        _methodParameterTypes14 = new String[] {
                "br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase"
            };

        _methodName15 = "updateFase";

        _methodParameterTypes15 = new String[] {
                "br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase",
                "boolean"
            };

        _methodName44 = "getBeanIdentifier";

        _methodParameterTypes44 = new String[] {  };

        _methodName45 = "setBeanIdentifier";

        _methodParameterTypes45 = new String[] { "java.lang.String" };

        _methodName50 = "criaFase";

        _methodParameterTypes50 = new String[] {
                "br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase"
            };

        _methodName51 = "getFasesByConfiguracaoId";

        _methodParameterTypes51 = new String[] { "long" };

        _methodName52 = "excluirFase";

        _methodParameterTypes52 = new String[] { "long" };

        _methodName53 = "moverFaseParaCima";

        _methodParameterTypes53 = new String[] { "long" };

        _methodName54 = "moverFaseParaBaixo";

        _methodParameterTypes54 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return FaseLocalServiceUtil.addFase((br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return FaseLocalServiceUtil.createFase(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return FaseLocalServiceUtil.deleteFase(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return FaseLocalServiceUtil.deleteFase((br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return FaseLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return FaseLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return FaseLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return FaseLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return FaseLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return FaseLocalServiceUtil.fetchFase(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return FaseLocalServiceUtil.getFase(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return FaseLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return FaseLocalServiceUtil.getFases(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return FaseLocalServiceUtil.getFasesCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return FaseLocalServiceUtil.updateFase((br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return FaseLocalServiceUtil.updateFase((br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName44.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
            return FaseLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            FaseLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return FaseLocalServiceUtil.criaFase((br.gov.camara.edemocracia.portlets.guiadiscussao.model.Fase) arguments[0]);
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            return FaseLocalServiceUtil.getFasesByConfiguracaoId(((Long) arguments[0]).longValue());
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            FaseLocalServiceUtil.excluirFase(((Long) arguments[0]).longValue());
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            FaseLocalServiceUtil.moverFaseParaCima(((Long) arguments[0]).longValue());
        }

        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            FaseLocalServiceUtil.moverFaseParaBaixo(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
