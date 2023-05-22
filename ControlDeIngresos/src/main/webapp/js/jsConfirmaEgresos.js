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
	$('#id_fecha_polizaEgreso').val(ObtenerFechaActual());
	limpiarCampos();
	consultaEngresosBD();
	configurarMenuPrincipalXPerfilesUsuario();
    validaBotonesAMotrar();
}

function validaBotonesAMotrar()
{
	let nivelUsuario=$("#lbNivel_usuario").text();
	if(nivelUsuario == 0)
	{
		MostrarDiv('btn_NuevoEgreso');
	}
	else if (nivelUsuario == 2)
	{
		OcultarDiv('btn_NuevoEgreso');
	}
	
}

/***   LIMPIA CAMPOS  ***/
function limpiarCampos()
{
	OcultarDiv('divMjsExito');
	OcultarDiv('divMjsError');
	limpiarCamposDeAltaDeEgreso();
	limpiaCamposDeTransferencia();
	habilitarBotones();
	limpiaCamposDeFirmaMancomunada();
}

function limpiaCamposDeFirmaMancomunada()
{
	$('#usuAutorizaEgreso').val("");
	$('#passAutorizaEgreso').val("");
}

function limpiaCamposDeTransferencia()
{
	$('#numero_trasferencia').val("");
	$('#id_bancoTransferencia').val("0");
}

function limpiarCamposDeAltaDeEgreso()
{	
	let id ="";
	inhabilitarCamposAltaDeEgreso()
	$('#cbxsTipoEgresoAlta input:checked').each(function () {
		 id = $(this).attr('id');
	 });
	
	if(id == "APagare")
		 $("#id_folio").prop("disabled", false);
	
	if(id == "ACheque")
	{
		$("#id_folio").prop("disabled", false);
		$("#id_banco").prop("disabled", false);
		$("#id_bancoDeposito").prop("disabled", true);
	}	
}

function inhabilitarCamposAltaDeEgreso()
{
	 $("#id_folio").prop("disabled", true);
	 $("#id_banco").prop("disabled", true);
	 $("#id_bancoDeposito").prop("disabled", true);
	 $("#id_colectivaEgreso").prop("disabled", true);
	 
	 $('#id_folio').val("");
	 $('#id_monto').val("");
	 $('#id_cheque').val("");
	 $('#id_banco').val("0");
	 $('#id_colectivaEgreso').val("0");
	 $('#id_bancoDeposito').val("0");	
}

function habilitarBotones()
{
	$("#btn_guardarNuevoEgreso").attr("disabled", false);
	$("#btn_AtrasfirmaMancomunada").attr("disabled", false);
	$("#btn_AutorizarfirmaMancomunada").attr("disabled", false);
	$("#btn_AtrasfirmaMancomunadaExtra").attr("disabled", false);
	$("#btn_AutorizarfirmaMancomunadaExtra").attr("disabled", false);
}


/***   CONSULTA DE EGRESOS  ***/
function consultaEngresosBD()
{
	
	$("dgEgresos").jsGrid("option", "data", []);
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
	        if(tipo === "CRedondeo")
	        	tipo_pago = 6;
	        if(tipo === "CNomina")
	        	tipo_pago = 7;
	    });
	 return tipo_pago;
}

function buscaEngresosPorParametroEnBD(tipoEgreso, fecha_inicio, fecha_fin, estatus)
{
	document.getElementById('cargando').style.display = 'block';
	
	$("#lb_mj_pol_generadas").text('')
	$.ajax({
	    url :'ConfirmaEgresos', 
	    data : "vista=ConfirmaEgresos.jsp&operacion=ConsultaEgreso" +"&fecha_ini=" + fecha_inicio  +"&fecha_fin=" + fecha_fin +"&id_estatus=" + estatus +"&tipoEgreso=" + tipoEgreso, 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	var dataEgresos = json.listaEgresos;
	    	var dataSemaforoEgresos = json.listaSemaforoIngresos;
	    	let polizaAntGenerada = json.polAntGeneradas;
	    	let fecha_ultima_poliza = json.fechaUltimaPoliza;
	    	
	        if(dataEgresos.length > 0)
        	{
	        	document.getElementById('cargando').style.display = 'none';
	        	if(dataEgresos.length > 0)
	        	{
	        		OcultarDiv('divMjsInfo');
	        		
	        		llenaGridEgresos(dataEgresos)
	        	}	
	        	else
	        	{
	        		mostrarMsjInfo('No se encontraron registros en el sistema en el periodo  ' + fecha_inicio +  "  y  " +  fecha_fin);
	        		OcultarDiv('dgEgresos')
	        	}
        	}
	        else
        	{
	        	document.getElementById('cargando').style.display = 'none';
        		mostrarMsjInfo('No se encontraron registros en el sistema en el periodo  ' + fecha_inicio +  "  y  " +  fecha_fin);
	        	OcultarDiv('dgEgresos');
        	}
	        
	        
	        $(function ()
   		     {
	        	  validaPolizasDiasanteriores(polizaAntGenerada)
   		     });
   	    	
   	    	 $(function ()
   		     {
   	    		 inicializarDatosDelSemaoforoDeIngresos(dataSemaforoEgresos, polizaAntGenerada);
   		     });
        
	        
	      
	       
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

function validaPolizasDiasanteriores(polizaAntGenerada)
{
	let unameUsu=$("#lbUname_br_usu").text();	
	let unameBrUsu=$("#lbUname_usu").text();	
	if(unameUsu != unameBrUsu)
	{
		if(polizaAntGenerada == false)
		{
			$("#tdCorteDeCaja").addClass("disabledMenu");
			$("#mm_ChequesPosfechados").addClass("disabledMenu");
			$("#mm_ChequeDevuelto").addClass("disabledMenu");
			$("#mm_MantoCheques").addClass("disabledMenu");
			$("#mm_OtrosPagos").addClass("disabledMenu");
			$("#mm_Panamericano").addClass("disabledMenu");
			$("#mm_Poliza").addClass("disabledMenu");
			$("#mm_ConsultaCortes").addClass("disabledMenu");
			document.getElementById("tdCorteDeCaja").disabled = true;
			document.getElementById("mm_ChequesPosfechados").disabled = true;
			document.getElementById("mm_ChequeDevuelto").disabled = true;
			document.getElementById("mm_MantoCheques").disabled = true;
			document.getElementById("mm_OtrosPagos").disabled = true;
			document.getElementById("mm_Panamericano").disabled = true;
			document.getElementById("mm_Poliza").disabled = true;
			document.getElementById("mm_ConsultaCortes").disabled = true;
			$("#lb_mj_pol_generadas").text('NO SE GENERO LA POLIZA DEL DIA ANTERIOR')
			alert('NO SE GENERO LA POLIZA DEL DIA ANTERIOR')	
		}
		else
		{
			
			$("#mm_ChequesPosfechados").addClass("EnableMenu");
			$("#mm_ChequeDevuelto").addClass("EnableMenu");
			$("#mm_MantoCheques").addClass("EnableMenu");
			$("#mm_OtrosPagos").addClass("EnableMenu");
			$("#mm_Panamericano").addClass("EnableMenu");
			$("#mm_Poliza").addClass("EnableMenu");
			$("#mm_ConsultaCortes").addClass("EnableMenu");
			$("#tdCorteDeCaja").addClass("EnableMenu");			
			document.getElementById("mm_ChequesPosfechados").disabled = false;
			document.getElementById("mm_ChequeDevuelto").disabled = false;
			document.getElementById("mm_MantoCheques").disabled = false;
			document.getElementById("mm_OtrosPagos").disabled = false;
			document.getElementById("mm_Panamericano").disabled = false;
			document.getElementById("mm_Poliza").disabled = false;
			document.getElementById("mm_ConsultaCortes").disabled = false;
			document.getElementById("tdCorteDeCaja").disabled = false;
			$("#lb_mj_pol_generadas").text('')
		}
	}
	else
	{
		$("#tdCorteDeCaja").addClass("EnableMenu");
		$("#mm_ChequesPosfechados").addClass("EnableMenu");
		$("#mm_ChequeDevuelto").addClass("EnableMenu");
		$("#mm_MantoCheques").addClass("EnableMenu");
		$("#mm_OtrosPagos").addClass("EnableMenu");
		$("#mm_Panamericano").addClass("EnableMenu");
		$("#mm_Poliza").addClass("EnableMenu");
		$("#mm_ConsultaCortes").addClass("EnableMenu");
		document.getElementById("tdCorteDeCaja").disabled = false;
		document.getElementById("mm_ChequesPosfechados").disabled = false;
		document.getElementById("mm_ChequeDevuelto").disabled = false;
		document.getElementById("mm_MantoCheques").disabled = false;
		document.getElementById("mm_OtrosPagos").disabled = false;
		document.getElementById("mm_Panamericano").disabled = false;
		document.getElementById("mm_Poliza").disabled = false;
		document.getElementById("mm_ConsultaCortes").disabled = false;
		$("#lb_mj_pol_generadas").text('')
	}
}

function inicializarDatosDelSemaoforoDeIngresos(dtSemaforo, polizaAntGenerada)
{
	
	$("#lbEfectivoDisponible").text(dtSemaforo[0].importe_actual);
	
	$('#lb_importe_actual').text("$ " + dtSemaforo[0].importe_actual);
	$('#lb_importe_minimo').text("Limite: $" + dtSemaforo[0].importe_minimo);
	$('#lb_importe_maximo').text("Maximo: $" + dtSemaforo[0].importe_maximo);
	aplicarValoresAlSemaforo(dtSemaforo[0].importe_actual.replace(',','').replace(',','').replace(',',''), 
							 dtSemaforo[0].importe_minimo.replace(',','').replace(',','').replace(',',''), 
							 dtSemaforo[0].importe_maximo.replace(',','').replace(',','').replace(',',''));
	
	validarImportesDeSemaforo(dtSemaforo, polizaAntGenerada);
}


function validarImportesDeSemaforo(dtSemaforo, polizaAntGenerada)
{	
	let unameUsu=$("#lbUname_br_usu").text();	
	let unameBrUsu=$("#lbUname_usu").text();	
	if(unameUsu != unameBrUsu)
	{
		let importeMaximo =  parseFloat(dtSemaforo[0].importe_maximo.replace(',','').replace(',','').replace(',','').replace(',','').replace(',',''))
		let importeAct =  parseFloat(dtSemaforo[0].importe_actual.replace(',','').replace(',','').replace(',','').replace(',',''))
		
		if(importeAct >= importeMaximo && polizaAntGenerada == false)
		{
			OcultarDiv('dgIngresos');
			$("#tdCorteDeCaja").addClass("disabledMenu");
			$("#mm_ConfirmaEgresos").addClass("disabledMenu");
			$("#mm_ChequesPosfechados").addClass("disabledMenu");
			$("#mm_ChequeDevuelto").addClass("disabledMenu");
			$("#mm_MantoCheques").addClass("disabledMenu");
			$("#mm_PagosCaja").addClass("disabledMenu");
			$("#mm_OtrosPagos").addClass("disabledMenu");
			$("#mm_Panamericano").addClass("disabledMenu");
			$("#mm_Poliza").addClass("disabledMenu");
			$("#mm_ConsultaCortes").addClass("disabledMenu");
			document.getElementById("tdCorteDeCaja").disabled = true;
			document.getElementById("mm_ConfirmaEgresos").disabled = true
			document.getElementById("mm_ChequesPosfechados").disabled = true;
			document.getElementById("mm_ChequeDevuelto").disabled = true;
			document.getElementById("mm_MantoCheques").disabled = true;
			document.getElementById("mm_PagosCaja").disabled = true;
			document.getElementById("mm_OtrosPagos").disabled = true;
			document.getElementById("mm_Panamericano").disabled = true;
			document.getElementById("mm_Poliza").disabled = true;
			document.getElementById("mm_ConsultaCortes").disabled = true;
			$("#lbInformacionSemaforo").text('Se ha sobrepasado el efectivo permitido, realiza un Corte de Caja.')
		}
		else if(importeAct >= importeMaximo)
		{
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
			OcultarDiv('dgEgresos');
			$("#lbInformacionSemaforo").text('Se ha sobrepasado el efectivo permitido, realiza un Corte de Caja.')
			alert('Se ha sobrepasado el efectivo permitido, realiza un Corte de Caja.')
			//document.getElementById('idCorteCaja').submit()
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
    	    		 width: "95%",
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
    	                 
    	                 { name: "folio_documento",  type: "text", title: "DOCUMENTO", width: 20, align: 'left', editing: false, inserting: false, filtering: true, },
    	                 { name: "importe",  type: "text", title: "IMPORTE", width: 20, align: 'right', editing: false, inserting: false, filtering: true},
    	                 { name: "cve_forma_pago", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "formPago", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "referencia",  type: "text", title: "REFERENCIA", width:35, align: 'left', editing: false, inserting: false, filtering: true},
    	                 { name: "colectiva",  type: "text", title: "COLECTIVA", width:20, align: 'left', editing: false, inserting: false, filtering: true},    	                 
    	                 { name: "banco_emisor",  type: "text", width: 25, align: 'center', editing: false, inserting: false, filtering: true , css: 'EG_hide'},
    	                 { name: "nombre_banco_emisor",  type: "text", title: "BANCO EMISOR", width: 30, align: 'center', editing: false, inserting: false, filtering: true,
    	                	 itemTemplate: function (value, item) {
    	                        return crearColumnaBancoEmisorParaGrid(item);
    	                     }
    	                 },
    	                 { name: "banco_deposito",  type: "text", width: 20, align: 'center', editing: false, inserting: false, filtering: true , css: 'EG_hide'},
    	                 { name: "nombre_banco_deposito",  type: "text", title: "BANCO DEPOSITO", width: 25, align: 'center', editing: false, inserting: false, filtering: true,
    	                	 itemTemplate: function (value, item) {
    	                        return crearColumnaBancoDepositoParaGrid(item);
    	                     }
    	                 },
    	                 { name: "numero_transferencia",  type: "text", title: "FOLIO TRANSFERENCIA", width: 20, align: 'right', editing: false, inserting: false, filtering: true},    	                 
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
    	                 { name: "fecha_poliza",  type: "text", title: "FECHA POLIZA", width: 17, align: 'center', editing: false, inserting: false, filtering: true,
    	                	 itemTemplate: function (value, item) {
     	                        return crearColumnaFechaPolizaParaGrid(item);
     	                     }
    	                 },
    	                 { name: "id_estatus", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "estatus", type: "text", title: "ESTATUS", width:25, align: 'center', editing: false, inserting: false,   filtering: false,                           	 
    	                	 itemTemplate: function (value, item) {
    	                         return crearColumnaEstatusParaGrid(value, item);
    	                     }
    	                 },
    	                 { 
    	                	 name: "btnCancelar", type: "text", title: " ", width: 12, align: 'center', editing: false, inserting: false,  filtering: false, 
    	                	 itemTemplate: function (value, item) {
    	                		  if(mostrarColumnaXPerfilUsuario())
    	                		  {
	    	                		 if (item.id_estatus == 1 && item.id_egreso != 5) {
	    	                             return $("<button>").attr("class", "EG_btnRemover").on("click", function () {
	    	                            	 mostrarAlertaDeCancelacion(item);
	    	                                 return false;
	    	                             });
	    	                		 }
    	                     	  }
    	                     }    	                 
    	                 },
	                 ],
	        	 });
	         });
     $("#dgEgresos").show();
}


function crearColumnaFechaPolizaParaGrid(item)
{
	let fechaPoliza ="";
	
	if (item.id_estatus == "0" || item.id_estatus == "1" || item.id_estatus == "2" || item.id_estatus == "3"  )
	{
		if(item.fecha_poliza == "01/01/1901")
		{
			item.fecha_poliza= ObtenerFechaActual();
		}
		else
		{
			fechaPoliza = item.fecha_poliza;
		}
	    return $("<button>").attr("class", "EG_link_color").text(fechaPoliza).on("click", function () {
	    	$("#lbfolioFechaPolEgresosAct").text( item.nombre_egreso + "-" + item.folio_caja);
	    	 $("#txt_fechaPolizaEgresosAct").val("")
	   	 	MostrarDiv('divEditaFechaPolizaEgresos');
	    });
	}
	else
	{
		return $("<div>").attr("style", "divClasica").text(item.fecha_poliza);
	}
}


/***  ACTUALIZA  FECHA DE POLIZA  ***/
function actualizaFechaPolizaEgresos()
{
	document.getElementById('cargando').style.display = 'block';
	let IActualizado = $("#lbfolioFechaPolEgresosAct").text().split("-");
	let fechaPoliza = $("#txt_fechaPolizaEgresosAct").val();
	IActualizado[0] = obtenerTipoDeEgresoPorNombre(IActualizado[0]);
	
    if (validaFechaPoliza(fechaPoliza) === false)
    {
    	document.getElementById('cargando').style.display = 'none';
    	let fechaActual= ObtenerFechaActual();
    	alert("La fecha no puede ser menor a " + fechaActual);
    }
    else
    {
    	OcultarDiv('divEditaFechaPolizaEgresos');
    	 $.ajax({
	    		    url :'ConfirmaEgresos', 
	    		    data : "vista=ConfirmaEgresos.jsp&operacion=ActualizaFechaPoliza" +
	    		    		"&tipoPago="+ IActualizado[0] + "&folio_caja="+ IActualizado[1]  + "&fecha_poliza="+ fechaPoliza,
	    		    type : 'POST',
	    		    dataType : 'Json',
	    		    success : function(respuesta)
	    		    { 
	    		    	document.getElementById('cargando').style.display = 'none';
	    		    	consultaEngresosBD();
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
	    					alert('Error al actualizar fecha  poliza.')
	    			}
    		});
     }
}

function validaFechaPoliza(fechaPoliza)
{
	var fechaIngresada = new Date();
    var arrayfecha = fechaPoliza.split("/");
    fechaIngresada.setFullYear(arrayfecha[2],arrayfecha[1]-1,arrayfecha[0])
    var fechaActual = new Date();
    if (fechaIngresada < fechaActual)
    	return false;
    else
    	return true;
}


function mostrarColumnaXPerfilUsuario()
{
	 let nivelUsuario=$("#lbNivel_usuario").text();
	 let datoNumerico = $("#lbDatoNumerico").text();
	 let mostrarColumna = true;
	  
	 if(nivelUsuario == 1  || nivelUsuario == 2)
	 {
		 mostrarColumna = false;
	 }
	 return mostrarColumna;
}

function crearColumnaFolioCajaParaGrid(item)
{
	if ((item.id_estatus === "2" || item.id_estatus === "3") && item.id_egreso != 5 ) {
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
          return $("<div>").attr("class", "EG_divCOB").text(item.nombre_egreso);
      }
      else if (item.id_egreso === 2) {
          return $("<div>").attr("class", "EG_divHR").text(item.nombre_egreso);
      }
      else if (item.id_egreso === 3) {
          return $("<div>").attr("class", "EG_divOI").text(item.nombre_egreso);
      }
      
      else if (item.id_egreso === 4) {
          return $("<div>").attr("class", "EG_divCON").text(item.nombre_egreso);
      }
	  
      else if (item.id_egreso === 5) {
          return $("<div>").attr("class", "EG_divOTR").text(item.nombre_egreso);
      }
	  
      else if (item.id_egreso === 6) {
          return $("<div>").attr("class", "EG_IRedondeo").text(item.nombre_egreso);
      }
	  
      else if (item.id_egreso === 7) {
          return $("<div>").attr("class", "EG_INomina").text(item.nombre_egreso);
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

function crearColumnaEstatusParaGrid(value,item)
{
	if (item.id_estatus == "0") {
        return $("<div>").attr("class", "EG_IPendiente").text(value);
    }
    else if (item.id_estatus == "1") {
        return $("<div>").attr("class", "EG_IConfirmado").text(value);
    }
    else if (item.id_estatus == "9") {
        return $("<div>").attr("class", "EG_ICancelado").text(value);
    }
    else if (item.id_estatus == "2") {
        return $("<div>").attr("class", "EG_ICorteDeCaja").text(value);
    }
    else if (item.id_estatus == "3") {
        return $("<div>").attr("class", "EG_ICorteDeCaja").text(value);
    }
    else if (item.id_estatus == "5") {
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
		
		document.getElementById('cargando').style.display = 'block';
		
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
		        	document.getElementById('cargando').style.display = 'none';
		        	mostrarMsjError(" al actualizar el Egreso.")			        	
		        	
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
	limpiarCampos();
	MostrarDiv('divAltaNuevoEgreso');
	
}

function validaTipoEgresoAIngresar()
{
	limpiarCampos();
	let tipoEgresoAlta = obtenerTipoDeEgresoParaAlta();
	if(tipoEgresoAlta == 2 || tipoEgresoAlta == 6)
	{
		$("#id_banco").prop("disabled", false);
		$("#id_bancoDeposito").prop("disabled", false);
	}
	else
	{
		$("#id_banco").prop("disabled", true);
		$("#id_bancoDeposito").prop("disabled", true);
	}
	
	if(tipoEgresoAlta == 3 || tipoEgresoAlta == 4)
	{
		$("#id_folio").prop("disabled", true);
	}
	else
	{
		$("#id_folio").prop("disabled", false);
	}
		
	if(tipoEgresoAlta == 7)
	{
		$("#id_colectivaEgreso").prop("disabled", false);
	}
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
	        if(tipo === "ARedondeo")
	        	tipo_pago = 6;
	        if(tipo === "ANomina")
	        	tipo_pago = 7;
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
		if(validaSiExisteEfectivoDisponible(tipo_pago))
		{
			document.getElementById('cargando').style.display = 'block';
			if(tipo_pago == 3 || tipo_pago == 4 || tipo_pago == 7)
			{
				document.getElementById('cargando').style.display = 'none';
				$('#usuAutorizaEgreso').val("");
				$('#passAutorizaEgreso').val("");
				solicitarFirmaMancomunada();
			}
			else
			{
				document.getElementById('cargando').style.display = 'none';
				insertaEgresoEnBD();
			}	
		}
		else
		{
			let msjError= "El Egreso no puede tener un importe mayor a  $"+ $("#lbEfectivoDisponible").text()
			mostrarMsjError(msjError)
			$("#btn_guardarNuevoEgreso").attr("disabled", false);
			document.getElementById('cargando').style.display = 'none';
		}
	}
	else
	{
		let msjError= obtieneMensajeError(numeroDatoIncorrecto)
		mostrarMsjError(msjError)
		$("#btn_guardarNuevoEgreso").attr("disabled", false);
		document.getElementById('cargando').style.display = 'none';
	}
}

function validaSiExisteEfectivoDisponible(tipo_pago)
{
	if(tipo_pago == 6)
	{
		return true;
	}
	else
	{
		let efectivoDisponible = $("#lbEfectivoDisponible").text().replace(',','').replace(',','').replace(',','').replace(',','');
		let total=0;
		if(efectivoDisponible <= 0)
			return false;
		else
		{
			total = efectivoDisponible - $('#id_monto').val().replace(',','').replace(',','').replace(',','').replace(',','');
			if(total < 0)
				return false;
			else
				return true;	
		}		
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
	    		"&banco="+ $('#id_banco').val() + "&bancoDeposito="+ $('#id_bancoDeposito').val() +  "&referencia="+ $('#id_cheque').val()+ "&cve_usu_autoriza=" + $('#usuAutorizaEgreso').val()+
	    		"&fechaPoliza=" + $('#id_fecha_polizaEgreso').val()+
	    		"&coletiva=" + $('#id_colectivaEgreso').val(), 
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
	if(tipoEgreso == 0)
	{
		return 6;
	}
		
	if(tipoEgreso == 1 || tipoEgreso == 2)
	{
		if($('#id_folio').val().length <= 0)
			return 1;
	}
	
	if($('#id_monto').val().length <= 0 || $('#id_monto').val() == 0)
	{
		return 2;
	}
		
	if(tipoEgreso == 2 || tipoEgreso == 6)
	{
		if($('#id_banco').val() == 0)
			return 3;
		
		if($('#id_bancoDeposito').val() == 0)
			return 4;		
	}
	
	if($('#id_cheque').val().length <= 0)
	{
		return 5;
	}
		
	if(tipoEgreso == 7)
	{
		if($('#id_colectivaEgreso').val() == 0)
		{
			return 7;
		}
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
		return " Ingresa una referencia para el Egreso";
	
	if(id_mensaje == 6)
		return "Ingresa el tipo de Egreso";
	
	if(id_mensaje == 7)
		return "Selecciona una colectiva valida.";
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
	if(ECancelado.id_egreso == 3 || ECancelado.id_egreso == 4 || ECancelado.id_egreso == 7)
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
    if(tipo === "Redondeo")
    	id_Egreso = 6;
    if(tipo === "Nomina")
    	id_Egreso = 7;
    
	 return id_Egreso;
}
