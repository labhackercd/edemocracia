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
package br.gov.camara.edemocracia.portlets.graficos.service;

import com.liferay.portal.service.InvokableLocalService;


public class GraficosLocalServiceClp implements GraficosLocalService {
    private InvokableLocalService _invokableLocalService;
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

    public GraficosLocalServiceClp(InvokableLocalService invokableLocalService) {
        _invokableLocalService = invokableLocalService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "getUsuariosPorUf";

        _methodParameterTypes3 = new String[] {
                "long", "com.liferay.portal.model.Country"
            };

        _methodName4 = "getUsuariosPorData";

        _methodParameterTypes4 = new String[] {
                "long", "java.util.TimeZone", "java.util.Date", "java.util.Date"
            };

        _methodName5 = "getAtividadePorData";

        _methodParameterTypes5 = new String[] {
                "long", "java.util.TimeZone", "java.util.Date", "java.util.Date"
            };
    }

    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName0,
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
            _invokableLocalService.invokeMethod(_methodName1,
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

    public java.util.Map<java.lang.String, java.lang.Integer> getUsuariosPorUf(
        long companyId, com.liferay.portal.model.Country pais) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] { companyId, ClpSerializer.translateInput(pais) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map<java.lang.String, java.lang.Integer>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.Map<java.lang.String, java.lang.Integer> getUsuariosPorData(
        long companyId, java.util.TimeZone tz, java.util.Date inicio,
        java.util.Date fim) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] {
                        companyId,
                        
                    ClpSerializer.translateInput(tz),
                        
                    ClpSerializer.translateInput(inicio),
                        
                    ClpSerializer.translateInput(fim)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map<java.lang.String, java.lang.Integer>) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.Map<java.lang.String, java.lang.Integer> getAtividadePorData(
        long companyId, java.util.TimeZone tz, java.util.Date inicio,
        java.util.Date fim) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] {
                        companyId,
                        
                    ClpSerializer.translateInput(tz),
                        
                    ClpSerializer.translateInput(inicio),
                        
                    ClpSerializer.translateInput(fim)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.Map<java.lang.String, java.lang.Integer>) ClpSerializer.translateOutput(returnObj);
    }
}
