/**
 * 
 */
package br.gov.camara.edemocracia.portlets.chat.portlet.beans.admin.usuarios;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.context.FacesContext;

import org.apache.commons.io.input.CharSequenceInputStream;

import br.gov.camara.edemocracia.portlets.chat.ChatRoomUserBean;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.portlet.ChatResourceHandler;
import br.gov.camara.edemocracia.portlets.chat.portlet.exporter.CSVChatRoomUsersExporter;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author rpdmiranda
 * 
 */
public class UsuariosResource extends Resource {

	/**
	 * Identificador da Sala
	 */
	private final ChatRoom sala;

	/**
	 * URL para o recurso
	 */
	private String requestPath;

	public UsuariosResource(ChatRoom sala) {
		this.sala = sala;
		setLibraryName(ChatResourceHandler.LIBRARY_NAME);
		setResourceName(ChatResourceHandler.USUARIOS_RESOURCE_PREFIX + sala.getRoomId());
		setContentType("text/csv");
	}

	/**
	 * @see javax.faces.application.Resource#getInputStream()
	 */
	@Override
	public InputStream getInputStream() throws IOException {

		List<ChatRoomUserBean> listUsers;
		try {
			listUsers = ChatRoomServiceUtil.findAllChatRoomParticipants(sala.getRoomId());
		} catch (PortalException e) {
			throw new IOException(e);
		} catch (SystemException e) {
			throw new IOException(e);
		}

		String csv = CSVChatRoomUsersExporter.export(listUsers);
		return new CharSequenceInputStream(csv, "UTF-8");
	}

	/**
	 * @see javax.faces.application.Resource#getResponseHeaders()
	 */
	@Override
	public Map<String, String> getResponseHeaders() {
		HashMap<String, String> retorno = new HashMap<String, String>();
		retorno.put("Content-Disposition", "attachment;filename=\"export-" + sala.getNameAsFilename() + "-users.csv\"");
		return retorno;
	}

	/**
	 * @see javax.faces.application.Resource#getRequestPath()
	 */
	@Override
	public String getRequestPath() {
		if (requestPath == null) {
			StringBuilder buf = new StringBuilder();
			buf.append(ResourceHandler.RESOURCE_IDENTIFIER);
			buf.append("/");
			buf.append(getResourceName());
			buf.append("?ln=");
			buf.append(getLibraryName());
			requestPath = buf.toString();
			requestPath = FacesContext.getCurrentInstance().getExternalContext().encodeResourceURL(requestPath);
		}

		return requestPath;
	}

	/**
	 * @see javax.faces.application.Resource#getURL()
	 */
	@Override
	public URL getURL() {
		return null;
	}

	/**
	 * @see javax.faces.application.Resource#userAgentNeedsUpdate(javax.faces.context.FacesContext)
	 */
	@Override
	public boolean userAgentNeedsUpdate(FacesContext context) {
		return true;
	}
}
