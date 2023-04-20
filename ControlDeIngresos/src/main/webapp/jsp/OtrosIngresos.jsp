<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		
		<!--  HOJAS DE ESTILOS -->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/EstilosMenu.css">
		<link rel="stylesheet" type="text/css" href="css/EstilosControlIngresos.css">
		<link rel="stylesheet" type="text/css" href="css/EstilosGenerales.css">
		<link rel="stylesheet" type="text/css" href="css/EstilosPieDePagina.css">
		
		<!--  FUNCIONES JS  -->
		<script type="text/javascript" src="js/jquery-ui.min"></script> 
		<script type="text/javascript" src="js/jquery.js"></script> 
		<script  type="text/javascript" src="js/bootstrap.js"></script> 
		<script  type="text/javascript" src="js/bootstrap.min.js"></script>
		<script  type="text/javascript" src="js/jsControlIngresos.js"></script> 
		<script  type="text/javascript" src="js/jsGeneral.js"></script> 
		<script  type="text/javascript" src="js/jquery.min.js"></script>
		
		<script type="text/javascript">
			  $(function () {
	               $(document).keydown(function (e) {
	                   return (e.which || e.keyCode) != 116;
	               });
	           });
		
			  window.onload = function() 
			  {
				  window.location.hash="no-back-button";
				  window.location.hash="Again-No-back-button";//esta linea es necesaria para chrome
			  };
			  window.onhashchange=function(){window.location.hash="no-back-button";}
			  
		</script>
	</head>
	<body onload="IniciaModuloOtrosIngresos('divOtrosIngresos','tdOtrosIngresos')">
		
		 <!-- PIE DE PAGINA  -->
		<%@include file="PieDePagina.html" %>
		
		 <!-- ENCABEZADO  -->
		<%@include file="Encabezado.html" %>
		
		<div class="EG_divPrincipal" style="text-align:center">
			<table width="100%" align="center">
				<tr>
					<td width="10%"  valign="top" >
						 <div style="background: #C0D9EF; height:8500px; width:120px" >
						 	<%@include file="Menu.html" %>		 
						 </div>
					 </td>
					 <td valign="top" width="90%" align="center">
					 	<br>
					 	<!--VENTANA EMERGENTE PARA MANTENIMIENTO -->
					 		<%@include file="AlertaMantenimientoOIngresos.html" %>	
				 		
				 		
				 		<!-- ALERTA DE ESPERA -->
						<%@include file="AlertaMensajeDeEspera.html" %>
				 		
				 		
					 	<!--VENTANA PRINCIPAL DE OTROS INGRESOS  -->						 	
						<div id="divOtrosIngresos" style="width:95%;">
							<form action="ControlDeIngresosServlet" method="post" id="IdcontrolOtrosIngresos">	
								<div style=" display: inline-block; width: 90%">
									<table width="80%" align="center">
										<tr>
											<td width="100%" align="center">
												<label style="color:#439ED4" class="EG_lbTituloAzul"> Otros Ingresos </label>
											</td>
										</tr>
									</table>
								</div>
								
								<div style="border:1px solid #DDDDDD; display: inline-block; border-radius:2px; width:90%">
									<table width="90%" align="center" class="EM_tbH_eader">	
										<tr>
											<td>
												<div style="width: 100%; "> 
													<br>
													<table align="center" width="100%" class="EM_tbH_eader">
														<tr>
															<td align="left"><label class="EG_lbtexto">Concepto:</label></td>
															<td align="left"><label class="EG_lbtexto">Precio:</label></td>
															<td align="left"><label class="EG_lbtexto">Cantidad:</label></td>
															<td align="left"><label class="EG_lbtexto">Kilos:</label></td>
															<td align="left"><label class="EG_lbtexto">Importe:</label></td>
														</tr>					
														<tr>																									
															<td align="left">
																<select id="cmbConcepto"  name="concepto" class="ECI_cmbOI" onchange="obtienePrecio('normal')">
																	<option value="0"  selected="selected">SELECCIONA</option>		
																	<c:forEach var="oi" items="${listaOtrosIngresos}">
																		<c:if test="${oi.id_otro_ingreso > 1}">
																			<c:choose>
																					<c:when test="${oi.id_otro_ingreso == ConceptoSession}">
																						<option value="${oi.id_otro_ingreso}"  selected="selected">${oi.descripcion}</option>		
																					</c:when>
																					<c:otherwise>
																						<option value="${oi.id_otro_ingreso}">${oi.descripcion}</option>
																					</c:otherwise>
																			</c:choose>		
																		</c:if>
																	</c:forEach>
																 </select>
																 <button id="btn_mantoPrecioConceptos" class="btn btn-success" type="button"  style="padding:3px; font-size: 12px; font-weight: normal; border-radius:12px " onclick="MostrarMtoPrecio();" >
																	<i class="glyphicon glyphicon-plus"></i>
																 </button>
															</td>
															<td>
													    		<input id="txtPrecio" type="text"  name="precio" class ="ECI_txtOI"  value="${PrecioSession}"  onkeypress="return EsNumero(event)">
															</td>
															
															<td align="left">
															    <input id="txtCantidad"type="text"  name="cantidad" class ="ECI_txtOI" value="${CantidadSession}"  maxlength="4" onkeyup="CalculaImporte(event)" onkeypress="return EsNumero(event)">
															</td>
															
															<td align="left">
															    <input id="txtKilos" type="text"  name="kilos" class ="ECI_txtOI"  value="${KilosSession}"  maxlength="4"   onkeypress="return EsNumero(event)" >
															</td>
															
															<td align="left">
															    <input id="txtImporte"type="text"  name="importe" class ="ECI_txtOI"  value="${ImporteSession}" onkeypress="return EsNumero(event) " >
															</td>
															
															<td>
																<input type="hidden" name="vista" id="idIndex" value="OtrosIngresos.jsp" >
																<input type="hidden" name="operacion" id="idIndex" value="IngresaCobroTemporal" >
																<button class="btn btn-info" type="submit"  style="padding:3px; font-size:13px; width:100px" >
																	<i class="glyphicon glyphicon-plus"></i> Agregar
																</button>
															</td>											
														
														
														</tr>
													</table>
													<br>
													<table align="center">
														<tr>
															<td align="center">
																<c:if test="${not empty datoIncorrecto}">
																	<div id="divMensajeError" style=" padding:3px">	
																		<div class="alert alert-danger alert-dismissible fade in" >
																		    <strong>Error:</strong> <label id ="lbMsjError" style="font-weight: normal">${datoIncorrecto}</label>
																		    <button type="button" class="close" onclick="OcultarDiv('divMensajeError')">&times;</button>
																		</div>
																	</div>
																</c:if>
															</td>
														</tr>
													</table>
													<table align="center">
													 	<tr>
													 		<td align="center" >
																<c:if test="${not empty exitoInsertar}">
																	<div id="divMensajeError" style=" padding:3px">	
																		<div class="alert alert-success alert-dismissible fade in" >
																		     <label id ="lbMsjExito" style="font-weight: normal">${exitoInsertar}</label> <strong>¡Correctamente!</strong>
																		    <button type="button" class="close" onclick="OcultarDiv('divMensajeError')">&times;</button>
																		</div>
																	</div>
																</c:if>
															</td>												 		
													 	</tr>
													</table>
												</div>
											</td>
										</tr>
									</table>
								</div>									
							</form>	
							<c:if test="${ListDetTmpIngresos != null}">	
								<div style="width:100%; ">
									<br>
									<br>
									<br>
									<form action="ControlDeIngresosServlet" method="post">
										 <table align="center" width="100%" >
										 	<tr>
										 		<td align="center"><label class="ECI_lbtextoAzul"> Folio:</label></td>
												<td>
													<input id="txtFolioFisico" type="text"  name="folioFisico" class ="ECI_txtOI"  value="${FolioFisico}"  onkeypress="return EsNumero(event)">
												</td>
												<td align="center"><label class="ECI_lbtextoAzul"> Forma Pago:</label></td>
												<td align="left">
													<select id="cmbFormaPago"  name="formaPago" class="ECI_cmbOI" >	
														<c:forEach var="fp" items="${listaFormas_Pago}">
															<option value="${fp.cve_forma_pago}" >${fp.nombre_forma_pago}</option>												
														</c:forEach>
													</select>
												</td>
												<td align="center"><label class="ECI_lbtextoAzul">Banco Emisor:</label></td>
												<td align="left">
													<select id="cmbBanco"  name="banco" class="ECI_cmbOI" >	
														<c:forEach var="ba" items="${listaBancos}">
															<option value="${ba.cve_banco}" >${ba.nombre_banco}</option>												
														</c:forEach>
													</select>
												</td>
												<td align="center"><label class="ECI_lbtextoAzul">Banco Deposito:</label></td>
												<td align="left">
													<select id="cmbBancoDeposito"  name="bancoDeposito" class="ECI_cmbOI" >	
														<c:forEach var="ba" items="${listaBancos}">
														<c:if test="${ba.deposito == '1'}">
															<option value="${ba.cve_banco}" >${ba.nombre_banco}</option>	
														</c:if>											
														</c:forEach>
													</select>
												</td>
												<td align="center"><label class="ECI_lbtextoAzul">Referencia:</label></td>
												<td align="left">
													<input id="txtReferenciaOI" type="text"  name="referenciaOI" class ="ECI_txtOI"  style="width:200px" value="${ReferenciaOI}" >													
												</td>
												<td align="right">
									 				<input type="hidden" name="vista" id="idIndex" value="OtrosIngresos.jsp" >
													<input type="hidden" name="operacion" id="idIndex" value="InsertaIngresosACaja" >
													<button class="btn btn-primary" type="submit"  style="padding:4px; width:100px" >
														<i class="glyphicon glyphicon-ok"></i> Guardar
													</button>
										 		</td>
										 	</tr>
										  </table>
										 
									 </form>
									<br>
									<table width=70% class="EM_tbH_eader"  align="center">
									 	<tr>
									 		<th class="ECI_th"> <label>CONCEPTO</label></th>
									 		<th class="ECI_th"> <label>PRECIO</label></th>
									 		<th class="ECI_th"> <label>CANTIDAD</label></th>
									 		<th class="ECI_th"> <label>KILOS</label></th>
									 		<th class="ECI_th"> <label>IMPORTE</label></th>
									 		<th class="ECI_th"> <label> </label></th>
									 	</tr>
									 	<c:set  var="index" value="1"/>
									 	<c:forEach var="concepto" items="${ListDetTmpIngresos}">
										 	<c:if test="${concepto.otros_ingresos == 'TOTAL'}" >
											 	<tr>
											 		<td class="ECI_tdTotales" align="left" style="display: none"></td>
											 		<td class="ECI_tdTotales" align="left">${concepto.otros_ingresos}</td>
											 		<td class="ECI_tdTotales" align="center">$ ${concepto.precio}</td>
											 		<td class="ECI_tdTotales" align="center">${concepto.cantidad}</td>
											 		<td class="ECI_tdTotales" align="center">${concepto.kilos}</td>
											 		<td class="ECI_tdTotales" align="right">$ ${concepto.importe}</td>
											 		<td class="ECI_tdTotales" align="right"> </td>
												 </tr>
												 <c:set  var="index" value="0"/>
											</c:if>
									 		<c:choose>
									 			<c:when test="${index > 0}">
									 				<form action="ControlDeIngresosServlet" method="post">												 				
										 				<tr>
										 					<td class="ECI_td" align="left" style="display: none">
										 						<input type="text" name="conceptoTmp" value="${concepto.id_otros_ingresos}" />
										 					</td>
													 		<td class="ECI_td" align="left">${concepto.otros_ingresos}</td>
													 		<td class="ECI_td" align="center">$ ${concepto.precio}</td>
													 		<td class="ECI_td" align="center">${concepto.cantidad}</td>
													 		<td class="ECI_td" align="center">${concepto.kilos}</td>
													 		<td class="ECI_td" align="right">$ ${concepto.importe}</td>
													 		<td class="ECI_td" align="right">
													 			<input type="hidden" name="vista" id="idIndex" value="OtrosIngresos.jsp" >
																<input type="hidden" name="operacion" id="idIndex" value="EliminaConceptoTmpXId" >
													 			 <button class="btn btn-danger" type="submit"  style=" padding:3px; width:30px ">
										                            <i class="glyphicon glyphicon-remove"></i> 
									                            </button>
													 		</td>
													 	</tr>
												 	</form>
									 			</c:when>
									 		</c:choose>	
									 		<c:set  var="index" value="${index + 1}"/>
									 	</c:forEach>
									 </table>
									<br>
								</div>
							</c:if>
							<br>
							<table>
								<tr>
									<td>
										 <div id="dvGridOtrosIngresos" style="align-content:center; font-size: 75%; font-weight: normal;  font-family:Arial"></div>
									</td>
								</tr>
						    </table>
						</div>		
					 </td>
				</tr>
			</table>
		</div>		
	</body>
</html>