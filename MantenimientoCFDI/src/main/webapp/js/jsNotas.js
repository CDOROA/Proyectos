var datos;
function rutinaInicioNotas() {
	$("#menu-cfdi").removeClass("Opc-Menu-Activo");
	$("#menu-notas").addClass("Opc-Menu-Activo");
	consultaNotas();
}
function consultaNotas(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorNotas',
		data : "accion=Cargar",
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
            alert('Error al consultar Notas.')
    }
	});
}

function cargaInformacionNotas(respuesta){
	var res = respuesta[0];
	var notas = res.listNotas;
	//alert(JSON.stringify(data));
	var db = {

			 loadData : function(filter) {
					var json= $.grep(notas, function(client) {
						return (!filter.doctoTran.toUpperCase()|| client.doctoTran.toUpperCase() === filter.doctoTran.toUpperCase() || client.doctoTran.toUpperCase() == filter.doctoTran.toUpperCase() || client.doctoTran.toUpperCase().includes(filter.doctoTran.toUpperCase()))
						&&(!filter.claveTran.toUpperCase()|| client.claveTran.toUpperCase() === filter.claveTran.toUpperCase() || client.claveTran.toUpperCase() == filter.claveTran.toUpperCase() || client.claveTran.toUpperCase().includes(filter.claveTran.toUpperCase()))
						&&(!filter.folioFiscal.toUpperCase()|| client.folioFiscal.toUpperCase() === filter.folioFiscal.toUpperCase() || client.folioFiscal.toUpperCase() == filter.folioFiscal.toUpperCase() || client.folioFiscal.toUpperCase().includes(filter.folioFiscal.toUpperCase()))
						&&(!filter.fechaTran.toUpperCase()|| client.fechaTran.toUpperCase() === filter.fechaTran.toUpperCase() || client.fechaTran.toUpperCase() == filter.fechaTran.toUpperCase() || client.fechaTran.toUpperCase().includes(filter.fechaTran.toUpperCase()))
						&&(!filter.numFactura.toUpperCase()|| client.numFactura.toUpperCase() === filter.numFactura.toUpperCase() || client.numFactura.toUpperCase() == filter.numFactura.toUpperCase() || client.numFactura.toUpperCase().includes(filter.numFactura.toUpperCase()))
						&&(!filter.fechaFactura.toUpperCase()|| client.fechaFactura.toUpperCase() === filter.fechaFactura.toUpperCase() || client.fechaFactura.toUpperCase() == filter.fechaFactura.toUpperCase() || client.fechaFactura.toUpperCase().includes(filter.fechaFactura.toUpperCase()))
						&&(!filter.serie.toUpperCase()|| client.serie.toUpperCase() === filter.serie.toUpperCase() || client.serie.toUpperCase() == filter.serie.toUpperCase() || client.serie.toUpperCase().includes(filter.serie.toUpperCase()))
						&&(!filter.txtNota.toUpperCase()|| client.txtNota.toUpperCase() === filter.txtNota.toUpperCase() || client.txtNota.toUpperCase() == filter.txtNota.toUpperCase() || client.txtNota.toUpperCase().includes(filter.txtNota.toUpperCase()))
						});
					datos=json;
					//alert(json);
					return json;
				}
	 };
		    window.db = db;
		    db.res;
		    $("#tablaNotas").jsGrid({
		    	height : "500px",
		        width: "100%",
		        controller: db,
		        filtering: true,
		        autoload:true,
		        sorting:true,
		        fields: [
		            { title:"DOCTOTRAN",name: "doctoTran", type: "text", width: 7,align : 'center'},
		            { title:"CLAVETRAN", name: "claveTran", align:'center', type: "text", width: 7 },
		            { title:"FOLIOFISCAL",name: "folioFiscal", type: "text", width: 7,align : 'center'},
		            { title:"FECHATRAN",name: "fechaTran", type: "text", width: 7,align : 'center'},
		            { title:"NUM FACTURA",name: "numFactura", type: "text", width: 7,align : 'center'},
		            { title:"FECHA FACTURA",name: "fechaFactura", type: "text", width: 7,align : 'center'},
		            { title:"SERIE FACTURA",name: "serie", type: "text", width: 7, align : 'center'},
		            { title:"TXT NOTA",name: "txtNota", type: "text", width: 10, align : 'center'},
             ],		       
		        rowClick: function (args) {
		        }
			    });
		    
}		    
function sellar(){
	for(var i=0; i<datos.length;i++){
		var sacarRuta=datos[i].fechaTran.split("-");
		cambiarRuta(sacarRuta,datos[i].txtNota);
		sellaNotas(datos[i].txtNota);
	}
}
function cambiarRuta(sacarRuta, nota){
	var checaRuta;
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorNotas',
		data : "accion=CambiarRuta&anio="+sacarRuta[0]+"&mes="+sacarRuta[1]+"&dia="+sacarRuta[2]+"&nota="+nota,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			// alert("HOla: " + JSON.stringify(respuesta) );
			checaRuta= respuesta[0].cambia;
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
            alert('Error al consultar Notas.')
    }
	});
	return checaRuta;
}
function sellaNotas(nota){
	var checaRuta;
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorNotas',
		data : "accion=SellaNotas&nota="+nota,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );
			checaRuta= respuesta[0].cambia;
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
            alert('Error al consultar Notas.')
    }
	});
	return checaRuta;
}	
