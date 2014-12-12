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

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

import java.util.Arrays;


public class ChatRoomServiceClpInvoker {
    private String _methodName40;
    private String[] _methodParameterTypes40;
    private String _methodName41;
    private String[] _methodParameterTypes41;
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;
    private String _methodName48;
    private String[] _methodParameterTypes48;
    private String _methodName50;
    private String[] _methodParameterTypes50;
    private String _methodName51;
    private String[] _methodParameterTypes51;
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
    private String _methodName64;
    private String[] _methodParameterTypes64;
    private String _methodName65;
    private String[] _methodParameterTypes65;
    private String _methodName69;
    private String[] _methodParameterTypes69;
    private String _methodName70;
    private String[] _methodParameterTypes70;
    private String _methodName71;
    private String[] _methodParameterTypes71;
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName73;
    private String[] _methodParameterTypes73;
    private String _methodName74;
    private String[] _methodParameterTypes74;
    private String _methodName75;
    private String[] _methodParameterTypes75;
    private String _methodName76;
    private String[] _methodParameterTypes76;
    private String _methodName77;
    private String[] _methodParameterTypes77;
    private String _methodName78;
    private String[] _methodParameterTypes78;
    private String _methodName79;
    private String[] _methodParameterTypes79;
    private String _methodName80;
    private String[] _methodParameterTypes80;
    private String _methodName81;
    private String[] _methodParameterTypes81;
    private String _methodName82;
    private String[] _methodParameterTypes82;
    private String _methodName83;
    private String[] _methodParameterTypes83;
    private String _methodName84;
    private String[] _methodParameterTypes84;

    public ChatRoomServiceClpInvoker() {
        _methodName40 = "getBeanIdentifier";

        _methodParameterTypes40 = new String[] {  };

        _methodName41 = "setBeanIdentifier";

        _methodParameterTypes41 = new String[] { "java.lang.String" };

        _methodName46 = "addChatRoom";

        _methodParameterTypes46 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom"
            };

        _methodName47 = "deleteChatRoom";

        _methodParameterTypes47 = new String[] { "long" };

        _methodName48 = "canModerate";

        _methodParameterTypes48 = new String[] { "long" };

        _methodName50 = "canJoin";

        _methodParameterTypes50 = new String[] { "long" };

        _methodName51 = "canSpy";

        _methodParameterTypes51 = new String[] { "long" };

        _methodName53 = "getUsersCountInChatRoom";

        _methodParameterTypes53 = new String[] { "long" };

        _methodName54 = "getChatRoomCommunityName";

        _methodParameterTypes54 = new String[] { "long" };

        _methodName55 = "addChatUser";

        _methodParameterTypes55 = new String[] { "long", "java.util.Date" };

        _methodName56 = "addAnonUser";

        _methodParameterTypes56 = new String[] {
                "long", "java.util.Date", "java.lang.String", "java.lang.String",
                "long"
            };

        _methodName57 = "addSpyUser";

        _methodParameterTypes57 = new String[] { "long", "java.util.Date" };

        _methodName58 = "approveMessage";

        _methodParameterTypes58 = new String[] {
                "long", "long", "boolean", "java.util.Date"
            };

        _methodName59 = "banUser";

        _methodParameterTypes59 = new String[] {
                "long", "long", "java.util.Date", "boolean"
            };

        _methodName60 = "findAllInGroup";

        _methodParameterTypes60 = new String[] { "long" };

        _methodName61 = "findOpenRoomsInGroup";

        _methodParameterTypes61 = new String[] { "long" };

        _methodName62 = "findOpenAndEnterableClosedRoomsInCompany";

        _methodParameterTypes62 = new String[] { "long" };

        _methodName64 = "findScheduledRoomsInGroup";

        _methodParameterTypes64 = new String[] { "long" };

        _methodName65 = "findScheduledRoomsInCompany";

        _methodParameterTypes65 = new String[] { "long" };

        _methodName69 = "findExportedRoomsInGroup";

        _methodParameterTypes69 = new String[] { "long" };

        _methodName70 = "findExportedRoomsInCompany";

        _methodParameterTypes70 = new String[] { "long" };

        _methodName71 = "getJSONUpdate";

        _methodParameterTypes71 = new String[] {
                "long",
                "br.gov.camara.edemocracia.portlets.chat.service.UserActivityId",
                "java.util.Date", "boolean"
            };

        _methodName72 = "getMessagesForExport";

        _methodParameterTypes72 = new String[] { "long" };

        _methodName73 = "findAllChatRoomParticipants";

        _methodParameterTypes73 = new String[] { "long" };

        _methodName74 = "getUserCount";

        _methodParameterTypes74 = new String[] { "long" };

        _methodName75 = "saveExportedMessages";

        _methodParameterTypes75 = new String[] { "long", "java.lang.Long[][]" };

        _methodName76 = "getMessagesWithIds";

        _methodParameterTypes76 = new String[] { "long", "java.lang.Long[][]" };

        _methodName77 = "getRoom";

        _methodParameterTypes77 = new String[] { "long" };

        _methodName78 = "getChatUserFromPortalUser";

        _methodParameterTypes78 = new String[] { "long" };

        _methodName79 = "getUsersInChatRoom";

        _methodParameterTypes79 = new String[] { "long" };

        _methodName80 = "openChatRoom";

        _methodParameterTypes80 = new String[] { "long", "java.util.Date" };

        _methodName81 = "closeChatRoom";

        _methodParameterTypes81 = new String[] { "long", "java.util.Date" };

        _methodName82 = "postMessage";

        _methodParameterTypes82 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType",
                "long", "long", "java.util.Date", "java.lang.String", "boolean",
                "boolean", "long", "int"
            };

        _methodName83 = "removeChatUser";

        _methodParameterTypes83 = new String[] {
                "long",
                "br.gov.camara.edemocracia.portlets.chat.service.UserActivityId",
                "java.util.Date"
            };

        _methodName84 = "updateChatRoom";

        _methodParameterTypes84 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "boolean"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName40.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
            return ChatRoomServiceUtil.getBeanIdentifier();
        }

        if (_methodName41.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
            ChatRoomServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return ChatRoomServiceUtil.addChatRoom((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0]);
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            ChatRoomServiceUtil.deleteChatRoom(((Long) arguments[0]).longValue());
        }

        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            return ChatRoomServiceUtil.canModerate(((Long) arguments[0]).longValue());
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return ChatRoomServiceUtil.canJoin(((Long) arguments[0]).longValue());
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            return ChatRoomServiceUtil.canSpy(((Long) arguments[0]).longValue());
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            return ChatRoomServiceUtil.getUsersCountInChatRoom(((Long) arguments[0]).longValue());
        }

        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            return ChatRoomServiceUtil.getChatRoomCommunityName(((Long) arguments[0]).longValue());
        }

        if (_methodName55.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
            return ChatRoomServiceUtil.addChatUser(((Long) arguments[0]).longValue(),
                (java.util.Date) arguments[1]);
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return ChatRoomServiceUtil.addAnonUser(((Long) arguments[0]).longValue(),
                (java.util.Date) arguments[1], (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Long) arguments[4]).longValue());
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            return ChatRoomServiceUtil.addSpyUser(((Long) arguments[0]).longValue(),
                (java.util.Date) arguments[1]);
        }

        if (_methodName58.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
            ChatRoomServiceUtil.approveMessage(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Boolean) arguments[2]).booleanValue(),
                (java.util.Date) arguments[3]);
        }

        if (_methodName59.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
            ChatRoomServiceUtil.banUser(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.util.Date) arguments[2],
                ((Boolean) arguments[3]).booleanValue());
        }

        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return ChatRoomServiceUtil.findAllInGroup(((Long) arguments[0]).longValue());
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            return ChatRoomServiceUtil.findOpenRoomsInGroup(((Long) arguments[0]).longValue());
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return ChatRoomServiceUtil.findOpenAndEnterableClosedRoomsInCompany(((Long) arguments[0]).longValue());
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            return ChatRoomServiceUtil.findScheduledRoomsInGroup(((Long) arguments[0]).longValue());
        }

        if (_methodName65.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
            return ChatRoomServiceUtil.findScheduledRoomsInCompany(((Long) arguments[0]).longValue());
        }

        if (_methodName69.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
            return ChatRoomServiceUtil.findExportedRoomsInGroup(((Long) arguments[0]).longValue());
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return ChatRoomServiceUtil.findExportedRoomsInCompany(((Long) arguments[0]).longValue());
        }

        if (_methodName71.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
            return ChatRoomServiceUtil.getJSONUpdate(((Long) arguments[0]).longValue(),
                (br.gov.camara.edemocracia.portlets.chat.service.UserActivityId) arguments[1],
                (java.util.Date) arguments[2],
                ((Boolean) arguments[3]).booleanValue());
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return ChatRoomServiceUtil.getMessagesForExport(((Long) arguments[0]).longValue());
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            return ChatRoomServiceUtil.findAllChatRoomParticipants(((Long) arguments[0]).longValue());
        }

        if (_methodName74.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
            return ChatRoomServiceUtil.getUserCount(((Long) arguments[0]).longValue());
        }

        if (_methodName75.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
            ChatRoomServiceUtil.saveExportedMessages(((Long) arguments[0]).longValue(),
                (java.lang.Long[]) arguments[1]);
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return ChatRoomServiceUtil.getMessagesWithIds(((Long) arguments[0]).longValue(),
                (java.lang.Long[]) arguments[1]);
        }

        if (_methodName77.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
            return ChatRoomServiceUtil.getRoom(((Long) arguments[0]).longValue());
        }

        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return ChatRoomServiceUtil.getChatUserFromPortalUser(((Long) arguments[0]).longValue());
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            return ChatRoomServiceUtil.getUsersInChatRoom(((Long) arguments[0]).longValue());
        }

        if (_methodName80.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
            ChatRoomServiceUtil.openChatRoom(((Long) arguments[0]).longValue(),
                (java.util.Date) arguments[1]);
        }

        if (_methodName81.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
            ChatRoomServiceUtil.closeChatRoom(((Long) arguments[0]).longValue(),
                (java.util.Date) arguments[1]);
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            ChatRoomServiceUtil.postMessage((br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType) arguments[0],
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.util.Date) arguments[3], (java.lang.String) arguments[4],
                ((Boolean) arguments[5]).booleanValue(),
                ((Boolean) arguments[6]).booleanValue(),
                ((Long) arguments[7]).longValue(),
                ((Integer) arguments[8]).intValue());
        }

        if (_methodName83.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
            ChatRoomServiceUtil.removeChatUser(((Long) arguments[0]).longValue(),
                (br.gov.camara.edemocracia.portlets.chat.service.UserActivityId) arguments[1],
                (java.util.Date) arguments[2]);
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            ChatRoomServiceUtil.updateChatRoom((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        throw new UnsupportedOperationException();
    }
}
