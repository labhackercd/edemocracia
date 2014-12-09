create index IX_87E95AA9 on CDChat_ChatRoom (companyId);
create index IX_A22A776B on CDChat_ChatRoom (groupId);
create index IX_61A8C7F1 on CDChat_ChatRoom (roomName, groupId);

create index IX_54A8936A on CDChat_ChatRoomMessage (messagePublic, messageTS);
create index IX_DC231273 on CDChat_ChatRoomMessage (messagePublic, recipientUserId, messageTS);

create index IX_F101218C on CDChat_ChatRoomUser (chatRoomId);
create index IX_B8030CF5 on CDChat_ChatRoomUser (chatRoomId, userEmail);
create index IX_717A2DC6 on CDChat_ChatRoomUser (chatRoomId, userId);
create index IX_42354F6 on CDChat_ChatRoomUser (chatRoomId, userName);
create index IX_BF76DB04 on CDChat_ChatRoomUser (userId);