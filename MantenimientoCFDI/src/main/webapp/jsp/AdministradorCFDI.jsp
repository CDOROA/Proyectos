<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<link rel="icon" href="images/logocdo.png">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--  HOJAS DE ESTILOS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap2.css"></link>
<link rel="stylesheet" type="text/css" href="css/Generales.css"></link>
<link type="text/css" href="css/chosen.css" rel="stylesheet"/>

<!--  FUNCIONES JS  -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jsCFDI.js"></script>
<script type="text/javascript" src="js/chosen.jquery.js"></script>

<link rel='stylesheet prefetch' href="css/jsgrid.css" />
<link rel='stylesheet prefetch' href="css/jsgrid-theme.css" />
<script type="text/javascript" src="js/jsgrid.js"></script>

<title>Administrador CFDI</title>
</head>
<body onload="rutinaInicioCFDI();">
<div id="cabecera"></div>
<%@include file="panelEspera.html" %>
	<%@include file="menu.html"%>
	<%@include file="LOG.html" %>
	<br>
	<div id="radios" style='width:100%; text-align:center; display:flex;'>
	<div style="width:20%;" id="buscador"></div>
	<div id="options" style="width:60%;">
		<div class="form-check form-check-inline" >
	  		<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" onclick="consultaCFDI(this.value)" checked value="1">
	  		<div id="f" style=""><label class="form-check-label" for="inlineRadio1">FACTURAS</label></div>
		</div>
		<div class="form-check form-check-inline">
			<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" onclick="consultaCFDI(this.value)" value="2">
			 <div id="t" style=""><label class="form-check-label" for="inlineRadio2">TRASPASOS RCs</label></div>
		</div>
		<div class="form-check form-check-inline">
			<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" onclick="consultaCFDI(this.value)" value="3">
			<div id="tcdo" style=""> <label class="form-check-label" for="inlineRadio3">TRASPASOS CDOs</label></div>
		</div>
		<div class="form-check form-check-inline">
			<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio4" onclick="consultaCFDI(this.value)" value="4">
			<div id="n" style=""> <label class="form-check-label" for="inlineRadio4">NOTAS DE CREDITO</label></div>
		</div>
		<div class="form-check form-check-inline">
			<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio5" onclick="consultaCFDI(this.value)" value="5">
			<div id="c" style=""> <label class="form-check-label" for="inlineRadio5">NOTAS DE CARGO</label></div>
		</div>
		<div class="form-check form-check-inline">
			<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio6" onclick="consultaCFDI(this.value)" value="6">
			<div id="p" style=""><label class="form-check-label" for="inlineRadio6">PAGOS</label></div>
		</div>
		</div>
<!-- 		<div style="text-align:right; width:10%;"><button class="btn btn-outline-dark" type="button" onclick="limpiar();">Actualizar tabla</button></div> -->
	<div style="text-align:right; width:10%;"><button class="btn btn-outline-primary type="button" onclick="actualizarPag();" ><img src="images/arrow-repeat.svg" width="30px" height="25px" ></button></div>
	</div><br>
	<div>
	<div id="tablaCFDI" width="100%" height="100%" ></div><br>
	</div>
	<div id="btnGenerarNotas" style="width:90%; display:none; text-align:right;"><button class='btn btn-warning' onclick='checaCliente()'>GENERAR CFDI</button></div>
	<br><br>
	<div id="titulo"><h4 style='width:100%; text-align:center; background:black; color:white;'>DATOS:</h4></div><br>
	<%@include file="comprobante.html" %>
	<%@include file="emisor.html" %>
	<br><br><br>
	<div style="width:80%; margin-left:8%; text-align:right;">
		<button type="button" class="btn btn-primary" onclick="verificaCampos();">GENERA CFDI</button>
	</div><br>
	<%@include file="receptor.html" %>
	<br>
	<div id="conceptosTITULO" style="width:80%; margin-left:8%;background:black; color:white;"><h5>Conceptos:</h5></div><br>
	<div id="tablaConceptos" style="width:80%; margin-left:8%; "></div>
	<%@include file="documentos.html" %>
	<%@include file="conceptos.html" %>
	
	<input type="hidden" id="numeroCliente" value="">
	<input type="hidden" id="serie" value="">
	<input type="hidden" id="folio" value="">
	<input type="hidden" id="cdo" value="${uname}">
	<input type="hidden" id="impresora" value="">
	<input type="hidden" id="ode2" value="">
	<input type="hidden" id="tipoDoc" value="">
	<input type="hidden" id="nc" value="">
	
</body>
</html>