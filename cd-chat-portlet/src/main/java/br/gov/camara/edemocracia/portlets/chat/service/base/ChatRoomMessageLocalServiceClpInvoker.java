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

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomMessageLocalServiceUtil;

import java.util.Arrays;


public class ChatRoomMessageLocalServiceClpInvoker {
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
    private String _methodName64;
    private String[] _methodParameterTypes64;
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName68;
    private String[] _methodParameterTypes68;

    public ChatRoomMessageLocalServiceClpInvoker() {
        _methodName0 = "addChatRoomMessage";

        _methodParameterTypes0 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage"
            };

        _methodName1 = "createChatRoomMessage";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteChatRoomMessage";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteChatRoomMessage";

        _methodParameterTypes3 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage"
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

        _methodName9 = "fetchChatRoomMessage";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getChatRoomMessage";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getChatRoomMessages";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getChatRoomMessagesCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateChatRoomMessage";

        _methodParameterTypes14 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage"
            };

        _methodName15 = "updateChatRoomMessage";

        _methodParameterTypes15 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage",
                "boolean"
            };

        _methodName56 = "getBeanIdentifier";

        _methodParameterTypes56 = new String[] {  };

        _methodName57 = "setBeanIdentifier";

        _methodParameterTypes57 = new String[] { "java.lang.String" };

        _methodName62 = "getNullMessage";

        _methodParameterTypes62 = new String[] {  };

        _methodName64 = "postMessage";

        _methodParameterTypes64 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType",
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser",
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "java.util.Date", "java.lang.String", "boolean", "boolean",
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser",
                "int"
            };

        _methodName66 = "approveMessage";

        _methodParameterTypes66 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage",
                "java.util.Date", "boolean"
            };

        _methodName67 = "getMessagesForUserSince";

        _methodParameterTypes67 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser",
                "java.util.Date"
            };

        _methodName68 = "getMessagesForUserUntil";

        _methodParameterTypes68 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser",
                "java.util.Date"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.addChatRoomMessage((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.createChatRoomMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.deleteChatRoomMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.deleteChatRoomMessage((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.fetchChatRoomMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.getChatRoomMessage(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.getChatRoomMessages(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.getChatRoomMessagesCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.updateChatRoomMessage((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.updateChatRoomMessage((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            ChatRoomMessageLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.getNullMessage();
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            ChatRoomMessageLocalServiceUtil.postMessage((br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType) arguments[0],
                (br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) arguments[1],
                (br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[2],
                (java.util.Date) arguments[3], (java.lang.String) arguments[4],
                ((Boolean) arguments[5]).booleanValue(),
                ((Boolean) arguments[6]).booleanValue(),
                (br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) arguments[7],
                ((Integer) arguments[8]).intValue());
        }

        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            ChatRoomMessageLocalServiceUtil.approveMessage((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage) arguments[0],
                (java.util.Date) arguments[1],
                ((Boolean) arguments[2]).booleanValue());
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.getMessagesForUserSince((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0],
                (br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) arguments[1],
                (java.util.Date) arguments[2]);
        }

        if (_methodName68.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
            return ChatRoomMessageLocalServiceUtil.getMessagesForUserUntil((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0],
                (br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) arguments[1],
                (java.util.Date) arguments[2]);
        }

        throw new UnsupportedOperationException();
    }
}
