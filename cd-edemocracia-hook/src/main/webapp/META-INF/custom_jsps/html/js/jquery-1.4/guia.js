
var lock = false;

function mycarousel_initCallback(carousel, state) {
    jQuery('#carousel-next').bind('click', function() {

		var $totalItens = $('.jcarousel-item').size();
		var $primeiroItem = carousel.first;

		// Evita fase dummy inicial
		if ($primeiroItem < $totalItens - 2) {
			if (lock == false) {
				lock = true;
				$('.jcarousel-item').removeClass('selecionada');
				
				var $posicao = 2 + ($primeiroItem) * 187;
							
				setTimeout(function(){
					var fases = $('.fases li');
					fases.removeClass('selecionada');
					$('.jcarousel-item').eq($primeiroItem+1).addClass('selecionada');
					$('.fases li.selecionada .detalhes').css('left', $posicao.toString() + "px");	
					lock = false;
				}, 425);

				carousel.next();
				$('#carousel-prev').disabled = true;
				$('#carousel-prev').removeClass('anteriorDesabilitado');
				$('#carousel-prev').addClass('anterior');
			}
		}
		//desabilita seta da direita
		if ($primeiroItem == $totalItens - 3) {
			$('#carousel-next').removeClass('proximo');
			$('#carousel-next').addClass('proximoDesabilitado');
		}

        return false;
    });

    jQuery('#carousel-prev').bind('click', function() {
	
		var $totalItens = $('.jcarousel-item').size();
		var $primeiroItem = carousel.first;
		
		// Evita fase dummy inicial
		if ($primeiroItem > 1) {
			if (lock == false) {
				lock = true;
				$('.jcarousel-item').removeClass('selecionada');

				var $posicao = 2 + (($primeiroItem-2) * 187);
						
				setTimeout(function(){
					var fases = $('.fases li');
					fases.removeClass('selecionada');
					$('.jcarousel-item').eq($primeiroItem-1).addClass('selecionada');
					$('.fases li.selecionada .detalhes').css('left', $posicao.toString() + "px");	
					lock = false;
				}, 425);
					
				carousel.prev();
				$('#carousel-next').removeClass('proximoDesabilitado');
				$('#carousel-next').addClass('proximo');
			}		
		}

		//desabilita seta da esquerda
		if ($primeiroItem - 2 == 0) {
			$('#carousel-prev').removeClass('anterior');
			$('#carousel-prev').addClass('anteriorDesabilitado');
		}
		return false;
    });


 
};

function itemLoadCallbackFunction(carousel, state)
{
	$('.fases li.selecionada .detalhes').css('left', (2 + (carousel.first-1) * 187) + "px");	

	if(carousel.last == $('.jcarousel-item').size()){
		$('#carousel-next').removeClass('proximo');$('.fases li.selecionada .detalhes').css('left', (2 + (carousel.first-1) * 187) + "px");
		$('#carousel-next').addClass('proximoDesabilitado');
	}
	if(carousel.first == 1){
		$('#carousel-prev').removeClass('anterior');
		$('#carousel-prev').addClass('anteriorDesabilitado');
	}
};

$(document).ready(function() {


	// encontra o indice da fase atual e marca como selecionada
	var fases = $("#fases > li");
	var itemAtual = $(".atual");
	var indexFaseAtual = fases.size()-1;
	if ( itemAtual.size() >= 1 ) {
		indexFaseAtual = fases.index(itemAtual);
		$(".atual").addClass('selecionada');
	}
	else {
		// caso nao tenha fase atual
		var faseSelecionada = fases.get(indexFaseAtual-1);
		$(faseSelecionada).addClass('selecionada');
	}
	
	// cria o carrossel com a fase atual pocionada
    jQuery("#carrossel").jcarousel({
		scroll: 1,
		start: indexFaseAtual,
		animation: 400,
		initCallback: mycarousel_initCallback,
		itemLoadCallback: itemLoadCallbackFunction,			
		buttonNextHTML: null,
		buttonPrevHTML: null
    });

});

