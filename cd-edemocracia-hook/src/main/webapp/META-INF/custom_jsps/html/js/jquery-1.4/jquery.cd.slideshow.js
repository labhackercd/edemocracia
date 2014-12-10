(function($) {
	
	$.fn.slideshow = function(options) {
		
		var slideshow = this;
		 
		// Configurações do plugin
		var settings = {
				
			  // configurações do slideshow
		      showThumbs: false, // Não exibir thumbnails.
		      fade: false, // Transição sem fadding.
		      
		      // configurações do jcarousel
		      scroll: 1, // Não faz sentido ser diferente de 1 para o slideshow
		      visible: 1, // Não faz sentido ser diferente de 1 para o slideshow
		      wrap: "both", 
		      animation: 0,
		      easing: "swing",
		      auto: 5,
		      initCallback: carouselSlideshow,
		      itemVisibleInCallback: defineSelectedControl,
		      itemFirstInCallback: {
		    	  onBeforeAnimation: beforeChangeSlide
		      } 
		};
		
		settings = $.extend({}, settings, options);
		
		/*
		 * Função chamada sempre que troca-se de um slide para outro (antes da troca)
		 * Responsável pelo efeito de "fade" na transição.
		 */
		function beforeChangeSlide (carousel, item, index, status) {
			
			// Se foi definido um valor (tempo) para o fadding.
			if (settings.fade) {
				
				index--;
				if (status == 'init') {
					$(item).toggleClass("hidden"); // Remove hidden do item atual.
				}
				else {
					slideshow.find('.jcarousel-item').addClass("hidden"); // Acrescenta "hidden" em todos os itens.
					$(item).removeClass("hidden", settings.fade); // Remove "hidden" do item atual.
				}
			}
		};
		
		/*
		 * Após um item qualquer do slideshow tornar-se visível
		 * adiciona a classe 'selected' ao item correspondente nos controles
		 * (e remove essa classe dos demais itens).
		 */
		function defineSelectedControl(carousel, item, index, status) {
			index--;
			slideshow.find('.slideshow-controls li').removeClass('selected');
			slideshow.find('.slideshow-controls li:eq('+ index +')').addClass('selected');
		}
		
		/*
		 * Quando os controles do slideshow não foram criados pelo usuário,
		 * eles precisam ser criados dinamicamente.
		 * É isso o que essa função faz: com base nos itens do carrossel,
		 * cria os controles correspondentes.
		 */
		function createControls () {
			
			var controles;
			
		    // Cria a área de controles
		    controles = $(document.createElement('ul')).prependTo(slideshow);
		    controles.addClass('slideshow-controls');
		    
		    // Inclui os controles em forma de itens da lista
		    // Cada item da lista do slideshow corresponderá a um item da lista de controles.
		    slideshow.find('.jcarousel-item').each(function(index) {
		    	
				var number = parseInt(index) + 1;
				var numberSpan;
				var item = $(document.createElement('li'));
				
				// Para o 'li' criado, cria dentro um 'a'
				// ... e dentro do 'a', um 'span'
				// ... e dentro do 'span' coloca o número do slide.
				numberSpan = 
				item.append(document.createElement('a')).children().attr("href", "#")
					.append(document.createElement('span')).children()
					.append('0'+number);
					   
				numberSpan.addClass("slide-number");
				
				if (settings.showThumbs) {
					
					var thumbnail;
					
					thumbnail = document.createElement('div');
					numberSpan.after(thumbnail);
					$(thumbnail).addClass('thumbnail');
					
					// Faz uma cópia (clone) do thumbnail do carrossel e
					// a insere na lista de controles, ao lado número do slide.  
					if ($(this).find('.to-thumbnail').length) {
						$(thumbnail).append ($(this).find('.to-thumbnail').clone().removeClass('to-thumbnail'));	
					} else {
						$(thumbnail).append ($(this).find('img').clone());
					}
					
					// Se existe algum link no thumbnail, remove essa tag e deixa apenas o conteúdo
					// Isso porque o thumbnail criado em si já é um link que mostra o conteúdo referente a ele,
					// e por isso não faz sentido ter um link dentro dele. 
					$(thumbnail).find('a').replaceWith ($(thumbnail).find('a').contents());
					
				}
				
				// Insere na lista "bullets" criada antes o "li" criado agora.
				controles.append(item);
			});
		    
		    return controles;
		}
		
		
		/*
		 * Iniciando o carrossel.
		 */
		function carouselSlideshow(carousel) {
			
			slideshow.addClass("slideshow-active");

			// Esconde todos os itens do carrossel para fazer o fadding
			// Cada item será visível apenas quando for o atual
			if (settings.fade){
				slideshow.find('.jcarousel-item').addClass("hidden");
			}
			
		    // Desabilita autoscrolling se o usuário clicar em "próximo" ou "anterior"
			// TODO: permitir que esse comportamento seja controlado através de settings 
			carousel.buttonNext.bind('click', function() {
				carousel.startAuto(0);
			});
			carousel.buttonPrev.bind('click', function() {
				carousel.startAuto(0);
			});

			// Pausa autoscrolling se o usuário colocar o ponteiro do mouse sobre o carrossel.
			// TODO: permitir que esse comportamento seja controlado através de settings 
		    carousel.clip.hover(function() {
		        carousel.stopAuto();
		    }, function() {
		        carousel.startAuto();
		    });
		    
		    
		    var controles = slideshow.find ('.slideshow-controls');
		    
		    // Verifica se a área de controles não existe
		    // Neste caso, ela será criada dinamicamente
		    if (controles.length == 0) {
		    	
		    	// Cria os controles.
		    	controles = createControls();
			    
				// Define o comportamento dos controles.
			    controles.delegate('a', 'click', function () {
					carousel.startAuto(0); // Deixa o carrossel parado ao selecionar um slide
					carousel.scroll($.jcarousel.intval($(this).text()));
					return false;
				});	
			    
		    }
		    else {
				// Define o comportamento dos controles.
			    controles.delegate('a', 'click', function () {
			    	
			    	var id;
			    	
					carousel.startAuto(0); // Deixa o carrossel parado ao selecionar um slide
					id = $(this).attr("href");
					carousel.scroll($.jcarousel.intval($(carousel.list).find(id).attr('jcarouselindex')));
					return false;
				});	
		    	
		    }
		    
		    controles.find('li:first').addClass('first');
			controles.find('li:last').addClass('last');
		}
	
		return this.find('.slideshow-slides').jcarousel(settings);
		
	};
})(jQuery);
