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
package br.gov.camara.edemocracia.movetopico.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;


public class MoveTopicoLocalServiceClp implements MoveTopicoLocalService {
    private ClassLoaderProxy _classLoaderProxy;
    private MethodKey _getBeanIdentifierMethodKey0;
    private MethodKey _setBeanIdentifierMethodKey1;
    private MethodKey _getTopicosPorComunidadeEForumMethodKey2;
    private MethodKey _getForunsComunidadeMethodKey3;
    private MethodKey _getComunidadesComPermissaoParaMoverMethodKey4;
    private MethodKey _moveTopicoMethodKey5;

    public MoveTopicoLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;

        _getBeanIdentifierMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
                "getBeanIdentifier");

        _setBeanIdentifierMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
                "setBeanIdentifier", java.lang.String.class);

        _getTopicosPorComunidadeEForumMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
                "getTopicosPorComunidadeEForum", long.class, long.class);

        _getForunsComunidadeMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
                "getForunsComunidade", long.class);

        _getComunidadesComPermissaoParaMoverMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
                "getComunidadesComPermissaoParaMover", long.class, long.class);

        _moveTopicoMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
                "moveTopico",
                br.gov.camara.edemocracia.movetopico.model.InfoMoverTopico.class);
    }

    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey0);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
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
        MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey1,
                ClpSerializer.translateInput(beanIdentifier));

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public java.util.List<br.gov.camara.edemocracia.movetopico.model.Topico> getTopicosPorComunidadeEForum(
        long idComunidade, long idForum) {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getTopicosPorComunidadeEForumMethodKey2,
                idComunidade, idForum);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<br.gov.camara.edemocracia.movetopico.model.Topico>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<com.liferay.portlet.messageboards.model.MBCategory> getForunsComunidade(
        long idComunidade) {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getForunsComunidadeMethodKey3,
                idComunidade);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.liferay.portlet.messageboards.model.MBCategory>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<com.liferay.portal.model.Group> getComunidadesComPermissaoParaMover(
        long idUsuario, long idComunidadeOrigem) {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getComunidadesComPermissaoParaMoverMethodKey4,
                idUsuario, idComunidadeOrigem);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.liferay.portal.model.Group>) ClpSerializer.translateOutput(returnObj);
    }

    public void moveTopico(
        br.gov.camara.edemocracia.movetopico.model.InfoMoverTopico info)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        MethodHandler methodHandler = new MethodHandler(_moveTopicoMethodKey5,
                ClpSerializer.translateInput(info));

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
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

    public ClassLoaderProxy getClassLoaderProxy() {
        return _classLoaderProxy;
    }
}
