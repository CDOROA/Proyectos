<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sismay CDO</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"></link>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css"></link>
		<link rel="stylesheet" type="text/css" href="css/EstilosLogin.css"></link>
		<link rel="stylesheet" type="text/css" href="css/EstilosMenu.css"></link>	
		<link rel="stylesheet" type="text/css" href="css/EstilosGenerales.css"></link>
	<!--  FUNCIONES JS  -->
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/jsControl.js"></script>
</head>
<body onload="verificaProssWeb()">
<%@include file="Encabezado.html"%>
<div id="url">
<form id="formulario" method="post">
<input type="hidden" name="txtUsuario" id="txtUsuario" value="SY-U04">
<input type="hidden" name="txtPassword" id="txtPassword" value="943fa6ffaa6e558603e812f9089af9bf49938983">
<input type="hidden" name="cdo_macro" id="cdo_macro" value="cdf">
<input type="hidden" name="proceso_web" id="proceso_web" value="151">
<input type="hidden" name="vista" id="idIndex" value="Inicio.jsp">
</form></div>
<div id="processWeb" style="padding: 60px 45%;">
	<select id="form-select" class='form-select' multiple aria-label='multiple select example' ondblclick="redireccionarVista(this.value);">
</div>

</body>
</html>