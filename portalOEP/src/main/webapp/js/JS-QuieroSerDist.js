$(document).ready(asignacionInicial);

function asignacionInicial() {

	$('#Btn_enviarQuieroSerDist').on('click', EnviarInformacion);
}

function EnviarInformacion() {
	$("#Btn_enviarQuieroSerDist").hide(200);
	$("#Btn_cancelarQuieroSerDist").hide(200);
	$("#btn_esperaQuieroSerDist").prop("disabled", true);
	$("#btn_esperaQuieroSerDist").show(100);
	
	if(validaDatos())
	{
		/*
		 * $('#txt_nombre_contacto').val() == "" | $('#txt_correo_contacto').val() == ""
			| $('#txt_whatsApp_contacto').val() == "" | $('#txt_mensaje_contacto').val() == ""
		 */
		 $.ajax({      
		        url :'QuieroSerDistribuidor',
		        data : 'operacion=2&nombre=' + $('#txt_nombre_contacto').val() + '&correo=' + $('#txt_correo_contacto').val() + '&whatsapp=' + $('#txt_whatsApp_contacto').val() + '&mensaje=' + $('#txt_mensaje_contacto').val(),
		        type : 'POST',
		        dataType : 'json',
		        success : function(json){
		        	alert('La informacion se envio satisfactoriamente.');
		        	LimpiarDatos();
		        	$('#modalDist').modal('hide');
		        },
		        error : function(xhr, status, error) {
		        }
		    });
	}
	
}

function validaDatos() {
	if ($('#txt_nombre_contacto').val() == "" | $('#txt_correo_contacto').val() == ""
		| $('#txt_whatsApp_contacto').val() == "" | $('#txt_mensaje_contacto').val() == ""
		) {
	
	$("#btn_esperaQuieroSerDist").hide(100);
	$("#Btn_enviarQuieroSerDist").show(100);
	$("#Btn_cancelarQuieroSerDist").show(100);
	var	msn = "¡Datos incompletos!, por favor valide que ninguno de los datos este en blanco.";
	
		if ($('#txt_nombre_contacto').val() == "") {
			msn = msn + "\n Ingrese el Nombre del contacto.";
			
			document.getElementById('txt_nombre_contacto').style.border = "solid rgb(237, 37, 37)";
			
				document.getElementById('txt_nombre_contacto').className = "form-control mi-input1";
		} 
		if ($('#txt_correo_contacto').val() == "") {
                   msn = msn + "\n Ingrese una direccion de correo electronico.";
			
			document.getElementById('txt_correo_contacto').style.border = "solid rgb(237, 37, 37)";
		} 
		if ($('#txt_whatsApp_contacto').val() == "") {
		       msn = msn + "\n Ingrese un Numero de WhatsApp";
				
				document.getElementById('txt_whatsApp_contacto').style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#txt_mensaje_contacto').val() == "") {
			 msn = msn + "\n Ingrese una breve descripcion";
				
				document.getElementById('txt_mensaje_contacto').style.border = "solid rgb(237, 37, 37)";
		}
	
		alert(msn);
			return false;
	}
	else
	{
		return true;
	}
	
		
}

function LimpiarDatos()
{
	   $('#txt_nombre_contacto').val("");
	   $('#txt_correo_contacto').val("");
	   $('#txt_whatsApp_contacto').val("");
	   $('#txt_mensaje_contacto').val("");
	   $("#Btn_cancelarQuieroSerDist").show(200);
		$("#Btn_enviarQuieroSerDist").show(200);
		$("#btn_esperaQuieroSerDist").prop("disabled", true);
		$("#btn_esperaQuieroSerDist").hide(100);
}