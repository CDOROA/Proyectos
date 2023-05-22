
/****  COSULTA TODAS LAS SUCURSALES EN CDO *****/
function consultaSucursalesCDOs()
{ 
	document.getElementById('cargandoInformacion').style.display = 'block';
	OcultarDiv('divMjsErrorSucursales');
	$.ajax
	({
		    url :'Sucursales', 
		    data : "vista=PaginaPrincipal.jsp&operacion=ConsultaSucursalesCDOs", 
		    type : 'POST',
		    dataType : 'Json',
		    success : function(jsonSucursales)
		    { 
		    	document.getElementById('cargandoInformacion').style.display = 'none';
		    	MostrarDiv('divSucursalesMapa');
	    		OcultarDiv('divSucursalesResultados');
	    		OcultarDiv('divMjsErrorSucursales');
	    		mostrarSucursalesCDOs(jsonSucursales);
	    		
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargandoInformacion').style.display = 'none';
				$("#lb_msjErrorSucursales").text("Hubo un error al buscar la sucursal.")
				MostrarDiv('divMjsErrorSucursales')
			}
	});
}

function mostrarSucursalesCDOs(jsonSucursales)
{
	$("#divSucursalesMapa").empty();
	let contenido = construyeContenidoSucursalesCDOs(jsonSucursales);
	$("#divSucursalesMapa").append(contenido);
	iniciaMapaCDOs(jsonSucursales);
}

function construyeContenidoSucursalesCDOs(jsonSucursales)
{
	let contenido= "<div class=' col-xs-12 col-sm-12 col-md-1 col-lg-1' style='text-align:center;'></div> "+
						"<div class=' col-xs-12 col-sm-12 col-md-10 col-lg-10' style='text-align:center; padding:0px'>"+
							"<div class='row' style='padding: 0px; margin: 0; text-align: center;' >"+
							  "<div class=' col-xs-12 col-sm-12 col-md-4 col-lg-4 ' style='text-align:center;overflow: auto; height:570px; padding:0px'>	";
			
	for(let i=0; i < jsonSucursales.length ; i++)
	{
		contenido +="<div class='row' style='padding: 5px; margin: 0; text-align: center;'>"+	
						"<div class=' col-xs-12 col-sm-12 col-md-1 col-lg-1' style='text-align:center;'></div>"+
							"<div class=' col-xs-12 col-sm-12 col-md-12 col-lg-12' style='text-align:center; width:100%; padding:5px' >"+
										"<div style='background-color: #F5F5F5 ; border: 1px solid #DDDDDD;border-radius:8px;padding: 20px'>"+
										
										"<div style='padding: 3px;padding-left:0px;text-align: center'>"+
										"<label  class='EPP_lb_size_22' style='font-weight: bold; color:#004085; margin:0px'>Cobertura:</label><br>"+
										"<label class='EPP_lb_size_12' style='font-weight: normal; color:normal;margin-bottom: 3px; text-align: justify;'>" +jsonSucursales[i].cobertura + "</label>"+
										
									"</div>"+
									 
									
									
														
											"<table width='100%' align='center' >"+
											"<tr style='width: 100%;'><td style='width: 100%;' colspan='2'>" +
											"<hr align='CENTER' size='2' width='100%' color='#CCCCCC' noshade>"+
											"</td></tr>"+
											"<tr style='width: 100%;'><td style='width: 100%;' colspan='2'>" +
											"<label class='EPP_lb_size_12' style='font-weight: bold; color:#004085;margin:0px'>Sucursal que atiende en su estado:</label>"+
											"</td></tr>"+
											"<tr style='width: 100%;'><td style='width: 100%;' colspan='2'>" +
											"<label  class='EPP_lb_size_22' style='font-weight: bold; color:#004085; margin:0px'> " +jsonSucursales[i].nombre + " </label>"+		
											"</td></tr>"+
												"<tr>"+
													"<td align='left' colspan='2'>	"+														
														"<label   class='EPP_lb_size_12' style='font-weight: normal; color:black; text-align: left; margin:0px'> " +jsonSucursales[i].direccion + "</label>"+					
													"</td>"+
												"</tr>"+
												"<tr>"+
													"<td align='left'><img src='images/telefono_mini.png'></img></td>"+
													"<td align='left'>"+															
														"&nbsp;<label  class='EPP_lb_size_12' style='font-weight: normal; color:black; margin:0px'> " +jsonSucursales[i].telefono + "</label>"+					
													"</td>"+
												"</tr>"+
												"<tr>"+
													"<td align='left'><img src='images/mail_mini.png'></img></td>"+
													"<td align='left'>"+															
														"&nbsp;<label  class='EPP_lb_size_12' style='font-weight: normal; color:black; margin:0px'>" +jsonSucursales[i].email + "</label>"+					
													"</td>"+
												"</tr>"+						
												"<tr>"+
												"<td align='left'>" +
												" <ul class='list-unstyled'>" +
												"<li style='background: transparent; padding-top: 0px;padding-bottom: 0px;margin-top: 0px;display: inline-block;'>" +
												"		<a href='javascript:void(0);'>" +
												//"			<img src='https://webcdo.cdoautopartes.com.mx/images/Icon_Signal.png' style='width: 16px;'> " +
												"		</a>" +
												"	</li>" +
												"	<li style='padding-top: 0px;padding-bottom: 0px;margin-top: 0px; display: inline-block;'>" +
												"		<a href='javascript:void(0);'>" +
												"			<img src='images/Icon_WhatsApp.png' style='width: 16px;'>" +
												"		</a>" +
												"	</li>" +
												"<li style='padding-top: 0px;padding-bottom: 0px;margin-top: 0px; display: inline-block;'>" +
												"		<a href='javascript:void(0);'>" +
												"			<img src='images/Icon_Telegram.png' style='width: 16px;'>" +
												"		</a>" +
												"	</li>" +
										     	"	</ul>" +
												"</td>" +
												"<td align='left'>" +
												" <ul class='list-unstyled'>" +
											"		<li style='background: transparent;margin-right: 15px; display: inline-block;'>" +
											"		<a ref='javascript:void(0);' class='EPP_lb_size_12' style='font-weight: normal; color:black; margin:0px'>" +
											"				55 4449 1721" +
											"		</a>" +
											"	</li>" +
									     	"	</ul>" +
												"</table>"+										
											
											"<div style='padding: 0px;text-align: left'>"+
												"<label class='EPP_lb_size_12' style='font-weight: bold; color:#004085;margin:0px'>Horario de Atenci&oacute;n:</label>	"+
												"<br>";
		                                     // alert(jsonSucursales[i].cve_empresa);	
		
												if(jsonSucursales[i].cve_empresa == '69')
													{
													contenido += "<label class='EPP_lb_size_12' style='font-weight: normal; color:black;margin-bottom: 3px'>L-V de 08:30 hrs. a 18:30 hrs.</label>";
													contenido += "<label class='EPP_lb_size_12' style='font-weight: normal; color:black;margin-bottom: 3px'>Sab. de 08:30 hrs. a 14:00 hrs.</label>";
												}else if( jsonSucursales[i].cve_empresa == '116')
												{
													contenido += "<label class='EPP_lb_size_12' style='font-weight: normal; color:black;margin-bottom: 3px'>L-V de 09:00 hrs. a 18:30 hrs.</label>";
													contenido += "<label class='EPP_lb_size_12' style='font-weight: normal; color:black;margin-bottom: 3px'>Sab. de 08:30 hrs. a 14:00 hrs.</label>";
												}
												else
													{
													contenido += "<label class='EPP_lb_size_12' style='font-weight: normal; color:black;margin-bottom: 3px'>L-V de 08:00 hrs. a 19:00 hrs.</label>";
													contenido += "<label class='EPP_lb_size_12' style='font-weight: normal; color:black;margin-bottom: 3px'>Sab. de 08:00 hrs. a 14:00 hrs.</label>";
													}
												contenido += "</div>"+
										"</div>"+
									"</div>"+
								"<div class='col-xs-12 col-sm-12 col-md-1 col-lg-1' style='text-align:center;'></div>"+
							"</div>";
	
	}
						
	contenido += 	
					"</div>"+
					"<div class=' col-xs-12 col-sm-12 col-md-8 col-lg-8' style='text-align:center'>"+
						"<div class='row' style='padding: 0px; margin: 0; text-align: center;' >"+
							"<div class=' col-xs-12 col-sm-0 col-md-0 col-lg-0 ' style='text-align: center; height: 20px'></div>"+
							"<div class=' col-xs-12 col-sm-12 col-md-12 col-lg-12' style='text-align:center; width:100%; padding:5px' >"+						
								"<div class='posicionMapa' id='mapCdos' style='width: 100%; height:500px; border: 0px solid #777;  overflow: hidden; margin: 0 auto; height:570px;'>" +
								
								"</div>"+
							"</div>"+
						"</div>"+
					"</div>"+
				 "</div>"+
				"</div>"+
				"<div class=' col-xs-12 col-sm-12 col-md-1 col-lg-1' style='text-align:center;'></div>";
	return contenido;
}

function iniciaMapaCDOs(jsonSucursales)
{
	 let latlng = new google.maps.LatLng(0 , 0);
	 let mapOptions = {
						zoom: 5,
						center: latlng,
						mapTypeId: google.maps.MapTypeId.ROADMAP,
					   };
	 let map = new google.maps.Map(document.getElementById('mapCdos'), mapOptions);
	 punteaMapaCdos(map, jsonSucursales);
}

function punteaMapaCdos( map, jsonSucursales)
{
	for(let i=0; i < jsonSucursales.length ; i++)
	{
		let longitudes = new google.maps.LatLng(jsonSucursales[i].latitud,jsonSucursales[i].longitud); 
	 	let image = 
	 	{
	 		url: "https://www.cdoautopartes.com.mx/image/paginaInicio/puntero5.png",
			scaledSize: new google.maps.Size(24,24)
	  	};
	 	
	 	let marker = new google.maps.Marker
		({
			position: longitudes,
			map: map,
			title: jsonSucursales[i].nombre,
			icon:image 
		});
	 	
	 	map.setCenter(marker.getPosition());
	}
}

/**  CONSULTA SUCIRSALES POR ESTADO  **/
function consultaSucursalesXEdo()
{
	document.getElementById('cargandoInformacion').style.display = 'block';
	OcultarDiv('divMjsErrorSucursales');
	if($("#cboSucursalesEstado").val() != 0)
	{
		$.ajax
		({
			    url :'Sucursales', 
			    data : "vista=PaginaPrincipal.jsp&operacion=ConsultaSucursalxEdo" +"&cve_edo=" + $("#cboSucursalesEstado").val(), 
			    type : 'POST',
			    dataType : 'Json',
			    success : function(jsonSucursales)
			    { 
			    	document.getElementById('cargandoInformacion').style.display = 'none';
			    	if(jsonSucursales.nombre != null &&  jsonSucursales.nombre != "")
		        	{
			    		MostrarDiv('divSucursalesResultados');
			    		OcultarDiv('divSucursalesMapa');
			    		OcultarDiv('divMjsErrorSucursales');
			    		$("#lb_sucursales_empresa").text(jsonSucursales.nombre)
			    		$("#lb_sucursales_direccion").text(jsonSucursales.direccion)
			    		$("#lb_sucursales_telefono").text(jsonSucursales.telefono)
			    		$("#lb_sucursales_email").text(jsonSucursales.email)
			    		$("#lb_sucursales_cobertura").text(jsonSucursales.cobertura)			    		
			    		MostrarMapaXEdo(jsonSucursales.latitud,jsonSucursales.longitud)
		        	}
			    	else
			    	{
			    		document.getElementById('cargandoInformacion').style.display = 'none';
			    		MostrarDiv('divSucursalesMapa');
			    		$("#lb_msjErrorSucursales").text("Por ahora no contamos con cobertura en su Estado.")
			    		OcultarDiv('divSucursalesResultados');
			    		MostrarDiv('divMjsErrorSucursales');
			    	}
				},
				error : function(xhr, status, error)
				{
					document.getElementById('cargandoInformacion').style.display = 'none';
					$("#lb_msjErrorSucursales").text("Hubo un error al buscar la sucursal.")
					MostrarDiv('divMjsErrorSucursales')
				}
		});
	}
	else
	{
		document.getElementById('cargandoInformacion').style.display = 'none';
		MostrarDiv('divSucursalesMapa');
		OcultarDiv('divSucursalesResultados');
		OcultarDiv('divMjsErrorSucursales')
	}	
}

function MostrarMapaXEdo(latitud,longitud)
{	 
	if(latitud > 0)
	{		
		document.getElementById("map").style.display ="block";
		
		let mapOptions = 
		  {
		    zoom: 16,
		    center: new google.maps.LatLng(latitud,longitud)
		  };
		  map = new google.maps.Map(document.getElementById('map'), mapOptions);
		  
		  let myLatLng = new google.maps.LatLng(latitud,longitud); 
		  
		  let image = {
				    url: "https://www.cdoautopartes.com.mx/image/paginaInicio/puntero5.png",
				    scaledSize: new google.maps.Size(65, 65)
				  };
		  let marker = new google.maps.Marker
		  ({
				position: myLatLng,
				map: map,
				title: "CENTRO DE DISTRIBUCION ORIENTE",
				icon:image,
		  });
	}  
}

