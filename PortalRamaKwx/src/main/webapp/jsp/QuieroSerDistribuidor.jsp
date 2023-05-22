<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
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

<!-- Funciones JavaScript -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-3.3.5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jsQueriSerDistribuidor.js"></script>

<title>¿Donde Comprar?</title>


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

<body onload="asignacionInicialDist()">
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
		style="background-image:url('${pageContext.request.contextPath}/image/imgKwx/dondeComprar-encabezado.png');padding-right: 25px;background-position: center;background-repeat: no-repeat;background-size: cover;">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12"
				style="padding-right: 0px;">
				<table width="98%">
					<tr>
						<td width="50%"></td>
						<td width="50%">
							<h1 style="color: white; font-style: bold;" class="pull-right">¿DÓNDE
								COMPRAR?</h1>
						</td>
					</tr>
					<tr>
						<td width="50%"></td>
						<td width="50%" class="pull-right">
							<h4 class="pull-right">
								<span class="glyphicon glyphicon-asterisk"></span>
								Distribuidores Autorizados
							</h4>
							<h4 class="pull-right">
								<span class="glyphicon glyphicon-asterisk"></span> Puntos de
								Venta
							</h4>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2 col-md-3 col-sm-12">
				<img class="img-responsive" src="${pageContext.request.contextPath}/img/Encabezados_QuieroSer.jpg" alt="" style="display: inline-block; padding: 10px;max-width: 350px;"></img>
			</div>
			<div class="col-lg-1 col-md-3 col-sm-12">
			</div>						
			<div class="col-lg-5 col-md-3 col-sm-12">
				<h3 style="font-weight: bold; color: black;">
					Gracias por tu inter&eacute;s en la marca
					<spam style="font-weight: bold;color: #ed2525;">KWX</spam></br>
                    Completa el Siguiente formulario y a la brevedad nos pondremos 
                    en contacto contigo para dar seguimiento y resolver tus dudas.
				</h3>
				</br>
				<h4 style="font-weight: bold; margin-bottom: 50px; margin-top: 45px; color: black; margin-bottom: 0px">
					<spam style="font-weight: bold;color: #ed2525;">*</spam>
                    Campos obligatorios
				</h4>
				
					<div class="form-group form-group-lg">
					<table width="100%">
					<tr>
					<td style="float: right;">
						<label class="control-label" for="txt_distribuidor_nombre_negocio" style="color: black;"><spam style="font-weight: bold;color: #ed2525;">*</spam>Nombre del Negocio</label>
						</td>
						<td>
						<div class="col-sm-12">
							<input class="form-control" type="text" id="txt_distribuidor_nombre_negocio" >
					    </div>
					    </td>
					    </tr>
<tr>
					<td style="float: right;">
					 
						<label class="control-label" for="txt_distribuidor_giro" style="color: black;"><spam style="font-weight: bold;color: #ed2525;">*</spam>Giro del Negocio</label>
						</td>
						<td>
						<div class="col-sm-12">
							<input class="form-control" type="text" id="txt_distribuidor_giro" >
					    </div>
					    </td>
					    </tr>
					<tr>
					<td style="float: right;">
						<label class="control-label" for="txt_distribuidor_nombre_contacto" style="color: black;"><spam style="font-weight: bold;color: #ed2525;">*</spam>Nombre del contacto</label>
						</td>
						<td>
						<div class="col-sm-12">
							<input class="form-control" type="text" id="txt_distribuidor_nombre_contacto" >
					    </div>
					</td>
					    </tr>
					<tr>
					<td style="float: right;">
						<label class="control-label" for="txt_distribuidor_puesto" style="color: black;"><spam style="font-weight: bold;color: #ed2525;">*</spam>Puesto</label>
						</td>
						<td>
						<div class="col-sm-12">
							<input class="form-control" type="text" id="txt_distribuidor_puesto" >
					    </div>
					</td>
					    </tr>
					<tr>
					<td style="float: right;">
						<label class="control-label" for="txt_distribuidor_correo" style="color: black;"><spam style="font-weight: bold;color: #ed2525;">*</spam>Correo Electr&oacute;nico</label>
						</td>
						<td>
						<div class="col-sm-12">
							<input class="form-control" type="text" id="txt_distribuidor_correo" >
					    </div>
					</td>
					    </tr>
					<tr>
					<td style="float: right;">
						<label class="control-label" for="txt_distribuidor_whatsApp" style="color: black;"><spam style="font-weight: bold;color: #ed2525;">*</spam>WhatsApp</label>
						</td>
						<td>
						<div class="col-sm-12">
							<input class="form-control" type="text" id="txt_distribuidor_whatsApp" onkeypress="return isNumberKey(event)">
					    </div>
					</td>
					    </tr>
					<tr>
					<td colspan="2">
					
					<h4 style="font-weight: bold; margin-bottom: 50px; margin-top: 45px; color: black; margin-bottom: 0px">
					Ubicaci&oacute;n del negocio</h4>
					</td>
					</tr>
					
					<tr>
					<td style="float: right;">
						<label class="control-label" for="cmb_distribuidor_Pais" style="color: black;"><spam style="font-weight: bold;color: #ed2525;">*</spam>Pais</label>
						</td>
						<td>
						<div class="col-sm-12">
							<select name="cmb_distribuidor_Pais" id="cmb_distribuidor_Pais" class="form-control">
								<option value="0" selected="selected">- - - - -</option>
									<c:forEach var="PaisDist" items="${listaPais}">
										<option value="${PaisDist.idPais}">${PaisDist.descripcionPais}</option>
									</c:forEach>
							</select>
					    </div>
					</td>
					    </tr>
					<tr>
					<td style="float: right;">
						<label class="control-label" for="txt_distribuidor_Estado" style="color: black;"><spam style="font-weight: bold;color: #ed2525;">*</spam>Estado</label>
						</td>
						<td>
						<div class="col-sm-12">
							<select name="cmb_distribuidor_Estado" id="cmb_distribuidor_Estado" class="form-control">
								<option value="0" selected="selected">- - - - -</option>
									<c:forEach var="estadoDist" items="${listEstadosDistribuidor}">
										<option value="${estadoDist.cve_estado}">${estadoDist.descripcion}</option>
									</c:forEach>
							</select>
					    </div>
					</td>
					    </tr>
					<tr>
					<td style="float: right;">
						<label class="control-label" for="cmb_distribuidor_municipio" style="color: black;"><spam style="font-weight: bold;color: #ed2525;">*</spam>Alcald&iacute;a o Municipio</label>
						</td>
						<td>
						<div class="col-sm-12">
						<select name="cmb_distribuidor_municipio" id="cmb_distribuidor_municipio" class="form-control">
								<option value="" selected="selected">- - - - -</option>
									<%-- <c:forEach var="municipiosDist" items="${listMunicipiosDistribuidor}">
										<option value="${municipiosDist.cve_estado}">${municipiosDist.descripcion}</option>
									</c:forEach> --%>
							</select>
					    </div>
				</td>
					    </tr>
					<tr>
					<td style="float: right;">
						<label class="control-label" for="txt_distribuidor_codigo_postal" style="color: black;"><spam style="font-weight: bold;color: #ed2525;">*</spam>C&oacute;digo Postal</label>
						</td>
						<td>
						<div class="col-sm-12">
							<input class="form-control" type="text" id="txt_distribuidor_codigo_postal" >
					    </div>
					</td>
					    </tr>
					<tr>
					<td style="float: right;">
						<label class="control-label" for="txt_distribuidor_codigo_postal" style="color: black;"><spam style="font-weight: bold;color: #ed2525;">*</spam>Fotografia del negocio</label>
						</td>
						<td>
						<div class="col-sm-12">
						<form class="form-horizontal" method="post" enctype="multipart/form-data" id="formEnviarFotoDistribuidor">
								<input type="file" style="margin-bottom: 0px;" accept="image/*" class="form-control" id="fileUpDist" name="fileUpDist" /> <label
								for="fileUpDist" class="pull-right" style="color: #000000;" >Tamaño máximo de la
								imagen 2MB, en formato .jpg o .png.</label>
								</form>
					    </div>
					</td>
					</tr>
					<tr>
					<td colspan="2">
					<div class="form-group form-group-lg">
						<input type="hidden" name="txtbase64Dist" id="txtbase64Dist" >
             			<input type="hidden" name="operacion" id="operacion" value="2">
						<button type="button" class="btn btn-default active" id="Btn_enviarDist">Enviar</button>
						<button type="button" id="btn_esperaDist" class="btn btn-warning"
							style="display: none">
							<span
								class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span>Enviando,
							Espere...
						</button>
					</div>
					</td>
					</tr>
					</table>
				
				</br></br></br></br>
			</div>
		</div>
	</div>
	</div>
		 		  <br> <br> <br>
	 <%@include file="footerKwx.html"%>

<br> <br>
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aajN9AQK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
</body>
<script>

function saltarA(id, tiempo) {
	  var tiempo = tiempo || 1000;
	  $("html, body").animate({ scrollTop: $(id).offset().top }, tiempo);
	}	
	</script>
</html>