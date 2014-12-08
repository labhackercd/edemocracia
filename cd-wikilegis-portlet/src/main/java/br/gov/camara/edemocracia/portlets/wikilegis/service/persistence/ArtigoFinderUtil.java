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
