package br.gov.camara.edemocracia.portlets.chat.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomVideo;
import br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomVideoLocalServiceBaseImpl;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomVideoUtil;

/**
 * The implementation of the chat room video local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.chat.service.ChatRoomVideoLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Ricardo Lima
 * @see br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomVideoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.chat.service.ChatRoomVideoLocalServiceUtil
 */
public class ChatRoomVideoLocalServiceImpl extends ChatRoomVideoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.gov.camara.edemocracia
	 * .portlets.chat.service.ChatRoomVideoLocalServiceUtil} to access the chat
	 * room video local service.
	 */

	/**
	 * Retorna o video cadastrado para a sala Se não encontrar o video retorna
	 * null
	 * 
	 * @param videoId
	 * @return
	 * @throws SystemException
	 */
	public ChatRoomVideo getVideo(long videoId) throws SystemException {
		return ChatRoomVideoUtil.fetchByPrimaryKey(videoId);
	}
}
