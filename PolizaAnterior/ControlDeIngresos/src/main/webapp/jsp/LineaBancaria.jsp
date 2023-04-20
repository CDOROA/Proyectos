<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

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
		<script  type="text/javascript" src="js/jsLineaBancaria.js"></script> 
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
		<link rel="stylesheet" type="text/css" href="css/EstilosLineaBancaria.css">
		
		<!--  CSS y JS CALENDARIO -->
		 <link rel="stylesheet" href="css/jquery-ui.css"/>
		 <script src="js/jquery-ui.js"></script>		 
		 <script type="text/javascript">
		
			  $( function() {
				  $( "#txt_fechaIniConcentrado" ).datepicker();
				  $( "#txt_fechaFinConcentrado" ).datepicker();
				  $( "#txt_fechaIniBanamex" ).datepicker();
				  $( "#txt_fechaFinBanamex" ).datepicker();
				  $( "#txt_fechaIniHSBC" ).datepicker();
				  $( "#txt_fechaFinHSBC" ).datepicker();
				  $( "#txt_fechaIniBBVA" ).datepicker();
				  $( "#txt_fechaFinBBVA" ).datepicker();
				  $( "#txt_fechaIniBanorte" ).datepicker();
				  $( "#txt_fechaFinBanorte" ).datepicker();
				  $( "#txt_fechaIniAzteca" ).datepicker();
				  $( "#txt_fechaFinAzteca" ).datepicker();
			  });
				
			$(function () {
			    $(document).keydown(function (e) {
			        return (e.which || e.keyCode) != 116;
			    });
			});
		</script>
		
	</head>
	
	<body onload="IniciaModuloDeLineaBancaria('divLineaBancaria', 'tdLineaBancaria')">
		 <!-- PIE DE PAGINA  -->
		<%@include file="PieDePagina.html" %>
	
		 <!-- ENCABEZADO  -->
		<%@include file="Encabezado.html" %>
		
		
		 <!-- CONCENTRADO DE BANCOS POR USUARIO  -->
		<%@include file="AlertaConcentradoDeBancosXUsuario.html" %>
	
		<div class="EG_divPrincipal" style="text-align:center">
			
			<!-- ALERTA DE ESPERA -->
		<%@include file="AlertaMensajeDeEspera.html" %>
		
			<table width="100%" align="center">
				<tr>
					<td width="10%"  valign="top" >
						<div style="background: #C0D9EF; height:860px; width:120px" >
						 	<%@include file="Menu.html" %>		 
						</div>
					</td>
					<td valign="top" width="90%">
						<div  id ="divLineaBancaria">
						
							<!-- SECCION DE TITULO -->
							<table width="80%" align="center" cellpadding="0px" cellspacing="0px">
								<tr><td height="3px"></td></tr>
								<tr>
									<td width="100%" align="center">
										<label style="color:#439ED4; margin: 0px" class="EG_lbTituloAzul"> Carga L&iacute;nea Bancaria </label>
									</td>
								</tr>
								<tr><td height="3px"></td></tr>
							</table>
							
							<div id="div_SubirArchivosLineasBancarias" style="display: none">
								<!-- SUBIR LINEA BANCARIA  -->	
								<table  width="80%" align="center" cellpadding="0px" cellspacing="0px" >
									<tr style="background-color: #FBFBFB ; border: 1px solid #DDDDDD;">
										<!-- Seccion de banco deposito-->
										<td width="30%"style="padding: 8px" > 
											<form id="frmLineaBancariaBanco" method="post" >
												<table>
													<tr>
														<td valign="top" style="padding:0px; margin: 0px" >
															<div  style="border-radius:1px; color:black;padding-left: 10px; padding-right: 10px; padding-top: 1px">
																<label for="id_bancoDeposito" class="ELB_lbtexto"  >Banco:</label>
															</div>
														</td>
														<td valign="top"  style="padding:0px; margin: 0px">
															<select id="bancoDeposito"  name="bancoDeposito" class="EG_cmb" style="width:150px;padding: 0px">
																<option value="0" >-- Selecciona --</option>	
																<c:forEach var="ba" items="${listaBancos}" >
																	<c:if test="${ba.deposito == '1'}">
																		<option value="${ba.cve_banco}" >${ba.nombre_banco}</option>
																	</c:if>												
																</c:forEach>
															</select>
														</td>
													</tr>
												</table>												
											</form>
										</td>
										<!-- Seccion de archivo linea bancaria -->
										<td width="55%">
											<form id="frmFileLineaBancaria" method="post"  enctype='multipart/form-data'>
												<table  cellpadding="0px" cellspacing="0px">
													<tr>
														<td valign="top" >
															<div  style="border-radius:1px; color:black;padding-left: 15px; padding-right: 15px;">
															 	
																<label for="id_bancoDeposito" class="ELB_lbtexto" >Selecciona Archivo:</label>
															</div>
														</td>
														<td valign="top">
															<input type="file"  name="file" id="file"></input>
															<input type="hidden" name="vista" id="vista" value="LineaBancaria.jsp" >
							 								<input type="hidden" name="operacion" id="operacion" value="CargaLineaBancaria"  style="font-size: 11px ; font-family: arial" >
														</td>
													</tr>
												</table>
											</form>
										</td>
										<td width="15%" >
											<button class="btn btn-primary" type="button"  style="padding:3px; font-size:13px;  width: 200px" onclick="cargaArchivoLineaBancaria();"  >	
												<i class="glyphicon glyphicon-floppy-open"></i> Cargar Linea Bancaria
											</button>
										</td>									
									</tr>
								</table>
								<br>
															
								<!-- ALERTAS DE ERROR Y EXITO  -->	
							    <table align="center" width="50%">
	                                <tr>
										<td align="center">
										
											<c:if test="${not empty mensajeError}">
												<div id="divMjsError" style=" padding:3px;">	
													<div class="alert alert-danger alert-dismissible fade in" >
													    <strong >¡Error!</strong>&nbsp; <label  style="font-weight: normal">${mensajeError}</label>
													    <button type="button" class="close" onclick="OcultarDiv('divMjsError')">&times;</button>
													</div>
												</div>
											</c:if>
											
											
											<c:if test="${not empty mensajeExito}">
												<div id="divMjsExito" style=" padding:3px;">	
													<div class="alert alert-success alert-dismissible fade in" >
													     <label id ="lbMsjExito" style="font-weight: normal"> </label> ${mensajeExito}&nbsp;<strong>¡Correctamente!</strong>
													    <button type="button" class="close" onclick="OcultarDiv('divMjsExito')">&times;</button>
													</div>
												</div>
											</c:if>
										</td>	
	                                </tr>
	                            </table>
							 				
							</div>
							
							
							<!-- SECCION TAP'S  BANCOS DEPOSITO EXISTENTES -->	
							<div id="div_taps_bancos_depositos" style="display: none">
								<ul class="nav nav-tabs">
									<li class="active"> <a data-toggle="tab" href="#div_BANAMEX"> BANAMEX </a> </li>
									<li> <a data-toggle="tab" href="#div_BBVA" onclick="consultaLineaBancariaBBVA()"> BBVA </a> </li>
									<li> <a data-toggle="tab" href="#div_HSBC"> HSBC </a> </li>
									<li> <a data-toggle="tab" href="#div_AZTECA"> AZTECA </a> </li>
									<li> <a data-toggle="tab" href="#div_BANORTE"> BANORTE </a> </li>
									<li> <a data-toggle="tab" href="#div_RESUMEN" onclick="obtieneConcentradoLineasBancariasPendientesBD()"> ASIGNAR LINEA </a> </li>
								</ul>
								
								<div class="tab-content">	
								
									<!--  BANAMEX  -->		
									<div id="div_BANAMEX" class="tab-pane fade in active" >
										<%@include file="LineaBancariaBanamex.html" %>
									</div>
									
									<!--  BANCOMER  -->		
									<div id="div_BBVA" class="tab-pane fade " >
										<%@include file="LineaBancariaBBVA.html" %>
									</div>
									
									
									<!--  HSBC  -->	
									<div id="div_HSBC" class="tab-pane fade">
										<%@include file="LineaBancariaHSBC.html" %>
									</div>
									
									<!--  AZTECA  -->										
									<div id="div_AZTECA" class="tab-pane fade">
										<%@include file="LineaBancariaAzteca.html" %>
									</div>	
									
									
									<!--  BANORTE  -->	
									<div id="div_BANORTE" class="tab-pane fade">
										<%@include file="LineaBancariaBanorte.html" %>
									</div>
									
									
									<!--  RESUMEN  -->	
									<div id="div_RESUMEN" class="tab-pane fade">
										<%@include file="LineaBancariaConcentradoBancos.html" %>
									</div>
																
								</div>
							</div>
							
						</div>
					</td>
				</tr>
			</table>
		</div>	
		<br>
		
	</body>
	
</html>