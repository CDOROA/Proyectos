function verificaProssWeb(){
	consultaInformacion();
}

function consultaInformacion(){
	$.ajax({
		url : 'AdministradorControl',
		data : "accion=Cargar",
		type : 'POST',
		dataType : 'JSON',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) { 
					cargarInformacionPw(respuesta);
					//document.getElementById('cargando').style.display = 'none';

				}
			} else
				//document.getElementById('cargando').style.display = 'none';
				alert("ok");
		},
		error : function(xhr, status, error) {
			//mostrarMsjError("No se pudo cargar los registros. Intentelo nuevamente.")
			//document.getElementById('cargando').style.display = 'none';
			alert("Error");
		}
	});
}

function cargarInformacionPw(json){
	$('#form-select').empty();
	let contenido="";
	for(var i=0;i<json[0].listaProcesos.length;i++){
		contenido+="<option value='"+json[0].listaProcesos[i].url+"'>"+json[0].listaProcesos[i].nombre+"</option>"
		}
	contenido+="</select>";
	$('#form-select').append(contenido);
}

function redireccionarVista(url){
//	alert(document.getElementById('formulario'));
	document.getElementById("formulario").action=url;
	document.getElementById("formulario").submit()
}