package br.gov.camara.edemocracia.portlets.chat.service;

import java.util.Collection;
import java.util.Date;

public interface ChatUserActivityManager {

	Collection<UserActivityId> removeInactiveUsers();

	void removeUser(Long roomId, UserActivityId userActivityId);
	
	void addUser(Long roomId, UserActivityId userActivityId);

	void updateUserLastActivity(Long roomId, UserActivityId userActivityId);

	Date getLastActivityOfUser(Long roomId, UserActivityId userActivityId);
	
	long getNumberOfUsersInRoom(Long roomId);
	
	long getNumberOfUsersSpyingInRoom(Long roomId);
	
	boolean isUserInRoom(Long roomId, UserActivityId userActivityId);
	
}
