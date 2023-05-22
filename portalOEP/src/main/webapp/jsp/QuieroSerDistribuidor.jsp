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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/JS-QuieroSerDist.js"></script>
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
			<div class="col-12">
				<label class="h1 EtiquetaUnderLine">QUIERO SER DISTRIBUIDOR</label><br>
			</div>
						<div class="col-12">
			<div class="align-self-baseline">			
				 <img src="${pageContext.request.contextPath}/img/quieroSerDist/QuieroSerDistribuidor.png" style="max-width:100px; margin-bottom: 32px;" > 
				<label class="h1 Etiqueta" >Mayorista <spam style="color: #CC303B;"> Exclusivo</spam></label>
				</div>
			</div>
		</div>
		</div>
		
		
		
		<div class="row">

			<div class="col-lg-4  col-md-12 col-sm-12">
				<div class="hovereffect-D" data-toggle="modal"
					data-target="#modalDist">
					<img class="img-fluid"
						src="${pageContext.request.contextPath}/img/quieroSerDist/QuieroSerCorreo.png"
						alt=""
						style="display: inline-block; padding: 10px; width: 285px"></img>
					<div class="overlay"></div>
				</div>
			</div>
			<div class="col-lg-4  col-md-12 col-sm-12">
				<a href="https://wa.me/message/GFGEO5Z4CB73B1" target="_blank">
					<div class="hovereffect-D">
						<img class="img-fluid"
							src="${pageContext.request.contextPath}/img/quieroSerDist/QuieroSerWhatsApp.png"
							alt=""
							style="display: inline-block; padding: 10px; width: 285px"></img>
						<div class="overlay"></div>
					</div>
				</a>
			</div>
			<div class="col-lg-4  col-md-12 col-sm-12">
				<a href="https://t.me/OEP_Autopartes" target="_blank">
					<div class="hovereffect-D">
						<img class="img-fluid"
							src="${pageContext.request.contextPath}/img/quieroSerDist/QuieroSerTelegram.png"
							alt=""
							style="display: inline-block; padding: 10px; width: 285px"></img>
						<div class="overlay"></div>
					</div>
				</a>
			</div>
		</div>
	</div>

	<div id= "modalDist" class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Quiero ser Distribuidor</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="col-12">
					
						<div class="form-group form-group-lg">
					<div class="col-12">
								<label class="control-label pull-right" 
									for="txt_nombre_contacto" style="color: black; margin-bottom: 0px;"><spam
										style="font-weight: bold;color: #ed2525;">*</spam>Nombre</label>
							</div>
							<div class="col-12">
								<input class="form-control" type="text" id="txt_nombre_contacto">
							</div>
						</div>

						<div class="form-group form-group-lg">
							<div class="col-12">
								<label class="control-label pull-right"
									for="txt_correo_contacto" style="color: black; margin-bottom: 0px;"><spam
										style="font-weight: bold;color: #ed2525;">*</spam>Correo
									Electr&oacute;nico</label>
							</div>
							<div class="col-12">
								<input class="form-control" type="text" id="txt_correo_contacto">
							</div>
						</div>
						<div class="form-group form-group-lg">
							<div class="col-12">
								<label class="control-label pull-right" 
									for="txt_whatsApp_contacto" style="color: black; margin-bottom: 0px;"><spam
										style="font-weight: bold;color: #ed2525;">*</spam>WhatsApp</label>
							</div>
							<div class="col-12">
								<input class="form-control" type="text"
									id="txt_whatsApp_contacto"
									onkeypress="return isNumberKey(event)">
							</div>
						</div>
						<div class="form-group form-group-lg">
							<div class="col-12">
								<label class="control-label pull-right"
									for="txt_mensaje_contacto" style="color: black; margin-bottom: 0px;"><spam
										style="font-weight: bold;color: #ed2525;">*</spam>Mensaje</label>
							</div>
							<div class="col-12">
								<textarea class="form-control" type="text"
									id="txt_mensaje_contacto" cols="40" rows="4"></textarea>
							</div>
						</div>
						<p class="h6"
							style="font-size: .75rem; margin-bottom: 0px; margin-top: 0px; color: black;">
							<spam style="font-weight: bold;color: #ed2525;">*</spam>
							Campos obligatorios
						</p>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
				
					<button id="Btn_cancelarQuieroSerDist" type="button" class=" btn btn-secondary" data-dismiss="modal">Cancelar</button>
					
						<div class="form-group form-group-lg" style="margin-bottom: 0px;">
							<input type="hidden" name="operacion" id="operacion" value="2">
							<button type="button" class="btn btn-danger" style="background-color: #CC303B;"
								id="Btn_enviarQuieroSerDist">Enviar</button>
							<button type="button" id="btn_esperaQuieroSerDist"
								class="btn  btn-warning" style="display: none">
								<span
									class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span>
								Enviando, Espere...
							</button>
						</div>
				</div>
			</div>
		</div>
	</div>
	<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_bGuXpAEK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
</body>
</html>