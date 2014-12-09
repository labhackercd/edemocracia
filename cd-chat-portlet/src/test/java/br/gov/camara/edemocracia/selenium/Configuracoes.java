package br.gov.camara.edemocracia.selenium;

public class Configuracoes {
	
	private static final String URL_LOCAL = "http://edemocracia-des.camara.gov.br/web/estatuto-da-juventude/bate-papo/-/bate-papo/sala/8501";
	private static final String NO_PROXY_URL_LOCAL= "edemocracia-des.camara.gov.br";
	
	public static String getURLDaSala(){
		return URL_LOCAL;
	}
	
	public static String getNoProxyURL(){
		return NO_PROXY_URL_LOCAL;
	}
	
}
