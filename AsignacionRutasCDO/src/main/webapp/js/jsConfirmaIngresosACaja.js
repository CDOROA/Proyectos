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
}

/***   FUNCIONES HOJA RUTA CDO  ***/
function MostrarMtoFacturas()
{
    document.getElementById('popupFac').style.display = 'block';
}

function OcultarMtoFaturas()
{
    document.getElementById('popupFac').style.display = 'none';
}

function soloNumeros(e) {
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
	$('#cmbEstatus').val("0");
	$('#txt_fechaIni').val(ObtenerFechaActual());
	$('#txt_fechaFin').val(ObtenerFechaActual());	
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
	let tipo_pago = obtenerTipoDePago();
	BuscaIngresosCapturadosXParametro(tipo_pago, fechaIni, fechaFin, estatus);
}

function BuscaIngresosCapturadosXParametro(tipoPago, fechaInicio, fechaFin, estatus)
{
	document.getElementById('cargando').style.display = 'block';
	
	$("dgIngresos").jsGrid("option", "data", []);	
	OcultarAlertas();
	$.ajax({
	    url :'ConfirmaIngresosACaja', 
	    data : "vista=ConfirmaIngresosACaja.jsp&operacion=ConsultaInicialDeIngresos&tipoPago="+ tipoPago+ "&fecha_inicio="+ fechaInicio+ "&fechaFin="+ fechaFin+ "&estatus="+ estatus , 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	var data = json;
	        if( data.length > 0)
        	{
	        	MostrarDiv('dgIngresos');
	        	cargaConceptosCapturadosEnGrid(data);OcultarDiv('divMjsInfo');
	        	document.getElementById('cargando').style.display = 'none';
        	}
	        else
	        {	
	        	mostrarMsjInfo('No se encontraron registros en el sistema en el periodo  ' + fechaInicio+  "  y  " +  fechaFin);
	        	OcultarDiv('dgIngresos');
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
				alert('Error al buscar ingresos en el sistema.')
		}
	});
}

function cargaConceptosCapturadosEnGrid(data)
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
             height: "600px",
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
             
             fields: 
             [
                 { name: "uname", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false,  css: 'EG_hide'},
                 { name: "uname_br", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide' },
                 { name: "id_tipo_pago", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide',},
                 { name: "nombre_pago",  type: "text", title: "TIPO", width: 18, align: 'center', editing: false, inserting: false, filtering: true,
                	 itemTemplate: function (value, item) {
                		 return crearColumnaTipoPagoParaGrid(value)
                     }
                 },
                 { name: "fecha_creacion", type: "text", title: "FECHA", width:30, align: 'center', editing: false, inserting: false, filtering: true},
                 { name: "folio_caja",  type: "text", title: "FOLIO",width: 20, align: 'center', editing: false, inserting: false, filtering: true},
                 { name: "cve_usu",  type: "text", title: "USUARIO", width: 23, align: 'center', editing: false, inserting: false, filtering: true},
                 { name: "nombre_usu", type: "text", title: "NOMBRE", width: 90, align: 'left', editing: false, inserting: false, filtering: true}, 
                 { name: "importe", type: "text",title: "TOTAL", width: 40, align: 'right', editing: false, inserting: false, filtering: false},
                 { name: "efectivo", type: "text", title: "EFECTIVO", width: 40, align: 'right', editing: true, inserting: false,filtering: false},
                 { name: "cheque", type: "text", title: "CHEQUE", width: 40, align: 'right', editing: true, inserting: false,filtering: false },
                 { name: "porfechado", type: "text", title: "POSFECHADO", width: 40, align: 'right', editing: true, inserting: false, filtering: false},
                 { name: "tarjeta", type: "text", title: "T. CREDITO", width:35, align: 'right', editing: true, inserting: false,filtering: false},
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
                 { name: "estatus", type: "text", title: "ESTATUS", width: 25, align: 'center', editing: false, inserting: false,css: 'EG_hide', filtering: false,
                	 editTemplate: function (value, item) {
                         if (value > 0) {
                             var $result = jsGrid.fields.text.prototype.editTemplate.apply(this, argumets);
                             $result.prop("readonly", item.notEditable);
                             $result.prop("readonly", item.deleteButton);
                             return $result;
                         }
                     }
                 },
                 { name: "decripcion_Estatus", type: "text", title: "ESTATUS", width: 40, align: 'center', editing: false, inserting: false,   filtering: false,                           	 
                	 itemTemplate: function (value, item) {
                         return crearColumnaEstatusParaGrid(value);
                     }
                 },
                 { name: "btnImprimir", type: "text", title: " ", width: 12, align: 'center', editing: false, inserting: false,  filtering: false, 
                	 itemTemplate: function (value, item) {
                		 if (item.estatus == "0") {
                             return $("<button>").attr("class", "EG_btnImpGrid").text("Imp").on("click", function () {
                            	 muestraAlertaConfirmacionIngreso(item);
                                 return false;
                             });
                		 }
                     }
                 },
                 { name: "btnReImprimir", type: "text", title: " ", width: 12, align: 'center', editing: false, inserting: false,  filtering: false, 
                	 itemTemplate: function (value, item) {
                		 if (item.estatus == "1") {
                             return $("<button>").attr("class", "EG_btnImpGrid").text("Imp").on("click", function () {
                            	 reimprimirIngresoXID(item);
                                 return false;
                             });
                		 }
                     }
                 },
                 { name: "btnCancelar", type: "text", title: " ", width: 12, align: 'center', editing: false, inserting: false,  filtering: false, 
                	 itemTemplate: function (value, item) {
                		 if (item.estatus == "0") {
                             return $("<button>").attr("class", "EG_btnCancela").on("click", function () {
                            	 mostrarAlertaDeCancelacion(item);
                                 return false;
                             });
                		 }
                     }
                 },
                 { type: "control",title: " ",  width: 22,
                     itemTemplate: function (value, item) {
                    	 var $result = $([]);
                         if (item.estatus == "0")
                             $result = $result.add(this._createEditButton(item));
                         return $result;
                         
                     },
                 },
        	 ],
    	 });
     });
}

/***   SECCION DE FUNCIONES PARA CONSTRUIR GRID ***/
function crearColumnaNotaDevolucionParaGrid(item)
{
	 if (item.estatus == "0"  &&  (item.id_tipo_pago == "2" || item.id_tipo_pago == "3"))
     {
         return $("<button>").attr("class", "EG_link").text(item.notaDevolucion).on("click", function () {
        	 MostrarDiv('divEditaNota');
    		 validaTipoNota(1,  item.folio_caja, item.nombre_pago);
         });
     }
     else
         return $("<div>").attr("style", "divClasica").text(item.notaDevolucion);
}

function crearColumnaNotaCreditoParaGrid(item)
{
	if (item.estatus == "0" &&  (item.id_tipo_pago == "2" || item.id_tipo_pago == "3"))
	{
	    return $("<button>").attr("class", "EG_link").text(item.notaCredito).on("click", function () {
	   	 	MostrarDiv('divEditaNota');
			 validaTipoNota(0, item.folio_caja, item.nombre_pago);
	    });
	}
	else
	    return $("<div>").attr("style", "divClasica").text(item.notaCredito);
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
}

function crearColumnaTipoPagoParaGrid(value)
{
	 if (value === "COB") {
         return $("<div>").attr("class", "EG_divCOB").text(value);
     }
     else if (value === "HR") {
         return $("<div>").attr("class", "EG_divHR").text(value);
     }
     else if (value === "OI") {
         return $("<div>").attr("class", "EG_divOI").text(value);
     }     
     else if (value === "CON") {
         return $("<div>").attr("class", "EG_divCON").text(value);
     }
}

/******************* SECCION TOTALES DEL GRID ********************/
function calculaImportesTotalesDelGridIngresos(items)
{
	 let total = {
		  btnCancelar: "", btnImprimir: "", uname: "", uname_br: "", id_tipo_pago: "", nombre_pago: "", fecha_creacion: "", folio_caja: "", cve_usu: "", nombre_usu: "TOTALES", importe: 0, 
		  efectivo: 0, cheque: 0, porfechado: 0, tarjeta: 0,  debito: 0, notaCredito: 0, notaDevolucion: 0, estatus: "", decripcion_Estatus: "",  IsTotal: true
     };
	  
	 items.forEach(function (item){
         total.importe += parseFloat(item.importe.replace(',', ''));
         total.efectivo += parseFloat(item.efectivo.replace(',', ''));
         total.cheque += parseFloat(item.cheque.replace(',', ''));
         total.porfechado += parseFloat(item.porfechado.replace(',', ''));
         total.tarjeta += parseFloat(item.tarjeta.replace(',', ''));
         total.debito += parseFloat(item.debito.replace(',', ''));
         total.notaCredito += parseFloat(item.notaCredito.replace(',', ''));
         total.notaDevolucion += parseFloat(item.notaDevolucion.replace(',', ''));
     });
	  
	 total.importe = "$ " + FormatearTotalesDeGrid(total.importe)
     total.efectivo = "$ " + FormatearTotalesDeGrid(total.efectivo)
     total.cheque =  "$ " + FormatearTotalesDeGrid(total.cheque)
     total.porfechado =  "$ " + FormatearTotalesDeGrid(total.porfechado)
     total.tarjeta = "$ " + FormatearTotalesDeGrid(total.tarjeta)
     total.debito =  "$ " + FormatearTotalesDeGrid(total.debito)
     total.notaCredito =  "$ " + FormatearTotalesDeGrid(total.notaCredito);
     total.notaDevolucion = "$ " +  FormatearTotalesDeGrid(total.notaDevolucion)
          
     return total;
}

function FormatearTotalesDeGrid(importe)
{
	let importeTotalGrid = parseFloat(importe).toFixed(2);
	importeTotalGrid = agregarCommas(importeTotalGrid);
	return importeTotalGrid;
}



/***   FUNCIONES ACTUALIZA  INGRESOS  ***/
function validaImportesCorrectos(IPrevio,IActualizado)
{
	if(IActualizado.id_tipo_pago == 2)
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
		
	if(efectivo <= 0 &&  cheque <= 0 && tarjeta <= 0 && debito <= 0 && porfechado <= 0)
		return false;
	else
		return true;
}

function sumaImportes(IActualizado)
{
	 let total=0;
	 let ITotal= convertirFloat(IActualizado.efectivo.replace(',', ''))  + 
			      convertirFloat(IActualizado.cheque.replace(',', ''))  + 
			      convertirFloat(IActualizado.tarjeta.replace(',', ''))  + 
			      convertirFloat(IActualizado.debito.replace(',', '')) +
			      convertirFloat(IActualizado.transferencia.replace(',', '')) +
			      convertirFloat(IActualizado.porfechado.replace(',', '')); 	
	 
	 let ETotal = convertirFloat(IActualizado.notaCredito.replace(',', '')) + 
	 			  convertirFloat(IActualizado.notaDevolucion.replace(',', ''));
	 ETotal = ETotal * -1;
	 
	 total=ITotal - (ETotal);
	 return total.toFixed(2);
}

function ActualizaIngresoXID(IActualizado)
{
	document.getElementById('cargando').style.display = 'block';
	 let importeTotal= sumaImportes(IActualizado); 	 
	 
	 $.ajax({
		    url :'ConfirmaIngresosACaja', 
		    data : "vista=ConfirmaIngresosACaja.jsp&operacion=ActualizaIngresoXID" +
		    		"&tipoPago="+ IActualizado.id_tipo_pago+ "&folio_caja="+ IActualizado.folio_caja +
		    		"&importe="+ importeTotal +"&efectivo="+ IActualizado.efectivo.replace(',', '')+
		    		"&cheque="+ IActualizado.cheque.replace(',', '')+"&tarjeta="+ IActualizado.tarjeta.replace(',', '')+
		    		"&debito="+ IActualizado.debito.replace(',', '')+"&porfechado="+ IActualizado.porfechado.replace(',', '')+
		    		"&transferencia="+ IActualizado.transferencia.replace(',', '')+
		    		"&notaCredito="+ IActualizado.notaCredito.replace(',', '')+
		    		"&notaDevolucion="+ IActualizado.notaCredito.replace(',', ''),
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


/***   FUNCIONES CANCELAR INGRESOS   ***/
function mostrarAlertaDeCancelacion(ICancelado)
{
	console.log("s");
	validarSessionDelUsuario();
	MostrarDiv('divCancelacion');
	$("#msjCancelacion").text( ICancelado.nombre_pago + "-" + ICancelado.folio_caja);	
}

function CancelarIngresoXID()
{
	let motivo = $('#cmbMotCancela').val();
	if(motivo <= 0){
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
		    	document.getElementById('cargando').style.display = 'none';
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
	 
	 
	 ConsultaDeIngresos();
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
	    });
	 return tipo_pago;
}

function obtieneIdTipoPago(nombreCorto)
{
	let idTP="";
	switch(nombreCorto)
	{
		case 'COB':
			idTP =1;
			break;
			
		case 'HR':
			idTP =2;
			break;
			
		case 'CON':
			idTP =3;
			break;
			
		case 'OI':
			idTP =4;
			break;
	}
	return idTP;
}


/***   FUNCIONES CONFIRMAR INGRESOS  ***/
function muestraAlertaConfirmacionIngreso(Iconfirmado)
{
	validarSessionDelUsuario();	
	MostrarDiv('divConfirmar');
	$("#msjConfirmacion").text(Iconfirmado.nombre_pago+ "-" + Iconfirmado.folio_caja);
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
		Iconfirmado.decripcion_Estatus);//18
	
}

function confirmarIngresoXID()
{
	OcultarDiv('divConfirmar');
	document.getElementById('cargando').style.display = 'block';
	let IConfirmar = $('#lbDatosIConfirmado').val().split("&");
	
	$.ajax({
	    url :'ConfirmaIngresosACaja', 
	    data : "vista=ConfirmaIngresosACaja.jsp&operacion=ConfirmaIngresoXID" +
	    		"&tipoPago="+ IConfirmar[2]+ "&folio_caja="+ IConfirmar[5]+
	    		"&cve_usu="+ IConfirmar[6]+ "&importe="+ IConfirmar[8]+
	    		"&efectivo="+ IConfirmar[9]+ "&cheque="+ IConfirmar[10]+
	    		"&porfechado="+ IConfirmar[11]+ "&tarjeta="+ IConfirmar[12]+
	    		"&debito="+ IConfirmar[13]+ "&transferencia="+ IConfirmar[14]+
	    		"&notaCredito="+ IConfirmar[15]+ "&notaDevolucion="+ IConfirmar[16]+
	    		"&usu_nombre="+ IConfirmar[7],
	    		
	    type : 'POST',
	    dataType : 'Json',
	    success : function(respuesta)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
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
	 
	 ConsultaDeIngresos();
}

/***   FUNCIONES RE-IMPRIME INGRESOS  ***/
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
	    	document.getElementById('cargando').style.display = 'none';
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

/***   FUNCIONES EDITA IMPORTE NOTA   ***/
function validaTipoNota(tipo, folio_caja, id_tipo_pago)
{
	validarSessionDelUsuario();	
	OcultarDiv('NotaCredito');
	OcultarDiv('NotaDevolcuion'); 
	$('#cmbUsuNota').val(0);
	$('#txtImporteNota').val("");
	$('#txtObservacionesNota').val("");
	$('#txtDocumentoNota').val("");
	
	if(tipo == 0){
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
	
	if(!validaDatosParaActualizarNota())
	{
		document.getElementById('cargando').style.display = 'none';
		alert('Debes capturar todos los datos solicitados.');
		return;
	}
	else
	{
		OcultarDiv('divEditaNota');
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
		
		$.ajax({
			    url :'ConfirmaIngresosACaja', 
			    data : "vista=ConfirmaIngresosACaja.jsp&operacion=ActualizaImporteNotaXID" +
			    		"&tipoPago="+ ICancelado[0]+ "&folio_caja="+ ICancelado[1] + "&notaCredito="+ importeNC + "&notaDevolucion="+ importeND + 
			    		"&observaciones="+ $('#txtObservacionesNota').val() + "&encargado="+ $('#cmbUsuNota').val() + "&documento_credito=" + documentoNC  + "&documento_devolucion=" + documentoND+
			    		"&tipoNota=" + $('#lbtipoNota').text(),
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
						alert('Error al actualizar importe de nota.')
				}
			});
	}
}

function validaDatosParaActualizarNota()
{
	if($('#lbtipoNota').text()  == 'Credito')
		if($('#cmbUsuNota').val() <= 0)
			return false;
	
	if($('#lbtipoNota').text()  == 'Devolucion')
		if($('#txtObservacionesNota').val().length <= 0)
			return false;
	
	if($('#txtDocumentoNota').val().length <= 0)
		 return false;
	
	if($('#txtImporteNota').val().length <= 0)
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


