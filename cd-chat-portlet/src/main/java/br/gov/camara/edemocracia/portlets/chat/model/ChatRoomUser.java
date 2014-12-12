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
package br.gov.camara.edemocracia.portlets.chat.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the ChatRoomUser service. Represents a row in the &quot;CDChat_ChatRoomUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Ricardo Lima
 * @see ChatRoomUserModel
 * @see br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserImpl
 * @see br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserModelImpl
 * @generated
 */
public interface ChatRoomUser extends ChatRoomUserModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link br.gov.camara.edemocracia.portlets.chat.model.impl.ChatRoomUserImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public com.liferay.portal.kernel.json.JSONObject getJSON();

    /**
    * Verifica se o usuário é moderador da sala
    *
    * @return
    */
    public boolean isModerator();
}
