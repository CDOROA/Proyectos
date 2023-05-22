<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/css/bootstrap-3.3.5.min.css"
	rel="stylesheet" />

<!-- Custom styles for this template Aqui estilos propios -->
<link href="${pageContext.request.contextPath}/css/starter-style.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/starter-template.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/EvaluarMecanico.css"
	rel="stylesheet" />

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
	src="${pageContext.request.contextPath}/js/jsEvaluarMecanico.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


<script type="text/javascript">
	window.onload = function() {
		initialize();
		$('#cmbListaEstados').on('change', CargaDelegaciones);
		$('#cmbListaMunicipio').on('change', CargaMecanicos);
		$("#myBtn").click(function() {
			$("#myBtn").hide(200);
			$("#btn_espera").prop("disabled", true);
			$("#btn_espera").show(100);
			EnviarInformacion();
		});
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
	

	<!--  Header  -->
	         <%@include file="EncabezadoKwx.html"%>

	<br>
	<br>
	<br>

	<div class="container-fluid" style="margin-top: 50px;">

		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-6">
				<table>
					<tr>
						<td><img class="img-responsive"
							src="${pageContext.request.contextPath}/img/Evaluar_2.png" alt=""
							style="height: 381px; display: inline-block;"></img></td>
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
			<div class="col-lg-9 col-md-9 col-sm-6">
				<form action="ServletSoyMecanico" method="post">
					<input type="hidden" name="operacion" id="operacion" value="2">
					<div class="row">
						<div class="form-group col-md-4">

							<div style="margin-top: 15px;">

								<!-- <label
								for="cmbListaEstados" class="pull-left">Delegacion o
								Municipio</label> -->
								<select name="cmbListaEstados" id="cmbListaEstados"
									class="form-control mi-input">
									<option value="0" selected="selected">- Estado -</option>
									<c:forEach var="estado" items="${listEstados}">
										<option value="${estado.descripcion}">${estado.descripcion}</option>
									</c:forEach>
								</select>
							</div>

							<div style="margin-top: 15px;">
								<input type="text"
									style="background: transparent; width: 0px; height: 0px; border: transparent;"
									id="txt_municipio" name="txt_municipio">
								<!-- <label
								for="cmbListaMunicipio" class="pull-left">Delegacion o
								Municipio</label> -->
								<select name="cmbListaMunicipio" id="cmbListaMunicipio"
									class="form-control mi-input">
									<option value="0" selected="selected">- Delegación o
										Municipio -</option>
									
								</select>
							</div>

							<div style="margin-top: 15px;">
								<!-- <label
								for="cmbTalleres" class="pull-left">Seleccione un Taller</label> -->
								<select name="cmbTalleres" id="cmbTalleres"
									class="form-control mi-input">
									<option value="0" selected="selected">- Seleccione un Taller -</option>
									
								</select>
							</div>
						</div>

						<div class="form-group col-md-4">
							<div style="margin-top: 15px;">
								<!-- <label
								for="cmbRequeriServicio" class="pull-left">Requerí servicio a domicilio</label> -->
								<select name="cmbRequeriServicio" id="cmbRequeriServicio"
									class="form-control mi-input">
									<option value="0" selected="selected">- Requerí servicio a domicilio -</option>
									<option value="S">SI</option>
									<option value="N">NO</option>
								</select>
							</div>
							<div style="margin-top: 15px;">
								<!-- <label
								for="cdmEntregoFicha" class="pull-left">Me entregaron ficha con diagnóstico de mi vehículo</label> -->
								<select name="cdmEntregoFicha" id="cdmEntregoFicha"
									class="form-control mi-input">
									<option value="0" selected="selected">- Me entregaron
										ficha con diagnóstico de mi vehículo -</option>
									<option value="S">SI</option>
									<option value="N">NO</option>
								</select>
							</div>
							<div style="margin-top: 15px;">
								<!-- <label
								for=""cmbBaseDatosUtil"" class="pull-left">Me fue de utilidad la base de datos de mecánicos </label> -->
								<select name="cmbBaseDatosUtil" id="cmbBaseDatosUtil"
									class="form-control mi-input">
									<option value="0" selected="selected">- Me fue de
										utilidad la base de datos de mecánicos -</option>
									<option value="1">SI</option>
									<option value="2">NO</option>
								</select>
							</div>
						</div>
						<div class="form-group col-md-4">
						<img class="img-responsive pull-left"
			style="height: 150px; padding-top: 10px; padding-right: 10px; display: inline;"
			src="${pageContext.request.contextPath}/img/Ficha.png"></img>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-8">
							<h2 style="font-weight: bold;">Evalúa del 0 al 10 el
								servicio que te ofrecieron</h2>
						</div>
						<div class="form-group col-md-4"></div>
					</div>
					<div class="row">
						<div class="form-group col-md-4">
							<div style="margin-top: 15px;">
								<!-- <label
								for="cmbListaAtencion" class="pull-left">Delegacion o
								Municipio</label> -->
								<select name="cmbListaAtencion" id="cmbListaAtencion"
									class="form-control mi-input">
									<option value="0" selected="selected">- Atención -</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="8">7</option>
									<option value="9">8</option>
									<option value="9">9</option>
									<option value="10">10</option>

								</select>
							</div>
							<div style="margin-top: 15px;">
								<!-- <label
								for="cmbListaAtencion" class="pull-left">Delegacion o
								Municipio</label> -->
								<select name="cmbListaCalidadTrabajo"
									id="cmbListaCalidadTrabajo" class="form-control mi-input">
									<option value="0" selected="selected">- Calidad del
										trabajo -</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="8">7</option>
									<option value="9">8</option>
									<option value="9">9</option>
									<option value="10">10</option>

								</select>
							</div>
							<div style="margin-top: 15px;">
								<!-- <label
								for="cmbListaAtencion" class="pull-left">Delegacion o
								Municipio</label> -->
								<select name="cmbListaTiempoEntrega" id="cmbListaTiempoEntrega"
									class="form-control mi-input">
									<option value="0" selected="selected">- Tiempo de
										entrega -</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="8">7</option>
									<option value="9">8</option>
									<option value="9">9</option>
									<option value="10">10</option>

								</select>
							</div>
						</div>

						<div class="form-group col-md-4">
							<div style="margin-top: 15px;">
								<!-- <label
								for="cmbListaAtencion" class="pull-left">Delegacion o
								Municipio</label> -->
								<select name="cmbListaSatisfechoTrabajo" id="cmbListaSatisfechoTrabajo"
									class="form-control mi-input">
									<option value="0" selected="selected">- Estoy satisfecho con el trabajo -</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="8">7</option>
									<option value="9">8</option>
									<option value="9">9</option>
									<option value="10">10</option>

								</select>
							</div>
							<div style="margin-top: 15px;">
								<!-- <label
								for="cmbListaAtencion" class="pull-left">Delegacion o
								Municipio</label> -->
								<select name="cmbListaRecomendarTaller"
									id="cmbListaRecomendarTaller" class="form-control mi-input">
									<option value="0" selected="selected">- Recomendaría al taller -</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="8">7</option>
									<option value="9">8</option>
									<option value="9">9</option>
									<option value="10">10</option>

								</select>
							</div>
							<div style="margin-top: 15px;">
								<!-- <label
								for="cmbListaAtencion" class="pull-left">Delegacion o
								Municipio</label> -->
								<select name="cmbListallevarAuto" id="cmbListallevarAuto"
									class="form-control mi-input">
									<option value="0" selected="selected">- Volvería a llevar mi auto -</option>
									<option value="1">SI</option>
									<option value="2">NO</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-8">
							<div class="btn-group btn-img2">
								<button type="button" class="btn btn-default" id="myBtn">Enviar</button>
								 <button type="button" id="btn_espera" class="btn" style="display: none"><span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span>Enviando, Espere...</button>
							</div>
							 <br/><br/><br/><br/><br/>
						</div>
						<div class="form-group col-md-4"></div>
					</div>
				</form>
			</div>
		    <br> <br><br>
		    <!-- Modal -->
	<div id="ModalTerminado" class="modal" style="z-index: 9999;">
		<span class="close">&times;</span> <img class="modal-content"
			id="img01"
			src="${pageContext.request.contextPath}/img/Evaluacion.png"
			alt=""
			style="display: inline-block; background: rgba(0, 0, 0, 0.26);"></img>
		<div id="caption"></div>
	</div>
		</div>
	</div>
		 		  <br> <br> <br>
	 <%@include file="footerKwx.html"%>

	<br> <br>
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aajN9AQK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
</body>
</html>