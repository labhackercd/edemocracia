Liferay.Service.register("Liferay.Service.PR", "br.gov.camara.edemocracia.portlets.priorizacao.service");

Liferay.Service.registerClass(
	Liferay.Service.PR, "Priorizacao",
	{
		getEixo: true,
		listarEixos: true,
		listarPropostaDisplay: true,
		addEixo: true,
		updateEixo: true,
		deleteEixo: true,
		getProposta: true,
		listarPropostasPorEixoId: true,
		deleteProposta: true,
		updateProposta: true,
		addProposta: true,
		addVoto: true,
		deleteVoto: true,
		getMBCategory: true,
		listarCategorias: true,
		listarTopicosPorCategoryId: true,
		getSumarioPriorizacao: true,
		getPropostaDisplay: true,
		getVotosUsuario: true,
		getConfiguracaoPorGrupo: true,
		updateConfiguracao: true,
		getEixosCountByGroupId: true,
		getPropostasCountByEixoId: true,
		getVotosPorPropostaId: true
	}
);