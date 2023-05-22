/***   INICIA MODULO DE LINEA BANCARIA  ***/
function MuestraPanel (div, menu)
{
	var divMostrar ="#" + div;
	var MunuActivo ="#" + menu;
    $(divMostrar).show();
    $(MunuActivo).css('background-color', '#337AB7');
}

function IniciaModuloDeLineaBancaria(div, menu)
{
	inicializaFechas();
	limpiarCombos();
	validarSessionDelUsuario();
	MuestraPanel(div, menu);
	obtieneLineasBancariasPendientesBD()
	obtieneConcentradoLineasBancariasPendientesBD();
	configurarMenuPrincipalXPerfilesUsuario();
	configuraModuloXPerfilDeUsuario();
	OcultarDiv('divPieDePagina');
}

function inicializaFechas()
{
	$('#txt_fechaIniConcentrado').val(ObtenerFechaActual());
	$('#txt_fechaFinConcentrado').val(ObtenerFechaActual());	
	$('#txt_fechaIniBanamex').val(ObtenerFechaActual());
	$('#txt_fechaFinBanamex').val(ObtenerFechaActual());
	$('#txt_fechaIniHSBC').val(ObtenerFechaActual());
	$('#txt_fechaFinHSBC').val(ObtenerFechaActual());
	$('#txt_fechaIniBBVA').val(ObtenerFechaActual());
	$('#txt_fechaFinBBVA').val(ObtenerFechaActual());
	$('#txt_fechaIniBanorte').val(ObtenerFechaActual());
	$('#txt_fechaFinBanorte').val(ObtenerFechaActual());
	$('#txt_fechaIniAzteca').val(ObtenerFechaActual());
	$('#txt_fechaFinAzteca').val(ObtenerFechaActual());
}

function limpiarCombos()
{
	$("#bancoDeposito").val(0)
	$("#cmbEstatusBanamex").val(0)
	$("#cmbUsuEcBanamex").val(0)
	$("#cmbTipoBanamex").val(0)
	
	$("#cmbEstatusHSBC").val(0)
	$("#cmbUsuEcHSBC").val(0)
	$("#cmbTipoHSBC").val(0)
	
	$("#cmbEstatusBBVA").val(0)
	$("#cmbUsuEcBBVA").val(0)
	$("#cmbTipoBBVA").val(0)
	
	$("#cmbEstatusBanorte").val(0)
	$("#cmbUsuEcBanorte").val(0)
	$("#cmbTipoBanorte").val(0)
		
	$("#cmbEstatusAzteca").val(0)
	$("#cmbUsuEcAzteca").val(0)
	$("#cmbTipoAzteca").val(0)
	
	$("#cmbEstatusConcentrado").val(1)
	$("#cmbNumeroAVBanamex").val(0)
	
	$("#cmbTipoBanamexCaja").val(0)
	$("#cmbTipoBbvaCaja").val(0)
	$("#cmbTipoHsbcCaja").val(0)
	$("#cmbTipoAztecaCaja").val(0)
	$("#cmbTipoBanorteCaja").val(0)	
	
	mostrarOcultarBotonesXEstatus("0",10)
	mostrarOcultarBotonesXEstatus("0",16)
	mostrarOcultarBotonesXEstatus("0",4)
	mostrarOcultarBotonesXEstatus("0",5)
	mostrarOcultarBotonesXEstatus("0",12)
	limpiarControlesMantenimiento()
}

/***  CONFIGURA  PERFIL DE USUARIO  ***/
function configuraModuloXPerfilDeUsuario()
{
	/** LOS PERFILES DE USUARIO PARA LOS GRIDS ESTAN EN EL EVENTO: mostrarColumnaXPerfilUsuario(); **/
	let nivelUsuario=$("#lbNivel_usuario").text();
	if(nivelUsuario == 0)
	{
		mostrarPerfilUsuarioCaja();
	}
	else if (nivelUsuario == 1) 
	{
		mostrarPerfilUsuarioCredito();
	}	
	else if (nivelUsuario == 2) 
	{
		mostrarPerfilUsuarioContabilidad();
	}
}

function mostrarPerfilUsuarioCaja()
{
	let datoNumerico = $("#lbDatoNumerico").text();
	MostrarDiv('div_SubirArchivosLineasBancarias');
	if($("#lbDatoNumerico").text() == 1)
	{
		MostrarDiv('div_taps_bancos_depositos');
		MostrarDiv('div_RESUMEN')
	}  
	else
	{ 
		MostrarDiv('div_taps_bancos_depositos');
		OcultarDiv('divAsignarLineaBanECR_Banamex')
		OcultarDiv('divAsignarLineaBanECR_BBVA')
		OcultarDiv('divAsignarLineaBanECR_HSBC')
		OcultarDiv('divAsignarLineaBanECR_Azateca')
		OcultarDiv('divAsignarLineaBanECR_Banorte')
		OcultarDiv('div_ActualizarClienteBanamex')	
		
		OcultarDiv('div_ActualizarAgenteBanamex')	
		OcultarDiv('div_ActualizarAgenteBbva')	
		OcultarDiv('div_ActualizarAgenteHsbc')	
		OcultarDiv('div_ActualizarAgenteAzteca')	
		OcultarDiv('div_ActualizarAgenteBanorte')		
		
		OcultarDiv('div_ActualizarClienteBanamex')
		OcultarDiv('div_ActualizarClienteBbva')
		OcultarDiv('div_ActualizarClienteHsbc')
		OcultarDiv('div_ActualizarClienteAzteca')
		OcultarDiv('div_ActualizarClienteBanorte')	
		
		OcultarDiv('divAsignarLineaBanECR_Banamex')
		OcultarDiv('divAsignarLineaBanECR_Bbva')
		OcultarDiv('divAsignarLineaBanECR_Hsbc')
		OcultarDiv('divAsignarLineaBanECR_Azteca')
		OcultarDiv('divAsignarLineaBanECR_Banorte')	
		OcultarDiv('div_RESUMEN')	
	}
}

function mostrarPerfilUsuarioCredito()
{
	let datoNumerico = $("#lbDatoNumerico").text();
	OcultarDiv('div_SubirArchivosLineasBancarias');
	MostrarDiv('div_taps_bancos_depositos');
	OcultarDiv('btn_actualizarSistema');
	
	if($("#lbDatoNumerico").text() == 1)
	{
		MostrarDiv('div_taps_bancos_depositos');
		MostrarDiv('btn_confirmaAsignacionEncargado')
		OcultarDiv('div_ActualizarPagoCajaBanamex')
		OcultarDiv('div_ActualizarPagoCajaHsbc')
		OcultarDiv('div_ActualizarPagoCajaBbva')
		OcultarDiv('div_ActualizarPagoCajaAzteca')
		OcultarDiv('div_ActualizarPagoCajaBanorte')
		MostrarDiv('div_RESUMEN')	
	}
	else
	{
		OcultarDiv('divAsignarLineaBanECR_Banamex');
		OcultarDiv('divAsignarLineaBanECR_Bbva');
		OcultarDiv('divAsignarLineaBanECR_Banorte');
		OcultarDiv('divAsignarLineaBanECR_Hsbc');
		OcultarDiv('divAsignarLineaBanECR_Azteca');
		OcultarDiv('div_ActualizarAgenteBanamex');
		OcultarDiv('div_ActualizarAgenteBbva');
		OcultarDiv('div_ActualizarAgenteBanorte');
		OcultarDiv('div_ActualizarAgenteHsbc');
		OcultarDiv('div_ActualizarAgenteAzteca');
		OcultarDiv('btn_QuitarPagoBanamex')
		OcultarDiv('btn_QuitarPagoBbva')
		OcultarDiv('btn_QuitarPagoBanorte')
		OcultarDiv('btn_QuitarPagoHsbc')
		OcultarDiv('btn_QuitarPagoAzteca')
		OcultarDiv('btn_confirmaAsignacionEncargado')	
		
		OcultarDiv('div_ActualizarPagoCajaBanamex')
		OcultarDiv('div_ActualizarPagoCajaHsbc')
		OcultarDiv('div_ActualizarPagoCajaBbva')
		OcultarDiv('div_ActualizarPagoCajaAzteca')
		OcultarDiv('div_ActualizarPagoCajaBanorte')
		
		OcultarDiv('div_ActualizarPagoCajaBanamex')
		
		
		OcultarDiv('div_RESUMEN')	
	}
}

function mostrarPerfilUsuarioContabilidad()
{
	MostrarDiv('div_taps_bancos_depositos');
	OcultarDiv('divAsignarLineaBanECR_Banamex')
	OcultarDiv('divAsignarLineaBanECR_BBVA')
	OcultarDiv('divAsignarLineaBanECR_HSBC')
	OcultarDiv('divAsignarLineaBanECR_Azateca')
	OcultarDiv('divAsignarLineaBanECR_Banorte')
	OcultarDiv('div_ActualizarClienteBanamex')	
	
	OcultarDiv('div_ActualizarAgenteBanamex')	
	OcultarDiv('div_ActualizarAgenteBbva')	
	OcultarDiv('div_ActualizarAgenteHsbc')	
	OcultarDiv('div_ActualizarAgenteAzteca')	
	OcultarDiv('div_ActualizarAgenteBanorte')		
	
	OcultarDiv('div_ActualizarClienteBanamex')
	OcultarDiv('div_ActualizarClienteBbva')
	OcultarDiv('div_ActualizarClienteHsbc')
	OcultarDiv('div_ActualizarClienteAzteca')
	OcultarDiv('div_ActualizarClienteBanorte')	
	
	OcultarDiv('divAsignarLineaBanECR_Banamex')
	OcultarDiv('divAsignarLineaBanECR_Bbva')
	OcultarDiv('divAsignarLineaBanECR_Hsbc')
	OcultarDiv('divAsignarLineaBanECR_Azteca')
	OcultarDiv('divAsignarLineaBanECR_Banorte')	
	OcultarDiv('div_RESUMEN')
	
	OcultarDiv('div_ActualizarPagoCajaBanamex')
	OcultarDiv('div_ActualizarPagoCajaHsbc')
	OcultarDiv('div_ActualizarPagoCajaBbva')
	OcultarDiv('div_ActualizarPagoCajaAzteca')
	OcultarDiv('div_ActualizarPagoCajaBanorte')
	OcultarDiv('btn_actualizarSistema');
	OcultarDiv('btn_QuitarPagoBanamex')
	OcultarDiv('btn_QuitarPagoBbva')
	OcultarDiv('btn_QuitarPagoBanorte')
	OcultarDiv('btn_QuitarPagoHsbc')
	OcultarDiv('btn_QuitarPagoAzteca')
	OcultarDiv('btn_confirmaAsignacionEncargado')	
	OcultarDiv('div_AplicarPagoBanamex')
	OcultarDiv('div_AplicarPagoHsbc')
	OcultarDiv('div_AplicarPagoBbva')
	OcultarDiv('div_AplicarPagoAzteca')
	OcultarDiv('div_AplicarPagoBanorte')
}


/*** SECCION SUBIR LINEA BANCARIA X BANCO ***/
function cargaArchivoLineaBancaria()
{
	document.getElementById('cargando').style.display = 'block';
	let archivo = $("#file").val();
	let bancoDeposito = $("#bancoDeposito").val();
	
	if(validaDatosSeleccionados(archivo, bancoDeposito))
	{
		let archivoValido = validarExtencionArchivo(archivo, bancoDeposito)
		
		if(archivoValido)
		{
			$.ajax({
			    url :'LineaBancaria', 
			    data : "vista=LineaBancaria.jsp&operacion=inicializaBanco" + "&bancoLineaBancaria=" + bancoDeposito,
			    type : 'POST',
			    dataType : 'text',
			    success : function(respuesta)
			    {
			    	var url = 'UploadFile';
					var formulario = document.getElementById('frmFileLineaBancaria');
					formulario.action = url;
					formulario.method = 'POST';
					formulario.submit();
					document.getElementById('cargando').style.display = 'none';
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
						alert('Error al actualizar ingreso.')
				}
			});
		}
		else
		{
			document.getElementById('cargando').style.display = 'none';
		}
	}
	else
	{
		document.getElementById('cargando').style.display = 'none';
	}
	
	
}

function validaDatosSeleccionados(archivo, bancoDeposito)
{
	if(bancoDeposito  == "0")
	{
		alert("Debes seleccionar un banco deposito.");
		return false;
	}
	else if(archivo  == "")
	{
		alert("Debes seleccionar un archivo.");
		return false;
	}
	
	else
	{
		return true;
	}
}

function validarExtencionArchivo(archivo , bancoDeposito)
{
	let extension = (archivo.substring(archivo.lastIndexOf("."))).toLowerCase();
	if(bancoDeposito == "10")
	{
		if(extension == ".txt")
		{
			return true;
		}	
		else
		{
			alert("El tipo de archivo seleccionado no es valido. Extenciones permitidas [.txt]");
			return false;
		}
	}
	else
	{
		if(extension == ".xlsx" ||  extension == ".xls")
		{
			return true;
		}
		else
		{
			alert("El tipo de archivo seleccionado no es valido. Extenciones permitidas [.xlsx | .xls ]");
			return false;
		}
	}
}


/*** SECCION CONSULTA LINEAS BANCARIAS PENDIENTES ***/
function obtieneLineasBancariasPendientesBD()
{
	$.ajax({
	    url :'LineaBancaria', 
	    data : "vista=LineaBancaria.jsp&operacion=obtieneLBXEstatus",
	    type : 'POST',
	    dataType : 'Json',
	    success : function(respuesta)
	    { 
	    	let dataBanamex = respuesta.linea_bancaria_banamex;
	    	let dataHsbc = respuesta.linea_bancaria_HSBC;
	    	let dataBBVA = respuesta.linea_bancaria_BBVA;
	    	let dataBanorte = respuesta.linea_bancaria_banorte;
	    	let dataAzteca = respuesta.linea_bancaria_azteca;
	    	validaSiSeMuestranLosGrids(dataBanamex, dataHsbc, dataBBVA, dataBanorte, dataAzteca)
	    	mostrarOcultarBotonesXEstatus("0",10)
	    	mostrarOcultarBotonesXEstatus("0",16)
	    	mostrarOcultarBotonesXEstatus("0",4)
	    	mostrarOcultarBotonesXEstatus("0",5)
	    	mostrarOcultarBotonesXEstatus("0",12)
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
				alert('Error al buscar ingresos en el sistema.')
		}
	});
}

function cargarLineaBanamexEnGrid(data)
{
	var db =
    {
        loadData: function (filter)/** seccion de filtros **/
        {
            return $.grep(data, function (ingreso) {
                return (!filter.num_cliente_banamex || ingreso.num_cliente_banamex.indexOf(filter.num_cliente_banamex) > -1)
                 		&& (!filter.num_agente_banamex || ingreso.num_agente_banamex === filter.num_agente_banamex)
                 		&& (!filter.fecha_pro_banamex || ingreso.fecha_pro_banamex === filter.fecha_pro_banamex)
                 		&& (!filter.fecha_banamex || ingreso.fecha_banamex.indexOf(filter.fecha_banamex) > -1)
                 		&& (!filter.autorizacion_banamex || ingreso.autorizacion_banamex.indexOf(filter.autorizacion_banamex) > -1)
                 		&& (!filter.sucursal_banamex || ingreso.sucursal_banamex === filter.sucursal_banamex)
                 		&& (!filter.referencia_numerica_banamex || ingreso.referencia_numerica_banamex === filter.referencia_numerica_banamex)
                 		&& (!filter.cve_usu_cr_banamex || ingreso.cve_usu_cr_banamex === filter.cve_usu_cr_banamex)
                 		&& (!filter.numero_cuenta_int_banamex || ingreso.numero_cuenta_int_banamex.indexOf(filter.numero_cuenta_int_banamex) > -1)
                 		&& (!filter.referencia_alfanumerica_banamex || ingreso.referencia_alfanumerica_banamex.indexOf(filter.referencia_alfanumerica_banamex) > -1)
                 		
            });
        },
        insertItem: function (insertingClient) {
            data.push(insertingClient);
        },
        updateItem: function (IActualizado) /** actualiza registro **/
        {
        	var d = $.Deferred();
        	let esCteValido = validaNumeroClienteIndividual(IActualizado.num_cliente_banamex);
        	if(esCteValido)
        	{
        		actualizaCteIndividualDeLineaBancariaXBanco(IActualizado.cve_banco_banamex, IActualizado.num_cliente_banamex, IActualizado.id_linea_bancaria_banamex)
        		d.resolve(IActualizado);
        	}
        	else
        	{
        		alert('El numero de cliente ingresado no es valido')
        		d.resolve(IPrevio);
        	}        	        	
        	return d.promise();
        },
     };
	 window.db = db;
     db.data;
     
     $(function ()
     {
    	 $("#grid_LineaBanamex").jsGrid({
    		 width: "98%",
             height: "580px",
             editing: true,
             filtering: true,
             sorting: true,
             paging: true,
             pageSize: 800,
             controller: 
             {
                 loadData: function () 
                 {
                     dataType: "json"
                     return data;
                 },
             },
             onItemUpdating: function (args) {
            	 IPrevio = args.previousItem;
             },
             autoload: true,
             confirmDeleting: false,
             controller: db,
             onRefreshed: function (args) { 
            	 /** seccion de totales **/
            	 let items = args.grid.option("data");
            	 let totales= calculaImportesTotalesDelGridBanamex(items)
                 let $totalRow = $("<tr>").addClass("total-row");
                 args.grid._renderCells($totalRow, totales);
                 args.grid._content.append($totalRow);
             },
             rowRenderer: function (item) 
             {
        		 var $row = $('<tr>');
                 this._renderCells($row, item);
                 
                 $addr = $row[0].children[6];
                 $($addr).attr("id", "popover");
                 $($addr).attr(item.nombre_cliente_banamex);
                 $($addr).attr("title", item.nombre_cliente_banamex);
                 
                 $addr2 = $row[0].children[24];
                 $($addr2).attr("id", "popover");
                 $($addr2).attr(item.nombre_usu_banamex);
                 $($addr2).attr("title", item.nombre_usu_banamex);
                 return $row;
             },
             fields: 
             [
            	 {
                     name: "checked", title: " ", align: "center", width: 12, editing: false,
                     itemTemplate: function (value, item) 
                     {
                    	 if(mostrarColumnaXPerfilUsuario(item.id_estatus_banamex))
                    	 {
	                    	 if(item.fecha_pro_banamex != "" &&  item.id_estatus_banamex <= 4)
	                    	 {
	                    		 return $("<input>").attr("type", "checkbox").attr("checked", false || value)
	                    		 .on("click", function (event) 
			                     {
			                    	 event.stopPropagation();
			                     })
			                     .on("change", function () 
			                     {
			                    		 let seleccionado = $(this).is(":checked");
				                         item.checked = $(this).is(":checked"); 
			                     });
	                    	 }
                    	 }
                     }
                 },
                 
                 { name: "id_linea_bancaria_banamex", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide'},
                 { name: "uname_banamex", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide' },
                 { name: "cve_banco_banamex", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide',},                 
                 { name: "cve_usu_banamex", type: "text", title: "", width:30, align: 'center', editing: false, inserting: false, filtering: true , css: 'EG_hide',},                 
                 { type: "control",title: " ",  width: 20,
                     itemTemplate: function (value, item) 
                     {
                    	 let nivelUsuario=$("#lbNivel_usuario").text();
                    	 let datoNumerico = $("#lbDatoNumerico").text();
                    	 if(nivelUsuario == 0 && datoNumerico == 0)
                    	 {
                    		//NO MUESTRA
                    	 }
                    	 else if(nivelUsuario == 2 )
                    	 {
                    		//NO MUESTRA
                    	 }
                    	 else
                    	 {
                    		 if (item.id_estatus_banamex <= 2 && item.fecha_pro_banamex != "")
                        	 {
                            	 let $result = $([]);
                            	 $result = $result.add(this._createEditButton(item));
                            	 return $result;
                        	 } 
                    	 }                         
                     },
                 },
                 { name: "num_cliente_banamex", type: "text", title:  "CLIENTE", width: 25, align: 'center', editing: true, inserting: false,filtering: true},
                 { name: "num_agente_banamex",  type: "text", title: "AV",width: 23, align: 'center', editing: false, inserting: false, filtering: true},
                 { name: "nombre_agente_banamex",  type: "text", title: " ",width: 23, align: 'center', editing: false, inserting: false, filtering: true, css: 'EG_hide',},
                 { name: "fecha_pro_banamex",  type: "text", title: "FECHA CREACION",width: 23, align: 'center', editing: false, inserting: false, filtering: true},
                 { name: "nombre_cliente_banamex", type: "text", title:  "NOMBRE CLIENTE", width: 30, align: 'left', editing: false, inserting: false,filtering: false,css: 'EG_hide' },
                 { name: "fecha_banamex", type: "text", title: "FECHA", width: 20, align: 'center', editing: false, inserting: false, filtering: true, },
                 { name: "numero_cuenta_int_banamex", type: "text", title: "NUM. CUENTA", width: 25, align: 'center', editing: false, inserting: false,filtering: true},
                 { name: "descripcion_banamex", type: "text", title: "DESCRIPCION", width: 60, align: 'left', editing: false, inserting: false,filtering: false },
                 { name: "cve_movimiento_banamex", type: "text", title: "", width: 40, align: 'right', editing: false, inserting: false, filtering: false,css: 'EG_hide'},
                 { name: "autorizacion_banamex", type: "text", title:  "AUTORI.", width: 25, align: 'center', editing: false, inserting: false,filtering: true},
                 { name: "ordenante_banamex", type: "text", title:  "ORDENANTE", width: 40, align: 'right', editing: false, inserting: false,filtering: false},
                 { name: "banco_emisor_banamex", type: "text", title:  "BANCO EMISOR", width: 40, align: 'right', editing: false, inserting: false,filtering: false},
                 { name: "sucursal_banamex", type: "text", title: "SUC.", width:17, align: 'center',editing: false, inserting: false, filtering: true},
                 { name: "referencia_numerica_banamex", type: "text", title:  "REFERENCIA NUM.", width: 35, align: 'center', editing: false, inserting: false,filtering: true},
                 { name: "referencia_alfanumerica_banamex", type: "text", title:  "REFERENCIA ALFA.", width: 60, align: 'left', editing: false, inserting: false,filtering: true},
                 { name: "importe_banamex", type: "text", title:  "IMPORTE", width: 33, align: 'right', editing: false, inserting: false,filtering: false},
                 { name: "autorizacion_banamex", type: "text", title:  "", width: 40, align: 'right', editing: false, inserting: false,filtering: false,css: 'EG_hide'},
                 { name: "id_estatus_banamex", type: "text", title:  "", width: 40, align: 'right', editing: false, inserting: false,filtering: false,css: 'EG_hide',
                	 editTemplate: function (value, item) {
	                	 crearInhabilitarColumnaXEstatus(item.id_estatus_banamex,item.fecha_pro_banamex, item )
                	 }
                 },
                 { name: "cve_usu_cr_banamex",  type: "text", title: "ECC", width: 23, align: 'center', editing: false, inserting: false, filtering: true },
                 { name: "nombre_usu_banamex", type: "text", title:  "ENCARGADO CR", width: 35, align: 'left', editing: false, inserting: false,filtering: false,css: 'EG_hide'},
                 { name: "id_tipo_linea_banamex", type: "text", title:  "", width: 40, align: 'right', editing: false, inserting: false,filtering: false, css: 'EG_hide'},
                 { name: "nombre_tipo_linea_banamex", type: "text", title:  "TIPO LINEA", width: 35, align: 'left', editing: false, inserting: false,filtering: false},
                 { name: "estatus_banamex", type: "text", title:  "ESTATUS", width:42, align: 'center', editing: false, inserting: false,filtering: false,
                	 
                	 itemTemplate: function (value, item) {
                         return crearColumnaEstatusParaGrid(item.id_estatus_banamex, item.estatus_banamex);
                     }
                 },
                 
                 
        	 ],
    	 });
     });
}

function cargarLineaHSBCEnGrid(data)
{
	var db =
    {
        loadData: function (filter)/** seccion de filtros **/
        {
            return $.grep(data, function (ingreso) {
                return (!filter.num_cliente_hsbc || ingreso.num_cliente_hsbc.indexOf(filter.num_cliente_hsbc) > -1)
                 		&& (!filter.num_agente_hsbc || ingreso.num_agente_hsbc === filter.num_agente_hsbc)
                 		&& (!filter.fecha_pro_hsbc || ingreso.fecha_pro_hsbc === filter.fecha_pro_hsbc)
                 		&& (!filter.fecha_valor_hsbc || ingreso.fecha_valor_hsbc.indexOf(filter.fecha_valor_hsbc) > -1)
                 		&& (!filter.referencia_cliente_hsbc || ingreso.referencia_cliente_hsbc.indexOf(filter.referencia_cliente_hsbc) > -1)
                 		&& (!filter.referencia_banco_hsbc || ingreso.referencia_banco_hsbc.indexOf(filter.referencia_banco_hsbc) > -1)
                 		&& (!filter.narrativa_hsbc || ingreso.narrativa_hsbc.indexOf(filter.narrativa_hsbc) > -1)
                 		&& (!filter.cve_usu_cr_hsbc || ingreso.cve_usu_cr_hsbc === filter.cve_usu_cr_hsbc)
            });
        },
        insertItem: function (insertingClient) {
            data.push(insertingClient);
        },
        updateItem: function (IActualizado) /** actualiza registro **/
        {
        	var d = $.Deferred();
        	let esCteValido = validaNumeroClienteIndividual(IActualizado.num_cliente_hsbc);
        	if(esCteValido)
        	{
        		actualizaCteIndividualDeLineaBancariaXBanco(IActualizado.cve_banco_hsbc, IActualizado.num_cliente_hsbc, IActualizado.id_linea_bancaria_hsbc);        		
        		d.resolve(IActualizado);
        	}
        	else
        	{
        		mostrarMsjError('El numero de cliente ingresado no es valido')
        		d.resolve(IPrevio);
        	}
        	return d.promise();
        },
     };
	 window.db = db;
     db.data;
     
     $(function ()
     {
    	 $("#grid_LineaHSBC").jsGrid({
    		 width: "98%",
             height: "580px",
             editing: true,
             filtering: true,
             sorting: true,
             paging: true,
             pageSize: 800,
             controller: 
             {
                 loadData: function () 
                 {
                     dataType: "json"
                     return data;
                 },
             },
             onRefreshed: function (args) { 
            	 /** seccion de totales **/
            	 let items = args.grid.option("data");
            	 let totales= calculaImportesTotalesDelGridHSBC(items)
                 let $totalRow = $("<tr>").addClass("total-row");
                 args.grid._renderCells($totalRow, totales);
                 args.grid._content.append($totalRow);
             },
             onItemUpdating: function (args) {
            	 IPrevio = args.previousItem;
             },
             autoload: true,
             confirmDeleting: false,
             controller: db,             
             rowRenderer: function (item) {
            	 if(item.num_cliente_hsbc != "")
            	{
            		 var $row = $('<tr>');
	                 this._renderCells($row, item);
	                 $addr = $row[0].children[6];
	                 $($addr).attr("id", "popover");
	                 $($addr).attr(item.nombre_cliente_hsbc);
	                 $($addr).attr("title", item.nombre_cliente_hsbc);
	               
	                 $addr2 = $row[0].children[19];
                     $($addr2).attr("id", "popover");
                     $($addr2).attr(item.nombre_usu_hsbc);
                     $($addr2).attr("title", item.nombre_usu_hsbc);
	                 return $row;
            	}
             },
             fields: 
             [
            	 {
                     name: "checked", title: " ", align: "center", width: 12, editing: false,
                     itemTemplate: function (value, item) 
                     {
                    	 if(mostrarColumnaXPerfilUsuario(item.id_estatus_hsbc))
                    	 {
	                    	 if(item.fecha_pro_hsbc != "" &&  item.id_estatus_hsbc <= 4)
	                    	 {
			            		 return $("<input>").attr("type", "checkbox")
			                         .attr("checked", false || value)
			                     .on("click", function (event) {
			                         event.stopPropagation();
			                     })
			                     .on("change", function () {
			                         var seleccionado = $(this).is(":checked");
			                         item.checked = $(this).is(":checked");
			                     });
	                    	 }
                    	 }
                     }
                 },
                 { name: "id_linea_bancaria_hsbc", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide'},
                 { name: "uname_hsbc", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide' },
                 { name: "cve_banco_hsbc", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide',},                 
                 { name: "cve_usu_hsbc", type: "text", title: "", width:30, align: 'center', editing: false, inserting: false, filtering: true , css: 'EG_hide',},
                 { type: "control",title: " ",  width: 20,                	 
                	 itemTemplate: function (value, item) 
                     {
                    	 let nivelUsuario=$("#lbNivel_usuario").text();
                    	 let datoNumerico = $("#lbDatoNumerico").text();
                    	 if(nivelUsuario == 0 && datoNumerico == 0)
                    	 {
                    		//NO MUESTRA
                    	 }
                    	 else if(nivelUsuario == 2 )
                    	 {
                    		//NO MUESTRA
                    	 }
                    	 else
                    	 {
                    		 if (item.id_estatus_hsbc <= 2 && item.fecha_pro_hsbc != "")
                        	 {
                            	 let $result = $([]);
                            	 $result = $result.add(this._createEditButton(item));
                            	 return $result;
                        	 } 
                    	 }                         
                     },
                 },
                 { name: "num_cliente_hsbc", type: "text", title:  "CLIENTE", width: 20, align: 'center', editing: true, inserting: false,filtering: true},
                 { name: "num_agente_hsbc",  type: "text", title: "AV",width: 23, align: 'center', editing: false, inserting: false, filtering: true},
                 { name: "nombre_agente_hsbc",  type: "text", title: " ",width: 23, align: 'center', editing: false, inserting: false, filtering: true, css: 'EG_hide',},
                 { name: "fecha_pro_hsbc",  type: "text", title: "FECHA CREACION",width: 23, align: 'center', editing: false, inserting: false, filtering: true, },   
                 { name: "nombre_cliente_hsbc", type: "text", title:  "NOMBRE CTE", width: 30, align: 'left', editing: false, inserting: false,filtering: false,css: 'EG_hide'},
                 { name: "fecha_valor_hsbc", type: "text", title: "FECHA", width: 25, align: 'center', editing: false, inserting: false, filtering: true, },
                 { name: "referencia_banco_hsbc", type: "text", title: "REFERENCIA BANCO", width: 30, align: 'center', editing: false, inserting: false,filtering: true},
                 { name: "narrativa_hsbc", type: "text", title: "NARRATIVA", width: 70, align: 'left', editing: false, inserting: false,filtering: true },
                 { name: "referencia_cliente_hsbc", type: "text", title: "REFERENCIA CTE", width: 40, align: 'left', editing: false, inserting: false, filtering: true},
                 { name: "importe_credito_hsbc", type: "text", title:  "IMPORTE CRE.", width: 35, align: 'right', editing: false, inserting: false,filtering: false},
                 { name: "importe_debito_hsbc", type: "text", title:  "IMPORTE DEB.", width: 35, align: 'right', editing: false, inserting: false,filtering: false},
                 { name: "saldo_hsbc", type: "text", title:  "SALDO", width: 35, align: 'right', editing: false, inserting: false,filtering: false},
                 { name: "id_estatus_hsbc", type: "text", title: "SUC.", width:20, align: 'center',editing: false, inserting: false, filtering: true,css: 'EG_hide',
                	 editTemplate: function (value, item) {
	                	 crearInhabilitarColumnaXEstatus(item.id_estatus_hsbc,item.fecha_pro_hsbc, item )
                	 }
                 },
                 { name: "cve_usu_cr_hsbc",  type: "text", title: "ECC", width: 23, align: 'center', editing: false, inserting: false, filtering: true},
                 { name: "nombre_usu_hsbc", type: "text", title:  "ECC", width: 40, align: 'left', editing: false, inserting: false,filtering: false, css: 'EG_hide'},
                 { name: "id_tipo_linea_hsbc", type: "text", title:  "", width: 40, align: 'right', editing: false, inserting: false,filtering: false, css: 'EG_hide'},
                 { name: "nombre_tipo_hsbc", type: "text", title:  "TIPO LINEA", width: 30, align: 'left', editing: false, inserting: false,filtering: false},
                 { name: "estatus_hsbc", type: "text", title:  "ESTATUS", width:34, align: 'center', editing: false, inserting: false,filtering: false,
                	 itemTemplate: function (value, item) {
                         return crearColumnaEstatusParaGrid(item.id_estatus_hsbc, item.estatus_hsbc);
                     }	 
                 
                 },                
        	 ],
    	 });
     });
}

function cargarLineaBBVAEnGrid(data)
{
	var db =
    {
        loadData: function (filter)/** seccion de filtros **/
        {
            return $.grep(data, function (ingreso) {
                return (!filter.num_cliente_bbva || ingreso.num_cliente_bbva.indexOf(filter.num_cliente_bbva) > -1)
                 		&& (!filter.num_agente_bbva || ingreso.num_agente_bbva === filter.num_agente_bbva)
                 		&& (!filter.fecha_pro_bbva || ingreso.fecha_pro_bbva === filter.fecha_pro_bbva)
                 		&& (!filter.sucursal_bbva || ingreso.sucursal_bbva.indexOf(filter.sucursal_bbva) > -1)
                 		&& (!filter.referencia_bbva || ingreso.referencia_bbva.indexOf(filter.referencia_bbva) > -1)
                 		&& (!filter.referencia_ampliada_bbva || ingreso.referencia_ampliada_bbva.indexOf(filter.referencia_ampliada_bbva) > -1)
                 		&& (!filter.cve_usu_cr_bbva || ingreso.cve_usu_cr_bbva === filter.cve_usu_cr_bbva)
            });
        },
        insertItem: function (insertingClient) {
            data.push(insertingClient);
        },
        updateItem: function (IActualizado) /** actualiza registro **/
        {
        	var d = $.Deferred();
        	let esCteValido = validaNumeroClienteIndividual(IActualizado.num_cliente_bbva);
        	if(esCteValido)
        	{
        		actualizaCteIndividualDeLineaBancariaXBanco(IActualizado.cve_banco_bbva, IActualizado.num_cliente_bbva, IActualizado.id_linea_bancaria_bbva);        		
        		d.resolve(IActualizado);
        	}
        	else
        	{
        		mostrarMsjError('El numero de cliente ingresado no es valido')
        		d.resolve(IPrevio);
        	}
        	return d.promise();
        },
     };
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#grid_LineaBbva").jsGrid({
    	    		 width: "98%",
    	             height: "580px",
    	             editing: true,
    	             filtering: true,
    	             sorting: true,
    	             paging: true,
    	             pageSize: 800,
    	             controller: 
    	             {
    	                 loadData: function () 
    	                 {
    	                     dataType: "json"
    	                     return data;
    	                 },
    	             },
    	             onItemUpdating: function (args) {
    	            	 IPrevio = args.previousItem;
    	             },
    	             autoload: true,
    	             confirmDeleting: false,
    	             controller: db,
    	             onRefreshed: function (args) { 
    	            	 /** seccion de totales **/
    	            	 let items = args.grid.option("data");
    	            	 let totales= calculaImportesTotalesDelGridBBVA(items)
    	                 let $totalRow = $("<tr>").addClass("total-row");
    	                 args.grid._renderCells($totalRow, totales);
    	                 args.grid._content.append($totalRow);
    	             },
    	             rowRenderer: function (item) {
    	            	 
    	            		 var $row = $('<tr>');
    		                 this._renderCells($row, item);
    		                 $addr = $row[0].children[6];
    		                 $($addr).attr("id", "popover");
    		                 $($addr).attr(item.nombre_cliente_bbva);
    		                 $($addr).attr("title", item.nombre_cliente_bbva);
    		                 
    		                 $addr2 = $row[0].children[19];
    	                     $($addr2).attr("id", "popover");
    	                     $($addr2).attr(item.nombre_usu_bbva);
    	                     $($addr2).attr("title", item.nombre_usu_bbva);
    		                 
    		                 return $row;
    	             },
    	             fields: 
    	             [
    	            	 {
    	                     name: "checked", title: " ", align: "center", width: 12, editing: false,
    	                     itemTemplate: function (value, item) 
    	                     {
    	                    	 if(mostrarColumnaXPerfilUsuario(item.id_estatus_bbva))
    	                    	 {
    	                    		 if(item.fecha_pro_bbva != "" &&  item.id_estatus_bbva <= 4)
    		                    	 {
    				            		 return $("<input>").attr("type", "checkbox")
    				                         .attr("checked", false || value)
    				                     .on("click", function (event) {
    				                         event.stopPropagation();
    				                     })
    				                     .on("change", function () {
    				                         var seleccionado = $(this).is(":checked");
    				                         item.checked = $(this).is(":checked");
    				                     });
    		                    	 }
    	                    	 }
    	                     }
    	                 },
    	                 { name: "id_linea_bancaria_bbva", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide'},
    	                 { name: "uname_bbva", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide' },
    	                 { name: "cve_banco_bbva", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide',},                 
    	                 { name: "cve_usu_bbva", type: "text", title: "", width:30, align: 'center', editing: false, inserting: false, filtering: true , css: 'EG_hide',},
    	                 { type: "control",title: " ",  width: 20,
    	                	 itemTemplate: function (value, item) 
    	                     {
    	                    	 let nivelUsuario=$("#lbNivel_usuario").text();
    	                    	 let datoNumerico = $("#lbDatoNumerico").text();
    	                    	 if(nivelUsuario == 0 && datoNumerico == 0)
    	                    	 {
    	                    		//NO MUESTRA
    	                    	 }
    	                    	 else if(nivelUsuario == 2 )
    	                    	 {
    	                    		//NO MUESTRA
    	                    	 }
    	                    	 else
    	                    	 {
    	                    		 if (item.id_estatus_bbva <= 2 && item.fecha_pro_bbva != "")
    	                        	 {
    	                            	 let $result = $([]);
    	                            	 $result = $result.add(this._createEditButton(item));
    	                            	 return $result;
    	                        	 } 
    	                    	 }                         
    	                     },
    	                 },
    	                 { name: "num_cliente_bbva", type: "text", title:  "CLIENTE", width: 20, align: 'center', editing: true, inserting: false,filtering: true},                 
    	                 { name: "num_agente_bbva",  type: "text", title: "AV",width: 23, align: 'center', editing: false, inserting: false, filtering: true},
    	                 { name: "nombre_agente_bbva",  type: "text", title: " ",width: 23, align: 'center', editing: false, inserting: false, filtering: true, css: 'EG_hide',},
    	                 { name: "fecha_pro_bbva",  type: "text", title: "FECHA CREACION",width: 23, align: 'center', editing: false, inserting: false, filtering: true},
    	                 { name: "nombre_cliente_bbva", type: "text", title:  "NOMBRE CTE.", width: 30, align: 'left', editing: false, inserting: false,filtering: false,css: 'EG_hide' },
    	                 { name: "sucursal_bbva", type: "text", title: "SUC.", width: 15, align: 'center', editing: false, inserting: false, filtering: true, },
    	                 { name: "fecha_operacion_bbva", type: "text", title: "FECHA", width: 20, align: 'center', editing: false, inserting: false,filtering: false},
    	                 { name: "codigo_bbva", type: "text", title: "CODIGO", width: 15, align: 'center', editing: false, inserting: false,filtering: false },
    	                 { name: "referencia_bbva", type: "text", title: "REFERENCIA ", width: 50, align: 'left', editing: false, inserting: false, filtering: true},
    	                 { name: "referencia_ampliada_bbva", type: "text", title:  "REFERENCIA AMP.", width: 60, align: 'left', editing: false, inserting: false,filtering: true},
    	                 { name: "concepto_bbva", type: "text", title:  "CONCEPTO", width: 50, align: 'left', editing: false, inserting: false,filtering: false},
    	                 { name: "importe_bbva", type: "text", title:  "IMPORTE", width: 30, align: 'right', editing: false, inserting: false,filtering: false},
    	                 { name: "id_estatus_bbva", type: "text", title: "", width:20, align: 'center',editing: false, inserting: false, filtering: true,css: 'EG_hide',
    	                	 editTemplate: function (value, item) {
    		                	 crearInhabilitarColumnaXEstatus(item.id_estatus_bbva,item.fecha_pro_bbva, item )
    	                	 }
    	                 },
    	                 { name: "cve_usu_cr_bbva",  type: "text", title: "ECC", width: 20, align: 'center', editing: false, inserting: false, filtering: true},
    	                 { name: "nombre_usu_bbva", type: "text", title:  "USU CR", width: 40, align: 'left', editing: false, inserting: false,filtering: false,css: 'EG_hide' },
    	                 { name: "id_tipo_linea_bbva", type: "text", title:  "", width: 40, align: 'right', editing: false, inserting: false,filtering: false, css: 'EG_hide'},
    	                 { name: "nombre_tipo_bbva", type: "text", title:  "TIPO LINEA", width: 30, align: 'left', editing: false, inserting: false,filtering: false},
    	                 
    	                 { name: "estatus_bbva", type: "text", title:  "ESTATUS", width: 35, align: 'center', editing: false, inserting: false,filtering: false,
    	                	 itemTemplate: function (value, item) {
    	                         return crearColumnaEstatusParaGrid(item.id_estatus_bbva, item.estatus_bbva);
    	                     }
    	                 },                
    	        	 ],
    	    	 });
    	     });
     
}

function cargarLineaAztecaEnGrid(data)
{
	var db =
    {
        loadData: function (filter)/** seccion de filtros **/
        {
            return $.grep(data, function (ingreso) {
                return (!filter.num_cliente_azteca || ingreso.num_cliente_azteca.indexOf(filter.num_cliente_azteca) > -1)
                 		&& (!filter.num_agente_azteca || ingreso.num_agente_azteca === filter.num_agente_azteca)
                 		&& (!filter.fecha_pro_azteca || ingreso.fecha_pro_azteca === filter.fecha_pro_azteca)
                 		&& (!filter.sucursal_operante_azteca || ingreso.sucursal_operante_azteca.indexOf(filter.sucursal_operante_azteca) > -1)
                 		&& (!filter.referencia_interna_azteca || ingreso.referencia_interna_azteca.indexOf(filter.referencia_interna_azteca) > -1)
                 		&& (!filter.referencia_01_azteca || ingreso.referencia_01_azteca.indexOf(filter.referencia_01_azteca) > -1)
                 		&& (!filter.cve_usu_cr_azteca || ingreso.cve_usu_cr_azteca === filter.cve_usu_cr_azteca)
            });
        },
        insertItem: function (insertingClient) {
            data.push(insertingClient);
        },
        updateItem: function (IActualizado) /** actualiza registro **/
        {
        	var d = $.Deferred();
        	let esCteValido = validaNumeroClienteIndividual(IActualizado.num_cliente_azteca);
        	if(esCteValido)
        	{
        		actualizaCteIndividualDeLineaBancariaXBanco(IActualizado.cve_banco_azteca, IActualizado.num_cliente_azteca, IActualizado.id_linea_bancaria_azteca);        		
        		d.resolve(IActualizado);
        	}
        	else
        	{
        		mostrarMsjError('El numero de cliente ingresado no es valido')
        		d.resolve(IPrevio);
        	}
        	return d.promise();
        },
     };
	 window.db = db;
     db.data;
     
     $(function ()
     {
    	 $("#grid_LineaAzteca").jsGrid({
    		 width: "98%",
             height: "580px",
             editing: true,
             filtering: true,
             sorting: true,
             paging: true,
             pageSize: 800,
             controller: 
             {
                 loadData: function () 
                 {
                     dataType: "json"
                     return data;
                 },
             },
             onItemUpdating: function (args) {
            	 IPrevio = args.previousItem;
             },
             
             onRefreshed: function (args) { 
            	 /** seccion de totales **/
            	 let items = args.grid.option("data");
            	 let totales= calculaImportesTotalesDelGridAzteca(items)
                 let $totalRow = $("<tr>").addClass("total-row");
                 args.grid._renderCells($totalRow, totales);
                 args.grid._content.append($totalRow);
             },
             autoload: true,
             confirmDeleting: false,
             controller: db,
             rowRenderer: function (item) {
            	 if(item.num_cliente_azteca != "")
            	{
            		 var $row = $('<tr>');
	                 this._renderCells($row, item);
	                 $addr = $row[0].children[6];
	                 $($addr).attr("id", "popover");
	                 $($addr).attr(item.nombre_cliente_azteca);
	                 $($addr).attr("title", item.nombre_cliente_azteca);
	                 
	                 $addr2 = $row[0].children[20];
                     $($addr2).attr("id", "popover");
                     $($addr2).attr(item.nombre_usu_azteca);
                     $($addr2).attr("title", item.nombre_usu_azteca);
	                 return $row;
            	}
             },
             fields: 
             [
            	 {
                     name: "checked", title: " ", align: "center", width: 12, editing: false,
                     itemTemplate: function (value, item) 
                     {
                    	 if(mostrarColumnaXPerfilUsuario(item.id_estatus_azteca))
                    	 {
	                    	 if(item.fecha_pro_azteca != "" &&  item.id_estatus_azteca <= 4)
	                    	 { 
			            		 return $("<input>").attr("type", "checkbox")
			                         .attr("checked", false || value)
			                     .on("click", function (event) {
			                         event.stopPropagation();
			                     })
			                     .on("change", function () {
			                         var seleccionado = $(this).is(":checked");
			                         item.checked = $(this).is(":checked");
			                     });
	                    	 }
                    	 }
                     }
                 },
                 { name: "id_linea_bancaria_azteca", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide'},
                 { name: "uname_azteca", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide' },
                 { name: "cve_banco_azteca", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide',},                 
                 { name: "cve_usu_azteca", type: "text", title: "", width:30, align: 'center', editing: false, inserting: false, filtering: true , css: 'EG_hide',},
                 { type: "control",title: " ",  width: 20,
                	 itemTemplate: function (value, item) 
                     {
                    	 let nivelUsuario=$("#lbNivel_usuario").text();
                    	 let datoNumerico = $("#lbDatoNumerico").text();
                    	 if(nivelUsuario == 0 && datoNumerico == 0)
                    	 {
                    		//NO MUESTRA
                    	 }
                    	 else if(nivelUsuario == 2 )
                    	 {
                    		//NO MUESTRA
                    	 }
                    	 else
                    	 {
                    		 if (item.id_estatus_azteca <= 2 && item.fecha_pro_azteca != "")
                        	 {
                            	 let $result = $([]);
                            	 $result = $result.add(this._createEditButton(item));
                            	 return $result;
                        	 } 
                    	 }                         
                     },
                 }, 
                 { name: "num_cliente_azteca", type: "text", title:  "CLIENTE", width: 20, align: 'center', editing: true, inserting: false,filtering: true},                 
                 { name: "num_agente_azteca",  type: "text", title: "AV",width: 23, align: 'center', editing: false, inserting: false, filtering: true},
                 { name: "nombre_agente_azteca",  type: "text", title: " ",width: 23, align: 'center', editing: false, inserting: false, filtering: true, css: 'EG_hide',},
                 { name: "fecha_pro_azteca",  type: "text", title: "FECHA CREACION",width: 23, align: 'center', editing: false, inserting: false, filtering: true},                    
                 { name: "nombre_cliente_azteca", type: "text", title:  "NOMBRE CTE", width: 30, align: 'left', editing: false, inserting: false,filtering: false,css: 'EG_hide'},
                 { name: "fecha_aplicacion_azteca", type: "text", title: "FECHA", width: 25, align: 'center', editing: false, inserting: false, filtering: false, },
                 { name: "sucursal_operante_azteca", type: "text", title: "SUC.", width: 30, align: 'center', editing: false, inserting: false,filtering: true},
                 { name: "referencia_interna_azteca", type: "text", title: "REFERENCIA INT.", width: 30, align: 'left', editing: false, inserting: false,filtering: true },
                 { name: "referencia_01_azteca", type: "text", title: "REFERENCIA 1 ", width: 30, align: 'left', editing: false, inserting: false, filtering: true},
                 { name: "referencia_02_azteca", type: "text", title:  "REFERENCIA 2", width: 35, align: 'center', editing: false, inserting: false,filtering: true,css: 'EG_hide'},
                 { name: "referencia_03_azteca", type: "text", title:  "REFERENCIA 3", width: 40, align: 'right', editing: false, inserting: false,filtering: false,css: 'EG_hide'},
                 { name: "referencia_04_azteca", type: "text", title:  "REFERENCIA 4", width: 40, align: 'right', editing: false, inserting: false,filtering: false,css: 'EG_hide'},
                 { name: "importe_movimiento_azteca", type: "text", title: "IMPORTE", width:30, align: 'right',editing: false, inserting: false, filtering: false},
                 { name: "id_estatus_azteca", type: "text", title:  "ESTATUS", width: 35, align: 'center', editing: false, inserting: false,filtering: true,css: 'EG_hide',
                	 editTemplate: function (value, item) {
	                	 crearInhabilitarColumnaXEstatus(item.id_estatus_azteca,item.fecha_pro_azteca, item )
                	 }
                 },
                 { name: "cve_usu_cr_azteca",  type: "text", title: "ECC", width: 23, align: 'center', editing: false, inserting: false, filtering: true },
                 { name: "nombre_usu_azteca", type: "text", title:  "USU. CR", width: 40, align: 'left', editing: false, inserting: false,filtering: false,css: 'EG_hide'},
                 { name: "id_tipo_linea_azteca", type: "text", title:  "", width: 40, align: 'right', editing: false, inserting: false,filtering: false, css: 'EG_hide'},                 
                 { name: "nombre_tipo_azteca", type: "text", title:  "TIPO LINEA", width: 30, align: 'left', editing: false, inserting: false,filtering: false},
                 
                 { name: "estatus_azteca", type: "text", title:  "ESTATUS", width: 35, align: 'center', editing: false, inserting: false,filtering: true,
                	 itemTemplate: function (value, item) {
                         return crearColumnaEstatusParaGrid(item.id_estatus_azteca, item.estatus_azteca);
                     }
                 },    
        	 ],
    	 });
     });
}

function cargarLineaBanorteEnGrid(data)
{
	var db =
    {
        loadData: function (filter)/** seccion de filtros **/
        {
            return $.grep(data, function (ingreso) {
                return (!filter.num_cliente_banorte || ingreso.num_cliente_banorte.indexOf(filter.num_cliente_banorte) > -1)
                 		&& (!filter.num_agente_banorte || ingreso.num_agente_banorte === filter.num_agente_banorte)
                 		&& (!filter.fecha_pro_banorte || ingreso.fecha_pro_banorte === filter.fecha_pro_banorte)
                 		&& (!filter.referencia_banorte || ingreso.referencia_banorte.indexOf(filter.referencia_banorte) > -1)
                 		&& (!filter.sucursal_banorte || ingreso.sucursal_banorte === filter.sucursal_banorte)
                 		&& (!filter.cve_usu_cr_banorte || ingreso.cve_usu_cr_banorte === filter.cve_usu_cr_banorte)
                 		&& (!filter.cheque_banorte || ingreso.cheque_banorte === filter.cheque_banorte)
            });
        },
        insertItem: function (insertingClient) {
            data.push(insertingClient);
        },
        updateItem: function (IActualizado) /** actualiza registro **/
        {
        	var d = $.Deferred();
        	let esCteValido = validaNumeroClienteIndividual(IActualizado.num_cliente_banorte);
        	if(esCteValido)
        	{
        		actualizaCteIndividualDeLineaBancariaXBanco(IActualizado.cve_banco_banorte, IActualizado.num_cliente_banorte, IActualizado.id_linea_bancaria_banorte);        		
        		d.resolve(IActualizado);
        	}
        	else
        	{
        		mostrarMsjError('El numero de cliente ingresado no es valido')
        		d.resolve(IPrevio);
        	}
        	return d.promise();
        },
     };
	 window.db = db;
     db.data;
     
     $(function ()
     {
    	 $("#grid_LineaBanorte").jsGrid({
    		 width: "98%",
             height: "580px",
             editing: true,
             filtering: true,
             sorting: true,
             paging: true,
             pageSize: 800,
             controller: 
             {
                 loadData: function () 
                 {
                     dataType: "json"
                     return data;
                 },
             },
             onItemUpdating: function (args) {
            	 IPrevio = args.previousItem;
             },
             onRefreshed: function (args) { 
            	 /** seccion de totales **/
            	 let items = args.grid.option("data");
            	 let totales= calculaImportesTotalesDelGridBanorte(items)
                 let $totalRow = $("<tr>").addClass("total-row");
                 args.grid._renderCells($totalRow, totales);
                 args.grid._content.append($totalRow);
             },
             autoload: true,
             confirmDeleting: false,
             controller: db,
             rowRenderer: function (item) {
            	 if(item.num_cliente_banorte != "")
            	{
            		 var $row = $('<tr>');
	                 this._renderCells($row, item);
	                 $addr = $row[0].children[7];
	                 $($addr).attr("id", "popover");
	                 $($addr).attr(item.nombre_cliente_banorte);
	                 $($addr).attr("title", item.nombre_cliente_banorte);
	                 
	                 $addr2 = $row[0].children[25];
                     $($addr2).attr("id", "popover");
                     $($addr2).attr(item.nombre_usu_banorte);
                     $($addr2).attr("title", item.nombre_usu_banorte);
	                 
	                 return $row;
            	}
             },
             fields: 
             [
            	 {
                     name: "checked", title: " ", align: "center", width: 12, editing: false,
                     itemTemplate: function (value, item) 
                     {
                    	 if(mostrarColumnaXPerfilUsuario(item.id_estatus_banorte))
                    	 {
	                    	 if(item.fecha_pro_banorte != ""  &&  item.id_estatus_banorte <= 4)
	                    	 { 
			            		 return $("<input>").attr("type", "checkbox")
			                         .attr("checked", false || value)
			                     .on("click", function (event) {
			                         event.stopPropagation();
			                     })
			                     .on("change", function () {
			                         var seleccionado = $(this).is(":checked");
			                         item.checked = $(this).is(":checked");
			                     });
	                    	 }
                    	 }
                     }
                 },
                 { name: "id_linea_bancaria_banorte", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide'},
                 { name: "uname_banorte", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide' },
                 { name: "cve_banco_banorte", type: "text",title: "", width: 40, align: 'center', editing: false, inserting: false, css: 'EG_hide',},                 
                 { name: "cve_usu_banorte", type: "text", title: "", width:30, align: 'center', editing: false, inserting: false, filtering: true , css: 'EG_hide',},
                 { type: "control",title: " ",  width: 20,
                	 itemTemplate: function (value, item) 
                     {
                    	 let nivelUsuario=$("#lbNivel_usuario").text();
                    	 let datoNumerico = $("#lbDatoNumerico").text();
                    	 if(nivelUsuario == 0 && datoNumerico == 0)
                    	 {
                    		//NO MUESTRA
                    	 }
                    	 else if(nivelUsuario == 2 )
                    	 {
                    		//NO MUESTRA
                    	 }
                    	 else
                    	 {
                    		 if (item.id_estatus_banorte <= 2 && item.fecha_pro_banorte != "")
                        	 {
                            	 let $result = $([]);
                            	 $result = $result.add(this._createEditButton(item));
                            	 return $result;
                        	 } 
                    	 }                         
                     },
                 },       
                 { name: "numero_cuenta_banorte", type: "text", title: "NUM. CUENTA", width: 25, align: 'center', editing: false, inserting: false, filtering: true,css: 'EG_hide' },
                 { name: "num_cliente_banorte", type: "text", title:  "CLIENTE", width: 20, align: 'center', editing: true, inserting: false,filtering: true},
                 { name: "nombre_cliente_banorte", type: "text", title:  "NOMBRE CTE.", width: 30, align: 'left', editing: false, inserting: false,filtering: false, css: 'EG_hide'},
                 { name: "num_agente_banorte",  type: "text", title: "AV",width: 23, align: 'center', editing: false, inserting: false, filtering: true},
                 { name: "nombre_agente_banorte",  type: "text", title: " ",width: 23, align: 'center', editing: false, inserting: false, filtering: true, css: 'EG_hide',},
                 { name: "fecha_pro_banorte",  type: "text", title: "FECHA CREACION",width: 23, align: 'center', editing: false, inserting: false, filtering: true}, 
                 { name: "fecha_operacion_banorte", type: "text", title: "FECHA OPER.", width: 30, align: 'center', editing: true, inserting: false,filtering:false, css: 'EG_hide'}, 
                 { name: "fecha_banorte", type: "text", title: "FECHA ", width: 30, align: 'center', editing: false, inserting: false,filtering: false },                 
                 { name: "referencia_banorte", type: "text", title: "REFERENCIA", width: 30, align: 'right', editing: false, inserting: false, filtering: true},
                 { name: "descripcion_banorte", type: "text", title:  "DESCRIPCION", width: 100, align: 'left', editing: false, inserting: false,filtering: false},
                 { name: "cod_transaccion_banorte", type: "text", title:  "COD TRANSAC.", width: 25, align: 'right', editing: false, inserting: false,filtering: false},
                 { name: "sucursal_banorte", type: "text", title:  "SUC.", width: 25, align: 'center', editing: false, inserting: false,filtering: true,},
                 { name: "depositos_banorte", type: "text", title: "DEPOSITOS", width:35, align: 'right',editing: false, inserting: false, filtering: false},
                 { name: "retiros_banorte", type: "text", title:  "RETIROS", width: 35, align: 'right', editing: false, inserting: false,filtering: true,css:'EG_hide'},    
                 { name: "saldo_banorte", type: "text", title:  "SALDO", width: 35, align: 'right', editing: false, inserting: false,filtering: true,css:'EG_hide'},    
                 { name: "movimiento_banorte", type: "text", title:  "MOVIMIENTOS", width: 30, align: 'center', editing: false, inserting: false,filtering: true,css:'EG_hide'}, 
                 { name: "descripcion_detallada_banorte", type: "text", title:  "DESCRIPCION DETALLADA", width: 90, align: 'left', editing: false, inserting: false,filtering: false}, 
                 { name: "cheque_banorte", type: "text", title:  "CHEQUE", width: 20, align: 'center', editing: false, inserting: false,filtering: true}, 
                 { name: "id_estatus_banorte", type: "text", title:  "ESTATUS", width: 30, align: 'center', editing: false, inserting: false,filtering: true,css:'EG_hide',
                	 editTemplate: function (value, item) {
	                	 crearInhabilitarColumnaXEstatus(item.id_estatus_banorte,item.fecha_pro_banorte, item )
                	 }
                 }, 
                 { name: "cve_usu_cr_banorte",  type: "text", title: "ECC", width: 23, align: 'center', editing: false, inserting: false, filtering: true },
                 { name: "nombre_usu_banorte", type: "text", title:  "ENCARGADO CR", width: 40, align: 'left', editing: false, inserting: false,filtering: false,css: 'EG_hide'},
                 { name: "id_tipo_linea_banorte", type: "text", title:  "", width: 40, align: 'right', editing: false, inserting: false,filtering: false, css: 'EG_hide'},
                 { name: "nombre_tipo_banorte", type: "text", title:  "TIPO LINEA", width:30, align: 'left', editing: false, inserting: false,filtering: false},                 
                 { name: "estatus_banorte", type: "text", title:  "ESTATUS", width: 42, align: 'center', editing: false, inserting: false,filtering: false,
                	 itemTemplate: function (value, item) {
                         return crearColumnaEstatusParaGrid(item.id_estatus_banorte, item.estatus_banorte);
                     }	 
                 }, 
        	 ],
    	 });
     });
}

function mostrarColumnaXPerfilUsuario(estatus)
{
	 let nivelUsuario=$("#lbNivel_usuario").text();
	 let datoNumerico = $("#lbDatoNumerico").text();
	 let mostrarColumna= false;
	 
	 if(nivelUsuario == 0 && datoNumerico == 1)
	 {
		 mostrarColumna = true;
	 }
	 else if (nivelUsuario == 0 && datoNumerico == 0 && estatus == 0)
	 {
		 mostrarColumna = true;
	 }
	 else if(nivelUsuario == 1 )
	 {
		 if(estatus >= 3 && datoNumerico == 0)
		 {
			 mostrarColumna=false;
		 }
		 else
		 {
			 mostrarColumna=true;
		 }
	 }
	 else if(nivelUsuario == 2 )
	 {
		 mostrarColumna=false;
	 }
	 
	 
	 
	 return mostrarColumna;
}


/*** SECCION TOTALES DEL GRID ***/
function calculaImportesTotalesDelGridBanamex(items)
{
	 let total =  {
			 id_linea_bancaria_banamex: "", uname_banamex: "", cve_banco_banamex: "", cve_usu_banamex: "", fecha_pro_banamex: "",cve_usu_cr_banamex:"", fecha_banamex:"TOTAL",
			 numero_cuenta_int_banamex: "", descripcion_banamex: "", cve_movimiento_banamex: "", autorizacion_banamex: "", ordenante_banamex: "", banco_emisor_banamex: "", 
			 sucursal_banamex: "", referencia_numerica_banamex: "", referencia_alfanumerica_banamex: "", importe_banamex: 0,  estatus_banamex: "", 
			 autorizacion_banamex: "", id_estatus_banamex: "", IsTotal: true
     };
	
	 items.forEach(function (item){
         total.importe_banamex += parseFloat(item.importe_banamex.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
     });
	  
	 total.importe_banamex = "$ " + FormatearTotalesDeGrid(total.importe_banamex.toFixed(2))
          
     return total;
}

function calculaImportesTotalesDelGridHSBC(items)
{
	 let total =  {
			 id_linea_bancaria_hsbc: "", uname_hsbc: "", cve_banco_hsbc: "", cve_usu_hsbc: "", fecha_pro_hsbc: "",cve_usu_cr_hsbc:"", fecha_valor_hsbc:"TOTAL",
			 referencia_banco_hsbc: "", narrativa_hsbc: "", referencia_cliente_hsbc: "", importe_credito_hsbc: 0, importe_debito_hsbc: 0, saldo_hsbc: 0, 
			 id_estatus_hsbc: "", estatus_hsbc: "", IsTotal: true
     };
	
	 items.forEach(function (item){
         total.importe_credito_hsbc += parseFloat(item.importe_credito_hsbc.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
         total.importe_debito_hsbc += parseFloat(item.importe_debito_hsbc.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
         total.saldo_hsbc += parseFloat(item.saldo_hsbc.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
     });
	  
	 total.importe_credito_hsbc = "$ " + FormatearTotalesDeGrid(total.importe_credito_hsbc.toFixed(2))
	 total.importe_debito_hsbc = "$ " + FormatearTotalesDeGrid(total.importe_debito_hsbc.toFixed(2))
	 total.saldo_hsbc = "$ " + FormatearTotalesDeGrid(total.saldo_hsbc.toFixed(2))
	           
     return total;
}

function calculaImportesTotalesDelGridBBVA(items)
{
	
	let total =  {
			id_linea_bancaria_bbva: "", uname_bbva: "", cve_banco_bbva: "", cve_usu_bbva: "", fecha_pro_bbva: "",cve_usu_cr_bbva:"",numero_cuenta_banorte:"", sucursal_bbva:"TOTAL",
			fecha_operacion_bbva: "", codigo_bbva: "", referencia_bbva: "", referencia_ampliada_bbva: "", concepto_bbva: "", importe_bbva: 0, 
			id_estatus_bbva: "", estatus_bbva: "", IsTotal: true
    };
	
	 items.forEach(function (item){
        total.importe_bbva += parseFloat(item.importe_bbva.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
    });
	  
	 total.importe_bbva = "$ " + FormatearTotalesDeGrid(total.importe_bbva.toFixed(2))
         
    return total;
}

function calculaImportesTotalesDelGridAzteca(items)
{
	 let total =  {
			 id_linea_bancaria_azteca: "", uname_azteca: "", cve_banco_azteca: "", cve_usu_azteca: "", fecha_pro_azteca: "",cve_usu_cr_azteca:"", fecha_aplicacion_azteca:"TOTAL",
			 sucursal_operante_azteca: "", referencia_interna_azteca: "", referencia_01_azteca: "", referencia_02_azteca: "", referencia_03_azteca: "", referencia_04_azteca: "", 
			 importe_movimiento_azteca: 0, id_estatus_azteca: "", estatus_azteca:"", IsTotal: true
     };
	
	 items.forEach(function (item){
         total.importe_movimiento_azteca += parseFloat(item.importe_movimiento_azteca.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
     });
	  
	 total.importe_movimiento_azteca = "$ " + FormatearTotalesDeGrid(total.importe_movimiento_azteca.toFixed(2))
          
     return total;
}

function calculaImportesTotalesDelGridBanorte(items)
{
	 let total =  {
			 id_linea_bancaria_banorte: "", uname_banorte: "", cve_banco_banorte: "", cve_usu_banorte: "", fecha_pro_banorte: "",cve_usu_cr_banorte:"", numero_cuenta_banorte:"TOTAL", fecha_operacion_banorte:"",
			 fecha_banorte: "", referencia_banorte: "", descripcion_banorte: "", cod_transaccion_banorte: "", sucursal_banorte: "", depositos_banorte: 0, retiros_banorte:0,saldo_banorte:0,
			 movimiento_banorte: "", descripcion_detallada_banorte: "", cheque_banorte:"",cheque_banorte:"", estatus_banorte:"", IsTotal: true
     };
	
	 items.forEach(function (item){
         total.depositos_banorte += parseFloat(item.depositos_banorte.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
         total.retiros_banorte += parseFloat(item.retiros_banorte.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
         total.saldo_banorte += parseFloat(item.saldo_banorte.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
     });
	  
	 total.depositos_banorte = "$ " + FormatearTotalesDeGrid(total.depositos_banorte.toFixed(2))
	 total.retiros_banorte = "$ " + FormatearTotalesDeGrid(total.retiros_banorte.toFixed(2))
	 total.saldo_banorte = "$ " + FormatearTotalesDeGrid(total.saldo_banorte.toFixed(2))
          
     return total;
}

function FormatearTotalesDeGrid(importe)
{
	let importeTotalGrid = parseFloat(importe).toFixed(2);
	importeTotalGrid = agregarCommas(importeTotalGrid);
	return importeTotalGrid;
}


/*** ESTILOS FILAS DEL GRID ***/
function crearColumnaEstatusParaGrid(id_estatus, estatus)
{
	if (id_estatus == "0") {
        return $("<div>").attr("class", "EG_IPendiente").text(estatus);
    }
    else if (id_estatus == "1") {
        return $("<div>").attr("class", "EG_IConfirmado").text(estatus);
    }
    else if (id_estatus == "2") {
        return $("<div>").attr("class", "EG_IAsignado").text(estatus);
    }
	
    else if (id_estatus == "3") {
        return $("<div>").attr("class", "EG_ICorteDeCaja").text(estatus);
    }
    else if (id_estatus == "4") {
        return $("<div>").attr("class", "EG_IPoliza").text(estatus);
    }	
    else if (id_estatus == "5") {
        return $("<div>").attr("class", "EG_ICancelado").text(estatus);
    }
}

function crearInhabilitarColumnaXEstatus(estatus, numCuenta, item)
{
	 let nivelUsuario=$("#lbNivel_usuario").text();
	 let datoNumerico = $("#lbDatoNumerico").text();
	
	if (nivelUsuario == 0 && datoNumerico == 0)
	{
		let $result = jsGrid.fields.text.prototype.editTemplate.apply(this, argumets);
        $result.prop("readonly", item.notEditable);
        $result.prop("readonly", item.deleteButton);
        return $result;
	}
	
	if (nivelUsuario == 2)
	{
		let $result = jsGrid.fields.text.prototype.editTemplate.apply(this, argumets);
        $result.prop("readonly", item.notEditable);
        $result.prop("readonly", item.deleteButton);
        return $result;
	}
	
	if(estatus > 2 && numCuenta!= "")
    {
    	let $result = jsGrid.fields.text.prototype.editTemplate.apply(this, argumets);
        $result.prop("readonly", item.notEditable);
        $result.prop("readonly", item.deleteButton);
        return $result;
    } 
}


/*** SECCION CONSULTA CONCENTRADO DE LINEA BANCARIA X ESTATUS ***/
function obtieneConcentradoLineasBancariasPendientesBD()
{
	if($("#cmbEstatusConcentrado").val() == "1")
		MostrarDiv('btn_confirmaAsignacionEncargado');
	else
		OcultarDiv('btn_confirmaAsignacionEncargado');
	
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'LineaBancaria', 
	    data : "vista=LineaBancaria.jsp&operacion=obtieneConcentradoLBXEstatus&IdEstatus=" + $("#cmbEstatusConcentrado").val()+ "&FechaIni=" + $("#txt_fechaIniConcentrado").val() + "&FechaFin=" + $("#txt_fechaFinConcentrado").val() ,
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	if(json.length > 0) 
	    	{
	    		cargarConcentradoDeLineaEnGrid(json)
		    	MostrarDiv('grid_concentradoDeBancosXUsu');
	    	}
	        else 
	        {
	    		OcultarDiv('grid_concentradoDeBancosXUsu');	
	    	}
	    	document.getElementById('cargando').style.display = 'none';
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
				alert('Error al buscar ingresos en el sistema.')
		}
	});
}

function cargarConcentradoDeLineaEnGrid(data)
{
	var db =
    {
        loadData: function (filter)/** seccion de filtros **/
        {
            return $.grep(data, function (ingreso) {
                return (!filter.cve_usu_cr || ingreso.cve_usu_cr.indexOf(filter.cve_usu_cr) > -1)
            });
        },
        insertItem: function (insertingClient) {
            data.push(insertingClient);
        },
        updateItem: function (IActualizado) /** actualiza registro **/
        {
        	
        },
     };
	 window.db = db;
     db.data;
     
     $(function ()
     {
    	 $("#grid_concentradoDeBancosXUsu").jsGrid({
    		 width: "95%",
             height: "580px",
             editing: true,
             filtering: true,
             sorting: true,
             paging: true,
             pageSize: 800,
             controller: 
             {
                 loadData: function () 
                 {
                     dataType: "json"
                     return data;
                 },
             },
             onRefreshed: function (args) { 
            	 // seccion de totales 
            	 let items = args.grid.option("data");
            	 let totales= calculaImportesTotalesDelGridConcentrado(items)
                 let $totalRow = $("<tr>").addClass("total-row");
                 args.grid._renderCells($totalRow, totales);
                 args.grid._content.append($totalRow);
             },
             onItemUpdating: function (args) {
            	 IPrevio = args.previousItem;
             },
             autoload: true,
             confirmDeleting: false,
             controller: db,
             fields: 
             [
                 { name: "cve_usu_cr", type: "text",title: "ECC", width: 40, align: 'center', editing: false, inserting: false, filtering: true,
                	 itemTemplate: function (value, item) {
                         return crearColumnaCveUcuCrParaGrid(item)
                      }
                 },
                 { name: "nombre_cve_usu", type: "text",title: "NOMBRE", width: 40, align: 'left', editing: false, inserting: false, filtering: false },
                 { name: "imp_banamex", type: "text",title: "BANAMEX", width: 40, align: 'right', editing: false, inserting: false, filtering: false },
                 { name: "imp_hsbc", type: "text",title: "HSBC", width: 40, align: 'right', editing: false, inserting: false, filtering: false },                 
                 { name: "imp_bbva", type: "text", title: "BBVA", width:30, align: 'right', editing: false, inserting: false, filtering: false },
                 { name: "imp_banorte",  type: "text", title: "BANORTE",width: 20, align: 'right', editing: false, inserting: false, filtering: false},
                 { name: "imp_azteca",  type: "text", title: "AZTECA", width: 23, align: 'right', editing: false, inserting: false, filtering: false},
                 { name: "imp_total", type: "text", title: "TOTAL", width: 25, align: 'right', editing: false, inserting: false, filtering: false},
                 { name: "id_estatus", type: "text", title: "", width: 25, align: 'right', editing: false, inserting: false, filtering: false,css: 'EG_hide',},
                 { name: "nombre_estatus", type: "text", title: "ESTATUS", width: 25, align: 'center', editing: false, inserting: false, filtering: false,
                	 itemTemplate: function (value, item) {
                         return crearColumnaEstatusParaGrid(item.id_estatus, value);
                     }	 
                 },
        	 ],
    	 });
     });
}

function calculaImportesTotalesDelGridConcentrado(items)
{
	 let total =  {
			 cve_usu_cr: "TOTAL", imp_banamex: 0, imp_hsbc: 0, imp_bbva: 0, imp_banorte: 0,imp_azteca:0, imp_total:0,  IsTotal: true
     };
	
	 items.forEach(function (item){
         total.imp_banamex += parseFloat(item.imp_banamex.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
         total.imp_hsbc += parseFloat(item.imp_hsbc.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
         total.imp_bbva += parseFloat(item.imp_bbva.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
         total.imp_banorte += parseFloat(item.imp_banorte.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
         total.imp_azteca += parseFloat(item.imp_azteca.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
         total.imp_total += parseFloat(item.imp_total.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
     });
	  
	 total.imp_banamex = "$ " + FormatearTotalesDeGrid(total.imp_banamex.toFixed(2))
	 total.imp_hsbc = "$ " + FormatearTotalesDeGrid(total.imp_hsbc.toFixed(2))
	 total.imp_bbva = "$ " + FormatearTotalesDeGrid(total.imp_bbva.toFixed(2))
	 total.imp_banorte = "$ " + FormatearTotalesDeGrid(total.imp_banorte.toFixed(2))
	 total.imp_azteca = "$ " + FormatearTotalesDeGrid(total.imp_azteca.toFixed(2))
	 total.imp_total = "$ " + FormatearTotalesDeGrid(total.imp_total.toFixed(2))
          
     return total;
}

function crearColumnaCveUcuCrParaGrid(item)
{
	if(item.cve_usu_cr != 'TOTAL')
	{
		return $("<button>").attr("class", "ELB_link").text(item.cve_usu_cr).on("click", function () {
			obtieneConcentradoLineasBancariasPendientesXCveUsuBD(item)
	    });
	}
	else
		 return $("<div>").attr("style", "divClasica").text(item.cve_usu_cr);
}



/*** SECCION CONSULTA CONCENTRADO DE LINEA BANCARIA X ESTATUS ***/
function obtieneConcentradoLineasBancariasPendientesXCveUsuBD(item)
{
	document.getElementById('cargando').style.display = 'block';	
	$.ajax({
	    url :'LineaBancaria', 
	    data : "vista=LineaBancaria.jsp&operacion=obtieneDetalleConcentradoLBXEstatus&CveUsuCr=" + item.cve_usu_cr,
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	cargarDetalleConcentradoDeLineaEnGrid(json);
		    $("#id_CveUsuCreditoDetalle").text(item.cve_usu_cr + " " + item.nombre_cve_usu);
		    MostrarDiv('divConcentradoXCveUsu');
	    	document.getElementById('cargando').style.display = 'none';
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
				alert('Error al buscar ingresos en el sistema.')
		}
	});
}

function cargarDetalleConcentradoDeLineaEnGrid(data)
{
	var db =
    {
        loadData: function (filter)/** seccion de filtros **/
        {
            return $.grep(data, function (ingreso) {
                return (!filter.cve_usu_cr || ingreso.cve_usu_cr.indexOf(filter.cve_usu_cr) > -1)
            });
        },
        insertItem: function (insertingClient) {
            data.push(insertingClient);
        },
        updateItem: function (IActualizado) /** actualiza registro **/
        {
        	
        },
     };
	 window.db = db;
     db.data;
     
     $(function ()
     {
    	 $("#grid_DetalleConcentradoDeBancosXUsu").jsGrid({
    		 width: "100%",
             height: "580px",
             editing: true,
             filtering: true,
             sorting: true,
             paging: true,
             pageSize: 800,
             controller: 
             {
                 loadData: function () 
                 {
                     dataType: "json"
                     return data;
                 },
             },
             onRefreshed: function (args) { 
            	 // seccion de totales 
            	 let items = args.grid.option("data");
            	 let totales= calculaImportesTotalesXUsuDelGridConcentrado(items)
                 let $totalRow = $("<tr>").addClass("total-row");
                 args.grid._renderCells($totalRow, totales);
                 args.grid._content.append($totalRow);
             },
             onItemUpdating: function (args) {
            	 IPrevio = args.previousItem;
             },
             autoload: true,
             confirmDeleting: false,
             controller: db,
             fields: 
             [
                 { name: "cve_usu_cr", type: "text",title: "USUARIO CR", width: 25, align: 'center', editing: false, inserting: false, filtering: true, },
                 { name: "cve_banco", type: "text",title: "BANCO", width: 30, align: 'center', editing: false, inserting: false, filtering: false,  css: 'EG_hide' },
                 { name: "nombre_banco", type: "text",title: "BANCO", width: 30, align: 'center', editing: false, inserting: false, filtering: false },
                 { name: "fecha", type: "text",title: "FECHA", width:30, align: 'center', editing: false, inserting: false, filtering: false },                 
                 { name: "sucursal", type: "text", title: "SUCURSAL", width:30, align: 'left', editing: false, inserting: false, filtering: false },
                 { name: "referencia1",  type: "text", title: "REFERENCIA",width: 100, align: 'left', editing: false, inserting: false, filtering: false},
                 { name: "referencia2",  type: "text", title: "REFERENCIA AMP.", width: 100, align: 'left', editing: false, inserting: false, filtering: false},
                 { name: "concepto", type: "text", title: "CONCEPTO", width: 100, align: 'left', editing: false, inserting: false, filtering: false},
                 { name: "importe", type: "text", title: "IMPORTE", width: 35, align: 'right', editing: false, inserting: false, filtering: false},
        	 ],
    	 });
     });
}

function calculaImportesTotalesXUsuDelGridConcentrado(items)
{
	 let total =  {
			 cve_usu_cr: "TOTAL", cve_banco: "", nombre_banco: "", fecha: "", sucursal: "",referencia1: "", referencia2: "", concepto:"",  importe:0,  IsTotal: true
     };
	
	 items.forEach(function (item){
         total.importe += parseFloat(item.importe.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
     });
	  
	 total.importe = "$ " + FormatearTotalesDeGrid(total.importe.toFixed(2))    
	 $("#id_TotalCveUsuCreditoDetalle").text(total.importe)
	 
     return total;
}


/*** SECCION CONSULTA LINEA BANCARIA POR ID BANCO ***/
function consultaLineaBancariaBanamex()
{
	limpiarControlesMantenimiento()
	document.getElementById('cargando').style.display = 'block';	
	$.ajax({
	    url :'LineaBancaria', 
	    data : "vista=LineaBancaria.jsp&operacion=obtieneLineaBancariaBanamex&IdEstatus=" + $("#cmbEstatusBanamex").val() +"&fechaIni= " +  $("#txt_fechaIniBanamex").val() + "&fechaFin=" + $("#txt_fechaFinBanamex").val(),
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	  $("grid_LineaBanamex").jsGrid("option", "data", []);	
	    	  if(json.length > 0) 
	    	  { 
	    		  mostrarOcultarBotonesXEstatus($("#cmbEstatusBanamex").val(),10)
	    		  cargarLineaBanamexEnGrid(json);
	    		  MostrarDiv('divMantoLineaBancariaBanamex');
	    	  }
	    	  else {
	    		  OcultarDiv('divMantoLineaBancariaBanamex');
	    	  }
	    	  document.getElementById('cargando').style.display = 'none';
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
				alert('Error al buscar ingresos en el sistema.')
		}
	});
}

function consultaLineaBancariaHSBC()
{
	limpiarControlesMantenimiento()
	document.getElementById('cargando').style.display = 'block';	
	$.ajax({
	    url :'LineaBancaria', 
	    data : "vista=LineaBancaria.jsp&operacion=obtieneLineaBancariaHSBC&IdEstatus=" + $("#cmbEstatusHSBC").val() +"&fechaIni= " +  $("#txt_fechaIniHSBC").val() + "&fechaFin=" + $("#txt_fechaFinHSBC").val(),
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 	    	
	    	
	    	  $("grid_LineaHSBC").jsGrid("option", "data", []);	
	    	  if(json.length > 0) 
	    	  {
	    		  mostrarOcultarBotonesXEstatus($("#cmbEstatusHSBC").val(),16)
	    		  cargarLineaHSBCEnGrid(json);
	    		  MostrarDiv('divMantoLineaBancariaHSBC');
	    	  }
	    	  else 
	    	  {
	    		  OcultarDiv('divMantoLineaBancariaHSBC');	
	    	  }
	    	  document.getElementById('cargando').style.display = 'none';
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
				alert('Error al buscar ingresos en el sistema.')
		}
	});
}

function consultaLineaBancariaBBVA()
{
	limpiarControlesMantenimiento()
	document.getElementById('cargando').style.display = 'block';	
	$.ajax({
	    url :'LineaBancaria', 
	    data : "vista=LineaBancaria.jsp&operacion=obtieneLineaBancariaBBVA&IdEstatus=" + $("#cmbEstatusBBVA").val() +"&fechaIni= " +  $("#txt_fechaIniBBVA").val() + "&fechaFin=" + $("#txt_fechaFinBBVA").val(),
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	  $("grid_LineaBbva").jsGrid("option", "data", []);	
	    	  if(json.length > 0) 
	    	  {
	    		  mostrarOcultarBotonesXEstatus($("#cmbEstatusBBVA").val(),4)
	    		  cargarLineaBBVAEnGrid(json);
	    		  MostrarDiv('divMantoLineaBancariaBBVA');
	    	  }
	    	  else {
	    		  OcultarDiv('divMantoLineaBancariaBBVA');	
	    	  }
	    	  document.getElementById('cargando').style.display = 'none';
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
				alert('Error al buscar ingresos en el sistema.')
		}
	});
}

function consultaLineaBancariaBanorte()
{
	limpiarControlesMantenimiento()
	document.getElementById('cargando').style.display = 'block';	
	$.ajax({
	    url :'LineaBancaria', 
	    data : "vista=LineaBancaria.jsp&operacion=obtieneLineaBancariaBanorte&IdEstatus=" + $("#cmbEstatusBanorte").val() +"&fechaIni= " +  $("#txt_fechaIniBanorte").val() + "&fechaFin=" + $("#txt_fechaFinBanorte").val(),
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 	
	    	  $("grid_LineaBanorte").jsGrid("option", "data", []);
	    	  if(json.length > 0) 
	    	  {
	    		  mostrarOcultarBotonesXEstatus($("#cmbEstatusBanorte").val(),12)
	    		  cargarLineaBanorteEnGrid(json);	    		  
	    		  MostrarDiv('divMantoLineaBancariaBanorte');
	    	  }
	    	  else {
	    		  OcultarDiv('divMantoLineaBancariaBanorte');	
	    	  }
	    	  document.getElementById('cargando').style.display = 'none';
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
				alert('Error al buscar ingresos en el sistema.')
		}
	});
}

function consultaLineaBancariaAzteca()
{
	limpiarControlesMantenimiento()
	document.getElementById('cargando').style.display = 'block';	
	$.ajax({
	    url :'LineaBancaria', 
	    data : "vista=LineaBancaria.jsp&operacion=obtieneLineaBancariaAzteca&IdEstatus=" + $("#cmbEstatusAzteca").val() +"&fechaIni= " +  $("#txt_fechaIniAzteca").val() + "&fechaFin=" + $("#txt_fechaFinAzteca").val(),
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	  $("grid_LineaAzteca").jsGrid("option", "data", []);
	    	  if(json.length > 0) 
	    	  {
	    		  mostrarOcultarBotonesXEstatus($("#cmbEstatusAzteca").val(),5)
	    		  cargarLineaAztecaEnGrid(json);
	    		  MostrarDiv('divMantoLineaBancariaAzteca');
	    	  }
	    	  else {
	    		  OcultarDiv('divMantoLineaBancariaAzteca');	
	    	  }
	    	  document.getElementById('cargando').style.display = 'none';
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
				alert('Error al buscar ingresos en el sistema.')
		}
	});
}


/***  ACTUALIZA CLIENTE EN LINEA BANCARIA POR BANCO  ***/
function validaNumeroClienteIndividual(num_cliente)
{
	let esCteValido = true;
	if($.isNumeric(num_cliente))
	{
		if(num_cliente <= 0){
			esCteValido = false;
    	}
	}
	else
	{
		esCteValido = false;
	}	
	return	esCteValido;
}

function  actualizaCteIndividualDeLineaBancariaXBanco(cve_banco, num_cliente, idLineaBancaria)
{
	document.getElementById('cargando').style.display = 'block';	
	$.ajax({
	    url :'LineaBancaria', 
	    data : "vista=LineaBancaria.jsp&operacion=actualizaCteXBanco&cve_banco=" + cve_banco +"&num_cliente= " + num_cliente+ "&idLineaBancaria=" +idLineaBancaria,
	    type : 'POST',
	    dataType : 'Json',
	    success : function(respuesta)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
	    	if(respuesta == false)
	    	{
	    		alert("ERROR al actualizar cliente en la Linea Bancaria.");
	    	}
	    	else
	    	{
	    		refrescaInformacionDeGrids(cve_banco)
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
				alert('Error al actualizar cliente en la Linea Bancaria.')
		}
	});
}

function  actualizaCteMasivoDeLineaBancariaXBanco(cve_banco)
{
	let numeroCliente=obtieneCteAgteXBancoSeleccionado(cve_banco, "Cte");
	if(numeroCliente == 0)
	{
		alert("El cliente ingresado no es valido.")
	}
	else
	{
		let itemsLineaBancaria = obtinerlineaBancariaXBanco(cve_banco)
		document.getElementById('cargando').style.display = 'block';	
		$.ajax({
		    url :'LineaBancaria', 
		    data : "vista=LineaBancaria.jsp&operacion=actualizaCteMasivoXBanco&cve_banco=" + cve_banco +"&num_cliente= " + numeroCliente+ "&lineaBancaria=" +itemsLineaBancaria,
		    type : 'POST',
		    dataType : 'Text',
		    success : function(respuesta)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if(respuesta == "LineaNoSeleccionada")
		    	{
		    		alert("ERROR: Debes seleccionar por lo menos un registro de la Linea Bancaria.");
		    	}
		    	else if(respuesta == "false")
		    	{
		    		alert("ERROR al actualizar cliente en la Linea Bancaria.");
		    	}
		    	else
		    	{
		    		refrescaInformacionDeGrids(cve_banco)
		    		limpiarControlesMantenimiento()
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
					alert('Error al actualizar cliente en la Linea Bancaria.')
			}
		});
	}
}

function limpiarControlesMantenimiento()
{
	$("#txt_NumeroCteActBanamex").val("") 
	$("#txt_NumeroCteActBanorte").val("") 
	$("#txt_NumeroCteActAzteca").val("") 
	$("#txt_NumeroCteActHsbc").val("")
	$("#txt_NumeroCteActBbva").val("")
	
	$("#cmbNumeroAVBanamex").val(0) 
	$("#cmbNumeroAVBanorte").val(0) 
	$("#cmbNumeroAVAzteca").val(0) 
	$("#cmbNumeroAVHsbc").val(0)
	$("#cmbNumeroAVBbva").val(0)
	
	$("#cmbTipoBanamex").val(0) 
	$("#cmbTipoBanorte").val(0) 
	$("#cmbTipoAzteca").val(0) 
	$("#cmbTipoHSBC").val(0)
	$("#cmbTipoBBVA").val(0)
	
	$("#cmbUsuEcBanamex").val(0) 
	$("#cmbUsuEcBanorte").val(0) 
	$("#cmbUsuEcAzteca").val(0) 
	$("#cmbUsuEcHSBC").val(0)
	$("#cmbUsuEcBBVA").val(0)
	
	$("#txt_folio_pagoActBanamex").val("") 
	$("#txt_folio_pagoActHsbc").val("") 
	$("#txt_folio_pagoActAzteca").val("") 
	$("#txt_folio_pagoActBanorte").val("") 
	$("#txt_folio_pagoActBbva").val("") 
}


/***  ACTUALIZA AGENTE DE VENTAS EN LINEA BANCARIA POR BANCO  ***/
function actualizaAVMasivoDeLineaBancariaXBanco(cve_banco)
{
	let numeroAgente = obtieneCteAgteXBancoSeleccionado(cve_banco, "Agte");
	let tipoLinea = obtieneTipoLineaXBancoSeleccionado(cve_banco)
	if(numeroAgente == 0 || tipoLinea == "0")
	{
		alert("Debes seleccionar un agente de ventas y un tipo de linea.")
	}
	else
	{
		let itemsLineaBancaria = obtinerlineaBancariaXBanco(cve_banco)
		document.getElementById('cargando').style.display = 'block';	
		$.ajax({
		    url :'LineaBancaria', 
		    data : "vista=LineaBancaria.jsp&operacion=actualizaAgenteXBanco&cve_banco=" + cve_banco +"&num_agente= " + numeroAgente+ "&lineaBancaria=" +itemsLineaBancaria + "&tipoLinea=" +tipoLinea,
		    type : 'POST',
		    dataType : 'Text',
		    success : function(respuesta)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if(respuesta == "LineaNoSeleccionada")
		    	{
		    		alert("ERROR: Debes seleccionar por lo menos un registro de la Linea Bancaria.");
		    	}
		    	else if(respuesta == "ErrorAlActualizar")
		    	{
		    		alert("ERROR al actualizar agente en la Linea Bancaria.");
		    	}
		    	else 
		    	{
		    		if(respuesta == "SinEncargadoCredito")
		    		{
		    			alert("Se actualizo el agente en la Linea Bancaria, pero no se encontro un ECC relacionado al AV.");
		    		}
					refrescaInformacionDeGrids(cve_banco)
					limpiarControlesMantenimiento()
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
					alert('Error al actualizar cliente en la Linea Bancaria.')
			}
		});
	}
}


/***  MODIFICA ENCARGADO EN LINEA BANCARIA POR BANCO  ***/
 function modificaLineaBancaria (cve_banco)
 {
	 let encargadoCR = obtieneEncargadoXBancoSeleccionado(cve_banco);
	 if(encargadoCR == "0")
	 {
		 alert("Debes seleccionar un ecargado de credito")
	 }
	 else
	 {
		 let itemsLineaBancaria = obtinerlineaBancariaXBanco(cve_banco)
		 document.getElementById('cargando').style.display = 'block';	
		 $.ajax({
				    url :'LineaBancaria', 
				    data : "vista=LineaBancaria.jsp&operacion=modificaEncargadoLineaBancaria&lineaBancaria=" + itemsLineaBancaria +"&cve_banco=" + cve_banco +"&encargadoCR= " + encargadoCR,  
				    type : 'POST',
				    dataType : 'Text',
				    success : function(respuesta)
				    { 
				    	document.getElementById('cargando').style.display = 'none';
				    	if(respuesta == "LineaNoSeleccionada")
				    	{
				    		alert("ERROR: Debes seleccionar por lo menos un registro de la Linea Bancaria.");
				    	}
				    	else if(respuesta == "false")
				    	{
				    		alert("ERROR al actualizar Encargado de Credito  en la Linea Bancaria.");
				    	}
				    	else
				    	{
				    		refrescaInformacionDeGrids(cve_banco)
				    		limpiarControlesMantenimiento()
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
							alert('Error al buscar ingresos en el sistema.')
					}
		   });
	 }
 }
 
 function preAsignaEncargadoLineaBancaria(jsonLinea, encargadoCR, tipoLinea, cve_banco)
 {
	 document.getElementById('cargando').style.display = 'block';	
	 $.ajax({
			    url :'LineaBancaria', 
			    data : "vista=LineaBancaria.jsp&operacion=preAsignaEncargadoLineaBancaria&lineaBancaria=" + jsonLinea +"&cve_banco=" + cve_banco +"&encargadoCR= " + encargadoCR+ "&tipoLinea=" +tipoLinea ,  
			    type : 'POST',
			    dataType : 'Json',
			    success : function(respuesta)
			    { 
			    	document.getElementById('cargando').style.display = 'none';
			    	limpiarCombos();
			    	actualizaConsultaLineaBancaria(cve_banco)
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
						alert('Error al buscar ingresos en el sistema.')
				}
	   });
 }

 
 /***  ASIGNA ENCARGADO LINEA BANCARIA  ***/
 function asignaEncargadoLineaBancaria()
 {
	 	var bandera = confirm("Todos los registros Pre-Asignados se Asignaran en el sistema.");
	    if (bandera == true)
	    {
			document.getElementById('cargando').style.display = 'block';	
			$.ajax({
			    url :'LineaBancaria', 
			    data : "vista=LineaBancaria.jsp&operacion=asignaEncargadoLineaBancaria",
			    type : 'POST',
			    dataType : 'Json',
			    success : function(respuesta)
			    { 
			    	document.getElementById('cargando').style.display = 'none';
			    	if(respuesta == false)
			    	{
			    		alert("ERROR al confirmar linea bancaria.");
			    	}
			    	else
			    	{
			    		$("#cmbEstatusConcentrado").val(2)
			    		obtieneLineasBancariasPendientesBD()
			    		obtieneConcentradoLineasBancariasPendientesBD();
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
						alert('Error al buscar ingresos en el sistema.')
				}
			});
	    }
 }
  
 
 /***  APLICAR / DES-APLICAR  PAGOS  DE LINEA BANCARIA  ***/ 
 function mantoLineaBancaria(cve_banco, accion, area)
 {
	 let lineaBanCorrecta = true;
	 let folioPago = 0;
	 if(accion === 'Aplicar_Pago')
	 {
		  if(area === "CajaAdministrativa")
		  {
			  lineaBanCorrecta = validarTipoPagoLineaCajaAdmin(cve_banco)
			  if(lineaBanCorrecta == false)
			  {
				 alert('Selecciona un tipo de linea bancaria valido')
				 return;
			  }
		  }
		  else
		  {
			  folioPago = validaFolioPagoValido(cve_banco)
			  /*if(folioPago <= 0)
			  {
				 alert('Ingresa un folio de pago valido')
				 return;
			  }*/
		  }
	 }
	 
	 let mensaje;
	 if(accion === 'Aplicar_Pago')
	 {
		 mensaje= "Se aplicaran todos los pagos seleccionados en el sistema."
	 }
	 else
	 {
		 mensaje= "Se regresaran todos los pagos seleccionados en el sistema."
	 }
	 
	 var bandera = confirm(mensaje);
     if (bandera == true)
     {
    	 switch(cve_banco)
		 {
		 	case 10:/*BANAMEX*/
		 		 items = obtinerlineaBancariaXBanco(10)
				 aplicaRegresarPagoLineaBancaria(items,10,accion,area, folioPago)
				 break;
		
		 	case 16:/*HSBC*/
		 		 items = obtinerlineaBancariaXBanco(16)
				 aplicaRegresarPagoLineaBancaria(items,16,accion,area,folioPago)
				 break;
				 
		 	case 4:/*BBVA*/
		 		 items = obtinerlineaBancariaXBanco(4)
				 aplicaRegresarPagoLineaBancaria(items,4,accion,area,folioPago)
				 break;
				 
		 	case 12:/*BANORTE*/
		 		 items = obtinerlineaBancariaXBanco(12)
				 aplicaRegresarPagoLineaBancaria(items,12,accion,area,folioPago)
				 break;
				 
		 	case 5:/*AZTECA*/
		 		 items = obtinerlineaBancariaXBanco(5)
				 aplicaRegresarPagoLineaBancaria(items,5,accion,area,folioPago)
				 break;
		 }
     }
	
	 
 }

 function validaFolioPagoValido(cve_banco)
 {
	 let folio = "0";
 	 switch(cve_banco)
 	 {
 	 	case 10:/*BANAMEX*/
 	 		folio = $("#txt_folio_pagoActBanamex").val()
 	 	break;
 	 	
 	 	case 16:/*HSBC*/
 	 		folio = $("#txt_folio_pagoActHsbc").val()
 	 	break;	 	
 	 	
 	 	case 4:/*BBVA*/
 	 		folio = $("#txt_folio_pagoActBbva").val()
 	 	break;
 	 	
 	 	case 12:/*BANORTE*/
 	 		folio = $("#txt_folio_pagoActBanorte").val()
 	 	break;
 	 	
 	 	case 5:/*AZTECA*/
 	 		folio = $("#txt_folio_pagoActAzteca").val()
 	 	break;
 	 }
 	 return folio;
 }
  
 function validarTipoPagoLineaCajaAdmin(cve_banco)
 {
	 let tipo ="";
	 switch(cve_banco)
	 {
	 	case 10:/*BANAMEX*/
	 		tipo = $("#cmbTipoBanamexCaja").val();			 
			 break;
	
	 	case 16:/*HSBC*/
	 		tipo = $("#cmbTipoHsbcCaja").val();	
			 break;
			 
	 	case 4:/*BBVA*/
	 		tipo = $("#cmbTipoBbvaCaja").val();	
			 break;
			 
	 	case 12:/*BANORTE*/
	 		tipo = $("#cmbTipoBanorteCaja").val();	
			 break;
			 
	 	case 5:/*AZTECA*/
	 		tipo = $("#cmbTipoAztecaCaja").val();	
			 break;
	 }
	 
	 if(tipo == "" || tipo == "0")
	 {
		 return false;
	 }
	 else
	 {
		 return true;
	 }
	 
 }
 
 function aplicaRegresarPagoLineaBancaria(jsonLinea, cve_banco, accion, area,folioPago)
 {	
	let tipoLinea= 0;
	if(area === "CajaAdministrativa")
	{
		tipoLinea = obtieneTipoLineaXBancoSeleccionadoDeCajaAdmin(cve_banco);
	}
	
	document.getElementById('cargando').style.display = 'block';	
	$.ajax({
	    url :'LineaBancaria', 
	    data : "vista=LineaBancaria.jsp&operacion=aplicaRegresarPagoEnLineaBancaria&cve_banco=" + cve_banco + "&accion=" + accion + "&lineaBancaria=" + jsonLinea + "&area=" + area + "&tipoLinea=" + tipoLinea + "&folioPago=" + folioPago,
	    type : 'POST',
	    dataType : 'Text',
	    success : function(respuesta)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
    		if(respuesta == "LineaNoSeleccionada")
	    	{
	    		alert("ERROR: Debes seleccionar por lo menos un registro de la Linea Bancaria.");
	    		return;
	    	}
    		else if(respuesta == 'SinCliente')
    		{
    			alert("Para APLICAR PAGO la linea debe tener asignado un Cliente y un Encargado de Credito");
    			return;
    		}
    		else if(respuesta == 'ActualizoCorrectamente')
    		{
    			actualizaConsultaLineaBancaria(cve_banco)
    			txt_folio_pagoActBanamex.val("0")
        		txt_folio_pagoActHsbc.val("0")
        		txt_folio_pagoActAzteca.val("0")
        		txt_folio_pagoActBanorte.val("0")
        		txt_folio_pagoActBbva.val("0")
        		
    		}
    		else  
    		{
    			alert("ERROR al actualizar la linea bancaria");
    			return;
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
				alert('ERROR al actualizar la linea bancaria.')
		}
	});
 }
 
 
 /***  METODOS  OBTIENEN DATOS SEGUN EL BANCO ***/
 function obtinerlineaBancariaXBanco(cve_banco)
 {
	 let items;
	 switch(cve_banco)
	 {
	 	case 10:/*BANAMEX*/
			 items = $("#grid_LineaBanamex").jsGrid("option", "data");
			 break;
	
	 	case 16:/*HSBC*/
			 items = $("#grid_LineaHSBC").jsGrid("option", "data");
			 break;
			 
	 	case 4:/*BBVA*/
			 items = $("#grid_LineaBbva").jsGrid("option", "data");
			 break;
			 
	 	case 12:/*BANORTE*/
			 items = $("#grid_LineaBanorte").jsGrid("option", "data");
			 break;
			 
	 	case 5:/*AZTECA*/
			 items = $("#grid_LineaAzteca").jsGrid("option", "data");
			 break;
	 }
	 
	 items= JSON.stringify(items);
	 return items
 }

 function actualizaConsultaLineaBancaria(cve_banco)
 {
	 switch(cve_banco)
	 {
	 	case 10:/*BANAMEX*/
	 		consultaLineaBancariaBanamex();
	 	break;
	 	
	 	case 16:/*HSBC*/
	 		consultaLineaBancariaHSBC();
	 	break;	 	
	 	
	 	case 4:/*BBVA*/
	 		consultaLineaBancariaBBVA();
	 	break;
	 	
	 	case 12:/*BANORTE*/
	 		consultaLineaBancariaBanorte();
	 	break;
	 	
	 	case 5:/*AZTECA*/
	 		consultaLineaBancariaAzteca();
	 	break;
	 }
 }
 
 function refrescaInformacionDeGrids(cve_banco)
 {
 	switch(cve_banco)
 	 {
 	 	case 10:/*BANAMEX*/
 	 		 consultaLineaBancariaBanamex();
 			 break;
 	
 	 	case 16:/*HSBC*/
 	 		 consultaLineaBancariaHSBC();
 			 break;
 			 
 	 	case 4:/*BBVA*/
 	 		 consultaLineaBancariaBBVA();
 			 break;
 			 
 	 	case 12:/*BANORTE*/
 	 		 consultaLineaBancariaBanorte();
 			 break;
 			 
 	 	case 5:/*AZTECA*/
 	 		 consultaLineaBancariaAzteca();
 			 break;
 	 }
 }

 function obtieneCteAgteXBancoSeleccionado(cve_banco, tipo)
 {
 	let numeroCteAgte=0;
 	 switch(cve_banco)
 	 {
 	 	case 10:/*BANAMEX*/
 	 		if(tipo === "Cte")
 	 			numeroCteAgte= $("#txt_NumeroCteActBanamex").val();
 	 		else
 	 			numeroCteAgte= $("#cmbNumeroAVBanamex").val();
 	 	break;
 	 	
 	 	case 16:/*HSBC*/
 	 		if(tipo === "Cte")
 	 			numeroCteAgte= $("#txt_NumeroCteActHsbc").val();
 	 		else
 	 			numeroCteAgte= $("#cmbNumeroAVHsbc").val();
 	 	break;	 	
 	 	
 	 	case 4:/*BBVA*/
 	 		if(tipo === "Cte")
 	 			numeroCteAgte= $("#txt_NumeroCteActBbva").val();
 	 		else
 	 			numeroCteAgte= $("#cmbNumeroAVBbva").val();
 	 	break;
 	 	
 	 	case 12:/*BANORTE*/
 	 		if(tipo === "Cte")
 	 			numeroCteAgte= $("#txt_NumeroCteActBanorte").val();
 	 		else
 	 			numeroCteAgte= $("#cmbNumeroAVBanorte").val();
 	 	break;
 	 	
 	 	case 5:/*BANORTE*/
 	 		if(tipo === "Cte")
 	 			numeroCteAgte= $("#txt_NumeroCteActAzteca").val();
 	 		else
 	 			numeroCteAgte= $("#cmbNumeroAVAzteca").val();
 	 	break;
 	 }
 	return numeroCteAgte;
 }
 
 function obtieneTipoLineaXBancoSeleccionado(cve_banco)
 {
	 let tipoLinea="0";
 	 switch(cve_banco)
 	 {
 	 	case 10:/*BANAMEX*/
 	 		tipoLinea= $("#cmbTipoBanamex").val();
 	 	break;
 	 	
 	 	case 16:/*HSBC*/
 	 		tipoLinea= $("#cmbTipoHSBC").val();
 	 	break;	 	
 	 	
 	 	case 4:/*BBVA*/
 	 		tipoLinea= $("#cmbTipoBBVA").val();
 	 	break;
 	 	
 	 	case 12:/*BANORTE*/
 	 		tipoLinea= $("#cmbTipoBanorte").val();
 	 	break;
 	 	
 	 	case 5:/*AZTECA*/
 	 		tipoLinea= $("#cmbTipoAzteca").val();
 	 	break;
 	 }
 	return tipoLinea;
 }
  
 function obtieneTipoLineaXBancoSeleccionadoDeCajaAdmin(cve_banco)
 {
	 let tipoLinea="0";
 	 switch(cve_banco)
 	 {
 	 	case 10:/*BANAMEX*/
 	 		tipoLinea= $("#cmbTipoBanamexCaja").val();
 	 	break;
 	 	
 	 	case 16:/*HSBC*/
 	 		tipoLinea= $("#cmbTipoHsbcCaja").val();
 	 	break;	 	
 	 	
 	 	case 4:/*BBVA*/
 	 		tipoLinea= $("#cmbTipoBbvaCaja").val();
 	 	break;
 	 	
 	 	case 12:/*BANORTE*/
 	 		tipoLinea= $("#cmbTipoBanorteCaja").val();
 	 	break;
 	 	
 	 	case 5:/*AZTECA*/
 	 		tipoLinea= $("#cmbTipoAztecaCaja").val();
 	 	break;
 	 }
 	return tipoLinea;
 }
   
 function obtieneEncargadoXBancoSeleccionado(cve_banco)
 {
 	 let ecc = "0";
 	 switch(cve_banco)
 	 {
 	 	case 10:/*BANAMEX*/
 	 		ecc = $("#cmbUsuEcBanamex").val()
 	 	break;
 	 	
 	 	case 16:/*HSBC*/
 	 		ecc = $("#cmbUsuEcHSBC").val()
 	 	break;	 	
 	 	
 	 	case 4:/*BBVA*/
 	 		ecc = $("#cmbUsuEcBBVA").val()
 	 	break;
 	 	
 	 	case 12:/*BANORTE*/
 	 		ecc = $("#cmbUsuEcBanorte").val()
 	 	break;
 	 	
 	 	case 5:/*AZTECA*/
 	 		ecc = $("#cmbUsuEcAzteca").val()
 	 	break;
 	 }
 	 return ecc;
 }
 
 function mostrarOcultarBotonesXEstatus(estatus, banco)
 {
 	let btnQuitar="btn_QuitarPago";
 	let btnAplicar="div_AplicarPago";
 	let divActualizaCte="div_ActualizarCliente";
 	let divAsignarUsu="divAsignarLineaBanECR_";
 	let divAsignarAgte="div_ActualizarAgente";
 	let divActualizaCaja ="div_ActualizarPagoCaja";
 	
 	switch(banco)
 	{
 		case 10:
 			btnQuitar +="Banamex"
 			btnAplicar +="Banamex"
 			divActualizaCte +="Banamex"
 			divAsignarUsu +="Banamex"
 			divAsignarAgte +="Banamex"
 			divActualizaCaja +="Banamex"
 			break;
 		case 16:
 			btnQuitar +="Hsbc"
 			btnAplicar +="Hsbc"
 			divActualizaCte +="Hsbc"
 			divAsignarUsu +="Hsbc"
 			divAsignarAgte +="Hsbc"
 			divActualizaCaja +="Hsbc"
 			break;
 		case 4:
 			btnQuitar +="Bbva"
 			btnAplicar +="Bbva"
 			divActualizaCte +="Bbva"
 			divAsignarUsu +="Bbva"
 			divAsignarAgte +="Bbva"
 			divActualizaCaja +="Bbva"
 			break;
 		case 5:
 			btnQuitar +="Azteca" 
 			btnAplicar +="Azteca"
 			divActualizaCte +="Azteca"
 			divAsignarUsu +="Azteca"
 			divAsignarAgte +="Azteca"
 			divActualizaCaja +="Azteca"
 			break;
 		case 12:
 			btnQuitar +="Banorte"
 			btnAplicar +="Banorte"
 			divActualizaCte +="Banorte"
 			divAsignarUsu +="Banorte"
 			divAsignarAgte +="Banorte"
 			divActualizaCaja +="Banorte"
 			break;
 	}
 	switch(estatus)
 	{
 		case "0":
 			OcultarDiv(btnQuitar)
 			OcultarDiv(btnAplicar)
 			MostrarDiv(divActualizaCte)  
 			MostrarDiv(divAsignarUsu) 
 			MostrarDiv(divAsignarAgte)
 			MostrarDiv(divActualizaCaja)
 			break;
 			
 		case "1":
 			OcultarDiv(btnQuitar)
 			OcultarDiv(btnAplicar)
 			MostrarDiv(divActualizaCte)  
 			MostrarDiv(divAsignarUsu)
 			MostrarDiv(divAsignarAgte)
 			OcultarDiv(divActualizaCaja)
 			break;
 			
 		case "2":
 			MostrarDiv(btnAplicar)
 			OcultarDiv(btnQuitar)
 			MostrarDiv(divActualizaCte)
 			MostrarDiv(divAsignarUsu)
 			OcultarDiv(divAsignarAgte) 
 			OcultarDiv(divActualizaCaja)
 			break;
 			
 		case "3":
 			OcultarDiv(btnAplicar)
 			MostrarDiv(btnQuitar)
 			OcultarDiv(divActualizaCte)
 			OcultarDiv(divAsignarUsu)
 			OcultarDiv(divAsignarAgte) 
 			OcultarDiv(divActualizaCaja)
 			break;
 						
 		case "4":
 			OcultarDiv(btnQuitar)
 			OcultarDiv(btnAplicar)
 			OcultarDiv(divActualizaCte)
 			OcultarDiv(divAsignarUsu)
 			OcultarDiv(divAsignarAgte) 
 			OcultarDiv(divActualizaCaja)
 			break;
 			
 		case "5":
 			OcultarDiv(btnQuitar)
 			OcultarDiv(btnAplicar)
 			OcultarDiv(divActualizaCte)
 			OcultarDiv(divAsignarUsu)
 			OcultarDiv(divAsignarAgte) 
 			OcultarDiv(divActualizaCaja)
 			break;
 	}
 	configuraModuloXPerfilDeUsuario()
 }

 function validaSiSeMuestranLosGrids(dataBanamex, dataHsbc, dataBBVA, dataBanorte, dataAzteca)
 {
 	/*BANAMEX*/
 	if(dataBanamex.length <= 0)  {
 		 OcultarDiv('divMantoLineaBancariaBanamex');	
 	}
 	else{
 		MostrarDiv('divMantoLineaBancariaBanamex');	
 		cargarLineaBanamexEnGrid(dataBanamex);
 	}
 	
 	/*HSBC*/
 	if(dataHsbc.length <= 0){
 		 OcultarDiv('divMantoLineaBancariaHSBC');	
 	}
 	else{
 		MostrarDiv('divMantoLineaBancariaHSBC');
 		cargarLineaHSBCEnGrid(dataHsbc);
 	}
 	
 	/*BBVA*/
 	if(dataBBVA.length <= 0)  {
 		 OcultarDiv('divMantoLineaBancariaBBVA');	
 		 
 	}
 	else{
 		MostrarDiv('divMantoLineaBancariaBBVA');
 		cargarLineaBBVAEnGrid(dataBBVA);
 	}
 	
 	/*BANORTE*/
 	if(dataBanorte.length <= 0)  {
 		 OcultarDiv('divMantoLineaBancariaBanorte');	
 	}
 	else{
 		MostrarDiv('divMantoLineaBancariaBanorte');
 		cargarLineaBanorteEnGrid(dataBanorte);
 	}
 	
 	/*AZTECA*/
 	if(dataAzteca.length <= 0)  {
 		 OcultarDiv('divMantoLineaBancariaAzteca');	
 	}
 	else{
 		MostrarDiv('divMantoLineaBancariaAzteca');
 		cargarLineaAztecaEnGrid(dataAzteca);
 		
 	}
 }

