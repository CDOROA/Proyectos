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
<script type="text/javascript" src="js/jsResultados.js"></script>
<script type="text/javascript" src="js/jsgrid.js"></script>
<script type="text/javascript" src="js/chosen.jquery.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/excellentexport@3.4.3/dist/excellentexport.min.js"></script>
<script src="https://cdn.jsdelivr.net/gh/gitbrent/pptxgenjs@latest/dist/pptxgen.bundle.js"></script>
<title>Resultados</title>
</head>
<body onload="rutinaInicioResultados()">

	<%@include file="menu.html"%>
	<%@include file="modalDeptos.html" %>
	<%@include file="ModalResultados.html" %>
	<%@include file="modalDetalleEmpleado.html" %>
	<%@include file="ModalPreguntas.html" %>
	<%@include file="panelEspera.html" %>
	<br>
	<div class="card">
  <div class="card-header">
    <ul class="nav nav-pills card-header-pills" style="display:flex;">
      <li class="nav-item">
        <a class="nav-link active"  id="areasbtn" onclick="cargaAreas();">AREAS</a>
      </li>
      <li class="nav-item">
        <a class="nav-link "  id="deptosbtn" onclick="cargaDepartamentos();">DEPARTAMENTOS</a>
      </li>
      <li class="nav-item">
        <a class="nav-link"  id="nivelesbtn" onclick="cargaNiveles();">NIVELES</a>
      </li>
      <li class="nav-item">
        <a class="nav-link"  id="empleadosbtn" onclick="cargaEmpleado(1,true,0);">EMPLEADOS</a>
      </li>
      <li id="btnAR" style="margin-left:57%;">
      	<a id="lblAR" class="btn btn-success" onclick="actualizaResultados();">Actualizar Resultados</a>
      </li>
      <li id="btnAreas" style="margin-left:1%; display:none;">
      	<a id="download_xlsxAreas" class="btn btn-warning" href="#">Descargar</a>
      </li>
      <li id="btnDepartamentos" style="margin-left:1%; display:none;">
      	<a id="download_xlsxDepartamentos" class="btn btn-warning"  href="#">Descargar</a>
      </li>
      <li id="btnNiveles" style="margin-left:1%; display:none;">
      	<a id="download_xlsxNiveles" class="btn btn-warning"  href="#">Descargar</a>
      </li>
       <li id="btnEmpleados" style="margin-left:1%; display:none;">
      	<a id="download_xlsxEmpleados" class="btn btn-warning"  href="#">Descargar</a>
      </li>
    </ul>
   <!--<button onclick="crearPptx();" type="button">Export to PPTX</button>-->
  </div>
  
  <div class="card-body">
   <div style="display:flex">
   <div id="selectEmp" style="display:none;">
    	<select style="display:none" id='tipoEncuesta' onchange="cargaEmpleado(this.value, false);">
    		<option value=0>Todos</option>
    		<option value=1 selected>Gerencial</option>
    		<option value=2>Mandos Medios</option>
    		<option value=3>Administrativo</option>
    		<option value=4>Operativo</option>
    		</select>
   </div>
    <div class="img-fluid" id="imgResultados" style="margin-left:35%;"><img src="images/normas.PNG"></div></div>
   <div id="divtablaCompetencia">
   
   </div>
   <div id="areas" style="display:none;"><div id="promedioTotal"></div></div>
   <div id="tablaAreas" style="display:none;"></div>
    <div id="departamentos" style="display:none;"></div>
    <div id="tablaDeptos" style="display:none;"></div>
    <div id="niveles" style="display:none;"></div>
    <div id="tablaNiveles" style="display:none;"></div>
    <div id="empleados" style="display:none;"></div>
    <div id="tablaEmpleados" style="display:none;"></div>
  </div>
</div>
 <script>
        let download_xlsxAreas = document.querySelector("#download_xlsxAreas")
        download_xlsxAreas.addEventListener("click", ()=>{                     
            ExcellentExport.convert({ anchor: download_xlsxAreas, filename: 'ResultadosAreas', format: 'xlsx'},[{name: 'RESULTADOS', from: {table: 'tablaAreas'}}])
        })
        let download_xlsxDepartamentos = document.querySelector("#download_xlsxDepartamentos")
        download_xlsxDepartamentos.addEventListener("click", ()=>{                     
            ExcellentExport.convert({ anchor: download_xlsxDepartamentos, filename: 'ResultadosDepartamentos', format: 'xlsx'},[{name: 'RESULTADOS', from: {table: 'tablaDeptos'}}])
        })

        let download_xlsxNiveles = document.querySelector("#download_xlsxNiveles")
        download_xlsxNiveles.addEventListener("click", ()=>{                     
            ExcellentExport.convert({ anchor: download_xlsxNiveles, filename: 'ResultadosNiveles', format: 'xlsx'},[{name: 'RESULTADOS', from: {table: 'tablaNiveles'}}])
        })

        let download_xlsxEmpleados = document.querySelector("#download_xlsxEmpleados")
        download_xlsxEmpleados.addEventListener("click", ()=>{                     
            ExcellentExport.convert({ anchor: download_xlsxEmpleados, filename: 'ResultadosEmpleados', format: 'xlsx'},[{name: 'RESULTADOS', from: {table: 'tablaEmpleados'}}])
        })


    </script> 
</body>
</html>