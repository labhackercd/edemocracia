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
package br.gov.camara.edemocracia.util;



import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

public class LinkSalasCacheUtil {

	private static final Log LOG = LogFactoryUtil.getLog(LinkSalasCacheUtil.class);
	private static String CACHE_NAME = "cacheLinkSalas";
	private static String CACHE_NAME_ENTRAR = CACHE_NAME + "entrar";
	private static String CACHE_NAME_ESPIAR = CACHE_NAME + "espiar";
	private static String CACHE_NAME_VER_HISTORICO = CACHE_NAME + "historico";
	private static int CACHE_EXPERIATION_TIME = 60*60;

	private static PortalCache cacheLinkEntrar;
	private static PortalCache cacheLinkEspiar;
	private static PortalCache cacheLinkVerHistorico;
	
	private LinkSalasCacheUtil(){
		
	}

	static {
		MultiVMPool multiVMPool = MultiVMPoolUtil.getMultiVMPool();
		cacheLinkEntrar = multiVMPool.getCache(CACHE_NAME_ENTRAR, false);
		cacheLinkEspiar = multiVMPool.getCache(CACHE_NAME_ESPIAR, false);
		cacheLinkVerHistorico = multiVMPool.getCache(CACHE_NAME_VER_HISTORICO, false);
	}

	public static String getLinkEntrar(Long roomId) {
		String value = null;
		try {
			value = (String) cacheLinkEntrar.get(roomId);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
		}
		if(value == null){
			value = StringPool.BLANK;
		}
		return value;
	}

	public static String getLinkEspiar(Long roomId) {
		String value = null;
		try {
			value = (String) cacheLinkEspiar.get(roomId);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
		}
		if(value == null){
			value = StringPool.BLANK;
		}
		return value;
	}

	public static String getLinkVerHistorico(Long roomId) {
		String value = null;
		try {
			value = (String) cacheLinkVerHistorico.get(roomId);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
		}
		if(value == null){
			value = StringPool.BLANK;
		}
		return value;
	}

	public static void setLinkEntrar(Long roomId, String url) {
		try {
			String valueFromCache = getLinkEntrar(roomId);
			if (valueFromCache.equals(StringPool.BLANK)) {
				cacheLinkEntrar.put(roomId, url, CACHE_EXPERIATION_TIME);
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
		}
	}

	public static void setLinkEspiar(Long roomId, String url) {
		try {
			String valueFromCache = getLinkEspiar(roomId);
			if (valueFromCache.equals(StringPool.BLANK)) {
				cacheLinkEspiar.put(roomId, url, CACHE_EXPERIATION_TIME);
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
		}
	}

	public static void setLinkVerHistorico(Long roomId, String url) {
		try {
			String valueFromCache = getLinkVerHistorico(roomId);
			if (valueFromCache.equals(StringPool.BLANK)) {
				cacheLinkVerHistorico.put(roomId, url, CACHE_EXPERIATION_TIME);
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
		}
	}
	
	public static void limparCaches() {
		cacheLinkEntrar.removeAll();
		cacheLinkEspiar.removeAll();
		cacheLinkVerHistorico.removeAll();
	}
	
}
