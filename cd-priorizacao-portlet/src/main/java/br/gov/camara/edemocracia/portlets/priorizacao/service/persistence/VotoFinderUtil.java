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


public class VotoFinderUtil {
    private static VotoFinder _finder;

    public static int countUserIdComMaisVotosPorProposta(long groupId,
        int votosPorProposta)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .countUserIdComMaisVotosPorProposta(groupId, votosPorProposta);
    }

    public static int countUserIdComMaisVotosTotal(long groupId, int totalVotos)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().countUserIdComMaisVotosTotal(groupId, totalVotos);
    }

    public static VotoFinder getFinder() {
        if (_finder == null) {
            _finder = (VotoFinder) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.priorizacao.service.ClpSerializer.getServletContextName(),
                    VotoFinder.class.getName());

            ReferenceRegistry.registerReference(VotoFinderUtil.class, "_finder");
        }

        return _finder;
    }

    public void setFinder(VotoFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(VotoFinderUtil.class, "_finder");
    }
}
