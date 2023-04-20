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
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/img/headerFooter/Logotipo_OEP.png">

<!--  CSS BOOTSTRAP  y JQUERY-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-1.10.3.custom.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estilosGenerales.css">

<!--  JS BOOTSTRAP Y JQUERY -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/JS-PaginaPrincipal.js?version=1.0.0"></script>

<meta name="p:domain_verify" content="ac34d803e8cb8499b3a92dc280ae952e"/>
<script type="text/javascript">


	function normalImg(id) {
		$("#"+id).hide()   
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
fbq('init', '709549896512059');
fbq('track', 'PageView');
</script>
<noscript><img height="1" width="1" style="display:none"
src="https://www.facebook.com/tr?id=709549896512059&ev=PageView&noscript=1"
/></noscript>
<!-- End Meta Pixel Code -->
<meta name="facebook-domain-verification" content="o9oldq7df9bn1pvm1dukuiesm3jvwl" />

</head>
<!-- <body>-->
<body onload="InicioPaginaPRincipal();"> 
	<!--  Header  -->
	<%@include file="HeaderProductos.html"%>
	<!--  Footer  -->
	<%@include file="FooterProductos.html"%>

	<div id="contenedorPrincipal" class="container-fluid"
		style="padding-right: 0px; padding-left: 0px; margin-bottom: 85px;">

		<!--  Carousel  -->
		<div class="row" >  
			<div class="col-lg-12 col-md-12 col-sm12 col-xs-12">

				<div id="carouselExampleInterval" class="carousel slide"
					data-ride="carousel">
					<div class="carousel-inner">
						<c:forEach var="banner" items="${listaBanners}" varStatus="loop">
							<c:choose>
								<c:when test="${loop.index == 0}">
									<div class="carousel-item active"
										data-interval="${banner.duracion}">
										<img
											src="${pageContext.request.contextPath}/image/banners/${banner.imagen}"
											class="d-block w-100">
									</div>
								</c:when>
								<c:otherwise>

									<div class="carousel-item" data-interval="${banner.duracion}">
										<img
											src="${pageContext.request.contextPath}/image/banners/${banner.imagen}"
											class="d-block w-100">
									</div>

								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleInterval"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleInterval"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>


				<div id="carouselExampleSlidesOnly" class="carousel slide"
					data-ride="carousel">

					<div class="carousel-inner">
						<div class="carousel-item active">
							<img
								src="${pageContext.request.contextPath}/image/banners/Slogan.jpg"
								class="d-block w-100">
						</div>
					</div>
				</div>


				<div  id="panelBotonVideos" class="row" style="display:none">
					<div class=" col-xs-12 col-sm-12 col-md-12 col-lg-12"
						style="background-color: #F5F5F5; padding: 15px; display: table"
						>
						<table class="hovereffect-D hovereffect-D-Shadow"
							onclick="verDivSubmenu('panelVideos')"
							style="border: 1px solid #bfbfbf; border-radius: 18px;">
							<tbody>
								<tr>
									<td class="VideosbordeTd">
										<div style="width: 100%">
											<img src="https://i.ibb.co/DWRhy1J/3-VISIO-N.jpg"
												class="img-fluid" alt=""
												style="display: inline-block; padding: 10px; width: 350px; margin-top: 15px;">
										</div>
									</td>
								</tr>
								<tr>
									<td class="VideosbordeTd">
										<div style="width: 100%">
											<div class="VideosDivDescripcion" style="margin-top: 15px;">
												<label> VIDEOS </label>
											</div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>

				</div>

<%@include file="panelVideos.html"%>


			</div>
			<!-- col-lg-12 col-md-12 col-sm12 col-xs-12 -->
		</div>
		<!-- row -->
	</div>
	<!-- container-fluid -->
		<!-- Clarity tracking code for https://www.cdoautopartes.com.mx/ -->

  <script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_bGuXpAEK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
			
</body>
</html>