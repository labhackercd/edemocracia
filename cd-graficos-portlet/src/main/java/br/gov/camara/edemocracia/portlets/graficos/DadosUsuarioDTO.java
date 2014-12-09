package br.gov.camara.edemocracia.portlets.graficos;

public class DadosUsuarioDTO {

	private long userId;
	private String username;
	private String email;
	private boolean membro;	
	private int comentariosWikilegis;
	private int contribuicoesWikilegis;
	private int comentariosBlog;
	private int comentariosConteudoWeb;
	private int comentariosWiki;
	private int comentariosDocumentos;
	private int postagensForum;
	private int alteracoesWiki;
	
	public DadosUsuarioDTO() {
	}
	
	public DadosUsuarioDTO(long userId, String username, String email) {
		this.userId = userId;
		this.username = username;
		this.email = email;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isMembro() {
		return membro;
	}

	public void setMembro(boolean membro) {
		this.membro = membro;
	}

	public int getComentariosWikilegis() {
		return comentariosWikilegis;
	}

	public void setComentariosWikilegis(int comentariosWikilegis) {
		this.comentariosWikilegis = comentariosWikilegis;
	}

	public int getContribuicoesWikilegis() {
		return contribuicoesWikilegis;
	}

	public void setContribuicoesWikilegis(int contribuicoesWikilegis) {
		this.contribuicoesWikilegis = contribuicoesWikilegis;
	}

	public int getComentariosBlog() {
		return comentariosBlog;
	}

	public void setComentariosBlog(int comentariosBlog) {
		this.comentariosBlog = comentariosBlog;
	}

	public int getComentariosConteudoWeb() {
		return comentariosConteudoWeb;
	}

	public void setComentariosConteudoWeb(int comentariosConteudoWeb) {
		this.comentariosConteudoWeb = comentariosConteudoWeb;
	}

	public int getComentariosWiki() {
		return comentariosWiki;
	}

	public void setComentariosWiki(int comentariosWiki) {
		this.comentariosWiki = comentariosWiki;
	}

	public int getComentariosDocumentos() {
		return comentariosDocumentos;
	}

	public void setComentariosDocumentos(int comentariosDocumentos) {
		this.comentariosDocumentos = comentariosDocumentos;
	}

	public int getPostagensForum() {
		return postagensForum;
	}

	public void setPostagensForum(int postagensForum) {
		this.postagensForum = postagensForum;
	}

	public int getAlteracoesWiki() {
		return alteracoesWiki;
	}

	public void setAlteracoesWiki(int alteracoesWiki) {
		this.alteracoesWiki = alteracoesWiki;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}