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
	
	$(document).on("click", ".btn-novo", function() {
		
		 window.location = contextPath+"/user/novo";

	});
	
	$(document).on("click", ".btn-save", function() {
		var id = $('.inp-id').val();
		var name = $('.inp-name').val();
		var email = $('.inp-email').val();
		var password = $('.inp-password').val();
		
		var enabled =1;

		if( $(".inp-enabled").is(":checked") == true ){
			enabled =1;
		} else{
			enabled =0;
		}
			
		if(id===""){
			id = "null";
		}
		
		$.ajax({
			url : contextPath + '/user/save/'+id+'/'+name+'/'+email+'/'+password+'/'+enabled,
			type : 'POST',
			success : function(result) {
				window.location = contextPath+"/user/index";
			}
		});	
	});
	
	$(document).on("click", ".btn-alter", function() {
		var name = $(this).attr('name-id');
		$.ajax({
			url : contextPath + '/user/alter/'+name,
			type : 'GET',
			success : function(html) {
				$('.result' ).html(html);	
			}
		});
	});
	
	$(document).on("click", ".btn-delete", function() {
		var id = $(this).attr('id');
		$.ajax({
			url : contextPath + '/user/delete/'+id,
			type : 'GET',
			success : function(html) {
				window.location = contextPath+"/user/index";
			}
		});
	});
	
	$(document).on("click", "#table-users tr", function() {
		/*var name = $(this).parent().parent().find('.tr-name').attr("name");		
		var name2 = $(this).parent().find('.tr-name').attr("name");
		var inp = $(this).attr('name-id');
		alert(inp);
		$.ajax({
			url : contextPath + '/user/alter/'+name,
			type : 'GET',
			success : function(html) {
				$('.result' ).html(html);	
			}
		});*/	
	});
	
	$(document).on("click", ".btn-back", function() {
		window.location = contextPath+"/user/index";
	});	
	
});	