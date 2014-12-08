create table CDWL_Artigo (
	artigoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	estruturaId LONG,
	ordem INTEGER,
	texto TEXT null,
	legislacaoVigente TEXT null
);

create table CDWL_Contribuicao (
	contribuicaoId LONG not null primary key,
	artigoId LONG,
	texto TEXT null,
	descricao TEXT null,
	data_ DATE null,
	userId LONG,
	userName VARCHAR(75) null
);

create table CDWL_Estrutura (
	estruturaId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	texto VARCHAR(300) null,
	ordem INTEGER,
	paiEstruturaId LONG
);