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
	href="${pageContext.request.contextPath}/css/CSS-Productos.css">
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
	src="${pageContext.request.contextPath}/js/JS-ProductosV2.js"></script>

	<!-- JS JSGRID -->
		<link rel='stylesheet prefetch' href="${pageContext.request.contextPath}/css/jsgrid.min.css"/> 
	    <link rel='stylesheet prefetch' href="${pageContext.request.contextPath}/css/jsgrid-theme.min.css"/> 
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jsgrid.js"></script> 
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jsgrid.min.js"></script>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/dataTables.bootstrap4.min.js"></script>
		<script type="text/javascript">
function bigImg(id) {
	$("#"+id).css('display','block') 
	}

	function normalImg(id) {
		$("#"+id).hide()   
	}   
</script>
</head>
<%int contador=0;%>
<c:if test="${modalAMostrar== '9'}">
	<% contador=9;%>
</c:if>
<body onload="RutinaInicioProductos(<%=contador%>)">
	<!--  Header  -->
	<%@include file="HeaderProductos.html"%>
	<!--  Footer  -->
	<%@include file="FooterProductos.html"%>

	
<!-- 	 <div class="container-fluid" style="display: flex;background-color: #f4323e;">  -->
	<div class="container-fluid" style="display: flex;background-color: black;">
	<div class="container" style="padding-left: 0px;padding-right: 0px;">
					<div class="col-lg-12 col-md-12 col-sm-12"
				style="margin-top: 5px;padding-right: 0px;padding-left: 0px;">
				<div class="form-inline">
					<table width=100% align="center"
						style="margin-right: 0px; margin-left: 0px;">
						<tr>
							<td align="left" width=97%><input
								onkeyup="consultaSugerencias(event)" id="txt_buscar_productos"
								type="text"
								placeholder="¿Qu&eacute; es lo que buscas? Ej.: Articulo Auto Modelo" class="focus-visible-only"
								style="font-family: Arial; font-size: 16px; border: 1px solid black; border-radius: 5px; width: 100%; padding: 4px"> 
							</td>
							<td width=3%><img
								src="${pageContext.request.contextPath}/img/productos/btnBuscarA.png"
								onclick="consultaArticulos()"
								style="height: 38px; cursor: pointer;"></td>

						</tr>
						<tr>
							<td colspan=2>
								<table id="tbSugerencias"
									style="background-color: #005CB0; font-family: arial; font-size: 12px; color: white;"
									width=100%></table>
							</td>
						</tr>
					</table>
				</div>
			</div>
	</div>
		</div>
	<div class="container-fluid" style="margin-bottom: 75px;">
		<div class="row d-flex justify-content-center ">
		</div>
		<div class="row">
		 	<div id="dondeComprarProductos" class="col-xl-1 col-lg-2 col-md-2 col-sm-12">
			
				<div class="row">
			  <div class="col-lg-12  col-md-12 col-sm-12">
                	<div class="hovereffect-D" style="margin-top: 25px;">
						<img class="img-fluid" src="${pageContext.request.contextPath}/img/dondeComprar/btnLinea.png" alt="" style="display: inline-block; padding: 10px; width: 150px"></img>
						<div class="overlay"> 
							<a class="info" href="${pageContext.request.contextPath}/CompraOnline">
							 </a>
						 </div>
					</div>
				</div>
				
				<div class="col-lg-12  col-md-12 col-sm-12">
					<div class="hovereffect-D" style="margin-top: 25px;">
						<img class="img-fluid" src="${pageContext.request.contextPath}/img/dondeComprar/btnDistribuidor.png" alt="" style="display: inline-block; padding: 10px; width: 150px"></img>
						<div class="overlay"> 
							<a class="info" href="${pageContext.request.contextPath}/ServletDondeComprar?operacion=1">
							 </a>
						 </div>
					</div>
				</div>
              
					<div class="col-lg-12  col-md-12 col-sm-12">
					<div class="hovereffect-D" style="margin-top: 25px;">
						<img class="img-fluid" src="${pageContext.request.contextPath}/img/dondeComprar/btnQuieroSer.png" alt="" style="display: inline-block; padding: 10px; width: 150px"></img>
						<div class="overlay"> 
							<a class="info" href="${pageContext.request.contextPath}/QuieroSerDistribuidor?operacion=1">
							 </a>
							
						 </div>
					</div>
				</div>
			</div>
			
			</div> 
			<div class="col-xl-11 col-lg-10 col-md-10 col-sm-12">
				<div id="div_ArticulosCarrito" class=" table-responsive container-fluid">
					<%@include file="menuProductos.html"%>
                </div>
			</div>
		</div>
	</div>


<div id="divGaleriaImagenes" style="display: none;" class="popupImagenes">
    <div class="content-popupImagenes" style="background-color: white">
    	<div class='row' style='padding: 10px; margin: 0; text-align: right;'>
    		<div  class=" col-12 col-sm-12 col-md-12 col-lg-12" style="text-align: right;">
    			<img src="${pageContext.request.contextPath}/img/productos/cerrar.png" onclick="OcultarDiv('divGaleriaImagenes')"></img>
    		</div>
    	</div>
    	<div class='conatiner-fluid' style='padding: 10px; margin: 0; text-align: center; border:1px solid #D3D3D3'>
    		<div class="row" style="margin-left: 15px;margin-right: 15px; margin-right: 25px;">
				<div id="modalImagen" class="col-xm-12  col-sm-6 col-md-5 col-lg-3 hovereffect-D-Shadow" style="border: 1px solid #bfbfbf;border-radius: 18px; margin-top: 0px;" ></div>
				<div id="modalDescripcion" class="col-xm-12  col-sm-6 col-md-7 col-lg-9 "></div>
			</div>
			<div class="row" style="margin-top: 25px; margin-left: 15px;margin-right: 15px;  margin-right: 25px;">
			<div class='col-12' style="display:none">
			<label class="EtiquetaUnderLineDetalle float-left">Aplicacion:</label>
			</div>
				<div class='col-lg-12' style="display:none">
					<div id="div_DetalleArticulos" class="table-responsive container-fluid" style="width: 100%; height: 250px"></div>
				</div>
			</div>
		</div>
	</div>
</div>
	<!-- MENSAJE DE ESPERA -->
	<%@include file="AlertaMensajeDeEspera.html"%>
<input type="hidden" name="listaArt" value="${parametrosPaginaInicio}" />
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_bGuXpAEK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
</body>