var array=null;
function rutinaInicioEvaluaciones() {
	$("#menu-evaluacion").removeClass("Opc-Menu");
	$("#menu-evaluacion").addClass("Opc-Menu-Activo");
	consultarEvaluaciones();
}
function consultarEvaluaciones(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'EvaluacionesServlet',
		data : "accion=Cargar",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + (respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					cargaTablaEvaluaciones(respuesta);
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
                window.location.href='/EncuestasEmpleados/';
            }
            else
                alert('Error al consultar evaluaciones en el sistema.')
        }
	});
}

function cargaEvaluaciones(json, n){
	document.getElementById('header').style.display = 'none';
	document.getElementById('tablaEvaluaciones').style.display = 'none';
	document.getElementById('divEvaluaciones').style.display = 'block';
	document.getElementById('navEvaluacion').style.display = 'block';
	var perfil;
	if(json.idPerfil[n]==1){
		perfil="JEFE INMEDIATO";
	}else if(json.idPerfil[n]==2){
		perfil="SUBORDINADO";
	}else if(json.idPerfil[n]==3){
		perfil="COLEGA";
	}else if(json.idPerfil[n]==4){
		perfil="CLIENTE";
	}else if(json.idPerfil[n]==5){
		perfil="AUTOEVALUACION";
	}	
	var contenido2="";	
	$('#navEvaluacion').empty();
	contenido2+="<div class='encabezado'><div id='divInstrucciones' class='text-center'>"
	+"<h3 style='text-align:center; color:white;'>Evaluaci\u00F3n 360\u00B0</h3>"
	+"<h5>El objetivo de esta evaluaci\u00F3n es conocer su opini\u00F3n sobre la persona que evaluar\u00E1 y que contribuya  a un mejor desempe\u00F1o.<b> Esta evaluaci\u00F3n es totalmente an\u00F3nima y confidencial, por lo que le pedimos sea lo m\u00E1s objetivo y sincero en su evaluaci\u00F3n.</b></h5>" +
			"<div id='evalua'><h5 style='display:flex; text-align:center;' ><p style='text-decoration: underline 2px;'>Evalua a: </p><p>"+json.nombreCompleto[n]+"</p><p style='text-decoration: underline 2px;'> como su: </p><p>"+perfil+"</p></h5></div>"
	+"<h5>Instrucciones: Lea cuidadosamente cada competencia y seleccione una calificaci\u00F3n que mejor describa al Evaluado,  d\u00F3nde 5 es el m\u00E1s alto y 1 el m\u00E1s bajo, de acuerdo a la siguiente escala.  Si la calificaci\u00F3n es 1 o  2 favor de justificar con un breve comentario.</h5>"
	+" </div></div>"
			  +"<div id='opciones' class='container text-light'><div id='regresar'><button  class='btn btn-warning' onclick='regresar();'>Regresar</button></div><div class='numero'>"
			  +"<p class='rounded' style='background-color: #008000;'>SIEMPRE<br><br>5</p>" +
			  "<p class='rounded' style='background-color: #0080ff;'>CASI SIEMPRE<br>4</p>" +
			  "<p class='rounded' style='background-color: #eae415; color: black;'>A VECES<br>3</p>" +
			  "<p class='rounded' style='background-color: #ff80ff;'>CASI NUNCA<br>2</p>" +
			  "<p class='rounded' style='background-color: #ff0b11;'>NUNCA<br><br>1</p>"
			 +"</div>"
			 +" </div>";
	$('#navEvaluacion').append(contenido2);
	$('#divEvaluaciones').empty();
	$("#tablaEvaluaciones").empty();
	console.log(JSON.stringify(json));
	//console.log(n);
	var temp=0;
	var checa="";
	var j=0;
	var m=0;
	var verifica='"block"';
	var verifica2='"none"';
	let contenido="";
	let nombre=json.nombreCompleto[n].replace(/ /g, "");
					contenido+="<input type='hidden' id='idEncuesta' value='"+json.idEncuesta[0]+"'> <input type='hidden' id='idTipoEncuesta' value='"+json.idTipoEncuesta+"'><input type='hidden' id='nombre' value='"+nombre+"'><input type='hidden' id='idEmpleadoev' value='"+json.idEmpleadoev[n]+"'>" +
							"<input type='hidden'id='consecutivoPregunta' value='"+json.consecutivoPregunta+"'>" +
									"" +
											"" +
											"<br>";
					contenido+="<div class='card'>"
						  +"<div class='card-header competencias bg-azul'>" +
						  		"<div id='tituloCompetencia'>"
						   +"<h6>COMPETENCIAS</h6>"
						+"</div>" 
						+"<div id='opciones'><p>5</p><p>4</p><p>3</p><p>2</p><p>1</p></div>"
						  +"</div>"
						  +"<div class='card-body'><form>";
				for(let p=0;p<json.consecutivoPregunta-3;p++){
					contenido+="<div class='form-evaluacion'><label id='pregunta' for='exampleFormControlInput1' class=''>"+(p+1)+". "+(json.pregunta[p])+"</label>" +
							"<input type='hidden' id='idPregunta"+p+"' value='"+json.idPregunta[p]+"'>"
					+"<div id='radiosEvaluaciones'>"
					switch(json.resultado[n].respuesta[p]){
					case '0':	
						contenido+="<div class='radios'>"
						+"<input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio5' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='5'><br>"
						+"</div> <div class='radios'>"
						+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio4' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='4'><br>"
						+"</div> <div class='radios'>"
						+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio3' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='3'><br>"
						+"</div> <div class='radios'>"
						+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio2' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='2'><br>"
						+"</div> <div class='radios'>"
						+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio1' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='1'><br>";
					break;
					case '1':	
						contenido+="<div class='radios'>"
						+"<input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio5' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='5'><br>"
						+"</div> <div class='radios'>"
						+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio4' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='4'><br>"
						+"</div> <div class='radios'>"
						+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio3' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='3'><br>"
						+"</div> <div class='radios'>"
						+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio2' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='2'><br>"
						+"</div> <div class='radios'>"
						+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio1' checked type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='1'><br>";
					break;
					case '2':	
						contenido+="<div class='radios'>"
						+"<input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio5' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='5'><br>"
						+"</div> <div class='radios'>"
						+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio4' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='4'><br>"
						+"</div> <div class='radios'>"
						+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio3' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='3'><br>"
						+"</div> <div class='radios'>"
						+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio2' checked type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='2'><br>"
						+"</div> <div class='radios'>"
						+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio1' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='1'><br>";
					break;
					case '3':	
						contenido+="<div class='radios'>"
						+"<input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio5' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='5'><br>"
						+"</div> <div class='radios'>"
						+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio4' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='4'><br>"
						+"</div> <div class='radios'>"
						+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio3' checked type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='3'><br>"
						+"</div> <div class='radios'>"
						+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio2' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='2'><br>"
						+"</div> <div class='radios'>"
						+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio1'  type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='1'><br>";
					break;
					case '4':	
						contenido+="<div class='radios'>"
						+"<input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio5' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='5'><br>"
						+"</div> <div class='radios'>"
						+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio4' checked type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='4'><br>"
						+"</div> <div class='radios'>"
						+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio3' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='3'><br>"
						+"</div> <div class='radios'>"
						+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio2' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='2'><br>"
						+"</div> <div class='radios'>"
						+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio1' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='1'><br>";
					break;
					case '5':	
						contenido+="<div class='radios'>"
						+"<input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio5' checked type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='5'><br>"
						+"</div> <div class='radios'>"
						+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio4' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='4'><br>"
						+"</div> <div class='radios'>"
						+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio3' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='3'><br>"
						+"</div> <div class='radios'>"
						+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio2' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='2'><br>"
						+"</div> <div class='radios'>"
						+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio1' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='1'><br>";
					break;
						default:
							contenido+="<div class='radios'>"
								+"<input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio5' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='5'><br>"
								+"</div> <div class='radios'>"
								+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio4' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='4'><br>"
								+"</div> <div class='radios'>"
								+" <input onchange='muestratxt("+("div"+nombre+p)+","+verifica2+","+p+")' class='radio radio3' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='3'><br>"
								+"</div> <div class='radios'>"
								+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio2' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='2'><br>"
								+"</div> <div class='radios'>"
								+" <input onclick='muestratxt("+("div"+nombre+p)+","+verifica+","+p+")' class='radio radio1' type='radio' name='"+nombre+p+"' id='"+nombre+p+"' value='1'><br>";
						
						break;
					};
					if(json.resultado[n].respuesta[p]==1||json.resultado[n].respuesta[p]==2){
					contenido+="</div></div></div><div id='div"+nombre+p+"' style='width:100%; display:block;text-align: center;'><br>"
					+"<label  class='form-label'>Favor de justificar con un breve comentario.</label><br>"
					+"<textarea onchange='actualizaDatos("+p+")'id='txt"+nombre+p+"' style='margin-left:6px;resize: none; width:100%;' >"+json.resultado[n].comentarios[p]+"</textarea>"
					+"</div>";
					}else{
						contenido+="</div></div></div><div id='div"+nombre+p+"' style='width:100%; display:none;text-align: center;'><br>"
						+"<label  class='form-label'>Favor de justificar con un breve comentario.</label><br>"
						+"<textarea onchange='actualizaDatos("+p+")'id='txt"+nombre+p+"' style='margin-left:6px;resize: none; width:100%;' ></textarea>"
						+"</div>";
					}
					if(p!=json.consecutivoPregunta-4){
						contenido+="<hr width='100%'/>";	
					}
				}
				contenido+="</form></div>"
					+"</div>" +
							"</div><br>";
				contenido+="<h3>Preguntas Abiertas</h3><h5>Responde a las siguientes preguntas abiertas.</h5><br>";
			var	i=1;
			for(let p=json.consecutivoPregunta-3;p<json.consecutivoPregunta;p++){
				contenido+="<input type='hidden' id='idPregunta"+p+"' value='"+json.idPregunta[p]+"'>";
					contenido+="<div class='bg-azul rounded-top' style='color:white;width: 100%;padding: 3px; '>" +
					"<p style='margin:10px;'>"+(p+1)+". "+(json.pregunta[p])+"</p></div>" +
					"<textarea style='resize:none; width:100%;' onchange='actualizaDatos("+p+")' class='rounded-bottom' id='txt"+nombre+p+"' rows='5'>"+json.resultado[n].comentarios[p]+"</textarea><br><br></div>";
				i++;
			}
			
			contenido+="<button onclick='msjSalida();' style='color:white;width: 100%;padding: 10px;'  class='rounded bg-success'>Finalizar Encuesta</button><br><br><br><br>";
	$("#divEvaluaciones").append(contenido);
}

function cargaTablaEvaluaciones(json){
	console.log(JSON.stringify(json));
	e=0;
	var porcentaje;
	var today = new Date();
	var dd = String(today.getDate()).padStart(2, '0');
	var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
	var yyyy = today.getFullYear();
	today = yyyy + '-' + mm + '-' + dd;
	contenido="<h5 class='text-center bg-azul text-light'>Encuestas 360</h5>";
	contenido+="<table id='evaluaciones' class='table table-hover table-bordered'>";
		contenido+="<thead class='table-primary'><tr><th scope='col' class='text-center'>Nombre</th><th scope='col' class='text-center'>Puesto</th><th scope='col' class='text-center'>Relacion</th><th scope='col' class='text-center'>Estatus</th><th scope='col' class='text-center'>Fecha inicio</th>" +
				"<th scope='col' class='text-center'>Fecha fin</th><th scope='col' class='text-center'>Progreso</th><th scope='col' style='display:none;' class='text-center'></th></tr></thead><tbody>";
		for(let i=0; i < json[0].listEvaluaciones.length; i++){
			for(let n=0;n<json[0].listEvaluaciones[i].nombreCompleto.length;n++){
				
				if(json[0].listEvaluaciones[i].vigenciaFin[n]>=today&&(json[0].listEvaluaciones[i].estatus[n]!="TERMINADA")){
					contenido+="<tr class='click' onclick='cargaEvaluaciones("+JSON.stringify(json[0].listEvaluaciones[i])+","+n+");'>";
				}else{
					if(json[0].listEvaluaciones[i].vigenciaFin[n]<today&&json[0].listEvaluaciones[i].vigenciaFin[n]!=today){
						contenido+="<tr style='background: #edc7e0;' class='click'>";
					}else{
						contenido+="<tr class='click'>";
					}
				}
				contenido+="<td  class='text-center' 	style='padding: 40px 0 0 0;'>"+json[0].listEvaluaciones[i].nombreCompleto[n]+"</td><td class='text-center' style='padding: 40px 0 0 0;'>"+json[0].listEvaluaciones[i].puesto[n]+"</td>" +
				"<td class='text-center' style='padding: 40px 0 0 0;'>"+json[0].listEvaluaciones[i].relacion[n]+"</td>";
				if(json[0].listEvaluaciones[i].estatus[n]=="TERMINADA"){
					contenido+="<td class='text-center' id='estatus"+e+"' style='background:#72c453; color:white; padding: 40px 0 0 0;' class='text-center'>";
				}else if(json[0].listEvaluaciones[i].estatus[n]=="NO INICIADA"){
					contenido+="<td  class='text-center'' id='estatus"+e+"' style='background:#ff4040; color:white; padding: 40px 0 0 0;' class='text-center'>";
				}else if(json[0].listEvaluaciones[i].estatus[n]=="EN PROCESO"){
					contenido+="<td  class='text-center' id='estatus"+e+"' style='background:#FFF700; padding: 40px 0 0 0;' class='text-center'>";
				}
				porcentaje=(json[0].listEvaluaciones[i].porcentaje[n]*100)/json[0].listEvaluaciones[i].consecutivoPregunta;
					contenido+=json[0].listEvaluaciones[i].estatus[n]+"</td><td  style='padding: 40px 0 0 0;' class='text-center'>" +
				json[0].listEvaluaciones[i].vigenciaInicio[n]+"</td><td class='text-center' style='padding: 40px 0 0 0;'>" +
				json[0].listEvaluaciones[i].vigenciaFin[n]+"</td>" +
						"<td class='text-center'>"+"<div class='progress'>"
						  +"<div class='progress-bar progress-bar-striped bg-success' role='progressbar' aria-label='Success example' style='width:"+porcentaje.toFixed(1)+"%' aria-valuenow='25' aria-valuemin='0' aria-valuemax='100'></div>"
						  +"</div><p>"+porcentaje.toFixed(1)+"%</p><p>"+json[0].listEvaluaciones[i].porcentaje[n]+"/"+json[0].listEvaluaciones[i].consecutivoPregunta+"</p></td>"
						+"<td style='display:none;'>"+json[0].listEvaluaciones[i].idPerfil[n]+"</td></tr>";
				e++;
			}
		}
		contenido+="</tbody></table>";
	$("#tablaEvaluaciones").append(contenido);
	var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
	 
	  table = document.getElementById("evaluaciones");
	  switching = true;
	  //Set the sorting direction to ascending:
	  dir = "asc";
	 
	  /*Make a loop that will continue until no switching has been done:*/
	  while (switching) {
	    //start by saying: no switching is done:
	    switching = false;
	    rows = table.rows;
	    /*Loop through all table rows (except the first, which contains table headers):*/
	    for (i = 1; i < (rows.length - 1); i++) {
	      //start by saying there should be no switching:
	      shouldSwitch = false;
	      /*Get the two elements you want to compare, one from current row and one from the next:*/
	      x = rows[i].getElementsByTagName("td")[7];
	      y = rows[i + 1].getElementsByTagName("td")[7];
	      /*check if the two rows should switch place, based on the direction, asc or desc:*/
	      if (dir == "asc") {
	        if ((parseFloat(x.innerHTML) > parseFloat(y.innerHTML))) {
	          //if so, mark as a switch and break the loop:
	          shouldSwitch= true;
	          break;
	        }
	      } else if (dir == "desc") {
	        if ((parseFloat(x.innerHTML) < parseFloat(y.innerHTML))) {
	          //if so, mark as a switch and break the loop:
	          shouldSwitch = true;
	          break;
	        }
	      }
	    }
	    if (shouldSwitch) {
	      /*If a switch has been marked, make the switch and mark that a switch has been done:*/
	      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
	      switching = true;
	      //Each time a switch is done, increase this count by 1:
	      switchcount ++;
	    } else {
	      /*If no switching has been done AND the direction is "asc", set the direction to "desc" and run the while loop again.*/
	      if (switchcount == 0 && dir == "asc") {
	        dir = "desc";
	        switching = true;
	      }
	    }
	  }
	
}

function muestratxt(nombre, estado, p){
	nombre.style.display = estado;
	actualizaDatos(p);
	actualizaEstatus(1,"");
}
function actualizaDatos(p){
	var resultado;
	if((document.querySelector('input[name="'+($("#nombre").val()+p)+'"]:checked'))==null){
		resultado=0;
	}else{
		resultado=document.querySelector('input[name="'+($("#nombre").val()+p)+'"]:checked').value
	}
	var idEncuesta=$("#idEncuesta").val();
	//alert(idEncuesta);
	//alert($("#txt"+$("#nombre").val()+p).val());
	var data = "accion=Actualizar&idPregunta="+$("#idPregunta"+p).val()+"&idEmpleadoev="+$("#idEmpleadoev").val()+"&comentarios="+ponerTilde($("#txt"+$("#nombre").val()+p).val())+"&resultado="+resultado+"&idEncuesta="+idEncuesta;
	//alert(data);
	$.ajax({
	url : 'EvaluacionesServlet',
	data : data,
	type : 'POST',
	dataType : 'Json',
		success : function(respuesta) {
			if (respuesta) {
				var data = respuesta;
				if (data.length > 0) {
				console.log(respuesta);
					
				}
				} else {
					document.getElementById('cargando').style.display = 'none';
			}
		},
		error : function(xhr, status, error)
        {
            document.getElementById('cargando').style.display = 'none';
            if (xhr.status === 200)
            {
                alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
                window.location.href='/EncuestasEmpleados/';
            }
            else
                alert('Error al actualizar la respuesta.')
        }
		});
	
	

}
function msjSalida(){
	$('#exampleModal').modal('show');
}

function guardaPreguntas(validaResultados){
	$('#exampleModal').modal('hide');			
	var totalPreguntas=$("#consecutivoPregunta").val();
	var nombre=$('#nombre').val();
	
	
	var array=[];
	for(var i=0;i<totalPreguntas-3;i++){
		if((document.querySelector('input[name="'+($("#nombre").val()+i)+'"]:checked'))==null){
			array+=(i+1)+" ";
		}
	}
	for(var i=totalPreguntas-3;i<totalPreguntas;i++){
		if($("#txt"+$("#nombre").val()+i).val()==""||$("#txt"+$("#nombre").val()+i).val()==undefined){
			$("#txt"+$("#nombre").val()+i).val(" ");
			actualizaDatos(i);
		}
	}
	if(array.length<=0){
		if(validaResultados){
			actualizaEstatus(2,"Inicio");
			fechaFin();
			validaResultados=false;
		 }else{
			 alert("No se han contestado todas las preguntas");
			 location.reload();
		 }
	}else{
	$("#msjError").append("Aun no contestas las preguntas: "+array);
	$("#errorModal").modal('show');
	}
}

function actualizaEstatus(estatus,opcion){
	//document.getElementById('cargando').style.display = 'block';
	//alert($("#txt"+$("#nombre").val()+p).val());
	//alert(estatus);
	var data = "accion=ActualizarEncuesta&estatus="+estatus+"&idEmpleadoev="+$("#idEmpleadoev").val();
	//alert(data);
	$.ajax({
	url : 'EvaluacionesServlet',
	data : data,
	type : 'POST',
	dataType : 'Json',
		success : function(respuesta) {
			if (respuesta) {
				var data = respuesta;
				if (data.length > 0) {
				console.log(respuesta);
					if(opcion=="Inicio"){
						window.location.href = "/EncuestasEmpleados/EvaluacionesServlet?accion=Inicio";
						document.getElementById('cargando').style.display = 'block';
					}
					document.getElementById('cargando').style.display = 'none';
				}
				} else {
					document.getElementById('cargando').style.display = 'none';
			}
		},
		error : function(xhr, status, error)
        {
            document.getElementById('cargando').style.display = 'none';
            if (xhr.status === 200)
            {
                alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
                window.location.href='/EncuestasEmpleados/';
            }
            else
                alert('Error al actualizar estatus.')
        }
		});
}
function regresar(){
	document.getElementById('header').style.display = 'block';
	document.getElementById('tablaEvaluaciones').style.display = 'block';
	document.getElementById('divEvaluaciones').style.display = 'none';
	document.getElementById('navEvaluacion').style.display = 'none';
	rutinaInicioEvaluaciones();
}
function checaRespuestas(){
	var idTipoEncuesta=$("#idTipoEncuesta").val();
	var idEvaluado=$("#idEmpleadoev").val();
	var idEvaluador=$("#idEvaluador").val();
	var data = "accion=ValidaRespuestas&idTipoEncuesta="+idTipoEncuesta+"&idEvaluado="+idEvaluado+"&idEvaluador="+idEvaluador;
	$.ajax({
		url : 'EvaluacionesServlet',
		data : data,
		type : 'POST',
		dataType : 'JSON',
			success : function(respuesta) {
				guardaPreguntas(respuesta[0].respuesta);
			},
			error : function(xhr, status, error)
	        {
	            document.getElementById('cargando').style.display = 'none';
	            if (xhr.status === 200)
	            {
	                alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
	                window.location.href='/EncuestasEmpleados/';
	            }
	            else
	                alert('Error al actualizar estatus.')
	        }
	});
	
}
function ponerTilde(palabra){
	var letras=["a1","A2","e1","E2","i1","I2","o1","O2","u1","U2","n1","N2"];
	var codigo=["\u00e1","\u00c1","\u00e9","\u00c9","\u00ed","\u00cd","\u00f3","\u00d3","\u00fa","\u00da","\u00f1","\u00d1"];
	for (var i = 0; i < codigo.length; i++) {
			for(var p=0;p< palabra.length;p++){
				palabra=palabra.replace(codigo[i],letras[i]);
			}
		   }
	   alert(palabra)
	return palabra;
} 