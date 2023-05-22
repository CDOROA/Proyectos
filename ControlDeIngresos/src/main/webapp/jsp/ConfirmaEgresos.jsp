<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
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
		<script  type="text/javascript" src="js/jsConfirmaEgresos.js"></script> 
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
		<link rel="stylesheet" type="text/css" href="css/EstilosEgresos.css">
		
		<!--  CSS y JS CALENDARIO -->
		<link rel="stylesheet" href="css/jquery-ui.css"/>
		<script src="js/jquery-ui.js"></script>
		
		<script type="text/javascript">		
		
			  $( function() {
				  $( "#txt_fechaIni" ).datepicker();
				  $( "#txt_fechaFin" ).datepicker();
				  $( "#id_fecha_polizaEgreso" ).datepicker();
				  $( "#txt_fechaPolizaEgresosAct" ).datepicker();
			  } );
		
		
			$(function () {
			    $(document).keydown(function (e) {
			        return (e.which || e.keyCode) != 116;
			    });
			});
		</script>
		
	</head>
	<body onload="IniciaModuloEgresos('divEgresos','tdEgresos')">
	
		 <!-- PIE DE PAGINA  -->
		<%@include file="PieDePagina.html" %>
		
		 <!-- ENCABEZADO  -->
		<%@include file="Encabezado.html" %>
		
		<div class="EG_divPrincipal" style="text-align:center">
		
		 	
			
			 <!-- ALERTA DE CANCELACION -->
	 		<%@include file="AlertaCancelacionDeEgreso.html" %>
	 		
	 		 <!-- ALERTA ALTA NUEVO EGRESO  -->
	 		<%@include file="AlertaAltaNuevoEgreso.html" %>
	 		
	 		 <!-- ALERTA ACTUALIZA TRANSFERENCIA DE EGRESO  -->
	 		<%@include file="AlertaActualizarTransferenciaEgreso.html" %>
	 		
	 		 <!-- ALERTA FIRMA MANCOMUNADA DE EGRESO  -->
	 		<%@include file="AlertaFirmaMancomunada.html" %>
	 		
	 		 <!-- ALERTA FIRMA MANCOMUNADA EXTRA DE EGRESO  -->
	 		<%@include file="AlertaFirmaMancomunadaExtra.html" %>
	 		
	 		
	 		<!-- ALERTA DE EDITAR FECHA  POLIZA  --> 		
	 		<%@include file="AlertaEditarFechaPolizaEgresos.html" %>
	 		
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
						<div id="divEgresos" style="width: 100%;">
							
							<br>
							 <div class="row">
							 	<div class="col-sm-12">
							 	
							 		<!-- SECCION DE TITULO -->
									<table width="80%" align="center">
										<tr>
											<td width="100%" align="center">
												<label style="color:#439ED4" class="EG_lbTituloAzul"> Confirmaci&oacute;n de Egresos </label>
											</td>
										</tr>
										<tr>
											<label id="lb_mj_pol_generadas" style="font-family: arial black; font-size: 16px ; font-weight: bold; color:red;"></label>
										</tr>
									</table>
									
							 		<table width="80%" align="center">
										<tr>
											<td width="100%" align="right">
											<label  style="color:#4169E1; font-family: arial; font-size: 16px;font-weight: bold ">Disponible:$</label>
											<label id="lbEfectivoDisponible" style="color:#4169E1; font-family: arial; font-size: 16px;font-weight: bold ">${EfectivoDisponible}</label>
											</td>
										</tr>
									</table>
							 		
							 		<!-- CHECKS DE TIPOS DE PAGO  -->	
								 	<table align="center" width="80%">
								 		<tr>
								 			<td align="center" valign="middle" style="background-color: #FBFBFB ; border: 1px solid #DDDDDD;height: 50px ">
								 				<div class="funkyradio" style="padding:0px; width:100%;" id="cbxsTipoEgreso"  >
			                                      	<table width="90%" align="center">
			                                         	<tr>
			                                         		<td>
			                                         			<div class="funkyradio-warning" style="width:130px" >
				                                                   <input type="radio" name="tipoEgreso" checked="checked" id="CPagare" />
				                                                   <label for="CPagare" class="ECE_lbCheckBox"> &nbsp;Pagare</label>
			                                            		</div>
			                                         		</td>
			                                         		<td>
			                                         			<div class="funkyradio-warning" style="width:120px">
					                                                <input type="radio" name="tipoEgreso" id="CCheque"  />
					                                                <label for="CCheque" class="ECE_lbCheckBox"> &nbsp;Cheque</label>
			                                             		</div>
			                                         		</td>
			                                         		<td>
			                                         			<div class="funkyradio-warning" style="width:120px">
					                                                <input type="radio" name="tipoEgreso" id="CRembolsos"  />
					                                                <label for="CRembolsos" class="ECE_lbCheckBox"> &nbsp;Rembolsos</label>
			                                             		</div>
			                                         		</td>
			                                         		<td>
			                                         			<div class="funkyradio-warning" style="width:120px">
					                                                <input type="radio" name="tipoEgreso" id="CDeudores"  />
					                                                <label for="CDeudores" class="ECE_lbCheckBox"> &nbsp;Deudores</label>
			                                             		</div>
			                                         		</td>
			                                         		<td  align="center">
			                                        			<div class="funkyradio-warning" style="width:120px">
				                                                <input type="radio" name="tipoEgreso" id="CRedondeo" />
				                                                <label for="CRedondeo" class="ECE_lbCheckBox"> &nbsp;Redondeo</label>
			                                            		</div>
			                                        		</td>
			                                        		<td  align="center">
			                                        			<div class="funkyradio-warning" style="width:120px">
				                                                <input type="radio" name="tipoEgreso" id="CNomina" />
				                                                <label for="CNomina" class="ECE_lbCheckBox"> &nbsp;Nomina</label>
			                                            		</div>
			                                        		</td>
			                                         		<td>
			                                         			<div class="funkyradio-warning" style="width:80px">
					                                                <input type="radio" name="tipoEgreso" id="CTodos" checked="checked" />
					                                                <label for="CTodos" class="ECE_lbCheckBox"> &nbsp;Todos</label>
			                                             		</div>
			                                         		</td>
			                                         	</tr>
			                                        </table>		                                                          
				                                </div> 
								 			</td>
								 		</tr>
								 	</table>
							 		
							 		<!-- FILTROS DE BUSQUEDA  -->	
									<table align="center" width="80%" style="border: 1px solid #DDDDDD; border-top: 0px">
										<tr>
											<td>
												<div style="padding:0px; width:100%;">
													<br>
													<table width="90%" align="center">
			                                         	<tr>
			                                         		<td>
			                                         			<label class="EG_lbtexto">Fecha Inicio:</label>
			                                         		</td>
			                                         		<td>
			                                         			<input type="text" id="txt_fechaIni" class="EG_calendario">
			                                         		</td>
			                                         		<td>
			                                         			<label class="EG_lbtexto">Fecha Fin:</label>
			                                         		</td>
			                                         		<td>
			                                         			<input type="text" id="txt_fechaFin" class="EG_calendario">
			                                         		</td>
			                                         		<td>
			                                         			<label class="EG_lbtexto">Estatus:</label>
			                                         		</td>
			                                         		<td>
			                                         			<select id="cmbEstatus"  name="cmbEstatus" class="EG_cmb">	
																	<c:forEach var="sts" items="${listaEstatus}" >
																			<option value="${sts.id_estatus}" >${sts.nombre_estatus}</option>
																	</c:forEach>
																</select>
			                                         		</td>
			                                         		<td>
			                                         			<button class="btn btn-primary" type="submit"  style="padding:3px; font-size:13px;  width: 90px" onclick="consultaEngresosBD()"  >
																	<i class="glyphicon glyphicon-search"></i> Buscar
																</button>
			                                         		</td>
			                                         		<td>
			                                         			<button id="btn_NuevoEgreso" class="btn btn-info" type="submit"  style="padding:3px; font-size:13px;  width: 110px" onclick="mostrarAlertaNuevoEgreso()"  >
																	<i class="glyphicon glyphicon-plus"></i> Nuevo Egreso
																</button>
			                                         		</td>
			                                         	</tr>
													</table>
													<br>
												</div>
											</td>
										</tr>
									</table>
							 		
							 		<br>
							 		<br>
							 		<!-- GRID DE INGRESOS  CAPTURADOS  -->	
								 	<table>
										<tr>
											<td align="center">
											 	<div id="dgEgresos" class="EG_DivGrid" ></div>
											</td>
										</tr>   
								 	</table>								 	
								 	<table align="center" width="50%">
	                                	<tr>
											<td align="center">
												<div id="divMjsInfo" style=" padding:3px; display: none; ">	
													<div class="alert alert-warning alert-dismissible fade in" >
													    <strong>¡Atenci&oacute;n!</strong> &nbsp; <label id ="lbMsjInfo" style="font-weight: normal"> </label> 
													    <button type="button" class="close" onclick="OcultarDiv('divMjsInfo')">&times;</button>
													</div>
											    </div>
											</td>
										</tr>
									</table>
							 	
							 	</div>			
							 </div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		
	</body>
</html>