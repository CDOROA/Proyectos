<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
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
		<meta name="viewport" content="width=device-width, initial-scale=1.0,  minimum-scale=1.0">
		<!-- CODIGO PARA NO GUARDAR CACHE -->
		<meta http-equiv="Expires" content="-1">
    	<meta http-equiv="Cache-Control" content="no-cache">
    	<meta http-equiv="Pragma" content="no-cache">
		<title>Corporación Química Automotriz, S.A. de C.V. (KWX)</title>
		<meta name="p:domain_verify" content="e477c43a1fc711e6af1077223f15d1c6"/>
		 <link href="${pageContext.request.contextPath}/css/bootstrap-3.3.5.min.css" rel="stylesheet" />		
		 <link href="${pageContext.request.contextPath}/css/starter-style.css" rel="stylesheet" />
    	<link href="${pageContext.request.contextPath}/css/starter-template-producto-mes.css" rel="stylesheet" />
    	
    	
    	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
    	<script  type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-3.3.5.js"></script>
		<title>Insert title here</title>
		
		<script type="text/javascript" >
 
			function cargar(imagen)
				{
				
				// Get the modal
				var modal = document.getElementById('myModal');
		
				// Get the image and insert it inside the modal - use its "alt" text as a caption
				var img = document.getElementById(imagen);
				var modalImg = document.getElementById("vid");
			   // alert(img.src);
				    modal.style.display = "block";
					modal.style.zIndex = 99999;
					
					modalImg.src = img.src + "?autoplay=1";
				
				/*img.onclick = function(){
					modal.style.display = "block";
					modal.style.zIndex = 99999;
					modalImg.src = this.src;
		
				}*/
		
				// Get the <span> element that closes the modal
				var span = document.getElementsByClassName("close")[0];
		
				// When the user clicks on <span> (x), close the modal
				span.onclick = function() {
				    modalImg.src = "";
					modal.style.display = "none";
					modal.style.zIndex = 1;
				}
			};
		
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
	
	<body class="bg-image-page">
	
		<script>
		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
		
		  ga('create', 'UA-102151860-1', 'auto');
		  ga('send', 'pageview');
		</script>	
	
		<div class="container-fluid"> 

			
	<!--  Header  -->
	         <%@include file="EncabezadoKwx.html"%>
			
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 thumb">
				<div class="thumbnail" align="center">
					<img src="${pageContext.request.contextPath}/image/imgKwx/productoDelMes.png"  width=100%></img>
					<div class="caption" style="font-style:none;color:#0867D4;">
						<!-- <h3 class="text-justify lead">
								${productoMes}
							 </br>
							 </br>
						</h3>-->
					</div>
				</div>
			</div>
		</div>
	 		  <br> <br> <br>
		 <%@include file="footerKwx.html"%>

		<br> <br> <br>
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aajN9AQK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
	</body>
</html>