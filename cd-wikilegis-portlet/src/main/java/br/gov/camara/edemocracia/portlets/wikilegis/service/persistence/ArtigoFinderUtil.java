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
package br.gov.camara.edemocracia.portlets.wikilegis.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class ArtigoFinderUtil {
    private static ArtigoFinder _finder;

    public static java.util.Map<java.lang.Long, java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay>> findAllArtigoDisplay(
        long groupId) {
        return getFinder().findAllArtigoDisplay(groupId);
    }

    public static java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay> findDisplayByG_E(
        long groupId, long estruturaId) {
        return getFinder().findDisplayByG_E(groupId, estruturaId);
    }

    public static ArtigoFinder getFinder() {
        if (_finder == null) {
            _finder = (ArtigoFinder) PortletBeanLocatorUtil.locate(br.gov.camara.edemocracia.portlets.wikilegis.service.ClpSerializer.getServletContextName(),
                    ArtigoFinder.class.getName());

            ReferenceRegistry.registerReference(ArtigoFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(ArtigoFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(ArtigoFinderUtil.class, "_finder");
    }
}
