Liferay.Service.register("Liferay.Service.CDChat", "br.gov.camara.edemocracia.portlets.chat.service");

Liferay.Service.registerClass(
	Liferay.Service.CDChat, "ChatRoom",
	{
		addChatRoom: true,
		deleteChatRoom: true,
		canModerate: true,
		canJoin: true,
		canSpy: true,
		getUsersCountInChatRoom: true,
		isRoomFull: true,
		addChatUser: true,
		addAnonUser: true,
		approveMessage: true,
		banUser: true,
		findAllInGroup: true,
		getJSONUpdate: true,
		getMessagesForExport: true,
		getUserCount: true,
		getUsersFromChatRoom: true,
		saveExportedMessages: true,
		getMessagesWithIds: true,
		getRoom: true,
		getChatUserFromPortalUser: true,
		getUsersInChatRoom: true,
		openChatRoom: true,
		closeChatRoom: true,
		postMessage: true,
		removeChatUser: true,
		updateChatRoom: true,
		removeStaleUsers: true
	}
);