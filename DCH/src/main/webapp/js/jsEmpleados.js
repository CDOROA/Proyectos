function rutinaInicioEmpleados() {
	$("#menu-evaluacion").removeClass("Opc-Menu-Activo");
	$("#menu-resultatipoEncuesta").removeClass("Opc-Menu-Activo");
	$("#menu-seguimiento").removeClass("Opc-Menu-Activo");
	$("#menu-empleatipoEncuesta").addClass("Opc-Menu-Activo");
	consultaEmpleados();
} 
function consultaEmpleados(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'EmpleadosServlet',
		data : "accion=Cargar",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			document.getElementById('cargando').style.display = 'none';
			cargaInformacionEmpleados(respuesta);
		},
		error : function(xhr, status, error)
        {
            document.getElementById('cargando').style.display = 'none';
            if (xhr.status === 200)
            {
                alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
                window.location.href='/DCH/';
            }
            else
                alert('Error al consultar numero de evaluaciones.')
        }
	});
}
function cargaInformacionEmpleados(respuesta){
	$("#gridEmpleados").empty();
	var res = respuesta[0];
	var resultados = res.listEmpleados;
	console.log(JSON.stringify(respuesta));
	var db = {

			 loadData : function(filter) {
					return $.grep(resultados, function(client) {
						return (!filter.area.toUpperCase()|| client.area.toUpperCase() === filter.area.toUpperCase() || client.area.toUpperCase() == filter.area.toUpperCase() || quitarCarateres(client.area.toUpperCase()).includes(filter.area.toUpperCase()))
					        && (!filter.nombre.toUpperCase()|| client.nombre.toUpperCase() === filter.nombre || client.nombre.toUpperCase() == filter.nombre || quitarCarateres(client.nombre.toUpperCase()).includes(filter.nombre.toUpperCase()))
					        && (!filter.tipoEncuesta.toUpperCase()|| client.tipoEncuesta.toUpperCase() === filter.tipoEncuesta || client.tipoEncuesta.toUpperCase() == filter.tipoEncuesta || quitarCarateres(client.tipoEncuesta.toUpperCase()).includes(filter.tipoEncuesta.toUpperCase()))
					        && (!filter.puesto.toUpperCase()|| client.puesto.toUpperCase() === filter.puesto || client.puesto.toUpperCase() == filter.puesto || quitarCarateres(client.puesto.toUpperCase()).includes(filter.puesto.toUpperCase()))
					        && (!filter.depto.toUpperCase()|| client.depto.toUpperCase() === filter.depto || client.depto.toUpperCase() == filter.depto || quitarCarateres(client.depto.toUpperCase()).includes(filter.depto.toUpperCase()))
					        && (!filter.correo|| client.correo === filter.correo || client.correo== filter.correo || quitarCarateres(client.correo.toUpperCase()).includes(filter.correo.toUpperCase()))
					        && (!filter.fechaIngreso.toUpperCase()|| client.fechaIngreso.toUpperCase() === filter.fechaIngreso || client.fechaIngreso.toUpperCase() == filter.fechaIngreso || quitarCarateres(client.fechaIngreso.toUpperCase()).includes(filter.fechaIngreso.toUpperCase()))
					        
					       
					});
				}
	 };
		    window.db = db;
		    db.res;
		    $("#gridEmpleados").jsGrid({
		    	
		        height: "auto",
		        width: "100%",
		        controller: db,
		        
		        filtering: true,
		        autoload:true,
		        sorting:true,
		        fields: [
		            { title:"AREA",name: "area", type: "text", width: 30},
		            { title:"NOMBRE",name: "nombre", type: "text", width: 50},
		            { title:"PUESTO",name: "puesto", type: "text", width: 45},
		            { title:"FECHA INGRESO",name: "fechaIngreso", type: "text", width: 10},
		            { title:"DEPTO",name: "depto", type: "text", width: 30,cellRenderer: function(item, value){
		            	var depto=item.split(',');
			            var contenido="<td><div title='"+depto[1]+"'>"+depto[0]+"</div></td>";
			            	if(item==""){
			            		contenido="<td style='background:black;'></td>";
			            }
				                return $(contenido).addClass("depto"); }},
		           // { title:"SUBDEPTO",name: "subdepto", type: "text", width: 30},
		            { title:"TIPO ENCUESTA",name: "tipoEncuesta", type: "text", width:25},
		            { title:"CORREO",name: "correo", type: "text", width: 45},
             ],rowDoubleClick: function (args) {
		        	cambiaCorreo(args.item.idEmpleado,args.item.correo,args.item.idTipoEncuesta); 
	            }
		    });
}


function cambiaCorreo(idEmpleado,correo,idTipoEncuesta){
	$("#correo").val(correo);
	$("#idTipoEncuesta").val(idTipoEncuesta);
	$("#idEmpleado").val(idEmpleado);
	$("#modalCorreo").modal("show");
	
}
function guardarCorreo(){
	//$("#modalCorreo").modal("hide");
	var correo=$("#correo").val()+" ";
//	alert("correo: "+correo.trim()+" idTipoEncuesta: "+$("#idTipoEncuesta").val()+" idEmpleado: "+$("#idEmpleado").val())
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'EmpleadosServlet',
		data : "accion=CambioCorreo&idTipoEncuesta="+$("#idTipoEncuesta").val()+"&correo="+correo.trim()+"&idEmpleado="+$("#idEmpleado").val(),
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			document.getElementById('cargando').style.display = 'none';
			consultaEmpleados();
			if((JSON.stringify(respuesta[0].rsp))==('"true"')){
				alert("Se guardaron los cambios");
			}else{
				alert("No se guardaron los cambios");
			}
		},
		error : function(xhr, status, error)
        {
            document.getElementById('cargando').style.display = 'none';
            if (xhr.status === 200)
            {
                alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
                window.location.href='/DCH/';
            }
            else
                alert('Error al consultar numero de evaluaciones.')
        }
	});
}
function validaCorreo(){
	var correo=$("#correo").val();
	if(correo.includes("@")|| correo.length>3){
		guardarCorreo();
		enviarCorreo();
	}else{
		alert("Correo no valido");
	}
}
function enviarCorreo(){
	var idEmpleado=$("#idEmpleado").val();
	$.ajax({
		url : 'AdministradorEvaluaciones',
		data : "accion=EnviarCorreo&idEmpleado="+idEmpleado+"&valida=true",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			$("#modalCorreo").modal("hide");
			alert("Correo enviado con exito!");
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {
            document.getElementById('cargando').style.display = 'none';
            if (xhr.status === 200)
            {
                alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
                window.location.href='/DCH/';
            }
            else
                alert('Error al enviar correo.')
        }
	});
	
}
function quitarCarateres(palabra){
	var letras=["a","A","e","E","i","I","o","O","u","U","ñ","Ñ"];
	var codigo=["\u00e1","\u00c1","\u00e9","\u00c9","\u00ed","\u00cd","\u00f3","\u00d3","\u00fa","\u00da","\u00f1","\u00d1"];
	for (var i = 0; i <= codigo.length; i++) {
		   palabra=palabra.replaceAll(codigo[i],letras[i]);
		}
	return palabra;
}