$(document).ready(asignacionInicial);


function asignacionInicial(){	
	LimpiarDatos();
	$('#btn_enviar').on('click', EnviarInformacion);
}

function EnviarInformacion()
{
	if(validaDatos())
	{
		if (validateEmail($('#txtCorreo').val())) 
		{
			 $.ajax({      
			        url :'ServletContacto',
			        data : 'operacion=2&nombre=' + $('#txtNombre').val() + '&pais=' + $('#txtPais').val() + '&ciudad=' + $('#txtCiudad').val() + '&calle=' + $('#txtCalle').val() + '&numInt=' + $('#txtNumInt').val() +
			        		'&numExt=' + $('#txtNumExt').val() + '&colonia=' + $('#txtColonia').val() + '&delegacion=' + $('#txtDelegacion').val() + '&cp=' + $('#txtCp').val() + '&lada=' + $('#txtLada').val()+
			        		'&telefono=' + $('#txtTelefono').val() + '&celular=' + $('#txtCelular').val() + '&correo='+ $('#txtCorreo').val() + '&mensaje=' + $('#txtMessage').val(),
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
		else
		{
			alert('Correo electr�nico no es v�lido!, por favor valide la informaci�n.');
			document.getElementById('txtCorreo').className = "form-control mi-input1";  
		}
	}
	
}

function validaDatos()
{
	if($('#txtNombre').val() == "" && $('#txtPais').val() == "" &&  $('#txtCiudad').val() == "" && $('#txtCalle').val() == "" && $('#txtNumInt').val() == "" && $('#txtNumExt').val() == "" && $('#txtColonia').val() == "" &&
	   $('#txtDelegacion').val() == "" &&  $('#txtCp').val() == "" && $('#txtLada').val() == "" &&  $('#txtTelefono').val() == "" && $('#txtCelular').val() == "" && $('#txtCorreo').val() == "" && $('#txtMessage').val() == "")
	{
		alert('�Por favor, Ingresa los datos solicitados.!');
		LimpiarDatos();
	}
	else
	{		
		if($('#txtNombre').val() == "" || $('#txtPais').val() == "" ||  $('#txtCiudad').val() == "" || $('#txtCalle').val() == "" || $('#txtNumExt').val() == "" || $('#txtColonia').val() == "" ||
		   $('#txtDelegacion').val() == "" ||  $('#txtCp').val() == "" || $('#txtLada').val() == "" || $('#txtCorreo').val() == "" || $('#txtMessage').val() == "")
		{
			 alert('�Datos incompletos!, por favor valide que ninguno de los datos este en blanco.');
			 if($('#txtNombre').val() == "")
			 {
				 document.getElementById('txtNombre').className = "form-control mi-input1"; 
			 }
			 else if($('#txtPais').val() == "")
			 { 
				 document.getElementById('txtPais').className = "form-control mi-input1"; 
			 }
			 else if($('#txtCiudad').val() == "")
			 { 
				 document.getElementById('txtCiudad').className = "form-control mi-input1"; 
			 }
			 else if($('#txtCalle').val() == "")
			 { 
				 document.getElementById('txtCalle').className = "form-control mi-input1"; 
			 }			 
			 else if($('#txtNumExt').val() == "")
			 { 
				 document.getElementById('txtNumExt').className = "form-control mi-input1"; 
			 }
			 else if($('#txtColonia').val() == "")
			 { 
				 document.getElementById('txtColonia').className = "form-control mi-input1"; 
			 }
			 else if($('#txtDelegacion').val() == "")
			 { 
				 document.getElementById('txtDelegacion').className = "form-control mi-input1"; 
			 }
			 else if($('#txtCp').val() == "")
			 { 
				 document.getElementById('txtCp').className = "form-control mi-input1"; 
			 }
			 else if($('#txtLada').val() == "")
			 { 
				 document.getElementById('txtLada').className = "form-control mi-input1"; 
			 } 
			 else if($('#txtCorreo').val() == "")
			 { 
				 document.getElementById('txtCorreo').className = "form-control mi-input1"; 
			 }
			 else if($('#txtMessage').val() == "")
			 { 
				 document.getElementById('txtMessage').className = "form-control mi-input1"; 
			 }
			 return false;
		}
		else if($('#txtTelefono').val() == "" && $('#txtCelular').val() == "")
		{
			alert('Por favor, ingresa un tel�fono o celuar.');
			document.getElementById('txtTelefono').className = "form-control mi-input1"; 
			document.getElementById('txtCelular').className = "form-control mi-input1"; 
		}
		else
		{
			return true;
		}
	}
}


function validateEmail(email) 
{
	  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	  return re.test(email);
}

function LimpiarDatos()
{
	   $('#txtNombre').val("");
	   $('#txtPais').val("");
	   $('#txtCiudad').val("");
	   $('#txtCalle').val("");
	   $('#txtNumInt').val("");
	   $('#txtNumExt').val("");
	   $('#txtColonia').val("");
	   $('#txtDelegacion').val("");
	   $('#txtCp').val("");
	   $('#txtLada').val("");
	   $('#txtTelefono').val("");
	   $('#txtCelular').val("");
	   $('#txtCorreo').val("");
	   $('#txtMessage').val("");
	   document.getElementById('txtNombre').className = "form-control mi-input"; 
	   document.getElementById('txtPais').className = "form-control mi-input";
	   document.getElementById('txtCiudad').className = "form-control mi-input"; 
	   document.getElementById('txtCalle').className = "form-control mi-input"; 
	   document.getElementById('txtNumInt').className = "form-control mi-input";
	   document.getElementById('txtNumExt').className = "form-control mi-input"; 
	   document.getElementById('txtColonia').className = "form-control mi-input"; 
	   document.getElementById('txtDelegacion').className = "form-control mi-input"; 
	   document.getElementById('txtCp').className = "form-control mi-input"; 
	   document.getElementById('txtLada').className = "form-control mi-input";
	   document.getElementById('txtTelefono').className = "form-control mi-input"; 
	   document.getElementById('txtCelular').className = "form-control mi-input"; 
	   document.getElementById('txtCorreo').className = "form-control mi-input"; 
	   document.getElementById('txtMessage').className = "form-control mi-input";
}


function isNumberKey(evt)
{
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57))
    {
        return false;
    }
    else
    {
    	document.getElementById('txtTelefono').className = "form-control mi-input"; 
    	document.getElementById('txtCelular').className = "form-control mi-input";
    	return true;
    }
}
