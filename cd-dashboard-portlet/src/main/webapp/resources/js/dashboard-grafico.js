function setSelectedItemColor(namespace) {

	/*namespace = '#portlet_' + namespace + ' '; */
	namespace = '#p_p_id' + namespace + ' ';
	var itemSelecionado = $(namespace + '.informacoesGrafico input:hidden').val();
	
	var corItemSelecionado =  $(namespace + '.jqplot-table-legend-swatch-outline .jqplot-table-legend-swatch:eq('+itemSelecionado+')').css('background-color');
	
	$(namespace+'.painelCorRecursoSelecionado').css('background-color', corItemSelecionado);
	$(namespace+'.painelCorRecursoSelecionado').css('border-color', corItemSelecionado);
	
}