package br.gov.camara.edemocracia.portlets.dashboard.cache.util;

public enum CacheKey {
	
	TOPICO("cacheTopicosComMaiorParticipacao"), 
	WIKIS("cacheWikisComMaiorParticipacao"), 
	BLOGS("cacheBlogsComMaiorParticipacao"),
	COMENTARIOS_WIKILEGIS("cacheArtigosWikilegisComMaiorParticipacao"),
	SUGESTOES_WIKILEGIS("cacheArtigosWikilegisComMaisSugestoes"),
	BATEPAPO_MENSAGENS("cacheBatePapoComMaisMensagens"),
	BATEPAPO_USUARIOS("cacheBatePapoComMaisUsuarios"),
	PAGINAS_COMUNIDADES("cachePaginasComunidades"),
	DOCUMENTOS_COMUNIDADES("cacheDocumentosComunidades"),
	CONTEUDOS_WEB_COMUNIDADES("cacheConteudosWebComunidades");
	
	private String key;
	
	private CacheKey(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
}
