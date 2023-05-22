
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
<link rel="icon" href="Images/0CDO.png">

<!--  HOJAS DE ESTILOS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"></link>
<link rel="stylesheet" type="text/css" href="css/Generales.css"></link>

<!--  FUNCIONES JS  -->
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jsAspirantes.js"></script>

<link rel='stylesheet prefetch' href="css/jsgrid.css" />
<link rel='stylesheet prefetch' href="css/jsgrid-theme.css" />
<script type="text/javascript" src="js/jsgrid.js"></script>

<title>Administrar Aspirantes WWW</title>

</head>
<body onload="RutinaInicioAspirantes()">

	<%@include file="menu.html"%>

	<%@include file="panelEspera.html"%>

	<%@include file="consultaVacante.html"%>
	
	<%@include file="consultaCorreo.html"%>
	
	<%@include file="consultaEstatus.html"%>

	<%@include file="alertas.html"%>
	
	<div class="container-fluid" style ="margin-top: 150px;">
	
		<div id="divTablaAspirantes"
			style="padding-right: 0px; padding-left: 0px;">
		</div>
		<input type="hidden" readonly id="hidenStatus">
		<input type="hidden" readonly id="hidenIdAsp">
	</div>

</body>
</html>