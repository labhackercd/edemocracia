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
