/**
 * 
 */
package br.gov.camara.edemocracia.portlets.chat.portlet;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoom;
import br.gov.camara.edemocracia.portlets.chat.portlet.beans.admin.usuarios.UsuariosResource;
import br.gov.camara.edemocracia.portlets.chat.service.ChatRoomServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author p_7339
 * 
 */
public class ChatResourceHandler extends ResourceHandlerWrapper {

	private final ResourceHandler wrapped;

	public static final String LIBRARY_NAME = "chat";

	public static final String USUARIOS_RESOURCE_PREFIX = "usr_";

	public ChatResourceHandler(ResourceHandler wrapped) {
		this.wrapped = wrapped;
	}

	/**
	 * @see javax.faces.application.ResourceHandlerWrapper#getWrapped()
	 */
	@Override
	public ResourceHandler getWrapped() {
		return wrapped;
	}

	/**
	 * @see javax.faces.application.ResourceHandlerWrapper#createResource(java.lang.String)
	 */
	@Override
	public Resource createResource(String resourceName) {
		return createResource(resourceName, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.application.ResourceHandlerWrapper#createResource(java.lang
	 * .String, java.lang.String, java.lang.String)
	 */
	@Override
	public Resource createResource(String resourceName, String libraryName, String contentType) {
		return createResource(resourceName, libraryName);
	}

	/**
	 * @see javax.faces.application.ResourceHandlerWrapper#createResource(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public Resource createResource(String resourceName, String libraryName) {
		if (!LIBRARY_NAME.equals(libraryName))
			return super.createResource(resourceName, libraryName);

		if (resourceName == null || !resourceName.startsWith(USUARIOS_RESOURCE_PREFIX))
			return super.createResource(resourceName, libraryName);

		// Cria o recurso para retornar os usuários da sala especificada
		try {
			long salaId = Long.parseLong(resourceName.substring(USUARIOS_RESOURCE_PREFIX.length()));

			if (true/* TODO: ChatRoomServiceUtil.canListUsers(salaId) */) {
				try {
					ChatRoom sala = ChatRoomServiceUtil.getRoom(salaId);
					return new UsuariosResource(sala);
				} catch (PortalException e) {
					return super.createResource(resourceName, libraryName);
				} catch (SystemException e) {
					throw new RuntimeException(e);
				}
			} else {
				return super.createResource(resourceName, libraryName);
			}
		} catch (NumberFormatException e) {
			return super.createResource(resourceName, libraryName);
		}
	}

	/**
	 * @see javax.faces.application.ResourceHandlerWrapper#libraryExists(java.lang.String)
	 */
	@Override
	public boolean libraryExists(String libraryName) {
		if (LIBRARY_NAME.equals(libraryName))
			return true;
		else
			return super.libraryExists(libraryName);
	}
}
