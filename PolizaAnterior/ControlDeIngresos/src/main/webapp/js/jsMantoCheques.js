function MuestraPanel (div, menu)
{
	var divMostrar ="#" + div;
	var MunuActivo ="#" + menu;
    $(divMostrar).show();
    $(MunuActivo).css('background-color', '#337AB7');
}

function IniciaModuloMantoCheques(div, menu)
{
	MuestraPanel(div, menu);
	inicializaVariables();
	configurarMenuPrincipalXPerfilesUsuario();
	configuraModuloXPerfilDeUsuario();
	consultaChequesNominativos()
}

function inicializaVariables()
{
	$('#txt_fechaPolizaMantoCheque').val(ObtenerFechaActual());
	$('#txt_fechaPolizaAltaMantoCheque').val(ObtenerFechaActual());	
	$('#txt_chequeMantoCheque').val("");
	$("#id_bancoEmisorMantoCheque").val("0") 
	$("#id_folioCajaMantoCheque").val("") 
	$("#id_chequeMantoCheque").val("")
	$("#id_tipoPagoMantoCheque").val("0")
	$("#id_clienteMantoCheque").val("")
	$("#id_importeMantoCheque").val("") 
	OcultarDiv('AltaChequeNominativo')
}

/***  CONFIGURA  PERFIL DE USUARIO  ***/
function configuraModuloXPerfilDeUsuario()
{
	/** LOS PERFILES DE USUARIO PARA LOS GRIDS ESTAN EN EL EVENTO: mostrarColumnaXPerfilUsuario(); **/
	//El nivel de Caja tiene todos los permisos a nivel vista.
	let nivelUsuario=$("#lbNivel_usuario").text();	
	if (nivelUsuario == 1) 
	{
		OcultarDiv('btn_agregarChequeNominativo');
		//mostrarPerfilUsuarioCredito();
	}
	else if (nivelUsuario == 2) 
	{
		OcultarDiv('btn_agregarChequeNominativo');
		//mostrarPerfilUsuarioContabilidad();
	}
}

function consultaChequesNominativos()
{
	let num_cheque=$('#txt_chequeMantoCheque').val();
	document.getElementById('cargando').style.display = 'block';
	
	$.ajax({
	    url :'MantoCheques', 
	    data : "vista=MantenimientoCheques.jsp&operacion=ConsultaCheques" +"&fecha_poliza=" + $('#txt_fechaPolizaMantoCheque').val() +"&numCheque" + num_cheque +"&estatus=" + $("#cmbstatusMantoCheque").val()+"&des_estatus=" +$( "#cmbstatusMantoCheque option:selected" ).text(), 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(jsonCheques)
	    { 	    	
	    	document.getElementById('cargando').style.display = 'none';
	    	let listaCheques = jsonCheques.listaChequesNominativos;
	    	let listaBancos = jsonCheques.listBancos;
	        if(listaCheques.length > 0)
        	{
	        	OcultarDiv('divMjsInfoMantoCheques');
	        	MostrarDiv('dgChequeNominativos');
	        	llenaGridChequeNominativo(listaCheques,listaBancos)
        	}
	        else
        	{
	        	MostrarDiv('divMjsInfoMantoCheques');
	        	$("#lbMsjInfoMantoCheques").text('No se encontraron registros en el sistema con fecha poliza  ' + $('#txt_fechaPolizaMantoCheque').val()) ;
	        	OcultarDiv('dgChequeNominativos');
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

/***   SECCION DE FUNCIONES PARA CONSTRUIR GRID  ***/
function llenaGridChequeNominativo(data, dataBanco)
{
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	        return $.grep(data, function (ingreso) {
	            return (!filter.referencia || ingreso.referencia.indexOf(filter.referencia) > -1)
	            && (!filter.tipo_ingreso || ingreso.tipo_ingreso.indexOf(filter.tipo_ingreso) > -1)
	            && (!filter.folio_caja || ingreso.folio_caja.indexOf(filter.folio_caja) > -1)
	            && (!filter.num_cli || ingreso.num_cli.indexOf(filter.num_cli) > -1)
	            && (!filter.ficha_deposito || ingreso.ficha_deposito.indexOf(filter.ficha_deposito) > -1)
	        });
	    },
	    
	    insertItem: function (insertingClient) {
	        data.push(insertingClient);
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {	    	
	    	var d = $.Deferred();	    	
	    	if(IActualizado.ficha_deposito == "" || IActualizado.ficha_deposito == "0")
	    	{
	    		alert('La ficha de deposito no es valida.')
	    		d.resolve(IPrevio);
	    	}
	    	else  if(IActualizado.cve_banco_deposito == "0")
	    	{
	    		alert('El banco deposito no es valido.')
	    		d.resolve(IPrevio);
	    	}
	    	else
	    	{
	    		actualizaChequeNominativoXID(IActualizado);
	    		consultaChequesNominativos();    		
	    	}
	    	return d.promise();
	    },
	 };
	
	 window.db = db;
     db.data;
     db.bancos = dataBanco;
     $(function ()
    	     {
    	    	 $("#dgChequeNominativos").jsGrid({
    	    		 width: "95%",
    	             height: "450px",
    	             editing: true,
    	             filtering: true,
    	             sorting: true,
    	             paging: true,
    	             pageSize: 800,
    	             controller: {
    	                 loadData: function () {
    	                     dataType: "json"
    	                     return data;
    	                 }
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
    	            	 let totales= calculaImportesTotalesDelGridIngresos(items)
    	                 let $totalRow = $("<tr>").addClass("total-row");
    	                 args.grid._renderCells($totalRow, totales);
    	                 args.grid._content.append($totalRow);
    	             },
    	             rowRenderer: function (item) {
    	                 var $row = $('<tr>');
    	                 this._renderCells($row, item);    	                 
    	                 $addr = $row[0].children[5];
    	                 $($addr).attr("id", "popover");
    	                 $($addr).attr(item.nom_cliente);
    	                 $($addr).attr("title", item.nom_cliente);
    	                 return $row;
    	             },
    	             fields: 
    	             [
    	                 { name: "uname", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "id_tipo_ingreso",  type: "text", width: 15, align: 'center', editing: false, inserting: false, filtering: true,css: 'EG_hide'},
    	                 { name: "tipo_ingreso",  type: "text", title: "TIPO",width:15, align: 'center', editing: false, inserting: false, filtering: true,
    	                	 itemTemplate: function (value, item) {
    	                		 return crearColumnaTipoPagoParaGrid(item.id_tipo_ingreso, value)
    	                	 },
    	                 },
    	                 { name: "referencia",  type: "text", title: "CHEQUE", width: 25, align: 'center', editing: false, inserting: false, filtering: true, },
    	                 { name: "folio_caja",  type: "text", title: "FOLIO CAJA", width: 20, align: 'center', editing: false, inserting: false, filtering: true,},
    	                 { name: "num_cli",     type: "text", title: "CLIENTE", width: 15, align: 'center', editing: false, inserting: false, filtering: true,},
    	                 { name: "nom_cliente",  type: "text", title: "NOMBRE",width:25, align: 'center', editing: false, inserting: false, filtering: false, css: 'EG_hide'},
    	                 { name: "importe",  type: "text",title: "IMPORTE", width: 30, align: 'right', editing: true, inserting: false, filtering: false,},
    	                 { name: "cve_banco",  type: "text",width:3, align: 'center', editing: false, inserting: false, filtering: false,css: 'EG_hide'},
    	                 { name: "banco",  type: "text", title: "BANCO EMISOR" ,width: 25, align: 'center', editing: false, inserting: false, filtering: false,},
    	                 { name: "ficha_deposito",  type: "text", title: "FICHA DEPOSITO",width:25, align: 'center', editing: true, inserting: false, filtering: true,},
    	                 { name: "cve_banco_deposito",   type: "select", items: db.bancos,  valueField: "cve_banco", textField: "nombre_banco",   width: 25, align: 'center',title: "BANCO DEPOSITO", editing:true, inserting: false, filtering: false,},
    	                 { name: "banco_deposito",  type: "text", title: "BANCO DEPOSITO",width:25, align: 'center', editing: true, inserting: false, filtering: false,css: 'EG_hide'},
    	                 { name: "fecha_poliza",  type: "text",title: "FECHA POLIZA", width:25, align: 'center', editing: false, inserting: false, filtering: false,},
    	                 { name: "id_estatus",  type: "text",width:3, align: 'center', editing: false, inserting: false, filtering: true,css: 'EG_hide',
    	                	 editTemplate: function (value, item) {
    	                		 if(mostrarColumnaXPerfilUsuario() == false)
    	                    	 {
    	                			 var $result = jsGrid.fields.text.prototype.editTemplate.apply(this, argumets);
	                                 $result.prop("readonly", item.notEditable);
	                                 $result.prop("readonly", item.deleteButton);
	                                 return $result;
	                             }
    	                		 else
    	                		 {
    	                			 if (value > 1 ) 
		    	                	 {
    	                				 var $result = jsGrid.fields.text.prototype.editTemplate.apply(this, argumets);
    	                                 $result.prop("readonly", item.notEditable);
    	                                 $result.prop("readonly", item.deleteButton);
    	                                 return $result;
		    	                	 }
    	                		 }
	    	                 }
    	                 },
    	                 { name: "descripcion_estatus", title: "ESTATUS", type: "text", width: 20, align: 'center', editing: false, inserting: false, filtering: false,
    	                	 itemTemplate: function (value, item) {
    	                         return crearColumnaEstatusParaGrid(value, item);
    	                     }
    	                 },
    	                 
    	                 { type: "control",title: " ",  width: 10,
    	                     itemTemplate: function (value, item) {
    	                    	 
    	                    	 if(mostrarColumnaXPerfilUsuario())
    	                    	 {
    		                    	 var $result = $([]);
    		                         if (item.id_estatus == "0" || item.id_estatus == "1" )
    		                             $result = $result.add(this._createEditButton(item));
    		                         return $result;
    	                    	 }
    	                     },
    	                 },
    	                 { name: "btnCancelar", type: "text", title: " ", width: 12, align: 'center', editing: false, inserting: false,  filtering: false, 
    	                	 itemTemplate: function (value, item) 
    	                	 {
    	                		 if(mostrarColumnaXPerfilUsuario())
    	                    	 { 
    	                			 if(item.id_tipo_ingreso > 1)
	                				 {
    	                				 if (item.id_estatus == "0" || item.id_estatus == "1" )
        			            		 {
        			            			 return $("<button>").attr("class", "EG_btnCancela").on("click", function () {
        		                             	 eliminarChequeNominativoXID(item);
        		                             	 
        		                                  return false;
        		                              });     
        			        			 }  
	                				 } 		                		
    	                    	 }
    	                     }
    	                 },
    	                 
	                 ],
	        	 });
	         });
}

function mostrarColumnaXPerfilUsuario()
{
	 let nivelUsuario=$("#lbNivel_usuario").text();
	 let datoNumerico = $("#lbDatoNumerico").text();
	 let mostrarColumna = true;
	  
	 if(nivelUsuario == 1  || nivelUsuario == 2)
	 {
		 mostrarColumna = false;
	 }
	 return mostrarColumna;
}

function crearColumnaEstatusParaGrid(value, item)
{
	if (item.id_estatus == "0") {
        return $("<div>").attr("class", "EG_IPendiente").text(value);
    }
    else if (item.id_estatus == "1") {
        return $("<div>").attr("class", "EG_IConfirmado").text(value);
    }    
    else if (item.id_estatus == "2") {
        return $("<div>").attr("class", "EG_IPoliza").text(value);
    }
}

function crearColumnaTipoPagoParaGrid(tipo, value)
{
	 if (tipo == "1") {
         return $("<div>").attr("class", "EG_divCOB").text(value);
     }
     else if (tipo == "2") {
         return $("<div>").attr("class", "EG_divHR").text(value);
     }
     else if (tipo == "4") {
         return $("<div>").attr("class", "EG_divOI").text(value);
     }     
     else if (tipo == "3") {
         return $("<div>").attr("class", "EG_divCON").text(value);
     }
     else if (tipo == "5") {
         return $("<div>").attr("class", "EG_divCRE").text(value);
     }
     else if (tipo == "6") {
         return $("<div>").attr("class", "EG_divLIN").text(value);
     }
     else if (tipo == "7") {
         return $("<div>").attr("class", "EG_divFHR").text(value);
     }
}

/*** SECCION TOTALES DEL GRID ***/
function calculaImportesTotalesDelGridIngresos(items)
{
	 let total = {
			 uname: "", id_tipo_ingreso: "", tipo_ingreso: "", referencia: "", folio_caja: "", num_cli: "TOTAL", nom_cliente: "", importe: 0, cve_usu: "", cve_banco: "", banco: "", 
			 ficha_deposito: "", cve_banco_deposito: "", banco_deposito: "", fecha_poliza: "",  id_estatus: "", descripcion_estatus: "",IsTotal: true
     };	  
	 items.forEach(function (item){
         total.importe += parseFloat(item.importe.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', ''));
        
     });	  
	 total.importe = "$ " + FormatearTotalesDeGrid(total.importe)
     return total;
}

function FormatearTotalesDeGrid(importe)
{
	let importeTotalGrid = parseFloat(importe).toFixed(2);
	importeTotalGrid = agregarCommas(importeTotalGrid);
	return importeTotalGrid;
}

/*** ACTUALIZAR CHEQUE NOMINATIVO  ***/
function actualizaChequeNominativoXID(IActualizado)
{
	document.getElementById('cargando').style.display = 'block';	 
	 $.ajax({
		    url :'MantoCheques', 
		    data : "vista=MantenimientoCheques.jsp&operacion=ActualizaChequeXID" +
		    		"&tipoPago="+ IActualizado.id_tipo_ingreso+ "&folio_caja="+ IActualizado.folio_caja +
		    		"&referencia="+ IActualizado.referencia+ "&cve_banco="+ IActualizado.cve_banco +
		    		"&ficha_deposito="+ IActualizado.ficha_deposito+ "&cve_banco_deposito="+ IActualizado.cve_banco_deposito +
		    		"&fecha_poliza="+ IActualizado.fecha_poliza + "&importe="+ IActualizado.importe.replace(",","").replace("$","").replace(",","").replace(",","").replace(",",""),
		    type : 'POST',
		    dataType : 'Json',
		    success : function(respuesta)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if(respuesta == "false")
		    		alert('Error al actualizar cheque nominativo')
		    	
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
					alert('Error al actualizar cheque.')
			}
		});
}




/*** CANCELAR CHEQUE NOMINATIVO  ***/
function eliminarChequeNominativoXID(IActualizado)
{
	let bandera = confirm("El cheque nominativo se eliminara del sistema.");
    if (bandera == true)
    {
		document.getElementById('cargando').style.display = 'block';	 
		 $.ajax({
			    url :'MantoCheques', 
			    data : "vista=MantenimientoCheques.jsp&operacion=cancelarChequeNominativo" +
			    		"&tipoPago="+ IActualizado.id_tipo_ingreso+ "&folio_caja="+ IActualizado.folio_caja +
			    		"&referencia="+ IActualizado.referencia+ "&cve_banco="+ IActualizado.cve_banco ,
			    type : 'POST',
			    dataType : 'Json',
			    success : function(respuesta)
			    { 
			    	document.getElementById('cargando').style.display = 'none';
			    	if(respuesta == "false")
			    		alert('Error al eliminar cheque nominativo')
			    	else
			    		consultaChequesNominativos();
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
						alert('Error al actualizar cheque.')
				}
			});
    }
}



/*** AGREGAR CHEQUE NOMINATIVO  ***/
function agregarChequeNominativo(fecha)
{
	document.getElementById('cargando').style.display = 'block';
	if(validarDatosCheque())
	{
		$.ajax({
		    url :'MantoCheques', 
		    data : "vista=MantenimientoCheques.jsp&operacion=AltaChequeNominativo" +
		    		"&tipoPago="+ $("#id_tipoPagoMantoCheque").val() + "&folio_caja="+  $("#id_folioCajaMantoCheque").val() +
		    		"&referencia="+ $("#id_chequeMantoCheque").val() + "&cve_banco="+ $("#id_bancoEmisorMantoCheque").val() +
		    		"&cliente="+ $("#id_clienteMantoCheque").val() + "&importe="+ $("#id_importeMantoCheque").val() +
		    		"&fecha_poliza="+ $("#txt_fechaPolizaAltaMantoCheque").val(),
		    type : 'POST',
		    dataType : 'Json',
		    success : function(respuesta)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if(respuesta == "false")
		    		alert('Error al agregar el cheque nominativo')
		    	else
		    	{
		    		inicializaVariables()
		    		consultaChequesNominativos();
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
					alert('Error al actualizar cheque.')
			}
		});
	}
	else
	{
		document.getElementById('cargando').style.display = 'none';
	}
}


function validarDatosCheque()
{
	if($("#id_bancoEmisorMantoCheque").val() == "0")
	{
		alert('El banco emisor no es valido')
		return false;
	}
	
	if($("#id_folioCajaMantoCheque").val() == "" || $("#id_folioCajaMantoCheque").val()  == "0")
	{
		alert('El  folio de caja no es valido.')
		return false;
	}	
	
	if($("#id_chequeMantoCheque").val() == "0"  || $("#id_chequeMantoCheque").val()  == "0")
	{
		alert('El numero de cheque es valido')
		return false;
	}
		
	if($("#id_tipoPagoMantoCheque").val() == "0")
	{
		alert('El tipo de pago no es valido')
		return false;
	}
	
	if($("#id_clienteMantoCheque").val() == "" || $("#id_clienteMantoCheque").val()  == "0")
	{
		alert('El cliente capturado no es valido')
		return false;
	}
	
	if($("#id_importeMantoCheque").val() == "" || $("#id_importeMantoCheque").val()  == "0")
	{
		alert('El importe capturado no es valido')
		return false;
	}
	
	if(!validaFechaPoliza($("#txt_fechaPolizaAltaMantoCheque").val()))
	{
		alert('La fecha de la poliza no puede ser menor al dia de hoy')
		return false;
	}
	return true;
}

function validaFechaPoliza(fechaPoliza)
{
	var fechaIngresada = new Date();
    var arrayfecha = fechaPoliza.split("/");
    fechaIngresada.setFullYear(arrayfecha[2],arrayfecha[1]-1,arrayfecha[0])
    var fechaActual = new Date();
    
    if (fechaIngresada < fechaActual)
    	return false;
    else
    	return true;
}

function mostrarOcultarDivAltaCheque()
{
	if ($("#AltaChequeNominativo").is(":visible")) 
	{
	   OcultarDiv('AltaChequeNominativo')
	}
	else
	{
		MostrarDiv('AltaChequeNominativo')
	}
}

