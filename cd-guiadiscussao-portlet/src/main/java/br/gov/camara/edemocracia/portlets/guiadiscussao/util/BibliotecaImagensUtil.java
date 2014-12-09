package br.gov.camara.edemocracia.portlets.guiadiscussao.util;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;

import br.gov.camara.edemocracia.portlets.guiadiscussao.beans.admin.FileEntryDisplay;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.lang.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.shopping.util.comparator.OrderDateComparator;

public final class BibliotecaImagensUtil {

	private static final Log LOG = LogFactoryUtil
			.getLog(BibliotecaImagensUtil.class);
	
	private BibliotecaImagensUtil() {
	}

	/**
	 * Carrega todas as imagens que estão cadastradas na biblioteca de
	 * documentos da comunidade
	 */
	public static List<FileEntryDisplay> getTodasImagensDaBiblioteca(
			long groupId) {

		List<FileEntryDisplay> retorno = new ArrayList<FileEntryDisplay>();
		retorno.add(getImagemPadraoBanner());

		try {
			
			List<DLFileEntry> dlFileEntries = DLFileEntryLocalServiceUtil
					.getGroupFileEntries(groupId, QueryUtil.ALL_POS,
							QueryUtil.ALL_POS);

			retorno.addAll(filtrarImagens(dlFileEntries));			
			

		} catch (SystemException e) {
			LOG.error("Erro ao carregar imagens.", e);
		} catch (PortalException e) {
			LOG.error("Erro ao carregar imagens.", e);
		}

		return retorno;
	}

	public static String getUrlImagem(long fileEntryId) {
		if (fileEntryId == 0) {
			return getUrlImagemPadrao();
		} else {
			try {
				FileEntry fileEntry = DLAppServiceUtil
						.getFileEntry(fileEntryId);
				return getUrlImagem(fileEntry);
			} catch (PortalException e) {
				return "";
			} catch (SystemException e) {
				LOG.error("Ocorreu um erro ao recuperar imagem " + fileEntryId, e);
				return getUrlImagemPadrao();
			}
		}
	}

	public static String getUrlImagem(FileEntry fileEntry)
			throws PortalException, SystemException {
		return DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(),
				LiferayFacesContext.getInstance().getThemeDisplay(),
				StringPool.BLANK, false, true);
	}

	/**
	 * Retorna uma instancia de FileEntryDisplay
	 * 
	 * @param fileEntryId
	 * @return
	 * @throws PortalException
	 *             se a imagem não for encontrada
	 */
	public static FileEntryDisplay getFileEntryDisplay(long fileEntryId)
			throws PortalException {
		FileEntryDisplay fileEntryDisplay = null;
		try {
			FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
			fileEntryDisplay = new FileEntryDisplay(fileEntry.getFileEntryId(),
					fileEntry.getTitle(), getUrlImagem(fileEntry));
		} catch (SystemException e) {
			LOG.error("Erro ao construir url para imagem.", e);
			throw new RuntimeException(e);
		}

		return fileEntryDisplay;
	}

	/**
	 * Carrega todos os icones que estão na biblioteca de documentos global na
	 * pasta: /icones/guia
	 * 
	 * @throws PortalException
	 */
	public static List<FileEntryDisplay> getTodosIconesAcoes() {

		long companyGroupId = LiferayFacesContext.getInstance()
				.getThemeDisplay().getCompanyGroupId();

		List<FileEntryDisplay> retorno = new ArrayList<FileEntryDisplay>();
		retorno.add(getImagemPadrao());

		try {

			DLFolder pastaIcones = DLFolderLocalServiceUtil.getFolder(
					companyGroupId, 0l, "icones");
			DLFolder pastaGuia = DLFolderLocalServiceUtil.getFolder(
					companyGroupId, pastaIcones.getFolderId(), "guia");

			OrderDateComparator orderByDate = new OrderDateComparator();

			List<DLFileEntry> dlFileEntries = DLFileEntryLocalServiceUtil
					.getFileEntries(companyGroupId, pastaGuia.getFolderId(),
							QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByDate);

			retorno.addAll(filtrarImagens(dlFileEntries));

		} catch (SystemException e) {
			LOG.error("Erro ao carregar icones.", e);
		} catch (PortalException e) {
			// Ignore: Esse erro ocorre quando não há pasta
		}

		return retorno;
	}
	
	/**
	 * Retorna uma lista de FileEntryDisplay contendo somente as imagens
	 * 
	 * @param dlFileEntries
	 * @return
	 * @throws PortalException
	 */
	private static List<FileEntryDisplay> filtrarImagens(List<DLFileEntry> dlFileEntries) throws PortalException {
		
		List<FileEntryDisplay> retorno = new ArrayList<FileEntryDisplay>();
		
		for (DLFileEntry file : dlFileEntries) {
			if (file.getMimeType().startsWith("image/") ) {
					retorno.add(getFileEntryDisplay(file.getFileEntryId()));
			}
		}
		
		return retorno;
	}
	/**
	 * Retorna url para imagem padrão das ações
	 */
	public static String getUrlImagemPadrao() {
		return getURLImagemResource("padrao.jpg");
	}

	/**
	 * Retorna imagem padrão para ações
	 * @return
	 */
	public static FileEntryDisplay getImagemPadrao() {
		return new FileEntryDisplay(0, "Imagem Padrão", getUrlImagemPadrao());
	}
	
	/**
	 * Retorna url para imagem padrão do banner 
	 * @return
	 */
	public static String getUrlImagemPadraoBanner() {
		return getURLImagemResource("padrao-banner.jpg");
	}

	/**
	 * Retorna imagem padrão para banner 
	 * @return
	 */
	public static FileEntryDisplay getImagemPadraoBanner() {
		return new FileEntryDisplay(0, "Imagem Padrão", getUrlImagemPadraoBanner());
	}
	
	/**
	 * Retorna a url da imagem localizada na pasta imagem dentro de resources
	 * @param nomeDaImagem
	 * @return
	 */
	private static String getURLImagemResource(String nomeDaImagem){
		ResourceHandler rs = LiferayFacesContext.getInstance().getApplication()
				.getResourceHandler();
		Resource resource = rs.createResource(nomeDaImagem, "images");
		return resource.getRequestPath();
	}

}
