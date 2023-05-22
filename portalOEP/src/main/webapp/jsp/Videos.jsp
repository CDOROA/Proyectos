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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/CSS-videos.css">

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
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/JS-VIDEOS.js"></script>
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


<div class="container-fluid" style="margin-top: 25px;margin-bottom: 85px;"> 
	<div class="row justify-content-center"> 
	<c:forEach var="video" items="${listaVideos}">	
		<div class="col-12 col-sm-12 col-md-4 col-lg-3 " >
			<div style="margin-left: 10px; margin-right: 10px;" >
				   <table class="hovereffect-D hovereffect-D-Shadow" onclick="abrirVideo('${video.urlVideo}')" style="border: 1px solid #bfbfbf;border-radius: 18px;"> 
					<tbody>
						<tr>
							<td class="VideosbordeTd">
								<div style="width: 100%">
									<img src="${video.urlImagen}" class="img-fluid" alt="" style="display: inline-block; padding: 10px; width: 350px;margin-top: 15px;" >
								</div>
							</td>
						</tr>
						<tr>
							<td class="VideosbordeTd">
								<div style="width: 100%">
									<div  class="VideosDivDescripcion" style="margin-top: 15px;">
										<label>  ${video.descripcion} </label>
									</div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		</c:forEach>
	</div>
</div>

  <div class="modal fade bd-example-modal-lg "   tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" id="modalVideos" onclick="document.getElementById('frameVideo').src = '';">
  <button type="button" onclick="document.getElementById('frameVideo').src = '';" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true" style="font-size: 48px;color: white;" >&times;</span>
                    </button>
	<div class="modal-dialog	modal-lg" >
	
    	<div class="modal-content"  id="modalVideoContenido">
			<div class="modal-body" style="padding-right: 0px;padding-bottom: 0px;padding-top: 0px;padding-left: 0px;">
					<div class="row">
						<div class="col-12 col-sm-12 col-md-12 col-lg-12 embed-responsive embed-responsive-16by9" id="etiquetaVideo">
						</div>
					</div>
   			</div>
    	</div>
	</div>
</div>  
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_bGuXpAEK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
</body>