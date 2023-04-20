$(document).ready(asignacionInicial);

function asignacionInicial(){	
}




function ObtieneHistorialBlog(operacion)
{
	$("#divHistorialBlog").append ( '<div style=" background-color: #f5f5f5; border-radius: 4px; padding-top: 15px; "> '+
										'<h4><label style=\"color: #3366CC; font-weight: bold\">Historial</label></h4> '+
									'</div>');	 
	$.ajax({      
        url :'ServletBlogSabiasQue',
        data : 'operacion=' + operacion,
        type : 'POST',
        dataType : 'json',
        success : function(json){
        	 
        	if( json.length > 0)
    		{
        		var contenido="";
        		
        		for (var i = 0; i < json.length; i++) {      
        			
        			contenido =  '<div  style=\"width:100%; \"> '+
        							'<ul id="\multicol-menu\" class=\"nav\" align=\"left\" style=\"align:left ; width:100%; \">'+
					    			    '<li class=\"dropdown\" style=\"align:left ; width:100%; \">'+
					    			        '<a href=\"#\" class=\"btn btn-link\" data-toggle=\"dropdown\" type=\"button\">' + json[i].historial.year +'(' +json[i].historial.cont_year+')<b class=\"caret\"></b></a>'+
					    			        '<ul class=\"dropdown-menu\">'+
					    			           '<li>'+
					    			                '<div class=\"row\" style=\"align:left ; width:100%; \">';
        								
        			var arregloDeCadenas = json[i].historial.meses.split('|');
        			var arregloDeTitulos = json[i].historial.titulo.split('|');
					for (var e=0; e < arregloDeCadenas.length; e++) {
						
						 if(arregloDeCadenas.length >= 1 &&  arregloDeCadenas.length < 5)
		        		{
					    	  contenido +=     '<ul class="list-unstyled col-lg-12 col-md-12 col-sm12 col-xs-12">'+
		        			                    	  '<li><a  style=\"color: #3366CC; font-size:11px; font-weight: bold\" role=\"menuitem\" tabindex=\"-1\" href=\"#\">'+arregloDeCadenas[e]+'</a></li>';
		        			         
					    	  var  arregloMesAct = arregloDeCadenas[e].split('(');
					    	  var  MesAct = arregloMesAct[0];
					    	  
					    	  for(var a = 0; a < arregloDeTitulos.length; a++)
				    		  {
					    		  var  ArregloTituloDetallado = arregloDeTitulos[a].split('-');
					    		  
					    		  if(ArregloTituloDetallado[0] == MesAct)
				    			  {
					    			  contenido += '<li role=\"presentation\"><a  style=\"color: black; font-size:10px;\"role=\"menuitem\" tabindex=\"-1\" href=\"javascript:ObtieneBlogActivo(1,'+ ArregloTituloDetallado[1]+')\">'+ArregloTituloDetallado[2]+'</a></li>';			                    	 
				    			  }
				    		  }
					    	  
					    	  
					    	  contenido += '<li role=\"presentation\" class=\"divider\"></li>'+    					    		  
					    		  		'</ul>';
		        		}
						else if(arregloDeCadenas.length >= 5 )
		        		{
							
					    	  contenido +=     '<ul class="list-unstyled col-lg-6 col-md-6 col-sm6 col-xs-6">'+
		        			                    	  '<li><a  style=\"color: #3366CC; font-size:11px; font-weight: bold\" role=\"menuitem\" tabindex=\"-1\" href=\"#\">'+arregloDeCadenas[e]+'</a></li>';
		        			         
					    	  var  arregloMesAct = arregloDeCadenas[e].split('(');
					    	  var  MesAct = arregloMesAct[0];
					    	  
					    	  for(var a = 0; a < arregloDeTitulos.length; a++)
				    		  {
					    		  var  ArregloTituloDetallado = arregloDeTitulos[a].split('-');
					    		  
					    		  if(ArregloTituloDetallado[0] == MesAct)
				    			  {
					    			  contenido += '<li role=\"presentation\"><a  style=\"color: black; font-size:10px;\"role=\"menuitem\" tabindex=\"-1\" href=\"javascript:ObtieneBlogActivo(1,'+ ArregloTituloDetallado[1]+')\">'+ArregloTituloDetallado[2]+'</a></li>';			                    	 
				    			  }
				    		  }
					    	  
					    	  contenido += '<li role=\"presentation\" class=\"divider\"></li>'+    					    		  
					    		  		'</ul>';
		        		}
												 
					}
        							
        			contenido +=    	 			'</div>'+
							            		'</li>'+
							            	'</ul>'+
							            ' </li>'+
							    '</ul>'+
							   '</div>';
        		$("#divHistorialBlog").append(contenido);
    			}
        		$("#divHistorialBlog").append('<br>'+ '<br>'+'<br>'+ '<br>'+'<br>'+'<br>'+'<br>'+'<br>'+
					    '<br>'+'<br>'+'<br>'+'<br>'+'<br>'+'<br>'+'<br>'+'<br>'+'<br>');
        		ObtieneBlogActivo(1,0);	
        		    
        		    
    		}
        },
        error : function(xhr, status, error) {
        	 alert('Disculpe, existió un problema');
        }
    }); 
}

function ObtieneBlogActivo(operacion, cve_blog)
{
	LimpiarCampos();
	
	$.ajax({
		
		  url :'ServletBlogSabiasQue', 
	      data : "operacion=" + operacion + '&cve_blog=' + cve_blog,
	      type : 'POST',
	      dataType : 'json',
	      success : function(json){ 
	    	  var id_block = (json.id_blog);
	    	  var titulo = (json.titulo1);
	    	  var subtitulo = (json.titulo2);
	    	  var fecha = (json.fecha);
	    	  var parrafo1 = (json.parrafo1);
	    	  var parrafo2 = (json.parrafo2);
	    	  var parrafo3 = (json.parrafo3);
	    	  var parrafo4 = (json.parrafo4);
	    	  var imagen = (json.imagen);
	    	  var parrafo5 = (json.parrafo5);
	    	  var parrafo6 = (json.parrafo6);
	    	  var parrafo7 = (json.parrafo7);
	    	  var parrafo8 = (json.parrafo8);
	    	  //var url_video = (json.url_video);
	    	  //var img_video = (json.img_video);
	    	  var descripcion_video = (json.descripcion_video);
	    	  var mes = (json.mes);
	    	  var year = (json.year);
	    	  var descripcionAnterior =(json.descripcion_anterior);
	    	  var imagenAnterior = (json.img_anterior);
	    	      	  
	    	  
	    	  $('#lbDescripcionAnterior').text(descripcionAnterior);
	    	  $('#lbDescripcionVideo').text(descripcion_video);
	    	  $('#lbIdBlock').text(id_block);
	    	  $('#lbTitulo').text(titulo);
	    	  $('#lbSubTitulo').text(subtitulo);
	    	  $('#lbFecha').text(fecha);
	    	  if(parrafo1 != "N-A")
	    	  {
	    		  $("#divParrafoSuperior").append ('<label style=\"font-size:18px; font-weight: normal\" color=\"black\">' + parrafo1 + '</label><br>');
	    	  }
	    	  if(parrafo2 != "N-A")
	    	  {
	    		  $("#divParrafoSuperior").append ('<label style=\" font-size:18px; font-weight: normal\" color=\"black\">' + parrafo2 + '</label><br>');
	    	  }
	    	  if(parrafo3 != "N-A")
	    	  {
	    		  $("#divParrafoSuperior").append ('<label style=\"font-size:18px; font-weight: normal\" color=\"black\">' + parrafo3 + '</label><br>');
	    	  }
	    	  if(parrafo4 != "N-A")
	    	  {
	    		  $("#divParrafoSuperior").append ('<label style=\" font-size:18px; font-weight: normal\" color=\"black\">' + parrafo4 + '</label><br>');
	    	  }
	      
	    	  if(parrafo5 != "N-A")
	    	  {
	    		  $("#divParrafoInferior").append ('<label style=\"font-size:18px; font-weight: normal\" color=\"black\">' + parrafo5 + '</label><br>');
	    	  }
	    	  if(parrafo6 != "N-A")
	    	  {
	    		  $("#divParrafoInferior").append ('<label style=\"font-size:18px; font-weight: normal\" color=\"black\">' + parrafo6 + '</label><br>');
	    	  }
	    	  if(parrafo7 != "N-A")
	    	  {
	    		  $("#divParrafoInferior").append ('<label style=\"font-size:18px; font-weight: normal\" color=\"black\">' + parrafo7 + '</label><br>');
	    	  }
	    	  if(parrafo8 != "N-A")
	    	  {
	    		  $("#divParrafoInferior").append ('<label style=\"font-size:18px; font-weight: normal\" color=\"black\">' + parrafo8 + '</label><br>');
	    	  }
	    	  
	    	  CargaImagenes(imagen,imagenAnterior);
	    	   	    	  
	      },
	      error : function(xhr, status, error) {
	    	  alert('Disculpe, existió un problema');
	      }
		
	}); 
}

function LimpiarCampos()
{
	  $('#lbDescripcionAnterior').val("");
	  $('#lbDescripcionVideo').val("");
	  $('#lbIdBlock').val("");
	  $('#lbTitulo').val("");
	  $('#lbSubTitulo').val("");
	  $('#lbFecha').val("");
	  $("#divParrafoSuperior").empty();
	  $("#divParrafoInferior").empty();
}


