/*** ACCIONES PRINCIPALES  ***/
function cargaInicialDeLosPedidos()
{
	$("#navbarsExample02").collapse('hide');
	  $("#navbarsExample02").removeClass("in");
	$('#txt_fechaIniResumenPedido').val(ObtenerFechaActual());
	$('#txt_fechaFinResumenPedido').val(ObtenerFechaActual());
	ocultarControlesSeguimiento();
	consultaResumenHistorialPedidos(false)
}

function ocultarControlesSeguimiento()
{
	OcultarDiv("divConsultaPorAplicacion");
	OcultarDiv("divEstadoDeCuenta");
	OcultarDiv("SeguimientoDePedidoDetalle");
	OcultarDiv("divCarritoDeComprasArticulos");	
	OcultarDiv("divSeguimientoOtrosPedido");	
	MostrarDiv("divSeguimientoDePedido");	
	
}


/*** CONSULTA RESUMEN DE PEDIDOS ***/
function consultaResumenHistorialPedidos(consultaInicial)
{
	document.getElementById('cargando').style.display = 'block';		
	let fechaIni="NA";
	let fechaFin="NA";
	let NumeroPedido=0;	
	if(consultaInicial == true)
	{
		if( $("#txt_numResumenPedido").val().length > 0)
		{
			NumeroPedido= $("#txt_numResumenPedido").val();
			fechaIni="NA";
			fechaFin="NA";
		}
		else
		{
			fechaIni = $("#txt_fechaIniResumenPedido").val();
			fechaFin =  $("#txt_fechaFinResumenPedido").val();
		}
	}
		
	$.ajax({
	    url :'SeguimientoDePedidos',
	    data : "vista=CarritoDeCompras.jsp&operacion=ConsultaSeguimientoDePedido&fechaIni=" + fechaIni + "&fechaFin=" + fechaFin + "&NumeroPedido=" + NumeroPedido, 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	document.getElementById('cargando').style.display = 'none';		    	
	    	cargaResumenHistorialPedidos(json)
	    	OcultarDiv("divCarritoDeComprasArticulos");
	    	OcultarDiv("divSeguimientoOtrosPedido");
	    	MostrarDiv("divSeguimientoDePedido"); 
	    	 
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

function cargaResumenHistorialPedidos(jsonResumenPedidos)
{
	 
	$('#dgResumenHistorialPedidos').empty();
	let contenido = generaTitulosResumenHistorialPedidos();	
	for(let i=0; i < jsonResumenPedidos.length ; i++)
	{
		contenido += "<tr id='tr_resumenPedidos'>";		
		contenido+=	generaColumnaInfoPedido(jsonResumenPedidos[i]);
		contenido+=	generaEstatusDelResumenPedido(jsonResumenPedidos[i])
		contenido+=	generaEstatusDelResumenPedidoEntrega(jsonResumenPedidos[i])
	}
	contenido +="</tbody>" +
	"</table>";
	$("#dgResumenHistorialPedidos").append(contenido);
	aplicarEstiloTablaResumenPedidos();		
}


/*** CONSTRUYE TABLA DE RESUMEN DE PEDIDOS ***/
function generaTitulosResumenHistorialPedidos()
{
	let contenido = "<table id='tb_resumenPedidos' align='center' cellpadding=0px; cellspacing=0px; class='table table-bordered' style='width:90%; background:white' data-page-length='5'>"+
						"<thead  id='thd_resumenPedidos' style='background-color:white; color:#0054A2' >"+
							"<tr id='tr_resumenPedidos'>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:2px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>PEDIDO</label> </th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:2px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>FECHA</label> </th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:2px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>HORA</label> </th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>CANT. PEDIDA</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>TRANSPORTE</label></th>"+
								//"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>CANT. SURTIDA</label></th>"+
								// "<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>IMPORTE PEDIDO</label></th>"+
								// "<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>IMPORTE FACTURADO</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>PEDIDO CDO</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>PEDIDO BR</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>PEDIDO 72Hrs 1</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>PEDIDO 72Hrs 2</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>PEDIDO 72Hrs 3</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>ESTATUS ALMACEN</label></th>"+
								"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>ESTATUS ENTREGA</label></th>"+
							// 	"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'>ESTATUS BR</label></th>"+
							"</tr>"+
						"</thead>"+
						"<tbody id='tbd_resumenPedidos'>" ;
	return contenido;
}

function generaColumnaInfoPedido(jsonResumenPedidos)
{
	 
	var arr72Hrs = ['0','0','0'];
	var pedidos72Hrs = jsonResumenPedidos.Ped72Hrs.split(",");
	var arr72HrsDescrip = ['','',''];
	var pedidos72HrsDescrip = jsonResumenPedidos.Ped72HrsDescrip.split(",");
	
	for (var i = 0; i < pedidos72Hrs.length; i++) {
		arr72Hrs[i] = pedidos72Hrs[i] ;
		}
	
	for (var i = 0; i < pedidos72HrsDescrip.length; i++) {
		arr72HrsDescrip[i] = pedidos72HrsDescrip[i] ;
		}
	
	let contenido =	"<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
			"<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Numero Pedido: " + "</label>"+
			"<label class='ECC_lb_size_14' style='font-weight: bold; color:#153D89 ; text-decoration:underline;cursor: pointer;'  onclick=\"mostrarDetalleDelSeguimientoDelPedido('"+ jsonResumenPedidos.pedido+"','" +jsonResumenPedidos.PedMayCdo+"-M,"+ jsonResumenPedidos.PedMayBr + "-R," + arr72Hrs[0] +"-T," + arr72Hrs[1] +"-T," + arr72Hrs[2] +"-T" + "')\">  "  + jsonResumenPedidos.pedido + "</label>"+
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
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Cantidad Pedida: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonResumenPedidos.transporte  + "</label>"+
		"</td>";
		
		/*
		 * 		
		contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='center'>"+
			"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Cantidad Surtida: " + "</label>"+
			"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonResumenPedidos.cantSurtida + "</label>"+
			"</td>";
		
		contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
			"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Importe Pedido: " + "</label>"+
		 	"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> $"  + jsonResumenPedidos.importePedido  + "</label>"+
		 	"</td>";
	
		contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
			"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Importe Facturado: " + "</label>"+
			"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  $"  + jsonResumenPedidos.importeFacturado  + "</label>"+
			"</td>";
	*/		
		contenido += "<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
			 "<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Pedido CDO: " + "</label>"+
			 "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonResumenPedidos.PedMayCdo  + "</label>"+
			 "</td>";
			 
		contenido += "<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
			"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Pedido BR: " + "</label>"+
			"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonResumenPedidos.PedMayBr  + "</label>"+
			"</td>";
		contenido += "<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Pedido BR: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + arr72HrsDescrip[0]  + "</label>"+
		"</td>";
		contenido += "<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Pedido BR: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + arr72HrsDescrip[1]  + "</label>"+
		"</td>";
		contenido += "<td  id='td_resumenPedidos' style='padding:5px; vertical-align: middle;' align='center'>"+
		"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Pedido BR: " + "</label>"+
		"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + arr72HrsDescrip[2]  + "</label>"+
		"</td>";
			 
	return contenido;
}

function generaEstatusDelResumenPedido(jsonResumenPedidos)
{
	var arr72Hrs = ['0','0','0'];
	var pedidos72Hrs = jsonResumenPedidos.Ped72Hrs.split(",");
	var arr72HrsDescrip = ['','',''];
	var pedidos72HrsDescrip = jsonResumenPedidos.Ped72HrsDescrip.split(",");
	
	for (var i = 0; i < pedidos72Hrs.length; i++) {
		arr72Hrs[i] = pedidos72Hrs[i] ;
		}
	
	for (var i = 0; i < pedidos72HrsDescrip.length; i++) {
		arr72HrsDescrip[i] = pedidos72HrsDescrip[i] ;
		}
	
	let colorLetraCDO =  "color:" + validarColorLetraColEstatus(jsonResumenPedidos.EstatusCdo , jsonResumenPedidos.cveEstatusCdo );
	let colorFondoCDO =  "background-color:" + validarColorFondoColEstatus(jsonResumenPedidos.EstatusCdo , jsonResumenPedidos.cveEstatusCdo);
	let colorLetraBR  =  "color:" + validarColorLetraColEstatus(jsonResumenPedidos.EstatusBr , jsonResumenPedidos.cveEstatusBr);
	let colorFondoBR  =  "background-color: " + validarColorFondoColEstatus(jsonResumenPedidos.EstatusBr , jsonResumenPedidos.cveEstatusBr);
	
	let contenido =	"<td  id='td_resumenPedidos' align='center' style='padding:5px; vertical-align: middle;" + colorFondoCDO + "'>";
	if(jsonResumenPedidos.cveEstatusCdo > 0)
	{
		/*
		contenido += '<input type="image" src="https://webcdo.cdoautopartes.com.mx/image/paginaInicio/Est' + jsonResumenPedidos.EstatusCdo + '.png" class="ECC_img_EstatusPedido" onclick="mostrarDetalleDelSeguimientoDelPedido("'+ jsonResumenPedidos.pedido+'","' +jsonResumenPedidos.PedMayCdo+'-M,'+ jsonResumenPedidos.PedMayBr + '-R,' + arr72Hrs[0] +'-T,' + arr72Hrs[1] +"-T," + arr72Hrs[2] +"-T" + '")">';
		contenido += "<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Estatus CDO: " + "</label>"+ "<label class='ECC_lb_size_12' style='font-weight:bold; " +colorLetraCDO+ "  ;'> "+ jsonResumenPedidos.EstatusCdo + "</label>";
		contenido += "</input>";
		*/
		/*ANTERIOIR OK */
		 contenido += "<div style='cursor: pointer;' onclick=\"mostrarDetalleDelSeguimientoDelPedido('"+ jsonResumenPedidos.pedido+"','" +jsonResumenPedidos.PedMayCdo+"-M,"+ jsonResumenPedidos.PedMayBr + "-R," + arr72Hrs[0] +"-T," + arr72Hrs[1] +"-T," + arr72Hrs[2] +"-T" + "')\">";
		 
		//  contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/Est" + jsonResumenPedidos.EstatusCdo + ".png' class='ECC_img_EstatusPedido' ><BR>";
		 
		 if(jsonResumenPedidos.EstatusCdo =="Capturado" )
			{
		contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/Est"+ jsonResumenPedidos.EstatusCdo + ".png' class='ECC_img_EstatusPedido' ><BR>";
			}
		 else if ( jsonResumenPedidos.EstatusCdo =="Facturado" )
			 {
			 contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/EstEntregado.png' class='ECC_img_EstatusPedido' ><BR>";
			 }
		else
			{
			contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/EstCapturado.png' class='ECC_img_EstatusPedido' ><BR>";
			}
		 if ( arr72Hrs[0] > 0)
			 {
			 contenido += "<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Estatus CDO: " + "</label>"+ "<label class='ECC_lb_size_12' style='font-weight:bold; " +colorLetraCDO+ "  ;'> Traspaso 72 Hrs.</label>";	 
			 }else{
		 contenido += "<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Estatus CDO: " + "</label>"+ "<label class='ECC_lb_size_12' style='font-weight:bold; " +colorLetraCDO+ "  ;'> "+ jsonResumenPedidos.EstatusCdo + "</label>";
			 }
		 contenido += "</div>";
	}
	contenido +="</td>";
	
	/*YA NO SE COLOCA STATUS BR*/
/*	contenido +=	"<td  id='td_resumenPedidos' align='center' style='padding:5px;" +colorFondoBR+ "'>";
	if( jsonResumenPedidos.cveEstatusBr > 0)
	{
		contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/Est" +jsonResumenPedidos.EstatusBr + ".png' class='ECC_img_EstatusPedido'><BR>";
		contenido += "<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Estatus BR: " + "</label>"+ "<label class='ECC_lb_size_12' style='font-weight: bold; color:"+colorLetraBR +"  ;'> "+ jsonResumenPedidos.EstatusBr + "</label>";
	}
	contenido +="</td>";
	*/
	return contenido;
}

function generaEstatusDelResumenPedidoEntrega(jsonResumenPedidos)
{
	var arr72Hrs = ['0','0','0'];
	var pedidos72Hrs = jsonResumenPedidos.Ped72Hrs.split(",");
	var arr72HrsDescrip = ['','',''];
	var pedidos72HrsDescrip = jsonResumenPedidos.Ped72HrsDescrip.split(",");
	
	for (var i = 0; i < pedidos72Hrs.length; i++) {
		arr72Hrs[i] = pedidos72Hrs[i] ;
		}
	
	for (var i = 0; i < pedidos72HrsDescrip.length; i++) {
		arr72HrsDescrip[i] = pedidos72HrsDescrip[i] ;
		}
	
	let colorLetraCDO =  "color:" + validarColorLetraColEstatus(jsonResumenPedidos.EstatusCdo , jsonResumenPedidos.cveEstatusCdo );
	let colorFondoCDO =  "background-color:" + validarColorFondoColEstatus(jsonResumenPedidos.EstatusCdo , jsonResumenPedidos.cveEstatusCdo);
	let colorLetraBR  =  "color:" + validarColorLetraColEstatus(jsonResumenPedidos.EstatusBr , jsonResumenPedidos.cveEstatusBr);
	let colorFondoBR  =  "background-color: " + validarColorFondoColEstatus(jsonResumenPedidos.EstatusBr , jsonResumenPedidos.cveEstatusBr);
	
	let contenido =	"<td  id='td_resumenPedidos' align='center' style='padding:5px; vertical-align: middle;" + colorFondoCDO + "'>";
	
	 
	
	if(jsonResumenPedidos.cveEstatusCdo > 0)
	{
		/*
		contenido += '<input type="image" src="https://webcdo.cdoautopartes.com.mx/image/paginaInicio/Est' + jsonResumenPedidos.EstatusCdo + '.png" class="ECC_img_EstatusPedido" onclick="mostrarDetalleDelSeguimientoDelPedido("'+ jsonResumenPedidos.pedido+'","' +jsonResumenPedidos.PedMayCdo+'-M,'+ jsonResumenPedidos.PedMayBr + '-R,' + arr72Hrs[0] +'-T,' + arr72Hrs[1] +"-T," + arr72Hrs[2] +"-T" + '")">';
		contenido += "<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Estatus CDO: " + "</label>"+ "<label class='ECC_lb_size_12' style='font-weight:bold; " +colorLetraCDO+ "  ;'> "+ jsonResumenPedidos.EstatusCdo + "</label>";
		contenido += "</input>";
		*/
		/*ANTERIOIR OK */
		 contenido += "<div style='cursor: pointer;' onclick=\"mostrarDetalleDelSeguimientoDelPedido('"+ jsonResumenPedidos.pedido+"','" +jsonResumenPedidos.PedMayCdo+"-M,"+ jsonResumenPedidos.PedMayBr + "-R," + arr72Hrs[0] +"-T," + arr72Hrs[1] +"-T," + arr72Hrs[2] +"-T" + "')\">";
		 
		 
		  contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/" + jsonResumenPedidos.imgEntrega + "' class='ECC_img_EstatusPedido' ><BR>";
		 
	/*	 if(jsonResumenPedidos.EstatusCdo =="Capturado" )
			{
		contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/Est"+ jsonResumenPedidos.EstatusCdo + ".png' class='ECC_img_EstatusPedido' ><BR>";
			}
		 else if ( jsonResumenPedidos.EstatusCdo =="Facturado" )
			 {
			 contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/EstEntregado.png' class='ECC_img_EstatusPedido' ><BR>";
			 }
		else
			{
			contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/EstCapturado.png' class='ECC_img_EstatusPedido' ><BR>";
			}
		*/ 

		 contenido += "<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Estatus CDO: " + "</label>"+ "<label class='ECC_lb_size_12' style='font-weight:bold; " +colorLetraCDO+ "  ;'> "+ jsonResumenPedidos.estatusEntrega + "</label>";
	}
	contenido +="</td>";
	
	/*YA NO SE COLOCA STATUS BR*/
/*	contenido +=	"<td  id='td_resumenPedidos' align='center' style='padding:5px;" +colorFondoBR+ "'>";
	if( jsonResumenPedidos.cveEstatusBr > 0)
	{
		contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/Est" +jsonResumenPedidos.EstatusBr + ".png' class='ECC_img_EstatusPedido'><BR>";
		contenido += "<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Estatus BR: " + "</label>"+ "<label class='ECC_lb_size_12' style='font-weight: bold; color:"+colorLetraBR +"  ;'> "+ jsonResumenPedidos.EstatusBr + "</label>";
	}
	contenido +="</td>";
	*/
	return contenido;
}

function validarColorFondoColEstatus(estatus, cve_estatus)
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

function validarColorLetraColEstatus(estatus, cve_estatus)
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
function mostrarDetalleDelSeguimientoDelPedido(pedido, pedidosCDO)
{
	
	
	document.location.href = "#"; 
	document.getElementById('cargando').style.display = 'block';
	$("#lb_detallePedido").text(pedido);
	$.ajax({
	    url :'SeguimientoDePedidos',
	    data : "vista=CarritoDeCompras.jsp&operacion=ConsultaPedidoDetalleCliente&pedidos=" + pedidosCDO + "&pedidoWWW=" + pedido , 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
	    	//alert(JSON.stringify(json)); 
	    	cargaDetallePedidos(json)
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
				alert('Servicio no disponible, intente mas tarde.')
		}
	});
	
	
	
}

function cargaDetallePedidos(jsonPedidos)
{
	contenido = "";
	$("#PedidosDetalle").empty();	
	
  	contenido += GeneraTablaEstatus(jsonPedidos);
	
	contenido += "<table id='tb_resumenPedidos' align='center' cellpadding=0px; cellspacing=0px; class='table table-bordered' style='width:100%; background:white' data-page-length='5'>";
	contenido += GeneraEncabezadoTablaPedido();
	
    	
	contenido += "<tbody id='tbd_resumenPedidos'>" ;
	
	for(let i=0; i < jsonPedidos.length ; i++)
	{
      	contenido += GeneraDetalleTablaPedido(jsonPedidos[i].detallePedidoCdo);
	}
	contenido += "</tbody>" ;
	contenido += "</table> <hr align='CENTER' size='2' width='98%' color='#CCCCCC' noshade=''> </div> </div>";
	
	 contenido += GeneraeTablaFacturas(jsonPedidos) 
	
	
	$("#PedidosDetalle").append(contenido);	
 	aplicarEstiloTablaDEtallePedidos();		
}

function GeneraTablaEstatus(jsonPedidosCompletos)
{
	let jsonPedidos = jsonPedidosCompletos[0].pedidoCdo;
	
	let contenido = "<table id='tb_Estatus' align='center' cellpadding=0px; cellspacing=0px; class='table table-bordered' style='width: auto; background:white' data-page-length='5'>"+
	"<thead  id='thd_Estatus' style='background-color:white; color:#0054A2' >"+
		"<tr id='tr_Estatus'>"; 
	 //alert("jsonPedidos.length: "+ JSON.stringify(jsonPedidos));
	for(let i=0; i < jsonPedidos.length ; i++)
	{
		if (jsonPedidos[i].numPedido  > 0)
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
	}
	
			contenido +="</tr>"+
			            "</thead>"+
			            "</table>  <hr align='CENTER' size='2' width='98%' color='#CCCCCC' noshade=''>" ;
			
	return contenido;
}
 

function GeneraEncabezadoTablaPedido()
{
	let contenido = "";
	
	contenido = "<thead  id='thd_resumenPedidos' style='background-color:white; color:#0054A2' >"+
		"<tr id='tr_resumenPedidos'>"+
		/*	"<th id='th_resumenPedidos1' style='text-align: center;padding:2px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold;'>RENGLON</label> </th>"+*/
			"<th id='th_resumenPedidos1' style='text-align: center;padding:2px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>ARTICULO</label> </th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>DESCRIPCION</label></th>"+			
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>CVE. UNIDAD</label></th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px; background-color: #EBF5FB; width: 84px;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>CANT.  PEDIDA</label></th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px; background-color: #EBF5FB; width: 84px;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>CANT.  72 hrs.</label></th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px; background-color: #EBF5FB; width: 84px;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>CANT. FACTURA</label></th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>PRECIO UNITARIO</label></th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>IMPORTE</label></th>"+
			"<th id='th_resumenPedidos1' style='text-align: center;padding:5px;position: sticky; background-color: #EBF5FB;'><label class='EPP_lb_size_12' style='font-weight: bold; margin-bottom: 1px;'>FACTURA</label></th>"+
		"</tr>"+
	"</thead>";
return contenido;
	
}
	
 
function GeneraDetalleTablaPedido(jsonDetalleFac)
{
	let contenido = "";
//	alert("jsonPedidos.length: "+ JSON.stringify(jsonDetalleFac));
	for(let i=0; i < jsonDetalleFac.length ; i++)
	{
	// if (jsonDetalleFac[i].numArt.trim() != "" && (jsonDetalleFac[i].cantSurt > 0  && jsonDetalleFac[i].factura != "" )  || jsonDetalleFac[i].cant72Hrs > 0 )
		if (jsonDetalleFac[i].numArt.trim() != ""  )
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
		
		if (jsonDetalleFac[i].cant72Hrs > 0  )
		{
			
			var tooltip =  "";
			var cantSurt72 = jsonDetalleFac[i].cant72Hrs;
			/*if ( jsonDetalleFac[i].cantSurt == 0)
			{
				cantSurt72 = 0;
			}*/
			if (jsonDetalleFac[i].cdoTraspaso != "")
			{
				tooltip ="Mercancia enviada por CDO " + jsonDetalleFac[i].cdoTraspaso ;
			}
			contenido +=	"<td  id='td_resumenPedidos' style='padding:5px; background-color: #fbfbb3;' align='right' title='"+ tooltip +"'>"+
			"<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Ped. 72hrs: " + "</label>"+
			// "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'  >  "  + jsonDetalleFac[i].cant72Hrs + "</label>"+
			"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'  >  "  + cantSurt72 + "</label>"+
			"</td>";
			
			
		}
		else
		{
			contenido +=	"<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
			"<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Ped. 72hrs: " + "</label>"+
			"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonDetalleFac[i].cant72Hrs + "</label>"+
			"</td>";
		}
		
		if (jsonDetalleFac[i].cant72Hrs == 0 &&  jsonDetalleFac[i].cantSurt == 0)
		{
			contenido +=	"<td  id='td_resumenPedidos' style='padding:5px; background-color: #ffb5b5;'  align='right'>"+
	        "<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Cant. Surt: " + "</label>"+
	        "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonDetalleFac[i].cantSurt + "</label>"+
	        "</td>";	
		}else
			{
		contenido +=	"<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
        "<label class='EPP_vista_movil' style='font-weight: bold; color:#0054A2;font-size: 16px;'> "+ "Cant. Surt: " + "</label>"+
        "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'>  "  + jsonDetalleFac[i].cantSurt + "</label>"+
        "</td>";
			}
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
		}
 
return contenido;
	
}


function GeneraeTablaFacturas(jsonPedidos)
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
			    	
			    		// contenido += cargaInfoFatura(jsonPedidos[i].detallePedidoCdo)
			    		 var facturaAuxiliar = "";
			    			for(let i=0; i < PedidoDetalle.length ; i++)
			    			{
			    				if (facturaAuxiliar !=  PedidoDetalle[i].factura )
			    					{
			    					if (PedidoDetalle[i].factura !="")
			    						{
			    				contenido += "<tr id='tr_resumenPedidos'>";	
			    				contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='left'>"+
			    				"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Factura: " + "</label>"+
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
			    				"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Subtotal: " + "</label>"+
			    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> $ "  + PedidoDetalle[i].subtotalFac + "</label>"+
			    				"</td>";
			    				contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
			    				"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Iva: " + "</label>"+
			    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> $ "  + PedidoDetalle[i].ivaFac + "</label>"+
			    				"</td>";
			    				contenido += "<td  id='td_resumenPedidos' style='padding:5px' align='right'>"+
			    				"<label class='EPP_vista_movil' style='font-weight: bold; color:black;font-size: 12px;'> "+ "Total: " + "</label>"+
			    				"<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> $ "  + PedidoDetalle[i].totalFAc + "</label>"+
			    				"</td></tr>";
			    				facturaAuxiliar =  PedidoDetalle[i].factura;
			    				
			    				var ttlImporte = PedidoDetalle[i].importeFac.replace(',', '');
			    		    	totalImporte = totalImporte + Number.parseFloat(ttlImporte);
			    		    	
			    		    	var ttDescuentos = PedidoDetalle[i].descuentosFac.replace(',', '');
						    	totalDescuentos = totalDescuentos + Number.parseFloat(ttDescuentos);
						    	
						    	var subttlFac = PedidoDetalle[i].subtotalFac.replace(',', '');
						    	totalSubtotal = totalSubtotal + Number.parseFloat(subttlFac);
						    	
						    	var ttlIva = PedidoDetalle[i].ivaFac.replace(',', '');
						    	totalIva = totalIva + Number.parseFloat(ttlIva);
						    	
						    	// alert("PedidoDetalle[i].totalFAc: " + PedidoDetalle[i].totalFAc);
						    	var totalfac = PedidoDetalle[i].totalFAc.replace(',', '');
						    	// totalTotalFacturas = totalTotalFacturas + Number.parseFloat(PedidoDetalle[i].totalFAc);
						    	totalTotalFacturas = totalTotalFacturas + Number.parseFloat(totalfac);
			    						}
			    					}
			    			}
			    	}
			    	
			    	contenido += "<tr id='tr_resumenPedidos'>";	
    				contenido += "<td  id='td_resumenPedidos' style='padding:5px; background-color: black;' align='right'>"+
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'> "+ "TOTALES" + "</label>"+
    				"<label class='EPP_lb_size_12' style='font-weight: normal; color:white;'>  TOTALES </label>"+
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
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'> "+ "Subtotal: " + "</label>"+
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'> "  + currencyFormat(totalSubtotal) + "</label>"+
    				"<label class='EPP_lb_size_12' style='font-weight: normal; color:white;'>"  + currencyFormat(totalSubtotal) + "</label>"+
    				"</td>";
    				contenido += "<td  id='td_resumenPedidos' style='padding:5px; background-color: black;' align='right'>"+
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'> "+ "Iva: " + "</label>"+
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'> "  + currencyFormat(totalIva) + "</label>"+
    				"<label class='EPP_lb_size_12' style='font-weight: normal; color:white;'>"  + currencyFormat(totalIva) + "</label>"+
    				"</td>";
    			//	alert( "totalTotalFacturas: " + totalTotalFacturas );
    				contenido += "<td  id='td_resumenPedidos' style='padding:5px; background-color: black;' align='right'>"+
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'> "+ "Total: " + "</label>"+
    				"<label class='EPP_vista_movil' style='font-weight: bold; color:white;font-size: 12px;'>"  + currencyFormat(totalTotalFacturas) + "</label>"+
    				"<label class='EPP_lb_size_12' style='font-weight: normal; color:white;'>"  + currencyFormat(totalTotalFacturas) + "</label>"+
    				"</td></tr>";
			    	
			    	contenido += "</tbody>" ;
	
    contenido += "</table>";	
	return contenido;
}


function cargaInfoFatura(jsonPedidos)
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

