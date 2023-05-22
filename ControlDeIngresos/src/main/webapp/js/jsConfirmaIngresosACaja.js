function MuestraPanel (div, menu)
{
	var divMostrar ="#" + div;
	var MunuActivo ="#" + menu;
    $(divMostrar).show();
    $(MunuActivo).css('background-color', '#337AB7');
}

function IniciaModuloDeIngresos(div, menu)
{
	validarSessionDelUsuario();
	MuestraPanel(div, menu);
	InicializaVariables();
	ConsultaDeIngresos();
	configurarMenuPrincipalXPerfilesUsuario();
	configuraModuloXPerfilDeUsuario();
}

/***  CONFIGURA  PERFIL DE USUARIO  ***/
function configuraModuloXPerfilDeUsuario()
{
	/** LOS PERFILES DE USUARIO PARA LOS GRIDS ESTAN EN EL EVENTO: mostrarColumnaXPerfilUsuario(); **/
	//El nivel de Caja tiene todos los permisos a nivel vista.
	let nivelUsuario=$("#lbNivel_usuario").text();	
	if (nivelUsuario == 1) 
	{
		mostrarPerfilUsuarioCredito();
	}
	else if (nivelUsuario == 2) 
	{
		mostrarPerfilUsuarioContabilidad();
	}
}

function mostrarPerfilUsuarioCredito()
{
	let datoNumerico = $("#lbDatoNumerico").text();
	OcultarDiv('btn_AgregarHojaRuta')
	OcultarDiv('btn_AgregarFacturaCredito')
	OcultarDiv('btn_actualizarSistema');
}

function mostrarPerfilUsuarioContabilidad()
{
	let datoNumerico = $("#lbDatoNumerico").text();
	OcultarDiv('btn_AgregarHojaRuta')
	OcultarDiv('btn_AgregarFacturaCredito')
	OcultarDiv('btn_actualizarSistema');
}

/***   FUNCIONES HOJA RUTA MANUAL POR CDO  ***/
function MostrarMtoHojaDeRutaManual()
{
   MostrarDiv('popupHojaRutaManual');
}

function OcultarMtoHojaDeRutaManual()
{
    document.getElementById('popupHojaRutaManual').style.display = 'none';
}

function soloNumeros(e) 
{
   var key = window.Event ? e.which : e.keyCode;
   return ((key >= 48 && key <= 57) ||(key==8))
}

function validarInputVacio() {
	
	if (document.getElementById("folioHojaRuta").value == 0 ) {
		alert('El folio no puede quedar en 0.');
		return false;
	}
	return true;
}

/***   FUNCIONES INICIO DE PAGINA  ***/
function InicializaVariables()
{
	let fecha = $('#txt_fechaIni').val()
	
	if(fecha=="")
	{
		$('#txt_fechaIni').val(ObtenerFechaActual());
	}
	
	fecha = $('#txt_fechaFin').val()
	if(fecha == "")
	{
		$('#txt_fechaFin').val(ObtenerFechaActual());
	}
	
	fecha = $('#txt_fechaPolizaIngreso').val()
	if(fecha=="")
	{
		$('#txt_fechaPolizaIngreso').val(ObtenerFechaActual());
	}
	OcultarAlertas();
}

function OcultarAlertas()
{
	OcultarDiv('divMjsInfo');
	OcultarDiv('divMjsExito');
	OcultarDiv('divMjsError');
}

/***   FUNCIONES CONSULTA DE INGRESOS ***/
function ConsultaDeIngresos()
{
	validarSessionDelUsuario();
	let fechaIni = $('#txt_fechaIni').val();
	let fechaFin = $('#txt_fechaFin').val();
	let estatus = $('#cmbEstatus').val();
	let folio = $('#txtFolioIngreso').val();
	let tipo_pago = obtenerTipoDePago();
	let tipoFecha = obtenerTipoDeFechas();
	BuscaIngresosCapturadosXParametro(tipo_pago, fechaIni, fechaFin, estatus, tipoFecha, folio);
}

function BuscaIngresosCapturadosXParametro(tipoPago, fechaInicio, fechaFin, estatus, tipoFecha, folioIngreso)
{
	OcultarDiv('tb_TotalesGrid');
	$("#lb_mj_pol_generadas").text('')
	document.getElementById("totalizado").checked = false;
	document.getElementById('cargando').style.display = 'block';	
	$("dgIngresos").jsGrid("option", "data", []);	
	OcultarAlertas();
	$.ajax({
	    url :'ConfirmaIngresosACaja', 
	    data : "vista=ConfirmaIngresosACaja.jsp&operacion=ConsultaInicialDeIngresos&tipoPago="+ tipoPago+ "&fecha_inicio="+ fechaInicio+ "&fechaFin="+
	    		fechaFin+ "&estatus="+ estatus  + "&tipoFecha=" + tipoFecha + "&folioIngreso=" + folioIngreso, 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	var dataIngresos = json.listaIngresos;
	    	var dataSemaforoIngresos = json.listaSemaforoIngresos;
	    	let polizaAntGenerada = json.polAntGeneradas;
	    	let fecha_ultima_poliza = json.fechaUltimaPoliza;
	    
	        if( dataIngresos.length > 0)
        	{
	        	MostrarDiv('dgIngresos');
	        	cargaConceptosCapturadosEnGrid(dataIngresos,estatus, fecha_ultima_poliza);
	        	OcultarDiv('divMjsInfo');
        	}
	        else
	        {	
	        	mostrarMsjInfo('No se encontraron registros en el sistema en el periodo  ' + fechaInicio+  "  y  " +  fechaFin);
	        	OcultarDiv('dgIngresos');
        	}
	        
	    	 $(function ()
		     {
	    		 validaPolizasDiasanteriores(polizaAntGenerada)
		     });
	    	
	    	 $(function ()
		     {
	    		 inicializarDatosDelSemaoforoDeIngresos(dataSemaforoIngresos, polizaAntGenerada);
		     });
	    	 
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
				alert('Error al buscar ingresos en el sistema.')
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

function cargaConceptosCapturadosEnGrid(data, estatus, fecha_ultima_poliza)
{
	var db =
    {
        loadData: function (filter)/** seccion de filtros **/
        {
            return $.grep(data, function (ingreso) {
                return (!filter.nombre_pago || ingreso.nombre_pago.indexOf(filter.nombre_pago) > -1)
                 		&& (!filter.folio_caja || ingreso.folio_caja === filter.folio_caja)
                 		&& (!filter.cve_usu || ingreso.cve_usu === filter.cve_usu)
                 		&& (!filter.nombre_usu || ingreso.nombre_usu.indexOf(filter.nombre_usu) > -1)
                 		&& (!filter.fecha_creacion || ingreso.fecha_creacion === filter.fecha_creacion)
                 		&& (!filter.fecha_caja || ingreso.fecha_caja === filter.fecha_caja)
                 		&& (!filter.fecha_corte || ingreso.fecha_corte === filter.fecha_corte)
            });
        },
        insertItem: function (insertingClient) {
            data.push(insertingClient);
        },
        updateItem: function (IActualizado) /** actualiza registro **/
        {
        	var d = $.Deferred();
        	if(!ValidaImpMayoresACero(IActualizado))
        	{
        		mostrarMsjError(' El importe total no puede ser 0.')
        		d.resolve(IPrevio);
        	}
        	else
        	{
        		if(validaImportesCorrectos(IPrevio, IActualizado))
    			{
		    		ActualizaIngresoXID(IActualizado);
		    		IActualizado.importe = sumaImportes(IActualizado);
		    		IActualizado.importe= agregarCommas(IActualizado.importe)
		    		ConsultaDeIngresos()
		    		d.resolve(IActualizado);
    			}
        		else
            	{
            		mostrarMsjError('La diferencia entre el importe original y el importe modificado solo  puede variar por $1.0')
            		d.resolve(IPrevio);
            	}
        	}        	
        	return d.promise();
        },
     };
	 window.db = db;
     db.data;
     
     $(function ()
     {
    	 $("#dgIngresos").jsGrid({
    		 width: "96%",
             height: "650px",
             editing: true,
             filtering: true,
             sorting: true,
             paging: true,
             pageSize: 800,
             controller: 
             {
                 loadData: function () 
                 {
                     dataType: "json"
                     return data;
                 },
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
            	 let totales= calculaImportesTotalesDelGridIngresos(items)
                 let $totalRow = $("<tr>").addClass("total-row");
                 args.grid._renderCells($totalRow, totales);
                 args.grid._content.append($totalRow);
             },
             
             rowRenderer: function (item) {
                 var $row = $('<tr>');
                 this._renderCells($row, item);
                 
                 $addr = $row[0].children[6];
                 $($addr).attr("id", "popover");
                 $($addr).attr(item.nombre_usu);
                 $($addr).attr("title", item.nombre_usu);
               
                 $addr2 = $row[0].children[4];
                 $($addr2).attr("id", "popover");
                 $($addr2).attr(item.hora_creacion);
                 $($addr2).attr("title","Hora Creacion: " +  item.hora_creacion);
                 
                 $addr3 = $row[0].children[19];
                 $($addr3).attr("id", "popover");
                 $($addr3).attr(item.hora_caja);
                 $($addr3).attr("title","Hora Caja: " +  item.hora_caja);
                 
                 $addr4 = $row[0].children[20];
                 $($addr4).attr("id", "popover");
                 $($addr4).attr(item.hora_corte);
                 $($addr4).attr("title","Hora Corte: " +  item.hora_corte);
                 
                 $addr5 = $row[0].children[5];
                 $($addr5).attr("id", "popover");
                 $($addr5).attr(item.folio_panamericano);
                 $($addr5).attr("title","Folios:[Corte Caja:" + item.folio_corte_caja + ", Rec.Valores:" + item.folio_panamericano + ", Poliza:" + item.folio_poliza + "]" );
                
                 return $row;
             },
             
             fields: 
             [
                 { name: "uname", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false,  css: 'EG_hide'},
                 { name: "uname_br", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide' },
                 { name: "id_tipo_pago", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide',},
                 { name: "nombre_pago",  type: "text", title: "TIPO", width: 17, align: 'center', editing: false, inserting: false, filtering: true,
                	 itemTemplate: function (value, item) {
                		 return crearColumnaTipoPagoParaGrid(item.id_tipo_pago, value)
                     }
                 },
                 { name: "fecha_creacion", type: "text", title: "FECHA CREACION", width:30, align: 'center', editing: false, inserting: false, filtering: true},
                 { name: "folio_caja",  type: "text", title: "FOLIO",width: 20, align: 'center', editing: false, inserting: false, filtering: true,
                	 itemTemplate: function (value, item) {
                         return crearColumnaFolioCaja(item)
                      }
                 },
                 { name: "cve_usu",  type: "text", title: "USUARIO", width: 23, align: 'center', editing: false, inserting: false, filtering: true },
                 { name: "nombre_usu", type: "text", title: "NOMBRE", width: 90, align: 'left', editing: false, inserting: false, filtering: true, css: 'EG_hide'}, 
                 { name: "importe_original", type: "text",title: "TOTAL", width: 35, align: 'right', editing: false, inserting: false, filtering: false,
                	 itemTemplate: function (value, item) {
                		 return crearColumnaTotalPagoParaGrid(value)
                     }
                 },
                 { name: "importe", type: "text",title: "IMPORTE", width: 35, align: 'right', editing: false, inserting: false, filtering: false,
                	 itemTemplate: function (value, item) {
                		 return crearColumnaTotalPagoParaGrid(value)
                     }
                 },
                 { name: "efectivo", type: "text", title: "EFECTIVO", width: 40, align: 'right', editing: true, inserting: false,filtering: false},
                 { name: "cheque", type: "text", title: "CHEQUE", width: 40, align: 'right', editing: true, inserting: false,filtering: false },
                 { name: "porfechado", type: "text", title: "POSFECHADO", width: 40, align: 'right', editing: true, inserting: false, filtering: false},
                 { name: "tarjeta", type: "text", title: "T. CREDITO", width:35, align: 'right',editing: true, inserting: false, filtering: false},
                 { name: "debito", type: "text", title:  "T. DEBITO", width: 40, align: 'right', editing: true, inserting: false,filtering: false},
                 { name: "transferencia", type: "text", title:  "TRANSFERENCIA", width: 40, align: 'right', editing: true, inserting: false,filtering: false},
                 { name: "notaCredito", type: "text", title: "N. CREDITO", width: 40, align: 'right', editing: false, inserting: false, filtering: false,
                	 itemTemplate: function (value, item) {
                		 return crearColumnaNotaCreditoParaGrid(item)
                     }
                 },                 
                 { name: "notaDevolucion", type: "text", title: "N.DEVOLUCION", width: 38, align: 'right', editing: false, inserting: false, filtering: false,
                	 itemTemplate: function (value, item) {
                        return crearColumnaNotaDevolucionParaGrid(item)
                     }
                 },
                 { name: "fecha_poliza", type: "text", title: "FECHA POLIZA", width:30, align: 'center', editing: false, inserting: false, filtering: true,
                	 itemTemplate: function (value, item) {
                         return crearColumnaFechaPolizaParaGrid(item, fecha_ultima_poliza)
                      }
                 },
                 { name: "fecha_caja", type: "text", title: "FECHA CAJA", width: 30, align: 'left', editing: false, inserting: false, filtering: true,},
                 { name: "fecha_corte", type: "text", title: "FECHA CORTE", width:30, align: 'center', editing: false, inserting: false, filtering: true,
                	 itemTemplate: function (value, item) {
                         return  crearColumnaFechaCorteParaGrid(item)
                      }
                 },
                
                 { name: "estatus", type: "text", title: "ESTATUS", width: 25, align: 'center', editing: false, inserting: false,css: 'EG_hide', filtering: false,
                	 editTemplate: function (value, item) {
                		 
                		 if(mostrarColumnaXPerfilUsuario() == false)
                    	 {
                			 var $result = jsGrid.fields.text.prototype.editTemplate.apply(this, argumets);
                             $result.prop("readonly", item.notEditable);
                             $result.prop("readonly", item.deleteButton);
                             return $result;
                    	 }
                		 else
                		 {
                			 if (value > 0) {
                                 var $result = jsGrid.fields.text.prototype.editTemplate.apply(this, argumets);
                                 $result.prop("readonly", item.notEditable);
                                 $result.prop("readonly", item.deleteButton);
                                 return $result;
                             }
                		 }
                     }
                 },
                 { name: "decripcion_Estatus", type: "text", title: "ESTATUS", width: 40, align: 'center', editing: false, inserting: false,   filtering: false,                           	 
                	 itemTemplate: function (value, item) {
                         return crearColumnaEstatusParaGrid(value, item);
                     }
                 },
                 { name: "btnImprimir", type: "text", title: " ", width: 12, align: 'center', editing: false, inserting: false,  filtering: false, 
                	 itemTemplate: function (value, item) {  
                		 
                		 if(mostrarColumnaXPerfilUsuario())
                    	 {
                			 if (item.estatus == "0") 
                    		 {
                                 return $("<button>").attr("class", "EG_btnImpGrid").text("Imp").on("click", function () {
                                	 muestraAlertaConfirmacionIngreso(item);
                                     return false;
                                 });
                    		 }
                    	 }
                     }
                 },
                 { name: "btnCancelar", type: "text", title: " ", width: 12, align: 'center', editing: false, inserting: false,  filtering: false, 
                	 itemTemplate: function (value, item) 
                	 {
                		 if(mostrarColumnaXPerfilUsuario())
                    	 {
		            		 let mostraBoton = false;
		            		 if($("#lbDatoNumerico").text() == "1" || $("#lbDatoNumerico").text() == "2") {
		        			   		mostraBoton= true;
		        			 }
	                		 if (item.estatus == "0" && mostraBoton == true) {
	            				  return $("<button>").attr("class", "EG_btnCancela").on("click", function () {
	                             	 mostrarAlertaDeCancelacion(item);
	                                  return false;
	                              });                             
	                		 }
                    	 }
                     }
                 },
                 { name: "btnRevertirIngreso", type: "text", title: " ", width: 12, align: 'center', editing: false, inserting: false,  filtering: false, 
                	 itemTemplate: function (value, item) 
                	 {
                		 if(mostrarColumnaXPerfilUsuario())
                    	 {
		            		 let mostraBoton = false;
		            		 if($("#lbDatoNumerico").text() == "1" || $("#lbDatoNumerico").text() == "2") {
		        			   		mostraBoton= true;
		        			 }
	                		 if (item.estatus == "1" && mostraBoton == true) {
	            				  return $("<button>").attr("class", "EG_btnRevertir").on("click", function () {
	            					  mostrarAlertaDeRevertirIngreso(item);
	                                  return false;
	                              });                             
	                		 }
                    	 }
                     }
                 },
                 { name: "btnReImprimir", type: "text", title: " ", width: 12, align: 'center', editing: false, inserting: false,  filtering: false, 
                	 itemTemplate: function (value, item) {
                		 if(mostrarColumnaXPerfilUsuario())
                    	 {
                			 if (item.estatus == "1") {
                                 return $("<button>").attr("class", "EG_btnImpGrid").text("Imp").on("click", function () {
                                	 reimprimirIngresoXID(item);
                                     return false;
                                 });
                    		 }
                    	 }
                     }
                 },
                 { type: "control",title: " ",  width: 22,
                     itemTemplate: function (value, item) {
                    	 
                    	 if(mostrarColumnaXPerfilUsuario())
                    	 {
	                    	 var $result = $([]);
	                         if (item.estatus == "0")
	                             $result = $result.add(this._createEditButton(item));
	                         return $result;
                    	 }
                     },
                 },
                 
                 { name: "hora_corte", type: "text", title: "", width: 90, align: 'left', editing: false, inserting: false, filtering: true, css: 'EG_hide'},                 
                 { name: "hora_caja", type: "text", title: "", width: 90, align: 'left', editing: false, inserting: false, filtering: true, css: 'EG_hide'},
                 { name: "hora_creacion", type: "text", title: "NOBRE", width: 90, align: 'left', editing: false, inserting: false, filtering: true, css: 'EG_hide'},
                 { name: "folio_corte_caja", type: "text", title: "", width: 90, align: 'left', editing: false, inserting: false, filtering: true, css: 'EG_hide'},
                 { name: "folio_panamericano", type: "text", title: "", width: 90, align: 'left', editing: false, inserting: false, filtering: true, css: 'EG_hide'},
                 { name: "folio_poliza", type: "text", title: "", width: 90, align: 'left', editing: false, inserting: false, filtering: true, css: 'EG_hide'},
                                  
        	 ],
    	 });
     });
     
     $(function ()
     {
    	 ocultarMostrarColumnasDeGrid(estatus);
     });
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

function ocultarMostrarColumnasDeGrid(estatus)
{
	 if($("#lbDatoNumerico").text() == "0") 
	 {
		 $("#dgIngresos").jsGrid("fieldOption", "btnCancelar", "visible", false);
	 }
	 switch(estatus)
	 {
		 case "0":
			 $("#dgIngresos").jsGrid("fieldOption", "btnReImprimir", "visible", false);
			 $("#dgIngresos").jsGrid("fieldOption", "fecha_corte", "visible", false);
			 $("#dgIngresos").jsGrid("fieldOption", "fecha_caja", "visible", false);
			 $("#dgIngresos").jsGrid("fieldOption", "btnRevertirIngreso", "visible", false);
			 break;
			 
		 case "1":
			 $("#dgIngresos").jsGrid("fieldOption", "btnImprimir", "visible", false);
			 $("#dgIngresos").jsGrid("fieldOption", "btnCancelar", "visible", false);			
			 break;
			 
		default:
			 $("#dgIngresos").jsGrid("fieldOption", "btnReImprimir", "visible", false);
			 $("#dgIngresos").jsGrid("fieldOption", "btnCancelar", "visible", false);
			 $("#dgIngresos").jsGrid("fieldOption", "btnImprimir", "visible", false);
			 $("#dgIngresos").jsGrid("fieldOption", "btnRevertirIngreso", "visible", false);
		 	break;
	 }
}

function inicializarDatosDelSemaoforoDeIngresos(dtSemaforo, polizaAntGenerada)
{
	$('#lb_importe_actual').text("$ " + dtSemaforo[0].importe_actual);
	$('#lb_importe_minimo').text("Limite: $"  + dtSemaforo[0].importe_minimo);
	$('#lb_importe_maximo').text("Maximo: $" + dtSemaforo[0].importe_maximo);
	aplicarValoresAlSemaforo(dtSemaforo[0].importe_actual.replace(',','').replace(',','').replace(',','').replace(',',''), 
							 dtSemaforo[0].importe_minimo.replace(',','').replace(',','').replace(',','').replace(',',''), 
							 dtSemaforo[0].importe_maximo.replace(',','').replace(',','').replace(',','').replace(',',''));
	
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
			//OcultarDiv('dgIngresos');
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
			alert('Se ha sobrepasado el efectivo permitido, realiza un Corte de Caja')				
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

/***   SECCION DE FUNCIONES PARA CONSTRUIR GRID ***/
function crearColumnaNotaDevolucionParaGrid(item)
{
	if(mostrarColumnaXPerfilUsuario() == false)
	{
		 return $("<div>").attr("style", "divClasica").text(item.notaDevolucion);
	}
	else
	{
		if (item.estatus == "0"  &&  (item.id_tipo_pago == "2" || item.id_tipo_pago == "3" || item.id_tipo_pago == "5" || item.id_tipo_pago == "7"))
	     {
	         return $("<button>").attr("class", "EG_link").text(item.notaDevolucion).on("click", function () {
	        	 MostrarDiv('divEditaNota');
	    		 validaTipoNota(1,  item.folio_caja, item.nombre_pago);
	         });
	     }
	     else
	         return $("<div>").attr("style", "divClasica").text(item.notaDevolucion);
	} 
}

function crearColumnaNotaCreditoParaGrid(item)
{
	if(mostrarColumnaXPerfilUsuario() == false)
	{
		 return $("<div>").attr("style", "divClasica").text(item.notaCredito);
	}
	else
	{
		if (item.estatus == "0" &&  (item.id_tipo_pago == "2" || item.id_tipo_pago == "3" || item.id_tipo_pago == "5" || item.id_tipo_pago == "7"))
		{
		    return $("<button>").attr("class", "EG_link").text(item.notaCredito).on("click", function () {
		   	 	MostrarDiv('divEditaNota');
				 validaTipoNota(0, item.folio_caja, item.nombre_pago);
		    });
		}
		else
		    return $("<div>").attr("style", "divClasica").text(item.notaCredito);
	}
}

function crearColumnaEstatusParaGrid(value, item)
{
	if (item.estatus == "0") {
        return $("<div>").attr("class", "EG_IPendiente").text(value);
    }
    else if (item.estatus == "1") {
        return $("<div>").attr("class", "EG_IConfirmado").text(value);
    }
    else if (item.estatus == "9") {
        return $("<div>").attr("class", "EG_ICancelado").text(value);
    }
    else if (item.estatus == "2") {
        return $("<div>").attr("class", "EG_ICorteDeCaja").text(value);
    }
    else if (item.estatus == "3") {
        return $("<div>").attr("class", "EG_ICorteDeCaja").text(value);
    }
    else if (item.estatus == "5") {
        return $("<div>").attr("class", "EG_IPoliza").text(value);
    }
}

function crearColumnaTipoPagoParaGrid(tipo, value)
{
	 if (tipo == "1") {
         return $("<div>").attr("class", "EG_divCOB").text(value);
     }
     else if (tipo == "2") {
         return $("<div>").attr("class", "EG_divHR").text(value);
     }
     else if (tipo == "4") {
         return $("<div>").attr("class", "EG_divOI").text(value);
     }     
     else if (tipo == "3") {
         return $("<div>").attr("class", "EG_divCON").text(value);
     }
     else if (tipo == "5") {
         return $("<div>").attr("class", "EG_divCRE").text(value);
     }
     else if (tipo == "6") {
         return $("<div>").attr("class", "EG_divLIN").text(value);
     }
     else if (tipo == "7") {
         return $("<div>").attr("class", "EG_divFHR").text(value);
     }
}
 
function crearColumnaTotalPagoParaGrid(value)
{
    return $("<div>").attr("class", "EG_divTotalIngreso").text(value);
}

function crearColumnaFechaPolizaParaGrid(item, fecha_ultima_poliza)
{
	if(mostrarColumnaXPerfilUsuario() == false)
	{
		return $("<div>").attr("style", "divClasica").text(item.fecha_poliza);
	}
	else
	{
		let fechaPoliza ="";
		
		if (item.estatus == "0" || item.estatus == "1" || item.estatus == "2" || item.estatus == "3"  )
		{
			if(item.fecha_poliza == "01/01/1901")
			{				
				if(fecha_ultima_poliza === "CDO_MACRO")
				{
					if(item.id_tipo_pago == "3" || item.id_tipo_pago == "5")
					{
						let uname_usu =$("#lbUname_usu").text();	
						let uname_br_usu=$("#lbUname_br_usu").text();	
						if(uname_usu === uname_br_usu)
						{
							fechaPoliza = ObtenerFechaActualMasDias(1);
						}
						else
						{
							fechaPoliza = ObtenerFechaActual();
						}
					}
					else
					{
						fechaPoliza = ObtenerFechaActual();
					}
				}
				else				
				{
					let fechaActualSistema = ObtenerFechaActualFormatoGuiones()					
					if(fecha_ultima_poliza == fechaActualSistema)
					{
						fechaPoliza = ObtenerFechaActualMasDias(1);
					}
					else
					{
						fechaPoliza = ObtenerFechaActual();
					}
				}				
				item.fecha_poliza= fechaPoliza;
			}
			else
			{
				fechaPoliza = item.fecha_poliza;
			}
		    return $("<button>").attr("class", "EG_link_color").text(fechaPoliza).on("click", function () {
		    	$("#lbfolioFechaPolIngreso").text( item.nombre_pago + "-" + item.folio_caja);
		   	 	MostrarDiv('divEditaFechaPoliza');
		    });
		}
		else
		{
			return $("<div>").attr("style", "divClasica").text(item.fecha_poliza);
		}
	}    
}

function crearColumnaFechaCorteParaGrid(item)
{
	if(item.estatus == "0")
	{
		return $("<div>").attr("style", "divClasica").text(" ");
	}
	else if(item.estatus == "9")
	{
		return $("<div>").attr("style", "divClasica").text(" ");
	}
	else if(item.estatus == "1")
	{
		return $("<div>").attr("style", "divClasica").text(" ");
	}
	else
	{
		return $("<div>").attr("style", "divClasica").text(item.fecha_corte);
	}
}

function crearColumnaFolioCaja(item)
{
	if(item.id_tipo_pago == "7")
	{
		 return $("<button>").attr("class", "EG_link_color").text(item.folio_caja).on("click", function () {
			 consultaDetallefolioHojaDeRuta(item.folio_caja);		   	
		    });
	}
	else
	{
		return $("<div>").attr("style", "divClasica").text(item.folio_caja);
	}
}





/*** SECCION TOTALES DEL GRID ***/
function calculaImportesTotalesDelGridIngresos(items)
{
	 let total = {
		  btnCancelar: "", btnImprimir: "", uname: "", uname_br: "", id_tipo_pago: "", nombre_pago: "", fecha_creacion: "", folio_caja: "", cve_usu: "", nombre_usu: "TOTALES", importe: 0, 
		  efectivo: 0, cheque: 0, porfechado: 0, tarjeta: 0,  debito: 0, transferencia:0, notaCredito: 0, notaDevolucion: 0, estatus: "", decripcion_Estatus: "",  IsTotal: true
     };
	  
	 items.forEach(function (item){
         total.importe += parseFloat(item.importe.replace(',', ''));
         total.efectivo += parseFloat(item.efectivo.replace(',', ''));
         total.cheque += parseFloat(item.cheque.replace(',', ''));
         total.porfechado += parseFloat(item.porfechado.replace(',', ''));
         total.tarjeta += parseFloat(item.tarjeta.replace(',', ''));
         total.debito += parseFloat(item.debito.replace(',', ''));
         total.transferencia += parseFloat(item.transferencia.replace(',', ''));
         total.notaDevolucion += parseFloat(item.notaDevolucion.replace(',', ''));
     });
	  
	 total.importe = "$ " + FormatearTotalesDeGrid(total.importe)
     total.efectivo = "$ " + FormatearTotalesDeGrid(total.efectivo)
     total.cheque =  "$ " + FormatearTotalesDeGrid(total.cheque)
     total.porfechado =  "$ " + FormatearTotalesDeGrid(total.porfechado)
     total.tarjeta = "$ " + FormatearTotalesDeGrid(total.tarjeta)
     total.debito =  "$ " + FormatearTotalesDeGrid(total.debito)
     total.transferencia =  "$ " + FormatearTotalesDeGrid(total.transferencia)
     total.notaCredito =  "$ " + FormatearTotalesDeGrid(total.notaCredito);
     total.notaDevolucion = "$ " +  FormatearTotalesDeGrid(total.notaDevolucion)
     
     generaTotalizarXTipoFormaPago(items)
     return total;
}
 
function generaTotalizarXTipoFormaPago(items)
{
	let impCob=0, efeCob=0, cheCob=0, posCob=0,creCob=0, debCob=0,traCob=0;
	let impHr=0, efeHr=0, cheHr=0, posHr=0,creHr=0, debHr=0,traHr=0;
	let impCon=0, efeCon=0, cheCon=0, posCon=0,creCon=0, debCon=0,traCon=0;
	let impCre=0, efeCre=0, cheCre=0, posCre=0,creCre=0, debCre=0,traCre=0;
	let impOi=0, efeOi=0, cheOi=0, posOi=0,creOi=0, debOi=0,traOi=0;
	let impLin=0, efeLin=0, cheLin=0, posLin=0,creLin=0, debLin=0,traLin=0;	
	let impFHr=0, efeFHr=0, cheFHr=0, posFHr=0,creFHr=0, debFHr=0,traFHr=0;
	
	items.forEach(function (item)
	{		
		 switch(item.id_tipo_pago)
		 {
			 case 1:
				 impCob += parseFloat(item.importe.replace(',', ''));
				 efeCob += parseFloat(item.efectivo.replace(',', ''));
				 cheCob += parseFloat(item.cheque.replace(',', ''));
				 posCob += parseFloat(item.porfechado.replace(',', ''));
				 creCob += parseFloat(item.tarjeta.replace(',', ''));
				 debCob += parseFloat(item.debito.replace(',', ''));
				 traCob += parseFloat(item.transferencia.replace(',', ''));
				 break;
				 
			 case 2:
				 impHr += parseFloat(item.importe.replace(',', ''));
				 efeHr += parseFloat(item.efectivo.replace(',', ''));
				 cheHr += parseFloat(item.cheque.replace(',', ''));
				 posHr += parseFloat(item.porfechado.replace(',', ''));
				 creHr += parseFloat(item.tarjeta.replace(',', ''));
				 debHr += parseFloat(item.debito.replace(',', ''));
				 traHr += parseFloat(item.transferencia.replace(',', ''));
				 break;
				 
			 case 3:
				 impCon += parseFloat(item.importe.replace(',', ''));
				 efeCon += parseFloat(item.efectivo.replace(',', ''));
				 cheCon += parseFloat(item.cheque.replace(',', ''));
				 posCon += parseFloat(item.porfechado.replace(',', ''));
				 creCon += parseFloat(item.tarjeta.replace(',', ''));
				 debCon+= parseFloat(item.debito.replace(',', ''));
				 traCon+= parseFloat(item.transferencia.replace(',', ''));
				 break;
				 
			 case 4:
				 impOi += parseFloat(item.importe.replace(',', ''));
				 efeOi += parseFloat(item.efectivo.replace(',', ''));
				 cheOi += parseFloat(item.cheque.replace(',', ''));
				 posOi += parseFloat(item.porfechado.replace(',', ''));
				 creOi += parseFloat(item.tarjeta.replace(',', ''));
				 debOi += parseFloat(item.debito.replace(',', ''));
				 traOi += parseFloat(item.transferencia.replace(',', ''));
				 break;
				 
			 case 5:
				 impCre += parseFloat(item.importe.replace(',', ''));
				 efeCre += parseFloat(item.efectivo.replace(',', ''));
				 cheCre += parseFloat(item.cheque.replace(',', ''));
				 posCre += parseFloat(item.porfechado.replace(',', ''));
				 creCre += parseFloat(item.tarjeta.replace(',', ''));
				 debCre += parseFloat(item.debito.replace(',', ''));
				 traCre += parseFloat(item.transferencia.replace(',', ''));
				 break;
				 
			 case 6:
				 impLin += parseFloat(item.importe.replace(',', ''));
				 efeLin += parseFloat(item.efectivo.replace(',', ''));
				 cheLin += parseFloat(item.cheque.replace(',', ''));
				 posLin += parseFloat(item.porfechado.replace(',', ''));
				 creLin += parseFloat(item.tarjeta.replace(',', ''));
				 debLin += parseFloat(item.debito.replace(',', ''));
				 traLin += parseFloat(item.transferencia.replace(',', ''));
				 break;
				 
			 case 7:
				 impFHr += parseFloat(item.importe.replace(',', ''));
				 efeFHr += parseFloat(item.efectivo.replace(',', ''));
				 cheFHr += parseFloat(item.cheque.replace(',', ''));
				 posFHr += parseFloat(item.porfechado.replace(',', ''));
				 creFHr += parseFloat(item.tarjeta.replace(',', ''));
				 debFHr += parseFloat(item.debito.replace(',', ''));
				 traFHr += parseFloat(item.transferencia.replace(',', ''));
				 break;
		 }		 
     });
	
	 let totalGeneralImp = parseFloat(impCob) + parseFloat(impHr) + parseFloat(impCon) + parseFloat(impOi) + parseFloat(impCre) + parseFloat(impLin) + parseFloat(impFHr);
	 let totalEfectivo = parseFloat(efeCob) + parseFloat(efeHr) + parseFloat(efeCon) + parseFloat(efeOi) + parseFloat(efeCre) + parseFloat(efeLin)+ parseFloat(efeFHr) ;
	 let totalCheque = parseFloat(cheCob) + parseFloat(cheHr) + parseFloat(cheCon) + parseFloat(cheOi) + parseFloat(cheCre) + parseFloat(cheLin) +parseFloat(cheFHr) ;
	 let totalPosfechado = parseFloat(posCob) + parseFloat(posHr) + parseFloat(posCon) + parseFloat(posOi) + parseFloat(posCre) + parseFloat(posLin) + parseFloat(posFHr);
	 let totalCredito = parseFloat(creCob) + parseFloat(creHr) + parseFloat(creCon) + parseFloat(creOi) + parseFloat(creCre) + parseFloat(creLin) + parseFloat(creFHr);
	 let totalDebito = parseFloat(debCob) + parseFloat(debHr) + parseFloat(debCon) + parseFloat(debOi) + parseFloat(debCre) + parseFloat(debLin) + parseFloat(debFHr);
	 let totalTransferencia = parseFloat(traCob) + parseFloat(traHr) + parseFloat(traCon) + parseFloat(traOi) + parseFloat(traCre) + parseFloat(traLin) + parseFloat(traFHr);
	
	 $("#COB_lb_importe").text( "$ " + FormatearTotalesDeGrid(impCob));
	 $("#COB_lb_efectivo").text( "$ " + FormatearTotalesDeGrid(efeCob));
	 $("#COB_lb_cheque").text( "$ " + FormatearTotalesDeGrid(cheCob));
	 $("#COB_lb_pofechado").text( "$ " + FormatearTotalesDeGrid(posCob));
	 $("#COB_lb_credito").text( "$ " + FormatearTotalesDeGrid(creCob));
	 $("#COB_lb_debito").text( "$ " + FormatearTotalesDeGrid(debCob));
	 $("#COB_lb_trasferencia").text( "$ " + FormatearTotalesDeGrid(traCob));
	 
	 $("#HR_lb_importe").text( "$ " + FormatearTotalesDeGrid(impHr));
	 $("#HR_lb_efectivo").text( "$ " + FormatearTotalesDeGrid(efeHr));
	 $("#HR_lb_cheque").text( "$ " + FormatearTotalesDeGrid(cheHr));
	 $("#HR_lb_pofechado").text( "$ " + FormatearTotalesDeGrid(posHr));
	 $("#HR_lb_credito").text( "$ " + FormatearTotalesDeGrid(creHr));
	 $("#HR_lb_debito").text( "$ " + FormatearTotalesDeGrid(debHr));
	 $("#HR_lb_trasferencia").text("$ " + FormatearTotalesDeGrid(traHr));
	 
	 $("#CON_lb_importe").text( "$ " + FormatearTotalesDeGrid(impCon));
	 $("#CON_lb_efectivo").text( "$ " + FormatearTotalesDeGrid(efeCon));
	 $("#CON_lb_cheque").text( "$ " + FormatearTotalesDeGrid(cheCon));
	 $("#CON_lb_pofechado").text( "$ " + FormatearTotalesDeGrid(posCon));
	 $("#CON_lb_credito").text( "$ " + FormatearTotalesDeGrid(creCon));
	 $("#CON_lb_debito").text( "$ " + FormatearTotalesDeGrid(debCon));
	 $("#CON_lb_trasferencia").text( "$ " + FormatearTotalesDeGrid(traCon));
	 
	 $("#OI_lb_importe").text("$ " + FormatearTotalesDeGrid(impOi));
	 $("#OI_lb_efectivo").text("$ " + FormatearTotalesDeGrid(efeOi));
	 $("#OI_lb_cheque").text("$ " + FormatearTotalesDeGrid(cheOi));
	 $("#OI_lb_pofechado").text("$ " + FormatearTotalesDeGrid(posOi));
	 $("#OI_lb_credito").text("$ " + FormatearTotalesDeGrid(creOi));
	 $("#OI_lb_debito").text("$ " + FormatearTotalesDeGrid(debOi));
	 $("#OI_lb_trasferencia").text("$ " + FormatearTotalesDeGrid(traOi));
	 
	 $("#CRE_lb_importe").text("$ " + FormatearTotalesDeGrid(impCre));
	 $("#CRE_lb_efectivo").text("$ " + FormatearTotalesDeGrid(efeCre));
	 $("#CRE_lb_cheque").text("$ " + FormatearTotalesDeGrid(cheCre));
	 $("#CRE_lb_pofechado").text("$ " + FormatearTotalesDeGrid(posCre));
	 $("#CRE_lb_credito").text("$ " + FormatearTotalesDeGrid(creCre));
	 $("#CRE_lb_debito").text("$ " + FormatearTotalesDeGrid(debCre));
	 $("#CRE_lb_trasferencia").text("$ " + FormatearTotalesDeGrid(traCre));
	 
	 $("#LIN_lb_importe").text("$ " + FormatearTotalesDeGrid(impLin));
	 $("#LIN_lb_efectivo").text("$ " + FormatearTotalesDeGrid(efeLin));
	 $("#LIN_lb_cheque").text("$ " + FormatearTotalesDeGrid(cheLin));
	 $("#LIN_lb_pofechado").text("$ " + FormatearTotalesDeGrid(posLin));
	 $("#LIN_lb_credito").text("$ " + FormatearTotalesDeGrid(creLin));
	 $("#LIN_lb_debito").text("$ " + FormatearTotalesDeGrid(debLin));
	 $("#LIN_lb_trasferencia").text("$ " + FormatearTotalesDeGrid(traLin));
	 
	 $("#LIN_lb_importe").text("$ " + FormatearTotalesDeGrid(impLin));
	 $("#LIN_lb_efectivo").text("$ " + FormatearTotalesDeGrid(efeLin));
	 $("#LIN_lb_cheque").text("$ " + FormatearTotalesDeGrid(cheLin));
	 $("#LIN_lb_pofechado").text("$ " + FormatearTotalesDeGrid(posLin));
	 $("#LIN_lb_credito").text("$ " + FormatearTotalesDeGrid(creLin));
	 $("#LIN_lb_debito").text("$ " + FormatearTotalesDeGrid(debLin));
	 $("#LIN_lb_trasferencia").text("$ " + FormatearTotalesDeGrid(traLin));
	 
	 
	 $("#FHR_lb_importe").text("$ " + FormatearTotalesDeGrid(impFHr));
	 $("#FHR_lb_efectivo").text("$ " + FormatearTotalesDeGrid(efeFHr));
	 $("#FHR_lb_cheque").text("$ " + FormatearTotalesDeGrid(cheFHr));
	 $("#FHR_lb_pofechado").text("$ " + FormatearTotalesDeGrid(posFHr));
	 $("#FHR_lb_credito").text("$ " + FormatearTotalesDeGrid(creFHr));
	 $("#FHR_lb_debito").text("$ " + FormatearTotalesDeGrid(debFHr));
	 $("#FHR_lb_trasferencia").text("$ " + FormatearTotalesDeGrid(traFHr));
	 
	 $("#TOT_lb_importe").text("$ " + FormatearTotalesDeGrid(totalGeneralImp));
	 $("#TOT_lb_efectivo").text("$ " + FormatearTotalesDeGrid(totalEfectivo));
	 $("#TOT_lb_cheque").text("$ " + FormatearTotalesDeGrid(totalCheque));
	 $("#TOT_lb_pofechado").text("$ " + FormatearTotalesDeGrid(totalPosfechado));
	 $("#TOT_lb_credito").text("$ " + FormatearTotalesDeGrid(totalCredito));
	 $("#TOT_lb_debito").text("$ " + FormatearTotalesDeGrid(totalDebito));
	 $("#TOT_lb_trasferencia").text("$ " + FormatearTotalesDeGrid(totalTransferencia));
}

function FormatearTotalesDeGrid(importe)
{
	let importeTotalGrid = parseFloat(importe).toFixed(2);
	importeTotalGrid = agregarCommas(importeTotalGrid);
	return importeTotalGrid;
}

/***  FUNCIONES ACTUALIZA  INGRESOS  ***/
function validaImportesCorrectos(IPrevio,IActualizado)
{
	if(IActualizado.id_tipo_pago == 2 || IActualizado.id_tipo_pago == 3 || IActualizado.id_tipo_pago == 5 )
	{
		return true;
	}
	if(!validaDiferenciaEntreImportes(IPrevio.efectivo, IActualizado.efectivo))
		return false;
	if(!validaDiferenciaEntreImportes(IPrevio.cheque, IActualizado.cheque))
		return false;
	if(!validaDiferenciaEntreImportes(IPrevio.tarjeta, IActualizado.tarjeta))
		return false;
	if(!validaDiferenciaEntreImportes(IPrevio.debito, IActualizado.debito))
		return false;
	if(!validaDiferenciaEntreImportes(IPrevio.transferencia, IActualizado.transferencia))
		return false;
	if(!validaDiferenciaEntreImportes(IPrevio.porfechado, IActualizado.porfechado))
		return false;
	
	return true;
}

function validaDiferenciaEntreImportes(importeAnt , importeAct)
{
	let IAnterior =  parseFloat(importeAnt.replace(",", ""));
	let IActualizado = parseFloat(importeAct.replace(",", "")); 
	let diferencia = IAnterior - IActualizado;
	if(diferencia > -1 && diferencia < 1)
		return true;
	else 
		return false;
}

function ValidaImpMayoresACero(IActualizado)
{
	let efectivo = parseFloat(IActualizado.efectivo.replace(",", ""));
	let cheque = parseFloat(IActualizado.cheque.replace(",", ""));
	let tarjeta = parseFloat(IActualizado.tarjeta.replace(",", ""));
	let debito = parseFloat(IActualizado.debito.replace(",", ""));
	let porfechado = parseFloat(IActualizado.porfechado.replace(",", ""));
	let transferencia = parseFloat(IActualizado.transferencia.replace(",", ""));
	let notasCreditoDevolucion = parseFloat(IActualizado.notaCredito.replace(",", "")) + parseFloat(IActualizado.notaDevolucion.replace(",", ""));
	if(notasCreditoDevolucion >=0)
	{
		if(efectivo <= 0 &&  cheque <= 0 && tarjeta <= 0 && debito <= 0 && porfechado <= 0 && transferencia <= 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	else
	{
		return true;
	}
			
}

function sumaImportes(IActualizado)
{
	 let ITotal= convertirFloat(IActualizado.efectivo.replace(',', ''))  + 
			      convertirFloat(IActualizado.cheque.replace(',', ''))  + 
			      convertirFloat(IActualizado.tarjeta.replace(',', ''))  + 
			      convertirFloat(IActualizado.debito.replace(',', '')) +
			      convertirFloat(IActualizado.transferencia.replace(',', '')) +
			      convertirFloat(IActualizado.porfechado.replace(',', '')); 	
	 
	 return ITotal.toFixed(2);
}

function ActualizaIngresoXID(IActualizado)
{
	document.getElementById('cargando').style.display = 'block';
	 let importeTotal= sumaImportes(IActualizado); 	 
	 
	 $.ajax({
		    url :'ConfirmaIngresosACaja', 
		    data : "vista=ConfirmaIngresosACaja.jsp&operacion=ActualizaIngresoXID" +
		    		"&tipoPago="+ IActualizado.id_tipo_pago+ "&folio_caja="+ IActualizado.folio_caja +
		    		"&importe="+ importeTotal +
		    		"&efectivo="+ IActualizado.efectivo.replace(',', '').replace(',', '').replace(',', '').replace(',', '')+
		    		"&cheque="+ IActualizado.cheque.replace(',', '').replace(',', '').replace(',', '').replace(',', '')+
		    		"&tarjeta="+ IActualizado.tarjeta.replace(',', '').replace(',', '').replace(',', '').replace(',', '')+
		    		"&debito="+ IActualizado.debito.replace(',', '').replace(',', '').replace(',', '').replace(',', '')+
		    		"&porfechado="+ IActualizado.porfechado.replace(',', '').replace(',', '').replace(',', '').replace(',', '')+
		    		"&transferencia="+ IActualizado.transferencia.replace(',', '').replace(',', '').replace(',', '').replace(',', '')+
		    		"&notaCredito="+ IActualizado.notaCredito.replace(',', '').replace(',', '').replace(',', '').replace(',', '')+
		    		"&notaDevolucion="+ IActualizado.notaDevolucion.replace(',', '').replace(',', '').replace(',', '').replace(',', ''),
		    type : 'POST',
		    dataType : 'Json',
		    success : function(respuesta)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if(respuesta)
		    		mostrarMsjExito('El ingreso fue actuaizado ');
		    	else
		    		mostrarMsjError(' Al actualizar el ingreso.');
		    	
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
					alert('Error al actualizar ingreso.')
			}
		});
	 
}

/***  FUNCIONES CANCELAR INGRESOS   ***/
function mostrarAlertaDeCancelacion(ICancelado)
{
	validarSessionDelUsuario();
	MostrarDiv('divCancelacion');
	$("#msjCancelacion").text( ICancelado.nombre_pago + "-" + ICancelado.folio_caja);	
}

function CancelarIngresoXID()
{
	let motivo = $('#cmbMotCancela').val();
	if(motivo <= 0)
	{
		document.getElementById('cargando').style.display = 'none';
		alert('Selecciona un motivo.')
		return
	}
	
	OcultarDiv('divCancelacion');
	let ICancelado = $('#msjCancelacion').text().split("-");	
	ICancelado[0] =obtieneIdTipoPago(ICancelado[0]);
	document.getElementById('cargando').style.display = 'block';
	 
	 $.ajax({
		    url :'ConfirmaIngresosACaja', 
		    data : "vista=ConfirmaIngresosACaja.jsp&operacion=CancelaIngresoXID" +
		    		"&tipoPago="+ ICancelado[0]+ "&folio_caja="+ ICancelado[1] + "&motivo="+ motivo,
		    type : 'POST',
		    dataType : 'Json',
		    success : function(respuesta)
		    { 
		    	if(respuesta)
		    		mostrarMsjExito('El ingreso fue cancelado ');
		    	else
		    		mostrarMsjError(' Al cancelar el ingreso.');
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
					alert('Error al cancelar ingreso.')
			}
		});
	 
	 $(function(){
		document.getElementById('cargando').style.display = 'none';
		ConsultaDeIngresos();
		}			
	);	
}

function obtenerTipoDePago()
{
	let tipo_pago = 0 ;
	 $('#cbxsTipoPago input:checked').each(function () {
	        let tipo = $(this).attr('id');
	        
	        if(tipo === "Todos")
	        	tipo_pago = 0;
	        if(tipo === "RelacionCobranza")
	        	tipo_pago = 1;
	        if(tipo === "HojaRuta")
	        	tipo_pago = 2;
	        if(tipo === "PagosContado")
	        	tipo_pago = 3;
	        if(tipo === "OtrosIngresos")
	        	tipo_pago = 4;
	        if(tipo === "FacturaCredito")
	        	tipo_pago = 5;
	        if(tipo === "LineaBancaria")
	        	tipo_pago = 6;	        
	        if(tipo === "FolioTraHojaRuta")
	        	tipo_pago = 7;
	    });
	 return tipo_pago;
}

function obtieneIdTipoPago(nombreCorto)
{
	let idTP="";
	switch(nombreCorto)
	{
		case 'COB':
			idTP = 1;
			break;
			
		case 'HR':
			idTP = 2;
			break;
			
		case 'CON':
			idTP =3;
			break;
			
		case 'OI':
			idTP = 4;
			break;
			
		case 'CRE':
			idTP = 5;
			break;
			
		case 'LIN':
			idTP = 6;
			break;
			
		case 'FHR':
			idTP = 7;
			break;
	}
	return idTP;
}

function obtenerTipoDeFechas()
{
	let tipo_fecha = "";
	 $('#cbxsFechasFiltro input:checked').each(function () {
	        let tipo = $(this).attr('id');
	        
	        if(tipo === "FechaCreacion")
	        	tipo_fecha = "FechaCreacion";
	        if(tipo === "FechaCorteCaja")
	        	tipo_fecha = "FechaCorteCaja";
	        if(tipo === "FechaPoliza")
	        	tipo_fecha = "FechaPoliza";
	        if(tipo === "FechaCaja")
	        	tipo_fecha = "FechaCaja";
	    });
	 return tipo_fecha;
}

/***  FUNCIONES CONFIRMAR INGRESOS  ***/
function muestraAlertaConfirmacionIngreso(Iconfirmado)
{
	OcultarDiv('divMjsError');
	OcultarDiv('divMjsExito');
	
	validarSessionDelUsuario();	
	if(validaIngresoAntesDeSerConfirmado(Iconfirmado))
	{
		MostrarDiv('divConfirmar');
		OcultarDiv('div_solicitaBancos');
		formarMensajeConfirmacion(Iconfirmado)
		
		$("#lbDatosIConfirmado").val(
			Iconfirmado.uname + "&" +//0
			Iconfirmado.uname_br+ "&" +//1
			Iconfirmado.id_tipo_pago+ "&" +//2
			Iconfirmado.nombre_pago+ "&" +//3
			Iconfirmado.fecha_creacion+ "&" +//4
			Iconfirmado.folio_caja+ "&" +//5
			Iconfirmado.cve_usu+ "&" +//6
			Iconfirmado.nombre_usu + "&" +//7
			Iconfirmado.importe+ "&" +//8
			Iconfirmado.efectivo+ "&" +//9
			Iconfirmado.cheque+ "&" +//10
			Iconfirmado.porfechado+ "&" +//11
			Iconfirmado.tarjeta+ "&" +//12
			Iconfirmado.debito+ "&" +//13
			Iconfirmado.transferencia+ "&" +//14
			Iconfirmado.notaCredito+ "&" +//15
			Iconfirmado.notaDevolucion+ "&" +//16
			Iconfirmado.estatus+ "&" +//17
			Iconfirmado.decripcion_Estatus + "&" +//18
			Iconfirmado.fecha_poliza  + "&" +//19
			Iconfirmado.importe_original);//20
	}
}

function validaIngresoAntesDeSerConfirmado(Iconfirmado)
{
	if(Iconfirmado.efectivo <= 0 && Iconfirmado.cheque <=0 && Iconfirmado.porfechado <= 0 && Iconfirmado.tarjeta <= 0 && 
	   Iconfirmado.debito <= 0 && Iconfirmado.transferencia <= 0 && Iconfirmado.notaCredito.replace('-','') <= 0 && Iconfirmado.notaDevolucion.replace('-','') <= 0)
	{
		alert("ERROR AL CONFIRMAR INGRESO: Todos los importes del ingreso estan en 0.")
		return false;
	}
	else		
	{
		return true;
	}
}

function formarMensajeConfirmacion(Iconfirmado)
{

	$("#msjConfirmacion").text(Iconfirmado.nombre_pago+ "-" + Iconfirmado.folio_caja);
	$("#msjConfirmacionFechaPoliza").text(Iconfirmado.fecha_poliza);
	
	$("#msjConfirmacionFormasPago").empty();
	
	let contenido = " <table align=\"center\" width=\"70%\" class=\"table table-striped\" style=\" font-size: 12px;\"> " +
						"<thead> " +
							" <tr>" +
								 "<th align=\"center\">FORMA DE PAGO</th>"+
								 "<th align=\"center\" width=\"50%\"> IMPORTE </th>" +
							"</tr>" +	
						"</thead>" +
						"<tbody>" ;
	if(quitarComas(Iconfirmado.efectivo) > 0)
	{
		contenido += "<tr>" +
							"<td align=\"left\"> Efectivo </td>" +
							"<td align=\"right\"> $ " + Iconfirmado.efectivo + "</td>" +
				    "</tr>";
	}
	
	if(quitarComas(Iconfirmado.cheque) > 0)
	{
		contenido += "<tr>" +
							"<td align=\"left\"> Cheque </td>" +
							"<td align=\"right\"> $ " + Iconfirmado.cheque + "</td>" +
					"</tr>";
	}
	
	if(quitarComas(Iconfirmado.porfechado) > 0)
	{
		
		contenido += "<tr>" +
							"<td align=\"left\"> Posfechado </td>" +
							"<td align=\"right\"> $ " + Iconfirmado.porfechado + "</td>" +
					"</tr>";
	}
	
	if(quitarComas(Iconfirmado.tarjeta) > 0)
	{
		contenido += "<tr>" +
							"<td align=\"left\"> Tarjeta Cre. </td>" +
							"<td align=\"right\"> $ " + Iconfirmado.tarjeta + "</td>" +
					"</tr>";
	}
	
	if(quitarComas(Iconfirmado.debito) > 0)
	{
		contenido += "<tr>" +
							"<td align=\"left\"> Tarjeta Deb. </td>" +
							"<td align=\"right\"> $ " + Iconfirmado.debito + "</td>" +
					"</tr>";
	}
	
	if(quitarComas(Iconfirmado.transferencia) > 0)
	{
		contenido += "<tr>" +
							"<td align=\"left\"> Transferencia </td>" +
							"<td align=\"right\"> $ " + Iconfirmado.transferencia + "</td>" +
					"</tr>";
	}
	
	if(quitarComas(Iconfirmado.notaCredito) > 0)
	{
		contenido += "<tr>" +
							"<td align=\"left\"> Nota Credito </td>" +
							"<td align=\"right\"> $ " + Iconfirmado.notaCredito + "</td>" +
					"</tr>";
	}
	
	if(quitarComas(Iconfirmado.notaDevolucion) > 0)
	{
		contenido += "<tr>" +
							"<td align=\"left\"> Nota Devolucion </td>" +
							"<td align=\"right\"> $ " + Iconfirmado.notaDevolucion + "</td>" +
					"</tr>";
	}
	contenido += "<tr>" +
					"<td style=\" font-size: 12px; font-weight: bold; color:#B22222\" align=\"left\" > TOTAL </td>" +
					"<td style=\" font-size: 12px; font-weight: bold; color:#B22222\" align=\"right\"> $ " + Iconfirmado.importe + "</td>" +
				"</tr>" +
				"<tbody>" ;
	contenido += "</table>";
	$("#msjConfirmacionFormasPago").append(contenido);
}

function quitarComas(importe)
{
	importe=  importe.replace(',','').replace(',','').replace(',','').replace(',','').replace(',','').replace(',','')
	return importe;
}

function confirmarIngresoXID()
{
	OcultarDiv('divConfirmar');
	document.getElementById('cargando').style.display = 'block';
	let IConfirmar = $('#lbDatosIConfirmado').val().split("&");
	
	if(IConfirmar[2] == 3)
	{		
		$.ajax({
		    url :'ConfirmaIngresosACaja', 
		    data : "vista=ConfirmaIngresosACaja.jsp&operacion=ValidaContadoConFactura" +
		    		"&folio_caja="+  IConfirmar[5],
		    type : 'POST',
		    dataType : 'Json',
		    success : function(respuesta)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if(respuesta == true)
		    	{
		    		$.ajax({
		    		    url :'ConfirmaIngresosACaja', 
		    		    data : "vista=ConfirmaIngresosACaja.jsp&operacion=ConfirmaIngresoXID" +
		    		    		"&tipoPago="+ IConfirmar[2]+ "&folio_caja="+ IConfirmar[5]+
		    		    		"&cve_usu="+ IConfirmar[6]+ "&importe="+ IConfirmar[8]+
		    		    		"&efectivo="+ IConfirmar[9]+ "&cheque="+ IConfirmar[10]+
		    		    		"&porfechado="+ IConfirmar[11]+ "&tarjeta="+ IConfirmar[12]+
		    		    		"&debito="+ IConfirmar[13]+ "&transferencia="+ IConfirmar[14]+
		    		    		"&notaCredito="+ IConfirmar[15]+ "&notaDevolucion="+ IConfirmar[16]+
		    		    		"&usu_nombre="+ IConfirmar[7] +"&banco_emisor="+ $('#cmbBanco_PCT').val()+
		    		    		"&banco_deposito="+ $('#cmbBancoDeposito_PCT').val() + "&aplicaComision=" + $("#cbxAplicaComision").prop("checked") + "&fecha_poliza="+ IConfirmar[19]+ "&importe_Origen="+ IConfirmar[20],
		    		    type : 'POST',
		    		    dataType : 'Json',
		    		    success : function(respuesta)
		    		    { 
		    		    	$("#cbxAplicaComision").prop("checked", false)
		    		    	if(respuesta)
		    		    		mostrarMsjExito('El ingreso fue confirmado ');
		    		    	else
		    		    		mostrarMsjError(' Al confirmar el ingreso.');		    		    			    			
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
		    					alert('Error al confirmar ingreso.')
		    			}
		    		});			    		
		    		$(function(){
		    			document.getElementById('cargando').style.display = 'none';
		    			ConsultaDeIngresos();
		    			}			
		    		);	
    				    		
		    	}
		    	else
		    	{
		    		mostrarMsjError(' El Ingreso de Contado no tiene asignada factura en el Sistema Mayorista');
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
					alert('Error al confirmar ingreso.')
			}
		});	
	}
	else
	{
		$.ajax({
		    url :'ConfirmaIngresosACaja', 
		    data : "vista=ConfirmaIngresosACaja.jsp&operacion=ConfirmaIngresoXID" +
		    		"&tipoPago="+ IConfirmar[2]+ "&folio_caja="+ IConfirmar[5]+
		    		"&cve_usu="+ IConfirmar[6]+ "&importe="+ IConfirmar[8]+
		    		"&efectivo="+ IConfirmar[9]+ "&cheque="+ IConfirmar[10]+
		    		"&porfechado="+ IConfirmar[11]+ "&tarjeta="+ IConfirmar[12]+
		    		"&debito="+ IConfirmar[13]+ "&transferencia="+ IConfirmar[14]+
		    		"&notaCredito="+ IConfirmar[15]+ "&notaDevolucion="+ IConfirmar[16]+
		    		"&usu_nombre="+ IConfirmar[7] +"&banco_emisor="+ $('#cmbBanco_PCT').val()+
		    		"&banco_deposito="+ $('#cmbBancoDeposito_PCT').val() + "&aplicaComision=" + $("#cbxAplicaComision").prop("checked") + "&fecha_poliza="+ IConfirmar[19]+ "&importe_Origen="+ IConfirmar[20],
		    type : 'POST',
		    dataType : 'Json',
		    success : function(respuesta)
		    { 
		    	$("#cbxAplicaComision").prop("checked", false)
		    	if(respuesta)
		    		mostrarMsjExito('El ingreso fue confirmado ');
		    	else
		    		mostrarMsjError(' Al confirmar el ingreso.');
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
					alert('Error al confirmar ingreso.')
			}
		});	 
		$(function(){
			document.getElementById('cargando').style.display = 'none';
			ConsultaDeIngresos();
			}			
		);		 
	}	
}

function validaSielContadoTieneFactura(folio_caja)
{
	$.ajax({
	    url :'ConfirmaIngresosACaja', 
	    data : "vista=ConfirmaIngresosACaja.jsp&operacion=ValidaContadoConFactura" +
	    		"&folio_caja="+ folio_caja,
	    type : 'POST',
	    dataType : 'Json',
	    success : function(respuesta)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
	    	alert(respuesta);
	    	
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
				alert('Error al confirmar ingreso.')
		}
	});	 
}

/***  FUNCIONES ACTUALIZA PAGO CON TARJETA  ***/
function validarPagosConTarjeta()
{
	let IConfirmar = $('#lbDatosIConfirmado').val().split("&");
	if( parseFloat(IConfirmar[12]) > 0 ||  parseFloat(IConfirmar[13]) > 0)
	{
		MostrarDiv('divIngresosConTarjetaCredito');
		$("#cbxAplicaComision").prop("checked", false)
		$("#cmbBanco_PCT").val("0");
		$("#cmbBancoDeposito_PCT").val("0");
		$("#lbFolioIngresoConTC").text($("#msjConfirmacion").text())
	}
	else
	{
		confirmarIngresoXID()
	}
}

function validaSiSolicitaraBancos()
{
	if($("#cbxAplicaComision").prop("checked") == true)
		MostrarDiv('div_solicitaBancos');
	else
		OcultarDiv('div_solicitaBancos');
}

function actualizarPagoConTarjeta()
{
	document.getElementById('cargando').style.display = 'block';
	
	let IActualizado=  $('#lbFolioIngresoConTC').text().split("-");
	IActualizado[0] = obtieneIdTipoPago(IActualizado[0]);
		
	if($("#cbxAplicaComision").prop("checked") == true)
	{
		if(ValidarDatosParaPagoConTarjeta() == false)
		{
			document.getElementById('cargando').style.display = 'none';
			alert('Ingresa los datos solicitados.');
			return;
		}
		else
		{
			document.getElementById('cargando').style.display = 'none';
			OcultarDiv('divIngresosConTarjetaCredito');
			confirmarIngresoXID()
		}
	}
	else
	{
		document.getElementById('cargando').style.display = 'none';
		OcultarDiv('divIngresosConTarjetaCredito');
		confirmarIngresoXID()
	}
}

function ValidarDatosParaPagoConTarjeta()
{
	 if($('#cmbBanco_PCT').val() == 0)
		return false;
	 
	 if($('#cmbBancoDeposito_PCT').val() == 0)
		return false;
	 
	 return true;
}

/***  FUNCIONES RE-IMPRIME INGRESOS  ***/
function reimprimirIngresoXID(Ireimprimir)
{
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'ConfirmaIngresosACaja', 
	    data : "vista=ConfirmaIngresosACaja.jsp&operacion=reimprimirIngresoXID" +
	    		"&tipoPago="+ Ireimprimir.id_tipo_pago+ "&folio_caja="+ Ireimprimir.folio_caja+
	    		"&cve_usu="+ Ireimprimir.cve_usu+ "&usu_nombre="+ Ireimprimir.nombre_usu+ 
	    		"&importe="+ Ireimprimir.importe+	"&efectivo="+ Ireimprimir.efectivo+ 
	    		"&cheque="+ Ireimprimir.cheque+"&porfechado="+ Ireimprimir.porfechado+
	    		"&tarjeta="+ Ireimprimir.tarjeta+"&debito="+ Ireimprimir.debito+
	    		"&transferencia="+ Ireimprimir.transferencia+"&notaCredito="+ Ireimprimir.notaCredito+
	    		"&notaDevolucion="+ Ireimprimir.notaDevolucion,
	    type : 'POST',
	    dataType : 'Json',
	    success : function(respuesta)
	    { 
	    	if(respuesta)
	    		document.getElementById('cargando').style.display = 'none';
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
				alert('Error al reimprimir ingreso.')
		}
	});	 
}

/***  FUNCIONES EDITA IMPORTE NOTA   ***/

function ocultarMostrarNota()
{
	if($("#cbxDescuentoMes").prop("checked") == true)
	{
		OcultarDiv('lbDocumentoNota');
		OcultarDiv('txtDocumentoNota');
	}
	else
	{
		MostrarDiv('lbDocumentoNota');
		MostrarDiv('txtDocumentoNota');
	}
}

function validaTipoNota(tipo, folio_caja, id_tipo_pago)
{
	validarSessionDelUsuario();	
	OcultarDiv('NotaCredito');
	OcultarDiv('NotaDevolcuion'); 
	$('#cmbUsuNota').val(0);
	$('#txtImporteNota').val("");
	$('#txtObservacionesNota').val("");
	$('#txtDocumentoNota').val("");
	MostrarDiv('lbDocumentoNota');
	MostrarDiv('txtDocumentoNota');
	$("#cbxDescuentoMes").prop("checked", false)	
	if(tipo == 0)
	{
		MostrarDiv('NotaCredito');
		$('#lbtipoNota').text("Credito");
		$('#lbtipoPagoNota').text(id_tipo_pago+ "-"+ folio_caja);
	}
	else
	{
		MostrarDiv('NotaDevolcuion');
		$('#lbtipoNota').text("Devolucion");
		$('#lbtipoPagoNota').text(id_tipo_pago+ "-"+ folio_caja);
	}	
}

function actualizaImporteNota()
{
	document.getElementById('cargando').style.display = 'block';
	let importeNC=0;
	let importeND=0;
	let documentoNC="";
	let documentoND="";	
	let ICancelado=  $('#lbtipoPagoNota').text().split("-");
	ICancelado[0] = obtieneIdTipoPago(ICancelado[0]);
	
	if($("#cbxDescuentoMes").prop("checked") == false)
	{
		if(!validaDatosParaActualizarNota(false))
		{
			document.getElementById('cargando').style.display = 'none';
			alert('Debes capturar todos los datos solicitados.');
			return;
		}
		else
		{
			document.getElementById('cargando').style.display = 'none';
			let numNota = $('#txtDocumentoNota').val();
			let serieNota =  numNota.substring(0, 1);
			let folioNota =  numNota.substring(1,(numNota.length));			
			if (isNaN(folioNota)) 
			{
				alert('El formato de la nota debe ser una letra y seis numeros (Eje. X000000 )');				
				return;
			}
			
			if (isNaN(serieNota) == false)
			{
				alert('El formato de la nota debe ser una letra y seis numeros (Eje. X000000 )');
				return;
			}
			
			if (folioNota.length != 6)
			{
				alert('El formato de la nota debe ser una letra y seis numeros (Eje. X000000 )');
				return;
			}
		}
		
		document.getElementById('cargando').style.display = 'none';
		if($('#lbtipoNota').text() == 'Credito')
		{
			importeNC= -$('#txtImporteNota').val();
			documentoNC= $('#txtDocumentoNota').val();
		}	
		else
		{
			importeND=-$('#txtImporteNota').val();
			documentoND =$('#txtDocumentoNota').val();
		}	 				
		document.getElementById('cargando').style.display = 'block';	
		$.ajax({
		    url :'ConfirmaIngresosACaja', 
		    data : "vista=ConfirmaIngresosACaja.jsp&operacion=ValidaNotasEnBD" +"&documento_credito=" + documentoNC  + "&documento_devolucion=" + documentoND + "&tipoNota=" + $('#lbtipoNota').text(),
		    type : 'POST',
		    dataType : 'Json',
		    success : function(existeNota)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if(existeNota)
		    	{
		    		actualizaImporteNotaValidaEnBD(ICancelado, importeNC, importeND, documentoNC, documentoND)
		    	}
		    	else
		    	{
		    		alert(' LA NOTA NO EXISTE. Si la nota sera generada en cierre de mes selecciona la opcion DESCUENTO DEL MES ');
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
					alert('Error al actualizar importe de nota.')
			}
		});
	}
	else
	{
		if(!validaDatosParaActualizarNota(true))
		{
			document.getElementById('cargando').style.display = 'none';
			alert('Debes capturar todos los datos solicitados.');
			return;
		}
		else
		{
			if($('#lbtipoNota').text() == 'Credito')
			{
				importeNC= -$('#txtImporteNota').val();
			}	
			else
			{
				importeND=-$('#txtImporteNota').val();
			}
			actualizaImporteNotaValidaEnBD(ICancelado, importeNC, importeND, "DESCUENTO_DEL_MES", "DESCUENTO_DEL_MES");
		}
	}
}


function actualizaImporteNotaValidaEnBD(ICancelado, importeNC, importeND, documentoNC, documentoND)
{
	document.getElementById('cargando').style.display = 'block';	
	$.ajax({
	    url :'ConfirmaIngresosACaja', 
	    data :  "vista=ConfirmaIngresosACaja.jsp&operacion=ActualizaImporteNotaXID" +
	    		"&tipoPago="+ ICancelado[0]+ "&folio_caja="+ ICancelado[1] + "&notaCredito="+ importeNC + "&notaDevolucion="+ importeND + 
	    		"&observaciones="+ $('#txtObservacionesNota').val() + "&encargado="+ $('#cmbUsuNota').val() + "&documento_credito=" + documentoNC  + "&documento_devolucion=" + documentoND+
	    		"&tipoNota=" + $('#lbtipoNota').text(),
	    type : 'POST',
	    dataType : 'Json',
	    success : function(respuesta)
	    { 
	    	OcultarDiv('divEditaNota');
	    	document.getElementById('cargando').style.display = 'none';
	    	if(respuesta)
	    	{
	    		ConsultaDeIngresos();
	    	}
	    	else
	    	{
	    		mostrarMsjError(' Al actualizar el importe.');
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
				alert('Error al actualizar importe de nota.')
		}
	});
}

function validaDatosParaActualizarNota( decuentoMes)
{
	if($('#lbtipoNota').text()  == 'Credito')
		if($('#cmbUsuNota').val() <= 0)
			return false;
	
	if($('#lbtipoNota').text()  == 'Devolucion')
		if($('#txtObservacionesNota').val().length <= 0)
			return false;
	
	if(decuentoMes == false)
	{
		if($('#txtDocumentoNota').val().length <= 0)
		{
			 return false;
		}	
	}
	
	if($('#txtImporteNota').val().length <= 0 || $('#txtImporteNota').val() <= 0)
		 return false;
	
	return true;
}

function CancelarImporteNota()
{
	OcultarDiv('divEditaNota');
	document.getElementById('cargando').style.display = 'block';
	let importeNC=0;
	let importeND=0;
	let ICancelado=  $('#lbtipoPagoNota').text().split("-");
	ICancelado[0] = obtieneIdTipoPago(ICancelado[0]);
	let tipoNota = $('#lbtipoNota').text();
	
	 $.ajax({
		    url :'ConfirmaIngresosACaja', 
		    data : "vista=ConfirmaIngresosACaja.jsp&operacion=CancelarImporteNotaXID" +
		    		"&tipoPago="+ ICancelado[0]+ "&folio_caja="+ ICancelado[1] + 
		    		"&tipoNota="+ tipoNota ,
		    type : 'POST',
		    dataType : 'Json',
		    success : function(respuesta)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if(respuesta)
		    		ConsultaDeIngresos();
		    	else
		    		mostrarMsjError(' Al actualizar el importe.');
		    	
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
					alert('Error al cancelar importe de nota.')
			}
		});
}

/***  ACTUALIZA  FECHA DE POLIZA  ***/
function actualizaFechaPoliza()
{
	document.getElementById('cargando').style.display = 'block';
	let IActualizado = $("#lbfolioFechaPolIngreso").text().split("-");
	let fechaPoliza = $("#txt_fechaPolizaIngreso").val();
	IActualizado[0] = obtieneIdTipoPago(IActualizado[0]);
	
    if (validaFechaPoliza(fechaPoliza) === false)
    {
    	document.getElementById('cargando').style.display = 'none';
    	 let fechaActual= ObtenerFechaActual();
    	 alert("La fecha no puede ser menor a " + fechaActual);
    }
    else
    {
    	OcultarDiv('divEditaFechaPoliza');
    	 $.ajax({
	    		    url :'ConfirmaIngresosACaja', 
	    		    data : "vista=ConfirmaIngresosACaja.jsp&operacion=ActualizaFechaPoliza" +
	    		    		"&tipoPago="+ IActualizado[0] + "&folio_caja="+ IActualizado[1]  + "&fecha_poliza="+ fechaPoliza,
	    		    type : 'POST',
	    		    dataType : 'Json',
	    		    success : function(respuesta)
	    		    { 
	    		    	document.getElementById('cargando').style.display = 'none';
	    		    	ConsultaDeIngresos();
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
	    					alert('Error al cancelar ingreso.')
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

/***  REVERTIR INGRESO CONFIRMADO  ***/
function mostrarAlertaDeRevertirIngreso(IRevertir)
{
	validarSessionDelUsuario();
	MostrarDiv('divRevertirIngreso');
	$("#msjRevertir").text( IRevertir.nombre_pago + "-" + IRevertir.folio_caja);	
}

function revertirIngresoXID()
{
	validarSessionDelUsuario();
	OcultarDiv('divRevertirIngreso');
	let IRevertir = $('#msjRevertir').text().split("-");	
	IRevertir[0] =obtieneIdTipoPago(IRevertir[0]);
	document.getElementById('cargando').style.display = 'block';
	
	 $.ajax({
		    url :'ConfirmaIngresosACaja', 
		    data : "vista=ConfirmaIngresosACaja.jsp&operacion=revertirIngresoXID" +"&tipoPago="+ IRevertir[0]+ "&folio_caja="+ IRevertir[1] ,
		    type : 'POST',
		    dataType : 'Text',
		    success : function(respuesta)
		    { 
		    	if(respuesta)
		    		mostrarMsjExito('El ingreso se regreso a pendiente.');
		    	else
		    		mostrarMsjError('Al revertir el ingreso.');
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
					alert('Error al revertir ingreso.')
			}
		}); 
	
	 $(function(){
		document.getElementById('cargando').style.display = 'none';
		ConsultaDeIngresos();
		}			
	);	
}

/***  AGREGAR FACTURA MANUELAMENTE  ***/
function MostrarMtoFacturaManual()
{
	MostrarDiv('divAlertaAgregarFacturaManual');
	$('#numFacturaManual').val("")
}

function agregarFacturaManualmente()
{
	let facturaLarga = $('#numFacturaManual').val();
	if(facturaLarga.length != 15)
	{
		alert("La factura capturada no es valida, verifica la informacion.")
	}
	else
	{
		document.getElementById('cargando').style.display = 'block';
		$.ajax({
			    url :'ConfirmaIngresosACaja', 
			    data : "vista=ConfirmaIngresosACaja.jsp&operacion=facturaCreditoManual" +
			    		"&formaPago=" + $('#cmbFormaPagoFacCre').val()+
			    		"&facturaManual=" + $('#numFacturaManual').val(),
			    type : 'POST',
			    dataType : 'Text',
			    success : function(respuesta)
			    { 
			    	document.getElementById('cargando').style.display = 'none';
			    	if(respuesta === "FacturaValida")
			    	{
			    		OcultarDiv('divAlertaAgregarFacturaManual');
			    		alert('La factura fue agregada CORRECTAMENTE');
			    		ConsultaDeIngresos();
			    	}
			    	else if(respuesta === "FacturaNoValida")
			    	{
			    		alert('La factura capturada NO ES VALIDA para gregarla en el sistema.');
			    	}
			    	else if(respuesta === "FacturaDuplicada")
			    	{
			    		alert('La factura ya fue capturada en el sistema el dia de hoy.');
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
						alert('Error al cancelar importe de nota.')
				}
		 });
	}
	
	
}

function MostrarOcultarTotales()
{
	 let checked = false;
	 $('#cbxsTotalizado input:checked').each(function () 
	 {
        let tipo = $(this).attr('id');        
        checked= true;
	 });
	 
	 if(checked)
     {
     	MostrarDiv("tb_TotalesGrid")
     }
     else
     {
     	OcultarDiv("tb_TotalesGrid")
     }    
}




function consultaDetallefolioHojaDeRuta(folioHojaRuta)
{
	document.getElementById('cargando').style.display = 'block';	
	$.ajax({
	    url :'ConfirmaIngresosACaja', 
	    data :  "vista=ConfirmaIngresosACaja.jsp&operacion=ConsultaDetalleFolioHR" +
	    		"&folio_caja="+ folioHojaRuta,
	    type : 'POST',
	    dataType : 'Json',
	    success : function(respuesta)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
	    	$("#lb_folio_detalleFHR").text(folioHojaRuta);
	    	llenaGridDetalleFolioHojaRuta(respuesta);   
	    	MostrarDiv('divAlertaDetalleFolioHojaRutal');    	
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
				alert('Error al actualizar importe de nota.')
		}
	});
}


function llenaGridDetalleFolioHojaRuta(data)
{
	var db =
	{
		loadData: function (filter)/** seccion de filtros **/
	    {
	    	 return $.grep(data, function (corte) {
	    		 return (!corte.num_fac || corte.num_fac.indexOf(corte.num_fac) > -1)
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
    	    	 $("#dgDetalleFHR").jsGrid({
    	    		 width: "80%",
    	             height: "300px",
    	             editing: false,
    	             filtering: true,
    	             sorting: true,
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
    	            	 let items = args.grid.option("data");
    	            	 let totales= calculaImportesTotalesDelGridDFHR(items)
    	                 let $totalRow = $("<tr>").addClass("total-row");
    	                 args.grid._renderCells($totalRow, totales);
    	                 args.grid._content.append($totalRow);
    	             },
    	             fields: 
    	             [    	            	 
    	                 { name: "uname_br", title: "Uname", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: false,  css: 'EG_hide'},    	                
    	                 { name: "folio_caja", title: "ticket",  type: "text", width: 15, align: 'center', editing: false, inserting: false, filtering: false, css: 'EG_hide'},
    	                 { name: "num_fac",  title: "FACTURA", type: "text", width: 20, align: 'center', editing: false, inserting: false, filtering: true},
    	                 { name: "descripcion", title: "FORMA DE PAGO",  type: "text", width: 30, align: 'center', editing: false, inserting: false, filtering: false}, 
    	                 { name: "importe",  title: "IMPORTE", type: "text", width: 20, align: 'right', editing: false, inserting: false, filtering: false},    	                
	                 ],
	        	 });
	         });
     $("#dgDetalleFHR").show();
}


function calculaImportesTotalesDelGridDFHR(items)
{
	 let total = {
			 uname_br: "",folio_caja: "", num_fac: "TOTAL", descripcion: "", importe:0,  IsTotal: true
     };
	  
	 items.forEach(function (item){
         total.importe += parseFloat(item.importe.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));  
     });
	 total.importe = "$ " + FormatearTotalesDeGrid(total.importe)
	 $("#lb_total_DetalleFHR").text("TOTAL: " + total.importe);
     return total;
}


