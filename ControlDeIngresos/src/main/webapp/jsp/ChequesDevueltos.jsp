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
<script type="text/javascript" src="js/jsChequesDevueltos.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<!--  CSS BOOTSTRAP  y JQUERY-->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/jsgrid.css">
<link rel="stylesheet" type="text/css"
	href="css/jquery-ui-1.10.3.custom.css">


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
<link rel="stylesheet" type="text/css" href="css/EstilosChequesDevueltos.css">

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
</head>

<body onload="IniciaModuloChequesDevueltos('divChequesDevueltos', 'tdChequesDevueltos')">
			<!-- ALERTA DE ESPERA -->
	<%@include file="AlertaMensajeDeEspera.html"%>
	<%@include file="Encabezado.html"%>
			<!-- ALERTA CHEQUE NUEVO DEVUELTO -->
	<%@include file="AlertaNuevoChequeDevuelto.html"%>
			<!-- ALERTA CANCELACION CHEQUE -->
	<%@include file="AlertaCancelacionCheque.html"%>
	<div class="EG_divPrincipal" style="text-align: center">
		<table width="100%" align="center">
			<tr>
				<td width="10%" valign="top">
					<div style="background: #C0D9EF; height: 860px; width: 120px">
						<%@include file="Menu.html"%>
					</div>
				</td>
				<td valign="top" width="90%"><br><br><br>
					<div id="divChequesDevueltos" style="width: 100%;"></div>
					<table width="100%" align="center">
						<tr>
							<td width="100%" align="center">
								<label style="color: #439ED4" class="EG_lbTituloAzul">Consulta Cheques Devueltos <br> </label> 
								<!-- FILTROS DE BUSQUEDA  -->
								<table align="center" width="95%" style="border: 1px solid #DDDDDD;">
									<tr>
										<td>
											<div style="padding: 0px; width: 90%;"><br>
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
															<label class="EG_lbtexto">Folio:</label>
														</td>
														<td>
															<input type="text" id="txt_folio" class="EG_cmb " style="text-align: center;">
														</td>
														<td>
															<label class="EG_lbtexto">Estatus:</label>
														</td>
														<td>
															<select id="cmbEstatus" name="cmbEstatus" class="EG_cmb">
																<c:forEach var="sts" items="${listaEstatus}">
																	<option value="${sts.id_estatus}">${sts.nombre_estatus}</option>
																</c:forEach>
															</select>
														</td>
														<td>
															<button class="btn btn-primary" type="submit" style="padding: 4px; width: 100px" onclick="consultaChequesBD()">
																<i class="glyphicon glyphicon-search"></i> Buscar &nbsp;&nbsp;
															</button>
														</td>
														<td>
															<button type="button" class="btn btn-success btn-md" onclick="MostrarMtoChq();" style="padding: 5px; font-size: 12px; font-weight: normal; " data-toggle="modal" data-target="#exampleModal">
																<i class="glyphicon glyphicon-plus"> </i> Agregar Cheque
															</button>
														</td>
													</tr>
												</table><br>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					
					<table align="center">
						<tr><br>
							<td align="center">
								<c:if test="${chequeCancelados == 'chequeCancelados'}">
									<div id="divMjsExito" style="padding: 3px; width: 400px;">
										<div class="alert alert-success alert-dismissible fade in">
											<label id="lbMsjExito" style="font-weight: normal">Cheque(s) Devuelto(s) Guardado(s) <strong>¡Correctamente!</strong></label>
											<button type="button" class="close"	onclick="OcultarDiv('divMjsExito')">&times;</button>
										</div>
									</div>
								</c:if>
							</td>
						</tr>
				
						<tr>
							<td align="center">
								<div id="divMjsExitoManto" style="padding: 3px; width: 400px; display: none;">	
									<div class="alert alert-success alert-dismissible fade in" >
										 <label id ="lbMsjExitoManto"  style="font-weight: normal"></label> 
										<button type="button" class="close" onclick="OcultarDiv('divMjsExitoManto')">&times;</button>
									</div>
								</div>
							</td>
						</tr>
		
						<tr>
							<td align="center">
								<div id="dgChequesDevueltos" class="EG_DivGrid"></div>
							</td>
						</tr>
					</table>
					<table align="center" width="50%">
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