function MuestraPanel (div, menu)
{
	var divMostrar ="#" + div;
	var MunuActivo ="#" + menu;
    $(divMostrar).show();
    $(MunuActivo).css('background-color', '#337AB7');
}

function IniciaModuloOtrosIngresos(div, menu)
{
	validarSessionDelUsuario();
	MuestraPanel(div, menu);
	$('#cmbFormaPago').val("0");
	$('#cmbBanco').val("0");
	$('#exitoInsertar').text("");
	OcultarDiv('divMjsErrorMantoConceptos');
	OcultarDiv('divMjsExitoMantoConceptos');
	
}

function obtienePrecio(tipo)
{
	validarSessionDelUsuario();
	var concepto = 0;
	concepto = (tipo == "mantenimiento") ? $('#cmbConceptoMto').val() : $('#cmbConcepto').val();
	
	$.ajax({
	    url :'ControlDeIngresosServlet', 
	    data : "vista=OtrosIngresos.jsp&operacion=ObtenerPrecio&concepto=" + concepto , 
	    type : 'POST',
	    dataType : 'text',
	    success : function(json)
	    { 
	    	 var arrayPrecio = json.split("|");
	    	 if(arrayPrecio[0] == 0)
	    		 $('#txtPrecio').attr('readonly', true);
	    	 else
	    		 $('#txtPrecio').attr('readonly', false);
	    	 
	    	 if(tipo == "mantenimiento")
	    		 $('#txtPrecioMto').val(arrayPrecio[1]);
	    	 else
	    		 $('#txtPrecio').val(arrayPrecio[1]);
	    	 
	    	 $('#txtCantidad').val("0");
	    	 $('#txtKilos').val("1");
	    	 $('#txtImporte').val("0");	    	 	    	 
		},
		error : function(xhr, status, error) 
		{
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else
				alert('Error al consultar precios.')
		}
	});
}

function CalculaImporte(event)
{
	let precio = $('#txtPrecio').val();  
	let cantidad = $('#txtCantidad').val();
	let importe =(precio * cantidad).toFixed(2);
	$('#txtImporte').val(importe);
}

function MostrarMtoPrecio()
{
	validarSessionDelUsuario();
	limpiarCamposDelMatenimiento();
    document.getElementById('popupEditaPrecios').style.display = 'block';
}

function OcultarMtoPrecio()
{
    document.getElementById('popupEditaPrecios').style.display = 'none';
}

function ValidaDivAMotrarEnManto(tipo)
{
	OcultarDiv('divCambioPrecio');
	OcultarDiv('divAltaConcepto');
	OcultarDiv('divMjsErrorMantoConceptos');
	OcultarDiv('divMjsExitoMantoConceptos');
	
	if(tipo == 'alta')
		MostrarDiv('divAltaConcepto');
	else
		MostrarDiv('divCambioPrecio');
}
	
function ActualizaPrecioConcepto()
{
	validarSessionDelUsuario();
	OcultarDiv('divMjsErrorMantoConceptos');
	OcultarDiv('divMjsExitoMantoConceptos');
	
	let concepto =  $('#cmbConceptoMto').val();
	let precio =  $('#txtPrecioMto').val();
	let uname_usu= $('#cmbCdoMto').val();
	
	if(ValidarDatosParaActualizarPrecio() == false)
		return
		
	$.ajax({
	    url :'ControlDeIngresosServlet', 
	    data : "vista=OtrosIngresos.jsp&operacion=ActualizaPrecio&concepto=" + concepto + "&precio=" + precio + "&uname_usu=" +  uname_usu, 
	    type : 'POST',
	    dataType : 'text',
	    success : function(respuesta)
	    { 
	    	if(respuesta)
	    	{
	    		MostrarDiv('divMjsExitoMantoConceptos');
	    		limpiarCamposDelMatenimiento();
	    		$('#lbMsjExitoMantoConceptos').text("El precio fue actualizado  ");
	    	}
	    	else
	    	{
	    		MostrarDiv('divMjsErrorMantoConceptos');
	    		$('#lbMsjErrorMantoConceptos').text("El precio NO se pudo actualizar.");
	    	}
		},
		error : function(xhr, status, error) 
		{
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='/ControlDeIngresos/';
			}
			else
				alert('Error al actualizar el concepto.')
		}
	});
}

function InsertaNuevoConcepto()
{
	validarSessionDelUsuario();
	OcultarDiv('divMjsErrorMantoConceptos');
	OcultarDiv('divMjsExitoMantoConceptos');
	
	
	if(validaDatosDelNuevoConcepto())
	{	
		let descripcion = $('#txtConceptoAlta').val();
		let reglaContable = $('#txtReglaContable').val();
		let precio = $('#txtPrecioAlta').val();
		let modificaPrecio = $('#cmbModificaPrecio').val();
		let uname_usu= $('#cmbAltaMto').val();
		
		 $.ajax({
			    url :'ControlDeIngresosServlet', 
			    data : "vista=OtrosIngresos.jsp&operacion=InsertaNuevoConcepto&descripcion=" + descripcion + "&reglaContable=" + reglaContable +"&precio=" + precio + "&modificaPrecio=" + modificaPrecio  + "&uname_usu=" +  uname_usu, 
			    type : 'POST',
			    dataType : 'text',
			    success : function(respuesta)
			    { 
			    	if(respuesta)
			    	{
			    		MostrarDiv('divMjsExitoMantoConceptos');
			    		limpiarCamposDelMatenimiento();
			    		$('#lbMsjExitoMantoConceptos').text("El concepto se guardo  ");
			    	}
			    	else
			    	{
			    		MostrarDiv('divMjsErrorMantoConceptos');
			    		$('#lbMsjErrorMantoConceptos').text("El concepto NO se pudo guardar.");
			    	}
			    	
				},
				error : function(xhr, status, error) 
				{
					if (xhr.status === 200)
					{
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href='/ControlDeIngresos/';
					}
					else
						alert('Error al insertar nuevo concepto.')
				}
			});
	}
	else
	{
		MostrarDiv('divMjsErrorMantoConceptos');
	}
	
}

function ValidarDatosParaActualizarPrecio()
{
	if( $('#cmbConceptoMto').val() <= 0)
	{
		MostrarDiv('divMjsErrorMantoConceptos');
		$('#lbMsjErrorMantoConceptos').text("Selecciona un concepto valido.");
		return false;
	}
	
	if( $('#txtPrecioMto').val() <= 0)
	{
		MostrarDiv('divMjsErrorMantoConceptos');
		$('#lbMsjErrorMantoConceptos').text("El precio NO puede ser 0.");
		return false;
	}
	
	return true;
}

function limpiarCamposDelMatenimiento()
{
	 MostrarDiv('divCambioPrecio');
	 OcultarDiv('divAltaConcepto');
	 $('#cmbConceptoMto').val(0);
	 $('#txtPrecioMto').val(0);
	 $('#mtoPrecios').attr( "checked", true );
	 $('#altaConcepto').attr('checked', false);
	 $('#cmbModificaPrecio').val(0);
	 $('#txtConceptoAlta').val("");
	 $('#txtReglaContable').val("");
	 $('#txtPrecioAlta').val(0);
}

function  validaDatosDelNuevoConcepto()
{
	if ($('#txtConceptoAlta').val() == "")
	{
		$('#lbMsjErrorMantoConceptos').text('Ingresa el nombre del concepto.')
		return false;
	}
	
	if ($('#txtReglaContable').val() == "")
	{
		$('#lbMsjErrorMantoConceptos').text('Ingresa la regal contable del concepto.')
		return false;
	}
	
	if ($('#txtPrecioAlta').val() <= 0)
	{
		$('#lbMsjErrorMantoConceptos').text('Ingresa el precio del concepto.')
		return false;
	}
	
	return true;
}


