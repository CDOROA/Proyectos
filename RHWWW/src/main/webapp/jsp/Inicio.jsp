
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />

<!--  HOJAS DE ESTILOS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"></link>
<link rel="stylesheet" type="text/css" href="css/signin.css"></link>
<link rel="stylesheet" type="text/css" href="css/Generales.css"></link>
<link rel="icon" href="Images/0CDO.png">

<!--  FUNCIONES JS  -->
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jsInicio.js"></script>
<script type="text/javascript" src="js/sha1.js"></script>
<title>RH WWW</title>
<%int contador=0;%>
<c:if test="${modalAMostrar== '9'}">
	<% contador=9;%>
</c:if>
</head>


<body onload="RutinaInicio(<%=contador%>)">
<%@include file="Encabezado.html" %>

	<form class="form-signin" action="UsuarioServlet" method="post">
		<div class="card">
			<div class="card-heading bg-primary">
				<div class="card-title text-white font-weight-bold">Iniciar
					Sesión</div>
			</div>
			<div class="card-body">
				<div class="form-row">
					<div class="input-group mb-4">
						<img src="Images/UserLogo.png" class="img-fluid centrar"
							width="90" height="90" alt="" />
					</div>

					<div class="input-group mb-4">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<img src="Images/User-32.png" class="img-fluid centrar" alt="" />
							</div>
						</div>
						<input type="text" class="form-control" id="txtUsuario"
							name="txtUsuario" placeholder="Usuario">
					</div>
					<div class="input-group mb-4">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<img src="Images/Lock-32.png" class="img-fluid centrar" alt="" />
							</div>
						</div>
						<input type="password" id="txtPassword" name="txtPassword"
							class="form-control" placeholder="Contraseña"
							onchange="validaPsw(this)">
					</div>

					<div class="input-group mb-4">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<img src="Images/Home-32.png" class="img-fluid centrar" alt="" />
							</div>
						</div>
						<select id="cmbCentros" name="cdo_macro" class="form-control">
							<option value="cdf" selected="selected">CDMX</option>
							<option value="cd2">PUEBLA</option>
							<option value="cdl">LEON</option>
							<option value="cdm">MONTERREY</option>
						</select>
					</div>

					<div class="input-group mb-2">
						<input type="hidden" name="vista" id="idIndex" value="Inicio.jsp">
						<input type="hidden" name="proceso_web" id="idIndex" value="151">
						<button id="btn_aceptar"
							class="btn btn-primary text-white font-weight-bold" type="submit"
							style="marging: 10px; width: 100%">Aceptar</button>
					</div>

				</div>
			</div>
		</div>

		<!-- The Modal -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-md">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header bg-warning">
						<h4 class="modal-title"
							style="color: #487996; font-size: 20px; font-weight: bold;">${SessionTitulo}</h4>
						<button type="button" class="close font-weight-bold"
							style="color: #487996" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<table width="100%">
							<tbody>
								<tr>
									<td width="10%" align="center"><img id="ImageAlert"
										class="img-log" src="Images/Alert-48.png"
										style="border-width: 0px;"></td>
									<td width="90%" align="center"><br> <span
										id="lbl_mensaje"
										style="display: inline-block; color: #487996; width: 100%;">
											${SessionMensaje}</span></td>
								</tr>
							</tbody>
						</table>

					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button"
							class="btn btn-default btn-warning font-weight-bold"
							style="color: #487996" data-dismiss="modal">Cerrar</button>
					</div>

				</div>
			</div>
		</div>
	</form>
</body>
</html>