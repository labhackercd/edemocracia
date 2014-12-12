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
package br.gov.camara.edemocracia.portlets.wikilegis.service.base;

import br.gov.camara.edemocracia.portlets.wikilegis.service.WikiLegisServiceUtil;

import java.util.Arrays;


public class WikiLegisServiceClpInvoker {
    private String _methodName32;
    private String[] _methodParameterTypes32;
    private String _methodName33;
    private String[] _methodParameterTypes33;
    private String _methodName40;
    private String[] _methodParameterTypes40;
    private String _methodName43;
    private String[] _methodParameterTypes43;
    private String _methodName45;
    private String[] _methodParameterTypes45;
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
    private String _methodName59;
    private String[] _methodParameterTypes59;
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

    public WikiLegisServiceClpInvoker() {
        _methodName32 = "getBeanIdentifier";

        _methodParameterTypes32 = new String[] {  };

        _methodName33 = "setBeanIdentifier";

        _methodParameterTypes33 = new String[] { "java.lang.String" };

        _methodName40 = "getArtigoDisplay";

        _methodParameterTypes40 = new String[] { "long" };

        _methodName43 = "listaElementos";

        _methodParameterTypes43 = new String[] { "long" };

        _methodName45 = "listaEstrutura";

        _methodParameterTypes45 = new String[] { "long" };

        _methodName47 = "editaArtigo";

        _methodParameterTypes47 = new String[] {
                "long", "long", "long", "java.lang.String", "java.lang.String"
            };

        _methodName48 = "excluiArtigo";

        _methodParameterTypes48 = new String[] { "long" };

        _methodName49 = "criaArtigo";

        _methodParameterTypes49 = new String[] {
                "long", "long", "long", "java.lang.String", "java.lang.String"
            };

        _methodName50 = "listaContribuicoes";

        _methodParameterTypes50 = new String[] { "long" };

        _methodName51 = "adicionaContribuicao";

        _methodParameterTypes51 = new String[] {
                "long", "java.lang.String", "java.lang.String"
            };

        _methodName52 = "removeContribuicao";

        _methodParameterTypes52 = new String[] { "long" };

        _methodName53 = "listaEstruturaFilhos";

        _methodParameterTypes53 = new String[] { "long", "long" };

        _methodName54 = "listaArtigos";

        _methodParameterTypes54 = new String[] { "long", "long" };

        _methodName55 = "criaEstrutura";

        _methodParameterTypes55 = new String[] {
                "long", "long", "long", "java.lang.String"
            };

        _methodName56 = "getEstrutura";

        _methodParameterTypes56 = new String[] { "long" };

        _methodName57 = "getArtigo";

        _methodParameterTypes57 = new String[] { "long" };

        _methodName58 = "atualizaEstrutura";

        _methodParameterTypes58 = new String[] {
                "long", "long", "long", "long", "java.lang.String"
            };

        _methodName59 = "postaComentario";

        _methodParameterTypes59 = new String[] {
                "long", "long", "java.lang.String"
            };

        _methodName60 = "excluiComentario";

        _methodParameterTypes60 = new String[] { "long", "long" };

        _methodName61 = "atualizaComentario";

        _methodParameterTypes61 = new String[] {
                "java.lang.String", "long", "long", "long"
            };

        _methodName62 = "atualizaContribuicao";

        _methodParameterTypes62 = new String[] {
                "long", "java.lang.String", "java.lang.String"
            };

        _methodName63 = "exportaContribuicoes";

        _methodParameterTypes63 = new String[] { "long" };

        _methodName64 = "exportaComentarios";

        _methodParameterTypes64 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName32.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
            return WikiLegisServiceUtil.getBeanIdentifier();
        }

        if (_methodName33.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
            WikiLegisServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName40.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
            return WikiLegisServiceUtil.getArtigoDisplay(((Long) arguments[0]).longValue());
        }

        if (_methodName43.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
            return WikiLegisServiceUtil.listaElementos(((Long) arguments[0]).longValue());
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            return WikiLegisServiceUtil.listaEstrutura(((Long) arguments[0]).longValue());
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            WikiLegisServiceUtil.editaArtigo(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3], (java.lang.String) arguments[4]);
        }

        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            WikiLegisServiceUtil.excluiArtigo(((Long) arguments[0]).longValue());
        }

        if (_methodName49.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
            return WikiLegisServiceUtil.criaArtigo(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3], (java.lang.String) arguments[4]);
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return WikiLegisServiceUtil.listaContribuicoes(((Long) arguments[0]).longValue());
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            WikiLegisServiceUtil.adicionaContribuicao(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            WikiLegisServiceUtil.removeContribuicao(((Long) arguments[0]).longValue());
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            return WikiLegisServiceUtil.listaEstruturaFilhos(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            return WikiLegisServiceUtil.listaArtigos(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName55.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
            return WikiLegisServiceUtil.criaEstrutura(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3]);
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return WikiLegisServiceUtil.getEstrutura(((Long) arguments[0]).longValue());
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            return WikiLegisServiceUtil.getArtigo(((Long) arguments[0]).longValue());
        }

        if (_methodName58.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
            return WikiLegisServiceUtil.atualizaEstrutura(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                ((Long) arguments[3]).longValue(),
                (java.lang.String) arguments[4]);
        }

        if (_methodName59.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
            WikiLegisServiceUtil.postaComentario(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            WikiLegisServiceUtil.excluiComentario(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            return WikiLegisServiceUtil.atualizaComentario((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                ((Long) arguments[3]).longValue());
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return WikiLegisServiceUtil.atualizaContribuicao(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1], (java.lang.String) arguments[2]);
        }

        if (_methodName63.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
            return WikiLegisServiceUtil.exportaContribuicoes(((Long) arguments[0]).longValue());
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            return WikiLegisServiceUtil.exportaComentarios(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
