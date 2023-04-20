function MuestraPanel (div, menu)
{
	var divMostrar ="#" + div;
	var MunuActivo ="#" + menu;
    $(divMostrar).show();
    $(MunuActivo).css('background-color', '#337AB7');
}

function IniciaModuloDeCorteDePanamericano(div, menu)
{
	MuestraPanel(div, menu);
	inicializaVariables();
	buscaCortesDeCajaEnBD('0')
	$("#lb_totalPanamericano").text("0.00")
	configurarMenuPrincipalXPerfilesUsuario();
	inicializarSessionDelSemaforoDeIngresos();
}

function inicializaVariables()
{
	$('#txt_fechaIni').val(ObtenerFechaActual());
	$('#txt_fechaFin').val(ObtenerFechaActual());
	$('#txt_fecha_polizaRecValores').val(ObtenerFechaActual());
	$('#txt_no_papeleta').val("");	
	$('#txt_no_plomo').val("");	
	$('#txt_papeletaBuscar').val("");	
	$('#txt_plomoBuscar').val("");	
	$('#txt_folioCorte').val("");	
	$('#txt_folioPanamericano').val("");
	$('#cmbEstatus').val(2);
	$('#lb_totalPanamericano').text("0.00");
}


/***  CONSULTA CORTES DE CAJA O PANAMERICANO ***/
function buscaCortesDeCajaEnBD(origen)
{
	document.getElementById('cargando').style.display = 'block';
	let fecha_ini = $('#txt_fechaIni').val();
	let fecha_fin =	$('#txt_fechaFin').val();
	let estatus =$('#cmbEstatus').val();
	let papeleta =$('#txt_papeletaBuscar').val();	
	let plomo=$('#txt_plomoBuscar').val();	
	let folio_corte =$('#txt_folioCorte').val();	
	let folio_panamericano =$('#txt_folioPanamericano').val();
	
	$.ajax({
	    url :'CortePanamericano', 
	    data : "vista=CortePanamericano.jsp&operacion=ConsultaCortesDeCaja&fecha_ini=" +  fecha_ini + "&fecha_fin=" + fecha_fin +"&IdEstatus=" + estatus + "&origen=" + origen+
	    	   "&papeleta= " +papeleta + "&plomo=" + plomo + "&folio_corte=" +folio_corte + "&folio_panamericano= " + folio_panamericano, 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(json)
	    { 
	    	if(json.length > 0)
	        {
        		OcultarDiv('divMjsInfo');
        		llenaGridCortePanamericano(json)
        		document.getElementById('cargando').style.display = 'none';
        		MostrarDiv('divGeneraCortePanamericano')
	        }
		    else
	        {
        		mostrarMsjInfo('No se encontraron registros en el sistema en el periodo  ' + fecha_ini +  "  y  " +  fecha_fin);
	        	OcultarDiv('dgCortePanamericano');
	        	OcultarDiv('divGeneraCortePanamericano')
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
				alert('Error al buscar egresos.')
		}
	});
}

function llenaGridCortePanamericano(data)
{
	var db =
	{
		loadData: function (filter)/** seccion de filtros **/
	    {
	    	 return $.grep(data, function (corte) {
	    		 return (!filter.nombre_pago || ingreso.nombre_pago.indexOf(filter.nombre_pago) > -1)
	            });
	    },
	    insertItem: function (insertingClient) {
	        data.push(insertingClient);
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    { },
	 };
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#dgCortePanamericano").jsGrid({
    	    		 width: "90%",
    	             height: "300px",
    	             editing: false,
    	             filtering: true,
    	             sorting: true,
    	             paging: false,
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
    	             rowRenderer: function (item) {
    	                 var $row = $('<tr>');
    	                 this._renderCells($row, item);
    	                 
    	                 $addr = $row[0].children[11];
    	                 $($addr).attr("id", "popover");
    	                 $($addr).attr(item.nombre_usuario);
    	                 $($addr).attr("title", item.nombre_usuario);
    	                 
    	                 $addr1 = $row[0].children[13];
    	                 $($addr1).attr("id", "popover");
    	                 $($addr1).attr(item.nombre_usuario_panamericano);
    	                 $($addr1).attr("title", item.nombre_usuario_panamericano);
    	                 
    	                 return $row;
    	             },
    	             onRefreshed: function (args) { 
    	            	 /** seccion de totales **/
    	            	 let items = args.grid.option("data");
    	            	 let totales= calculaImportesTotalesDelGrid(items)
    	                 let $totalRow = $("<tr>").addClass("total-row");
    	                 args.grid._renderCells($totalRow, totales);
    	                 args.grid._content.append($totalRow);
    	             },
    	             fields: 
    	             [    	            	 
    	                 { name: "uname", title: "Uname", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 { name: "uname_br", title: "Uname", type: "text",  width:25, align: 'center', editing: false, inserting: false, filtering: true,  css: 'EG_hide'},
    	                 {
                             name: "checked", title: " ", align: "center", width: 12, editing: false,
                             itemTemplate: function (value, item) {
                            	 if(item.folio_corte > 0 && item.estatus == 2)
                            	 {
                            		 return $("<input>").attr("type", "checkbox")
	                                     .attr("checked", false || value)
	                                 .on("click", function (event) {
	                                     event.stopPropagation();
	                                 })
	                                 .on("change", function () {
	                                     var seleccionado = $(this).is(":checked");
	                                     var total = calculaTotalCortePanamericano(seleccionado, item.importeEfectivo)
	                                     $('#lb_totalPanamericano').text(agregarCommas(parseFloat(total).toFixed(2)));
	                                     item.checked = $(this).is(":checked");
	                                 });
                            	 }
                             }
                         },
    	                 { name: "folio_corte", title: "CORTE CAJA",  type: "text", width: 15, align: 'center', editing: false, inserting: false, filtering: true, },
    	                 { name: "fecha_corteCaja", title: "FECHA CORTE CAJA",  type: "text", width: 30, align: 'center', editing: false, inserting: false, filtering: true,}, 
    	                 { name: "folio_panamericano",  title: "FOLIO PANAMERICANO", type: "text", width: 30, align: 'center', editing: false, inserting: false, filtering: true},
    	                 { name: "fecha_panamericano",  title: "FECHA PANAMERICANO", type: "text", width: 30, align: 'center', editing: false, inserting: false, filtering: true,
    	                	 itemTemplate: function (value, item) {
    	                         return crearColumnaFechaParaGrid(item);
    	                     }	
    	                 },
    	                 { name: "papeleta",  title: "PAPELETA", type: "text", width: 25, align: 'right', editing: false, inserting: false, filtering: false,},
    	                 { name: "plomo",  title: "PLOMO", type: "text", width: 20, align: 'right', editing: false, inserting: false, filtering: false,},
    	                 { name: "importe",  title: "IMP CORTE CAJA", type: "text", width: 40, align: 'right', editing: false, inserting: false, filtering: false,},
    	                 { name: "importeEfectivo",  title: "RECOLECCION VALORES", type: "text", width: 30, align: 'right', editing: false, inserting: false, filtering: false,},
    	                 { name: "usuario",  title: "USUARIO CORTE ", type: "text", width: 30, align: 'center', editing: false, inserting: false, filtering: true,},
    	                 { name: "nombre_usuario", title: "NOMBRE ",  type: "text", width:25, align: 'left', editing: false, inserting: false, filtering: true,css: 'EG_hide'},
    	                 { name: "usuario_panamericano",  title: "USUARIO PANAMERICANO ", type: "text", width: 30, align: 'center', editing: false, inserting: false, filtering: true,},
    	                 { name: "nombre_usuario_panamericano", title: "NOMBRE ",  type: "text", width:25, align: 'left', editing: false, inserting: false, filtering: true,css: 'EG_hide'},
    	                 { name: "estatus",  title: "ESTATUS", type: "text", width: 30, align: 'center', editing: false, inserting: false, filtering: true,
    	                	 itemTemplate: function (value, item) {
    	                         return crearColumnaEstatusParaGrid(value);
    	                     }	
    	                 },
    	                 { name: "hora_pro",  title: "HORA", type: "text", width: 20, align: 'center', editing: false, inserting: false, filtering: true,css: 'EG_hide'},
    	                 { name: "fecha_poliza",  title: "", type: "text", width: 20, align: 'center', editing: false, inserting: false, filtering: true,css: 'EG_hide'},
    	                
	                 ],
	        	 });
	         });
     $("#dgCortePanamericano").show();
}


/*** SECCION TOTALES DEL GRID  ***/
function calculaImportesTotalesDelGrid(items)
{
	 let total = {
			 uname: "",uname_br: "",Checked: "TOTAL", folio_corte: "", fecha_corteCaja: "",usuario: "", nombre_usuario: "", importe:0, importeEfectivo:0, estatus: "",fecha_pro: "",hora_pro: "", 
			 fecha_poliza: "", fecha_panamericano: "", IsTotal: true
     };
	  
	 items.forEach(function (item){
         total.importe += parseFloat(item.importe.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', '')); 
         total.importeEfectivo += parseFloat(item.importeEfectivo.replace(',', '').replace(',', '').replace(',', '').replace(',', '').replace(',', '')); 
         
     });
	  
	 total.importe = "$ " + FormatearTotalesDeGrid(total.importe)
	 total.importeEfectivo = "$ " + FormatearTotalesDeGrid(total.importeEfectivo)
     return total;
}

function FormatearTotalesDeGrid(importe)
{
	let importeTotalGrid = parseFloat(importe).toFixed(2);
	importeTotalGrid = agregarCommas(importeTotalGrid);
	return importeTotalGrid;
}


/*** ESTILOS FILAS DEL GRID ***/
function crearColumnaEstatusParaGrid(value)
{
	if (value == "2") {
        return $("<div>").attr("class", "EG_IPendiente").text("Corte De Caja");
    }
    else if (value == "3") {
        return $("<div>").attr("class", "EG_IConfirmado").text("Rec. Valores");
    }
    else if (value == "5") {
        return $("<div>").attr("class", "EG_IPoliza").text("Poliza");
    }
}

function crearColumnaFechaParaGrid(item)
{
	if (item.folio_panamericano == "0") {
        return $("<div>").text("");
    }
    else  {
        return $("<div>").text(item.fecha_panamericano);
    }
}


/*** SECCION TOTALES CORTE PANAMERICANO ***/
function calculaTotalCortePanamericano(seleccionado,importe)
{
	 let total_actual =  $('#lb_totalPanamericano').text().replace(",", "").replace(",", "").replace(",", "").replace(",", "");
	 let total = 0;
	  if (seleccionado === true) 
	  {
     	 total = parseFloat(total_actual) + parseFloat(importe.replace(",", "").replace(",", "").replace(",", "").replace(",", ""));
      }
      else 
      {
     	 total = parseFloat(total_actual) - parseFloat(importe.replace(",", "").replace(",", "").replace(",", "").replace(",", ""));
      }

      if (total < 0) 
     	 total = 0;
	 return total;
}


/*** GENERA CORTE PANAMERICANO ***/
function generarCortePanamericano()
{
	document.getElementById('cargando').style.display = 'block';
	let total_actual =  $('#lb_totalPanamericano').text();
	let numeroPapeleta =  $('#txt_no_papeleta').val();
	let numeroPlomo =  $('#txt_no_plomo').val();
   
	var bandera = confirm("El corte Rec. Valores con Num. Papeleta: " + numeroPapeleta +" sera Registrado con FECHA POLIZA: " + $("#txt_fecha_polizaRecValores").val());
    if (bandera == true)
    {
    	
    	if($("#txt_no_papeleta").val() == "" || $("#txt_no_plomo").val() == "")
    	{
    		alert("Ingresa un folio de papeleta y un folio de plomo.")
    		document.getElementById('cargando').style.display = 'none';
    	}
    	else
    	{
    		let respuesta = validarSiFechaPolizaEsFinDeSemana($("#txt_fecha_polizaRecValores").val()); 
    		if(respuesta === "DOMINGO")
    		{
    			alert("La fecha de la poliza no puede ser Domingo")
        		document.getElementById('cargando').style.display = 'none';
    		}
    		else
    		{
	    		let items = $("#dgCortePanamericano").jsGrid("option", "data");
	    		let jsonCortesCaja = JSON.stringify(items);
	
	    		$.ajax({
	    		    url :'CortePanamericano', 
	    		    data : "vista=CortePanamericano.jsp&operacion=GeneraCortePanamericano&jsonCortesCaja=" +jsonCortesCaja + "&NumPapeleta=" + numeroPapeleta + "&NumPlomo=" + numeroPlomo + "&importe= " + $("#lb_totalPanamericano").text() + 
	    		           "&fechaPolizaRecValores=" +  $("#txt_fecha_polizaRecValores").val(),
	    		    type : 'POST',
	    		    dataType : 'Text',
	    		    success : function(impCortePanamericano)
	    		    { 
	    		    	document.getElementById('cargando').style.display = 'none';
	    		    	if(impCortePanamericano == "")
	    		    	{
	    		    		document.getElementById('cargando').style.display = 'none';
	    		    		alert("Error al generar el Corte de Panamericano");
	    		    	}
	    		    	else
	    		    	{
	    		    		document.getElementById('cargando').style.display = 'none';
	    		    		buscaCortesDeCajaEnBD('1');
	    		    		$('#txt_no_papeleta').val("");	
	    		    		$('#txt_no_plomo').val("");	
	    		    		$('#cmbEstatus').val(2);
	    		    		$('#lb_totalPanamericano').text("0.00");
	    		    		colocaimporteEnFichaBancaria(impCortePanamericano, numeroPapeleta, numeroPlomo);
	    			    	MostrarDiv('divAlertaCortePanamericano');
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
	    					alert('Error al buscar egresos.')
	    			}
	    		});
    		}
    	}
    }
    else 
    {
    	document.getElementById('cargando').style.display = 'none';
    }

}

function validarSiFechaPolizaEsFinDeSemana(fechaPoliza)
{
	let array = fechaPoliza.split('/');	
	let date =new Date(array[2] + '-' +array[1]  + '-'+ array[0] );
	let respuesta_dia = "VALIDO";
	if (date.getDay() == 6)
	{
		respuesta_dia='DOMINGO';
	}
	return respuesta_dia;
}


function colocaimporteEnFichaBancaria(str_importe, numeroPapeleta, numeroPlomo)
{
	$("#div_listaImporteEfectivo").empty();
	let contenidoDivEfectivo = " <table align=\"center\" width=\"90%\">" +
									"<tr> " +
									"<td valign=\"bottom\" align=\"right\" style=\"font-weight: bold; font-size: 20px\">$</td> " ;
	
	var arrayImporte = str_importe.split("/");
	for (let item = 0; item < arrayImporte.length; item++) 
	{
		contenidoDivEfectivo += " <td align=\"center\"  style=\"border:1px solid #C0C0C0; font-size:16px; font-weight: bold\" >" +
								 arrayImporte[item] +
								" </td>";	
	}
	contenidoDivEfectivo += "</tr> </table>";
	$("#div_listaImporteEfectivo").append(contenidoDivEfectivo);
	$('#NumPapeletaFichaBan').text(numeroPapeleta);
	$('#NumPlomoFichaBan').text(numeroPlomo);
	
}













