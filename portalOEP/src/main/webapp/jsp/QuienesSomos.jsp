<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,  minimum-scale=1.0">
<title>OEP - Dale vida a tu auto</title>
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/headerFooter/Logotipo_OEP.png" >

<!--  CSS BOOTSTRAP  y JQUERY-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-1.10.3.custom.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilosGenerales.css">

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
fbq('init', '709549896512059');
fbq('track', 'PageView');
</script>
<noscript><img height="1" width="1" style="display:none"
src="https://www.facebook.com/tr?id=709549896512059&ev=PageView&noscript=1"
/></noscript>
<!-- End Meta Pixel Code -->
<meta name="facebook-domain-verification" content="o9oldq7df9bn1pvm1dukuiesm3jvwl" />

<!--  JS BOOTSTRAP Y JQUERY -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	<script type="text/javascript">
function bigImg(id) {
	$("#"+id).css('display','block') 
	}

	function normalImg(id) {
		$("#"+id).hide()   
	}   
</script>
</head>

<body>
	<!--  Header  -->
	<%@include file="Header.html"%>
	<!--  Footer  -->
	<%@include file="Footer.html"%>
	<!-- MENSAJE DE ESPERA -->
	<%@include file="AlertaMensajeDeEspera.html"%>

			<div class="container-fluid" style="padding-top: 25px; margin-bottom: 85px;">
			<div class="row" style="margin-top: 28px;">
				<div class="col-2">
					<label class="h1 EtiquetaUnderLineNosotros" >NOSOTROS</label>	
				</div>
			</div>
			<div class="row" style="margin-top: 28px;">
				<div class="col-lg-2 col-md-4 col-sm-6 col-12" style="margin-top: 10px;">
					<img class="img-fluid hovereffect-D-Shadow float-right" src="${pageContext.request.contextPath}/image/nosotros/QUIENES-SOMOS.jpg" alt="" style="width: 350px;"></img>
				</div>
				<div class="col-lg-10 col-md-8 col-sm-6 col-12"  style="margin-top: 10px;">
					 
					<label class="h2 EtiquetaUnderLineNosotros" >¿QUIÉNES SOMOS?</label>	
					<p class="h4 text-justify font-weight-normal ">Somos una empresa con presencia a nivel nacional y respaldo de m&aacute;s de 20 años en el mercado automotriz. OEP es una marca de autopartes de repuesto para veh&iacute;culos comerciales.</p>
				</div>
			</div>
		
		<div class="row" style="margin-top: 28px;">
				<div class="col-lg-2 col-md-4 col-sm-6 col-12"  style="margin-top: 10px;">
					<img class="img-fluid hovereffect-D-Shadow float-right" src="${pageContext.request.contextPath}/image/nosotros/MISION.jpg" alt="" style="width: 350px;"></img>
				</div>
				<div class="col-lg-10 col-md-8 col-sm-6 col-12"  style="margin-top: 10px;">
					<label class="h2 EtiquetaUnderLineNosotros" >MISI&Oacute;N </label>
					<p class="h4 text-justify font-weight-normal "> Satisfacer las necesidades de autopartes de nuestros clientes, proporcion&aacute;ndoles el mejor surtido, precio, servicio, calidad y garant&iacute;a con personal capacitado y motivado para atender al cliente con el gusto. </p>
				</div>
			</div>
			
			<div class="row" style="margin-top: 28px;">
				<div class="col-lg-2 col-md-4 col-sm-6 col-12"  style="margin-top: 10px;">
					<img class="img-fluid hovereffect-D-Shadow float-right" src="${pageContext.request.contextPath}/image/nosotros/VISION.jpg" alt="" style="width: 350px;"></img>
				</div>
				<div class="col-lg-10 col-md-8 col-sm-6 col-12"  style="margin-top: 10px;">
					<label class="h2 EtiquetaUnderLineNosotros" > VISI&Oacute;N </label>
					<p class="h4 text-justify font-weight-normal "> Ser la empresa l&iacute;der en la venta de autopartes, reconocida por su capacidad de surtirlas, con calidad garantizada en cualquier poblaci&oacute;n del pa&iacute;s, con el mejor tiempo de respuesta y la mejor relaci&oacute;n de precio-servicio.</p>
				</div>
			</div>
			</div>
	<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_bGuXpAEK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
</body>