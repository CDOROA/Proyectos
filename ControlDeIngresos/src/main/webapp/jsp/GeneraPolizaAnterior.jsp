<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Control de Ingresos CDO-ROA</title>
			
			<script  type="text/javascript" src="js/jquery-ui.min.js"></script>
			<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
			<script type="text/javascript" src="js/jquery.js"></script> 
			<script  type="text/javascript" src="js/bootstrap.min.js"></script>
			
			<!--  CSS BOOTSTRAP  y JQUERY-->
			<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
			<link rel="stylesheet" type="text/css" href="css/jsgrid.css">
			<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom.css">
			
			
			<!--  JS PERSONALIZADO Y JQUERY -->
			<script  type="text/javascript" src="js/jsCortePolizaAnterior.js"></script> 
			<script  type="text/javascript" src="js/jsGeneral.js"></script> 
			<script  type="text/javascript" src="js/jquery.min.js"></script>
			<script  type="text/javascript" src="js/jsjquery.min.js"></script>
			
			<!--  JS JSGRID -->
			<link rel='stylesheet prefetch' href="css/jsgrid.min.css"/> 
		    <link rel='stylesheet prefetch' href="css/jsgrid-theme.min.css"/> 
		    <script type="text/javascript" src="js/jsgrid.js"></script> 
		    <script type="text/javascript" src="js/jsgrid.min.js"></script> 
			
			<!--  JS BOOTSTRAP -->
			<script  type="text/javascript" src="js/bootstrap.js"></script> 
			
			<!--  CSS PERSONALIZADO -->
			<link rel="stylesheet" type="text/css" href="css/EstilosPieDePagina.css">
			<link rel="stylesheet" type="text/css" href="css/EstilosMenu.css">
			<link rel="stylesheet" type="text/css" href="css/EstilosGenerales.css">
			<link rel="stylesheet" type="text/css" href="css/EstilosCortePoliza.css">
			<link rel="stylesheet" type="text/css" href="css/EstilosCorteCaja.css">
			<link rel="stylesheet" type="text/css" href="css/EstilosPoliza.css">
			
			<!--  CSS y JS CALENDARIO -->
			<link rel="stylesheet" href="css/jquery-ui.css"/>
			<script src="js/jquery-ui.js"></script>
			
			<script type="text/javascript">
		
			  $( function() {
				  $( "#txt_fechaPolizaAnterior" ).datepicker();
			  });
		
		
			$(function () {
			    $(document).keydown(function (e) {
			        return (e.which || e.keyCode) != 116;
			    });
			});
		</script>
	</head>
	<body onload="IniciaModuloDeCorteDePolizaAnterior('divCortePolizaAnterior', 'tdCorteDePolizaAnterior')">
		 <!-- PIE DE PAGINA  -->
		<%@include file="PieDePagina.html" %>
		
		 <!-- ENCABEZADO  -->
		<%@include file="Encabezado.html" %>
		
		<div class="EG_divPrincipal" style="text-align:center">
			<!-- ALERTA DE CONFIRMACION POLIZA DIA -->
			<%@include file="AlertaGenerarPolizaDia.html" %>			
			
			
			<!-- ALERTA DE ESPERA -->
			<%@include file="AlertaMensajeDeEspera.html" %>
			
			<table width="100%" align="center">
				<tr>
					<td width="10%"  valign="top" >
						<div style="background: #C0D9EF; height:860px; width:120px" >
						 	<%@include file="Menu.html" %>		 
						</div>
					</td>
					<td valign="top" width="90%" align=center>
						<div id="divCortePolizaAnterior" style="width: 95%;">
							<div style="height: 10px"></div>	
							<div class="row">
								<div class="col-sm-12" >	
									<form action ="	GeneraPolizaAnterior" method="post" id="id_polizaAnteriorForm">
										<table width="80%" align="center">
											<tr>
												<td width="100%" align="center">
													<input type="hidden" name="vista" id="idIndex" value="GeneraPolizaAnterior.jsp" >
													<input type="hidden" name="operacion" id="idIndex" value="ConsultaPolizaDiaAnterior" >												
													<label style="color:#439ED4; font-size: 16px; color:#013ADF" class="EG_lbTituloAzul"> Fecha Poliza: </label>
													<input type="text" id="txt_fechaPolizaAnterior" name = "fechaPolizaAnterior" class="EG_calendario">
													<button  class="btn btn-info" type="submit"  style="padding:3px; font-size:13px;  width: 160px">
														<i class="glyphicon glyphicon-search"></i> Consultar Poliza
													</button>
													<br>	
												</td>
											</tr>
										</table>
									</form>
								</div>
							</div>							
							<%@include file="PolizaDiaAnterior.html" %>			
						</div>
					</td>
				</tr>
			</table>
		</div>
	
	</body>
</html>