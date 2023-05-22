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
<link type="text/css" rel="stylesheet" href="css/jsgrid.min.css" />
<link type="text/css" rel="stylesheet" href="css/jsgrid-theme.css"/>
<link type="text/css" href="css/chosen.css" rel="stylesheet"/>

<!--  FUNCIONES JS  -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jsSeguimiento.js"></script>
<script type="text/javascript" src="js/jsgrid.js"></script>
<script type="text/javascript" src="js/chosen.jquery.js"></script>
<title>Seguimiento</title>
</head>
<body onload="rutinaInicioSeguimiento()">
	<%@include file="menu.html"%>
	<%@include file="panelEspera.html" %>
	<%@include file="modalSeguimiento.html" %>
	<div></div>
	<br>
	<div id="selectEncuesta" style="width:100%; text-align:center;"></div>
	<br>
	<div id="divSeguimiento"><div style="text-align:center; font-weight: bold; font-size:19px;">Seleccione una encuesta</div></div>
</body>
</html>