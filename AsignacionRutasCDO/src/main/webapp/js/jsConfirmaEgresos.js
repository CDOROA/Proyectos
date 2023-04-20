/***   INICIA MODULO DE EGRESOS  ***/
function MuestraPanel (div, menu)
{
	var divMostrar ="#" + div;
	var MunuActivo ="#" + menu;
    $(divMostrar).show();
    $(MunuActivo).css('background-color', '#337AB7');
}

function IniciaModuloEgresos(div, menu)
{
	MuestraPanel(div, menu);
	OcultarDiv('divCapturaBanco');
	OcultarDiv('divCapturaCheque');
	$('#cmbEstatus').val("1");
	$('#txt_fechaIni').val(ObtenerFechaActual());
	$('#txt_fechaFin').val(ObtenerFechaActual());
	limpiarCampos();
	consultaEngresosBD();
}

function limpiarCampos()
{
	$('#id_folio').val("");
	$('#id_monto').val("");
	$('#id_cheque').val("");
	$('#numero_trasferencia').val("");
	$('#usuAutorizaEgreso').val("");
	$('#passAutorizaEgreso').val("");
	$('#id_banco').val("0");
	$('#id_bancoDeposito').val("0");	
	$('#id_bancoTransferencia').val("0");
	$("#id_folio").prop("disabled", true);
	$("#id_banco").prop("disabled", true);
	$("#id_bancoDeposito").prop("disabled", true);
	$("#id_cheque").prop("disabled", true);
	OcultarDiv('divMjsExito');
	OcultarDiv('divMjsError');
	$("#btn_guardarNuevoEgreso").attr("disabled", false);
	$("#btn_AtrasfirmaMancomunada").attr("disabled", false);
	$("#btn_AutorizarfirmaMancomunada").attr("disabled", false);
	$("#btn_AtrasfirmaMancomunadaExtra").attr("disabled", false);
	$("#btn_AutorizarfirmaMancomunadaExtra").attr("disabled", false);
}


/***   CONSULTA DE EGRESOS  ***/
function consultaEngresosBD()
{
	validarSessionDelUsuario();
	let fecha_inicio = $('#txt_fechaIni').val();
	let fecha_fin = $('#txt_fechaFin').val();
	let estatus = $('#cmbEstatus').val();
	
	let tipo_egreso = obtenerTipoDeEgresoParaConsulta();
	buscaEngresosPorParametroEnBD(tipo_egreso,fecha_inicio,fecha_fin,  estatus)
	
}

function obtenerTipoDeEgresoParaConsulta()
{
	let tipo_pago = 0 ;
	 $('#cbxsTipoEgreso input:checked').each(function () {
	        let tipo = $(this).attr('id');
	        
	        if(tipo === "CTodos")
	        	tipo_pago = 0;
	        if(tipo === "CPagare")
	        	tipo_pago = 1;
	        if(tipo === "CCheque")
	        	tipo_pago = 2;
	        if(tipo === "CRembolsos")
	        	tipo_pago = 3;
	        if(tipo === "CDeudores")
	        	tipo_pago = 4;
	    });
	 return tipo_pago;
}

function buscaEngresosPorParametroEnBD(tipoEgreso, fecha_inicio, fecha_fin, estatus)
{
	document.getElementById('cargando').style.display = 'block';
	
	$.ajax({
	    url :'ConfirmaEgresos', 
	    data : "vista=ConfirmaEgresos.jsp&operacion=ConsultaEgreso" +"&fecha_ini=" + fecha_inicio  +"&fecha_fin=" + fecha_fin +"&id_estatus=" + estatus +"&tipoEgreso=" + tipoEgreso, 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(respuesta)
	    { 
	        if(respuesta)
        	{
	        	document.getElementById('cargando').style.display = 'none';
	        	var data = respuesta;
		        if( data.length > 0)
	        	{
		        	llenaGridEgresos(data)
		        	MostrarDiv('dgEgresos');
		        	OcultarDiv('divMjsInfo');
	        	}
		        else
	        	{
	        		mostrarMsjInfo('No se encontraron registros en el sistema en el periodo  ' + fecha_inicio +  "  y  " +  fecha_fin);
		        	OcultarDiv('dgEgresos');
		        	document.getElementById('cargando').style.display = 'none';
	        	}
        	}
	        else		        	
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
				alert('Error al buscar egresos.')
		}
	});
}


/***   SECCION DE FUNCIONES PARA CONSTRUIR GRID  ***/
function llenaGridEgresos(data)
{
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	        return $.grep(data, function (ingreso) {
	            return (!filter.nombre_pago || ingreso.nombre_pago.indexOf(filter.nombre_pago) > -1)
	        });
	    },
	    insertItem: function (insertingClient) {
	        data.push(insertingClient);
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {
	    },
	 };
	
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#dgEgresos").jsGrid({
    	    		 width: "90%",
    	             height: "500px",
    	             editing: true,
    	             filtering: true,
    	             sorting: true,
    	             paging: true,
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
    	            	 /** seccion de totales **/
    	            	 let items = args.grid.option("data");
    	            	 let totales= calculaImportesTotalesDelGridEgresos(items)
    	                 let $totalRow = $("<tr>").addClass("total-row");
    	                 args.grid._renderCells($totalRow, totales);
    	                 args.grid._content.append($totalRow);
    	             },
    	             fields: 
    	             [
    	                 { name: "uname", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "uname_br", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "id_egreso",  type: "text", width: 20, align: 'center', editing: false, inserting: false, filtering: true,css: 'EG_hide'},
    	                 { name: "nombre_egreso",  type: "text", title: "TIPO EGRESO",width:20, align: 'center', editing: false, inserting: false, filtering: true,
    	                	 itemTemplate: function (value, item) {
    	                       return crearColumnaTipoEgresoParaGrid(item);
    	                     }
    	                 },
    	                 { name: "folio_caja",  type: "text", title: "FOLIO CAJA", width: 13, align: 'center', editing: false, inserting: false, filtering: true,
    	                	 itemTemplate: function (value, item) {
        	                       return crearColumnaFolioCajaParaGrid(item);
    	                	 		}
    	                 },
    	                 
    	                 { name: "folio_documento",  type: "text", title: "DOCUMENTO", width: 20, align: 'left', editing: false, inserting: false, filtering: true,
    	                	
    	                 },
    	                 { name: "importe",  type: "text", title: "IMPORTE", width: 25, align: 'right', editing: false, inserting: false, filtering: true},
    	                 { name: "cve_forma_pago", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "formPago", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "referencia_cheque",  type: "text", title: "REFERENCIA", width: 25, align: 'left', editing: false, inserting: false, filtering: true},
    	                 { name: "banco_emisor",  type: "text", width: 25, align: 'center', editing: false, inserting: false, filtering: true , css: 'EG_hide'},
    	                 { name: "nombre_banco_emisor",  type: "text", title: "BANCO EMISOR", width: 30, align: 'center', editing: false, inserting: false, filtering: true,
    	                	 itemTemplate: function (value, item) {
    	                        return crearColumnaBancoEmisorParaGrid(item);
    	                     }
    	                 },
    	                 { name: "banco_deposito",  type: "text", width: 25, align: 'center', editing: false, inserting: false, filtering: true , css: 'EG_hide'},
    	                 { name: "nombre_banco_deposito",  type: "text", title: "BANCO DEPOSITO", width: 30, align: 'center', editing: false, inserting: false, filtering: true,
    	                	 itemTemplate: function (value, item) {
    	                        return crearColumnaBancoDepositoParaGrid(item);
    	                     }
    	                 },
    	                 { name: "numero_transferencia",  type: "text", title: "FOLIO TRANSFERENCIA", width: 25, align: 'right', editing: false, inserting: false, filtering: true},    	                 
    	                 { name: "banco_transferencia",  type: "text", width: 25, align: 'center', editing: false, inserting: false, filtering: true , css: 'EG_hide'},
    	                 { name: "nombre_banco_transferencia",  type: "text", title: "BANCO TRANSFERENCIA", width: 30, align: 'center', editing: false, inserting: false, filtering: true,
    	                	 itemTemplate: function (value, item) {
    	                        return crearColumnaBancoTransferenciaParaGrid(item);
    	                     }
    	                 },
    	                 { name: "cve_usu", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "folio_corte_caja",  type: "text", title: "FOLIO", width: 20, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide',},
    	                 { name: "folio_panamericano",  type: "text", title: "FOLIO", width: 20, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide',},
    	                 { name: "folio_poliza",  type: "text", title: "FOLIO", width: 20, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide',},
    	                 { name: "fecha_inicio",  type: "text", title: "FECHA", width: 17, align: 'center', editing: false, inserting: false, filtering: true},
    	                 { name: "id_estatus", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "estatus", type: "text", title: "ESTATUS", width:25, align: 'center', editing: false, inserting: false,   filtering: false,                           	 
    	                	 itemTemplate: function (value, item) {
    	                         return crearColumnaEstatusParaGrid(value);
    	                     }
    	                 },
    	                 { 
    	                	 name: "btnCancelar", type: "text", title: " ", width: 12, align: 'center', editing: false, inserting: false,  filtering: false, 
    	                	 itemTemplate: function (value, item) {
    	                		 if (item.id_estatus == 1 && item.id_egreso != 5) {
    	                             return $("<button>").attr("class", "EG_btnRemover").on("click", function () {
    	                            	 mostrarAlertaDeCancelacion(item);
    	                                 return false;
    	                             });
    	                		 }
    	                     }
    	                 },
	                 ],
	        	 });
	         });
}

function crearColumnaFolioCajaParaGrid(item)
{
	if (item.id_estatus === "2" && item.id_egreso != 5 ) {
        return $("<button>").attr("class", "EG_lb_link").text(item.folio_caja).on("click", function () {
        	mostrarAlertaParaActualizarTransferencia(item);
            return false;
        });
    }
    else {
        return $("<div>").attr("style", "customfamilyfont").text("  " + item.folio_caja + "  ");
    }
}

function crearColumnaTipoEgresoParaGrid(item)
{
	  if (item.id_egreso === 1) {
          return $("<div>").attr("class", "EG_divCOB").text("PAGARE");
      }
      else if (item.id_egreso === 2) {
          return $("<div>").attr("class", "EG_divHR").text("CHEQUE");
      }
      else if (item.id_egreso === 3) {
          return $("<div>").attr("class", "EG_divOI").text("REMBOLSO");
      }
      
      else if (item.id_egreso === 4) {
          return $("<div>").attr("class", "EG_divCON").text("DEUDORES");
      }
	  
      else if (item.id_egreso === 5) {
          return $("<div>").attr("class", "EG_divOTR").text("CH.DEVUELTO");
      }
}

function crearColumnaBancoEmisorParaGrid(item)
{
	if (item.banco_emisor === 0) {
	    return $("<div>").attr("class", "").text("");
	}
	else {
	    return $("<div>").attr("class", "").text(item.nombre_banco_emisor);
	}
}

function crearColumnaBancoDepositoParaGrid(item)
{
	if (item.banco_deposito === 0) {
	    return $("<div>").attr("class", "").text("");
	}
	else {
	    return $("<div>").attr("class", "").text(item.nombre_banco_deposito);
	}
}

function crearColumnaBancoTransferenciaParaGrid(item)
{
	if (item.banco_trasferencia === 0) {
	    return $("<div>").attr("class", "").text("");
	}
	else {
	    return $("<div>").attr("class", "").text(item.nombre_banco_transferencia);
	}
}

function crearColumnaEstatusParaGrid(value)
{
	if (value === "Pendiente") {
        return $("<div>").attr("class", "EG_IPendiente").text(value);
    }
    else if (value === "Confirmado") {
        return $("<div>").attr("class", "EG_IConfirmado").text(value);
    }
    else if (value === "Cancelado") {
        return $("<div>").attr("class", "EG_ICancelado").text(value);
    }
    else if (value === "Corte De Caja") {
        return $("<div>").attr("class", "EG_ICorteDeCaja").text(value);
    }
    else if (value === "Poliza") {
        return $("<div>").attr("class", "EG_IPoliza").text(value);
    }
    
}


/*** SECCION TOTALES DEL GRID  ***/
function calculaImportesTotalesDelGridEgresos(items)
{
	 let total = {
			 uname: "",uname_br: "", folio_caja: "", id_egreso: "",nombre_egreso: "", folio_Caja: "",folio_documento: "TOTAL",importe: 0,cve_forma_pago: "",formPago: "",referencia_cheque: "",
			 banco_emisor: "",nombre_banco_emisor: "",banco_deposito: "" ,nombre_banco_deposito: "", numero_transferencia: "",banco_transferencia: "",nombre_banco_transferencia: "",
			 cve_usu: "", folio_corte_caja: "",folio_panamericano: "", folio_poliza: "",fecha_inicio: "",id_estatus: "",
			 estatus: "",btnCancelar: "",  IsTotal: true
     };
	  
	 items.forEach(function (item){
         total.importe += parseFloat(item.importe.replace(',', ''));        
     });
	  
	 total.importe = "$ " + FormatearTotalesDeGrid(total.importe)
     return total;
}

function FormatearTotalesDeGrid(importe)
{
	let importeTotalGrid = parseFloat(importe).toFixed(2);
	importeTotalGrid = agregarCommas(importeTotalGrid);
	return importeTotalGrid;
}


/*** ACTUALIZAR TRANSFERENCIA DE EGRESO ***/
function mostrarAlertaParaActualizarTransferencia(EActualizado)
{
	validarSessionDelUsuario();
	limpiarCampos()
	MostrarDiv('divActualizaTransferenciaEgreso');
	$("#msjAactualizaTrans").text( EActualizado.nombre_egreso + "-" + EActualizado.folio_caja);	
}

function actualizarTrasferenciaXIDEgreso()
{
	if(validarDatosDeTransferencia())
	{
		let EActualizado = $('#msjAactualizaTrans').text().split("-");
		let id_egreso = obtenerTipoDeEgresoPorNombre(EActualizado[0])
		
		OcultarDiv('divActualizaTransferenciaEgreso');
		$.ajax({
		    url :'ConfirmaEgresos', 
		    data : "vista=ConfirmaEgresos.jsp&operacion=ActualizaTransferenciaEgreso&id_egreso="+ id_egreso+ "&folio="+ EActualizado[1]+  
		    		 "&bancoTransferencia="+ $('#id_bancoTransferencia').val() +  "&numeroTransferencia="+ $('#numero_trasferencia').val() , 
		    type : 'POST',
		    dataType : 'Text',
		    success : function(respuesta)
		    { 
		        if(respuesta)
	        	{
		        	limpiarCampos();
		        	document.getElementById('cargando').style.display = 'none';
		        	consultaEngresosBD();
		        	mostrarMsjExito(" El Egreso se actualizo.");
	        	}
		        else
		        {	
		        	mostrarMsjError(" al actualizar el Egreso.")			        	
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
					alert('Error al actualizar trasferencia de egreso.')
			}
		});
	}
}

function validarDatosDeTransferencia()
{
	if($('#numero_trasferencia').val().length <= 0 || $('#numero_trasferencia').val() == 0)
	{
		alert("Ingresa un numero de trasferencia valido.");
		return false;
	}
				
	if($('#id_bancoTransferencia').val() == 0)
	{
		alert("Selecciona un banco valido.");
		return false;
	}
	return true;
}


/*** REGISTRAR NUEVO EGRESO  ***/
function mostrarAlertaNuevoEgreso()
{
	validarSessionDelUsuario();
	MostrarDiv('divAltaNuevoEgreso');
	limpiarCampos();
}

function validaTipoEgresoAIngresar()
{
	limpiarCampos();
	if(obtenerTipoDeEgresoParaAlta() == 2)
	{
		$("#id_banco").prop("disabled", false);
		$("#id_bancoDeposito").prop("disabled", false);
		$("#id_cheque").prop("disabled", false);
	}
	else
	{
		$("#id_banco").prop("disabled", true);
		$("#id_bancoDeposito").prop("disabled", true);
		$("#id_cheque").prop("disabled", true);
	}
	
	if(obtenerTipoDeEgresoParaAlta() == 3 || obtenerTipoDeEgresoParaAlta() == 4)
		$("#id_folio").prop("disabled", true);
	else
		$("#id_folio").prop("disabled", false);
}

function obtenerTipoDeEgresoParaAlta()
{
	let tipo_pago = 0 ;
	 $('#cbxsTipoEgresoAlta input:checked').each(function () {
	        let tipo = $(this).attr('id');
	        
	        if(tipo === "APagare")
	        	tipo_pago = 1;
	        if(tipo === "ACheque")
	        	tipo_pago = 2;
	        if(tipo === "ARembolso")
	        	tipo_pago = 3;
	        if(tipo === "ADeudores")
	        	tipo_pago = 4;
	    });
	 return tipo_pago;
}

function altaNuevoEgreso()
{
	validarSessionDelUsuario();
	$("#btn_guardarNuevoEgreso").attr("disabled", true);
	let tipo_pago = obtenerTipoDeEgresoParaAlta();
	let numeroDatoIncorrecto = validaDatosParaInsertarEgresos(tipo_pago);
	if(numeroDatoIncorrecto == 0)
	{
		if(tipo_pago == 3 || tipo_pago == 4)
		{
			$('#usuAutorizaEgreso').val("");
			$('#passAutorizaEgreso').val("");
			solicitarFirmaMancomunada();
		}
		else
			insertaEgresoEnBD();
	}
	else
	{
		let msjError= obtieneMensajeError(numeroDatoIncorrecto)
		mostrarMsjError(msjError)
		$("#btn_guardarNuevoEgreso").attr("disabled", false);
		document.getElementById('cargando').style.display = 'none';
	}
}

function insertaEgresoEnBD()
{
	validarSessionDelUsuario();
	document.getElementById('cargando').style.display = 'block';
	let tipo_pago = obtenerTipoDeEgresoParaAlta();
	let folio =0;
	if($('#id_folio').val() != "")
		folio = $('#id_folio').val()
		
	$.ajax({
	    url :'ConfirmaEgresos', 
	    data : "vista=ConfirmaEgresos.jsp&operacion=InsertaEgreso&tipo_pago="+ tipo_pago+ "&folio="+ folio+ "&monto="+ $('#id_monto').val()+ 
	    		"&banco="+ $('#id_banco').val() + "&bancoDeposito="+ $('#id_bancoDeposito').val() +  "&cheque="+ $('#id_cheque').val()+ "&cve_usu_autoriza=" + $('#usuAutorizaEgreso').val() , 
	    type : 'POST',
	    dataType : 'Text',
	    success : function(respuesta)
	    { 
	        if(respuesta)
        	{
	        	limpiarCampos();
	        	document.getElementById('cargando').style.display = 'none';
	        	consultaEngresosBD();
	        	$("#btn_guardarNuevoEgreso").attr("disabled", false);
	        	mostrarMsjExito(" El Egreso se inserto.");
        	}
	        else
	        {	
	        	mostrarMsjError(" al guardar el Egreso.")			     
	        	$("#btn_guardarNuevoEgreso").attr("disabled", false);
	        	document.getElementById('cargando').style.display = 'none';
        	}
		},
		error : function(xhr, status, error)
		{
			$("#btn_guardarNuevoEgreso").attr("disabled", false);
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else
				alert('Error al insertar egreso')
		}
	});
}

function solicitarFirmaMancomunada()
{
	MostrarDiv('divFirmaMancomunada');	
}

function validaFirmaMancomunada()
{
	$("#btn_AtrasfirmaMancomunada").attr("disabled", true);
	$("#btn_AutorizarfirmaMancomunada").attr("disabled", true);
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
	        	$("#btn_AtrasfirmaMancomunada").attr("disabled", false);
	        	$("#btn_AutorizarfirmaMancomunada").attr("disabled", false);
	        	insertaEgresoEnBD();
        	}
	        else
	        {	
	        	document.getElementById('cargando').style.display = 'none';
	        	alert('Los datos del usuario no son correctos.');
	        	$("#btn_AtrasfirmaMancomunada").attr("disabled", false);
	        	$("#btn_AutorizarfirmaMancomunada").attr("disabled", false);
        	}
		},
		error : function(xhr, status, error)
		{
			mostrarMsjError(" al guardar el Egreso.")	
			$("#btn_AtrasfirmaMancomunada").attr("disabled", false);
	        	$("#btn_AutorizarfirmaMancomunada").attr("disabled", false);
			document.getElementById('cargando').style.display = 'none';
		}
	});
}

function validaDatosParaInsertarEgresos(tipoEgreso)
{
	if(tipoEgreso == 1 || tipoEgreso == 2)
	{
		if($('#id_folio').val().length <= 0)
			return 1;
	}
	
	if($('#id_monto').val().length <= 0 || $('#id_monto').val() == 0)
		return 2;
	
	if(tipoEgreso == 2)
	{
		if($('#id_banco').val() == 0)
			return 3;
		
		if($('#id_bancoDeposito').val() == 0)
			return 4;
		
		if($('#id_cheque').val().length <= 0)
			return 5;
	}
		
	return 0;
}

function obtieneMensajeError(id_mensaje)
{
	if(id_mensaje == 1)
		return " Ingresa un folio de documento valido";
	
	if(id_mensaje == 2)
		return " El monto no puede ser 0";
	
	if(id_mensaje == 3)
		return " Selecciona un banco emisor valido";
	
	if(id_mensaje == 4)
		return " Selecciona un banco deposito valido";
	
	if(id_mensaje == 5)
		return " Ingresa la referencia del cheque";
}


/*** CANCELAR EGRESO  ***/
function solicitarFirmaMancomunadaExtra()
{
	MostrarDiv('divFirmaMancomunadaExtra');	
}

function ocultaFirmaMacomunada()
{
	OcultarDiv('divFirmaMancomunada')
	$("#btn_guardarNuevoEgreso").attr("disabled", false);
}

function validaFirmaMancomunadaExtra()
{
	
	$("#btn_AtrasfirmaMancomunadaExtra").attr("disabled", true);
	$("#btn_AutorizarfirmaMancomunadaExtra").attr("disabled", true);
	
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'ConfirmaEgresos', 
	    data : "vista=ConfirmaEgresos.jsp&operacion=ValidarFirmaMancomunada&cve_usu="+ $('#usuAutorizaEgresoExtra').val() + "&password="+ $('#passAutorizaEgresoExtra').val(), 
	    type : 'POST',
	    dataType : 'Text',
	    success : function(respuesta)
	    { 
	        if(respuesta == 'true')
        	{
	        	document.getElementById('cargando').style.display = 'none';	
	        	OcultarDiv('divFirmaMancomunadaExtra');
	        	$("#btn_AtrasfirmaMancomunadaExtra").attr("disabled", false);
	        	$("#btn_AutorizarfirmaMancomunadaExtra").attr("disabled", false);	        	
	        	
	        	MostrarDiv('divECancelacion');
	        	$("#msjECancelacion").text( ECancelado.nombre_egreso + "-" + ECancelado.folio_caja);
        	}
	        else
	        {	
	        	document.getElementById('cargando').style.display = 'none';
	        	alert('Los datos del usuario no son correctos.');
	        	$("#btn_AtrasfirmaMancomunadaExtra").attr("disabled", false);
	        	$("#btn_AutorizarfirmaMancomunadaExtra").attr("disabled", false);
        	}
		},
		error : function(xhr, status, error)
		{
			mostrarMsjError(" al guardar el Egreso.")	
			$("#btn_AtrasfirmaMancomunadaExtra").attr("disabled", false);
	        $("#btn_AutorizarfirmaMancomunadaExtra").attr("disabled", false);
			document.getElementById('cargando').style.display = 'none';
		}
	});
}


function mostrarAlertaDeCancelacion(ECancelado)
{
	validarSessionDelUsuario();
	if(ECancelado.id_egreso == 3 || ECancelado.id_egreso == 4 )
	{
		$("#msjECancelacion").text( ECancelado.nombre_egreso + "-" + ECancelado.folio_caja);
		$('#usuAutorizaEgresoExtra').val("");
		$('#passAutorizaEgresoExtra').val("");
		solicitarFirmaMancomunadaExtra();
	}
	else
	{
		MostrarDiv('divECancelacion');
		$("#msjECancelacion").text( ECancelado.nombre_egreso + "-" + ECancelado.folio_caja);
	}
		
}

function CancelarEgresoXID()
{
	OcultarDiv('divECancelacion');
	document.getElementById('cargando').style.display = 'block';
	 
	let idECancelado = $('#msjECancelacion').text().split("-");
	let id_egreso = obtenerTipoDeEgresoPorNombre(idECancelado[0])
	
	 $.ajax({
		    url :'ConfirmaEgresos', 
		    data : "vista=ConfirmaEgresos.jsp&operacion=CancelaEgreso&folio=" +idECancelado[1]  + "&id_egreso=" +id_egreso , 
		    type : 'POST',
		    dataType : 'Text',
		    success : function(respuesta)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if(respuesta)
		    		{
			    		consultaEngresosBD();
			    		mostrarMsjExito('El egreso fue cancelado ');
		    		}
		    	else
		    		mostrarMsjError(' Al cancelar el egreso.');
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
					alert('Error al cancelar el egreso.')
			}
		});
}

function obtenerTipoDeEgresoPorNombre(tipo)
{
	let id_Egreso = 0 ;
	
    if(tipo === "Pagare")
    	id_Egreso = 1;
    if(tipo === "Cheque")
    	id_Egreso = 2;
    if(tipo === "Rembolso")
    	id_Egreso = 3;
    if(tipo === "Deudores")
    	id_Egreso = 4;
    
	 return id_Egreso;
}
