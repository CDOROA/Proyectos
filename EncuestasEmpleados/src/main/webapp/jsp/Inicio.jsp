<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Expires" content="0">
	<meta http-equiv="Last-Modified" content="0">
	<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
	<meta http-equiv="Pragma" content="no-cache">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
		<title>Encuestas 360</title>
		<link rel="icon" type="image/x-icon" href="images/logocdo.png">
		<!--  HOJAS DE ESTILOS -->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css"></link>
		<link rel="stylesheet" type="text/css" href="css/EstilosLogin.css"></link>
		<link rel="stylesheet" type="text/css" href="css/EstilosGenerales.css"></link>
		<!--  FUNCIONES JS  -->
		<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script  type="text/javascript" src="js/jsInicio.js"></script>  
	<%int contador=0;%>
	<c:if test="${modalAMostrar== '9'}">
	<% contador=9;%>
	</c:if>
	</head>
	
	<body onload="RutinaInicio(<%=contador%>)">
	
		<form action="EmpleadosServlet" method="post">
		
			<!--  HEADER -->
	 		<header >
	 			<div class="EG_containerPrincipal" > 
		 			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	 					<div class="navbar-header"> 
							<table height="45px" >
							    <tr>
								    <td valign="middle"> <label class="EL_textosGrande">  &nbsp;&nbsp; Centro de Distribuci&oacute;n Oriente S.A de C.V </label></td>
							    </tr>
							</table>	
						</div> 
		 			</nav>
	 			</div>
	 		</header> 
	 		
	 		<!--  ESPACIO  -->
			<div id="espacio"></div>
	 		
			<!--  DIV DE LOGIN  -->
			<div class="col-sm-4"></div>
	 		<div id="DivLoguin">
	 			<table width=70% align="center">
	 				<tr>
	 					<td>
	 						<div class="panel panel-primary" >
								<div class="panel-heading">
									 <div class="panel-title" align="left"> <label class="EG_lbTituloEncabezado">Evaluaciones</label></div>
								</div>
								<div style="padding-top: 30px; background-color: white" class="panel-body" >   
									<table  align="center" width=100% >
										<tr>
											<td align="center" colspan="2">
												<div>
													<img src="images/logocdo.png" class="img-responsive navbar-brand-img" ></img>
												</div>
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center">
												<div>
													<table align="center" width="80%">
														<tr>
															<td align="center">
																<div  class="EL_msjRespuesta">														
																	
																</div>
															</td>
														</tr>
													</table>
													<br>	
													
													<input type="hidden" name="idIndex" id="idIndex" value="Inicio.jsp">									
													<div class="input-group" style="width:80%;">
														 <span class="input-group-addon"><span class="glyphicon glyphicon-home" ></span></span>
														 <select id="cmbCentros"  name="cdo" class="form-control">
																<option value="cdf">CDMX</option>
																<option value="cd2" selected="selected">PUEBLA</option>
																<option value="cdl">LEON</option>
																<option value="cdm" >MONTERREY</option>
														 </select>
													</div>	
													<br>
													<div class="input-group" style="width:80%;">
														<span class="input-group-addon" ><span class="glyphicon glyphicon-user" ></span></span>
														<input id="txtUsu" name="noEmpleado" required type="text" class="form-control" placeholder="Numero de empleado" >
													</div>
													<br>
													<div class="input-group" style="width:80%;">
														<span class="input-group-addon" ><span class="glyphicon glyphicon-lock" ></span></span>
														<input id="txtPass"type="password"  required name="psw" class="form-control" placeholder="Contrase&ntilde;a" >
													</div>
													<br>
													<table align="center" width="80%">
														<tr>
															<td align="center">
																<button id="btnSubmit" class="btn btn-primary" type="submit"  style="marging:10px;width:100%"  >
																	<i class="glyphicon glyphicon-ok"></i>Aceptar
																</button>
															</td>
														</tr>
													</table>
													<br>
												</div>
											</td>
										</tr>
									</table>	
								</div>
							</div>
	 					</td>
	 				</tr>
	 			</table>
				
			</div>
			<div class="col-sm-4"></div>
		
		
		<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-md">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header bg-warning">
						<h4 class="modal-title" style="color: #487996; font-size: 20px; font-weight: bold;">${SessionTitulo}</h4>
						<button type="button" class="close font-weight-bold" style="color: #487996" data-dismiss="modal">×</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<table width="100%">
							<tbody>
								<tr>
									<td width="10%" align="center"><img id="ImageAlert" class="img-log" src="images/Alert-48.png" style="border-width: 0px;"></td>
									<td width="90%" align="center"><br> <span id="lbl_mensaje" style="display: inline-block; color: #487996; width: 100%;">
											${SessionMensaje}</span></td>
								</tr>
							</tbody>
						</table>

					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default btn-warning font-weight-bold" style="color: #487996" data-dismiss="modal">Cerrar</button>
					</div>

				</div>
			</div>
		</div>
		</form>
	</body>
</html>