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
package br.gov.camara.edemocracia.portlets.chat.service;

import com.liferay.portal.service.InvokableService;


public class ChatRoomServiceClp implements ChatRoomService {
    private InvokableService _invokableService;
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
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
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName20;
    private String[] _methodParameterTypes20;
    private String _methodName21;
    private String[] _methodParameterTypes21;
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;
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
    private String _methodName33;
    private String[] _methodParameterTypes33;
    private String _methodName34;
    private String[] _methodParameterTypes34;
    private String _methodName35;
    private String[] _methodParameterTypes35;

    public ChatRoomServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "addChatRoom";

        _methodParameterTypes3 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom"
            };

        _methodName4 = "deleteChatRoom";

        _methodParameterTypes4 = new String[] { "long" };

        _methodName5 = "canModerate";

        _methodParameterTypes5 = new String[] { "long" };

        _methodName6 = "canJoin";

        _methodParameterTypes6 = new String[] { "long" };

        _methodName7 = "canSpy";

        _methodParameterTypes7 = new String[] { "long" };

        _methodName8 = "getUsersCountInChatRoom";

        _methodParameterTypes8 = new String[] { "long" };

        _methodName9 = "getChatRoomCommunityName";

        _methodParameterTypes9 = new String[] { "long" };

        _methodName10 = "addChatUser";

        _methodParameterTypes10 = new String[] { "long", "java.util.Date" };

        _methodName11 = "addAnonUser";

        _methodParameterTypes11 = new String[] {
                "long", "java.util.Date", "java.lang.String", "java.lang.String",
                "long"
            };

        _methodName12 = "addSpyUser";

        _methodParameterTypes12 = new String[] { "long", "java.util.Date" };

        _methodName13 = "approveMessage";

        _methodParameterTypes13 = new String[] {
                "long", "long", "boolean", "java.util.Date"
            };

        _methodName14 = "banUser";

        _methodParameterTypes14 = new String[] {
                "long", "long", "java.util.Date", "boolean"
            };

        _methodName15 = "findAllInGroup";

        _methodParameterTypes15 = new String[] { "long" };

        _methodName16 = "findOpenRoomsInGroup";

        _methodParameterTypes16 = new String[] { "long" };

        _methodName17 = "findOpenAndEnterableClosedRoomsInCompany";

        _methodParameterTypes17 = new String[] { "long" };

        _methodName18 = "findScheduledRoomsInGroup";

        _methodParameterTypes18 = new String[] { "long" };

        _methodName19 = "findScheduledRoomsInCompany";

        _methodParameterTypes19 = new String[] { "long" };

        _methodName20 = "findExportedRoomsInGroup";

        _methodParameterTypes20 = new String[] { "long" };

        _methodName21 = "findExportedRoomsInCompany";

        _methodParameterTypes21 = new String[] { "long" };

        _methodName22 = "getJSONUpdate";

        _methodParameterTypes22 = new String[] {
                "long",
                "br.gov.camara.edemocracia.portlets.chat.service.UserActivityId",
                "java.util.Date", "boolean"
            };

        _methodName23 = "getMessagesForExport";

        _methodParameterTypes23 = new String[] { "long" };

        _methodName24 = "findAllChatRoomParticipants";

        _methodParameterTypes24 = new String[] { "long" };

        _methodName25 = "getUserCount";

        _methodParameterTypes25 = new String[] { "long" };

        _methodName26 = "saveExportedMessages";

        _methodParameterTypes26 = new String[] { "long", "java.lang.Long[][]" };

        _methodName27 = "getMessagesWithIds";

        _methodParameterTypes27 = new String[] { "long", "java.lang.Long[][]" };

        _methodName28 = "getRoom";

        _methodParameterTypes28 = new String[] { "long" };

        _methodName29 = "getChatUserFromPortalUser";

        _methodParameterTypes29 = new String[] { "long" };

        _methodName30 = "getUsersInChatRoom";

        _methodParameterTypes30 = new String[] { "long" };

        _methodName31 = "openChatRoom";

        _methodParameterTypes31 = new String[] { "long", "java.util.Date" };

        _methodName32 = "closeChatRoom";

        _methodParameterTypes32 = new String[] { "long", "java.util.Date" };

        _methodName33 = "postMessage";

        _methodParameterTypes33 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType",
                "long", "long", "java.util.Date", "java.lang.String", "boolean",
                "boolean", "long", "int"
            };

        _methodName34 = "removeChatUser";

        _methodParameterTypes34 = new String[] {
                "long",
                "br.gov.camara.edemocracia.portlets.chat.service.UserActivityId",
                "java.util.Date"
            };

        _methodName35 = "updateChatRoom";

        _methodParameterTypes35 = new String[] {
                "br.gov.camara.edemocracia.portlets.chat.model.ChatRoom",
                "boolean"
            };
    }

    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName0,
                    _methodParameterTypes0, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        try {
            _invokableService.invokeMethod(_methodName1,
                _methodParameterTypes1,
                new Object[] { ClpSerializer.translateInput(beanIdentifier) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        throw new UnsupportedOperationException();
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom addChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom chatRoom)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] { ClpSerializer.translateInput(chatRoom) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) ClpSerializer.translateOutput(returnObj);
    }

    public void deleteChatRoom(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName4,
                _methodParameterTypes4, new Object[] { roomId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public boolean canModerate(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5, new Object[] { roomId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    public boolean canJoin(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6, new Object[] { roomId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    public boolean canSpy(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName7,
                    _methodParameterTypes7, new Object[] { roomId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    public long getUsersCountInChatRoom(long roomId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName8,
                    _methodParameterTypes8, new Object[] { roomId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Long) returnObj).longValue();
    }

    public java.lang.String getChatRoomCommunityName(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName9,
                    _methodParameterTypes9, new Object[] { roomId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addChatUser(
        long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName10,
                    _methodParameterTypes10,
                    new Object[] { roomId, ClpSerializer.translateInput(
                            timestamp) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser addAnonUser(
        long roomId, java.util.Date timestamp, java.lang.String name,
        java.lang.String email, long uf)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName11,
                    _methodParameterTypes11,
                    new Object[] {
                        roomId,
                        
                    ClpSerializer.translateInput(timestamp),
                        
                    ClpSerializer.translateInput(name),
                        
                    ClpSerializer.translateInput(email),
                        
                    uf
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.service.UserActivityId addSpyUser(
        long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName12,
                    _methodParameterTypes12,
                    new Object[] { roomId, ClpSerializer.translateInput(
                            timestamp) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.service.UserActivityId) ClpSerializer.translateOutput(returnObj);
    }

    public void approveMessage(long roomId, long messageId, boolean approved,
        java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName13,
                _methodParameterTypes13,
                new Object[] {
                    roomId,
                    
                messageId,
                    
                approved,
                    
                ClpSerializer.translateInput(timestamp)
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public void banUser(long roomId, long chatUserId, java.util.Date timestamp,
        boolean banned)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName14,
                _methodParameterTypes14,
                new Object[] {
                    roomId,
                    
                chatUserId,
                    
                ClpSerializer.translateInput(timestamp),
                    
                banned
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom[] findAllInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName15,
                    _methodParameterTypes15, new Object[] { groupId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.model.ChatRoom[]) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findOpenRoomsInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName16,
                    _methodParameterTypes16, new Object[] { groupId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[]) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findOpenAndEnterableClosedRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName17,
                    _methodParameterTypes17, new Object[] { companyId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[]) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findScheduledRoomsInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName18,
                    _methodParameterTypes18, new Object[] { groupId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[]) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findScheduledRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName19,
                    _methodParameterTypes19, new Object[] { companyId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[]) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findExportedRoomsInGroup(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName20,
                    _methodParameterTypes20, new Object[] { groupId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[]) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[] findExportedRoomsInCompany(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName21,
                    _methodParameterTypes21, new Object[] { companyId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.ChatRoomBean[]) ClpSerializer.translateOutput(returnObj);
    }

    public java.lang.String getJSONUpdate(long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId,
        java.util.Date since, boolean firstUpdate)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName22,
                    _methodParameterTypes22,
                    new Object[] {
                        roomId,
                        
                    ClpSerializer.translateInput(userActivityId),
                        
                    ClpSerializer.translateInput(since),
                        
                    firstUpdate
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] getMessagesForExport(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName23,
                    _methodParameterTypes23, new Object[] { roomId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[]) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean> findAllChatRoomParticipants(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName24,
                    _methodParameterTypes24, new Object[] { roomId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean>) ClpSerializer.translateOutput(returnObj);
    }

    public long getUserCount(long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName25,
                    _methodParameterTypes25, new Object[] { roomId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Long) returnObj).longValue();
    }

    public void saveExportedMessages(long roomId, java.lang.Long[] messages)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName26,
                _methodParameterTypes26,
                new Object[] { roomId, ClpSerializer.translateInput(messages) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[] getMessagesWithIds(
        long roomId, java.lang.Long[] messages)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName27,
                    _methodParameterTypes27,
                    new Object[] { roomId, ClpSerializer.translateInput(
                            messages) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessage[]) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoom getRoom(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName28,
                    _methodParameterTypes28, new Object[] { roomId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.model.ChatRoom) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser getChatUserFromPortalUser(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName29,
                    _methodParameterTypes29, new Object[] { roomId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser) ClpSerializer.translateOutput(returnObj);
    }

    public br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[] getUsersInChatRoom(
        long roomId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName30,
                    _methodParameterTypes30, new Object[] { roomId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser[]) ClpSerializer.translateOutput(returnObj);
    }

    public void openChatRoom(long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName31,
                _methodParameterTypes31,
                new Object[] { roomId, ClpSerializer.translateInput(timestamp) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public void closeChatRoom(long roomId, java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName32,
                _methodParameterTypes32,
                new Object[] { roomId, ClpSerializer.translateInput(timestamp) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public void postMessage(
        br.gov.camara.edemocracia.portlets.chat.model.impl.MessageType type,
        long chatUserId, long roomId, java.util.Date timestamp,
        java.lang.String message, boolean pub, boolean admin,
        long recipientUser, int textType)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName33,
                _methodParameterTypes33,
                new Object[] {
                    ClpSerializer.translateInput(type),
                    
                chatUserId,
                    
                roomId,
                    
                ClpSerializer.translateInput(timestamp),
                    
                ClpSerializer.translateInput(message),
                    
                pub,
                    
                admin,
                    
                recipientUser,
                    
                textType
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public void removeChatUser(long roomId,
        br.gov.camara.edemocracia.portlets.chat.service.UserActivityId userActivityId,
        java.util.Date timestamp)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName34,
                _methodParameterTypes34,
                new Object[] {
                    roomId,
                    
                ClpSerializer.translateInput(userActivityId),
                    
                ClpSerializer.translateInput(timestamp)
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public void updateChatRoom(
        br.gov.camara.edemocracia.portlets.chat.model.ChatRoom room,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableService.invokeMethod(_methodName35,
                _methodParameterTypes35,
                new Object[] { ClpSerializer.translateInput(room), merge });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }
}
