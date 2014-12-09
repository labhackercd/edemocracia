package br.gov.camara.edemocracia.portlets.guiadiscussao.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.camara.edemocracia.portlets.guiadiscussao.beans.admin.FileEntryDisplay;
import br.gov.camara.edemocracia.portlets.guiadiscussao.util.BibliotecaImagensUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.lang.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

@FacesConverter(value = "imagemConverter")
public class ImagemConverter implements Converter {

	private static final Log LOG = LogFactoryUtil.getLog(ImagemConverter.class);

	@Override
	public Object getAsObject(FacesContext facesContext,
			UIComponent uiComponent, String string) {
		long fileEntryId = Long.parseLong(string);
		FileEntryDisplay fileEntryDisplay = null;

		try {
			if (fileEntryId != 0) {
				FileEntry fileEntry = DLAppServiceUtil
						.getFileEntry(fileEntryId);
				String urlImagem = DLUtil.getPreviewURL(fileEntry, fileEntry
						.getFileVersion(), LiferayFacesContext.getInstance()
						.getThemeDisplay(), StringPool.BLANK, false, true);
				fileEntryDisplay = new FileEntryDisplay(
						fileEntry.getFileEntryId(), fileEntry.getTitle(),
						urlImagem);
			} else {
				fileEntryDisplay = BibliotecaImagensUtil.getImagemPadrao();
			}

		} catch (SystemException e) {
			LOG.error("Erro ao construir filedisplay na conversão.", e);
		} catch (PortalException e) {
			fileEntryDisplay = BibliotecaImagensUtil.getImagemPadrao();
		}
		return fileEntryDisplay;
	}

	@Override
	public String getAsString(FacesContext facesContext,
			UIComponent uiComponent, Object object) {
		return object.toString();
	}

}
