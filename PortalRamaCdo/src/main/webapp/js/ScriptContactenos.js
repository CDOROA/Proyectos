function limpiarCamposContacto()
{
	$("#txt_nombreContacto").val("");
	$("#txt_paternoContacto").val("");
	$("#txt_maternoContacto").val("");
	$("#txt_emailContacto").val("");
	$("#txt_telefonoContacto").val("");
	$("#txt_mensajeContacto").val("");
	$("txt_clienteContacto").val("");
	$("#select_estadoContacto").val("0");	
	$("#select_tipoNegocio").val("1");	
}


/*** INSERTA REGISTRO DE CONTACTENOS ***/
function insertaRegistroContactenos(nombre,paterno,materno,email,cliente,radio,mensaje,telefono,estado,tipoNegocio,nombreTipoNegocio) 
{
	let esCliente = "0";
	let Numcliente = "0";
	if (radio == "radio_siContacto"){
		esCliente ="1";
	}
	
	if (cliente.length > 0){
		Numcliente = cliente;
	}
	
	$.ajax({
	    url :'Contactenos', 
	    data :  'vista=Contactenos.jsp&operacion=RegistraContacto&nombre='+nombre+'&apellido_paterno='+paterno+'&apellido_materno='+materno+'&telefono='+telefono+'&correo='+
	    		email+'&num_cli='+Numcliente+'&id_estado='+estado+'&esCliente='+esCliente+'&mensaje='+mensaje+'&tipoNegocio='+tipoNegocio + '&nombreTipoNegocio=' + nombreTipoNegocio ,
	    type : 'POST',
	    dataType : 'Text', 
	    success : function(respuesta)
	    { 
	        if(respuesta)
        	{
	        	msjCorrecto("Sus datos fueron enviados correctamente.")
	        	limpiarCamposContacto();
        	}
	        else
        	{
	        	msjError("Error al enviar los datos, por favor intentarlo mas tarde.")
        	}
	    
		},
		error : function(xhr, status, error)
		{
			if (xhr.status === 200)
			{
				msjError("Error al enviar correo")
			}
		}
	});
	
}


function validarInformacioncontacto()
{
	
	let comboTipoNegocio = document.getElementById("select_tipoNegocio");
	let nombreTipoNegocio = comboTipoNegocio.options[comboTipoNegocio.selectedIndex].text;
	let nombre = $("#txt_nombreContacto").val();
	let paterno = $("#txt_paternoContacto").val();
	let materno = $("#txt_maternoContacto").val();
	let email = $("#txt_emailContacto").val();
	let cliente = $("#txt_clienteContacto").val();
	let mensaje = $("#txt_mensajeContacto").val();
	let telefono = $("#txt_telefonoContacto").val();
	let estado = $("#select_estadoContacto").val();
	let tipoNegocio = $("#select_tipoNegocio").val();
	let radio = $('input:radio[name=radioClienteContacto]:checked').val();
	let aux = 0;
	let arrayVal = [nombre,paterno,materno,mensaje];
	arrayVal.forEach(function(elemento, indice, array) 
	{
		if (aux == 0)
		{
			if (elemento == "")
	    	{
				obtenerMensaje(indice);
				aux++;
			}
		}
	})
	if (aux == 0) 
	{
		if (telefono != "")
		{
			if (telefono.length  < 10 )
			{
				msjAdvertencia("El telefono debe tener 10 digitos")
				aux++;
				return false;
			}
		}
		else
		{
			aux++;
			msjAdvertencia("Ingrese su numero de telefono a 10 digitos")
			return false;
		}
		
		if (radio == "radio_siContacto")
		{
			if (cliente == "")
			{
				aux++;
				msjAdvertencia("Ingrese su numero cliente en CDO-ROA")
				return false;
			}
		}
		if (email != "")
		{
			if (!validarEstructuraEmail(email))
			{
				msjAdvertencia("El email ingresado no es valido")
				return false;
				aux++;
			}
		}
		else
		{
			msjAdvertencia("Ingrese su email")
			return false;
			aux++;
		}
	}	
	if (aux == 0) 
	{
		insertaRegistroContactenos(nombre,paterno,materno,email,cliente,radio,mensaje,telefono,estado,tipoNegocio,nombreTipoNegocio);
	}
}


function msjAdvertencia(msj)
{
	ocultarMsj()
	$("#divAdvertenciaContactenos").show()
	$("#msjAdvertenciaContactenos").text(msj)
}

function msjCorrecto(msj)
{
	ocultarMsj()
	$("#divCorrectoContactenos").show()
	$("#msjCorrectoContactenos").text(msj)
}

function msjError(msj)
{
	ocultarMsj()
	$("#divErrorContactenos").show()
	$("#msjErrorContactenos").text(msj)
}

function ocultarMsj()
{
	$("#divAdvertenciaContactenos").hide()
	$("#divCorrectoContactenos").hide()
	$("#divErrorContactenos").hide()
}

function obtenerMensaje(indice) 
{
	switch (indice) 
	{
	case 0:
		msjAdvertencia("Ingrese su nombre completo")
		break;
	case 1:
		msjAdvertencia("Ingrese su apellido paterno")
	break;
	case 2:
		msjAdvertencia("Ingrese su apellido materno")
	break;
	case 3:
		msjAdvertencia("Por favor capture sus dudas o comentarios")
	break;
	default:
		break;
	}
}

function cerrarFormularioContacto() 
{
	$('#modalFormulario').modal('hide');
	if ($('.modal-backdrop').is(':visible')) {
	  $('body').removeClass('modal-open'); 
	  $('.modal-backdrop').remove(); 
	};
}






/*** VALIDA SI ES CLIENTE DE CDO ***/
function ocultarClienteContacto() 
{
	$("#div_txt_clienteContacto").hide();
}

function mostrarClienteContacto() 
{
	$("#div_txt_clienteContacto").show();
}