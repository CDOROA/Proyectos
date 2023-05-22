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
		<script  type="text/javascript" src="js/jsConfirmaIngresosACaja.js"></script> 
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
		<link rel="stylesheet" type="text/css" href="css/EstilosConfirmaIngresosACaja.css">
		
		<!--  CSS y JS CALENDARIO -->
		 <link rel="stylesheet" href="css/jquery-ui.css"/>
		 <script src="js/jquery-ui.js"></script>
		
		<script type="text/javascript">
			  $( function() {
				  $( "#txt_fechaIni" ).datepicker();
				  $( "#txt_fechaFin" ).datepicker();
				  $( "#txt_fechaPolizaIngreso" ).datepicker();
			  });
				
			$(function () {
			    $(document).keydown(function (e) {
			        return (e.which || e.keyCode) != 116;
			    });
			});
		</script>
		  
	</head>
	
	<body onload="IniciaModuloDeIngresos('divConfirmaIngresos', 'tdIngresos')">
		
		 <!-- PIE DE PAGINA  -->
		<%@include file="PieDePagina.html" %>
	
		 <!-- ENCABEZADO  -->
		<%@include file="Encabezado.html" %>
		
		<div class="EG_divPrincipal" style="text-align:center">
			
			<!-- ALERTA AGREGAR FOLIO  -->
			<%@include file="AlertaHojaDeRutaManual.html" %>
		
			 <!-- ALERTA DE EDICION NOTAS -->
			<%@include file="AlertaEdicionDeNotas.html" %>
		
	 		 <!-- ALERTA DE CANCELACION -->
	 		<%@include file="AlertaCancelacionDeIngreso.html" %>
	 		  		
	 		 <!-- ALERTA DE CONFIRMACION DE INGRESO --> 		
	 		<%@include file="AlertaConfirmarIngreso.html" %>
	 		
	 		 <!-- ALERTA DE CONFIRMACION DE INGRESO --> 		
	 		<%@include file="AlertaIngresosConTarjetaCredito.html" %>
	 		
	 		<!-- ALERTA DE EDITAR FECHA  POLIZA  --> 		
	 		<%@include file="AlertaEditarFechaPoliza.html" %>
	 		
	 		<!-- ALERTA CAPTURA FACTURAS MANUALES --> 		
	 		<%@include file="AlertaAgregarFacturaManual.html" %>
	 			 		
	 		<!-- ALERTA REVERTIR INGRESOS MANUALES --> 		
	 		<%@include file="AlertaRevertirIngreso.html" %>	 
	 		
	 		<!-- ALERTA DETALLE FOLIO HOJA RUTA --> 		
	 		<%@include file="AlertaDetalleFolioHojaRuta.html" %>			
	 			 		
	 			 		
	 		<!-- ALERTA MENSAJE DE ESPERA  -->
			<%@include file="AlertaMensajeDeEspera.html" %>
	 			 		
			<table width="100%" align="center">
				<tr>
					<td width="10%"  valign="top" >
						<div style="background: #C0D9EF; height:860px; width:120px" >
						 	<%@include file="Menu.html" %>		 
						</div>
					</td>
					<td valign="top" width="90%" align="center">
						<div  id ="divConfirmaIngresos">
						
							<!-- SECCION DE TITULO -->
							<table width="100%" align="center">
								<tr><td height="2px"></td></tr>
								<tr>
									<td width="100%" align="center">
										<label style="color:#439ED4; padding:0px; margin:0px" class="EG_lbTituloAzul"> Confirmaci&oacute;n de Ingresos </label>
									</td>
								</tr>
								<tr>
									<label id="lb_mj_pol_generadas" style="font-family: arial black; font-size: 16px ; font-weight: bold; color:red;"></label>
								</tr>
								<tr><td height="2px"></td></tr>
							</table>
								
							<!-- CHECKS DE TIPOS DE PAGO  -->	
						 	<table align="center" width="98%">
						 		<tr>
						 			<td align="center" valign="middle" style="background-color: #FBFBFB ; border: 1px solid #DDDDDD;height: 40px ">
						 				<div class="funkyradio" style="padding:0px; width:100%;" id="cbxsTipoPago"  >
	                                      	<table width="95%" align="center">
	                                         	<tr>
	                                         		<td>
	                                         			<div class="funkyradio-warning" style="width:155px" >
		                                                   <input type="radio" name="tipoPago" id="RelacionCobranza" />
		                                                   <label for="RelacionCobranza" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;Relaci&oacute;n Cobranza</label>
	                                            		</div>
	                                         		</td>
	                                         		<td>
	                                         			<div class="funkyradio-warning" style="width:130px">
			                                                <input type="radio" name="tipoPago" id="HojaRuta"  />
			                                                <label for="HojaRuta" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;Hoja de Ruta</label>
	                                             		</div>
	                                         		</td>
	                                         		<td>
	                                         			<div class="funkyradio-warning" style="width:130px">
			                                                <input type="radio" name="tipoPago" id="PagosContado"  />
			                                                <label for="PagosContado" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;Pagos Contado</label>
	                                             		</div>
	                                         		</td>
	                                         		<td>
	                                         			<div class="funkyradio-warning" style="width:130px">
			                                                <input type="radio" name="tipoPago" id="OtrosIngresos"  />
			                                                <label for="OtrosIngresos" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;Otros Ingresos</label>
	                                             		</div>
	                                         		</td>
	                                         		<td>
	                                         			<div class="funkyradio-warning" style="width:140px">
			                                                <input type="radio" name="tipoPago" id="FacturaCredito"  />
			                                                <label for="FacturaCredito" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;Factura Cr&eacute;dito</label>
	                                             		</div>
	                                         		</td>
	                                         		<td>
	                                         			<div class="funkyradio-warning" style="width:130px">
			                                                <input type="radio" name="tipoPago" id="LineaBancaria"  />
			                                                <label for="LineaBancaria" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;L&iacute;nea Bancaria</label>
	                                             		</div>
	                                         		</td>
	                                         		<td>
	                                         			<div class="funkyradio-warning" style="width:130px">
			                                                <input type="radio" name="tipoPago" id="FolioTraHojaRuta"  />
			                                                <label for="FolioTraHojaRuta" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;Folio Hoja Ruta</label>
	                                             		</div>
	                                         		</td>
	                                         		<td>
	                                         			<div class="funkyradio-warning" style="width:80px">
			                                                <input type="radio" name="tipoPago" id="Todos" checked="checked" />
			                                                <label for="Todos" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;Todos</label>
	                                             		</div>
	                                         		</td>
	                                         	</tr>
	                                        </table>		                                                          
		                                </div> 
						 			</td>
						 		</tr>
						 	</table>
						 								
							<!-- FILTROS DE BUSQUEDA  -->	
							<table width="98%" align="center" style="border: 1px solid #DDDDDD; border-top: 0px; border-bottom: 0px">
								<tr height="3px"></tr>
								<tr>
                           			<td style="border: 0px solid white">
                           				&nbsp;&nbsp;&nbsp;&nbsp;
                           				<label style="font-family: arial; font-size: 12px; font-variant: normal">Filtrar por Fecha:</label>
                           			</td>
                           		</tr>
							</table>
							
							<table width=98% align="center" style="border: 1px solid #DDDDDD; border-top: 0px;">
								<tr>
									<td width= "23%" style="border:0px solid red;">
										<div class="funkyradio" style="padding:0px;" id="cbxsFechasFiltro"  >
	                                      	<table width="95%" align="center">
	                                      		<tr height="3px"></tr>
	                                         	<tr>
	                                         		<td align="center">
	                                         			<div class="funkyradio-info" style="width:95px" >
		                                                   <input type="radio" name="fechas" id="FechaCreacion" checked="checked" />
		                                                   <label for="FechaCreacion" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;Creaci&oacute;n</label>
	                                            		</div>
	                                         		</td>
	                                         		<td align="center">
	                                         			<div class="funkyradio-info" style="width:70px">
			                                                <input type="radio" name="fechas" id="FechaCaja"   />
			                                                <label for="FechaCaja" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;Caja</label>
	                                             		</div>
	                                         		</td>
	                                         		<td align="center">
	                                         			<div class="funkyradio-info" style="width:100px">
			                                                <input type="radio" name="fechas" id="FechaCorteCaja"  />
			                                                <label for="FechaCorteCaja" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;Corte Caja</label>
	                                             		</div>
	                                         		</td>
	                                         		<td align="center">
	                                         			<div class="funkyradio-info" style="width:70px">
			                                                <input type="radio" name="fechas" id="FechaPoliza"   />
			                                                <label for="FechaPoliza" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;Poliza</label>
	                                             		</div>
	                                         		</td>
	                                         		
	                                         	</tr>
	                                         	<tr height="5px"></tr>
	                                        </table>		                                                          
		                                </div> 		
									</td>
									<td  width= "54%" style="border:0px solid red;">
										<!-- FILTROS POR FECHAS -->	
										<div style="border-right: 0px solid #87CEEB; width:100%;padding: 0px">										 	
							 				<table width="100%">
								 				<tr>
								 					<td align="center"  width="20%">
	                                         			<label class="EG_lbtexto">F.Inicio:</label>
	                                         			<input type="text" id="txt_fechaIni" class="EG_calendario" style="width:85px">
	                                         		</td>
	                                         		<td  align="center"  width="20%">
	                                         			<label class="EG_lbtexto">F.Fin:</label>
	                                         			<input type="text" id="txt_fechaFin" class="EG_calendario" style="width:85px">
	                                         		</td> 	                                         		
	                                         		<td align="center"  width="25%">
	                                         			<label class="EG_lbtexto">Estatus:</label>
	                                         			 <select id="cmbEstatus"  name="cmbEstatus" class="EG_cmb">	
															<c:forEach var="sts" items="${listaEstatus}" >
																<option value="${sts.id_estatus}" >${sts.nombre_estatus}</option>
															</c:forEach>
														 </select>
	                                         		</td>
	                                         		<td align="center"  width="15%">
		                                         		<div class="funkyradio" style="padding:0px; width:100%;" id="cbxsTotalizado"  >
															<table width="95%" align="center">
																<tr>
																	<td align="center">
																		<div class="funkyradio-primary" style="width:110px" >
																		  <input type="checkbox" name="totalizado" id="totalizado" onclick="MostrarOcultarTotales();" />
																		   <label for="totalizado" class="ECI_lbCheckBox" style=" margin:0px"> &nbsp;Ver Totales</label>
																		</div>
																	</td>
														        </tr>
														    </table>		                                                          
														</div> 
													</td>
													<td align="center"  width="20%" >
	                                         			<label class="EG_lbtexto" style="border-left:1px solid gray;padding-left:5px" >Folio Caja:</label>
	                                         			<input type="text" id="txtFolioIngreso" class="EG_calendario"  onkeypress="return EsNumero(event)" style="width:50px" >
	                                         		</td>
								 				</tr>	
							 				</table>
			                            </div>	
									</td> 
									<td width= "23%" style="border:0px solid red;">
										&nbsp;&nbsp;<button class="btn btn-primary" type="submit"  style="padding:3px; font-size:13px;  width: 80px" onclick="ConsultaDeIngresos()"  >
											<i class="glyphicon glyphicon-search"></i> Buscar
										</button> &nbsp;
										<button  id="btn_AgregarHojaRuta" class="btn btn-info" type="button"  style="padding:3px; font-size:13px;  width: 110px" onclick="MostrarMtoHojaDeRutaManual();"  >	
											<i class="glyphicon glyphicon-plus"></i> Hoja De Ruta 
										</button>&nbsp;										
										<button  id="btn_AgregarFacturaCredito" class="btn btn-info" type="button"  style="padding:3px; font-size:13px;  width: 80px" onclick="MostrarMtoFacturaManual();"  >	
											<i class="glyphicon glyphicon-plus"></i> Factura 
										</button>
									</td>
								</tr>							
							</table>
							
							<div style="height: 5px"></div>
							
							<!-- SECCION DE TOTALES -->	
							<%@include file="AlertaTotalizadoIngresos.html" %>
														
							<!-- ALERTAS DE ERROR Y EXITO  -->	
						    <table align="center" width="50%">
						    <tr height="10px"></tr>
                                <tr>
									<td align="center">
										<div id="divMjsError" style=" padding:3px; display: none">	
											<div class="alert alert-danger alert-dismissible fade in" >
											    <strong >¡Error!</strong>&nbsp; <label id ="lbMsjError" style="font-weight: normal"></label>
											    <button type="button" class="close" onclick="OcultarDiv('divMjsError')">&times;</button>
											</div>
										</div>
										<div id="divMjsExito" style=" padding:3px; display: none">	
											<div class="alert alert-success alert-dismissible fade in" >
											     <label id ="lbMsjExito" style="font-weight: normal"> </label> &nbsp;<strong>¡Correctamente!</strong>
											    <button type="button" class="close" onclick="OcultarDiv('divMjsExito')">&times;</button>
											</div>
										</div>
										<div id="divMjsInfo" style=" padding:3px; display: none">	
											<div class="alert alert-warning alert-dismissible fade in" >
											    <strong>¡Atenci&oacute;n!</strong> &nbsp; <label id ="lbMsjInfo" style="font-weight: normal"> </label> 
											    <button type="button" class="close" onclick="OcultarDiv('divMjsInfo')">&times;</button>
											</div>
										</div>
									</td>	
                                </tr>
                                <tr height="3px"></tr>
                            </table>
						    
						 	<!-- GRID DE INGRESOS  CAPTURADOS  -->	
						 	<table>
								<tr>
									<td align="center">
									 	<div id="dgIngresos" class="EG_DivGrid"></div>
									</td>
								</tr>   
						 	</table>
						 	<br><br><br>
						 	
						</div>
					</td>
				</tr>
			</table>
		</div>
		
		<c:if test="${msjRespuestaHojaRuta != ''}">
			<script>
				alert('${msjRespuestaHojaRuta}');
			</script>
		</c:if>
		
	</body>
</html>