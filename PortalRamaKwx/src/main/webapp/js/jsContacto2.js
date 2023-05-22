$(document).ready(asignacionInicial);

function asignacionInicial() {

	$('#Btn_enviarContacto').on('click', EnviarInformacion);
}

function EnviarInformacion() {
	$("#Btn_enviarContacto").hide(200);
	$("#btn_esperaContacto").prop("disabled", true);
	$("#btn_esperaContacto").show(100);
	
	if(validaDatos())
	{
		/*
		 * $('#txt_nombre_contacto').val() == "" | $('#txt_correo_contacto').val() == ""
			| $('#txt_whatsApp_contacto').val() == "" | $('#txt_mensaje_contacto').val() == ""
		 */
		 $.ajax({      
		        url :'ServletContacto2',
		        data : 'operacion=2&nombre=' + $('#txt_nombre_contacto').val() + '&correo=' + $('#txt_correo_contacto').val() + '&whatsapp=' + $('#txt_whatsApp_contacto').val() + '&mensaje=' + $('#txt_mensaje_contacto').val(),
		        type : 'POST',
		        dataType : 'json',
		        success : function(json){
		        	alert('La informaci�n se envio satisfactoriamente.');
		        	LimpiarDatos();
		        },
		        error : function(xhr, status, error) {
		        }
		    });
	}
	
}

function validateEmail(email) {
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}

function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		return false;
	} else {
		document.getElementById('txt_whatsApp_contacto').className = "form-control mi-input";

		return true;
	}
}

	function validaDatos() {
		if ($('#txt_nombre_contacto').val() == "" | $('#txt_correo_contacto').val() == ""
			| $('#txt_whatsApp_contacto').val() == "" | $('#txt_mensaje_contacto').val() == ""
			) {
		
		$("#btn_esperaContacto").hide(100);
		$("#Btn_enviarContacto").show(100);
				
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
			$("#Btn_enviarContacto").show(200);
			$("#btn_esperaContacto").prop("disabled", true);
			$("#btn_esperaContacto").hide(100);
	}

