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
package br.gov.camara.edemocracia.portlets.priorizacao.service.base;

import br.gov.camara.edemocracia.portlets.priorizacao.service.EixoLocalServiceUtil;

import java.util.Arrays;


public class EixoLocalServiceClpInvoker {
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
    private String _methodName54;
    private String[] _methodParameterTypes54;
    private String _methodName55;
    private String[] _methodParameterTypes55;
    private String _methodName60;
    private String[] _methodParameterTypes60;
    private String _methodName61;
    private String[] _methodParameterTypes61;
    private String _methodName62;
    private String[] _methodParameterTypes62;
    private String _methodName64;
    private String[] _methodParameterTypes64;
    private String _methodName65;
    private String[] _methodParameterTypes65;
    private String _methodName66;
    private String[] _methodParameterTypes66;

    public EixoLocalServiceClpInvoker() {
        _methodName0 = "addEixo";

        _methodParameterTypes0 = new String[] {
                "br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo"
            };

        _methodName1 = "createEixo";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteEixo";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteEixo";

        _methodParameterTypes3 = new String[] {
                "br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo"
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

        _methodName9 = "fetchEixo";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getEixo";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getEixos";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getEixosCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateEixo";

        _methodParameterTypes14 = new String[] {
                "br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo"
            };

        _methodName15 = "updateEixo";

        _methodParameterTypes15 = new String[] {
                "br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo",
                "boolean"
            };

        _methodName54 = "getBeanIdentifier";

        _methodParameterTypes54 = new String[] {  };

        _methodName55 = "setBeanIdentifier";

        _methodParameterTypes55 = new String[] { "java.lang.String" };

        _methodName60 = "listarEixosPorGroupId";

        _methodParameterTypes60 = new String[] { "long" };

        _methodName61 = "addEixo";

        _methodParameterTypes61 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String", "long"
            };

        _methodName62 = "updateEixo";

        _methodParameterTypes62 = new String[] {
                "long", "java.lang.String", "java.lang.String", "long", "long"
            };

        _methodName64 = "excluirEixo";

        _methodParameterTypes64 = new String[] {
                "br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo"
            };

        _methodName65 = "excluirEixo";

        _methodParameterTypes65 = new String[] { "long" };

        _methodName66 = "getEixosCountByGroupId";

        _methodParameterTypes66 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return EixoLocalServiceUtil.addEixo((br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return EixoLocalServiceUtil.createEixo(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return EixoLocalServiceUtil.deleteEixo(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return EixoLocalServiceUtil.deleteEixo((br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return EixoLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return EixoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return EixoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return EixoLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return EixoLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return EixoLocalServiceUtil.fetchEixo(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return EixoLocalServiceUtil.getEixo(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return EixoLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return EixoLocalServiceUtil.getEixos(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return EixoLocalServiceUtil.getEixosCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return EixoLocalServiceUtil.updateEixo((br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return EixoLocalServiceUtil.updateEixo((br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            return EixoLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName55.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
            EixoLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return EixoLocalServiceUtil.listarEixosPorGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            return EixoLocalServiceUtil.addEixo(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Long) arguments[4]).longValue());
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return EixoLocalServiceUtil.updateEixo(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue(),
                ((Long) arguments[4]).longValue());
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            EixoLocalServiceUtil.excluirEixo((br.gov.camara.edemocracia.portlets.priorizacao.model.Eixo) arguments[0]);
        }

        if (_methodName65.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
            EixoLocalServiceUtil.excluirEixo(((Long) arguments[0]).longValue());
        }

        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return EixoLocalServiceUtil.getEixosCountByGroupId(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
