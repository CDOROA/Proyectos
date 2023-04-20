function MostrarMensjes()
{
	document.getElementById('cargando').style.display = 'block';

	$.ajax({
	    url :'CentroDeMensajes', 
	    data : "operacion=ConsultaMensajes", 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	ProcesaMensajesJson(json);
	    	
	    	$( function() {
    		    $( "#tabs" ).tabs();
    		  } );
	    	
	    	document.getElementById('cargando').style.display = 'none';
	    	
	    	MostrarDiv('divCentroMEnsajes');
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			alert('Servicio de mensajes no disponible, favor de intentar mas tarde.')
			
			
			
		}
	});
}

function ProcesaMensajesJson(json)
{
	 
	$('#divContenedorMensajesPendientes').empty();
	$('#divContenedorMensajesLeidos').empty();
	
	$("#CentroMensajesBtnCerrar").attr('onClick', 'OcultarDiv("divCentroMEnsajes");');
	
	if(json.status == 5)
	{
		var datos = json.datos[0];
		$("#lblCentroMensajesTotal").text("( " + datos.pendientes + " )" ) 
		$("#lblCentroMensajesPenditnes").text("Pendientes: " + datos.pendientes ) 
		$("#lblCentroMensajesLeidos").text("Leidos: " + datos.leidos )
		
		var src1='images/mailBlue.png';
		
		if (datos.pendientes > 0)
		{
			src1='images/mailRed.png'
			$("#imgCentroMensajes").attr("src", src1);
			generaDivMenajesPendientes(datos.msjPendientes);
		}
		if (datos.leidos > 0)
		{
			generaDivMenajesLeidos(datos.msjLeidos);
		}
		
	}		 
}
/* Mensajes pendientes por leer.*/
function generaDivMenajesPendientes(json)
{
	$('#divContenedorMensajesPendientes').empty();
	var contenido= "";
	var Mensajes = "";
	for(let i=0; i < json.length ; i++)
	{
		var registro = json[i]; 
		contenido += '<div class="d-flex text-muted pt-3">';
		contenido += generaVinetaPendientes(json[i]);
		
		contenido += '<div class="pb-3 mb-0 small lh-sm border-bottom w-100">';
		contenido += generaMensajePendientes(json[i]);
	//	contenido += generaBotonPendientes(json[i]);
		contenido += '</div></div></div>';
		
		if(Mensajes == "")
		{
			Mensajes  = Mensajes + json[i].id;
		}
		else{
			Mensajes = Mensajes +  "-" + json[i].id;	
		}
	}
	var msn = Mensajes;
 
	$("#CentroMensajesBtnCerrar").attr('onClick', 'cerrarCentroMensaje("'+ msn +'", 1);');
 
	$('#divContenedorMensajesPendientes').append(contenido);
}
function generaVinetaPendientes(json)
{
	var contenido= "";
	/*contenido=  '<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded"' +
		'width="32" height="32" xmlns="http://www.w3.org/2000/svg"'+
		'role="img" aria-label="Placeholder: 32x32"'+
		'preserveAspectRatio="xMidYMid slice" focusable="false">'+
		'<title>Placeholder</title><rect width="100%" height="100%"'+
		'	fill="#b8daff"></rect>'+
		'<text x="50%" y="50%" dy=".3em" >'+ json.id +'</text></svg>';*/
	contenido= '<label  style="width:32px; height:32px; background-color: #cce5ff; text-align: center;  padding: 4px;  border-radius: 5px; color:#6c757d; font-size: 16px; font-weight: bolder;" >' +
		json.id + '</label>';
	return contenido;
}
function generaMensajePendientes(json)
{
	var contenido= "";
	contenido= '<div class="d-flex justify-content-between">'+
	'<strong class="text-gray-dark"> <p style="margin-bottom: 0px;margin-left: 16px;" ><p style="margin-bottom: 0px;margin-left: 16px;" >' +
	json.mensaje + 
	'</p></strong>  ';

return contenido;
}
function generaBotonPendientes(json)
{
	var contenido= "";
	/*
	contenido= '<a href="#">Follow</a> ';
*/
	contenido= '<button type="button" class="btn btn-outline-primary">Marcar como Leido</button>'
return contenido;	
}

/* Mensajes ya leidos.*/
function generaDivMenajesLeidos(json)
{
	$('#divContenedorMensajesLeidos').empty();
	var contenido= "";
	for(let i=0; i < json.length ; i++)
	{
		var registro = json[i]; 
		contenido += '<div id="centroMejsatesId-' + json[i].id + '" class="d-flex text-muted pt-3">';
		contenido += generaVinetaLeidos(json[i]);
		
		contenido += '<div class="pb-3 mb-0 small lh-sm border-bottom w-100">';
		contenido += generaMensajeLeidos(json[i]);
		contenido += generaBotonLeidos(json[i]);
		contenido += '</div></div></div>';
	}
	$('#divContenedorMensajesLeidos').append(contenido);
}
function generaVinetaLeidos(json)
{
	var contenido= "";
	/*contenido=  '<svg class="bd-placeholder-img flex-shrink-0 me-2 rounded"' +
		'width="32" height="32" xmlns="http://www.w3.org/2000/svg"'+
		'role="img" aria-label="Placeholder: 32x32"'+
		'preserveAspectRatio="xMidYMid slice" focusable="false">'+
		'<title>Placeholder</title><rect width="100%" height="100%"'+
		'	fill="#b8daff"></rect>'+
		'<text x="50%" y="50%" dy=".3em" >'+ json.id +'</text></svg>';
	
	*/
	contenido= '<label  style="width:32px; height:32px; background-color: #cce5ff; text-align: center;  padding: 4px;  border-radius: 5px; color:#6c757d; font-size: 16px; font-weight: bolder;" >' +
	json.id + '</label>';
	return contenido;
}
function generaMensajeLeidos(json)
{
	var contenido= "";
	contenido= '<div class="d-flex justify-content-between">'+
	'<strong class="text-gray-dark"> <p style="margin-bottom: 0px;margin-left: 16px;" ><p style="margin-bottom: 0px;margin-left: 16px;" >' +
	json.mensaje + 
	'</p></strong>  ';

return contenido;
}
function generaBotonLeidos(json)
{
	var contenido= "";
	contenido= '<button type="button" class="btn btn-outline-danger" onclick="OcultarCentroMensaje(' + json.id  + ', 2 )" >no mostrar</button>';

return contenido;	
}

/* Evento de Cerrar Centro de Mensajes*/
function cerrarCentroMensaje(mensajes, est)
{	
	var src1='images/mailBlue.png'

    	$("#imgCentroMensajes").attr("src", src1);
    	$("#lblCentroMensajesTotal").text("(0)");
    	
	$.ajax({
	    url :'CentroDeMensajes', 
	    data : "operacion=ActualizaMensajes&estatus="+ est +"&mensajes=" + mensajes, 
	    type : 'POST',
	    dataType : 'text',
	    success : function(json)
	    { 
	    	var src1='images/mailBlue.png'

	    	$("#imgCentroMensajes").attr("src", src1);
	    	$("#lblCentroMensajesTotal").text("(0)");
 
		},
		error : function(xhr, status, error)
		{
 
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='http://www.cdoautopartes.com.mx/';
			}

		}
	});
	
	
	OcultarDiv('divCentroMEnsajes');
	// document.getElementById('cargando').style.display = 'none';
}

function OcultarCentroMensaje(mensajes, est)
{	
	var renglon = '#centroMejsatesId-'+mensajes;
	$(renglon).attr("class", "");
	$(renglon).hide("drop");
	//document.getElementById(renglon).style.display = 'none';
	
	
	
	$.ajax({
	    url :'CentroDeMensajes', 
	    data : "operacion=ActualizaMensajes&estatus="+ est +"&mensajes=" + mensajes, 
	    type : 'POST',
	    dataType : 'text',
	    success : function(json)
	    { 
	    	
		},
		error : function(xhr, status, error)
		{
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='http://www.cdoautopartes.com.mx/';
			}

		}
	});
	
}


function consultaHedarCentroMensajes() {
	
	
	
	$.ajax({
	    url :'CentroDeMensajes', 
	    data : "operacion=ConsultaNuevosMensajes", 
	    type : 'POST',
	    dataType : 'text',
	    success : function(json)
	    { 

	    	  var src1='images/mailBlue.png'
	    	  if(json > 0)
    		  {
	    		src1='images/mailRed.png';
    		  }
	    	  $("#imgCentroMensajes").attr("src", src1);
    		  $("#lblCentroMensajesTotal").text("( "+json+" )");
		},
		error : function(xhr, status, error)
		{
			alert('status: ' + status);
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='http://www.cdoautopartes.com.mx/';
			}
	
		}
	});
	
	setTimeout(function(){consultaHedarCentroMensajes()},300000);
}