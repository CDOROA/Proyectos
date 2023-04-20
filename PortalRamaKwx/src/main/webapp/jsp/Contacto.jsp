<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html  xmlns="http://www.w3.org/1999/xhtml">
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
		<meta name="viewport" content="width=device-width, initial-scale=1.0,  minimum-scale=1.0"></meta>
		<!-- CODIGO PARA NO GUARDAR CACHE -->
		<meta http-equiv="Expires" content="-1">
    	<meta http-equiv="Cache-Control" content="no-cache">
    	<meta http-equiv="Pragma" content="no-cache">
    	
		<title>Corporación Química Automotriz, S.A. de C.V. (KWX)</title>
		<!--Mapa-->
		<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD3pAWctAaHoIRhTERJ1N3lQ_0TZe7tCqY"></script>
		
		
		 <!-- Bootstrap core CSS -->
	    <link href="${pageContext.request.contextPath}/css/bootstrap-3.3.5.min.css" rel="stylesheet" />
	    
	    <!-- Custom styles for this template Aqui estilos propios -->
		<link href="${pageContext.request.contextPath}/css/starter-style.css" rel="stylesheet" />
	    <link href="${pageContext.request.contextPath}/css/starter-template-6.css" rel="stylesheet" />
    	
    	
    	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
		 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
		 <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-3.3.5.js"></script>
		 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jsContacto.js"></script>
		<title>Insert title here</title>
		
		<script type="text/javascript">
		
			function IniciaMapa()
			{
				 var latlng = new google.maps.LatLng(0 , 0);
				 var mapOptions=
				 {
					zoom: 12,
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
		
		<meta name="facebook-domain-verification" content="iwxagmmck8vlpagd55qrtzt8rx6899" />
		
	</head>
	
	<body  style="background-color:#F1F5F8">
	
		<script>
		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
		
		  ga('create', 'UA-102151860-1', 'auto');
		  ga('send', 'pageview');
		</script>	
	
		<div class="container-fluid" style="width: 100%; padding-left: 0px; padding-right: 0px;"> 
			
	
			
		<!--  Header  -->
	         <%@include file="EncabezadoKwx.html"%>
	 		
	 		<div id="DivAceites" style="background-image:url('${pageContext.request.contextPath}/image/imgKwx/contacto-encabezado.png'); padding-right: 10px; padding-left: 10px; padding-bottom:10px;" class="jumbotron">
				<div class="row" >
					<div class="col-lg-12 col-md-12 col-sm-12">
						<h1 style="color:white; font-style:bold;" class="pull-right">CONTACTO</h1> 
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<p style="color:white; font-style:bold;" class="pull-right hidden-sm text-justify">
							¿Desea entrar en contacto con nosotros?</br>
							Envíenos un mensaje y en breve le </br>
							resolveremos sus dudas o inquietudes.
						</p> 
					</div>
				</div>
		    </div>
		    <div class="row">
		    	<div class="col-md-12">
					<table width="100%">
						<tr>
							<td width="50%" style="padding-left: 15px; padding-right: 15px;" valign="top">
								<form>
									<div class="form-group" style="width:100%;">
										<div class="col-md-6">
											<input style="width:100%;" type="text" id="txtNombre" name="txtNombre" placeholder="Nombre" class="form-control mi-input mi-input" ></input>										
										</div>
										<div class="col-md-3">										
											<input  type="text" id="txtPais"  name="txtPais" placeholder="País" class="form-control mi-input" ></input>								
										</div>
										<div class="col-md-3">
											<input  type="text" id="txtCiudad" name="txtCiudad" placeholder="Ciudad" class="form-control mi-input" ></input>	
										</div>
										<div class="col-md-6">
											<input  type="text" id="txtCalle" name="txtCalle" placeholder="Calle" class="form-control mi-input" ></input>
										</div>
										<div class="col-md-3">
											<input  type="text" id="txtNumInt"  name="txtNumInt" maxlength="5" placeholder="Núm Int." class="form-control mi-input" onkeypress="return isNumberKey(event)"></input>	
										</div>
										<div class="col-md-3">
											<input  type="text" id="txtNumExt" name="txtNumExt" maxlength="5" placeholder="Núm Ext." class="form-control mi-input" onkeypress="return isNumberKey(event)"></input>	
										</div>
										<div class="col-md-6">
											<input  type="text" id="txtColonia" name="txtColonia" placeholder="Colonia" class="form-control mi-input" ></input>
										</div>
										<div class="col-md-6">
											<input  type="text" id="txtDelegacion" name="txtDelegacion" placeholder="Delegación o Municipio" class="form-control mi-input" ></input>
										</div>
										<div class="col-md-3">
											<input   type="text" id="txtCp"  name="txtCp" maxlength="5" placeholder="C.P." class="form-control mi-input" onkeypress="return isNumberKey(event)"></input>	
										</div>
										<div class="col-md-3">
											<input   type="text" id="txtLada" name="txtLada" maxlength="4" placeholder="Lada" class="form-control mi-input" onkeypress="return isNumberKey(event)"></input>
										</div>
										<div class="col-md-3">
											<input  type="text" id="txtTelefono"  name="txtTelefono" maxlength="15" placeholder="Teléfono" class="form-control mi-input" onkeypress="return isNumberKey(event)"></input>
										</div>
										<div class="col-md-3">											
											<input  type="text" id="txtCelular"  name="txtTelefono" maxlength="15" placeholder="Celular" class="form-control mi-input" onkeypress="return isNumberKey(event)"></input>
										</div>
										<div class="col-md-12">
											<input  type="text" id="txtCorreo"  name="txtCorreo"  placeholder="Correo Electrónico" class="form-control mi-input" ></input>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12">
											<textarea  name="txtMessage" id="txtMessage"  placeholder="Mensaje" class="contact-message form-control mi-input"  rows="7"></textarea></input>
										</div>
									</div>
									<div class="form-group pull-right">
										<div class="col-md-12">
											<div class="btn-group btn-img2">
												<button id="btn_enviar" type="button" class="btn btn-default">
													Enviar 
												</button>
											</div>
										</div>
									</div>
								</form>
							</td>
						</tr>
		    		</table>
		    	</div>
		    	<div class="col-md-12">
					<table width="100%">
						<tr>
							<td>
								<table width="100%">
									<tr style="background-color:#495565;" align="center" valign="center">
										<td>
										<p class="pull-right" style="color:#FFEB3B; font-weight: bold; margin-top: 10px; margin-bottom:10px;" >CORPORACIÓN QUÍMICA AUTOMOTRIZ S.A. DE C.V.</p>
										</td>
										<td >
											<p class="pull-left" style="color:#ffffff; font-weight: bold;  margin-top: 10px; margin-bottom:10px;" >&nbsp;&nbsp;Maíz No. 302 col. Valle del Sur, C.P. 09819, CDMX.</p>
										</td>
									</tr>
									<tr style="color:#FFFFFF;background-color:#3176c7; font-weight: bold; font-size:10pt;" align="center" valign="center">
										<td colspan="2" >
										<p style="color:#FFFFFF; font-weight: bold;  margin-top: 10px; margin-bottom:10px;" >Tel: (0155) 5670 7593, (0155) 5670 7563 &nbsp;&nbsp;&nbsp;&nbsp; atencionaclientes@kwx.com.mx
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="https://www.facebook.com/kwxautomotriz/" target="_blank" style="color:#FFFFFF;">
												<img src="${pageContext.request.contextPath}/img/headerFooter/facebookfooter.png"   style="width:24px;" >
												/kwxautomotriz
											</a>
											<a href="https://es.pinterest.com/kwxautomotriz/" target="_blank" style="color:#FFFFFF;">
												<img src="${pageContext.request.contextPath}/img/headerFooter/pinterestfooter.png"  style="width:24px;" >
												/kwxautomotriz
											</a>
											<a href="https://www.youtube.com/channel/UCek61qopOCr8N2S_zRwhgBw" target="_blank" style="color:#FFFFFF;" >
												<img src="${pageContext.request.contextPath}/img/headerFooter/youtubefooter.png"   style="width:24px;">
												/KWX Automotriz
											</a>	
										</p>
										</td>
									</tr>
									<tr>
										<td colspan="2" style="background-color:#495565;" align="center">
										<div id="mi-mapa" style="width:100%; height: 300px;" ></div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
		    		</table>
		    	</div>
		    
		    
		    
		    </div>
		</div>
		<br> <br> <br>
		 <%@include file="footerKwx.html"%>
	 		  
		<br> <br> <br>
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aajN9AQK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
	</body>
</html>