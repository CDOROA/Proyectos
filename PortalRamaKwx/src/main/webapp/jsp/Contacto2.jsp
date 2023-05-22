<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
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
	content="width=device-width, initial-scale=1.0,  minimum-scale=1.0"></meta>
		
		<!-- CODIGO PARA NO GUARDAR CACHE -->
		<meta http-equiv="Expires" content="-1">
    	<meta http-equiv="Cache-Control" content="no-cache">
    	<meta http-equiv="Pragma" content="no-cache">
<title>Corporación Química Automotriz, S.A. de C.V. (KWX)</title>
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
<link
	href="${pageContext.request.contextPath}/css/starter-template-6.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/starter-template.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-3.3.5.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jsContacto2.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
		
			function IniciaMapa()
			{
				 var latlng = new google.maps.LatLng(0 , 0);
				 var mapOptions=
				 {
					zoom: 17,
					center: latlng,
					mapTypeId: google.maps.MapTypeId.ROADMAP,
				 };
				 map = new google.maps.Map(document.getElementById('mi-mapa'), mapOptions);
				 setMarkers(map);
			}
			
			function setMarkers(map)
			{
				<c:forEach items="${listClientes}" var="clientes" >	
				
					var myLatLng = new google.maps.LatLng("${clientes.latitud}","${clientes.longitud}"); 
				 	var image = 
				 	{
					    url: "http://www.kwx.com.mx/image/imgKwx/kwx64.png",
					    scaledSize: new google.maps.Size(60, 60)
				  	};
				 	var marker = new google.maps.Marker
					({
						position: myLatLng,
						map: map,
						title: "${clientes.nombre}",
						icon:image 
					});
				 	var infowindow;
				 	var nombre_cte = "${clientes.nombre}";
				 	var direccion="${clientes.direccion}";
				 	var telefono="${clientes.telefono}";
				 	var correo="${clientes.correoElectronico}";
				 	
				 	(function(nombre_cte, direccion,telefono,correo, marker) 
					{
				 		google.maps.event.addListener(marker,'click',function() 
		 				{
				 			var contenido = '<div id="content" style="width:100%;" align="center">' +
				 								'<div class="col-md-12 col-sm-12">' +
														'<table>'+
															'<tr>'+
																'<td style="font-weight:bold; font-size:12px; color:#1D69AA;" align="center">'+
																	'<p>'+ nombre_cte +'</p>'+
																'</td>'+
															'</tr>'+
															'<tr>'+
																'<td style="font-weight:bold; font-size:12px; color:#9E9E9E;" align="center">'+
																	'<p>'+ direccion+'</p>'+
																'</td>'+
															'</tr>'+
															'<tr>'+
																'<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'+
																	'<p>Tel.: '+telefono+'</p>'+
																'</td>'+
															'</tr>'+
															'<tr>'+
															'<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'+
																'<p>Tel.: '+correo+'</p>'+
															'</td>'+
														'</tr>'+
													 '</table>'+
												'</div>'+
											 '</div>';												
				 			if (!infowindow) {
								infowindow = new google.maps.InfoWindow();
							}
							infowindow.setContent(contenido);
							infowindow.open(map, marker);			
							
		 				});
				 		
					})( nombre_cte, direccion,telefono,correo, marker);
				 	
				 	map.setCenter(marker.getPosition());
				 	
				</c:forEach>
				
			}
			
			google.maps.event.addDomListener(window, 'load', IniciaMapa);
			
			
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

<meta name="facebook-domain-verification"
	content="9dhqhgte50gycfbcmp5xom4o7is37v" />

</head>

<body style="background-color: #ffffff">

	<script>
		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
		
		  ga('create', 'UA-102151860-1', 'auto');
		  ga('send', 'pageview');
		</script>

	<div class="container-fluid"
		style="width: 100%; padding-left: 0px; padding-right: 0px;">


		<!--  Header  -->
		<%@include file="EncabezadoKwx.html"%>

		<div id="DivAceites"
			style="background-image:url('${pageContext.request.contextPath}/image/imgKwx/contacto-encabezado.png'); padding-right: 10px; padding-left: 10px; padding-bottom:10px;"
			class="jumbotron">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<h1
						style="color: white; font-style: bold; margin-top: 0px; margin-bottom: 5px;"
						class="pull-right">CONTACTO</h1>
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12">
					<p style="color: white; font-style: bold;"
						class="pull-right hidden-sm text-justify">
						¿Desea entrar en contacto con nosotros?</br> Envíenos un mensaje y en
						breve le </br> resolveremos sus dudas o inquietudes.
					</p>
				</div>
			</div>
		</div>

		<div class="container-fluid">
			<div class="row">
			<div class="col-lg-1 col-md-3 col-sm-12">
				</div>
			
				<div class="col-lg-2 col-md-3 col-sm-12">
				
				<div class="hovereffect-D">
						<img class="img-responsive" src="${pageContext.request.contextPath}/img/Boton_Acudir.jpg" alt="" style="height: 150px;display: inline-block; padding: 10px;"></img>
						<div class="overlay"> 
							<!--   <a class="info" href="${pageContext.request.contextPath}/ServletInicio?operacion=2"> -->
							<a class="info" href="${pageContext.request.contextPath}/ServletDondeComprar?operacion=1">
							 </a>
							
						 </div>
					</div>
				
				<div class="hovereffect-D">
						<img class="img-responsive" src="${pageContext.request.contextPath}/img/Boton_Online.jpg" alt="" style="height: 150px;display: inline-block; padding: 10px;"></img>
						<div class="overlay"> 
							<!--   <a class="info" href="${pageContext.request.contextPath}/ServletInicio?operacion=2"> -->
							<a class="info" href="${pageContext.request.contextPath}/CompraEnLinea?operacion=1">
							 </a>
							
						 </div>
					</div>
				
					<div class="hovereffect-D">
						<img class="img-responsive"
							src="${pageContext.request.contextPath}/img/Boton_QuieroSer.jpg"
							alt=""
							style="height: 150px; display: inline-block; padding: 10px;"></img>
						<div class="overlay">
							<a class="info"
								href="${pageContext.request.contextPath}/QuieroSerDistribuidor?operacion=1">
							</a>

						</div>
					</div>
				</div>
				
				<div class="col-lg-4 col-md-3 col-sm-12" style="padding-top: 75px;">
					<h4
						style="font-weight: bold; margin-bottom: 50px; margin-top: 10px; color: black; margin-bottom: 10px">
						<spam style="font-weight: bold;color: #ed2525;">*</spam>
						Campos obligatorios
					</h4>

					<div class="form-group form-group-lg">
					<div class="col-sm-4">
						<label class="control-label pull-right" for="txt_nombre_contacto"
							style="color: black;"><spam
								style="font-weight: bold;color: #ed2525;">*</spam>Nombre</label>
						</div>
						<div class="col-sm-8">
							<input class="form-control" type="text" id="txt_nombre_contacto">
						</div>
					</div>

					<div class="form-group form-group-lg">
					<div class="col-sm-4">
						<label class="control-label pull-right" for="txt_correo_contacto"
							style="color: black;"><spam
								style="font-weight: bold;color: #ed2525;">*</spam>Correo
							Electr&oacute;nico</label>
							</div>
						<div class="col-sm-8">
							<input class="form-control" type="text" id="txt_correo_contacto">
						</div>
					</div>
					<div class="form-group form-group-lg">
					<div class="col-sm-4">
						<label class="control-label pull-right" for="txt_whatsApp_contacto"
							style="color: black;"><spam
								style="font-weight: bold;color: #ed2525;">*</spam>WhatsApp</label>
								</div>
						<div class="col-sm-8">
							<input class="form-control" type="text"
								id="txt_whatsApp_contacto"
								onkeypress="return isNumberKey(event)">
						</div>
					</div>
					<div class="form-group form-group-lg">
					<div class="col-sm-4">
						<label class="control-label pull-right" for="txt_mensaje_contacto"
							style="color: black;"><spam
								style="font-weight: bold;color: #ed2525;">*</spam>Mensaje</label>
								</div>
						<div class="col-sm-8">
							<textarea class="form-control" type="text"
								id="txt_mensaje_contacto" cols="40" rows="5"></textarea>
						</div>
					</div>
					<div class="form-group form-group-lg">
						<input type="hidden" name="txtbase64Dist" id="txtbase64Dist"><input
							type="hidden" name="operacion" id="operacion" value="2">
						<button type="button" class="btn btn-default active"
							id="Btn_enviarContacto">Enviar</button>
						<button type="button" id="btn_esperaContacto" class="btn  btn-warning"
							style="display: none">
							<span
								class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span>
							Enviando, Espere...
						</button>
					</div>
				</div>
				<div class="col-lg-1 col-md-3 col-sm-12">
				</div>
				<div class="col-lg-4 col-md-3 col-sm-12" style="padding-top: 75px; display: inline-block;">
					<div id="mi-mapa" style="height: 375px; width: 420px; margin-top: 20px;"></div>
					<label class="col-sm-4 control-label"
						style="color: black; width: 420px; margin-top: 10px;">
						Ma&iacute;z No. 302. Col. Valle del Sur, C.P. 09819</br> Alcald&iacute;a Iztapalapa,
						Ciudad de M&eacute;xico, M&eacute;xico.</br> 55 5670 7593 - 55 5670 7563</br>atencionaclientes@kwx.com.mx
					</label>
				</div>
			</div>
		</div>

	</div>
	  <br> <br> <br>
	 <%@include file="footerKwx.html"%>
	 <br> <br>
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aajN9AQK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
</body>
</html>