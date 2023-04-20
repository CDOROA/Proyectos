function envioRangoFechas() 
{
	if ($("#txt_fechaIniPedidos").val() != '' && $("#txt_fechaFinPedidos").val() != '' )
	{
		consultaMarcadoClientes()
	}
	else
	{
		alert('Ingrese una fecha valida')
	}	
}

function envioRangoFechast() 
{
	if ($("#txt_fechaIniPedidost").val() != '' && $("#txt_fechaFinPedidost").val() != '' )
	{
		consultaPedidosBDTrans('',$('input:radio[name=mostrarInfoPort]:checked').val())
	}
	else
	{
		alert('Ingrese una fecha valida')
	}	
}


function envioRangoFechasc() 
{
	if ($("#txt_fechaIniPedidosc").val() != '' && $("#txt_fechaFinPedidosc").val() != '' )
	{
		$("#divMarcadoClientes").css("visibility", "hidden");
		consultaPedidosBD('',$('input:radio[name=mostrarInfoPorc]:checked').val());
	}
	else
	{
		alert('Ingrese una fecha valida')
	}	
}

function envioRangoFechasRc() {
	if($("txt_fechaIniPedidosRc").val() != '' && $("txt_fechaFinPedidosRc").val() != ''){
		//alert("Entra a envio de RangoFecha");
		$("#divMarcadoClientesRC").css("visibility", "hidden");
		$("#divMarcadoDetalleRC").css("visibility", "hidden");
		consultarPedidosRcBD();
	}else{
		alert('Ingrese una fecha valida');
	}
}


function consultarPedidosconParametros() 
{
	$("#divMarcadoClientes").css("visibility", "hidden");
	consultaPedidosBD('',$('input:radio[name=mostrarInfoPor]:checked').val());
}

function emptyChofer()
{
	$("#dgZonasClic").empty();
	
}
function ocultarModalMarcado()
{
	$("#divMarcadoClientes").css("visibility", "hidden");
}

function ocultarModalMarcadoRC()
{
	$("#tblDinamicaMarcadoRC").html("")
	$("#tblDinamicaMarcadoRC").val("")
	$("#choferMarcadoJson").val("")
	$("#divMarcadoClientesRC").css("visibility", "hidden");
}

function ocultarModalMarcadoDetalleRC()
{
	$("#divMarcadoDetalleRC").css("visibility", "hidden");
	$("#inputChoferMarcadoDetalleRC").val("");
}

function clickAsigancionChofe() 
{
	$("#inputChoferMarcado").val("");
	$("#inputChoferMarcadoDetalleRC").val("");
	$("#divMarcadoClientes").css("visibility", "hidden");
	$("#divMarcadoDetalleRC").css("visibility", "hidden");
	$("#divMarcadoClientesRC").css("visibility", "hidden");
	emptyChofer()
	OcultarDiv('encabezadoPedidos');
	eliminarCredito();fecha();quitarChofer();
	OcultarDiv('btnConfirmarFac');
	OcultarDiv('monitor');OcultarDiv('credito');
//	MostrarDiv('asignacion');
	$("#ordenMarcado").hide();
	$("#ordenMarcadoRC").hide();
	$("#ordenMarcadoRC2").hide();
	OcultarDiv('impresion');OcultarDiv('encabezadoPedidosInicial');
	OcultarDiv('encabezadoPedidosInicialRC');
	//	OcultarDiv('asignacionTransportes');
	OcultarDiv('encabezadoPedidosInicialTrans');actualizar();
	OcultarDiv('corte');OcultarDiv('divDetalle');
	vaciarCredito()	
}



function principalT() 
{
	OcultarDivStyle('asignacionTransportes')
	$('#txt_fechaIniPedidost').val(ObtenerFechaActual());
	$('#txt_fechaFinPedidost').val(ObtenerFechaActual());
	$("#divCalendariot").show()
}
function principal() 
{
	clickAsigancionChofe();
	OcultarDivStyle('asignacion')
	$('#txt_fechaIniPedidosc').val(ObtenerFechaActual());
	$('#txt_fechaFinPedidosc').val(ObtenerFechaActual());
	$("#divCalendarioc").show()
}

function principalRC() 
{
	//alert("Entra a principalRC");
	clickAsigancionChofe();
	OcultarDivStyle('asignacionRC')
	$('#txt_fechaIniPedidosRc').val(ObtenerFechaActual());
	$('#txt_fechaFinPedidosRc').val(ObtenerFechaActual());
	$("#divCalendariocRC").show()
}

function empty()
{
	$("#dgZonasClicTrans").empty();
}

function OcultarDivStyle(id)
{
	$("#"+id+"").addClass("oculto");
}
function MostrarDivStyle(id)
{
	$("#"+id+"").removeClass("oculto");
}
function consultaMarcadoClientes() 
{
	document.getElementById('dgZonasClicTrans').innerHTML = '';
	document.getElementById('cargando').style.display = 'block';
	$("#divMsjError").hide();
	$("#divChofer").hide();
	$("#divMsjExito").hide();
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : "accion=ConsultaMarcadoClientes&ruta=&tipo=&fechaInicio="+$("#txt_fechaIniPedidos").val()+"&fechaFin="+$("#txt_fechaFinPedidos").val(), 
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
	        		llenarGridMarcadoClientes(data)
	        		 $("#divMarcadoClientes").css("visibility", "visible");
	        		$("#divCalendario").hide()
	        		$("#gridMarcadoClientes").show()
	        		
	        	} 
	        	else
	        	{	
	        		alert("No existen facturas para asignar")
	        	}
        	}
	        else		        	
	    var n;
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
			}
		}
	});
}
//gridInicial()

function OcultarDivVisible() 
{
	$("#divMarcadoClientes").css("visibility", "hidden");
}


function llenarGridMarcadoClientesRC(data,tipo)
{
    //alert(JSON.stringify(data));
	var db;
	db = {
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	
	    	return $.grep(data, function (egreso) {
	            return     (!filter.cliente.toUpperCase()|| egreso.cliente.toUpperCase() === filter.cliente.toUpperCase() || egreso.cliente.toUpperCase() == filter.cliente.toUpperCase() || egreso.cliente.toUpperCase().includes(filter.cliente.toUpperCase()))
	                     && (!filter.direccion.toUpperCase()|| egreso.direccion.toUpperCase() === filter.direccion.toUpperCase() || egreso.direccion.toUpperCase() == filter.direccion.toUpperCase() || egreso.direccion.toUpperCase().includes(filter.direccion.toUpperCase()))
	                     &&  (!filter.facturas.toUpperCase()|| egreso.facturas.toUpperCase() === filter.facturas.toUpperCase() || egreso.facturas.toUpperCase() == filter.facturas.toUpperCase())
	                     && (!filter.ruta.toUpperCase()|| egreso.ruta.toUpperCase() === filter.ruta.toUpperCase() || egreso.ruta.toUpperCase() == filter.ruta.toUpperCase() || egreso.ruta.toUpperCase().includes(filter.ruta.toUpperCase()))
	        });
	    	
	    },
	    insertItem: function (insertingClient) 
	    {
	    	
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {
	    
	    },
	 };
		
	window.db = db;
	  db.data;
    $(function ()
    	     {
    	    	 $("#gridMarcadoClientesRC").jsGrid({
    	    		 width: "99%",
    	             height: "700",
    	             editing: false,
    	             filtering: true,
    	             selecting: true,
    	             sorting: true ,
    	             paging: false,
    	             pageSize: 600,
    	             css: "grid_marcado",
    	             controller: 
    	             {
    	            	 
    	                 loadData: function () 
    	                 {
    	                     dataType: "json"
    	                     return data ;
    	                 }    	    	 
    	             },
    	             controller: db,
    	             loadMessage: "Please, wait...",
    	             onRefreshed: function (args) 
    	             { 
    	            	 var filtro = $("#inputChoferMarcado").val();
    	            	 if (filtro != '')
    	            	 {
    	            		var split = filtro.split(",");
							for (var i = 0; i < split.length; i++) 
							{
								if(document.getElementById(split[i]))
								{
									document.getElementById(split[i]).checked = true;
							    }
								
							}
							
    	            	 }
    	             },
    	             autoload: true,
    	             fields: 
    	             [
    	               	 { name: "cnt", type: "checkbox",width: 13, title: "ORDEN",visible:true, editing:false,  filtering: false,  
						     itemTemplate: function(_, item) 
						     {
//						    	 console.log("x")
						    	 return `<input class="single ${item.id}"  name="checksMarcadoRC[]" id='${item.id}*${item.ruta}*${item.cliente}'  value=${item.id} onclick="sMarcado();pegarSelOdeMarcadoRC('${item.id}*${item.ruta}*${item.cliente}')" type="checkbox" style="height: 10px;width: 10px;"/>`
						     }
    	               	 },
    	               	
    	            	 { name: "ruta", type: "text", title: "RUTA", width:12, align: 'left',filtering: true},
    	            	 { name: "cliente",  type: "text", title: "CLIENTE", width: 12, align: 'center', filtering: true},
    	            	 { name: "direccion",  type: "text", title: "DIRECCION", width:60 , align: 'left', filtering: true},
    	            	 { name: "facturas",  type: "text", title: "FACTURAS", width: 20, align: 'center', filtering: true},
    	            	 { name: "bolsas",  type: "text", title: "BOLSAS", width: 20, align: 'center', filtering: true},
    	            	 { name: "cajas",  type: "text", title: "CAJAS", width: 20, align: 'center', filtering: true },
    	            	 { name: "paquetes",  type: "text", title: "PAQUETES", width: 20, align: 'center', filtering: true },
    	            	 { name: "atados",  type: "text", title: "ATADOS", width: 20, align: 'center', filtering: true },
    	            	 { name: "acumuladores",  type: "text", title: "ACUMUL", width:15, align: 'center', filtering: true },
    	            	 { name: "tarimas",  type: "text", title: "TARIMAS", width: 15, align: 'center', filtering: true },
    	            	 { name: "otros",  type: "text", title: "OTROS", width: 15, align: 'center', filtering: true },
    	            	 { name: "peso",  type: "text", title: "PESO", width: 10, align: 'center', filtering: true }
    	             ],
	                 
	        	 });
	         });
    
}


function llenarGridMarcadoClientes(data,tipo)
{
    //alert(JSON.stringify(data));
	var db;
	db = {
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	
	    	return $.grep(data, function (egreso) {
	            return     (!filter.cliente.toUpperCase()|| egreso.cliente.toUpperCase() === filter.cliente.toUpperCase() || egreso.cliente.toUpperCase() == filter.cliente.toUpperCase() || egreso.cliente.toUpperCase().includes(filter.cliente.toUpperCase()))
	                     && (!filter.direccion.toUpperCase()|| egreso.direccion.toUpperCase() === filter.direccion.toUpperCase() || egreso.direccion.toUpperCase() == filter.direccion.toUpperCase() || egreso.direccion.toUpperCase().includes(filter.direccion.toUpperCase()))
	                     &&  (!filter.facturas.toUpperCase()|| egreso.facturas.toUpperCase() === filter.facturas.toUpperCase() || egreso.facturas.toUpperCase() == filter.facturas.toUpperCase())
	                     && (!filter.ruta.toUpperCase()|| egreso.ruta.toUpperCase() === filter.ruta.toUpperCase() || egreso.ruta.toUpperCase() == filter.ruta.toUpperCase() || egreso.ruta.toUpperCase().includes(filter.ruta.toUpperCase()))
	        });
	    	
	    },
	    insertItem: function (insertingClient) 
	    {
	    	
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {
	    
	    },
	 };
		
	window.db = db;
	  db.data;
    $(function ()
    	     {
    	    	 $("#gridMarcadoClientes").jsGrid({
    	    		 width: "99%",
    	             height: "700",
    	             editing: false,
    	             filtering: true,
    	             selecting: true,
    	             sorting: true ,
    	             paging: false,
    	             pageSize: 600,
    	             css: "grid_marcado",
    	             controller: 
    	             {
    	            	 
    	                 loadData: function () 
    	                 {
    	                     dataType: "json"
    	                     return data ;
    	                 }    	    	 
    	             },
    	             controller: db,
    	             loadMessage: "Please, wait...",
    	             onRefreshed: function (args) 
    	             { 
    	            	 var filtro = $("#inputChoferMarcado").val();
    	            	 if (filtro != '')
    	            	 {
    	            		var split = filtro.split(",");
							for (var i = 0; i < split.length; i++) 
							{
								if(document.getElementById(split[i]))
								{
									document.getElementById(split[i]).checked = true;
							    }
								
							}
							
    	            	 }
    	             },
//    	             onRefreshing : function ( args ) 
//    	             {
//    	                 var $gridData = $("#gridMarcadoClientes .jsgrid-grid-body tbody");
//    	       	      var aux = 0
//    	       	                 $gridData.sortable({
//    	       	                     update: function(e, ui) {
////    	       	                    	 console.log(e)
////    	       	                    	 console.log(ui)
////    	       	                    	 let items = args.grid.option("data");
////    	       	                    	 console.log("AUC: "+aux+": "+items);aux++
//    	       	                    	 
//    	       	                         // array of indexes
//    	       	                         var clientIndexRegExp = /\s*client-(\d+)\s*/;
//    	       	                         var indexes = $.map($gridData.sortable("toArray", { attribute: "class" }), function(classes) {
//    	       	                             return clientIndexRegExp.exec(classes)[1];
//    	       	                         });
//    	       	                         alert("Reordered indexes: " + indexes.join(", "));
//    	       	      
//    	       	                         // arrays of items
//    	       	                         var items = $.map($gridData.find("tr"), function(row) {
//    	       	                        	 
//    	       	                             return $(row).data("JSGridItem");
//    	       	                         });
////    	       	                         
//    	       	                         console && console.log("Reordered items", items);
//    	       	                     }
//    	       	                 });     
//    	       	   
//    	             },
//    	             onRefreshed: function(args) 
//    	             {
//    	      
//    	             },
    	             autoload: true,
    	             fields: 
    	             [
    	               	 { name: "cnt", type: "checkbox",width: 10, title: "ORDEN",visible:true, editing:false,  filtering: false,  
						     itemTemplate: function(_, item) 
						     {
//						    	 console.log("x")
						    	 return `<input class="single ${item.id}"  name="checksMarcado[]" id='${item.id}*${item.ruta}*${item.cliente}'  value=${item.id} onclick="sMarcado();pegarSelOdeMarcado('${item.id}*${item.ruta}*${item.cliente}')" type="checkbox" style="height: 10px;width: 10px;"/>`
						     }
    	               	 },
    	               	
    	            	 { name: "ruta", type: "text", title: "RUTA", width:10, align: 'left',filtering: true},
    	            	 { name: "cliente",  type: "text", title: "CLIENTE", width: 10, align: 'center', filtering: true},
    	            	 { name: "direccion",  type: "text", title: "DIRECCION", width:60 , align: 'left', filtering: true},
    	            	 { name: "facturas",  type: "text", title: "FACTURAS", width: 10, align: 'center', filtering: true},
    	            	 { name: "bolsas",  type: "text", title: "BOLSAS", width: 10, align: 'center', filtering: true},
    	            	 { name: "cajas",  type: "text", title: "CAJAS", width: 10, align: 'center', filtering: true },
    	            	 { name: "paquetes",  type: "text", title: "PAQUETES", width: 10, align: 'center', filtering: true },
    	            	 { name: "atados",  type: "text", title: "ATADOS", width: 15, align: 'center', filtering: true },
    	            	 { name: "acumuladores",  type: "text", title: "ACUMUL", width:15, align: 'center', filtering: true },
    	            	 { name: "tarimas",  type: "text", title: "TARIMAS", width: 15, align: 'center', filtering: true },
    	            	 { name: "otros",  type: "text", title: "OTROS", width: 15, align: 'center', filtering: true },
    	            	 { name: "peso",  type: "text", title: "PESO", width: 10, align: 'center', filtering: true }
    	             ],
	                 
	        	 });
	         });
    
}

function gridInicial()
{
	
	
	var nivel = $("#nivelUsu").val();
	if (nivel != 3) 
	{
		if ($("#redireccionar").val() != '')
		{
			switch (parseInt($("#redireccionar").val())) 
			{
				case 1:
					$("#encabezadoPedidosInicial").hide()
					if ($("#choferTipoSession").val() != "")
					{
						consultaPedidosBD('',$("#choferTipoSession").val());
					}
					else
					{
						$("#divChofer").show();
					}
					break;
				case 2:
					
					consultaPedidosBDTrans('',$("#transporteTipoSession").val())
					 $(".trans").click();
					$("#divTransporte").hide()
					break;
				case 3:
					$(".monito").click();
					break;
				default:
					$(".chof").click();
					break;
				
			}
		}
		else
			{$("#encabezadoPedidosInicial").hide()
					if ($("#choferTipoSession").val() != "")
					{
						consultaPedidosBD('',$("#choferTipoSession").val());
					}
					else
					{
						$("#divChofer").show();
					}}

		
		
		
//		consultaPedidosBD('');	
	}
	else
	{
		
		OcultarDiv('ventaActive');
		OcultarDiv('asigTrans');
		OcultarDiv('cor');
		OcultarDiv('encabezadoPedidosInicial');
		OcultarDiv('imp');
		MostrarDiv('renta');
		MostrarDiv('cre');
		  $(".monito").click();
	}
	
	
	
	
	
}
function redireccionar() 
{
	switch (parseInt($("#redireccionar"))) 
	{
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
	}
}
function nivelUsu() 
{
	var nivel = $("#nivelUsu").val();
	if(nivel == "1")
	{
		MostrarDiv('cmbEstatus');
		MostrarDiv('cmbCorte');
		MostrarDiv('cmbFacturas');
	}
}
function mostrarMonitor()
{
    $('#liAsignacion').removeClass('active');
    $('#liMonitor').addClass('active');
    $("#asignacion").hide()
    $("#monitor").show()
}
function mostrarAsignacion()
{
	$('#liMonitor').removeClass('active');
    $('#liAsignacion').addClass('active');
    $("#monitor").hide()
    $("#asignacion").show()
}
function actualizar()
{
	$("#divChofer").show();
}


function actualizarTrans()
{
//	$("#divTransporte").show();
	$('#txt_fechaIniPedidost').val(ObtenerFechaActual());
	$('#txt_fechaFinPedidost').val(ObtenerFechaActual());
}

function mostrarBlock()
{
	console.log("s")
//	document.getElementById('cargando').style.display = 'block';
	borrarFiltrado()
}

function mostrarBlockDetalleRC(){
	asignarDetalleRC()
}

function mostrarBlockRC(){
	console.log("s")
	borrarFiltradoRC()
}

function mostrarBlockTrans()
{
	console.log("s")
//	document.getElementById('cargando').style.display = 'block';
	borrarFiltradoTrans()
}
//OcultarDiv('agregarNuevoOde');asignar()
function asignar()
{
	console.log("asignar")
	$("#divCancelacion").show()
//	borrarFiltrado();
	$("#msjOde").text("");
	OcultarDiv('agregarNuevoOde')
	OcultarDiv('alertaWidth')
	
	$("#odeAgregada").text("")
	if(obtenerChecksSeleccionados() != '' &&  obtenerChecksSeleccionados() != undefined)
	{
		  
		MostrarDiv('alertaWidth')
	
	
	ajaxObtenerFacturaPedidos() 
	
	$("#msjCancelacion").text("Se asignaran los pedidos: "+obtenerChecksSeleccionados());
	$("#msjCancelacionOdes").text("Se asignaran las ODE:    "+obtenerChecksSeleccionadosOdes());
	document.getElementById('alertaWidth').style.setProperty('max-width', (parseInt(screen.width)-45)+"px", 'important');
	
	}
	else
	{
		MostrarDiv('agregarNuevoOde')
	}
	
}

function asignarRC(){
	//console.log("asignarRC")
	$("#divCancelacionRC").show()
//	borrarFiltrado();
	$("#msjFacturaRC").text("");
	OcultarDiv('agregarNuevoFacturaRC')
	OcultarDiv('alertaWidthRC')
	$("#cdoOrigPue").css('display','none')
	$("#cdoOrigLeo").css('display','none')
	$("#cdoOrigCDMX").css('display','none')
	$("#cdoSelCDX").val("0");
	$("#cdoSelLeo").val("0");
	$("#cdoSelPue").val("0");
	$("#cdoSelectPue").val("0");
	$("#cdoSelectLeo").val("0");
	$("#cdoSelectCDX").val("0");
	$("#facturaAgregada").text("") 
	
	if(obtenerChecksSeleccionadosRC() != '' &&  obtenerChecksSeleccionadosRC() != undefined)
	{
		  
		MostrarDiv('alertaWidthRC')
	
	
	ajaxObtenerFacturasRC() 
	
	$("#msjCancelacionRC").text("Se asignaran las facturas: "+obtenerChecksSeleccionadosRC());
	//$("#msjCancelacionOdes").text("Se asignaran las ODE:    "+obtenerChecksSeleccionadosOdes());
	document.getElementById('alertaWidthRC').style.setProperty('max-width', (parseInt(screen.width)-45)+"px", 'important');
	
	}
	else
	{
		MostrarDiv('agregarNuevoFacturaRC')
	}
		
}

function asignarDetalleRC(){
	//console.log("asignarDetalleRC")
	
	var articulosDetalle = $("#inputChoferMarcadoDetalleRC").val();
	//alert("articulosDetalle: "+articulosDetalle);
		if(articulosDetalle != '' && articulosDetalle != ',')
		{
			asignarPedidosDetalleRC();
		/*	//OcultarDiv('divMarcadoDetalleRC');
			$("#divMarcadoDetalleRC").css("visibility", "hidden");
			//$("#divDetalleRC").hide()
			//	borrarFiltrado();
				$("#msjFacturaRC").text("");
				//OcultarDiv('agregarNuevoFacturaRC')
				OcultarDiv('alertaWidthDetalleRC')
				
				$("#facturaAgregada").text("")
				if(obtenerChecksSeleccionadosDetalleRC() != '' &&  obtenerChecksSeleccionadosDetalleRC() != undefined)
				{
					  
					MostrarDiv('alertaWidthDetalleRC')
				
				
				ajaxObtenerArticulosDetalleRC() 
				
				//$("#msjCancelacionRC").text("Se asignaran las facturas: "+obtenerChecksSeleccionadosRC());
				//$("#msjCancelacionOdes").text("Se asignaran las ODE:    "+obtenerChecksSeleccionadosOdes());
				document.getElementById('alertaWidthDetalleRC').style.setProperty('max-width', (parseInt(screen.width)-45)+"px", 'important');
				
				}
				else
				{
					
				}*/
			
		}
		else
		{
			alert("Debe seleccionar un articulo de la Factura");
		}
			
}


function confirmarFac()
{
	if(obtenerChecksSeleccionadosCredito() != '')
	{
	$("#divCancelacionFacturas").show()
	$("#msjCancelacionFacturas").text("Se confirmaran las siguientes facturas: "+obtenerChecksSeleccionadosCredito());
//	$("#msjCancelacionOdes").text("Se asignaran las ODE:    "+obtenerChecksSeleccionadosOdes());
	document.getElementById('alertaWidthFac').style.setProperty('max-width', (parseInt(screen.width)-45)+"px", 'important');
	document.getElementById('colorCEFac').style.setProperty('max-width', (parseInt(screen.width)-20)+"px", 'important');
	}
	else
	{
		alert("Debe seleccionar al menos una factura")
	}
	
}

function asignarTrans()
{
	$("#msjOdeTrans").text("");
	$("#odeAgregadaTrans").text("");
	$("#labelRegionalesTrans").text("")
	$("#regionalesTrans").hide();
	OcultarDiv('agregarNuevoOdeTrans')
	OcultarDiv('alertaTransWidth')
	console.log("edidos; "+obtenerChecksSeleccionadosTrans())
	console.log("edidos R; "+obtenerChecksSeleccionadosOdesTrans())
	if(obtenerChecksSeleccionadosTrans() != '' &&  obtenerChecksSeleccionadosTrans() != undefined)
	{
		MostrarDiv('alertaTransWidth')
	$("#divCancelacionTrans").show()
	ajaxObtenerFacturaPedidosTrans() 
	$("#msjCancelacionTrans").text("Se asignaran los pedidos: "+obtenerChecksSeleccionadosTrans());
	$("#msjCancelacionOdesTrans").text("Se asignaran las ODE:    "+obtenerChecksSeleccionadosOdesTrans());
	document.getElementById('alertaTransWidth').style.setProperty('max-width', (parseInt(screen.width)-45)+"px", 'important');
	document.getElementById('colorCE').style.setProperty('max-width', (parseInt(screen.width)-20)+"px", 'important');
	
	var aux = validaRegional();
		if(aux > 0)
	    {
	    	$("#labelRegionalesTrans").text("CDO ENTREGA")
	    	$("#regionalesTrans").show();
	    }
	}
	else
	{
		$("#divCancelacionTrans").show()
		MostrarDiv('agregarNuevoOdeTrans')
	}
	
}


function validaRegional()
{
	var aux = 0
    var arrR = $('[name="checksTransR[]"]:checked').map(function(){
    	var valor = this.value.split("*")
    	aux++
	      return valor[0];
	    }).get();
	return aux;
}

function selectChoferes(valor) 
{
	$("#choferSelect").val(valor)
}
function selectVehiculos(valor) 
{
	$("#vehiculosSelect").val(valor)
}
function selectChoferesTrans(valor) 
{
	$("#choferSelectTrans").val(valor)
}
function selectChoferes1(valor) 
{
	$("#busquedaChofer").val(valor)
}


function radios()
{
	var elements = document.getElementsByName('tipoBusqueda');
	for (i=0;i<elements.length;i++) {
	  if(elements[i].value == "ruta") {
	    elements[i].checked = true;
	  }
	}
}

function fecha()
{
	
	$('#txt_fechaIni').val(ObtenerFechaActual());
	$('#txt_fechaFin').val(ObtenerFechaActual());
	$('#txt_fechaIniCorte').val(ObtenerFechaActual());
	$('#txt_fechaIniCredito').val(ObtenerFechaActual());
	$('#txt_fechaFinCredito').val(ObtenerFechaActual());
}
function generarExcel(tipo) 
{
		
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data :  'accion=GenerarExcel&tipo='+tipo,
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	document.getElementById('cargando').style.display = 'none';
	        	var data = respuesta;
	        	if( data == 's')
	        	{
	        		 $("#formExcel").submit();
	        	}
	        	else
	        	{	
	        		alert("No se genero")
	        	}
        	}
	        else
        	{
	        	alert("Error en llamado")
        	}
	    
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
				
			}
		}
	});
	
}
function ajaxObtenerFacturaPedidosTrans() 
{
		var data ='';
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data :  'accion=ObtenerFacturasPedidosTrans&pedidos='+obtenerChecksSeleccionadosOdesTrans()+"&ped="+obtenerChecksSeleccionadosTrans(),
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	 data = respuesta;
	        	
	        	 $("#msjPedidosFacturasTrans").text(data);
	        	
        	}
	        else
        	{
	        	alert("Error en llamado")
        	}
	    
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
				
			}
		}
	});
	

}

function ajaxObtenerArticulosDetalleRC()
{
	var data ='';
	$.ajax({
		url :'MonitorPedidosServlet', 
	    data :  'accion=ObtenerCantidadDetalleRC&articulosDetalle='+obtenerChecksSeleccionadosDetalleRC(),
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	 data = respuesta;
	        	 $("#msjPedidosFacturasDetalleRC").text(data);
	        	
        	}
	        else
        	{
	        	alert("Error en llamado")
        	}
	    
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
				
			}
		}
		
	});
}

function ajaxObtenerFacturasRC(){
	var data ='';
	$.ajax({
		url :'MonitorPedidosServlet', 
	    data :  'accion=ObtenerFacturasRC&facturasTras='+obtenerChecksSeleccionadosRC(),
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	 data = respuesta;
	        	 $("#msjPedidosFacturasRC").text(data);
	        	
        	}
	        else
        	{
	        	alert("Error en llamado")
        	}
	    
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
				
			}
		}
		
	});
}


function ajaxObtenerFacturaPedidos() 
{
		var data ='';
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data :  'accion=ObtenerFacturasPedidos&pedidos='+obtenerChecksSeleccionadosOdes()+"&ped="+obtenerChecksSeleccionados(),
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	 data = respuesta;
	        	 $("#msjPedidosFacturas").text(data);
	        	
        	}
	        else
        	{
	        	alert("Error en llamado")
        	}
	    
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
				
			}
		}
	});
	

}


function limpiar() 
{
	document.getElementById('ticketsEnvio').innerHTML = '';
	$("#variosTickets").hide();
	$("#variosTicketsCorte").hide();
	$("#limpiar").hide()
	$("#nolimpiar").show();
}

function imprimirTicket() 
{
	var folio = $("#folioImprimir").val();
	$("#variosTickets").hide();
	$("#variosTicketsCorte").hide();
	
	if(folio != '')
	{	
		document.getElementById('cargando').style.display = 'block';
		$.ajax({
		    url :'MonitorPedidosServlet', 
		    data :  'accion=imprimirticket&folio='+folio+'&uname_chofer='+$("#ticketsEnvio option:selected").val()+'&ticket='+sReimpresion(),
		    type : 'POST',
		    dataType : 'Json', 
		    success : function(respuesta)
		    { 
		
		        if(respuesta)
	        	{
		        	if (!respuesta.includes("VARIOS-")) 
		        	{
		        		document.getElementById('cargando').style.display = 'none';
		        		var data = respuesta	
		        		$("#variosTickets").show();
		        		$("#variosTicketsCorte").show();
		        		$("#folioSpan").text(folio);
		        		var $select = $('#ticketsEnvio');
		        		$.each(data, function(id, name) 
        				{
    	                $select.append('<option value=' + name.uname + '>' + name.descripcion + '</option>');
	        	         });
		        		$("#limpiar").show()
		        		$("#nolimpiar").hide();
					}
		        	else
		        	{	
			        	
			        	var split = respuesta.split("-");
			        	var data = split[1];
			        	document.getElementById('cargando').style.display = 'none';
		        		$("#folioImprimir").val("");
		        		 limpiar() 
			        	alert(data)
		        	}
	        	}
		        else
	        	{
		        	$("#folioImprimir").val("");
		        	alert("No se pudo imprimir, error interno")
	        	}
		    
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				if (xhr.status === 200)
				{
					alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
					window.location.href='/AsignacionRutasCDO/';
				}
			}
		});
	}
	else
	{
		alert("DEBE INGRESAR EL FOLIO DE ENVIO.")
	}
	
}


var mensaje;
//var opcion = confirm("Clicka en Aceptar o Cancelar");
//if (opcion == true) {
//    mensaje = "Has clickado OK";
//} else {
//    mensaje = "Has clickado Cancelar";
//}




function imprimirTicketCorte() 
{
	var folio = $("#folioImprimirCorte").val();
	if(folio != '')
	{	
		document.getElementById('cargando').style.display = 'block';
		$.ajax({
		    url :'MonitorPedidosServlet', 
		    data :  'accion=imprimirticketCorte&folio='+folio,
		    type : 'POST',
		    dataType : 'Json', 
		    success : function(respuesta)
		    { 
		
		        if(respuesta)
	        	{$("#folioImprimirCorte").val("");
		        	document.getElementById('cargando').style.display = 'none';
		        	var data = respuesta;
		        	alert(data)
	        	}
		        else
	        	{
		        	$("#folioImprimirCorte").val("");
		        	alert("No se pudo imprimir, error interno")
	        	}
		    
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				if (xhr.status === 200)
				{
					alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
					window.location.href='/AsignacionRutasCDO/';
				}
			}
		});
	}
	else
	{
		alert("DEBE INGRESAR EL FOLIO DE CORTE.")
	}
	
}








function consultarTrayecto(tipo)
{
	var tipoBusqueda = $('input:radio[name=tipoBusqueda]:checked').val();
	var rutaInicio = $("#rutaInicio").val();
	var factura = $("#busquedaFactura").val();
	var rutaFin = $("#rutaFin").val();
	var fechaInicio = $("#txt_fechaIni").val()
	var fechaFin = $("#txt_fechaFin").val()
	var choferInicio = $("#choferInicio").val()
	var choferFin = $("#choferFin").val()
	var cliente = $("#busquedaCliente").val()
	var clienteFin = $("#busquedaClienteFin").val()
	var pedido = $("#busquedaPedido").val()
		var check = $("#check").val();
	if(tipo == 'inicio')
		{
			rutaInicio = 'inicio';
			rutaFin = 'inicio';
			$('#txt_fechaIni').val(ObtenerFechaActual());
			$('#txt_fechaFin').val(ObtenerFechaActual());
		}
	if(validarVacio(rutaInicio,rutaFin,fechaInicio,fechaFin,choferInicio,choferFin,tipoBusqueda,cliente,clienteFin,pedido))
	{
		url = ''
	if(tipoBusqueda == 'cliente')
		{
		
		url = "accion=ConsultarTrayectoCliente&rutaInicio="+rutaInicio+"&rutaFin="+rutaFin+"&choferInicio="+choferInicio+"&choferFin="+choferFin+"&fechaInicio="+fechaInicio+"&cliente="+cliente+"&fechaFin="+fechaFin+"&clienteFin="+clienteFin+"&factura="+factura+"&pedido="+pedido+"&cdo="+check;
		}
	else
	{
		
		url = "accion=ConsultarTrayecto&rutaInicio="+rutaInicio+"&rutaFin="+rutaFin+"&choferInicio="+choferInicio+"&choferFin="+choferFin+"&fechaInicio="+fechaInicio+"&fechaFin="+fechaFin+"&factura="+factura+"&pedido="+pedido+"&cdo="+check;
	}
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : ''+url, 
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	document.getElementById('cargando').style.display = 'none';
//	        	$("#check").val("");
	        	var data = respuesta;
	        	if( data.length > 0)
	        	{
	        		$("#gridMonitor").hide()
	        		$("#gridMonitorCliente").hide()
	        		if (cliente != '')
	        		{
	        			llenaGridMonitorCliente(data)
			        	$("#gridMonitorCliente").show()
					}
	        		else
	        		{
	        			llenaGridMonitor(data)
			        	$("#gridMonitor").show()
	        		}
	        		
		        	
	        		 $("#rutaInicio").val("");
	        		 $("#rutaFin").val("");
					 $("#choferInicio").val("")
					 $("#choferFin").val("")
					 $("#busquedaFactura").val("");
//					 $("#busquedaCliente").val("")
//					 $("#busquedaClienteFin").val("")
					 $("#busquedaPedido").val("")
//					 $('#choferSel1').prop('selectedIndex',0);
	        	}
	        	else
	        	{	
	        			 alert("No existen registros con"+msjMonitor(rutaInicio,rutaFin,choferInicio,choferFin,fechaInicio,cliente,fechaFin,clienteFin,factura,pedido))
	        		 $("#rutaInicio").val("");
	        		 $("#rutaFin").val("");
					 $("#choferInicio").val("")
					 $("#choferFin").val("")
					 $("#busquedaFactura").val("");
//					 $("#busquedaClienteFin").val("")
//					 $("#busquedaCliente").val("")
					 $("#busquedaPedido").val("")
						 $("#gridMonitor").hide()
						 $("#mon").hide()
						 $("#monCliente").hide()
						 $("#gridMonitorCliente").hide()
//						 $('#choferSel1').prop('selectedIndex',0);
	        	}
        	}
	        else		        	
	    var n;
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
			}
		}
	});
	}
}


function consultarDetalle(folio,cartaPorte,chofer,fecha,tipo,item,uname,asignacion,finRuta)
{
	url = "accion=ConsultarDetalle&id_trayecto="+folio+"&uname="+uname;
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : ''+url, 
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
	        		
//	        			llenaGridDetalle(folio,chofer,fecha,data)
	        			mostrarDetalle(folio,cartaPorte,chofer,fecha,data,tipo,item,asignacion,finRuta)
	        	}
        	}
	        
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
			}
		}
	});
	
}







function msjMonitor(rutaInicio,rutaFin,choferInicio,choferFin,fechaInicio,cliente,fechaFin,clienteFin,factura,pedido) 
{
	var msj = ''
	
		
		
		
		
	if(rutaInicio != '' && rutaInicio != 'inicio')
		{
			msj = " Folio envio inicio: "+rutaInicio+" - Folio  fin: "+rutaFin+".";
		}
	if(fechaInicio != '')
		{
			msj = msj + " Fecha: "+fechaInicio+" a "+fechaFin+"."
	}
	else
		{
		msj = msj + " el dia de hoy. "
		}
	if(cliente != '')
	{
		msj = msj + " Cliente inicio: "+cliente+" - Cliente fin: "+clienteFin+".";
	}
	if(pedido != '')
	{
		msj = msj + " Pedido: "+pedido+".";
	}
	if(factura != '')
	{
		msj = msj + " Factura: "+factura+".";
	}
	if(choferInicio != '')
		{
		msj = msj + " Chofer inicio: "+choferInicio+" - Chofer fin: "+clienteFin+".";
		}
	return msj
	
}



function validarVacio(rutaInicio,rutaFin,fechaInicio,fechaFin,choferInicio,choferFin,tipoBusqueda,cliente,clienteFin,pedido) 
{
	var f = fechaInicio.split("/");
	var ff = fechaFin.split("/");
	var si = 0;
	if (f[0] > ff[0])
	{
		si = 1;
		if (f[1] > ff[1])
		{
			
			si = 1;
			if (f[2] < ff[2]) 
			{
				si = 0;
			}
		}
		else	if (f[1] < ff[1])
		{
			si = 0;
		}
	
	}

	if (si != 0) 
	{
		alert("La fecha de inicio debe ser menor a la fecha fin")
		return false;
	}
	
	
	if (rutaInicio == '' && rutaFin != '')
	{
		alert("Debe poner folio envio de inicio si pone folio envio de fin ")
		return false;
		
	}
	if (rutaFin == '' && rutaInicio != '')
	{
		alert("Debe poner folio envio de fin si pone folio envio de inicio ")
		return false;
	}
	if (rutaInicio != '' && rutaFin != '')
	{
		if (parseInt(rutaInicio) > parseInt(rutaFin))
		{
			alert("El folio envio de inicio debe ser menor al folio envio de fin.")
			return false;
		}
	}
	

	
	
	if (choferInicio == '' && choferFin != '')
	{
		alert("Debe poner chofer de inicio si pone chofer de fin ")
		return false;
	}
	if (choferFin == '' && choferInicio != '')
	{
		alert("Debe poner chofer de fin si pone chofer de inicio ")
		return false;
	}
	if (choferInicio != '' && choferFin != '')
	{
		if (parseInt(choferInicio) > parseInt(choferFin))
		{
			alert("La chofer de inicio debe ser menor a la chofer de fin.")
			return false;
		}
	}
	
	if (tipoBusqueda == 'cliente')
	{
		if (cliente == '' && clienteFin != '')
		{
			alert("Debe poner cliente de inicio si pone cliente de fin ")
			return false;
		}
		if (clienteFin == '' && cliente != '')
		{
			alert("Debe poner cliente de fin si pone cliente de inicio ")
			return false;
		}
		if (cliente != '' && clienteFin != '')
		{
			if (parseInt(cliente) > parseInt(clienteFin))
			{
				alert("La cliente de inicio debe ser menor a la cliente de fin.")
				return false;
			}
		}	
	}
	
		
		
		
		
		return true
}

function llenaGridMonitor(data)
{
	
	$("#monCliente").hide();
	$("#mon").show();
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	return $.grep(data, function (egreso) {
	            return 		(!filter.id_traycto|| egreso.id_traycto === filter.id_traycto || egreso.id_traycto == filter.id_traycto )
	                     &&  (!filter.estatus.toUpperCase()|| egreso.estatus.toUpperCase() === filter.estatus.toUpperCase() || egreso.estatus.toUpperCase() == filter.estatus.toUpperCase() || egreso.estatus.toUpperCase().includes(filter.estatus.toUpperCase()))
	                     &&  (!filter.importePedido.toUpperCase()|| egreso.importePedido.toUpperCase() === filter.importePedido.toUpperCase() || egreso.importePedido.toUpperCase() == filter.importePedido.toUpperCase() || egreso.importePedido.toUpperCase().includes(filter.importePedido.toUpperCase()))
	                     &&  (!filter.descripcion_cdo.toUpperCase()|| egreso.descripcion_cdo.toUpperCase() === filter.descripcion_cdo.toUpperCase() || egreso.descripcion_cdo.toUpperCase() == filter.descripcion_cdo.toUpperCase() || egreso.descripcion_cdo.toUpperCase().includes(filter.descripcion_cdo.toUpperCase()))
	                     &&  (!filter.descripcion_br.toUpperCase()|| egreso.descripcion_br.toUpperCase() === filter.descripcion_br.toUpperCase() || egreso.descripcion_br.toUpperCase() == filter.descripcion_br.toUpperCase() || egreso.descripcion_br.toUpperCase().includes(filter.descripcion_br.toUpperCase()))
	                     &&  (!filter.num_chofer.toUpperCase()|| egreso.num_chofer.toUpperCase() === filter.num_chofer.toUpperCase() || egreso.num_chofer.toUpperCase() == filter.num_chofer.toUpperCase() || egreso.num_chofer.toUpperCase().includes(filter.num_chofer.toUpperCase()))
	                     &&  (!filter.facturas_cod.toUpperCase()|| egreso.facturas_cod.toUpperCase() === filter.facturas_cod.toUpperCase() || egreso.facturas_cod.toUpperCase() == filter.facturas_cod.toUpperCase() || egreso.facturas_cod.toUpperCase().includes(filter.facturas_cod.toUpperCase()))
	                     &&  (!filter.tipo.toUpperCase()|| egreso.tipo.toUpperCase() === filter.tipo.toUpperCase() || egreso.tipo.toUpperCase() == filter.tipo.toUpperCase() || egreso.tipo.toUpperCase().includes(filter.tipo.toUpperCase()))
                         &&  (!filter.asignacionConcat.toUpperCase()|| egreso.asignacionConcat.toUpperCase() === filter.asignacionConcat.toUpperCase() || egreso.asignacionConcat.toUpperCase() == filter.asignacionConcat.toUpperCase() || egreso.asignacionConcat.toUpperCase().includes(filter.asignacionConcat.toUpperCase()))
                         && (!filter.horasEnc.toUpperCase()|| egreso.horasEnc.toUpperCase() === filter.horasEnc.toUpperCase() || egreso.horasEnc.toUpperCase() == filter.horasEnc.toUpperCase() || egreso.horasEnc.toUpperCase().includes(filter.horasEnc.toUpperCase()))
                         && (!filter.horasInicio.toUpperCase()|| egreso.horasInicio.toUpperCase() === filter.horasInicio.toUpperCase() || egreso.horasInicio.toUpperCase() == filter.horasInicio.toUpperCase() || egreso.horasInicio.toUpperCase().includes(filter.horasInicio.toUpperCase()))
                         && (!filter.horasEncPed.toUpperCase()|| egreso.horasEncPed.toUpperCase() === filter.horasEncPed.toUpperCase() || egreso.horasEncPed.toUpperCase() == filter.horasEncPed.toUpperCase() || egreso.horasEncPed.toUpperCase().includes(filter.horasEncPed.toUpperCase()))
                         &&  (!filter.inicioConcat.toUpperCase()|| egreso.inicioConcat.toUpperCase() === filter.inicioConcat.toUpperCase() || egreso.inicioConcat.toUpperCase() == filter.inicioConcat.toUpperCase() || egreso.inicioConcat.toUpperCase().includes(filter.inicioConcat.toUpperCase()))
                         &&  (!filter.finConcat.toUpperCase()|| egreso.finConcat.toUpperCase() === filter.finConcat.toUpperCase() || egreso.finConcat.toUpperCase() == filter.finConcat.toUpperCase() || egreso.finConcat.toUpperCase().includes(filter.finConcat.toUpperCase()))
                         &&  (!filter.ingresosCobro.toUpperCase()|| egreso.ingresosCobro.toUpperCase() === filter.ingresosCobro.toUpperCase() || egreso.ingresosCobro.toUpperCase() == filter.ingresosCobro.toUpperCase() || egreso.ingresosCobro.toUpperCase().includes(filter.ingresosCobro.toUpperCase()))
                          &&  (!filter.folio_carta_porte.toUpperCase()|| egreso.folio_carta_porte.toUpperCase() === filter.folio_carta_porte.toUpperCase() || egreso.folio_carta_porte.toUpperCase() == filter.folio_carta_porte.toUpperCase() || egreso.folio_carta_porte.toUpperCase().includes(filter.folio_carta_porte.toUpperCase())) 
	        });
	    },
	    insertItem: function (insertingClient) 
	    {
	    	
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {
	    
	    },
	 };
	window.db = db;
    db.data;
     $(function ()
    	     {
    	    	 $("#mon").jsGrid({
    	    		 width: "99%",
    	             height: "600px",
    	             editing: false,
    	             filtering: true,
    	             selecting: true,
    	             sorting: true ,
    	             paging: false,
    	             pageSize: 800,
    	             
    	             controller: 
    	             {
    	                 loadData: function () 
    	                 {
    	                     dataType: "json"
    	                     return data ;
    	                 }
    	             },
    	             controller: db,

    	             rowClass: function(item, itemIndex) 
    	             { 
    	            	if(item.repeticion == "s")
    	            		{
    	            			return "ocultar";
    	            		}
    	            	if (item.ingresosCobro == '*') 
    	            	{
    	            		return "bg-red";
						}
    	            	
    	             },
    	             onRefreshed: function (args) { 
    	            	 /** seccion de totales **/
    	            	 let items = args.grid.option("data");
    	            	 let totales= calculaImportesTotalesDelGridIngresos(items)
    	                 let $totalRow = $("<tr>").addClass("total-row");
    	                 args.grid._renderCells($totalRow, totales);
    	                 args.grid._content.append($totalRow);
    	             },
    	             
    	             autoload: true,
    	             fields: 
    	             [
    	            	 { name: "descripcion_br", type: "text", title: "CDO", width:40, align: 'center',filtering: true,itemTemplate: function (value, item) {return validarIngresosColor(value,item.ingresosCobro)}},
    	            	 { name: "descripcion_cdo", type: "text", title: "ASIGNO", width:40, align: 'center',filtering: true,itemTemplate: function (value, item) {return validarIngresosColor(value,item.ingresosCobro)}},
    	            	 { name: "id_traycto",  type: "text", title: "FOL", width: 45, align: 'center', filtering: true ,itemTemplate: function (value, item) {return validarIngresosColor(value,item.ingresosCobro)}},
    	            	 { name: "folio_carta_porte",  type: "text", title: "FOL CP", width: 40, align: 'center', filtering: true },
    	            	 { name: "tipo", type: "text", title: "TIPO", width:45, align: 'center', filtering: true,itemTemplate: function (value, item) { return validarTipoColor(value,item.color)}},
    	                 { name: "num_chofer", type: "text", title: "CHOFER", width:135, align: 'left', filtering: true,itemTemplate: function (value, item) { return validarIngresosColor(validarTipo(value,item),item.ingresosCobro)}},
    	                 { name: "facturas_cod", type: "text", title: "COD", width:35, align: 'center', filtering: true,itemTemplate: function (value, item) { return divCOD(value)}},
    	                 { name: "ingresosCobro", type: "text", title: "*", width:30, align: 'center', filtering: true,itemTemplate: function (value, item) { if (value == "n")
    	                 {
    	                	 return ""
						}
    	                 else
    	                	 {return value}}},
    	                	 { name: "importePedido",  type: "text", title: "IMP", width: 57, align: 'right', filtering: true ,itemTemplate: function (value, item) {return validarIngresosColor("$"+value,item.ingresosCobro)}},
    	                 { name: "asignacionConcat", type: "text", title: "FECHA ASIGNACION", width:80, align: 'center', filtering: true,itemTemplate: function (value, item) { return tooltip(value,item)}},
    	                 { name: "inicioConcat", type: "text", title: "FECHA INICIO-RUTA", width:80, align: 'center', filtering: true,itemTemplate: function (value, item) { return tooltipInicio(value,item)}},
    	                 { name: "finConcat", type: "text", title: "FECHA FIN-RUTA", width:80, align: 'center', filtering: true,itemTemplate: function (value, item) { return tooltipFin(value,item)}},
    	                 { name: "horasInicio", type: "text", title: "TMP INICIO", width:53, align: 'center', filtering: true,itemTemplate: function (value, item) { return toltipTmp(value,"Tiempo que tardo desde que se asigno la ruta hasta que inicio ruta chofer (fecha asignacion - fecha inicio ruta)")}},
    	                 { name: "horasEnc", type: "text", title: "TMP RUTA", width:53, align: 'center', filtering: true,itemTemplate: function (value, item) { return toltipTmp(value.replace("-",""),"Tiempo de inicio de ruta a fin de ruta (fecha inicio ruta - fecha fin ruta)")}},
    	                 { name: "horasEncPed", type: "text", title: "TMP ASIGN", width:53, align: 'center', filtering: true,itemTemplate: function (value, item) { return toltipTmp(value.replace("-",""),"Tiempo desde que se asigno la ruta hasta fin de ruta (fecha asignacion - fecha fin ruta)")}},
    	                 { name: "estatus",  type: "text", title: "ESTATUS", width: 61, align: 'center', filtering: true,itemTemplate: function (value, item) {
    	                	 if (item.repeticion == "n" || item.repeticion == "s")
    	                 {
    	                	 return colorEstatus(item.id_estatus,value)
						} }},
       	                 { name: "btnDetalle", type: "text", title: "", width: 15, align: 'center', filtering:false,
    	                	 itemTemplate: function (value, item) 
    	                	 {
    	                		 if (item.repeticion == "n" || item.repeticion == "s") 
    	                		 {
									
    	                		 return $("<button>").attr("class", "EG_btnUbicacion").on("click", function () {
    	                			 //alert("Folio carta porte: "+item.folio_carta_porte);
    	                             consultarDetalle(item.id_traycto,item.folio_carta_porte,item.num_chofer,item.inicioConcat,item.tipo,item,item.uname_br,item.asignacionConcat,item.finConcat);
    	                                 return false;
    	                             });
    	                		 }
    	                     }
    	                 },
       	                 { name: "btnDetalle", type: "text", title: "", width: 15, align: 'center', filtering:false,
    	                	 itemTemplate: function (value, item) 
    	                	 {
    	                		 if (item.repeticion == "n" || item.repeticion == "s") 
    	                		 {
									
								
    	                		 return $("<button>").attr("class", "EG_btnUbicacionPunteo").on("click", function () {
    	                			 $("#seguimientoRuta").text(item.id_traycto)
    	                			 $("#seguimientoChofer").text(item.num_chofer)
    	                			 mostrarUbicacion1(item,item.id_traycto,data)
    	                                 return false;
    	                             });
    	                		 }
    	                     }
    	                 },
    	                 { name: "btnDetalle", type: "text", title: "", width: 15, align: 'center', filtering:false,
    	                	 itemTemplate: function (value, item) 
    	                	 {
    	                		 if (item.id_estatus == 0)
    	                		 {
									
								
    	                		 return $("<button>").attr("class", "EG_btnCancela").on("click", function () {
    	                				if (confirm('Confirme para cancelar el trayecto: '+item.id_traycto)) 
	                		 			{
    	                					cancelarTrayecto(item)
	                		 			}
    	                                 return false;
    	                             });
    	                     }
    	                	
    	                	 }
    	                 }
  
    	             ],
	                 
	        	 });
	         });
}
function calculaImportesTotalesDelGridIngresos(items)
{
	 let total = {
			 descripcion_br: "", descripcion_cdo: "", id_traycto: "", tipo: "", num_chofer: "", facturas_cod: "", importePedido: "", asignacionConcat: "", inicioConcat: "", finConcat: "", horasInicio: "", 
			 horasEnc: "", horasEncPed: "", estatus: "8", btnDetalle: "8",  btnDetalle: "8", btnDetalle: "8",  IsTotal: true
     };
	  
	 items.forEach(function (item){
		 if(item.repeticion == "n")
			 {
			 total.importePedido = (Number(total.importePedido) + Number(parseFloat(item.importePedido.replace(',', '')).toFixed(2))).toFixed(2);  
			 }
        
     });
	  
	 total.importePedido = FormatearTotalesDeGrid(total.importePedido)
     return total;
}

function calculaImportesTotalesDelGridIngresos2(items)
{
	 let total = {
			 id_traycto: "", uname: "", ode: "", pedido: "", cliente: "", factura: "", importe: "",importe_cobrado:"", tipo_cobro: "", observaciones: "", ruta: "", direccion: "", fechaPedido: "", 
			 fecha_inicio_entrega: "", horasPed: "", horas: "", horasAsig: "",  finConcat: "", folio_corte: "",estatus:"",btnDetalle:false, IsTotal: true
     };
	  
	 var hora = "00:00:00"
	 items.forEach(function (item){
		 if (item.uname != "TOTALES") 
		 {
			 
			total.importe_cobrado = (Number(total.importe_cobrado) + Number(parseFloat(item.importe_cobrado.replace(',', '')).toFixed(2))).toFixed(2);
			total.importe = (Number(total.importe) + Number(parseFloat(item.importe.replace(',', '')).toFixed(2))).toFixed(2);
		 }
		 else
			 {
			 total.finConcat = item.finConcat;
			 }
		 	  
        
     });
	 if (total.importe_cobrado == '') 
	 {
		 total.importe_cobrado = "0";
	 }
	 if (total.importe == '') 
	 {
		 total.importe = "0";
	 }
	 total.importe_cobrado = FormatearTotalesDeGrid(total.importe_cobrado) 
	 total.importe = FormatearTotalesDeGrid(total.importe)
     return total;
}




function FormatearTotalesDeGrid(importe)
{
	let importeTotalGrid = parseFloat(importe).toFixed(2);
	importeTotalGrid = agregarCommas(importeTotalGrid);
	return importeTotalGrid;
}
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


function llenaGridMonitorCliente(data)
{

	$("#mon").hide();
	$("#monCliente").show();
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	return $.grep(data, function (egreso) {
	            return 		(!filter.cliente.toUpperCase()|| egreso.cliente.toUpperCase() === filter.cliente.toUpperCase() || egreso.cliente.toUpperCase() == filter.cliente.toUpperCase() || egreso.cliente.toUpperCase().includes(filter.cliente.toUpperCase()))
//	                     && 
	            &&  (!filter.importePedido.toUpperCase()|| egreso.importePedido.toUpperCase() === filter.importePedido.toUpperCase() || egreso.importePedido.toUpperCase() == filter.importePedido.toUpperCase() || egreso.importePedido.toUpperCase().includes(filter.importePedido.toUpperCase()))
				         && (!filter.ode.toUpperCase()|| egreso.ode.toUpperCase() === filter.ode.toUpperCase() || egreso.ode.toUpperCase() == filter.ode.toUpperCase() || egreso.ode.toUpperCase().includes(filter.ode.toUpperCase()))
				         &&(!filter.id_traycto|| egreso.id_traycto === filter.id_traycto || egreso.id_traycto == filter.id_traycto || egreso.id_traycto.includes(filter.id_traycto))
				         && (!filter.pedido.toUpperCase()|| egreso.pedido.toUpperCase() === filter.pedido.toUpperCase() || egreso.pedido.toUpperCase() == filter.pedido.toUpperCase() || egreso.pedido.toUpperCase().includes(filter.pedido.toUpperCase()))
				         && (!filter.horasEnc.toUpperCase()|| egreso.horasEnc.toUpperCase() === filter.horasEnc.toUpperCase() || egreso.horasEnc.toUpperCase() == filter.horasEnc.toUpperCase() || egreso.horasEnc.toUpperCase().includes(filter.horasEnc.toUpperCase()))
	                     &&  (!filter.descripcion_cdo.toUpperCase()|| egreso.descripcion_cdo.toUpperCase() === filter.descripcion_cdo.toUpperCase() || egreso.descripcion_cdo.toUpperCase() == filter.descripcion_cdo.toUpperCase() || egreso.descripcion_cdo.toUpperCase().includes(filter.descripcion_cdo.toUpperCase()))
	                     &&  (!filter.descripcion_br.toUpperCase()|| egreso.descripcion_br.toUpperCase() === filter.descripcion_br.toUpperCase() || egreso.descripcion_br.toUpperCase() == filter.descripcion_br.toUpperCase() || egreso.descripcion_br.toUpperCase().includes(filter.descripcion_br.toUpperCase()))
	                     &&  (!filter.tipo.toUpperCase()|| egreso.tipo.toUpperCase() === filter.tipo.toUpperCase() || egreso.tipo.toUpperCase() == filter.tipo.toUpperCase() || egreso.tipo.toUpperCase().includes(filter.tipo.toUpperCase()))
	                     &&  (!filter.num_chofer.toUpperCase()|| egreso.num_chofer.toUpperCase() === filter.num_chofer.toUpperCase() || egreso.num_chofer.toUpperCase() == filter.num_chofer.toUpperCase() || egreso.num_chofer.toUpperCase().includes(filter.num_chofer.toUpperCase()))
                         &&  (!filter.asignacionConcat.toUpperCase()|| egreso.asignacionConcat.toUpperCase() === filter.asignacionConcat.toUpperCase() || egreso.asignacionConcat.toUpperCase() == filter.asignacionConcat.toUpperCase() || egreso.asignacionConcat.toUpperCase().includes(filter.asignacionConcat.toUpperCase()))
                         &&  (!filter.inicioConcat.toUpperCase()|| egreso.inicioConcat.toUpperCase() === filter.inicioConcat.toUpperCase() || egreso.inicioConcat.toUpperCase() == filter.inicioConcat.toUpperCase() || egreso.inicioConcat.toUpperCase().includes(filter.inicioConcat.toUpperCase()))
                         &&  (!filter.finConcat.toUpperCase()|| egreso.finConcat.toUpperCase() === filter.finConcat.toUpperCase() || egreso.finConcat.toUpperCase() == filter.finConcat.toUpperCase() || egreso.finConcat.toUpperCase().includes(filter.finConcat.toUpperCase()))
                         &&  (!filter.fecha_inicio_entrega.toUpperCase()|| egreso.fecha_inicio_entrega.toUpperCase() === filter.fecha_inicio_entrega.toUpperCase() || egreso.fecha_inicio_entrega.toUpperCase() == filter.fecha_inicio_entrega.toUpperCase() || egreso.fecha_inicio_entrega.toUpperCase().includes(filter.fecha_inicio_entrega.toUpperCase()))
                         && (!filter.horasInicio.toUpperCase()|| egreso.horasInicio.toUpperCase() === filter.horasInicio.toUpperCase() || egreso.horasInicio.toUpperCase() == filter.horasInicio.toUpperCase() || egreso.horasInicio.toUpperCase().includes(filter.horasInicio.toUpperCase()))
                         &&  (!filter.fechaPedido.toUpperCase()|| egreso.fechaPedido.toUpperCase() === filter.fechaPedido.toUpperCase() || egreso.fechaPedido.toUpperCase() == filter.fechaPedido.toUpperCase() || egreso.fechaPedido.toUpperCase().includes(filter.fechaPedido.toUpperCase()))
                         && (!filter.horasEncPed.toUpperCase()|| egreso.horasEncPed.toUpperCase() === filter.horasEncPed.toUpperCase() || egreso.horasEncPed.toUpperCase() == filter.horasEncPed.toUpperCase() || egreso.horasEncPed.toUpperCase().includes(filter.horasEncPed.toUpperCase()))
                         && (!filter.horasEntrega.toUpperCase()|| egreso.horasEntrega.toUpperCase() === filter.horasEntrega.toUpperCase() || egreso.horasEntrega.toUpperCase() == filter.horasEntrega.toUpperCase() || egreso.horasEntrega.toUpperCase().includes(filter.horasEntrega.toUpperCase()))
		            	 && (!filter.folio_carta_porte.toUpperCase()|| egreso.folio_carta_porte.toUpperCase() === filter.folio_carta_porte.toUpperCase() || egreso.folio_carta_porte.toUpperCase() == filter.folio_carta_porte.toUpperCase() || egreso.folio_carta_porte.toUpperCase().includes(filter.folio_carta_porte.toUpperCase()))   
	        });
	    },
	    insertItem: function (insertingClient) 
	    {
	    	
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {
	    
	    },
	 };
	window.db = db;
    db.data;
    
	 $(function ()
    	     {
    	    	 $("#monCliente").jsGrid({
    	    		 width: "99%",
    	             height: "600px",
    	             editing: false,
    	             filtering: true,
    	             selecting: true,
    	             sorting: true ,
    	             paging: false,
    	             pageSize: 800,
    	             
    	             controller: 
    	             {
    	                 loadData: function () 
    	                 {
    	                     dataType: "json"
    	                     return data ;
    	                 }
    	             },
    	             controller: db,

    	             rowClass: function(item, itemIndex) 
    	             { 
    	            	 
    	             },
    	             onRefreshed: function (args) { 
    	            	 /** seccion de totales **/
    	            	 let items = args.grid.option("data");
    	            	 let totales= ccc(items)
    	                 let $totalRow = $("<tr>").addClass("total-row");
    	                 args.grid._renderCells($totalRow, totales);
    	                 args.grid._content.append($totalRow);
    	             },
    	             autoload: true,
    	             fields: 
    	             [
    	            	 { name: "descripcion_br", type: "text", title: "CDO", width:20, align: 'center',filtering: true},
    	            	 { name: "descripcion_cdo", type: "text", title: "ASIGNO", width:20, align: 'center',filtering: true},
    	            	 { name: "id_traycto", type: "text", title: "FOL", width:20, align: 'center', filtering: true},
    	            	 { name: "folio_carta_porte", type: "text", title: "FOL CP", width:20, align: 'center', filtering: true},
    	            	 { name: "tipo", type: "text", title: "TIPO", width:20, align: 'center', filtering: true,itemTemplate: function (value, item) { return tipoItemT(value,item)}},
    	            	 { name: "cliente", type: "text", title: "CLIENTE", width:75, align: 'left', filtering: true,itemTemplate: function (value, item) { return divCteChofer(value,item)}},
    	            	 { name: "num_chofer", type: "text", title: "CHOFER", width:75, align: 'left', filtering: true,itemTemplate: function (value, item) { return divCteChofer(value,item)}},
    	            	 { name: "ode", type: "text", title: "ODE", width:20, align: 'center', filtering: true},
    	            	 { name: "pedido", type: "text", title: "PEDIDO", width:20, align: 'center', filtering: true},
    	            	 { name: "importePedido",  type: "text", title: "IMPORTE", width: 35, align: 'right', filtering: true ,itemTemplate: function (value, item) {return validarIngresosColor("$"+value,item.ingresosCobro)}},
    	            	 { name: "fechaPedido", type: "text", title: "FECHA PEDIDO", width:50, align: 'center', filtering: true,itemTemplate: function (value, item) { return tooltip(value,item)}},
    	                 { name: "asignacionConcat", type: "text", title: "FECHA ASIGNACION", width:50, align: 'center', filtering: true,itemTemplate: function (value, item) { return tooltip(value,item)}},
    	                 { name: "inicioConcat", type: "text", title: "FECHA INICIO-RUTA", width:50, align: 'center', filtering: true,itemTemplate: function (value, item) { return tooltipInicio(value,item)}},
    	                 { name: "finConcat", type: "text", title: "FECHA FIN-RUTA", width:50, align: 'center', filtering: true,itemTemplate: function (value, item) { return tooltipFin(value,item)}},
    	                 { name: "fecha_inicio_entrega", type: "text", title: "FECHA ENTREGA", width:50, align: 'center', filtering: true,itemTemplate: function (value, item) { return tooltipFin(value,item)}},
    	                 { name: "horasPed", type: "text", title: "TMP PEDIDO", width: 40, align: 'center', filtering: false,itemTemplate: function (value, item) { return toltipTmp(validarIngresos(item.horasPed.toString().replace("-",""),item.ingresos,item.tipo_cobro),"Tiempo que tardo desde que mando pedido cliente hasta que entrego chofer (fecha pedido - fecha entrega)")}},
    	                 { name: "horasEnc", type: "text", title: "TMP RUTA", width:25, align: 'center', filtering: true,itemTemplate: function (value, item) { return toltipTmp(value.replace("-",""),"Tiempo desde que inicio ruta hasta que termino ruta (fecha inicio ruta - fecha fin ruta)")}},
    	                 { name: "horasEntrega", type: "text", title: "TMP ENTREGA", width:40, align: 'center', filtering: true,itemTemplate: function (value, item) { return toltipTmp(value,"Tiempo desde que se asigno ruta hasta que termino ruta (fecha inicio ruta - fecha entrega )")}},
    	                 { name: "horasEncPed", type: "text", title: "TMP ASIG", width:25, align: 'center', filtering: true,itemTemplate: function (value, item) { return toltipTmp(value.replace("-",""),"Tiempo desde que se asigno ruta hasta que termino ruta (fecha asignacion - fecha fin ruta)")}},
    	                 { name: "horasInicio", type: "text", title: "TMP INI", width:25, align: 'center', filtering: true,itemTemplate: function (value, item) { return toltipTmp(value.replace("-",""),"Tiempo desde que se asigno ruta hasta que inicio ruta (fecha asignacion - fecha inicio ruta)")}}
    	                 
  
    	             ],
	                 
	        	 });
	         });
}


//
function ccc(items)
{
	 let total = {
			 descripcion_br: "", descripcion_cdo: "", id_traycto: "", tipo: "8",
			 cliente : "", num_chofer: "",ode : "",
			 pedido : "", importePedido: "" ,fechaPedido : "",
			 asignacionConcat : "",inicioConcat : "", 
			 finConcat : "",fecha_inicio_entrega : "",
			 horasPed :"", horasInicio : "", horasEnc : "", 
			 horasEncPed : "",IsTotal: true
     };
//	  
	 items.forEach(function (item){
	 total.importePedido = (Number(total.importePedido) + Number(parseFloat(item.importePedido.replace(',', '')).toFixed(2))).toFixed(2);  
        	
        
     });
	  
	 total.importePedido = FormatearTotalesDeGrid(total.importePedido)
     return total;
}
	function changeFunc($i) 
	{
		formularioProv($i)
	}
	function formularioProv(value)
	{
		$("#check").val(value);
			
	}

	function changeFuncCorte($i) 
	{
		formularioProvCorte($i)
	}
	function formularioProvCorte(value)
	{
		$("#cdoCorte").val(value);
			
	}
	function changeFuncFacturas($i) 
	{
		formularioProvFacturas($i)
	}
	function formularioProvFacturas(value)
	{
		$("#cdoFacturas").val(value);
			
	}

	function changeFuncFacturasTrans($i) 
	{
		formularioProvFacturasTrans($i)
	}
	function changeCh($i) 
	{
		consultaPedidosBD($i)
	}
	function changeTp($i) 
	{
		consultaPedidosBDTrans($i)
	}
	
	
	function formularioProvFacturasTrans(value)
	{
		$("#cdoFacturasTrans").val(value);
			
	}

function tooltip(value, item)
{
    	 return $("<div>").prop("title", ""+item.usuario_asignacion+"").text(value);
    	 
}
function toltipTmp(value, leyenda)
{
    	 return $("<div>").prop("title", ""+leyenda+"").text(value);
    	 
}

function toltipTmp2(value, leyenda)
{
	
	console.log("value: "+value)
    	 return $("<div>").prop("title", ""+leyenda+"").text(value);
    	 
}

function tipoItem(value, item)
{
	if (value == "8")
	{
		return $("<div>").text("");
	}
	else
		{
			if(value == "TRANSP" )
			{
				return $("<div>").prop("title", "TRANSPORTE").text("TRANSP");
			}
			else if(value == "CHOFER")
			{
				return $("<div>").prop("title", "CHOFER").text("CHOFER");
			}
			else if(value == "RCs")
			{
				return $("<div>").prop("title", "RCS").text("RCS");
			}else{
				return $("<div>").prop("title", "ALMACEN").text("ALMACEN");
			}
		}
    	 
}

function tipoItemT(value, item)
{
	
	
	
	
	
	if(value == "T" )
		{
		return $("<div>").prop("title", "TRANSPORTE").text("TRANSP");
		}
	else if(value == "C")
		{
		return $("<div>").prop("title", "CHOFER").text("CHOFER");
		}
	else
		{
		return $("<div>").text("");
		}
    	 
    	 
}




function validarTipo(value, item)
{
	
	if(item.tipo == 'TRANSP')
		{
		var valor = item.numeroChofer+"-"+item.transporteNombre;
    	 return $("<div>").attr("style", "width: 100%;").prop("title", valor).append(value.toString().substring(0,34));
		}
	else
		{
		return $("<div>").attr("style", "width: 100%;").prop("title", value).append(value.toString().substring(0,34));
		}
    	 
}


function tooltipInicio(value, item)
{
    	 return $("<div>").text(value);
    	 
}
function tooltipCredito(value,item,usu)
{
	 return $("<div>").prop("title", usu).text(value);
}
function tooltipFin(value, item)
{
	return $("<div>").text(value);
    	 
}
function mostrarDetalle(ruta,cartaPorte,chofer,fecha,dt,tipo,datos,asignacion,finRuta)
{
	var aux = 0
	var total = 0
	var totalCobrado = 0	
	var auxFecha = 0
	var ant = '00:00:00'
	  var dsp = '00:00:00'
	  var h1	= '00:00:00'
	  var h2 = '00:00:00'
	  var sumaHoras = ''
	  	var sumaFinal = '00:00:00'
	  		
	  	var finConcat = ''	

	var dd = ""
		var aux = 0
	jQuery.each(dt, function(index, item) 
	   {	if (ruta == item.id_traycto) 
	   	{
		
		aux++
		
		total += parseFloat(item.importe.replace(",",''));
		 totalCobrado += parseFloat(item.importe_cobrado.replace(",",''));
		 
		
		 if (auxFecha == 0)
       	 {
       		var split = item.fecha_inicio_entrega.split("-");
       		ant = split [0];
       		h1 = obtenerHorasDif(ant,dsp);
       		retorno =  '00:00:00';
       		
       	 }
       	 else
   		 {
       		var split = item.fecha_inicio_entrega.split("-");
       		dsp = split [0];
       		h2 = obtenerHorasDif(ant,dsp);
       		retorno =  obtenerHorasDif(ant,dsp);
       		ant = split [0];
       		h1 = obtenerHorasDif(ant,dsp);
       		sumaHoras = sumarHoras(h1,h2) ;
       		sumaFinal = sumarHoras(sumaHoras,sumaFinal)
   		 }
		 auxFecha++;
		 finConcat =finConcat + retorno +"*"+auxFecha+",";
		 item.finConcat = retorno;
		 dd +=   JSON.stringify(item)+",";
		 
		 
		}
	   });
	
	
	
	var totales = ",{\"uname\":\"TOTALES\",\"cliente_nombre\":\"\",\"dias\":\"\",\"horas\":\"\",\"diasPed\":\"\",\"horasPed\":\"\",\"diasEnc\":\"\",\"horasEnc\":\"\",\"diasEncPed\":\"\",\"horasEncPed\":\"\",\"fechaPedido\":\"\",\"descripcion_cdo\":\"TOTALES\",\"repeticion\":\"\",\"uname_br\":\"\",\"id_traycto\":\"\",\"num_chofer\":\"\",\"fecha_asignacion\":\"\",\"hora_asignacion\":\"\",\"usuario_asignacion\":\"\",\"fecha_inicio_trayecto\":\"\",\"fecha_inicio_entrega\":\"\",\"fecha_fin_trayecto\":\"\",\"hora_inicio_trayecto\":\"\",\"hora_fin_trayecto\":\"\",\"cliente\":\"\",\"ode\":\"\",\"pedido\":\"\",\"factura\":\"\",\"facturas\":\"\",\"importe\":\""+importeCobrado1(total.toFixed(2))+"\",\"estatus\":\"\",\"id_estatus\":\"\",\"latitud_inicio_entrega\":\"\",\"longitud_inicio_entrega\":\"\",\"latitud_fin_entrega\":\"\",\"longitud_fin_entrega\":\"\",\"importe_cobrado\":\""+importeCobrado1(totalCobrado.toFixed(2))+"\",\"observaciones\":\"\",\"tipo_cobro\":\"\",\"asignacionConcat\":\"\",\"finConcat\":\""+sumaFinal+"\",\"folio_corte\":\"\",\"inicioConcat\":\"\",\"ruta\":\"\",\"direccion\":\"\",\"tipo\":\"\",\"transporteNombre\":\"\",\"numeroChofer\":\"\",\"ingresos\":\"\"}";
	
	dd = "["+dd.substring(0,dd.length-1)+totales+"]";
	dt = JSON.parse(dd);
	llenaGridDetalle(ruta,cartaPorte,chofer,fecha,dt,aux,tipo,datos,finConcat,asignacion,finRuta);
	

}


function sumarHoras(h1,h2) 
{
	if(h1 == ''){h1='00:00:00'}
	if(h2 == ''){h2='00:00:00'}
	var split1 = h1.split(":");
	var split2 = h2.split(":");
	
	var auxSeg = 0
	var auxMin = 0
	var auxHor = 0
	
	if((parseInt(split1[2])+parseInt(split2[2]))>60)
	{
		auxSeg = (parseInt(split1[2])+parseInt(split2[2])) - 60;
		auxSeg = dgt(auxSeg);
		auxMin = 1;
	}
	else
	{
		auxSeg = dgt(parseInt(split1[2])+parseInt(split2[2]))
	}
	if(((parseInt(split1[1])+auxMin)+(parseInt(split2[1])+auxMin))>60)
	{
		auxMin = ((parseInt(split1[1])+auxMin)+(parseInt(split2[1])+auxMin)) - 60;
		auxMin = dgt(auxMin);
		auxHor = 1;
	}
	else
	{
		auxMin = dgt(parseInt(split1[1])+parseInt(split2[1]))
	}
	if(((parseInt(split1[0])+auxHor)+(parseInt(split2[0])+auxHor))>60)
	{
		auxHor = ((parseInt(split1[0])+auxHor)+(parseInt(split2[0])+auxHor)) - 60;
		auxHor = dgt(auxHor);
	}
	else
	{
		auxHor = dgt(parseInt(split1[0])+parseInt(split2[0]))
	}
	return auxHor+":"+auxMin+":"+auxSeg
}

function formatoFecha(fecha)
{
	if(fecha != '')
	{
	var split = fecha.split("-");
	return split[1]+"-"+split[2]+"-"+split[3]+"-"+split[0];
	}
	return ''
}

function difHoras(ant,dsp) 
{
	if(ant == ''){ant='00:00:00'}
	if(dsp == ''){dsp='00:00:00'}
	var hora1 = (""+dsp+"").split(":"),
    hora2 = (""+ant+"").split(":"),
    t1 = new Date(),
    t2 = new Date();
 
t1.setHours(hora1[0], hora1[1], hora1[2]);
t2.setHours(hora2[0], hora2[1], hora2[2]);
 
//Aquí hago la resta
t1.setHours(t1.getHours() - t2.getHours(), t1.getMinutes() - t2.getMinutes(), t1.getSeconds() - t2.getSeconds());

//Imprimo el resultado
return "Diferencia es de: " + (t1.getHours() ? t1.getHours() + (t1.getHours() > 1 ? " horas" : " hora") : "") + (t1.getMinutes() ? ", " + t1.getMinutes() + (t1.getMinutes() > 1 ? " minutos" : " minuto") : "") + (t1.getSeconds() ? (t1.getHours() || t1.getMinutes() ? " y " : "") + t1.getSeconds() + (t1.getSeconds() > 1 ? " segundos" : " segundo") : "");
 
}
function obtenerHorasDif(ant,dsp)
{
	if(ant == ''){ant='00:00:00'}
	if(dsp == ''){dsp='00:00:00'}
	var hora1 = (""+dsp+"").split(":"),
    hora2 = (""+ant+"").split(":"),
    t1 = new Date(),
    t2 = new Date();
 
t1.setHours(hora1[0], hora1[1], hora1[2]);
t2.setHours(hora2[0], hora2[1], hora2[2]);
 
//Aquí hago la resta
t1.setHours(t1.getHours() - t2.getHours(), t1.getMinutes() - t2.getMinutes(), t1.getSeconds() - t2.getSeconds());

//Imprimo el resultado
return dgt(t1.getHours())+":"+dgt(t1.getMinutes())+":"+dgt(t1.getSeconds());
}

function dgt(valor)
{
	if (valor.toString().length == 2) 
	{
		return valor;
	}
	else
	{
		return "0"+valor;
	}
}


function divCOD(valor) 
{
	if (valor == 'COD')
	{
		return '<div style="width:100%" align="center"><div style="width: 70%;background: #FF7F50;color: white;">'+valor+'</div></div>'
	}
	else
	{
		return ''
	}
}
function importeCobrado(cobrado)
{
	if (cobrado != 0)
	{
		return '<div style="width:100%" align="right"><div style="width: 70%;background: #FF7F50;color: white;">$'+cobrado+'</div></div>'
	}
	else
	{
		return '$'+cobrado
	}
}    
function importeCobrado1(cobrado)
{
//		return '<div style="width:100%" align="right"><div style="width: 100%;background: #A9A9A9;color: black;">$'+agregarCommas(cobrado)+'</div></div>'
	return agregarCommas(cobrado)

}   

function abrirArchivo() 
{

//        document.location = "C:\workSpaceAndres\Almacen\MonitorZonas\FicherosExcel\ReporteCliente_66176.xls";
     
    return false;
}

function ubicacionEntrega(item,data,ruta,trayecto,ode,pedido,cliente,factura,latitud_inicio,longitud_inicio,latitud_fin,longitud_fin,chofer,fecha_inicio_entrega) 
{	
	
	
	var longitud = 0
	var latitud = 0
	if(latitud_inicio != 0 && longitud_inicio != 0)
	{
		latitud = parseFloat(latitud_inicio)
		longitud = parseFloat(longitud_inicio)
	}
	else
	{
		latitud = 19.366217
		longitud = -99.053331
	}
	
	var myLatLng = new google.maps.LatLng(latitud,longitud);
	var divMapa = document.getElementById('dvUbicFactura');
	var mapOptions = {
	        zoom: 16,
	        center: myLatLng
	    };	
	var mapa = new google.maps.Map(divMapa, mapOptions);
	var array1 = []
	var aux = 0

	if(latitud_inicio != 0 && longitud_inicio != 0)
	{
	aux = 1;
	array1.push({
		"lat" :  parseFloat(latitud_inicio),
		"lng" : parseFloat(longitud_inicio)
	});
	}
	 if(latitud_fin != 0 && longitud_fin != 0)
	 {	
		 aux = 2
		 array1.push({
	 		"lat" :  parseFloat(latitud_fin),
	 		"lng" : parseFloat(longitud_fin)
	 	 });
   	 }

	 var linea = new google.maps.Polyline({
		 path: array1,
		 map: mapa,
		 strokeColor: 'rgb(255, 0, 0)',
		 strokeWeight: 2,
		 
		 
	 });
	 var Loc_CDO = new google.maps.LatLng(latitud_inicio,longitud_inicio);
	 var marker = new google.maps.Marker({
		 position: Loc_CDO,
         draggable: false,
         map: mapa,
         center: Loc_CDO,
         title: 'INICIO PEDIDO.'+' '+fecha_inicio_entrega
     });
	 var Loc_CDO = new google.maps.LatLng(latitud_fin,longitud_fin);
	 
	 var marker = new google.maps.Marker({
		 position: Loc_CDO,
         draggable: false,
         map: mapa,
         center: Loc_CDO,
         title: 'FIN PEDIDO.'+' '+fecha_inicio_entrega
     });
	  if(aux == 0)
		  {
		  	alert("No se ha resgitrado el inicio de entrega de este pedido")
		  }
	  else
		  {
			  		$("#pedidoFac").text(pedido)
			  		$("#facturaFac").text(factura)
			  		$("#rutaFac").text(ruta)
			  		$("#clienteFac").text(cliente)
			  		$("#choferFac").text(chofer)
			  
		  if(aux == 1)
			  {
			  	alert("No ha registrado el fin de entrega de este pedido")
			  }
			  $("#divUbicacionClicFactura").show();
		  }
}


function mostrarUbicacion1(Item,ruta,data)
{
	
	  
		inicio =Item.latitud_cdo
			fin = Item.longitud_cdo
var myLatLng = new google.maps.LatLng(Item.latitud_cdo,Item.longitud_cdo);
var divMapa = document.getElementById('dvUbic');
   var mapOptions = {
	        zoom: 15,
	        center: myLatLng
	    };	
   var mapa = new google.maps.Map(divMapa, mapOptions);
var array1 = []
var aux = 0
var ode = 0
var inicio 
var fin 
var pedido = 0

var ant = 0
var dsp = 0
var ant2 = 0
var dsp2 = 0

var latitud = ""
var longitud = ""
var titulo = ""
	var auxill = 0
	var finTrayecto = 0
   jQuery.each(data, function(index, item) 
	{
	   
	     if(ruta ==item.id_traycto)
	  	   {
	    	
	    	 	if(ode != item.ode && pedido != item.pedido)
	    	 	{
	    	 		
	    	 			if(aux == 0 )
				    		 {

				    	 array1.push({
					    		"lat" :  parseFloat(inicio),
					    		"lng" : parseFloat(fin)
					    	});
	    	 		    	var Loc_CDO = new google.maps.LatLng(inicio,fin);
				       		var marker = new google.maps.Marker({
				      			 position: Loc_CDO,
				      	         draggable: false,
				      	         map: mapa,
//				      	         center: Loc_CDO,
//				      	         icon : 'http://desweb:8080/AsignacionRutasCDO/images/logo.png',
				      	     });
				       		aux++
				    		 }
	    	 		
				    	 if(item.latitud_inicio_entrega != 0 && item.longitud_inicio_entrega != 0)
				    	 {
				    		 
				    		 var p = ''
				    	     var o = ''
				    	    	 var auxill2 = 0
				    		 jQuery.each(data, function(index, item2) 
				    					{
				    			 if(ruta ==item2.id_traycto)
				    				 {
					    			 if (ant2 == 0) 
						    		 {
						    			 ant2 = item.hora_inicio_trayecto
						    		 }
					    			 var split2 = item2.fecha_inicio_entrega.split("-");
					    			 dsp2 = split2[0]
					    			 			if ( item.latitud_inicio_entrega == item2.latitud_inicio_entrega  && item.longitud_inicio_entrega == item2.longitud_inicio_entrega ) 
					    			 			{
					    			 				if (item2.pedido != p && item2.ode != o) 
					    			 				{
					    			 					if (auxill2 == 0) 
					    			 					{
					    			 						titulo += 'PEDIDO: '+item2.pedido+' FACTURA: '+item2.facturas+' CLIENTE: '+item2.cliente+' '+item2.fecha_inicio_entrega+". "+difHoras(ant2,dsp2)+ ". \n"
					    			 						item2.bnd = "s"
														}
					    			 					else
				    			 						{
					    			 						titulo += 'PEDIDO: '+item2.pedido+' FACTURA: '+item2.facturas+' CLIENTE: '+item2.cliente+' '+item2.fecha_inicio_entrega+". "+difHoras(ant2,dsp2)+ ". \n"
					    			 						item2.bnd = "f";
				    			 						}
					    			 					
					    			 					auxill2++;
													}
					    			 				p = item2.pedido;
						    			 			o = item2.ode;
												}
					    			 ant2 = split2[0]
				    				 }
				    					});
				    		 auxill2 = 0
							
				    		 
				    		 o = ""
				    		 p = ""
				    		 auxill++
				    		 
				    		 
				    		 
				    		 
				    		 var split = item.fecha_inicio_entrega.split("-");
				    			 dsp = split[0]
				    		 
					    	array1.push({
					    		"lat" :  parseFloat(item.latitud_inicio_entrega),
					    		"lng" : parseFloat(item.longitud_inicio_entrega)
					    	});
				
				    		 var Loc_CDO = new google.maps.LatLng(item.latitud_inicio_entrega,item.longitud_inicio_entrega);
				    		 if (ant == 0) 
				    		 {
				    			 ant = item.hora_inicio_trayecto
				    		 }
				    		if (item.bnd == "t") 
				    		{
				    			 var marker = new google.maps.Marker({
				        			 position: Loc_CDO,
				        	         draggable: false,
				        	         map: mapa,
				        	         center: Loc_CDO,
				        	         label : {
				        	             text: ''+aux+'',
				        	             color: "white"
				        	           },
				        	         title: 'PEDIDO: '+item.pedido+' FACTURA: '+item.facturas+' CLIENTE: '+item.cliente+' '+item.fecha_inicio_entrega+". "+difHoras(ant,dsp)
				        	     });
				    			 aux++
				        
							}
				    		else if (item.bnd == "s") 
				    		{
				    			 var marker = new google.maps.Marker({
				        			 position: Loc_CDO,
				        	         draggable: false,
				        	         map: mapa,
				        	         center: Loc_CDO,
				        	         label : {
				        	             text: ''+aux+'',
				        	             color: "white"
				        	           },
				        	         title: ''+titulo+''
				        	     });
				    			 aux++
							}
				    		
				        		
				        		 ant = split[0]
				    	 
				    	 }
				    	 titulo = "";
				    	 	ode = item.ode
				    	 	pedido = pedido	
	    	 	}
	    	 	finTrayecto = item.hora_fin_trayecto
	  	   }
    
    });
var Loc_CDO = new google.maps.LatLng(inicio,fin);
var marker = new google.maps.Marker({
	 position: Loc_CDO,
    draggable: false,
    map: mapa,
    center: Loc_CDO,
    label : {
        text: 'CDO',
        color: "black"
      },
    title: "Llegada CDO. "+difHoras(ant,finTrayecto)
});


//array1.forEach( function(valor, indice, array) {
//});
		if (Item.finConcat != '')
		{
		 	 array1.push({
		    		"lat" :  parseFloat(inicio),
		    		"lng" : parseFloat(fin)
		    	});
		    
		}
		array1.forEach( function(valor, indice, array) {
		});
	  var linea = new google.maps.Polyline({
	        path: array1,
	        map: mapa,
	        strokeColor: 'rgb(255, 0, 0)',
	        strokeWeight: 2
	      });
	  if(aux == 0)
		  {
		  	alert("No se ha resgitrado el inicio de ruta")
		  }
	  else
		  {
		  $("#divUbicacionClic").show();
		  }
   
	   }



function openWin() {
    var divText = document.getElementById("divUbicacionClic").outerHTML;
    var myWindow = window.open('', '', 'width=200,height=100');
    var doc = myWindow.document;
    doc.open();
    doc.write(divText);
    doc.close();
}

function agregarRegistroOde() 
{
	
//	 var mensaje;
//	    var opcion = confirm("Clicka en Aceptar o Cancelar");
//	    if (opcion == true) {
//	        mensaje = "Has clickado OK";
//		} else {
//		    mensaje = "Has clickado Cancelar";
//		}
	var ode = $("#odeAgregada").val();
	if(ode != "")
	{
		document.getElementById('cargando').style.display = 'block';
		$("#divMsjError").hide();
		$("#divMsjExito").hide();
		$.ajax({
		    url :'MonitorPedidosServlet', 
		    data : "accion=ConsultarOde&ode="+ode, 
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

		        		$("#msjOde").html("<pre>" + data + "</pre>");			        			
		        	} 
		        	else
		        	{	
		        		$("#odeAgregada").val("");
		        		alert("Hubo problema al recibir respuesta de la ODE.");
		        	}
	        	}
		        else
		        {
		        	document.getElementById('cargando').style.display = 'none';
		        	alert("No hubo respuesta")
		        	
		        }
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				if (xhr.status === 200)
				{
					alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
					window.location.href='/AsignacionRutasCDO/';
				}
			}
		});
	}
	else
	{
		alert("Debe ingresar una ODE")
	}
}

function agregarRegistroFactura() 
{
	
//	 var mensaje;
//	    var opcion = confirm("Clicka en Aceptar o Cancelar");
//	    if (opcion == true) {
//	        mensaje = "Has clickado OK";
//		} else {
//		    mensaje = "Has clickado Cancelar";
//		}
	var factura = $("#facturaAgregada").val();
	if(factura != "")
	{
		document.getElementById('cargando').style.display = 'block';
		$("#divMsjErrorRC").hide();
		$("#divMsjExitoRC").hide();
		$.ajax({
		    url :'MonitorPedidosServlet', 
		    data : "accion=ConsultarFactura&factura="+factura, 
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

		        		$("#msjFacturaRC").html("<pre>" + data + "</pre>");			        			
		        	} 
		        	else
		        	{	
		        		$("#facturaAgregada").val("");
		        		alert("Hubo problema al recibir respuesta de la FACTURA.");
		        	}
	        	}
		        else
		        {
		        	document.getElementById('cargando').style.display = 'none';
		        	alert("No hubo respuesta")
		        	
		        }
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				if (xhr.status === 200)
				{
					alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
					window.location.href='/AsignacionRutasCDO/';
				}
			}
		});
	}
	else
	{
		alert("Debe ingresar una FACTURA")
	}
}

function detalleRC(item)
{
	document.getElementById('cargando').style.display = 'block';
	$("#divMsjError").hide();
	$("#divMsjExito").hide();
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : "accion=consultarDetalleRC&factura="+item.facturaTraslado, 
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	document.getElementById('cargando').style.display = 'none';	
	        	var data = respuesta;
	    		//alert(data.length);
	    		if( data.length > 0){
	    			LLenarGridDetalleRC(data);
	    			//$("#divMarcadoDetalleRC").show();
	    			$("#ordenMarcadoRC").show();
	        		//$("#subtablaPrincipalMarcadoRC").show();
	    			$("#divMarcadoDetalleRC").css("visibility", "visible");
	        		$("#gridMarcadoDetalleRC").show();
	        		var datos = "Factura: "+item.facturaTraslado +" - Remision: "+item.remision+ " - Cte: "+item.cteDestino+"  "+"   MARCADO ARTICULOS";
	        		$("#informacionDetalle").html(datos);
	    		}else{
	    			alert("No existen articulos de ese traslado.");
	    			$("#ordenMarcadoRC").hide();
	    			$("#subtablaPrincipalMarcadoRC").hide();
	    		}
        	}
	        else
	        {
	        	document.getElementById('cargando').style.display = 'none';
	        	alert("No hubo respuesta, error al cargar detalle")
	        	
	        }
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
			}
		}
	});
}

function cancelar(item) 
{

	document.getElementById('cargando').style.display = 'block';
	$("#divMsjError").hide();
	$("#divMsjExito").hide();
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : "accion=CancelarPedido&ode="+item.ode+"&uname_br="+item.uname, 
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	document.getElementById('cargando').style.display = 'none';	

	        	var data = respuesta;
	        	alert(data)
	        	location.reload();
        	}
	        else
	        {
	        	document.getElementById('cargando').style.display = 'none';
	        	alert("No hubo respuesta, error al cancelar")
	        	
	        }
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
			}
		}
	});
}



function cancelarTrayecto(item) 
{

	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : "accion=CancelarTrayecto&trayecto="+item.id_traycto+"&uname_br="+item.uname_br+"&tipo="+item.tipo, 
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	document.getElementById('cargando').style.display = 'none';

	        	var data = respuesta;
	        	alert(data)
	        	location.reload();
	        
        	}
	        else
	        {
	        	document.getElementById('cargando').style.display = 'none';
	        	alert("No hubo respuesta, error al cancelar")
	        	
	        }
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
			}
		}
	});
}

function marcarFacturaT() 
{
	var escaneado = $("#escaneadoFacturaPedidoT").val();
	if (escaneado != '')
	{
		
		var valor = $("#"+escaneado+"").val();
		if (valor != undefined) 
		{
			if ($('input:radio[name=cteregt]:checked').val() == 'c') 
			{
				var split = valor.split("*");
				$("."+split[0]+"").prop("checked", true);
				$("."+split[0]+"r").prop("checked", false);
				s();
				pegarSelOde(split[0],split[1])
				$("#escaneadoFacturaPedidoT").val("");
			}
			else
			{
				var split = valor.split("*");
				$("."+split[0]+"r").prop("checked", true);
				$("."+split[0]).prop("checked", false);
				
				$("#escaneadoFacturaPedidoT").val("");
			}
			document.getElementById("escaneadoFacturaPedidoT").focus();
		}
		else
		{
			alert("No existe la factura: "+escaneado)
			$("#escaneadoFacturaPedidoT").val("");
			document.getElementById("escaneadoFacturaPedidoT").focus();
		}	
	}
	else
	{
		alert("Ingrese una factura")
		document.getElementById("escaneadoFacturaPedidoT").focus();
	}
	
}
function marcarFactura() 
{
	var escaneado = $("#escaneadoFacturaPedido").val().toUpperCase();
	//alert(escaneado);
	if (escaneado != '')
	{
		
		var valor = $("#"+escaneado+"").val();
		if (valor != undefined) 
		{
			if ($('input:radio[name=ctereg]:checked').val() == 'c') 
			{
				var split = valor.split("*");
				$("."+split[0]+"").prop("checked", true);
				$("."+split[0]+"r").prop("checked", false);
				s();
				pegarSelOde(split[0],split[1])
				$("#escaneadoFacturaPedido").val("");	
			}
			else
			{
				var split = valor.split("*");
//				console.log("split[0]: "+split[0])
				$("."+split[0]+"r").prop("checked", true);
				$("."+split[0]).prop("checked", false);
//				sR();
//				pegarSelOde(split[0]+"r",split[1])
				$("#escaneadoFacturaPedido").val("");
			}
			
			document.getElementById("escaneadoFacturaPedido").focus();
		}
		else
		{
			alert("No existe la factura: "+escaneado)
			$("#escaneadoFacturaPedido").val("");
			document.getElementById("escaneadoFacturaPedido").focus();
		}
	}
	else
	{
		alert("Ingrese una factura")
		document.getElementById("escaneadoFacturaPedido").focus();
	}
	
}

function marcarFacturaRC(){
	var escaneado = $("#escaneadoFacturaPedidoRC").val();
	if (escaneado != '')
	{
		var valor = $("#"+escaneado+"").val();
		if (valor != undefined) 
		{
			$("#escaneadoFacturaPedidoRC").val("");
			document.getElementById("escaneadoFacturaPedidoRC").focus();
		}
		else
		{
			alert("No existe la factura: "+escaneado)
			$("#escaneadoFacturaPedidoRC").val("");
			document.getElementById("escaneadoFacturaPedidoRC").focus();
		}
		
	}
	else
	{
		alert("Ingrese una factura")
		document.getElementById("escaneadoFacturaPedidoRC").focus();
	}
	
}

function agregarRegistroOdeTrans() 
{
	
	var ode = $("#odeAgregadaTrans").val();
	if(ode != "")
	{
		document.getElementById('cargando').style.display = 'block';
		$("#divMsjError").hide();
		$("#divMsjExito").hide();
		$.ajax({
		    url :'MonitorPedidosServlet', 
		    data : "accion=ConsultarOde&ode="+ode, 
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

		        		$("#msjOdeTrans").html("<pre>" + data + "</pre>");			        			
		        	} 
		        	else
		        	{	
		        		$("#odeAgregadaTrans").val("");
		        		alert("Hubo problema al recibir respuesta de la ODE.");
		        	}
	        	}
		        else
		        {
		        	document.getElementById('cargando').style.display = 'none';
		        	alert("No hubo respuesta")
		        	
		        }
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				if (xhr.status === 200)
				{
					alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
					window.location.href='/AsignacionRutasCDO/';
				}
			}
		});
	}
	else
	{
		alert("Debe ingresar una ODE")
	}
}

function validarCaminoAsignacionDetalleRC(){
	var vehiculos = $("#vehiculosSelect").val();
	if(vehiculos =! "" && vehiculos != "0")
	{
	   	var split = $("#vehiculosSelect").val().split("*");
	   		alert("asignarArticulosDeTraslado-RC");
	   		asignarPedidosDetalleRC();
	}
	else
	{
		alert("Debe seleccionar un vehiculo");
	}
}

function asignarPedidosDetalleRC(){
		var aux = 0;
		var articulos = $("#inputChoferMarcadoDetalleRC").val();

		if(aux == 0)
		{		
				$("#divMsjErrorRC").hide();
				ocultarModalMarcado();
				document.getElementById('cargando').style.display = 'block';
				$("#divMsjErrorRC").hide();
				$("#divMsjExitoRC").hide();
				$.ajax({
				    url :'MonitorPedidosServlet', 
				    data : "accion=ActualizarPedidosDetalleRC&articulos="+articulos, 				 
				    type : 'POST',
				    dataType : 'Json', 
				    success : function(respuesta)
				    { 				
				        if(respuesta)
			        	{
				        	document.getElementById('cargando').style.display = 'none';
			
				        	var data = respuesta;
				        	if( data = true)
				        	{				        			
				        				quitarChofer();
					        			alert("Articulos del Pedido seleccionados correctamente");
					        			$("#pedidosSelec").val("")		        			
					        			$("#divMarcadoDetalleRC").css("visibility","hidden");
					        		
	//				        			document.getElementById('cargando').style.display = 'block';
	//				        		    location.reload();				        			
				        	} 
				        	else
				        	{	
				        		quitarChofer();
				        		alert("Hubo un error al asignar pedidos,intente mas tarde");
				        		$("#divDetalleRC").hide()
				        		location.reload();
				        		
				        	}
			        	}
				        else
				        {
				        	document.getElementById('cargando').style.display = 'none';
				        	alert("No hubo respuesta")
				        	
				        }
					},
					error : function(xhr, status, error)
					{
						document.getElementById('cargando').style.display = 'none';
						if (xhr.status === 200)
						{
							alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
							window.location.href='/AsignacionRutasCDO/';
						}
					}
				});
			}

}

function enviarInformacionTraslado(data,cdoSel,chofer,vehiculos,pedidosRC){
//	console.log("-------------ENTRO----------")
//	console.log("data: " + data)
//	console.log("cdoSel " + cdoSel)
//	console.log("chofer " + chofer)
//	console.log("vehiculo " + vehiculos)
//	console.log("pedidosRC " + pedidosRC)
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : "accion=enviarTraspasoCDO&pedidosRC="+pedidosRC+"&vehiculo="+vehiculos+"&chofer="+chofer+"&cdoSel="+cdoSel+"&data="+data, 
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
	        			
	        		if (data.length > 9) 
		        	{
		        	    	quitarChofer();
		        			alert(data)
					}
		        	else
		        	{				        	 
			        		quitarChofer();
				        	alert("Pedidos asignados correctamente con el folio de envio: "+data);
				        	$("#pedidosSelec").val("")	
				        	$("#choferMarcadoJson").val("");
				        	$("#divCancelacionRC").hide();
				        	principalRC();OcultarDivStyle('asignacionTransportes');OcultarDivStyle('asignacionRC');
				        	
			        		//document.getElementById('cargando').style.display = 'block';
			        		//location.reload();
		        	}		        					        		
	        	} 
	        	else
	        	{	
	        		quitarChofer();
	        		alert("Hubo un error al asignar pedidos,intente mas tarde");
	        		$("#divCancelacionRC").hide()
	        		location.reload();
	        		
	        	}
        	}
	        else
	        {
	        	document.getElementById('cargando').style.display = 'none';
	        	alert("No hubo respuesta")
	        	
	        }
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
			}
		}
	});
	
	
	
}

function validarCaminoAsignacionRC(){
	//alert("Entro a validar Camino Asignacion");
	var vehiculos = $("#vehiculosSelect").val();
	if(vehiculos =! "" && vehiculos !="0")
	{
		var split = $("#vehiculosSelect").val().split("*");
		//alert(split);
		if (split[1] >= '4') 
		{
			//alert("asignarPedidosORDEN-RC");
			asignarPedidosORDENRC();
		}
		else
		{
			//alert("asignarPedidos-RC");
			asignarPedidosRC();
		}
	}
	else
	{
		alert("Debe seleccionar un vehiculo")
	}
}

function asignarPedidosRC() 
{
	
	var bandera = true;	
	
	if ($("#choferMarcadoJson").val() != "") 
	{
			
		var arr = $('[name="checksMarcadoRC[]"]:not(:checked)').map(function(){
			var isChecked = document.getElementById(this.id).checked;
			if(isChecked)
			{
				
			}
			else
			{
				console.log("nel")
				 bandera = false;	
			}
		}).get();
	}
	else
	{
		 bandera = true;	
	}
  
  if (bandera)
  {
		var chofer = $("#choferSelect").val();
		var vehiculos = $("#vehiculosSelect").val();
		var v = $("#vehiculosSelect").val();
		var factura = $("#facturaAgregada").val();
		//var pedidos = s();
		var pedidosRC = sRC();
		var facturaAgregada = "";
		var msj = $("#msjFacturaRC").text();
		var aux = 0;
		var facturasRC = $("#inputChoferRC").val();
		var articulosFactura = $("#inputChoferMarcadoDetalleRC").val();
		
		var cdoSelectPue = $("#cdoSelectPue").val();
		var cdoSelectLeo = $("#cdoSelectLeo").val();
		var cdoSelectCDX= $("#cdoSelectCDX").val();
		
		var cdoSelPue = $("#cdoSelPue").val();
		var cdoSelLeo = $("#cdoSelLeo").val();
		var cdoSelCDMX= $("#cdoSelCDX").val();
			
		var cdoSel = "";
		var validaSelCdo = "";
		var splitVehiculo = vehiculos.split("*");
		var llantas = splitVehiculo[1];
		
		if(cdoSelectPue != "0"){			
			cdoSel = cdoSelectPue;
			validaSelCdo = cdoSelPue;
		}
		else if(cdoSelectLeo != "0"){
			cdoSel = cdoSelectLeo;
			validaSelCdo = cdoSelLeo;
		}
		else if(cdoSelectCDX != "0"){
			cdoSel = cdoSelectCDX;
			validaSelCdo = cdoSelCDMX;
		}
		
//		console.log("cdoSel: " + cdoSel)
//		console.log("validaSelCdo: " + validaSelCdo)
		var splitCdoSel = "";
		if(validaSelCdo != ""){
			splitCdoSel = validaSelCdo.split("-");
		}
//		console.log("...1 cdoSel: " + cdoSel)
//		console.log("...1 validaSelCdo: " + validaSelCdo)
		var unaOri = $("#unameOrigen").val();
		//console.log("unaOri: " + unaOri)
		var valId = "";
		switch(unaOri){
			case "CDO CDMX":
				valId = 7;
			break;
			case "CDO PUEBLA 2000":
				valId = 8;
			break;
			case "CDO LEON":
				valId = 4;
			break;
		}
//		console.log("1-----------------------1")
//		console.log("pedidosRC: " + pedidosRC)
//		console.log("factura: " + factura)
//		console.log("chofer: " + chofer)
//		console.log("msjPedfac: " + $("#msjPedidosFacturasRC").text())
//		console.log("vehiculos: " + vehiculos)
//		console.log("Marcado:  " + $("#choferMarcadoJson").val())
//		console.log("articulosFactura: " + articulosFactura)
//		console.log("cdoSel: " + cdoSel)
//		console.log("llantas: " + llantas)
//		console.log("1-----------------------1")
		
		if(pedidosRC != "") 
		{
			
			
		}
		else
		{
			if (msj.includes("YA AGREGADA EN OTRO")  || msj.includes("NO EXISTE")  || msj.includes("INGRESO FACTURAS REPETIDAS") || msj.includes("false") || msj.length <= 5 || msj.length == 0) 
			{
				aux = 1;
			}
		}
	//	if (msj.includes("YA AGREGADA EN OTRO")  || msj.includes("NO EXISTE")  || msj.includes("INGRESO ODE REPETIDAS") || msj.includes("false") || msj.length <= 5 || msj.length == 0) 
	//	{
	//		aux = 1;
	//	}
		
		if(aux == 0)
		{
			if(chofer =! "" && chofer !="0")
			{
				if(v =! "" && v !="0")
				{							
					//alert("Asignar Pedidos: "+chofer+" "+vehiculos+" "+v+" "+ode+" "+pedidos+" "+pedidosR);
					if (confirm("Confirme para asignar al chofer: "+$('select[name="choferSel"] option:selected').text()+". los pedidos: "+obtenerChecksSeleccionadosRC())) 
		 			{
						//alert("Aqui...");
						$("#divMsjErrorRC").hide();
						ocultarModalMarcado();
						ocultarModalMarcadoRC();
						document.getElementById('cargando').style.display = 'block';
						$("#divMsjErrorRC").hide();
						$("#divMsjExitoRC").hide();
						$.ajax({
						    url :'MonitorPedidosServlet', 
						    data : "accion=AsignarPedidosRC&pedidosRC="+pedidosRC+"&facturaAgregada="+factura+"&c="+$("#choferSelect").val()+"&numeroFacturasRC="+$("#msjPedidosFacturasRC").text()+"&vehiculo="+$("#vehiculosSelect").val()+"&posicionInsert="+$("#choferMarcadoJson").val()+"&articulosFactura="+articulosFactura, 
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
						        			if (data.length > 9) 
						        			{
						        				quitarChofer();
						        				alert(data)
											}
						        			else
						        			{	
						        				if(validaSelCdo != ""){
//						        					console.log("cdoSel[1]: "+Number(splitCdoSel[1]))
//						        					console.log("valId: " + Number(valId))
						        					if(Number(valId) != Number(splitCdoSel[1])){
							        					if(validaSelCdo != 0 && llantas >= '4'){
										        			// console.log("Entra")
										        			 var chof = $("#choferSelect").val()
										        			 enviarInformacionTraslado(data,validaSelCdo,chof,vehiculos,pedidosRC); 
										        		 }else{
										        			// console.log("No entra")
										        			 quitarChofer();
											        		 alert("Pedidos asignados correctamente con el folio de envio: "+data);
											        		 $("#pedidosSelec").val("")	
											        		 $("#choferMarcadoJson").val("");
											        		 $("#divCancelacionRC").hide();
											        		 $("#cdoSelPue").val("0");
											        		 principalRC();OcultarDivStyle('asignacionTransportes');OcultarDivStyle('asignacionRC');
										        		 }
							        				}else{
							        					//console.log("No entra")
									        			 quitarChofer();
										        		 alert("Pedidos asignados correctamente con el folio de envio: "+data);
										        		 $("#pedidosSelec").val("")	
										        		 $("#choferMarcadoJson").val("");
										        		 $("#divCancelacionRC").hide();
										        		 $("#cdoSelPue").val("0");
										        		 principalRC();OcultarDivStyle('asignacionTransportes');OcultarDivStyle('asignacionRC');
							        				}
						        				}
						        				else
						        				{
							        			// console.log("No entra")
							        			 quitarChofer();
								        		 alert("Pedidos asignados correctamente con el folio de envio: "+data);
								        		 $("#pedidosSelec").val("")	
								        		 $("#choferMarcadoJson").val("");
								        		 $("#divCancelacionRC").hide();
								        		 $("#cdoSelPue").val("0");
								        		 principalRC();OcultarDivStyle('asignacionTransportes');OcultarDivStyle('asignacionRC');
							        		 }	
							        			
							        			
							        			//document.getElementById('cargando').style.display = 'block';
							        			//location.reload();
						        			}
						        	} 
						        	else
						        	{	
						        		quitarChofer();
						        		alert("Hubo un error al asignar pedidos,intente mas tarde");
						        		$("#divCancelacionRC").hide()
						        		location.reload();
						        		
						        	}
					        	}
						        else
						        {
						        	document.getElementById('cargando').style.display = 'none';
						        	alert("No hubo respuesta")
						        	
						        }
							},
							error : function(xhr, status, error)
							{
								document.getElementById('cargando').style.display = 'none';
								if (xhr.status === 200)
								{
									alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
									window.location.href='/AsignacionRutasCDO/';
								}
							}
						});
				     }						
			}
			else
			{
				alert("Debe seleccionar un vehiculo")
			}
			}
			else
			{
				alert("Debe seleccionar un chofer")
			}
		}
		else
		{
			alert("Favor de marcar una FACTURA en la tabla o consultar FACTURA valida")
			
		}
  }
  else
	 {
	  alert("Debe seleccionar todos los registros")
	 }
}

function asignarPedidosORDENRC() 
{
	//alert("Entra a asignarPedidosORDENRC");
	var chofer = $("#choferSelect").val();
	var vehiculos = $("#vehiculosSelect").val();
	var v = $("#vehiculosSelect").val();
	var factura = $("#facturaAgregada").val();
	var pedidosRC = sRC();
	var facturaAgregada = "";
	var msj = $("#msjFacturaRC").text();
	var aux = 0;
	var facturasRC = $("#inputChoferRC").val();
	var articulosFactura = $("#inputChoferMarcadoDetalleRC").val();
	
	var cdoSelectPue = $("#cdoSelectPue").val();
	var cdoSelectLeo = $("#cdoSelectLeo").val();
	var cdoSelectCDX= $("#cdoSelectCDX").val();
	
	var cdoSelPue = $("#cdoSelPue").val();
	var cdoSelLeo = $("#cdoSelLeo").val();
	var cdoSelCDMX= $("#cdoSelCDX").val();
	
	var cdoSel = "";
	var validaSelCdo = "";
	
	if(cdoSelectPue != "0"){			
		cdoSel = cdoSelectPue;
		validaSelCdo = cdoSelPue;
	}
	else if(cdoSelectLeo != "0"){
		cdoSel = cdoSelectLeo;
		validaSelCdo = cdoSelLeo;
	}
	else if(cdoSelectCDX != "0"){
		cdoSel = cdoSelectCDX;
		validaSelCdo = cdoSelCDMX;
	}
	
//	console.log("validaSelCdo: "+validaSelCdo)
//	console.log("-----------------------")
//	console.log("pedidosRC: " + pedidosRC)
//	console.log("factura: " + factura)
//	console.log("chofer: " + chofer)
//	console.log("msjPedfac: " + $("#msjPedidosFacturasRC").text())
//	console.log("vehiculos: " + vehiculos)
//	console.log("articulosFactura: " + articulosFactura)
//	console.log("cdoSel: " + cdoSel)
//	console.log("-----------------------")
	
	
	//alert("Asignar Pedidos ORDEN: "+chofer+" "+vehiculos+" "+v+" "+ode+" "+pedidos+" "+pedidosR);
	
	if(pedidosRC != "") 
	{
		
		
	}
	else
		{
		if (msj.includes("YA AGREGADA EN OTRO")  || msj.includes("NO EXISTE")  || msj.includes("INGRESO FACTURA REPETIDAS") || msj.includes("false") || msj.length <= 5 || msj.length == 0) 
		{
			aux = 1;
		}
		}
//	if (msj.includes("YA AGREGADA EN OTRO")  || msj.includes("NO EXISTE")  || msj.includes("INGRESO ODE REPETIDAS") || msj.includes("false") || msj.length <= 5 || msj.length == 0) 
//	{
//		aux = 1;
//	}
	
	if(aux == 0)
	{
		
		if(chofer =! "" && chofer !="0")
		{
			if(v =! "" && v !="0")
			{
				if(validaSelCdo != "0"){
					if (confirm("Confirme para asignar al chofer: "+$('select[name="choferSel"] option:selected').text()+". los pedidos: "+obtenerChecksSeleccionadosRC())) 
		 			{
				document.getElementById('cargando').style.display = 'block';
				$("#divMsjError").hide();
				$("#divMsjExito").hide();
				$("#choferMarcadoJson").val("");
				$.ajax({
				    url :'MonitorPedidosServlet',  
				    data : "accion=AsignarPedidosORDENRC&pedidosRC="+pedidosRC+"&facturaAgregada="+factura+"&c="+$("#choferSelect").val()+"&numeroFacturasRC="+$("#msjPedidosFacturasRC").text()+"&vehiculo="+$("#vehiculosSelect").val()+"&articulosFactura="+articulosFactura,
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
				        		llenarGridMarcadoClientesRC(data)
				        		$("#divMarcadoClientesRC").css("visibility", "visible");
				        		$("#gridMarcadoClientesRC").show()
				        	}else{
				        		alert("No encuentra informacion del traslado.");
				        	} 
				        	
			        	}
				        else
				        {
				        	document.getElementById('cargando').style.display = 'none';
				        	alert("No hubo respuesta")
				        	
				        }
					},
					error : function(xhr, status, error)
					{
						document.getElementById('cargando').style.display = 'none';
						if (xhr.status === 200)
						{
							alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
							window.location.href='/AsignacionRutasCDO/';
						}
					}
				});
				}
			  }
			  else
			  {
				  alert("Debe seleccionar un CDO Destino")
			  }
			}
		else
		{
			alert("Debe seleccionar un vehiculo")
		}
		}
		else
		{
			alert("Debe seleccionar un chofer")
		}
	}
	else
	{
		alert("Favor de marcar un traslado en la tabla o consultar un traslado valido")
		
	}
}

function validarCaminoAsignacion() 
{
	//alert("Entro a validar Camino Asignacion");
	var vehiculos = $("#vehiculosSelect").val();
	if(vehiculos =! "" && vehiculos !="0")
	{
		var split = $("#vehiculosSelect").val().split("*");
		//alert(split);
		if (split[1] >= '4') 
		{
			alert("asignarPedidosORDEN");
			asignarPedidosORDEN();
		}
		else
		{
			alert("asignarPedidos");
			asignarPedidos();
		}
	}
	else
	{
		alert("Debe seleccionar un vehiculo")
	}
}


function asignarPedidos() 
{
	
	var bandera = true;	
	
	if ($("#choferMarcadoJson").val() != "") 
	{
			
		var arr = $('[name="checksMarcado[]"]:not(:checked)').map(function(){
			var isChecked = document.getElementById(this.id).checked;
			if(isChecked)
			{
				
			}
			else
			{
				console.log("nel")
				 bandera = false;	
			}
		}).get();
	}
	else
	{
		 bandera = true;	
	}
  
  if (bandera)
  {
		var chofer = $("#choferSelect").val();
		var vehiculos = $("#vehiculosSelect").val();
		var v = $("#vehiculosSelect").val();
		var ode = $("#odeAgregada").val();
		var pedidos = s();
		var pedidosR = sR();
		var OdeAgregada = "";
		var msj = $("#msjOde").text();
		var aux = 0;
		//alert("pedidos: "+pedidos);
		//alert("pedidos: "+pedidosR);
		//alert("Asignar Pedidos: "+chofer+" "+vehiculos+" "+v+" "+ode+" "+pedidos+" "+pedidosR);
		if(pedidos != "" || pedidosR != "") 
		{
			
			
		}
		else
			{
			if (msj.includes("YA AGREGADA EN OTRO")  || msj.includes("NO EXISTE")  || msj.includes("INGRESO ODE REPETIDAS") || msj.includes("false") || msj.length <= 5 || msj.length == 0) 
			{
				aux = 1;
			}
			}
	//	if (msj.includes("YA AGREGADA EN OTRO")  || msj.includes("NO EXISTE")  || msj.includes("INGRESO ODE REPETIDAS") || msj.includes("false") || msj.length <= 5 || msj.length == 0) 
	//	{
	//		aux = 1;
	//	}
		
		if(aux == 0)
		{
			if(chofer =! "" && chofer !="0")
			{
				if(v =! "" && v !="0")
				{
					//alert("Asignar Pedidos: "+chofer+" "+vehiculos+" "+v+" "+ode+" "+pedidos+" "+pedidosR);
					if (confirm("Confirme para asignar al chofer: "+$('select[name="choferSel"] option:selected').text()+". los pedidos: "+obtenerChecksSeleccionados())) 
		 			{
				//alert("Aqui...");
				$("#divMsjError").hide();
				ocultarModalMarcado();
				document.getElementById('cargando').style.display = 'block';
				$("#divMsjError").hide();
				$("#divMsjExito").hide();
				$.ajax({
				    url :'MonitorPedidosServlet', 
				    data : "accion=AsignarPedidos&pedidos="+pedidos+"&odeAgregada="+ode+"&pedidosR="+pedidosR+"&c="+$("#choferSelect").val()+"&numeroFacturas="+$("#msjPedidosFacturas").text()+"&vehiculo="+$("#vehiculosSelect").val()+"&posicionInsert="+$("#choferMarcadoJson").val(), 
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
				        			if (data.length > 9) 
				        			{
				        				quitarChofer();
				        				alert(data)
									}
				        			else
				        			{	
				        				quitarChofer();
					        			alert("Pedidos asignados correctamente con el folio de envio: "+data);
					        			$("#pedidosSelec").val("")		        			
					        			$("#divCancelacion").hide();
					        			principal();OcultarDivStyle('asignacionTransportes');OcultarDivStyle('asignacion');
	//				        			document.getElementById('cargando').style.display = 'block';
	//				        		    location.reload();
				        			}
				        	} 
				        	else
				        	{	
				        		quitarChofer();
				        		alert("Hubo un error al asignar pedidos,intente mas tarde");
				        		$("#divCancelacion").hide()
				        		location.reload();
				        		
				        	}
			        	}
				        else
				        {
				        	document.getElementById('cargando').style.display = 'none';
				        	alert("No hubo respuesta")
				        	
				        }
					},
					error : function(xhr, status, error)
					{
						document.getElementById('cargando').style.display = 'none';
						if (xhr.status === 200)
						{
							alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
							window.location.href='/AsignacionRutasCDO/';
						}
					}
				});
				}
				}
			else
			{
				alert("Debe seleccionar un vehiculo")
			}
			}
			else
			{
				alert("Debe seleccionar un chofer")
			}
		}
		else
		{
			alert("Favor de marcar una ODE en la tabla o consultar ODE valida")
			
		}
  }
  else
	 {
	  alert("Debe seleccionar todos los registros")
	 }
}

function asignarPedidosORDEN() 
{
	
	
	
	var chofer = $("#choferSelect").val();
	var vehiculos = $("#vehiculosSelect").val();
	var v = $("#vehiculosSelect").val();
	var ode = $("#odeAgregada").val();
	var pedidos = s();
	var pedidosR = sR();
	var OdeAgregada = "";
	var msj = $("#msjOde").text();
	var aux = 0;
	//alert("Asignar Pedidos ORDEN: "+chofer+" "+vehiculos+" "+v+" "+ode+" "+pedidos+" "+pedidosR);
	if(pedidos != "" || pedidosR != "") 
	{
		
		
	}
	else
		{
		if (msj.includes("YA AGREGADA EN OTRO")  || msj.includes("NO EXISTE")  || msj.includes("INGRESO ODE REPETIDAS") || msj.includes("false") || msj.length <= 5 || msj.length == 0) 
		{
			aux = 1;
		}
		}
//	if (msj.includes("YA AGREGADA EN OTRO")  || msj.includes("NO EXISTE")  || msj.includes("INGRESO ODE REPETIDAS") || msj.includes("false") || msj.length <= 5 || msj.length == 0) 
//	{
//		aux = 1;
//	}
	
	if(aux == 0)
	{
		
		if(chofer =! "" && chofer !="0")
		{
			if(v =! "" && v !="0")
			{
				if (confirm("Confirme para asignar al chofer: "+$('select[name="choferSel"] option:selected').text()+". los pedidos: "+obtenerChecksSeleccionados())) 
	 			{
			document.getElementById('cargando').style.display = 'block';
			$("#divMsjError").hide();
			$("#divMsjExito").hide();
			$.ajax({
			    url :'MonitorPedidosServlet', 
			    data : "accion=AsignarPedidosORDEN&pedidos="+pedidos+"&odeAgregada="+ode+"&pedidosR="+pedidosR+"&c="+$("#choferSelect").val()+"&numeroFacturas="+$("#msjPedidosFacturas").text()+"&vehiculo="+$("#vehiculosSelect").val(), 
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
			        		llenarGridMarcadoClientes(data)
			        		$("#divMarcadoClientes").css("visibility", "visible");
			        		$("#gridMarcadoClientes").show()
			        	} 
			        	
		        	}
			        else
			        {
			        	document.getElementById('cargando').style.display = 'none';
			        	alert("No hubo respuesta")
			        	
			        }
				},
				error : function(xhr, status, error)
				{
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200)
					{
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href='/AsignacionRutasCDO/';
					}
				}
			});
			}
			}
		else
		{
			alert("Debe seleccionar un vehiculo")
		}
		}
		else
		{
			alert("Debe seleccionar un chofer")
		}
	}
	else
	{
		alert("Favor de marcar una ODE en la tabla o consultar ODE valida")
		
	}
}


function confirmarFacturasAjax() 
{
	var pedidos = sCredito();
	
	if(pedidos != "")
	{
		document.getElementById('cargando').style.display = 'block';
		$("#divMsjError").hide();
		$("#divMsjExito").hide();
		$.ajax({
		    url :'MonitorPedidosServlet', 
		    data : "accion=ActualizarFacturas&pedidos="+pedidos, 
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
	        			alert("Facturas actualizadas correctamente: "+obtenerChecksSeleccionadosCredito());
	        			$("#divCancelacionFacturas").hide();
	        			consultarCredito();
		        	} 
		        	else
		        	{	
		        		alert("Error interno al actualizar las facturas");
		        		$("#divCancelacionFacturas").hide()
		        		
		        	}
	        	}
		        else
		        {
		        	document.getElementById('cargando').style.display = 'none';
		        	alert("No hubo respuesta")
		        	
		        }
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				if (xhr.status === 200)
				{
					alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
					window.location.href='/AsignacionRutasCDO/';
				}
			}
		});
	}
	else
	{
		alert("Debe seleccionar una factura al menos")
		$("#divCancelacionFacturas").hide()
	}
}

function asignarPedidosTrans() 
{

	var chofer = $("#choferSelectTrans").val();
	var ode = $("#odeAgregadaTrans").val();
	var pedidos = sTrans();
	var pedidosR = sTransR();
	
	var OdeAgregada = "";
	var msj = $("#msjOdeTrans").text();
	var aux2 = 0;
	var aux = 0;
	
	if(pedidos != "" || pedidosR != "")
	{
		
	}
	else
		{
		if (msj.includes("YA AGREGADA EN OTRO")  || msj.includes("NO EXISTE")  || msj.includes("INGRESO ODE REPETIDAS") || msj.includes("false") || msj.length <= 5 || msj.length == 0) 
		{
			aux2 = 1;
		}
		}
//	if (msj.includes("YA AGREGADA EN OTRO")  || msj.includes("NO EXISTE")  || msj.includes("INGRESO ODE REPETIDAS") || msj.includes("false") || msj.length <= 5 || msj.length == 0) 
//	{
//		aux2 = 1;
//	}
	if(aux2 == 0)
	{
		
		if(chofer =! "" && chofer !="0")
		{
		var regional = validaRegional();
		if (regional > 0)
		{
			if ($("#cdoFacturasTrans").val() != '')
			{
				
			}
			else
				{
				aux ++;;
				alert("Debe seleccionar el cdo regional al que lo mandara.")
				}
		}	
		if (aux == 0)
		{
			if (confirm("Confirme para asignar al transporte: "+ $('select[name="choferSelTrans"] option:selected').text()+". los pedidos: "+obtenerChecksSeleccionadosTrans())) 
 			{
			document.getElementById('cargando').style.display = 'block';
			$("#divMsjError").hide();
			$("#divMsjExito").hide();
			
			$.ajax({
			    url :'MonitorPedidosServlet', 
			    data : "accion=AsignarPedidosTrans&pedidos="+pedidos+"&odeAgregada="+ode+"&c="+$("#choferSelectTrans").val()+"&pedidosR="+pedidosR+"&uname_regional="+$("#cdoFacturasTrans").val()+"&numeroFacturas="+$("#msjPedidosFacturasTrans").text(), 
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
			        			if (data.length > 9) 
			        			{
			        				quitarChofer();
			        				alert(data)
								}
			        			else
			        			{	
			        				quitarChofer();
				        			alert("Pedidos asignados correctamente con el folio de envio: "+data);
				        			$("#pedidosSelecTrans").val("")		        			
				        			$("#divCancelacionTrans").hide();
				        			document.getElementById('cargando').style.display = 'block';
				        		    location.reload();
			        			}
			        	} 
			        	else
			        	{	
			        		quitarChofer();
			        		alert("Hubo un error al asignar pedidos,intente mas tarde");
			        		$("#divCancelaciontrans").hide()
			        		location.reload();
			        		
			        	}
		        	}
			        else
			        {
			        	document.getElementById('cargando').style.display = 'none';
			        	alert("No hubo respuesta")
			        	
			        }
				},
				error : function(xhr, status, error)
				{
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200)
					{
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href='/AsignacionRutasCDO/';
					}
				}
			});
 			}
		}
		}
		else
		{
			alert("Debe seleccionar un transporte")
		}
	}
	else
	{
		alert("Favor de marcar una ODE en la tabla o consultar ODE valida")
	}
}






























function selectZonasAct(valor) 
{
	var split = valor.split("*");
	document.getElementById("descripcionZona").value = split[0];
	document.getElementById("letraZona").value = split[1];
}
function estatusAct(valor) 
{
	var split = valor.split("*");
	document.getElementById("descripcionEstatus").value = split[1];
	document.getElementById("valorEstatus").value = split[0];
}



function msjError()
{
	$("#divMsjError").show();
	$('#orden').val("");
	$('#pedido').val("");
}

function cerrarRespuesta() {
	$("#divMsjExito").hide();
	$("#divMsjError").hide();
}


function eliminarCredito()
{
	document.getElementById('monCredito').innerHTML = '';
}

function consultaPedidosBD(ruta,tipo)
{
	//alert("ruta: "+ruta);
	//alert("tipo: "+tipo);
	document.getElementById('dgZonasClicTrans').innerHTML = '';
	document.getElementById('cargando').style.display = 'block';
	$("#divMsjError").hide();
	$("#divChofer").hide();
	$("#divMsjExito").hide();
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : "accion=ConsultarPedidos&ruta="+ruta+"&tipo="+tipo+"&fechaInicio="+$("#txt_fechaIniPedidosc").val()+"&fechaFin="+$("#txt_fechaFinPedidosc").val(),
	    type : 'POST',
	    dataType : 'Json',  
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	document.getElementById('cargando').style.display = 'none';
	        	$("#encabezadoPedidosInicial").show()
	        	$("#choferTipo").val(tipo);
	        	var data = respuesta;
	        	if( data.length > 0)
	        	{
	        		$("#encabezadoPedidosInicial").hide()
	        		$("#encabezadoPedidos").show()
	        		llenaGridCheques(data,tipo)
		        	MostrarDiv('dgZonas');
	        		$("#divCalendarioc").hide()
//	        		MostrarDiv('asignacion');
	        		MostrarDivStyle('asignacion');
	        		MostrarDiv('asignacion');
//	        		MostrarDiv('dgZonasClic');
	        		document.getElementById("escaneadoFacturaPedido").focus();
	        		inicio()
	        	} 
	        	else
	        	{	
	        		$("#encabezadoPedidosInicial").show()
	        		$("#encabezadoPedidos").hide()
	        		document.getElementById('dgZonasClic').innerHTML = '';
	        		alert("No existen pedidos para asignar a chofer disponibles")
	        	}
        	}
	        else		        	
	    var n;
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
			}
		}
	});

}

function consultarPedidosRcBD(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : "accion=ConsultarPedidosRC&fechaInicio="+$("#txt_fechaIniPedidosRc").val()+"&fechaFin="+$("#txt_fechaFinPedidosRc").val(),
	    type : 'POST',
	    dataType : 'Json',  
	    success : function(respuesta)
	    { 
	    	if(respuesta){
	    		//document.getElementById('cargando').style.display = 'none';
	    		$("#encabezadoPedidosInicialRC").show()
	    		var data = respuesta;
	    		//alert(data.length);
	    		if( data.length > 0){
	    			$("#encabezadoPedidosInicialRC").hide()
	    			$("#encabezadoPedidosRC").show()
	    			LLenarGridRC(data);
	    			$("#divCalendariocRC").hide()
	    			MostrarDivStyle('asignacionRC');
	        		MostrarDiv('asignacionRC');
	        		document.getElementById("escaneadoFacturaPedido").focus();
	        		document.getElementById('cargando').style.display = 'none';
	    		}else{
	    			$("#encabezadoPedidosInicialRC").show()
	    			$("#encabezadoPedidosRC").hide()
	    			document.getElementById('dgZonasClicRC').innerHTML = '';
	    			alert("NO existen registros de RC");
	    			document.getElementById('cargando').style.display = 'none';
	    		}
	    	}
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
			}
		}
	});
}

function consultaPedidosBDTrans(ruta,tipo)
{
	document.getElementById('dgZonasClic').innerHTML = '';
	$("#divTransporte").hide();
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : "accion=ConsultarPedidosTrans&ruta="+ruta+"&tipo="+tipo+"&fechaInicio="+$("#txt_fechaIniPedidost").val()+"&fechaFin="+$("#txt_fechaFinPedidost").val(), 
	    type : 'POST',
	    dataType : 'Json',  
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	document.getElementById('cargando').style.display = 'none';
	        	$("#transporteTipo").val(tipo);
	        	var data = respuesta;
	        	if( data.length > 0)
	        	{
	        		$("#encabezadoPedidosInicialTrans").hide()
	        		$("#encabezadoPedidosTrans").show()
	        		llenaGridChequesTrans(data,tipo)
		        	MostrarDiv('dgZonasTrans');
	        		$("#divCalendariot").hide()
//	        		MostrarDiv('dgZonasClicTrans');
	        		MostrarDivStyle('asignacionTransportes');
	        		MostrarDiv('asignacionTransportes');
	        		document.getElementById("escaneadoFacturaPedidoT").focus();
	        	} 
	        	else
	        	{	
	        		$("#encabezadoPedidosInicialTrans").show()
	        		$("#encabezadoPedidosTrans").hide()
	        		document.getElementById('dgZonasClicTrans').innerHTML = '';
	        		
	        		alert("No existen pedidos para asignar transportes disponibles.")
	        	}
        	}
	        else		        	
	    var n;
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
			}
		}
	});

}



function ObtenerFechaActual()
{
	var fecha = new Date();
	let dia = String(fecha.getDate()).padStart(2, '0');
	let mes = String(fecha.getMonth() + 1).padStart(2, '0'); 
	let year = fecha.getFullYear();
	
	fecha = dia + '/' + mes + '/' + year;
	return fecha;
}


function llenaGridChequesClic(dataR)
{
 
}

function mostrarUbicacion(ICancelado) 
{
	
	
	if(ICancelado.facturas == null)
	{
		alert("No tiene facturas este pedido.")
	}
	else 
	{
	
	MostrarDiv('divCancelacion');
	
	var nn;
	nn = ICancelado.facturas;
	var spliteado = nn.split(",");
	var fact = ""
	for (var i = 0; i < spliteado.length; i++)
	{
		if (fact != "")
		{
			fact += spliteado[i]+", ";
		}
		else
		{
			fact = spliteado[i]+", "
		}
	}
	
	var ln = fact.length;
	var fact1 = fact.substring(0,(ln-2));
	$("#msjCancelacion").text("  "+fact1+"  ");
	
	}
}



function quitarValorCliente() 
{
	$("#busquedaCliente").val("")
	$("#busquedaClienteFin").val("")
}

function ponerValorCliente() 
{
	$("#busquedaCliente").val(0)
	$("#busquedaClienteFin").val(999999)
}


function quitarChofer() 
{
	$("#inputChoferRC").val("");
	$("#inputChofer").val("");
	$("#inputTrans").val("");
	$("#inputChoferMarcadoDetalleRC").val("");
}

function c(valor)
{
	return console.log(valor);
}

function pegarSelOde(ode,id)
{
	if($("#"+id+"").is(':checked'))
	{
		$("."+ode+"").prop("checked", true);
		$("."+ode+"r").prop("checked", false);
	}
	else
	{
		$("."+ode+"").prop("checked", false);
	}
	$("."+ode+"").each(function(index) 
	{
	   pegarSel($(this).attr('id'));
	});
}

function obtenerId(valor)
{
	
	var split = valor.split("*");
	return split[0];
}

function pegarSelOdeMarcadoRC(id)
{
	if($("#"+id+"").is(':checked'))
	{
		$("."+id+"").prop("checked", true);
		
	}
	else
	{
		$("."+id+"").prop("checked", false);
	}
	   pegarSelMarcadoRC(id);
}

function pegarSelOdeMarcado(id)
{
	if($("#"+id+"").is(':checked'))
	{
		$("."+id+"").prop("checked", true);
		
	}
	else
	{
		$("."+id+"").prop("checked", false);
	}
	   pegarSelMarcado(id);
}

function pegarSelDetalleRC(id)
{
	if($("#"+id+"").is(':checked'))
	{
		$("."+id+"").prop("checked", true);
		
	}
	else
	{
		$("."+id+"").prop("checked", false);
	}
	pegarSelMarcadoDetalleRC(id);
}

function pegarSelOdeTrans(ode,id)
{
	if($("#"+id+"").is(':checked'))
	{
		$("."+ode+"").prop("checked", true);
		$("."+ode+"r").prop("checked", false);
	}
	else
	{
		$("."+ode+"").prop("checked", false);
	}
	$("."+ode+"").each(function(index) 
	{
	   pegarSelTrans($(this).attr('id'));
	});
}

function pegarSelFact(facturaTras, identificacionCDD){
	//alert("pegarSelFact: "+facturaTras);
		if($("#"+facturaTras+"").is(':checked'))
		{
			//alert("entra en check");
			$("."+facturaTras.substring(0,facturaTras.length-1)+"").prop("checked",false);
			$("."+facturaTras+"").prop("checked",true)
		}
		else
		{
			//alert("no entra en check");
			$("."+facturaTras+"").prop("checked",false);
		}
	
	$("."+facturaTras+"").each(function(index)
	{
		pegarSelF($(this).attr('id'), identificacionCDD);
	});
}


function pegarSelOdeR(ode,id)
{
	if($("#"+id+"").is(':checked'))
	{
		$("."+ode.substring(0,ode.length-1)+"").prop("checked", false);
		$("."+ode+"").prop("checked", true);
	}
	else
	{
		$("."+ode+"").prop("checked", false);
	}
	$("."+ode+"").each(function(index) 
	{
	   pegarSel($(this).attr('id'));
	});
}

function pegarSelOdeRTrans(ode,id)
{
	if($("#"+id+"").is(':checked'))
	{
		$("."+ode.substring(0,ode.length-1)+"").prop("checked", false);
		$("."+ode+"").prop("checked", true);
	}
	else
	{
		$("."+ode+"").prop("checked", false);
	}
	$("."+ode+"").each(function(index) 
	{
	   pegarSelTrans($(this).attr('id'));
	});
}

function pegarSelMarcadoRC(id)
{	
	var input = $("#inputChoferMarcado").val() ;
	input = input.replace(",,",",");
	var isChecked = document.getElementById(id).checked;
	 if(!isChecked)
 	{
		 input = input.replace(id,"");
	}
	 else
	 {
		 
		 input = input+ ","+id;
	 }
	 $("#inputChoferMarcado").val(input);
	 llenarTablaDinamicaMarcadoRC();
}

function pegarSelMarcado(id)
{	
	var input = $("#inputChoferMarcado").val() ;
	input = input.replace(",,",",");
	var isChecked = document.getElementById(id).checked;
	 if(!isChecked)
 	{
		 input = input.replace(id,"");
	}
	 else
	 {
		 
		 input = input+ ","+id;
	 }
	 $("#inputChoferMarcado").val(input);
	 llenarTablaDinamicaMarcado();
}

function pegarSelMarcadoDetalleRC(id)
{
	var input = $("#inputChoferMarcadoDetalleRC").val();
	input = input.replace(",,",",");
	var isChecked = document.getElementById(id).checked;
	 if(!isChecked)
 	{
		 input = input.replace(id,"");
	}
	 else
	 {
		 
		 input = input+ ","+id;
	 }
	 $("#inputChoferMarcadoDetalleRC").val(input);
	 //llenarTablaDinamicaMarcado();
}


function llenarTablaDinamicaMarcadoRC() 
{
	$("#tblDinamicaMarcadoRC").html("");
	$("#choferMarcadoJson").val("");
	var trayectos = $("#inputChoferMarcado").val().split(",");
	var marcadoJson = '';
	var tabla = '<table class="table table-hover table-responsive table-striped" style="width: 100%; height: 480px;" >';
    tabla += '<thead>';
    tabla += '<tr style="">';
    tabla += '<th style="align-content: center;font-weight: 400;">ORDEN</th><th style="align-content: center;font-weight: 400;">RUTA</th><th style="font-weight: 400;align-content: center;">CLIENTE</th>';
    tabla += '</tr>';
    tabla += '</thead>';
	tabla += '<tbody style = "font-size: 13px;">';
    tr = '';
    var aux = 1
    tr += '<tr style =" padding-bottom: 0px;padding-top: 0px;visibility: hidden;font-size:1px"> <td style="text-align: center;padding-bottom: 0px;padding-top: 0px;">.</td><td style = "text-align: left;padding-bottom: 0px;padding-top: 0px;">.......................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................</td><td style="text-align: center;padding-bottom: 0px;padding-top: 0px;">......</td></tr>';
    for (var i = 0; i < trayectos.length; i++) 
    {
    	if (trayectos[i] != '')
    	{
    		var split = trayectos[i].split("*");
    		tr += '<tr>';
        	tr += '<td style="text-align: center;padding-bottom: 5px;padding-top: 5px;">'+aux+'</td><td style = "text-align: left;padding-bottom: 5px;padding-top: 5px;">'+split[1]+'</td><td style="text-align: center;padding-bottom: 5px;padding-top: 5px;">'+split[2]+'</td>';
        	tr += '</tr>';
        	marcadoJson = marcadoJson + aux + "*" + split[2] +",";
        	aux = parseInt(aux) + 1;
        	
		}
	}
	tabla += tr;
    tabla += '</tbody></table>';
    if (aux > 1) 
    {
    	if (marcadoJson.length > 0) 
    	{
    		$("#choferMarcadoJson").val(marcadoJson);
    		$("#ordenMarcadoRC2").show();
    		$("#subtablaPrincipalMarcadoRC").show();
		}
    	else
		{
    		alert("Debe seleccionar un cliente al menos")
		}
    	
	}
    else
	{
    	$("#subtablaPrincipalMarcadoRC").hide();
    	$("#ordenMarcadoRC2").hide();
	}
        $("#tblDinamicaMarcadoRC").html(tabla);	
}

function llenarTablaDinamicaMarcado() 
{
	$("#tblDinamicaMarcado").html("");
	$("#choferMarcadoJson").val("");
	var trayectos = $("#inputChoferMarcado").val().split(",");
	var marcadoJson = '';
	var tabla = '<table class="table table-hover table-responsive table-striped" style="width: 100%; height: 480px;" >';
    tabla += '<thead>';
    tabla += '<tr style="">';
    tabla += '<th style="align-content: center;font-weight: 400;">ORDEN</th><th style="align-content: center;font-weight: 400;">RUTA</th><th style="font-weight: 400;align-content: center;">CLIENTE</th>';
    tabla += '</tr>';
    tabla += '</thead>';
	tabla += '<tbody style = "font-size: 13px;">';
    tr = '';
    var aux = 1
    tr += '<tr style =" padding-bottom: 0px;padding-top: 0px;visibility: hidden;font-size:1px"> <td style="text-align: center;padding-bottom: 0px;padding-top: 0px;">.</td><td style = "text-align: left;padding-bottom: 0px;padding-top: 0px;">.......................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................................</td><td style="text-align: center;padding-bottom: 0px;padding-top: 0px;">......</td></tr>';
    for (var i = 0; i < trayectos.length; i++) 
    {
    	if (trayectos[i] != '')
    	{
    		var split = trayectos[i].split("*");
    		tr += '<tr>';
        	tr += '<td style="text-align: center;padding-bottom: 5px;padding-top: 5px;">'+aux+'</td><td style = "text-align: left;padding-bottom: 5px;padding-top: 5px;">'+split[1]+'</td><td style="text-align: center;padding-bottom: 5px;padding-top: 5px;">'+split[2]+'</td>';
        	tr += '</tr>';
        	marcadoJson = marcadoJson + aux + "*" + split[2] +",";
        	aux = parseInt(aux) + 1;
        	
		}
	}
	tabla += tr;
    tabla += '</tbody></table>';
    if (aux > 1) 
    {
    	if (marcadoJson.length > 0) 
    	{
    		$("#choferMarcadoJson").val(marcadoJson);
    		$("#ordenMarcado").show();
    		$("#subtablaPrincipalMarcado").show();
		}
    	else
		{
    		alert("Debe seleccionar un cliente al menos")
		}
    	
	}
    else
	{
    	$("#subtablaPrincipalMarcado").hide();
    	$("#ordenMarcado").hide();
	}
        $("#tblDinamicaMarcado").html(tabla);	
}

function pegarSelF(id, identificacionCDD){
	//alert("id: "+id);
	var input = $("#inputChoferRC").val();
	//alert("input: "+input);
	input = input.replace(",,",",");
	var isChecked = document.getElementById(id).checked;
	if(!isChecked)
	{
		//input = input.replace(id+"r","");
		input = input.replace(id,"");
	}
	else
	{
		//if(id.includes("r")){
		input = input.replace(id,"");
		//}	
		input = input+ ","+id;
		//alert("input: "+input);
	}
	$("#inputChoferRC").val(input);
}

function pegarSel(id)
{
	//alert("id: "+id);
	var input = $("#inputChofer").val() ;
	//alert("input: "+input);
	input = input.replace(",,",",");
	var isChecked = document.getElementById(id).checked;
	
	 if(!isChecked)
 	{
		 input = input.replace(id+"r","");
		 input = input.replace(id,"");
	}
	 else
	 {
		 if (id.includes("r"))
		 {
			 var split = id.split("r");
			 input = input.replace(split[0],"");
		 }
		 else
		{
			 input = input.replace(id+"r","");
		}
		 input = input+ ","+id;
		 //alert("input: "+input);
	 }
	 $("#inputChofer").val(input);
}

function pegarSelTrans(id)
{
	var input = $("#inputTrans").val() ;
	input = input.replace(",,",",");
	var isChecked = document.getElementById(id).checked;
	 if(!isChecked)
 	{
		 input = input.replace(id+"r","");
		 input = input.replace(id,"");
	}
	 else
	 {
		 if (id.includes("r"))
		 {
			 var split = id.split("r");
			 input = input.replace(split[0],"");
		 }
		 else
		{
			 input = input.replace(id+"r","");
		}
		 input = input+ ","+id;
	 }
	 $("#inputTrans").val(input);
}

/*function asignarDetalleRC(){
	var facturasDetalle = $("#inputChoferMarcadoDetalleRC").val();
	if(facturasDetalle != '' && facturasDetalle != ','){
		alert("facturaDetalle: "+facturasDetalle);
		//var facturasDet = facturasDetalle.split(",");
		//  alert(facturasDet.length);		  
	}
	else
	{
	   alert("Debe seleccionar un articulo de la factura.");	
	}
}
*/
function LLenarGridDetalleRC(data){
	
	db = {
		    loadData: function (filter)/** seccion de filtros **/
		    {
		    	
		    	return $.grep(data, function (egreso) {
		            return     (!filter.noIdentificacion.toUpperCase()|| egreso.noIdentificacion.toUpperCase() === filter.noIdentificacion.toUpperCase() || egreso.noIdentificacion.toUpperCase() == filter.noIdentificacion.toUpperCase() || egreso.noIdentificacion.toUpperCase().includes(filter.noIdentificacion.toUpperCase()))
		                     &&  (!filter.descUnidad.toUpperCase()|| egreso.descUnidad.toUpperCase() === filter.descUnidad.toUpperCase() || egreso.descUnidad.toUpperCase() == filter.descUnidad.toUpperCase() || egreso.descUnidad.toUpperCase().includes(filter.descUnidad.toUpperCase()))
		                     && (!filter.peso.toUpperCase()|| egreso.peso.toUpperCase() === filter.peso.toUpperCase() || egreso.peso.toUpperCase() == filter.peso.toUpperCase() || egreso.peso.toUpperCase().includes(filter.peso.toUpperCase()))
		                     &&  (!filter.cantidad.toUpperCase()|| egreso.cantidad.toUpperCase() === filter.cantidad.toUpperCase() || egreso.cantidad.toUpperCase() == filter.cantidad.toUpperCase() || egreso.cantidad.toUpperCase().includes(filter.cantidad.toUpperCase()))
		                     && (!filter.clvMaterialPeligroso.toUpperCase()|| egreso.clvMaterialPeligroso.toUpperCase() === filter.clvMaterialPeligroso.toUpperCase() || egreso.clvMaterialPeligroso.toUpperCase() == filter.clvMaterialPeligroso.toUpperCase() || egreso.clvMaterialPeligroso.toUpperCase().includes(filter.clvMaterialPeligroso.toUpperCase()));			            	    
		        });
		    	
		    },
		    insertItem: function (insertingClient) 
		    {
		    	
		    },
		    updateItem: function (IActualizado) /** actualiza registro **/
		    {
		    
		    },
		 };
 
 window.db = db;
 
 $(function() 
			{
			 $("#gridMarcadoDetalleRC").jsGrid({
	    		 width: "100%",
	             height: "700px",
	             editing: false,
	             filtering: true,
	             selecting: true,
	             sorting: true ,
	             paging: false,
	             pageSize: 800,
	             controller: 
	             {
	            	 loadData: function () 
	                 {
	                     dataType: "json"
	                     return data ;
	                 }
	             },
	             rowClass: function(item, itemIndex) 
	             {
	            	 
	             },
	             rowDoubleClick: function(args) 
	             {
	            	 
	             },
	             noDataContent: "NO HAY REGISTROS",
	             controller: db,
	             loadMessage: "Please, wait...",
	             onRefreshed: function (args) 
	             {
	            	 var filtro = $("#inputChoferMarcadoDetalleRC").val();
	            	 if (filtro != '')
	            	 {
	            		var split = filtro.split(",");
						for (var i = 0; i < split.length; i++) 
						{
							if(document.getElementById(split[i]))
							{
								document.getElementById(split[i]).checked = true;
						    }
							
						}
						
	            	 }
	             },
	             autoload: true,
	             fields: 
	             [
	            	 { name: "cnt", type: "checkbox",width: 13, title: "",visible:true, editing:false,  filtering: false,  
					     itemTemplate: function(_, item) 
					     {
					    	 return `<input class="single ${item.idDetalleRC}"  name="checksDetalle[]" id='${item.idDetalleRC}*${item.facturaTraslado}'  value=${item.idDetalleRC} onclick="pegarSelDetalleRC('${item.idDetalleRC}*${item.facturaTraslado}')" type="checkbox" style="height: 10px;width: 10px;"/>`
					     }
	               	 },
//	            	 {name: "cc",type: "select",  title: "RUTA",align: 'left', width:55,items: db.states,valueField: "Id",textField: "Name"},
	            	 { name: "noIdentificacion",  type: "text", title: "ARTICULO", width: 35, align: 'center', filtering: true ,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	            	 { name: "descUnidad",  type: "text", title: "DESCRIPCION", width: 40, align: 'center', filtering: true ,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	            	 { name: "peso",  type: "text", title: "PESO",width: 25, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	                 { name: "cantidad", type: "text", title: "CANTIDAD", width: 20, align: 'center',filtering: true,itemTemplate: function (value,item){ return estatusColorRC(value,item)}},
	            	 { name: "clvMaterialPeligroso",  type: "text", title: "CLAVE MATE.PELIGRO", width: 30, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColorRCMatPeligro(value,item)}},
	              // { name: "idTrayecto",  type: "text", title: "TRAYECTO/FOLIO", width: 30, align: 'center', filtering: true ,itemTemplate: function (value, item) { return estatusColorRC(value,item)}}, 
	             ]
	             
			    });
			 });
 
}

function LLenarGridRC(data){
	 
	 db = {
			    loadData: function (filter)/** seccion de filtros **/
			    {
			    	
			    	return $.grep(data, function (egreso) {
			            return     (!filter.ruta.toUpperCase()|| egreso.ruta.toUpperCase() === filter.ruta.toUpperCase() || egreso.ruta.toUpperCase() == filter.ruta.toUpperCase() || egreso.ruta.toUpperCase().includes(filter.ruta.toUpperCase()))
			                     &&  (!filter.descripcionTipo.toUpperCase()|| egreso.descripcionTipo.toUpperCase() === filter.descripcionTipo.toUpperCase() || egreso.descripcionTipo.toUpperCase() == filter.descripcionTipo.toUpperCase() || egreso.descripcionTipo.toUpperCase().includes(filter.descripcionTipo.toUpperCase()))
			            		 &&  (!filter.unameDestino.toUpperCase()|| egreso.unameDestino.toUpperCase() === filter.unameDestino.toUpperCase() || egreso.unameDestino.toUpperCase() == filter.unameDestino.toUpperCase() || egreso.unameDestino.toUpperCase().includes(filter.unameDestino.toUpperCase()))
			                     && (!filter.cteDestino.toUpperCase()|| egreso.cteDestino.toUpperCase() === filter.cteDestino.toUpperCase() || egreso.cteDestino.toUpperCase() == filter.cteDestino.toUpperCase() || egreso.cteDestino.toUpperCase().includes(filter.cteDestino.toUpperCase()))
			                     //&& (!filter.identificacionCDD.toUpperCase()|| egreso.identificacionCDD.toUpperCase() === filter.identificacionCDD.toUpperCase() || egreso.identificacionCDD.toUpperCase() == filter.identificacionCDD.toUpperCase() || egreso.identificacionCDD.toUpperCase().includes(filter.identificacionCDD.toUpperCase()))
			                     &&  (!filter.facturaTraslado.toUpperCase()|| egreso.facturaTraslado.toUpperCase() === filter.facturaTraslado.toUpperCase() || egreso.facturaTraslado.toUpperCase() == filter.facturaTraslado.toUpperCase() || egreso.facturaTraslado.toUpperCase().includes(filter.facturaTraslado.toUpperCase()))
			                     && (!filter.remision.toUpperCase()|| egreso.remision.toUpperCase() === filter.remision.toUpperCase() || egreso.remision.toUpperCase() == filter.remision.toUpperCase() || egreso.remision.toUpperCase().includes(filter.remision.toUpperCase()))
			                     && (!filter.numeroCaja.toUpperCase()|| egreso.numeroCaja.toUpperCase() === filter.numeroCaja.toUpperCase() || egreso.numeroCaja.toUpperCase() == filter.numeroCaja.toUpperCase() || egreso.numeroCaja.toUpperCase().includes(filter.numeroCaja.toUpperCase()))
			                     && (!filter.totalArticulos.toUpperCase()|| egreso.totalArticulos.toUpperCase() === filter.totalArticulos.toUpperCase() || egreso.totalArticulos.toUpperCase() == filter.totalArticulos.toUpperCase() || egreso.totalArticulos.toUpperCase().includes(filter.totalArticulos.toUpperCase()))
			                     &&  (!filter.fecha|| egreso.fecha === filter.fecha || egreso.fecha == filter.fecha || egreso.fecha.includes(filter.fecha))
			                     &&  (!filter.razonSocial.toUpperCase()|| egreso.razonSocial.toUpperCase() === filter.razonSocial.toUpperCase() || egreso.razonSocial.toUpperCase() == filter.razonSocial.toUpperCase() || egreso.razonSocial.toUpperCase().includes(filter.razonSocial.toUpperCase()))
			                     &&  (!filter.direccion.toUpperCase()|| egreso.direccion.toUpperCase() === filter.direccion.toUpperCase() || egreso.direccion.toUpperCase() == filter.direccion.toUpperCase() || egreso.direccion.toUpperCase().includes(filter.direccion.toUpperCase()))
			                     &&  (!filter.trasnporte.toUpperCase()|| egreso.trasnporte.toUpperCase() === filter.trasnporte.toUpperCase() || egreso.trasnporte.toUpperCase() == filter.trasnporte.toUpperCase() || egreso.trasnporte.toUpperCase().includes(filter.trasnporte.toUpperCase()))
			                     &&  (!filter.estatus.toUpperCase()|| egreso.estatus.toUpperCase() === filter.estatus.toUpperCase() || egreso.estatus.toUpperCase() == filter.estatus.toUpperCase() || egreso.estatus.toUpperCase().includes(filter.estatus.toUpperCase()))
			                     &&  (!filter.unameOrigen.toUpperCase()|| egreso.unameOrigen.toUpperCase() === filter.unameOrigen.toUpperCase() || egreso.unameOrigen.toUpperCase() == filter.unameOrigen.toUpperCase() || egreso.unameOrigen.toUpperCase().includes(filter.unameOrigen.toUpperCase()))
			                     && (!filter.idTrayecto || egreso.idTrayecto === filter.idTrayecto);
				            	    
			        });
			    	
			    },
			    insertItem: function (insertingClient) 
			    {
			    	
			    },
			    updateItem: function (IActualizado) /** actualiza registro **/
			    {
			    
			    },
			 };
	 
	 
	 
	 
	 window.db = db;
	 
	 $(function() 
			{
			 $("#dgZonasClicRC").jsGrid({
	    		 width: "99%",
	             height: "780px",
	             editing: false,
	             filtering: true,
	             selecting: true,
	             sorting: true ,
	             paging: false,
	             pageSize: 800,
	             controller: 
	             {
	            	 loadData: function () 
	                 {
	                     dataType: "json"
	                     return data ;
	                 }
	             },
	             rowClass: function(item, itemIndex) 
	             {
	            	 
	             },
	             rowDoubleClick: function(args) 
	             {
	            	 
	             },
	             noDataContent: "NO HAY REGISTROS",
	             controller: db,
	             loadMessage: "Please, wait...",
	             onRefreshed: function (args) 
	             {
	            	 var filtro = $("#inputChoferRC").val();
	            	 if (filtro != '')
	            	 {
	            		var split = filtro.split(",");
						for (var i = 0; i < split.length; i++) 
						{
							if(document.getElementById(split[i]))
							{
								document.getElementById(split[i]).checked = true;
						    }
							
						}
						
	            	 }
	             },
	             autoload: true,
	             fields: 
	             [
	            	 { name: "cnt", type: "checkbox",width: 13, title: "CTE",visible:true, editing:false,  filtering: false,  
					     itemTemplate: function(_, item) 
					     {
					    	 return `<input class="single ${item.facturaTraslado}"  name="checksRC[]" id='${item.facturaTraslado}'  value=${item.facturaTraslado},'${item.identificacionCDD}' onclick="pegarSelFact('${item.facturaTraslado}','${item.identificacionCDD}')" type="checkbox" style="height: 10px;width: 10px;"/>`
					     }
	               	 },
	               	 { name: "btnDetalleRC", type: "text", title: " ", width: 13, align: 'center', editing: false, inserting: false,  filtering: false, 
	              	   	                	 
	                	 itemTemplate: function (value, item) {
	                		 	                		 		
	                		 		 return $("<button>").attr("class", "EG_btnDetalleRC").on("click", function () {
	                		 				detalleRC(item)	                		 				                		 			 	
	                		 				return false;
	    	                             });	    
								
	                	   }
	                 },
//	            	 {name: "cc",type: "select",  title: "RUTA",align: 'left', width:55,items: db.states,valueField: "Id",textField: "Name"},
	                 { name: "ruta",  type: "text", title: "RUTA", width: 32, align: 'center', filtering: true ,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	                 { name: "descripcionTipo",  type: "text", title: "TIPO", width: 20, align: 'center', filtering: true ,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	            	 { name: "unameDestino",  type: "text", title: "UNAME DESTINO", width: 15, align: 'center', filtering: true ,css: 'EG_hide',itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	            	 { name: "identificacionCDD",  type: "text", title: "ID_CDD", width: 15, align: 'center', filtering: false ,css: 'EG_hide',itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	            	 { name: "cteDestino",  type: "text", title: "CLIENTE DESTINO",width: 18, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	                 { name: "facturaTraslado", type: "text", title: "DOCUMENTO", width: 28, align: 'center',filtering: true,itemTemplate: function (value,item){ return estatusColorRC(value,item)}},
	            	 { name: "remision",  type: "text", title: "REMISION", width: 17, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	            	 { name: "numeroCaja",  type: "text", title: "REFERENCIA", width: 25, align: 'center', filtering: true ,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	            	 { name: "totalArticulos",  type: "text", title: "TOT. ART", width: 17, align: 'center', filtering: true ,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	            	 { name: "fecha",  type: "text", title: "FECHA", width: 23, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	            	 { name: "razonSocial", type: "text", title: "RAZON SOCIAL", width:85, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	                 { name: "direccion", type: "text", title: "DIRECCION", width:85, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	                 { name: "trasnporte",  type: "text", title: "TRANSPORTE", width: 45, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColorRC(value,item)}},
	                 { name: "estatus",  type: "text", title: "ESTATUS", width: 18, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColorEstatus(value,item)}},
	                 { name: "unameOrigen",  type: "text", title: "UNAME ORIGEN", width: 13, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColorRC(value,item)}}
	               /*{ name: "btnCancelar", type: "text", title: " ", width: 12, align: 'center', editing: false, inserting: false,  filtering: false, 
	              	   
	                	 
	                	 
	                	 itemTemplate: function (value, item) {
	                		 	if (item.programada == '8') 
	                		 	{
	                		 		
	                		 		
	                		 		 return $("<button>").attr("class", "EG_btnCancela").on("click", function () {
	                		 			if (confirm('Confirme para cancelar el TRASLADO: '+item.facturaTraslado+" CLIENTE: "+item.cteDestino)) 
	                		 			{
	                		 				cancelar(item)
	                		 			}
	                		 			 	
	    	                                 return false;
	    	                             });
	    
								}
	                	   }
	                 }*/ 
	             ]
	             
			    });
			 });
}

function llenaGridCheques(data,tipo)
{

	var db;
	if (tipo == "p")
	{
		db = {
			    loadData: function (filter)/** seccion de filtros **/
			    {
			    	
			    	return $.grep(data, function (egreso) {
			            return(!filter.ode.toUpperCase()|| egreso.ode.toUpperCase() === filter.ode.toUpperCase() || egreso.ode.toUpperCase() == filter.ode.toUpperCase() || egreso.ode.toUpperCase().includes(filter.ode.toUpperCase()))
	                     &&  (!filter.ods.toUpperCase()|| egreso.ods.toUpperCase() === filter.ods.toUpperCase() || egreso.ods.toUpperCase() == filter.ods.toUpperCase() || egreso.ods.toUpperCase().includes(filter.ods.toUpperCase()))
	                     && (!filter.pedido.toUpperCase()|| egreso.pedido.toUpperCase() === filter.pedido.toUpperCase() || egreso.pedido.toUpperCase() == filter.pedido.toUpperCase() || egreso.pedido.toUpperCase().includes(filter.pedido.toUpperCase()))
			                     && (!filter.cte.toUpperCase()|| egreso.cte.toUpperCase() === filter.cte.toUpperCase() || egreso.cte.toUpperCase() == filter.cte.toUpperCase() || egreso.cte.toUpperCase().includes(filter.cte.toUpperCase()))
			                     &&  (!filter.consignatario|| egreso.consignatario === filter.consignatario || egreso.consignatario == filter.consignatario || egreso.consignatario.includes(filter.consignatario))
			                     &&  (!filter.direccion.toUpperCase()|| egreso.direccion.toUpperCase() === filter.direccion.toUpperCase() || egreso.direccion.toUpperCase() == filter.direccion.toUpperCase() || egreso.direccion.toUpperCase().includes(filter.direccion.toUpperCase()))
			                     &&  (!filter.nombre_razon_social.toUpperCase()|| egreso.nombre_razon_social.toUpperCase() === filter.nombre_razon_social.toUpperCase() || egreso.nombre_razon_social.toUpperCase() == filter.nombre_razon_social.toUpperCase() || egreso.nombre_razon_social.toUpperCase().includes(filter.nombre_razon_social.toUpperCase()))
			                     &&  (!filter.transporte.toUpperCase()|| egreso.transporte.toUpperCase() === filter.transporte.toUpperCase() || egreso.transporte.toUpperCase() == filter.transporte.toUpperCase() || egreso.transporte.toUpperCase().includes(filter.transporte.toUpperCase()))
			                     &&  (!filter.fecha_factura.toUpperCase()|| egreso.fecha_factura.toUpperCase() === filter.fecha_factura.toUpperCase() || egreso.fecha_factura.toUpperCase() == filter.fecha_factura.toUpperCase() || egreso.fecha_factura.toUpperCase().includes(filter.fecha_factura.toUpperCase()))
			                     &&  (!filter.fecha_ods.toUpperCase()|| egreso.fecha_ods.toUpperCase() === filter.fecha_ods.toUpperCase() || egreso.fecha_ods.toUpperCase() == filter.fecha_ods.toUpperCase() || egreso.fecha_ods.toUpperCase().includes(filter.fecha_ods.toUpperCase()))
			                     && (!filter.cc || egreso.cc === filter.cc);
				            	    
			        });
			    	
			    },
			    insertItem: function (insertingClient) 
			    {
			    	
			    },
			    updateItem: function (IActualizado) /** actualiza registro **/
			    {
			    
			    },
			 };
	}
	else
		{
		
		
	db = {
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	
	    	return $.grep(data, function (egreso) {
	            return     (!filter.ode.toUpperCase()|| egreso.ode.toUpperCase() === filter.ode.toUpperCase() || egreso.ode.toUpperCase() == filter.ode.toUpperCase() || egreso.ode.toUpperCase().includes(filter.ode.toUpperCase()))
	                     &&  (!filter.ods.toUpperCase()|| egreso.ods.toUpperCase() === filter.ods.toUpperCase() || egreso.ods.toUpperCase() == filter.ods.toUpperCase() || egreso.ods.toUpperCase().includes(filter.ods.toUpperCase()))
	                     && (!filter.pedido.toUpperCase()|| egreso.pedido.toUpperCase() === filter.pedido.toUpperCase() || egreso.pedido.toUpperCase() == filter.pedido.toUpperCase() || egreso.pedido.toUpperCase().includes(filter.pedido.toUpperCase()))
	                     &&  (!filter.factura.toUpperCase()|| egreso.factura.toUpperCase() === filter.factura.toUpperCase() || egreso.factura.toUpperCase() == filter.factura.toUpperCase() || egreso.factura.toUpperCase().includes(filter.factura.toUpperCase()))
	                     && (!filter.cte.toUpperCase()|| egreso.cte.toUpperCase() === filter.cte.toUpperCase() || egreso.cte.toUpperCase() == filter.cte.toUpperCase() || egreso.cte.toUpperCase().includes(filter.cte.toUpperCase()))
	                     &&  (!filter.consignatario|| egreso.consignatario === filter.consignatario || egreso.consignatario == filter.consignatario || egreso.consignatario.includes(filter.consignatario))
	                     &&  (!filter.direccion.toUpperCase()|| egreso.direccion.toUpperCase() === filter.direccion.toUpperCase() || egreso.direccion.toUpperCase() == filter.direccion.toUpperCase() || egreso.direccion.toUpperCase().includes(filter.direccion.toUpperCase()))
	                     &&  (!filter.nombre_razon_social.toUpperCase()|| egreso.nombre_razon_social.toUpperCase() === filter.nombre_razon_social.toUpperCase() || egreso.nombre_razon_social.toUpperCase() == filter.nombre_razon_social.toUpperCase() || egreso.nombre_razon_social.toUpperCase().includes(filter.nombre_razon_social.toUpperCase()))
	                     &&  (!filter.transporte.toUpperCase()|| egreso.transporte.toUpperCase() === filter.transporte.toUpperCase() || egreso.transporte.toUpperCase() == filter.transporte.toUpperCase() || egreso.transporte.toUpperCase().includes(filter.transporte.toUpperCase()))
	                     &&  (!filter.fecha_factura.toUpperCase()|| egreso.fecha_factura.toUpperCase() === filter.fecha_factura.toUpperCase() || egreso.fecha_factura.toUpperCase() == filter.fecha_factura.toUpperCase() || egreso.fecha_factura.toUpperCase().includes(filter.fecha_factura.toUpperCase()))
	                     &&  (!filter.fecha_ods.toUpperCase()|| egreso.fecha_ods.toUpperCase() === filter.fecha_ods.toUpperCase() || egreso.fecha_ods.toUpperCase() == filter.fecha_ods.toUpperCase() || egreso.fecha_ods.toUpperCase().includes(filter.fecha_ods.toUpperCase()))
	                     && (!filter.cc || egreso.cc === filter.cc);
		            	    
	        });
	    	
	    },
	    insertItem: function (insertingClient) 
	    {
	    	
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {
	    
	    },
	 };
		}
	window.db = db;
	

	var n = $("#rutasSesion").val().replace(/[*]/g,"\"")
	//alert("n: "+n);
	var ar = []
	ar.push({ Id: 0, Name: ""})
		jQuery.each(JSON.parse(n), function(index, item) 
	   {
			ar.push({ Id: item.num_ruta, Name: ""+item.descripcion+""})
	   });
	  db.states = ar; 
	  db.data;
    $(function ()
    	     {
    	    	 $("#dgZonasClic").jsGrid({
    	    		 width: "99%",
    	             height: "780px",
    	             editing: false,
    	             filtering: true,
    	             selecting: true,
    	             sorting: true ,
    	             paging: false,
    	             pageSize: 800,
    	             controller: 
    	             {
    	            	 
    	                 loadData: function () 
    	                 {
    	                     dataType: "json"
    	                     return data ;
    	                 }
    	             },
    	             rowClass: function(item, itemIndex) 
    	             { 
    	            	if (tipo == "p")
    	            	{
    	            		if(item.repeticion == "s")
    	            		{
    	            			return "ocultar";
//    	            			return "bg-red";
    	            		}
						}
//    	            	if (item.uname_entrega != "n")
//    	                {
//    	            		
//    	        	    	if (item.uname_entrega == item.uname_br_entrega)
//    	        	    	{
//    	        	    		return "bg-1";	
//    	        			}
//    	        	    	else if(item.uname_entrega == '')
//    	        	    		{
//    	        	    		return "bg-2";
//    	        	    		}
//    	        	    	else
//    	        			{
//    	        	    		return "bg-3";
//    	        			}
//    	                }
//    	            	else if(item.id_estatus == 8)
//    	            		{
//    	            		return "bg-4";
//    	            		}
    	            	
    	            	
    	            	
    	             },
    	             
    	             rowDoubleClick: function(args) 
    	             {
    	            	 var item = args.item;
    	            	 var keys = Object.keys(item);
    	            	 
    	            	 if($("#"+item.no+"").is(':checked'))
    	            	 {  
	            			  $("."+item.ode+"").each(function(index) 
	            			  {
	            				  $("#"+$(this).attr('id')+"").prop("checked", false); 
	            				   pegarSel($(this).attr('id'));
	            			  });
    	                 }
    	            	 else
    	            	{
    	            		 var isChecked = document.getElementById(item.no+"r").checked;
    	            		 if(isChecked)
    	         	    	{
    	            			 $("."+item.ode+"").each(function(index) 
    	            			  {
    	            			      document.getElementById($(this).attr('id')+"r").checked = false;
    	            			      pegarSel($(this).attr('id'));
    	            			  });
    	            			 
    	            			 document.getElementById(item.no).checked = true;
    	            			 $("."+item.ode+"").each(function(index) 
		            			  {
    	            				  document.getElementById($(this).attr('id')).checked = true;
    	            				  pegarSel($(this).attr('id'));
		            			  });
    	         	    	}
    	            		 else
    	            		{
    	            			 $("."+item.ode+"").prop("checked", true);
    	            			  $("."+item.ode+"").each(function(index) 
    	            			  {
    	            			      pegarSel($(this).attr('id'));
    	            			  });

    	            		} 
    	            	}
    	             },
    	             noDataContent: "NO HAY REGISTROS",
    	             controller: db,
    	             loadMessage: "Please, wait...",
    	             onRefreshed: function (args) 
    	             { 
    	            	 var filtro = $("#inputChofer").val();
    	            	 if (filtro != '')
    	            	 {
    	            		var split = filtro.split(",");
							for (var i = 0; i < split.length; i++) 
							{
								if(document.getElementById(split[i]))
								{
									document.getElementById(split[i]).checked = true;
							    }
								
							}
							
    	            	 }
    	            	 
    	            },
    	             autoload: true,
    	             fields: 
    	             [
    	               	 { name: "cnt", type: "checkbox",width: 13, title: "CTE",visible:true, editing:false,  filtering: false,  
						     itemTemplate: function(_, item) 
						     {
						    	 		return `<input class="single ${item.ode}"  name="checks[]" id='${item.no}'  value=${item.pedido}*${item.ode} onclick="s();pegarSelOde('${item.ode}','${item.no}')" type="checkbox" style="height: 10px;width: 10px;"/><input class="single " id='${item.factura_larga}'  value=${item.ode}*${item.no}  type="hidden" style="height: 10px;width: 10px;"/>`
						     }
    	               	 },
    	               	{ name: "cnt", type: "checkbox",width: 13, title: "REG",visible:true, editing:false,  filtering: false,  
						     itemTemplate: function(_, item) 
						     {
						    	 		return `<input class="single ${item.oder}"  name="checksR[]" id='${item.nor}'  value=${item.pedido}*${item.ode} onclick="pegarSelOdeR('${item.oder}','${item.nor}')" type="checkbox" style="height: 10px;width: 10px;"/>`
						     }
    	               	 },
    	               	
//    	            	 { name: "ruta", type: "text", title: "RUTA", width:55, align: 'left',filtering: true,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	            	 {name: "cc",type: "select",  title: "RUTA",align: 'left', width:55,items: db.states,valueField: "Id",textField: "Name"},
    	            	 { name: "cte",  type: "text", title: "CTE", width: 17, align: 'center', filtering: true ,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	            	 { name: "pedido",  type: "text", title: "PEDIDO", width: 20, align: 'center', filtering: true ,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	            	 { name: "ods",  type: "text", title: "ODS",width: 15, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	                 { name: "ode",  type: "text", title: "ODE", width: 15, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	                 { name: "factura",  type: "text", title: "FACTURA", width: 15, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	            	 { name: "fecha_ods", type: "text", title: "FECHA PEDIDO", width:33, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	                 { name: "fecha_factura", type: "text", title: "FECHA FACTURA", width:33, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	                 { name: "consignatario",  type: "text", title: "CONSIG", width: 20, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	                 { name: "direccion",  type: "text", title: "DIRECCION", width: 65, align: 'left', filtering: true,itemTemplate: function (value, item) { return toltipDireccion(value,item)}},
    	                 { name: "nombre_razon_social",  type: "text", title: "RAZON SOCIAL", width: 65, align: 'left', filtering: true,itemTemplate: function (value, item) { return toltipDireccion(value,item)}},
    	                 { name: "transporte",  type: "text", title: "TRANSPORTE", width: 50, align: 'left', filtering: true ,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	                 { name: "btnCancelar", type: "text", title: " ", width: 12, align: 'center', editing: false, inserting: false,  filtering: false, 
            	   
    	                	 
    	                	 
    	                	 itemTemplate: function (value, item) {
    	                		 	if (item.uname_entrega !='n' || item.id_estatus == '8') 
    	                		 	{
    	                		 		
    	                		 		
    	                		 		 return $("<button>").attr("class", "EG_btnCancela").on("click", function () {
    	                		 			if (confirm('Confirme para cancelar el PEDIDO: '+item.pedido+" ODE: "+item.ode+" ODS: "+item.ods+" CLIENTE: "+item.cte)) 
    	                		 			{
    	                		 				cancelar(item)
    	                		 			}
    	                		 			 	
    	    	                                 return false;
    	    	                             });
    	    
									}
    	                	   }
    	                 }
    	               
    	             ],
	                 
	        	 });
	         });
    if (tipo == 'p') 
    {
    	$("#dgZonasClic").jsGrid("fieldOption", "factura", "visible", false);
	}
    
}

function borrarFiltradoRC(){
	asignarRC()
}

function borrarFiltrado()
{
	 asignar()
//	(function () {
//
//		  console.log('this is the start');
//		  setTimeout(function cb() {
//			  document.getElementById('cargando').style.display = 'block';
////		    console.log('this is a msg from call back');
//		    
//		  });
//
//		  console.log('this is just a message');
//
//		  setTimeout(function cb1() {
//			  $("#dgZonasClic").jsGrid("clearFilter").done(function() {
////					console.log("filtro complet")
//				});
//		  }, 2000);
//
//		  setTimeout(function cb2() {
//			  document.getElementById('cargando').style.display = 'none';
//			  asignar()
//		  }, 5000);
//		  
//		  console.log('this is the  end');
//
//		})();
//	

	
}

	

function borrarFiltradoTrans()
{

	  asignarTrans()
//	(function () {
//
//		  console.log('this is the start');
//		  setTimeout(function cb() {
//			  document.getElementById('cargando').style.display = 'block';
////		    console.log('this is a msg from call back');
//		    
//		  });
//
//		  console.log('this is just a message');
//
//		  setTimeout(function cb1() {
//			  $("#dgZonasClicTrans").jsGrid("clearFilter").done(function() {
////					console.log("filtro complet")
//				});
//		  }, 2000);
//
//		  setTimeout(function cb2() {
//			  document.getElementById('cargando').style.display = 'none';
//			  asignarTrans()
//		  }, 5000);
//		  
//		  console.log('this is the  end');
//
//		})();
//	

	
}

	

function llenaGridChequesTrans(data,tipo)
{

	
	
	
	var db;
	if (tipo == "p")
	{
		db = {
			    loadData: function (filter)/** seccion de filtros **/
			    {
			    	
			    	return $.grep(data, function (egreso) {
			            return (!filter.ode.toUpperCase()|| egreso.ode.toUpperCase() === filter.ode.toUpperCase() || egreso.ode.toUpperCase() == filter.ode.toUpperCase() || egreso.ode.toUpperCase().includes(filter.ode.toUpperCase()))
		                &&  (!filter.ods.toUpperCase()|| egreso.ods.toUpperCase() === filter.ods.toUpperCase() || egreso.ods.toUpperCase() == filter.ods.toUpperCase() || egreso.ods.toUpperCase().includes(filter.ods.toUpperCase()))
		                && (!filter.pedido.toUpperCase()|| egreso.pedido.toUpperCase() === filter.pedido.toUpperCase() || egreso.pedido.toUpperCase() == filter.pedido.toUpperCase() || egreso.pedido.toUpperCase().includes(filter.pedido.toUpperCase()))
			                     && (!filter.cte.toUpperCase()|| egreso.cte.toUpperCase() === filter.cte.toUpperCase() || egreso.cte.toUpperCase() == filter.cte.toUpperCase() || egreso.cte.toUpperCase().includes(filter.cte.toUpperCase()))
			                     &&  (!filter.consignatario|| egreso.consignatario === filter.consignatario || egreso.consignatario == filter.consignatario || egreso.consignatario.includes(filter.consignatario))
			                     &&  (!filter.direccion.toUpperCase()|| egreso.direccion.toUpperCase() === filter.direccion.toUpperCase() || egreso.direccion.toUpperCase() == filter.direccion.toUpperCase() || egreso.direccion.toUpperCase().includes(filter.direccion.toUpperCase()))
			                     &&  (!filter.nombre_razon_social.toUpperCase()|| egreso.nombre_razon_social.toUpperCase() === filter.nombre_razon_social.toUpperCase() || egreso.nombre_razon_social.toUpperCase() == filter.nombre_razon_social.toUpperCase() || egreso.nombre_razon_social.toUpperCase().includes(filter.nombre_razon_social.toUpperCase()))
			                     &&  (!filter.transporte.toUpperCase()|| egreso.transporte.toUpperCase() === filter.transporte.toUpperCase() || egreso.transporte.toUpperCase() == filter.transporte.toUpperCase() || egreso.transporte.toUpperCase().includes(filter.transporte.toUpperCase()))
			                     &&  (!filter.fecha_factura.toUpperCase()|| egreso.fecha_factura.toUpperCase() === filter.fecha_factura.toUpperCase() || egreso.fecha_factura.toUpperCase() == filter.fecha_factura.toUpperCase() || egreso.fecha_factura.toUpperCase().includes(filter.fecha_factura.toUpperCase()))
			                     &&  (!filter.fecha_ods.toUpperCase()|| egreso.fecha_ods.toUpperCase() === filter.fecha_ods.toUpperCase() || egreso.fecha_ods.toUpperCase() == filter.fecha_ods.toUpperCase() || egreso.fecha_ods.toUpperCase().includes(filter.fecha_ods.toUpperCase()))
			                     && (!filter.cc || egreso.cc === filter.cc);
				            	    
			        });
			    	
			    },
			    insertItem: function (insertingClient) 
			    {
			    	
			    },
			    updateItem: function (IActualizado) /** actualiza registro **/
			    {
			    
			    },
			 };
	}
	else
		{
		
		
	db = {
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	
	    	return $.grep(data, function (egreso) {
	            return (!filter.ode.toUpperCase()|| egreso.ode.toUpperCase() === filter.ode.toUpperCase() || egreso.ode.toUpperCase() == filter.ode.toUpperCase() || egreso.ode.toUpperCase().includes(filter.ode.toUpperCase()))
                &&  (!filter.ods.toUpperCase()|| egreso.ods.toUpperCase() === filter.ods.toUpperCase() || egreso.ods.toUpperCase() == filter.ods.toUpperCase() || egreso.ods.toUpperCase().includes(filter.ods.toUpperCase()))
                && (!filter.pedido.toUpperCase()|| egreso.pedido.toUpperCase() === filter.pedido.toUpperCase() || egreso.pedido.toUpperCase() == filter.pedido.toUpperCase() || egreso.pedido.toUpperCase().includes(filter.pedido.toUpperCase()))
	                     && (!filter.cte.toUpperCase()|| egreso.cte.toUpperCase() === filter.cte.toUpperCase() || egreso.cte.toUpperCase() == filter.cte.toUpperCase() || egreso.cte.toUpperCase().includes(filter.cte.toUpperCase()))
	                     &&  (!filter.factura.toUpperCase()|| egreso.factura.toUpperCase() === filter.factura.toUpperCase() || egreso.factura.toUpperCase() == filter.factura.toUpperCase() || egreso.factura.toUpperCase().includes(filter.factura.toUpperCase()))
	                     &&  (!filter.consignatario|| egreso.consignatario === filter.consignatario || egreso.consignatario == filter.consignatario || egreso.consignatario.includes(filter.consignatario))
	                     &&  (!filter.direccion.toUpperCase()|| egreso.direccion.toUpperCase() === filter.direccion.toUpperCase() || egreso.direccion.toUpperCase() == filter.direccion.toUpperCase() || egreso.direccion.toUpperCase().includes(filter.direccion.toUpperCase()))
	                     &&  (!filter.nombre_razon_social.toUpperCase()|| egreso.nombre_razon_social.toUpperCase() === filter.nombre_razon_social.toUpperCase() || egreso.nombre_razon_social.toUpperCase() == filter.nombre_razon_social.toUpperCase() || egreso.nombre_razon_social.toUpperCase().includes(filter.nombre_razon_social.toUpperCase()))
	                     &&  (!filter.transporte.toUpperCase()|| egreso.transporte.toUpperCase() === filter.transporte.toUpperCase() || egreso.transporte.toUpperCase() == filter.transporte.toUpperCase() || egreso.transporte.toUpperCase().includes(filter.transporte.toUpperCase()))
	                     &&  (!filter.fecha_factura.toUpperCase()|| egreso.fecha_factura.toUpperCase() === filter.fecha_factura.toUpperCase() || egreso.fecha_factura.toUpperCase() == filter.fecha_factura.toUpperCase() || egreso.fecha_factura.toUpperCase().includes(filter.fecha_factura.toUpperCase()))
	                     &&  (!filter.fecha_ods.toUpperCase()|| egreso.fecha_ods.toUpperCase() === filter.fecha_ods.toUpperCase() || egreso.fecha_ods.toUpperCase() == filter.fecha_ods.toUpperCase() || egreso.fecha_ods.toUpperCase().includes(filter.fecha_ods.toUpperCase()))
	                     && (!filter.cc || egreso.cc === filter.cc);
		            	    
	        });
	    	
	    },
	    insertItem: function (insertingClient) 
	    {
	    	
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {
	    
	    },
	 };
	
	
		}	
	
	
	
	
	
	
	window.db = db;
	
	
	var n = $("#rutasSesion").val().replace(/[*]/g,"\"")
	var ar = []
	ar.push({ Id: 0, Name: ""})
		jQuery.each(JSON.parse(n), function(index, item) 
	   {
			ar.push({ Id: item.num_ruta, Name: ""+item.descripcion+""})
	   });
	  db.states = ar; 
	
	
	
	
	
    db.data;
    
	 $(function ()
    	     {
    	    	 $("#dgZonasClicTrans").jsGrid({
    	    		 width: "99%",
    	    		 height: "780px",
    	             editing: false,
    	             filtering: true,
    	             selecting: true,
    	             sorting: true ,
    	             paging: false,
    	             pageSize: 800,
    	             controller: 
    	             {
    	                 loadData: function () 
    	                 {
    	                     dataType: "json"
    	                     return data ;
    	                 }
    	             },
    	             rowClass: function(item, itemIndex) 
    	             { 
     	            	if (tipo == "p")
    	            	{
    	            		if(item.repeticion == "s")
    	            		{
    	            			return "ocultar";
    	            		}
						}
    	             },

    	             rowDoubleClick: function(args) 
    	             {
    	            	 var item = args.item;
    	            	 var keys = Object.keys(item);
    	            	 
    	            	 if($("#"+item.no+"").is(':checked'))
    	            	 {  
	            			  $("."+item.ode+"").each(function(index) 
	            			  {
	            				  $("#"+$(this).attr('id')+"").prop("checked", false); 
	            				   pegarSelTrans($(this).attr('id'));
	            			  });
    	                 }
    	            	 else
    	            	{
    	            		 var isChecked = document.getElementById(item.no+"r").checked;
    	            		 if(isChecked)
    	         	    	{
    	            			 $("."+item.ode+"").each(function(index) 
    	            			  {
    	            			      document.getElementById($(this).attr('id')+"r").checked = false;
    	            			      pegarSelTrans($(this).attr('id'));
    	            			  });
    	            			 
    	            			 document.getElementById(item.no).checked = true;
    	            			 $("."+item.ode+"").each(function(index) 
		            			  {
    	            				  document.getElementById($(this).attr('id')).checked = true;
    	            				  pegarSelTrans($(this).attr('id'));
		            			  });
    	         	    	}
    	            		 else
    	            		{
    	            			 $("."+item.ode+"").prop("checked", true);
    	            			  $("."+item.ode+"").each(function(index) 
    	            			  {
    	            			      pegarSelTrans($(this).attr('id'));
    	            			  });

    	            		} 
    	            	}
    	             },
    	             noDataContent: "NO HAY REGISTROS",
    	             controller: db,
    	             onRefreshed: function (args) 
    	             { 
    	            	 var filtro = $("#inputTrans").val();
    	            	 if (filtro != '')
    	            	 {
    	            		var split = filtro.split(",");
							for (var i = 0; i < split.length; i++) 
							{
								if(document.getElementById(split[i]))
								{
									document.getElementById(split[i]).checked = true;
							    }
								
							}
							
    	            	 }
    	            	 
    	            },
    	             autoload: true,
    	             fields: 
    	             [
    	               	 { name: "cnt", type: "checkbox",width: 13, title: "CTE",visible:true, editing:false,  filtering: false,  
						     itemTemplate: function(_, item) 
						     {
						    		return `<input class="single ${item.ode}"  name="checksTrans[]" id='${item.no}' value=${item.pedido}*${item.ode} onclick="sTrans();pegarSelOdeTrans('${item.ode}','${item.no}')" type="checkbox" style="height: 10px;width: 10px;"/><input class="single " id='${item.factura_larga}'  value=${item.ode}*${item.no}  type="hidden" style="height: 10px;width: 10px;"/>`
						   	 }
    	            	 },
    	            	 { name: "cnt", type: "checkbox",width: 13, title: "REG",visible:true, editing:false,  filtering: false,  
						     itemTemplate: function(_, item) 
						     { 
						    	 		return `<input class="single ${item.oder}"  name="checksTransR[]" id='${item.nor}' value=${item.pedido}*${item.ode} onclick="pegarSelOdeRTrans('${item.oder}','${item.nor}')" type="checkbox" style="height: 10px;width: 10px;"/>`
						     }
    	               	 },
    	               	{name: "cc",type: "select",  title: "RUTA",align: 'left', width:55,items: db.states,valueField: "Id",textField: "Name"},
    	            	 { name: "cte",  type: "text", title: "CTE", width: 17, align: 'center', filtering: true },
    	            	 { name: "pedido",  type: "text", title: "PEDIDO", width: 20, align: 'center', filtering: true },
    	            	 { name: "ods",  type: "text", title: "ODS",width: 15, align: 'center', filtering: true},
    	                 { name: "ode",  type: "text", title: "ODE", width: 15, align: 'center', filtering: true},
    	                 { name: "factura",  type: "text", title: "FACTURA", width: 15, align: 'center', filtering: true,itemTemplate: function (value, item) { return value}},
    	            	 { name: "fecha_ods", type: "text", title: "FECHA PEDIDO", width:33, align: 'center', filtering: true},
    	                 { name: "fecha_factura", type: "text", title: "FECHA FACTURA", width:33, align: 'center', filtering: true},
    	                 { name: "consignatario",  type: "text", title: "CONSIG", width: 20, align: 'center', filtering: true},
    	                 { name: "direccion",  type: "text", title: "DIRECCION", width: 65, align: 'left', filtering: true,itemTemplate: function (value, item) { var valor = value.substring(0,37); return $("<div>").attr("style", "font-size: 10px;").prop("title", value).text(valor)}},
    	                 { name: "nombre_razon_social",  type: "text", title: "RAZON SOCIAL", width: 65, align: 'left', filtering: true,itemTemplate: function (value, item) {var valor = value.substring(0,37); return $("<div>").attr("style", "font-size: 10px;").prop("title", value).text(valor);	}},
    	                 { name: "transporte",  type: "text", title: "TRANSPORTE", width: 50, align: 'left', filtering: true ,itemTemplate: function (value, item) { return $("<div>").attr("style", "font-size: 10px;").text(value)}}

    	                
    	             ],
	                 
	        	 });
	         });
	   if (tipo == 'p') 
	    {
	    	$("#dgZonasClicTrans").jsGrid("fieldOption", "factura", "visible", false);
		}
}










function sMarcado()
{

 
//	    var arr = $('[name="checksMarcado[]"]:checked').map(function(){
//	    	let spt = $('#'+this.id+'').attr('class').split(' ').join('.');
//	    	spt = spt.split('.');
//	    	var isChecked = document.getElementById(this.id+"r").checked;
//	    	if(isChecked)
//	    	{
//	    		$("."+spt[1]+"").each(function(index) 
//				{
//				   document.getElementById($(this).attr('id')+"r").checked = false;
//				});
//	    		return this.id;
//	    	}
//	    	else
//    		{
//	    		$("."+spt[1]+"").each(function(index) 
//				{
//				   document.getElementById($(this).attr('id')+"r").checked = false;
//				});
//	    		return this.id;
//    		}
//	      
//	      
//	    }).get();
//	    
//	    var str = arr.join(',');
//	    return str;
//	    
	    

}



function s()
{
	    var arr = $('[name="checks[]"]:checked').map(function(){
	    	let spt = $('#'+this.id+'').attr('class').split(' ').join('.');
	    	spt = spt.split('.');
	    	var isChecked = document.getElementById(this.id+"r").checked;
	    	if(isChecked)
	    	{
	    		$("."+spt[1]+"").each(function(index) 
				{
				   document.getElementById($(this).attr('id')+"r").checked = false;
				});
	    		return this.id;
	    	}
	    	else
    		{
	    		$("."+spt[1]+"").each(function(index) 
				{
				   document.getElementById($(this).attr('id')+"r").checked = false;
				});
	    		return this.id;
    		}	      
	    }).get();
	    
	    var str = arr.join(',');
	    return str;

}


function sR()
{	
	 var cte = $('[name="checksR[]"]:checked').map(function()
			 {
		 var split = this.id.split("*");
	    	let spt = $('#'+split[0]+'').attr('class').split(' ').join('.');
	    	spt = spt.split('.');
		 var isChecked = document.getElementById(split[0]).checked;
	    	if(isChecked)
	    	{
	    		return this.id;
	    	}
	    }).get();
	 	var str = cte.join(',');
	    return str;
	 
}


function sRC(){
	var cte = $('[name="checksRC[]"]:checked').map(function()
			 {
		 var split = this.id;
		    if(!split.includes(".")){
		    	let spt = $('#'+split+'').attr('class').split(' ').join('.');
		    	spt = spt.split('.');
		    }
	    	
		 var isChecked = document.getElementById(split).checked;
		 	if(isChecked)
	    	{
	    		return this.id;
	    	}
	    }).get();
		//console.log("cte: " + cte)
	 	var str = cte.join(',');
	    return str;	
}


function sTrans()
{

 
	 var arr = $('[name="checksTrans[]"]:checked').map(function(){
	    	
		 let spt = $('#'+this.id+'').attr('class').split(' ').join('.');
	    	spt = spt.split('.');
	    	var isChecked = document.getElementById(this.id+"r").checked;
	    	if(isChecked)
	    	{
	    		$("."+spt[1]+"").each(function(index) 
				{
				   document.getElementById($(this).attr('id')+"r").checked = false;
				});
	    		return this.id;
	    	}
	    	else
 		{
	    		$("."+spt[1]+"").each(function(index) 
				{
				   document.getElementById($(this).attr('id')+"r").checked = false;
				});
	    		return this.id;
 		}
	      
	      
	    }).get();
	    
	    var str = arr.join(',');
	    return str;
}




function sTransR()
{
	
	 var cte = $('[name="checksTransR[]"]:checked').map(function()
			 {
		 	

		 var split = this.id.split("*");
	    	let spt = $('#'+split[0]+'').attr('class').split(' ').join('.');
	    	spt = spt.split('.');
		 var isChecked = document.getElementById(split[0]).checked;
	    	if(isChecked)
	    	{

	    		return this.id;
	    	}
	    }).get();
	 	var str = cte.join(',');
	    return str;
	 
}

function sCredito()
{

 var selec = 0;
	
	    var arr = $('[name="checksCredito[]"]:checked').map(function(){
	    	selec = parseInt(selec)+1;
	    	return this.id;
	    }).get();
	    
	    var str = arr.join(',');
	    $("#totalFacturasSeleccionadas").text(" "+selec)
	    return str;
	    

}



function sReimpresion()
{

 
	    var arr = $('[name="checksReimpresion[]"]:checked').map(function(){
	      return this.value;
	    }).get();
	    
	    var str = arr.join(',');
	    return str;
	    

}



function obtenerChecksSeleccionadosOdes()
{

	let arreglo = '';
    var arr = $('[name="checks[]"]:checked').map(function(){
    	var valor = this.value.split("*")
    	if (arreglo.includes(valor[1])) 
    		{
    			
			}
    		else
    			{
    			arreglo = arreglo + ","+valor[1]
    			return valor[1];
    			}
	    }).get();
	    
	    var str = arr.join(',');
		let arreglor = '';
	    var arrR = $('[name="checksR[]"]:checked').map(function(){
	    	var valor = this.value.split("*")
	    	
	    	if (arreglor.includes(valor[1])) 
    		{
    			
			}
    		else
    			{
    			arreglor = arreglor + ","+valor[1]
    			return valor[1];
    			}
	    	
		    }).get();
		    
		    var strR = arrR.join(',');
	    
		    if (strR != '' && str != '' ) 
		    {
		    	return str+','+strR;
			}
		  
		    if (strR != '' && str == '' ) 
		    {
		    	return strR;
			}
		    
		    if (strR == '' && str != '' ) 
		    {
		    	return str;
			}
		    
	    return str;
	    

}

function obtenerChecksSeleccionadosDetalleRC()
{
	let arreglo = '';
	var arr = $('[name="checksDetalle[]"]:checked').map(function(){
		//alert("chk Sel: "+arr.length);
		var valor = this.value;
		//alert("valorChSel "+valor);
		//alert("val0 "+valor[0]);
			//if(arreglo.includes(valor[0]))
			//{
				
			//}else{
				arreglo = arreglo + ","+valor
				return valor;
			//}
		}).get();
		var str = arr.join(',');
		if(str != ''){
			return str;
		}
}

function obtenerChecksSeleccionadosRC(){
	//alert("Entra a checkSeleccionadoRC");
	let arreglo = '';
	var idCd = "";
	//console.log("..1")
		var arr = $('[name="checksRC[]"]:checked').map(function(){
			//alert("chk Sel: "+arr.length);
			var valor = this.value;
			var valorSel = valor.split(",")
			var Fact = valorSel[0]
			var idCDD = valorSel[1]
			//console.log("..2")
			 
				idCDD = idCDD.replace("'","")
				idCDD = idCDD.replace("'","")
				//console.log("idCDD2: " + idCDD)
					var unaOri = $("#unameOrigen").val();
					//console.log("unaOri: " + unaOri)
					
					switch(unaOri){
						case "CDO CDMX":
							valId = 7;
						break;
						case "CDO PUEBLA 2000":
							valId = 8;
						break;
						case "CDO LEON":
							valId = 4;
						break;
					}
//					console.log("valId: "+Number(valId))
//					console.log("idCDD: " + Number(idCDD))
					if(Number(valId) != Number(idCDD)){
						//console.log("Entra")
						if(Number(idCDD) == 8){
							$("#cdoOrigPue").css('display','block')
							$("#cdoOrigLeo").css('display','none')
							$("#cdoOrigCDMX").css('display','none')
							$("#cdoSelectPue").val("cd2-8");
						}else if(Number(idCDD) == 4){
							$("#cdoOrigLeo").css('display','block')
							$("#cdoOrigPue").css('display','none')
							$("#cdoOrigCDMX").css('display','none')
							$("#cdoSelectLeo").val("cdl-4");
						}else if(Number(idCDD) == 7){
							$("#cdoOrigCDMX").css('display','block')
							$("#cdoOrigLeo").css('display','none')
							$("#cdoOrigPue").css('display','none')
							$("#cdoSelectCDX").val("cdf-7");
						}
						
					}else{
						//console.log("No entra")
					}
					
					arreglo = arreglo + ","+valor
					//console.log("Fact/idCDD: "+Fact+"/"+idCDD)
					return Fact;
				//}
			}).get();
			
			var str = arr.join(',');
			if(str != ''){
				return str;
			}
}


function obtenerChecksSeleccionados()
{
let arreglo = '';
    var arr = $('[name="checks[]"]:checked').map(function(){
    	var valor = this.value.split("*")
    	//alert("valorChkSel "+valor);
    	//alert("val0 "+valor[0]);
    		if (arreglo.includes(valor[0])) 
    		{
    			
			}
    		else
    			{
    			arreglo = arreglo + ","+valor[0]
    			return valor[0];
    			}
	      
	    }).get();
	   
	    var str = arr.join(',');
	    
	    let arreglor = '';
	    var arrR = $('[name="checksR[]"]:checked').map(function(){
	    	var valor = this.value.split("*")
	    	if (arreglor.includes(valor[0])) 
    		{
    			
			}
    		else
    			{
    			arreglor = arreglor + ","+valor[0]
    			return valor[0];
    			}
	      
		    }).get();
		    var strR = arrR.join(',');
	    if (strR != '' && str != '' ) 
	    {
	    	return str+','+strR;
		}
	  
	    if (strR != '' && str == '' ) 
	    {
	    	return strR;
		}
	    
	    if (strR == '' && str != '' ) 
	    {
	    	return str;
		}
	    

}

function obtenerChecksSeleccionadosCredito()
{

    var arr = $('[name="checksCredito[]"]:checked').map(function(){
    	var valor = this.value.split("*")
	      return valor[0];
	    }).get();
	    
	    var str = arr.join(',');
	    return str;
	    

}


function obtenerChecksSeleccionadosOdesTrans()
{

	let arreglo = '';
    var arr = $('[name="checksTrans[]"]:checked').map(function(){
    	var valor = this.value.split("*")
    	if (arreglo.includes(valor[1])) 
    		{
    			
			}
    		else
    			{
    			arreglo = arreglo + ","+valor[1]
    			return valor[1];
    			}
	    }).get();
	    
	    var str = arr.join(',');
		let arreglor = '';
	    var arrR = $('[name="checksTransR[]"]:checked').map(function(){
var valor = this.value.split("*")
	    	
	    	if (arreglor.includes(valor[1])) 
    		{
    			
			}
    		else
    			{
    			arreglor = arreglor + ","+valor[1]
    			return valor[1];
    			}
	    	
		    }).get();
		    var strR = arrR.join(',');
	    
		    if (strR != '' && str != '' ) 
		    {
		    	return str+','+strR;
			}
		  
		    if (strR != '' && str == '' ) 
		    {
		    	return strR;
			}
		    
		    if (strR == '' && str != '' ) 
		    {
		    	return str;
			}
		    
	    return str;
	    

}
function obtenerChecksSeleccionadosTrans()
{
	let arreglo = '';
	   var arr = $('[name="checksTrans[]"]:checked').map(function(){
		   var valor = this.value.split("*")
   		if (arreglo.includes(valor[0])) 
   		{
   			
			}
   		else
   			{
   			arreglo = arreglo + ","+valor[0]
   			return valor[0];
   			}
	      
	    }).get();
	   
	    var str = arr.join(',');
	    
	    let arreglor = '';
		    var arrR = $('[name="checksTransR[]"]:checked').map(function(){
		    	var valor = this.value.split("*")
		    	if (arreglor.includes(valor[0])) 
	    		{
	    			
				}
	    		else
	    			{
	    			arreglor = arreglor + ","+valor[0]
	    			return valor[0];
	    			}
		      
			    }).get();
			    
			    var strR = arrR.join(',');
		    if (strR != '' && str != '' ) 
		    {
		    	return str+','+strR;
			}
		  
		    if (strR != '' && str == '' ) 
		    {
		    	return strR;
			}
		    
		    if (strR == '' && str != '' ) 
		    {
		    	return str;
			}

}


function l(valor)
{
}
function pedidos(pedido) 
{
	var ped = $("#pedidosSelec").val();
	ped = ped +", "+pedido;
	$("#pedidosSelec").val(ped)
}
function soloNumeros(e) {
	   var key = window.Event ? e.which : e.keyCode;
	   return ((key >= 48 && key <= 57) ||(key==8))
	 }
function validaEstatusRepartidor(value, item)
{
    
		if (value === "ENTREGADO")
        {
    	 return $("<div>").attr("style", "color: black; background: #00FF00").text(value);
		
        
        }
     	else if (value === "EN TRANSITO")
     	{
     		
     		return	$("<div>").attr("style", "color: black; background: #ffff00").text(value);
    	
        }
     	else if (value === "DESASIGNADO")
     	{
     		
     		return	$("<div>").attr("style", "color: white; background: #59A659").text(value);
    	
        }
		else if (value === "PENDIENTE")
		{
			return $("<div>").attr("style", "color: white   ;  background: #ff0000").text(value);
		}
		
       
   
}

function Tooltip(value, item)
{
    	 return $("<div>").prop("title", ""+item.nombre+"").text(value);
    	 
}
function TooltipEmpaque(value, item)
{
    	 return $("<div>").prop("title", ""+item.nom_emp+"").text(value);
    	 
}
function TooltipChofer(value, item)
{
    	 return $("<div>").prop("title", ""+item.nom_chofer+"").text(value);
}

function estatusColorRCMatPeligro(value, item){
	if(item.clvMaterialPeligroso != 0){
		return $("<div>").attr("style", "color: white; background: #F02D19").text(value); //F31811
	}else{
		return $("<div>").text(value);
	}
}

function estatusColorEstatus(value, item){
	if(item.estatus == "Asignado Parcial"){
		return $("<div>").attr("style", "color: white; background: #CF8BF9").text(value);
	}else{
		return $("<div>").text(value);
	}
}

function estatusColorRC(value, item){
	if(item.programada == "8")
	{
	return $("<div>").attr("style", "color: black; background: #FAD2A1").prop("title", "REPROGRAMADO").text(value);
	}
	else
    {
	return $("<div>").text(value);
	}
}

function toltipDireccionRC(value,item){
	return $("<div>").prop("title", value).text(valor);
}

function estatusColor(value, item)
{
	
    	if (item.uname_entrega != "n")
        {
    		
	    	if (item.uname_entrega == item.uname_br_entrega)
	    	{
	    		return $("<div>").attr("style", "color: black; background: #FAD2A1").prop("title", "REPROGRAMADO ENTREGA EN MISMO CDO").text(value);	
			}
	    	else if(item.uname_entrega == '')
	    		{
	    			return $("<div>").attr("style", "color: black; background: #b9dfff").prop("title", "REPROGRAMADO").text(value);
	    		}
	    	else
			{
			return $("<div>").attr("style", "color: black; background: #FAD2A1").prop("title", "REPROGRAMADO ENTREGA EN DIFERENTE CDO, DE: "+item.uname_br_entrega+" a "+item.uname_entrega).text(value);
			}
        }
    	else if(item.id_estatus == 8)
    		{
    		return $("<div>").attr("style", "color: black; background: #b9dfff").prop("title", "REPROGRAMADO").text(value);
    		}
    	else
    		{return $("<div>").text(value);}
    	

}

function toltipDireccion(value,item)
{
	var valor = value.substring(0,33);

	
	if (item.uname_entrega != "n")
    {
		
    	if (item.uname_entrega == item.uname_br_entrega)
    	{
    		return $("<div>").attr("style", "color: black; background: #FAD2A1").prop("title", value).text(valor);	
		}
    	else if(item.uname_entrega == '')
    		{
    			return $("<div>").attr("style", "color: black; background: #b9dfff").prop("title", value).text(valor);
    		}
    	else
		{
		return $("<div>").attr("style", "color: black; background: #FAD2A1").prop("title", value).text(valor);
		}
    }
	else if(item.id_estatus == 8)
		{
		return $("<div>").attr("style", "color: black; background: #b9dfff").prop("title", value).text(valor);
		}
	else
		{return $("<div>").prop("title", value).text(valor);}
}
function divTotales(valor) 
{
	return $("<div>").attr("style", "color: white; background: black").text("$"+valor);
}
function divTotalesFecha(valor) 
{
	return $("<div>").attr("style", "color: white; background: black").text(valor);
}


function colorEstatus(estatus,value) 
{
	estatus = parseInt(estatus)
	switch (estatus) {
	case 0:
		return $("<div>").attr("style", "color: black; background: #f9fce3").text(value);
	break;
	case 1:
	return $("<div>").attr("style", "color: black; background: #eafce3").text(value);
	break;
	case 2:
	return $("<div>").attr("style", "color: black; background: #a3ecae").text(value);
	break;
	case 3:
	return $("<div>").attr("style", "color: black; background: #f7d1d1").text(value);
	break;
	case 4:
	return $("<div>").attr("style", "color: black; background: #FAD2A1").text(value);
	break;
	case 8:
	return $("<div>").attr("style", "color: black; background: #b9dfff").text(value);
	break;
	default:
	return $("<div>").attr("style", "color: black; background: #f5f5f5").text(value);
	break;
	}
}

function colorEstatusDetalle(estatus,value) 
{
	
	estatus = parseInt(estatus)
	switch (estatus) {
	case 0:
		return $("<div>").attr("style", "color: black; background: #f9fce3;font-weight: bold;font-size: 9px;").text(value);
	break;
	case 1:
	return $("<div>").attr("style", "color: black; background: #eafce3;font-weight: bold;font-size: 9px;").text(value);
	break;
	case 2:
	return $("<div>").attr("style", "color: black; background: #a3ecae;font-weight: bold;font-size: 9px;").text(value);
	break;
	case 3:
	return $("<div>").attr("style", "color: black; background: #f7d1d1;font-weight: bold;font-size: 9px;").text(value);
	break;
	case 4:
	return $("<div>").attr("style", "color: black; background: #FAD2A1;font-weight: bold;font-size: 9px;").text(value);
	break;
	case 8:
	return $("<div>").attr("style", "color: black; background: #b9dfff;font-weight: bold;font-size: 9px;").text(value);
	break;
	default:
	return $("<div>").attr("style", "color: black; background: #f5f5f5;font-weight: bold;font-size: 9px;").text(value);
	break;
	}
}

function divObservaciones(item,value) 
{
	return $("<div>").attr("style", "width: 100%;").prop("title", value).append(value.toString().substring(0,14));
}

function divCteChofer(value,item) 
{
	return $("<div>").attr("style", "width: 100%;").prop("title", value).append(value.toString().substring(0,25));
}


function toltipConfirmacion(item,value) 
{
	return $("<div>").attr("style", "width: 100%;").prop("title", value).append(value.toString().substring(0,28));
}

function toltipConfirmacionRuta(item,value) 
{
	return $("<div>").attr("style", "width: 100%;").prop("title", value).append(value.toString().substring(0,18));
}

function divChoferMonitor(item,value) 
{
	return $("<div>").attr("style", "width: 100%;").prop("title", value).append(value.toString().substring(0,34));
}

function validarIngresos(valor,ingresos,cobro) 
{
//	if(cobro == 'COD' && ingresos != '')
//	{
//		return $("<div>").prop("title", "No ha registrado cobro").append(valor);	
//	}
//	else
//	{
		return valor;
//	}
	
}


function validarIngresos2(valor,ingresos,cobro) 
{
//	console.log("antes: "+valor)
//	if(cobro == 'COD' && ingresos != '')
//	{
//		console.log("antesdespues11: "+valor)
//		return $("<div>").prop("title", "No ha registrado cobro").append(valor);	
//	}
//	else
//	{
//		console.log("antesdespues: "+valor)
		return valor;
//	}
//	console.log("antesdespues: "+valor)
}

function validarIngresosColor(valor,ingresos) 
{
	if(ingresos == '*' )
	{
		return $("<div>").prop("title", "No ha registrado cobro").append(valor);	
	}
	else
	{
		return valor;
	}
	
}

function validarTipoColor(valor, tipo){
	
	return $("<div>").attr("style", "color: black; background:" +tipo).text(valor);
}

function validarTipoColorRespaldo(valor, tipo){
	console.log("color: "+tipo)
	if(valor == 'RCS'){
		return $("<div>").attr("style", "color: black; background: #F7EACE").text(valor);
	}else if(valor == 'CDO'){
		return $("<div>").attr("style", "color: black; background: #F4EBFA").text(valor);
	}else if(valor == 'CORP'){
		return $("<div>").attr("style", "color: black; background: chartreuse").text(valor);
	}else if(valor == 'TRANS'){
		return $("<div>").attr("style", "color: black; background: #D3F5CD").text(valor);
	}
}

function divDireccion(item,value) 
{
	
	return $("<div>").attr("style", "width: 100%;").prop("title", value).append(value.toString().substring(0,24));
}
function limpiarTablaDetalle() 
{
	$("#tablaDetalle").html("");
}
function llenaGridDetalle(ruta,cartaPorte,chofer,fecha,dt,auxFor,tipo,datos,finConcat,asignacion,finRuta)
{
	
	
	$("#trayectoTitulo").text(ruta)
	if(cartaPorte!=null || cartaPorte!=""){
		$("#cartaPorteTitulo").text(cartaPorte)
	}
	$("#fechaTitulo").text(fecha)
	$("#fechaFinRuta").text(finRuta)
	$("#fechaAsignacion").text(asignacion)
	finConcat = finConcat.split(",");
	if(tipo == 'TRANSP')
	{
		$("#choferTitulo").text(datos.numeroChofer+"-"+datos.transporteNombre)
	}
	else
	{
		$("#choferTitulo").text(chofer)
	}
		
	
	$('#divDetalle').show()
		$('#monitor').hide()
		
		
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	return $.grep(dt, function (egreso) {
	            return 		(!filter.pedido.toUpperCase()|| egreso.pedido.toUpperCase() === filter.pedido.toUpperCase() || egreso.pedido.toUpperCase() == filter.pedido.toUpperCase() || egreso.pedido.toUpperCase().includes(filter.pedido.toUpperCase()))
	            &&  (!filter.importe.toUpperCase()|| egreso.importe.toUpperCase() === filter.importe.toUpperCase() || egreso.importe.toUpperCase() == filter.importe.toUpperCase() || egreso.importe.toUpperCase().includes(filter.importe.toUpperCase()))
	            &&  (!filter.importe_cobrado.toUpperCase()|| egreso.importe_cobrado.toUpperCase() === filter.importe_cobrado.toUpperCase() || egreso.importe_cobrado.toUpperCase() == filter.importe_cobrado.toUpperCase() || egreso.importe_cobrado.toUpperCase().includes(filter.importe_cobrado.toUpperCase()))
	            &&  (!filter.fechaPedido.toUpperCase()|| egreso.fechaPedido.toUpperCase() === filter.fechaPedido.toUpperCase() || egreso.fechaPedido.toUpperCase() == filter.fechaPedido.toUpperCase() || egreso.fechaPedido.toUpperCase().includes(filter.fechaPedido.toUpperCase()))
	            &&  (!filter.cliente.toUpperCase()|| egreso.cliente.toUpperCase() === filter.cliente.toUpperCase() || egreso.cliente.toUpperCase() == filter.cliente.toUpperCase() || egreso.cliente.toUpperCase().includes(filter.cliente.toUpperCase()))
	            &&  (!filter.finConcat.toUpperCase()|| egreso.finConcat.toUpperCase() === filter.finConcat.toUpperCase() || egreso.finConcat.toUpperCase() == filter.finConcat.toUpperCase() || egreso.finConcat.toUpperCase().includes(filter.finConcat.toUpperCase()))
	            &&  (!filter.factura.toUpperCase()|| egreso.factura.toUpperCase() === filter.factura.toUpperCase() || egreso.factura.toUpperCase() == filter.factura.toUpperCase() || egreso.factura.toUpperCase().includes(filter.factura.toUpperCase()))
	            &&  (!filter.tipo_cobro.toUpperCase()|| egreso.tipo_cobro.toUpperCase() === filter.tipo_cobro.toUpperCase() || egreso.tipo_cobro.toUpperCase() == filter.tipo_cobro.toUpperCase() || egreso.tipo_cobro.toUpperCase().includes(filter.tipo_cobro.toUpperCase()))
	            &&  (!filter.observaciones.toUpperCase()|| egreso.observaciones.toUpperCase() === filter.observaciones.toUpperCase() || egreso.observaciones.toUpperCase() == filter.observaciones.toUpperCase() || egreso.observaciones.toUpperCase().includes(filter.observaciones.toUpperCase()))
	            &&  (!filter.ruta.toUpperCase()|| egreso.ruta.toUpperCase() === filter.ruta.toUpperCase() || egreso.ruta.toUpperCase() == filter.ruta.toUpperCase() || egreso.ruta.toUpperCase().includes(filter.ruta.toUpperCase()))
	            &&  (!filter.fecha_inicio_entrega.toUpperCase()|| egreso.fecha_inicio_entrega.toUpperCase() === filter.fecha_inicio_entrega.toUpperCase() || egreso.fecha_inicio_entrega.toUpperCase() == filter.fecha_inicio_entrega.toUpperCase() || egreso.fecha_inicio_entrega.toUpperCase().includes(filter.fecha_inicio_entrega.toUpperCase()))
	            &&  (!filter.direccion.toUpperCase()|| egreso.direccion.toUpperCase() === filter.direccion.toUpperCase() || egreso.direccion.toUpperCase() == filter.direccion.toUpperCase() || egreso.direccion.toUpperCase().includes(filter.direccion.toUpperCase()))
	            &&  (!filter.ode.toUpperCase()|| egreso.ode.toUpperCase() === filter.ode.toUpperCase() || egreso.ode.toUpperCase() == filter.ode.toUpperCase() || egreso.ode.toUpperCase().includes(filter.ode.toUpperCase()))
	            &&  (!filter.folio_corte.toUpperCase()|| egreso.folio_corte.toUpperCase() === filter.folio_corte.toUpperCase() || egreso.folio_corte.toUpperCase() == filter.folio_corte.toUpperCase() || egreso.folio_corte.toUpperCase().includes(filter.folio_corte.toUpperCase()))
	            
		            	    
	        });
	    },
	    insertItem: function (insertingClient) 
	    {
	    	
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {
	    
	    },
	 };
	window.db = db;
    db.dt;
	 $(function ()
    	     {
    	    	 $("#tablaDetalle").jsGrid({
    	    		 width: "100%",
    	             height: "600px",
    	             editing: false,
    	             filtering: true,
    	             selecting: true,
    	             sorting: true ,
    	             paging: false,
    	             cache: false,
    	             pageSize: 800,
    	             
    	             controller: 
    	             {
    	                 loadData: function () 
    	                 {
    	                	 dataType: "json"
    	                     return dt ;
    	                 }
    	             },
    	             rowClass: function(item, itemIndex) 
    	             { 
    	            	if (item.uname == "TOTALES")
    	            	{
    	            		return "ocultar";
						}
    	            	 
    	            	if(item.tipo_cobro == 'COD' && item.ingresos != '')
    	            	{
    	            		return "bg-red";
						}
    	            	if(item.descripcion_cdo == 'TOTALES')
    	            	{
    	            		return "bg-totales";
						} 
    	            	
    	            	
    	            	
    	            	
    	             },
    	             controller: db,
    	             onRefreshed: function (args) { 
    	            	 let items = args.grid.option("data");
    	            	 let totales= calculaImportesTotalesDelGridIngresos2(items)
    	                 let $totalRow = $("<tr>").addClass("total-row");
    	                 args.grid._renderCells($totalRow, totales);
    	                 args.grid._content.append($totalRow);
    	             },
    	            
    	             autoload: true,
    	             fields: 
    	             [
    	            	 { name: "id_traycto", type: "text", title: "", width:18, align: 'center',filtering: false,itemTemplate: function (value, item) { 

    	            			 
    	            			 return validarIngresos(item.no,item.ingresos,item.tipo_cobro)
    	            		 
    	            		 
    	            		 }},
    	            	 { name: "ode",  type: "text", title: "ODE", width: 28, align: 'center', filtering: true,itemTemplate: function (value, item) {return validarIngresos(value,item.ingresos,item.tipo_cobro)}},
    	            	 { name: "pedido", type: "text", title: "PEDIDO", width:28, align: 'center', filtering: true,itemTemplate: function (value, item) {return validarIngresos(value,item.ingresos,item.tipo_cobro)}},
    	                 { name: "cliente", type: "text", title: "CTE", width:70, align: 'center', filtering: true,itemTemplate: function (value, item) { return validarIngresos(divObservaciones(item,value),item.ingresos,item.tipo_cobro)}},
    	                 { name: "factura", type: "text", title: "FACTURA", width:28, align: 'center', filtering: true,itemTemplate: function (value, item) {return validarIngresos(value,item.ingresos,item.tipo_cobro)}},
    	                 { name: "importe", type: "text", title: "IMP", width:50, align: 'right', filtering: true,filtering: true,itemTemplate: function (value, item) { 
    	                	 
    	               		 if (item.uname == 'TOTALES') 
    	            		 {
								return divTotales(value)
    	            		 }
    	                	 return validarIngresos("$"+value,item.ingresos,item.tipo_cobro)
    	                	 }},
    	                 { name: "importe_cobrado", type: "text", title: "IMP COBRADO", width:55, align: 'right', filtering: true,itemTemplate: function (value, item) {
    	               		 if (item.uname == 'TOTALES') 
    	            		 {
								return divTotales(value)
    	            		 }
    	                	 return validarIngresos(importeCobrado(item.importe_cobrado),item.ingresos,item.tipo_cobro)}},
    	                 { name: "tipo_cobro", type: "text", title: "CP", width:25, align: 'center', filtering: true,itemTemplate: function (value, item) {return validarIngresos(value,item.ingresos,item.tipo_cobro)}},
    	                 { name: "observaciones", type: "text", title: "OBSERVACIONES", width:80, align: 'left', filtering: true,itemTemplate: function (value, item) { return validarIngresos(divObservaciones(item,value),item.ingresos,item.tipo_cobro)}},
    	                 { name: "ruta", type: "text", title: "RUTA", width:65, align: 'left', filtering: true,itemTemplate: function (value, item) {return validarIngresos(divObservaciones(item,value),item.ingresos,item.tipo_cobro)}},
    	                 { name: "direccion",  type: "text", title: "DIRECCION", width: 90, align: 'left', filtering: true,itemTemplate: function (value, item) { return validarIngresos(divDireccion(item,value),item.ingresos,item.tipo_cobro)}},
       	                 { name: "fechaPedido", type: "text", title: "F. PEDIDO", width: 67, align: 'center', filtering:true,itemTemplate: function (value, item) {return validarIngresos(value,item.ingresos,item.tipo_cobro)}},
       	                 { name: "fecha_inicio_entrega", type: "text", title: "ENTREGO PEDIDO", width: 67, align: 'center', filtering: true,itemTemplate: function (value, item) { return validarIngresos(formatoFecha(item.fecha_inicio_entrega),item.ingresos,item.tipo_cobro)}},
       	                 { name: "horasPed", type: "text", title: "TMP PEDIDO", width: 40, align: 'center', filtering: false,itemTemplate: function (value, item) { return toltipTmp(validarIngresos(item.horasPed.toString().replace("-",""),item.ingresos,item.tipo_cobro),"Tiempo desde que se imprimio ods hasta que se entrego al cliente (fecha pedido - entrego pedido)")}},
       	                 { name: "horas", type: "text", title: "TMP ENTREGA", width: 46, align: 'center', filtering: false,itemTemplate: function (value, item) { console.log("irtem: "+item.horas.toString().replace("-","")); 
       	                	 return toltipTmp2(validarIngresos2(item.horas.toString().replace("-",""),item.ingresos,item.tipo_cobro),"Tiempo desde que inicio ruta chofer hasta que entrego pedido (fecha inicio ruta - entrego pedido)")}},
       	                 { name: "horasAsig", type: "text", title: "TMP ASIG", width: 40, align: 'center', filtering: false,itemTemplate: function (value, item) {
       	                	 return toltipTmp(validarIngresos(item.horasAsig,item.ingresos,item.tipo_cobro),"Tiempo desde que se asigno ruta hasta que entrego pedido (fecha asignacion - entrego pedido)")}},
       	                 { name: "finConcat", type: "text", title: "DIF ENTREGA", width:44, align: 'center', filtering: true,itemTemplate: function (value, item) 
       	                	 {
       	            		 if (item.uname == 'TOTALES') 
    	            		 {
								return divTotalesFecha(value)
    	            		 }
       	                	 return toltipTmp(validarIngresos(value,item.ingresos,item.tipo_cobro),"Diferencia entre la entrega del pedido anterior")
       	                	 }
       	                	 
       	                 },
       	              { name: "folio_corte",  type: "text", title: "CORTE", width: 30, align: 'center', filtering: true,itemTemplate: function (value, item) { return validarIngresos(value,item.ingresos,item.tipo_cobro)}},
       	                 { name: "estatus", type: "text", title: "ESTATUS", width: 64, align: 'center', filtering: false,itemTemplate: function (value, item) {
       	                	if (item.uname != 'TOTALES' && item.uname != "")  
       	                	 {
       	                		return colorEstatusDetalle(item.id_estatus,value)
						} }},
       	                 { name: "btnDetalle", type: "text", title: "", width: 20, align: 'center', filtering:false,
    	                	 itemTemplate: function (value, item) 
    	                	 {
    	                		 if (item.uname != 'TOTALES' && item.uname != "") 
	                			 {
    	                		 return $("<button>").attr("class", "EG_btnUbicacionPunteo").on("click", function () 
	                				 {
	                			 		ubicacionEntrega(item,dt,ruta,item.id_traycto,item.ode,item.pedido,item.cliente,item.factura,item.latitud_inicio_entrega,item.longitud_inicio_entrega,item.latitud_fin_entrega,item.longitud_fin_entrega,chofer,item.fecha_inicio_entrega);	
    	                			     return false;
    	                             });
	                			 }
    	                		 
    	                		 
    	                     }
    	                 }
       	                 
       	                 
//       	               
    	             ]
	                 
	        	 });
	         });


}
function calculaImportesTotalesDelGridEgresos(items,a,aa,aaa)
{
	 let total = {
			 id_traycto: 0,ode: "", pedido: "", cliente: "",factura: "", importe: ""+a+"",importe_cobrado: ""+aa+"",tipo_cobro: "",observaciones: "",ruta: "",direccion: "",
			 fechaPedido: "",fecha_inicio_entrega: "",horasPed: "" ,horas: "", finConcat: ""+aaa+"",folio_corte:"0",btnDetalle: "", IsTotal: true
     };
	  

     return total;
}

function scrollBlock()
{
	$("body").css({
		"overflow-y" : "hidden",
		"overflow-x":"hidden"	
	});
}
//var scrollLeft = $(window).scrollLeft();
//var scrollTop = $(window).scrollTop();
//scrollBlock()
//	$("#cargando").show();
//	$("#cargando").offset({ top: scrollTop, left: 0 });



function consultarCorte()
{
	
	
	var fecha = $("#txt_fechaIniCorte").val()
	if(fecha != ''){
		
		var opcion = confirm("Esta seguro que desea realizar el corte?");
		if (opcion == true )
		{
		
		
		var cdoCorte = $("#cdoCorte").val();
		url = "accion=ConsultarCorte&fecha="+fecha+"&cdo="+cdoCorte;
		document.getElementById('cargando').style.display = 'block';
		$.ajax({
		    url :'MonitorPedidosServlet', 
		    data : ''+url, 
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
		        		if (data.includes("()"))
		        		{
		        			var split = data.split("()");
		        			alert(split[0]);
		        			$("#tablaCorte").html("<pre>" + split[2] + "</pre>");
		        			$("#tablaCorte2").html("<pre>" + split[3] + "</pre>");
						}
		        		else
		        			{
		        			alert(data)
		        			}
		        			
		        	}
		        	else
		        		{
		        		alert("No se encontraron registros para realizar el corte con la fecha: "+fecha )
		        		}
	        	}
		        else
		        	{
		        	alert("Error al generar corte")
		        	}
		       
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				if (xhr.status === 200)
				{
					alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
					window.location.href='/AsignacionRutasCDO/';
				}
			}
		});
		}
}
else{
	alert("Debe ingreasr una fecha")
}
}

function consultarCredito()
{

	var fecha = $("#txt_fechaIniCredito").val()
	var fechaFin = $("#txt_fechaFinCredito").val()
	var corte = $("#folioCorteCredito").val();
	var tipoBusqueda = $('input:radio[name=tipoBusquedaCredito]:checked').val();
var cdoCredito = $("#cdoFacturas").val();

var f = fecha.split("/");
var ff = fechaFin.split("/");
var si = 0;
if (f[0] > ff[0])
{
	si = 1;
	if (f[1] > ff[1])
	{
		
		si = 1;
		if (f[2] < ff[2]) 
		{
			si = 0;
		}
	}
	else	if (f[1] < ff[1])
	{
		si = 0;
	}

	
}

if(si == 0)
		{
		url = "accion=ConsultarCredito&fecha="+fecha+"&cdoCredito="+cdoCredito+"&fechaFin="+fechaFin+"&tipo="+tipoBusqueda+"&corte="+corte;
		
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : ''+url, 
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	document.getElementById('cargando').style.display = 'none';
	        	$("#check").val("");
	        	var data = respuesta;
	        	if( data.length > 0)
	        	{
	        			llenaGridCredito(data)
			        	$("#monCredito").show()
			        	$("#btnConfirmarFac").show()
			        	$("#folioCorteCredito").val("");
	        	}
	        	else
	        		{
	        		alert("No hay registros con el rango de fecha: "+fecha+ " - " +fechaFin)
	        		$("#totalFacturasDisponibles").text("");
	        		$("#totalFacturasSeleccionadas").text("");
	        		$("#monCredito").hide()
	        		$("#btnConfirmarFac").hide()
	        		$("#folioCorteCredito").val("");
	        		}
        	}
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/AsignacionRutasCDO/';
			}
		}
	});
		}
else
	{
	alert("La fecha de inicio debe ser menor a la fecha fin")
	}
	}
function vaciarCredito()
{
	$("#totalFacturasDisponibles").text("");
	$("#totalFacturasSeleccionadas").text("");
}

function llenaGridCredito(data)
{

//	$('#monCredito').find('.jsgrid-header-row').css('background','#3f4b54 !important');
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	return $.grep(data, function (egreso) {
	            return 		(!filter.cliente.toUpperCase()|| egreso.cliente.toUpperCase() === filter.cliente.toUpperCase() || egreso.cliente.toUpperCase() == filter.cliente.toUpperCase() || egreso.cliente.toUpperCase().includes(filter.cliente.toUpperCase()))
	            			&&  (!filter.importe.toUpperCase()|| egreso.importe.toUpperCase() === filter.importe.toUpperCase() || egreso.importe.toUpperCase() == filter.importe.toUpperCase() || egreso.importe.toUpperCase().includes(filter.importe.toUpperCase()))
				            && (!filter.ode.toUpperCase()|| egreso.ode.toUpperCase() === filter.ode.toUpperCase() || egreso.ode.toUpperCase() == filter.ode.toUpperCase() || egreso.ode.toUpperCase().includes(filter.ode.toUpperCase()))
				            &&  (!filter.importe_cobrado.toUpperCase()|| egreso.importe_cobrado.toUpperCase() === filter.importe_cobrado.toUpperCase() || egreso.importe_cobrado.toUpperCase() == filter.importe_cobrado.toUpperCase() || egreso.importe_cobrado.toUpperCase().includes(filter.importe_cobrado.toUpperCase()))
				            &&(!filter.id_traycto.toUpperCase()|| egreso.id_traycto.toUpperCase() === filter.id_traycto.toUpperCase())
				            &&(!filter.folio_corte.toUpperCase()|| egreso.folio_corte.toUpperCase() === filter.folio_corte.toUpperCase() || egreso.folio_corte.toUpperCase() == filter.folio_corte.toUpperCase() || egreso.folio_corte.toUpperCase().includes(filter.folio_corte.toUpperCase()))
						            &&(!filter.tipo.toUpperCase()|| egreso.tipo.toUpperCase() === filter.tipo.toUpperCase() || egreso.tipo.toUpperCase() == filter.tipo.toUpperCase() || egreso.tipo.toUpperCase().includes(filter.tipo.toUpperCase()))
					            && (!filter.pedido.toUpperCase()|| egreso.pedido.toUpperCase() === filter.pedido.toUpperCase() || egreso.pedido.toUpperCase() == filter.pedido.toUpperCase() || egreso.pedido.toUpperCase().includes(filter.pedido.toUpperCase()))
				             && (!filter.num_chofer.toUpperCase()|| egreso.num_chofer.toUpperCase() === filter.num_chofer.toUpperCase() || egreso.num_chofer.toUpperCase() == filter.num_chofer.toUpperCase() || egreso.num_chofer.toUpperCase().includes(filter.num_chofer.toUpperCase()))
			              && (!filter.condicion.toUpperCase()|| egreso.condicion.toUpperCase() === filter.condicion.toUpperCase() || egreso.condicion.toUpperCase() == filter.condicion.toUpperCase() || egreso.condicion.toUpperCase().includes(filter.condicion.toUpperCase()))
			               && (!filter.ruta.toUpperCase()|| egreso.ruta.toUpperCase() === filter.ruta.toUpperCase() || egreso.ruta.toUpperCase() == filter.ruta.toUpperCase() || egreso.ruta.toUpperCase().includes(filter.ruta.toUpperCase()))
			               && (!filter.estatus.toUpperCase()|| egreso.estatus.toUpperCase() === filter.estatus.toUpperCase() || egreso.estatus.toUpperCase() == filter.estatus.toUpperCase() || egreso.estatus.toUpperCase().includes(filter.estatus.toUpperCase()))
			                 && (!filter.factura.toUpperCase()|| egreso.factura.toUpperCase() === filter.factura.toUpperCase() || egreso.factura.toUpperCase() == filter.factura.toUpperCase() || egreso.factura.toUpperCase().includes(filter.factura.toUpperCase()))
			                 && (!filter.fecha_envios.toUpperCase()|| egreso.fecha_envios.toUpperCase() === filter.fecha_envios.toUpperCase() || egreso.fecha_envios.toUpperCase() == filter.fecha_envios.toUpperCase() || egreso.fecha_envios.toUpperCase().includes(filter.fecha_envios.toUpperCase()))
			                 && (!filter.fecha_credito.toUpperCase()|| egreso.fecha_credito.toUpperCase() === filter.fecha_credito.toUpperCase() || egreso.fecha_credito.toUpperCase() == filter.fecha_credito.toUpperCase() || egreso.fecha_credito.toUpperCase().includes(filter.fecha_credito.toUpperCase()))
			                 && (!filter.fecha_corte.toUpperCase()|| egreso.fecha_corte.toUpperCase() === filter.fecha_corte.toUpperCase() || egreso.fecha_corte.toUpperCase() == filter.fecha_corte.toUpperCase() || egreso.fecha_corte.toUpperCase().includes(filter.fecha_corte.toUpperCase()))
		            	    
	        });
	    },
	    insertItem: function (insertingClient) 
	    {
	    	
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {
	    
	    },
	 };
	window.db = db;
    db.data;
    var fact = 0;
    var total = 0;
    
	 $(function ()
    	     {
    	    	 $("#monCredito").jsGrid({
    	    		 width: "99%",
    	             height: "500px",
    	             editing: false,
    	             filtering: true,
    	             selecting: true,
    	             sorting: true ,
    	             paging: false,
    	             pageSize: 800,
    	             
    	             controller: 
    	             {
    	                 loadData: function () 
    	                 {
    	                     dataType: "json"
    	                     return data ;
    	                 }
    	             },
    	             controller: db,
    	             onRefreshed: function (args) 
    	             { 
    	            	 $("#totalFacturasDisponibles").text("Facturas totales: "+total+"  Facturas disponibles: "+fact+"  Facturas seleccionadas: ")
    	            	 sCredito()
    	            	 
    	            	fact = 0;
    	            	total = 0;
    	             },
    	             rowClass: function(item, itemIndex) 
    	             { 
    	            	 
    	             },
    	             rowDoubleClick: function(args) 
    	             {
    	            	 var item = args.item;
    	            	 var keys = Object.keys(item);
    	            	 if($("#"+item.no+"").is(':checked'))
    	            	 {  
    	            		 $("#"+item.no+"").prop("checked", false); 
    	                 }
    	            	 else
    	            	{
    	            		 $("#"+item.no+"").prop("checked", true); 
    	            	}
    	             },
    	             autoload: true,
    	             fields: 
    	             [
    	            	 { name: "cnt", type: "checkbox",width: 20, title: " ",visible:true, editing:false,  filtering: false,  
						     itemTemplate: function(_, item) 
						     {
						    	 total = parseInt(total)+1;	
						    	 if (item.id_estatus == 2 && $("#nivelUsu").val() != 3)
						    	 	{
						    	 		fact = parseInt(fact) +1;
						    	 		
						    	 		return `<input class="single"  name="checksCredito[]" id='${item.no}' value=${item.factura}*${item.ode} onclick="sCredito();" checked type="checkbox" style="height: 10px;width: 10px;"/>`
									}
						    	 	else
						    	 		{
						    	 		return false;
						    	 		}
						    	 	
						    	 	
						   	 }
    	            	 },
    	            	 { name: "id_traycto",  type: "text", title: "FOLIO", width: 40, align: 'center', filtering: true },
    	            	 { name: "tipo", type: "text", title: "TIPO", width:40, align: 'center', filtering: true},
    	            	 { name: "num_chofer", type: "text", title: "CHOFER", width:93, align: 'left', filtering: true,itemTemplate: function (value, item) { return value}},
    	            	 { name: "factura", type: "text", title: "FACTURA", width:38, align: 'center', filtering: true},
    	            	 { name: "pedido", type: "text", title: "PEDIDO", width:43, align: 'center', filtering: true},
    	            	 { name: "ode", type: "text", title: "ODE", width:43, align: 'center', filtering: true},
    	            	 { name: "cliente", type: "text", title: "CLIENTE", width:98, align: 'left', filtering: true,itemTemplate: function (value, item) { return toltipConfirmacion(item.id_estatus,value)}},
    	            	 { name: "importe", type: "text", title: "IMPORTE", width:48, align: 'right', filtering: true,filtering: true,itemTemplate: function (value, item) {return "$"+value}},
    	            	 { name: "importe_cobrado", type: "text", title: "IMPORTE COBRADO", width:63, align: 'right', filtering: true,filtering: true,itemTemplate: function (value, item) {return "$"+value}},
    	            	 { name: "condicion", type: "text", title: "CP", width:38, align: 'center', filtering: true},
    	            	 { name: "ruta", type: "text", title: "RUTA", width:68, align: 'left', filtering: true,itemTemplate: function (value, item) { return toltipConfirmacionRuta(item.id_estatus,value)}},
    	            	 { name: "folio_corte", type: "text", title: "CORTE", width:34, align: 'center', filtering: true},
    	            	 { name: "fecha_envios", type: "text", title: "CONFIRMA ENVIOS", width:66, align: 'center', filtering: true,itemTemplate: function (value, item) { return tooltipCredito(value,item,item.usuario_envios)}},
    	            	 { name: "fecha_credito", type: "text", title: "CREDITO", width:66, align: 'center', filtering: true,itemTemplate: function (value, item) { return tooltipCredito(value,item,item.usuario_credito)}},
    	            	 { name: "fecha_corte", type: "text", title: "GENERA CORTE", width:66, align: 'center', filtering: true,itemTemplate: function (value, item) { return tooltipCredito(value,item,item.usuario_corte)}},
    	            	 { name: "estatus", type: "text", title: "ESTATUS", width: 58, align: 'center', filtering: true,itemTemplate: function (value, item) { return colorEstatus(item.id_estatus,value)}}
    	            	  
    	             ],
	                 
	        	 });
	         });
	 
}
