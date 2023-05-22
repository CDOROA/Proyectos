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
		<script  type="text/javascript" src="js/jsMantoCheques.js"></script> 
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
				  $( "#txt_fechaPolizaMantoCheque" ).datepicker();
				  $( "#txt_fechaPolizaAltaMantoCheque" ).datepicker();				  
			  });
		
		
			$(function () {
			    $(document).keydown(function (e) {
			        return (e.which || e.keyCode) != 116;
			    });
			});
		</script>
		
	</head>
	<body onload="IniciaModuloMantoCheques('divMantocheques','tdMantoCheques')">
	
		 <!-- PIE DE PAGINA  -->
		<%@include file="PieDePagina.html" %>
		
		 <!-- ENCABEZADO  -->
		<%@include file="Encabezado.html" %>
		
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
						<div id="divMantocheques" style="width: 100%;">
							
							<br>
							 <div class="row">
							 	<div class="col-sm-12">
							 	
							 		<!-- SECCION DE TITULO -->
									<table width="80%" align="center">
										<tr>
											<td width="100%" align="center">
												<label style="color:#439ED4" class="EG_lbTituloAzul"> Mantenimiento Cheques</label>
											</td>
										</tr>
									</table>
									
									<!-- FILTROS DE BUSQUEDA POLIZA  -->
									<div style="height: 10px"></div>
									<table width=80% align="center" style="background-color: #FBFBFB ; border: 1px solid #DDDDDD;">
										<tr height="10px"></tr>
										<tr>
											<td width=20px></td>
											<td>
												<label class="EG_lbtexto">Fecha Poliza:</label>
												<input type="text" id="txt_fechaPolizaMantoCheque" class="EG_calendario">
											</td>
											<td>
												<label class="EG_lbtexto">Cheque:</label>
												<input type="text" id="txt_chequeMantoCheque" class="EG_txt">
											</td>
											<td>
												<label class="EG_lbtexto">Estatus:</label>
												<select id="cmbstatusMantoCheque" name="cmbstatusMantoCheque" class="EG_cmb" style="width: 150px">														
													<c:forEach var="sts" items="${listaEstatusNominativo}" >
														<option value="${sts.id_estatus}" >${sts.nombre_estatus}</option>
													</c:forEach>													
												</select>
											</td>
											<td valign="bottom">
								                <button  class="btn btn-info" type="submit"  style="padding:3px; font-size:13px;  width: 150px" onclick="consultaChequesNominativos()"  >
													<i class="glyphicon glyphicon-search"></i> Buscar Cheques
												</button>
												<button  ID="btn_agregarChequeNominativo"style="color:#228B22; font-size: 14px; font-weight: normal; text-decoration: underline;" type="button" class="btn btn-link" onclick="mostrarOcultarDivAltaCheque()">
													<i class="glyphicon glyphicon-plus"></i>  &nbsp;Nuevo Cheque 
												</button>
								            </td>
								            <td width=10px></td>
										</tr>	
										<tr height="10px"></tr>
									</table>
									<div style="height: 10px"></div>
										
									<table width=80% align="center" >
										<tr> 
											<td align=left>
												 
											</td>
										</tr>
									</table>	
								
									<div id="AltaChequeNominativo">
										<table width=80% align="center" style="background-color: #FBFBFB ; border: 1px solid #32CD32;">
											<tr height="10px"></tr>
											<tr>												
												<td>
													<label class="EG_lbtexto">Tipo Pago:</label>
													<select id="id_tipoPagoMantoCheque"  name="id_bancoEmisorMantoCheque" class="EG_cmb" style="width:150px">	
														<option value="0" >--Selecciona--</option>
														<option value="2" >Hoja de Ruta</option>
														<option value="3" >Ticket de Contado</option>
														<option value="4" >Otros Ingresos</option>
														<option value="5" >Factura Credito</option>
														<option value="7" >Folio Hoja Ruta</option>
													</select>												
												</td>
												<td>
													<label class="EG_lbtexto">Folio  de Caja:</label>	
													<input type="text"  id="id_folioCajaMantoCheque" name="folio" class="EG_txt" style="width:80px" onkeypress="return EsNumero(event)">								
												</td>
												<td>
													<label class="EG_lbtexto">Num. Cheque</label>
													<input type="text"  id="id_chequeMantoCheque" name="folio" class="EG_txt" style="width:80px" onkeypress="return EsNumero(event)">									
												</td>
												<td>
													<label class="EG_lbtexto">Num. Cliente:</label>
													<input type="text"  id="id_clienteMantoCheque" maxlength="5" name="folio" class="EG_txt" style="width:80px" onkeypress="return EsNumero(event)">									
												</td>
											</tr>
											<tr height="10px"></tr>
											<tr>												
												<td>
													<label class="EG_lbtexto">Importe Cheque:</label>	
													<input type="text"  id="id_importeMantoCheque" name="folio" class="EG_txt" style="width:80px" onkeypress="return EsNumero(event)">								
												</td>
												<td>
													<label class="EG_lbtexto">Banco Emisor:</label>
													<select id="id_bancoEmisorMantoCheque"  name="id_bancoEmisorMantoCheque" class="EG_cmb" style="width:150px">	
							 							<option value="0" >--Selecciona--</option>
														<c:forEach var="ba" items="${listaBancos}" >
															<option value="${ba.cve_banco}" >${ba.nombre_banco}</option>												
														</c:forEach>
													</select>									
												</td>
												<td>
													<label class="EG_lbtexto">Fecha Poliza</label>	
													<input type="text" id="txt_fechaPolizaAltaMantoCheque" class="EG_calendario">								
												</td>
												<td>
													<button  class="btn btn-success" type="submit"  style="padding:3px; font-size:13px;  width: 100px" onclick="agregarChequeNominativo()">
														<i class="glyphicon glyphicon-ok"></i> Agregar
													</button>	
																					
												</td>
											</tr>
											<tr height="10px"></tr>
										</table>
									
									</div>
									
									
									
											
									<div style="height: 10px"></div>							
									<table>
										<tr>
											<td align="center">
											 	<div id="dgChequeNominativos" class="EG_DivGrid" ></div>
											</td>
										</tr>   
								 	</table>
								 	
								 	<table align="center" width="50%">
	                                	<tr>
											<td align="center">
												<div id="divMjsInfoMantoCheques" style=" padding:3px; display: none; ">	
													<div class="alert alert-warning alert-dismissible fade in" >
													    <strong>Atenci&oacute;n</strong> &nbsp; <label id ="lbMsjInfoMantoCheques" style="font-weight: normal"> </label> 
													    <button type="button" class="close" onclick="OcultarDiv('divMjsInfoMantoCheques')">&times;</button>
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