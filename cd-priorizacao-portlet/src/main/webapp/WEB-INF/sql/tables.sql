create table PR_Configuracao (
	configuracaoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	maximoVotos INTEGER,
	maxVotosProposta INTEGER,
	votacaoAberta BOOLEAN
);

create table PR_Eixo (
	eixoId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	categoryId LONG,
	titulo VARCHAR(3900) null,
	sumario VARCHAR(3900) null,
	ordem INTEGER
);

create table PR_Proposta (
	propostaId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	eixoId LONG,
	identificador VARCHAR(75) null,
	ementa VARCHAR(3900) null,
	texto TEXT null,
	threadId LONG
);

create table PR_Voto (
	votoId LONG not null primary key,
	propostaId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	numeroVotos INTEGER,
	votosDisponiveis INTEGER,
	data_ DATE null
);