/***   VALIDAR SESSION DEL USUARIO  ***/
function validarSessionDelUsuario() 
{
	/*$.ajax({
		    url :'ValidaSessionUsuario', 
		    data : "",
		    type : 'POST',
		    dataType : 'text',
		    success : function(respuesta)
		    { 
		    	if(respuesta == "Session_Invalida")
		    		terminarSessionSalirDelSistema()
			},
			error : function(xhr, status, error)
			{
				alert(xhr.status)
				if (xhr.status === 200)
				{
					terminarSessionSalirDelSistema();
				}	
			}
	});*/
}

function terminarSessionSalirDelSistema()
{
	alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
	window.location.href='/ControlDeIngresos/';
}


/***   COLOCAR FORMATO DE COMAS  ***/
function agregarCommas(importe) {
	importe += '';
    x = importe.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    return x1 + x2;
}


/***   VALIDAR SI ES NUMERO  ***/
function EsNumero(evt) {
	
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if(charCode ==  47)
    	  return false;
    if (charCode > 31 && (charCode <= 45 || charCode > 57)) {
        return false;
    }
    else
    	return true;
}


/***   MOSTRAR/OCULTAR DIVS  ***/
function OcultarDiv(div)
{
	var divOcultar ="#" + div;
	$(divOcultar).hide();
}

function MostrarDiv(div)
{
	var divMostrar ="#" + div;
	$(divMostrar).show();
}


/***   FUNCIONES MENAJAES / ALERTAS  ***/
function mostrarMsjError(mensaje)
{
	MostrarDiv('divMjsError');
	$("#lbMsjError").text(mensaje);
}

function mostrarMsjExito(mensaje)
{
	MostrarDiv('divMjsExito');
	$("#lbMsjExito").text(mensaje);
}

function mostrarMsjInfo(mensaje)
{
	MostrarDiv('divMjsInfo');
	$("#lbMsjInfo").text(mensaje);
}


/***   COLOCAR FECHA DEL SISTEMA ***/
function ObtenerFechaActual()
{
	var fecha = new Date();
	let dia = String(fecha.getDate()).padStart(2, '0');
	let mes = String(fecha.getMonth() + 1).padStart(2, '0'); 
	let year = fecha.getFullYear();

	fecha = dia + '/' + mes + '/' + year;
	return fecha;
}


/***   DAR FORMATO DE NUMERO ***/
function convertirFloat(valor)
{
	return parseFloat(valor.replace(",", "")); 
}


