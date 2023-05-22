<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<div class="container-fluid" style="padding-top: 25px">
		<div class="row">
			<div class="col-12 ">
				<label class="h1 EtiquetaUnderLine">ACUDE CON TU DISTRIBUIDOR</label> <br>
			</div>
			<div class="col-12">
			<div class="align-self-baseline">			
				 <img src="${pageContext.request.contextPath}/img/distCercano/distCercano.png" style="max-width:75px; margin-bottom: 32px;" > 
				<label class="h1 Etiqueta" >Te canalizamos al <spam style="color: #CC303B;"> m&aacute;s cercano</spam></label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6  col-md-12 col-sm-12">
				<a href="https://wa.me/message/GFGEO5Z4CB73B1" target="_blank">
					<div class="hovereffect-D">

						<img class="img-fluid"
							src="${pageContext.request.contextPath}/img/distCercano/btnDistCercanoWhatsApp.png"
							alt=""
							style="display: inline-block; padding: 10px; width: 485px"></img>
						<div class="overlay"></div>
					</div>
				</a>
			</div>

			<div class="col-lg-6  col-md-12 col-sm-12">
				<a href="https://t.me/OEP_Autopartes" target="_blank">
					<div class="hovereffect-D">

						<img class="img-fluid"
							src="${pageContext.request.contextPath}/img/distCercano/btnDistCercanoTelegram.png"
							alt=""
							style="display: inline-block; padding: 10px; width: 485px"></img>
						<div class="overlay"></div>
					</div>
				</a>
			</div>
		</div>
	</div>
	<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_bGuXpAEK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
</body>
</html>