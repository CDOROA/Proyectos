<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
	<!-- Google tag (gtag.js) --> 
		<script async src="https://www.googletagmanager.com/gtag/js?id=G-YQ1X9DRKCF"></script> 
		<script>   
			window.dataLayer = window.dataLayer || [];   
			function gtag(){
				dataLayer.push(arguments);
			}   
			gtag('js', new Date());   
			gtag('config', 'G-YQ1X9DRKCF'); 
		</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,  minimum-scale=1.0">
		<!-- CODIGO PARA NO GUARDAR CACHE -->
		<meta http-equiv="Expires" content="-1">
    	<meta http-equiv="Cache-Control" content="no-cache">
    	<meta http-equiv="Pragma" content="no-cache">
<title>Corporación Química Automotriz, S.A. de C.V. (KWX)</title>
<meta name="keywords"
	content="tapafugas, refrigerante, anticongelante, liquido para frenos, inflallantas, afloja todo, limpiador carburador, limpiador inyector, desengrasante para motor, abrillantador,pluma limpiaparabrisas, lubricantes, aditivos, filtros, monogrado, multigrado, aceite monogrado, aceite multigrado, cables para bujia, filtros de aire, filtros de gasolina, filtros de aceite, aceite para auto, selladores, aceite transmision, aceite para moto"></meta>
<meta name="description"
	content="Corporación Química Automotriz, S.A. de C.V. (KWX) es una empresa 100% mexicana certificada con la norma de calidad ISO 9001-2008, fundada en 1985 cuyo giro principal es la fabricación de productos químicos automotrices"></meta>


<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD3pAWctAaHoIRhTERJ1N3lQ_0TZe7tCqY"></script>


<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/css/bootstrap-3.3.5.min.css"
	rel="stylesheet" />

<!-- Custom styles for this template Aqui estilos propios -->
<link href="${pageContext.request.contextPath}/css/starter-style.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/starter-template.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/css/starter-template-7.css"
	rel="stylesheet" />
<style>
.form-control {
	background-color: rgba(0, 0, 0, 0.66);
	opacity: .8;
	color: #FFFFFF;
	margin-bottom: 15px;
}

.inputFaltante {
	border: #ed2525;
	border-style: groove;
}

.mi-input::-webkit-input-placeholder {
	color: #FFFFFF;
	font-weight: 700;
}

.mi-input:-moz-placeholder {
	color: #FFFFFF;
	font-weight: 700;
}

.mi-input::-moz-placeholder {
	color: #FFFFFF;
	font-weight: 700;
}

.mi-input:-ms-input-placeholder {
	color: #FFFFFF;
	font-weight: 700;
}

.mi-input1::-webkit-input-placeholder {
	color: #8B0000;
	font-weight: bold
}

.mi-input1:-moz-placeholder {
	color: #8B0000;
	font-weight: bold
}

.mi-input1::-moz-placeholder {
	color: #8B0000;
	font-weight: bold
}

.mi-input1:-ms-input-placeholder {
	color: #8B0000;
	font-weight: bold
}

#myImg {
	border-radius: 5px;
	cursor: pointer;
	transition: 0.3s;
}

#myImg:hover {
	opacity: 0.7;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.9); /* Black w/ opacity */
}

/* Modal Content (image) */
.modal-content {
	margin: auto;
	display: block;
	width: 80%;
	max-width: 700px;
}

/* Caption of Modal Image */
#caption {
	margin: auto;
	display: block;
	width: 80%;
	max-width: 700px;
	text-align: center;
	color: #ccc;
	padding: 10px 0;
	height: 150px;
}

/* Add Animation */
.modal-content,#caption {
	-webkit-animation-name: zoom;
	-webkit-animation-duration: 0.6s;
	animation-name: zoom;
	animation-duration: 0.6s;
}

@
-webkit-keyframes zoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes zoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* The Close Button */
.close {
	position: absolute;
	top: 15px;
	right: 35px;
	color: #f1f1f1;
	font-size: 40px;
	font-weight: bold;
	transition: 0.3s;
}

.close:hover,.close:focus {
	color: #bbb;
	text-decoration: none;
	cursor: pointer;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px) {
	.modal-content {
		width: 100%;
	}
}

.btn-img2 {
	color: #FFFFFF;
	background-color: #c74d31;
	font-weight: bold;
	-webkit-transform: skew(-20deg);
	transform: skew(-20deg);
	border-style: none;
	padding-top: 2px;
	padding-right: 4px;
	padding-left: 4px;
	padding-bottom: 2px;
	margin-top: 4px;
}

.btn-img2>button {
	color: #FFFFFF;
	background-color: transparent;
	font-weight: bold;
	border-style: none;
	-webkit-transform: skew(20deg);
	transform: skew(20deg);
}

.btn-img2>button:hover {
	color: #FFFFFF;
	background-color: #c74d31;
	font-weight: bold;
	border-style: none;
	-webkit-transform: skew(20deg);
	transform: skew(20deg);
}
/*Para hacer girar el boton...*/
.glyphicon-refresh-animate {
	-animation: spin .7s infinite linear;
	-webkit-animation: spin2 .7s infinite linear;
}

@
-webkit-keyframes spin2 {from { -webkit-transform:rotate(0deg);
	
}

to {
	-webkit-transform: rotate(360deg);
}

}
@
keyframes spin {from { transform:scale(1)rotate(0deg);
	
}

to {
	transform: scale(1) rotate(360deg);
}
}
</style>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-3.3.5.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery1.11.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jsPrincipal.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/SoyMecanico.js"></script>

<script type="text/javascript">
	window.onload = function() {

		initialize();

		$("#myBtn").click(function() {
			$("#myBtn").hide(200);
			$("#btn_espera").prop("disabled", true);
			$("#btn_espera").show(100);
			EnviarInformacion();
		});

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];
		// Get the modal
		var modal = document.getElementById("ModalTerminado");
		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}

		if (window.File && window.FileReader && window.FileList && window.Blob) {
			document.getElementById('fileUp').addEventListener('change',
					handleFileSelect, false);
		}

		function handleFileSelect(evt) {
			var f = evt.target.files[0]; // FileList object
			var reader = new FileReader();
			// Closure to capture the file information.
			reader.onload = (function(theFile) {
				return function(e) {
					var binaryData = e.target.result;
					//Converting Binary Data to base 64
					var base64String = window.btoa(binaryData);
					//showing file converted to base64
					document.getElementById('txt_base64').value = base64String;
					//  alert('File converted to base64 successfuly!\nCheck in Textarea');
				};
			})(f);
			// Read in the image file as a data URL.
			reader.readAsBinaryString(f);
		}

	}

	function initialize() {
		var $animation_elements = $('.animation-element');
		var $window = $(window);

		function check_if_in_view() {
			var window_height = $window.height();
			var window_top_position = $window.scrollTop();
			var window_bottom_position = (window_top_position + window_height);
			$
					.each(
							$animation_elements,
							function() {
								var $element = $(this);
								var element_height = $element.outerHeight();
								var element_top_position = $element.offset().top;
								var element_bottom_position = (element_top_position + element_height);

								//check to see if this current container is within viewport
								if ((element_bottom_position >= window_top_position)
										&& (element_top_position <= window_bottom_position)) {
									$element.addClass('in-view');
								} else {
									$element.removeClass('in-view');
								}
							});
		}

		$window.on('scroll resize', check_if_in_view);
		$window.trigger('scroll');
	}
</script>


<script>
	// Get the modal
	var modal = document.getElementById("ModalTerminado");

	// Get the image and insert it inside the modal - use its "alt" text as a caption

	var modalImg = document.getElementById("img01");
	var captionText = document.getElementById("caption");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}
</script>


<!-- Meta Pixel Code -->
<script>
!function(f,b,e,v,n,t,s)
{if(f.fbq)return;n=f.fbq=function(){n.callMethod?
n.callMethod.apply(n,arguments):n.queue.push(arguments)};
if(!f._fbq)f._fbq=n;n.push=n;n.loaded=!0;n.version='2.0';
n.queue=[];t=b.createElement(e);t.async=!0;
t.src=v;s=b.getElementsByTagName(e)[0];
s.parentNode.insertBefore(t,s)}(window, document,'script',
'https://connect.facebook.net/en_US/fbevents.js');
fbq('init', '1677679685720148');
fbq('track', 'PageView');
</script>
<noscript><img height="1" width="1" style="display:none"
src="https://www.facebook.com/tr?id=1677679685720148&ev=PageView&noscript=1"
/></noscript>
<!-- End Meta Pixel Code -->

<meta name="facebook-domain-verification" content="iwxagmmck8vlpagd55qrtzt8rx6899" />

</head>

<body class="bg-image-page-Mecanico">

	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'https://www.google-analytics.com/analytics.js', 'ga');

		ga('create', 'UA-102151860-1', 'auto');
		ga('send', 'pageview');
	</script>

 


<div>
	
	 		
<!--  Header  -->
	         <%@include file="EncabezadoKwx.html"%>
	 		
	 	</div>
		<div class="contanier-fluid">
			<div class="col-lg-3 col-md-3 col-sm-6">
				<table>
					<tr>
						<td><img class="img-responsive"
							src="${pageContext.request.contextPath}/img/Soy.png" alt=""
							style="height: 381px; display: inline-block; margin-top: 100px;"></img></td>
					</tr>
					<tr>
						<td>
							<div class="hovereffect " style="margin-top: 0px;">
								<img class="img-responsive"
									src="${pageContext.request.contextPath}/img/Regresar.png"
									alt="" style="display: inline-block;"></img>
								<div class="overlay">
									<!--   <a class="info" href="${pageContext.request.contextPath}/ServletInicio?operacion=2"> -->
									<a class="info"
										href="${pageContext.request.contextPath}/ServletMecanicos?operacion=1">
									</a>

								</div>
							</div>
						</td>
					</tr>
				</table>

			</div>
			<div class="col-lg-7 col-md-7 col-sm-6">

				<h3
					style="font-weight: bold; margin-bottom: 50px; margin-top: 45px;">
					<spam style="font-weight: bold;color: #ed2525;">KWX</spam>
					te ayuda en estos tiempos difíciles, Regístrate en nuestra página y
					obtén difusión para que más clientes puedan contactarse contigo.
				</h3>
				</br>

				<div>
					<input type="hidden" name="operacion" id="operacion" value="2">
					<div class="row">
						<div class="form-group col-md-6" style="margin-bottom: 0px;">

							<!-- <label for="cmbListaEstados" class="pull-left">Estado</label> -->
							<select name="cmbListaEstados" id="cmbListaEstados"
								class="form-control mi-input">

								<option value="0" selected="selected">- Estado -</option>
								<c:forEach var="estado" items="${listEstados}">
									<option value="${estado.descripcion}">${estado.descripcion}</option>
								</c:forEach>
							</select>

							<div style="margin-top: 15px;">
								<!--  <label for="cmbMunicipios" class="pull-left">Delegación
									o Municipio</label> -->
								<input type="text" class="form-control mi-input"
									placeholder="Delegación o Municipio" id="cmbMunicipios"
									name="cmbMunicipios">
							</div>
							<div style="margin-top: 15px;">
								<!-- <label for="txtColonia" class="pull-left">Colonia</label> -->
								<input placeholder="Colonia" type="text"
									class="form-control mi-input" id="txtColonia" name="txtColonia">
							</div>
							<div style="margin-top: 15px;">
								<!-- <label for="txtCp" class="pull-left">Código Postal</label> -->
								<input placeholder="Código Postal" type="text"
									class="form-control mi-input" id="txtCp" name="txtCp"
									onchange="Punteaubic()">
							</div>
							<div style="margin-top: 15px;">
								<!-- <label for="txtCalle" class="pull-left">Calle</label>  -->
								<input placeholder="Calle" type="text"
									class="form-control mi-input" id="txtCalle" name="txtCalle"
									onchange="Punteaubic()">
							</div>
							<div>
								<div class="form-group col-md-6" style="margin-bottom: 0px;">
									<!-- <label for="txtNumExt" class="pull-left">No. Ext.</label>  -->
									<input placeholder="No. Ext." type="text"
										class="form-control mi-input" id="txtNumExt" name="txtNumExt"
										onchange="Punteaubic()">
								</div>
							</div>
							<div>
								<div class="form-group col-md-6" style="margin-bottom: 0px;">
									<!-- <label for="txtNumInt" class="pull-left">No. Int.</label> -->
									<input placeholder="No. Int." type="text"
										class="form-control mi-input" id="txtNumInt" name="txtNumInt">
								</div>
							</div>
						</div>
						<div class="form-group col-md-6" style="margin-bottom: 0px;">

							<!-- 							<label for="txtNombreTaller" class="pull-left">Nombre del Taller</label>  -->
							<input placeholder="Nombre del Taller" type="text"
								class="form-control mi-input" id="txtNombreTaller"
								name="txtNombreTaller">

							<div style="margin-top: 15px;">
								<select id="cmbEspecialidad" class="form-control mi-input"
									required style="font-size: 14px; font-family: arial">
									<option value="0">-Especialidad del Taller-</option>
									<c:forEach var="especialidad" items="${listaEspecialidades}">
										<option value="${especialidad.id}">${especialidad.descripcion}</option>
									</c:forEach>
								</select> </select>
							</div>



							<div style="margin-top: 15px;">
								<!--<label for="txtEncargado" class="pull-left">Nombre del dueño o encargado</label>  -->
								<input placeholder="Nombre del dueño o encargado" type="text"
									class="form-control mi-input" id="txtEncargado"
									name="txtEncargado">
							</div>
							<div style="margin-top: 15px;">
								<!-- <label for="cmbBrindaServisioDomicilio" class="pull-left">Brinda
									servicio a domicilio</label> -->
								<select name="cmbBrindaServisioDomicilio"
									id="cmbBrindaServisioDomicilio" class="form-control mi-input">
									<option value="0" selected="selected">- Brinda
										servicio a domicilio -</option>
									<option value="S">SI</option>
									<option value="N">NO</option>
								</select>
							</div>

							<div style="margin-top: 15px;">
								<!-- <label for="txtTelefono" class="pull-left">Telefono	local(10 digitos)</label> -->
								<input placeholder="Teléfono local(10 dígitos)" type="text"
									class="form-control mi-input" id="txtTelefono"
									name="txtTelefono">
							</div>

							<div>
								<!-- <label for="txtWhatsapp" class="pull-left">WhatsApp</label>  -->
								<input placeholder="WhatsApp" type="text"
									class="form-control mi-input" id="txtWhatsapp"
									name="txtWhatsapp">
							</div>
						</div>
						<div class="form-group col-md-12">
							<!-- <label for="txtEmail" class="pull-left">Correo electrónico</label>  -->
							<input placeholder="Correo electrónico" type="text"
								class="form-control mi-input" id="txtEmail" name="txtEmail">

						</div>
						<div class="form-group col-md-12">
							<!-- <div style="margin-top: 20px;"> -->
							<div class="row">
								<div class="col-md-12">
									<label class="pull-left">¿Como se enteró de la página?.</label>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2"></div>
								<div class="col-md-2" style="margin-top: 15px;">
									<label class="radio-inline"> <input type="radio"
										name="optradio" value="Facebook">Facebook
									</label>
								</div>
								<div class="col-md-2" style="margin-top: 15px;">
									<label class="radio-inline"> <input type="radio"
										name="optradio" value="Instagram">Instagram
									</label>
								</div>
								<div class="col-md-2" style="margin-top: 15px;">
									<label class="radio-inline"> <input type="radio"
										name="optradio" value="Pinterest">Pinterest
									</label>
								</div>
								<div class="col-md-2" style="margin-top: 15px;">
									<label class="radio-inline"> <input type="radio"
										name="optradio" value="Youtube">Youtube
									</label>
								</div>
								<div class="col-md-2" style="margin-top: 15px;">
									<label class="radio-inline"> <input type="radio"
										name="optradio" value="WhatsApp">WhatsApp
									</label>
								</div>


							</div>
							<div class="row" style="margin-top: 15px;">
								<div class="col-md-2"></div>
								<div class="col-md-5">
									<div class="form-inline">
										<label class="radio-inline"> <input type="radio"
											name="optradio" value="Refaccionaria">Refaccionaria
										</label> <input type="text" class="form-control mi-input"
											id="txtRefaccionaria" name="txtRefaccionaria"
											style="width: 60%;">
									</div>
								</div>
								<div class="col-md-5">
									<div class="form-inline">
										<label class="radio-inline"> <input type="radio"
											name="optradio" value="Otro">Otro
										</label> <input type="text" class="form-control mi-input" id="txtOtro"
											name="txtOtro" style="width: 70%;">
									</div>
								</div>
							</div>

						</div>

					
			
			<div class="form-group col-md-12">

				<div style="margin-top: 15px;">
					<div style="margin-top: 15px;">
						<form method="post" enctype="multipart/form-data"
							id="formEnviarFoto">
							<label for="fileUp" class="pull-left">Fotografía de la
								fachada del taller.</label> <input type="file"
								style="margin-bottom: 0px;" accept="image/*"
								class="form-control" id="fileUp" name="fileUp" /> <label
								for="fileUp" class="pull-right">Tamaño máximo de la
								imagen 2MB, en formato .jpg o .png.</label>
						</form>
				</div>

				<div class="form-group col-md-12">
					<div style="margin-top: 15px;">
						<div class="checkbox">
							<label><input type="checkbox" id="chkRecibirInfo"
								name="chkRecibirInfo">Deseo recibir más información de
								capacitaciones y productos KWX.</label>
						</div>
					</div>
					<div class="btn-group btn-img2">
						<button type="button" class="btn btn-default" id="myBtn">Enviar</button>
						<button type="button" id="btn_espera" class="btn"
							style="display: none">
							<span
								class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span>Enviando,
							Espere...
						</button>
					</div>
				</div>
				<input type="text"
					style="background: transparent; width: 0px; height: 0px; border: transparent;"
					id="txt_lat" name="txt_lat"> <input type="text"
					style="background: transparent; width: 0px; height: 0px; border: transparent;"
					id="txt_lon" name="txt_lon"> <input type="text"
					style="background: transparent; width: 0px; height: 0px; border: transparent;"
					id="txt_base64" name="txt_base64">
			</div>
			<br> <br> <br> <br> <br> <br> <br> <br> <br> 
			</div>
		</div>
		</div>
		</div>

	</div>
		
 
	<!-- Modal -->
	<div id="ModalTerminado" class="modal" style="z-index: 9999;">
		<span class="close">&times;</span> <img class="modal-content"
			id="img01"
			src="${pageContext.request.contextPath}/img/RegistroExitoso.png"
			alt=""
			style="display: inline-block; background: rgba(0, 0, 0, 0.26);"></img>
		<div id="caption"></div>
	</div>

<br> <br> <br>
	 	<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aajN9AQK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
	 </body>
</html>