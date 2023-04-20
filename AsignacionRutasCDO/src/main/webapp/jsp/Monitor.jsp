
<%@ page language="java"%>
<%@ page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <!-- CODIGO PARA QUE NO GUARDE CACHE -->
 <meta http-equiv="Expires" content="-1">
 <meta http-equiv="Cache-Control" content="no-cache">
 <meta http-equiv="Pragma" content="no-cache">

<title>Asignacion Pedidos</title>
<link rel="styleshet" type="text/css" href="css/EstilosMenu.css">
<link rel="stylesheet" type="text/css" href="css4/bootstrap.css">
 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD3pAWctAaHoIRhTERJ1N3lQ_0TZe7tCqY&libraries=places"
        async defer></script>
<link rel="stylesheet" type="text/css" href="css4/bootstrap.min.css">

<script type="text/javascript" src="js4/jquery.js"></script>
<script type="text/javascript" src="js4/bootstrap.js"></script>
<link rel="stylesheet" type="text/css" href="css/EstilosGenerales.css">
<script type="text/javascript" src="js/jsGeneral.js"></script>
<script type="text/javascript" src="js/jsMonitorPedido.js"></script>


<!--  CSS y JS CALENDARIO -->
<link rel="stylesheet" href="css/jquery-ui.css" />
<script src="js/jquery-ui.js"></script>

<!--  JS JSGRID -->
<link rel='stylesheet prefetch' href="css4/jsgrid.min.css" />
<link rel='stylesheet prefetch' href="css4/jsgrid-theme.min.css" />
<script type="text/javascript" src="js4/jsgrid.js"></script>
<script type="text/javascript" src="js4/jsgrid.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#txt_fechaIni").datepicker();
		$("#txt_fechaIniCorte").datepicker();
		$("#txt_fechaFin").datepicker();
		$("#txt_fechaIniCredito").datepicker();
		$("#txt_fechaFinCredito").datepicker();
		$("#txt_fechaIniPedidos").datepicker();
		$("#txt_fechaFinPedidos").datepicker();
		$("#txt_fechaIniPedidost").datepicker();
		$("#txt_fechaFinPedidost").datepicker();
		$("#txt_fechaIniPedidosc").datepicker();
		$("#txt_fechaFinPedidosc").datepicker();
		$("#txt_fechaIniPedidosRc").datepicker();		
		$("#txt_fechaFinPedidosRc").datepicker();
	});


</script>
  <script>
    function inicio() {
  
	
	  
    }
    
    
    
  
  </script>


</head>
<body onload="principal()">


	<%@include file="Encabezado.html"%>
<%@include file="AlertaCancelacionCheque.html"%>
<%@include file="AlertaCancelacionChequeRC.html"%>
<%@include file="AlertaCancelacionDetalleRC.html" %>
<%@include file="AlertaCalendario.html"%>
<%@include file="AlertaCalendarioChofer.html"%>
<%@include file="AlertaCalendarioChoferRC.html" %>
<%@include file="AlertaCalendarioAsignacion.html"%>
<%@include file="AlertaConfrimacionFacturas.html"%>
<%@include file="AlertaCancelacionChequeTrans.html"%>
<%@include file="MensajeEspera.html"%>

	 	
			<input type="hidden" id="pedidosSelec">
			<input type="hidden" id="lat">
			<input type="hidden" id="long">
			<input type="hidden" id="nivelUsu" value="${nivelUsu}">
			<input type="hidden" id="ruts" value="${rutasChofer}">
			<input type="hidden" id="redireccionar" value="${redireccionar}">
			
			<div align="left" style="width: 100%" id="enc1">
			<ul class="nav nav-tabs" style="height: 33px">
				<li class="nav-item" style="padding: 2px"> <a class="nav-link active chof" data-toggle="tab" href="#asignacion" id="ventaActive"  onclick="principal();OcultarDivStyle('asignacionTransportes');OcultarDivStyle('asignacion');" style="font-size: 13px;padding: 7px" > ASIGNACION CHOFER</a> </li>
				<li class="nav-item" style="padding: 2px"> <a class="nav-link trans" data-toggle="tab" href="#asignacionTransportes" id="asigTrans"  onclick="OcultarDivStyle('asignacion');OcultarDivStyle('asignacionTransportes');emptyChofer();empty();eliminarCredito();OcultarDiv('encabezadoPedidosTrans');OcultarDiv('btnConfirmarFac');fecha();quitarChofer();OcultarDiv('monitor');OcultarDiv('credito');OcultarDiv('impresion');OcultarDiv('encabezadoPedidosInicial');MostrarDiv('divCalendariot');actualizarTrans();OcultarDiv('encabezadoPedidosInicialTrans');OcultarDiv('corte');OcultarDiv('divDetalle');vaciarCredito()" style="font-size: 13px;padding: 7px" > ASIGNACION TRANSPORTES </a> </li>
				<li class="nav-item" style="padding: 2px"> <a class="nav-link monito" data-toggle="tab" href="#monitor" id="renta" onclick="fecha();radios();OcultarDivStyle('asignacion');OcultarDivStyle('asignacionTransportes');emptyChofer();eliminarCredito();quitarChofer();quitarValorCliente();OcultarDiv('btnConfirmarFac');MostrarDiv('monitor');OcultarDiv('credito');OcultarDiv('impresion');OcultarDiv('encabezadoPedidosInicial');consultarTrayecto('inicio');fecha();OcultarDiv('encabezadoPedidosInicialTrans');nivelUsu();OcultarDiv('corte');OcultarDiv('divDetalle'); OcultarDiv('monCredito');OcultarDiv('asignacionRC');vaciarCredito()" style="font-size: 13px;padding: 7px" > MONITOR </a> </li>
				<li class="nav-item" style="padding: 2px"> <a class="nav-link" data-toggle="tab" href="#credito" id="cre" onclick="fecha();MostrarDiv('credito');OcultarDivStyle('asignacion');OcultarDivStyle('asignacionTransportes');quitarChofer();emptyChofer();OcultarDiv('corte');OcultarDiv('impresion');OcultarDiv('monitor');OcultarDiv('encabezadoPedidosInicial');fecha();OcultarDiv('encabezadoPedidosInicialTrans');nivelUsu();OcultarDiv('divDetalle')" style="font-size: 13px;padding: 7px" > CONFIRMACION DE FACTURAS PARA CORTE</a> </li>
				<li class="nav-item" style="padding: 2px"> <a class="nav-link" data-toggle="tab" href="#corte" id="cor" onclick="fecha();eliminarCredito();OcultarDivStyle('asignacion');OcultarDivStyle('asignacionTransportes');MostrarDiv('corte');quitarChofer();emptyChofer();OcultarDiv('btnConfirmarFac');OcultarDiv('credito');OcultarDiv('impresion');OcultarDiv('monitor');OcultarDiv('encabezadoPedidosInicial');fecha();OcultarDiv('encabezadoPedidosInicialTrans');nivelUsu();OcultarDiv('divDetalle');vaciarCredito()" style="font-size: 13px;padding: 7px" > GENERAR CORTE </a> </li>
				<li class="nav-item" style="padding: 2px"> <a class="nav-link" data-toggle="tab" href="#impresion" id="imp" onclick="fecha();eliminarCredito();OcultarDivStyle('asignacion');OcultarDivStyle('asignacionTransportes');MostrarDiv('impresion');OcultarDiv('btnConfirmarFac');emptyChofer();quitarChofer();OcultarDiv('credito');OcultarDiv('monitor');OcultarDiv('encabezadoPedidosInicial');OcultarDiv('encabezadoPedidosInicialTrans');OcultarDiv('corte');OcultarDiv('divDetalle');vaciarCredito()" style="font-size: 13px;padding: 7px" > REIMPRESION TICKET </a> </li>
				<li class="nav-item" style="padding: 2px"> <a class="nav-link" data-toggle="tab" href="#asignacionRC" id="ventaActive"  onclick="principalRC();OcultarDivStyle('asignacionTransportes');OcultarDivStyle('asignacionRC');OcultarDiv('asignacion');" style="font-size: 13px;padding: 7px" > ENTREGAS FLETES</a> </li>
			</ul>			
			</div>
			<%@include file="DivMonitor.html"%>
			<%@include file="DivFacturas.html"%>
			<%@include file="AlertaMarcadoClientes.html"%>
			<%@include file="AlertaMarcadoClientesRC.html" %>
			<%@include file="AlertaMarcadoDetalleRC.html"%>
			<%@include file="DivCorte.html"%>
			<%@include file="DivImpresion.html"%>
			 <%@include file="DivAsignacionPedidos.html"%>
			 <%@include file="DivAsignacionPedidosRC.html" %>
			 <%@include file="DivAsignacionTransportes.html"%>
			 <%@include file="Mapa.html"%>
			 <%@include file="MapaUbicacionFactura.html"%>
			 <%@include file="AlertaDetalle.html"%>
			 <%@include file="AlertaChofer.html"%>
			 <%@include file="AlertaTransporte.html"%>
			<input type="hidden" id="choferTipo">
			<input type="hidden" id="choferTipoSession" value="${choferTipo}">
			<input id="inputChofer" type="hidden">
			<input id="inputChoferRC" type="hidden">
	<input id="inputChoferMarcado" type="hidden">
	<input id="inputChoferMarcadoDetalleRC" type="hidden">
	<input id="choferMarcadoJson" type="hidden">
	<input type="hidden" id="uname_br" value="${session_br} ">
	<input type="hidden" id="minutos" value="${minutos} ">
			<input type="hidden" id="transporteTipo">
			<input type="hidden" id="transporteTipoSession" value="${transporteTipo}">
			<input type="hidden" id="unameOrigen" value="${infoUsu.uname_nombre}">
</body>
</html>

