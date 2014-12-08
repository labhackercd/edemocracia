package br.gov.camara.edemocracia.portlets.wikilegis.service.persistence;

public interface ArtigoFinder {
    public java.util.Map<java.lang.Long, java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay>> findAllArtigoDisplay(
        long groupId);

    public java.util.List<br.gov.camara.edemocracia.portlets.wikilegis.ArtigoDisplay> findDisplayByG_E(
        long groupId, long estruturaId);
}
