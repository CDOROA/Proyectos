function initialize() {
	var $animation_elements = $('.animation-element');
	var $window = $(window);

	function check_if_in_view() {
		var window_height = $window.height();
		var window_top_position = $window.scrollTop();
		var window_bottom_position = (window_top_position + window_height);
		$
				.each(
						$animation_elements,
						function() {
							var $element = $(this);
							var element_height = $element.outerHeight();
							var element_top_position = $element.offset().top;
							var element_bottom_position = (element_top_position + element_height);

							// check to see if this current container is within
							// viewport
							if ((element_bottom_position >= window_top_position)
									&& (element_top_position <= window_bottom_position)) {
								$element.addClass('in-view');
							} else {
								$element.removeClass('in-view');
							}
						});
	}

	$window.on('scroll resize', check_if_in_view);
	$window.trigger('scroll');
	
	
}

function CargaDelegaciones(cve_del)
{
	//alert (cve_del);
	$('#cmbListaMunicipio').empty();
	var cve_estado = $('#cmbListaEstados').val();
	
	//alert (cve_estado);
	$.ajax({
        url :'ServletEvaluarMecanico', 
        data : "operacion=2"+'&cve_estado='+cve_estado,
        type : 'POST',
        dataType : 'json',
        success : function(json)
        {	
        	if( json.length > 0)
    		{
        		$("<option value="+"0"+">"+"- Delegacion o Municipio -"+"</option>").appendTo("#cmbListaMunicipio");
        		for (var i = 0; i < json.length; i++) {
        			
        			//$("<option value="+json[i].cve_delegacion+">"+json[i].descripcion+"</option>").appendTo("#cmbListaMunicipio");
        			 $("#cmbListaMunicipio").append('<option value="'+json[i].descripcion+'">'+json[i].descripcion+'</option>');
        		}
        		
        		
    		}
    	},
    	error : function(xhr, status, error) {
        	//alert('Sitio en construcion');
        }
    }); 
	
}


function CargaMecanicos()
{
	var cve_estado = $('#cmbListaEstados').val();
	var cve_numcipio = $('#cmbListaMunicipio').val();
	
	
	$.ajax({
        url :'ServletEvaluarMecanico', 
        data : "operacion=3"+"&cve_delegacion="+cve_estado+"&cve_numcipio="+cve_numcipio,
        type : 'POST',
        dataType : 'json',
        success : function(json)
        {	
        	if( json.length > 0)
    		{
        		$('#cmbTalleres').empty();
        		$("<option value="+"0"+">"+"- Seleccione un Taller -"+"</option>").appendTo("#cmbTalleres");
        		for (var i = 0; i < json.length; i++) {
        			 $("#cmbTalleres").append('<option value="'+json[i].idMecanico+'">'+json[i].nombreTaller+'</option>');
        		}
    		}
        	
    	},
    	error : function(xhr, status, error) {
        	//alert('Sitio en construcion');
        }
    }); 
	
}

function EnviarInformacion()
{
	var idTaller =  $('#cmbTalleres').val();
    var NombreTaller= $("#cmbTalleres option:selected").text();
    var requeriServicio = $('#cmbRequeriServicio').val();
    var cdmEntregoFicha = $('#cdmEntregoFicha').val();
    var cmbBaseDatosUtil = $('#cmbBaseDatosUtil').val();
    var cmbListaAtencion = $('#cmbListaAtencion').val();
    var cmbListaCalidadTrabajo = $('#cmbListaCalidadTrabajo').val();
    var cmbListaTiempoEntrega = $('#cmbListaTiempoEntrega').val();
    var cmbListaSatisfechoTrabajo = $('#cmbListaSatisfechoTrabajo').val();
    var cmbListaRecomendarTaller = $('#cmbListaRecomendarTaller').val();
    var cmbListallevarAuto = $('#cmbListallevarAuto').val();
    
/*    
    alert("idTaller: " + idTaller + "\nNombreTaller: " + NombreTaller
    		+"\nrequeriServicio:"+requeriServicio +"\ncdmEntregoFicha: "+cdmEntregoFicha
    		+"\ncmbBaseDatosUtil:"+ cmbBaseDatosUtil +"\ncmbListaAtencion: " + cmbListaAtencion
    		+"\ncmbListaCalidadTrabajo: "+ cmbListaCalidadTrabajo +"\ncmbListaTiempoEntrega: "+ cmbListaTiempoEntrega
    		+"\ncmbListaSatisfechoTrabajo: "+ cmbListaSatisfechoTrabajo + "\ncmbListaRecomendarTaller: " + cmbListaRecomendarTaller
    		+"\ncmbListallevarAuto: "+ cmbListallevarAuto);*/
    
    
    $.ajax({
		url : 'ServletEvaluarMecanico',
		data : 'operacion=4&idTaller=' + idTaller + 
		        '&NombreTaller=' + NombreTaller + 
		        '&requeriServicio=' +requeriServicio + 
		        '&cdmEntregoFicha=' + cdmEntregoFicha + 
		        '&cmbBaseDatosUtil=' + cmbBaseDatosUtil +
		        '&cmbListaAtencion=' + cmbListaAtencion + 
		        '&cmbListaCalidadTrabajo=' +cmbListaCalidadTrabajo + 
		        '&cmbListaTiempoEntrega=' + cmbListaTiempoEntrega + 
		        '&cmbListaSatisfechoTrabajo=' + cmbListaSatisfechoTrabajo +
				'&cmbListaRecomendarTaller=' + cmbListaRecomendarTaller +
				'&cmbListallevarAuto=' + cmbListallevarAuto,
		type : 'POST',
		dataType : 'json',
		success : function(json) {
			//alert("aqui...");
			
			// Get the modal
			var modal = document.getElementById("ModalTerminado");
			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];
			// Get the modal
			
			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
				modal.style.display = "none";
			}
			
			//var modal = document.getElementById("ModalTerminado");

			// Get the image and insert it inside the modal - use its "alt" text as a caption

			var modalImg = document.getElementById("img01");
			var captionText = document.getElementById("caption");

			modal.style.display = "block";

			captionText.innerHTML = modalImg.alt;

			LimpiaCampos();

		},
		error : function(xhr, status, error) {
			//	alert("aqui error...");
		}
	});
}

function LimpiaCampos(){
 $('#cmbTalleres').val(0);
 $("#cmbTalleres").val(0);
 $('#cmbRequeriServicio').val(0);
 $('#cdmEntregoFicha').val(0);
 $('#cmbBaseDatosUtil').val(0);
 $('#cmbListaAtencion').val(0);
 $('#cmbListaCalidadTrabajo').val(0);
 $('#cmbListaTiempoEntrega').val(0);
 $('#cmbListaSatisfechoTrabajo').val(0);
 $('#cmbListaRecomendarTaller').val(0);
 $('#cmbListallevarAuto').val(0);
 
	$("#btn_espera").hide(200);
	$("#myBtn").prop("disabled", true);
	$("#myBtn").show(100);
}