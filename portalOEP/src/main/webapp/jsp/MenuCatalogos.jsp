<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0,  minimum-scale=1.0">
<title>OEP - Dale vida a tu auto</title>
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/headerFooter/Logotipo_OEP.png" >

<!--  CSS BOOTSTRAP  y JQUERY-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui-1.10.3.custom.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estilosGenerales.css">
	
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
<script  type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script> 
<script  type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script> 
<script  type="text/javascript" src="${pageContext.request.contextPath}/js/JS-catalogo.js"></script>
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
<body onload="InicioCatalogo();">

	<!--  Header  -->
	<%@include file="Header.html"%>
	<!--  Footer  -->
	<%@include file="Footer.html"%>
	
	
	<div class="" id="" style=""> 
			<div style="widows: 100%; height: 100%">
					<div class="hovereffect-D">
					<table style="width: 100%;">
					    <tbody>
					    	<tr>
						        <td>
						    		<img class="img-responsive" src="${pageContext.request.contextPath}/image/catalogos/catalogoMaster.png" alt="" style="display: inline-block; padding: 10px; max-width: 285px;display: inline-block;padding: 10px;max-width: 285px;" ></img>
						        </td>
						    </tr>
						    <tr>
						        <td>
						            <label style="font-size: 22px">Cátalogo Master</label>
						        </td>
						    </tr>
						</tbody>
					</table>									
			  
<%-- 						<img class="img-responsive" src="${pageContext.request.contextPath}/img/headerFooter/logoHeader.png" alt="" style="display: inline-block; padding: 10px; max-width: 285px" ></img> --%>
						<div class="overlay"  onclick="location.href='/Catalogo?catalogo=master'">  
<!-- 							<a class="info" href="https://guiarapida.kwx.com.mx/view/448735038/" target="popup" onclick="window.open(this.href, this.target, 'width=700px,height=750px'); return false;"> -->
<!-- 							</a> -->
						 </div>
					</div>
					<div class="hovereffect-D">
					<table style="width: 100%;">
					    <tbody>
					    	<tr>
						        <td>
						    		<img class="img-responsive" src="${pageContext.request.contextPath}/image/catalogos/catalogoEmbrague.png" alt="" style="display: inline-block; padding: 10px; max-width: 285px;display: inline-block;padding: 10px;max-width: 285px;" ></img>
						        </td>
						    </tr>
						    <tr>
						        <td>
						            <label style="font-size: 22px">Cátalogo Kit de Embrague</label>
						        </td>
						    </tr>
						</tbody>
					</table>					
						 
<%-- 						<img class="img-responsive" src="${pageContext.request.contextPath}/img/headerFooter/logoHeader.png" alt="" style="display: inline-block; padding: 10px; max-width: 285px" ></img> --%>
							<div class="overlay"onclick="location.href='/Catalogo?catalogo=embrague'"> 
<!-- 							<a class="info" href="https://guiarapida.kwx.com.mx/view/448735038/" target="popup" onclick="window.open(this.href, this.target, 'width=700px,height=750px'); return false;"> -->
<!-- 							</a> -->
						 </div>   
					</div> 
					<div class="hovereffect-D" style="padding-bottom: 100px;">
					<table style="width: 100%;">
					    <tbody>
					    	<tr>
						        <td>
 						    		<img class="img-responsive" src="${pageContext.request.contextPath}/image/catalogos/catalogoDipticoH.png" alt="" style="display: inline-block; padding: 10px; max-width: 285px;display: inline-block;padding: 10px;max-width: 285px;" ></img>
						        </td>
						    </tr>
						    <tr>
						        <td>
						            <label style="font-size: 22px">Díptico</label>  
						        </td>
						    </tr>
						</tbody>
					</table>					 
						   
<%-- 						<img class="img-responsive" src="${pageContext.request.contextPath}/img/headerFooter/logoHeader.png" alt="" style="display: inline-block; padding: 10px; max-width: 285px" ></img> --%>
						<div class="overlay" onclick="location.href='/Catalogo?catalogo=diptico'">    
<!-- 							<a class="info" href="https://guiarapida.kwx.com.mx/view/448735038/" target="popup" onclick="window.open(this.href, this.target, 'width=700px,height=750px'); return false;"> -->
<!-- 							</a> -->
						 </div>
					</div>
			</div>
			 
		</div>
     <script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_bGuXpAEK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
</body>
</body>
</html>