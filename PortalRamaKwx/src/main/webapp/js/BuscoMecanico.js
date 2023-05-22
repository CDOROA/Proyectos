function CargaDelegaciones(cve_del)
{
	//alert (cve_del);
	$('#cmbListaMunicipio').empty();
	var cve_estado = $('#cmbListaEstados').val();
	
	//alert (cve_estado);
	$.ajax({
        url :'ServletBuscoMecanico', 
        data : "operacion=2"+'&cve_estado='+cve_estado,
        type : 'POST',
        dataType : 'json',
        success : function(json)
        {	
        	if( json.length > 0)
    		{
        		$("<option value="+"0"+">"+"- - - - -"+"</option>").appendTo("#cmbListaMunicipio");
        		for (var i = 0; i < json.length; i++) {
        			
        			//$("<option value="+json[i].cve_delegacion+">"+json[i].descripcion+"</option>").appendTo("#cmbListaMunicipio");
        			 $("#cmbListaMunicipio").append('<option value="'+json[i].descripcion+'">'+json[i].descripcion+'</option>');
        		}
        		
        		
    		}
    	},
    	error : function(xhr, status, error) {
        	alert('Sitio en construcion');
        }
    }); 
	
}

function cargaMunicipio()
{
	var cve_numcipio = $('#cmbListaMunicipio').val();
	//alert ("cmbListaMunicipio :" + cve_numcipio + ".");
	$('#txt_municipio').val(cve_numcipio);

	}

function CargaMecanicos()
{
	var cve_estado = $('#cmbListaEstados').val();
	var cve_numcipio = $('#cmbListaMunicipio').val();
	var cve_domicilio = $('#cmbListaDomicilio').val();
	
	//alert ("delegacion :" + cve_estado + ",  cve_municipio:" +cve_numcipio+",  cve_domicilio: " + cve_domicilio );
	$.ajax({
        url :'ServletBuscoMecanico', 
        data : "operacion=3"+"&cve_delegacion="+cve_estado+"&cve_numcipio="+cve_numcipio+"&cve_domicilio="+cve_domicilio,
        type : 'POST',
        dataType : 'json',
        success : function(json)
        {	
        	if( json.length > 0)
    		{
        	//alert("completo:" + json[0].nombreTaller);
        	setMarkers(json);
    		}else
    			{
    			IniciaMapa();
    			
    			}
        	
    	},
    	error : function(xhr, status, error) {
        	alert('Sitio en construcion');
        }
    }); 
	
}
 