function IniciaModuloChequesDevueltos(div, menu)
{
	MuestraPanel(div, menu);
	 document.getElementById('popupChq').style.display = 'none';
	$('#cmbEstatus').val("2");
	$('#txt_fechaIni').val(ObtenerFechaActual());
	$('#txt_fechaFin').val(ObtenerFechaActual());
	$('#txt_folio').val(" ");
	consultaChequesBD();
}

function consultaChequesBD()
{

	let fecha_ini = $('#txt_fechaIni').val();
	let fecha_fin = $('#txt_fechaFin').val();
	let folio = $('#txt_folio').val();
	let estatus = $('#cmbEstatus').val();

	ConsultaDeCheques(fecha_ini,fecha_fin,  estatus,folio)
	
}

function MostrarMtoChq()
{
 document.getElementById('popupChq').style.display = 'block';
}
function OcultarMtoChq()
{
    document.getElementById('popupChq').style.display = 'none';
}


function ConsultaDeCheques(fecha_ini, fecha_fin, estatus,folio)
{
document.getElementById('cargando').style.display = 'block';

	$.ajax({
	    url :'ChequesDevueltos', 
	    data : "vista=ChequesDevueltos.jsp&operacion=ConsultaInicialCheques" +"&fecha_ini=" + fecha_ini  +"&fecha_fin=" + fecha_fin +"&id_estatus=" + estatus+"&folio=" + folio, 
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	document.getElementById('txt_folio').value = " ";
	        	document.getElementById('cargando').style.display = 'none';
	        	var data = respuesta;


		        if( data.length > 0)
	        	{
		        	llenaGridCheques(data)
		        	MostrarDiv('dgChequesDevueltos');
		        	OcultarDiv('divMjsInfo');
	        	}
		        else
	        	{
		        	
		        	if (folio != ' ') {

		        		mostrarMsjInfo('No se encontraron cheques devueltos en el sistema con el folio de corte de caja: '+folio+'  en el periodo '+fecha_ini+' y '+fecha_fin);
					}
		        	else{
	        		mostrarMsjInfo('No se encontraron cheques devueltos en el sistema en el periodo '+fecha_ini+' y '+fecha_fin);
		        	}
		        	OcultarDiv('dgChequesDevueltos');
		        	document.getElementById('cargando').style.display = 'none';
	        	}
        	}
	        else		        	
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
				alert('Error al buscar cheques.')
		}
	});
}


function llenaGridCheques(data)
{
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	return $.grep(data, function (egreso) {
	            return (!filter.folio_corte_caja || egreso.folio_corte_caja.indexOf(filter.folio_corte_caja) > -1)
	        });
	    },
	    insertItem: function (insertingClient) 
	    {
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {
	    },
	 };
	
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#dgChequesDevueltos").jsGrid({
    	    		 width: "65%",
    	             height: "400px",
    	             editing: false,
    	             filtering: false,
    	             sorting: false,
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
    	             onRefreshed: function (args) { 
//    	            	 /** seccion de totales **/
//    	            	 let items = args.grid.option("data");
//    	            	 let totales= calculaImportesTotalesDelGridEgresos(items)
//    	                 let $totalRow = $("<tr>").addClass("total-row");
//    	                 args.grid._renderCells($totalRow, totales);
//    	                 args.grid._content.append($totalRow);
    	             },
    	             fields: 
    	             [
    	                 { name: "folio_corte_caja", type: "text", title: "FOLIO CORTE CAJA", width:8, align: 'center', editing: false, inserting: false, filtering: false},
    	                 { name: "fecha_pro",  type: "text", title: "FECHA",width: 10, align: 'center', editing: false, inserting: false, filtering: false},
    	                 { name: "folio_documento",  type: "text", title: "NO.CHEQUE", width: 8, align: 'center', editing: false, inserting: false, filtering: false},
    	                 { name: "importe", type: "text", title: "IMPORTE", width: 8, align: 'right', editing: false, inserting: false, filtering: false}, 
    	                 { name: "hora_pro", type: "text",title: "MOTIVO", width: 13, align: 'center', editing: false, inserting: false, filtering: false},
    	                 { name: "id_status",  type: "text", title: "", width: 0, align: 'center', editing: false, inserting: false, filtering: false,  css: 'EG_hide',},
    	                 { name: "btnCancelar", type: "text", title: " ", width: 5, align: 'center', editing: false, inserting: false,  filtering: false, 
    	                	
    	                	 
    	                	 
    	                	 itemTemplate: function (value, item) {
    	                		 if (item.id_status == 2 || item.id_status == 3) {
    	                             return $("<button>").attr("class", "EG_btnCancela").on("click", function () {
    	                             mostrarAlertaDeCancelacionn(item);
    
    	                                 return false;
    	                             });
    	                		 }
    	                     }
    	                 }
    	                 
	                 ],
	        	 });
	         });
}



function muestraAlertaConfirmacionIngreso(Iconfirmado)
{

	MostrarDiv('divConfirmar');
	$("#msjConfirmacion").text(Iconfirmado.folio_documento);
	$("#lbDatosIConfirmado").val(
		Iconfirmado.folio_corte_caja + "&" +//0
		Iconfirmado.fecha+ "&" +//1
		Iconfirmado.folio_documento+ "&" +//2
		Iconfirmado.importe+ "&" +//3
		Iconfirmado.descripcion);//18
	
}



function mostrarAlertaDeCancelacionn(ICancelado)
{
	MostrarDiv('divCancelacion');
	$("#msjCancelacion").text( ICancelado.folio_documento);	
}




function CancelarCheque()
{
	
	OcultarDiv('divCancelacion');
	let ICancelado = $('#msjCancelacion').text();
	
	 document.getElementById('cargando').style.display = 'block';
	 
	 
	 $.ajax({
		    url :'ChequesDevueltos', 
		    data : "vista=ChequesDevueltos.jsp&operacion=cancelarCheque"+
    		"&folio_documento="+ ICancelado,
		    type : 'POST',
		    dataType : 'Json',
		    success : function(respuesta)
		    { 

		    	document.getElementById('cargando').style.display = 'none';
		    	consultaChequesBD();

		    	if(respuesta){
		    		
		    	
		    	
		    	mostrarMsjExitoChq('El cheque '+ICancelado+' fue cancelado con exito');
		    	}
		    	else
		    
		    		mostrarMsjError('No se pudo cancelar el cheque  '+ICancelado);
		    	
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
					alert('Error al cancelar cheque.')
			}
		});
	 

}

function mostrarMsjExitoChq(mensaje)
{
	MostrarDiv('divMjsExitoManto');
	$("#lbMsjExitoManto").text(mensaje);
}
function MuestraPanel (div, menu)
{
	var divMostrar ="#" + div;
	var MunuActivo ="#" + menu;
    $(divMostrar).show();
    $(MunuActivo).css('background-color', '#337AB7');
}

function ChecarCheck() 
{
	var arrayClaseOrdenFinal = [];
	var arrayTrues = [];
	var contadorTrues=0;
	var claseOrdenFinal = document.getElementsByClassName("checarCheck");
	for (var i = 0; i < claseOrdenFinal.length; ++i)
	{
		if (typeof claseOrdenFinal[i].value !== "undefined") 
		{	
			arrayClaseOrdenFinal.push(claseOrdenFinal[i].value);
			arrayTrues.push(document.getElementById(arrayClaseOrdenFinal[i]).checked);
		}
	}
	for (var o = 0; o < arrayTrues.length; ++o)
	{console.log(arrayTrues[o])
		if (arrayTrues[o] == true) 
		{
			
			contadorTrues++;
		}
	}
	if (contadorTrues == 0)
	{
		alert('Es necesario seleccionar un cheque como minimo');
		return false
	}
	return true;
}

function Arrays(e) 
{
	var claseOrdenFinal = document.getElementsByClassName("numeroCheques");
	var claseOrdenImporte = document.getElementsByClassName("importeCheques");
	var claseOrdenMotivo = document.getElementsByClassName("motivoCheques");
	var  arrayClaseOrdenFinal= [];
	var  arrayClaseImporte= [];
	var  arrayClaseMotivos= [];
	var split = [];
	split=e.value.split("_");
	for (var i = 0; i < claseOrdenFinal.length; ++i)
	{
		if (typeof claseOrdenFinal[i].value !== "undefined") 
		{	
			arrayClaseOrdenFinal.push(claseOrdenFinal[i].value);
		}
	}
	for (var i = 0; i < claseOrdenImporte.length; ++i)
	{
		if (typeof claseOrdenImporte[i].value !== "undefined") 
		{	
			arrayClaseImporte.push(claseOrdenImporte[i].value);
		}
	}
	for (var i = 0; i < claseOrdenMotivo.length; ++i)
	{
		if (typeof claseOrdenMotivo[i].value !== "undefined") 
		{	
			arrayClaseMotivos.push(claseOrdenMotivo[i].value);
		}
	}
	if (arrayClaseOrdenFinal[split[split.length-1]] == '' || arrayClaseOrdenFinal[split[split.length-1]] == '0') 
	{
		alert('Ingresa un numero de cheque valido.');
		document.getElementById(e.value).checked = false;
	}else if (arrayClaseImporte[split[split.length-1]] == '' ||arrayClaseImporte[split[split.length-1]] == '0') 
	{
		alert('El importe del cheque no puede ser 0.');
		document.getElementById(e.value).checked = false;
	}else if (arrayClaseMotivos[split[split.length-1]] == '') 
	{
		alert('Selecciona el motivo por el que se devuelve el cheque.');
		document.getElementById(e.value).checked = false;
	}
}

function cancelarUno(eId)
{
	var claseOrdenFinal = document.getElementsByClassName("numeroCheques");
	var claseOrdenImporte = document.getElementsByClassName("importeCheques");
	var claseOrdenMotivo = document.getElementsByClassName("motivoCheques");
	var  arrayClaseOrdenFinal= [];
	var  arrayClaseImporte= [];
	var  arrayClaseMotivos= [];
	for (var i = 0; i < claseOrdenFinal.length; ++i)
	{
		if (typeof claseOrdenFinal[i].value !== "undefined") 
		{	
			arrayClaseOrdenFinal.push(claseOrdenFinal[i].value);
		}
	}
	for (var i = 0; i < claseOrdenImporte.length; ++i)
	{
		if (typeof claseOrdenImporte[i].value !== "undefined") 
		{	
			arrayClaseImporte.push(claseOrdenImporte[i].value);
		}
	}
	for (var i = 0; i < claseOrdenMotivo.length; ++i)
	{
		if (typeof claseOrdenMotivo[i].value !== "undefined") 
		{	
			arrayClaseMotivos.push(claseOrdenMotivo[i].value);
		}
	}
if (arrayClaseOrdenFinal[eId] == '' || arrayClaseOrdenFinal[eId] == '0') 
	{
		alert('Ingresa un numero de cheque valido.');
		return  false;
	}else if (arrayClaseImporte[eId] == '' || arrayClaseImporte[eId] == '0') 
	{
		alert('El importe del cheque no puede ser 0.');
		return  false;
	}else if (arrayClaseMotivos[eId] == '') 
	{
		alert('Selecciona el motivo por el que se devuelve el cheque.');
		return  false;
	}
	return  true;
}


function MotivoInputHiddeen(e) 
{	
	var n= e.split("_");
	console.log(n[0]);
	document.getElementById(n[0]+"_motivo2").value = document.getElementById(e).value	
}


function MotivoInputHidden(s,e)
{
		var select = document.getElementById("nSelect");
		var n= s.split("_");
		document.getElementById(n[0]+"_motivo2").value = document.getElementById(s).value	
	}
function MotivoInputHidden2(s,e)
{
	var n= s.split("_");
	document.getElementById(n[0]+"_txtNumeroCheque2").value = e.value	
}
function MotivoInputHidden3(s,e)
{
	var n= s.split("_");
	document.getElementById(n[0]+"_txtImporteCheque3").value =  e.value	
	}

function soloNumeros(e) {
	   var key = window.Event ? e.which : e.keyCode;
	   return ((key >= 48 && key <= 57) ||(key==8))
	 }

function soloNumerosPuntos(e) 
{
	var key = window.Event ? e.which : e.keyCode;
	return ((key >= 48 && key <= 57) ||(key==8) || key==46)
}



function ConfirmarEnvio()
{	 
	var confirmarEnvio=confirm('El cheque devuelto se confirmara en el sistema.');
	if (confirmarEnvio) {
		return true;
	}
	else{
		return false;
	}
}