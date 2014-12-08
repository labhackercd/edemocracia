create unique index IX_2F88A338 on PR_Configuracao (groupId);

create index IX_685481CC on PR_Eixo (groupId);

create index IX_1BACC681 on PR_Proposta (eixoId);
create index IX_599EA413 on PR_Proposta (groupId);
create index IX_237B32A4 on PR_Proposta (identificador, groupId);

create index IX_31C8145A on PR_Voto (propostaId);
create unique index IX_8C407294 on PR_Voto (propostaId, userId);
create index IX_C92D13F1 on PR_Voto (userId);