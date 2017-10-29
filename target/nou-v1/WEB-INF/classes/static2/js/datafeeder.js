$(document).ready( function() {

	$('.popover-abra, .popover-nregs-abra').popover({
		title: function() {
			var titulo = $(this).find('.bar').find('label').html();
			return titulo;
		},
		content: function() {
			var inicio = $(this).parent().attr('ini');
			if (typeof(inicio) == "undefined") {
				inicio = '-';
			}
			var fim = $(this).parent().attr('fim');
			if (typeof(fim) == "undefined") {
				fim = '-';
			}
			var tempo = $(this).parent().attr('tem');
			if (typeof(tempo) == "undefined") {
				tempo = '-';
			}
			var num = $(this).parent().attr('reg');
			if (typeof(num) == "undefined") {
				num = '-';
			}

			var val = $(this).parent().attr('val');
			if (typeof(val) == "undefined") {
				val = '-';
			}

			if($(this).hasClass('popover-abra')) {
				$(".popover-html").find('.pop-valor').html(val);

				$(".popover-html").find('.th-num').hide();
				$(".popover-html").find('.th-valor').show();	
			}

			if($(this).hasClass('popover-nregs-abra')) {
				$(".popover-html").find('.pop-valor').html(num);

				$(".popover-html").find('.th-valor').hide();
				$(".popover-html").find('.th-num').show();
			}

			$(".popover-html").find('.pop-inicio').html(inicio);
			$(".popover-html").find('.pop-fim').html(fim);
			$(".popover-html").find('.pop-tempo').html(tempo);


			var html = $(".popover-html").html();
			return html;
		},
		html:true,
		placement : 'right',
		trigger : 'hover'
	});

	$('.popover-st').popover({
		title: function() {
			var titulo = $(this).find('.bar').find('label').html();
			return titulo;
		},
		content: function() {
			var str = $(this).parent().attr('t');
			var spl = str.split(';');

			var g = '';
			for ( var u in spl) {
				g += spl[u] + '<br>';
			}

			$(".popover-p").find('.t').html(g);

			var html = $(".popover-p").html();
			return html;
		},
		html:true,
		placement : 'right',
		trigger : 'hover'
	});

	$('.calendario-select').datepicker({
		todayBtn: true,
		language: "pt-BR",
		orientation: "top left",
		format: 'dd/mm/yyyy',
		autoclose: true
	});

	$('i').tooltip();
	$('.toolTipText').tooltip();
	$('.dropdown-toggle').dropdown();

	$(document).on("change", ".data-calendario", function() {
		limparTask();

		atualizarPagina();
	});

	//atualizarPagina();
	var intervalo = window.setInterval(function() {
		 if(window.location.href.indexOf("painel-novo") > -1) {
				atualizarPagina();
		 }
	}, 2500);

	/*
	 * Atualizar as informacoes da pagina a partir dos dados recebidos
	 */


	function limparTask() {
		$('.inicio').html('');
		$('.usuario').html('');
		$('.st-right').find('i').hide();

		$('.IGPDI').find('i').show();
		$('.INPC').find('i').show();
		$('.CP').find('i').show();
	}

	$(document).on("click", ".iniciar-exec", function() {
		var button = $(this);
		$(button).addClass('disabled');

		$.ajax({
			type: "POST", 
			url: contextPath + '/painel/iniciar',
			dataType: "text", 
			success: function(text) {
				if(text) {
					atualizarPagina();
				}
			}, 
			error:function (xhr, ajaxOptions, thrownError){
				//alert(xhr.status);
				//alert(thrownError);
			}   
		});
	});

	$(document).on("click", ".parar-exec", function() {
		var button = $(this);
		$(button).addClass('disabled');

		$.ajax({
			type: "POST", 
			url: contextPath + '/painel/parar',
			dataType: "text", 
			success: function(text) {
				if(text) {
					$(this).removeClass('btn-danger').addClass('btn-primary');
					$(this).html('Iniciar');
					$(this).removeClass('parar-exec').addClass('iniciar-exec');
				}
			}, 
			error:function (xhr, ajaxOptions, thrownError){
				//alert(xhr.status);
				//alert(thrownError);
			}   
		});
	});

	$(document).on("click", ".reprocessar", function() {
		var proc = $(this).attr('proc');
		alert(proc);
	});

	$(document).on("change", ".upload", function() {
		$(this).parent().find('.submit').click();
	});
	
	function atualizarPagina() {
		//pega a data que esta selecionada
		var data = $('.data-calendario').val();

		//a data esta invalida?
		if(data != '' && data.length != 10) {
			return;//nao faca nada
		}

		//monta a url de requisicao
		var url = contextPath + '/indicadoresRisco/painel-novo/atualizar/' + data;

		$.ajax({
			url : url,
			type: "POST",
			dataType: "json",
			beforeSend: function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");  
				xhr.setRequestHeader("Content-Type", "application/json");  
			},  
			success : function(result) {
				//limparTask();

				if(result.data != null) {
					var usuario = result.usuario;
					var inicio = result.inicio;

					$('.inicio').html('<i class="icon-time"></i> ' + inicio);
					$('.usuario').html('<i class="icon-user"></i> ' + usuario);

					if(result.executando) {
						$('.parar-exec').show();
						$('.iniciar-exec').hide();

						/*setTimeout( function() {

							atualizarPagina();

						}, 1000);*/

					} else {
						$('.iniciar-exec').show();
						$('.parar-exec').hide();
					}

					atualizarTask(result);

				}
			}
		});
	}
	
	
	function atualizarTask(result) {
		//varrer cada elemento da resposta
		$('.GEROU_PRECOS').attr('t', "");	
		for (var i in result.task) {

			var tarefa = result.task[i].tarefa;
			var perc = result.task[i].perc;
			var download = result.task[i].download;
			var insercao = result.task[i].insercao;
			var feito = result.task[i].feito;


			if('GEROU_CURVAS' == tarefa || 'GEROU_ARQ' == tarefa || 'GEROU_OPCOES' == tarefa || 'RISCO_MERCADO' == tarefa || 'RISCO_LIQUIDEZ' == tarefa || 'GEROU_PRECOS' == tarefa) {
				var t = '';
				for(var text in result.task[i].processos) {
					t += result.task[i].processos[text] + ';';
				}
				if('GEROU_OPCOES' == tarefa){
					if(perc == 100){
						$('.GEROU_PRECOS').attr('t', $('.GEROU_PRECOS').attr('t') + "Gerou Opcoes - Sim;");
					}else{
						$('.GEROU_PRECOS').attr('t', $('.GEROU_PRECOS').attr('t') + "Gerou Opcoes - Nao;");
					}	
				}else{
					if('GEROU_CURVAS' == tarefa || 'GEROU_PRECOS' == tarefa  ){
						$('.GEROU_PRECOS').attr('t', $('.GEROU_PRECOS').attr('t') + t);
					}else{
						$('.' + tarefa).attr('t', t);
					}
				}
			}

			$('.' + tarefa).attr('ini', result.task[i].inicio);
			$('.' + tarefa).attr('fim', result.task[i].fim);
			$('.' + tarefa).attr('tem', result.task[i].tempo);
			$('.' + tarefa).attr('reg', result.task[i].numRegs);
			$('.' + tarefa).attr('val', result.task[i].valor);

			$('.' + tarefa).find('.bar').css('width', perc + '%');

			if(download == 1) {
				$('.' + tarefa).find('.download').show();

			}  else {
				$('.' + tarefa).find('.download').hide();
			} 

			if(insercao == 1) {
				$('.' + tarefa).find('.insercao').show();

			} else {
				$('.' + tarefa).find('.insercao').hide();
			}

			if(feito == 1) {
				$('.' + tarefa).find('.feito').show();
				$('.' + tarefa).find('.nfeito').hide();
				$('.' + tarefa).find('.efeito').hide();

			} else if(feito == 2) {
				$('.' + tarefa).find('.feito').hide();
				$('.' + tarefa).find('.nfeito').hide();
				$('.' + tarefa).find('.efeito').show();

			} else {
				$('.' + tarefa).find('.nfeito').show();
				$('.' + tarefa).find('.feito').hide();
				$('.' + tarefa).find('.efeito').hide();
			}
		}
		$('.GEROU_PRECOS').attr('t');
		
		var count = ($('.GEROU_PRECOS').attr('t').match(new RegExp("- Sim", "g")) || []).length; //logs 4
		count = (count / 18) *100;
		$('.GEROU_PRECOS').find('.bar').css('width', count + '%');
		mudaCorFlagNew(count,'GEROU_PRECOS');
	}
	
	function mudaCorFlagNew(porcent, tarefa){
		if(porcent < 99) {
			$('.' + tarefa).find('.nfeito').show();
			$('.' + tarefa).find('.feito').hide();
			$('.' + tarefa).find('.efeito').hide();
		} else {
			$('.' + tarefa).find('.feito').show();
			$('.' + tarefa).find('.nfeito').hide();
			$('.' + tarefa).find('.efeito').hide();
		}
	}
});