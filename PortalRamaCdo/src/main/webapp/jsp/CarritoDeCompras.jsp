<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="req" value="${pageContext.request}" /> <c:set var="url">${req.requestURL}</c:set> <c:set var="uri" value="${req.requestURI}" />
<c:set var="abc" value="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	
 
    
	<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-MK6GSZ7');</script>
<!-- End Google Tag Manager -->
	
	

	
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,  minimum-scale=1.0">
 
		<title>CDO ROA AutoPartes</title>
		<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/logo_cdo.png">	
		
		<meta name="keywords" content="mayorista de refacciones automotrices, mayoreo de autopartes, distribuidora de refacciones, mayoreo refacciones, distribuidor de refacciones, DISTRIBUIDOR KWX, distribuidor kwx, oep autopartes, OEP AUTOPARTES"></meta>
		<meta name="description" content="Somos una empresa mexicana lider en la venta de autopartes en cualquier poblacion del pais con el mejor tiempo de respuesta y la mejor relacion precio servicio, ponemos a su servicio nuestros 12 centros de distribucion colocados en puntos estrategicos del pais"></meta>
		<meta name="facebook-domain-verification" content="ps39bf05iqp7goa0u1hsrcpvci100s" />					
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
			
						
						
		<!--  CSS BOOTSTRAP  y JQUERY-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui-1.10.3.custom.css">
			
		<!--  JS PERSONALIZADO Y JQUERY -->
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/jsjquery.min.js"></script>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/ScriptGeneral.js"></script>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/ScriptLogin.js"></script>		
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/ScriptCarritoDeCompras.js"></script>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/ScriptEstadoDeCuenta.js"></script>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/ScriptSeguimientoDePedido.js"></script>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/ScriptSeguimientoOtrosPedido.js"></script>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/dataTables.bootstrap4.min.js"></script>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/popper.min.js"></script>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/ScriptCentroDeMensajes.js"></script>
		
		<!-- JS JSGRID -->
		<link rel='stylesheet prefetch' href="${pageContext.request.contextPath}/css/jsgrid.min.css"/> 
	    <link rel='stylesheet prefetch' href="${pageContext.request.contextPath}/css/jsgrid-theme.min.css"/> 
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jsgrid.js"></script> 
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jsgrid.min.js"></script>
	    
	    
	    
		<!-- JS BOOTSTRAP -->
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script> 
		 
		
		<!--  CSS PERSONALIZADO -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/EstilosGenerales.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/EstilosCarritoCompras.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/EstilosSeguimientoDePedidos.css">
		
					
		<!--  CSS y JS CALENDARIO -->
		<link rel="stylesheet" href="css/jquery-ui.css"/>
		<script src="js/jquery-ui.js"></script>
		
		<script type="text/javascript">
			function aplicarEstiloTabla() 
			{
				$('#tb_articulos').DataTable( {
					"lengthMenu":[[50, 75, 100], [50, 75 ,100]],
					
					"pageLength":50,
					 
			        "language": {
			            "lengthMenu": "Mostrar  _MENU_ productos.",
			            "zeroRecords": "No se encontraron productos.",
			            "info": " ",
			            "infoEmpty": "No se encontraron productos.",
			            "infoFiltered": "(Filtrando de _MAX_ registros totales)",
			            "sSearch": "Buscar:",
	            	    "sLoadingRecords": "Cargando...",
	            	    "oPaginate": {
		            	    "sFirst": "Primero",
		            	    "sLast": "Último",
		            	    "sNext": "Siguiente",
		            	    "sPrevious": "Anterior"
	            	   },
			        }
			    } );
				
			}
			
			
			
			function aplicarEstiloTablaDetalleArticulos() 
			{
// 				   $('#tb_articulosDetalle').DataTable();
				$('#tb_articulosDetalle').DataTable( {
					 ordering: true,
					  "paging": false,
			        "language": {
			            "lengthMenu": "Mostrar  _MENU_ productos.",
			            "zeroRecords": "No se encontraron productos.",
			            "infoEmpty": "No se encontraron productos.",
			            "infoFiltered": "(Filtrando de _MAX_ registros totales)",
			            "sSearch": "Buscar:",
			            "dom" : "<'row' <'col-md-6 pull-left form-group' f>>" ,
	            	    "sLoadingRecords": "Cargando..."
	            	    ,
			        }
			    } );
				
			}
			
			function aplicarEstiloTablaPedidoCarrito() 
			{
				
				$('#tb_articulosPedCarrito').DataTable( {
					"lengthMenu":[[50, 75, 100], [50, 75 ,100]],
					"pageLength":50,
			        "language": {
			            "lengthMenu": "Mostrar  _MENU_ productos.",
			            "zeroRecords": "No se encontraron productos.",
			             "info": " ",
			            "infoEmpty": "No se encontraron productos.",
			            "infoFiltered": "(Filtrando de _MAX_ registros totales)",
			            "sSearch": "Buscar:",
	            	    "sLoadingRecords": "Cargando...",
	            	    "oPaginate": {
		            	    "sFirst": "Primero",
		            	    "sLast": "Último",
		            	    "sNext": "Siguiente",
		            	    "sPrevious": "Anterior"
	            	   },
			        }
			    } );
			} 
			
			
			function aplicarEstiloTablaResumenPedidos() 
			{
				
				$('#tb_resumenPedidos').DataTable( {
					 "retrieve": true,
					    "paging": false,
					"lengthMenu": [[50, 75, 100], [50, 75 ,100]],
					 "order": [[ 1, "desc" ]],

						"pageLength":50,
			        "language": {
			            "lengthMenu": "Mostrar  _MENU_ pedidos.",
			            "zeroRecords": "No se encontraron pedidos.",
			            "info": " ",
			            "infoEmpty": "No se encontraron pedidos.",
			            "infoFiltered": "(Filtrando de _MAX_ registros totales)",
			            "sSearch": "Buscar:",
	            	    "sLoadingRecords": "Cargando...",
	            	    "oPaginate": {
		            	    "sFirst": "Primero",
		            	    "sLast": "Último",
		            	    "sNext": "Siguiente",
		            	    "sPrevious": "Anterior"
	            	   },
			        }
			    } );
			}
			
			function aplicarEstiloTablaResumenPedidosOtrosCanales() 
			{
				
				$('#tb_resumenPedidos').DataTable( {
					 "retrieve": true,
					    "paging": false,
					"lengthMenu": [[50, 75, 100], [50, 75 ,100]],
					 "order": [[ 1, "desc" ]],

						"pageLength":50,
			        "language": {
			            "lengthMenu": "Mostrar  _MENU_ pedidos.",
			            "zeroRecords": "No se encontraron pedidos.",
			            "info": " ",
			            "infoEmpty": "No se encontraron pedidos.",
			            "infoFiltered": "(Filtrando de _MAX_ registros totales)",
			            "sSearch": "Buscar:",
	            	    "sLoadingRecords": "Cargando...",
	            	    "oPaginate": {
		            	    "sFirst": "Primero",
		            	    "sLast": "Último",
		            	    "sNext": "Siguiente",
		            	    "sPrevious": "Anterior"
	            	   },
			        }
			    } );
			}
			
			function aplicarEstiloTablaDEtallePedidos() 
			{
				
				$('#tb_resumenPedidos').DataTable( {
					 "retrieve": true,
					    "paging": false,
					"lengthMenu": [[50, 75, 100], [50, 75 ,100]],
					order: [7, 'asc'],

					"pageLength":50,
			        "language": {
			            "lengthMenu": "Mostrar  _MENU_ pedidos.",
			            "zeroRecords": "No se encontraron pedidos.",
			             "info": " ",
			            "infoEmpty": "No se encontraron pedidos.",
			            "infoFiltered": "(Filtrando de _MAX_ registros totales)",
			            "sSearch": "Buscar:",
	            	    "sLoadingRecords": "Cargando...",
	            	    "oPaginate": {
		            	    "sFirst": "Primero",
		            	    "sLast": "Último",
		            	    "sNext": "Siguiente",
		            	    "sPrevious": "Anterior"
	            	   },
			        }
			    } );
			}
			
			function aplicarEstiloTablaDEtallePedidosOtros() 
			{
				
				$('#tb_resumenPedidos').DataTable( {
					 "retrieve": true,
					    "paging": false,
					"lengthMenu": [[50, 75, 100], [50, 75 ,100]],
					order: [7, 'asc'],

					"pageLength":50,
			        "language": {
			            "lengthMenu": "Mostrar  _MENU_ pedidos.",
			            "zeroRecords": "No se encontraron pedidos.",
			          //"info": "Página _PAGE_ De _PAGES_",
			            
			            "infoEmpty": "No se encontraron pedidos.",
			            "infoFiltered": "(Filtrando de _MAX_ registros totales)",
			            "sSearch": "Buscar:",
	            	    "sLoadingRecords": "Cargando...",
	            	    "oPaginate": {
		            	    "sFirst": "Primero",
		            	    "sLast": "Último",
		            	    "sNext": "Siguiente",
		            	    "sPrevious": "Anterior"
	            	   },
			        }
			    } );
			}
			
		</script>
		
		<script type="text/javascript">
		
			  $( function() {
				  $( "#txt_fechaIniResumenPedido" ).datepicker();
				  $( "#txt_fechaFinResumenPedido" ).datepicker();			  
			  });
				
		</script>
						<meta http-equiv="Expires" content="-1">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
		
	</head>
	
	<body onload="mostrarMensajesDeInicio()">
			<!-- Google Tag Manager (noscript) -->
<noscript><iframe src=https://www.googletagmanager.com/ns.html?id=GTM-MK6GSZ7
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->
				
		<!--	    <script type='text/javascript' src='https://vcl4-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/85F61374B44637B4_X_ovwAIK/loaderthenewwave.ashx' id='newloaderthewavev5'></script> -->
		
		
		<!--  ENCABEZADO CARRITO  -->		
		<%@include file="CarritoHeader.html" %>
				
		<!--  MENU CARRITO  -->		
		<%@include file="CarritoMenu.html" %>
			
		<!--  Centro de Mensajes  -->		
		<%@include file="AlertaCentroDeMensajes.html" %>	
				
		<!--  tipo Contacto  -->		
		<%@include file="AlertaTipoContacto.html" %>	
		
		<!--  CUENTAS DEPOSITO  -->		
		<%@include file="AlertaCuentasDeposito.html" %>	
				
				
		<!-- GALERIA DE FOTOS -->
		<%@include file="CarritoGaleriaFotosArticulos.html" %>
		
		<!-- VALIDA EXISTENCIAS EN CDO -->
		<%@include file="CarritoAlertaExistenciasArticulos.html" %>
		
		<!-- VALIDA EXISTENCIAS EN CDO a modificar-->
		<%@include file="CarritoAlertaModificaArticulos.html" %>
		
		<!--   DETALLE DE HISTORIAL DE PEDIDOS  -->
		<%@include file="CarritoSeguimientoDePedidoDetalle.html" %>
		
		<!-- MENSAJE INICIAL -->
		<%@include file="AlertaMensajeInicial.html" %>
		
		<!-- MENSAJE DE ESPERA -->
		<%@include file="AlertaMensajeDeEspera.html" %>
		
		<!-- MENSAJE DE ESPERA -->
		<%@include file="modalContrasenaEdoCuenta.html" %>
		
		<!-- MENSAJE DE ESPERA -->
		<%@include file="AlertaEspera.html" %>
		
		<!-- ALERTA DETALLE CLIENTE-->
				<%@include file="AlertaDetalleArticulo.html" %>
		
	
		<!-- ESTADO DE CUENTA  -->
		<div style="height: 0px"></div>		
		<div  class="container-fluid" id ="divEstadoDeCuenta"  style="text-align: center;display: none">
			<%@include file="CarritoEstadoDeCuenta.html" %>
		</div>
				
		<!-- SEGUIMIENTO DE PEDIDOS  -->
		<div style="height: 0px"></div>		
		<div  class="container-fluid" id ="divSeguimientoDePedido"  style="text-align: center;display: none;">
			<%@include file="CarritoSeguimientoDePedidos.html" %>
		</div>
		
		<!-- SEGUIMIENTO DE otros PEDIDOS  -->
		<div style="height: 0px"></div>		
		<div  class="container-fluid" id ="divSeguimientoOtrosPedido"  style="text-align: center;display: none;">
			<%@include file="CarritoSeguimientoOtrosPedidos.html" %>
		</div>
				
		<!-- CONSULTA POR APLICACION -->	
		<div  class="container-fluid" id ="divConsultaPorAplicacion"  style="text-align: center;padding:2px">
			<%@include file="CarritoBusquedaPorAplicacion.html" %>
		</div>
		
		<!-- VALIDA EXISTENCIAS EN CDO -->
		<div  id="divCarritoDeComprasArticulos" class="container-fluid" style="padding: 0px; margin: 0;display: none; " >	
			<%@include file="CarritoDeComprasDetalleArticulos.html" %>
		</div>
	
		<!-- VALIDA Elimina Articulo -->
		<%@include file="CarritoElinimarArticulohtml.html" %>	
	
	
	<!-- Modifica Cantidad -->
		<%@include file="CarritoModificaCantidad.html" %>	
	

<br/>
<br/>
<br/>
<br/>

<!--  <script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_ZUmiVAEK/loaderthenewwave.ashx' id='newloaderthewavev5'></script> -->
<!--  <script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_YyZyqAIK/loaderthenewwave.ashx' id='newloaderthewavev5'></script> -->	

	
<input type="hidden" value="${abc}">
<% 
String x = ""+pageContext.findAttribute("abc")+"" ;
// System.out.println(x);
if (x.equals("https://webcdo.cdoautopartes.com.mx")){ %> 
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_YyvgIAEK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
<% } else  if (x.equals("https://www.cdoautopartes.com.mx")){ %>
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_ZUmiVAEK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
<% } else  if (x.equals("http://www.cdoautopartes.com.mx")){ %>
<script type='text/javascript' src='http://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aaxioAUK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
<% } else { %>
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_YyvgIAEK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
<!-- <script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_YyvgIAEK/loaderthenewwave.ashx' id='newloaderthewavev5'></script> -->
<% } %>
	 
<!--	 	<a href="#" class="btn-flotante">
	<img src="${pageContext.request.contextPath}/images/chat2.png"  style="width: 32px" onclick="llamarChat()"></img>
    </a>
    -->
	</body>
</html>