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
