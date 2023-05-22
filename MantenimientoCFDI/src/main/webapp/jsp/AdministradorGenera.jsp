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
<script type="text/javascript" src="js/jsGenera.js"></script>
<script type="text/javascript" src="js/jsgrid.js"></script>
<script type="text/javascript" src="js/chosen.jquery.js"></script>
    
<title>Generar</title>
</head>
<body onload="rutinaInicioGenera();">
	<%@include file="panelEspera.html" %>
	<%@include file="menu.html"%>
	<div style="width:95%; margin-left:2%; margin-right:2%;"><br>
	<div class="row g-3">
		  <div class="col-md">
		    <div class="form-floating">
		      <input type="text" class="form-control" maxlength="6" id="pedido" placeholder="PEDIDO" onkeyup="verificaCampo();" value="">
		      <label for="floatingInputGrid">PEDIDO</label>
		    </div>
		  </div>	
		  <div class="col-6">
		    <div class="form-floating">
		      <select id="seccion" class="form-select form-select-lg mb-3" >
		      	<option value="0" selected>0</option>
		      	<option value="1" >1</option>
		      	<option value="2" >2</option>
		      	<option value="3" >3</option>
		      	<option value="4" >4</option>
		      	<option value="5" >5</option>
		      </select>
		      <label for="floatingInputGrid">SECCION</label>
		    </div>
		  </div>
		  <div class="col-md">
		    <div class="form-floating">
		      <input type="date" class="form-control" id="fechaFac" placeholder="FECHA FACTURA"  onkeyup="verificaCampo();"  value="">
		      <label for="floatingInputGrid">FECHA FACTURA</label>
		    </div>
		  </div>
		</div><br><br>
		<div style="text-align:center;"><button type="button" class="btn btn-success" onclick="validaCampos();">EMITIR CFDI</button></div>
	</div>
	
</body>
</html>