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
package br.gov.camara.edemocracia.portlets.graficos.service.base;

import br.gov.camara.edemocracia.portlets.graficos.service.ParticipacaoLocalServiceUtil;

import java.util.Arrays;


public class ParticipacaoLocalServiceClpInvoker {
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
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName32;
    private String[] _methodParameterTypes32;

    public ParticipacaoLocalServiceClpInvoker() {
        _methodName24 = "getBeanIdentifier";

        _methodParameterTypes24 = new String[] {  };

        _methodName25 = "setBeanIdentifier";

        _methodParameterTypes25 = new String[] { "java.lang.String" };

        _methodName28 = "getComunidadesDisponiveis";

        _methodParameterTypes28 = new String[] { "long" };

        _methodName29 = "getDadosComunidade";

        _methodParameterTypes29 = new String[] { "java.util.List" };

        _methodName30 = "getDadosComunidade";

        _methodParameterTypes30 = new String[] {
                "java.util.List", "java.util.Date", "java.util.Date"
            };

        _methodName31 = "getDadosComunidade";

        _methodParameterTypes31 = new String[] { "java.lang.Long" };

        _methodName32 = "getDadosComunidade";

        _methodParameterTypes32 = new String[] {
                "java.lang.Long", "java.util.Date", "java.util.Date"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            return ParticipacaoLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            ParticipacaoLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return ParticipacaoLocalServiceUtil.getComunidadesDisponiveis(((Long) arguments[0]).longValue());
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            return ParticipacaoLocalServiceUtil.getDadosComunidade((java.util.List<java.lang.Long>) arguments[0]);
        }

        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            return ParticipacaoLocalServiceUtil.getDadosComunidade((java.util.List<java.lang.Long>) arguments[0],
                (java.util.Date) arguments[1], (java.util.Date) arguments[2]);
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            return ParticipacaoLocalServiceUtil.getDadosComunidade((java.lang.Long) arguments[0]);
        }

        if (_methodName32.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
            return ParticipacaoLocalServiceUtil.getDadosComunidade((java.lang.Long) arguments[0],
                (java.util.Date) arguments[1], (java.util.Date) arguments[2]);
        }

        throw new UnsupportedOperationException();
    }
}
