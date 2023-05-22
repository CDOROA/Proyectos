<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,  minimum-scale=1.0">
		<!-- CODIGO PARA NO GUARDAR CACHE -->
		<meta http-equiv="Expires" content="-1">
    	<meta http-equiv="Cache-Control" content="no-cache">
    	<meta http-equiv="Pragma" content="no-cache">
<title>Corporación Química Automotriz, S.A. de C.V. (KWX)</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/css/bootstrap-3.3.5.min.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/starter-style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/css/starter-template-3.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-3.3.5.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery1.11.4.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	jQuery(document).ready(function($) {
		cargaCarrusel();
		var a = getParam('a');
		var b = getParam('b');
		if (a != false) {
			if (b != false) {
				cargarProductos("#" + a, "#" + b);
			}
		}
	});

	function cargarProductos(div, desde) {
		$(div).hide();
		$(div).html($(desde).html());
		$(div).show("fade", 800);
		$(div).focus();
		cargaCarrusel();
	}

	function cargaCarrusel() {
		$("#carousel-text").hide();

		$('#myCarousel').carousel({
			interval : false
		});

		$('[id^=carousel-selector-]').click(function() {
			var id = this.id.substr(this.id.lastIndexOf("-") + 1);
			var id = parseInt(id);
			$('#myCarousel').carousel(id);
			$('html, body').animate({
				scrollTop : $('#myCarousel').offset().top
			}, 'slow');
		});
		$("#carousel-text").show("fade", 400);
	}

	function getParam(param) {
		var url = window.location.href.slice(
				window.location.href.indexOf('?') + 1).split('&');
		for ( var i = 0; i < url.length; i++) {
			var params = url[i].split("=");
			if (params[0] == param)
				return params[1];
		}
		return false;
	}
	function openPDF() {
		window
				.open(
						"C:/Users/eliezer.moreno/Desktop/CATALOGOS/Catalogo_Filtros.pdf",
						"_blank");
		// file:///C:/Users/eliezer.moreno/Desktop/CATALOGOS/Catalogo_Filtros.pdf
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

<body class="bg-image-page" width="100%">

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

	<div class="container-fluid" width="100%"
		style="padding-left: 0px; padding-right: 0px;">

<!--  Header  -->
	         <%@include file="EncabezadoKwx.html"%>

		<div id="divContenido"></div>
		<br> <br> <br>
	</div>

	<!--  Filtros  -->
	<div id="Contenido-1" class="container"
		style="display: none; padding-left: 0px; padding-right: 0px;"
		width="100%">
		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/articulosKwx/Filtros/filtros-encabezado.png');padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12"
					style="padding-right: 0px;">
					<table width="98%">
						<tr>
							<td width="50%"></td>
							<td width="50%">
								<h1 style="color: white;">FILTROS</h1>
							</td>
						</tr>
						<tr>
							<td width="50%"></td>
							<td width="50%">
								<p class="lead text-justify hidden-ms hidden-xs">Los filtros
									automotrices de KWX están elaborados conforme a los más altos
									estándares de calidad y bajo las especificaciones del
									fabricante del vehículo, son además sometidos a rigurosas
									pruebas de laboratorio proporcionando de esta manera la máxima
									protección al motor y total garantía.</p>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class=" row hidden-xs" id="slider-thumbs"
			style="padding-right: 15px;">
			<ul class="hide-bullets list-inline style-2 bg-slider">
				<li><a class="thumbnail" id="carousel-selector-0">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Filtros/btn/btn_filtro001.png">
								</td>
								<td>
									<p class="sub-text">
										Filtro para <br> Aceite Lubricante
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-1">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Filtros/btn/btn_filtro002.png">
								</td>
								<td>
									<p class="sub-text">
										Filtro para <br> Aire
									</P>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail " id="carousel-selector-2">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Filtros/btn/btn_filtro003.png">
								</td>
								<td>
									<p class="sub-text">
										Filtro para <br> Gasolina
									</p>
								</td>
							</tr>
						</table>
				</a></li>
			</ul>
		</div>

		<div id="main_area">
			<div class="row">
				<div class="col-xs-12" id="slider"
					style="padding-left: 0px; padding-right: 0px;">
					<div class="row">
						<div class="col-sm-12" id="carousel-bounding-box"
							style="padding-left: 25px; padding-right: 25px;">
							<div class="carousel slide" id="myCarousel" style="width: 98%;">
								<div class="carousel-inner">

									<!--  Filtro 0  -->
									<div class="item" data-slide-number="0">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Filtros/img/img_filtro001.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">FILTRO
												PARA ACEITE LUBRICANTE</h1>
											<h4 class="lead text-justify" style="color: #4D4D4D;">KWX
												proporciona una amplia gama de aplicaciones en filtros para
												aceite, tanto para vehículos modernos como de años
												anteriores. Estos son ideales para lubricantes de alto
												rendimiento (sintéticos), y de base mineral. Cambie el
												filtro al menos cada 5000 kilómetros o cada 6 meses.</h4>
										</div>
										<div class="btn-group btn-img" role="group"
											style="align: center">
											<a
												href="${pageContext.request.contextPath}/doc/DocFiltros/catalogoFiltros001.pdf"
												target="_blank" class="btn btn-default btn-img-buttom"
												role="button" style="align: center"> <span
												class="glyphicon glyphicon-ok "></span> CATALOGO DE FILTROS
											</a>
											<a
												href="https://guiarapida.kwx.com.mx/view/210332622/"
												class="btn btn-default btn-img-buttom" role="button"
												style="align: center">
												<span class="glyphicon glyphicon-ok "></span> GUÍA DE
												FILTROS
											</a>
											
										</div>
									</div>

									<!--  Filtro 1  -->
									<div class="active item" data-slide-number="1" align="center">
										<div class="col-sm-6" align="center">
											<img id="img-muestra-1"
												src="${pageContext.request.contextPath}/image/articulosKwx/Filtros/img/img_filtro002.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">FILTRO
												PARA AIRE</h1>
											<h4 class="lead text-justify" style="color: #4D4D4D;">La
												retención de partículas contaminantes presentes en el aire
												es muy importante, ya que la admisión de una pequeña
												cantidad de suciedad en el motor es suficiente para causar
												daños enormes. KWX ofrece una amplia variedad de filtros
												para aire con múltiples aplicaciones. Los cuales suministran
												la protección necesaria al motor. Es necesario cambiar el
												filtro cada 6 meses o 10,000 kilómetros.</h4>

										</div>
										<div class="btn-group btn-img" role="group"
											style="align: center">
											<a
												href="${pageContext.request.contextPath}/doc/DocFiltros/catalogoFiltros001.pdf"
												target="_blank" class="btn btn-default btn-img-buttom"
												role="button" style="align: center"> <span
												class="glyphicon glyphicon-ok "></span> CATALOGO DE FILTROS
											</a> <a
												href="https://guiarapida.kwx.com.mx/view/210332622/"
												target="_blank" class="btn btn-default btn-img-buttom"
												role="button" style="align: center"> <span
												class="glyphicon glyphicon-ok "></span> GUÍA DE FILTROS
											</a>
										</div>
									</div>

									<!--  Filtro 3  -->
									<div class="item" data-slide-number="2">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Filtros/img/img_filtro003.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">FILTRO
												PARA GASOLINA</h1>
											<h4 class="lead text-justify" style="color: #4D4D4D;">KWX
												cuenta con filtros para combustible con una vida promedio de
												10,000 a 15,000 km. La calidad de su fabricación reúne los
												requisitos y especificaciones de los fabricantes de autos
												americanos, europeos y asiáticos cubriendo el 95% de las
												aplicaciones a nivel nacional.</h4>

										</div>
										<div class="btn-group btn-img" role="group"
											style="align: center">
											<a
												href="${pageContext.request.contextPath}/doc/DocFiltros/catalogoFiltros001.pdf"
												target="_blank" class="btn btn-default btn-img-buttom"
												role="button" style="align: center"> <span
												class="glyphicon glyphicon-ok "></span> CATALOGO DE FILTROS
											</a> <a
												href="https://guiarapida.kwx.com.mx/view/210332622/"
												target="_blank" class="btn btn-default btn-img-buttom"
												role="button" style="align: center"> <span
												class="glyphicon glyphicon-ok "></span> GUÍA DE FILTROS
											</a>
										</div>
									</div>

								</div>
								<a class="left carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left"></span>
								</a> <a class="right carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--  Aceites Lubricantes  -->
	<div id="Contenido-2" class="container"
		style="display: none; padding-left: 0px; padding-right: 35px;"
		width="100%">
		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/lubricantes-encabezado.png'); padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12"
					style="padding-right: 0px;">
					<table width="98%">
						<tr>
							<td width="50%" style="vertical-align: top;"></td>
							<td width="50%" style="vertical-align: top;" align="right">
								<table>
									<tr>
										<td>
											<h1 style="color: white;">ACEITES LUBRICANTES</h1>
										</td>
									</tr>
									<tr>
										<td>
											<p class="lead text-justify  hidden-ms hidden-xs">Los
												lubricantes de KWX están formulados con aceites básicos
												altamente refinados y aditivos especialmente seleccionados
												para cada aplicación, los cuales proveen máxima protección
												en motores de vehículos modernos y modelos de años
												anteriores.</p>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class=" row hidden-xs" id="slider-thumbs"
			style="padding-right: 35px;">
			<ul class="hide-bullets list-inline style-lubricntes bg-slider">
				<li><a class="thumbnail" id="carousel-selector-0">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/btn/btn_aceite001.png">
								</td>
								<td>
									<p class="sub-text">
										Motor Racing <br> Multigrado
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-1">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/btn/btn_aceite002.png">
								</td>
								<td>
									<p class="sub-text">
										Motor Oil <br> Monogrado
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-2">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/btn/btn_aceite003.png">
								</td>
								<td>
									<p class="sub-text">
										Motor Alto <br> Kilometraje
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-3">
						<table>
							<tr>
								<td>
							<%-- 	 <img
									src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/btn/btn_aceite004.png"> 
									 --%>
									<img
									src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/btn/Synthec_Chica.png">
									
								</td>
								<td>
									<p class="sub-text">
										Motor Synthec Oil <br> Multigrado 100% Sintético
									</P>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-4">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/btn/btn_aceite005.png">
								</td>
								<td>
									<p class="sub-text ">
										Transmisión Automática <br> ATF Dexron III Mercon
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail " id="carousel-selector-5">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/btn/btn_aceite006.png">
								</td>
								<td>
									<p class="sub-text">
										Transmisión STD <br> Monogrado
									</p>
								</td>
							</tr>
						</table>
				</a></li>

				<li><a class="thumbnail " id="carousel-selector-6">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/btn/btn_aceite007.png">
								</td>
								<td>
									<p class="sub-text">
										Transmisión STD <br> Multigrado
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-7">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/btn/Synthec_ATF_chica.png">
								</td>
								<td>
									<p class="sub-text ">
										Transmisi&oacute;n Autom&aacute;tica <br> Synthec ATF <br> Dexron VI Mercon LV
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-8">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/btn/btn_aceite008.png">
								</td>
								<td>
									<p class="sub-text">
										4T <br> para Motos
									</p>
								</td>
							</tr>
						</table>
				</a></li>
			</ul>
		</div>

		<div id="main_area">
			<div class="row">
				<div class="col-xs-12" id="slider"
					style="padding-left: 25px; padding-right: 25px;">
					<div class="row">
						<div class="col-sm-12" id="carousel-bounding-box"
							style="padding-left: 0px; padding-right: 0px;">
							<div class="carousel slide" id="myCarousel" style="width: 98%;">
								<div class="carousel-inner">

									<!-- DESC-ACEITE 0 -->
									<div class="active item" data-slide-number="0">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/img/img_aceite001.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ACEITE
												LUBRICANTE MOTOR RACING</h1>
											<h2 style="color: #647F90; font-weight: bold;">MULTIGRADO</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Lubricante
												mineral que inhibe la formación de depósitos a altas
												temperaturas y mantiene excelente fluidez a bajas
												temperaturas. Recomendado para la lubricación de motores a
												gasolina donde el fabricante especifica un lubricante
												categoría API SL. El lubricante multigrado de KWX cumple con
												las especificaciones establecidas por la clasificación SAE.
											</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">K-1-10W30</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-envase-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">K-1-15W40</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-envase-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">K-1-20W50</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-envase-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">K-5-15W40</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-garrafa-azul.png"
																style="width: 24px; height: 24px;">
														</span> 5 L</td>
													</tr>
													<tr>
														<td style="text-align: left">K-5-20W50</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-garrafa-azul.png"
																style="width: 24px; height: 24px;">
														</span> 5 L</td>
													</tr>
													<tr>
														<td style="text-align: left">K-200-20W50</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/barril-azul.png"
																style="width: 24px; height: 24px;">
														</span> 200 L</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite001-1.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD 10W30
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/ft_aceites001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <%-- <br> <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite001-2.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD 15W40
												</a>  <br>  <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite001-3.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD 20W50
												</a> --%> <a
													href="https://guiarapida.kwx.com.mx/view/210519685/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA ACEITES LUBRICANTES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-ACEITE 1 -->
									<div class="item" data-slide-number="1">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/img/img_aceite002.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ACEITE
												LUBRICANTE MOTOR</h1>
											<h2 style="color: #647F90; font-weight: bold;">OIL
												MONOGRADO</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Lubricante
												base mineral de tipo Monogrado con alto grado de desempeño
												en condiciones de operación cálidas y constantes.
												Recomendado para la lubricación de motores a gasolina que
												especifiquen un aceite monogrado con clasificación API SL.
												Cumple con las especificaciones de alta temperatura
												establecidas por la clasificación SAE.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">K-1-040</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-envase-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">K-1-050</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-envase-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">K-5-040</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-garrafa-azul.png"
																style="width: 24px; height: 24px;">
														</span> 5 L</td>
													</tr>
													<tr>
														<td style="text-align: left">K-5-050</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-garrafa-azul.png"
																style="width: 24px; height: 24px;">
														</span> 5 L</td>
													</tr>
													<tr>
														<td style="text-align: left">K-200-040</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/barril-azul.png"
																style="width: 24px; height: 24px;">
														</span> 200 L</td>
													</tr>
													<tr>
														<td style="text-align: left">K-200-050</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/barril-azul.png"
																style="width: 24px; height: 24px;">
														</span> 200 L</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite002-1.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD sae40
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/ft_aceites002.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <%--<br>  <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite002-2.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD sae50
												</a>  --%><a
													href="https://guiarapida.kwx.com.mx/view/210519685/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA ACEITES LUBRICANTES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-ACEITE 2 -->
									<div class="item" data-slide-number="2">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/img/img_aceite003.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ACEITE
												LUBRICANTE MOTOR</h1>
											<h2 style="color: #647F90; font-weight: bold;">ALTO
												KILOMETRAJE</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Lubricante
												multigrado con la viscosidad ideal para proporcionar una
												excelente protección en altas y bajas temperaturas con alto
												grado de rendimiento, proporciona un excelente sello entre
												anillos y camisas aumentando el desempeño del motor.
												Recomendado para motores a gasolina con altos kilometrajes y
												para condiciones extremas de temperatura.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">K-AK-1-25W50</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-envase-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>

													</tr>
													<tr>
														<td style="text-align: left">K-AK-5-25W50</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-garrafa-azul.png"
																style="width: 24px; height: 24px;">
														</span> 5 L</td>

													</tr>
													<tr>
														<td style="text-align: left">K-AK-200-25W50</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/barril-azul.png"
																style="width: 24px; height: 24px;">
														</span> 200 L</td>

													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">

											<%-- 	<a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite003.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/ft_aceites003.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <a
													href="https://guiarapida.kwx.com.mx/view/210519685/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA ACEITES LUBRICANTES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-ACEITE 3 -->
									<div class="item" data-slide-number="3">
										<div class="col-sm-6" align="center">
											<%-- <img id="img-muestra-3"
												src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/img/img_aceite004.png"
												class="img-responsive"> --%>
												
												<img id="img-muestra-3"
												src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/img/Synthec_Grande.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ACEITE
												LUBRICANTE MOTOR SYNTHEC</h1>
											<h2 style="color: #647F90; font-weight: bold;">OIL
												MULTIGRADO 100% SINTÉTICO</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Elaborado
												con aceites básicos sintéticos y aditivos de avanzada
												tecnología. Diseñado para proporcionar altos niveles de
												rendimiento, Por su baja viscosidad facilita el encendido,
												considerado como un lubricante conservador de energía ya que
												economiza combustible. Cumple con las especificaciones de
												servicio API SN e ILSAC GF-5.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center" colspan="3">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>	
														<td style="text-align: left">K-SIN-1-10W30</td>
														<td colspan="3"><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-envase-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">K-SIN-1-5W30</td>
														<td colspan="3"><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-envase-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">K-SIN-1-5W40</td>
														<td colspan="3"><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-envase-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">K-SIN-5-10W30</td>
														<td colspan="3"><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-garrafa-azul.png"
																style="width: 24px; height: 24px;">
														</span> 5 L</td>
													</tr>
													<tr>
														<td style="text-align: left">K-SIN-1-0W20</td>
														<td colspan="3"><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-envase-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">K-SIN-1-5W50</td>
														<td colspan="3"><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-envase-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group" align="left">
											<%-- 	<a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite004-1.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD 5W30
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/ft_aceites004-1.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <%-- <br> <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite004-2.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD 10W30
												</a>  <br>  <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite004-3.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD 5W40
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/ft_aceites004-2.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <br>
												<a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/ft_synthec0W20.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <br>
												<a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/ft_synthec5W50.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <br>
												 <a
													href="https://guiarapida.kwx.com.mx/view/210519685/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA ACEITES LUBRICANTES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-ACEITE 4 -->
									<div class="item" data-slide-number="4">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/img/img_aceite005.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ACEITE
												LUBRICANTE TRANSMISIÓN AUTOMÁTICA ATF</h1>
											<h2 style="color: #647F90; font-weight: bold;">DEXRON
												III MERCON</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Elaborado
												tecnológicamente para cajas de transmisión automática y de
												dirección hidráulica, donde por especificaciones del
												fabricante exige un lubricante del tipo ATF Dexron III,
												Mercon, desarrollado y elaborado para cubrir los requisitos
												más exigentes de GM DEXRON III, FORD MERCON y ALLISON C-4.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">K-1-ATF</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/envase-chupon-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/ft_aceites005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br>  --><a
													href="https://guiarapida.kwx.com.mx/view/210519685/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA ACEITES LUBRICANTES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-ACEITE 5 -->
									<div class="item" data-slide-number="5">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/img/img_aceite006.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ACEITE
												LUBRICANTE TRANSMISIÓN STD</h1>
											<h2 style="color: #647F90; font-weight: bold;">MONOGRADO</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Lubricante
												Monogrado de gran rendimiento para transmisiones de tipo
												estándar. Se recomienda para transmisiones de engranes
												rectos en automóviles y camiones, en cajas de transmisión y
												reductores industriales que trabajen con cargas ligeras a
												moderadas, destinado a equipos que requieran de un fluido
												con categoría API GL-1.</h4>
											<table style="width: 50%;" class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center" colspan="3">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">K-1-090</td>
														<td colspan="3"><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/envase-chupon-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">K-1-140</td>
														<td colspan="3"><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/envase-chupon-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite006-1.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD sae90
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/ft_aceites006.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a><%--  <br> <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite006-2.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD sae140
												</a> --%> <a
													href="https://guiarapida.kwx.com.mx/view/210519685/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA ACEITES LUBRICANTES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-ACEITE 6 -->
									<div class="item" data-slide-number="6">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/img/img_aceite007.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ACEITE
												LUBRICANTE TRANSMISIÓN STD</h1>
											<h2 style="color: #647F90; font-weight: bold;">MULTIGRADO</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Aceite
												Lubricante Multigrado de Extrema Presión ideal para cargas
												moderadas a severas. Se recomienda para todo tipo de
												transmisiones manuales de automóviles, camiones, tractores,
												equipo agrícola e industrial donde por recomendación del
												fabricante se requiera aditivos de Extrema Presión y
												especificaciones de servicio API GL-5.</h4>

											<table style="width: 50%;" class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center" colspan="3">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">K-1-80W90</td>
														<td colspan="3"><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/envase-chupon-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite007.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/ft_aceites007.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210519685/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA ACEITES LUBRICANTES
												</a>
											</div>

										</div>
									</div>

                                    <!-- DESC-ACEITE 7-->
									<div class="item" data-slide-number="7">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/img/Synthec_ATF_grande.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ACEITE LUBRICANTE SINTÉTICO TRANSMISIÓN AUTOMÁTICA ATF VI</h1>
											<h2 style="color: #647F90; font-weight: bold;">DEXRON VI, MERCON LV</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">El Aceite lubricante Sintético ATF VI Dexron VI, Mercon LV está formulado con aceites base sintéticos de alto desempeño y una tecnología avanzada de aditivos que cumplen y exceden los rigurosos requisitos de la especificación Dexron-VI/Mercon-LV para transmisiones automáticas.</h4>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Recomendado para ser usado en todas las cajas de transmisión automática o dirección asistida de automóviles y camiones ligeros. Proporciona una excelente protección a vehículos modelos 2006 en adelante de GM donde la especificación Dexron-VI es requerida.</h4>
                                            <h4 class="lead text-justify" style="color: #4D4D4D;">También es adecuado donde Dexron-IIIG, IIIH; Dexron-II, IID, IIE; y JASO-1A es especificado por el fabricante. </h4>
											
											<table style="width: 50%;" class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center" colspan="3">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">K-1-DEX-VI</td>
														<td colspan="3"><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/envase-chupon-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
												</tbody>
											</table>
											
											<div class="btn-group btn-img" role="group">
												 <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/ft_DexronATFVI.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a>
												<a
													href="https://guiarapida.kwx.com.mx/view/210519685/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA ACEITES LUBRICANTES
												</a>
											</div>
										</div>
									</div>


									<!-- DESC-ACEITE 8 -->
									<div class="item" data-slide-number="8">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/img/img_aceite008.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ACEITE
												LUBRICANTE PARA MOTOS</h1>
											<h2 style="color: #647F90; font-weight: bold;">A 4
												TIEMPOS</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Elaborado
												con básicos de la más alta calidad con un innovador y
												balanceado paquete de aditivos que le confieren cubrir con
												los requisitos más exigentes de motocicletas modernas,
												diseñado especialmente donde la lubricación es simultanea
												entre el motor, el embrague húmedo y la transmisión.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: center">K-4T-1-10W40</td>
														<td colspan="3"><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/presentacion/aceite-envase-azul.png"
																style="width: 24px; height: 24px;">
														</span> 946 mL</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/hs_aceite008.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocAceitesLubricantes/ft_aceites008.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210519685/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA ACEITES LUBRICANTES
												</a>
											</div>
										</div>
									</div>

								</div>
								<a class="left carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left"></span>
								</a> <a class="right carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!--  Radiadores  -->
	<div id="Contenido-3" class="container"
		style="display: none; padding-left: 0px; padding-right: 0px;">

		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/radiador-encabezado.png'); padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<table width="98%">
						<tr>
							<td width="50%" style="vertical-align: top;"></td>
							<td width="50%" style="vertical-align: top;" align="right">
								<table>
									<tr>
										<td>
											<h1 style="color: white;">PRODUCTOS PARA RADIADOR</h1>
										</td>
									</tr>
									<tr>
										<td>
											<p class="lead text-justify hidden-ms hidden-xs">Mantienen
												el sistema de enfriamiento en óptimas condiciones de
												operación, previenen el sobrecalentamiento y son excelentes
												con los sistemas que cuentan con aleaciones especiales de
												aluminio y otros metales.</p>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class=" row hidden-xs" id="slider-thumbs"
			style="padding-right: 15px;">
			<ul class="hide-bullets list-inline style-Radiador bg-slider">
				<li><a class="thumbnail" id="carousel-selector-0">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/btn/btn_radiador001.png">
								</td>
								<td>
									<p class="sub-text">
										Anticongelante <br> Refrigerante <br> Uso Directo <br>
										al 33%
									</P>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail " id="carousel-selector-1">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/btn/btn_radiador002.png">
								</td>
								<td>
									<p class="sub-text">
										Anticongelante <br> Refrigerante <br> Uso Directo <br>
										al 20%
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail " id="carousel-selector-2">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/btn/btn_radiador003.png">
								</td>
								<td>
									<p class="sub-text">
										Anticongelante <br> Refrigerante <br> Larga Vida
										(Orgánico) <br> al 33%
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-3">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/btn/btn_radiador004.png">
								</td>
								<td>
									<p class="sub-text">
										Anticongelante <br> Refrigerante <br> Concentrado <br>
										al 66%
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-4">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/btn/btn_radiador008.png">
								</td>
								<td>
									<p class="sub-text">
										Refrigerante <br> Anticorrosivo y<br> Antioxidante
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-5">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/btn/btn_radiador005.png">
								</td>
								<td>
									<p class="sub-text ">
										Limpiador para Radiador <br> y Sistema de <br>
										Enfriamiento
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-6">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/btn/btn_radiador006.png">
								</td>
								<td>
									<p class="sub-text">
										Tapafugas para <br> Radiador de Metal
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-7">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/btn/btn_radiador007.png">
								</td>
								<td>
									<p class="sub-text">
										Pastillas Inhibidoras <br> de Corrosión
									</p>
								</td>
							</tr>
						</table>
				</a></li>
			</ul>
		</div>

		<div id="main_area">
			<div class="row">
				<div class="col-xs-12" id="slider"
					style="padding-left: 25px; padding-right: 25px;">
					<div class="row">
						<div class="col-sm-12" id="carousel-bounding-box"
							style="padding-left: 0px; padding-right: 0px;">
							<div class="carousel slide" id="myCarousel" style="width: 98%;">
								<div class="carousel-inner">

									<!-- DESC-ACEITE 0 -->
									<div class="active item" data-slide-number="0" align="center">
										<div class="col-sm-6" align="center">
											<img id="img-muestra-0"
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/img/img_radiador001.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ANTICONGELANTE
												REFRIGERANTE</h1>
											<h2 style="color: #647F90; font-weight: bold;">USO
												DIRECTO AL 33%</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Fórmula
												desarrollada lista para usar no requiere diluir, conveniente
												para motores de automóviles, camiones, tractores y en
												instalaciones estacionarias. Mantiene el sistema de
												enfriamiento en óptimas condiciones de operación, protege
												temperaturas de -19°C a +125°C.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">1-3</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa1lt.png"
																style="width: 24px; height: 24px;">
														</span> 1 L</td>
													</tr>
													<tr>
														<td style="text-align: left">1-6</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa2lt.png"
																style="width: 24px; height: 24px;">
														</span> 2L</td>
													</tr>
													<tr>
														<td style="text-align: left">1-7</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa3lt.png"
																style="width: 24px; height: 24px;">
														</span> 3.785 L</td>
													</tr>
													<tr>
														<td style="text-align: left">1-8</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/cubeta.png"
																style="width: 24px; height: 24px;">
														</span> 18 L</td>
													</tr>
													<tr>
														<td style="text-align: left">1-16</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafon.png"
																style="width: 24px; height: 24px;">
														</span> 18 L</td>
													</tr>
													<tr>
														<td style="text-align: left">T-A</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/tambor.png"
																style="width: 24px; height: 24px;">
														</span> 200 L</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/hs_radiador001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/ft_radiador001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/1052710258/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA PRODUCTOS
													PARA RADIADOR
												</a>

											</div>
										</div>
									</div>

									<!-- DESC-ACEITE 1 -->
									<div class="item" data-slide-number="1">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/img/img_radiador002.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ANTICONGELANTE
												REFRIGERANTE</h1>
											<h2 style="color: #647F90; font-weight: bold;">USO
												DIRECTO AL 20%</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Fórmula
												especial para climas templados a cálidos, conveniente para
												uso en motores de automóviles. Mantiene el sistema de
												enfriamiento en óptimas condiciones de operación, protege
												temperaturas de -8°C a 122°C. No requiere mezclarse con
												agua. Protege contra la corrosión, la cavitación y la
												oxidación las partes metálicas incluyendo el aluminio.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">1-19</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa1lt.png"
																style="width: 24px; height: 24px;">
														</span> 1 L</td>
													</tr>
													<tr>
														<td style="text-align: left">1-20</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa3lt.png"
																style="width: 24px; height: 24px;">
														</span> 3.785 L</td>
													</tr>
													<tr>
														<td style="text-align: left">1-18</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/cubeta.png"
																style="width: 24px; height: 24px;">
														</span> 18 L</td>
													</tr>
													<tr>
														<td style="text-align: left">T-A3</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/tambor.png"
																style="width: 24px; height: 24px;">
														</span> 200 L</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
											<%-- 	<a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/hs_radiador001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/ft_radiador002.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/1052710258/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA PRODUCTOS
													PARA RADIADOR
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-ACEITE 2 -->
									<div class="item" data-slide-number="2">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/img/img_radiador003.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ANTICONGELANTE
												REFRIGERANTE</h1>
											<h2 style="color: #647F90; font-weight: bold;">LARGA
												VIDA (ORGÁNICO) AL 33%</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Fórmula
												especialmente desarrollada para una larga duración lista
												para usar sin diluir, conveniente para todo tipo de motores.
												Protege rangos de temperaturas de -20°C a 124°C. Contiene
												aditivos orgánicos que protegen contra la corrosión,
												cavitación y la oxidación las partes metálicas incluyendo el
												aluminio. Su color ayuda a detectar cualquier fuga en el
												sistema.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">1-14</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa1lt.png"
																style="width: 24px; height: 24px;">
														</span> 1 L</td>
													</tr>
													<tr>
														<td style="text-align: left">1-15</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa3lt.png"
																style="width: 24px; height: 24px;">
														</span> 3.785 L</td>
													</tr>
													<tr>
														<td style="text-align: left">1-A2</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/tambor.png"
																style="width: 24px; height: 24px;">
														</span> 200 L</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/hs_radiador003.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/ft_radiador003.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/1052710258/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA PRODUCTOS
													PARA RADIADOR
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-ACEITE 3 -->
									<div class="item" data-slide-number="3">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/img/img_radiador004.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ANTICONGELANTE
												REFRIGERANTE</h1>
											<h2 style="color: #647F90; font-weight: bold;">CONCENTRADO
												AL 66%</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Fórmula
												concentrada, conveniente para ser diluido hasta en un 50%
												con agua. Protege temperaturas de -56°C a +134°C sin diluir
												y -19°C a +124°C diluido al 50%. Protege contra la
												corrosión, cavitación y la oxidación las partes metálicas
												incluyendo el aluminio, además de aleaciones metálicas
												especiales. Su color ayuda a detectar cualquier fuga en el
												sistema.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">1-5</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa1lt.png"
																style="width: 24px; height: 24px;">
														</span> 1 L</td>
													</tr>
													<tr>
														<td style="text-align: left">1-4</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa3lt.png"
																style="width: 24px; height: 24px;">
														</span> 3.785 L</td>
													</tr>
													<tr>
														<td style="text-align: left">1-9</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/cubeta.png"
																style="width: 24px; height: 24px;">
														</span> 18 L</td>
													</tr>
													<tr>
														<td style="text-align: left">1-17</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafon.png"
																style="width: 24px; height: 24px;">
														</span> 18 L</td>
													</tr>
													<tr>
														<td style="text-align: left">T-A1</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/tambor.png"
																style="width: 24px; height: 24px;">
														</span> 200 L</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/hs_radiador004.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/ft_radiador004.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a><!--  <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/1052710258/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA PRODUCTOS
													PARA RADIADOR
												</a>
											</div>
										</div>
									</div>
									<!-- DESC-ACEITE 4 -->
									<div class="item" data-slide-number="4">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/img/img_radiador008.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">REFRIGERANTE
												ANTICORROSIVO</h1>
											<h2 style="color: #647F90; font-weight: bold;">Y
												ANTIOXIDANTE</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Listo
												para usar, no requiere hacer mezclas o adicionar agua,
												idóneo para rellenar niveles, contiene inhibidores de
												corrosión bajo la norma ASTM-6210 para servicio pesado.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">1-25</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa1lt.png"
																style="width: 24px; height: 24px;">
														</span> 1 L</td>
													</tr>
													<tr>
														<td style="text-align: left">1-24</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa3lt.png"
																style="width: 24px; height: 24px;">
														</span> 3.785 L</td>
													</tr>

													<tr>
														<td style="text-align: left">T-A4</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/tambor.png"
																style="width: 24px; height: 24px;">
														</span> 200 L</td>
													</tr>
												</tbody>
											</table>

											<div class="btn-group btn-img" role="group">
												<a
													href="https://guiarapida.kwx.com.mx/view/1052710258/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA PRODUCTOS
													PARA RADIADOR
												</a>
											</div>
										</div>
									</div>

									<!--    DESC-ACEITE 3-1    
                                		<div class="item" data-slide-number="4">
                                			<div class="col-sm-6" align="center" >
												<img src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/img/img_radiador004.png" class="img-responsive">
											</div>
											<div class="col-sm-6" align="center" >
												<h1 style="color:#21669F; font-weight: bold;">REFRIGERANTE ANTICORROSIVO</h1>
												<h2 style="color:#647F90; font-weight: bold;">Y ANTIOXIDANTE</h2>
												<h4 class="lead text-justify" style="color:#4D4D4D;">Fluido refrigerante especialmente diseñado para climas calurosos, permite controlar la temperatura alta en motores de combustión interna protegiendo todos los metales del sistema, ideal para rellenar el sistema, es de uso directo, no requiere diluciones y es compatible con juntas, empaques y diversos hules que acompañan los sistemas de enfriamiento.</h4>
												<table class="table">
													<thead class="tabla-enc">
														<tr>
															<th style="text-align:center" >CLAVE</th>
															<th style="text-align:center" >PRESENTACIÓN</th>
														</tr>
													</thead>
													<tbody class="tabla-cont">
														<tr>
															<td style="text-align:left">1-5</td>
															<td>
																<span> <img src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa1lt.png" style="width: 24px; height: 24px;" > </span>
																1 L
															</td>
														</tr>
														<tr>
															<td style="text-align:left">1-4</td>
															<td>
																<span> <img src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafa3lt.png" style="width: 24px; height: 24px;" > </span>
																3.785 L
															</td>
														</tr>
														<tr>
															<td style="text-align:left">1-9</td>
															<td>
																<span> <img src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/cubeta.png" style="width: 24px; height: 24px;" > </span>
																18 L
															</td>
														</tr>
														<tr>
															<td style="text-align:left">1-17</td>
															<td>
																<span> <img src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/garrafon.png" style="width: 24px; height: 24px;" > </span>
																18 L
															</td>
														</tr>
														<tr>
															<td style="text-align:left">T-A1</td>
															<td>
																<span> <img src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/tambor.png" style="width: 24px; height: 24px;" > </span>
																200 L
															</td>
														</tr>
													</tbody>
												</table>
												<div class="btn-group btn-img" role="group" >
													<a href="${pageContext.request.contextPath}/doc/DocRadiadores/hs_radiador004.pdf" target="_blank" class="btn btn-default btn-img-buttom" role="button">
															<span class="glyphicon glyphicon-ok "></span>  HOJA DE SEGURIDAD
													</a>
													<a href="${pageContext.request.contextPath}/doc/DocRadiadores/ft_radiador004.pdf" target="_blank" class="btn btn-default btn-img-buttom" role="button">
														<span class="glyphicon glyphicon-ok "></span>  FICHA TÉCNICA
													</a>
												</div>
											</div>
                                		</div> -->


									<!-- DESC-ACEITE 5-->
									<div class="item" data-slide-number="5">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/img/img_radiador005.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">LIMPIADOR
												PARA RADIADOR</h1>
											<h2 style="color: #647F90; font-weight: bold;">Y SISTEMA
												DE ENFRIAMIENTO</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Aplicación
												directa en la toma del radiador fórmula especial de rápida
												acción para sistemas de enfriamiento en motores diésel y
												gasolina, quita oxido, sarro y lodos que tapan el radiador.
												Limpia y protege aluminio, bronce, estaño, plomo y
												aleaciones especiales. Compatible con todo tipo de
												anticongelantes y refrigerantes.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">1-1</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/gramos.png"
																style="width: 24px; height: 24px;">
														</span> 50 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/hs_radiador005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/ft_radiador005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a><!--  <br>  --><a
													href="https://guiarapida.kwx.com.mx/view/1052710258/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA PRODUCTOS
													PARA RADIADOR
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-ACEITE 6-->
									<div class="item" data-slide-number="6">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/img/img_radiador006.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">TAPAFUGAS
												PARA RADIADOR</h1>
											<h2 style="color: #647F90; font-weight: bold;">DE METAL</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Aplicación
												directa a la toma del radiador, formula de rápida acción
												tapa fugas en el radiador de manera permanente sin
												intervención mecánica. Su fórmula especial no obstruye los
												conductos del radiador o monoblock. Compatible con todo tipo
												de anticongelantes y refrigerantes.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">1-2</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/gramos.png"
																style="width: 24px; height: 24px;">
														</span> 50 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/hs_radiador006.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/ft_radiador006.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/1052710258/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA PRODUCTOS
													PARA RADIADOR
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-ACEITE 7 -->
									<div class="item" data-slide-number="7">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/img/img_radiador007.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">PASTILLAS
												INHIBIDORAS</h1>
											<h2 style="color: #647F90; font-weight: bold;">DE
												CORROSIÓN</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">De
												acción rápida y prolongada, inhibe la oxidación y corrosión
												en radiador y camisas del motor. Protege bomba de agua y
												partes sensible como el termostato, sensores y bulbos de
												temperatura. No ataca metales blandos ni aleaciones
												especiales. Es compatible con todo tipo de anticongelantes y
												refrigerantes, sirve para motores Diésel y Gasolina.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">6-3</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosRadiador/presentacion/gramos.png"
																style="width: 24px; height: 24px;">
														</span> 50 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/hs_radiador007.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocRadiadores/ft_radiador007.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a><!--  <br>  --><a
													href="https://guiarapida.kwx.com.mx/view/1052710258/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA PRODUCTOS
													PARA RADIADOR
												</a>
											</div>
										</div>
									</div>


								</div>
								<a class="left carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left"></span>
								</a> <a class="right carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>

	<!--  Limpiadores  -->
	<div id="Contenido-4" class="container"
		style="display: none; padding-left: 0px; padding-right: 0px;">
		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/limpiadores-encabezado.png'); padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<table width="98%">
						<tr>
							<td width="50%" style="vertical-align: top;"></td>
							<td width="50%" style="vertical-align: top;" align="right">
								<table>
									<tr>
										<td>
											<h1 style="color: white;">LIMPIADORES</h1>
										</td>
									</tr>
									<tr>
										<td>
											<p class="lead text-justify hidden-ms hidden-xs">Formulaciones
												desarrolladas para el servicio a motores de autos modernos y
												modelos anteriores de manera rápida segura y eficaz.</p>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class=" row hidden-xs" id="slider-thumbs"
			style="padding-right: 15px;">
			<ul class="hide-bullets list-inline style-Radiador bg-slider">
				<li><a class="thumbnail" id="carousel-selector-0">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/btn/btn_limpiador001.png">
								</td>
								<td>
									<p class="sub-text">
										Limpiador para Carburador <br> sin Desarmar
									</P>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail " id="carousel-selector-1">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/btn/btn_limpiador002.png">
								</td>
								<td>
									<p class="sub-text">
										Limpiador <br> de Inyectores <br> para Boya
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail " id="carousel-selector-2">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/btn/btn_limpiador003.png">
								</td>
								<td>
									<p class="sub-text">
										Limpiador de Inyectores <br> Profesional
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-3">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/btn/btn_limpiador004.png">
								</td>
								<td>
									<p class="sub-text">
										Desengrasante <br> para Motor
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-4">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/btn/btn_limpiador005.png">
								</td>
								<td>
									<p class="sub-text ">
										Crema Limpiadora <br> para Manos
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-5">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/btn/btn_limpiador006.png">
								</td>
								<td>
									<p class="sub-text">
										Limpiador para Cuerpo <br> de Aceleración
									</p>
								</td>
							</tr>
						</table>
				</a></li>
			</ul>
		</div>

		<div id="main_area">
			<div class="row">
				<div class="col-xs-12" id="slider"
					style="padding-left: 0px; padding-right: 0px;">
					<div class="row">
						<div class="col-sm-12" id="carousel-bounding-box"
							style="padding-left: 25px; padding-right: 25px;">
							<div class="carousel slide" id="myCarousel" style="width: 98%;">
								<div class="carousel-inner">

									<!-- DESC-LIMPIADOR 0 -->
									<div class="active item" data-slide-number="0">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/img/img_limpiador001.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">LIMPIADOR
												PARA CARBURADOR</h1>
											<h2 style="color: #647F90; font-weight: bold;">SIN
												DESARMAR</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Especialmente
												formulado para la fácil y rápida limpieza de carburadores y
												partes metálicas, limpia el interior y exterior del
												Carburador sin desarmarlo, su exclusiva formula remueve
												carbón, gomosidad, laca, aceite pegado y grasa, mejora el
												rendimiento del motor. No daña la capa superior de ozono.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">4-13</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/presentacion/latalisa.png"
																style="width: 24px; height: 24px;">
														</span> 320 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocLimpiadores/hs_limpiadores001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocLimpiadores/ft_limpiadores001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210219128/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA LIMPIADORES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-LIMPIADOR 1 -->
									<div class="item" data-slide-number="1">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/img/img_limpiador002.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">LIMPIADOR
												DE INYECTORES</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA BOYA</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Especialmente
												formulado para la limpieza directa y eficaz de los
												inyectores de gasolina, disuelve residuos de carbón en las
												válvulas de admisión, logra una atomización perfecta de
												gasolina, aumenta la potencia del motor, reduce el excesivo
												consumo de combustible, elimina el cascabeleo.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">4-21</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/presentacion/latalisa.png"
																style="width: 24px; height: 24px;">
														</span> 500 mL</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
											<%-- 	<a
													href="${pageContext.request.contextPath}/doc/DocLimpiadores/hs_limpiadores002.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocLimpiadores/ft_limpiadores002.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a><!--  <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210219128/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA LIMPIADORES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-LIMPIADOR 2 -->
									<div class="item" data-slide-number="2">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/img/img_limpiador003.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">LIMPIADOR
												DE INYECTORES</h1>
											<h2 style="color: #647F90; font-weight: bold;">PROFESIONAL</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Fórmula
												especial para la limpieza directa y eficaz de los inyectores
												de gasolina, disuelve residuos de barniz, laca, goma y
												carbón en las válvulas de admisión, restaura la eficiencia
												de los inyectores logrando una atomización perfecta de
												gasolina, reduce la emisión de gases contaminantes. No daña
												la capa superior de ozono.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">4-18</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/presentacion/latalisa.png"
																style="width: 24px; height: 24px;">
														</span> 340 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
											<%-- 	<a
													href="${pageContext.request.contextPath}/doc/DocLimpiadores/hs_limpiadores003.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocLimpiadores/ft_limpiadores003.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br>  --><a
													href="https://guiarapida.kwx.com.mx/view/210219128/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA LIMPIADORES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-LIMPIADOR 3 -->
									<div class="item" data-slide-number="3">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/img/img_limpiador004.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">DESENGRASANTE</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA
												MOTOR</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Facilita
												la limpieza de motores de automóviles, camiones, tractores,
												etcétera. Mezcla de removedores de grasas y detergentes,
												limpia metales de residuos de grasas, barro, entre otros.
												Diseñado para una limpieza de motores profesional. No daña
												la capa superior de ozono.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">4-22</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/presentacion/lata.png"
																style="width: 24px; height: 24px;">
														</span> 410 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
											<%-- 	<a
													href="${pageContext.request.contextPath}/doc/DocLimpiadores/hs_limpiadores004.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocLimpiadores/ft_limpiadores004.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a><!--  <br>  --><a
													href="https://guiarapida.kwx.com.mx/view/210219128/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA LIMPIADORES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-LIMPIADOR 4 -->
									<div class="item" data-slide-number="4">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/Crema-limpiadora_Grande.jpg"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">CREMA
												LIMPIADORA</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA
												MANOS</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Ideal
												para la limpieza y cuidado de las manos. Fórmula base acuosa
												con emolientes, detergentes y emulsificantes. Especial para
												remover grasas, aceites, tizne, asfalto y suciedad generada
												por el trabajo con maquinaria, en talleres mecánicos,
												fábricas, herrerías, gasolineras, talleres en el hogar,
												etcétera.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">4-14</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/presentacion/bote800.png"
																style="width: 24px; height: 24px;">
														</span> 800 g</td>
													</tr>
													<tr>
														<td style="text-align: left">4-15</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/presentacion/cubeta.png"
																style="width: 24px; height: 24px;">
														</span> 3.900 kg</td>
													</tr>
													<tr>
														<td style="text-align: left">4-17</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/presentacion/bote450.png"
																style="width: 24px; height: 24px;">
														</span> 450 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
											<%-- 	<a
													href="${pageContext.request.contextPath}/doc/DocLimpiadores/hs_limpiadores005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocLimpiadores/ft_limpiadores005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a><!--  <br>  --><a
													href="https://guiarapida.kwx.com.mx/view/210219128/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA LIMPIADORES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-LIMPIADOR 5 -->
									<div class="item" data-slide-number="5">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/img/img_limpiador006.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">LIMPIADOR
												PARA CUERPO</h1>
											<h2 style="color: #647F90; font-weight: bold;">DE
												ACELERACIÓN</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Fórmula
												especial que remueve carbón, aceite pegado, barnices y todo
												tipo de suciedad del cuerpo de aceleración en motores de
												inyección de combustible. Permite un mejor control del flujo
												de aire al motor, para una adecuada combustión. Producto
												libre de solventes clorados y propelentes CFCs.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">4-31</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Limpiadores/presentacion/lata.png"
																style="width: 24px; height: 24px;">
														</span> 500 mL</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
											<%-- 	<a
													href="${pageContext.request.contextPath}/doc/DocLimpiadores/hs_limpiadores006.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocLimpiadores/ft_limpiadores006.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210219128/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA LIMPIADORES
												</a>
											</div>
										</div>
									</div>
								</div>
								<a class="left carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left"></span>
								</a> <a class="right carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!--  Selladores  -->
	<div id="Contenido-5" class="container"
		style="display: none; padding-left: 0px; padding-right: 0px;">

		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/articulosKwx/Selladores/selladores-encabezado.png'); padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<table width="98%">
						<tr>
							<td width="50%" style="vertical-align: top;"></td>
							<td width="50%" style="vertical-align: top;" align="right">
								<table>
									<tr>
										<td>
											<h1 style="color: white;">SELLADORES</h1>
										</td>
									</tr>
									<tr>
										<td>
											<p class="lead text-justify hidden-ms hidden-xs">Formulados
												y desarrollados para soportar grandes presiones,
												temperaturas extremas y de gran resistencia a los agentes
												químicos que acompañan las zonas en su aplicación.</p>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class=" row hidden-xs" id="slider-thumbs"
			style="padding-right: 15px;">
			<ul class="hide-bullets list-inline style-Radiador bg-slider">
				<li><a class="thumbnail" id="carousel-selector-0">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/Silicones_Chica.png">
								</td>
								<td>
									<p class="sub-text">
										Forma Empaque <br> de Silicón
									</P>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail " id="carousel-selector-1">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/btn/btn_sellador002.png">
								</td>
								<td>
									<p class="sub-text">
										Sellador Shellac <br> Juntas
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail " id="carousel-selector-2">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/btn/btn_sellador003.png">
								</td>
								<td>
									<p class="sub-text">
										Sellador No. 3 Aviación <br> Ensamble y Juntas
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-3">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/btn/btn_sellador004.png">
								</td>
								<td>
									<p class="sub-text">
										Sellador <br> para Monoblocks
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-4">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/btn/btn_sellador005.png">
								</td>
								<td>
									<p class="sub-text ">
										Solda Fácil <br> en Frío
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-5">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/btn/btn_corcho005.png">
								</td>
								<td>
									<p class="sub-text ">
										Corcho Grano <br> Fino   
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-6">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/btn/btn_vellomoid005.png">
								</td>
								<td>
									<p class="sub-text ">
										Papel <br> Vellomoid   
									</p>
								</td>
							</tr>
						</table>
				</a></li>
			</ul>
		</div>

		<div id="main_area">
			<div class="row">
				<div class="col-xs-12" id="slider"
					style="padding-left: 0px; padding-right: 0px;">
					<div class="row">
						<div class="col-sm-12" id="carousel-bounding-box"
							style="padding-left: 25px; padding-right: 25px;">
							<div class="carousel slide" id="myCarousel" style="width: 98%;">
								<div class="carousel-inner">

									<!-- DESC-SELLADOR 0 -->
									<div class="active item" data-slide-number="0">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/Silicones_Grande.jpg"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">FORMA
												EMPAQUE DE SILICÓN</h1>
											<h2 style="color: #647F90; font-weight: bold;"></h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">El
												sellador de silicón KWX, está formulado para mecanismos de
												uso automotriz, industrial, marino y agrícola. Permite crear
												juntas con espesor y dimensiones requeridas, evita que se
												rompan o endurezcan, resistente al agua, aceite y
												temperaturas extremas, sella metal, madera, vidrio, corcho,
												etcétera.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">2-11N</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/presentacion/silicon.png"
																style="width: 24px; height: 24px;">
														</span> 70 g Negro</td>
													</tr>
													<tr>
														<td style="text-align: left">2-11G</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/presentacion/silicon.png"
																style="width: 24px; height: 24px;">
														</span> 70 g Gris</td>
													</tr>
													<tr>
														<td style="text-align: left">2-11R</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/presentacion/silicon.png"
																style="width: 24px; height: 24px;">
														</span> 70 g Rojo</td>
													</tr>

													<tr>
														<td style="text-align: left">2-11</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/presentacion/silicon.png"
																style="width: 24px; height: 24px;">
														</span> 70 g Trasparente</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocSelladores/hs_sellador001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocSelladores/ft_sellador001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br>  --><a
													href="https://guiarapida.kwx.com.mx/view/1052442743/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA SELLADORES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-SELLADOR 1 -->
									<div class="item" data-slide-number="1">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/img/img_sellado002.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">SELLADOR
												SHELLAC</h1>
											<h2 style="color: #647F90; font-weight: bold;">JUNTAS</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Sellador
												líquido de secado rápido y fraguado rígido, para ensambles
												rápidos y seguros en juntas automotrices e industriales,
												resiste gasolina, agua, aceite y otros derivados del
												petróleo, principales usos automotrices en empaques de bomba
												de agua, de gasolina, termóstatos y mangueras del radiador.
											</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">2-9</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/presentacion/selladoShellac.png"
																style="width: 24px; height: 24px;">
														</span> 50 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
											<%-- 	<a
													href="${pageContext.request.contextPath}/doc/DocSelladores/hs_sellador002.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocSelladores/ft_sellador002.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/1052442743/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA SELLADORES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-SELLADOR 2 -->
									<div class="item" data-slide-number="2">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/img/img_sellado003.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">SELLADOR
												No. 3 AVIACIÓN</h1>
											<h2 style="color: #647F90; font-weight: bold;">ENSAMBLE
												Y JUNTAS</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Sellador
												líquido para juntas, secado lento y fraguado flexible,
												lubrica las juntas evitando que se rompan con el calor y la
												vibración ya que no endurece, resistente al agua, aceite,
												vibración y compresión, para juntas de bomba de agua y
												conexiones roscadas, así como en juntas de maquinaria
												industrial, agrícola y equipo marino.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">2-7</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/presentacion/selladorAviacion.png"
																style="width: 24px; height: 24px;">
														</span> 115 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocSelladores/hs_sellador003.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocSelladores/ft_sellador003.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a><!--  <br>  --><a
													href="https://guiarapida.kwx.com.mx/view/1052442743/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA SELLADORES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-SELLADOR 4 -->
									<div class="item" data-slide-number="3">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/img/img_sellado004.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">SELLADOR</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA
												MONOBLOCKS</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Sella
												de manera efectiva grietas y cuarteaduras internas del
												monoblock, muy efectivo en metales como acero, hierro y
												aluminio, aplicación directa en la toma del radiador, tolera
												temperaturas y presiones presentes durante la operación
												normal del motor, formando un sellado permanente.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">4-12</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/presentacion/selladorMonoblock.png"
																style="width: 24px; height: 24px;">
														</span> 500 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocSelladores/hs_sellador004.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocSelladores/ft_sellador004.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br>  --><a
													href="https://guiarapida.kwx.com.mx/view/1052442743/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA SELLADORES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-SELLADOR 5 -->
									<div class="item" data-slide-number="4">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/img/img_sellado005.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">SOLDA
												FÁCIL</h1>
											<h2 style="color: #647F90; font-weight: bold;">EN FRÍO</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Compuesto
												con una base de resina acrílica y aluminio, que permite
												tapar perforaciones y grietas en superficies metálicas. Útil
												en tapa de punterías, tanques de gasolina, cárter,
												radiadores, caja de velocidades, carrocerías, metales,
												etcétera. Gran variedad de aplicación en la industria
												automotriz, industrial, agrícola y en el hogar.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">3-4</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/presentacion/silicon.png"
																style="width: 24px; height: 24px;">
														</span> 70 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocSelladores/hs_sellador005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocSelladores/ft_sellador005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/1052442743/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA SELLADORES
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-SELLADOR 6 -->
									<div class="item" data-slide-number="5">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/img/img_corcho005.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">CORCHO GRANO FINO</h1>
											<h2 style="color: #647F90; font-weight: bold;"></h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Material muy utilizado para la elaboración de juntas de diversos tamaños, resistente a altas temperaturas, muy hermético y es ideal para emplearse en componentes donde se requiera impedir la fuga de agua aceite y presión de gases, es de fácil manejo y con los espesores más comerciales y técnicamente más usados.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
														<th style="text-align: center">ESPESOR EN PULGADAS</th>
														<th style="text-align: center">ESPESOR EN MILIMETROS</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">C-1</td>
														<td> 60 X 90 CMS.</td>
														<td> 1/16</td>
														<td> 1.60</td>
														</tr>
														<tr>
														<td style="text-align: left">C-2</td>
														<td> 60 X 90 CMS.</td>
														<td> 3/32</td>
														<td> 2.40</td>
														</tr>
														<tr>
														<td style="text-align: left">C-3</td>
														<td> 60 X 90 CMS.</td>
														<td> 1/8</td>
														<td> 3.20</td>
														</tr>
														<tr>
														<td style="text-align: left">C-4</td>
														<td>60 X 90 CMS.</td>
														<td> 3/16</td>
														<td> 4.80</td>
														</tr>
														<tr>
														<td style="text-align: left">C-5</td>
														<td>60 X 90 CMS.</td>
														<td> 1/4</td>
														<td> 6.40</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocSelladores/hs_sellador005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  <a
													href="${pageContext.request.contextPath}/doc/DocSelladores/ft_sellador005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/1052442743/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA SELLADORES
												</a>--%>
											</div>
										</div>
									</div>

                                   <!-- DESC-SELLADOR 7 -->
									<div class="item" data-slide-number="6">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Selladores/img/img_vellomoid005.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">PAPEL VELLOMOID</h1>
											<h2 style="color: #647F90; font-weight: bold;"></h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Papel de fibra vegetal impregnado especialmente para proporcionar alta resistencia a los derivados del petróleo, y conveniente para funcionar en rangos de temperaturas hasta de 120°C (250°F). ideal para elaborar juntas automotrices e industriales, utilizando selladores de base mineral favoreciendo y mejorando los resultados. </h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">MEDIDA DEL ROLLO</th>
														<th style="text-align: center">ESPESOR EN PULGADAS</th>
														<th style="text-align: center">ESPESOR EN MILIMETROS</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">P-1</td>
														<td> 75 CMS. X 5 MTS.</td>
														<td> 1/64</td>
														<td> 0.40</td>
														</tr>
														<tr>
														<td style="text-align: left">P-2</td>
														<td> 75 CMS. X 5 MTS.</td>
														<td> 1/32</td>
														<td> 0.80</td>
														</tr>
														<tr>
														<td style="text-align: left">P-3</td>
														<td> 75 CMS. X 5 MTS.</td>
														<td> 1/16</td>
														<td> 1.60</td>
														</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocSelladores/hs_sellador005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  <a
													href="${pageContext.request.contextPath}/doc/DocSelladores/ft_sellador005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/1052442743/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA SELLADORES
												</a>--%>
											</div>
										</div>
									</div>



								</div>
								<a class="left carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left"></span>
								</a> <a class="right carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>

	<!--  Mantenimiento  -->
	<div id="Contenido-6" class="container"
		style="display: none; padding-left: 0px; padding-right: 0px;">

		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/mantenimiento-encabezado.png'); padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<table width="98%">
						<tr>
							<td width="50%" style="vertical-align: top;"></td>
							<td width="50%" style="vertical-align: top;" align="right">
								<table>
									<tr>
										<td>
											<h1 style="color: white;">PRODUCTOS PARA MANTENIMIENTO</h1>
										</td>
									</tr>
									<tr>
										<td>
											<p class="lead text-justify hidden-ms hidden-xs">Herramientas
												químicas que facilitan el trabajo y el servicio a motores,
												logrando un mantenimiento adecuado de las unidades que
												requieren el uso de productos de alta calidad y
												funcionalidad.</p>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class=" row hidden-xs" id="slider-thumbs"
			style="padding-right: 15px;">
			<ul class="hide-bullets list-inline style-Radiador bg-slider">
				<li><a class="thumbnail" id="carousel-selector-0">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/btn/btn_mantenimiento001.png">
								</td>
								<td>
									<p class="sub-text">
										Afloja <br> Todo
									</P>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail " id="carousel-selector-1">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/btn/btn_mantenimiento002.png">
								</td>
								<td>
									<p class="sub-text">
										Limpiaparabrisas <br> Fórmula <br> Concentrada
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail " id="carousel-selector-2">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/btn/btn_mantenimiento003.png">
								</td>
								<td>
									<p class="sub-text">Limpiaparabrisas</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-3">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/btn/btn_mantenimiento004.png">
								</td>
								<td>
									<p class="sub-text">
										Arrancador <br> para Motor
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-4">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/Inflallantas_Chica.png">
								</td>
								<td>
									<p class="sub-text ">Inflallantas</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-5">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/btn/btn_mantenimiento006.png">
								</td>
								<td>
									<p class="sub-text ">
										Esmeril <br> para Válvulas
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-6">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/btn/btn_mantenimiento007.png">
								</td>
								<td>
									<p class="sub-text ">
										Cosmético <br> para Bandas
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-7">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/DOT-3_Chica.png">
								</td>
								<td>
									<p class="sub-text ">
										L&iacute;quido para Frenos <br> y Sistema de <br>
										Embrague <br> Hidr&aacute;ulico <br> DOT-3 (LF-3)
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-8">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/DOT-4_Chica.png">
								</td>
								<td>
									<p class="sub-text ">
										L&iacute;quido para Frenos <br> y Sistema de <br>
										Embrague <br> Hidr&aacute;ulico <br> DOT-4 (LF-4)
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-9">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/btn/btn_mantenimiento0010.png">
								</td>
								<td>
									<p class="sub-text ">
										Silenciador <br> para <br> Frenos <br> de Disco
									</p>
								</td>
							</tr>
						</table>
				</a></li>
			</ul>
		</div>

		<div id="main_area">
			<div class="row">
				<div class="col-xs-12" id="slider"
					style="padding-left: 0px; padding-right: 0px;">
					<div class="row">
						<div class="col-sm-12" id="carousel-bounding-box"
							style="padding-left: 25px; padding-right: 25px;">
							<div class="carousel slide" id="myCarousel" style="width: 98%;">
								<div class="carousel-inner">

									<!-- DESC-MANTENIMIENTO 0 -->
									<div class="active item" data-slide-number="0">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/Afloja-todo_Grande.jpg"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">AFLOJA</h1>
											<h2 style="color: #647F90; font-weight: bold;">TODO</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Actúa
												rápidamente liberando partes oxidadas y corroídas, facilita
												el aflojar tuercas, tornillos, pernos, cables, ensambles,
												etcétera. Lubrica, evita la corrosión y la oxidación. Es
												para uso industrial, automotriz, marino, agrícola, y
												doméstico. No daña la capa superior de ozono.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">4-3</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/lata.png"
																style="width: 24px; height: 24px;">
														</span> 120 g</td>
													</tr>
													<tr>
														<td style="text-align: left">4-2</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/lata.png"
																style="width: 24px; height: 24px;">
														</span> 250 g</td>
													</tr>
													<tr>
														<td style="text-align: left">4-28</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/lata.png"
																style="width: 24px; height: 24px;">
														</span> 300 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
											<%-- 	<a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/hs_mantenimiento001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/ft_mantenimiento001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210189403/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA MANTENIMIENTO
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-MANTENIMIENTO 1 -->
									<div class="item" data-slide-number="1">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/img/img_mantenimiento002.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">LIMPIAPARABRISAS</h1>
											<h2 style="color: #647F90; font-weight: bold;">FÓRMULA
												CONCENTRADA</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Formulación
												concentrada, ideal para diluir hasta con cuatro litros de
												agua. Limpia grasas, insectos, suciedad de aves, tierra y
												polvo, así como savia de árboles y otros materiales que se
												adhieren al parabrisas. Mejora la visibilidad, ya que no
												empaña ni deja manchas. Su fórmula especial no daña las
												gomas de los limpiadores. No contiene amoniaco.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">8-8</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/botella250-350.png"
																style="width: 24px; height: 24px;">
														</span> 250 mL</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/ft_mantenimiento002.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <a
													href="https://guiarapida.kwx.com.mx/view/210189403/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA MANTENIMIENTO
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-MANTENIMIENTO 2 -->
									<div class="item" data-slide-number="2">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/img/img_mantenimiento003.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">LIMPIAPARABRISAS</h1>
											<h2 style="color: #647F90; font-weight: bold;"></h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Ideal
												para usarse de forma directa en el depósito. Limpia grasas,
												insectos, suciedad de aves, tierra y polvo, así como savia
												de árboles y otros materiales que se adhieren al parabrisas.
												Mejora la visibilidad, ya que no empaña ni deja manchas. Su
												fórmula especial no daña las gomas de los limpiadores. No
												contiene amoniaco.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">8-10</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/limpiaparabrisas.png"
																style="width: 24px; height: 24px;">
														</span> 1 L</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/hs_mantenimiento003.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/ft_mantenimiento003.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210189403/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA MANTENIMIENTO
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-MANTENIMIENTO 3 -->
									<div class="item" data-slide-number="3">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/img/img_mantenimiento004.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ARRANCADOR</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA
												MOTOR</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Facilita
												el arranque en motores a diésel y gasolina, cuida cilindros
												y pistones. Fórmula especial para todo tipo de clima, para
												uso en automóviles y camiones. Protege la batería y partes
												de encendido, al facilitar el arranque. No daña la capa
												superior de ozono.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">6-2</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/lata.png"
																style="width: 24px; height: 24px;">
														</span> 310 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/hs_mantenimiento004.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/ft_mantenimiento004.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br>  --><a
													href="https://guiarapida.kwx.com.mx/view/210189403/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA MANTENIMIENTO
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-MANTENIMIENTO 4 -->
									<div class="item" data-slide-number="4">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/Inflallantas_Grande.jpg"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">INFLALLANTAS</h1>
											<h2 style="color: #647F90; font-weight: bold;"></h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Vulcanizador
												instantáneo, infla y sella en segundos, no es necesario
												levantar el vehículo con gato mecánico o hidráulico, no
												afecta la alineación y el balanceo, puede usarse en
												vehículos de pasajeros, camionetas y camiones de cargas
												ligeras. No daña la capa superior de ozono.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">4-26</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/inflallantas.png"
																style="width: 24px; height: 24px;">
														</span> 320 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/hs_mantenimiento005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/ft_mantenimiento005.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210189403/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA MANTENIMIENTO
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-MANTENIMIENTO 5 -->
									<div class="item" data-slide-number="5">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/img/img_mantenimiento006.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ESMERIL</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA
												VÁLVULAS</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Para
												el rápido y perfecto asentamiento de las válvulas de motor,
												útil para pulir, afilar herramienta y dar terminado a piezas
												de torno y fundición. Tiene grado grueso para cortar, y
												grado fino para dar acabado a la pieza. No requiere
												adicionar aceite lubricante.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">4-7</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/esmeril.png"
																style="width: 24px; height: 24px;">
														</span> 60 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/hs_mantenimiento006.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/ft_mantenimiento006.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210189403/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA MANTENIMIENTO
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-MANTENIMIENTO 6 -->
									<div class="item" data-slide-number="6">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/Cosmetico-para-bandas_Grande.jpg"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">COSMÉTICO</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA
												BANDAS</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Ideal
												para todo tipo de bandas, de lona, cuero, hule, plástico,
												etcétera. Mejora la tracción y el agarre, evitando el
												rechinido y el patinaje. Protege de altas temperaturas, la
												fricción y el polvo. Por su acción lubricante alarga la vida
												útil de las bandas automotrices e industriales, de
												ventiladores, bombas de agua, máquinas cortadoras, motores
												estacionarios, etcétera. No daña la capa superior de ozono.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">4-9</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/latalisa.png"
																style="width: 24px; height: 24px;">
														</span> 120 g</td>
													</tr>
													<tr>
														<td style="text-align: left">4-10</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/lata.png"
																style="width: 24px; height: 24px;">
														</span> 250 g</td>
													</tr>
													<tr>
														<td style="text-align: left">4-11</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/latalisa.png"
																style="width: 24px; height: 24px;">
														</span> 200 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
											<%-- 	<a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/hs_mantenimiento007.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a> --%> <a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/ft_mantenimiento007.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a><!--  <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210189403/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA MANTENIMIENTO
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-MANTENIMIENTO 7 -->
									<div class="item" data-slide-number="7">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/DOT-3_Grande.jpg"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">LÍQUIDO
												PARA FRENOS Y SISTEMAS DE EMBRAGUE HIDR&Aacute;ULICO</h1>
											<h2 style="color: #647F90; font-weight: bold;">DOT-3
												(LF-3)</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Ideal
												para sistemas de freno de alta temperatura y embrague
												hidráulico, para vehículos que especifiquen el uso de
												líquido para frenos DOT-3 o LF3, frenos de disco en las
												cuatro ruedas, para autos último modelo, deportivos y todo
												terreno. Cumple con las especificaciones de la Norma Oficial
												Mexicana NOM-113- SCFI-1995.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">5-1</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/botella250-350.png"
																style="width: 24px; height: 24px;">
														</span> 250 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">5-4</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/botella250-350.png"
																style="width: 24px; height: 24px;">
														</span> 350 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">5-7</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/liquidofrenos.png"
																style="width: 24px; height: 24px;">
														</span> 950 mL</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/hs_mantenimiento008.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/ft_mantenimiento008.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br>  --><a
													href="https://guiarapida.kwx.com.mx/view/210189403/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA MANTENIMIENTO
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-MANTENIMIENTO 8 -->
									<div class="item" data-slide-number="8">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/DOT-4_Grande.jpg"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">LÍQUIDO
												PARA FRENOS Y SISTEMAS DE EMBRAGUE HIDR&Aacute;ULICO</h1>
											<h2 style="color: #647F90; font-weight: bold;">DOT-4
												(LF-4)</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">
												Ideal para sistemas de freno de alta temperatura y embrague
												hidráulico, para vehículos que especifiquen el uso de
												líquido para frenos DOT-4 o LF4, frenos de disco en las
												cuatro ruedas, último modelo, deportivos y todo terreno.
												Cumple con las especificaciones de la Norma Oficial Mexicana
												NOM-113-SCFI-1995.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">5-8</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/botella250-350.png"
																style="width: 24px; height: 24px;">
														</span> 350 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">5-9</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/liquidofrenos.png"
																style="width: 24px; height: 24px;">
														</span> 950 mL</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/hs_mantenimiento009.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/ft_mantenimiento009.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a><!--  <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210189403/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA MANTENIMIENTO
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-MANTENIMIENTO 9 -->
									<div class="item" data-slide-number="9">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/img/img_mantenimiento0010.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">SILENCIADOR</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA
												FRENOS DE DISCO</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Fabricación
												a base de resinas que repelen el agua, alta capacidad de
												adherencia, resiste altas temperaturas, elimina el ruido y
												el rechinido de los frenos de disco, producido por la
												vibración, la acumulación de polvo y el trabajo pesado. No
												daña la capa superior de ozono.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">5-6</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/lata.png"
																style="width: 24px; height: 24px;">
														</span> 340 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/hs_mantenimiento0010.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/ft_mantenimiento0010.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br>  --><a
													href="https://guiarapida.kwx.com.mx/view/210189403/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA MANTENIMIENTO
												</a>
											</div>
										</div>
									</div>

								</div>
								<a class="left carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left"></span>
								</a> <a class="right carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!--  Aditivos  -->
	<div id="Contenido-7" class="container"
		style="display: none; padding-left: 0px; padding-right: 0px;">
		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/articulosKwx/Aditivos/aditivos-encabezado.png'); padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<table width="98%">
						<tr>
							<td width="50%" style="vertical-align: top;"></td>
							<td width="50%" style="vertical-align: top;" align="right">
								<table>
									<tr>
										<td>
											<h1 style="color: white;">ADITIVOS</h1>
										</td>
									</tr>
									<tr>
										<td>
											<p class="lead text-justify hidden-ms hidden-xs">Complementos
												químicos de alta calidad y funcionalidad para beneficio del
												motor y todos sus componentes, promueven la correcta
												lubricación para reducir el desgaste y prolongar la vida
												funcional del equipo.</p>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class=" row hidden-xs" id="slider-thumbs"
			style="padding-right: 15px;">
			<ul class="hide-bullets list-inline style-Radiador bg-slider">
				<li><a class="thumbnail" id="carousel-selector-0">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Aditivos/Restaurador_Chica.png">
								</td>
								<td>
									<p class="sub-text">Restaurador de Motor y Lubricante</P>
								</td>
							</tr>
						</table>
				</a></li>
			</ul>
		</div>

		<div id="main_area">
			<div class="row">
				<div class="col-xs-12" id="slider"
					style="padding-left: 0px; padding-right: 0px;">
					<div class="row">
						<div class="col-sm-12" id="carousel-bounding-box"
							style="padding-left: 25px; padding-right: 25px;">
							<div class="carousel slide" id="myCarousel" style="width: 98%;">
								<div class="carousel-inner">

									<!-- DESC-ADITIVOS 0 -->
									<div class="active item" data-slide-number="0">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Aditivos/Restaurador_Grande.jpg"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">RESTAURADOR</h1>
											<h2 style="color: #647F90; font-weight: bold;">DE MOTOR
												Y LUBRICANTE</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Aumenta
												y empareja la compresión del motor, aumenta la potencia,
												incrementa la vida del motor, reduce el consumo de aceite,
												rellena las rayaduras de las paredes de los cilindros
												generadas por el uso del motor, es compatible con cualquier
												tipo de aceite, se puede aplicar a motores diésel y
												gasolina.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">7-1</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Aditivos/presentacion/latalisa.png"
																style="width: 24px; height: 24px;">
														</span> 325 mL 4 cilindros</td>
													</tr>
													<tr>
														<td style="text-align: left">7-2</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Aditivos/presentacion/latalisa.png"
																style="width: 24px; height: 24px;">
														</span> 443 mL 6 cilindros</td>
													</tr>
													<tr>
														<td style="text-align: left">7-3</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Aditivos/presentacion/latalisa.png"
																style="width: 24px; height: 24px;">
														</span> 561 mL 8 cilindros</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocAditivos/hs_aditivo001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocAditivos/ft_aditivo001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a><!--  <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210378515/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA ADITIVOS
												</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--  Estetica Automotriz  -->
	<div id="Contenido-8" class="container"
		style="display: none; padding-left: 0px; padding-right: 0px;">

		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/articulosKwx/EsteticaAutomotriz/automotriz-encabezado.png'); padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<table width="98%">
						<tr>
							<td width="50%" style="vertical-align: top;"></td>
							<td width="50%" style="vertical-align: top;" align="right">
								<table>
									<tr>
										<td>
											<h1 style="color: white;">ESTÉTICA AUTOMOTRIZ</h1>
										</td>
									</tr>
									<tr>
										<td>
											<p class="lead text-justify hidden-ms hidden-xs">Productos
												de gran calidad, adecuados para obtener el máximo resultado
												con una sencilla y rápida aplicación, con formulaciones
												exclusivas de gran eficacia.</p>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class=" row hidden-xs" id="slider-thumbs"
			style="padding-right: 15px;">
			<ul class="hide-bullets list-inline style-Radiador bg-slider">
				<li><a class="thumbnail" id="carousel-selector-0">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/EsteticaAutomotriz/btn/btn_automotriz001.png">
								</td>
								<td>
									<p class="sub-text">Lustra Vinil Protector</P>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-1">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/EsteticaAutomotriz/btn/btn_automotriz002.png">
								</td>
								<td>
									<p class="sub-text">
										Abrillantador de Llantas <br> y Tableros
									</P>
								</td>
							</tr>
						</table>
				</a></li>
			</ul>
		</div>

		<div id="main_area">
			<div class="row">
				<div class="col-xs-12" id="slider"
					style="padding-left: 0px; padding-right: 0px;">
					<div class="row">
						<div class="col-sm-12" id="carousel-bounding-box"
							style="padding-left: 25px; padding-right: 25px;">
							<div class="carousel slide" id="myCarousel" style="width: 98%;">
								<div class="carousel-inner">

									<!-- DESC-ADITIVOS 0 -->
									<div class="active item" data-slide-number="0">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/EsteticaAutomotriz/img/img_automotriz001.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">LUSTRA
												VINIL</h1>
											<h2 style="color: #647F90; font-weight: bold;">PROTECTOR</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Su
												exclusiva formulación a base de silicón protege de los
												efectos dañinos del sol, ozono y rayos ultra violeta,
												restaura opacamiento en plásticos y hules y protege contra
												cuarteaduras, deja una capa resistente y duradera, con
												propiedades antiestáticas para repeler el polvo, puede
												aplicarse en molduras y facias de plástico.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">8-1</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/EsteticaAutomotriz/presentacion/vinil.png"
																style="width: 24px; height: 24px;">
														</span> 245 mL</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocEsteticaAutomotriz/hs_automotriz001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocEsteticaAutomotriz/ft_automotriz001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/209919315/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA ESTETICA AUTOMOTRIZ
												</a>

											</div>
										</div>
									</div>

									<!-- DESC-ADITIVOS 1 -->
									<div class="item" data-slide-number="1">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/EsteticaAutomotriz/img/img_automotriz002.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ABRILLANTADOR</h1>
											<h2 style="color: #647F90; font-weight: bold;">DE
												LLANTAS Y TABLEROS</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Espuma
												abrillantadora que en minutos quita mugre y polvo de la
												manera más fácil y segura, su exclusiva formulación a base
												de silicón protege plástico y hules, deja una capa
												resistente y duradera, con propiedades antiestáticas para
												repeler el polvo, puede aplicarse en molduras y facias de
												plástico. No daña la capa superior de ozono.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">8-20</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/EsteticaAutomotriz/presentacion/lata.png"
																style="width: 24px; height: 24px;">
														</span> 400 g</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocEsteticaAutomotriz/hs_automotriz002.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocEsteticaAutomotriz/ft_automotriz002.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/209919315/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA ESTETICA AUTOMOTRIZ
												</a>
											</div>
										</div>
									</div>

								</div>
								<a class="left carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left"></span>
								</a> <a class="right carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!--  Plumas  -->
	<div id="Contenido-9" class="container"
		style="display: none; padding-left: 0px; padding-right: 0px;">

		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/articulosKwx/PlumasLimpiaparabrisas/plumas-encabezado.png'); padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<table width="98%">
						<tr>
							<td width="50%" style="vertical-align: top;"></td>
							<td width="50%" style="vertical-align: top;" align="right">
								<table>
									<tr>
										<td>
											<h1 style="color: white;">PLUMAS LIMPIAPARABRISAS</h1>
										</td>
									</tr>
									<tr>
										<td>
											<p class="lead text-justify hidden-ms hidden-xs">Las
												plumas limpiaparabrisas de KWX, proveen la mayor resistencia
												y tecnología de vanguardia, para una limpieza de alta
												calidad, brindándole la mejor sensación de confort y
												seguridad en el manejo, en cualquier condición de lluvia.</p>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class=" row hidden-xs" id="slider-thumbs"
			style="padding-right: 15px;">
			<ul class="hide-bullets list-inline style-Radiador bg-slider">
				<li><a class="thumbnail" id="carousel-selector-0">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/PlumasLimpiaparabrisas/Alta_Chica.png">
								</td>
								<td>
									<p class="sub-text">Alta Calidad</P>
										<ul>
											<li> <b>Tipo Recta</b>  
											</li>
										</ul>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-1">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/PlumasLimpiaparabrisas/Premium_Chica.png">
								</td>
								<td>
									<p class="sub-text">Calidad Premium</P>
										<ul>
											<li> <b>Tipo Banana</b>  
											</li>
										</ul>
								</td>
							</tr>
						</table>
				</a></li>
								<li><a class="thumbnail " id="carousel-selector-2">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/btn/btn_mantenimiento002.png">
								</td>
								<td>
									<p class="sub-text">
										Limpiaparabrisas <br> Fórmula <br> Concentrada
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail " id="carousel-selector-3">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/btn/btn_mantenimiento003.png">
								</td>
								<td>
									<p class="sub-text">Limpiaparabrisas</p>
								</td>
							</tr>
						</table>
				</a></li>
			</ul>
		</div>

		<div id="main_area">
			<div class="row">
				<div class="col-xs-12" id="slider"
					style="padding-left: 0px; padding-right: 0px;">
					<div class="row">
						<div class="col-sm-12" id="carousel-bounding-box"
							style="padding-left: 25px; padding-right: 25px;">
							<div class="carousel slide" id="myCarousel" style="width: 98%;">
								<div class="carousel-inner">
									<!-- DESC-ADITIVOS 0 -->
									<div class="active item" data-slide-number="0">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/PlumasLimpiaparabrisas/Alta_Grande.jpg"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">ALTA
												CALIDAD</h1>
											<h2 style="color: #647F90; font-weight: bold;"></h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Su
												estructura permite el máximo contacto de la goma a todo lo
												largo de la pluma limpiaparabrisas, su acabado de precisión
												y el accionamiento de trabajo a 45° desplaza con mayor
												facilidad el agua del parabrisas. Con su adaptador de tipo
												universal las plumas limpiaparabrisas de KWX cubren el 95%
												de las aplicaciones automotrices actuales y de años
												anteriores permitiendo una instalación fácil y segura.</h4>
											<br>
											<div class="btn-group btn-img" role="group"
												style="align: center">
												<a
													href="${pageContext.request.contextPath}/doc/DocPlumas/catalogoPlumas001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> CATALOGO DE PLUMAS
												</a> <a
													href="https://guiarapida.kwx.com.mx/view/210620135/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA PLUMAS
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-ADITIVOS 1 -->
									<div class="item" data-slide-number="1">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/PlumasLimpiaparabrisas/Premium_Grande.jpg"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">CALIDAD
												PREMIUM</h1>
											<h2 style="color: #647F90; font-weight: bold;"></h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Su 
											Innovadora tecnología y su diseño permiten ofrecer un 
											producto que no requiere uniones o bisagras de metal 
											obteniendo un mejor funcionamiento al distribuir de manera
											 uniforme la presión a lo largo de toda la pluma
											  limpiaparabrisas, obteniendo mejor visibilidad que da seguridad 
											  al conducir superando el rendimiento en todo clima a las plumas 
											  convencionales. Cuentan con 10 conectores que cubren el 99% de las 
											  aplicaciones del mercado automotriz, cubriendo a modelos 
											  anteriores y actuales.</h4>
												
											<br>
											<div class="btn-group btn-img" role="group"
												style="align: center">
												<a
													href="${pageContext.request.contextPath}/doc/DocPlumas/catalogoPlumas001.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> CATALOGO DE PLUMAS
												</a> <a
													href="https://guiarapida.kwx.com.mx/view/210620135/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA PLUMAS
												</a>
											</div>
										</div>
									</div>


				
					<!-- DESC-MANTENIMIENTO 1 -->
									<div class="item" data-slide-number="2">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/img/img_mantenimiento002.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">LIMPIAPARABRISAS</h1>
											<h2 style="color: #647F90; font-weight: bold;">FÓRMULA
												CONCENTRADA</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Formulación
												concentrada, ideal para diluir hasta con cuatro litros de
												agua. Limpia grasas, insectos, suciedad de aves, tierra y
												polvo, así como savia de árboles y otros materiales que se
												adhieren al parabrisas. Mejora la visibilidad, ya que no
												empaña ni deja manchas. Su fórmula especial no daña las
												gomas de los limpiadores. No contiene amoniaco.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">8-8</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/botella250-350.png"
																style="width: 24px; height: 24px;">
														</span> 250 mL</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/ft_mantenimiento002.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <a
													href="https://guiarapida.kwx.com.mx/view/210620135/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA MANTENIMIENTO
												</a>
											</div>
										</div>
									</div>

									<!-- DESC-MANTENIMIENTO 2 -->
									<div class="item" data-slide-number="3">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/img/img_mantenimiento003.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">LIMPIAPARABRISAS</h1>
											<h2 style="color: #647F90; font-weight: bold;"></h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Ideal
												para usarse de forma directa en el depósito. Limpia grasas,
												insectos, suciedad de aves, tierra y polvo, así como savia
												de árboles y otros materiales que se adhieren al parabrisas.
												Mejora la visibilidad, ya que no empaña ni deja manchas. Su
												fórmula especial no daña las gomas de los limpiadores. No
												contiene amoniaco.</h4>
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">8-10</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/ProductosMantenimiento/presentacion/limpiaparabrisas.png"
																style="width: 24px; height: 24px;">
														</span> 1 L</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												<%-- <a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/hs_mantenimiento003.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													HOJA DE SEGURIDAD
												</a>  --%><a
													href="${pageContext.request.contextPath}/doc/DocMantenimiento/ft_mantenimiento003.pdf"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													FICHA TÉCNICA
												</a> <!-- <br> --> <a
													href="https://guiarapida.kwx.com.mx/view/210620135/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA MANTENIMIENTO
												</a>
											</div>
										</div>
									</div>



								</div>
								<a class="left carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left"></span>
								</a> <a class="right carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!--  Cables  -->
	<div id="Contenido-10" class="container"
		style="display: none; padding-left: 0px; padding-right: 0px;">

		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/articulosKwx/CableParaBujias/cables-encabezado.png'); padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<table width="98%">
						<tr>
							<td width="50%" style="vertical-align: top;"></td>
							<td width="50%" style="vertical-align: top;" align="right">
								<table>
									<tr>
										<td>
											<h1 style="color: white;">CABLES PARA BUJÍAS</h1>
										</td>
									</tr>
									<tr>
										<td>
											<p class="lead text-justify hidden-ms hidden-xs">Los
												cables para bujías de KWX están fabricados en México por
												mano de obra calificada, se utilizan materias primas de
												primera calidad, para cubrir las especificaciones y
												requerimientos de equipo original, son recomendados para
												todo tipo de automóviles, camionetas y SUV´s.</p>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class=" row hidden-xs" id="slider-thumbs"
			style="padding-right: 15px;">
			<ul class="hide-bullets list-inline style-Radiador bg-slider">
				<li><a class="thumbnail" id="carousel-selector-0">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/CableParaBujias/btn/btn_cables001.png">
								</td>
								<td>
									<p class="sub-text">Cables para bujías EPDM</P>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-1">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/CableParaBujias/btn/btn_cables002.png">
								</td>
								<td>
									<p class="sub-text">Cables para bujías Silicón</P>
								</td>
							</tr>
						</table>
				</a></li>
			</ul>
		</div>

		<div id="main_area">
			<div class="row">
				<div class="col-xs-12" id="slider"
					style="padding-left: 0px; padding-right: 0px;">
					<div class="row">
						<div class="col-sm-12" id="carousel-bounding-box"
							style="padding-left: 25px; padding-right: 25px;">
							<div class="carousel slide" id="myCarousel" style="width: 98%;">
								<div class="carousel-inner">
									<!-- DESC-ADITIVOS 0 -->
									<div class="active item" data-slide-number="0">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/CableParaBujias/img/img_cables001.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">CABLES</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA
												BUJÍAS EPDM</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">El
												forro y los capuchones de EPDM anti-flama proporcionan un
												aislante y sellado perfecto, son a prueba de humedad y a
												alta temperatura, sus terminales garantizan un excelente
												contacto con la bujía, el conductor es grafitado y permite
												una eficiente supresión de interferencia electromagnética.</h4>
											<div class="btn-group btn-img" role="group">
												<a
													href="https://guiarapida.kwx.com.mx/view/210048209/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA CABLES PARA BUJIAS
												</a>
											</div>

										</div>
									</div>
									<!-- DESC-ADITIVOS 1 -->
									<div class="item" data-slide-number="1">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/CableParaBujias/img/img_cables002.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">CABLES</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA
												BUJÍAS SILICÓN</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">El
												forro tricapa, de silicón, fibra de vidrio y EPDM
												proporcionan un aislamiento altamente dieléctrico, los
												capuchones de silicón son a prueba de humedad y alta
												temperatura, las terminales fabricadas de acero inoxidable o
												cobre conforme a equipo original, el conductor con capacidad
												para suprimir la interferencia electromagnética de 9 a 21
												Kiloohmios.</h4>
											<div class="btn-group btn-img" role="group">
												<a
													href="https://guiarapida.kwx.com.mx/view/210048209/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA CABLES PARA BUJIAS
												</a>
											</div>

										</div>
									</div>
								</div>
								<a class="left carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left"></span>
								</a> <a class="right carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!--  KITS  -->
	<div id="Contenido-11" class="container"
		style="display: none; padding-left: 0px; padding-right: 0px;">

		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/articulosKwx/kits/Encabezado_afi.jpg'); padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12"
					style="padding-right: 0px;">
					<table width="98%">
						<tr>
							<td width="50%" style="vertical-align: top;"></td>
							<td width="50%" style="vertical-align: top;" align="right">
								<table>
									<tr>
										<td>
											<h1 style="color: white;">Kits de Afinación y Lubricación</h1>
										</td>
									</tr>
									<tr>
										<td>
											<p class="lead text-justify  hidden-ms hidden-xs">Los kits de KWX contienen todo lo necesario 
											para la correcta lubricación del motor, así mismo los componentes importantes para realizar 
											la afinación del vehículo con la máxima calidad requerida. Sus componentes están elaborados 
											de acuerdo con las especificaciones de equipo original, cubren la mayor cantidad de 
											aplicaciones a nivel nacional.</p>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class=" row hidden-xs" id="slider-thumbs"
			style="padding-right: 15px;">
			<ul class="hide-bullets list-inline style-Radiador bg-slider">
	<li><a class="thumbnail" id="carousel-selector-0">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/kits/btn/KitLub_Chica.png">
								</td>
								<td>
									<p class="sub-text">
										Kit's <br> de Lubricaci&oacute;n
									</p>
								</td>
							</tr>
						</table>
				</a></li>

				<li><a class="thumbnail" id="carousel-selector-1">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/kits/btn/KIT_Afi_Chica.png">
								</td>
								<td>
									<p class="sub-text">
										Kit's <br> de Afinaci&oacute;n <br> con aceite
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				
				<li><a class="thumbnail" id="carousel-selector-2">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/kits/btn/Afi_sa_chi.png">
								</td>
								<td>
									<p class="sub-text">
										Kit's <br> de Afinaci&oacute;n <br> sin aceite
									</p>
								</td>
							</tr>
						</table>
				</a></li>
				
			</ul>
		</div>

		<div id="main_area">
			<div class="row">
				<div class="col-xs-12" id="slider"
					style="padding-left: 0px; padding-right: 0px;">
					<div class="row">
						<div class="col-sm-12" id="carousel-bounding-box"
							style="padding-left: 25px; padding-right: 25px;">
							<div class="carousel slide" id="myCarousel" style="width: 98%;">
								<div class="carousel-inner">
								
                                      <!-- kits 0 -->
									<div class="active item" data-slide-number="0">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/kits/img/KitLub_Grande.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">KIT´S</h1>
											<h2 style="color: #647F90; font-weight: bold;">DE
												LUBRICACIÓN</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">El kit de lubricación de KWX contiene lo 
											necesario para la correcta lubricación del motor, cubre las especificaciones más exigentes 
											de los motores de vehículos a gasolina de modelos recientes y anteriores.
                                            <br> 
                                            Se recomienda el reemplazo del filtro y lubricante cada 5 mil kilómetros, 
                                            para mantener en óptimas condiciones de funcionamiento el motor.  
											</h4>
											<div class="btn-group btn-img" role="group">

												<a
													href="https://guiarapida.kwx.com.mx/view/1051975232/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA KITS DE LUBRICACIÓN
												</a>
											</div>
											<%-- <img
												src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/img/captura1.png"
												class="img-responsive"> --%>
										</div>

									</div>

									<!-- kits 1 -->
									<div class="item" data-slide-number="1">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/kits/img/KIT_Afi_Grande.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">KIT´S</h1>
											<h2 style="color: #647F90; font-weight: bold;">DE
												AFINACIÓN <br> CON ACEITE</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Contiene todos los elementos necesarios 
											para realizar una afinación de calidad al motor del vehículo: 
											lubricante, filtro para aceite, aire, para gasolina, y bujías de larga duración.
                                            <br> Todos sus componentes están fabricados bajo especificaciones de equipo original.
                                                  Para conservar en óptimas condiciones su motor realice el servicio de afinación de 
                                                  acuerdo con el manual del propietario o bien cada 6 mil kilómetros </h4>
											<div class="btn-group btn-img" role="group">

												
												<a
													href="https://guiarapida.kwx.com.mx/view/1052266659/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA KITS DE AFINACIÓN CON ACEITE
												</a>
											</div>
											<%-- <img
												src="${pageContext.request.contextPath}/image/articulosKwx/kits/img/Afi_sa_gde.png"
												class="img-responsive"> --%>
										</div>
									</div>
									
									<!-- kits 2 -->
									<div class="item" data-slide-number="1">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/kits/img/Afi_sa_gde.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">KIT´S</h1>
											<h2 style="color: #647F90; font-weight: bold;">DE
												AFINACIÓN <br> SIN ACEITE</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Para realizar una afinación eficiente y rápida al motor, 
											 este kit de afinación contiene los elementos de calidad necesarios para ello.
											  Sus componentes están fabricados bajo especificaciones de equipo original con garantía de calidad al 100%
                                              <br> Para conservar en óptimas condiciones su motor realice el servicio de afinación de 
                                              acuerdo con el manual del propietario, o bien cada 6 mil kilómetros.
                                            </h4>
											<div class="btn-group btn-img" role="group">

												<a
													href="https://guiarapida.kwx.com.mx/view/1052481617/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button"> <span class="glyphicon glyphicon-ok "></span>
													GUÍA KITS DE AFINACIÓN SIN ACEITE
												</a>
												 
											</div>
											<%-- <img
												src="${pageContext.request.contextPath}/image/articulosKwx/AceitesLubricantes/img/captura.png"
												class="img-responsive"> --%>
										</div>
									</div>
                                  </div>
                                  <a class="left carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left"></span>
								</a> <a class="right carousel-control hidden-lg" href="#myCarousel"
									role="button" data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	
		<!--  SANITIZANTES  -->
	<div id="Contenido-12" class="container"
		style="display: none; padding-left: 0px; padding-right: 0px;">

		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/articulosKwx/Sanitizantes/Encabezado_san2.jpg'); padding-right: 25px;background-repeat: no-repeat;background-size: cover;">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<table width="98%">
						<tr>
							<td width="50%" style="vertical-align: top;"></td>
							<td width="50%" style="vertical-align: top;" align="right">
								<table>
									<tr>
										<td>
											<h1 style="color: white;">SANITIZANTES</h1>
										</td>
									</tr>
									<tr>
										<td>
											<p class="lead text-justify hidden-ms hidden-xs">Los sanitizantes de KWX  estan diseñados  
											y formulados para eliminar una amplia gama de gérmenes, bacterias, virus y hongos. Además 
											de ser hipoalergénicos y de tener múltiples usos en el hogar, auto, oficinas y negocios.</p>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class=" row hidden-xs" id="slider-thumbs"
			style="padding-right: 15px;">
			<ul class="hide-bullets list-inline style-Radiador bg-slider">
				<li><a class="thumbnail" id="carousel-selector-0">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Sanitizantes/btn/GelAntibacterial_Chica.png">
								</td>
								<td>
									<p class="sub-text">GEL ANTIBACTERIAL <br> PARA MANOS</P>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-1">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Sanitizantes/btn/SanitizanteAerosol_Chica.png"
									 />
								</td>
								<td>
									<p class="sub-text">DESINFECTANTE ANTIBACTERIAL  <br> PARA SUPERFICIES</P>
								</td>
							</tr>
						</table>
				</a></li>
				<li><a class="thumbnail" id="carousel-selector-2">
						<table>
							<tr>
								<td><img
									src="${pageContext.request.contextPath}/image/articulosKwx/Sanitizantes/btn/SanitizanteManos_Chica.png">
								</td>
								<td>
									<p class="sub-text">SANITIZANTE ANTIBACTERIAL <br> PARA MANOS Y SUPERFICIES</P>
								</td>
							</tr>
						</table>
				</a></li>
			</ul>
		</div>

		<div id="main_area">
			<div class="row">
				<div class="col-xs-12" id="slider"
					style="padding-left: 0px; padding-right: 0px;">
					<div class="row">
						<div class="col-sm-12" id="carousel-bounding-box"
							style="padding-left: 25px; padding-right: 25px;">
							<div class="carousel slide" id="myCarousel" style="width: 98%;">
								<div class="carousel-inner">
									<!-- GelAntibacterial 0 -->
									<div class="active item" data-slide-number="0">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Sanitizantes/img/GelAntibacterial_Grande.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">GEL ANTIBACTERIAL</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA MANOS</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">El Gel Antibacterial KWX esta formulado a base de alcohol etílico
                                                 y agentes humectantes que dejan las manos limpias y suaves.
                                                 Desinfecta eliminando gérmenes, virus y bacterias, no requiere
                                                 enjuagarse o hacer uso de toalla para secar las manos.
                                                 Su fórmula hipoalergénica no deja residuos ni sensación pegajosa,
                                                 ideal para usarse en niños y adultos, en lugares o situaciones donde no hay agua y jabón disponible.
                                            </h4>
                                            
                                            <table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">K-11-3</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Sanitizantes/presentacion/icon_gel.png"
																style="width: 24px; height: 24px;">
														</span> 1 L</td>
													</tr>
												</tbody>
											</table>
                                            
                                            <div class="btn-group btn-img" role="group">
												<a
												href="${pageContext.request.contextPath}/doc/DocSanitizantes/ft_gelAntibacterial.pdf"
												target="_blank" class="btn btn-default btn-img-buttom"
												role="button" style="align: center"> <span
												class="glyphicon glyphicon-ok "></span> Ficha técnica
											</a>
											<a
													href="https://guiarapida.kwx.com.mx/view/1051925105/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA SANITIZANTES
												</a>
											</div>
                                            
										</div>
									</div>
									<!-- DESINFECTANTE ANTIBACTERIAL PARA SUPERFICIES 1 -->
									<div class="item" data-slide-number="1">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Sanitizantes/img/SanitizanteAerosol_Grande.png"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">DESINFECTANTE ANTIBACTERIAL</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA SUPERFICIES</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Aerosol desinfectante fabricado con activos antivirales, 
											antimicóticos y antibacteriales, ejerce una protección eficaz eliminando virus, hongos y bacterias, 
											al utilizarse en superficies metálicas, cerámica, plástico y muebles, así como en objetos de uso cotidiano. 
											Cuenta con un amplio espectro biocida, gracias a la acción sinérgica del alcohol etílico en conjunto con los 
											otros componentes de la fórmula. Eficiente en superficies porosas, donde se concentran la mayor cantidad 
											de microorganismos.</h4>
											
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">K-11-4</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Sanitizantes/presentacion/icon_aerosol.png"
																style="width: 24px; height: 24px;">
														</span> 450 mL</td>
													</tr>
												</tbody>
											</table>
											
											<div class="btn-group btn-img" role="group">
												<a
												href="${pageContext.request.contextPath}/doc/DocSanitizantes/ft_desinfectanteSuperficies.pdf"
												target="_blank" class="btn btn-default btn-img-buttom"
												role="button" style="align: center"> <span
												class="glyphicon glyphicon-ok "></span> Ficha técnica
											</a>
											<a
													href="https://guiarapida.kwx.com.mx/view/1051925105/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA SANITIZANTES
												</a>
											</div>
											
										</div>
									</div>
									
									<!-- DESINFECTANTE ANTIBACTERIAL PARA SUPERFICIES 1 -->
									<div class="item" data-slide-number="1">
										<div class="col-sm-6" align="center">
											<img
												src="${pageContext.request.contextPath}/image/articulosKwx/Sanitizantes/Sanitizante_Grande.jpg"
												class="img-responsive">
										</div>
										<div class="col-sm-6" align="center">
											<h1 style="color: #21669F; font-weight: bold;">SANITIZANTE ANTIBACTERIAL</h1>
											<h2 style="color: #647F90; font-weight: bold;">PARA MANOS Y SUPERFICIES</h2>
											<h4 class="lead text-justify" style="color: #4D4D4D;">Su empleo reduce el riesgo de contraer enfermedades infecciosas. 
											 Permite de manera fácil, rápida y segura, la sanitización de superficies de todo tipo de materiales como son plásticos,
											 metales, madera, cerámica, telas entre otros.
											 <br>
                                             Muy útil en la sanitización en partes del auto con las que se tiene contacto como son manijas, 
                                             levanta vidrios, rejillas del aire acondicionado, palanca de velocidades, volante, asientos etc.
                                             En el hogar en manijas de puertas, teléfonos, inodoros, lavabos, repisas, muebles en general etc.
                                             </h4>
											
											<table class="table">
												<thead class="tabla-enc">
													<tr>
														<th style="text-align: center">CLAVE</th>
														<th style="text-align: center">PRESENTACIÓN</th>
													</tr>
												</thead>
												<tbody class="tabla-cont">
													<tr>
														<td style="text-align: left">K-11-2</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Sanitizantes/presentacion/icon_manos.png"
																style="width: 24px; height: 24px;">
														</span> 245 mL</td>
													</tr>
													<tr>
														<td style="text-align: left">K-11-5</td>
														<td><span> <img
																src="${pageContext.request.contextPath}/image/articulosKwx/Sanitizantes/presentacion/icon_manos2.png"
																style="width: 24px; height: 24px;">
														</span> 20 L</td>
													</tr>
												</tbody>
											</table>
											<div class="btn-group btn-img" role="group">
												
											<a
													href="https://guiarapida.kwx.com.mx/view/1051925105/"
													target="_blank" class="btn btn-default btn-img-buttom"
													role="button" style="align: center"> <span
													class="glyphicon glyphicon-ok "></span> GUÍA SANITIZANTES
												</a>
											</div>
										</div>
									</div>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	 		  <br> <br> <br>
	 <%@include file="footerKwx.html"%>

	<br><br>
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aajN9AQK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
</body>
</html>