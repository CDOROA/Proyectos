<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Control de Ingresos CDO-ROA</title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/jquery-ui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jsChequesPosfechados.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		
		<!--  CSS BOOTSTRAP  y JQUERY-->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/jsgrid.css">
		<link rel="stylesheet" type="text/css"href="css/jquery-ui-1.10.3.custom.css">
			
		<!--  JS PERSONALIZADO Y JQUERY -->
		<script type="text/javascript" src="js/jsConfirmaIngresosACaja.js"></script>
		<script type="text/javascript" src="js/jsGeneral.js"></script>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jsjquery.min.js"></script>
				
		<!--  JS JSGRID -->
		<link rel='stylesheet prefetch' href="css/jsgrid.min.css" />
		<link rel='stylesheet prefetch' href="css/jsgrid-theme.min.css" />
		<script type="text/javascript" src="js/jsgrid.js"></script>
		<script type="text/javascript" src="js/jsgrid.min.js"></script>
			
		<!--  JS BOOTSTRAP -->
		<script type="text/javascript" src="js/bootstrap.js"></script>
			
		<!--  CSS BOOTSTRAP  y JQUERY-->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/jsgrid.css">
		<link rel="stylesheet" type="text/css"
			href="css/jquery-ui-1.10.3.custom.css">
		
		<!--  CSS PERSONALIZADO -->
		<link rel="stylesheet" type="text/css" href="css/EstilosMenu.css">
		<link rel="stylesheet" type="text/css" href="css/EstilosGenerales.css">
		<link rel="stylesheet" type="text/css" href="css/EstilosChequesPosfechados.css">
		
		<!--  CSS y JS CALENDARIO -->
		<link rel="stylesheet" href="css/jquery-ui.css" />
		<script src="js/jquery-ui.js"></script>
		
		<script type="text/javascript">
			$(function() {
				$("#txt_fechaIni").datepicker();
				$("#txt_fechaFin").datepicker();
			});
		
			$(function() {
				$(document).keydown(function(e) {
					return (e.which || e.keyCode) != 116;
				});
			});
		</script>
		<script>
			$(document).ready(function() {
		
				$(".boton").click(function() {
					var valores = "";
					// Obtenemos todos los valores contenidos en los <td> de la fila
					// seleccionada
					$(this).parents("tr").find("td").each(function() {
		
						valores += $(this).html() + "\n";
					});
					alert(valores);
				});
			});
		</script>
		
		<script type="text/javascript">
				 function imprimirCheques()
		         {
		              var divToPrint = document.getElementById('divChequesImpresion');
		              var newWin = window.open('', 'Print-Window');
		              newWin.document.open();
		              newWin.document.write('<html>' +
		                                  '<body onload="window.print()">' +
		                                  divToPrint.innerHTML +
		                                  '</body></html>');
		
		              newWin.document.close();
		              setTimeout(function () { newWin.close(); }, 10);         
		         }
		</script>
	
	</head>

<body onload="IniciaModuloChequesPosfechados('divChequesPosfechados', 'tdChequesPosfechados')">
	
	 <!-- PIE DE PAGINA  -->
     <%@include file="PieDePagina.html" %>
	 <%@include file="Encabezado.html"%>
	 <%@include file="AlertaAgregarFichaDeposito.html"%>
	 <%@include file="AlertaCancelacionChequePosfechado.html"%>
	 <%@include file="AlertaPosfechados.html"%>
	 <%@include file="AlertaMensajeDeEspera.html"%>
	
	<div class="EG_divPrincipal" style="text-align: center">
		<table width="100%" align="center">
			<tr>
				<td width="10%" valign="top">
					<div style="background: #C0D9EF; height: 860px; width: 120px">
						<%@include file="Menu.html"%>
					</div>
				</td>
				<td valign="top" width="90%"><br>
					<div id="divChequesDevueltos" style="width: 80%;"></div>
					<table width="95%" align="center">
						<tr>
							<td width="100%" align="center">
								<label style="color: #439ED4" class="EG_lbTituloAzul"> Cheques Posfechados <br> </label> 
								<table align="center" width="90%" style="border: 1px solid #DDDDDD; ">
									<tr height="5px"><td></td></tr>
									<tr>
										<td>
											<table width="80%" align="center">
												<tr>
													<td rowspan="2"></td>
													<td align="center" >
														<label class="EG_lbtexto">Banco:</label>	
													</td>
													<td align="center" >
														<select id="cmbBanco" name="cmbBanco" class="EG_cmb"style="width: 150px">
														<option value="00">Selecciona</option>
															<c:forEach var="ba" items="${listaBancos}">
																<option value="${ba.cve_banco}*${ba.nombre_banco}" >${ba.nombre_banco}</option>
															</c:forEach>
														</select>
													</td>
													<td align="center" >
														<label class="EG_lbtexto">Usuario:</label>
													</td>
													<td align="center" >
														<select id="cmbUsuario" name="cmbUsuario" class="EG_cmb" style="width: 150px">
														<option value="00">Selecciona</option>
															<c:forEach var="usuCr" items="${listaUsuariosCredito}">
																<option value="${usuCr.cve_usu_credito}*${usuCr.nombre_usu_credito}">${usuCr.cve_usu_credito} - ${usuCr.nombre_usu_credito}</option>
															</c:forEach>
														</select>
													</td>
													<td align="center" >
														<label class="EG_lbtexto">Cheque:</label>
													</td>
													<td align="center" >
														<input type="text" id="txt_cheque" class="EG_cmb " onKeyPress="return soloNumeros(event);" style="text-align: center; ">
													</td>
													<td align="center" >
														<label class="EG_lbtexto">Estatus:</label>
													</td>
													<td align="center" >
														<select id="cmbEstatus" name="cmbEstatus" class="EG_cmb" style="width: auto">
															<c:forEach var="sts" items="${listaEstatusPosfechados}">
																<option value="${sts.id_estatus}*${sts.nombre_estatus}">${sts.nombre_estatus}</option>
															</c:forEach>
														</select>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr height="5px"><td></td></tr>
									<tr height="5px"><td width=80%; style="border-top: 1px solid #DDDDDD; width:95%;padding: 5px" align="center"></td></tr>
									<tr>
										<td>
											<table width="98%" align="center">
												<tr>
													<td>
														<div class="funkyradio" style="padding:0px; width:100%;" id="cbxsTipoFecha"  >
															<table width="80%" align="center">
																<tr>
																	<td align="left">
																	<div class="funkyradio-warning" style="width:fit-content">
																		  <input type="hidden" id="txt_IdsChecksSeleccionados">
																		  <input type="hidden" id="nivelUsuario" value="${infoUsu.nivel_usuario}">
																		  <input type="hidden" id="datoNumerico" value="${infoUsu.dato_numerico}">
																		  <input type="hidden" id="nombreUsuario" value="${infoUsu.nombre}">
																		  <input type="hidden" id="claveUsuario" value="${infoUsu.cve_usuario}">
																		  <input type="hidden" id="lstEstatusPosfechados" value="${lstEstatusPosfechados}">
																		  <input type="hidden" id="datosJsGrid" >
																	</div>
					                                     			</td>
					                                     			<td align="left" >
					                                     				<div class="funkyradio-warning" style="width:120px"  >
							                                              <input type="radio" name="tipoFecha" id="depositoFecha" checked="checked"  />
							                                              <label for="depositoFecha" class="ECI_lbCheckBox"> &nbsp;Fecha Deposito</label>
							                                       		</div>
					                                  				</td>
						                                     		<td width="10px"></td>
																	<td>
							                                  			<div class="funkyradio-warning" style="width:140px">
							                                              <input type="radio" name="tipoFecha" id="posfechadoFecha" />
							                                              <label for="posfechadoFecha" class="ECI_lbCheckBox"> &nbsp;Fecha Envio Caja</label>
							                                       		</div>
							                                 		</td>
							                                 		<td width="10px"></td>
																	<td align="left">
							                                  			<div class="funkyradio-warning" style="width:120px">
							                                              <input type="radio" name="tipoFecha" id="pagoFecha" />
							                                              <label for="pagoFecha" class="ECI_lbCheckBox"> &nbsp;Fecha Pago</label>
							                                       		</div>
							                                 		</td>
																</tr>
															</table>
														</div>	
													</td>
													<td>
														<label class="EG_lbtexto">Fecha Inicio:</label>
														<input type="text" id="txt_fechaIni" class="EG_calendario">
													</td>
													<td>
														<label class="EG_lbtexto">Fecha Fin:</label>
														<input type="text" id="txt_fechaFin" class="EG_calendario">
													</td>
													<td>
														<button class="btn btn-primary" type="submit" style="padding: 3px; width: 180px" onclick="consultaChequesBD()">
															<i class="glyphicon glyphicon-search"></i> Buscar Posfechados
														</button>
													</td>	
												</tr>											
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<div style="height:10px "></div>
					<table width="89%"  align="center">
						<tr>
							<td width="82px"></td>
							<td align="left" width="500px">
								<button type="button"  style="display: none" id="btnConfirmado" onclick="alertaActualizarEstatus('confirmado','N')" class="btn btn-sm btn-success"> Confirmado por Cliente <span class="glyphicon glyphicon-check"></span> </button>
								<button type="button"  style="display: none" id="btnTransito" onclick="alertaActualizarEstatus('transito','N')" class="btn btn-sm btn-info"> Transito de Deposito <span class="glyphicon glyphicon-road"></span> </button>
								<button type="button"  style="display: none" id="btnDepositado" onclick="alertaActualizarEstatus('deposito','S')" class="btn btn-sm btn-warning"> Confirma Deposito en Banco <span class="glyphicon glyphicon-saved"></span> </button>
								<button type="button"  style="display: none" id="btnCancelar" onclick="mostrarAlertaCancelacionCheque('cancelar','N')" class="btn btn-sm btn-danger"> Cancelar <span class="glyphicon glyphicon-trash"></span> </button>
								<button type="button"  style="display: none" id="btnCancelarCredito" onclick="mostrarAlertaCancelacionCheque('cancelar','C')" class="btn btn-sm btn-danger"> Cancelar <span class="glyphicon glyphicon-trash"></span> </button>
								<button  class="btn btn-primary" type="submit" id="btnImprimirChequePostfechado"  style="padding:3px; font-size:13px;"  onclick="imprimirCheques()"> Imprimir Cheques  <span class="glyphicon glyphicon-print"></span></button>
							</td>
							<td>
								<table width="85%" id="divMjsAlert" style="display: none;" >
									<tr>
										<td>
											<div class=" alert alert-danger alert-dismissible" style="width: 85%;align="center" id="divMjsAlert">
												<a href="#" class="close" onclick="OcultarDiv('divMjsAlert')" aria-label="close" style="margin: 10px 0px 0px 0px;">×</a>
												<label id="lbMsjAlert" style="margin: 10px 0px 0px 0px;"></label>
											</div>
										</td>
									</tr>
								</table>
								<table width="85%" id="divMjsSuccess" style="display: none;" >
									<tr>
										<td>
											<div class=" alert alert-success alert-dismissible" style="width: 85%;align="center" id="divMjsSuccess">
												<a href="#" class="close" onclick="OcultarDiv('divMjsSuccess')" aria-label="close" style="margin: 10px 0px 0px 0px;">×</a>
												<label id="lbMsjSuccess" style="margin: 10px 0px 0px 0px;"></label>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<table align="center"  width="98%" >
						<tr>
							<td align="center" >
								<div id="dgChequesPosfechados" class="EG_DivGrid" style="font-family: arial; font-size: 10px"></div>
							</td>
						</tr>
					</table>
					
					<div id="divChequesImpresion" style="width:80%; display: none ">
					</div>
					
					<table align="center" width="80%">
						<tr>
							<td align="center">
								<div id="divMjsInfo" style="padding: 3px; display: none;">
									<div class="alert alert-warning alert-dismissible fade in"><strong>¡Atenci&oacute;n!</strong> &nbsp; 
										<label id="lbMsjInfo" style="font-weight: normal"></label>
										<button type="button" class="close" onclick="OcultarDiv('divMjsInfo')">&times;</button>
									</div>
								</div>
							</td>
						</tr>
					</table>
					
				</td>
			</tr>
		</table>
	</div>	
</body>
</html>