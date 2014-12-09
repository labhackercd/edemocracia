package br.gov.camara.edemocracia.portlets.dashboard.cache.util;

import java.util.List;

import org.joda.time.DateTime;

import br.gov.camara.edemocracia.portlets.dashboard.dto.RecursoDTO;

import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class DashboardCacheUtil {

	private static final Log LOG = LogFactoryUtil.getLog(DashboardCacheUtil.class);
	private static int CACHE_EXPERIATION_TIME = 10*60; /* 10 min */

	private DashboardCacheUtil(){
	}

	public static CacheRecursosDTO getCacheRecurso(CacheKey cacheKey, String portletInstanceId){
		CacheRecursosDTO cache = getCache(cacheKey, portletInstanceId); 
		return validarDataDoCache(cache);
	}

	public static void setCacheRecurso(CacheKey cacheKey,String portletInstanceId, List<RecursoDTO> recursos) {
		setCache(cacheKey, portletInstanceId, recursos);
	}
	
	/**
	 * Busca o cache desta instância do portlet
	 * 
	 * Se não encontrar retorna null
	 * 
	 * @param portletInstanceId
	 * @return
	 */
	private static CacheRecursosDTO getCache(CacheKey cacheKey, String portletInstanceId){
		
		PortalCache cache = getOrCreateCache(cacheKey, portletInstanceId) ;
		
		if (cache != null) {
			CacheRecursosDTO value = null;
			
			try {
				value = (CacheRecursosDTO) cache.get(portletInstanceId);
			} catch  (ClassCastException e) {
				value = null;
				LOG.debug(e.getLocalizedMessage());
			} catch  (Exception e) {
				LOG.error(e.getLocalizedMessage());
			}
			if(value == null){
				LOG.debug("Não existe cache de recursos");
			}
			return value;
			
		} else {
			LOG.debug("Não existe PortalCache");
			return null;
		}
	}
	
	private static void setCache(CacheKey cacheKey ,String portletInstanceId, List<RecursoDTO> recursos){
		CacheRecursosDTO cacheTopicos = new CacheRecursosDTO(new DateTime(), recursos);

		PortalCache cache = limparCache(cacheKey ,portletInstanceId);
		cache.put(portletInstanceId, cacheTopicos, CACHE_EXPERIATION_TIME);
		LOG.debug("salvando novo cache");
	}
	

	/**
	 * Valida se o cache é do mesmo dia 
	 * 
	 * Se o cache não for válido retorna null
	 * 
	 * @param portletInstanceId
	 * @return
	 */
	private static CacheRecursosDTO validarDataDoCache (CacheRecursosDTO cache) {
		
		if (cache != null) {
			DateTime dataCache = cache.getDataCache();
			boolean cacheDoMesmoDia = dataCache.withTime(0, 0, 0, 0).isEqual(new DateTime().withTime(0, 0, 0, 0));
			
			if (cacheDoMesmoDia) {
				LOG.debug("existe cache");
				return cache;
			} else {
				LOG.debug("existia mas não do mesmo dia");
				return null;
			}

		} else {
			LOG.debug("cache vazio");
			return null;
		}
	}

	public static PortalCache limparCache (CacheKey cacheKey, String portletInstanceId) {
		LOG.debug("limpando cache");
		PortalCache cache = getOrCreateCache(cacheKey,portletInstanceId); 
		Object obj = cache.get(portletInstanceId);
			
		if (obj != null) {
			cache.removeAll();
		}
			
		return cache;
	}
	
	public static void limparTodos (String portletInstanceId) {
		for(CacheKey cacheKey : CacheKey.values()){
			limparCache(cacheKey, portletInstanceId);
		}
	}

	private static PortalCache getOrCreateCache(CacheKey cacheKey, String portletInstanceId) {
		MultiVMPool multiVMPool = MultiVMPoolUtil.getMultiVMPool();
		return multiVMPool.getCache(cacheKey.getKey() + portletInstanceId, false);
	}
	
}
