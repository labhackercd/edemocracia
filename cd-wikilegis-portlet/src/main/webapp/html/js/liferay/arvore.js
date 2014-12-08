// Alterna a visualização do grupo e indica se ele está fechado ou não.
function toggleGrupo(objlink) {

	// Altera a exibição da subárvore
	$(objlink).siblings("ul").slideToggle("fast");
	
	
	$(objlink).toggleClass('menuAberto');
	// Altera ícone (+ / -)
	// TODO usar imagem em vez de texto
	
	if ($(objlink).hasClass('menuAberto')) {
		$(objlink).html("<img src='" + themeDisplay.getPathThemeImages() + "/custom/iconeRecolher.gif' alt='Recolher Menu' />");
	}
	else {
		$(objlink).html("<img src='" + themeDisplay.getPathThemeImages() + "/custom/iconeExpandir.gif' alt='Expandir Menu' />");
	}
	return false;
}
