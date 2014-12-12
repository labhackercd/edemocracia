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
package br.gov.camara.edemocracia.portlets.priorizacao.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class PropostaFinderUtil {
    private static PropostaFinder _finder;

    public static java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay> findPropostaDisplayByUserEixo(
        long userId, long eixoId, int votosDisponiveis, boolean podeVerVotos,
        boolean podeVotar)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .findPropostaDisplayByUserEixo(userId, eixoId,
            votosDisponiveis, podeVerVotos, podeVotar);
    }

    public static PropostaFinder getFinder() {
        if (_finder == null) {
            _finder = (PropostaFinder) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.priorizacao.service.ClpSerializer.getServletContextName(),
                    PropostaFinder.class.getName());

            ReferenceRegistry.registerReference(PropostaFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(PropostaFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(PropostaFinderUtil.class, "_finder");
    }
}
