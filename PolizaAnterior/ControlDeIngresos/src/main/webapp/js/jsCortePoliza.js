function MuestraPanel (div, menu)
{
	var divMostrar ="#" + div;
	var MunuActivo ="#" + menu;
    $(divMostrar).show();
    $(MunuActivo).css('background-color', '#337AB7');
}

function IniciaModuloDeCorteDePoliza(div, menu)
{
	MuestraPanel(div, menu);
	inicializaVariables();
	inicializarSessionDelSemaforoDeIngresos();
	configurarMenuPrincipalXPerfilesUsuario();
}

function inicializaVariables()
{
	$('#txt_fechaPoliza').val(ObtenerFechaActual());
	$('#lb_fechaActualPol').text(ObtenerFechaActual());
}

/*** GENERA POLIZAS DEL DIA ***/
function generaPolizaDiaEnBD()
{
	let importeBancosCheque = parseFloat($("#lb_totalBancosCheque").text()).toFixed(2);
	let importeTiposCheques = parseFloat($("#lb_totalTiposCheque").text()).toFixed(2);
	alert(importeBancosCheque)
	alert(importeTiposCheques)
	if(importeBancosCheque != importeTiposCheques)
	{
		alert('LA POLIZA NO SE PUEDE GENERAR. Los importes totales de cheque no coinciden , por favor verifica los datos.')	
		return;
	}
	
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'CortePoliza', 
	    data : "vista=CorteDePoliza.jsp&operacion=GeneraPolizaDelDia" , 
	    type : 'POST',
	    dataType : 'Text',
	    success : function(respuesta)
	    { 
	    	if(respuesta == "true")
	    	{
	    		document.getElementById('cargando').style.display = 'none';
	    		MostrarDiv('divAlertaGenerarPolizaDia')
	    	}
	    	else
	    	{
	    		document.getElementById('cargando').style.display = 'none';
	    		alert(respuesta);
	    	}
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else
				alert('Error al generar Poliza.')
				}
			});
	}

/*** CONSULTA  POLIZAS DEL DIA  NO SE USA ACTUALMENTE ***/
function consultaPolizaDelDiaBD()
{
	document.getElementById('cargando').style.display = 'block';	
	let fechaPoliza = $('#txt_fechaPoliza').val();
	
	$.ajax({
	    url :'CortePoliza', 
	    data : "vista=CorteDePoliza.jsp&operacion=ConsultaCortesDeCaja&fechaPoliza=" + fechaPoliza , 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	if(json.length > 0)
	        {
        		OcultarDiv('divMjsInfo');
        		llenaGridCortePoliza(json)
        		document.getElementById('cargando').style.display = 'none';
	        }
		    else
	        {
        		mostrarMsjInfo('No se encontro ninguna poliza con fecha  ' + fechaPoliza );
	        	OcultarDiv('dgCortePoliza');
	        	document.getElementById('cargando').style.display = 'none';
	        }
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else
				alert('Error al buscar cortes de caja.')
		}
	});
}

