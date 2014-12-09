package br.gov.camara.edemocracia.portlets.chat.service.base;

import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomLocalServiceUtil;

import java.util.Arrays;


public class ChatRoomLocalServiceClpInvoker {
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
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName68;
    private String[] _methodParameterTypes68;
    private String _methodName69;
    private String[] _methodParameterTypes69;
    private String _methodName70;
    private String[] _methodParameterTypes70;
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName79;
    private String[] _methodParameterTypes79;
    private String _methodName80;
    private String[] _methodParameterTypes80;
    private String _methodName82;
    private String[] _methodParameterTypes82;
    private String _methodName83;
    private String[] _methodParameterTypes83;
    private String _methodName84;
    private String[] _methodParameterTypes84;
    private String _methodName85;
    private String[] _methodParameterTypes85;
    private String _methodName90;
    private String[] _methodParameterTypes90;
    private String _methodName91;
    private String[] _methodParameterTypes91;
    private String _methodName92;
    private String[] _methodParameterTypes92;
    private String _methodName93;
    private String[] _methodParameterTypes93;

    public ChatRoomLocalServiceClpInvoker() {
        _methodName0 = "addChatRoom";

        _methodParameterTypes0 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom"
            };

        _methodName1 = "createChatRoom";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteChatRoom";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteChatRoom";

        _methodParameterTypes3 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom"
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

        _methodName9 = "fetchChatRoom";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "getChatRoom";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getPersistedModel";

        _methodParameterTypes11 = new String[] { "java.io.Serializable" };

        _methodName12 = "getChatRooms";

        _methodParameterTypes12 = new String[] { "int", "int" };

        _methodName13 = "getChatRoomsCount";

        _methodParameterTypes13 = new String[] {  };

        _methodName14 = "updateChatRoom";

        _methodParameterTypes14 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom"
            };

        _methodName15 = "updateChatRoom";

        _methodParameterTypes15 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "boolean"
            };

        _methodName56 = "getBeanIdentifier";

        _methodParameterTypes56 = new String[] {  };

        _methodName57 = "setBeanIdentifier";

        _methodParameterTypes57 = new String[] { "java.lang.String" };

        _methodName62 = "findOpenAndEnterableClosedRoomsInCompany";

        _methodParameterTypes62 = new String[] { "long", "boolean" };

        _methodName63 = "findScheduledRoomsInCompany";

        _methodParameterTypes63 = new String[] { "long" };

        _methodName64 = "findExportedRoomsInCompany";

        _methodParameterTypes64 = new String[] { "long" };

        _methodName65 = "listUsersStartingBy";

        _methodParameterTypes65 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "java.lang.String"
            };

        _methodName66 = "isFullNameInUseInPortal";

        _methodParameterTypes66 = new String[] { "long", "java.lang.String" };

        _methodName67 = "getUsersCountInChatRoom";

        _methodParameterTypes67 = new String[] { "long" };

        _methodName68 = "roomHaveSpaceLeft";

        _methodParameterTypes68 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom"
            };

        _methodName69 = "addUserToRoom";

        _methodParameterTypes69 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "com.liferay.portal.model.User", "java.util.Date"
            };

        _methodName70 = "addModeratorToRoom";

        _methodParameterTypes70 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "com.liferay.portal.model.User", "java.util.Date"
            };

        _methodName72 = "addAnonUser";

        _methodParameterTypes72 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "java.util.Date", "java.lang.String", "java.lang.String", "long"
            };

        _methodName79 = "addSpyUser";

        _methodParameterTypes79 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "java.util.Date", "com.liferay.portal.model.User"
            };

        _methodName80 = "banirUsuario";

        _methodParameterTypes80 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser",
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser",
                "java.util.Date", "boolean"
            };

        _methodName82 = "isUserInRoom";

        _methodParameterTypes82 = new String[] {
                "java.lang.Long",
                "br.gov.camara.edemocracia.portlets.chat.service.UserActivityId"
            };

        _methodName83 = "updateUserTimestamp";

        _methodParameterTypes83 = new String[] {
                "java.lang.Long",
                "br.gov.camara.edemocracia.portlets.chat.service.UserActivityId"
            };

        _methodName84 = "removeSpyUser";

        _methodParameterTypes84 = new String[] {
                "java.lang.Long",
                "br.gov.camara.edemocracia.portlets.chat.service.UserActivityId"
            };

        _methodName85 = "removeUser";

        _methodParameterTypes85 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser",
                "java.util.Date"
            };

        _methodName90 = "checkScheduledRoomState";

        _methodParameterTypes90 = new String[] { "java.util.Date" };

        _methodName91 = "removerUsuariosInativos";

        _methodParameterTypes91 = new String[] {  };

        _methodName92 = "removerUsuariosBanidosDeSalasFechadas";

        _methodParameterTypes92 = new String[] {  };

        _methodName93 = "synchronizeActivityManagerAndDatabase";

        _methodParameterTypes93 = new String[] {  };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ChatRoomLocalServiceUtil.addChatRoom((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ChatRoomLocalServiceUtil.createChatRoom(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ChatRoomLocalServiceUtil.deleteChatRoom(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ChatRoomLocalServiceUtil.deleteChatRoom((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ChatRoomLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ChatRoomLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ChatRoomLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ChatRoomLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ChatRoomLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ChatRoomLocalServiceUtil.fetchChatRoom(((Long) arguments[0]).longValue());
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ChatRoomLocalServiceUtil.getChatRoom(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ChatRoomLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ChatRoomLocalServiceUtil.getChatRooms(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ChatRoomLocalServiceUtil.getChatRoomsCount();
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ChatRoomLocalServiceUtil.updateChatRoom((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ChatRoomLocalServiceUtil.updateChatRoom((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return ChatRoomLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            ChatRoomLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return ChatRoomLocalServiceUtil.findOpenAndEnterableClosedRoomsInCompany(((Long) arguments[0]).longValue(),
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName63.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
            return ChatRoomLocalServiceUtil.findScheduledRoomsInCompany(((Long) arguments[0]).longValue());
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            return ChatRoomLocalServiceUtil.findExportedRoomsInCompany(((Long) arguments[0]).longValue());
        }

        if (_methodName65.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
            return ChatRoomLocalServiceUtil.listUsersStartingBy((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return ChatRoomLocalServiceUtil.isFullNameInUseInPortal(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            return ChatRoomLocalServiceUtil.getUsersCountInChatRoom(((Long) arguments[0]).longValue());
        }

        if (_methodName68.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
            return ChatRoomLocalServiceUtil.roomHaveSpaceLeft((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0]);
        }

        if (_methodName69.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
            return ChatRoomLocalServiceUtil.addUserToRoom((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0],
                (com.liferay.portal.model.User) arguments[1],
                (java.util.Date) arguments[2]);
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return ChatRoomLocalServiceUtil.addModeratorToRoom((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0],
                (com.liferay.portal.model.User) arguments[1],
                (java.util.Date) arguments[2]);
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return ChatRoomLocalServiceUtil.addAnonUser((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0],
                (java.util.Date) arguments[1], (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                ((Long) arguments[4]).longValue());
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            return ChatRoomLocalServiceUtil.addSpyUser((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0],
                (java.util.Date) arguments[1],
                (com.liferay.portal.model.User) arguments[2]);
        }

        if (_methodName80.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
            ChatRoomLocalServiceUtil.banirUsuario((br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) arguments[0],
                (br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) arguments[1],
                (br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) arguments[2],
                (java.util.Date) arguments[3],
                ((Boolean) arguments[4]).booleanValue());
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return ChatRoomLocalServiceUtil.isUserInRoom((java.lang.Long) arguments[0],
                (br.gov.camara.edemocracia.portlets.chat.service.UserActivityId) arguments[1]);
        }

        if (_methodName83.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
            ChatRoomLocalServiceUtil.updateUserTimestamp((java.lang.Long) arguments[0],
                (br.gov.camara.edemocracia.portlets.chat.service.UserActivityId) arguments[1]);
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            ChatRoomLocalServiceUtil.removeSpyUser((java.lang.Long) arguments[0],
                (br.gov.camara.edemocracia.portlets.chat.service.UserActivityId) arguments[1]);
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            ChatRoomLocalServiceUtil.removeUser((br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) arguments[0],
                (java.util.Date) arguments[1]);
        }

        if (_methodName90.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
            ChatRoomLocalServiceUtil.checkScheduledRoomState((java.util.Date) arguments[0]);
        }

        if (_methodName91.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
            ChatRoomLocalServiceUtil.removerUsuariosInativos();
        }

        if (_methodName92.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
            ChatRoomLocalServiceUtil.removerUsuariosBanidosDeSalasFechadas();
        }

        if (_methodName93.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
            ChatRoomLocalServiceUtil.synchronizeActivityManagerAndDatabase();
        }

        throw new UnsupportedOperationException();
    }
}
