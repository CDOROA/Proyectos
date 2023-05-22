function rutinaInicioSeguimiento() {
	$("#menu-evaluacion").removeClass("Opc-Menu-Activo");
	$("#menu-resultados").removeClass("Opc-Menu-Activo");
	$("#menu-seguimiento").addClass("Opc-Menu-Activo");
	consultaEvaluaciones();
	
}
function consultaInformacion(idEncuesta) {
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'SeguimientoServlet',
		data : "accion=Cargar&idEncuesta="+idEncuesta,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			 //alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					cargarSeguimiento(respuesta);
					document.getElementById('cargando').style.display = 'none';

				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
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
                alert('Error al consultar seguimientos.')
        }
	});
}

function cargarSeguimiento(respuesta){
	var data = respuesta;
	//alert("data: " + JSON.stringify( data));
	var seg = data[0];
	var seguimiento = seg.listSegumiento;
	/* Calculando el largo de Divs */
	//alert("seguimiento: " + JSON.stringify( seg));
	var db = {
			 loadData : function(filter) {
					return $.grep(seguimiento, function(client) {
						return (!filter.nombre.toUpperCase()|| client.nombre.toUpperCase() === filter.nombre.toUpperCase() || client.nombre.toUpperCase() == filter.nombre.toUpperCase() || client.nombre.toUpperCase().includes(filter.nombre.toUpperCase()))
							&& (!filter.estatus.toUpperCase()|| client.estatus.toUpperCase() === filter.estatus.toUpperCase() || client.estatus.toUpperCase() == filter.estatus.toUpperCase() || client.estatus.toUpperCase().includes(filter.estatus.toUpperCase()))
					       	&& (!filter.puesto.toUpperCase()|| client.puesto.toUpperCase() === filter.puesto.toUpperCase() || client.puesto.toUpperCase() == filter.puesto.toUpperCase() || client.puesto.toUpperCase().includes(filter.puesto.toUpperCase()))
					       	&& (!filter.departamento.toUpperCase()|| client.departamento.toUpperCase() === filter.departamento.toUpperCase() || client.departamento.toUpperCase() == filter.departamento.toUpperCase() || client.departamento.toUpperCase().includes(filter.departamento.toUpperCase()))
							&& (!filter.totalEncuestas|| client.totalEncuestas === filter.totalEncuestas || client.totalEncuestas == filter.totalEncuestas)
							&& (!filter.totalEncuestasTerm|| client.totalEncuestasTerm === filter.totalEncuestasTerm || client.totalEncuestasTerm == filter.totalEncuestasTerm)
							&& (filter.estatus|| client.estatus === 'NO INICIADO'|| client.estatus == 'NO INICIADO'||filter.estatus|| client.estatus === 'EN PROCESO'|| client.estatus == 'EN PROCESO')
							});
				}
	 };
		    window.db = db;
		    db.seguimiento;
		    //alert(db.areas);
		    $("#divSeguimiento").jsGrid({
		        height: "auto",
		        width: "100%",
		        controller: db,
		        filtering: true,
		        autoload:true,
		        sorting: true,
		       
		        fields: [
		        	{ title:"DEPARTAMENTO",name: "departamento", type: "text"},
		        	{ title:"PUESTO",name: "puesto",type: "text"},
		            { title:"NOMBRE COMPLETO",name: "nombre", type: "text"},
		            { headerTemplate: function() { return $("<div>").prop("title", "NUMERO DE ENCUESTAS").text(this.title); }, title:"#E",align: "center", name: "totalEncuestas", type: "text", width:10},
		            { headerTemplate: function() { return $("<div>").prop("title", "NUMERO DE ENCUESTAS TERMINADAS").text(this.title); }, title:"#ET",align: "center", name: "totalEncuestasTerm", type: "text", width:10},
		            {
						title:"ESTATUS",
						name:"estatus",
						sorting: false,
						width:30,
						type: "select",
					    align: "center",            // center text alignment
					    autosearch: true,           // triggers searching when the user changes the selected item in the filter
					    items: [{name:"",valor:""},{name:"SIN ENCUESTA",valor:"SIN ENCUESTA"},{name:"EN PROCESO", valor:"EN PROCESO"},{name:"NO INICIADO",valor:"NO INICIADO"},{name:"TERMINADO",valor:"TERMINADO"}],                  // an array of items for 
					    valueField: "valor",        
					    textField: "name",
				        valueType: "string", // the data type of the value
				        cellRenderer : function(value, item) {
				        	//alert(JSON.stringify(item.estatus));
								var contenido="<td>"+JSON.stringify(item);
								if(JSON.stringify(item.estatus)=='"'+"EN PROCESO"+'"'){
									contenido="<td style='background:#ffec9c; color:#9c5600;'>";
								}else if(JSON.stringify(item.estatus)=='"'+"NO INICIADO"+'"'){
									contenido="<td style='background:#ffc4cc; color:#94000e;'>";
								}else if(JSON.stringify(item.estatus)=='"'+"TERMINADO"+'"'){
									contenido="<td style='background:#c8eccc; color:#005e05;'>";
								}
								return $(contenido).addClass("estatus").append(item.estatus);
							}
					},
		            {
						title : "PROGRESO",
						width:30,
						type:"control",
						sorting: false,
						align : 'center',
						itemTemplate : function(value, item) {
							var contenido="";
							if(JSON.stringify(item.totalEncuestasTerm)==0||JSON.stringify(item.totalEncuestas)==0){
								contenido= "<div class='progress'><div class='progress-bar' role='progressbar' style='width: 0%;' aria-valuenow='0' aria-valuemin='0' aria-valuemax='100'>0%</div>";
							}else{
								contenido= "<div class='progress'><div class='progress-bar' role='progressbar' style='width: "+JSON.stringify(((item.totalEncuestasTerm*100)/item.totalEncuestas).toFixed(2)).replaceAll('"',"")+"%;' aria-valuenow='"+JSON.stringify(((item.totalEncuestasTerm*100)/item.totalEncuestas).toFixed(2)).replaceAll('"',"")+
		                		"' aria-valuemin='0' aria-valuemax='100'>"+JSON.stringify(((item.totalEncuestasTerm*100)/item.totalEncuestas).toFixed(2)).replaceAll('"',"")+"%</div>";
							}
							return contenido;
						}
					},
		        ],
		        rowClick: function (args) {
		        	cargaSegumiento(args.item.idEmpleado, args.item.nombre);
	                //$("#exampleModal").modal("show");
	         
	               
	            },
	            
		    });
		    $("#sort").click(function() {
		        var field = $("#sortingField").val();
		        $("#divSeguimiento").jsGrid("sort", field);
		    });
}
function cargaSegumiento(idEmpleado, nombre){
	//alert(idEmpleado);
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'SeguimientoServlet',
		data : "accion=SeguimientoDetalle&idEmpleado="+idEmpleado,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			 //alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					cargarSeguimientoDetalle(respuesta, nombre);
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
            window.location.href='/DCH/';
        }
        else
            alert('Error al consultar seguimientos.')
    }
	});
}
function cargarSeguimientoDetalle(respuesta, nombre){
	//console.log(JSON.stringify(respuesta));
	var contenido="<table id='tablaSeguimientos' class='tablaEvaluaciones2'><th>EVALUADOS</th><th>PUESTO</th><th>PERFIL</th><th>FECHA INICIO</th><th>FECHA FIN</th><th>ESTATUS</th><th>PROGRESO</th>";
	$("#tablaSeguimientos").empty();
		contenido+="<h5 style='text-align:center;'>EVALUADOR: "+nombre+"</h5>";
		for(var i=0;i<respuesta[0].listSegumiento.length;i++){
			contenido+="<tr><td>"+respuesta[0].listSegumiento[i].nombre+"</td><td>"+respuesta[0].listSegumiento[i].puesto+"</td><td>"+respuesta[0].listSegumiento[i].perfil+
			"</td><td>"+respuesta[0].listSegumiento[i].fechaInicio+"</td><td>"+respuesta[0].listSegumiento[i].fechaFin+"</td>";
			if(respuesta[0].listSegumiento[i].estatus=="TERMINADA"){
				contenido+="<td class='text-center' id='estatus' style='background:#72c453; color:white;' class='text-center'>";
			}else if(respuesta[0].listSegumiento[i].estatus=="NO INICIADA"){
				contenido+="<td  class='text-center'' id='estatus' style='background:#ff4040; color:white;' class='text-center'>";
			}else if(respuesta[0].listSegumiento[i].estatus=="EN PROCESO"){
				contenido+="<td  class='text-center' id='estatus' style='background:#FFF700;' class='text-center'>";
			}	
			contenido+=respuesta[0].listSegumiento[i].estatus+"</td><td><div class='progress'>"
			  +"<div class='progress-bar' role='progressbar' style='width: "+((respuesta[0].listSegumiento[i].preguntasContestadas*100)/respuesta[0].listSegumiento[i].totalPreguntas).toFixed(2)+"%;' aria-valuenow='"+((respuesta[0].listSegumiento[i].preguntasContestadas*100)/respuesta[0].listSegumiento[i].totalPreguntas).toFixed(2)+"' aria-valuemin='0' aria-valuemax='100'>"+((respuesta[0].listSegumiento[i].preguntasContestadas*100)/respuesta[0].listSegumiento[i].totalPreguntas).toFixed(2)+"%</div>"
			+"</div></td></tr>";
		}
		contenido+="</table>";
	$("#tablaSeguimientos").append(contenido);
	$("#exampleModal").modal("show");
}
function consultaEvaluaciones(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorEvaluaciones',
		data : "accion=Cargar",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;
				if (data.length > 0) {
					var contenido="<select id='selectEncuesta' onchange='consultaInformacion(this.value);'>"
					$("#selectEncuesta").empty();
					contenido+="<option value='' selected></option>";
					for(var i=0; i<respuesta[0].listEvaluaciones.length;i++){
						contenido+="<option value='"+respuesta[0].listEvaluaciones[i].idEncuesta+"'>"+respuesta[0].listEvaluaciones[i].nombre+"</option>"
					}
					contenido+="</select>"
					$("#selectEncuesta").append(contenido);
					document.getElementById('cargando').style.display = 'none';

				}
			} else
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
                alert('Error al consultar evaluaciones.')
        }
	});
}
