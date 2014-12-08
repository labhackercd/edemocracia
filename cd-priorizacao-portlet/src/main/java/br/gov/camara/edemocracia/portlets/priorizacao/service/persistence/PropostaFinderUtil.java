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
