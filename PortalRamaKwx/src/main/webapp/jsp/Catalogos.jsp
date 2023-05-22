<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	href="${pageContext.request.contextPath}/css/starter-template.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/css/starter-template-5.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-3.3.5.js"></script>

<title>Catalogos</title>


<!-- Facebook Pixel Code -->
<script>

function abrirVideo(url_video)
{
	
	var scrollLeft = $(window).scrollLeft();
	
	var scrollTop = $(window).scrollTop();
	
	$("#etiquetaVideo").html("");
	let contenido = '<iframe name="frameVideo" id="frameVideo" src="'+url_video+'?autoplay=1" class="embed-responsive-item" controls="true" allowfullscreen="true"></iframe';
	//let contenido = '<video src="'+url_video+'" controls="true" style="width: 100%"></video>';

	//let contenido = '<iframe name="frameVideo" id="frameVideo" src="'+url_video+'" class="embed-responsive-item" controls="true" allowfullscreen="true"></iframe';
	
	$("#etiquetaVideo").html(contenido);
// 	$('#modalImagenes').modal('hide');
 
	$('#modalVideos').modal('toggle');
}

function abrirVideo2(url_video2)
{
	
	var scrollLeft2 = $(window).scrollLeft();
	
	var scrollTop2 = $(window).scrollTop();
	
	$("#etiquetaVideo2").html("");
	let contenido2 = '<iframe name="frameVideo2" id="frameVideo2" src="'+url_video2+'?autoplay=1" class="embed-responsive-item" controls="true" allowfullscreen="true"></iframe';
	
	$("#etiquetaVideo2").html(contenido2);
// 	$('#modalImagenes').modal('hide');
 
	$('#modalVideos2').modal('toggle');
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

<body>
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

	<div id="DivAceites"
		style="background-image:url(${pageContext.request.contextPath}/image/articulosKwx/CATALOGOS/Encabezado.jpg);padding-right: 127px;background-position: center;background-repeat: no-repeat;background-size: cover;">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12"
				style="padding-right: 0px;">
				<table width="98%">
					<tr>
						<td width="50%"></td>
						<td width="50%">
							<h1 style="color: white; font-style: bold; margin-bottom: 29px;" class="pull-right">CATÁLOGOS DIGITALES</h1>
						</td>
					</tr>
					<tr>
						<td width="50%"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>

</br></br></br>

		<div class="container-fluid">
			<div class="row">
				<div>
					<div class="hovereffect-D">
						<img class="img-responsive" src="${pageContext.request.contextPath}/image/articulosKwx/CATALOGOS/Boton_01.jpg" alt="" style="display: inline-block; padding: 10px; max-width: 285px" ></img>
<%-- 						<img class="img-responsive" src="${pageContext.request.contextPath}/img/headerFooter/logoHeader.png" alt="" style="display: inline-block; padding: 10px; max-width: 285px" ></img> --%>
						<div class="overlay" onclick="abrirVideo('https://guiarapida.kwx.com.mx/view/448735038/')"> 
<!-- 							<a class="info" href="https://guiarapida.kwx.com.mx/view/448735038/" target="popup" onclick="window.open(this.href, this.target, 'width=700px,height=750px'); return false;"> -->
<!-- 							</a> -->
						 </div>
					</div>
					<div class="hovereffect-D">
						<img class="img-responsive" src="${pageContext.request.contextPath}/image/articulosKwx/CATALOGOS/Boton_Guia_Kits.jpg" alt="" style="display: inline-block; padding: 10px; max-width: 285px" ></img>
<%-- 						<img class="img-responsive" src="${pageContext.request.contextPath}/img/headerFooter/logoHeader.png" alt="" style="display: inline-block; padding: 10px; max-width: 285px" ></img> --%>
						<div class="overlay" onclick="abrirVideo2('https://online.flippingbook.com/view/245415321/')"> 
<!-- 							<a class="info" href="https://guiarapida.kwx.com.mx/view/448735038/" target="popup" onclick="window.open(this.href, this.target, 'width=700px,height=750px'); return false;"> -->
<!-- 							</a> -->
						 </div>
					</div>
				</div>
			</div>
		</div>
		
		<br><br><br><br><br>
		 <%@include file="footerKwx.html"%>
<br> <br>
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aajN9AQK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>


<div class="modal fade bd-example-modal-lg "   tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" id="modalVideos" onclick="document.getElementById('frameVideo').src = '';">
  <button type="button" onclick="document.getElementById('frameVideo').src = '';" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true" style="font-size: 48px;color: white;" >&times;</span>
                    </button>
	<div class="modal-dialog	modal-lg" style="height: 67vh !important;" >
	
    	<div class="modal-content"  id="modalVideoContenido" style="height: 67vh !important;">
			<div class="modal-body" style="padding-right: 0px;padding-bottom: 0px;padding-top: 0px;padding-left: 0px; height: 67vh !important;">
					<div class="row">
						<div class="col-12 col-sm-12 col-md-12 col-lg-12 embed-responsive embed-responsive-16by9" id="etiquetaVideo" style="height: 67vh !important;">
						</div>
					</div>
   			</div>
    	</div>
	</div>
</div>

<div class="modal fade bd-example-modal-lg "   tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" id="modalVideos2" onclick="document.getElementById('frameVideo2').src = '';">
  <button type="button" onclick="document.getElementById('frameVideo2').src = '';" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true" style="font-size: 48px;color: white;" >&times;</span>
                    </button>
	<div class="modal-dialog	modal-lg" style="height: 67vh !important;" >
	
    	<div class="modal-content"  id="modalVideoContenido2" style="height: 67vh !important;">
			<div class="modal-body" style="padding-right: 0px;padding-bottom: 0px;padding-top: 0px;padding-left: 0px; height: 67vh !important;">
					<div class="row">
						<div class="col-12 col-sm-12 col-md-12 col-lg-12 embed-responsive embed-responsive-16by9" id="etiquetaVideo2" style="height: 67vh !important;">
						</div>
					</div>
   			</div>
    	</div>
	</div>
</div>

</body>
<script>

function saltarA(id, tiempo) {
	  var tiempo = tiempo || 1000;
	  $("html, body").animate({ scrollTop: $(id).offset().top }, tiempo);
	}	
	</script>
</html>