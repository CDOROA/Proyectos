/*** ACCIONES PRINCIPALES  ***/
function cargaInicialDeOtrosPedidos()
         
{
	$("#navbarsExample02").collapse('hide');
	  $("#navbarsExample02").removeClass("in");
	$('#txt_fechaIniResumenPedido').val(ObtenerFechaActual());
	$('#txt_fechaFinResumenPedido').val(ObtenerFechaActual());
	ocultarControlesSeguimientoOtros();
 	consultaHistorialOtrosPedidos(false)
}

function ocultarControlesSeguimientoOtros()
{
	OcultarDiv("divConsultaPorAplicacion");
	OcultarDiv("divEstadoDeCuenta");
	OcultarDiv("SeguimientoDePedidoDetalle");
	OcultarDiv("divCarritoDeComprasArticulos");	
	OcultarDiv("divSeguimientoDePedido");	
	MostrarDiv("divSeguimientoOtrosPedido");	
	
}


/*** CONSULTA RESUMEN DE PEDIDOS ***/
function consultaHistorialOtrosPedidos()
{
	document.getElementById('cargando').style.display = 'block';		
	let fechaIni="NA";
	let fechaFin="NA";
	let rango="NA";
	let NumeroPedido=0;	

	rango= $("#cmb_rango_dias").val();
	
	$.ajax({
	    url :'SeguimientoDePedidos',
	    data : "vista=CarritoDeCompras.jsp&operacion=ConsultaSeguimientoDePedidoOtrosCanales&rango=" + rango, 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	document.getElementById('cargando').style.display = 'none';		    	
	    	cargaResumenHistorialPedidosotrosCanales(json)
	    	OcultarDiv("divCarritoDeComprasArticulos");
	    	OcultarDiv("divSeguimientoDePedido"); 
	    	MostrarDiv("divSeguimientoOtrosPedido");
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='http://www.cdoautopartes.com.mx/';
			}
			else
				alert('Error al consultar historial de Pedidos.')
		}
	});
}

function cargaResumenHistorialPedidosotrosCanales(jsonResumenPedidos)
{
	 
	$('#dgResumenHistorialPedidosOtrosCanales').empty();
	let contenido = generaTitulosResumenHistorialPedidosOtros();	
	for(let i=0; i < jsonResumenPedidos.length ; i++)
	{
		contenido += "<tr id='tr_resumenPedidos'>";		
		contenido+=	generaColumnaInfoPedidoOtros(jsonResumenPedidos[i]);
		contenido+=	generaEstatusDelResumenPedidoOtros(jsonResumenPedidos[i])
		contenido+=	generaEstatusDelResumenPedidoEntregaOtros(jsonResumenPedidos[i])
	}
	contenido +="</tbody>" +
	"</table>";
	$("#dgResumenHistorialPedidosOtrosCanales").append(contenido);
	aplicarEstiloTablaDEtallePedidos();		
}


/*** CONSTRUYE TABLA DE RESUMEN DE PEDIDOS ***/
function generaTitulosResumenHistorialPedidosOtros()
{
	let contenido = "<table id='tb_resumenPedidos' align='center' cellpadding=0px; cellspacing=0px; class='table table-bordered' style='width:90%; background:white' data-page-length='5'>"+
						"<thead  id='thd_resumenPedidos' style='background-color:white; color:#0054A2' >"+
							"<tr id='tr_resumenPedidos'>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:2px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>CANAL</label> </th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:2px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>PEDIDO</label> </th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:2px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>FECHA</label> </th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>HORA</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>CANT. PEDIDA</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>CANT. ARTICULOS</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>TRANSPORTE</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>ESTATUS ALMACEN</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>ESTATUS ENTREGA</label></th>"+
							"</tr>"+
						"</thead>"+
						"<tbody id='tbd_resumenPedidos'>" ;
	return contenido;
}

function generaColumnaInfoPedidoOtros(jsonResumenPedidos)
{
	let contenido =	"<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
	"<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Canal: " + "</label>"+
	"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonResumenPedidos.descripcionCanal + "</label>"+
	"</td>";
	
	 contenido +=	"<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
			"<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Numero Pedido: " + "</label>"+
			"<label class='ECC_lb_size_14' style='font-weight: bold; color:#153D89 ; text-decoration:underline;cursor: pointer;'  onclick=\"mostrarDetalleDelSeguimientoDelPedidoOtros('"+ jsonResumenPedidos.pedido+"','"+ jsonResumenPedidos.pedido+ "-M,0-R,0-T,0-T,0-T" + "')\">  "  + jsonResumenPedidos.pedido + "</label>"+
			"</td>";
			
		contenido += "<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
			"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
			"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonResumenPedidos.fecha + "</label>"+
			"</td>";
		contenido += "<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Hora Pedido: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonResumenPedidos.hora + "</label>"+
		"</td>";
			
		contenido += "<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
			"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Cantidad Pedida: " + "</label>"+
			"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonResumenPedidos.cantPedida  + "</label>"+
			"</td>";
		
		contenido += "<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Cantidad Articulos: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonResumenPedidos.numArticulos  + "</label>"+
		"</td>";
		
		contenido += "<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Transporte: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonResumenPedidos.transporte  + "</label>"+
		"</td>";

	return contenido;
}

function generaEstatusDelResumenPedidoOtros(jsonResumenPedidos)
{
	//alert(JSON.stringify(jsonResumenPedidos));
	//alert(jsonResumenPedidos.pedido);
	let contenido =	"<td  id='td_resumenPedidos' align='center' style='padding:5px;  vertical-align: middle; '>";
		 contenido += "<div style='cursor: pointer;' onclick=\"mostrarDetalleDelSeguimientoDelPedidoOtros('"+ jsonResumenPedidos.pedido+"','" +jsonResumenPedidos.pedido+"-M,0-R,0-T,0-T,0-T')\">";
		 if (jsonResumenPedidos.estatusAlmacen == "Facturado")
			 {
		  contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/EstEntregado.png' class='ECC_img_EstatusPedido' ><BR>";
			 }
		 else
			 {
			  contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/EstCapturado.png' class='ECC_img_EstatusPedido' ><BR>";
			 }
		  
		 contenido += "<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Estatus CDO: " + "</label>"+ "<label class='ECC_lb_size_12' style='font-weight:bold; '> "+ jsonResumenPedidos.estatusAlmacen + "</label>";
		 contenido += "</div>";
	
	contenido +="</td>";
	
	return contenido;
}

function generaEstatusDelResumenPedidoEntregaOtros(jsonResumenPedidos)
{
 
	let contenido =	"<td  id='td_resumenPedidos' align='center' style='padding:5px; vertical-align: middle;'>";
	

		 contenido += "<div style='cursor: pointer;' onclick=\"mostrarDetalleDelSeguimientoDelPedidoOtros('"+ jsonResumenPedidos.pedido+"','" +jsonResumenPedidos.pedido+"-M,0-R,0-T,0-T,0-T" + "')\">";
		 
		  contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/" + jsonResumenPedidos.idEstatusPng + "' class='ECC_img_EstatusPedido' ><BR>";
		 

		 contenido += "<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Estatus CDO: " + "</label>"+ "<label class='ECC_lb_size_12' style='font-weight:bold;'> "+ jsonResumenPedidos.estatusEntrega + "</label>";
		 contenido += "</div>";

	contenido +="</td>";
 
	return contenido;
}

function validarColorFondoColEstatusOtros(estatus, cve_estatus)
{
	let colorFondoBR="";
		
	if(cve_estatus <= 0){
		colorFondoBR="transparent";
	}
	else
	{
		switch(estatus)
		{
			case "Capturado":
				colorFondoBR="#EAF2F8";			
				break;
				
			case "Enviado":
				colorFondoBR="#EBF5FB";
				break;
				
			case "DetenidoPorCredito":
				colorFondoBR="#FDEDEC";
				break;
				
			case "PorSurtir":
				colorFondoBR="#F2F4F4";
				break;
				
			case "Entregado":
				colorFondoBR="#EAFAF1";
				break;
				
			case "SinExistencia":
				colorFondoBR="#FDEDEC";
				break;
		}
	}	
	return colorFondoBR;
}

function validarColorLetraColEstatusOtros(estatus, cve_estatus)
{
	let colorLetra="";
		
	if(cve_estatus <= 0){
		colorLetra="black";
	}
	else
	{
		switch(estatus)
		{
			case "Capturado":
				colorLetra= "#154360"; 			
				break;
				
			case "Enviado":
				colorLetra= "#1B4F72"; 
				break;
				
			case "DetenidoPorCredito":
				colorLetra= "#C0392B"; 
				break;
				
			case "PorSurtir":
				colorLetra= "#424949"; 
				break;
				
			case "Entregado":
				colorLetra= "#186A3B"; 
				break;
				
			case "SinExistencia":
				colorLetra= "#C0392B"; 
				break;
		}
	}	
	return colorLetra;
}


/*** CONSULTA DETALLE DE RESUMEN DE PEDIDOS ***/
         
function mostrarDetalleDelSeguimientoDelPedidoOtros(pedido, pedidosCDO)
{
	document.location.href = "#"; 
	document.getElementById('cargando').style.display = 'block';
	$("#lb_detallePedido").text(pedido);
	$.ajax({
	    url :'SeguimientoDePedidos',
	    data : "vista=CarritoDeCompras.jsp&operacion=ConsultaPedidoDetalleClienteOtrosPedidos&pedidos=" + pedidosCDO + "&pedidoWWW=" + pedido , 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	
	    	document.getElementById('cargando').style.display = 'none';
	    	cargaDetallePedidosOtros(json)
	    	 MostrarDiv("SeguimientoDePedidoDetalle");
		},
		error : function(xhr, status, error)
		{
			
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='http://www.cdoautopartes.com.mx/';
			}
			else
				alert('Error al consultar Detalle de Pedidos.')
		}
	});
	
	
	
}

function cargaDetallePedidosOtros(jsonPedidos)
{
	
	contenido = "";
	$("#PedidosDetalle").empty();	
	
  	contenido += GeneraTablaEstatusOtros(jsonPedidos);
	
	contenido += "<table id='tb_resumenPedidos' align='center' cellpadding=0px; cellspacing=0px; class='table table-bordered' style='width:100%; background:white' data-page-length='5'>";
	contenido += GeneraEncabezadoTablaPedidoOtros();
	
    	
	contenido += "<tbody id='tbd_resumenPedidos'>" ;
	for(let i=0; i < jsonPedidos.length ; i++)
	{
      	contenido += GeneraDetalleTablaPedidoOtros(jsonPedidos[i].detallePedidoCdo);
	}
	contenido += "</tbody>" ;
	contenido += "</table> <hr align='CENTER' size='2' width='98%' color='#CCCCCC' noshade=''> </div> </div>";
	
	 contenido += GeneraeTablaFacturasOtros(jsonPedidos) 
	
	
	$("#PedidosDetalle").append(contenido);	
	 aplicarEstiloTablaDEtallePedidosOtros();		
}

function GeneraTablaEstatusOtros(jsonPedidos)
{
	let contenido = "<table id='tb_Estatus' align='center' cellpadding=0px; cellspacing=0px; class='table table-bordered' style='width: auto; background:white' data-page-length='5'>"+
	"<thead  id='thd_Estatus' style='background-color:white; color:#0054A2' >"+
		"<tr id='tr_Estatus'>"; 

	for(let i=0; i < jsonPedidos.length ; i++)
	{
		
		contenido += "<th id='th_Estatus' style='text-align: center;padding:2px;position: sticky;'>" +
		        "<table><tr><td>" +
				"<label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 0px;'>" +jsonPedidos[i].descripcionUname  + "</label> " +
				"<p style='margin-bottom: 0px;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 0px;'>PEDIDO: " +jsonPedidos[i].numPedido  + "</label></p></td> " ;
		
		contenido += "<td id='td_Estatus' align='center' style='padding:5px;background-color:#EBF5FB'><img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/"+ jsonPedidos[i].estatus+"'" ;
		
		
		
		contenido +=  " class='ECC_img_EstatusPedido'><br><label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> Estatus CDO: </label><label class='ECC_lb_size_12' " +
				"style='font-weight:bold; color:#1B4F72  ;'> "+ jsonPedidos[i].descripcionEstatus  +"</label></td>" +
		        "</tr></table>"+		
				"</th>" ;
	
	}
	
			contenido +="</tr>"+
			            "</thead>"+
			            "</table>  <hr align='CENTER' size='2' width='98%' color='#CCCCCC' noshade=''>" ;
			
	return contenido;
}
 

function GeneraEncabezadoTablaPedidoOtros()
{
	let contenido = "";
	
	contenido = "<thead  id='thd_resumenPedidos' style='background-color:white; color:#0054A2' >"+
		"<tr id='tr_resumenPedidos'>"+
		/*	"<th id='th_resumenPedidos1' style='text-align: center;padding:2px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>RENGLON</label> </th>"+*/
			"<th id='th_resumenPedidos1' style='text-align: center;padding:2px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>ARTICULO</label> </th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>DESCRIPCION</label></th>"+			
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>CVE. UNIDAD</label></th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>CANT. PEDIDA</label></th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>CANT. FACTURADA</label></th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>PRECIO UNITARIO</label></th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>IMPORTE</label></th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>FACTURA</label></th>"+
		"</tr>"+
	"</thead>";
return contenido;
	
}
	
 
function GeneraDetalleTablaPedidoOtros(jsonDetalleFac)
{
	let contenido = "";
	 
	for(let i=0; i < jsonDetalleFac.length ; i++)
	{
		contenido += "<tr id='tr_resumenPedidos'>"; 
	/*	contenido +=	"<td  id='td_resumenPedidos' style='padding:5px' align='center'>"+
		                "<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Renglon: " + "</label>"+
		                "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + contador + "</label>"+
		                "</td>";
		*/
		contenido +=	"<td  id='td_resumenPedidos' style='padding:5px' align='left'>"+
        "<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Articulo: " + "</label>"+
        "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonDetalleFac[i].numArt + "</label>"+
        "</td>";
		contenido +=	"<td  id='td_resumenPedidos' style='padding:5px' align='left'>"+
        "<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Descripcion: " + "</label>"+
        "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonDetalleFac[i].descripcion + "</label>"+
        "</td>";
		contenido +=	"<td  id='td_resumenPedidos' style='padding:5px' align='center'>"+
        "<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Cve. Unidad: " + "</label>"+
        "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonDetalleFac[i].cveUnidad + "</label>"+
        "</td>";
		contenido +=	"<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
        "<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Cant. Pedida: " + "</label>"+
        "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonDetalleFac[i].cantPedida + "</label>"+
        "</td>";
		contenido +=	"<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
        "<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Cant. Surt: " + "</label>"+
        "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonDetalleFac[i].cantSurt + "</label>"+
        "</td>";
		contenido +=	"<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
        "<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Precio Unit.: " + "</label>"+
        "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> $ "  + jsonDetalleFac[i].precioUni + "</label>"+
        "</td>";
		contenido +=	"<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
        "<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Importe: " + "</label>"+
        "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> $ "  + jsonDetalleFac[i].importe + "</label>"+
        "</td>";
		contenido +=	"<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
        "<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Factura: " + "</label>"+
        "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonDetalleFac[i].factura + "</label>"+
        "</td>";
		contenido += "</tr>"; 

		}
 
return contenido;
	
}


function GeneraeTablaFacturasOtros(jsonPedidos)
{
	 let contenido = "<table id='tb_resumenPedidos' align='center' cellpadding=0px; cellspacing=0px; class='table table-bordered' style='width:90%; background:white' data-page-length='5'>"+
	                 "<thead  id='thd_resumenPedidos' style='background-color:white; color:#0054A2' >"+
		             "<tr id='tr_resumenPedidos'>"+
			         "<th id='th_resumenPedidos1' style='text-align: center;padding:2px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px; '>FACTURA</label> </th>"+
			         /*"<th id='th_resumenPedidos1' style='text-align: center;padding:2px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>IMPORTE</label> </th>"+
			         "<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>DESCUENTOS</label></th>"+*/			
			         "<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>SUBTOTAL</label></th>"+
			         "<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>I.V.A.</label></th>"+
			         "<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>TOTAL</label></th>";

			     	contenido +="</tr>";
			    	contenido +="</thead>";
			    	
			    	contenido += "<tbody id='tbd_resumenPedidos'>" ;
			    	
			    	var totalImporte = 0;
			    	var totalDescuentos = 0;
			    	var totalSubtotal = 0;
			    	var totalIva = 0;
			    	var totalTotalFacturas = 0;
			    	for(let i=0; i < jsonPedidos.length ; i++)
			    	{
			    		PedidoDetalle = jsonPedidos[i].detallePedidoCdo;
			    	
			    		// contenido += cargaInfoFaturaOtros(jsonPedidos[i].detallePedidoCdo)
			    		 var facturaAuxiliar = "";
			    			for(let i=0; i < PedidoDetalle.length ; i++)
			    			{
			    				if (facturaAuxiliar !=  PedidoDetalle[i].factura)
			    					{
			    				contenido += "<tr id='tr_resumenPedidos'>";	
			    				contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='left'>"+
			    				"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
			    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>"  + PedidoDetalle[i].factura + "</label>"+
			    				"</td>";
			    			/*	contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
			    				"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
			    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> $ "  + PedidoDetalle[i].importeFac + "</label>"+
			    				"</td>";
			    				contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
			    				"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
			    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> $ "  + PedidoDetalle[i].descuentosFac + "</label>"+
			    				"</td>";*/
			    				contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
			    				"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
			    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> $ "  + PedidoDetalle[i].subtotalFac + "</label>"+
			    				"</td>";
			    				contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
			    				"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
			    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> $ "  + PedidoDetalle[i].ivaFac + "</label>"+
			    				"</td>";
			    				contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
			    				"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
			    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> $ "  + PedidoDetalle[i].totalFAc + "</label>"+
			    				"</td></tr>";
			    				facturaAuxiliar =  PedidoDetalle[i].factura;
			    				
			    		    	totalImporte = totalImporte + Number.parseFloat(PedidoDetalle[i].importeFac);
						    	totalDescuentos = totalDescuentos + Number.parseFloat(PedidoDetalle[i].descuentosFac);
						    	totalSubtotal = totalSubtotal + Number.parseFloat(PedidoDetalle[i].subtotalFac);
						    	totalIva = totalIva + Number.parseFloat(PedidoDetalle[i].ivaFac);
						    	totalTotalFacturas = totalTotalFacturas + Number.parseFloat(PedidoDetalle[i].totalFAc);
			    					}
			    			}
			    	}
			    	
			    	contenido += "<tr id='tr_resumenPedidos'>";	
    				contenido += "<td  id='td_resumenPedidos' style='padding:5px; background-color: black;' align='right'>"+
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'> "+ "TOTALES" + "</label>"+
    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:white;'>  TOTALES </label>"+
    				"</td>";
    				/*contenido += "<td  id='td_resumenPedidos' style='padding:5px; background-color: black;' align='right'>"+
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:white;'>"  + currencyFormat(totalImporte); + "</label>"+
    				"</td>";
    				contenido += "<td  id='td_resumenPedidos' style='padding:5px; background-color: black;' align='right'>"+
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:white;'>"  +  currencyFormat(totalDescuentos) + "</label>"+
    				"</td>";*/
    				contenido += "<td  id='td_resumenPedidos' style='padding:5px; background-color: black;' align='right'>"+
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'> "  + currencyFormat(totalSubtotal) + "</label>"+
    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:white;'>"  + currencyFormat(totalSubtotal) + "</label>"+
    				"</td>";
    				contenido += "<td  id='td_resumenPedidos' style='padding:5px; background-color: black;' align='right'>"+
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'> "  + currencyFormat(totalIva) + "</label>"+
    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:white;'>"  + currencyFormat(totalIva) + "</label>"+
    				"</td>";
    				contenido += "<td  id='td_resumenPedidos' style='padding:5px; background-color: black;' align='right'>"+
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'>"  + currencyFormat(totalTotalFacturas) + "</label>"+
    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:white;'>"  + currencyFormat(totalTotalFacturas) + "</label>"+
    				"</td></tr>";
			    	
			    	contenido += "</tbody>" ;
	
    contenido += "</table>";	
	return contenido;
}


function cargaInfoFaturaOtros(jsonPedidos)
{
	 let contenido = "";
	 var facturaAuxiliar = "";
	for(let i=0; i < jsonPedidos.length ; i++)
	{
		if (facturaAuxiliar !=  jsonPedidos[i].factura)
			{
		contenido += "<tr id='tr_resumenPedidos'>";	
		contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='left'>"+
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:#0054A2;'>"  + jsonPedidos[i].factura + "</label>"+
		"</td>";
		contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:#0054A2;'>"  + currencyFormat(jsonPedidos[i].importeFac) + "</label>"+
		"</td>";
		contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:#0054A2;'>"  + currencyFormat(jsonPedidos[i].descuentosFac) + "</label>"+
		"</td>";
		contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:#0054A2;'>"  + currencyFormat(jsonPedidos[i].subtotalFac) + "</label>"+
		"</td>";
		contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:#0054A2;'>"  + currencyFormat(jsonPedidos[i].ivaFac) + "</label>"+
		"</td>";
		contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Fecha Pedido: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:#0054A2;'>"  +  currencyFormat(jsonPedidos[i].totalFAc) + "</label>"+
		"</td></tr>";
		facturaAuxiliar =  jsonPedidos[i].factura;
			}
	}
	return contenido;
}


function currencyFormat(num) {
	  return '$ ' + num.toFixed(2).replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
	}

