function gridInicial()
{
	$("#encabezadoPedidosInicial").hide()
	consultaPedidosBD();
}

function mostrarMonitor()
{
    $('#liAsignacion').removeClass('active');
    $('#liMonitor').addClass('active');
    $("#asignacion").hide()
    $("#monitor").show()
}
function mostrarAsignacion()
{
	$('#liMonitor').removeClass('active');
    $('#liAsignacion').addClass('active');
    $("#monitor").hide()
    $("#asignacion").show()
}
function actualizar()
{
	consultaPedidosBD();
}

function asignar()
{
//	alert("Debe seleccionar un pedido para poder asignarlo")
	$("#divCancelacion").show()
	$("#msjCancelacion").text("Se asignaran lo siguientes pedidos: "+$("#pedidosSelec").val().substring(1,$("#pedidosSelec").val().length));
}




function selectChoferes(valor) 
{
	$("#choferSelect").val(valor)
}


function consultarTrayecto()
{
	var trayecto = $("#busquedaTrayecto").val();
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : "accion=ConsultarTrayecto&trayecto="+trayecto, 
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
	        		llenaGridMonitor(data)
		        	MostrarDiv('dgMonitor');
	        	}
	        	else
	        	{	
	        		alert("No existe treyecto con el id: "+trayecto)
	        		
	        	}
        	}
	        else		        	
	    var n;
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				
			}
		}
	});
	
}




function llenaGridMonitor(data)
{

	
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	return $.grep(data, function (egreso) {
	            return (!filter.id_trayecto|| egreso.id_trayecto === filter.id_trayecto || egreso.id_trayecto == filter.id_trayecto || egreso.id_trayecto.includes(filter.id_trayecto))
	                     &&  (!filter.estatus.toUpperCase()|| egreso.estatus.toUpperCase() === filter.estatus.toUpperCase() || egreso.estatus.toUpperCase() == filter.estatus.toUpperCase() || egreso.estatus.toUpperCase().includes(filter.estatus.toUpperCase()))
	                     &&  (!filter.uname.toUpperCase()|| egreso.uname.toUpperCase() === filter.uname.toUpperCase() || egreso.uname.toUpperCase() == filter.uname.toUpperCase() || egreso.uname.toUpperCase().includes(filter.uname.toUpperCase()))
	                     &&  (!filter.num_chofer.toUpperCase()|| egreso.num_chofer.toUpperCase() === filter.num_chofer.toUpperCase() || egreso.num_chofer.toUpperCase() == filter.num_chofer.toUpperCase() || egreso.num_chofer.toUpperCase().includes(filter.num_chofer.toUpperCase()))
                         &&  (!filter.usuario_asignacion.toUpperCase()|| egreso.usuario_asignacion.toUpperCase() === filter.usuario_asignacion.toUpperCase() || egreso.usuario_asignacion.toUpperCase() == filter.usuario_asignacion.toUpperCase() || egreso.usuario_asignacion.toUpperCase().includes(filter.usuario_asignacion.toUpperCase()))
                         &&  (!filter.fecha_asignacion.toUpperCase()|| egreso.fecha_asignacion.toUpperCase() === filter.fecha_asignacion.toUpperCase() || egreso.fecha_asignacion.toUpperCase() == filter.fecha_asignacion.toUpperCase() || egreso.fecha_asignacion.toUpperCase().includes(filter.fecha_asignacion.toUpperCase()))
                         &&  (!filter.hora_asignacion.toUpperCase()|| egreso.hora_asignacion.toUpperCase() === filter.hora_asignacion.toUpperCase() || egreso.hora_asignacion.toUpperCase() == filter.hora_asignacion.toUpperCase() || egreso.hora_asignacion.toUpperCase().includes(filter.hora_asignacion.toUpperCase()))
		            	    
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
    	    	 $("#dgMonitor").jsGrid({
    	    		 width: "99%",
    	             height: "400px",
    	             editing: false,
    	             filtering: true,
    	             selecting: true,
    	             sorting: true ,
    	             paging: false,
    	             pageSize: 800,
    	             controller: 
    	             {
    	                 loadData: function () 
    	                 {
    	                     dataType: "json"
    	                     return data ;
    	                 }
    	             },
    	             controller: db,
    	             autoload: true,
    	             fields: 
    	             [
    	            	 { name: "uname", type: "text", title: "uname", width:20, align: 'left',filtering: true},
    	            	 { name: "id_trayecto",  type: "text", title: "TRAYECTO", width: 20, align: 'center', filtering: true },
    	                 { name: "num_chofer", type: "text", title: "CHOFER", width:45, align: 'left', filtering: true},
    	                 { name: "fecha_asignacion", type: "text", title: "FECHA ASIGNACION", width:30, align: 'left', filtering: true},
    	                 { name: "hora_asignacion",  type: "text", title: "HORA ASIGNACION",width: 30, align: 'center', filtering: true},
    	                 { name: "usuario_asignacion",  type: "text", title: "USUARIO ASIGNO", width: 45, align: 'center', filtering: true},
    	                 { name: "estatus",  type: "text", title: "ESTATUS", width: 25, align: 'center', filtering: true}
  
    	             ],
	                 
	        	 });
	         });
}















function asignarPedidos() 
{
	var chofer = $("#choferSelect").val();
	var pedidos = s();
	
	if(pedidos != "")
	{
		
		if(chofer =! "" && chofer !="0")
		{
			
		document.getElementById('cargando').style.display = 'block';
		$("#divMsjError").hide();
		$("#divMsjExito").hide();
		$.ajax({
		    url :'MonitorPedidosServlet', 
		    data : "accion=AsignarPedidos&pedidos="+pedidos+"&c="+$("#choferSelect").val(), 
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
		        			alert("Pedidos asignados correctamente con el trayecto: "+data);
		        			$("#divCancelacion").hide();
		        			consultaPedidosBD();
		        	} 
		        	else
		        	{	
		        		alert("Hubo un error al asignar pedidos,intente mas tarde");
		        		$("#divCancelacion").hide()
		        		consultaPedidosBD();
		        		
		        	}
	        	}
		        else		        	
		    var n;
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				if (xhr.status === 200)
				{
					alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
					
				}
			}
		});
		}
		else
		{
			alert("Debe seleccionar un chofer")
		}
	}
	else
	{
		alert("Debe seleccionar un pedido almenos")
		$("#divCancelacion").hide()
	}
}

function selectZonasAct(valor) 
{
	var split = valor.split("*");
	document.getElementById("descripcionZona").value = split[0];
	document.getElementById("letraZona").value = split[1];
}
function estatusAct(valor) 
{
	var split = valor.split("*");
	document.getElementById("descripcionEstatus").value = split[1];
	document.getElementById("valorEstatus").value = split[0];
}



function consultaClic()
{
	document.getElementById('cargando').style.display = 'block';
	$("#dgZonas").hide();
	$("#divMsjError").hide();
	var  fecha = $('#txt_fechaIni').val();
	var  fin = $('#txt_fechaFin').val();
	var orden = $('#orden').val();
	var pedido = $('#pedido').val();
	var msj = '';
	var letra
	var estatus
	if ($('#letraZona').val() == '')
	{
		letra = $('#zonaInicial').val(); 
	}
	else 
	{	
		letra = $('#letraZona').val();
	}
	if ($('#valorEstatus').val() == '')
	{
		estatus = 9; 
	}
	else 
	{	
		estatus = $('#valorEstatus').val();
	}
	
	var descripcionEstatus;
	if (estatus == 0)
	{
		descripcionEstatus = "PENDIENTE";
	}
	if (estatus == 3)
	{
		descripcionEstatus = "DESASIGNADO";
	}
	if (estatus == 9)
	{
		descripcionEstatus = "TODO";
	}
	else if (estatus == 1)
	{
		descripcionEstatus = "EN TRANSITO";
	}
	else if (estatus == 2)
	{
		descripcionEstatus = "ENTREGADO";
	}
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : "accion=ConsultarPedidos&letra="+letra+"&inicio="+fecha+"&orden="+orden+"&fin="+fin+"&pedido="+pedido+"&estatus="+estatus, 
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

		        	llenaGridChequesClic(data)
//		        	MostrarDiv('dgZonasClic');
		        	$('#orden').val("");
		        	$('#pedido').val("");
	        	} 
	        	else
	        	{
	        		
	        		
	        		
	        		if(orden != "")
	        		{
	         			document.getElementById('cargando').style.display = 'none';
		        		$("#dgZonasClic").hide();
		        		$("#dgZonas").hide();
		        		var mensaje = "No existen pedidos con el numero de orden de entrega: "+orden;
		        		$("#msjError").text(mensaje);
						msjError();
	        		}
	        		else if(pedido != "")
	        		{
	         			document.getElementById('cargando').style.display = 'none';
		        		$("#dgZonasClic").hide();
		        		$("#dgZonas").hide();
		        		var mensaje = "No existen pedidos  con el rango de fecha de "+fecha+" a "+fin+", pedido:  "+pedido+" y estatus: "+descripcionEstatus;
		        		$("#msjError").text(mensaje);
						msjError();
	        		}	
	        		else if(estatus == 9)
	        		{
	        			document.getElementById('cargando').style.display = 'none';
		        		$("#dgZonasClic").hide();
		        		$("#dgZonas").hide();
		        		var mensaje = "No existen pedidos  con el rango de fecha de "+fecha+" a "+fin;
		        		$("#msjError").text(mensaje);
						msjError();
	        		}
	        		else
	        		{
	        			
	        		
	        		document.getElementById('cargando').style.display = 'none';
	        		$("#dgZonasClic").hide();
	        		$("#dgZonas").hide();
	        		var mensaje = "No existen pedidos  con el rango de fecha de "+fecha+" a "+fin+", zona: "+letra+" y estatus: "+descripcionEstatus;



	        			$("#msjError").text(mensaje);
						msjError();
	        		
	        		}
	        	}
        	}
	        else		        	
	    var n;
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				
			}
		}
	});


}

function msjError()
{
	$("#divMsjError").show();
	$('#orden').val("");
	$('#pedido').val("");
}

function cerrarRespuesta() {
	$("#divMsjExito").hide();
	$("#divMsjError").hide();
}



function consultaPedidosBD()
{

	document.getElementById('cargando').style.display = 'block';
	$("#divMsjError").hide();
	$("#divMsjExito").hide();
	$.ajax({
	    url :'MonitorPedidosServlet', 
	    data : "accion=ConsultarPedidos", 
	    type : 'POST',
	    dataType : 'Json', 
	    success : function(respuesta)
	    { 
	
	        if(respuesta)
        	{
	        	document.getElementById('cargando').style.display = 'none';
	        	$("#encabezadoPedidosInicial").show()
	        	var data = respuesta;
	        	if( data.length > 0)
	        	{
	        		$("#encabezadoPedidosInicial").hide()
	        		$("#encabezadoPedidos").show()
	        		llenaGridCheques(data)
		        	MostrarDiv('dgZonas');
	        	} 
	        	else
	        	{	
	        		$("#encabezadoPedidosInicial").show()
	        		$("#encabezadoPedidos").hide()
	        		$("#msjError").text("No existen pedidos para asignar a chofer disponibles")
	        		$("#divMsjError").show();
	        	}
        	}
	        else		        	
	    var n;
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			if (xhr.status === 200)
			{
				alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
				
			}
		}
	});

}
function ObtenerFechaActual()
{
	var fecha = new Date();
	let dia = String(fecha.getDate()).padStart(2, '0');
	let mes = String(fecha.getMonth() + 1).padStart(2, '0'); 
	let year = fecha.getFullYear();
	
	fecha = dia + '/' + mes + '/' + year;
	return fecha;
}


function llenaGridChequesClic(dataR)
{
 
}

function mostrarUbicacion(ICancelado) 
{
	
	
	if(ICancelado.facturas == null)
	{
		alert("No tiene facturas este pedido.")
	}
	else 
	{
	
	MostrarDiv('divCancelacion');
	
	var nn;
	nn = ICancelado.facturas;
	var spliteado = nn.split(",");
	var fact = ""
	for (var i = 0; i < spliteado.length; i++)
	{
		if (fact != "")
		{
			fact += spliteado[i]+", ";
		}
		else
		{
			fact = spliteado[i]+", "
		}
	}
	
	var ln = fact.length;
	var fact1 = fact.substring(0,(ln-2));
	$("#msjCancelacion").text("  "+fact1+"  ");
	
	}
}

function llenaGridCheques(data)
{

	
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	    	return $.grep(data, function (egreso) {
	            return (!filter.ode|| egreso.ode === filter.ode || egreso.ode == filter.ode || egreso.ode.includes(filter.ode))
	                     &&  (!filter.ods|| egreso.ods === filter.ods || egreso.ods == filter.ods || egreso.ods.includes(filter.ods))
	                     &&  (!filter.pedido|| egreso.pedido === filter.pedido || egreso.pedido == filter.pedido || egreso.pedido.includes(filter.pedido))
	                     &&  (!filter.cte|| egreso.cte === filter.cte || egreso.cte == filter.cte || egreso.cte.includes(filter.cte))
	                     &&  (!filter.consignatario|| egreso.consignatario === filter.consignatario || egreso.consignatario == filter.consignatario || egreso.consignatario.includes(filter.consignatario))
	                     &&  (!filter.ruta.toUpperCase()|| egreso.ruta.toUpperCase() === filter.ruta.toUpperCase() || egreso.ruta.toUpperCase() == filter.ruta.toUpperCase() || egreso.ruta.toUpperCase().includes(filter.ruta.toUpperCase()))
	                     &&  (!filter.factura.toUpperCase()|| egreso.factura.toUpperCase() === filter.factura.toUpperCase() || egreso.factura.toUpperCase() == filter.factura.toUpperCase() || egreso.factura.toUpperCase().includes(filter.factura.toUpperCase()))
	                     &&  (!filter.direccion.toUpperCase()|| egreso.direccion.toUpperCase() === filter.direccion.toUpperCase() || egreso.direccion.toUpperCase() == filter.direccion.toUpperCase() || egreso.direccion.toUpperCase().includes(filter.direccion.toUpperCase()))
	                     &&  (!filter.nombre_razon_social.toUpperCase()|| egreso.nombre_razon_social.toUpperCase() === filter.nombre_razon_social.toUpperCase() || egreso.nombre_razon_social.toUpperCase() == filter.nombre_razon_social.toUpperCase() || egreso.nombre_razon_social.toUpperCase().includes(filter.nombre_razon_social.toUpperCase()))
	                     &&  (!filter.transporte.toUpperCase()|| egreso.transporte.toUpperCase() === filter.transporte.toUpperCase() || egreso.transporte.toUpperCase() == filter.transporte.toUpperCase() || egreso.transporte.toUpperCase().includes(filter.transporte.toUpperCase()))
	                     &&  (!filter.fecha_factura.toUpperCase()|| egreso.fecha_factura.toUpperCase() === filter.fecha_factura.toUpperCase() || egreso.fecha_factura.toUpperCase() == filter.fecha_factura.toUpperCase() || egreso.fecha_factura.toUpperCase().includes(filter.fecha_factura.toUpperCase()))
	                     &&  (!filter.fecha_ods.toUpperCase()|| egreso.fecha_ods.toUpperCase() === filter.fecha_ods.toUpperCase() || egreso.fecha_ods.toUpperCase() == filter.fecha_ods.toUpperCase() || egreso.fecha_ods.toUpperCase().includes(filter.fecha_ods.toUpperCase()))
//	                     &&  (!filter.cliente|| egreso.cliente === filter.cliente || egreso.cliente == filter.cliente || egreso.cliente.includes(filter.cliente))
//	                     &&  (!filter.zona.toUpperCase()|| egreso.zona.toUpperCase() === filter.zona.toUpperCase() || egreso.zona.toUpperCase() == filter.zona.toUpperCase() || egreso.zona.toUpperCase().includes(filter.zona.toUpperCase()))
//	                     &&  (!filter.fecha_ped.toUpperCase()|| egreso.fecha_ped.toUpperCase() === filter.fecha_ped.toUpperCase() || egreso.fecha_ped.toUpperCase() == filter.fecha_ped.toUpperCase() || egreso.fecha_ped.toUpperCase().includes(filter.fecha_ped.toUpperCase()))
//	                     &&  (!filter.descripcion.toUpperCase().trim()|| egreso.descripcion.toUpperCase().trim() === filter.descripcion.toUpperCase().trim() || egreso.descripcion.toUpperCase().trim() == filter.descripcion.toUpperCase().trim() || egreso.descripcion.toUpperCase().trim().includes(filter.descripcion.toUpperCase().trim()) )
//	                     &&  (!filter.emp_empaque|| egreso.emp_empaque === filter.emp_empaque || egreso.emp_empaque == filter.emp_empaque || egreso.emp_empaque.includes(filter.emp_empaque))
//		            	 &&  (!filter.emp_repartidor|| egreso.emp_repartidor === filter.emp_repartidor || egreso.emp_repartidor == filter.emp_repartidor || egreso.emp_repartidor.includes(filter.emp_repartidor))
//		            	  &&  (!filter.sts_empaque.toUpperCase().trim()|| egreso.sts_empaque.toUpperCase().trim() === filter.sts_empaque.toUpperCase().trim() || egreso.sts_empaque.toUpperCase().trim() == filter.sts_empaque.toUpperCase().trim() || egreso.sts_empaque.toUpperCase().trim().includes(filter.sts_empaque.toUpperCase().trim()) )
//		            	   &&  (!filter.sts_repartidor.toUpperCase().trim()|| egreso.sts_repartidor.toUpperCase().trim() === filter.sts_repartidor.toUpperCase().trim() || egreso.sts_repartidor.toUpperCase().trim() == filter.sts_repartidor.toUpperCase().trim() || egreso.sts_repartidor.toUpperCase().trim().includes(filter.sts_repartidor.toUpperCase().trim()) )
		            	    
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
    	    	 $("#dgZonasClic").jsGrid({
    	    		 width: "99%",
    	             height: "800px",
    	             editing: false,
    	             filtering: true,
    	             selecting: true,
    	             sorting: true ,
    	             paging: false,
    	             pageSize: 800,
    	             controller: 
    	             {
    	                 loadData: function () 
    	                 {
    	                     dataType: "json"
    	                     return data ;
    	                 }
    	             },
    	             controller: db,
    	             autoload: true,
    	             fields: 
    	             [
    	               	 { name: "cnt", type: "checkbox",width: 12, title: " ",visible:true, editing:false,  filtering: false,  
//    	            		 headerTemplate: function(value,item) 
//						     {
//    	            			 var grid = this._grid;
//    	            			 return `<input class="all" id="checkHeader" type="checkbox"    onclick="seleccionarTodosChecks()" ${grid.selections.length==grid.data.length?'checked':''} />`;	
//						     },
						     itemTemplate: function(_, item) 
						     {
						    	 	
						    	 		return `<input class="single"  name="checks[]" value=${item.no} onclick="pedidos(${item.pedido})" type="checkbox" style="height: 10px;width: 10px;"/>`
						    	 	
						    	 	
						   	 }
    	            	 },
    	            	 { name: "ruta", type: "text", title: "RUTA", width:45, align: 'left',filtering: true},
    	            	 { name: "cte",  type: "text", title: "CTE", width: 25, align: 'center', filtering: true },
    	                 { name: "fecha_ods", type: "text", title: "FECHA PEDIDO", width:38, align: 'left', filtering: true},
    	                 { name: "fecha_factura", type: "text", title: "FECHA FACTURA", width:38, align: 'left', filtering: true},
    	                 { name: "ods",  type: "text", title: "ODS",width: 20, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	                 { name: "pedido",  type: "text", title: "PEDIDO", width: 25, align: 'center', filtering: true ,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	                 { name: "ode",  type: "text", title: "ODE", width: 20, align: 'center', filtering: true,itemTemplate: function (value, item) { return estatusColor(value,item)}},
    	                 { name: "factura",  type: "text", title: "FACTURA", width: 25, align: 'center', filtering: true },
    	                 
    	                 { name: "consignatario",  type: "text", title: "CONSIG", width: 20, align: 'center', filtering: true},
    	                 { name: "direccion",  type: "text", title: "DIRECCION", width: 100, align: 'left', filtering: true},
    	                 { name: "nombre_razon_social",  type: "text", title: "RAZON SOCIAL", width: 85, align: 'left', filtering: true},
    	                 { name: "transporte",  type: "text", title: "TRANSPORTE", width: 50, align: 'left', filtering: true }

    	                
    	             ],
	                 
	        	 });
	         });
}
function s()
{

 
	    var arr = $('[name="checks[]"]:checked').map(function(){
	      return this.value;
	    }).get();
	    
	    var str = arr.join(',');
	    
	    return str;
	    

}
function pedidos(pedido) 
{
	var ped = $("#pedidosSelec").val();
	ped = ped +", "+pedido;
	console.log(ped)
	$("#pedidosSelec").val(ped)
}
function soloNumeros(e) {
	   var key = window.Event ? e.which : e.keyCode;
	   return ((key >= 48 && key <= 57) ||(key==8))
	 }
function validaEstatusRepartidor(value, item)
{
    
		if (value === "ENTREGADO")
        {
    	 return $("<div>").attr("style", "color: black; background: #00FF00").text(value);
		
        
        }
     	else if (value === "EN TRANSITO")
     	{
     		
     		return	$("<div>").attr("style", "color: black; background: #ffff00").text(value);
    	
        }
     	else if (value === "DESASIGNADO")
     	{
     		
     		return	$("<div>").attr("style", "color: white; background: #59A659").text(value);
    	
        }
		else if (value === "PENDIENTE")
		{
			return $("<div>").attr("style", "color: white   ;  background: #ff0000").text(value);
		}
		
       
   
}

function Tooltip(value, item)
{
    	 return $("<div>").prop("title", ""+item.nombre+"").text(value);
    	 
}
function TooltipEmpaque(value, item)
{
    	 return $("<div>").prop("title", ""+item.nom_emp+"").text(value);
    	 
}
function TooltipChofer(value, item)
{
    	 return $("<div>").prop("title", ""+item.nom_chofer+"").text(value);
}


function estatusColor(value, item)
{
    	if (item.programada != "99")
        {
    	 return $("<div>").attr("style", "color: white; background: #ec971f").prop("title", "ESTE PEDIDO ESTA REPROGRAMADO").text(value);
        
        }
    	else
    	{
    		return $("<div>").text(value);
    	}

    	
   
}
