/*****  ESTADO DE CUENTA GENERAL *****/

function validarContrasenaEdoCuenta() 
{
	var pass = $("#txt_valida_contrasena_edoCuenta").val();
	if (pass != '') 
	{
		document.getElementById('cargando').style.display = 'block';
		$("#alertEdoCuenta").hide()
		$.ajax({
		    url :'EstadoDeCuenta', 
		    data : "vista=CarritoDeCompras.jsp&operacion=ValidarPasswordEdoCuenta&pass="+pass, 
		    type : 'POST',
		    dataType : 'text',
		    success : function(respuesta)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if (respuesta == 1) 
		    	{
		    		consultaEstadoDeCuentaPorCte();
				}
		    	else
	    		{
		    		$("#alertEdoCuenta").show()
		    		$("#lbl_alert_edoCuenta").text("La contrase\u00F1a ingresada es incorrecta")
		    		$("#txt_valida_contrasena_edoCuenta").val("");
		    		document.getElementById("txt_valida_contrasena_edoCuenta").focus();
	    		}
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				if (xhr.status === 200)
				{
					alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
					window.location.href='http://www.cdoautopartes.com.mx/';
				}
				else
					alert('Error al consultar password para Estado de Cuenta.')
			}
		});
	}
	else
	{
		$("#alertEdoCuenta").show()
		$("#lbl_alert_edoCuenta").text("Ingrese una contrase\u00F1a")
		document.getElementById("txt_valida_contrasena_edoCuenta").focus();
	}
	
}

function mostrarModalContrasenaEdoCuenta() 
{
    $("#txt_valida_contrasena_edoCuenta").val("");
    $("#modalContrasenaEdoCuenta").modal("toggle");
     $('#modalContrasenaEdoCuenta').on('shown.bs.modal', function (e) {

 

          password1=document.getElementById("txt_valida_contrasena_edoCuenta");
          password1.type = "password";
            document.getElementById("txt_valida_contrasena_edoCuenta").focus();
          })
}


function consultaEstadoDeCuentaPorCte()
{
	$("#modalContrasenaEdoCuenta").modal("hide");
	$("#navbarsExample02").collapse('hide');
	  $("#navbarsExample02").removeClass("in");
	document.getElementById('cargando').style.display = 'block';
	ocultarControlesEstadoCuenta()
	OcultarDiv('div_SeccionDetalleEdoCuenta');
	OcultarDiv('divSeguimientoDePedido');
	$.ajax({
	    url :'EstadoDeCuenta', 
	    data : "vista=CarritoDeCompras.jsp&operacion=ConsultaEstadoDeCuenta", 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
	    	$("#lbSaldoVencido").text(json.saldo_vencido);
	    	$("#lbSaldoTotal").text(json.saldo_total);
	    	$("#lbFechaEstadoCuenta").text(ObtenerFechaActual() + " " + ObtenerHoraActual()) ;
	    	crearSessionFacturasDelDia(json.listFacturasDia);
	    	crearSeccionPedidosDelDia(json.listPedidosDia); 
	    	MostrarDiv("divEstadoDeCuenta");
	    	MostrarDiv('lb_verDetalleEdocuenta');
	    	OcultarDiv('lb_OcultarDetalleEdocuenta');
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='http://www.cdoautopartes.com.mx/';
			}
			else
				alert('Error al consultar Estado de Cuenta.')
		}
	});
}

function crearSessionFacturasDelDia(jsonFacturasdia)
{
	$('#lb_FacturasDiaEdoCuenta').text("");
	$('#div_FacturasDiaEdoCuenta').empty();
	let contenido = "";	
	if( jsonFacturasdia.length > 0)
	{
		contenido= "<table class='table'>"+
				"<tbody>";
		
		for(let i=0; i < jsonFacturasdia.length ; i++)
		{
		contenido += "<tr>" +
		 		 "<td style='font-family: arial; font-size: 12px; font-weight: normal;text-align: left;padding: 5px'> " + jsonFacturasdia[i].num_factura + "</td>" +
		 		 "<td style='font-family: arial; font-size: 12px; font-weight: normal;text-align: right;padding: 5px'> " + jsonFacturasdia[i].importe_factura + "</td>" +
		 	  "</tr>" ;
		}	
		contenido += 		"</tbody>"+
			"</table>"
		$('#lb_FacturasDiaEdoCuenta').text("FACTURAS DEL D\u00CDA");
	}
	
	 
	$("#div_FacturasDiaEdoCuenta").append(contenido);
}

function crearSeccionPedidosDelDia(jsonPedDia)
{
	$('#lb_PedidosDiaEdoCuenta').text("");
	$('#div_PedidosDiaEdoCuenta').empty();
	let contenido = "";	
	if( jsonPedDia.length > 0)
	{
		contenido = "<table class='table'>"+
		"<tbody>";

		for(let i=0; i < jsonPedDia.length ; i++)
		{
			contenido += "<tr>" +
			 		 "<td  colspan='2' style='font-family: arial; font-size: 12px; font-weight: normal;text-align: left;padding: 5px'> " + jsonPedDia[i].num_ped + " - " + jsonPedDia[i].hora_peido + "</td>" +
			 	  "</tr>" ;
		}	
		contenido += 		"</tbody>"+
					"</table>"
		$('#lb_PedidosDiaEdoCuenta').text("PEDIDOS DEL D\u00CDA");
	}
	$("#div_PedidosDiaEdoCuenta").append(contenido);
}



/*****  DETALLE DE ESTADO D ECUENTA  *****/
function consultaEstadoDeCuentaDetallePorCte()
{	
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'EstadoDeCuenta', 
	    data : "vista=CarritoDeCompras.jsp&operacion=ConsultaDetalleEstadoDeCuenta", 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	document.getElementById('cargando').style.display = 'none';	 
	    	crearSessionFacturasDetalle(json);	
	    	MostrarDiv('div_SeccionDetalleEdoCuenta');
	    	OcultarDiv('lb_verDetalleEdocuenta');
	    	MostrarDiv('lb_OcultarDetalleEdocuenta');
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='http://www.cdoautopartes.com.mx/';
			}
			else
				alert('Error al consultar Estado de Cuenta.')
		}
	});
}


function ocultarDetalleMovimientos()
{
	OcultarDiv('div_SeccionDetalleEdoCuenta');
	MostrarDiv('lb_verDetalleEdocuenta');
	OcultarDiv('lb_OcultarDetalleEdocuenta');
}

function crearSessionFacturasDetalle(ss)
{
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	        return $.grep(ss, function (ingreso) {
	            return (!filter.factura || ingreso.factura.indexOf(filter.factura) > -1)
	            &&(!filter.fecha_factura || ingreso.fecha_factura.indexOf(filter.fecha_factura) > -1)
	            &&(!filter.importe_real || ingreso.importe_real.indexOf(filter.importe_real) > -1)
	            &&(!filter.saldo || ingreso.saldo.indexOf(filter.saldo) > -1)
	            &&(!filter.dias_vencidos || ingreso.dias_vencidos.indexOf(filter.dias_vencidos) > -1)
	        });
	    }
	 };
	 window.db = db;
     db.ss;
	 $(function ()
    	     {
    	    	 $("#tb_FacturasDetalleEdoCuenta").jsGrid({
    	    		 width: "100%",
    	             height: "600px",
    	             editing: false,
    	             filtering: true,
    	             selecting: true,
    	             sorting: true ,
    	             paging: false,
    	             pageSize: 800,
    	             data: ss,
    	             controller: {
    	                 loadData: function () {
    	                     dataType: "json"
    	                     return data;
    	                 }
    	             },
    	             controller: db,
    	             rowClass: function(item, itemIndex) 
    	             { 
    	            	 
    	             },
    	             onRefreshed: function (args) { 
    	            
    	             },
    	             autoload: true,
    	             fields: 
    	             [
    	            	 { name: "factura", type: "text", title: "FACTURA", width:20, align: 'center',filtering: true},
    	            	 { name: "fecha_factura", type: "text", title: "FECHA FACTURA", width:20, align: 'center',filtering: true},
    	            	 { name: "importe_real", type: "text", title: "IMPORTE REAL", width:20, align: 'right',filtering: true},
    	            	 { name: "saldo", type: "text", title: "SALDO", width:20, align: 'right',filtering: true},
    	            	 { name: "dias_vencidos", type: "text", title: "DIAS VENCIDOS", width:20, align: 'center',filtering: true,itemTemplate: function (value, item) { 
    	            		 if (value > 0)
	            			{
					 			return $("<div>").text(value);
					 		}
					 		else
					 		{
					 			return $("<div>").attr("style", "color: white; background: #DC143C").text(value);
					 		}
    	            	 }}
  
    	             ],
	                 
	        	 });
	         });
	 
	 //aplicarEstiloTablaDetalleEdoCuenta();
}
/* ANTERIOR 
function crearSessionFacturasDetalle(jsonFacturasDetalle)
{
	
	$('#tb_FacturasDetalleEdoCuenta').empty();
	let contenido= "<table   class='table table-bordered' width:100%>" +
						"<theader >" +
							"<tr  style='position: sticky;top: 0; background-color:#045FB4; color:white;' >" +
								"<th id='th_facturasEdoCuenta1' class='ECC_lb_size_12_edo_Cuenta' style=' font-weight: bold;text-align: center;color:white'>Factura</th>" +
								"<th  id='th_facturasEdoCuenta1' class='ECC_lb_size_12_edo_Cuenta' style='font-weight: bold;text-align: center;color:white'>Fecha</th>" +
								"<th  class='ECC_lb_size_12_edo_Cuenta'  style='font-weight: bold;text-align: center;color:white'>Importe</th>" +
								"<th  class='ECC_lb_size_12_edo_Cuenta'  style='font-weight: bold;text-align: center;color:white'>Saldo</th>" +
								"<th  class='ECC_lb_size_12_edo_Cuenta'  style='font-weight: bold;text-align: center;color:white'>Vencido</th>" +
								"<th  class='ECC_lb_size_12_edo_Cuenta'  style=' font-weight: bold;text-align: center;color:white'>Dias a Pagar </th>" +
							"<tr>" +
						"</theader>"+
						"<tbody  >";
	
	for(let i=0; i < jsonFacturasDetalle.length ; i++)
	{
		 contenido += "<tr >" +
				 		 "<td  class='ECC_lb_size_12_edo_Cuenta'  style=' font-weight: normal;text-align: center;'> " + jsonFacturasDetalle[i].factura + "</td>" +
				 		 "<td  id='th_facturasEdoCuenta1'  class='ECC_lb_size_12_edo_Cuenta'  style=' font-weight: normal;text-align: center;'> " + jsonFacturasDetalle[i].fecha_factura + "</td>" +
				 		"<td  id='th_facturasEdoCuenta1' class='ECC_lb_size_12_edo_Cuenta'  style=' font-weight: normal;text-align: right;'> " + jsonFacturasDetalle[i].importe_real + "</td>" +
				 		"<td  class='ECC_lb_size_12_edo_Cuenta'  style='font-weight: normal;text-align: right;'> " + jsonFacturasDetalle[i].saldo + "</td>" +
				 		"<td class='ECC_lb_size_12_edo_Cuenta'   style=' font-weight: normal;text-align: center;'> " + jsonFacturasDetalle[i].fecha_vencimiento + "</td>" ;
				 		if(jsonFacturasDetalle[i].dias_vencidos > 0)
				 		{
				 			contenido +="<td class='ECC_lb_size_12_edo_Cuenta'   style=' font-weight: normal;text-align: center;'> " + jsonFacturasDetalle[i].dias_vencidos + "</td>" ;
				 		}
				 		else
				 		{
				 			contenido +="<td class='ECC_lb_size_12_edo_Cuenta'  style='font-weight: normal;text-align: center;background-color:#DC143C; color:white '> " + jsonFacturasDetalle[i].dias_vencidos + "</td>" ;
				 		}
				 		
				 		
		contenido += "</tr>" ;
	}	
	 contenido += 		"</tbody>"+
					"</table>"
	 
	$("#tb_FacturasDetalleEdoCuenta").append(contenido);
	 //aplicarEstiloTablaDetalleEdoCuenta();
}
*/


function ConsultaInformacionDeContacto()
{

	document.getElementById('cargando').style.display = 'block';

	$.ajax({
	    url :'TipoContacto', 
	    data : "operacion=ConsultaTipoContacto", 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	 CrearTablaContacto(json);
	    	document.getElementById('cargando').style.display = 'none';
	    	
	    	MostrarDiv('divTipoContacto');
	    	
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='http://www.cdoautopartes.com.mx/';
			}
			
		}
	});
}

function CrearTablaContacto(jsonTipoContacto)
{
	
	$('#tablaContacto').empty();
	var datos = jsonTipoContacto.datos;
	 var contenido= "<table class='table'><thead><tr><th scope='col' colspan='2'>Informaci&oacute;n de Contacto</th></tr></thead><tbody>"
	for(let i=0; i < datos.length ; i++)
	{
		var registro = datos[i]; 
		contenido += "<tr><td>"+ registro.descripcion+"</td><td>"+registro.datos +"</td></tr> "
	 
	}
	 contenido += "</tbody></table>";
	$('#tablaContacto').append(contenido);
}



function ConsultaCuentasDeposito()
{

	document.getElementById('cargando').style.display = 'block';

	$.ajax({
	    url :'CuentasDeposito', 
	    data : "operacion=ConsultaCuentasDeposito", 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    		    	
	    	 CrearTablaCuentasDeposito(json);
	    	document.getElementById('cargando').style.display = 'none';
	    	
	    	MostrarDiv('divCuentasDeposito');
	    	
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				window.location.href='http://www.cdoautopartes.com.mx/';
			}
			
		}
	});
}

function CrearTablaCuentasDeposito(jsonTipoContacto)
{
	
	$('#tablaCuentasDeposito').empty();
	var datos = jsonTipoContacto.datos;
 
	 var contenido= "<table class='table'><thead><tr>" +
	 		"<th scope='col'>Banco</th>" +
	 		"<th scope='col'>Sucursal</th>" +
	 		"<th scope='col'>Cuenta</th>" +
	 		"<th scope='col'>Clabe</th>" +
	 		"<th scope='col'>Rap</th>" +
	 		"<th scope='col'>Cie</th>" +
	 		"<th scope='col'>Contrato Daz</th>" +
	 		"</tr></thead><tbody>"
	for(let i=0; i < datos.length ; i++)
	{
		var registro = datos[i]; 
		contenido += "<tr><td>"+ registro.banco+"</td><td>"+registro.sucursal +"</td>"
		contenido += "<td>"+ registro.cuenta+"</td><td>"+registro.clabe +"</td>"
		contenido += "<td>"+ registro.rap+"</td><td>"+registro.cie +"</td>"
		contenido += "<td>"+ registro.contrato_daz+"</td></tr> "
	 
	}
	 contenido += "</tbody></table>";
	$('#tablaCuentasDeposito').append(contenido);
}



/*****  ACCIONES GENERALES DEL CARRITO *****/
function ocultarControlesEstadoCuenta()
{
	OcultarDiv("divConsultaPorAplicacion");
	OcultarDiv("divEstadoDeCuenta");
	OcultarDiv("divCarritoDeComprasArticulos");
	OcultarDiv("divSeguimientoOtrosPedido");
	
	$('#tbSugerencias').empty();
}