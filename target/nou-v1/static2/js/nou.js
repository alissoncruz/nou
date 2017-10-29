$(document).ready(function() {
	
	$.ajaxSetup({
		cache : false
	});
	
	$('i').tooltip();
	
	$('.dropdown-toggle').dropdown();

	$('.date').datepicker({
		language : "pt-BR",
		orientation : "top left",
		format : 'dd/mm/yyyy',
		autoclose : true
	});
	
	$('[data-toggle="popover"]').popover({
        html:true,
        content : function() {
             $('#clickGoogle').css({'display':'block'});
             return $('#clickGoogle');
        }        
    });
	
	function createTable(){
		$('#table-result').dataTable({
            "scrollY": "400px",
            "scrollCollapse": true,
            "paging": true,
            "ordering": true,
            "info": false,
            "searching": false
            
            });
	}

	$('#resultado').hide();
	
	function pesquisar(){		
			var valor = $('.valor').val();
			if (valor !== '' ){
				
				$.ajax({
					url : contextPath + '/consulta/pessoaFisica' + '/' + valor,
					type : 'POST',
					success : function(html) {
						$('#resultado').html(html);
						$('#resultado').show();
					}
				});	
			} else {
				$('#resultado').hide();
			}
	}

	
	$(document).on(
			'click',
			'.btn-pesquisa',function() {
			pesquisar();
	});
	
	$(document).on('keypress','.valor',function(e) {
		 if (e.which == 13) {		        
				var valor = $('.valor').val();
				$.ajax({
					url : contextPath + '/consulta/pessoaFisicaNome' + '/' + valor,
					type : 'POST',
					success : function(html) {
						$('#resultado').html(html);
						$('#resultado').show();
						createTable();
//						$('#logocentral').hide();
					}
				});
		    }
	
	});
	
	
	$(document).on('keyup', '.input-pesquisar', function() {
	    var palavra = $(this).val();

	    var count = 0;
	    $("#table-preboleta").find("tr:not(:empty)").each(function(index) {
        	if (!index) {
        		return;
        	}
            $(this).find("td:not(:empty)").each(function () {
                var str = $(this).text().toLowerCase();
                var not_found = (str.indexOf(palavra.toLowerCase()) === -1);
                $(this).closest('tr').toggle(!not_found);
                if(!not_found){
               		count++
                }
                return not_found;
           });
	    });	
	 });
	
	$(document).on('click', '#table-result tr', function() {
		var cpf = $(this).find('.cpf').text();
		$.ajax({
			url : contextPath + '/consulta/pessoaFisicaPorCpf' + '/' + cpf,
			type : 'GET',
			success : function(html) {
				$('#resultado').html(html);
				$('#resultado').show();
			}
		});
	});
		
	
});
