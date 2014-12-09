package br.gov.camara.edemocracia.portlets.chat.service;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import br.gov.camara.edemocracia.portlets.chat.model.ChatRoomUser;

/**
 * Representa uma chave para os usuários de uma sala de bate-papo. Para usuários
 * espiões, guarda um {@link UUID}, para usuários não espiões, guarda um {@link Long},
 * que é o id salvo no banco e corresponde a {@link ChatRoomUser#getChatUserId()} 
 * @author p_882148
 */
public final class UserActivityId implements Serializable {
    private static final long serialVersionUID = 1L;
   
	private final UUID spyUserId;
	private final Long chatUserId;
	
	public static UserActivityId forPersistentUser(long chatUserId) {
		return new UserActivityId(chatUserId);
	}
	
	public static UserActivityId forNewSpyUser() {
		return new UserActivityId(UUID.randomUUID());
	}
	
	private UserActivityId(long chatRoomUserId) {
		this.chatUserId = chatRoomUserId;
		this.spyUserId = null;
	}
	
	private UserActivityId(UUID spyUserId) {
		if (spyUserId == null) {
			throw new IllegalArgumentException("spyUserId não pode ser null");
		}
		this.spyUserId = spyUserId;
		this.chatUserId = null;
	}
	
	public String getAsString() {
		if(spyUserId == null) {
			return chatUserId.toString();
		}else {
			return spyUserId.toString();
		}
	}
	
	public static UserActivityId fromString(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}
		try {
			Long chatUserId = Long.parseLong(id);
			return new UserActivityId(chatUserId);
        } catch (NumberFormatException e) {
        	return new UserActivityId(UUID.fromString(id));
        }
	}
	
	public boolean isSpyUser() {
		return spyUserId != null;
	}
	
	public boolean isPersistentUser() {
		return chatUserId != null;
	}
	
	public UUID getSpyUserId() {
	    return spyUserId;
    }
	
	public Long getChatUserId() {
	    return chatUserId;
    }

	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((chatUserId == null) ? 0 : chatUserId.hashCode());
	    result = prime * result + ((spyUserId == null) ? 0 : spyUserId.hashCode());
	    return result;
    }

	@Override
    public boolean equals(Object obj) {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (getClass() != obj.getClass())
		    return false;
	    UserActivityId other = (UserActivityId) obj;
	    if (chatUserId == null) {
		    if (other.chatUserId != null)
			    return false;
	    } else if (!chatUserId.equals(other.chatUserId))
		    return false;
	    if (spyUserId == null) {
		    if (other.spyUserId != null)
			    return false;
	    } else if (!spyUserId.equals(other.spyUserId))
		    return false;
	    return true;
    }

	@Override
    public String toString() {
	    return getAsString();
    }
}
