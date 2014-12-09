$(document).ready(function() {
	$('.lnk-mais-opcoes').click(function() {
		$('.painelToggle').toggle();
	});

	$(".lnk-mais-opcoes").toggle(function() {
		if ($(this).hasClass("iconSecaoAberta")) {
			$(this).removeClass("iconSecaoAberta");
			$(this).addClass("iconSecaoFechada");
		} else if ($(this).hasClass("iconSecaoFechada")) {
			$(this).addClass("iconSecaoAberta");
			$(this).removeClass("iconSecaoFechada");
		}
	}, function() {

		if ($(this).hasClass("iconSecaoAberta")) {
			$(this).removeClass("iconSecaoAberta");
			$(this).addClass("iconSecaoFechada");
		} else if ($(this).hasClass("iconSecaoFechada")) {
			$(this).addClass("iconSecaoAberta");
			$(this).removeClass("iconSecaoFechada");
		}

	});

});