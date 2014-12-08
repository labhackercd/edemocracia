package br.gov.camara.edemocracia.portlets.priorizacao.service.persistence;

public interface VotoFinder {
    public int countUserIdComMaisVotosPorProposta(long groupId,
        int votosPorProposta)
        throws com.liferay.portal.kernel.exception.SystemException;

    public int countUserIdComMaisVotosTotal(long groupId, int totalVotos)
        throws com.liferay.portal.kernel.exception.SystemException;
}
