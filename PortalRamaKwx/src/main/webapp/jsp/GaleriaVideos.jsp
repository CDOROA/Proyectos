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
	    <!-- Bootstrap core CSS -->
	    <link href="${pageContext.request.contextPath}/css/bootstrap-3.3.5.min.css" rel="stylesheet" />
	    <link href="${pageContext.request.contextPath}/css/starter-style.css" rel="stylesheet" />
    	<link href="${pageContext.request.contextPath}/css/starter-template-7.css" rel="stylesheet" />
    	
    	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
		 <script  type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-3.3.5.js"></script>
    
		<title>Insert title here</title>
		
		<script type="text/javascript" >
 
			function cargar(imagen)
			{
				var modal = document.getElementById('myModal');
		
				var img = document.getElementById(imagen);
				var modalImg = document.getElementById("vid");
				    modal.style.display = "block";
					modal.style.zIndex = 99999;
					
					modalImg.src = img.src + "?autoplay=1";
				var span = document.getElementsByClassName("close")[0];
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
			 <nav class="navbar navbar-default  navbar-default-BTTM navbar-fixed-bottom">
			 	<div class="container-fluid">
			 		
			 		<a href="${pageContext.request.contextPath}/ServletInicio?operacion=1">
	 					<img class="img-responsive pull-left" style="height:40px; padding-top:10px; padding-right:10px; display:inline;" src="${pageContext.request.contextPath}/img/headerFooter/logokwxfooter.png"></img>
	 				</a>
					<img class="img-responsive pull-left" style="width:80px; height:40px; padding-top:10px; padding-right:10px; display:inline;" src="${pageContext.request.contextPath}/img/headerFooter/esr.png"></img>
					<img class="img-responsive pull-left" style="width:40px; height:40px; padding-top:10px; padding-right:10px; display:inline;" src="${pageContext.request.contextPath}/img/headerFooter/isologo.png"></img>
			 	
			 		<div id="footer" class="collapse navbar-collapse" >
						<ul class="nav navbar-nav navbar-right" >
							<li ><a href="https://www.facebook.com/kwxautomotriz/" target="_blank">
								<img src="${pageContext.request.contextPath}/img/headerFooter/facebookfooter.png"  class="img-responsive" style="width:24px;" ></img>
							</a>
							</li>
							<li >
							<a href="https://es.pinterest.com/kwxautomotriz/" target="_blank">
								<img src="${pageContext.request.contextPath}/img/headerFooter/pinterestfooter.png"  class="img-responsive" style="width:24px;" ></img>
							</a>
							</li>
							<li>
							<a href="https://www.youtube.com/channel/UCek61qopOCr8N2S_zRwhgBw" target="_blank" >
								<img src="${pageContext.request.contextPath}/img/headerFooter/youtubefooter.png"  class="img-responsive" style="width:24px;"></img>
							</a>
                            </li>
                             <li>
							<a href="https://www.instagram.com/kwx_automotriz" target="_blank" >
								<img src="${pageContext.request.contextPath}/img/headerFooter/botoInstagram.png"  class="img-responsive" style="width:24px;"></img>
							</a>
                            </li>
							<li><a class="hvr-sweep-to-right" href="#">Aviso de privacidad</a></li>
						</ul>
					</div>
			 	</div>
			 </nav>
			 			 
	<!--  Header  -->
	         <%@include file="EncabezadoKwx.html"%>
			 
			 <div class="row">
			 
			 	<div class="col-lg-12">
					<h1 class="page-header">Videos</h1>
			    </div>
			      
			    <div class="container-fluid" style="padding-left: 45px;padding-right: 45px;">
		   
					    <c:forEach items="${listVideos}" var="video" varStatus="status">
						<c:choose>
        					<c:when test="${status.index == 0}">
        						<div class="row">
	            					<div class="col-lg-4 col-md-4 col-sm4 col-xs-12">
									<a class="thumbnail" href="#" onclick="cargar('vid-${video.id_video}')" style="text-decoration:none;">
										<img src="${video.url_imagen}">
										<div class="caption">
											<h4>${video.descripcion}</h4>
										</div>
									</a>	
									<iframe id="vid-${video.id_video}" src="${video.url_video}" style="display:none;"></iframe>
									</div>
        					</c:when>
        					<c:otherwise>
								<c:choose>
								<c:when test="${status.index % 3 == 0}">
									</div>
									<div class="row">
										<div class="col-lg-4 col-md-4 col-sm4 col-xs-12">
										<a class="thumbnail" href="#" onclick="cargar('vid-${video.id_video}')" style="text-decoration:none;">
											<img src="${video.url_imagen}">
											<div class="caption">
												<h4>${video.descripcion}</h4>
											</div>
										</a>	
										<iframe id="vid-${video.id_video}" src="${video.url_video}" style="display:none;"></iframe>
										</div>
								</c:when>
								<c:otherwise>
										<div class="col-lg-4 col-md-4 col-sm4 col-xs-12">
										<a class="thumbnail" href="#" onclick="cargar('vid-${video.id_video}')" style="text-decoration:none;">
											<img src="${video.url_imagen}">
											<div class="caption">
												<h4>${video.descripcion}</h4>
											</div>
										</a>
										<iframe id="vid-${video.id_video}" src="${video.url_video}" style="display:none;"></iframe>
									</div>
								</c:otherwise>
								</c:choose>
							</c:otherwise>
    					</c:choose>
					    </c:forEach>
		    		</div>
				</div>
			    
			 </div>
			 <div id="myModal" class="modal">
			  	<span class="close" onclick="document.getElementById('myModal').style.display='none'">&times;</span>
				<div class="modal-content" >
					  <div class="embed-responsive embed-responsive-16by9">
						<iframe  class="embed-responsive-item" id="vid" allowfullscreen="true"></iframe>
					  </div>
				 </div>
			</div>
		</div>

<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aajN9AQK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
	</body>
</html>