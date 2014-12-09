package br.gov.camara.edemocracia.util;

import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * Utilitários para reescrever URLs
 * 
 * @author P_7339
 *
 */
public final class UrlRewriterUtil {
	
	/**
	 * Converte a URL para HTTP
	 * 
	 * @param url
	 * @return
	 */
	public static final String convertToHttp(String url) {
		if (!url.startsWith("https://"))
			return url;
		
		url = "http://" + url.substring(8);
		int slashPos = url.indexOf('/', 8);
		if (slashPos == -1)
			slashPos = url.length();
		int dotPos = url.indexOf(':', 8);
		
		// Retira a porta
		if (dotPos != -1 && dotPos < slashPos) {
			url = url.substring(0, dotPos) + url.substring(slashPos);
			slashPos = url.indexOf('/', 8);
			if (slashPos == -1)
				slashPos = url.length();
		}
		
		String portString = PropsUtil.get(PropsKeys.WEB_SERVER_HTTP_PORT);
		int port = Http.HTTP_PORT;
		if (portString != null) {
			try {
				port = Integer.parseInt(portString);
			} catch (NumberFormatException e) {
				port = Http.HTTP_PORT;
			}
		}
		if (port == -1 || port == 80)
			return url;
		
		// Acrescenta a porta
		url = url.substring(0, slashPos) + ":" + port + url.substring(slashPos);
		return url;
	}
}
