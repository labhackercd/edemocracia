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
package br.gov.camara.edemocracia.portlets.comunidades.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.RepositoryException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.documentlibrary.util.ImageProcessorUtil;

public class CommunityIconFinder {

	private CommunityIconFinder() {
	}

	public static String findUrl(ThemeDisplay td, long groupId) throws SystemException {
		String result = "/html/icons/enterprise_admin_communities.png";
		
		try {
			FileEntry entry = DLAppLocalServiceUtil.getFileEntry(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "icone");
			FileVersion version = entry.getFileVersion();
			if (version != null) {
				if (ImageProcessorUtil.hasImages(version)) {
					result = DLUtil.getPreviewURL(entry, version, td, "&imageThumbnail=1");
				}
			}
		} catch (RepositoryException e) {
			// Ignore
		} catch (PortalException e) {
			// Ignore
		}
		return result;
	}
}
