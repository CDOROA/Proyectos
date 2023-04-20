function MuestraPanel (div, menu)
{
	var divMostrar ="#" + div;
	var MunuActivo ="#" + menu;
    $(divMostrar).show();
    $(MunuActivo).css('background-color', '#337AB7');
}

function IniciaModuloDeCorteDePolizaAnterior(div, menu)
{
	MuestraPanel(div, menu);
	inicializaVariables();
	inicializarSessionDelSemaforoDeIngresos();
	configurarMenuPrincipalXPerfilesUsuario();
}

function inicializaVariables()
{
	$('#txt_fechaPolizaAnterior').val(ObtenerFechaActual());
}

function consultaPolizaAnterior()
{
	alert( $("#txt_fechaPolizaAnterior").val())
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'GeneraPolizaAnterior', 
	    data : "vista=GeneraPolizaAnterior.jsp&operacion=ConsultaPolizaDiaAnterior&fechaPoliza=" + $("#txt_fechaPolizaAnterior").val() , 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(jsonPoliza)
	    { 
	    	document.getElementById('cargando').style.display = 'none';	    	
	    	let existePoliza = jsonPoliza.existePolizaAnterior;	
	    	alert(existePoliza)
	    	
	    	if(existePoliza == 'NO')
	    	{
	    		MostrarDiv('divConsultaCortesDePolizaAnteriores');
	    		OcultarDiv('divMjsErrorPolizaAnterior');
	    	}
	    	else if(existePoliza == 'NO_EXISTEN_REGISTROS')
	    	{
	    		$("#lb_textConfirPolizaAnterior").text('No Existe Informacion Para Generar la Polia del Dia ' + $("#txt_fechaPolizaAnterior").val())
	    		OcultarDiv('divConsultaCortesDePolizaAnteriores');	    		
	    		MostrarDiv('divMjsErrorPolizaAnterior');
	    	}
	    	else if(existePoliza == 'SI')
	    	{
	    		$("#lb_textConfirPolizaAnterior").text('Ya fue generada la Poliza Del Dia ' + $("#txt_fechaPolizaAnterior").val()  )
	    		OcultarDiv('divConsultaCortesDePolizaAnteriores');
	    		MostrarDiv('divMjsErrorPolizaAnterior');
	    	}
	    	
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			OultarDiv('divConsultaCortesDePolizaAnteriores');
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else			
				alert('Error al consultar Poliza.')
		}
	});
}




