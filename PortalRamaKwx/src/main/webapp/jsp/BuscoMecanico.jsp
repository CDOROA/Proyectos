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

<title>Corporación Química Automotriz, S.A. de C.V. (KWX)</title>
<meta name="keywords"
	content="tapafugas, refrigerante, anticongelante, liquido para frenos, inflallantas, afloja todo, limpiador carburador, limpiador inyector, desengrasante para motor, abrillantador,pluma limpiaparabrisas, lubricantes, aditivos, filtros, monogrado, multigrado, aceite monogrado, aceite multigrado, cables para bujia, filtros de aire, filtros de gasolina, filtros de aceite, aceite para auto, selladores, aceite transmision, aceite para moto"></meta>
<meta name="description"
	content="Corporación Química Automotriz, S.A. de C.V. (KWX) es una empresa 100% mexicana certificada con la norma de calidad ISO 9001-2008, fundada en 1985 cuyo giro principal es la fabricación de productos químicos automotrices"></meta>
		
		<!-- CODIGO PARA NO GUARDAR CACHE -->
		<meta http-equiv="Expires" content="-1">
    	<meta http-equiv="Cache-Control" content="no-cache">
    	<meta http-equiv="Pragma" content="no-cache">
<!--Mapa-->
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
<link href="${pageContext.request.contextPath}/css/BuscoMecanico.css"
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
	src="${pageContext.request.contextPath}/js/BuscoMecanico.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script type="text/javascript">
	window.onload = function() {
		initialize();
		$('#cmbListaEstados').on('change', CargaDelegaciones);
		$('#cmbListaDomicilio').on('change', CargaMecanicos);
		$('#cmbListaMunicipio').on('change', CargaMecanicos);

		 var f = window.innerHeight;
         var d = f - (f * .25) ;
         document.getElementById("mi-mapa").style.height = (d) + "px";
		
		IniciaMapa();

		$("#myModal").modal();
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
	function IniciaMapa() {
		var latlng = new google.maps.LatLng(24.3951357, -96.4561295);

		var DelIni = "0";
		var mapOptions;

		if (DelIni > 0) {
			mapOptions = {
				zoom : 11,
				center : latlng,
				mapTypeId : google.maps.MapTypeId.ROADMAP,
			};
		} else {
			mapOptions = {
				zoom : 6,
				center : latlng,
				mapTypeId : google.maps.MapTypeId.ROADMAP,
			};
		}
		map = new google.maps.Map(document.getElementById('mi-mapa'),
				mapOptions);
	}

	function setMarkers(markers) {
		var r = [];
		var c = 0;
		//	alert("Markers: " + markers.length);
		var mapDiv = document.getElementById("mi-mapa");
		var catalunya = new google.maps.LatLng(24.3951357, -96.4561295);
		var options = {
			center : catalunya,
			zoom : 12
		//,
		//mapTypeId: google.maps.MapTypeId.ROADMAP
		};

		var mapa = new google.maps.Map(mapDiv, options);

		for (i = 0; i < markers.length; i++) {
			var mec = markers[i];
			//	alert("nombreTaller: " + mec.nombreTaller);
			// imagen
			var image = {
				
				url :  "http://www.kwx.com.mx/image/imgKwx/Globo_mapa.png",
				scaledSize : new google.maps.Size(30, 45)
			};
			// Codigo para generar la marka en el mapa...
			var marker = new google.maps.Marker({
				position : new google.maps.LatLng(mec.latitud, mec.longitud),
				map : mapa,
				title : 'Empresa: ' + mec.nombreTaller,
				icon : image
			});
			var infowindow;
			var nombre_cte = mec.nombreTaller;
			var direccion = mec.calle + " " + mec.numExt + ", " + mec.colonia
					+ "," + mec.municipio + ".";
			var telefono = mec.telefono;
			var correo = mec.email;
			var whatsApp = mec.whatsapp;
			var coordenada = (mec.latitud + "," + mec.longitud);
			var contenido = '<div id="content" style="width:100%;" align="center">'
					+ '<div class="col-md-12 col-sm-12">'
					+ '<table>'
					+ '<tr>'
					+ '<td style="font-weight:bold; font-size:12px; color:#1D69AA;" align="center">'
					+ '<p>'
					+ nombre_cte
					+ '</p>'
					+ '</td>'
					+ '</tr>'
					+ '<tr>'
					+ '<td style="font-weight:bold; font-size:12px; color:#9E9E9E;" align="center">'
					+ '<p>'
					+ direccion
					+ '</p>'
					+ '</td>'
					+ '</tr>'
					+ '<tr>'
					+ '<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'
					+ '<p>Tel.: '
					+ telefono
					+ '</p>'
					+ '</td>'
					+ '</tr>'
					+ '<tr>'
					+ '<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'
					+ '<p>Correo: '
					+ correo
					+ '</p>'
					+ '</td>'
					+ '</tr>'
					+ '<tr>'
					+ '<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'
					+ '<p>WhatsApp: '
					+ whatsApp
					+ '</p>'
					+ '</td>'
					+ '</tr>'
					+ '<tr>'
					+ '<td style="font-weight:bold;font-size:12px; color:#fe5042;" align="center">'
					+ '<span class="glyphicon glyphicon-map-marker"></span> <a href="https://www.google.com/maps/place/'+coordenada+'/@${clientes.latitud}${clientes.longitud}" target="_blank" style=" color:#00bfd9">Ver en Google maps</a>'
					+ '</td>' + '</tr>' + '</table>' + '</div>' + '</div>';

			r.push(contenido);

			var infoWindow = new google.maps.InfoWindow(), marker, c;

			// Allow each marker to have an info window    

			google.maps.event.addListener(marker, 'click',
					(function(marker, c) {
						return function() {
							infoWindow.setContent(r[c]);
							infoWindow.open(mapa, marker);
						}
					})(marker, c));
			try {
				var control = 'img' + c;
				google.maps.event.addDomListener(document
						.getElementById(control), 'click',
						(function(marker, c) {
							return function() {
								infoWindow.setContent(r[c]);
								infoWindow.open(mapa, marker);
								mapa.setCenter(marker.getPosition());

							}
						})(marker, c));

			} catch (e) {
				// alert("catch" + e);
			}
			c++;

			mapa.setCenter(new google.maps.LatLng(mec.latitud, mec.longitud));

			mapa.setZoom(12);
		}
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
	<div class="container-fluid">

		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-6"></div>
			<div class="col-lg-9 col-md-9 col-sm-6">

				<form action="ServletSoyMecanico" method="post">
					<input type="hidden" name="operacion" id="operacion" value="2">


					<div class="form-row">
						<div class="form-group col-md-4">

							<!-- <label for="cmbListaEstados" class="pull-left">Estado</label> -->
							<select name="cmbListaEstados" id="cmbListaEstados"
								class="form-control mi-input">
								<option value="0" selected="selected">- Estado -</option>
								<c:forEach var="estado" items="${listEstados}">
									<option value="${estado.descripcion}">${estado.descripcion}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-4">
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
								<c:forEach var="municipio" items="${listMunicipios}">
									<option value="${municipio.descripcion}">${municipio.descripcion}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-4">

							<!-- <label for="cmbListaDomicilio" class="pull-left">Requiere
								servicio a domicilio</label> -->
							<select name="cmbListaDomicilio" id="cmbListaDomicilio"
								class="form-control mi-input">
								<option value="T" selected="selected">- Requiere
									servicio a domicilio -</option>
								<option value="S">Si</option>								
							</select>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-6">
				<table>
					<tr>
						<td><img class="img-responsive"
							src="${pageContext.request.contextPath}/img/Busco_2.png" alt=""
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
					<tr>
						<td>
							<div class="hovereffect " style="margin-top: 0px;">
								<img class="img-responsive"
									src="${pageContext.request.contextPath}/img/Evaluar.png" alt=""
									style="display: inline-block;"></img>
								<div class="overlay">
									<!--   <a class="info" href="${pageContext.request.contextPath}/ServletInicio?operacion=2"> -->
									<a class="info"
										href="${pageContext.request.contextPath}/ServletEvaluarMecanico?operacion=1">
									</a>

								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div class="col-lg-9 col-md-9 col-sm-6">
				<div id="mi-mapa" style="width: 98%; height: 510px;"></div>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h3 style="color: black;" class="modal-title">AVISO</h3>
					</div>
					<div class="modal-body" style="color: black;">
						<p>En apoyo ante la contingencia que se vive actualmente en
							todo el país y por la importancia de tener los vehículos en
							buenas condiciones, hemos creado la siguiente base de datos para
							que encuentres a un mecánico cerca de tu domicilio y seguir
							moviendo la economía local.</p>
						<p>
							Cabe aclarar que <img style="height: 15px;"
								src="${pageContext.request.contextPath}/img/headerFooter/logokwxfooter.png"></img>
							no tiene ningún tipo de convenio con ninguno de los mecánicos de
							esta base de datos, por lo cual no nos hacemos responsables de
							ningún tipo de daño.
						</p>
						<P>Sin embargo, si contactó con algún mecánico a través de nuestra plataforma, agradeceremos lo evalúe.</P>
						<h3>#QuedateEnCasa</h3>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					</div>
				</div>

			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	 <%@include file="footerKwx.html"%>
	 		  <br> <br>
 <script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aajN9AQK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
</body>
</html>