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
package br.gov.camara.edemocracia.portlets.chat.service.base;

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomTwitterLocalServiceUtil;

import java.util.Arrays;


public class ChatRoomTwitterLocalServiceClpInvoker {
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
    private String _methodName56;
    private String[] _methodParameterTypes56;
    private String _methodName57;
    private String[] _methodParameterTypes57;
    private String _methodName62;
    private String[] _methodParameterTypes62;

    public ChatRoomTwitterLocalServiceClpInvoker() {
        _methodName0 = "addChatRoomTwitter";

        _methodParameterTypes0 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter"
            };

        _methodName1 = "createChatRoomTwitter";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteChatRoomTwitter";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteChatRoomTwitter";

        _methodParameterTypes3 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter"
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

        _methodName9 = "fetchChatRoomTwitter";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getChatRoomTwitter";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getChatRoomTwitters";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getChatRoomTwittersCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateChatRoomTwitter";

        _methodParameterTypes14 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter"
            };

        _methodName15 = "updateChatRoomTwitter";

        _methodParameterTypes15 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter",
                "boolean"
            };

        _methodName56 = "getBeanIdentifier";

        _methodParameterTypes56 = new String[] {  };

        _methodName57 = "setBeanIdentifier";

        _methodParameterTypes57 = new String[] { "java.lang.String" };

        _methodName62 = "getTwitter";

        _methodParameterTypes62 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.addChatRoomTwitter((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.createChatRoomTwitter(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.deleteChatRoomTwitter(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.deleteChatRoomTwitter((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.fetchChatRoomTwitter(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.getChatRoomTwitter(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.getChatRoomTwitters(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.getChatRoomTwittersCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.updateChatRoomTwitter((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.updateChatRoomTwitter((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            ChatRoomTwitterLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return ChatRoomTwitterLocalServiceUtil.getTwitter(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}
