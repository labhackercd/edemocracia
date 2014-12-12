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

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomUserLocalServiceUtil;

import java.util.Arrays;


public class ChatRoomUserLocalServiceClpInvoker {
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
    private String _methodName63;
    private String[] _methodParameterTypes63;
    private String _methodName64;
    private String[] _methodParameterTypes64;
    private String _methodName65;
    private String[] _methodParameterTypes65;

    public ChatRoomUserLocalServiceClpInvoker() {
        _methodName0 = "addChatRoomUser";

        _methodParameterTypes0 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser"
            };

        _methodName1 = "createChatRoomUser";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteChatRoomUser";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteChatRoomUser";

        _methodParameterTypes3 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser"
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

        _methodName9 = "fetchChatRoomUser";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getChatRoomUser";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getChatRoomUsers";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getChatRoomUsersCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateChatRoomUser";

        _methodParameterTypes14 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser"
            };

        _methodName15 = "updateChatRoomUser";

        _methodParameterTypes15 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser",
                "boolean"
            };

        _methodName56 = "getBeanIdentifier";

        _methodParameterTypes56 = new String[] {  };

        _methodName57 = "setBeanIdentifier";

        _methodParameterTypes57 = new String[] { "java.lang.String" };

        _methodName62 = "existsUserNameInChatRoom";

        _methodParameterTypes62 = new String[] { "long", "java.lang.String" };

        _methodName63 = "existsUserEmailInChatRoom";

        _methodParameterTypes63 = new String[] { "long", "java.lang.String" };

        _methodName64 = "isUserNameInUse";

        _methodParameterTypes64 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "java.lang.String"
            };

        _methodName65 = "findByPortalUser";

        _methodParameterTypes65 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "com.liferay.portal.model.User"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.addChatRoomUser((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.createChatRoomUser(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.deleteChatRoomUser(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.deleteChatRoomUser((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.fetchChatRoomUser(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.getChatRoomUser(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.getChatRoomUsers(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.getChatRoomUsersCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.updateChatRoomUser((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.updateChatRoomUser((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            ChatRoomUserLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.existsUserNameInChatRoom(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);
        }

        if (_methodName63.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.existsUserEmailInChatRoom(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.isUserNameInUse((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName65.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
            return ChatRoomUserLocalServiceUtil.findByPortalUser((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0],
                (com.liferay.portal.model.User) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
