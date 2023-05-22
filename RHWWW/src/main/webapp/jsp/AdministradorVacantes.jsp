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
<script type="text/javascript" src="js/jsVacantes.js"></script>

<link rel='stylesheet prefetch' href="css/jsgrid.css" />
<link rel='stylesheet prefetch' href="css/jsgrid-theme.css" />
<script type="text/javascript" src="js/jsgrid.js"></script>

<title>Administrar Vacantes WWW</title>
</head>
<body onload="RutinaInicioVacantes()">

	<%@include file="menu.html"%>

	<%@include file="panelEspera.html"%>

	<%@include file="formularioVacante.html"%>

	<%@include file="alertas.html"%>

	<div class="container-fluid" style ="margin-top: 150px;">
		<div class="row">
			<div class="col-lg-12" style="margin-bottom: 15px;">
				<button id="btnAgregarVacante" type="button" class="btn btn-outline-success float-right" onclick="MostrarFormParaCaptura()">
				<img  src='Images/btnAgregar.png' class='img-fluid centrar' />&nbsp; &nbsp;Agregar Vacante
				</button>
			</div>
		</div>
		<div id="divTablaVacantes"
			style="padding-right: 0px; padding-left: 0px;">
		</div>
	</div>

</body>
</html>