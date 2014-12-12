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
package br.gov.camara.edemocracia.portlets.priorizacao.service;

import br.gov.camara.edemocracia.portlets.priorizacao.model.ConfiguracaoClp;
import br.gov.camara.edemocracia.portlets.priorizacao.model.EixoClp;
import br.gov.camara.edemocracia.portlets.priorizacao.model.PropostaClp;
import br.gov.camara.edemocracia.portlets.priorizacao.model.VotoClp;

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
                        "cd-priorizacao-portlet-deployment-context");

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
                            "cd-priorizacao-portlet-deployment-context");

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
                _servletContextName = "cd-priorizacao-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(ConfiguracaoClp.class.getName())) {
            return translateInputConfiguracao(oldModel);
        }

        if (oldModelClassName.equals(EixoClp.class.getName())) {
            return translateInputEixo(oldModel);
        }

        if (oldModelClassName.equals(PropostaClp.class.getName())) {
            return translateInputProposta(oldModel);
        }

        if (oldModelClassName.equals(VotoClp.class.getName())) {
            return translateInputVoto(oldModel);
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

    public static Object translateInputConfiguracao(BaseModel<?> oldModel) {
        ConfiguracaoClp oldClpModel = (ConfiguracaoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getConfiguracaoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputEixo(BaseModel<?> oldModel) {
        EixoClp oldClpModel = (EixoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getEixoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputProposta(BaseModel<?> oldModel) {
        PropostaClp oldClpModel = (PropostaClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getPropostaRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputVoto(BaseModel<?> oldModel) {
        VotoClp oldClpModel = (VotoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getVotoRemoteModel();

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
                    "br.gov.camara.edemocracia.portlets.priorizacao.model.impl.ConfiguracaoImpl")) {
            return translateOutputConfiguracao(oldModel);
        }

        if (oldModelClassName.equals(
                    "br.gov.camara.edemocracia.portlets.priorizacao.model.impl.EixoImpl")) {
            return translateOutputEixo(oldModel);
        }

        if (oldModelClassName.equals(
                    "br.gov.camara.edemocracia.portlets.priorizacao.model.impl.PropostaImpl")) {
            return translateOutputProposta(oldModel);
        }

        if (oldModelClassName.equals(
                    "br.gov.camara.edemocracia.portlets.priorizacao.model.impl.VotoImpl")) {
            return translateOutputVoto(oldModel);
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
                    "br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException")) {
            return new br.gov.camara.edemocracia.portlets.priorizacao.NoSuchConfiguracaoException();
        }

        if (className.equals(
                    "br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException")) {
            return new br.gov.camara.edemocracia.portlets.priorizacao.NoSuchEixoException();
        }

        if (className.equals(
                    "br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException")) {
            return new br.gov.camara.edemocracia.portlets.priorizacao.NoSuchPropostaException();
        }

        if (className.equals(
                    "br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException")) {
            return new br.gov.camara.edemocracia.portlets.priorizacao.NoSuchVotoException();
        }

        return throwable;
    }

    public static Object translateOutputConfiguracao(BaseModel<?> oldModel) {
        ConfiguracaoClp newModel = new ConfiguracaoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setConfiguracaoRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputEixo(BaseModel<?> oldModel) {
        EixoClp newModel = new EixoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setEixoRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputProposta(BaseModel<?> oldModel) {
        PropostaClp newModel = new PropostaClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setPropostaRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputVoto(BaseModel<?> oldModel) {
        VotoClp newModel = new VotoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setVotoRemoteModel(oldModel);

        return newModel;
    }
}
