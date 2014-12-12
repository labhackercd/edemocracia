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

import br.gov.camara.edemocracia.portlets.priorizacao.service.PriorizacaoServiceUtil;

import java.util.Arrays;


public class PriorizacaoServiceClpInvoker {
    private String _methodName38;
    private String[] _methodParameterTypes38;
    private String _methodName39;
    private String[] _methodParameterTypes39;
    private String _methodName42;
    private String[] _methodParameterTypes42;
    private String _methodName43;
    private String[] _methodParameterTypes43;
    private String _methodName44;
    private String[] _methodParameterTypes44;
    private String _methodName45;
    private String[] _methodParameterTypes45;
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;
    private String _methodName48;
    private String[] _methodParameterTypes48;
    private String _methodName49;
    private String[] _methodParameterTypes49;
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
    private String _methodName55;
    private String[] _methodParameterTypes55;
    private String _methodName56;
    private String[] _methodParameterTypes56;
    private String _methodName57;
    private String[] _methodParameterTypes57;
    private String _methodName58;
    private String[] _methodParameterTypes58;
    private String _methodName60;
    private String[] _methodParameterTypes60;
    private String _methodName61;
    private String[] _methodParameterTypes61;
    private String _methodName62;
    private String[] _methodParameterTypes62;
    private String _methodName63;
    private String[] _methodParameterTypes63;
    private String _methodName64;
    private String[] _methodParameterTypes64;
    private String _methodName65;
    private String[] _methodParameterTypes65;
    private String _methodName66;
    private String[] _methodParameterTypes66;

    public PriorizacaoServiceClpInvoker() {
        _methodName38 = "getBeanIdentifier";

        _methodParameterTypes38 = new String[] {  };

        _methodName39 = "setBeanIdentifier";

        _methodParameterTypes39 = new String[] { "java.lang.String" };

        _methodName42 = "getEixo";

        _methodParameterTypes42 = new String[] { "long" };

        _methodName43 = "listarEixos";

        _methodParameterTypes43 = new String[] { "long" };

        _methodName44 = "listarPropostaDisplay";

        _methodParameterTypes44 = new String[] { "long" };

        _methodName45 = "addEixo";

        _methodParameterTypes45 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String", "long"
            };

        _methodName46 = "updateEixo";

        _methodParameterTypes46 = new String[] {
                "long", "java.lang.String", "java.lang.String", "long", "long"
            };

        _methodName47 = "deleteEixo";

        _methodParameterTypes47 = new String[] { "long" };

        _methodName48 = "getProposta";

        _methodParameterTypes48 = new String[] { "long" };

        _methodName49 = "listarPropostasPorEixoId";

        _methodParameterTypes49 = new String[] { "long" };

        _methodName50 = "deleteProposta";

        _methodParameterTypes50 = new String[] { "long" };

        _methodName51 = "updateProposta";

        _methodParameterTypes51 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String", "long",
                "java.lang.String"
            };

        _methodName52 = "addProposta";

        _methodParameterTypes52 = new String[] {
                "long", "long", "java.lang.String", "java.lang.String", "long",
                "java.lang.String"
            };

        _methodName53 = "addVoto";

        _methodParameterTypes53 = new String[] { "long" };

        _methodName54 = "deleteVoto";

        _methodParameterTypes54 = new String[] { "long" };

        _methodName55 = "getMBCategory";

        _methodParameterTypes55 = new String[] { "long" };

        _methodName56 = "listarCategorias";

        _methodParameterTypes56 = new String[] { "long", "long" };

        _methodName57 = "listarTopicosPorCategoryId";

        _methodParameterTypes57 = new String[] { "long", "long" };

        _methodName58 = "getSumarioPriorizacao";

        _methodParameterTypes58 = new String[] {
                "long",
                "br.gov.camara.edemocracia.portlets.priorizacao.OrdemProposta[][]"
            };

        _methodName60 = "getPropostaDisplay";

        _methodParameterTypes60 = new String[] { "long" };

        _methodName61 = "getVotosUsuario";

        _methodParameterTypes61 = new String[] { "long" };

        _methodName62 = "getConfiguracaoPorGrupo";

        _methodParameterTypes62 = new String[] { "long" };

        _methodName63 = "updateConfiguracao";

        _methodParameterTypes63 = new String[] { "long", "int", "int", "boolean" };

        _methodName64 = "getEixosCountByGroupId";

        _methodParameterTypes64 = new String[] { "long" };

        _methodName65 = "getPropostasCountByEixoId";

        _methodParameterTypes65 = new String[] { "long" };

        _methodName66 = "getVotosPorPropostaId";

        _methodParameterTypes66 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName38.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
            return PriorizacaoServiceUtil.getBeanIdentifier();
        }

        if (_methodName39.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
            PriorizacaoServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName42.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
            return PriorizacaoServiceUtil.getEixo(((Long) arguments[0]).longValue());
        }

        if (_methodName43.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
            return PriorizacaoServiceUtil.listarEixos(((Long) arguments[0]).longValue());
        }

        if (_methodName44.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
            return PriorizacaoServiceUtil.listarPropostaDisplay(((Long) arguments[0]).longValue());
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            return PriorizacaoServiceUtil.addEixo(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Long) arguments[4]).longValue());
        }

        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return PriorizacaoServiceUtil.updateEixo(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                ((Long) arguments[3]).longValue(),
                ((Long) arguments[4]).longValue());
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            PriorizacaoServiceUtil.deleteEixo(((Long) arguments[0]).longValue());
        }

        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            return PriorizacaoServiceUtil.getProposta(((Long) arguments[0]).longValue());
        }

        if (_methodName49.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
            return PriorizacaoServiceUtil.listarPropostasPorEixoId(((Long) arguments[0]).longValue());
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            PriorizacaoServiceUtil.deleteProposta(((Long) arguments[0]).longValue());
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            return PriorizacaoServiceUtil.updateProposta(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Long) arguments[4]).longValue(),
                (java.lang.String) arguments[5]);
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return PriorizacaoServiceUtil.addProposta(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Long) arguments[4]).longValue(),
                (java.lang.String) arguments[5]);
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            PriorizacaoServiceUtil.addVoto(((Long) arguments[0]).longValue());
        }

        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            PriorizacaoServiceUtil.deleteVoto(((Long) arguments[0]).longValue());
        }

        if (_methodName55.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
            return PriorizacaoServiceUtil.getMBCategory(((Long) arguments[0]).longValue());
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return PriorizacaoServiceUtil.listarCategorias(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            return PriorizacaoServiceUtil.listarTopicosPorCategoryId(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName58.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
            return PriorizacaoServiceUtil.getSumarioPriorizacao(((Long) arguments[0]).longValue(),
                (br.gov.camara.edemocracia.portlets.priorizacao.OrdemProposta[]) arguments[1]);
        }

        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return PriorizacaoServiceUtil.getPropostaDisplay(((Long) arguments[0]).longValue());
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            return PriorizacaoServiceUtil.getVotosUsuario(((Long) arguments[0]).longValue());
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return PriorizacaoServiceUtil.getConfiguracaoPorGrupo(((Long) arguments[0]).longValue());
        }

        if (_methodName63.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
            return PriorizacaoServiceUtil.updateConfiguracao(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                ((Boolean) arguments[3]).booleanValue());
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            return PriorizacaoServiceUtil.getEixosCountByGroupId(((Long) arguments[0]).longValue());
        }

        if (_methodName65.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
            return PriorizacaoServiceUtil.getPropostasCountByEixoId(((Long) arguments[0]).longValue());
        }

        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return PriorizacaoServiceUtil.getVotosPorPropostaId(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
