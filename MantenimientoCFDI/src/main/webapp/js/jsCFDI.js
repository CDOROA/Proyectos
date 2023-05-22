setInterval(actualizarPag, 120000);
function rutinaInicioCFDI() {
	$("#menu-notas").removeClass("Opc-Menu-Activo");
	$("#menu-cfdi").addClass("Opc-Menu-Activo");
	checaPendientes();
	consultaCFDI(1);
	//nIntervId = setTimeout(limpiar,120000);
	//setInterval(rutinaInicioCFDI(), 120000);
}
function actualizarPag(){
	checaPendientes();
	var value = $("input[type=radio][name=inlineRadioOptions]:checked").val();
	switch(value){
	case 1:
		$("#inlineRadio1").prop("checked", true);
		break;
	case 2:
		$("#inlineRadio2").prop("checked", true);
		break;
	case 3:
		$("#inlineRadio3").prop("checked", true);
		break;
	case 4:
		$("#inlineRadio4").prop("checked", true);
		break;
	case 5:
		$("#inlineRadio4").prop("checked", true);
		break;
	case 6:
		$("#inlineRadio6").prop("checked", true);
		break;
	}
	consultaCFDI(value);
	limpiar();
}
function checaPendientes(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI ',
		data : "accion=ConsultarPendientes",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					
					for(var i=0;i<data[0].pendientes.length;i++){
						//console.log(data[0].pendientes[i]+":"+i);
						switch(i){
							case 0:
								if(data[0].pendientes[i]=="1"){
									document.getElementById('f').style.background="red";
									document.getElementById('f').style.color="white";
								}else{
									document.getElementById('f').style.background="white";
									document.getElementById('f').style.color="black";
								}
							break;
							case 1:
								if(data[0].pendientes[i]=="1"){
									document.getElementById('t').style.background="red";
									document.getElementById('t').style.color="white";
								}
								else{
									document.getElementById('t').style.background="white";
									document.getElementById('t').style.color="black";
								}
							break;
							case 2:
								if(data[0].pendientes[i]=="1"){
									document.getElementById('tcdo').style.background="red";
									document.getElementById('tcdo').style.color="white";
								}else{
									document.getElementById('tcdo').style.background="white";
									document.getElementById('tcdo').style.color="black";
								}
							break;
							case 3:
								if(data[0].pendientes[i]=="1"){
									document.getElementById('n').style.background="red";
									document.getElementById('n').style.color="white";
								}else{
									document.getElementById('n').style.background="white";
									document.getElementById('n').style.color="black";
								}
							break;
							case 4:
								if(data[0].pendientes[i]=="1"){
									document.getElementById('c').style.background="red";
									document.getElementById('c').style.color="white";
								}else{
									document.getElementById('c').style.background="white";
									document.getElementById('c').style.color="black";
								}
							break;
							case 5:
								if(data[0].pendientes[i]=="1"){
									document.getElementById('p').style.background="red";
									document.getElementById('p').style.color="white";
								}else{
									document.getElementById('p').style.background="white";
									document.getElementById('p').style.color="black";
								}
							break;
						}
					}
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar CFDI´S.')
    }
	});
}
function consultaCFDI(opcion){
	//alert(opcion)
	$("#buscador").empty();
	if(opcion==4||opcion==5){
		$("#buscador").append("<input type='text' placeholder='NUMERO CLIENTE' id='numeroCliente2' onkeyup="+'"'+"validarCliente('#numeroCliente2',this.value);"+'"'+"> <button type='button' class='btn btn-success' onclick='buscarNumeroCliente("+'"'+opcion+'"'+");'>BUSCAR</button><div class='invalid-feedback'>"
       			+"Ingresa un numero cliente."
          		+"</div>&nbsp;");
		document.getElementById('btnGenerarNotas').style.display = 'block';
	}else{
		$("#buscador").append("<input type='text' placeholder='FOLIO' id='buscarFolio' onkeyup="+'"'+"validar('#buscarFolio');"+'"'+"><button type='button' class='btn btn-success' onclick='buscarFolio();'>BUSCAR</button><div class='invalid-feedback'>"
       			+"Ingresa un folio."
          		+"</div>&nbsp;");
		document.getElementById('btnGenerarNotas').style.display = 'none';
	}
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI ',
		data : "accion=Cargar&opcion="+opcion,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//alert(respuesta);
					if(opcion=="4"||opcion=="5"){
						cargaInformacionNotas(respuesta);
					}else if(opcion=="6"){
						cargaInformacionPagos(respuesta);
					}else{
						cargaInformacionCFDI(respuesta);
					}
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar CFDI´S.')
    }
	});
	//nIntervId = setTimeout(consultaCFDI,120000);
}
function cargaInformacionPagos(respuesta){
	console.log(JSON.stringify(respuesta));
	$("#tablaCFDI").empty();
	var res = respuesta[0];
	var cfdi = res.listCFDI;
	//alert(JSON.stringify(data));
	var db = {

			 loadData : function(filter) {
					return $.grep(cfdi, function(client) {
						return (!filter.descripcion.toUpperCase()|| client.descripcion.toUpperCase() === filter.descripcion.toUpperCase() || client.descripcion.toUpperCase() == filter.descripcion.toUpperCase() || client.descripcion.toUpperCase().includes(filter.descripcion.toUpperCase()))
						&&(!filter.serie.toUpperCase()|| client.serie.toUpperCase() === filter.serie.toUpperCase() || client.serie.toUpperCase() == filter.serie.toUpperCase() || client.serie.toUpperCase().includes(filter.serie.toUpperCase()))
						&&(!filter.folio.toUpperCase()|| client.folio.toUpperCase() === filter.folio.toUpperCase() || client.folio.toUpperCase() == filter.folio.toUpperCase() || client.folio.toUpperCase().includes(filter.folio.toUpperCase()))
						&&(!filter.numCliente.toUpperCase()|| client.numCliente.toUpperCase() === filter.numCliente.toUpperCase() || client.numCliente.toUpperCase() == filter.numCliente.toUpperCase() || client.numCliente.toUpperCase().includes(filter.numCliente.toUpperCase()))
						&&(!filter.nombreCliente.toUpperCase()|| client.nombreCliente.toUpperCase() === filter.nombreCliente.toUpperCase() || client.nombreCliente.toUpperCase() == filter.nombreCliente.toUpperCase() || client.nombreCliente.toUpperCase().includes(filter.nombreCliente.toUpperCase()))
						&&(!filter.estatus.toUpperCase()|| client.estatus.toUpperCase() === filter.estatus.toUpperCase() || client.estatus.toUpperCase() == filter.estatus.toUpperCase() || client.estatus.toUpperCase().includes(filter.estatus.toUpperCase()))
						&&(!filter.fecha_pro.toUpperCase()|| client.fecha_pro.toUpperCase() === filter.fecha_pro.toUpperCase() || client.fecha_pro.toUpperCase() == filter.fecha_pro.toUpperCase() || client.fecha_pro.toUpperCase().includes(filter.fecha_pro.toUpperCase()))
						&&(!filter.hora_pro.toUpperCase()|| client.hora_pro.toUpperCase() === filter.hora_pro.toUpperCase() || client.hora_pro.toUpperCase() == filter.hora_pro.toUpperCase() || client.hora_pro.toUpperCase().includes(filter.hora_pro.toUpperCase()))			
					});
				}
	 };
		    window.db = db;
		    db.res;
		    $("#tablaCFDI").jsGrid({
		    	height : "655px",
		        width: "100%",
		        controller: db,
		        filtering: true,
		        autoload:true,
		        pageIndex: 1,
		        pageSize: 10,
		        paging: true,
		        sorting:true,
		        fields: [
		            { title:"CDO",name: "descripcion", type: "text", width: 4,align : 'center'},
		            { title:"SERIE", name: "serie", align:'center', type: "text", width: 4 },
		            { title:"FOLIO",name: "folio", type: "text", width: 4,align : 'center'},
		            { title:"TIPO DOC",name: "tipoDoc",width: 25 , align : 'center',cellRenderer : function(value, item) {
							var item2="NO TRAE";
							var regresa="<td>"
							switch (item.tipoDoc){
							case 1:
								item2="FACTURA";
								break;
							case 2:
								item2="TRANSPASOS";
								break;
							case 3:
								item2="TRASPASOS CDOS";
								break;
							case 4:
								item2="NOTAS DE CREDITO";
								break;
							case 5:
								item2="NOTAS DE CARGO";
								break;
							case 6:
								item2="PAGOS";
								break;
							}
							return $(regresa).addClass("tipoDoc").append(item2);
						}},
						
		            { title:"CLIENTE",name: "numCliente", type: "text", width: 8 , align : 'center'},
		            { title:"NOMBRE CLIENTE",name: "nombreCliente", type: "text", width:80 , align : 'center'},
		            { title:"FECHA",name: "fecha_pro", type: "text", width: 25, align : 'center'},
		            { title:"HORA",name: "hora_pro",  type: "text", width: 8 , align : 'center'},
		            { title:"ESTATUS",name: "estatus", 	type : "select",
						items: [{name:"", valor:""},{name:"No impresa", valor:"0"},{name:"Impresa",valor:"1"}],
						valueField: "valor", textField: "name",width: 20 , align : 'center',cellRenderer : function(value, item) {
							var item2="Impresa";
							var regresa="<td style='background:#c8eccc; color:#005e05;'>"
							if(item.estatus=="0"){
								item2="No impresa";
								regresa="<td style='background:#ffc4cc; color:#94000e;'>"
							}
							return $(regresa).addClass("estatus").append(item2);
							//return regresa;
						}},
						{ title:"SELLADO",name: "sellado",width: 20, align : 'center',cellRenderer : function(value, item) {
							//alert(item.sellado);
								//var item2="Sellado";
								var regresa="<td style='background:#c8eccc; color:#005e05;'>"
								if(item.sellado=='No sellado'){
								//	item2="No sellado";
									regresa="<td style='background:#ffc4cc; color:#94000e;'>"
								}else if(item.sellado=="En proceso"){
								//	item2="No sellado";
									regresa="<td style='background:#ffec9c; color:#9c5600;'>"
								}
								return $(regresa).addClass("estatus").append(item.sellado);
								//return regresa;
							}},
					{ title:"LOG",width: 2 , align : 'center',itemTemplate : function(value, item) {
						let String= "<button type='button' style='font-size:12px;' class='btn btn-danger' onclick='cargaLog("+'"'+item.serie+'"'+","+'"'+item.folio+'"'+")'>LOG</button>";
						return String;
						
					}},
					{ title:"+INFO",width:2, align : 'center',itemTemplate : function(value, item) {
						let String= "<button type='button' style='font-size:12px;' class='btn btn-primary' onclick='cargaInfoCliente("+'"'+item.numCliente+'"'+")'>INFO</button>";
						return String;
						
					}},
             ],		       
             rowDoubleClick: function (args) {
            	 $("#tipoDoc").val(args.item.tipoDoc)
		        	$("#titulo").empty();
		    		$("#titulo").append("<h4 style='width:100%; text-align:center; background:black; color:white;'>DATOS: "+args.item.serie.toUpperCase()+"-"+args.item.folio+"</h4>")
		        	cargaComprobante(args.item.serie, args.item.folio); 
		        	cargaEmisor(args.item.serie, args.item.folio);
		        	cargaReceptor(args.item.serie, args.item.folio);
		        	cargaConceptos(args.item.serie, args.item.folio);
		        	cargaDocumentos(args.item.serie, args.item.folio);
		        	$("#numeroCliente").val(args.item.numCliente);
		        	$("#numeroCliente2").val(args.item.numCliente);
		        	$("#nc").val(args.item.numCliente);
		        	$("#serie").val(args.item.serie);
		        	$("#folio").val(args.item.folio);
		        	consultaImpresora(args.item.serie, args.item.folio);
		        	$("#ode2").val(args.item.ode);
		        	$("#td").val(args.item.tipoDoc);
		        }
		    });
}

function cargaInformacionNotas(respuesta){

	$("#tablaCFDI").empty();
	var res = respuesta[0];
	var cfdi = res.listCFDI;
	//alert(JSON.stringify(data));
	var db = {

			 loadData : function(filter) {
					return $.grep(cfdi, function(client) {
						return (!filter.descripcion.toUpperCase()|| client.descripcion.toUpperCase() === filter.descripcion.toUpperCase() || client.descripcion.toUpperCase() == filter.descripcion.toUpperCase() || client.descripcion.toUpperCase().includes(filter.descripcion.toUpperCase()))
						&&(!filter.serie.toUpperCase()|| client.serie.toUpperCase() === filter.serie.toUpperCase() || client.serie.toUpperCase() == filter.serie.toUpperCase() || client.serie.toUpperCase().includes(filter.serie.toUpperCase()))
						&&(!filter.folio.toUpperCase()|| client.folio.toUpperCase() === filter.folio.toUpperCase() || client.folio.toUpperCase() == filter.folio.toUpperCase() || client.folio.toUpperCase().includes(filter.folio.toUpperCase()))
						&&(!filter.numCliente|| client.numCliente === filter.numCliente || client.numCliente == filter.numCliente)
						&&(!filter.nombreCliente.toUpperCase()|| client.nombreCliente.toUpperCase() === filter.nombreCliente.toUpperCase() || client.nombreCliente.toUpperCase() == filter.nombreCliente.toUpperCase() || client.nombreCliente.toUpperCase().includes(filter.nombreCliente.toUpperCase()))
						&&(!filter.estatus.toUpperCase()|| client.estatus.toUpperCase() === filter.estatus.toUpperCase() || client.estatus.toUpperCase() == filter.estatus.toUpperCase() || client.estatus.toUpperCase().includes(filter.estatus.toUpperCase()))
						&&(!filter.fecha_pro.toUpperCase()|| client.fecha_pro.toUpperCase() === filter.fecha_pro.toUpperCase() || client.fecha_pro.toUpperCase() == filter.fecha_pro.toUpperCase() || client.fecha_pro.toUpperCase().includes(filter.fecha_pro.toUpperCase()))
						&&(!filter.hora_pro.toUpperCase()|| client.hora_pro.toUpperCase() === filter.hora_pro.toUpperCase() || client.hora_pro.toUpperCase() == filter.hora_pro.toUpperCase() || client.hora_pro.toUpperCase().includes(filter.hora_pro.toUpperCase()))			
						&&(!filter.documento.toUpperCase()|| client.documento.toUpperCase() === filter.documento.toUpperCase() || client.documento.toUpperCase() == filter.documento.toUpperCase() || client.documento.toUpperCase().includes(filter.documento.toUpperCase()))
					});
				}
	 };
		    window.db = db;
		    db.res;
		    $("#tablaCFDI").jsGrid({
		    	height : "655px",
		        width: "100%",
		        controller: db,
		        filtering: true,
		        autoload:true,
		        pageIndex: 1,
		        pageSize: 10,
		        paging: true,
		        sorting:true,
		        fields: [
		            { title:"CDO",name: "descripcion", type: "text", width: 4,align : 'center'},
		            { title:"SERIE", name: "serie", align:'center', type: "text", width: 4 },
		            { title:"FOLIO",name: "folio", type: "text", width: 4,align : 'center'},
		            { title:"DOCTO",name: "documento", type: "text", width: 4 , align : 'center'},
		            { title:"TIPO DOC",name: "tipoDoc",width: 25 , align : 'center',cellRenderer : function(value, item) {
							var item2="NO TRAE";
							var regresa="<td>"
							switch (item.tipoDoc){
							case 1:
								item2="FACTURA";
								break;
							case 2:
								item2="TRANSPASOS";
								break;
							case 3:
								item2="TRASPASOS CDOS";
								break;
							case 4:
								item2="NOTAS DE CREDITO";
								break;
							case 5:
								item2="NOTAS DE CARGO";
								break;
							case 6:
								item2="PAGOS";
								break;
							}
							return $(regresa).addClass("tipoDoc").append(item2);
						}},
						
		            { title:"CLIENTE",name: "numCliente", type: "text", width: 8 , align : 'center'},
		            { title:"NOMBRE CLIENTE",name: "nombreCliente", type: "text", width:80 , align : 'center'},
		            { title:"FECHA",name: "fecha_pro", type: "text", width: 25, align : 'center'},
		            { title:"HORA",name: "hora_pro",  type: "text", width: 8 , align : 'center'},
		            { title:"ESTATUS",name: "estatus", 	type : "select",
						items: [{name:"", valor:""},{name:"No impresa", valor:"0"},{name:"Impresa",valor:"1"}],
						valueField: "valor", textField: "name",width: 20 , align : 'center',cellRenderer : function(value, item) {
							var item2="Impresa";
							var regresa="<td style='background:#c8eccc; color:#005e05;'>"
							if(item.estatus=="0"){
								item2="No impresa";
								regresa="<td style='background:#ffc4cc; color:#94000e;'>"
							}
							return $(regresa).addClass("estatus").append(item2);
							//return regresa;
						}},
						{ title:"SELLADO",name: "sellado",width: 20, align : 'center',cellRenderer : function(value, item) {
							//alert(item.sellado);
								//var item2="Sellado";
								var regresa="<td style='background:#c8eccc; color:#005e05;'>"
								if(item.sellado=='No sellado'){
								//	item2="No sellado";
									regresa="<td style='background:#ffc4cc; color:#94000e;'>"
								}else if(item.sellado=="En proceso"){
								//	item2="No sellado";
									regresa="<td style='background:#ffec9c; color:#9c5600;'>"
								}
								return $(regresa).addClass("estatus").append(item.sellado);
								//return regresa;
							}},
					{ title:"LOG",width: 2 , align : 'center',itemTemplate : function(value, item) {
						let String= "<button type='button' style='font-size:12px;' class='btn btn-danger' onclick='cargaLog("+'"'+item.serie+'"'+","+'"'+item.folio+'"'+")'>LOG</button>";
						return String;
						
					}},
					{ title:"+INFO",width:2, align : 'center',itemTemplate : function(value, item) {
						let String= "<button type='button' style='font-size:12px;' class='btn btn-primary' onclick='cargaInfoCliente("+'"'+item.numCliente+'"'+")'>INFO</button>";
						return String;
						
					}},
             ],		       
             rowDoubleClick: function (args) {
            	 $("#tipoDoc").val(args.item.tipoDoc)
		        	$("#titulo").empty();
		    		$("#titulo").append("<h4 style='width:100%; text-align:center; background:black; color:white;'>DATOS: "+args.item.serie.toUpperCase()+"-"+args.item.folio+"</h4>")
		        	cargaComprobante(args.item.serie, args.item.folio); 
		        	cargaEmisor(args.item.serie, args.item.folio);
		        	cargaReceptor(args.item.serie, args.item.folio);
		        	cargaConceptos(args.item.serie, args.item.folio);
		        	cargaDocumentos(args.item.serie, args.item.folio);
		        	$("#numeroCliente").val(args.item.numCliente);
		        	$("#numeroCliente2").val(args.item.numCliente);
		        	$("#nc").val(args.item.numCliente);
		        	$("#serie").val(args.item.serie);
		        	$("#folio").val(args.item.folio);
		        	consultaImpresora(args.item.serie, args.item.folio);
		        	$("#ode2").val(args.item.ode);
		        	$("#td").val(args.item.tipoDoc);
		        }
		    });
}

function cargaInformacionCFDI(respuesta){
	var folios=[];
	$("#tablaCFDI").empty();
	var res = respuesta[0];
	var cfdi = res.listCFDI;
	//alert(JSON.stringify(data));
	var db = {

			 loadData : function(filter) {
					return $.grep(cfdi, function(client) {
						return (!filter.descripcion.toUpperCase()|| client.descripcion.toUpperCase() === filter.descripcion.toUpperCase() || client.descripcion.toUpperCase() == filter.descripcion.toUpperCase() || client.descripcion.toUpperCase().includes(filter.descripcion.toUpperCase()))
						&&(!filter.serie.toUpperCase()|| client.serie.toUpperCase() === filter.serie.toUpperCase() || client.serie.toUpperCase() == filter.serie.toUpperCase() || client.serie.toUpperCase().includes(filter.serie.toUpperCase()))
						&&(!filter.folio.toUpperCase()|| client.folio.toUpperCase() === filter.folio.toUpperCase() || client.folio.toUpperCase() == filter.folio.toUpperCase() || client.folio.toUpperCase().includes(filter.folio.toUpperCase()))
						&&(!filter.ode.toUpperCase()|| client.ode.toUpperCase() === filter.ode.toUpperCase() || client.ode.toUpperCase() == filter.ode.toUpperCase() || client.ode.toUpperCase().includes(filter.ode.toUpperCase()))
						&&(!filter.pedido.toUpperCase()|| client.pedido.toUpperCase() === filter.pedido.toUpperCase() || client.pedido.toUpperCase() == filter.pedido.toUpperCase() || client.pedido.toUpperCase().includes(filter.pedido.toUpperCase()))
						&&(!filter.numCliente.toUpperCase()|| client.numCliente.toUpperCase() === filter.numCliente.toUpperCase() || client.numCliente.toUpperCase() == filter.numCliente.toUpperCase() || client.numCliente.toUpperCase().includes(filter.numCliente.toUpperCase()))
						&&(!filter.nombreCliente.toUpperCase()|| client.nombreCliente.toUpperCase() === filter.nombreCliente.toUpperCase() || client.nombreCliente.toUpperCase() == filter.nombreCliente.toUpperCase() || client.nombreCliente.toUpperCase().includes(filter.nombreCliente.toUpperCase()))
						&&(!filter.estatus.toUpperCase()|| client.estatus.toUpperCase() === filter.estatus.toUpperCase() || client.estatus.toUpperCase() == filter.estatus.toUpperCase() || client.estatus.toUpperCase().includes(filter.estatus.toUpperCase()))
						&&(!filter.fechaPedido.toUpperCase()|| client.fechaPedido.toUpperCase() === filter.fechaPedido.toUpperCase() || client.fechaPedido.toUpperCase() == filter.fechaPedido.toUpperCase() || client.fechaPedido.toUpperCase().includes(filter.fechaPedido.toUpperCase()))
						//&&(!filter.tipoDoc.toUpperCase()|| client.tipoDoc.toUpperCase() === filter.tipoDoc.toUpperCase() || client.tipoDoc.toUpperCase() == filter.tipoDoc.toUpperCase() || client.tipoDoc.toUpperCase().includes(filter.tipoDoc.toUpperCase()))
						&&(!filter.fecha_pro.toUpperCase()|| client.fecha_pro.toUpperCase() === filter.fecha_pro.toUpperCase() || client.fecha_pro.toUpperCase() == filter.fecha_pro.toUpperCase() || client.fecha_pro.toUpperCase().includes(filter.fecha_pro.toUpperCase()))
						&&(!filter.hora_pro.toUpperCase()|| client.hora_pro.toUpperCase() === filter.hora_pro.toUpperCase() || client.hora_pro.toUpperCase() == filter.hora_pro.toUpperCase() || client.hora_pro.toUpperCase().includes(filter.hora_pro.toUpperCase()))			
						&&(!filter.documento.toUpperCase()|| client.documento.toUpperCase() === filter.documento.toUpperCase() || client.documento.toUpperCase() == filter.documento.toUpperCase() || client.documento.toUpperCase().includes(filter.documento.toUpperCase()))
					});
				}
	 };
		    window.db = db;
		    db.res;
		    $("#tablaCFDI").jsGrid({
		    	height : "655px",
		        width: "100%",
		        controller: db,
		        filtering: true,
		        autoload:true,
		        //editing: true,
		        pageIndex: 1,
		        pageSize: 10,
		        paging: true,
		        sorting:true,
		        fields: [
		            { title:"CDO",name: "descripcion", type: "text", width: 4,align : 'center'},
		            { title:"SERIE", name: "serie", align:'center', type: "text", width: 4 },
		            { title:"FOLIO",name: "folio", type: "text", width: 4,align : 'center'},
		            { title:"DOCTO",name: "documento", type: "text", width: 8 , align : 'center'},
		            { title:"ODE",name: "ode", type: "text", width: 7,align : 'center'},
		            { title:"PEDIDO",name: "pedido", type: "text", width: 7, align : 'center'},
		            { title:"FECHA PEDIDO",name: "fechaPedido", type: "text", width: 25, align : 'center'},
		            { title:"TIPO DOC",name: "tipoDoc",width: 25 , align : 'center',cellRenderer : function(value, item) {
							var item2="NO TRAE";
							var regresa="<td>"
							switch (item.tipoDoc){
							case 1:
								item2="FACTURA";
								break;
							case 2:
								item2="TRANSPASOS";
								break;
							case 3:
								item2="TRASPASOS CDOS";
								break;
							case 4:
								item2="NOTAS DE CREDITO";
								break;
							case 5:
								item2="NOTAS DE CARGO";
								break;
							case 6:
								item2="PAGOS";
								break;
							}
							return $(regresa).addClass("tipoDoc").append(item2);
						}},
		            { title:"CLIENTE",name: "numCliente", type: "text", width: 8 , align : 'center'},
		            { title:"NOMBRE CLIENTE",name: "nombreCliente", type: "text", width:110 , align : 'center'},
		            { title:"FECHA",name: "fecha_pro", type: "text", width: 25, align : 'center'},
		            { title:"HORA",name: "hora_pro", type: "text", width: 8 , align : 'center'},
		            { title:"ESTATUS",name: "estatus", 	type : "select",
						items: [{name:"", valor:""},{name:"No impresa", valor:"0"},{name:"Impresa",valor:"1"}],
						valueField: "valor", textField: "name",width: 20 , align : 'center',cellRenderer : function(value, item) {
							var item2="Impresa";
							var regresa="<td style='background:#c8eccc; color:#005e05;'>"
							if(item.estatus=="0"){
								item2="No impresa";
								regresa="<td style='background:#ffc4cc; color:#94000e;'>"
							}
							return $(regresa).addClass("estatus").append(item2);
							//return regresa;
						}},
						{ title:"SELLADO",name: "sellado",width: 20, align : 'center',cellRenderer : function(value, item) {
							//alert(item.sellado);
								//var item2="Sellado";
								var regresa="<td style='background:#c8eccc; color:#005e05;'>"
								if(item.sellado=='No sellado'){
								//	item2="No sellado";
									regresa="<td style='background:#ffc4cc; color:#94000e;'>"
								}else if(item.sellado=="En proceso"){
								//	item2="No sellado";
									regresa="<td style='background:#ffec9c; color:#9c5600;'>"
								}
								return $(regresa).addClass("estatus").append(item.sellado);
								//return regresa;
							}},
							{ title:"PRIORIDAD",name: "prioridad",width: 20, align : 'center',cellRenderer : function(value, item) {
									var regresa="<td>"
									if(item.prioridad=="Alta"){
										//item2="No impresa";
										regresa="<td style='background:#ffc4cc; color:#94000e;'>"
									}
									return $(regresa).addClass("estatus").append(item.prioridad);
									//return regresa;
								}},
					{ title:"LOG",width: 2 , align : 'center',itemTemplate : function(value, item) {
						let String= "<button type='button' style='font-size:12px;' class='btn btn-danger' onclick='cargaLog("+'"'+item.serie+'"'+","+'"'+item.folio+'"'+")'>LOG</button>";
						return String;
						
					}},
					{ title:"+INFO",width:2, align : 'center',itemTemplate : function(value, item) {
						let String= "<button type='button' style='font-size:12px;' class='btn btn-primary' onclick='cargaInfoCliente("+'"'+item.numCliente+'"'+")'>INFO</button>";
						return String;
						
					}},
             ],		       
             rowDoubleClick: function (args) {
            	 $("#tipoDoc").val(args.item.tipoDoc)
		        	$("#titulo").empty();
		    		$("#titulo").append("<h4 style='width:100%; text-align:center; background:black; color:white;'>DATOS: "+args.item.serie.toUpperCase()+"-"+args.item.folio+"</h4>")
		        	cargaComprobante(args.item.serie, args.item.folio); 
		        	cargaEmisor(args.item.serie, args.item.folio);
		        	cargaReceptor(args.item.serie, args.item.folio);
		        	cargaConceptos(args.item.serie, args.item.folio);
		        	cargaDocumentos(args.item.serie, args.item.folio);
		        	$("#numeroCliente").val(args.item.numCliente);
		        	$("#numeroCliente2").val(args.item.numCliente);
		        	$("#nc").val(args.item.numCliente);
		        	$("#serie").val(args.item.serie);
		        	$("#folio").val(args.item.folio);
		        	consultaImpresora(args.item.serie, args.item.folio);
		        	$("#ode2").val(args.item.ode);
		        	$("#td").val(args.item.tipoDoc);
		        }
		    });
		  //  $("#tablaCFDI").jsGrid("fieldOption", "tipoDoc", "visible", false);
}
function cargaInfoCliente(numCliente){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI ',
		data : "accion=CargaInfoCliente&numCliente="+numCliente,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			// alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//console.log(JSON.stringify(respuesta));
					cargaCliente(respuesta,numCliente);
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar comprobante.')
    }
	});
}
function cargaCliente(respuesta, numCliente){
	window.location='#cabecera';
	$("#logTitulo").empty();
	$("#logTitulo").append("Cliente: "+numCliente);
	var formaPago="";
	var metodoPago="";
	var regimenFiscal="";
	var usoCFDI="";
	
	//alert("HOla: " + JSON.stringify(respuesta) );
	$("#log").empty();
//	var contenido="<table class='table'><tr><th>CDO</th><th>SERIE</th><th>FOLIO</th><th>DESCRIPCION</th><th>DOCUMENTO</th><th>DOCUMENTO CFDI</th><th>ODE</th><th>FECHA PRO</th><th>HORA PRO</th></tr>";
//	for(var i=0;i<respuesta[0].listLOG.length;i++){
//		contenido+="<tr><td>"+respuesta[0].listLOG[i].uname+"</td><td>"+respuesta[0].listLOG[i].serie+"</td><td>"+respuesta[0].listLOG[i].folio+"</td><td>"+respuesta[0].listLOG[i].descripcion
//		+"</td><td>"+respuesta[0].listLOG[i].documento+"</td><td>"+respuesta[0].listLOG[i].documentoCFDI+"</td><td>"+respuesta[0].listLOG[i].ode+"</td><td>"+respuesta[0].listLOG[i].fechaPro+"</td><td>"+
//		respuesta[0].listLOG[i].horaPro+"</td></tr>";
//	}
//	contenido+="</table>"
	var contenido="<table class='table'><tr><th>RFC</th><th>FORMA PAGO</th><th>REGIMEN FISCAL</th><th>METODO PAGO</th><th>USO CFDI</th></tr>";
	for(var i=0;i<respuesta[0].listCliente.length;i++){
		if(respuesta[0].listCliente[i].formaPago==undefined||respuesta[0].listCliente[i].descFormaPago==undefined){
			formaPago=" - ";
		}else{
			formaPago=respuesta[0].listCliente[i].formaPago+"-"+respuesta[0].listCliente[i].descFormaPago;
		}
		if(respuesta[0].listCliente[i].metodoPago==undefined||respuesta[0].listCliente[i].descMetodoPago==undefined){
			metodoPago=" - ";
		}else{
			metodoPago=respuesta[0].listCliente[i].metodoPago+"-"+respuesta[0].listCliente[i].descMetodoPago;
		}
		if(respuesta[0].listCliente[i].regimenFiscal==undefined||respuesta[0].listCliente[i].descRegimenFiscal==undefined){
			regimenFiscal=" - ";
		}else{
			regimenFiscal=respuesta[0].listCliente[i].regimenFiscal+"-"+respuesta[0].listCliente[i].descRegimenFiscal;
		}
		if(respuesta[0].listCliente[i].usoCfdi==undefined||respuesta[0].listCliente[i].descUsoCfdi==undefined){
			usoCFDI=" - ";
		}else{
			usoCFDI=respuesta[0].listCliente[i].usoCfdi+"-"+respuesta[0].listCliente[i].descUsoCfdi;
		}
		contenido+="<tr><td>"+respuesta[0].listCliente[i].rfc+"</td><td>"+formaPago+"</td>" +
				"<td>"+regimenFiscal+"</td>" +
						"<td>"+metodoPago+"</td>" +
						"<td>"+usoCFDI+"</td></tr>";
	}
	contenido+="</table>"
		$("#log").append(contenido);
	$("#modalLog").modal("show");
}
function cargaComprobante(serie,folio){
	window.location='#titulo';
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI ',
		data : "accion=CargarComprobantes&serie="+serie+"&folio="+folio,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			// alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//console.log(JSON.stringify(respuesta));
					cargaInformacionComprobante(respuesta,serie,folio);
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar comprobante.')
    }
	});
}
function cargaInformacionComprobante(respuesta,serie,folio){
		
		$("#comprobanteTITULO").empty();
		$("#comprobanteTITULO").append("<h5>Comprobante: "+serie.toUpperCase()+"-"+folio+"</h5>")
		document.getElementById('comprobanteSD').style.display = 'none';
	if(respuesta[0].listComprobante.length>0){
		
		//document.getElementById('comprobante').style.display = 'block';
		$("#serieComp").val("");
		$("#folioComp").val("");
		$("#fechaCFDI").val("");
		$("#formaPago").val("");
		$("#importeDescuentos").val("");
		$("#moneda").val("");
		$("#tipoCambio").val("");
		$("#importeTotal").val("");
		$("#tipoComprobante").val("");
		$("#exportacion").val("");
		$("#metodoPago").val("");
		$("#importeSubtotal").val("");
		$("#lugarExpedicion").val("");
		$("#observaciones").val("");
		$("#ode").val("");
		$('#estatus').val("")
		$("#tipoDocumento").val("");
		$("#fechaPro").val("");
		$("#horaPro").val("");
		//alert(respuesta[0].listComprobante[0].formaPago);
		rellenaCampo("#serieComp",(respuesta[0].listComprobante[0].serie));
		rellenaCampo("#folioComp",(respuesta[0].listComprobante[0].folio));
		rellenaCampo("#fechaCFDI", (respuesta[0].listComprobante[0].fechaCFDI));
		rellenaCampo("#formaPago", (respuesta[0].listComprobante[0].formaPago));
		rellenaCampo("#importeDescuentos",(respuesta[0].listComprobante[0].importeDescuentos));
		rellenaCampo("#moneda",(respuesta[0].listComprobante[0].moneda));
		rellenaCampo("#tipoCambio",(respuesta[0].listComprobante[0].tipoCambio));
		rellenaCampo("#importeTotal",(respuesta[0].listComprobante[0].importeTotal));
		rellenaCampo("#tipoComprobante",(respuesta[0].listComprobante[0].tipoComprobante));
		rellenaCampo("#exportacion",(respuesta[0].listComprobante[0].exportacion));
		rellenaCampo("#metodoPago",(respuesta[0].listComprobante[0].metodoPago));
		rellenaCampo("#importeSubtotal",(respuesta[0].listComprobante[0].importeSubTotal));
		rellenaCampo("#lugarExpedicion",(respuesta[0].listComprobante[0].lugarExpedicion));
		rellenaCampo("#observaciones",(respuesta[0].listComprobante[0].observaciones));
		rellenaCampo("#ode",(respuesta[0].listComprobante[0].ode));
		rellenaCampo('#estatus',(respuesta[0].listComprobante[0].estatus));
		rellenaCampo("#tipoDocumento",(respuesta[0].listComprobante[0].tipoDocumento));
		rellenaCampo("#fechaPro",( respuesta[0].listComprobante[0].fechaPro));
		rellenaCampo("#horaPro",(respuesta[0].listComprobante[0].horaPro));
	//	rellenaCampo();
		//$("#serieComp").val(respuesta[0].listComprobante[0].serie);
//		$("#folioComp").val(respuesta[0].listComprobante[0].folio);
//		$("#fechaCFDI").val(respuesta[0].listComprobante[0].fechaCFDI);
//		$("#formaPago").val(respuesta[0].listComprobante[0].formaPago);
//		$("#importeDescuentos").val(respuesta[0].listComprobante[0].importeDescuentos);
//		$("#moneda").val(respuesta[0].listComprobante[0].moneda);
//		$("#tipoCambio").val(respuesta[0].listComprobante[0].tipoCambio);
//		$("#importeTotal").val(respuesta[0].listComprobante[0].importeTotal);
//		$("#tipoComprobante").val(respuesta[0].listComprobante[0].tipoComprobante);
//		$("#exportacion").val(respuesta[0].listComprobante[0].exportacion);
//		$("#metodoPago").val(respuesta[0].listComprobante[0].metodoPago);
//		$("#importeSubtotal").val(respuesta[0].listComprobante[0].importeSubTotal);
//		$("#lugarExpedicion").val(respuesta[0].listComprobante[0].lugarExpedicion);
//		$("#observaciones").val(respuesta[0].listComprobante[0].observaciones);
//		$("#ode").val(respuesta[0].listComprobante[0].ode);
//		$('#estatus').val(respuesta[0].listComprobante[0].estatus);
//		$("#tipoDocumento").val(respuesta[0].listComprobante[0].tipoDocumento);
//		$("#fechaPro").val(respuesta[0].listComprobante[0].fechaPro);
//		$("#horaPro").val(respuesta[0].listComprobante[0].horaPro);
		
	}else{
		//document.getElementById('comprobante').style.display = 'none';
		//document.getElementById('comprobanteSD').style.display = 'block';
		$("#serieComp").val("");
		$("#folioComp").val("");
		$("#fechaCFDI").val("");
		$("#formaPago").val("");
		$("#importeDescuentos").val("");
		$("#moneda").val("");
		$("#tipoCambio").val("");
		$("#importeTotal").val("");
		$("#tipoComprobante").val("");
		$("#exportacion").val("");
		$("#metodoPago").val("");
		$("#importeSubtotal").val("");
		$("#lugarExpedicion").val("");
		$("#observaciones").val("");
		$("#ode").val("");
		$('#estatus').val("")
		$("#tipoDocumento").val("");
		$("#fechaPro").val("");
		$("#horaPro").val("");
	}
}
function cargaEmisor(serie, folio){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=CargarEmisor&serie="+serie+"&folio="+folio,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			 //alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//alert(respuesta);
					cargaInformacionEmisor(respuesta,serie,folio);
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar CFDI´S.')
    }
	});
}
function cargaInformacionEmisor(respuesta,serie,folio){
	$("#emisorTITULO").empty();
	$("#emisorTITULO").append("<h5>Emisor: "+serie+"-"+folio+"</h5>")
	if(respuesta[0].listEmisor.length>0){
		//document.getElementById('emisor').style.display = 'block';
		$("#rfc").val(respuesta[0].listEmisor[0].rfc);
		$("#nombreEmisor").val(respuesta[0].listEmisor[0].rfc);
		$("#regimenFiscal").val(respuesta[0].listEmisor[0].regimenFiscal);
	}else{
		$("#rfc").val("");
		$("#nombreEmisor").val("");
		$("#regimenFiscal").val("");
	}
}
function cargaLog(serie,folio){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=CargaLog&serie="+serie+"&folio="+folio,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			 

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//alert(respuesta);
					cargaInformacionLog(respuesta);
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar CFDI´S.')
    }
	});
}
function cargaInformacionLog(respuesta){
	window.location='#cabecera';
	$("#logTitulo").empty();
	if(respuesta[0].listLOG.length>0){
	$("#logTitulo").append("LOG DEL DOCUMENTO: "+respuesta[0].listLOG[0].ode+"-"+respuesta[0].listLOG[0].serie+"-"+respuesta[0].listLOG[0].folio+"-"+respuesta[0].listLOG[0].documento);

		$("#modalLog").modal("show");
	}else{
		alert("Sin log");
		$("#modalLog").modal("hide");
	}
	//alert("HOla: " + JSON.stringify(respuesta) );
	$("#log").empty();
//	var contenido="<table class='table'><tr><th>CDO</th><th>SERIE</th><th>FOLIO</th><th>DESCRIPCION</th><th>DOCUMENTO</th><th>DOCUMENTO CFDI</th><th>ODE</th><th>FECHA PRO</th><th>HORA PRO</th></tr>";
//	for(var i=0;i<respuesta[0].listLOG.length;i++){
//		contenido+="<tr><td>"+respuesta[0].listLOG[i].uname+"</td><td>"+respuesta[0].listLOG[i].serie+"</td><td>"+respuesta[0].listLOG[i].folio+"</td><td>"+respuesta[0].listLOG[i].descripcion
//		+"</td><td>"+respuesta[0].listLOG[i].documento+"</td><td>"+respuesta[0].listLOG[i].documentoCFDI+"</td><td>"+respuesta[0].listLOG[i].ode+"</td><td>"+respuesta[0].listLOG[i].fechaPro+"</td><td>"+
//		respuesta[0].listLOG[i].horaPro+"</td></tr>";
//	}
//	contenido+="</table>"
	var contenido="<table class='table'><tr><th style='width:85%;'>DESCRIPCION</th><th>FECHA</th><th>HORA</th></tr>";
	for(var i=0;i<respuesta[0].listLOG.length;i++){
		contenido+="<tr><td style='width:85%;'>"+respuesta[0].listLOG[i].descripcion+"</td><td style='padding: 5% 0;'>"+respuesta[0].listLOG[i].fechaPro+"</td><td style='padding: 5% 0;'>"+
		respuesta[0].listLOG[i].horaPro+"</td></tr>";
	}
	contenido+="</table>"
		$("#log").append(contenido);
}
function cargaReceptor(serie, folio){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=CargaReceptor&serie="+serie+"&folio="+folio,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
		//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//alert(respuesta);
					cargaInformacionReceptor(respuesta,serie,folio);
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar CFDI´S.')
    }
	});
}
function cargaInformacionReceptor(respuesta,serie,folio){
	$("#receptorTITULO").empty();
	$("#receptorTITULO").append("<h5>Receptor: "+serie+"-"+folio+"</h5>");
	if(respuesta[0].listReceptor.length>0){
		//document.getElementById('receptor').style.display = 'block';
		$("#rfcReceptor").val("");
		$("#nombreReceptor").val("");
		$("#domicilioFiscalReceptor").val("");
		$("#regimenFiscalReceptor").val("");
		$("#usoCFDIReceptor").val("");
		$("#etiquetaTransporte").val("");
		$("#etiquetaRuta").val("");
		$("#etiquetaCalle").val("");
		$("#etiquetaNumExt").val("");
		$("#etiquetaNumInt").val("");
		$("#etiquetaColonia").val("");
		$("#etiquetaCodigoPostal").val("");
		$("#etiquetaMunicipio").val("");
		$("#etiquetaPais").val("");
		$("#etiquetaEstado").val("");
		$("#etiquetaPedido").val("");
		$("#etiquetaNumCli").val("");
		$("#etiquetaAgente").val("");
		$("#etiquetaCondCred").val("");
		$("#etiquetaTipoFact").val("");
		$("#etiquetaTipoCliente").val("");
		$("#etiquetaTipoDocto").val("");
		$("#etiquetaMail").val("");
		rellenaCampo("#rfcReceptor",(respuesta[0].listReceptor[0].rfcReceptor));
		rellenaCampo("#nombreReceptor",(respuesta[0].listReceptor[0].nombreReceptor));
		rellenaCampo("#domicilioFiscalReceptor",(respuesta[0].listReceptor[0].domicilioFiscalReceptor));
		rellenaCampo("#regimenFiscalReceptor",(respuesta[0].listReceptor[0].regimenFiscalReceptor));
		rellenaCampo("#usoCFDIReceptor",(respuesta[0].listReceptor[0].usoCFDIReceptor));
		rellenaCampo("#etiquetaRuta",(respuesta[0].listReceptor[0].etiquetaRuta));
		rellenaCampo("#etiquetaTransporte",(respuesta[0].listReceptor[0].etiquetaTransporte));
		rellenaCampo("#etiquetaCalle",(respuesta[0].listReceptor[0].etiquetaCalle));
		rellenaCampo("#etiquetaNumExt",(respuesta[0].listReceptor[0].etiquetaNumExt));
		rellenaCampo("#etiquetaNumInt",(respuesta[0].listReceptor[0].etiquetaNumInt));
		rellenaCampo("#etiquetaColonia",(respuesta[0].listReceptor[0].etiquetaColonia));
		rellenaCampo("#etiquetaCodigoPostal",(respuesta[0].listReceptor[0].etiquetaCodigoPostal));
		rellenaCampo("#etiquetaMunicipio",(respuesta[0].listReceptor[0].etiquetaMunicipio));
		rellenaCampo("#etiquetaPais",(respuesta[0].listReceptor[0].etiquetaPais));
		rellenaCampo("#etiquetaEstado",(respuesta[0].listReceptor[0].etiquetaEstado));
		rellenaCampo("#etiquetaPedido",(respuesta[0].listReceptor[0].etiquetaPedido));
		rellenaCampo("#etiquetaNumCli",(respuesta[0].listReceptor[0].etiquetaNumCli));
		rellenaCampo("#etiquetaAgente",(respuesta[0].listReceptor[0].etiquetaAgente));
		rellenaCampo("#etiquetaCondCred",(respuesta[0].listReceptor[0].etiquetaCondCred));
		rellenaCampo("#etiquetaTipoFact",(respuesta[0].listReceptor[0].etiquetaTipoFact));
		rellenaCampo("#etiquetaTipoCliente",(respuesta[0].listReceptor[0].etiquetaTipoCliente));
		rellenaCampo("#etiquetaTipoDocto",(respuesta[0].listReceptor[0].etiquetaTipoDocto));
		rellenaCampo("#etiquetaMail",(respuesta[0].listReceptor[0].etiquetaMail));
		//rellenaCampo("#etiquetaAgente",(respuesta[0].listReceptor[0].etiquetaAgente));
//		$("#rfcReceptor").val(respuesta[0].listReceptor[0].rfcReceptor);
//		$("#nombreReceptor").val(respuesta[0].listReceptor[0].nombreReceptor);
//		$("#domicilioFiscalReceptor").val(respuesta[0].listReceptor[0].domicilioFiscalReceptor);
//		$("#regimenFiscalReceptor").val(respuesta[0].listReceptor[0].regimenFiscalReceptor);
//		$("#usoCFDIReceptor").val(respuesta[0].listReceptor[0].usoCFDIReceptor);
//		$("#etiquetaTransporte").val(respuesta[0].listReceptor[0].etiquetaTransporte);
//		$("#etiquetaRuta").val(respuesta[0].listReceptor[0].etiquetaRuta);
//		$("#etiquetaCalle").val(respuesta[0].listReceptor[0].etiquetaCalle);
//		$("#etiquetaNumExt").val(respuesta[0].listReceptor[0].etiquetaNumExt);
//		$("#etiquetaNumInt").val(respuesta[0].listReceptor[0].etiquetaNumInt);
//		$("#etiquetaColonia").val(respuesta[0].listReceptor[0].etiquetaColonia);
//		$("#etiquetaCodigoPostal").val(respuesta[0].listReceptor[0].etiquetaCodigoPostal);
//		$("#etiquetaMunicipio").val(respuesta[0].listReceptor[0].etiquetaMunicipio);
//		$("#etiquetaPais").val(respuesta[0].listReceptor[0].etiquetaPais);
//		$("#etiquetaEstado").val(respuesta[0].listReceptor[0].etiquetaEstado);
//		$("#etiquetaPedido").val(respuesta[0].listReceptor[0].etiquetaPedido);
//		$("#etiquetaNumCli").val(respuesta[0].listReceptor[0].etiquetaNumCli);
//		$("#etiquetaAgente").val(respuesta[0].listReceptor[0].etiquetaAgente);
//		$("#etiquetaCondCred").val(respuesta[0].listReceptor[0].etiquetaCondCred);
//		$("#etiquetaTipoFact").val(respuesta[0].listReceptor[0].etiquetaTipoFact);
//		$("#etiquetaTipoCliente").val(respuesta[0].listReceptor[0].etiquetaTipoCliente);
//		$("#etiquetaTipoDocto").val(respuesta[0].listReceptor[0].etiquetaTipoDocto);
//		$("#etiquetaMail").val(respuesta[0].listReceptor[0].etiquetaMail);
	}else{
		$("#rfcReceptor").val("");
		$("#nombreReceptor").val("");
		$("#domicilioFiscalReceptor").val("");
		$("#regimenFiscalReceptor").val("");
		$("#usoCFDIReceptor").val("");
		$("#etiquetaTransporte").val("");
		$("#etiquetaRuta").val("");
		$("#etiquetaCalle").val("");
		$("#etiquetaNumExt").val("");
		$("#etiquetaNumInt").val("");
		$("#etiquetaColonia").val("");
		$("#etiquetaCodigoPostal").val("");
		$("#etiquetaMunicipio").val("");
		$("#etiquetaPais").val("");
		$("#etiquetaEstado").val("");
		$("#etiquetaPedido").val("");
		$("#etiquetaNumCli").val("");
		$("#etiquetaAgente").val("");
		$("#etiquetaCondCred").val("");
		$("#etiquetaTipoFact").val("");
		$("#etiquetaTipoCliente").val("");
		$("#etiquetaTipoDocto").val("");
		$("#etiquetaMail").val("");
		
	}
}
function cargaConceptos(serie, folio){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=CargaConceptos&serie="+serie+"&folio="+folio,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
		//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//alert(respuesta);
					cargaInformacionConceptos(respuesta,serie,folio);
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar CFDI´S.')
    }
	});
}
function cargaInformacionConceptos(respuesta,serie,folio){
	$("#conceptosTITULO").empty();
	$("#conceptosTITULO").append("<h5>Conceptos: "+serie+"-"+folio+"</h5>")
	var res = respuesta[0];
	var conceptos = res.listConceptos;
	//alert(JSON.stringify(res));
	var db = {

			 loadData : function(filter) {
					return $.grep(conceptos, function(client) {
						return (!filter.descripcionConceptos.toUpperCase()|| client.descripcionConceptos.toUpperCase() === filter.descripcionConceptos.toUpperCase() || client.descripcionConceptos.toUpperCase() == filter.descripcionConceptos.toUpperCase() || client.descripcionConceptos.toUpperCase().includes(filter.descripcionConceptos.toUpperCase()))
						&&(!filter.unidad.toUpperCase()|| client.unidad.toUpperCase() === filter.unidad.toUpperCase() || client.unidad.toUpperCase() == filter.unidad.toUpperCase() || client.unidad.toUpperCase().includes(filter.unidad.toUpperCase()))
						&&(!filter.cantidad.toUpperCase()|| client.cantidad.toUpperCase() === filter.cantidad.toUpperCase() || client.cantidad.toUpperCase() == filter.cantidad.toUpperCase() || client.cantidad.toUpperCase().includes(filter.cantidad.toUpperCase()))
						&&(!filter.noIdentificacion.toUpperCase()|| client.noIdentificacion.toUpperCase() === filter.noIdentificacion.toUpperCase() || client.noIdentificacion.toUpperCase() == filter.noIdentificacion.toUpperCase() || client.noIdentificacion.toUpperCase().includes(filter.noIdentificacion.toUpperCase()))
						});
				}
	 };
		    window.db = db;
		    db.res;
		    $("#tablaConceptos").jsGrid({
		    	height : "500px",
		        width: "80%",
		        filtering: true,
		        sorting:true,
		        css: "",
		        headercss: "",
		        filtercss: "",
		        insertcss: "",
		        editcss: "",
		        rowClass : function(item, itemIndex) // item is
				// the data
				// in a row,
				// index is
				// the row
		        // number.
		        {
					if (((item.noIdentificacion).trim() == "")) {
						return "bg-rechazado";
					}
					if((item.cantidad==0)||(item.cantidad).trim()==""){
						return "bg-rechazado";
					}
					if((item.unidad==0)||(item.unidad).trim()==""){
						return "bg-rechazado";
					}
					if((item.claveProdServ==0)||(item.claveProdServ).trim()==""){
						return "bg-rechazado";
					}
					if((item.valorUnitario==0)||(item.valorUnitario).trim()==""){
						return "bg-rechazado";
					}
					if((item.importe==0)||(item.importe).trim()==""){
						return "bg-rechazado";
					}
				},
				autoload : true,
				controller : db,
		        fields: [
		        	{ title:"NO. IDENTIFICACION",name: "noIdentificacion", type: "text", width: 7,align : 'center',css : "labelfor"},
		        	{ title:"CANTIDAD",name: "cantidad", type: "text", width: 7,align : 'center',css : "labelfor"},
		            { title:"DESCRIPCION",name: "descripcionConceptos", type: "text", width: 7,align : 'center',css : "labelfor"},
		            { title:"CLAVE PROD SERV",name: "claveProdServ", type: "text", width: 7,align : 'center',css : "labelfor"},
		            { title:"UNIDAD", name: "unidad", align:'center', type: "text", width: 7 ,css : "labelfor"},
		            { title:"VALOR UNITARIO", name: "valorUnitario", align:'center', type: "text", width: 7,css : "labelfor"},
		            { title:"IMPORTE", name: "importe", align:'center', type: "text", width: 7 ,css : "labelfor"},
		            
             ],		       
		        rowClick: function (args) {
		        	cargaConcepto(args.item,serie,folio);
	            }
		    });
}

function cargaConcepto(concepto,serie,folio){
	//console.log(concepto);
	$("#tituloModalConceptos").empty();
	$("#tituloModalConceptos").append(serie+"-"+folio);
	
	$("#numRenglon").val("");
	$("#claveProdServ").val("");
	$("#noIdentificacion").val("");
	$("#cantidad").val("");
	$("#claveUnidad").val("");
	$("#unidad").val("");
	$("#descripcionConceptos").val("");
	$("#valorUnitario").val("");
	$("#importe").val("");
	$("#descuento").val("");
	$("#objetoImp").val("");
	$("#baseTraslado").val("");
	$("#importeTraslado").val("");
	$("#impuestoTraslado").val("");
	$("#tasaCuota").val("");
	$("#tipoFactorTranslado").val("");
	$("#baseRetencion").val("");
	$("#importeRetencion").val("");
	$("#impuestoRetencion").val("");
	$("#tasaCuotaRetencion").val("");
	$("#tipoFactorRetencion").val("");

	rellenaCampo("#claveProdServ",(concepto.claveProdServ));
	rellenaCampo("#numRenglon",(concepto.numRenglon));
	rellenaCampo("#cantidad",(concepto.cantidad));
	rellenaCampo("#claveUnidad",(concepto.claveUnidad));
	rellenaCampo("#unidad",(concepto.unidad));
	rellenaCampo("#valorUnitario",(concepto.valorUnitario));
	rellenaCampo("#importe",(concepto.importe));
	rellenaCampo("#descuento",(concepto.descuento));
	rellenaCampo("#objetoImp",(concepto.objetoImp));
	rellenaCampo("#baseTraslado",(concepto.baseTraslado));
	rellenaCampo("#importeTraslado",(concepto.importeTraslado));
	rellenaCampo("#impuestoTraslado",(concepto.impuestoTraslado));
	rellenaCampo("#tasaCuota",(concepto.tasaCuota));
	rellenaCampo("#tipoFactorTranslado",(concepto.tipoFactorTranslado));
	rellenaCampo("#baseRetencion",(concepto.baseRetencion));
	rellenaCampo("#importeRetencion",(concepto.importeRetencion));
	rellenaCampo("#impuestoRetencion",(concepto.impuestoRetencion));
	rellenaCampo("#tasaCuotaRetencion",(concepto.tasaCuotaRetencion));
	rellenaCampo("#tipoFactorRetencion",(concepto.tipoFactorRetencion));
	rellenaCampo("#noIdentificacion",(concepto.noIdentificacion));
	rellenaCampo("#descripcionConceptos",(concepto.descripcionConceptos));
	
//	$("#numRenglon").val(concepto.numRenglon);
//	$("#claveProdServ").val(concepto.claveProdServ);
//	$("#noIdentificacion").val(concepto.noIdentificacion);
//	$("#cantidad").val(concepto.cantidad);
//	$("#claveUnidad").val(concepto.claveUnidad);
//	$("#unidad").val(concepto.unidad);
//	$("#descripcionConceptos").val(concepto.descripcionConceptos);
//	$("#valorUnitario").val(concepto.valorUnitario);
//	$("#importe").val(concepto.importe);
//	$("#descuento").val(concepto.descuento);
//	$("#objetoImp").val(concepto.objetoImp);
//	$("#baseTraslado").val(concepto.baseTraslado);
//	$("#importeTraslado").val(concepto.importeTraslado);
//	$("#impuestoTraslado").val(concepto.impuestoTraslado);
//	$("#tasaCuota").val(concepto.tasaCuota);
//	$("#tipoFactorTranslado").val(concepto.tipoFactorTranslado);
//	$("#baseRetencion").val(concepto.baseRetencion);
//	$("#importeRetencion").val(concepto.importeRetencion);
//	$("#impuestoRetencion").val(concepto.impuestoRetencion);
//	$("#tasaCuotaRetencion").val(concepto.tasaCuotaRetencion);
//	$("#tipoFactorRetencion").val(concepto.tipoFactorRetencion);
	$("#modalConceptos").modal("show");
}
function cargaDocumentos(serie, folio){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=CargaDocumentos&serie="+serie+"&folio="+folio,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
		//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//alert(respuesta);
					cargaInformacionDocumentos(respuesta,serie,folio);
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar CFDI´S.')
    }
	});
}
function cargaInformacionDocumentos(respuesta,serie,folio){
	//alert(JSON.stringify(respuesta));
	$("#documentosTITULO").empty();
	$("#documentosTITULO").append("<h5>Documentos: "+serie+"-"+folio+"</h5>")
	if(respuesta[0].listDocumentos.length>0){
		//document.getElementById('documentos').style.display = 'block';
		$("#documentosTITULO").empty();
		$("#documentosTITULO").append("<h5>Documentos: "+serie+"-"+folio+"</h5>")
		$("#tipoRelacion").val(respuesta[0].listDocumentos[0].tipoRelacion);
		$("#documentoRelacionado").val(respuesta[0].listDocumentos[0].documentoRelacionado);
		$("#folioFiscal").val(respuesta[0].listDocumentos[0].folioFiscal);
	}else{
		//document.getElementById('documentos').style.display = 'none';
	}
}
function actualizaRegimenReceptor(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=ActualizaRegimenReceptor&numeroCliente="+$("#numeroCliente").val()+"&serie="+$("#serie").val()+"&folio="+$("#folio").val(),
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			$("#regimenFiscalReceptor").val("");
			rellenaCampo("#regimenFiscalReceptor", respuesta[0].actualizar);
			//$("#regimenFiscalReceptor").val(respuesta[0].actualizar);
			//alert("Se actualizo regimen del receptor");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}
function actualizaUsoCFDI(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=ActualizaUsoCFDI&numeroCliente="+$("#numeroCliente").val()+"&serie="+$("#serie").val()+"&folio="+$("#folio").val(),
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			$("#usoCFDIReceptor").val("");
			rellenaCampo("#usoCFDIReceptor", respuesta[0].actualizar);
			//alert("Se actualizo regimen del receptor");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}
function actualizaFormaPago(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=ActualizaFormaPago&numeroCliente="+$("#numeroCliente").val()+"&serie="+$("#serie").val()+"&folio="+$("#folio").val(),
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			$("#formaPago").val("");
			rellenaCampo("#formaPago", respuesta[0].actualizar);
			
			//alert("Se actualizo regimen del receptor");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}
function actualizaMetodoPago(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=ActualizaMetodoPago&numeroCliente="+$("#numeroCliente").val()+"&serie="+$("#serie").val()+"&folio="+$("#folio").val(),
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			$("#metodoPago").val("");
			rellenaCampo("#metodoPago", respuesta[0].actualizar);
			//$("#metodoPago").val(respuesta[0].actualizar);
			//alert("Se actualizo regimen del receptor");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}
function guardaConcepto(){
	//alert(ponerTilde($("#descripcionConceptos").val()))
	var data="accion=GuardaConcepto&serie="+$("#serie").val()+"&folio="+$("#folio").val()+"&numRenglon="+$("#numRenglon").val()+"&cantidad="+$("#cantidad").val()+"&descripcionConceptos="+
	ponerTilde($("#descripcionConceptos").val())+"&valorUnitario="+$("#valorUnitario").val()+"&importe="+$("#importe").val()+"&descuento="+$("#descuento").val()+"&noIdentificacion="+$("#noIdentificacion").val()
	+"&tasaCuotaRetencion="+$("#tasaCuotaRetencion").val()+"&objetoImp="+$("#objetoImp").val()+"&baseTraslado="+$("#baseTraslado").val()+"&importeTraslado="+$("#importeTraslado").val()
	+"&tipoFactorTranslado="+$("#tipoFactorTranslado").val()+"&tasaCuota="+$("#tasaCuota").val()+"&impuestoTraslado="+$("#impuestoTraslado").val()
	+"&baseRetencion="+$("#baseRetencion").val()+"&importeRetencion="+$("#importeRetencion").val()+"&impuestoRetencion="+$("#impuestoRetencion").val()
	+"&tipoFactorRetencion="+$("#tipoFactorRetencion").val()+"&unidad="+$("#unidad").val();
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : data,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			alert("Concepto actualizado");
			//alert(JSON.stringify(respuesta));
			cargaConceptos($("#serie").val(), $("#folio").val())
			//alert("Se actualizo regimen del receptor");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}
function guardarCampos(){
	var data="accion=GuardaCFDI&serie="+$("#serieComp").val().trim()+"&folio="+$("#folioComp").val().trim()+"&moneda="+$("#moneda").val().trim()+"&tipoCambio="+$("#tipoCambio").val().trim()+"&exportacion="+
	$("#exportacion").val().trim()+"&observaciones="+$("#observaciones").val().trim()+"&ode="+$("#ode").val().trim()+"&serie2="+$("#serie").val().trim()+"&folio2="+$("#folio").val().trim();
	document.getElementById('cargando').style.display = 'block';
	//alert(data);
	$.ajax({
		url : 'AdministradorCFDI',
		data : data,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert(JSON.stringify(respuesta));
			actualizaReceptor();
			alert("Datos actualizados");
			//alert(JSON.stringify(respuesta));
			consultaCFDI(1);
//			cargaComprobante($("#serieComp").val(), $("#folioComp").val()); 
//        	cargaEmisor($("#serieComp").val(), $("#folioComp").val());
//        	cargaReceptor($("#serieComp").val(), $("#folioComp").val());
//        	cargaConceptos($("#serieComp").val(), $("#folioComp").val());
//        	cargaDocumentos($("#serieComp").val(), $("#folioComp").val());
			limpiar();
        	sellarCFDI();
			//alert("Se actualizo regimen del receptor");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}
function actualizaRfcReceptor(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=RfcReceptor&numeroCliente="+$("#numeroCliente").val()+"&serie="+$("#serie").val()+"&folio="+$("#folio").val(),
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			$("#rfcReceptor").val("");
			rellenaCampo("#rfcReceptor", respuesta[0].actualizar);
			//checaRfc(respuesta[0].actualizar)
			//alert("Se actualizo regimen del receptor");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}
function consultaRfc(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=ConsultaRfc&numeroCliente="+$("#numeroCliente").val()+"&serie="+$("#serie").val()+"&folio="+$("#folio").val,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			$("#rfcReceptor").val("");
			checaRfc(respuesta[0].actualizar);
			//checaRfc(respuesta[0].actualizar)
			//alert("Se actualizo regimen del receptor");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}

function checaRfc(rfc){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=validaRfc&rfc="+rfc,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			var valida=JSON.stringify(respuesta[0].respuesta).replace('"','').replace('"','');
			if(valida==="true"){
				   actualizaRfcReceptor();
			   }else{
				   
				   rellenaCampo("#rfcReceptor", "");
			   }
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}
function checaRf2c(rfc){
	document.getElementById('cargando').style.display = 'none';
	//var rfc = rfc;
	var xhr = new XMLHttpRequest();
	var url = "http://deswebcdo18.corprama.com.mx:8080/wsSelladoCFDIv4Prod/comprobante/validadorRFC?usuario=FYUFVHOH-CDSA&passwrod=9HKX3GU82&rfc="+rfc;// SARO9602134G8;
	xhr.open("GET", url, true);
	xhr.setRequestHeader("Content-Type", "text/plain");
	xhr.onload = function() {
		  if (xhr.status != 200) { // analiza el estado HTTP de la respuesta
		    alert(`Error ${xhr.status}: ${xhr.statusText}`); // ej. 404: No encontrado
		  } else { // muestra el resultado
			 // alert(xhr.response);
		   if(xhr.response==="true"){
			   actualizaRfcReceptor();
		   }else{
			   
			   rellenaCampo("#rfcReceptor", "");
		   }// Respuesta del servidor
		  }
		};
		 xhr.send();
}

function actualizaReceptor(){
	//alert("entro aqui2");
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=ActualizaReceptor&numeroCliente="+$("#numeroCliente").val()+"&serie="+$("#serie").val()+"&folio="+$("#folio").val()+"&domicilioFiscal="+$("#domicilioFiscalReceptor").val()+"&etiquetaTransporte="+$("#etiquetaTransporte").val()
		+"&etiquetaRuta="+$("#etiquetaRuta").val()+"&etiquetaCalle="+$("#etiquetaCalle").val()+"&etiquetaNumExt="+$("#etiquetaNumExt").val()+"&etiquetaNumInt="+$("#etiquetaNumInt").val()
		+"&etiquetaColonia="+$("#etiquetaColonia").val()+"&etiquetaCodigoPostal="+$("#etiquetaCodigoPostal").val()+"&etiquetaMunicipio="+$("#etiquetaMunicipio").val()+"&etiquetaEstado="+$("#etiquetaEstado").val()
		+"&etiquetaPais="+$("#etiquetaPais").val()+"&etiquetaPedido="+$("#etiquetaPedido").val()+"&etiquetaNumCli="+$("#etiquetaNumCli").val()
		+"&etiquetaTipoFact="+$("#etiquetaTipoFact").val()+"&etiquetaCondCred="+$("#etiquetaCondCred").val()+"&etiquetaAgente="+$("#etiquetaAgente").val()
		+"&etiquetaTipoCliente="+$("#etiquetaTipoCliente").val()+"&etiquetaTipoDocto="+$("#etiquetaTipoDocto").val()+"&etiquetaMail="+$("#etiquetaMail").val(),
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("Se actualizo regimen del receptor");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}
function verificaClaveProdutoServ(clave){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=verificaClaveProdServ&claveProdServ="+clave+"&serie="+$("#serie").val()+"&folio="+$("#folio").val()+"&noIdentificacion="+$("#noIdentificacion").val(),
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			if(!respuesta[0].verifica){
				$("#claveProdServ").val("");
				rellenaCampo("#claveProdServ", "");
				//alert("El valor ingresado no corresponde a una clave producto servicio");
			}else{
				$("#claveProdServ").val("");
				rellenaCampo("#claveProdServ", clave);
			}
			//alert("Se actualizo regimen del receptor");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}
function ponerTilde(palabra){
	var letras=["a","A","e","E","i","I","o","O","u","U","ñ","Ñ"];
	var codigo=["\u00e1","\u00c1","\u00e9","\u00c9","\u00ed","\u00cd","\u00f3","\u00d3","\u00fa","\u00da","\u00f1","\u00d1"];
	for (var i = 0; i <= codigo.length; i++) {
		   palabra=palabra.replaceAll(codigo[i],letras[i]);
		}
	return palabra;
}
//function sellarCFDI(){
//	document.getElementById('cargando').style.display = 'none';
//	var xhr = new XMLHttpRequest();
//	var url = "http://deswebcdo18.corprama.com.mx:8080/wsSelladoCFDIv4Prod/comprobante/validador?rfc="+rfc;
//	xhr.open("GET", url, true);
//	xhr.setRequestHeader("Content-Type", "text/plain");
//	xhr.onload = function() {
//	  if (xhr.status != 200) { // analiza el estado HTTP de la respuesta
//	    alert(`Error ${xhr.status}: ${xhr.statusText}`); // ej. 404: No encontrado
//	   } else { // muestra el resultado
//			 // alert(xhr.response);
//	   if(xhr.response.length>0){
//		   alert("CFDI sellado");
//	   }else{
//		   alert("No se pudo sellar el CFDI");
//	   }// Respuesta del servidor
//	  }
//	};
// xhr.send();	 
//}
function validar(campo){
	//alert(campo);
	if($(campo).val().length<=0||$(campo).val().trim()=="0.00"||$(campo).val().trim()=="0"){
		$(campo).removeClass("is-valid");
		$(campo).addClass("is-invalid");
		$(campo).val("");
	}else{
		$(campo).removeClass("is-invalid");
	//	$(campo).addClass("is-valid");
	}
}
function validar2(campo){
	//alert(campo);
	if($(campo).val().length<=0){
		$(campo).removeClass("is-valid");
		$(campo).addClass("is-invalid");
		$(campo).val("");
	}else{
		$(campo).removeClass("is-invalid");
	//	$(campo).addClass("is-valid");
	}
}
function validarCliente(campo, value){
	//alert(campo);
	if($(campo).val().length<=0||$(campo).val().trim()=="0.00"||$(campo).val().trim()=="0"){
		$(campo).removeClass("is-valid");
		$(campo).addClass("is-invalid");
		$(campo).val("");
		
	}else{
		$("#nc").val(value);
		$(campo).removeClass("is-invalid");
		$("#tipoDoc").val($('input[name="inlineRadioOptions"]:checked').val())
	//	$(campo).addClass("is-valid");
	}
}
function validarDescuento(campo){
	//alert(campo);
	if($(campo).val().length<=0){
		$(campo).removeClass("is-valid");
		$(campo).addClass("is-invalid");
		$(campo).val("");
	}else{
		$(campo).removeClass("is-invalid");
	//	$(campo).addClass("is-valid");
	}
}
function rellenaCampo(campo, valor){
	//alert(campo);
	if(valor==undefined){
		valor=" ";
	}
	valor+=" ";
	if((valor.trim()).length<=0||valor.length<=0){
		$(campo).removeClass("is-valid");
		$(campo).addClass("is-invalid");
		$(campo).val("");
	}else{
		$(campo).removeClass("is-invalid");
		$(campo).val(valor);
	}
}

function validarObjetoImp(valor){
	if(valor=="01"||valor=="02"){
		$("#objetoImp").removeClass("is-invalid");
		$("#objetoImp").val(valor);
		
	}else{
		$("#objetoImp").removeClass("is-valid");
		$("#objetoImp").addClass("is-invalid");
		$("#objetoImp").val("");
	}
}
function verificaConcepto(){
	if($("#numRenglon").val()==""||$("#cantidad").val()==""||$("#descripcionConceptos").val()==""||$("#valorUnitario").val()==""||$("#importe").val()==""||$("#descuento").val()==""||
	$("#tasaCuotaRetencion").val()==""||$("#objetoImp").val()==""||$("#baseTraslado").val()==""||$("#importeTraslado").val()==""||$("#tipoFactorTranslado").val()==""||
	$("#tasaCuota").val()==""||$("#impuestoTraslado").val()==""||$("#baseRetencion").val()==""||$("#importeRetencion").val()==""||$("#impuestoRetencion").val()==""||
	$("#tipoFactorRetencion").val()==""||$("#unidad").val()==""){
		alert("Campos vacios");
	}else{
		guardaConcepto();
	}
}
function verificaCampos(){
	if($("#serieComp").val()==""||$("#folioComp").val()==""||$("#moneda").val()==""||$("#tipoCambio").val()==""||$("#exportacion").val()==""||
	$("#observaciones").val()==""||$("#ode").val()==""||$("#serie").val()==""||$("#folio").val()==""||$("#regimenFiscalReceptor").val()==""||
	$("#rfcReceptor").val()==""||$("#usoCFDIReceptor").val()==""||$("#formaPago").val()==""||$("#metodoPago").val()==""){
		alert("Campos vacios");
	}else{
		guardarCampos();
	}
}
function consultaImpresora(serie,folio){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : "accion=ConsultaImpresora&serie="+serie+"&folio="+folio,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert(respuesta[0].actualizar);
				$("#impresora").val(respuesta[0].actualizar);
			//alert("Se actualizo regimen del receptor");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}
function sellarCFDI(){
	var serie=$("#serie").val();
	var folio=$("#folio").val();
	var impresora=$("#impresora").val();
	var numCliente=$("#nc").val();
	var tipoDoc=$("#tipoDoc").val();
	var accion = accion="accion=SellaNota&serie="+serie+"&folio="+folio+"&impresora="+impresora+"&tipoDoc="+tipoDoc+"&ode="+ode+"&numCliente="+numCliente;
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI',
		data : accion,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("");
				//$("#impresora").val(respuesta[0].actualizar);
			$("#serie").val("");
			$("#folio").val("");
			$("#impresora").val("");
			$("#nc").val("");
			$("#tipoDoc").val("");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al actualizar Datos.')
    }
	});
}
function buscarFolio(){
	if($("#buscarFolio").val().length<=0){
		validarDescuento("#buscarFolio");
	}else{
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI ',
		data : "accion=CargarFolio&folio="+$("#buscarFolio").val(),
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			// alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//alert(respuesta);
					cargaInformacionCFDI(respuesta);
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar CFDI´S.')
    }
	});
	}
}
function checaCliente(){
	var campo="#numeroCliente2";
	if($(campo).val().length<=0){
		$(campo).removeClass("is-valid");
		$(campo).addClass("is-invalid");
		$(campo).val("");
	}else{
		$(campo).removeClass("is-invalid");
		sellarCFDI();
	//	$(campo).addClass("is-valid");
	}
}
function buscarNumeroCliente(opcion){
	if($("#numeroCliente2").val().length<=0){
		validarDescuento("#numeroCliente2");
	}else{
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorCFDI ',
		data : "accion=CargarNumeroCliente&numCliente="+$("#numeroCliente2").val()+"&opcion="+opcion,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			// alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//alert(respuesta);
					cargaInformacionNotas(respuesta);
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar CFDI´S.')
    }
	});
	}
}
function limpiar(){
	var array=["#numRenglon","#claveProdServ","#noIdentificacion","#cantidad","#claveUnidad","#unidad","#descripcionConceptos",
		"#valorUnitario","#importe","#descuento","#objetoImp","#baseTraslado","#importeTraslado","#impuestoTraslado",
		"#tasaCuota","#tipoFactorTranslado","#baseRetencion","#importeRetencion","#impuestoRetencion","#tasaCuotaRetencion"
		,"#tipoFactorRetencion","#rfcReceptor","#nombreReceptor","#domicilioFiscalReceptor","#regimenFiscalReceptor",
		"#usoCFDIReceptor","#etiquetaTransporte","#etiquetaRuta","#etiquetaCalle","#etiquetaNumExt","#etiquetaNumInt",
		"#etiquetaColonia","#etiquetaColonia","#etiquetaCodigoPostal","#etiquetaMunicipio","#etiquetaPais","#etiquetaEstado",
		"#etiquetaPedido","#etiquetaNumCli","#etiquetaAgente","#etiquetaCondCred","#etiquetaTipoFact","#etiquetaTipoCliente",
		"#etiquetaTipoDocto","#etiquetaMail","#serieComp","#folioComp","#fechaCFDI","#formaPago","#importeDescuentos","#moneda","#tipoCambio","#importeTotal",
		"#tipoComprobante","#exportacion","#metodoPago","#importeSubtotal","#lugarExpedicion","#observaciones","#ode",'#estatus',
		"#tipoDocumento","#fechaPro","#horaPro","#buscarFolio"]
	for(var i=0;i<array.length;i++){
		$(array[i]).val("");
		$(array[i]).removeClass("is-invalid");
		$(array[i]).removeClass("is-valid");
	}
	$("#tablaConceptos").empty();
	//$("#inlineRadio1").prop("checked", true);
	//$('#inlineRadio0').is(":checked");
	window.location='#cabecera';
	//rutinaInicioCFDI();
	
	//$( "#options" ).load(window.location.href + " #options" );
	//$('#radios').load('AdministradorCFDI.jsp');
	//location.reload();
}

function sellarNotas(){
	if($("#numeroCliente").val().length>0){
		document.getElementById('cargando').style.display = 'block';
		$.ajax({
			url : 'AdministradorCFDI ',
			data : "accion=sellaCliente&numCliente="+$("#numeroCliente").val(),
			type : 'POST',
			dataType : 'Json',
			success : function(respuesta) {
				// alert("HOla: " + JSON.stringify(respuesta) );
	
				if (respuesta) {
	
					var data = respuesta;
	
					if (data.length > 0) {
						//alert(respuesta);
						alert("Notas selladas")
						document.getElementById('cargando').style.display = 'none';
					}
				} else
					{
					document.getElementById('cargando').style.display = 'none';
					}
				document.getElementById('cargando').style.display = 'none';
			},
			error : function(xhr, status, error)
	        {document.getElementById('cargando').style.display = 'none';
	        if (xhr.status === 200)
	        {
	            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
	            window.location.href='/MantenimientoCFDI/';
	        }
	        else
	            alert('Error al consultar CFDI´S.')
	    }
		});
	}else{
		alert("No hay un cliente especificado");
	}
}
