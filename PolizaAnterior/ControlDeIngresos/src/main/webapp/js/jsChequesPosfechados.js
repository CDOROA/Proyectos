function MuestraPanel (div, menu)
{
	var divMostrar ="#" + div;
	var MunuActivo ="#" + menu;
    $(divMostrar).show();
    $(MunuActivo).css('background-color', '#337AB7');
}

function IniciaModuloChequesPosfechados(div, menu)
{
	MuestraPanel(div, menu);
	validarSessionDelUsuario();
	configurarMenuPrincipalXPerfilesUsuario();
	
	document.getElementById('popupFichaDeposito').style.display = 'none';
	$('#txt_fechaIni').val(ObtenerFechaActual());
	$('#txt_fechaFin').val(ObtenerFechaActual());
	var nivel = $("#nivelUsuario").val()
	var numerico = $("#datoNumerico").val();
	if (nivel.includes("0") && numerico.includes("0")) 
	{
		var estatusLength = document.getElementById('cmbEstatus').options.length;
		for (var i = 0; i < estatusLength; i++) 
		{
			if (i == 1)
			{
				$("#cmbEstatus").val(document.getElementById('cmbEstatus').options[i].value);
				break;
			}
		}
	}
	if (nivel.includes("1") && numerico.includes("0")) 
	{
		var nombre = $("#nombreUsuario").val();
		var cve_usu = $("#claveUsuario").val();
		$("#cmbUsuario").empty()
		  let $lider_list = $('#cmbUsuario option');
			$('#cmbUsuario').append($('<option />', {
		    text: cve_usu+" - "+nombre,
		    value: cve_usu+"*"+nombre,
		  }));
	}
	consultaChequesBD();
}

function consultaChequesBD()
{
	let fecha_ini = $('#txt_fechaIni').val();
	let fecha_fin = $('#txt_fechaFin').val();
	let estatus = $('#cmbEstatus').val();
	let banco = $('#cmbBanco').val();
	let usuario = $('#cmbUsuario').val();
	let cheque = $('#txt_cheque').val();
	let tipoFecha = obtenerTipoFecha();

	ConsultaDeCheques(fecha_ini,fecha_fin,estatus,banco,usuario,cheque,tipoFecha)
}

function limpiarCampos()
{
	$('#cmbEstatus').val("00");
	$('#cmbBanco').val("00");
	$('#cmbUsuario').val("00");
	$('#txt_cheque').val("");
	$('#txtFichaDepositos').val("");
}

function obtenerTipoFecha()
{
	var fecha = "00" ;
	 $('#cbxsTipoFecha input:checked').each(function () 
		{
			let tipo = $(this).attr('id');
	        if(tipo === "posfechadoFecha")
	        {
	        	fecha = "1";
	       	}
	        if(tipo === "depositoFecha")
	        {
	        	fecha = "2";
	        }
	        if(tipo === "pagoFecha")
	        {
	        	fecha = "3";
	        }
	    });
	 return fecha;
}

function ocultarBotones()
{
	$("#btnConfirmado").hide();
	$("#btnDepositado").hide();
	$("#btnTransito").hide();
	$("#btnCancelar").hide();
	$("#btnCancelarCredito").hide();
}

function validaNivelUsuario(estatus) 
{
	ocultarBotones()
	var nivel = $("#nivelUsuario").val()
	var numerico = $("#datoNumerico").val();
	switch (obtenerIdCombos(estatus,0)) 
	{
		case "0":
			if (nivel.includes("1"))
			{
			$("#btnConfirmado").show();
			$("#btnCancelarCredito").show();
			}
			else if (nivel.includes("0") && numerico.includes("1"))
			{
				$("#btnConfirmado").show();
				$("#btnCancelarCredito").show();
			}
			break;
		case "1":
			if (nivel.includes("0"))
			{
				if (numerico.includes("0") || numerico.includes("1")) 
				{
					$("#btnTransito").show();
				}
			}
			break;
		case "2":
			if (nivel.includes("0"))
			{
				if (numerico.includes("0") || numerico.includes("1")) 
				{
					$("#btnDepositado").show();
					$("#btnCancelar").show();
				}
			}
			break;
		default:
			break;
	}
}

function validarAlMenosUnCheckSeleccionado()
{
	let valoresCheck = [];
	$("input[type=checkbox]:checked").each(function()
			{
				if (this.value != "on")
				{
					valoresCheck.push(this.value);	
				}
			});
	if (valoresCheck == "")
	{		        	
		mostrarMsjAlert("Debe seleccionar al menos un registro");
		return "false"
	}
	else
	{
		return valoresCheck.toString()
	}
}

function mostrarAlertaFichaDeposito()
{
	if (validarAlMenosUnCheckSeleccionado() != "false")
	{		        	
		document.getElementById('popupFichaDeposito').style.display = 'block';
	}
}

function mostrarAlertaCancelacionCheque(valor,tipo)
{
	if (validarAlMenosUnCheckSeleccionado() != "false")
	{		        	
		document.getElementById('popupCancelacionPosfechado').style.display = 'block';
		if (tipo == "C")
		{
			$("#motivosCancelacionDepositado").hide();
			$("#motivosCancelacionCredito").show();
		}
		else
		{
			$("#motivosCancelacionCredito").hide();
			$("#motivosCancelacionDepositado").show();
		}
	}
}

function ConsultaDeCheques(fecha_ini,fecha_fin,estatus,banco,usuario,cheque,tipoFecha)
{
	ocultarMsj();
	$('#divChequesImpresion').empty();
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'ChequesPosfechadosServlet', 
	    data : "vista=ChequesPosfechados.jsp&operacion=ConsultaInicialCheques" +"&fecha_ini=" + fecha_ini  +"&fecha_fin=" + fecha_fin +"&estatus=" + obtenerIdCombos(estatus,0) +"&banco=" + obtenerIdCombos(banco,0) +"&usuario=" + obtenerIdCombos(usuario,0) +"&cheque=" + cheque +"&tipoFecha=" + tipoFecha, 
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	    	if(respuesta)
        	{
	        	document.getElementById('cargando').style.display = 'none';
	        	var data = respuesta;
	        	if( data.length > 0)
	        	{
	        		ocultarBotones()
		        	validaNivelUsuario(obtenerIdCombos(estatus,0));
	        		$("#datosJsGrid").val(JSON.stringify(data))
	        		llenaGridCheques(data,obtenerIdCombos(estatus,0))
	        		llenaDivDeImpresion(data)	
	        		
		        	MostrarDiv('dgChequesPosfechados');
		        	OcultarDiv('divMjsInfo');
		        	MostrarDiv('btnImprimirChequePostfechado');
	        	}
		        else
	        	{
		        	ocultarBotones()
		        	$("#dgChequesPosfechados").hide()
		        	mostrarMsjInfo(mensajeInfo(fecha_ini,fecha_fin,estatus,banco,usuario,cheque,tipoFecha));
		        	OcultarDiv('dgChequesDevueltos');
		        	OcultarDiv('btnImprimirChequePostfechado');
		        	document.getElementById('cargando').style.display = 'none';
	        	}
        	}
	        else
	        {		
	        	document.getElementById('cargando').style.display = 'none';
	        	$("#dgChequesPosfechados").hide()
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
				alert('Error al buscar cheques.')
		}
	})
	
}

function mensajeInfo(fecha_ini,fecha_fin,estatus,banco,usuario,cheque,tipoFecha)
{
	var descripcionFecha = "";
	if (!tipoFecha.includes("00")) 
	{
		if (tipoFecha.includes("1"))
		{
			descripcionFecha = " Fecha envio a caja: ";
		}
		else if (tipoFecha.includes("2"))
		{
			descripcionFecha = " Fecha de deposito: ";
		}
		else if (tipoFecha.includes("2"))
		{
			descripcionFecha = " Fecha de pago: ";
		}
	}
	var msj = "No se encontraron cheques posfechados en el sistema  con el periodo "+descripcionFecha+""+fecha_ini+" a "+fecha_fin;
	if (!estatus.includes("00"))
	{
		msj = msj + ", estatus:  "+obtenerIdCombos(estatus,1); 
	}
	if (!banco.includes("00")) 
	{
		msj = msj + ", banco: "+obtenerIdCombos(banco,1);
	}
	if (!usuario.includes("00"))
	{
		msj = msj + ", usuario: "+ obtenerIdCombos(usuario,0);
	}
	if (cheque.length > 0)
	{
		msj = msj + ", cheque: "+ cheque;
	}
	return msj+".";
}

function obtenerIdCombos(cmb,pocision) 
{
	
	var arraySplit = cmb.split("*");
	var descripcion = arraySplit[pocision];
	return descripcion;
}

function llenaGridCheques(data,estatus)
{
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	return $.grep(data, function (egreso) 
	    			{
	            return 	   (!filter.no.toString() || egreso.no.toString()  === filter.no.toString() || egreso.no.toString().includes(filter.no.toString()))
	             		 && (!filter.fecha_creacion.toUpperCase() || egreso.fecha_creacion.toUpperCase() === filter.fecha_creacion.toUpperCase() || egreso.fecha_creacion.toUpperCase() == filter.fecha_creacion.toUpperCase() || egreso.fecha_creacion.toUpperCase().includes(filter.fecha_creacion.toUpperCase()))
	             		  && (!filter.fecha_pago.toUpperCase() || egreso.fecha_pago.toUpperCase() === filter.fecha_pago.toUpperCase() || egreso.fecha_pago.toUpperCase() == filter.fecha_pago.toUpperCase() || egreso.fecha_pago.toUpperCase().includes(filter.fecha_pago.toUpperCase()))
	             		  && (!filter.fecha_administrador.toUpperCase() || egreso.fecha_administrador.toUpperCase() === filter.fecha_administrador.toUpperCase() || egreso.fecha_administrador.toUpperCase() == filter.fecha_administrador.toUpperCase() || egreso.fecha_administrador.toUpperCase().includes(filter.fecha_administrador.toUpperCase()))
	             		  &&(!filter.referencia.toString() || egreso.referencia.toString()  === filter.referencia.toString() || egreso.referencia.toString().includes(filter.referencia.toString()))
	             		  &&(!filter.num_agente.toString() || egreso.num_agente.toString()  === filter.num_agente.toString() || egreso.num_agente.toString().includes(filter.num_agente.toString()))
	             		  && (!filter.cve_usu_ecc.toUpperCase() || egreso.cve_usu_ecc.toUpperCase() === filter.cve_usu_ecc.toUpperCase() || egreso.cve_usu_ecc.toUpperCase() == filter.cve_usu_ecc.toUpperCase() || egreso.cve_usu_ecc.toUpperCase().includes(filter.cve_usu_ecc.toUpperCase()))
	             		  &&(!filter.num_cli.toString() || egreso.num_cli.toString()  === filter.num_cli.toString() || egreso.num_cli.toString().includes(filter.num_cli.toString()))
	             		  && (!filter.nombre_banco.toUpperCase() || egreso.nombre_banco.toUpperCase() === filter.nombre_banco.toUpperCase() || egreso.nombre_banco.toUpperCase() == filter.nombre_banco.toUpperCase() || egreso.nombre_banco.toUpperCase().includes(filter.nombre_banco.toUpperCase()))
	             		  &&(!filter.folio_caja.toString() || egreso.folio_caja.toString()  === filter.folio_caja.toString() || egreso.folio_caja.toString().includes(filter.folio_caja.toString()))
	             		  &&(!filter.folio_caja_cheque_nominativo.toString() || egreso.folio_caja_cheque_nominativo.toString()  === filter.folio_caja_cheque_nominativo.toString() || egreso.folio_caja_cheque_nominativo.toString().includes(filter.folio_caja_cheque_nominativo.toString()))
	             		  && (!filter.ficha_deposito.toUpperCase() || egreso.ficha_deposito.toUpperCase() === filter.ficha_deposito.toUpperCase() || egreso.ficha_deposito.toUpperCase() == filter.ficha_deposito.toUpperCase() || egreso.ficha_deposito.toUpperCase().includes(filter.ficha_deposito.toUpperCase()))
	             		  
	        });
	    },
	    insertItem: function (insertingClient) 
	    {
	    },
	    updateItem: function (IActualizado) /** actualiza  1102  1106 registro **/
	    {
	    },
	 };	
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#dgChequesPosfechados").jsGrid({
    	    		 width: "100%",
    	             height: "500px",
    	             editing: false,
    	             filtering: true,
    	             sorting: true,
    	             paging: true,
    	             selections: [],
    	             noDataContent: "NO HAY REGISTROS CON EL VALOR INGRESADO",
    	             pageSize: 800,
    	             controller: {
    	                 loadData: function () {
    	                     dataType: "json"
    	                
    	                     return data;
    	                 }
    	             },
    	             autoload: true,
    	             confirmDeleting: false,
    	             onRefreshed: function (args) { 
    	            	 /** seccion de totales **/
    	            	 let items = args.grid.option("data");
    	            	 let totales= calculaImportesTotalesDelGridPosfechados(items)
    	            	 console.log("totales: "+totales)
    	                 let $totalRow = $("<tr>").addClass("total-row");
    	                 args.grid._renderCells($totalRow, totales);
    	                 args.grid._content.append($totalRow);
    	             },
    	             controller: db,
    	             fields: 
    	             [
    	               	 { name: "cnt", type: "checkbox",width: 18, title: "C",visible:false, editing:false,  filtering: false,  
    	            		 headerTemplate: function(value,item) 
						     {
    	            			 var grid = this._grid;
    	            			 return `<input class="all" id="checkHeader" type="checkbox"  onclick="seleccionarTodosChecks()" ${grid.selections.length==grid.data.length?'checked':''} />`;	
						     },
						     itemTemplate: function(_, item) 
						     {
						    	 	if(item.fecha_administrador === ObtenerFechaActualSinFormato())
						    	 	{
						    	 		return `<input class="single" value=${item.no} type="checkbox" _isall=${false} ${this._grid.selections.some(no=>no==item.no	)?'checked':''} />`
						    	 	}
						    	 	
						   	 }
    	            	 },
    	            	 { name: "referencia", type: "text", title: "CHEQUE", align: 'center',width: 20,  editing: false, inserting: false, filtering: true},
    	            	 { name: "importe",  type: "text", title: "IMPORTE",  align: 'right',width: 25,  editing: false, inserting: false, filtering: false,                           	 
    	                	 itemTemplate: function (value, item) 
    	                	 {
    	                		 return agregarCommas(value);
    	                     }
    	                 },
    	            	 { name: "nombre_banco",  type: "text", title: "BANCO", align: 'left',width: 40,  editing: false, inserting: false, filtering: true},
    	            	 { name: "no", type: "text", title: "No.",  align: 'center', width: 13,  editing: false, inserting: false, filtering: true,css: 'EG_hide'},
    	                 { name: "fecha_creacion",  type: "text", title: "CREACION",width: 30,  align: 'center', editing: false, inserting: false, filtering: true},
    	                 { name: "fecha_administrador",  type: "text", title: "DEPOSITO",width: 30,  align: 'center', editing: false, inserting: false, filtering: true,                           	 
    	                	 itemTemplate: function (value, item) {
    	                		 return crearColumnaFechaPosfechado(value);
    	                     }
    	                 },
    	                 { name: "fecha_pago",  type: "text", title: "PAGO",width: 30,  align: 'center', editing: false, inserting: false, filtering: true},
    	                 { name: "num_agente", type: "text",title: "AV",  align: 'center',width: 23,  editing: false, inserting: false, filtering: true,itemTemplate: function (value, item) { return TooltipAgente(value, item)}},
    	                 { name: "cve_usu_ecc",  type: "text", title: "ECC", width: 23, align: 'center', editing: false, inserting: false, filtering: true,itemTemplate: function (value, item) { return TooltipEcc(value, item)}},
    	                 { name: "num_cli",  type: "text", title: "CTE",  align: 'center',width: 23, editing: false, inserting: false, filtering: true,itemTemplate: function (value, item) { return TooltipCliente(value, item)}},
    	                 { name: "folio_caja",  type: "text", title: "F. CAJA", align: 'center', width: 15, editing: false, inserting: false, filtering: true},
    	                 { name: "folio_caja_cheque_nominativo",  type: "text", title: "F. NOMINATIVO", align: 'center', width: 25, editing: false, inserting: false, filtering: true},
    	                 { name: "ficha_deposito",  type: "text", title: "FICHA DEPOSITO", align: 'center',width: 25,  editing: false, inserting: false, filtering: true, css: 'EG_hide'},
    	                 { name: "descripcion_estatus",  type: "text", title: "ESTATUS", align: 'center',width: 50,  editing: false, inserting: false, filtering: false,                           	 
    	                	 itemTemplate: function (value, item) {
    	                		 return crearColumnaEstatus(value,item);
    	                     }
    	                 },
    	                 { name: "descripcion_cancelacion",  type: "text", title: "CANCELADO", align: 'center',width: 50,  visible:false,editing: false, inserting: false, filtering: false,}, 
    	                 { name: "nombre_agente", type: "text", title: "", css: 'EG_hide'},
    	                 { name: "nombre_ecc", type: "text", title: "", css: 'EG_hide'},
    	                 { name: "nombre_cliente", type: "text", title: "", css: 'EG_hide'},
    	                 { name: "cve_banco", type: "text", title: "", css: 'EG_hide'},
    	                 { name: "id_estatus", type: "text", title: "", css: 'EG_hide'},
    	                 { name: "id_tipo_ingreso", type: "text", title: "", css: 'EG_hide'}
    	                 
	                 ],
	        	 })
	        	
	         });
     $(function ()
    		 {
    	 		ocultarColumnaCheck(estatus);
    	 	});
}

function llenaDivDeImpresion(dataCheques)
{
	$('#divChequesImpresion').empty();
	let total=0;
	let importe=0;

	let contenido = "<br>" +
						"<table  class='table table-striped'  style='width: 100%;margin-bottom: 0px'; >"+
						"<thead>"+
							"<tr>"+
								"<th style='background-color:#D3D3D3;font-family: arial; font-size: 12px; text-align: center;font-weight:bold;border:1px solid #D3D3D3'>CHEQUE</th>"+
								"<th style='background-color:#D3D3D3;font-family: arial; font-size: 12px; text-align: center;font-weight:bold;border:1px solid #D3D3D3'>IMPORTE</th>"+
								"<th style='background-color:#D3D3D3;font-family: arial; font-size: 12px; text-align: center;font-weight:bold;border:1px solid #D3D3D3'>BANCO</th>"+
								"<th style='background-color:#D3D3D3;font-family: arial; font-size: 12px; text-align: center;font-weight:bold;border:1px solid #D3D3D3'>F.CREACION</th>"+
								"<th style='background-color:#D3D3D3;font-family: arial; font-size: 12px; text-align: center;font-weight:bold;border:1px solid #D3D3D3'>F.DEPOSITO</th>"+
								"<th style='background-color:#D3D3D3;font-family: arial; font-size: 12px; text-align: center;font-weight:bold;border:1px solid #D3D3D3'>F. PAGO</th>"+
								"<th style='background-color:#D3D3D3;font-family: arial; font-size: 12px; text-align: center;font-weight:bold;border:1px solid #D3D3D3'>AV</th>"+
								"<th style='background-color:#D3D3D3;font-family: arial; font-size: 12px; text-align: center;font-weight:bold;border:1px solid #D3D3D3'>ECC</th>"+
								"<th style='background-color:#D3D3D3;font-family: arial; font-size: 12px; text-align: center;font-weight:bold;border:1px solid #D3D3D3'>CTE</th>"+
								"<th style='background-color:#D3D3D3;font-family: arial; font-size: 12px; text-align: center;font-weight:bold;border:1px solid #D3D3D3'>FOLIO CAJA</th>"+
								"<th style='background-color:#D3D3D3;font-family: arial; font-size: 12px; text-align: center;font-weight:bold;border:1px solid #D3D3D3'>F.NOMINATIVO</th>"+
								"<th style='background-color:#D3D3D3;font-family: arial; font-size: 12px; text-align: center;font-weight:bold;border:1px solid #D3D3D3'>ESTATUS</th>"+
							"</tr>"+
						"</thead>"+
						"<tbody>";
							
	
	for(let i=0; i < dataCheques.length ; i++)
	{
		total = parseFloat(total) +	parseFloat(dataCheques[i].importe.replace(',','').replace(',','').replace(',','').replace(',',''));
		importe = parseFloat(dataCheques[i].importe.replace(',','').replace(',','').replace(',','').replace(',',''));
		importe= validaImporte(importe);
		
		contenido += "<tr>"+
						"<td style='border:1px solid #D3D3D3; align='center' >"+
							"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'>" + dataCheques[i].referencia + "</label>"+
						"</td>"+
						"<td  style='border:1px solid #D3D3D3' align='right'>"+
							"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'>" + importe + "</label>"+
						"</td>"+
						"<td  style='border:1px solid #D3D3D3' align='left'>"+
							"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'>" + dataCheques[i].nombre_banco + "</label>"+
						"</td>"+
						"<td  style='border:1px solid #D3D3D3' align='center'>"+
							"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'>" + dataCheques[i].fecha_creacion + "</label>"+
						"</td>"+
						"<td  style='border:1px solid #D3D3D3'align='center' >"+
							"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'>" + dataCheques[i].fecha_administrador + "</label>"+
						"</td>"+
						"<td  style='border:1px solid #D3D3D3' align='center'>"+
							"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'>" + dataCheques[i].fecha_pago + "</label>"+
						"</td>"+
						"<td  style='border:1px solid #D3D3D3' align='center'>"+
							"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'>" + dataCheques[i].num_agente + "</label>"+
						"</td>"+
						"<td style='border:1px solid #D3D3D3' align='center'>"+
							"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'>" + dataCheques[i].cve_usu_ecc + "</label>"+
						"</td>"+
						"<td  style='border:1px solid #D3D3D3' align='center'>"+
							"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'>" + dataCheques[i].num_cli + "</label>"+
						"</td>"+
						"<td  style='border:1px solid #D3D3D3' align='center' >"+
							"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'>" + dataCheques[i].folio_caja + "</label>"+
						"</td>"+
						"<td  style='border:1px solid #D3D3D3' align='center'>"+
							"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'>" + dataCheques[i].folio_caja_cheque_nominativo + "</label>"+
						"</td>"+
						"<td  style='border:1px solid #D3D3D3' align='center'>"+
							"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'>" + dataCheques[i].descripcion_estatus + "</label>"+
						"</td>"+
					"</tr>";
	}
	
	total= validaImporte(total);	
	contenido += "<tr>"+
					"<td align='center' >"+
						"<label style='font-family: arial;font-size: 12px;color:black;font-weight:bold; margin: 0px'>TOTAL</label>"+
					"</td>"+
					"<td   align='right'>"+
						"<label style='font-family: arial;font-size: 12px;color:black;font-weight:bold; margin: 0px'>" + total+ "</label>"+
					"</td>"+
					"<td  colspan='10' align='left'>"+
						"<label style='font-family: arial;font-size: 12px;color:black;font-weight:normal; margin: 0px'></label>"+
					"</td>"+
				"</tr>"+
			"</tbody>"+
		"</table>";
	
	$("#divChequesImpresion").append(contenido);
}

function validaImporte(importe)
{
	if(importe == "") 
		importe= "0.00";
	else
		importe=agregarCommas(importe.toFixed(2));
	
	return importe;
}


function calculaImportesTotalesDelGridPosfechados(items)
{
	 let total = {
			 cnt: "", referencia: "TOTAL:", no:"", importe: 0, uname_br: "", fecha_creacion: "", fecha_administrador: "", fecha_pago: "", num_agente: "", cve_usu_ecc: "", num_cli: "", nombre_banco: "", 
			 folio_caja: "", folio_caja_cheque_nominativo: "", ficha_deposito: "", descripcion_estatus: "",  nombre_agente: "", nombre_ecc: "", cve_banco: "", id_estatus: "",id_tipo_ingreso: ""
     };
	  
	 items.forEach(function (item){
		 total.importe += parseFloat(item.importe.replace(',', ''));
     });
	 total.importe = "$ " + FormatearTotalesDeGridPosfechados(total.importe)
	 console.log(total.importe)
	 return total;
}

function FormatearTotalesDeGridPosfechados(importe)
{
	let importeTotalGrid = parseFloat(importe).toFixed(2);
	importeTotalGrid = agregarCommas(importeTotalGrid);
	return importeTotalGrid;
}

function crearColumnaEstatus(value,item)
{
	
	if (item.id_estatus == "0") {
        return $("<div>").attr("class", "ECP_PendienteDeDeposito").text(value);
    }
    else if (item.id_estatus == "1") {
        return $("<div>").attr("class", "ECP_ConfirmadoPorCliente").text(value);
    }
    else if (item.id_estatus == "9") {
        return $("<div>").attr("class", "ECP_Cancelado").text(value);
    }
    else if (item.id_estatus == "8") {
        return $("<div>").attr("class", "ECP_Cancelado").text(value);
    }
    else if (item.id_estatus == "2") {
        return $("<div>").attr("class", "ECP_TransitoDeDeposito").text(value);
    }
    else if (item.id_estatus == "3") {
        return $("<div>").attr("class", "ECP_DepositadoEnBanco").text(value);
    }
    else if (item.id_estatus == "4") {
        return $("<div>").attr("class", "ECP_ChequeNominativo").text(value);
    }
}

function detallesFechaVencida() 
{
	alert("La fecha del cheque ha vencido. \rPara dar mantenimiento al cheque es necesario que actualice la fecha en el Sistema de Pagos.")
}

function crearColumnaFechaPosfechado(value)
{
	var re = /-/g;
	var val =  value.replace(re,'');
	var actual = ObtenerFechaActualSinFormato().replace(re,'')
	if (parseInt(val) == parseInt(actual)) 
	{
        return $("<div>").attr("class", "ECP_FechaLimite").prop("title", "Fecha limite de cheque hoy.").text(value);
    }
	else if (parseInt(val) < parseInt(actual))
	{
		return $("<div onclick=\"detallesFechaVencida()\">").attr("class", "ECP_FechaVencida").prop("title", "Fecha de cheque vencida, haga clic para mas detalles.").text(value);
	}
	else 
	{
		return value
	}

}

function ObtenerFechaActualSinFormato()
{
	var fecha = new Date();
	let dia = String(fecha.getDate()).padStart(2, '0');
	let mes = String(fecha.getMonth() + 1).padStart(2, '0'); 
	let year = fecha.getFullYear();

	fecha = year + '-' + mes + '-' + dia;
	return fecha;
}

function ocultarColumnaCheck(estatus)
{
	ocultarBotones()
	var nivel = $("#nivelUsuario").val()
	var numerico = $("#datoNumerico").val();
	switch (obtenerIdCombos(estatus,0)) 
	{
		case "0":
			if (nivel.includes("1"))
			{
			$("#btnConfirmado").show();
			$("#btnCancelarCredito").show();
			$("#dgChequesPosfechados").jsGrid("fieldOption", "cnt", "visible", true);
			}
			else if (nivel.includes("0") && numerico.includes("1"))
			{
				$("#btnConfirmado").show();
				$("#btnCancelarCredito").show();
				$("#dgChequesPosfechados").jsGrid("fieldOption", "cnt", "visible", true);
			}
			break;
		case "1":
			if (nivel.includes("0"))
			{
				if (numerico.includes("0") || numerico.includes("1")) 
				{
					$("#btnTransito").show();
					$("#dgChequesPosfechados").jsGrid("fieldOption", "cnt", "visible", true);
				}
			}
			break;
		case "2":
			if (nivel.includes("0"))
			{
				if (numerico.includes("0") || numerico.includes("1")) 
				{
					$("#dgChequesPosfechados").jsGrid("fieldOption", "cnt", "visible", true);
					$("#btnDepositado").show();
					$("#btnCancelar").show();
				}
			}
			break;
		case "9":
			$("#dgChequesPosfechados").jsGrid("fieldOption", "descripcion_cancelacion", "visible", true);
			break;
		default:
			break;
	}	
}

function seleccionarTodosChecks()
{
	$('#dgChequesPosfechados input[type=checkbox]').on('change', function()
	{
		var checkbox = $(this),
		grid = checkbox.closest('#dgChequesPosfechados').data().JSGrid;
		if (checkbox.attr('class') == 'all') 
		{
			let checked = checkbox.is(":checked");
			grid.selections = checked ? grid.data : [];
			$.each($('#dgChequesPosfechados input[class=single]'), (i, el) => $(el).prop('checked', checked))
		}
		checkbox.closest('#dgChequesPosfechados').find('input.all').prop('checked', grid.selections.length == grid.data.length);   
	});
}

function ocultarMsj()
{
	OcultarDiv('divMjsAlert');
	OcultarDiv('divMjsSuccess');
}

function mostrarMsjAlert(mensaje)
{
	ocultarMsj()
	MostrarDiv('divMjsAlert');
	$("#lbMsjAlert").text(mensaje);
}

function mostrarMsjSuccess(mensaje)
{
	ocultarMsj()
	MostrarDiv('divMjsSuccess');
	$("#lbMsjSuccess").text(mensaje);
}

function validarFichaDeposito(estatus,fichaDeposito)
{
	actualizarEstatus(estatus,"0")
	$("#tablaFichaPosfechados").hide()
	$("#encabezadoPosfechado").show();
	
	/*fichaDeposito = $("#txtFichaDeposito").val();
	if (fichaDeposito != "")
	{
		actualizarEstatus(estatus,fichaDeposito)
		$("#tablaFichaPosfechados").hide()
		$("#encabezadoPosfechado").show();
	}
	else
	{
		alert("Debe ingresar la ficha deposito para continuar.")
	}	*/
}

function obtenerGrid(valores,estatus,fichaDeposito) 
{
	OcultarDiv('popupCancelacionPosfechado');
	var dataArray = $("#datosJsGrid").val();
	var jsonJsGrid = JSON.parse(dataArray);
	var valoresConCheck = valores.split(",");
	var valoresSinCheck = [];
	for (var i = 0; i < jsonJsGrid.length; i++) 
	{
		valoresSinCheck[i]=i;
	}
	for (var i = 0; i < valoresConCheck.length; i++)
	{
		var valor = valoresConCheck[i];
		valoresSinCheck = eliminarLosSeleccionados(valoresSinCheck, parseInt(valor));
	}
	for (var i = 0; i < valoresSinCheck.length; i++)
	{
		jsonJsGrid = actualizarJsonAlertaSleccionados(jsonJsGrid,{no:parseInt(valoresSinCheck[i])})
	}
	var data = jsonJsGrid;
	var estatusLength = document.getElementById('cmbEstatus').options.length;
	for (var i = 0; i < estatusLength; i++) 
	{
		if (i == obtenerEstatusAMandar(estatus))
		{
			$("#encabezadoPosfechado").text("Los siguientes posfechados cambiaran a estatus: " + obtenerIdCombos(document.getElementById('cmbEstatus').options[i].value,1).toUpperCase());
			break;
		}
	}
	document.getElementById('popupPosfechado').style.display = 'block';
	llenarGridAlertaPosfechados(data);
	MostrarDiv('dgAlertaPosfechados');
	validarBotonMostrarAlerta(estatus,fichaDeposito);
}

function obtenerEstatusAMandar(accionBoton)
{
	switch (accionBoton)
	{
		case "confirmado":
		return 1;
		break;
		case "transito":
		return 2;
		break;
		case "deposito":
		return 3;
		break;
		case "cancelar":
		return 19;
		break;
	}
}

function validarBotonMostrarAlerta(estatus,fichaDeposito) 
{
	$("#btnConfirmadoAlerta").hide();
	$("#btnDepositadoAlerta").hide();
	$("#btnTransitoAlerta").hide();
	$("#btnCancelarAlertaCaja").hide();
	$("#btnCancelarAlertaCredito").hide();
	if (estatus == "confirmado")
	{
		$("#btnConfirmadoAlerta").show();
	}
	if (estatus == "transito")
	{
		$("#btnTransitoAlerta").show();
	}
	if (estatus == "deposito")
	{
		$("#popupFichaDeposito").hide();
		$("#tablaFichaPosfechados").show()
		$("#encabezadoPosfechado").hide();
		var msj = "Se enviaran los sig. cheques a Depositado en Banco: <b id=\"textoFichaDepostio\" class=\"textoFichaDeposito\"> "+$("#txtFichaDeposito").val()+" </b>";
		msj = msj.replace("<b>", "<b>");
		msj = msj.replace("</b>", "</b>"); 
		$("#encabezadoPosfechado").html(msj);
		$("#btnDepositadoAlerta").show();
	}
	if (estatus == "cancelar")
	{
		var motivoCancelacion
		if (fichaDeposito == "C")
		{
			 motivoCancelacion = $('#cmbMotvCancelacionCredito').val();	
			 $("#btnCancelarAlertaCredito").show();
		}
		else 
		{
			 motivoCancelacion = $('#cmbMotvCancelacionCaja').val();	
			 $("#btnCancelarAlertaCaja").show();
		}
		
		var msj = "Se cancelaran los sig. cheques por : <b class=\"motivoCancelacion\"> "+obtenerIdCombos(motivoCancelacion,1)+" </b>";
		msj = msj.replace("<b>", "<b>");
		msj = msj.replace("</b>", "</b>"); 
		$("#encabezadoPosfechado").html(msj);
		
	}
	
}

function eliminarLosSeleccionados(array, elemento) 
{
	  var resultado = []
	  for (var i = 0; i < array.length; i++) 
	  {
	    if (array[i] !== elemento)
	    {
	      resultado.push(array[i]);
	    }
	  }
	  return resultado;
}

function actualizarJsonAlertaSleccionados(array,elem)
{		
	  return array.filter(e=> e.no!==elem.no);
}

function alertaActualizarEstatus(estatus,fichaDeposito)
{
	ocultarMsj();
	$('#txtFichaDeposito').val("");
	var checkSeleccionados = validarAlMenosUnCheckSeleccionado()
	if (checkSeleccionados != "false")
	{		
		obtenerGrid(checkSeleccionados,estatus,fichaDeposito);
	}

}

function llenarGridAlertaPosfechados(data)
{
	$(function ()
	 {
		 $("#dgAlertaPosfechados").jsGrid({
			 width: "95%",
	         height: "auto",
	         editing: false,
	         filtering: false,
	         sorting: false,
	         paging: false,
	         noDataContent: "NO HAY REGISTROS CON EL VALOR INGRESADO",
	         controller: {
	             loadData: function () {
	                 dataType: "json"
	                 return data;
	             }
	         },
	         autoload: true,
	         fields: 
	         [
	        	 { name: "no", type: "text", title: "No.",  align: 'center', width: 13,  editing: false, inserting: false, filtering: false,css: 'EG_hide'},
	        	 { name: "referencia", type: "text", title: "CHEQUE", align: 'center',width: 20,  editing: false, inserting: false, filtering: false},
	        	 { name: "importe",  type: "text", title: "IMPORTE",  align: 'right',width: 25,  editing: false, inserting: false, filtering: false},
	        	 { name: "nombre_banco",  type: "text", title: "BANCO", align: 'left',width: 40,  editing: false, inserting: false, filtering: false},
	        	 { name: "num_agente", type: "text",title: "AGENTE",  align: 'center',width: 23,  editing: false, inserting: false, filtering: false,itemTemplate: function (value, item) { return TooltipAgente(value,item)}},
	        	 { name: "num_cli",  type: "text", title: "CLIENTE",  align: 'center',width: 25,  editing: false, inserting: false, filtering: false,itemTemplate: function (value, item) { return TooltipCliente(value, item)}},
	             { name: "folio_caja",  type: "text", title: "FOLIO CAJA", align: 'center',width: 25,  editing: false, inserting: false, filtering: false},
	             { name: "nombre_cliente", type: "text", title: "", css: 'EG_hide'},
	             { name: "nombre_agente", type: "text", title: "", css: 'EG_hide'}
	         ],
		 })
		
	 	});
}

function actualizarEstatus(estatus,fichaDeposito)
{
	
	if (estatus == "deposito")
	{
		fichaDeposito = $("#txtFichaDeposito").val();
	}
	if (estatus == "cancelar" && fichaDeposito == "N")
	{
		fichaDeposito = obtenerIdCombos($("#cmbMotvCancelacionCaja").val(),0);
	}
	if (estatus == "cancelar" && fichaDeposito == "C")
	{
		fichaDeposito = obtenerIdCombos($("#cmbMotvCancelacionCredito").val(),0);
	}
	document.getElementById('popupPosfechado').style.display = 'none';
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'ChequesPosfechadosServlet', 
	    data : "vista=ChequesPosfechados.jsp&operacion=ActualizarEstatusCheques"+"&noCheques=" + validarAlMenosUnCheckSeleccionado()+"&estatus=" + estatus+"&fichaDeposito=" + fichaDeposito,
	    type : 'POST',
	    dataType : 'text', 
	    success : function(respuesta)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
	      	if(respuesta)
        	{
	      		var data = respuesta;
		       	if (data.length > 0)  
		       	{
		       		mostrarMsjSuccess(data);
		       		consultaChequesBD()
				}
		       	else
		       	{
		       		mostrarMsjAlert("Hubo un error al mandar los cheques");
		       	}
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
				alert('Error al buscar cheques.')
		}
	});
}

function obtenerDescripcionEstatus(estatus) 
{
	var splitEstatus = $("#lstEstatusPosfechados").val();
	var splitEstatus = splitEstatus.split(",");
	var nombre 
	splitEstatus.forEach( function(valor, indice, array) 
	{
		var nombreEstatus = valor.split("*");
		if (parseInt(nombreEstatus[0]) == parseInt(estatus)) 
		{
		 	nombre = nombreEstatus[1];
		}
	});
	return nombre
}

function columnaImporte(value)
{
    return $("<div>").attr("class", "EG_divTotalIngreso").text(FormatearTotalesDeGrid(value));
}

function FormatearTotalesDeGrid(importe)
{
	let importeTotalGrid = parseFloat(importe).toFixed(2);
	importeTotalGrid = agregarCommas(importeTotalGrid);
	return importeTotalGrid;
}

function TooltipAgente(value, item)
{
    	 return $("<div>").prop("title", ""+item.nombre_agente+"").text(value);    	 
}

function TooltipEcc(value, item)
{
    	 return $("<div>").prop("title", ""+item.nombre_ecc+"").text(value);    	 
}

function TooltipCliente(value, item)
{
    	 return $("<div>").prop("title", ""+item.nombre_cliente+"").text(value);
}
