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

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomClp;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomMessageClp;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitterClp;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUserClp;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideoClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "cd-chat-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "cd-chat-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "cd-chat-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(ChatRoomClp.class.getName())) {
            return translateInputChatRoom(oldModel);
        }

        if (oldModelClassName.equals(ChatRoomMessageClp.class.getName())) {
            return translateInputChatRoomMessage(oldModel);
        }

        if (oldModelClassName.equals(ChatRoomTwitterClp.class.getName())) {
            return translateInputChatRoomTwitter(oldModel);
        }

        if (oldModelClassName.equals(ChatRoomUserClp.class.getName())) {
            return translateInputChatRoomUser(oldModel);
        }

        if (oldModelClassName.equals(ChatRoomVideoClp.class.getName())) {
            return translateInputChatRoomVideo(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputChatRoom(BaseModel<?> oldModel) {
        ChatRoomClp oldClpModel = (ChatRoomClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getChatRoomRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputChatRoomMessage(BaseModel<?> oldModel) {
        ChatRoomMessageClp oldClpModel = (ChatRoomMessageClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getChatRoomMessageRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputChatRoomTwitter(BaseModel<?> oldModel) {
        ChatRoomTwitterClp oldClpModel = (ChatRoomTwitterClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getChatRoomTwitterRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputChatRoomUser(BaseModel<?> oldModel) {
        ChatRoomUserClp oldClpModel = (ChatRoomUserClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getChatRoomUserRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputChatRoomVideo(BaseModel<?> oldModel) {
        ChatRoomVideoClp oldClpModel = (ChatRoomVideoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getChatRoomVideoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomImpl")) {
            return translateOutputChatRoom(oldModel);
        }

        if (oldModelClassName.equals(
                    "br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomMessageImpl")) {
            return translateOutputChatRoomMessage(oldModel);
        }

        if (oldModelClassName.equals(
                    "br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomTwitterImpl")) {
            return translateOutputChatRoomTwitter(oldModel);
        }

        if (oldModelClassName.equals(
                    "br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserImpl")) {
            return translateOutputChatRoomUser(oldModel);
        }

        if (oldModelClassName.equals(
                    "br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomVideoImpl")) {
            return translateOutputChatRoomVideo(oldModel);
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals(
                    "br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException")) {
            return new br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomException();
        }

        if (className.equals(
                    "br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException")) {
            return new br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomMessageException();
        }

        if (className.equals(
                    "br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException")) {
            return new br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomTwitterException();
        }

        if (className.equals(
                    "br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException")) {
            return new br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomUserException();
        }

        if (className.equals(
                    "br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException")) {
            return new br.gov.camara.edemocracia.portlets.chat.NoSuchChatRoomVideoException();
        }

        return throwable;
    }

    public static Object translateOutputChatRoom(BaseModel<?> oldModel) {
        ChatRoomClp newModel = new ChatRoomClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setChatRoomRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputChatRoomMessage(BaseModel<?> oldModel) {
        ChatRoomMessageClp newModel = new ChatRoomMessageClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setChatRoomMessageRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputChatRoomTwitter(BaseModel<?> oldModel) {
        ChatRoomTwitterClp newModel = new ChatRoomTwitterClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setChatRoomTwitterRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputChatRoomUser(BaseModel<?> oldModel) {
        ChatRoomUserClp newModel = new ChatRoomUserClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setChatRoomUserRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputChatRoomVideo(BaseModel<?> oldModel) {
        ChatRoomVideoClp newModel = new ChatRoomVideoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setChatRoomVideoRemoteModel(oldModel);

        return newModel;
    }
}
