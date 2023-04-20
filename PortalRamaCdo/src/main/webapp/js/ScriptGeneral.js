
/*****  TERMINA SESSION DEL SISTEMA *****/
function terminarSessionSalirDelSistema()
{
	alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
	window.location.href='http://www.cdoautopartes.com.mx/';
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
function EsNumero(evt,jsonArticulos) {
	
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if(charCode ==  47)
    	  return false;
    if (charCode > 31 && (charCode <= 45 || charCode > 57)) {
        return false;
    }
    if (charCode ==  13)
    	{
    validarExistenciasArticulo(jsonArticulos);
    }
    else
    	return true;
}

function EsNumeroMOD(evt,jsonArticulos) {
	
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if(charCode ==  47)
    	  return false;
    if (charCode > 31 && (charCode <= 45 || charCode > 57)) {
        return false;
    }
    if (charCode ==  13)
    	{
    	validarExistenciasArticuloDesdeImagenMod(jsonArticulos);
    }
    else
    	return true;
}

function EsNumeroDesdeImagen(evt,jsonArticulos) {
	
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if(charCode ==  47)
    	  return false;
    if (charCode > 31 && (charCode <= 45 || charCode > 57)) {
        return false;
    }
    if (charCode ==  13)
    	{
    	validarExistenciasArticuloDesdeImagen(jsonArticulos);
    }
    else
    	return true;
}

/***   VALIDAR SI ES NUMERO O SIGNO  ***/
function EsNumeroOSigno(evt) {
	
    var charCode = (evt.which) ? evt.which : event.keyCode;
    if(charCode ==  47)
    	  return false;
    if(charCode ==  46)
  	  return false;
    if (charCode > 31 && (charCode <= 45 || charCode > 57)) {
        return false;
    }
    else
    	return true;
}


/***   MOSTRAR / OCULTAR DIVS  ***/
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


/***   COLOCAR FECHA DEL SISTEMA  ***/
function ObtenerFechaActual()
{
	var fecha = new Date();
	let dia = String(fecha.getDate()).padStart(2, '0');
	let mes = String(fecha.getMonth() + 1).padStart(2, '0'); 
	let year = fecha.getFullYear();

	fecha = dia + '/' + mes + '/' + year;
	return fecha;
}

function ObtenerHoraActual()
{
	var horaDia = new Date();
	let hora = String(horaDia.getHours());
	let minuto = String(horaDia.getMinutes()); 
	let segundo = horaDia.getSeconds();

	horaDia = hora + ':' + minuto + ':' + segundo;
	return horaDia;
}


function ObtenerFechaActualMasDias(num)
{
	var fecha = new Date();
	fecha.setDate(fecha.getDate() + num);
	let dia = String(fecha.getDate()).padStart(2, '0');
	let mes = String(fecha.getMonth() + 1).padStart(2, '0'); 
	let year = fecha.getFullYear();

	fecha = dia + '/' + mes + '/' + year;
	return fecha;
}


/***   DAR FORMATO DE NUMERO  ***/
function convertirFloat(valor)
{
	return parseFloat(valor.replace(",", "")); 
}


/*** REPRODUCIR VIDEOS ***/
function reproducirVideo(imagen)
{
	let modal = document.getElementById('myModal');
	let img = document.getElementById(imagen);
	
	let modalImg = document.getElementById("vid");
		modal.style.display = "block";
		modal.style.zIndex = 99999;
		modalImg.src = img.src + "?autoplay=1";
	let span = document.getElementsByClassName("close")[0];
	span.onclick = function() {
		modalImg.src = "";
		modal.style.display = "none";
		modal.style.zIndex = 1;
	}
};

/*** ENCRIPTACION SHA 1 ***/
function encriptarSha1(str_dato) {	       	
	return rstr2hex(rstr_sha1(str_dato));
}

/*** VALIDAR ESTRUCTURA DEL CORREO ***/
function validarEstructuraEmail( email ) 
{
    var regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return regex.test(email) ? true : false;
}

function llamarChat() 
{
	MyG2C.API.chatAsk("Solicitud de ayuda.",10);
}

