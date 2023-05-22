<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<!--Mapa-->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD3pAWctAaHoIRhTERJ1N3lQ_0TZe7tCqY"></script>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/css/bootstrap-3.3.5.min.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/starter-style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/css/starter-template-5.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/bootstrap-3.3.5.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jsClientesKwx.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	function pintarJSON(json, km, producto, cp,pais){
// 	  	json = JSON.stringify(json);
// 	 	var parseado = JSON.parse(json)
// 	 	results = JSON.stringify(parseado.results)
// 	 	var results2 = JSON.parse(results)
	var siTieneLat = "";
		
		//siTieneLat = JSON.stringify(json.results[0].geometry.location.lat);
		if(json.results[0] == undefined){
			alert("Codigo Postal Incorrecto, Ingrese otro.")
		}else{
			//console.log("JSON con valor")
		}
		
		const siTienLAT	=  JSON.stringify(json.results[0].geometry.location.lat);

			var lat = JSON.stringify(json.results[0].geometry.location.lat);
			var longi = JSON.stringify(json.results[0].geometry.location.lng);
						
			document.location.href = "${pageContext.request.contextPath}/ServletDondeComprar?operacion=2&Producto="
				+ producto
				+ "&km="
				+ km
				+ "&lat="
				+ lat
				+ "&longi="
				+ longi
				+ "&cp="
				+ cp
				+"&pais="
				+pais;

	}
	function IniciaMapa(latitud, longitud) {
		
		var pruebaLoc = "";
		
		var latlng = new google.maps.LatLng(0, 0);

		var DelIni = "${str_delegacion}";
		var mapOptions;

		if (DelIni > 0) {
			mapOptions = {
				zoom : 12,
				center : latlng,
				mapTypeId : google.maps.MapTypeId.ROADMAP,
			};
		} else {
			mapOptions = {
				zoom : 12,
				center : latlng,
				mapTypeId : google.maps.MapTypeId.ROADMAP,
			};
		}
		map = new google.maps.Map(document.getElementById('mi-mapa'),
				mapOptions);
		setMarkers(map,latitud,longitud);
	}

	function setMarkers(map, latitud, longitud) {
		if(longitud==null || longitud ==undefined){
			latitud="19.3478575"
			longitud="-99.1160392";
		}
		//alert(latitud+":"+longitud)
		<c:if test="${longitud2 != ''}">
			$("#msjInicio").css('display','none')
			longitud = "${longitud2}";
		</c:if>
		
		<c:if test="${latitud2 != ''}">
			latitud = "${latitud2}";
		</c:if>
		
		var kmTotal = "";
		var distanciaRecorr = 99999;
		var listaClientes = "";
		var listaKM = "";
		<c:if test="${distRecorr != ''}">
			distanciaRecorr = ${distRecorr};
		</c:if>
		<c:forEach items="${listClientes}" var="clientes">
		if(longitud === undefined){
			console.log("longitSinInf: "+longitud)
		}
		else{
			/*METODO PARA SACAR LOS KM DE ACUERDO A UNA LAT Y LONG QUE ME MANDEN*/
			var degtorad = 0.01745329;
			  var radtodeg = 57.29577951;
			  var lat1h = ${clientes.latitud};
			  var lat2h = latitud;
			  var long1h = ${clientes.longitud};
			  var long2h = longitud;
			  var lat1 = parseFloat(lat1h);
			  var lat2 = parseFloat(lat2h);
			  var long1 = parseFloat(long1h);
			  var long2 = parseFloat(long2h);
			  
			  var dlong = (long1 - long2);
			  var dvalue = (Math.sin(lat1 * degtorad) * Math.sin(lat2 * degtorad))
			   + (Math.cos(lat1 * degtorad) * Math.cos(lat2 * degtorad)
			   * Math.cos(dlong * degtorad));
			  var dd = Math.acos(dvalue) * radtodeg;
			  var miles = (dd * 69.16);
			  miles = (miles * 100)/100;
			  var km = (dd * 111.302);
			  km = (km * 100)/100;
			  
			 kmTotal = FormatNumber(km, 2);

		}
		if(kmTotal < distanciaRecorr || kmTotal == ""){
			if(kmTotal == "" || kmTotal == null){
				
			}else{
				/*CREO CADENAS ACUMULADAS DE LA INFORMACION*/
				var cve_cliente = "${clientes.cve_cliente}";
				listaClientes += (cve_cliente + ", ");
				listaKM += (kmTotal + ", ");
			}					
	
			var myLatLng = new google.maps.LatLng("${clientes.latitud}",
					"${clientes.longitud}");
			
			var myLatLng2 = new google.maps.LatLng(latitud,longitud);
			var image = {
				url : "https://www.kwx.com.mx/image/imgKwx/kwx64.png",
			        
				scaledSize : new google.maps.Size(60, 60)
			};
			var marker = new google.maps.Marker({
				position : myLatLng,
				map : map,
				title : "${clientes.nombre}",
				icon : image
			});
			var infowindow;
			var cve_cliente = "${clientes.cve_cliente}";
			var nombre_cte = "${clientes.nombre}";
			var direccion = "${clientes.direccion}";
			var telefono = "${clientes.telefono}";
			var correo = "${clientes.correoElectronico}";
			var whatsApp = "${clientes.tel_Whatsapp}";
			var coordenada = "${clientes.coordenadas}";
			var kmt = kmTotal;
			
			(function(nombre_cte, direccion, telefono, correo, whatsApp, marker, kmt) {
				google.maps.event
						.addListener(
								marker,
								'click',
								function() {
									var coordenada = "${clientes.coordenadas}";
									var contenido = '<div id="content" style="width:100%;" align="center">'
											+ '<div class="col-md-12 col-sm-12">'
											+ '<table>'
											+ '<tr>'
											+ '<td style="font-weight:bold; font-size:12px; color:#1D69AA;" align="center">'
											+ '<p>'
											+ nombre_cte
											+ '</p>'
											+ '</td>'
											+ '</tr>'
											+ '<tr>'
											+ '<td style="font-weight:bold; font-size:12px; color:#9E9E9E;" align="center">'
											+ '<p>'
											+ direccion
											+ '</p>'
											+ '</td>'
											+ '</tr>'
											+ '<tr>'
											+ '<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'
											+ '<p>Tel.: '
											+ telefono
											+ '</p>'
											+ '</td>'
											+ '</tr>'
											+ '<tr>'
											+ '<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'
											+ '<p>Correo: '
											+ correo
											+ '</p>'
											+ '</td>'
											+ '</tr>'
											+ '<tr>'
											+ '<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'
											+ '<p>WhatsApp: '
											+ whatsApp
											+ '</p>'
											+ '</td>'
											+ '</tr>';	
									if(kmt != ""){
									    var km = '<tr>'
											+ '<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'
											+ '<p>KM: '
											+ kmt
											+ '</p>'
											+ '</td>'
											+ '</tr>';
									}
										var contenido2 = '<tr>'
											+ '<td style="font-weight:bold;font-size:12px; color:#fe5042;" align="center">'
											+
											'<span class="glyphicon glyphicon-map-marker"></span> <a href="https://www.google.com/maps/place/'+coordenada+'/@${clientes.latitud}${clientes.longitud}" target="_blank" style=" color:#00bfd9">Ver en Google maps</a>'
											+ '</td>'
											+ '</tr>'
											+ '</table>'
											+ '</div>' + '</div>';
	
									if (!infowindow) {
										infowindow = new google.maps.InfoWindow();
									}
									infowindow.setContent(contenido + km + contenido2);
									infowindow.open(map, marker);
	
								});
	
			})(nombre_cte, direccion, telefono, correo, whatsApp, marker,kmt);
	
			map.setCenter(myLatLng2);
		}
		
		</c:forEach>

		var produc = "";
		var cp = "";
		<c:if test="${str_producto != ''}">
			produc = "${str_producto}";
		</c:if>
	        	if(listaClientes != ""){
	        		$("#mapa").css('display','block')
  					$("#compraLinea").css('display','none')
					mandarClientesEspe(listaClientes, produc, listaKM);
					//document.location.href = "${pageContext.request.contextPath}/ServletDondeComprar?operacion=4&listaCliente="
						//+ listaClientes;	
 				}
 	        	else if(listaClientes == "" && produc != ""){
  					//alert("No existen Refaccionarias en un radio de "+distanciaRecorr+ " km, Intente lo siguiente:\n"
  						//	+ "1. Amplie los KM de la lista.\n"
  						//	+ "2. Realice sus compras en linea.")
  				 //   $("#mapa").css('display','none')
  					$("#compraLinea").css('display','block')
  				    
  				}
			
		var edo = "${distRecorr}";
		var pro = "${str_producto}";
		var del = "${cp}";
		var pais= "${pais}";
		if(edo == '999999999'){
			$('#km').val('');	
		}else{
			if(pais=='1'){
				$('#km').val(edo);
			}else{
				$('#cp').val('');
			}
		}
		if(pro == '10000'){
			$('#cmbProductos').val(0);	
		}else{
			$('#cmbProductos').val(pro);
		}
		if(pais==1){
		$('#cp').val(del);
		}else{
			$('#cp').val('');
		}
		$('#pais').val(pais);
		CargaDelegaciones(del);

	}
	
	function FormatNumber(Number, Decimals) {
		 Number = "" + Number;
		 Decimals = "" + Decimals;
		 var OriginalNumber = Number;
		 var Sign = 1;
		 var Pad = "";
		 var Count = 0;
		 if(parseFloat(Number)) {
		  Number = parseFloat(Number);
		 }
		 else {
		  Number = 0;
		 }
		 if((parseInt(Decimals,10)) || (parseInt(Decimals,10) == 0)) {
		  Decimals = parseInt(Decimals,10);
		 }
		 else {
		  Decimals = 2;
		 }
		 if(Number < 0) {
		  Sign = -1;
		  Number *= Sign;
		 }
		 if(Decimals < 0)
		  Decimals *= -1;
		 Number = "" + Math.floor(Number * Math.pow(10,Decimals + 1) + 5);
		 if((Number.substring(1,2) == '.') || (Number=='NaN'))
		  return(OriginalNumber);
		 if(Number.length < Decimals +1)
		 {
		  for(Count = Number.length; Count <= Decimals; Count++)
		  Pad += "0"
		 }
		 Number = Pad + Number;
		 if(Decimals == 0) {
		  Number = Number.substring(0, Number.length -1)
		 }
		 else {
		  Number = Number.substring(0,Number.length - Decimals -1) +  "." +
		          Number.substring(Number.length - Decimals -1, Number.length -1);
		 }
		 if(Sign == -1)
		  Number = "-" + Number;
			return(Number)
		}

	google.maps.event.addDomListener(window, 'load', IniciaMapa);
	/*FUNCION QUE HACE LA BUSQUEDA DE LAS REFACCIONARIAS*/
	function ConsultaClienteKwx() {

		$("#msjInicio").css('display','none')
		var numbers = /^[0-9]+$/;		
		
		var cp = $("#cp").val();
		var km = $("#km").val();
		var pais = $("#pais").val();
		//alert(pais);
		var producto = $("#cmbProductos").val();
		
		if(km == '' && producto == 0 && cp == ''&& pais == ''){
			km = '20';
			cp= '09819'
			pais='1'
			document.location.href = "${pageContext.request.contextPath}/ServletDondeComprar?operacion=2&km="+km
					+"&Producto=0&cp="+cp+"&lat=19.347857619451894&longi=-99.11610818404026&pais="+pais;
		}else{	
		   if(!cp.match(numbers)){
			   var lon2="";
			   var lat2="";
			  // if(cp == ''&&pais == ''){
				//alert("Formato erroneo de Codigo Postal, Favor de Ingresar Solo NUMEROS.")
				if(pais=='1'){
					lat2="19.347857619451894"
					lon2="-99.11610818404026"
				}else{
					lat2="14.6432664"
					lon2="-90.572967"
				}
					
				document.location.href = "${pageContext.request.contextPath}/ServletDondeComprar?operacion=7&lat="+lat2+"&longi="+lon2+"&pais="+pais;
// 			   }else{
// 				   switch(pais){
// 					   case "1":
// 						   document.location.href = "${pageContext.request.contextPath}/ServletDondeComprar?operacion=2&km=20&Producto=0&cp=09819&lat=19.347857619451894&longi=-99.11610818404026&pais=1";
// 						   break;
// 						default:
// 							document.location.href = "${pageContext.request.contextPath}/ServletDondeComprar?operacion=2&km=20&Producto=0&cp=01057&lat=14.634842530735131&long=-90.49977384192752&pais=2";
// 				   }
				  
// 			   }

		   }
			else {
				var pais2="";
				  switch(pais){
				   case "1":
					  pais2="mexico";
					  break;
					default:
						pais2="ciudaddeguatemala";
				  }
				var result = "";
				if(km == ''){
					km = '10';	
				}
				if(pais=="2"){
					fetch('https://maps.googleapis.com/maps/api/geocode/json?address='+cp+'+'+pais2+'&sensor=true&key=AIzaSyD3pAWctAaHoIRhTERJ1N3lQ_0TZe7tCqY')
					.then(response => response.json())
					.then(json => pintarJSON(json, km, producto, cp,pais))
				}else{
					fetch('https://maps.googleapis.com/maps/api/geocode/json?address='+cp+'&sensor=true&key=AIzaSyD3pAWctAaHoIRhTERJ1N3lQ_0TZe7tCqY')
					.then(response => response.json())
					.then(json => pintarJSON(json, km, producto, cp,pais))
				}

			}			
			
		}
			
	}

	function VerClienteKwx() {
		var estado = $("#cmbListaEstados").val();
		var producto = $("#cmbProductos").val();
		var delegacion = $("#cmbDelegacion").val();
		document.location.href = "${pageContext.request.contextPath}/ServletDondeComprar?operacion=1&Producto="
				+ producto
				+ "&Estado="
				+ estado
				+ "&delegacion="
				+ delegacion
				+ "&ListEdo=${listEstados}";
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
fbq('init', '1677679685720148');
fbq('track', 'PageView');
</script>
<noscript><img height="1" width="1" style="display:none"
src="https://www.facebook.com/tr?id=1677679685720148&ev=PageView&noscript=1"
/></noscript>
<!-- End Meta Pixel Code -->

<meta name="facebook-domain-verification" content="iwxagmmck8vlpagd55qrtzt8rx6899" />

</head>

<body onload="localizador();">
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
	<script type="text/javascript">
		function localizador() {
			//alert("Entra");
			var lati = "";
			var longitu = "";
			if (!"geolocation" in navigator) {
				return alert("Tu navegador no soporta el acceso a la ubicación. Intenta con otro");
			}

			const $latitud = document.querySelector("#latitud"),
				  $longitud = document.querySelector("#longitud"),
				  $enlace = document.querySelector("#enlace");


			const onUbicacionConcedida = ubicacion => {
				const coordenadas = ubicacion.coords;
				$latitud.innerText = coordenadas.latitude;
				$longitud.innerText = coordenadas.longitude;
				$enlace.href = `https://www.google.com/maps/@${coordenadas.latitude},${coordenadas.longitude},20z`;
					
				lati = coordenadas.latitude;
				longitu = coordenadas.longitude;
				//alert(lati+":"+longitu)
				if(lati != "" && longitu != ""){
					$("#msjInicio").css('display','block')
					IniciaMapa(lati,longitu);
					//document.location.href = "${pageContext.request.contextPath}/ServletDondeComprar?operacion=4&latitud="+lati+"&longitud="+longitu;	
				}								
			}
			const onErrorDeUbicacion = err => {

				$latitud.innerText = "Error obteniendo ubicación: " + err.message;
				$longitud.innerText = "Error obteniendo ubicación: " + err.message;
				console.log("Error obteniendo ubicación: ", err);
			}

			const opcionesDeSolicitud = {
				enableHighAccuracy: true, // Alta precisión
				maximumAge: 0, // No queremos caché
				timeout: 6000 // Esperar solo 6 segundos
			};

			$latitud.innerText = "Cargando...";
			$longitud.innerText = "Cargando...";
			navigator.geolocation.getCurrentPosition(onUbicacionConcedida, onErrorDeUbicacion, opcionesDeSolicitud);
			
			//document.location.href = "${pageContext.request.contextPath}/ServletDondeComprar?operacion=4&latitud="+$latitud+"&longitud="+$longitud;
			
		//document.addEventListener("DOMContentLoaded", funcionInit);

	}
	
	function getLocation() {
	   if (navigator.geolocation) {
		    navigator.geolocation.getCurrentPosition(showPosition);
	   } else { 
		    console.log("Geolocation is not supported by this browser.");
		    alert("Geolocation is not supported by this browser.")
	   }
	}	
	function showPosition(position) {
// 		  x.innerHTML = "Latitude: " + position.coords.latitude + 
// 		  "<br>Longitude: " + position.coords.longitude;
		  console.log("Latitude: " + position.coords.latitude +" Longitude: " + position.coords.longitude)
	}
	function limpiar(){
		location.href = "${pageContext.request.contextPath}/ServletDondeComprar"; 
	}
	</script>

	<!--  Header  -->
	         <%@include file="EncabezadoKwx.html"%>
	<div style="display: none">
	<p id="latitud"></p>
	<p id="longitud"></p>	
	<a target="_blank" id="enlace" href="#"></a>
	</div>
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
	<div class="row" style="padding-left: 20px;">
		<div class="col-md-4 col-sm-12">
			<div style="margin-top: 10px; display: none" class="input-group" id="msjInicio">			
				<span class="input-group-addon" style="width: 49.7%"><h4><b> Se mostrarán las refaccionarias que se encuentran <br> a 5 km de su ubicación. </b></h4></span> 
			</div>
			<div style="margin-top: 10px;" class="input-group">			
				<span class="input-group-addon" style="width: 49.7%"><b>------------ Ingrese los siguientes datos para la búsqueda ------------<br>------------de sus refaccionarias más cercanas. ------------</b></span> 
			</div>
			<div style="margin-top: 10px;" class="input-group">			
				<span class="input-group-addon" style="width: 49%"> CODIGO POSTAL </span> 
					<!-- <select name="cmbListaEstados" id="cmbListaEstados" class="form-control">
						<option value="0" selected="selected">- - - - -</option>
						<c:forEach var="estado" items="${listEstados}">
							<option value="${estado.cve_estado}">${estado.descripcion}</option>
						</c:forEach>
					</select>  -->
					<input type="text" id="cp" name="cp" class="form-control" maxlength="5" style="width: 160%"/>
			</div>
			<div style="margin-top: 10px" class="input-group">
				<span class="input-group-addon" style="width: 56%"> PAIS </span> 
					<!-- <select name="cmbListaEstados" id="cmbListaEstados" class="form-control">
						<option value="0" selected="selected">- - - - -</option>
						<c:forEach var="estado" items="${listEstados}">
							<option value="${estado.cve_estado}">${estado.descripcion}</option>
						</c:forEach>
					</select>  -->
					<select name="pais" id="pais" class="form-control" style="width: 213%"> 
					<option value="1">MÉXICO</option>
					<option value="2">GUATEMALA</option>
				</select>
				</div>
			<div style="margin-top: 10px" class="input-group">
				<span class="input-group-addon" style="width: 40%"> KILOMETROS </span> 
				<!-- <select name="cmbDelegacion" id="cmbDelegacion" class="form-control"> 
					<option value="0" selected="selected">- - - - -</option>
				</select>  -->
				<select name="km" id="km" class="form-control" style="width: 112%"> 
					<option value="">SELECCIONE DISTANCIA EN KM</option>
					<option value="3">3 KM </option>
					<option value="5">5 KM </option>
					<option value="8">8 KM </option>
					<option value="10">10 KM </option>
					<option value="15">15 KM </option>
					<option value="20">20 KM </option>
				</select>
			</div>

			<div style="margin-top: 10px" class="input-group">
				<span class="input-group-addon" style="width: 39%"> PRODUCTO </span> <select
					name="cmbproductos" id="cmbProductos" class="form-control" style="width: 107.2%">
					<option value="0">TODOS LOS PRODUCTOS</option>
					<c:forEach var="articulo" items="${lisArticulos}">
						<option value="${articulo.cve_producto_kwx}">${articulo.descripcion}</option>
					</c:forEach>
				</select>
			</div>



			<div style="margin-top: 10px" class="input-group pull-right">
				<table width="100%"> 
					<tr>
					<td width="45%">
						   <button class="btn btn-success" type="button" id="limpiar" onclick="limpiar()"><i class="glyphicon glyphicon-floppy-remove"></i> Limpiar</button>
						</td>
						<td width="10%"><label style="color: white">___</label></td>
						<td width="45%">
						   <button class="btn btn-success" type="button" id="obtenerUbicacion" onclick="localizador()"><i class="glyphicon glyphicon-globe"></i> Obtener Ubicacion</button>
						</td>
						<td width="10%"><label style="color: white">___</label></td>
						<td width="45%">
							<button class="btn btn-warning pull-right" type="button"
								onclick="ConsultaClienteKwx()">
								<i class="glyphicon glyphicon-search"></i>Buscar
							</button>
						</td>
					</tr>
				</table>


			</div>

			<div style="margin: 10px;">
				<div
					style="max-height: 450px; margin-top: 10px; margin-bottom: 50px;" id="clientes">
					<table
						style="margin-top: 20px; margin-bottom: 30px; width: 100%; max-height: 450px; overflow: auto; display: inline-block;">
						<tbody>
							<c:forEach var="cliente" items="${listClientes}">
								<tr>
									<td>
										<p style="font-weight: bold; color: #1D69AA;">
											${cliente.nombre}</p>
										<p style="font-weight: bold; color: #9E9E9E;">
											${cliente.direccion}</p>
										<p style="font-weight: bold; color: black;">
											Tel.:${cliente.telefono} </br> ${cliente.correoElectronico}
										</p>
										
										<p style="font-weight: bold; color: black;">WhatsApp:
											${cliente.tel_Whatsapp}</p>
<!-- 										<p style="font-weight: bold; color: black;">KM: -->
<%-- 											${cliente.km}</p> --%>
										<button id="img-0" type="button"
											onclick="MuestraUbiCteKwx('${cliente.nombre}', '${cliente.direccion}', '${cliente.telefono}', '${cliente.correoElectronico}', '${cliente.latitud}', '${cliente.longitud}', '${cliente.tel_Whatsapp}', '${cliente.coordenadas}', '${cliente.km}');saltarA('#mi-mapa')"
											class="btn btn-primary"
											style="margin-right: 12px; margin-left: 12px;">
											<span class="glyphicon glyphicon-map-marker"></span> Ver</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div id="clienteEspecificos"></div>
		</div>

		<div class="col-md-8 col-sm-12" id="mapa">
			</br>
			<div id="mi-mapa" style="width: 98%; height: 610px;"></div>
			</br>
		</div>
		<div style="display: none" id="compraLinea">
			<div class="col-md-3 col-sm-8">
				<a href="https://www.autorep.mx/search#!products/kwx/d/eyJsaW1pdCI6NTMsIm9mZnNldCI6MCwib3JkZXJCeSI6Ik9SREVSX0JZX1RJTUVTX09SREVSRURfREVTQ0VORElORyJ9/s/eyJyZXR1cm5DYXRlZ29yeUZhY2V0cyI6dHJ1ZSwicmV0dXJuTWFudWZhY3R1cmVyRmFjZXRzIjp0cnVlLCJjYXRlZ29yeUlkIjotMTAwLCJtYW51ZmFjdHVyZXJJZCI6LTEwMCwic2VhcmNoVGV4dCI6Imt3eCIsIndoZXJlVG9TZWFyY2giOi05OSwidG9rZW5pemVTb2xySW5wdXQiOnRydWV9" target="_blank">
					<img class="img-responsive" src="${pageContext.request.contextPath}/img/Boton_Auto-Rep.jpg" alt="" style="display: inline-block; padding: 10px;"></img>
					<div class="overlay"> 
						
					</div>
				</a>
			</div>
		
             <div class="col-md-3 col-sm-8">
                	<a href="https://cutt.ly/GcFv4pD" target="_blank" >
						<img class="img-responsive" src="${pageContext.request.contextPath}/img/Boton_ML.jpg" alt="" style="display: inline-block; padding: 10px;"></img>
						<div class="overlay"> 
						 </div>
					</a>
			</div>					
		</div>
		</div>
	  <br> <br> <br>
	 <%@include file="footerKwx.html"%>
	 		
	<br> <br> <br>
<script type='text/javascript' src='https://vcl1-cloud.vocalcom-latam.com/hermes_net_v5/PlateformPublication/WebSitesLiveChat/Commun/TheWave/65956495363483B4_aajN9AQK/loaderthenewwave.ashx' id='newloaderthewavev5'></script>
</body>
<script>

function saltarA(id, tiempo) {
	  var tiempo = tiempo || 1000;
	  $("html, body").animate({ scrollTop: $(id).offset().top }, tiempo);
	}	
	</script>
</html>