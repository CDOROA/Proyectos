<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<link rel="icon" href="images/logocdo.png">

<!--  HOJAS DE ESTILOS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap2.css"></link>
<link rel="stylesheet" type="text/css" href="css/Generales.css"></link>
<link type="text/css" rel="stylesheet" href="css/jsgrid.min.css" />
<link type="text/css" rel="stylesheet" href="css/jsgrid-theme.css" />

<!--  FUNCIONES JS  -->
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/jsEvaluaciones.js"></script>
<script type="text/javascript">
$(function() {
    var navbarTop = $('#navEvaluacion').offset().top;

    $(window).on('scroll', function() {
        if ($(window).scrollTop() > navbarTop) {
            $('#navEvaluacion').addClass('navbarFixed');
        } else {
            $('#navEvaluacion').removeClass('navbarFixed');
        }
    });
});</script>


<title>Evaluaciones</title>
</head>
<body onload="rutinaInicioEvaluaciones()">

	<%@include file="menu.html"%>
	<%@include file="panelEspera.html" %>
	<%@include file="modalSalir.html"%>
	<%@include file="Error.html"%>
	
	<div id="tablaEvaluaciones" class="conteiner-fluid tablaEvaluaciones" style="width:90%; margin:auto; margin-top:20px; ">
	<h1 style="display:none;" class='conteiner-fluid text-center'>${nombre}</h1>
	</div>
	<div id="divEvaluaciones" class="conteiner-fluid" style="width:70%; margin-left:15%; display:none;">
	</div>
</body>

</html>