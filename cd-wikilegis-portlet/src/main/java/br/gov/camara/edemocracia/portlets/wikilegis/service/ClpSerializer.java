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
package br.gov.camara.edemocracia.portlets.wikilegis.service;

import br.gov.camara.edemocracia.portlets.wikilegis.model.ArtigoClp;
import br.gov.camara.edemocracia.portlets.wikilegis.model.ContribuicaoClp;
import br.gov.camara.edemocracia.portlets.wikilegis.model.EstruturaClp;

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
                        "cd-wikilegis-portlet-deployment-context");

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
                            "cd-wikilegis-portlet-deployment-context");

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
                _servletContextName = "cd-wikilegis-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(ArtigoClp.class.getName())) {
            return translateInputArtigo(oldModel);
        }

        if (oldModelClassName.equals(ContribuicaoClp.class.getName())) {
            return translateInputContribuicao(oldModel);
        }

        if (oldModelClassName.equals(EstruturaClp.class.getName())) {
            return translateInputEstrutura(oldModel);
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

    public static Object translateInputArtigo(BaseModel<?> oldModel) {
        ArtigoClp oldClpModel = (ArtigoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getArtigoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputContribuicao(BaseModel<?> oldModel) {
        ContribuicaoClp oldClpModel = (ContribuicaoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getContribuicaoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputEstrutura(BaseModel<?> oldModel) {
        EstruturaClp oldClpModel = (EstruturaClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getEstruturaRemoteModel();

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
                    "br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ArtigoImpl")) {
            return translateOutputArtigo(oldModel);
        }

        if (oldModelClassName.equals(
                    "br.gov.camara.edemocracia.portlets.wikilegis.model.impl.ContribuicaoImpl")) {
            return translateOutputContribuicao(oldModel);
        }

        if (oldModelClassName.equals(
                    "br.gov.camara.edemocracia.portlets.wikilegis.model.impl.EstruturaImpl")) {
            return translateOutputEstrutura(oldModel);
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
                    "br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException")) {
            return new br.gov.camara.edemocracia.portlets.wikilegis.NoSuchArtigoException();
        }

        if (className.equals(
                    "br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException")) {
            return new br.gov.camara.edemocracia.portlets.wikilegis.NoSuchContribuicaoException();
        }

        if (className.equals(
                    "br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException")) {
            return new br.gov.camara.edemocracia.portlets.wikilegis.NoSuchEstruturaException();
        }

        return throwable;
    }

    public static Object translateOutputArtigo(BaseModel<?> oldModel) {
        ArtigoClp newModel = new ArtigoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setArtigoRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputContribuicao(BaseModel<?> oldModel) {
        ContribuicaoClp newModel = new ContribuicaoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setContribuicaoRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputEstrutura(BaseModel<?> oldModel) {
        EstruturaClp newModel = new EstruturaClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setEstruturaRemoteModel(oldModel);

        return newModel;
    }
}
