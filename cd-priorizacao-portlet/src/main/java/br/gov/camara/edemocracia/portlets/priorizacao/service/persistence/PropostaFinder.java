package br.gov.camara.edemocracia.portlets.priorizacao.service.persistence;

public interface PropostaFinder {
    public java.util.List<br.gov.camara.edemocracia.portlets.priorizacao.PropostaDisplay> findPropostaDisplayByUserEixo(
        long userId, long eixoId, int votosDisponiveis, boolean podeVerVotos,
        boolean podeVotar)
        throws com.liferay.portal.kernel.exception.SystemException;
}
