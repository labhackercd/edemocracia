create table CDChat_ChatRoom (
	roomId LONG not null primary key,
	roomName VARCHAR(75) null,
	description VARCHAR(3900) null,
	openPolicy INTEGER,
	status INTEGER,
	openFrom DATE null,
	openUntil DATE null,
	moderated BOOLEAN,
	capacity INTEGER,
	maxSimultaneousUsersSpying INTEGER,
	maxSimultaneousUsers INTEGER,
	anonymousAllowed BOOLEAN,
	guestId LONG,
	guestName VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	usePolicyEnabled BOOLEAN,
	usePolicyURL VARCHAR(300) null,
	imageId LONG,
	videoLiveId LONG,
	videoRecordedId LONG,
	createDate DATE null
);

create table CDChat_ChatRoomMessage (
	chatMessageId LONG not null primary key,
	parentMessageId LONG,
	chatRoomId LONG,
	exportedPosition LONG,
	exportedRemoved BOOLEAN,
	messageType INTEGER,
	messageStatus INTEGER,
	senderId LONG,
	senderName VARCHAR(75) null,
	senderUF LONG,
	senderEmail VARCHAR(75) null,
	senderType INTEGER,
	messageText VARCHAR(3900) null,
	textType INTEGER,
	messageTS DATE null,
	messagePublic BOOLEAN,
	adminMessage BOOLEAN,
	recipientUserId LONG,
	recipientUserName VARCHAR(75) null
);

create table CDChat_ChatRoomTwitter (
	twitterId LONG not null primary key,
	twitterTitle VARCHAR(75) null,
	twitterDescription VARCHAR(3900) null,
	twitterEnabled BOOLEAN,
	twitterHashtag VARCHAR(75) null,
	twitterDataWidgetId VARCHAR(75) null
);

create table CDChat_ChatRoomUser (
	chatUserId LONG not null primary key,
	chatRoomId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	userImgId LONG,
	userUF LONG,
	userEmail VARCHAR(75) null,
	banned BOOLEAN,
	userType INTEGER,
	joinedTS DATE null
);

create table CDChat_ChatRoomVideo (
	videoId LONG not null primary key,
	videoTitle VARCHAR(75) null,
	videoSubtitle VARCHAR(75) null,
	videoDescription VARCHAR(3900) null,
	videoEnabled BOOLEAN,
	videoUrl VARCHAR(3900) null,
	videoType VARCHAR(75) null
);