<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:h="http://java.sun.com/jsf/html">
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
	    <meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
		<meta name="viewport" content="width=device-width, initial-scale=1.0,  minimum-scale=1.0"></meta>
		
		<!-- CODIGO PARA NO GUARDAR CACHE -->
		<meta http-equiv="Expires" content="-1">
    	<meta http-equiv="Cache-Control" content="no-cache">
    	<meta http-equiv="Pragma" content="no-cache">
		
		
		<title>Corporación Química Automotriz, S.A. de C.V. (KWX)</title>
		 
		<!-- Bootstrap core CSS -->
    	<link href="${pageContext.request.contextPath}/css/bootstrap-3.3.5.min.css" rel="stylesheet" />
    	
    	<link href="${pageContext.request.contextPath}/css/starter-style.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/css/starter-template-sabiasque.css" rel="stylesheet" />
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
 		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-3.3.5.js"></script>
 		 <script  type="text/javascript" src="${pageContext.request.contextPath}/js/jquery1.11.4.js"></script>
 		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/jsBlogSabiasQue.js"></script>    
		<title>Insert title here</title>
	
		
		<script type="text/javascript">

		$(document).ready(function(){
		    $(".dropdown").on("show.bs.dropdown", function(event){
		        var x = $(event.relatedTarget).text(); // Get the button text
		        //alert("You clicked on: " + x);
		    });
		});
		
		function CargaImagenes(imagen, imagenAnterior)
		{
			var contextPath = "<%=request.getContextPath()%>"; 
			var img = document.getElementById("img_articulo");
			//var imgVideo= document.getElementById("imgVideo"); 
			var VideoBlog= document.getElementById("vid-1"); 
			var imgAnterior= document.getElementById("imgAnterior"); 
			img.src = contextPath + "/image/blogSabiasQue/" + imagen; 
			//imgVideo.src = imagenVideo; 
			//VideoBlog.src= urlVideo;
			imgAnterior.src = contextPath + "/image/blogSabiasQue/" + imagenAnterior;
		}
		
		function CargaBlogAnterior()
		{ 
			var id_blog =document.getElementById("lbIdBlock").innerText - 1;
			ObtieneBlogActivo(1,id_blog);
		}
		
		function cargarVideo(imagen)
		{
			/*var modal = document.getElementById('myModal');
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
			}*/
			//onload="ObtieneHistorialBlog(2)"
		};
		
		
		</script>
		
		<!-- Facebook Pixel Code -->

<!--
<script>
!function(f,b,e,v,n,t,s)
{if(f.fbq)return;n=f.fbq=function(){n.callMethod?
n.callMethod.apply(n,arguments):n.queue.push(arguments)};
if(!f._fbq)f._fbq=n;n.push=n;n.loaded=!0;n.version='2.0';
n.queue=[];t=b.createElement(e);t.async=!0;
t.src=v;s=b.getElementsByTagName(e)[0];
s.parentNode.insertBefore(t,s)}(window,document,'script',
'https://connect.facebook.net/en_US/fbevents.js');
fbq('init', '1677679685720148'); 
fbq('track', 'PageView');
</script>
-->
<noscript>
<img height="1" width="1" 
src="https://www.facebook.com/tr?id=1677679685720148&ev=PageView
&noscript=1"/>
</noscript>
<!-- End Facebook Pixel Code -->
		
	<meta name="facebook-domain-verification" content="iwxagmmck8vlpagd55qrtzt8rx6899" />	
		
	</head>
	
	<body class="bg-image-page" onload="ObtieneHistorialBlog(2)" >
		
		<script>
		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
		
		  ga('create', 'UA-102151860-1', 'auto');
		  ga('send', 'pageview');
		</script>	
	
		
		<div class="container-fluid" style="width: 100%; padding-left: 0px; padding-right: 0px; ">
		
	
             <!--  Header  -->
	         <%@include file="EncabezadoKwx.html"%>
		 	 
		 	<div id="DivAceites"style="background-image:url('${pageContext.request.contextPath}/image/imgKwx/sabiasQue-encabezado.png'); padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
				<div class="row">
					 <div class="col-lg-12 col-md-12 col-sm-12" style="padding-right:0px;">
						 <table width="98%">
						 	 <tr>
						 	 	 <td width="50%" style="vertical-align:top;">
								 </td>
								 <td width="50%" style="vertical-align:top;" align="right">
								 	<table>
										<tr>
											<td>
												<br>
												<h1 style="color:white;">LO QUE DEBE SABER</h1> </br>
											</td>
										</tr>
										<tr>
											<td>
												<p class="lead  hidden-ms hidden-xs" style="color: #FFFFFF;">Enterate de algunas curiosidades y datos interesantes.</p>
												
												<br>
											</td>
										</tr>
									</table>
								 </td>
						 	 </tr>
						 </table>
					 </div>
				</div>
			</div>
		 	 
		 	<div class="container-fluid">
		 		<div class="row">
		 		
		 			<div class="col-sm-9  blog-main">
		 				<div class="blog-post">
		 					  <h3 class="blog-title" style="color:#eb162e; font-weight: bold;">
		 					 	 	<label id="lbTitulo" class="blog-title"></label>
		 					  </h3>
		 					  <h4 class="blog-subtitle" style="color:#eb162e; font-weight: bold;">
		 					  		<label id="lbSubTitulo" class="blog-subtitle"></label>
		 					  </h4>
		 					  <label id="lbFecha" class="blog-post-meta"></label>
 					  		  <div id="divParrafoSuperior" style="width:100%" class="lead text-justify"> 					  		  
							  </div>
							  <div id="divImagen" style="width:100%" class="center" align="center">
 					  		  		<img id="img_articulo"  class="img-responsive" >
 					  		  		<br>
 					  		  		<br>
							  </div>
							  <div id="divParrafoInferior" style="width:100%" class="lead text-justify"> 					  		  
							  </div>
							  <br>
							  <br>
		 				</div>
		 			</div>
		 			
		 			 <div class="col-sm-3  blog-sidebar" >
		 			 
	 			 		<div class="sidebar-module sidebar-module-inset" style="width:100%; border-top: 1px solid #e5e5e5; align:center">
			            	<h4 style="color:#0867D4;">Publicaciones Recientes</h4>
							<a class="thumbnail" href="#" onclick="CargaBlogAnterior()" style="text-decoration:none;">
								<object data="${pageContext.request.contextPath}/img/mantenimiento.png" type="image/png">
									<img  id="imgAnterior"></img>
								</object>
								<div class="caption" >
									<font color="white"><label id="lbIdBlock" ></label></font>
									<label id="lbDescripcionAnterior" ></label>
								</div>
							</a>
						</div>
							
						 <!-- <div class="sidebar-module sidebar-module-inset" style="width:100%; border-top: 1px solid #e5e5e5">
								<h4 style="color:#0867D4;">Tambien te podría interesar</h4>
								<div>
									<a class="thumbnail" href="#" onclick="cargarVideo('vid-1')" style="text-decoration:none;">
										<img id="imgVideo" >
										<div class="caption">
											<label id="lbDescripcionVideo" ></label>
										</div>
									</a>
									<iframe id="vid-1"  style="display:none;"></iframe>
								</div>
				          </div> -->
				          
				         <div id="divHistorialBlog" style="align:left ; width:100%; overflow: auto;display;">
					      
					     </div>
				          
		 			 </div>
		 		</div>		 		
		 	</div>
		 	<div id="myModal" class="modal">
				  	<span class="close" onclick="document.getElementById('myModal').style.display='none'" >&times;</span>
					<div class="modal-content" >
						  <div class="embed-responsive embed-responsive-16by9">
							<iframe  class="embed-responsive-item" id="vid" allowfullscreen></iframe>
						  </div>
					 </div>
				</div>
		</div>
 
		 <%@include file="footerKwx.html"%>
	 		  <br/> <br/>
		 
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aajN9AQK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
	</body>
</html>