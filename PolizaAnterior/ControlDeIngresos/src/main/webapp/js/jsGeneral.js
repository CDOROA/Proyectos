/***   VALIDAR SESSION DEL USUARIO  ***/
function validarSessionDelUsuario() 
{
	//Se valida la session desde el servlet
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


function ObtenerFechaActualFormatoGuiones()
{
	var fecha = new Date();
	let dia = String(fecha.getDate()).padStart(2, '0');
	let mes = String(fecha.getMonth() + 1).padStart(2, '0'); 
	let year = fecha.getFullYear();

	fecha = year  + '-' + mes + '-' + dia;
	return fecha;
}



/***   DAR FORMATO DE NUMERO  ***/
function convertirFloat(valor)
{
	return parseFloat(valor.replace(",", "")); 
}


/***  MONITOREA EL SEMAFORO DE INGRESOS  ***/
function inicializarSessionDelSemaforoDeIngresos()
{
	$.ajax({
	    url :'ControlDeIngresosServlet', 
	    data : "vista=OtrosIngresos.jsp&operacion=inicializaSemaforo" , 
	    type : 'POST',
	    dataType : 'text',
	    success : function(json)
	    { 
	    	
	    	var dtSemaforo=json.split('&')
	    	$('#lb_importe_actual').text("$ " +dtSemaforo[0]);
	    	$('#lb_importe_minimo').text(dtSemaforo[1]);
	    	$('#lb_importe_maximo').text(dtSemaforo[2]);
	    	
	    	aplicarValoresAlSemaforo(dtSemaforo[0].replace(',','').replace(',','').replace(',','').replace('$ ',''), 
					 dtSemaforo[1].replace(',','').replace(',','').replace(',','').replace('Limite: $',''), 
					 dtSemaforo[2].replace(',','').replace(',','').replace(',','').replace('Maximo: $',''));  
	    	validarImportesDeSemaforoInicial(dtSemaforo);
	    	
		},
		error : function(xhr, status, error) 
		{
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else
				alert('Error al generar semaforo')
		}
	});
}

function validarImportesDeSemaforoInicial(dtSemaforo)
{	
	let unameUsu=$("#lbUname_br_usu").text();	
	let unameBrUsu=$("#lbUname_usu").text();	
	if(unameUsu != unameBrUsu)
	{
		let importeMaximo =  parseFloat(dtSemaforo[2].replace(',','').replace(',','').replace(',','').replace('Maximo: $',''))
		let importeAct =  parseFloat(dtSemaforo[0].replace(',','').replace(',','').replace(',','').replace('$ ',''))
		if(importeAct >= importeMaximo)
		{
			$("#dgIngresos").jsGrid("fieldOption", "btnReImprimir", "visible", false);
			$("#dgIngresos").jsGrid("fieldOption", "btnRevertirIngreso", "visible", false);
			$("#dgIngresos").jsGrid("fieldOption", "btnCancelar", "visible", false);
			$("#dgIngresos").jsGrid("fieldOption", "btnImprimir", "visible", false);
			$("#dgIngresos").jsGrid("option", "editing", false);
			
			$("#mm_ConfirmaEgresos").addClass("disabledMenu");
			$("#mm_ChequesPosfechados").addClass("disabledMenu");
			$("#mm_ChequeDevuelto").addClass("disabledMenu");
			$("#mm_MantoCheques").addClass("disabledMenu");
			//$("#mm_PagosCaja").addClass("disabledMenu");
			$("#mm_OtrosPagos").addClass("disabledMenu");
			$("#mm_Panamericano").addClass("disabledMenu");
			$("#mm_Poliza").addClass("disabledMenu");
			$("#mm_ConsultaCortes").addClass("disabledMenu");
			document.getElementById("mm_ConfirmaEgresos").disabled = true
			document.getElementById("mm_ChequesPosfechados").disabled = true;
			document.getElementById("mm_ChequeDevuelto").disabled = true;
			document.getElementById("mm_MantoCheques").disabled = true;
			//document.getElementById("mm_PagosCaja").disabled = true;
			document.getElementById("mm_OtrosPagos").disabled = true;
			document.getElementById("mm_Panamericano").disabled = true;
			document.getElementById("mm_Poliza").disabled = true;
			document.getElementById("mm_ConsultaCortes").disabled = true;
			$("#lbInformacionSemaforo").text('Se ha sobrepasado el efectivo permitido, realiza un Corte de Caja.')
		}
		else
		{
			$("#mm_ConfirmaEgresos").addClass("EnableMenu");
			$("#mm_ChequesPosfechados").addClass("EnableMenu");
			$("#mm_ChequeDevuelto").addClass("EnableMenu");
			$("#mm_MantoCheques").addClass("EnableMenu");
			$("#mm_PagosCaja").addClass("EnableMenu");
			$("#mm_OtrosPagos").addClass("EnableMenu");
			$("#mm_Panamericano").addClass("EnableMenu");
			$("#mm_Poliza").addClass("EnableMenu");
			$("#mm_ConsultaCortes").addClass("EnableMenu");
			document.getElementById("mm_ConfirmaEgresos").disabled = false
			document.getElementById("mm_ChequesPosfechados").disabled = false;
			document.getElementById("mm_ChequeDevuelto").disabled = false;
			document.getElementById("mm_MantoCheques").disabled = false;
			document.getElementById("mm_PagosCaja").disabled = false;
			document.getElementById("mm_OtrosPagos").disabled = false;
			document.getElementById("mm_Panamericano").disabled = false;
			document.getElementById("mm_Poliza").disabled = false;
			document.getElementById("mm_ConsultaCortes").disabled = false;
			$("#lbInformacionSemaforo").text('')
		}
	}
	else
	{
		$("#mm_ConfirmaEgresos").addClass("EnableMenu");
		$("#mm_ChequesPosfechados").addClass("EnableMenu");
		$("#mm_ChequeDevuelto").addClass("EnableMenu");
		$("#mm_MantoCheques").addClass("EnableMenu");
		$("#mm_PagosCaja").addClass("EnableMenu");
		$("#mm_OtrosPagos").addClass("EnableMenu");
		$("#mm_Panamericano").addClass("EnableMenu");
		$("#mm_Poliza").addClass("EnableMenu");
		$("#mm_ConsultaCortes").addClass("EnableMenu");
		document.getElementById("mm_ConfirmaEgresos").disabled = false
		document.getElementById("mm_ChequesPosfechados").disabled = false;
		document.getElementById("mm_ChequeDevuelto").disabled = false;
		document.getElementById("mm_MantoCheques").disabled = false;
		document.getElementById("mm_PagosCaja").disabled = false;
		document.getElementById("mm_OtrosPagos").disabled = false;
		document.getElementById("mm_Panamericano").disabled = false;
		document.getElementById("mm_Poliza").disabled = false;
		document.getElementById("mm_ConsultaCortes").disabled = false;
		$("#lbInformacionSemaforo").text('')
	}
}



function aplicarValoresAlSemaforo( EfectivoActual, EfectivoLimiteMinimo, EfectivoLimiteMaximo)
{
	if(EfectivoActual == ".00")
		EfectivoActual= 0
	if(EfectivoLimiteMinimo == ".00")
		EfectivoLimiteMinimo= 0
		
   let barra = document.getElementById("divBarraDeIngresos");
   let porcentaje = calculaPorcentajeDelSemaforo(EfectivoActual,EfectivoLimiteMinimo)
   
   if(porcentaje >= 100)
   {
	   $(barra).css('background-color', '#DC143C');
	   $("#lb_importe_actual").css('color', '#DC143C');
   }
   else
   {
	   $("#lb_importe_actual").css('color', '#2E8B57');
	   $(barra).css('background-color', '#32CD32');
   }
	  
   
   if(porcentaje > 200)
	   porcentaje=200
	   
   barra.style.width = porcentaje + '%';
   barra.innerHTML = porcentaje * 1 + '%';
}

function calculaPorcentajeDelSemaforo(EfectivoActual, EfectivoLimiteMinimo)
{
	let porcentaje = (parseInt(EfectivoActual) * 100) / parseInt(EfectivoLimiteMinimo);
	return parseInt(porcentaje);
}


function ocultarMenu()
{
	alert($("#menuDesplegable").is(":visible"));
	if($("#menuDesplegable").is(":visible") == true)
	{
		OcultarDiv('menuDesplegable');
	}
	else
	{
		MostrarDiv('menuDesplegable');
	}
}


function configurarMenuPrincipalXPerfilesUsuario()
{
	let nivelUsuario=$("#lbNivel_usuario").text();
	let datoNumerico = $("#lbDatoNumerico").text();	
	let uname_usu =$("#lbUname_usu").text();	
	let uname_br_usu=$("#lbUname_br_usu").text();	
	
	
	if(nivelUsuario == 0) /*CAJA ADMINISTRATIVA*/
	{
		/**** MenuPrincipal ****/
		MostrarDiv('tdIngresos');
		MostrarDiv('tdEgresos');
		MostrarDiv('tdOtrosIngresos');
		MostrarDiv('tdChequesDevueltos');
		MostrarDiv('tdCorteDeCaja');
		MostrarDiv('tdCorteDePanamericano');
		MostrarDiv('tdCorteDePoliza');
		MostrarDiv('tdMantocheques');
		if(uname_usu != uname_br_usu) /*BODEGA REGIONAL*/
		{
			OcultarDiv('tdLineaBancaria');
			OcultarDiv('tdChequesPosfechados');
			OcultarDiv('tdMantocheques');
		}
	}
	else if (nivelUsuario == 1) /*CREDITO Y COBRANZA*/
	{
		/**** MenuPrinicpal ****/
		OcultarDiv('tdEgresos');
		OcultarDiv('tdOtrosIngresos');
		OcultarDiv('tdChequesDevueltos');
		OcultarDiv('tdCorteDeCaja');
		OcultarDiv('tdCorteDePanamericano');
		OcultarDiv('div_botonGeneraPolDia');
		MostrarDiv('tdMantocheques');	
	}	
	
	else if (nivelUsuario == 2)/*CONTABILIDAD*/
	{
		/**** MenuPrinicpal ****/
		//OcultarDiv('tdIngresos');
		//OcultarDiv('tdEgresos');
		OcultarDiv('tdOtrosIngresos');
		OcultarDiv('tdChequesPosfechados');
		OcultarDiv('tdChequesDevueltos');
		OcultarDiv('tdCorteDeCaja');
		OcultarDiv('tdCorteDePanamericano');
		OcultarDiv('tdCorteDePoliza');
		MostrarDiv('tdMantocheques');
		//OcultarDiv('tdCorteDePoliza');		
	}	
}






