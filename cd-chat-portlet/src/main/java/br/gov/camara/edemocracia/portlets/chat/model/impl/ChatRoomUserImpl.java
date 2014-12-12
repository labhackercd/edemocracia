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
package br.gov.camara.edemocracia.portlets.chat.model.impl;

import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;
import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * The model implementation for the ChatRoomUser service. Represents a row in
 * the &quot;CDChat_ChatRoomUser&quot; database table, with each column mapped
 * to a property of this class.
 * 
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this class directly. All methods that expect a chat room user
 * model instance should use the {@link ChatRoomUser} interface instead.
 * </p>
 */
public class ChatRoomUserImpl extends ChatRoomUserBaseImpl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChatRoomUserImpl() {
	}

	public JSONObject getJSON() {

		JSONObject result = JSONFactoryUtil.createJSONObject();

		result.put("id", getChatUserId());
		result.put("name", escapeHtml(getUserName()));
		result.put("imgid", getUserImgId());
		result.put("type", getUserType());
		result.put("audience", false);
		result.put("banned", getBanned());

		return result;
	}

	/**
	 * Verifica se o usuário é moderador da sala
	 * 
	 * @return
	 */
	public boolean isModerator() {
		return getUserType() == UserType.Moderator.getValue() || getUserType() == UserType.SpecialGuest.getValue();
	}
}
