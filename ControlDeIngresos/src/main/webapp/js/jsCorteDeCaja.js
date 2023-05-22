function MuestraPanel (div, menu)
{
	var divMostrar ="#" + div;
	var MunuActivo ="#" + menu;
    $(divMostrar).show();
    $(MunuActivo).css('background-color', '#337AB7');
}

function IniciaModuloDeCorteDeCaja(div, menu)
{
	MuestraPanel(div, menu);
	limpiarTablaDeDenominaciones();
	limpiarCampos()
	inicializarSessionDelSemaforoDeIngresos()
	configurarMenuPrincipalXPerfilesUsuario();
}


/**** LIMPIAR CONSTROLES  ****/
function limpiarCampos()
{
	$("#btn_imprimeCorte").hide(); 
	$("#btn_salirCorte").hide(); 
	$("#div_fichaBancaria").hide(); 
	$("#div_tituloImpresion").hide(); 
	$("#btn_confirmaCorte").show(); 
	$("#div_importesEfectivo").show();
	$("#div_titulo").show();
	$("#id_lbCdoCorteCaja").text("");
	$("#id_lbNumCorteCaja").text("");
	$("#id_lbFechaCorteCaja").text("");
	$("#id_lbUsuCorteCaja").text("");
	$('#usuAutorizaEgreso').val("");
	$('#passAutorizaEgreso').val("");
	$("#btn_AtrasfirmaMancomunada").attr("disabled", false);
	$("#btn_AutorizarfirmaMancomunada").attr("disabled", false);
	$("#btn_confirmaCorte").attr("disabled", false);
	
}

function muestraAlertaCorteCaja()
{
	validarSessionDelUsuario();
	MostrarDiv('divAlertaCorteCaja');	
	limpiarTablaDeDenominaciones();
	/*if(parseFloat($("#lbImpTotalPrevioEfectivo").text())< 0)
	{
		alert("No puedes generar un Corte de Caja con un importe menor a 0")	
	}
	else
	{
		MostrarDiv('divAlertaCorteCaja');	
		limpiarTablaDeDenominaciones();
	}*/
}

function limpiarTablaDeDenominaciones()
{
	limpiarTablaDeDenominacionesBilletes()
	limpiarTablaDeDenominacionesMonedas()
}

function limpiarTablaDeDenominacionesBilletes()
{
	 let filasDeLaTablaBilletes=document.querySelectorAll("#tblDenominacionBilletes tbody tr");
	 filasDeLaTablaBilletes.forEach(function(e) {
		 
		 let columnasDeLaTablaBilletes=e.querySelectorAll("td");
		 columnasDeLaTablaBilletes[2].style.display='none'
		 let inputCant= "#" + columnasDeLaTablaBilletes[1].children[0].id;
		 let lbCantFija= "#" + columnasDeLaTablaBilletes[2].children[0].id;
		 let lb_total = "#" + columnasDeLaTablaBilletes[1].children[0].id.replace('id_cantidad','importe');
		 let lb_fajilla100 = "#" + columnasDeLaTablaBilletes[1].children[0].id.replace('id_cantidadDenominacion','fajilla100');
		 let lb_fajilla50 = "#" + columnasDeLaTablaBilletes[1].children[0].id.replace('id_cantidadDenominacion','fajilla50');
		 let lb_fajilla25 = "#" + columnasDeLaTablaBilletes[1].children[0].id.replace('id_cantidadDenominacion','fajilla25');
		 let lb_Suelto = "#" + columnasDeLaTablaBilletes[1].children[0].id.replace('id_cantidadDenominacion','suelto');
		 
		 $(lbCantFija).text("0");
		 $(lb_fajilla100).text("0");
		 $(lb_fajilla50).text("0");
		 $(lb_fajilla25).text("0");
		 $(lb_Suelto).text("0");
		 $(lb_total).text("$ 0.00");
		 $(inputCant).val("0");
		 $("#lbImporteFajillas").text("0.00")
		 
		 var columnaFooter=document.querySelectorAll("#tblDenominacionBilletes tfoot tr td");
		 columnaFooter[0].style.display='none'
	 });
}

function limpiarTablaDeDenominacionesMonedas()
{
	 let filasDeLaTablaMonedas=document.querySelectorAll("#tblDenominacionMonedas tbody tr");
	 filasDeLaTablaMonedas.forEach(function(e) {
		 
		 let columnasDeLaTablaMonedas=e.querySelectorAll("td");
		 columnasDeLaTablaMonedas[2].style.display='none'
		 let  inputCant= "#" + columnasDeLaTablaMonedas[1].children[0].id;
		 let  lbCantFija= "#" + columnasDeLaTablaMonedas[2].children[0].id;
		 let lb_total = "#" + columnasDeLaTablaMonedas[1].children[0].id.replace('id_cantidad','importe');
		 
		 $(inputCant).val("0");
		 $(lbCantFija).text("0");
		 $(lb_total).text("$ 0.00");
		 $("#lbImporteFajillas").text("0.00")
		 var columnaFooter=document.querySelectorAll("#tblDenominacionMonedas tfoot tr td");
		 columnaFooter[0].style.display='none'
		 
	 });
}


/****  CALCULA FIJILLAS X DENOMINACIONES DE MONEDAS  ****/
function calcularDenominacionDeMonedas(id_denominacion, denominacion)
{
	let campoCantidad="#id_cantidadDenominacion_"+ id_denominacion;
	let campoCantfija ="#id_cantidadDenominacionFija_"+ id_denominacion;
	crearVariablesDeDenominacionMoneda();
		
	$(campoCantfija).text($(campoCantidad).val())
	cantidadDenominacionMoneda = $(campoCantidad).val();
	importeDenominacionMoneda =  parseFloat(cantidadDenominacionMoneda * denominacion).toFixed(2);	
	inicializaTotalesDeDenominacionMoneda(id_denominacion);
	calculaimporteTotalDeDenominacion(importeDenominacionMoneda);
}

function crearVariablesDeDenominacionMoneda()
{
	var cantidadDenominacionMoneda = 0;
	var importeDenominacionMoneda = 0.00;
}

function inicializaTotalesDeDenominacionMoneda(id_denominacion)
{
	let campoImporte="#importeDenominacion_" + id_denominacion;
	$(campoImporte).text("$ " + agregarCommas(importeDenominacionMoneda));
}

function validarCampoCantidad(id_denominacion)
{
	let campoCantidad="#id_cantidadDenominacion_"+ id_denominacion;
	if($(campoCantidad).val() == "" )
		$(campoCantidad).val("0")
}


/****  CALCULA FIJILLAS X DENOMINACION DE BILLETES  ****/
function calcularDenominacionDeBilletes(id_denominacion, denominacion)
{
	let campoCantidad="#id_cantidadDenominacion_"+ id_denominacion;
	let campoCantFija="#id_cantidadDenominacionFija_"+ id_denominacion;
	crearVariablesDeDenominacionBilletes();
	
	$(campoCantFija).text($(campoCantidad).val())
	cantidadDenominacion = $(campoCantidad).val();
	importeDenominacion =  parseFloat(cantidadDenominacion * denominacion).toFixed(2);	
	incializavariablesDeDenominacionBilletes(cantidadDenominacion);
	inicializaTotalesDeDenominacionBilletes(id_denominacion);
	calculaimporteTotalDeDenominacion(importeDenominacion);
}

function inicializaTotalesDeDenominacionBilletes(id_denominacion)
{
	let campoImporte="#importeDenominacion_" + id_denominacion;
	let campoFajilla100="#fajilla100_" + id_denominacion;
	let campoFajilla50="#fajilla50_" + id_denominacion;
	let campoFajilla25="#fajilla25_" + id_denominacion;
	let campoSueltos="#suelto_" + id_denominacion;
	
	$(campoImporte).text("$ " + agregarCommas(importeDenominacion));
	$(campoFajilla100).text(fajilla100);
	$(campoFajilla50).text(fajilla50);	
	$(campoFajilla25).text(fajilla25);	
	$(campoSueltos).text(sueltos);
	
}

function incializavariablesDeDenominacionBilletes(cantidad)
{
	fajilla100= Math.floor(cantidad /100);
	cantidad= cantidad % 100;
	
	if(cantidad > 0)
	{
		fajilla50=Math.floor(cantidad /50);
		cantidad= cantidad % 50;
	}
	
	if(cantidad > 0)
	{
		fajilla25=Math.floor(cantidad /25);
		cantidad= cantidad % 25;
	}
	
	if(cantidad > 0)
		sueltos= cantidad;
	else
		sueltos=0;
}

function crearVariablesDeDenominacionBilletes()
{
  var cantidadDenominacion = 0;
  var importeDenominacion = 0.00;
  var importeTotalDeDenominacion=0;
  var fajilla100 = 0;
  var fajilla50=0
  var fajilla25=0;
  var sueltos=0; 
}


/****  CALCULA IMPORTES TOTALES DE DENOMINACIONES  ****/
function calculaimporteTotalDeDenominacion(importeCalculado)
{
	let ImporteTotal=0;
    let filasDeLaTablaBilletes=document.querySelectorAll("#tblDenominacionBilletes tbody tr"); 
    
    filasDeLaTablaBilletes.forEach(function(e) {
 
        let columnasDeLaTablaBilletes=e.querySelectorAll("td");
        let importeBilletes = parseFloat(columnasDeLaTablaBilletes[3].textContent.replace(",","").replace("$","").replace(",","").replace(",","").replace(",",""));
        ImporteTotal+= importeBilletes;
    });
    
    let filasDeLaTablaMonedas=document.querySelectorAll("#tblDenominacionMonedas tbody tr"); 
    
    filasDeLaTablaMonedas.forEach(function(e) {
 
        let columnasDeLaTablaMonedas=e.querySelectorAll("td"); 
        let importeMonedas = parseFloat(columnasDeLaTablaMonedas[3].textContent.replace(",","").replace("$",""));
 
        ImporteTotal+= importeMonedas;
    });
        
    $('#lbImporteFajillas').text(agregarCommas(ImporteTotal.toFixed(2)));
    
}


/****  VALIDA IMPORTE TOTAL DE EFECTIVO VS DENOMINACIONES  ****/
function validaImporteEfectivoVSdenominaciones()
{
	$("#btn_confirmaCorte").attr("disabled", true);
	$('#usuAutorizaEgreso').val("");
	$('#passAutorizaEgreso').val("");
	let importeDenominacion = quitarFormato( $("#lbImpTotalPrevioEfectivo").text());
	let importeFajillasEfectivo= quitarFormato($("#lbImporteFajillas").text());
		
	if(importeDenominacion <= 0)
	{
		solicitarFirmaMancomunada();
	}
	else
	{
		if(importeDenominacion === importeFajillasEfectivo)
		{
			solicitarFirmaMancomunada();
		}	
		else
		{
			alert('La denominaciones ingresadas son incorrectas.')
			$("#btn_confirmaCorte").attr("disabled", false);
		}
	}
	//solicitarFirmaMancomunada();
}

function quitarFormato(importe)
{
	importe  = importe.replace("$","").replace(",","").replace(",","").replace(",","").replace(",","").replace(",","").replace(" ","").replace(" ","");
	return importe;
}

/****  GENERA CORTE DE CAJA EN BD  ****/
function solicitarFirmaMancomunada()
{
	validarSessionDelUsuario();
	MostrarDiv('divFirmaMancomunada');	
}

function ocultaFirmaMacomunada()
{
	OcultarDiv('divFirmaMancomunada')
	$("#btn_confirmaCorte").attr("disabled", false);
}

function validaFirmaMancomunada()
{
	$("#btn_AtrasfirmaMancomunada").attr("disabled", true);
	$("#btn_AutorizarfirmaMancomunada").attr("disabled", true);
	
	validarSessionDelUsuario();
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'ConfirmaEgresos', 
	    data : "vista=ConfirmaEgresos.jsp&operacion=ValidarFirmaMancomunada&cve_usu="+ $('#usuAutorizaEgreso').val() + "&password="+ $('#passAutorizaEgreso').val(), 
	    type : 'POST',
	    dataType : 'Text',
	    success : function(respuesta)
	    { 
	        if(respuesta == 'true')
        	{
	        	document.getElementById('cargando').style.display = 'none';
	        	OcultarDiv('divFirmaMancomunada');
	        	insertaCorteDeCajaEnBD()
        	}
	        else
	        {	
	        	document.getElementById('cargando').style.display = 'none';
	        	alert('Los datos del usuario  no son correctos.');
	        	$("#btn_AtrasfirmaMancomunada").attr("disabled", false);
	        	$("#btn_AutorizarfirmaMancomunada").attr("disabled", false);
        	}
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			$("#btn_AtrasfirmaMancomunada").attr("disabled", false);
        	$("#btn_AutorizarfirmaMancomunada").attr("disabled", false);
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else
				alert('Error al validar firma.')
		}
	});
}

function insertaCorteDeCajaEnBD()
{
	validarSessionDelUsuario();
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'CorteDeCaja', 
	    data : "vista=CorteDeCaja.jsp&operacion=GeneraCorteDeCaja", 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	if(json.length >0 )
	    	{
	    		habilitarDivsDeImpresionDeCorte()
	    		configurarPantallaDeImpresion()
	    		$("#id_lbNumCorteCaja").text(json[0].folio_corte);
	    		$("#id_lbFechaCorteCaja").text(json[0].fecha_corteCaja + " " +json[0].hora_corteCaja );
	    		$("#id_lbUsuCorteCaja").text(json[0].usuario + " - " +json[0].nombre_usuario);
	    		$("#id_lbImporteCorteCaja").text("$ " + agregarCommas(json[0].importe));
	    		document.getElementById('cargando').style.display = 'none';
	    		$("#btn_confirmaCorte").attr("disabled", false);
	    	}
	    	else
	    	{
	    		document.getElementById('cargando').style.display = 'none';
	    		$("#btn_confirmaCorte").attr("disabled", false);
	    	}
		},
		error : function(xhr, status, error) 
		{
			$("#btn_confirmaCorte").attr("disabled", false);
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else
				alert('Error al insertar corte de caja.')
		}
	});
}

function habilitarDivsDeImpresionDeCorte()
{
	$("#btn_imprimeCorte").show();
	$("#div_fichaBancaria").show();
	$("#btn_salirCorte").show(); 
	$("#div_tituloImpresion").show(); 
	$("#btn_confirmaCorte").hide();
	$("#div_importesEfectivo").hide();
	$("#div_titulo").hide();
}

function configurarPantallaDeImpresion()
{
	crearFilaDeTotalesEnTablaDenominacionBilletes()
	crearFilaDeTotalesEnTablaDenominacionMonedas()
	inhabilitarTxtTablaDeDenominacionesMonedas()
	inhabilitarTxtTablaDeDenominacionesBilletes()
}

function inhabilitarTxtTablaDeDenominacionesBilletes()
{
	 let filasDeLaTablaBilletes=document.querySelectorAll("#tblDenominacionBilletes tbody tr");
	 filasDeLaTablaBilletes.forEach(function(e) {
		 
		 let columnasDeLaTablaBilletes=e.querySelectorAll("td");
		 columnasDeLaTablaBilletes[2].style.display='block'
	     columnasDeLaTablaBilletes[1].style.display='none'
	 });
}

function inhabilitarTxtTablaDeDenominacionesMonedas()
{
	 let filasDeLaTablaMonedas=document.querySelectorAll("#tblDenominacionMonedas tbody tr");
	 filasDeLaTablaMonedas.forEach(function(e) {
		 
		 let columnasDeLaTablaMonedas=e.querySelectorAll("td");
		 columnasDeLaTablaMonedas[2].style.display='block'
	     columnasDeLaTablaMonedas[1].style.display='none'
	 });
}

function crearFilaDeTotalesEnTablaDenominacionBilletes()
{
	let totalCant=0
	let totalImp=0
	let totalFajilla100=0
	let totalFajilla50=0
	let totalFajilla25=0
	let suelto=0
	
	let filasDeLaTablaBilletes=document.querySelectorAll("#tblDenominacionBilletes tbody tr");
	filasDeLaTablaBilletes.forEach(function(e) {
		 
		 let columnas=e.querySelectorAll("td");
		 totalCant += parseFloat(columnas[2].textContent);
		 totalImp += parseFloat(quitarFormato(columnas[3].textContent));
		 totalFajilla100 += parseFloat(columnas[4].textContent);
	     totalFajilla50 += parseFloat(columnas[5].textContent);
		 totalFajilla25 += parseFloat(columnas[6].textContent);
		 suelto += parseFloat(columnas[7].textContent);
	});
	
	var columnaFooter=document.querySelectorAll("#tblDenominacionBilletes tfoot tr td");
	columnaFooter[0].style.display='block'
	columnaFooter[1].style.display='none'
	columnaFooter[1].textContent=agregarCommas(totalCant);
	columnaFooter[2].textContent=agregarCommas(totalCant);
	columnaFooter[3].textContent="$ "+ agregarCommas(totalImp.toFixed(2));
	columnaFooter[4].textContent=agregarCommas(totalFajilla100);
	columnaFooter[5].textContent=agregarCommas(totalFajilla50);
	columnaFooter[6].textContent=agregarCommas(totalFajilla25);
	columnaFooter[7].textContent=agregarCommas(suelto);
}

function crearFilaDeTotalesEnTablaDenominacionMonedas()
{
	let totalCant=0
	let totalImp=0
	
	
	let filasDeLaTablaBilletes=document.querySelectorAll("#tblDenominacionMonedas tbody tr");
	filasDeLaTablaBilletes.forEach(function(e) {
		 
		 let columnas=e.querySelectorAll("td");
		 totalCant += parseFloat(columnas[2].textContent);
		 totalImp += parseFloat(quitarFormato(columnas[3].textContent));
		
	});
	
	var columnaFooter=document.querySelectorAll("#tblDenominacionMonedas tfoot tr td");
	columnaFooter[0].style.display='block'
	columnaFooter[1].style.display='none'
	columnaFooter[1].textContent=agregarCommas(totalCant);
	columnaFooter[2].textContent=agregarCommas(totalCant);
	columnaFooter[3].textContent="$ "+  agregarCommas(totalImp.toFixed(2));
	
}

function terminarCorteDeCaja()
{
	validarSessionDelUsuario();
	OcultarDiv('divAlertaCorteCaja');
	$.ajax({
	    url :'CorteDeCaja', 
	    data : "vista=Menu.html", 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
		},
		error : function(xhr, status, error) 
		{
		}
	});
}


/***   REDONDEAR CENTAVOS  ***/
function muestraAlertaRedondearCentavos()
{
	validarSessionDelUsuario();
	consultaRedondeosExisentes();
}

function configuraMuestraAlertaRedondeo()
{
	validaQueCentavosMostrar();
	limpiarVariablesRedondeo()
	MostrarDiv('divAlertaRedondeoCentavos');
}

function validaRedondeoCentavos()
{
	let tipoRedondeo = obtenerTipoDeRedondeo();
	let monedaARedondear = obtenerMonedaRedondeo();	
	
	if(monedaARedondear === 999)
	{
		alert("Selecciona a cuantos centavos deseas redondear")
	}
	else
	{
		let importeActual = quitarFormato($("#lbImpTotalEfectivoRedondeo").text());
		let importeConRedondeo = obtieneimporteConRedondeo (importeActual,monedaARedondear, tipoRedondeo) 
		let importeMovimientoAplicar = obtieneImporteDelMovimientoAplicar(tipoRedondeo , importeActual,importeConRedondeo);
															
		$("#msjTipoRedondeo").text(tipoRedondeo);
		$("#msjImporteMovimientoAplicarRedondeo").text("$ " + importeMovimientoAplicar);
		$("#msjImporteConRedondeo").text("$ " + importeConRedondeo);
		MostrarDiv('divConfirmaRedondeo');
	}
}

function obtieneimporteConRedondeo(importeActual, monedaARedondear, tipoRedondeo)
{
	let arrayImporteAct= importeActual.split(".");	
	let importeConRedondeo = arrayImporteAct[0] + "." + parseFloat(monedaARedondear);
	if(tipoRedondeo === "Otro Ingreso" && monedaARedondear === 0)
	{
		importeConRedondeo = parseFloat(importeConRedondeo) + 1;
	}
	return importeConRedondeo;
}

function obtieneImporteDelMovimientoAplicar(tipoRedondeo,importeActual, importeConRedondeo)
{
	let importeMovimientoAplicar = 0;
	if(tipoRedondeo === "Egreso")
	{
		importeMovimientoAplicar = parseFloat(importeActual) - parseFloat(importeConRedondeo);
	}
	else
	{
		importeMovimientoAplicar = parseFloat(importeConRedondeo) - parseFloat(importeActual);
	}
	return parseFloat(importeMovimientoAplicar).toFixed(2);
}

function obtenerTipoDeRedondeo()
{
	let tipoRedondeo = "" ;
	 $('#cbxsTiposRedondeo input:checked').each(function () {
	        let tipo = $(this).attr('id');
	        
	        if(tipo === "TMas")
	        	tipoRedondeo = "Otro Ingreso";
	        if(tipo === "TMenos")
	        	tipoRedondeo = "Egreso";
	    });
	 return tipoRedondeo;
}

function obtenerMonedaRedondeo()
{
	let monedaRedondeo = 999 ;
	 $('#cbxsMonedasRedondeo input:checked').each(function () {
	        let tipo = $(this).attr('id');
	        
	        if(tipo === "Moneda10")
	        	monedaRedondeo = 10;
	        if(tipo === "Moneda20")
	        	monedaRedondeo = 20;
	        if(tipo === "Moneda30")
	        	monedaRedondeo = 30;
	        if(tipo === "Moneda40")
	        	monedaRedondeo = 40;
	        if(tipo === "Moneda50")
	        	monedaRedondeo = 50;
	        if(tipo === "Moneda60")
	        	monedaRedondeo = 60;
	        if(tipo === "Moneda70")
	        	monedaRedondeo = 70;
	        if(tipo === "Moneda80")
	        	monedaRedondeo = 80;
	        if(tipo === "Moneda90")
	        	monedaRedondeo = 90;
	        if(tipo === "Moneda0")
	        	monedaRedondeo = 00;
	    });
	 return monedaRedondeo;
}

function validaQueCentavosMostrar()
{
	let importeActual = quitarFormato($("#lbImpTotalEfectivoRedondeo").text());
	let arrayImporteAct = importeActual.split(".");	
	let cetavosActuales= "0." + arrayImporteAct[1];
	let tipoRendondeo= obtenerTipoDeRedondeo();
	mostrarOcultarCentavos(tipoRendondeo, cetavosActuales)
	limpiarVariablesRedondeo();
}

function mostrarOcultarCentavos(tipoRendondeo, cetavosActuales)
{
	if(tipoRendondeo == "Egreso")
	{
		mostrarOcultarEgresos(cetavosActuales)
	}
	else
	{
		mostrarOcultarOtrosIngresos(cetavosActuales)
	}
}

function mostrarOcultarOtrosIngresos(cetavosActuales)
{
	if(0.10 > cetavosActuales )
		MostrarDiv('div_Moneda10');	
	else
		OcultarDiv('div_Moneda10');
	
	if(0.20 > cetavosActuales )
		MostrarDiv('div_Moneda20');	
	else
		OcultarDiv('div_Moneda20');
	
	if(0.30 > cetavosActuales )
		MostrarDiv('div_Moneda30');	
	else
		OcultarDiv('div_Moneda30');
	
	if(0.40 > cetavosActuales )
		MostrarDiv('div_Moneda40');	
	else
		OcultarDiv('div_Moneda40');
	
	if(0.50 > cetavosActuales )
		MostrarDiv('div_Moneda50');	
	else
		OcultarDiv('div_Moneda50');
	
	if(0.60 > cetavosActuales )
		MostrarDiv('div_Moneda60');	
	else
		OcultarDiv('div_Moneda60');
	
	if(0.70 > cetavosActuales )
		MostrarDiv('div_Moneda70');	
	else
		OcultarDiv('div_Moneda70');
	
	if(0.80 > cetavosActuales )
		MostrarDiv('div_Moneda80');	
	else
		OcultarDiv('div_Moneda80');
	
	if(0.90 > cetavosActuales )
		MostrarDiv('div_Moneda90');	
	else
		OcultarDiv('div_Moneda90');
}

function mostrarOcultarEgresos(cetavosActuales)
{
	if(0.10 < cetavosActuales )
		MostrarDiv('div_Moneda10');	
	else
		OcultarDiv('div_Moneda10');
	
	if(0.20 < cetavosActuales )
		MostrarDiv('div_Moneda20');	
	else
		OcultarDiv('div_Moneda20');
	
	if(0.30 < cetavosActuales )
		MostrarDiv('div_Moneda30');	
	else
		OcultarDiv('div_Moneda30');
	
	if(0.40 < cetavosActuales )
		MostrarDiv('div_Moneda40');	
	else
		OcultarDiv('div_Moneda40');
	
	if(0.50 < cetavosActuales )
		MostrarDiv('div_Moneda50');	
	else
		OcultarDiv('div_Moneda50');
	
	if(0.60 < cetavosActuales )
		MostrarDiv('div_Moneda60');	
	else
		OcultarDiv('div_Moneda60');
	
	if(0.70 < cetavosActuales )
		MostrarDiv('div_Moneda70');	
	else
		OcultarDiv('div_Moneda70');
	
	if(0.80 < cetavosActuales )
		MostrarDiv('div_Moneda80');	
	else
		OcultarDiv('div_Moneda80');
	
	if(0.90 < cetavosActuales )
		MostrarDiv('div_Moneda90');	
	else
		OcultarDiv('div_Moneda90');
}

function limpiarVariablesRedondeo()
{
	$("#msjTipoRedondeo").text("");
	$("#msjImporteMovimientoAplicarRedondeo").text("");
	$("#msjImporteConRedondeo").text("");
	$("#Moneda10").prop("checked", false );
	$("#Moneda20").prop("checked", false );
	$("#Moneda30").prop("checked", false );
	$("#Moneda40").prop("checked", false );
	$("#Moneda50").prop("checked", false );
	$("#Moneda60").prop("checked", false );
	$("#Moneda70").prop("checked", false );
	$("#Moneda80").prop("checked", false );
	$("#Moneda90").prop("checked", false );
	$("#Moneda0").prop("checked", false );

}

function generarRedondeoCentavos()
{
	validarSessionDelUsuario();
	document.getElementById('cargando').style.display = 'block';
	let tipoRedondeo = $("#msjTipoRedondeo").text();
	let importeRedondeo = $("#msjImporteMovimientoAplicarRedondeo").text();
	
	$.ajax({
	    url :'CorteDeCaja', 
	    data : "vista=CorteDeCaja.jsp&operacion=redondearCorteCaja&importeRedondeo=" + importeRedondeo + "&tipoRedondeo=" + tipoRedondeo, 
	    type : 'POST',
	    dataType : 'Text',
	    success : function(respuesta)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
	    	OcultarDiv('divAlertaRedondeoCentavos');
	    	OcultarDiv('divConfirmaRedondeo');
	    	refrescarCorteCajaConRedondeo(0);
		},
		error : function(xhr, status, error) 
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else
				alert('Error al insertar corte de caja.')
		}
	});
}

function consultaRedondeosExisentes()
{
	MostrarDiv('cargando');
	let existenRedondeosAnteriores = false;
	$.ajax({
	    url :'CorteDeCaja', 
	    data : "vista=CorteDeCaja.jsp&operacion=consultaRedondeoDeCorteCaja", 
	    type : 'POST',
	    dataType : 'Text',
	    success : function(respuesta)
	    { 
	    	if(respuesta == "true")
	    	{
	    		OcultarDiv('cargando');
	    		var bandera = confirm("Existe un redondeo aplicado previamente. Deseas eliminarlo ?");
	    	    if (bandera == true)
	    	    {
	    	    	eliminarRedondeoExistente();
	    	    }
	    	}
	    	else
	    	{
	    		OcultarDiv('cargando');
	    		configuraMuestraAlertaRedondeo();
	    	}
		},
		error : function(xhr, status, error) 
		{
			OcultarDiv('cargando');
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else
				alert('Error al generar nuevamente corte de caja.')
		}
	});	
	return existenRedondeosAnteriores;	
}

function eliminarRedondeoExistente()
{
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'CorteDeCaja', 
	    data : "vista=CorteDeCaja.jsp&operacion=eliminaRedondeoDeCorteCaja", 
	    type : 'POST',
	    dataType : 'Text',
	    success : function(respuesta)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
	    	refrescarCorteCajaConRedondeo(1);
	    	
		},
		error : function(xhr, status, error) 
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else
				alert('Error al eliminar redondeo previo.')
		}
	});	
}

function refrescarCorteCajaConRedondeo(origen)
{
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'CorteDeCaja', 
	    data : "vista=CorteDeCaja.jsp&operacion=refrescarCorteDeCaja", 
	    type : 'POST',
	    dataType : 'Text',
	    success : function(respuesta)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
	    	arrayImportes = respuesta.split('/');
	    	$("#lbImpPrevioIEfectivo").text(arrayImportes[0]);
	    	$("#lbImpPrevioE").text(arrayImportes[1]);
	    	$("#lbImpTotalPrevioEfectivo").text(arrayImportes[2]);
	    	$("#lbImpTotalEfectivoRedondeo").text(arrayImportes[2]);
	    	if(origen >0)
	    	{
	    		configuraMuestraAlertaRedondeo();
	    	}
		},
		error : function(xhr, status, error) 
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else
				alert('Error al procesar el  corte de caja.')
		}
	});	
}

function refrescarCorteCaja()
{
	OcultarDiv('divAlertaCorteCaja');
	javascript:document.getElementById('idCorteCaja').submit();
}
