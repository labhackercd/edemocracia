Liferay.Service.register("Liferay.Service.CDWL", "br.gov.camara.edemocracia.portlets.wikilegis.service", "cd-wikilegis-portlet");

Liferay.Service.registerClass(
	Liferay.Service.CDWL, "WikiLegis",
	{
		getArtigoDisplay: true,
		listaElementos: true,
		listaEstrutura: true,
		editaArtigo: true,
		excluiArtigo: true,
		criaArtigo: true,
		listaContribuicoes: true,
		adicionaContribuicao: true,
		removeContribuicao: true,
		listaEstruturaFilhos: true,
		listaArtigos: true,
		criaEstrutura: true,
		getEstrutura: true,
		getArtigo: true,
		atualizaEstrutura: true,
		postaComentario: true,
		excluiComentario: true,
		atualizaComentario: true,
		atualizaContribuicao: true,
		exportaContribuicoes: true,
		exportaComentarios: true
	}
);