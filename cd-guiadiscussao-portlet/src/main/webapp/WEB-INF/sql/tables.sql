create table GD_Acao (
	acaoId LONG not null primary key,
	faseId LONG,
	ordem INTEGER,
	texto VARCHAR(75) null,
	urlExterna BOOLEAN,
	urlLink VARCHAR(300) null,
	iconeId LONG
);

create table GD_Configuracao (
	configuracaoId LONG not null primary key,
	groupId LONG,
	faseAtualId LONG,
	textoBanner VARCHAR(75) null,
	imagemIdBanner LONG,
	urlBanner VARCHAR(300) null,
	urlExterna BOOLEAN,
	tituloBanner VARCHAR(75) null
);

create table GD_Fase (
	faseId LONG not null primary key,
	configuracaoId LONG,
	ordem INTEGER,
	titulo VARCHAR(75) null
);