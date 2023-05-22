var data;
var jerarquia;
var area;
var area2;
var firstClick = false; 
var i=0;
var checa2=false;
var check=false;
var idEncuesta;
var idEvaluado;
var idEmpleadoEva;
var checa=false;
var jefesInmediatos=[];
var subordinados=[];
var colegas=[];
var clientes=[];
var filas=0;
var checaCorreo=false;
function rutinaInicioEvaluaciones() {
	$("#menu-evaluacion").removeClass("Opc-Menu");
	$("#menu-evaluacion").addClass("Opc-Menu-Activo");
	consultaEvaluaciones();
	consultaNumEvaluaciones();
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	 if(dd<10){
	        dd='0'+dd
	    } 
	    if(mm<10){
	        mm='0'+mm
	    } 

	today = yyyy+'-'+mm+'-'+dd;
	document.getElementById("fechaFin").setAttribute("min", today);
	document.getElementById("fechaFin").setAttribute("value", today);
}
function consultaNumEvaluaciones(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorEvaluaciones',
		data : "accion=ConsultaEvaluaciones",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//console.log("HOla: " + JSON.stringify(respuesta) );

			$("#numEvaluacionas").val(respuesta[0].numEvaluaciones);
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
					cargarInformacionEvaluaciones(respuesta);
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
function cargarInformacionEvaluaciones(json) {
	document.getElementById('cargando').style.display = 'block';
	console.log(JSON.stringify(json));
	  $("#divEvaluaciones").empty();
	  var contenido="";
	  contenido+=""
		  contenido+="<table class='tablaEvaluaciones'>"
			  +"<thead class='thead-dark'>"
			    +"<tr>"
			      +"<th scope='col'>NOMBRE</th>"
			      +"<th scope='col'>ESTATUS</th>"
			      +"<th scope='col'>FECHA INICIO</th>"
			      +"<th scope='col'>FECHA FIN</th>"
				+"<th scope='col'>RELACI\u00D3N</th>"	
			    +"</tr>"
			  +"</thead>"
			  +"<tbody>";
			for(var i=0;i<json[0].listEvaluaciones.length;i++){
			contenido+="<tr><td>"+json[0].listEvaluaciones[i].nombre+"</td>"
			      +"<td>"+json[0].listEvaluaciones[i].estatus+"</td>"
			      +"<td>"+json[0].listEvaluaciones[i].vigenciaInicio+"</td>"
			      +"<td>"+json[0].listEvaluaciones[i].vigenciaFin+"</td>"
			      +"<td><button type='button' class='btn btn-light' onclick=cambio('Evaluaciones','preguntas','"+json[0].listEvaluaciones[i].idEncuesta+"');><img  src='images/derecha.svg' class='img-fluid centrar' /></button></td>";
			contenido+="</tr>"
			}    
			
			  +"</tbody>"
			+"</table>";
	$('#divEvaluaciones').append(contenido);
	
}
function agregaEvaluacion(){
	$('#modalEva').modal('show');
}
function cambio(anterior,actual, idencuesta){
	document.getElementById('cargando').style.display = 'block';
	document.getElementById(anterior).style.display = 'none';
	document.getElementById(actual).style.display = 'block';
	document.getElementById('cargando').style.display = 'none';
	idEncuesta=idencuesta;
	//alert(idEncuesta)
	limpiar();
}

function consultaAreas(idEncuesta){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorEvaluaciones',
		data : "accion=CargarAreas&idEncuesta="+idEncuesta,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					console.log(JSON.stringify(respuesta));
					cargaAreas(respuesta);
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
                alert('Error al consultar areas.')
        }
	});
}

function cargaAreas(json){
	var porcentaje;
	$('#divArea').empty();
	console.log(JSON.stringify(json));
	var contenido ="<div id='cajaConfiguracion'><div id='uno' class='list-group'><table class='tablaAreas'><th style='width:10%; '>AREA</th><th style='width:2%;'>INVENTARIO</th>";
	for(var i=0;i<json[0].listAreas.length;i++){
		contenido+="<tr><td style='width:10%;  text-align:left; font-size:13px;'><div class='btn-group dropend' style='width:100%;'>"
			+"<a class='rounded-start list-group-item list-group-item-action' id='list-home-list"+i+"' data-bs-toggle='list' role='tab' aria-controls='list-home' onclick='cambiaVariable("+json[0].listAreas[i].idArea+");'"  
				+"data-toggle='list' href='"+i+"' role='tab' aria-controls='home'>"+json[0].listAreas[i].descripcion+"</a>"
		      +"<button type='button' class='btn btn-primary dropdown-toggle dropdown-toggle-split' data-bs-toggle='dropdown' aria-expanded='false'>"
		       +" <span class='visually-hidden'>Toggle Dropdown</span>"
		      +"</button>"
		      +"<ul class='dropdown-menu'>"
		       +json[0].listAreas[i].subdptos
		     +" </ul>"
		 +"</div></td>";
		if(json[0].listAreas[i].totalEmpleados!=0){
		   	porcentaje=((json[0].listAreas[i].empleadosEvaluados*100)/json[0].listAreas[i].totalEmpleados);
		   	}else{
		   		porcentaje=0;
		   	}
	   	if(json[0].listAreas[i].totalEmpleados==json[0].listAreas[i].empleadosEvaluados){
	   	  contenido+="<td style='background-color:#CAF7CB'> " +
	   	  		"<div class='progress'><div class='progreso' style='position: absolute;'>"+porcentaje.toFixed(0)+"%</div>" +
	   	  		"<div class='progress-bar progress-bar-striped progress-bar-animated bg-success' role='progressbar' style='width:"+porcentaje.toFixed(0)+"%;' aria-valuenow='"+porcentaje.toFixed(0)+"' aria-valuemin='0' aria-valuemax='100'>" +
	   	  				"</div>" +
	   	  				"</div><p style='font-size:12px;'>"+json[0].listAreas[i].empleadosEvaluados+"/"+json[0].listAreas[i].totalEmpleados+"</p></td>";
	   	}else{
	   		contenido+="<td ><div class='progress' ><div class='progreso' style='position: absolute;'>"+porcentaje.toFixed(0)+"%</div>" +
	   				"<div class='progress-bar progress-bar-striped progress-bar-animated bg-danger' role='progressbar' style='width: "+porcentaje.toFixed(0)+"%;' aria-valuenow='"+porcentaje.toFixed(0)+"' aria-valuemin='0' aria-valuemax='100'></div></div>" +
	   						"<p style='font-size:12px;'>"+json[0].listAreas[i].empleadosEvaluados+"/"+json[0].listAreas[i].totalEmpleados+"</p></td>";
	   	}
	   
	   	contenido+="</tr>"
	}
	  contenido+="</table></div>"
	   +"<div class='col-8' style='width:80%;'>" 
	   +"<div class='tab-content' style='text-align:center;' id='nav-tabContent'><h3>Selecciona un area</h3>";
	contenido +="</div></div>"
			   +"</div>"
				 +"</div>";
	$('#divArea').append(contenido);
	const tabElms = document.querySelectorAll('a[data-bs-toggle="list"]')
	tabElms.forEach(tabElm => {
	  tabElm.addEventListener('shown.bs.tab', event => {
	    event.target // newly activated tab
	    event.relatedTarget // previous active tab
	  })
	})
}

function cargaEmpleadosArea(idArea, i){
	//document.getElementById("boton").classList.toggle("active");
	document.getElementById('cargando').style.display = 'block';
	if(!firstClick||jerarquia==undefined){
		$.ajax({
		url : 'AdministradorEvaluaciones',
		data : "accion=CargarEmpleados&idArea="+idArea,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				//data = respuesta;

				if (respuesta.length > 0) {
					//console.log(JSON.stringify(respuesta));
					cargaEmpleados(respuesta, i);
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
                alert('Error al consultar empleados del area.')
        }
	});	
		//firstClick = true; 
	}else{
		
	}
}

function cargaEmpleados(json, i){
	document.getElementById("btnGuardar").style.display = 'block';
	document.getElementById("btnCorreos").style.display = 'none';
	var verifica=false;
	var jera;
	$('#nav-tabContent').empty();
	//document.getElementById("area"+i).onclick= 'cambiaVariable("+json[0].listAreas[i].idArea+"); cargarEvaluadores("+jerarquia+", "+area+");';
	var j=0;
	var contenido="";
	 contenido+="<script>$(document).ready(function(){ $('.chosen').chosen(); });</script><h3 style='background-color: black; color:white;'>Selecciona al Evaluado</h3><div class='tab-pane fade show active' id='list-home"+i+"' " +
	 		"role='tabpanel' aria-labelledby='list-home-list'>"
	 if(json[0].listEmpleados.length<=0){
		 contenido+="<h6>Sin registros</h6>"
	 }else{
	 contenido+="<select cname='miselect[]' style='width:40%; height:15%;' id='evaluados' class='chosen' onchange='cambiaCheck(this.value);' data-placeholder='Elige a la persona a evaluar'>" +
	 "<option value=''></option>";
	 for(var n=0;n<json[0].listEmpleados.length;n++){
		 if(json[0].listEmpleados[n].idEmpleado==idEmpleadoEva){
			 contenido+= "<option selected value='"+json[0].listEmpleados[n].jerarquia+"'>"+json[0].listEmpleados[n].nombre+"("+json[0].listEmpleados[n].nombreArea+")"+"</option>";
			 verifica=true;
			 jera=json[0].listEmpleados[n].jerarquia;
		 }else{
		 contenido+= "<option value='"+json[0].listEmpleados[n].jerarquia+"'>"+json[0].listEmpleados[n].nombre+"("+json[0].listEmpleados[n].nombreArea+")"+"</option>";
		 }
	 }
	 contenido+="</select></div><br><div id='divJefeInmediato'></div><br><div id='divSubordinados'></div><br><div id='divColegas'></div><br><div id='divClientes'></div>";
	 for(var n=0;n<json[0].listEmpleados.length;n++){
		 nombre=json[0].listEmpleados[n].nombre+"("+json[0].listEmpleados[n].nombreArea+")";
		 nombre=nombre.replaceAll(" ","");
		 contenido+= "<input type='hidden' id='"+nombre+json[0].listEmpleados[n].jerarquia+"' value='"+json[0].listEmpleados[n].idEmpleado+"'>";
	 }
	 }
	 
	$('#nav-tabContent').append(contenido);
	if(verifica){
		cambiaCheck(jera);
	}
	$('#btnLimpiar').empty();
	 contenido="<button type='button' onclick='limpiar();' class='btn btn-primary'>Limpiar</button>";
	$('#btnLimpiar').append(contenido);
}
function cargarEvaluadores(idJerarquia, area){
	document.getElementById('cargando').style.display = 'block';
	//jerarquia=idJerarquia;
		$.ajax({
		url : 'AdministradorEvaluaciones',
		data : "accion=CargarEmpleadosEv&idJerarquia="+idJerarquia+"&idArea="+area,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				//data = respuesta;

				if (respuesta.length > 0) {
					//alert(JSON.stringify(respuesta));
					if(!check||document.getElementById( "selectEvars" )==null){
					cargaEmpleadosEv(respuesta);
					check=true;
					}
						for(var n=0;n<respuesta[0].listEmpleadosEv.length;n++){
							if ( $("#selectEvars option[value='"+respuesta[0].listEmpleadosEv[n].idEmpleado+"']").length == 0 ){
							 	var aficiones = document.getElementById("selectEvars");
							    var inputAficion = respuesta[0].listEmpleadosEv[n].nombre+" ("+respuesta[0].listEmpleadosEv[n].nombreArea+")";
							    var option = document.createElement("option");
							    option.text = inputAficion;
							    option.value =respuesta[0].listEmpleadosEv[n].idEmpleado;
							    //alert(jefesInmediatos);
							    for(var i=0;i<jefesInmediatos.length;i++){
						    		if(respuesta[0].listEmpleadosEv[n].idEmpleado==jefesInmediatos[i]){
						    			option.selected=true;
						    			//alert(jefesInmediatos);
						    		}
						    		
						    	}
							    aficiones.add(option);
							}
							$('#selectEvars').trigger("chosen:updated");
							}
						
						}
					
					document.getElementById('cargando').style.display = 'none';

				
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
                alert('Error al consultar evaluadores.')
        }
	});
}

function cargaEmpleadosEv(json){
	//alert(JSON.stringify(json));
	var contenido="";
	
	$('#divJefeInmediato').empty();
	 contenido+="<script>$(document).ready(function(){ $('.chosen').chosen(); });</script><h3 style='background-color: gray; color:white;'>Selecciona al Jefe Inmediato</h3>" +
	 		"<div class='tab-pane fade show active' id='list-home"+i+"' " +
		"role='tabpanel' aria-labelledby='list-home-list'>";
		contenido+="<select cname='miselect[]' id='selectEvars' style='width:30%;' multiple class='chosen' data-placeholder='Elige a los jefes inmediatos'>" +
		"<option></option>";	
	 contenido+="</select></div><br>";
	$('#divJefeInmediato').append(contenido);
}
function cambiaVariable(idArea){
	area=idArea;
	if(!checa){
	cargaEvaluados(area)
	}
	if(firstClick){
		cargarEvaluadores(jerarquia, area);
		
	}
}
function cambiaCheck(idJerarquia){
	check=false;
	var evaluado= $("#evaluados :selected").text();
	evaluado=evaluado.replaceAll(" ","");
	evaluado=evaluado+idJerarquia;
	//alert(evaluado);
	idEvaluado=document.getElementById(evaluado).value;
	$('#divColegas').empty();
	$('#divSubordinados').empty();
	$('#divJefeInmediato').empty();
	$('#divClientes').empty();
	cargarEvaluadoresC(idJerarquia,area); 
	cargarEvaluadoresS(idJerarquia,area); 
	cargarEvaluadores(idJerarquia,area);
	cargarEvaluadoresCli(area);
	jerarquia=idJerarquia;
}
function cargarEvaluadoresS(idJerarquia, area){
	document.getElementById('cargando').style.display = 'block';
		$.ajax({
		url : 'AdministradorEvaluaciones',
		data : "accion=CargarEmpleadosEvS&idJerarquia="+idJerarquia+"&idArea="+area,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				//data = respuesta;

				if (respuesta.length > 0) {
					//alert(JSON.stringify(respuesta));
					if(!check||document.getElementById( "selectEvarS" )==null){
					cargaEmpleadosEvS(respuesta);
					check=true;
					}
						for(var n=0;n<respuesta[0].listEmpleadosEv.length;n++){
							if ( $("#selectEvarS option[value='"+respuesta[0].listEmpleadosEv[n].idEmpleado+"']").length == 0 ){
							 	var aficiones = document.getElementById("selectEvarS");
							    var inputAficion = respuesta[0].listEmpleadosEv[n].nombre+" ("+respuesta[0].listEmpleadosEv[n].nombreArea+")";
							    var option = document.createElement("option");
							    option.text = inputAficion;
							    option.value =respuesta[0].listEmpleadosEv[n].idEmpleado;
							    for(var i=0;i<subordinados.length;i++){
						    		if(respuesta[0].listEmpleadosEv[n].idEmpleado==subordinados[i]){
						    			option.selected=true;
						    		}
							    }
							    aficiones.add(option);
							}
							 $('#selectEvarS').trigger("chosen:updated");
							}
						
						}
					
					document.getElementById('cargando').style.display = 'none';

				
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
                alert('Error al consultar evaluadores subordinados.')
        }
	});
	
}
function cargaEmpleadosEvS(json){
	//alert(JSON.stringify(json));
	var contenido="";
	$('#divSubordinados').empty();
	 contenido+="<script>$(document).ready(function(){ $('.chosen').chosen(); });</script><h3 style='background-color: gray; color:white;'>Selecciona a los Subordinados</h3>" +
	 		"<div class='tab-pane fade show active' id='list-home"+i+"' " +
		"role='tabpanel' aria-labelledby='list-home-list'>";
		contenido+="<select cname='miselect[]' id='selectEvarS' style='width:30%;' multiple class='chosen' data-placeholder='Elige a los subordinados'>" +
		"<option></option>";	
	 contenido+="</select></div><br>";
	$('#divSubordinados').append(contenido);	
}
function cargarEvaluadoresC(idJerarquia, area){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	url : 'AdministradorEvaluaciones',
	data : "accion=CargarEmpleadosC&idJerarquia="+idJerarquia+"&idArea="+area+"&idEvaluado="+idEvaluado,
	type : 'POST',
	dataType : 'Json',
	success : function(respuesta) {
		//alert("HOla: " + JSON.stringify(respuesta) );

		if (respuesta) {

			//data = respuesta;

			if (respuesta.length > 0) {
				//alert(JSON.stringify(respuesta));
				if(!check||document.getElementById("selectEvarC")==null){
				cargaEmpleadosEvC(respuesta);
				check=true;
				}
					for(var n=0;n<respuesta[0].listEmpleadosEv.length;n++){
						if ( $("#selectEvarC option[value='"+respuesta[0].listEmpleadosEv[n].idEmpleado+"']").length == 0 ){
						 	var aficiones = document.getElementById("selectEvarC");
						    var inputAficion = respuesta[0].listEmpleadosEv[n].nombre+" ("+respuesta[0].listEmpleadosEv[n].nombreArea+")";
						    var option = document.createElement("option");
						    option.text = inputAficion;
						    option.value =respuesta[0].listEmpleadosEv[n].idEmpleado;
						    for(var i=0;i<colegas.length;i++){
					    		if(respuesta[0].listEmpleadosEv[n].idEmpleado ==colegas[i]){
					    			option.selected=true;
					    		}
					    	}
						    aficiones.add(option);
						}
						 $('#selectEvarC').trigger("chosen:updated");
						}
					
					}
				
				document.getElementById('cargando').style.display = 'none';

			
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
            alert('Error al consultar evaluadores colegas.')
    }
});
}
function cargaEmpleadosEvC(json){
	//alert(JSON.stringify(json));
	var contenido="";
	$('#divColegas').empty();
	 contenido+="<script>$(document).ready(function(){ $('.chosen').chosen(); });</script><h3 style='background-color: gray; color:white;'>Selecciona a los Colegas</h3>" +
	 		"<div class='tab-pane fade show active' id='list-home"+i+"' " +
		"role='tabpanel' aria-labelledby='list-home-list'>";
		contenido+="<select cname='miselect[]' id='selectEvarC' style='width:30%;' multiple class='chosen' data-placeholder='Elige a los colegas'>" +
		"<option></option>";	
	 contenido+="</select></div><br>";
	$('#divColegas').append(contenido);
}
function cargarEvaluadoresCli(area){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	url : 'AdministradorEvaluaciones',
	data : "accion=CargarEmpleadosCli&idArea="+area+"&idEvaluado="+idEvaluado,
	type : 'POST',
	dataType : 'Json',
	success : function(respuesta) {
		//alert("HOla: " + JSON.stringify(respuesta) );

		if (respuesta) {

			//data = respuesta;

			if (respuesta.length > 0) {
				//alert(JSON.stringify(respuesta));
				if(!check||document.getElementById( "selectEvarCli" )==null){
				cargaEmpleadosEC(respuesta);
				check=true;
				}
					for(var n=0;n<respuesta[0].listEmpleadosEv.length;n++){
						if ( $("#selectEvarCli option[value='"+respuesta[0].listEmpleadosEv[n].idEmpleado+"']").length == 0 ){
						 	var aficiones = document.getElementById("selectEvarCli");
						    var inputAficion = respuesta[0].listEmpleadosEv[n].nombre+" ("+respuesta[0].listEmpleadosEv[n].nombreArea+")";
						    var option = document.createElement("option");
						    option.text = inputAficion;
						    option.value =respuesta[0].listEmpleadosEv[n].idEmpleado;
						    for(var i=0;i<clientes.length;i++){
						    	if(respuesta[0].listEmpleadosEv[n].idEmpleado==clientes[i]){
						    		option.selected=true;
						    	}
						    }
						    aficiones.add(option);
						    }
							
						    $('#selectEvarCli').trigger("chosen:updated");
						}

					}

				document.getElementById('cargando').style.display = 'none';

			
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
            alert('Error al consultar evaluadores clientes.')
    }
});
}
function cargaEmpleadosEC(json){
	//alert(JSON.stringify(json));
	document.getElementById('cargando').style.display = 'block';
	var contenido="";
	$('#divClientes').empty();
	 contenido+="<script>$(document).ready(function(){ $('.chosen').chosen(); });</script><h3 style='background-color: gray; color:white;'>Selecciona a los Clientes</h3>" +
	 		"<div class='tab-pane fade show active' id='list-home"+i+"' " +
		"role='tabpanel' aria-labelledby='list-home-list'>";
	 contenido+="<select cname='miselect[]' id='selectEvarCli' style='width:30%;' multiple class='chosen' data-placeholder='Elige a los clientes'>" +
		"<option></option>";
	 contenido+="</select></div><br>";
	$('#divClientes').append(contenido);

}
function cargaEvaluados(area, depto){
	document.getElementById('cargando').style.display = 'block';
	if(depto==undefined || depto==null){
		depto="";
	}
	$.ajax({
		url : 'AdministradorEvaluaciones',
		data : "accion=CargarEvaluados&idArea="+area+"&idEncuesta="+idEncuesta+"&idDepto="+depto,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {
				
				//data = respuesta;

				if (respuesta.length > 0) {
					//alert(JSON.stringify(respuesta));
					cargaEvaluadosTabla(respuesta);
				}
					
					document.getElementById('cargando').style.display = 'none';

				
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
                alert('Error al consultar evaluados.')
        }
	});
}

function cargaEvaluadosTabla(json){
	document.getElementById("btnGuardar").style.display = 'none';
	document.getElementById("btnCorreos").style.display = 'block';
	filas=0;
	var contenido="";
	if(json[0].listEvaluados.length<=0){
		$('#nav-tabContent').empty();
		contenido="<h6>Sin registros</h6>"
		$('#nav-tabContent').append(contenido)
	}else{
		contenido="";
	$('#nav-tabContent').empty();
		contenido+="<table class='tablaEvaluadores'><th style='display:none;'>AREA</th><th>EVALUADO</th><th>JEFE INMEDIATO</th><th>SUBORDINADO</th><th>COLEGA</th><th>CLIENTE</th>";//<th>CORREO</th>";
		for(var i=0;i<json[0].listEvaluados.length;i++){
			filas++;
			contenido+="<tr ondblclick='guardaIdEmpleado("+json[0].listEvaluados[i].idEmpleado+");evaluadoresSelecciona("+filas+");cambiaIdEvaluado("+json[0].listEvaluados[i].idEmpleado+");' class='click'><td style='display:none;'>"+json[0].listEvaluados[i].area+"</td><td>"+json[0].listEvaluados[i].nombreEvaluado+"</td>";
			if(json[0].listEvaluados[i].jefeInmediato==""){
				contenido+="<td style='background:#DCDCDC;'></td>";
			}else{
				if(json[0].listEvaluados[i].jefeInmediato.indexOf())
				contenido+="<td>"+json[0].listEvaluados[i].jefeInmediato+"</td>"
			}
			if(json[0].listEvaluados[i].subordinado==""){
				contenido+="<td style='background:#DCDCDC;'></td>";
			}else{
				contenido+="<td>"+json[0].listEvaluados[i].subordinado+"</td>"
			}
			if(json[0].listEvaluados[i].colega==""){
				contenido+="<td style='background:#DCDCDC;'></td>";
			}else{
				contenido+="<td>"+json[0].listEvaluados[i].colega+"</td>"
			}
			if(json[0].listEvaluados[i].cliente==""){
				contenido+="<td style='background:#DCDCDC;'></td>";
			}else{
				contenido+="<td>"+json[0].listEvaluados[i].cliente+"</td>"
			}
		//	contenido+="<td style='padding: 9px;'><button type='button' class='btn btn-info' onclick='editaCorreo("+'"'+json[0].listEvaluados[i].idEmpleado+'"'+")'>CORREO</button></td>"
		}
		contenido+="</tr></table>"
	
	$('#nav-tabContent').append(contenido);
		
		$('#btnLimpiar').empty();
		 contenido="<button type='button' onclick='limpiar();' class='btn btn-primary'>Limpiar</button>";
		$('#btnLimpiar').append(contenido);
	}
}
function editaCorreo(idEmpleado){
	alert(idEmpleado);
}
function guardaIdEmpleado(idEmpleado){
	$("#idEmpleado").val(idEmpleado);
}
function guardaEvaluaciones(){
	//borrarAnteriores();
	 var jefeInmediato = $("#selectEvars :selected").map(function(i, el) {
		    return $(el).val();
	 }).get();
	 var subordinado = $("#selectEvarS :selected").map(function(i, el) {
		    return $(el).val();
	 }).get();
	 var colegas = $("#selectEvarC :selected").map(function(i, el) {
		    return $(el).val();
	 }).get();
	 var cliente = $("#selectEvarCli :selected").map(function(i, el) {
		    return $(el).val();
	 }).get();
		for(var j=0;j<jefeInmediato.length;j++){
			guardaDatos(idEncuesta,idEvaluado, jefeInmediato[j], 1);
		}
		for(var s=0;s<subordinado.length;s++){
			guardaDatos(idEncuesta,idEvaluado, subordinado[s], 2);
		}
		for(var co=0;co<colegas.length;co++){
			guardaDatos(idEncuesta,idEvaluado, colegas[co], 3);
		}
		for(var cl=0;cl<cliente.length;cl++){
			guardaDatos(idEncuesta,idEvaluado, cliente[cl], 4);
		}
		//consultaAreas();
		limpiar();
		area=area2;
		cargaEvaluados(area2);
}

function guardaDatos(idEncuesta,idEvaluado, idEvaluador, pColaborador){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorEvaluaciones',
		data : "accion=GuardarDatos&idEvaluado="+idEvaluado+"&idEvaluador="+idEvaluador+"&pColaborador="+pColaborador+"&idEncuesta="+idEncuesta,
		type : 'POST',
		dataType : 'Json',
		async: false,
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {	

				//data = respuesta;

				if (respuesta.length > 0) {
					//alert("Datos Guardados con exito");
						}
					
					document.getElementById('cargando').style.display = 'none';

				
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
                alert('Error al guarda encuestas.')
        }
	});
}
function limpiar(){
	firstClick = false;  
	i=0;
	check=false;
	checa=false;
	checa2=false;
	consultaAreas(idEncuesta);
	filas=0;
	document.getElementById("btnGuardar").style.display = 'none';
	document.getElementById("btnCorreos").style.display = 'none';
}
function cambiaIdEvaluado(idEmpEvaluado){
	if(!checa){
	idEmpleadoEva=idEmpEvaluado;
	}
	area2=area;
	$('#nav-tabContent').empty();
	checa=true
	checa2=true;
	if(!firstClick||jerarquia==undefined){
		cargaEmpleadosArea(area, i);
		firstClick = true; 
	}	
}
function cambiaVariable2(area, depto){
	if(!checa2){
	cargaEvaluados(area, depto)
	}
}
function evaluadoresSelecciona(n){
	jefesInmediatos=[];
	subordinados=[];
	colegas=[];
	clientes=[];
	//alert("aca");
	for(var i=0;i<=2000;i++){
		if($("#"+n+"-"+i+"-"+1).length > 0){
			jefesInmediatos.push($("#"+n+"-"+i+"-"+1).val());
		}
		if($("#"+n+"-"+i+"-"+2).length > 0){
			subordinados.push($("#"+n+"-"+i+"-"+2).val());
		
		}
		if($("#"+n+"-"+i+"-"+3).length > 0){
			colegas.push($("#"+n+"-"+i+"-"+3).val());
		}
		if($("#"+n+"-"+i+"-"+4).length > 0){
			clientes.push($("#"+n+"-"+i+"-"+4).val());
		}
	}
}
function rellenaArrays(){
	document.getElementById('cargando').style.display = 'block';
	checaCorreo=false;
	var evaluadores=[]
	for(var f=1;f<=filas;f++){	
		for(var i=1;i<=2000;i++){
			for(var p=1;p<=4;p++){
				if($("#"+f+"-"+i+"-"+p).length > 0){
					if(evaluadores.indexOf($("#"+f+"-"+i+"-"+p).val())<0){
						evaluadores.push($("#"+f+"-"+i+"-"+p).val());
					}
				}
			}
		}
	}
	for(var i=0;i<evaluadores.length;i++){
		enviarCorreo(evaluadores[i]);
	}
}
function borrarAnteriores(){
	var retorno;
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorEvaluaciones',
		data : "accion=BorrarDatos&idEvaluado="+$("#idEmpleado").val()+"&idEncuesta="+idEncuesta,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );
			guardaEvaluaciones();
			return;
			retorno="true"
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
                alert('Error al borrar anteriores.')
        }
	});
	return retorno;
}

function enviarCorreo(idEmpleado){
	$.ajax({
		url : 'AdministradorEvaluaciones',
		data : "accion=EnviarCorreo&idEmpleado="+idEmpleado,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			if(!checaCorreo){
				$("#modalCorreo").modal("show");
				checaCorreo=true;
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
                alert('Error al enviar correo.')
        }
	});
	
}
function generaEncuesta(){
	if(document.getElementById("radio1").checked||document.getElementById("radio2").checked||document.getElementById("radio3").checked){
		if(($("#nombreEncuesta").val()).length>0){
				var numEncuestas=Number($("#numEvaluacionas").val())+1;
				var idEvaluacion=document.querySelector('input[name="nombreEncuesta"]:checked').value;
				var nombre=$("#nombreEncuesta").val();
				var fechaFin=$("#fechaFin").val();
				document.getElementById('cargando').style.display = 'block';
				$.ajax({
					url : 'AdministradorEvaluaciones',
					data : "accion=GeneraEncuestas&numEncuestas="+numEncuestas+"&idEvaluacion="+idEvaluacion+"&nombre="+nombre+"&fechaFin="+fechaFin,
					type : 'POST',
					dataType : 'Json',
					success : function(respuesta) {
						//console.log("HOla: " + JSON.stringify(respuesta) );
						if(respuesta[0].valida){
							alert("Encuesta agregada");
							rutinaInicioEvaluaciones();
							$('#modalEva').modal('hide');
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
		}else{
			alert("NO SE INGRESO UN NOMBRE");
		}
	}else{
		alert("NO SE SELECCIONO NINGUN OPCION");
	}
}