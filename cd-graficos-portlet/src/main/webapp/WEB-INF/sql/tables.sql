create table Graficos_ContadorAcesso (
	contadorId LONG not null primary key,
	companyId LONG,
	data_ DATE null,
	dataAtualizacao DATE null,
	cache TEXT null
);