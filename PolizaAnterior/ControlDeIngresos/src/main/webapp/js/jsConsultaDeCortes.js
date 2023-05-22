function MuestraPanel (div, menu)
{
	var divMostrar ="#" + div;
	var MunuActivo ="#" + menu;
    $(divMostrar).show();
    $(MunuActivo).css('background-color', '#337AB7');
}

function IniciaModuloDeConsultaDeCortes(div, menu)
{
	MuestraPanel(div, menu);
	inicializaVariables();
	configurarMenuPrincipalXPerfilesUsuario();
	OcultarDiv('divPieDePagina');
	validarTapMostrarPosUsuario();
}

function validarTapMostrarPosUsuario()
{
	let nivelUsuario=$("#lbNivel_usuario").text();
	if(nivelUsuario == 0)
	{
		MostrarDiv('li_CortesCaja');
		MostrarDiv('li_CortesPanamericano');
		MostrarDiv('li_CortesPoliza');
	}
	else if (nivelUsuario == 1)
	{
		OcultarDiv('li_CortesCaja');
		OcultarDiv('li_CortesPanamericano');	
		MostrarDiv('li_CortesPoliza');
		OcultarDiv('btn_reimprimir_polizaConsulta');
	}
	else if (nivelUsuario == 2)
	{
		MostrarDiv('li_CortesCaja');
		MostrarDiv('li_CortesPanamericano');
		MostrarDiv('li_CortesPoliza');
		OcultarDiv('btn_reimprimir_polizaConsulta');
	}
}

function inicializaVariables()
{
	$('#txt_fechaCorteCaja').val(ObtenerFechaActual());
	$('#txt_fechaCortePoliza').val(ObtenerFechaActual());	
	$('#txt_fechaCortePanamericano').val(ObtenerFechaActual());	
	$('#txt_folioCorteCaja').val("");
	$('#txt_folioCortePoliza').val("");
	$('#cmbCdoMantoCorteCaja').val("0");
}

/***** CONSULTA CORTE DE CAJA *****/
function consultaCorteDeCajaBD(origen, folio)
{
	document.getElementById('cargando').style.display = 'block';
	
	 $("#lbTotalIngresos").text("0.00");
	 $("#lbTotalEgresos").text("0.00");
	 $("#lbTotalCorteCaja").text("0.00");
	 
	 let folioCorteCaja = 0;
	 if(origen == 1){
		 folioCorteCaja = $('#txt_folioCorteCaja').val();
	 }
	 else{
		 folioCorteCaja = folio;
	 }
	 
	 $.ajax({
	    url :'ConsultasDeCortes', 
	    data : "vista=ConsultasDeCortes.jsp&operacion=ConsultarCortesCaja&fechaCorteCaja=" + $('#txt_fechaCorteCaja').val()+ "&folioCorteCaja="
	    	    + folioCorteCaja +"&origen=" + origen +"&uname_consulta="  + $('#cmbCdoMantoCorteCaja').val() , 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	let dataIFormaPago = json.listaPrevioXFP;
	    	let dataITipoPago = json.listaPrevioXTP;
	    	let dataIBancos = json.listaIngresosBancos;
	    	let dataEgresos = json.listaPrevioEgresos;
	    	let dataEgresosBancos = json.listaEgresosBancos;
	    	let dataCorteDeCaja = json.listaCortesCaja;
	    	
	    	if(dataITipoPago.length > 0 || dataEgresos != 0)
	    	{
	    		MostrarDiv('divCorteCajaConsultado');
	    		OcultarDiv('divMjsCorteCaja');
	    		if(origen == 1)
		    	{
		    		llenaGridCorteCaja(dataCorteDeCaja);	 
		    	} 
		    	
		    	llenaGridPrevioFP(dataIFormaPago);
		    	llenaGridPrevioTP(dataITipoPago);
		    	llenaGridPrevioBancos(dataIBancos);
		    	
		    	if(dataEgresos.length > 0)
		    	{
		    		llenaGridPrevioEgresos(dataEgresos);
			    	llenaGridPrevioEgresosBancos(dataEgresosBancos);
		    	}
		    	else
		    	{
		    		OcultarDiv('dgPrevioEgresos');
		    		OcultarDiv('dgPrevioEgresosBancos');
		    	}
	    	}
	    	else
	    	{
	    		OcultarDiv('divCorteCajaConsultado');
	    		MostrarDiv('divMjsCorteCaja');
	    	}
	    	
	    	document.getElementById('cargando').style.display = 'none';	    	
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
				alert('Error al buscar cortes de caja.')
		}
	});
}

/* GRIDS CORTE DE CAJA GENERAL  */
function llenaGridCorteCaja(data)
{
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	 return $.grep(data, function (corte) {
	                return (!corte.nombre_pago || corte.nombre_pago.indexOf(filter.nombre_pago) > -1)
	            });
	    },
	    insertItem: function (insertingClient) {
	        data.push(insertingClient);
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    { },
	 };
	
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#dgCorteCajaGeneral").jsGrid({
    	    		 width: "90%",
    		         paging: false,
    	             controller: {
    	                 loadData: function () {
    	                     dataType: "json"
    	                     return data;
    	                 }
    	             },
    	             autoload: true,
    	             controller: db,
    	             rowClick: function(args) {
    	            	     
    	                 var $row = this.rowByItem(args.item),
    	                     selectedRow = $("#dgCorteCajaGeneral").find('table tr.highlight');

    	                 if (selectedRow.length) {
    	                     selectedRow.toggleClass('highlight');
    	                 };    	    
    	                 consultaCorteDeCajaBD(2, args.item.folio_corte)
    	                 $row.toggleClass("highlight");    	                
    	             },
    	             fields: 
    	             [    	            	 
    	                 { name: "folio_corte", title:"FOLIO",  type: "text", width: 15, align: 'center',  editing: false, inserting: false, filtering: false,
    	                	/* itemTemplate: function (value, item) { 
                                 return $("<button>").attr("class", "lblinkGd").text(value).on("click", function () {
                                     consultaCorteDeCajaBD(2, item.folio_corte);                                    
                                     return false;
                                 });
    	                     }*/
    	                 },    	                 
    	                 { name: "fecha_corteCaja",   title:"FECHA",type: "text", width: 18, align: 'center',  editing: false, inserting: false, filtering: false, },
    	                 { name: "hora_corteCaja",   title:"HORA",type: "text", width: 18, align: 'center',  editing: false, inserting: false, filtering: false, },
    	                 { name: "usuario",   title:"USUARIO",type: "text", width: 25, align: 'center',  editing: false, inserting: false, filtering: false, },
    	                 { name: "nombre_usuario",   title:"NOMBRE",type: "text", width: 60, align: 'left',  editing: false, inserting: false, filtering: false, },
    	                 { name: "importe",   title:"IMPORTE",type: "text", width: 35, align: 'right',  editing: false, inserting: false, filtering: false, },
	                 ],
	        	 });
	         });
     $("#dgCorteCajaGeneral").show();
}

/* GRIDS CORTE DE CAJA INGRESOS  */
function llenaGridPrevioFP(data)
{
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	 return $.grep(data, function (corte) {
	                return (!corte.nombre_pago || corte.nombre_pago.indexOf(filter.nombre_pago) > -1)
	            });
	    },
	    insertItem: function (insertingClient) {
	        data.push(insertingClient);
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    { },
	 };
	
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#dgPrevioFormaPago").jsGrid({
    	    		 width: "90%",
    		         paging: false,
    	             controller: {
    	                 loadData: function () {
    	                     dataType: "json"
    	                     return data;
    	                 }
    	             },
    	             autoload: true,
    	             controller: db,
    	             onRefreshed: function (args) { 
    	            	 // seccion de totales 
    	            	let items = args.grid.option("data");
    	            	let totales= calculaImportesTotalesDelGridIFP(items)
    	                let $totalRow = $("<tr>").addClass("total-row");
    	             },
    	             fields: 
    	             [    	            	 
    	                 { name: "forma_pago", title:"FORMA PAGO",  type: "text", width: 35, align: 'left',  editing: false, inserting: false, filtering: false,},
    	                 { name: "importe",   title:"IMPORTE",type: "text", width: 30, align: 'right',  editing: false, inserting: false, filtering: false, },
	                 ],
	        	 });
	         });
     $("#dgPrevioFormaPago").show();
}

function llenaGridPrevioTP(data)
{
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	 return $.grep(data, function (corte) {
	                return (!corte.nombre_pago || corte.nombre_pago.indexOf(filter.nombre_pago) > -1)
	            });
	    },
	    insertItem: function (insertingClient) {
	        data.push(insertingClient);
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    { },
	 };
	
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#dgPrevioTipoPago").jsGrid({
    	    		 width: "90%",
    	             height: "auto",
    	             editing: false,
    	             filtering: false,
    	             sorting: false,
    	             paging: false,
    	             pageSize: 800,
    	             controller: {
    	                 loadData: function () {
    	                     dataType: "json"
    	                     return data;
    	                 }
    	             },
    	             onItemUpdating: function (args) {
    	            	 IPrevio = args.previousItem;
    	             },
    	             autoload: true,
    	             confirmDeleting: false,
    	             controller: db,
    	             fields: 
    	             [    	            	 
    	                 { name: "id_tipo_pago", title: "", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "tipo_pago", title: "TIPO DE  PAGO",  type: "text", width:60, align: 'left', editing: false, inserting: false, filtering: true,},
    	                 { name: "importe", title: "IMPORTE",  type: "text", width: 30, align: 'right', editing: false, inserting: false, filtering: true, },
	                 ],
	        	 });
	         });
     $("#dgPrevioTipoPago").show();
}

function llenaGridPrevioBancos(data)
{
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	 return $.grep(data, function (corte) {
	                return (!corte.nombre_pago || corte.nombre_pago.indexOf(filter.nombre_pago) > -1)
	            });
	    },
	    insertItem: function (insertingClient) {
	        data.push(insertingClient);
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    { },
	 };
	
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#dgPrevioBancos").jsGrid({
    	    		 width: "90%",
    	             height: "auto",
    	             editing: false,
    	             filtering: false,
    	             sorting: false,
    	             paging: false,
    	             pageSize: 800,
    	             controller: {
    	                 loadData: function () {
    	                     dataType: "json"
    	                     return data;
    	                 }
    	             },
    	             onItemUpdating: function (args) {
    	            	 IPrevio = args.previousItem;
    	             },
    	             autoload: true,
    	             confirmDeleting: false,
    	             controller: db,
    	             onRefreshed: function (args) { 
    	            	 // seccion de totales 
    	            	let items = args.grid.option("data");
    	            	let totales= 0;
    	            	$("#lbTotalCorteCaja").text($("#lbTotalIngresos").text().replace('$', ''));
    	                let $totalRow = $("<tr>").addClass("total-row");
    	             },
    	             fields: 
    	             [    	            	 
    	                 { name: "cve_banco", title: "", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "banco_nombre", title: "BANCO",  type: "text", width:60, align: 'left', editing: false, inserting: false, filtering: true,},
    	                 { name: "importe", title: "IMPORTE",  type: "text", width: 30, align: 'right', editing: false, inserting: false, filtering: true, },
	                 ],
	        	 });
	         });
     $("#dgPrevioBancos").show();
}

function calculaImportesTotalesDelGridIFP(items)
{
	 let total = {
			 cve_forma_pago: "",forma_pago: "TOTAL", importe: 0, IsTotal: true
     };
	  
	 items.forEach(function (item){
         total.importe += parseFloat(item.importe.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace('$', ''));        
     });
	  
	 total.importe = "$" + FormatearTotalesDeGrid(total.importe)
	 $("#lbTotalPrevioIngresos").text(total.importe)
	 $("#lbTotalIngresos").text(total.importe)
     return "";
}

function FormatearTotalesDeGrid(importe)
{
	let importeTotalGrid = parseFloat(importe).toFixed(2);
	importeTotalGrid = agregarCommas(importeTotalGrid);
	return importeTotalGrid;
}

/* GRIDS CORTE DE CAJA EGRESOS */
function llenaGridPrevioEgresos(data)
{
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	 return $.grep(data, function (corte) {
	                return (!corte.nombre_pago || corte.nombre_pago.indexOf(filter.nombre_pago) > -1)
	            });
	    },
	    insertItem: function (insertingClient) {
	        data.push(insertingClient);
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    { },
	 };
	
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#dgPrevioEgresos").jsGrid({
    	    		 width: "90%",
    	             height: "auto",
    	             editing: false,
    	             filtering: false,
    	             sorting: false,
    	             paging: false,
    	             pageSize: 800,
    	             controller: {
    	                 loadData: function () {
    	                     dataType: "json"
    	                     return data;
    	                 }
    	             },
    	             onItemUpdating: function (args) {
    	            	 IPrevio = args.previousItem;
    	             },
    	             autoload: true,
    	             confirmDeleting: false,
    	             controller: db,
    	             onRefreshed: function (args) { 
    	            	 // seccion de totales 
    	            	let items = args.grid.option("data");
    	            	let totales= calculaImportesTotalesDelGridETipo(items)
    	             },
    	             
    	             fields: 
    	             [    	            	 
    	                 { name: "id_egreso", title: "", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "nombre_egreso", title: "TIPO DE EGRESO",  type: "text", width:60, align: 'left', editing: false, inserting: false, filtering: true,},
    	                 { name: "importe_egreso", title: "IMPORTE",  type: "text", width: 30, align: 'right', editing: false, inserting: false, filtering: true, },
	                 ],
	        	 });
	         });
     $("#dgPrevioEgresos").show();
}

function llenaGridPrevioEgresosBancos(data)
{
	
	
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	 return $.grep(data, function (corte) {
	                return (!corte.nombre_pago || corte.nombre_pago.indexOf(filter.nombre_pago) > -1)
	            });
	    },
	    insertItem: function (insertingClient) {
	        data.push(insertingClient);
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    { },
	 };
	
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#dgPrevioEgresosBancos").jsGrid({
    	    		 width: "90%",
    	             height: "auto",
    	             editing: false,
    	             filtering: false,
    	             sorting: false,
    	             paging: false,
    	             pageSize: 800,
    	             controller: {
    	                 loadData: function () {
    	                     dataType: "json"
    	                     return data;
    	                 }
    	             },
    	             onItemUpdating: function (args) {
    	            	 IPrevio = args.previousItem;
    	             },
    	             autoload: true,
    	             confirmDeleting: false,
    	             controller: db,
    	             fields: 
    	             [    	            	 
    	                 { name: "cve_banco", title: "", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "banco_nombre", title: "BANCOS",  type: "text", width:60, align: 'left', editing: false, inserting: false, filtering: true,},
    	                 { name: "importe", title: "IMPORTE",  type: "text", width: 30, align: 'right', editing: false, inserting: false, filtering: true, },
	                 ],
	        	 });
	         });
     $("#dgPrevioEgresosBancos").show();
}

function calculaImportesTotalesDelGridETipo(items)
{
	 let totalEgresos=0;
	 if(items.length > 0)
	 {
		 items.forEach(function (item){
			 let imp_sin_formato = item.importe_egreso.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace('$', '');
			 totalEgresos += parseFloat(imp_sin_formato); 
	     });
		  
		 $("#lbTotalPrevioEgresos").text( "-" + totalEgresos);
		 $("#lbTotalEgresos").text( "-" + totalEgresos);
		 calculaImportesTotales();		 
	 }
	 return "";
}

function calculaImportesTotales()
{
	let totalIngresos = $("#lbTotalIngresos").text().replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace('$', '').replace('-', '');	
	let totalEgresos = $("#lbTotalEgresos").text().replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace('$', '').replace('-', '');	
	let totalCorteCaja= parseFloat(totalIngresos) - parseFloat(totalEgresos);	
	totalCorteCaja= agregarCommas(parseFloat(totalCorteCaja).toFixed(2))	
	$("#lbTotalCorteCaja").text(totalCorteCaja);
}

function crearColumnaFormaDePagoParaGrid(value, item)
{
	 if (item.forma_pago === "EFECTIVO") 
	 {
         return $("<div>").attr("class", "ECPO_lbEfectivo").text(value);
     }
     else 
     {
         return $("<div>").attr("class", "ECPO_lbFormaPago").text(value);
     }
}



/***** CONSULTA CORTE DE POLIZA  *****/
function consultaCorteDePolizaBD()
{
	document.getElementById('cargando').style.display = 'block';	
	 
	 $.ajax({
	    url :'ConsultasDeCortes', 
	    data : "vista=ConsultasDeCortes.jsp&operacion=ConsultarCortesPoliza&fechaCortePoliza=" + $('#txt_fechaCortePoliza').val()+ "&folioCortePoliza=" + $('#txt_folioCortePoliza').val() +  "&uname_consulta="  + $('#cmbCdoMantoCortePoliza').val() , 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(jsonPoliza)
	    { 
	    	let folioPoliza = jsonPoliza.folio_poliza;
	    	let fechaPoliza = jsonPoliza.fecha_poliza;
	    	let totalPolizaIngresos = jsonPoliza.total_polizaIngresos;
	    	let totalPolizaEgresos = jsonPoliza.total_polizaEgresos;
	    	let polizaEgresos = jsonPoliza.listaPolDiaTipoEgreso;
	    	let polizaIngresosTipo = jsonPoliza.listaPolDiaTipoIngreso;
	    	let polizaIngresosBancos = jsonPoliza.listaPolDiaBancoIngresos;
	    	let polizaIngresosOtros = jsonPoliza.listaPolDiaOtrosIngresos;
	    	let polizaRValores = jsonPoliza.listaRecoleccionValores;
	    	let transitoAplicado= jsonPoliza.transito_aplicado;
	    	let transitoPendiente= jsonPoliza.transito_pendiente;
	    	let listafichasBancarias= jsonPoliza.listafichasBancarias;
	    	let listafichasBancariasEgresos= jsonPoliza.listafichasBancariasEgresos;
	    	let listaPolizaContable= jsonPoliza.polizaContable;
	    	let ajusteMasCheque = jsonPoliza.ajusteMasCheque;
	    	let ajusteMenosCheque = jsonPoliza.ajusteMenosCheque;
	    		    	
	    	if(totalPolizaIngresos > 0)
	    	{
	    		MostrarDiv('divCortePolizaConsultado');
	    		OcultarDiv('divMjsErrorPoliza');	
	    		$('#lb_folioActualPol').text(folioPoliza);
	    		$('#lb_fechaActualPol').text(fechaPoliza);	    		
	    		generaContenidoDePolizaDia(polizaEgresos, polizaIngresosTipo, polizaIngresosBancos, polizaIngresosOtros, totalPolizaIngresos,totalPolizaEgresos,polizaRValores, transitoPendiente , transitoAplicado,listafichasBancarias,listafichasBancariasEgresos, listaPolizaContable, ajusteMasCheque, ajusteMenosCheque);
	    		document.getElementById('cargando').style.display = 'none';
	    	}
	    	else
	    	{
	    		OcultarDiv('divCortePolizaConsultado');
	    		MostrarDiv('divMjsErrorPoliza');
	    		document.getElementById('cargando').style.display = 'none';
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
				alert('Error al buscar cortes de caja.')
		}
	});
}

function generaContenidoDePolizaDia(polizaEgresos, polizaIngresosTipo, polizaIngresosBancos, polizaIngresosOtros,totalPolizaIngresos, totalPolizaEgresos,polizaRValores, transitoPendiente,transitoAplicado,listafichasBancarias,listafichasBancariasEgresos, polizaContable,  ajusteMasCheque, ajusteMenosCheque )
{
	$('#div_ContenidoPoliza').empty();
	let contenitoIBanco=generaContenidoIngresosBancos(polizaIngresosBancos,polizaEgresos);
	let contenitoItipo = generaContenidoIngresosTipo(polizaIngresosTipo, totalPolizaEgresos, polizaEgresos,  ajusteMasCheque, ajusteMenosCheque);
	let contenitoIOtros = generaContenidoIngresosOtros(polizaIngresosOtros);
	let contenitoEgresos = generaContenidoEgreso(polizaEgresos);
	let totalPolizaIngresosBancos = obtenerTotalesDeBancos(polizaIngresosTipo);
	let contenidoTotalBancos = generaContenidoTotalesBancos(totalPolizaIngresosBancos, totalPolizaEgresos,polizaIngresosOtros );	
	let contenidoRValores = generaContenidoRecoleccionValores(polizaRValores);
	let contenidoTransito= generaContenidoCobranzaTransito(transitoPendiente, transitoAplicado)
	let contenidoFichasBancarias= generaContenidoFichasBancarias(listafichasBancarias)	
	let contenidoFichasBancariasEgresos= generaContenidoFichasBancariasEgresos(listafichasBancariasEgresos)	
	//let contenidoPolizaContable= generaContenidoPolizaContable(polizaContable)	
	let contenido = contenitoIBanco + contenitoItipo + "<br>" +  contenitoEgresos + "<br>" + contenitoIOtros  + "<br>" + contenidoFichasBancarias + "<br>" + contenidoFichasBancariasEgresos + "<br>" + contenidoTransito + "<br>" + contenidoRValores /*+ "<br>" +contenidoPolizaContable + "<br>"*/; 
	$("#div_ContenidoPoliza").append(contenido);
}

/* POLIZA INGRESOS SEGMENTO BANCOS */
function  generaContenidoIngresosBancos(polizaIngresosBancos, polizaEgresos)
{
	let totalRow=0;
	let totalEfectivo=0;
	let totalCheque=0;
	let totalTransferencia=0;
	let totalTCredito=0;
	let totalTDebito=0;
	let totalPosfechado=0;
	let total=0;
	let totalEfectCheque = 0
	let EfectCheque= 0
	let totalEgresos=0
	let contenidoIBancos = "<table  class='table table-striped'  style='width: 100%;margin-bottom: 0px'>"+
								"<tbody>"+
									"<tr>"+
										"<td colspan='8' style='border:1px solid #D3D3D3' >"+
											"<label style='font-family: arial;font-size: 14px;color:#013ADF;font-weight:bold; margin: 0px'> BANCOS </label>"+
										"</td>"+
									"</tr>";
	
	for(let i=0; i < polizaIngresosBancos.length ; i++)
	{
		totalRow= 	parseFloat(polizaIngresosBancos[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',','')) + 
					parseFloat(polizaIngresosBancos[i].importe_cheque.replace(',','').replace(',','').replace(',','').replace(',','')) +
					parseFloat(polizaIngresosBancos[i].importe_tCredito.replace(',','').replace(',','').replace(',','').replace(',','')) + 
					parseFloat(polizaIngresosBancos[i].importe_tDebito.replace(',','').replace(',','').replace(',','').replace(',','')) +
					parseFloat(polizaIngresosBancos[i].importe_transferencia.replace(',','').replace(',','').replace(',','').replace(',','')) ;
				
		total = parseFloat(total) + parseFloat(totalRow);
		totalRow = validaImporte(totalRow)
		
		totalEfectivo = parseFloat(totalEfectivo) + parseFloat(polizaIngresosBancos[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',',''));
		totalCheque= parseFloat(totalCheque) +  parseFloat(polizaIngresosBancos[i].importe_cheque.replace(',','').replace(',','').replace(',','').replace(',',''));
		totalTransferencia= parseFloat(totalTransferencia) +  parseFloat(polizaIngresosBancos[i].importe_transferencia.replace(',','').replace(',','').replace(',','').replace(',',''));
		totalTCredito= parseFloat(totalTCredito) + parseFloat(polizaIngresosBancos[i].importe_tCredito.replace(',','').replace(',','').replace(',','').replace(',',''));
		totalTDebito= parseFloat(totalTDebito) + parseFloat(polizaIngresosBancos[i].importe_tDebito.replace(',','').replace(',','').replace(',','').replace(',','')) ; 
		totalPosfechado= parseFloat(totalPosfechado) + parseFloat(polizaIngresosBancos[i].importe_posfechado.replace(',','').replace(',','').replace(',','').replace(',',''));
		EfectCheque=  parseFloat(polizaIngresosBancos[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',','')) + parseFloat(polizaIngresosBancos[i].importe_cheque.replace(',','').replace(',','').replace(',','').replace(',',''));
		totalEfectCheque= totalEfectCheque + EfectCheque; 
		
		contenidoIBancos += "<tr>"+
								"<td style='padding: 4px; display:none; border:1px solid #D3D3D3'>"+
									"<label style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>" + polizaIngresosBancos[i].cve_banco +"</label>"+
								"</td>"+
								"<td style='padding: 4px; width: 15%; border:1px solid #D3D3D3' >"+
									"<label style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>" + polizaIngresosBancos[i].nombre_banco +"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
										polizaIngresosBancos[i].importe_efectivo+
									 "</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
										polizaIngresosBancos[i].importe_cheque+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
										validaImporte(EfectCheque)+
									"</label>"+
								"</td>"+								
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
										polizaIngresosBancos[i].importe_tCredito+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
										polizaIngresosBancos[i].importe_tDebito+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
										polizaIngresosBancos[i].importe_transferencia+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>"+
										polizaIngresosBancos[i].importe_posfechado+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label style='font-weight: bold;font-family: arial; font-size: 11px; margin: 0px'>$ "+
									totalRow+
									"</label>"+
								"</td>"+
							"</tr>";

		for(let e=0; e < polizaEgresos.length; e++)
		{
			if( polizaIngresosBancos[i].nombre_banco  ==  polizaEgresos[e].nombre_banco &&  polizaEgresos[e].tipo_egreso != 5)
		    {
				totalEgresos = parseFloat(totalEgresos) + parseFloat(polizaEgresos[e].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',',''));
				
				contenidoIBancos += "<tr style=' background-color: #F5C6CB; border: 1px solid #E8939B'>"+
										"<td style='padding: 4px; display:none; border:1px solid #D3D3D3'>"+
											"<label style='color:#DC143C; font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>" + 0 +"</label>"+
										"</td>"+
										"<td style='padding: 4px; width: 15%; border:1px solid #D3D3D3' >"+
											"<label style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>" + polizaEgresos[e].nombre_banco + " - " + polizaEgresos[e].nombre_tipo_egreso +"</label>"+
										"</td>"+
										"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
											"<label style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ -"+
												polizaEgresos[e].importe_efectivo+
											 "</label>"+
										"</td>"+
										"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
											"<label  style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+												
											"</label>"+
										"</td>"+
										"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
											"<label  style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ -"+
												polizaEgresos[e].importe_efectivo+
											"</label>"+
										"</td>"+								
										"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
											"<label style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+
											"</label>"+
										"</td>"+
										"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
											"<label  style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+
											"</label>"+
										"</td>"+
										"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
											"<label style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+
											"</label>"+
										"</td>"+
										"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
											"<label  style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+
											"</label>"+
										"</td>"+
										"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
											"<label style='color:#DC143C;font-weight: bold;font-family: arial; font-size: 11px; margin: 0px'>$ -"+
												polizaEgresos[e].importe_efectivo+
											"</label>"+
										"</td>"+
									"</tr>";
		    }
		}
	}
	
	totalEfectivo= parseFloat(totalEfectivo)-parseFloat(totalEgresos);
	totalEfectivo = validaImporte(totalEfectivo)
		
	totalCheque = validaImporte(totalCheque)
	totalTransferencia = validaImporte(totalTransferencia)
	totalTCredito = validaImporte(totalTCredito)
	totalTDebito = validaImporte(totalTDebito)
	totalPosfechado = validaImporte(totalPosfechado)	
	
	total= parseFloat(total)-parseFloat(totalEgresos);
	total = validaImporte(total)
	
	totalEfectCheque= parseFloat(totalEfectCheque)-parseFloat(totalEgresos);
	totalEfectCheque = validaImporte(totalEfectCheque)
	
	
	contenidoIBancos += "<tr style='background-color: #B8DAFF; border: 1px solid #B8DAFF;'>"+
							"<td style='padding: 4px; display:none;'></td>"+
							"<td style='padding: 4px;width: 15%' align='left'></td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label  style='color:black; font-weight: bold;font-family: arial; font-size: 11px; margin: 0px'>$ "+
									totalEfectivo+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label style='color:black;font-weight: bold;font-family: arial; font-size: 11px; ; margin: 0px'>$ "+
									totalCheque+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%;background-color:black; border:1px solid black;' align='right'>"+
								"<label style='color:white;font-weight: bold;font-family: arial; font-size: 11px; ; margin: 0px'>$ "+
									totalEfectCheque+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label  style='color:black;font-family: arial; font-size: 11px; font-weight:bold; margin: 0px'>$ "+
									totalTCredito+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label  style='color:black;font-weight: bold;font-family: arial; font-size: 11px;  margin: 0px'>$ "+
									totalTDebito +
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label  style='color:black;font-weight: bold;font-family: arial; font-size: 11px; margin: 0px'>$ "+
									totalTransferencia+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; background-color: #FFEEBA; border:1px solid #FFDF7E' align='right'>"+
								"<label  style='color:black;font-weight: bold;font-family: arial; font-size: 11px; margin: 0px'>$ "+
									totalPosfechado+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label  style='color:black;font-weight: bold;font-family: arial; font-size: 11px; margin: 0px'>$ "+
									total +
								"</label>"+
							"</td>"+
						"</tr>"+
					"</tbody>"+
				"</table>" +
				"<BR>";
	
	return contenidoIBancos;
}

function obtenerTotalesDeBancos(polizaIngresosTipo)
{
	let totalEfectivo=0;
	let totalCheque=0;
	let totalEfectCheque = 0;
	let EfectCheque= 0;
	
	for(let i=0; i < polizaIngresosTipo.length ; i++)
	{		
		totalEfectivo = parseFloat(totalEfectivo) + parseFloat(polizaIngresosTipo[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',',''));
		totalCheque= parseFloat(totalCheque) +  parseFloat(polizaIngresosTipo[i].importe_cheque.replace(',','').replace(',','').replace(',','').replace(',',''));
		EfectCheque= parseFloat(polizaIngresosTipo[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',','')) + parseFloat(polizaIngresosTipo[i].importe_cheque.replace(',','').replace(',','').replace(',','').replace(',',''));
		totalEfectCheque= totalEfectCheque + EfectCheque; 
	}
	return totalEfectCheque;
}

/* POLIZA INGRESOS SEGMENTO TIPOS */
function  generaContenidoIngresosTipo(polizaIngresosTipo, totalPolizaEgresos,polizaEgresos,  ajusteMasCheque, ajusteMenosCheque)
{
	let totalRow=0;
	let totalEfectivo=0;
	let totalCheque=0;
	let totalTransferencia=0;
	let totalTCredito=0;
	let totalTDebito=0;
	let totalPosfechado=0;
	let total=0;
	let totalEfectCheque = 0
	let EfectCheque= 0
	let totalEgresos=0
	
	let contenidoITipos = "<table  class='table table-striped'  style='width: 100%; margin-bottom: 0px'>"+
								"<tbody>"+
									"<tr>"+
										"<td colspan='3'  style='border:1px solid #D3D3D3'>"+
											"<label style='font-family: arial;font-size: 14px;color:#013ADF;font-weight:bold; margin: 0px'> TIPO PAGO </label>"+
										"</td>"+
										"<td align='center'>"+
											"<label style='font-family: arial;font-size: 12px;color:#013ADF;font-weight:bold; margin: 0px'> CLIENTES CREDITO</label>"+
										"</td>"+
										"<td colspan='5'></td>"+
									"</tr>";
	for(let i=0; i < polizaIngresosTipo.length ; i++)
	{
		if(polizaIngresosTipo[i].tipo_pago != 4)
		{
			totalRow= 	parseFloat(polizaIngresosTipo[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',','')) + 
						parseFloat(polizaIngresosTipo[i].importe_cheque.replace(',','').replace(',','').replace(',','').replace(',','')) +
						parseFloat(polizaIngresosTipo[i].importe_tCredito.replace(',','').replace(',','').replace(',','').replace(',','')) + 
						parseFloat(polizaIngresosTipo[i].importe_tDebito.replace(',','').replace(',','').replace(',','').replace(',','')) +
						parseFloat(polizaIngresosTipo[i].importe_transferencia.replace(',','').replace(',','').replace(',','').replace(',','')) ;
					
			total = parseFloat(total) + parseFloat(totalRow);
			totalRow = validaImporte(totalRow)
			
			totalEfectivo = parseFloat(totalEfectivo) + parseFloat(polizaIngresosTipo[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',',''));
			totalCheque= parseFloat(totalCheque) +  parseFloat(polizaIngresosTipo[i].importe_cheque.replace(',','').replace(',','').replace(',','').replace(',',''));
			totalTransferencia= parseFloat(totalTransferencia) +  parseFloat(polizaIngresosTipo[i].importe_transferencia.replace(',','').replace(',','').replace(',','').replace(',',''));
			totalTCredito= parseFloat(totalTCredito) + parseFloat(polizaIngresosTipo[i].importe_tCredito.replace(',','').replace(',','').replace(',','').replace(',',''));
			totalTDebito= parseFloat(totalTDebito) + parseFloat(polizaIngresosTipo[i].importe_tDebito.replace(',','').replace(',','').replace(',','').replace(',','')) ; 
			totalPosfechado= parseFloat(totalPosfechado) + parseFloat(polizaIngresosTipo[i].importe_posfechado.replace(',','').replace(',','').replace(',','').replace(',',''));
		
			EfectCheque= parseFloat(polizaIngresosTipo[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',','')) + parseFloat(polizaIngresosTipo[i].importe_cheque.replace(',','').replace(',','').replace(',','').replace(',',''));
			totalEfectCheque= totalEfectCheque + EfectCheque; 
			
			totalEgresos= calculaImportesDeEgresos('ChequeDevuelto', polizaEgresos); //parseFloat(totalPolizaEgresos.replace('-',''));
		
			
			contenidoITipos += "<tr>"+
									"<td style='padding: 4px; display:none;'>"+
										"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>" +
											polizaIngresosTipo[i].tipo_pago+
										"</label>"+
									"</td>"+
									"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3'>"+
										"<label style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>" +
											polizaIngresosTipo[i].nombre_tipo_pago+
										"</label>"+
									"</td>"+
									"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
										"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$"+ 
											polizaIngresosTipo[i].importe_efectivo+
										 "</label>"+
									"</td>"+
									"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
										"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
											polizaIngresosTipo[i].importe_cheque+
										"</label>"+
									"</td>"+
									"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
										"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
											validaImporte(EfectCheque)+
										"</label>"+
									"</td>"+
									"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
										"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
											polizaIngresosTipo[i].importe_tCredito+
										"</label>"+
									"</td>"+
									"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
										"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
											polizaIngresosTipo[i].importe_tDebito +
										"</label>"+
									"</td>"+
									"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
										"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
											polizaIngresosTipo[i].importe_transferencia+
										"</label>"+
									"</td>"+
									"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
										"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$"+ 
											polizaIngresosTipo[i].importe_posfechado+
										"</label>"+
									"</td>"+
									"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
										"<label  style='font-weight: bold;font-family: arial; font-size: 11px;  margin: 0px'>$ "+
											totalRow +
										"</label>"+
									"</td>"+
								"</tr>";
		}
	
	}
	
	if(parseFloat(totalEgresos) >0)
	{
		contenidoITipos += "<tr style=' background-color: #F5C6CB; border: 1px solid #E8939B'>"+
								"<td style='padding: 4px; display:none;'>"+
									"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'> 0" +								
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3'>"+
									"<label style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>" +
										"CHEQUES DEVUELTOS "+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+ 
									
									 "</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ - "+
									validaImporte(totalEgresos)+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ -"+
									validaImporte(totalEgresos)+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:#DC143C;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+ 
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:#DC143C;font-weight: bold;font-family: arial; font-size: 11px;  margin: 0px'>$ -"+
									validaImporte(totalEgresos)+
									"</label>"+
								"</td>"+
							"</tr>";
	
	}
	
	let ajusteChequeNominativo = 0;	
	if(parseFloat(ajusteMasCheque) > 0)
	{
		ajusteChequeNominativo= parseFloat(ajusteMasCheque);
	}
	else if(parseFloat(ajusteMenosCheque) < 0)
	{
		ajusteChequeNominativo= parseFloat(ajusteMenosCheque);
	}
	
	if(ajusteChequeNominativo != 0)
	{
		contenidoITipos += "<tr style=' background-color: #EBEBEE; border: 1px solid #E8939B'>"+
								"<td style='padding: 4px; display:none;'>"+
									"<label  style='font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'> 0" +								
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3'>"+
									"<label style='color:black;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>" +
										"AJUSTE CHEQUE NOMINATIVO "+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:black;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+ 
									
									 "</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:black;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
									validaImporte(ajusteChequeNominativo)+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:black;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ "+
									validaImporte(ajusteChequeNominativo)+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:black;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:black;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:black;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:black;font-weight: normal;font-family: arial; font-size: 11px; font-weight:normal; margin: 0px'>$ 0"+ 
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='color:black;font-weight: bold;font-family: arial; font-size: 11px;  margin: 0px'>$ "+
									validaImporte(ajusteChequeNominativo)+
									"</label>"+
								"</td>"+
							"</tr>";
	}
	
	
	//totalEfectivo= parseFloat(totalEfectivo)//-parseFloat(totalPolizaEgresos.replace('-',''));
	totalEfectivo = validaImporte(totalEfectivo)
	
	totalCheque  = parseFloat(totalCheque) - parseFloat(totalEgresos);
	if(parseFloat(ajusteChequeNominativo) > 0)
	{
		totalCheque = parseFloat(totalCheque) + parseFloat(ajusteChequeNominativo);
	}
	else if(parseFloat(ajusteChequeNominativo) < 0)
	{
		totalCheque = parseFloat(totalCheque) - (parseFloat(ajusteChequeNominativo)*-1);
	}
	totalCheque = validaImporte(totalCheque) 
	
	totalTransferencia = validaImporte(totalTransferencia)
	totalTCredito = validaImporte(totalTCredito)
	totalTDebito = validaImporte(totalTDebito)
	totalPosfechado = validaImporte(totalPosfechado)
	
	total= parseFloat(total)-parseFloat(totalEgresos);
	if(parseFloat(ajusteChequeNominativo) > 0)
	{
		total = parseFloat(total) + parseFloat(ajusteChequeNominativo);
	}
	else if(parseFloat(ajusteChequeNominativo) < 0)
	{
		total = parseFloat(total) - (parseFloat(ajusteChequeNominativo)*-1);
	}
	total = validaImporte(total)
	
	totalEfectCheque= parseFloat(totalEfectCheque)-parseFloat(totalEgresos);	
	if(parseFloat(ajusteChequeNominativo) > 0)
	{
		totalEfectCheque = parseFloat(totalEfectCheque) + parseFloat(ajusteChequeNominativo);
	}
	else if(parseFloat(ajusteChequeNominativo) < 0)
	{
		totalEfectCheque = parseFloat(totalEfectCheque) - (parseFloat(ajusteChequeNominativo)*-1);
	}
	totalEfectCheque = validaImporte(totalEfectCheque)

	contenidoITipos +="<tr style='background-color: #B8DAFF; border: 1px solid#B8DAFF;'>"+
						 	"<td style='padding: 4px; display:none;'></td>"+
						 	"<td style='padding: 4px;width: 15%' align='left'></td>"+
						 	"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label style='color:black; font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$"+ 
									totalEfectivo+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+ 
									totalCheque+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; background-color:black; border:1px solid black' align='right'>"+
								"<label style=' color:white;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+ 
									totalEfectCheque+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									totalTCredito+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									totalTDebito+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
								 totalTransferencia+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%;  background-color: #FFEEBA; border:1px solid #FFDF7E' align='right'>"+
								"<label style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									totalPosfechado+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									total+
								"</label>"+
							"</td>"+
						"</tr>"+
					"</tbody>"+
				"</table>";
	return contenidoITipos;			
}

/* POLIZA EGRESOS SEGMENTO */
function  generaContenidoEgreso(polizaEgresos)
{
	let totalRow=0;
	let totalEfectivo=0;
	let totalCheque=0;
	let total=0;
	
	let contenidoEgresos = "<table  class='table table-striped'  style='width: 100%; margin-bottom: 0px'>"+
								"<tbody>"+
									"<tr>"+
										"<td colspan='9'  style='border:1px solid #D3D3D3'>"+
											"<label class='EPOL_lb_hd' style='color:#DC143C;font-family: arial;font-size: 14px;font-weight:bold; margin: 0px'>EGRESOS </label>"+
										"</td>"+
									"</tr>";
	
	for(let i=0; i < polizaEgresos.length ; i++)
	{
		totalRow= 	parseFloat(polizaEgresos[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',',''));
		total = parseFloat(total) + parseFloat(totalRow);
		totalRow = validaImporte(totalRow)
		
		if(polizaEgresos[i].tipo_egreso != 5)
		{
			totalEfectivo = parseFloat(totalEfectivo) + parseFloat(polizaEgresos[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',',''));
		}
		else
		{
			totalCheque = parseFloat(totalCheque) + parseFloat(polizaEgresos[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',',''));
		}
		
		contenidoEgresos +="<tr>"+
								"<td style='padding: 4px; display:none;'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>"+
										polizaEgresos[i].tipo_egreso+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'> "+
										polizaEgresos[i].nombre_tipo_egreso + " - " + polizaEgresos[i].nombre_banco+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>";
									
								if(polizaEgresos[i].tipo_egreso != 5)
								{
									contenidoEgresos += "<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
															polizaEgresos[i].importe_efectivo
														"</label>";
								}	
								else
								{
									contenidoEgresos +="<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
															"0.00"
														"</label>";
								}	
									
		contenidoEgresos +=	"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>";
								if(polizaEgresos[i].tipo_egreso != 5)
								{
									contenidoEgresos += "<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
															"0.00"
														"</label>";
								}	
								else
								{
									contenidoEgresos +="<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									polizaEgresos[i].importe_efectivo
														"</label>";
								}	
		
	    contenidoEgresos +=	"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									polizaEgresos[i].importe_efectivo+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$  "+
										"0.00"+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
										"0.00"+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+ 
										"0.00"+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$"+  
										"0.00"+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
										totalRow+
									"</label>"+
								"</td>"+
							"</tr>";
	}
	
	totalEfectivo = validaImporte(totalEfectivo)
	totalCheque = validaImporte(totalCheque)
	total = validaImporte(total)
	
	contenidoEgresos +="<tr style='background-color: #F5C6CB; border: 1px solid #E8939B'>"+
						 	"<td style='padding: 4px; display:none;'></td>"+
						 	"<td style='padding: 4px;width: 15%' align='left'></td>"+
						 	"<td style='padding: 4px;width: 10%;border:1px solid #D3D3D3' align='right'>"+
								"<label  style='font-weight: bold;  color:#DC143C; font-family: arial; font-size: 11px;margin: 0px'>$"+ 
									totalEfectivo+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%;border:1px solid #D3D3D3' align='right'>"+
								"<label  style='font-weight: bold ; color:#DC143C; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									totalCheque+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%;border:1px solid #D3D3D3;' align='right'>"+
								"<label  style='font-weight: bold ; color:#DC143C;font-family: arial; font-size: 11px;margin: 0px'>$ "+
									total+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%;border:1px solid #D3D3D3' align='right'>"+
								"<label  style='font-weight: bold ; color:#DC143C; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									"0.00"+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%;border:1px solid #D3D3D3' align='right'>"+
								"<label  style='font-weight: bold ; color:#DC143C; font-family: arial; font-size: 11px;margin: 0px'>$"+
									"0.00"+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%;border:1px solid #D3D3D3' align='right'>"+
								"<label  style='font-weight: bold ; color:#DC143C; font-family: arial; font-size: 11px;margin: 0px'>$"+
									"0.00"+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label  style='font-weight: bold; color:#DC143C; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									"0.00"+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%;border:1px solid #D3D3D3' align='right'>"+
								"<label  style='font-weight: bold ; color:#DC143C; font-family: arial; font-size: 11px;margin: 0px'>$"+
									total+
								"</label>"+
							"</td>"+
						"</tr>"+
						"</tbody>"+
					"</table>";
	return contenidoEgresos;
}

/* POLIZA INGRESOS SEGMENTO OTROS */
function  generaContenidoIngresosOtros(polizaIngresosOtros)
{
	let totalRow=0;
	let totalEfectivo=0;
	let totalCheque=0;
	let totalTransferencia=0;
	let totalTCredito=0;
	let totalTDebito=0;
	let totalPosfechado=0;
	let total=0;
	let totalEfectCheque = 0
	let EfectCheque= 0
	
	let contenidoIOtros = "<table  class='table table-striped'  style='width: 100%;margin-bottom: 0px'>"+
								"<tbody>"+
									"<tr>"+
										"<td colspan='9'  style=' border:1px solid #D3D3D3'>"+
											"<label style='font-family: arial;font-size: 14px;color:#013ADF;font-weight:bold; margin: 0px'>OTROS INGRESOS </label>"+
										"</td>"+
									"</tr>";
	for(let i=0; i < polizaIngresosOtros.length ; i++)
	{
		totalRow= 	parseFloat(polizaIngresosOtros[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',','')) + 
					parseFloat(polizaIngresosOtros[i].importe_cheque.replace(',','').replace(',','').replace(',','').replace(',','')) +
					parseFloat(polizaIngresosOtros[i].importe_tCredito.replace(',','').replace(',','').replace(',','').replace(',','')) + 
					parseFloat(polizaIngresosOtros[i].importe_tDebito.replace(',','').replace(',','').replace(',','').replace(',','')) +
					parseFloat(polizaIngresosOtros[i].importe_transferencia.replace(',','').replace(',','').replace(',','').replace(',','')) ;
				
		total = parseFloat(total) + parseFloat(totalRow);
		totalRow = validaImporte(totalRow)
		
		totalEfectivo = parseFloat(totalEfectivo) + parseFloat(polizaIngresosOtros[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',',''));
		totalCheque= parseFloat(totalCheque) +  parseFloat(polizaIngresosOtros[i].importe_cheque.replace(',','').replace(',','').replace(',','').replace(',',''));
		totalTransferencia= parseFloat(totalTransferencia) +  parseFloat(polizaIngresosOtros[i].importe_transferencia.replace(',','').replace(',','').replace(',','').replace(',',''));
		totalTCredito= parseFloat(totalTCredito) + parseFloat(polizaIngresosOtros[i].importe_tCredito.replace(',','').replace(',','').replace(',','').replace(',',''));
		totalTDebito= parseFloat(totalTDebito) + parseFloat(polizaIngresosOtros[i].importe_tDebito.replace(',','').replace(',','').replace(',','').replace(',','')) ; 
		totalPosfechado= parseFloat(totalPosfechado) + parseFloat(polizaIngresosOtros[i].importe_posfechado.replace(',','').replace(',','').replace(',','').replace(',',''));
		EfectCheque=  parseFloat(polizaIngresosOtros[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',','')) + parseFloat(polizaIngresosOtros[i].importe_cheque.replace(',','').replace(',','').replace(',','').replace(',',''));
		totalEfectCheque= totalEfectCheque + EfectCheque; 
	
		contenidoIOtros +="<tr>"+
								"<td style='padding: 4px; display:none;'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>"+
										polizaIngresosOtros[i].id_otro_ingreso+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>"+
										polizaIngresosOtros[i].nombre_otro_ingreso+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
										polizaIngresosOtros[i].importe_efectivo+
									" </label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
										polizaIngresosOtros[i].importe_cheque+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
										validaImporte(EfectCheque)+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
										polizaIngresosOtros[i].importe_tCredito+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
										polizaIngresosOtros[i].importe_tDebito+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$"+ 
										polizaIngresosOtros[i].importe_transferencia+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+ 
										polizaIngresosOtros[i].importe_posfechado+
									"</label>"+
								"</td>"+
								"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
									"<label  style='font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
										totalRow+
									"</label>"+
								"</td>"+
							"</tr>";
	}
	
	totalEfectivo = validaImporte(totalEfectivo)
	totalCheque = validaImporte(totalCheque)
	totalTransferencia = validaImporte(totalTransferencia)
	totalTCredito = validaImporte(totalTCredito)
	totalTDebito = validaImporte(totalTDebito)
	totalPosfechado = validaImporte(totalPosfechado)
	total = validaImporte(total)
	totalEfectCheque = validaImporte(totalEfectCheque)
	
	contenidoIOtros +="<tr style='background-color: #B8DAFF; border: 1px solid #7ABAFF;'>"+
						 	"<td style='padding: 4px; display:none;'></td>"+
						 	"<td style='padding: 4px;width: 15%' align='left'></td>"+
						 	"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									totalEfectivo+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label  style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									totalCheque+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label  style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									totalEfectCheque+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'> "+
								"<label  style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$"+ 
									totalTCredito+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label  style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									totalTDebito+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label  style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$  "+
									totalTransferencia+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; background-color: #FFEEBA; border:1px solid #FFDF7E' align='right'>"+
								"<label  style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									totalPosfechado+
								"</label>"+
							"</td>"+
							"<td style='padding: 4px;width: 10%; border:1px solid #D3D3D3' align='right'>"+
								"<label  style='color:black;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									total+
								"</label>"+
							"</td>"+
						"</tr>"+
					"</tbody>"+
				"</table>";
	return contenidoIOtros;	
}

/* POLIZA  SEGMENTO RECOLECCION VALORES */
function  generaContenidoRecoleccionValores(polizaRValores)
{
	let total=0;		
	let contenidoRV = "<table class='table table-striped'  style='width: 100%; margin-bottom: 0px'>"+
							"<tbody>"+
								"<tr>"+
									"<td colspan='9'  style=' border:1px solid #D3D3D3'>"+
										"<label style='color:black;font-family: arial;font-size: 14px;font-weight:bold; margin: 0px'>REC. DE VALORES</label>"+
									"</td>"+
								"</tr>";
	
	for(let i=0; i < polizaRValores.length ; i++)
	{
		total = parseFloat(total) + parseFloat(polizaRValores[i].importe.replace(',','').replace(',','').replace(',','').replace(',',''));
		
		contenidoRV +="<tr>"+
						 	"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3' align='left'>"+
						 		"<label style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>"+
									"FOLIO REC. VAL.:"  + polizaRValores[i].folio_panamericano+
								"</label>"+
						 	"</td>"+
						 	"<td style='padding: 4px;width: 85%; border:1px solid #D3D3D3' align='right'>"+
						 		"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
						 			polizaRValores[i].importe+
								"</label>"+
						 	"</td>"+
						"</tr>	"
	}
	
	total = validaImporte(total)
	
	contenidoRV += "<tr>"+
						"<td colspan='2' style='padding: 4px;width: 100%; background-color: black; border: 1px solid black;' align='right'>"+
							"<label  style='font-weight: bold; color:white; font-family: arial; font-size: 11px;margin: 0px '>$ "+
								total+
							"</label>"+
						"</td>"+
					"</tr>"+					
				"</tbody>"+
			"</table>";
	return contenidoRV;
	
}

/* POLIZA INGRESOS TOTALES DE BANCOS  */
function  generaContenidoTotalesBancos(totalPolizaIngresosBancos, totalPolizaEgresos,polizaIngresosOtros)
{
	let totalBancos= parseFloat(totalPolizaIngresosBancos) - parseFloat(totalPolizaEgresos.replace('-','')) ;
	totalBancos = validaImporte(totalBancos);
	totalPolizaEgresos =totalPolizaEgresos.replace('-','');
	totalPolizaEgresos =validaImporte(parseFloat(totalPolizaEgresos));
	totalPolizaEgresos= '-'+ totalPolizaEgresos
	totalPolizaIngresosBancos = validaImporte(totalPolizaIngresosBancos)
	
	
	let totalO=0;
	
	
	for(let i=0; i < polizaIngresosOtros.length ; i++)
	{
		let totalRowO= 	parseFloat(polizaIngresosOtros[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',','')) + 
					parseFloat(polizaIngresosOtros[i].importe_cheque.replace(',','').replace(',','').replace(',','').replace(',','')) +
					parseFloat(polizaIngresosOtros[i].importe_tCredito.replace(',','').replace(',','').replace(',','').replace(',','')) + 
					parseFloat(polizaIngresosOtros[i].importe_tDebito.replace(',','').replace(',','').replace(',','').replace(',','')) +
					parseFloat(polizaIngresosOtros[i].importe_transferencia.replace(',','').replace(',','').replace(',','').replace(',','')) ;
				
		totalO = parseFloat(totalO) + parseFloat(totalRowO);
	}
	
	totalPolizaIngresosBancos =parseFloat(totalPolizaIngresosBancos.replace(',','').replace(',','').replace(',','').replace(',','')) -parseFloat(totalO) ;
	totalPolizaIngresosBancos= validaImporte(totalPolizaIngresosBancos)
		
		
	let contenidoTotal = "<table class='table table-striped'  style='width: 100%; margin-bottom: 0px'>"+
							"<tbody>"+
								"<tr>"+
									"<td colspan='3'  style='border:1px solid #D3D3D3'>"+
										"<label  style='color:blcak;font-family: arial;font-size: 14px;font-weight:bold; margin: 0px'>TOTALES</label>"+
									"</td>"+
								"</tr>"+
								"<tr>"+
									"<td style='padding: 4px; display:none;'>"+
										"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>0</label>"+
									"</td>"+								
									 "<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3' align='left'>"+
										"<label style='font-family: arial; font-size: 11px;margin: 0px'>INGRESOS</label></td>"+										
									
								 	"<td style='padding: 4px;width: 85%; border:1px solid #D3D3D3' align='right'>"+
								 		"<label  style='font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
								 			totalPolizaIngresosBancos+
										"</label>"+
								 	"</td>"+
								"</tr>"+
								"<tr>"+
									"<td style='padding: 4px; display:none;'>"+
										"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>0</label>"+
									"</td>"+								
									 "<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3' align='left'>"+
										"<label style='font-family: arial; font-size: 11px;margin: 0px'>EGRESOS</label>" +
									"</td>"+
								 	"<td style='padding: 4px;width: 85%; border:1px solid #D3D3D3' align='right'>"+
								 		"<label  style='font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'> $ "+
								 			totalPolizaEgresos +
										"</label>"+
								 	"</td>"+								 	
								"</tr>"+
								"<tr  style='background-color:black; border:1px solid black;'>"+
									"<td style='padding: 4px; display:none;'>"+
										"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>0</label>"+
									"</td>"+								
									 "<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3' align='left'>"+
										"<label style='color:white;font-family: arial; font-size: 11px;margin: 0px'></label></td>"+										
									
								 	"<td style='padding: 4px;width:85%; border:1px solid #D3D3D3' align='right'>"+
								 		"<label  style='color:white;font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
								 			totalBancos + 
										"</label>"+
								 	"</td>"+
								 	
								"</tr>"+
							"</tbody>"+
						"</table>";
	return contenidoTotal;
			
}


/* POLIZA  CONTENIDO FICHAS BANCARIAS */
function generaContenidoFichasBancarias(listafichasBancarias)
{
	let contenido = "<table class='table table-striped'  style='width: 100%; margin-bottom: 0px'>"+
							"<tbody>"+
									"<tr>"+
									"<td colspan='4'  style=' border:1px solid #D3D3D3'>"+
										"<label  style='color:black;font-family: arial;font-size: 14px;font-weight:bold; margin: 0px'> FICHAS BANCARIAS CHEQUES</label>"+
									"</td>"+
								"</tr>"+
								"<tr style='background-color: #DCDCDC'>"+
									"<td  style='width: 15%; border:1px solid #D3D3D3; text-align: center'>"+
										"<label  style='color:black;font-family: arial;font-size: 12px;font-weight:bold; margin: 0px'> Banco </label>"+
									"</td>"+
									"<td  style='width: 28%; border:1px solid #D3D3D3;text-align: center'>"+
										"<label  style='color:black;font-family: arial;font-size: 12px;font-weight:bold; margin: 0px'> Ficha Deposito </label>"+
									"</td>"+
									"<td  style='width: 28%; border:1px solid #D3D3D3;text-align: center'>"+
										"<label  style='color:black;font-family: arial;font-size: 12px;font-weight:bold; margin: 0px'> Importe </label>"+
									"</td>"+
									"<td  style='width: 28%; border:1px solid #D3D3D3;text-align: center'>"+
										"<label  style='color:black;font-family: arial;font-size: 12px;font-weight:bold; margin: 0px'> Acumulado </label>"+
									"</td>"+
								"</tr>"	;
	for(let i=0; i < listafichasBancarias.length ; i++)
	{
		contenido +="<tr>"+
						"<td style='padding: 4px; display:none;'>"+
						"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>0</label>"+
					"</td>"+
				 	"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3' align='left'><label style='font-family: arial; font-size: 11px;margin: 0px; font-weight: normal'>" +listafichasBancarias[i].banco + "</label></td>"+
				 	"<td style='padding: 4px;width: 28%; border:1px solid #D3D3D3' align='left'><label style='font-family: arial; font-size: 11px;margin: 0px; font-weight: normal'>" +listafichasBancarias[i].ficha_bancaria +"</label></td>"+
				 	"<td style='padding: 4px;width:28%; border:1px solid #D3D3D3; border-left: 0px; border-right: 0px' align='right'>"+
				 		"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'> $ "+
				 		listafichasBancarias[i].importe + 
						"</label>"+
				 	"</td>"+
				 	"<td style='padding: 4px;width:28%; border:1px solid #D3D3D3; ' align='right'>"+
					 	"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'> $ "+
				 			listafichasBancarias[i].acumulado + 
						"</label>"+
				 	"</td>	"+
				" </tr>";
	}

	contenido += " </tbody>"+
		" </table>"+
		" <BR>	";
	
	return contenido;
}


/* POLIZA  CONTENIDO FICHAS BANCARIAS EGRESOS */
function generaContenidoFichasBancariasEgresos(listafichasBancariasEgresos)
{
	let contenido = "<table class='table table-striped'  style='width: 100%; margin-bottom: 0px'>"+
							"<tbody>"+
									"<tr>"+
									"<td colspan='4'  style=' border:1px solid #D3D3D3'>"+
										"<label  style='color:black;font-family: arial;font-size: 14px;font-weight:bold; margin: 0px'> TRANSFERENCIAS BANCARIAS EGRESOS </label>"+
									"</td>"+
								"</tr>"+
								"<tr style='background-color: #DCDCDC'>"+
									"<td  style='width: 15%; border:1px solid #D3D3D3; text-align: center'>"+
										"<label  style='color:black;font-family: arial;font-size: 12px;font-weight:bold; margin: 0px'> Banco </label>"+
									"</td>"+
									"<td  style='width: 28%; border:1px solid #D3D3D3;text-align: center'>"+
										"<label  style='color:black;font-family: arial;font-size: 12px;font-weight:bold; margin: 0px'> Numero de Autorizacion </label>"+
									"</td>"+
									"<td  style='width: 28%; border:1px solid #D3D3D3;text-align: center'>"+
										"<label  style='color:black;font-family: arial;font-size: 12px;font-weight:bold; margin: 0px'> Importe </label>"+
									"</td>"+
									"<td  style='width: 28%; border:1px solid #D3D3D3;text-align: center'>"+
										"<label  style='color:black;font-family: arial;font-size: 12px;font-weight:bold; margin: 0px'> Acumulado </label>"+
									"</td>"+
								"</tr>"	;
	for(let i=0; i < listafichasBancariasEgresos.length ; i++)
	{
		contenido +="<tr>"+
						"<td style='padding: 4px; display:none;'>"+
						"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>0</label>"+
					"</td>"+
				 	"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3' align='left'><label style='font-family: arial; font-size: 11px;margin: 0px; font-weight: normal'>" +listafichasBancariasEgresos[i].banco + "</label></td>"+
				 	"<td style='padding: 4px;width: 28%; border:1px solid #D3D3D3' align='left'><label style='font-family: arial; font-size: 11px;margin: 0px; font-weight: normal'>" +listafichasBancariasEgresos[i].ficha_bancaria +"</label></td>"+
				 	"<td style='padding: 4px;width:28%; border:1px solid #D3D3D3; border-left: 0px; border-right: 0px' align='right'>"+
				 		"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'> $ "+
				 		listafichasBancariasEgresos[i].importe + 
						"</label>"+
				 	"</td>"+
				 	"<td style='padding: 4px;width:28%; border:1px solid #D3D3D3; ' align='right'>"+
					 	"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'> $ "+
					 	listafichasBancariasEgresos[i].acumulado + 
						"</label>"+
				 	"</td>	"+
				" </tr>";
	}

	contenido += " </tbody>"+
		" </table>"+
		" <BR>	";
	
	return contenido;
}

/* POLIZA INGRESOS SEGMENTO TOTALES SE DESHABILITA EN LA SEGUNDA VERSION */
function  generaContenidoTotales(totalPolizaIngresos, totalPolizaEgresos)
{
	let total= parseFloat(totalPolizaIngresos) + parseFloat(totalPolizaEgresos);
	totalPolizaIngresos = validaImporte(parseFloat(totalPolizaIngresos))
	totalPolizaEgresos = validaImporte(parseFloat(totalPolizaEgresos))
	total = validaImporte(total)
	
	let contenidoTotal = "<table class='table table-striped'  style='width: 100%; margin-bottom: 0px'>"+
								"<tbody>"+
									"<tr>"+
										"<td colspan='9'  style='border:1px solid #D3D3D3'>"+
											"<label  style='color:#088A08;font-family: arial;font-size: 14px;font-weight:bold; margin: 0px'>TOTALES  DE POLIZA</label>"+
										"</td>"+
									"</tr>"+
									"<tr>"+
									 	"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3' align='left'>"+
											"<label style='font-family: arial; font-size: 11px;margin: 0px'>INGRESOS</label></td>"+
									 	"<td style='padding: 4px;width: 85%; border:1px solid #D3D3D3' align='right'>"+
									 		"<label  style='font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									 			totalPolizaIngresos+
											"</label>"+
									 	"</td>"+
									"</tr>"+
									"<tr>"+
									 	"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3' align='left'>"+
											"<label  style='font-family: arial; font-size: 11px;margin: 0px'>ERESOS</label></td>"+
									 	"<td style='padding: 4px;width: 85%; border:1px solid #D3D3D3' align='right'>"+
									 		"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									 			totalPolizaEgresos+
											"</label>"+
									 	"</td>"+
									"</tr>"+
									"<tr>"+
										"<td colspan='2' style='padding: 4px;width: 100%; background-color: #C3E6CB; border:1px solid #8FD19E;' align='right'>"+
											"<label style='font-weight: bold; color:black; font-family: arial; font-size: 11px;margin: 0px '>$ "+
												total+
											"</label>"+
										"</td>"+
									"</tr>"+
								"</tbody>"+
							"</table>";
	return contenidoTotal;
}

/* POLIZA  SEGMENTO TRANSITO */
function  generaContenidoCobranzaTransito(transitoPendiente, transitoAplicado)
{
	let contenidoTransito = "<table class='table table-striped'  style='width: 100%; margin-bottom: 0px'>"+
								"<tbody>"+
									"<tr>"+
										"<td colspan='9'  style='border:1px solid #D3D3D3'>"+
											"<label  style='color:black;font-family: arial;font-size: 14px;font-weight:bold; margin: 0px'>COBRANZA</label>"+
										"</td>"+
									"</tr>"+
									"<tr>"+
									 	"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3' align='left'>"+
											"<label style='font-family: arial; font-size: 11px;margin: 0px;font-weight: normal'>EN TRANSITO</label></td>"+
									 	"<td style='padding: 4px;width: 85%; border:1px solid #D3D3D3' align='right'>"+
									 		"<label  style='font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									 			transitoPendiente+
											"</label>"+
									 	"</td>"+
									"</tr>"+
									"<tr>"+
									 	"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3' align='left'>"+
											"<label  style='font-family: arial; font-size: 11px;margin: 0px;font-weight: normal'>EN TRANSITO APLICADA</label></td>"+
									 	"<td style='padding: 4px;width: 85%; border:1px solid #D3D3D3' align='right'>"+
									 		"<label  style='font-weight: bold; font-family: arial; font-size: 11px;margin: 0px'>$ "+
									 			transitoAplicado+
											"</label>"+
									 	"</td>"+
									"</tr>"+
									"<tr>"+
										"<td colspan='2' style='padding: 4px;width: 100%; background-color: black; border:1px solid black;' align='right'>"+
											"<label style='font-weight: bold; color:black; font-family: arial; font-size: 11px;margin: 0px '> "+
												
											"</label>"+
										"</td>"+
									"</tr>"+
								"</tbody>"+
							"</table>";
	return contenidoTransito;
}


/*  SEGMENTO POLIZA CONTABLE  */
function  generaContenidoPolizaContable(polizaContable)
{
	let contenidoPolContable = "<table class='table table-striped'  style='width: 100%; margin-bottom: 0px'>"+
									"<tbody>"+
										"<tr>"+
											"<td colspan='9'  style='border:1px solid #D3D3D3; background-color:#F0F8FF'>"+
												"<label  style='color:black;font-family: arial;font-size: 14px;font-weight:bold; margin: 0px'>POLIZA CONTABLE</label>"+
											"</td>"+
										"</tr>";
	
	for(let i=0; i < polizaContable.length ; i++)
	{
		let importe=  polizaContable[i].importe_total;
		contenidoPolContable +="<tr>"+
									 	"<td style='padding: 4px;width: 15%; border:1px solid #D3D3D3' align='left'>"+
								 		"<label style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>" + polizaContable[i].descripcion_contable + "</label>"+
								 	"</td>"+
								 	"<td style='padding: 4px;width: 85%; border:1px solid #D3D3D3' align='right'>"+
								 		"<label  style='font-weight: normal; font-family: arial; font-size: 11px;margin: 0px'>$ "+
								 		polizaContable[i].importe_total +
										"</label>"+
								 	"</td>"+
								"</tr>";	
	}
	contenidoPolContable += "<tr>"+
								"<td colspan='2' style='padding: 4px;width: 100%; background-color: #4169E1; border: 1px solid #4169E1;' align='right'>"+
								"<label  style=''font-weight: bold; color:white; font-family: arial; font-size: 11px;margin: 0px'></label>"+
							"</td>"+
							"</tr>	"+
							"</tbody>"+
						  "</table>";
	
	return contenidoPolContable;	
}






function validaImporte(importe)
{
	if(importe == "") 
		importe= "0.00";
	else
		importe=agregarCommas(importe.toFixed(2));
	
	return importe;
}

function calculaImportesDeEgresos(tipoEgreso, polizaEgresos)
{
	let totalRow = 0;
	switch(tipoEgreso)
	{
		case 'ChequeDevuelto':
			for(let i=0; i < polizaEgresos.length ; i++)
			{
				 if(polizaEgresos[i].tipo_egreso  == 5)
				 {
					 totalRow= parseFloat(totalRow) + parseFloat(polizaEgresos[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',',''));
				 }
			}
			break;
			
			
		case 'Egresos':
			for(let i=0; i < polizaEgresos.length ; i++)
			{
				 if(polizaEgresos[i].tipo_egreso  != 5)
				 {
					 totalRow= parseFloat(totalRow) + parseFloat(polizaEgresos[i].importe_efectivo.replace(',','').replace(',','').replace(',','').replace(',',''));
				 }
			}
			break;
	}
	
	return totalRow;
}



/***** CONSULTA CORTE DE PANAMERICANO *****/
function consultaCorteDePanamericanoBD()
{
	OcultarDiv('divMjsCortePanamericano')
	document.getElementById('cargando').style.display = 'block';		 
	 $.ajax({
	    url :'ConsultasDeCortes', 
	    data : "vista=ConsultasDeCortes.jsp&operacion=ConsultarCortesPanamericano&fechaCortePanamericano=" + $('#txt_fechaCortePanamericano').val()+ "&folioCortePanamericano=" + $('#txt_folioCortePanamericano').val() + "&uname_consulta="  + $('#cmbCdoMantoCortePanamericano').val() , 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(jsonPanamericano)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
	    	if(jsonPanamericano.folio_panamericano > 0)
	    	{
	    		MostrarDiv('div_ficha_bancariaConsulta')	    	
		    	colocaimporteEnFichaBancaria(jsonPanamericano)		    			    	
	    	}
	    	else
	    	{
	    		OcultarDiv('div_ficha_bancariaConsulta')
	    		MostrarDiv('divMjsCortePanamericano')
	    		divMjsCortePanamericano
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
				alert('Error al buscar cortes de panamericano.')
		}
	});
}

function colocaimporteEnFichaBancaria(jsonPanamericano)
{
	$("#div_listaImporteEfectivoConsulta").empty();
	let contenidoDivEfectivo = " <table align='center' width='90%'>" +
									"<tr> " +
									"<td valign='bottom' align='right' style='font-weight: bold; font-size: 20px'>$</td> " ;
	
	var arrayImporte = jsonPanamericano.importe.split("/");
	
	for (let item = 0; item < arrayImporte.length; item++) 
	{
		contenidoDivEfectivo += " <td align='center'  style='border:1px solid #C0C0C0; font-size:16px; font-weight: bold' >" +
								 arrayImporte[item] +
								" </td>";	
	}
	contenidoDivEfectivo += "</tr> </table>";
	$("#div_listaImporteEfectivoConsulta").append(contenidoDivEfectivo);
	
	$('#lb_folioPanamericano').text(jsonPanamericano.folio_panamericano)
	$('#lb_papeletaPanamericano').text(jsonPanamericano.papeleta)
	$('#lb_plomoPanamericano').text(jsonPanamericano.plomo)
	$('#lb_fechaProPanamericano').text(jsonPanamericano.fecha_pro)
	$('#lb_hora_proPanamericano').text(jsonPanamericano.hora_pro)
	
	$('#NumPapeletaFichaBanConsulta').text(jsonPanamericano.papeleta)
	$('#NumPlomoFichaBanConsulta').text(jsonPanamericano.plomo)
	
}






















