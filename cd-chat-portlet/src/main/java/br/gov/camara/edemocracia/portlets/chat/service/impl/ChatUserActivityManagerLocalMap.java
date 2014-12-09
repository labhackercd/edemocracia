package br.gov.camara.edemocracia.portlets.chat.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import br.gov.camara.edemocracia.portlets.chat.service.ChatUserActivityManager;
import br.gov.camara.edemocracia.portlets.chat.service.UserActivityId;

public class ChatUserActivityManagerLocalMap implements ChatUserActivityManager {

	private ConcurrentMap<Long, ConcurrentMap<UserActivityId, Date>> chatRoomsUserActivityMap = new ConcurrentHashMap<Long, ConcurrentMap<UserActivityId, Date>>();

	private static final Log LOG = LogFactoryUtil.getLog(ChatUserActivityManagerLocalMap.class);
	
	@Override
	public Collection<UserActivityId> removeInactiveUsers() {
		Collection<UserActivityId> inactiveUsers = new ArrayList<UserActivityId>();
		Date tenMinutesAgo = getTenMinutesAgo();

		Collection<ConcurrentMap<UserActivityId, Date>> allUsersActivities = chatRoomsUserActivityMap.values();
		if (allUsersActivities == null) {
			return Collections.emptyList();
		}

		for (Map<UserActivityId, Date> roomActivities : allUsersActivities) {

			for (Iterator<Map.Entry<UserActivityId, Date>> iterator = roomActivities.entrySet().iterator(); iterator.hasNext();) {
				Map.Entry<UserActivityId, Date> userActivity = iterator.next();
				Date lastActivity = userActivity.getValue();
				if (lastActivity.before(tenMinutesAgo) || lastActivity.equals(tenMinutesAgo)) {
					inactiveUsers.add(userActivity.getKey());
					iterator.remove();
				}
			}
		}

		return inactiveUsers;
	}

	@Override
	public void addUser(Long roomId, UserActivityId userId) {
		if (roomId == null || userId == null) {
			throw new IllegalArgumentException("roomId, userId e timestamp devem ser informados");
		}

		LOG.debug("Incluindo usuário " + userId + "na sala " + roomId);
		
		Map<UserActivityId, Date> roomActivities = getOrCreateRoomActivities(roomId);
		roomActivities.put(userId, new Date());
	}

	@Override
	public void updateUserLastActivity(Long roomId, UserActivityId idUser) {
		updateUserLastActivity(roomId, idUser, new Date());
	}

	void updateUserLastActivity(Long roomId, UserActivityId idUser, Date timestamp) {
		if (roomId == null || idUser == null || timestamp == null) {
			throw new IllegalArgumentException("roomId, idUser e timestamp devem ser informados");
		}

		ConcurrentMap<UserActivityId, Date> roomActivities = getOrCreateRoomActivities(roomId);
		roomActivities.replace(idUser, timestamp);
		LOG.debug("Atualizado " + roomActivities);
	}

	@Override
	public Date getLastActivityOfUser(Long roomId, UserActivityId idUser) {
		Map<UserActivityId, Date> roomActivities = getOrCreateRoomActivities(roomId);

		return roomActivities.get(idUser);
	}

	@Override
	public void removeUser(Long roomId, UserActivityId idUser) {
		if (roomId == null || idUser == null) {
			throw new IllegalArgumentException("roomId e idUser devem ser informados");
		}
		Map<UserActivityId, Date> roomActivities = getOrCreateRoomActivities(roomId);
		LOG.debug("Antes de remover: " + roomActivities.toString());

		roomActivities.remove(idUser);
		LOG.debug("Removeu usuário " + idUser + " da sala " + roomId);

		LOG.debug("Depois de remover: " + roomActivities.toString());
	}

	private ConcurrentMap<UserActivityId, Date> getOrCreateRoomActivities(Long roomId) {
		ConcurrentMap<UserActivityId, Date> mapaExistente = chatRoomsUserActivityMap.get(roomId); 
		if (mapaExistente == null) {
			ConcurrentMap<UserActivityId, Date> novoMapaAtividades = new ConcurrentHashMap<UserActivityId, Date>();
			mapaExistente = chatRoomsUserActivityMap.putIfAbsent(roomId, novoMapaAtividades);
			if (mapaExistente == null)
				return novoMapaAtividades;
			else
				return mapaExistente;
		}
		return mapaExistente;
	}

	private Date getTenMinutesAgo() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.MINUTE, -10);
		return cal.getTime();
	}

	public long getNumberOfUsersInRoom(Long roomId) {
		if (roomId == null) {
			throw new IllegalArgumentException("O parâmetro roomId não pode ser null");
		}
		
		Map<UserActivityId, Date> roomActivities = chatRoomsUserActivityMap.get(roomId);
		long numberOfUsers = 0;

		if (roomActivities != null) {
			for (UserActivityId userActivityId : roomActivities.keySet()) {
				if (userActivityId.isPersistentUser()) {
					numberOfUsers++;
				}
			}
		}

		return numberOfUsers;
	}

	public long getNumberOfUsersSpyingInRoom(Long roomId) {
		if (roomId == null) {
			throw new IllegalArgumentException("O parâmetro roomId não pode ser null");
		}
		
		Map<UserActivityId, Date> roomActivities = chatRoomsUserActivityMap.get(roomId);
		long numberOfUsers = 0;

		if (roomActivities != null) {
			for (UserActivityId userActivityId : roomActivities.keySet()) {
				if (userActivityId.isSpyUser()) {
					numberOfUsers++;
				}
			}
		}

		return numberOfUsers;
	}

	public boolean isUserInRoom(Long roomId, UserActivityId userActivityId) {
		return getLastActivityOfUser(roomId, userActivityId) != null;
    }
}
