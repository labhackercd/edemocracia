alter table CDChat_ChatroomMessage alter column messageText nvarchar(3000)
alter table CDChat_Chatroom alter column description nvarchar(3900)
alter table cdchat_chatroom add imageId bigint
alter table CDChat_ChatRoomMessage add senderEmail nvarchar(75), senderUF bigint;