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
package br.gov.camara.edemocracia.portlets.chat.portlet.beans.admin.editroom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * 
 * @author p_7339
 */
@ManagedBean(name = "roomImage")
@ViewScoped
public class ChatRoomImageBean implements Serializable {

    private static final long serialVersionUID = 1L;

	private boolean showUpdateImage;

	/**
	 * Deve mostrar o popup de arquivos?
	 * 
	 * @return
	 */
	public boolean isShowUpdateImage() {
		return showUpdateImage;
	}

	/**
	 * Mostra o popup da imagem
	 */
	public String showFilePopup() {
		showUpdateImage = true;
		return null;
	}

	/**
	 * Esconde o popup da imagem
	 */
	public String hideFilePopup() {
		showUpdateImage = false;
		return null;
	}

	/**
	 * Arquivo atual
	 */
	private File file;

	/**
	 * Content type do arquivo
	 */
	private String contentType;

	/**
	 * Log
	 */
	private static final Log _log = LogFactoryUtil.getLog(ChatRoomImageBean.class);

	/**
	 * Remove o arquivo de imagem
	 */
	@PreDestroy
	public void destroy() {
		deleteUploadedFile();
	}

	/**
	 * Exclui o arquivo que foi carregado
	 */
	public synchronized void deleteUploadedFile() {
		if (file != null)
			file.delete();
		file = null;
		contentType = null;
	}

	/**
	 * Imagem enviada
	 * 
	 * @param event
	 */
	public void imageUploaded(FileUploadEvent event) {
		File tempFile = createTempFile(event.getFile());
		if (tempFile != null) {
			if (this.file != null) {
				this.file.delete();
				this.file = tempFile;
				this.contentType = event.getFile().getContentType();
			} else {
				this.file = tempFile;
				this.contentType = event.getFile().getContentType();
			}
		} else {
			LiferayFacesContext.getInstance().addGlobalErrorMessage("Ocorreu um erro ao importar a imagem.");
		}
		showUpdateImage = false;

	}

	/**
	 * Cria um arquivo temporário a partir do arquivo submetido pelo primefaces
	 * 
	 * @param file
	 * @return
	 */
	private File createTempFile(UploadedFile file) {

		OutputStream outputStream = null;
		InputStream inputStream = null;
		File directory = null;
		File tempFile = null;
		try {
			inputStream = file.getInputstream();
			directory = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath(""));
			tempFile = File.createTempFile("chat", ".tmp", directory);
			outputStream = new FileOutputStream(tempFile);

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			return tempFile;

		} catch (IOException e) {
			_log.error("Erro ao importar imagem.", e);
			String msg = LanguageUtil.get(LiferayFacesContext.getInstance().getLocale(), "room-upload-image-error");
			LiferayFacesContext.getInstance().addGlobalErrorMessage(msg);
			tempFile.delete();
			return null;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					String msg = LanguageUtil.get(LiferayFacesContext.getInstance().getLocale(), "room-upload-image-error");
					LiferayFacesContext.getInstance().addGlobalErrorMessage(msg);
					_log.error("Erro ao fechar InputStream.", e);
					tempFile.delete();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					String msg = LanguageUtil.get(LiferayFacesContext.getInstance().getLocale(), "room-upload-image-error");
					LiferayFacesContext.getInstance().addGlobalErrorMessage(msg);
					tempFile.delete();
					_log.error("Erro ao fechar OutputStream.", e);
				}

			}
		}
	}

	/**
	 * @return the currentFile
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @return the Content Type
	 */
	public String getContentType() {
		return contentType;
	}
}
