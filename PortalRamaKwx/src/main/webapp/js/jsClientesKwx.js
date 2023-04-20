$(document).ready(asignacionInicial);

function mandarClientesEspe(listaClientes,produc,listaKM){
		if(produc == ""){
			produc = 0;
		}
	$.ajax({
        url :'ServletDondeComprar', 
        data : "operacion=4"+'&listaCliente='+listaClientes+"&producto="+produc+"&listaKM="+listaKM,
        type : 'POST',
        dataType : 'json',
        success : function(json)
        {	
        		console.log("Entra a respuesta")
        		$("#clientes").css('display', 'none'); 
        		var mapa = "'#mi-mapa'";
            	var tr = "";
            	var clientes = json.LISCLIEN;
            	var kms = json.KMORDEN;
            	var kmS = kms.split(","); 
            	var clientesMost = "";
            	var clieAgrega = "";
            	var clienEspe = '<div style="max-height: 450px; margin-top: 10px; margin-bottom: 50px;">' +
    								'<table style="margin-top: 20px; margin-bottom: 30px; width: 100%; max-height: 450px; overflow: auto; display: inline-block;">' +
    									'<tbody>';
            								for(var j = 0; j < kmS.length; j++){
            									for (var i = 0; i < clientes.length; i++) {
         								    	    var kmL = kmS[j].replace(" ","")
            										var clin = clientes[i].km.replace(" ","")
         								    	   	if(Number(kmL) == Number(clin)){
         								    	   		if(clientes[i].cve_cliente == "1" || clientes[i].cve_cliente == "2" || clientes[i].cve_cliente == "3" || clientes[i].cve_cliente == "4" || clientes[i].cve_cliente == "5" ||
         								    	   			clientes[i].cve_cliente == "6" || clientes[i].cve_cliente == "7" || clientes[i].cve_cliente == "8" || clientes[i].cve_cliente == "9"){
         								    	   				clientes[i].cve_cliente = "0"+clientes[i].cve_cliente;
         								    	   		}
         								    	   		if(!clientesMost.includes(clientes[i].cve_cliente)){
	         								    	   		clientesMost += clientes[i].cve_cliente + ",";

	         								    	   		tr += '<tr>' +
		     													'<td>' +
		     														'<p style="font-weight: bold; color: #1D69AA;">' +
		     														clientes[i].nombre + '</p>' +
		     														'<p style="font-weight: bold; color: #9E9E9E;">' +
		     														clientes[i].direccion + '</p>' +
		     														'<p style="font-weight: bold; color: black;">' +
		     															' Tel.:' + clientes[i].telefono+  '</br>'+ clientes[i].correoElectronico +
		     														'</p>' +
		     														
		     														'<p style="font-weight: bold; color: black;">WhatsApp:' +
		     														clientes[i].tel_Whatsapp + '</p>' +
		     														'<button type="button" style="background-color:black"><label style="color:white">KM: ' +
		     														clientes[i].km + '</label></button>' +
		     														'<br>'+	
		     														'<button id="img-0" type="button"' +
		     															' onclick="MuestraUbiCteKwx('+"'"+ clientes[i].nombre+"'"+', '+"'"+ clientes[i].direccion+"'"+', '+"'"+clientes[i].telefono+"'"+', '+"'"+clientes[i].correoElectronico+"'"+', '+"'"+clientes[i].latitud+"'"+', '+"'"+clientes[i].longitud+"'"+', '+"'"+clientes[i].tel_Whatsapp+"'"+', '+"'"+clientes[i].coordenadas+"'"+', '+"'"+clientes[i].km+"'"+');'+'saltarA('+mapa+')"' +
		     															' class="btn btn-primary pull-right" ' +
		     															' style="margin-right: 12px; margin-left: 12px;">' +
		     															' <span class="glyphicon glyphicon-map-marker"></span> Ver ' +
		     													'</td>' +
		     												'</tr>';
	         								    	   		 clieAgrega = clientesMost.split(",")
         								    	   		}
         								    	   		
         								    	   	}   
    								    	   }    								    	   								 
    								       }
    								var cierre = '</tbody>' +
    								'</table>' +
    							'</div>';
            	$("#clienteEspecificos").html(clienEspe+tr+cierre);
        	    	
    	},
    	error : function(xhr, status, error) {
        	alert('Error');
        }
    }); 
}


function asignacionInicial(){	
	
	$('#cmbListaEstados').on('change', CargaDelegaciones);	
}

function MuestraUbiCteKwx(nombre_cte,direccion,telefono,correo,latitud,longitud,whatsApp,coordenada, km)
{
	if(latitud > 0)
	{
		  var mapOptions = 
		  {
		    zoom: 16,
		    center: new google.maps.LatLng(latitud,longitud)
		  };
		  map = new google.maps.Map(document.getElementById('mi-mapa'), mapOptions);
		  
		  var myLatLng = new google.maps.LatLng(latitud,longitud); 
		  
		  var image = {
				  url : "http://www.kwx.com.mx/image/imgKwx/kwx64.png",
				    scaledSize: new google.maps.Size(65, 65)
				  };
		  var marker = new google.maps.Marker
			({
				position: myLatLng,
				map: map,
				title: nombre_cte,
				icon:image,
			});
		  var infowindow;
		  google.maps.event.addListener(marker,'click',function() 
		  {	
			  var contenido = '<div id="content" style="width:100%;" align="center">' +
										'<div class="col-md-12 col-sm-12">' +
										'<table>'+
											'<tr>'+
												'<td style="font-weight:bold; font-size:12px; color:#1D69AA;" align="center">'+
													'<p>'+ nombre_cte +'</p>'+
												'</td>'+
											'</tr>'+
											'<tr>'+
												'<td style="font-weight:bold; font-size:12px; color:#9E9E9E;" align="center">'+
													'<p>'+ direccion+'</p>'+
												'</td>'+
											'</tr>'+
											'<tr>'+
												'<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'+
													'<p>Tel.: '+telefono+'</p>'+
												'</td>'+
											'</tr>'+
											'<tr>'+
											'<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'+
												'<p>Correo: '+correo+'</p>'+
											'</td>'+
											'</tr>'+
											'<tr>'+
											'<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'+
											'<p>WhatsApp: '+whatsApp+'</p>'+
											'</td>'+
											'</tr>';
									if(km != ''){	
										var kms = '<tr>'+
											'<td style="font-weight:bold;font-size:12px; color:#000000;" align="center">'+
											'<p>KM: '+km+'</p>'+
											'</td>'+
											'</tr>';
									}	
											var contenido2= '<tr>'+
											'<td style="font-weight:bold;font-size:12px; color:#fe5042;" align="center">'+
											'<span class="glyphicon glyphicon-map-marker"></span>  <a href="https://www.google.com/maps/place/'+coordenada+'/@'+latitud+''+longitud+'" target="_blank" style="color:#00bfd9" >Ver en Google maps</a>'+
											'</td>'+
											'</tr>'+
										
									 '</table>'+
								'</div>'+
							 '</div>';			
			  
			  if (!infowindow) {
					infowindow = new google.maps.InfoWindow();
				}
				infowindow.setContent(contenido+kms+contenido2);
				infowindow.open(map, marker);
			  
		  });		
		  map.setCenter(marker.getPosition());
	}
}

function CargaDelegaciones(cve_del)
{
	//alert (cve_del);
	$('#cmbDelegacion').empty();
	var cve_estado = $('#cmbListaEstados').val();
	
	//alert (cve_estado);
	$.ajax({
        url :'ServletDondeComprar', 
        data : "operacion=3"+'&cve_estado='+cve_estado,
        type : 'POST',
        dataType : 'json',
        success : function(json)
        {	
        	if( json.length > 0)
    		{
        		$("<option value="+"0"+">"+"- - - - -"+"</option>").appendTo("#cmbDelegacion");
        		for (var i = 0; i < json.length; i++) {
        			
        			$("<option value="+json[i].cve_delegacion+">"+json[i].descripcion+"</option>").appendTo("#cmbDelegacion");
        		}
    		}
        	if(cve_del> 0)
        	{$('#cmbDelegacion').val(cve_del);}
        	
    	},
    	error : function(xhr, status, error) {
        	alert('Error');
        }
    }); 
	
}
