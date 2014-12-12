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
package br.gov.camara.edemocracia.portlets.guiadiscussao.util;

import org.apache.commons.lang3.StringUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public final class URLUtil {
	
	private URLUtil(){
		
	}
	
	/**
	 * Este método faz a construção dos links cadastrados no guia
	 * 
	 * @param url
	 * @param urlExterna
	 * @return
	 */
	public static String construirURL(String url, boolean urlExterna){
		
		if(StringUtils.isBlank(url))
			return "#";

		LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();
		if (urlExterna) {
			if (!url.startsWith("http://") && !url.startsWith("https://")) {
				if (!url.startsWith("/"))
					url = "/" + url;
				return liferayFacesContext.getPortalURL() + url;
			} else {
				return url;
			}
		} else {
			try {
				Layout layout = null;
				try {
					long plid = Long.parseLong(url);
					layout = LayoutLocalServiceUtil.getLayout(plid);
					if (layout.getGroupId() != liferayFacesContext
							.getHostGroupId())
						layout = null;
				} catch (NumberFormatException e) {
					// Ignore
				}
				if (layout == null)
					return "#";
				return PortalUtil.getLayoutFullURL(layout,
						liferayFacesContext.getThemeDisplay());
			} catch (PortalException e) {
				return "#";
			} catch (SystemException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
}
