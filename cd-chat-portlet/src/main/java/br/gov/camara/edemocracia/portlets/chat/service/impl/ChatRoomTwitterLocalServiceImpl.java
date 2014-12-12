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
package br.gov.camara.edemocracia.portlets.chat.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomTwitter;
import br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomTwitterLocalServiceBaseImpl;
import br.gov.camara.edemocracia.portlets.chat.service.persistence.ChatRoomTwitterUtil;

/**
 * The implementation of the chat room twitter local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.portlets.chat.service.ChatRoomTwitterLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Ricardo Lima
 * @see br.gov.camara.edemocracia.portlets.chat.service.base.ChatRoomTwitterLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.chat.service.ChatRoomTwitterLocalServiceUtil
 */
public class ChatRoomTwitterLocalServiceImpl extends ChatRoomTwitterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * br.gov.camara.edemocracia
	 * .portlets.chat.service.ChatRoomTwitterLocalServiceUtil} to access the
	 * chat room twitter local service.
	 */

	/**
	 * Retorna o twitter cadastrado para a sala Caso não encontre, retorna null
	 */
	public ChatRoomTwitter getTwitter(long twitterId) throws SystemException {
		return ChatRoomTwitterUtil.fetchByPrimaryKey(twitterId);
	}
}
