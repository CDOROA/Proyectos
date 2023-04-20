
/*** CONSULTA VACANTES EXISTENTES ***/
function consultaVacantes(cve_edo)
{	
	OcultarDiv('divMjsErrorBolsaTrabajo');
	if(cve_edo= '9'){
		cve_edo = $("#cboBolsaTrabajoEstado").val();
	}	
	
	$.ajax({
	    url :'BolsaDeTrabajo', 
	    data : "vista=PaginaPrincipal.jsp&operacion=ConsultaVacantesxEdo" +"&cve_edo=" + cve_edo, 
	    type : 'POST',
	    dataType : 'Json',
	    success : function(jsonVacantes)
	    { 
	    	if( jsonVacantes.length > 0)
        	{
	    		MostrarDiv('divVacantesDisponibles')
	    		llenarDivVacantesDisponibles(jsonVacantes);
        	}
	    	else
	    	{
	    		OcultarDiv('divVacantesDisponibles')
	    		MostrarDiv('divMjsErrorBolsaTrabajo');	
	    	}
		},
		error : function(xhr, status, error)
		{
			alert('Error al consultar vacantes')			
		}
	});
}

function llenarDivVacantesDisponibles(jsonVacantes) 
{
	$('#divVacantesDisponibles').empty();
	let contenido="<div class='row' style='padding: 0px; margin: 0; text-align: center;background-color: #F5F5F5;'>";
	let item=1;
	
	for(let i=0; i < jsonVacantes.length ; i++)
	{
		if(item > 3)
		{
			contenido += "</div><div style='height: 20px; background-color: white'></div>";			
			contenido += "<div class='row' style='padding: 0px; margin: 0; text-align: center;background-color: #F5F5F5;'>";
			item =1;
		}
		contenido += "<div class=' col-xs-12 col-sm-12 col-md-4 col-lg-4' style='padding:15px;padding-top:0px; padding-bottom:0px; border-right:10px solid white;'>"+
							
							" <img src=\"images/vacantes.png\"  style='position: absolute;bottom:40%;left:5%' ></img> "+
							"<table style='text-align:center;' width=95% align=center>"+
							
							"<tr><td  align='center'  rowspan='5' valign='top' width:100px> "+
								"<label style='color:#F4F4F4'>Vacante Disponible</label>"+
							"</td></tr>"+
							
							"<tr><td   align='center'> <label class='EPP_lb_size_15' style='font-weight: bold; color:#004085; padding-top:10px' > "+ jsonVacantes[i].nombre_puesto + " </label> </td></tr>"+
							"<tr>"+
								"<td   align='justify'>"+
									"<label class='EPP_lb_size_12' style='font-weight: normal; color:black; text-align: justify;' >"+
										jsonVacantes[i].descripcion_vacantes.toUpperCase() + 
									"</label>"+
								"</td>"+
							"</tr>"+
							"<tr>"+
							"<td  align='left'>"+
								"<label  class='EPP_lb_size_12' style='font-weight: bold; color:#004085'>OBSERVACIONES:&nbsp;</label>"+
								"<label class='EPP_lb_size_12' style='font-weight: normal; color:black'> "+jsonVacantes[i].observaciones.toUpperCase() + "</label>"+
							"</td>"+
							"</tr>"+
							"<tr>"+
								"<td  align='left'>"+
									"<label  class='EPP_lb_size_12' style='font-weight: bold; color:#004085'>HORARIO:&nbsp;</label>"+
									"<label class='EPP_lb_size_12' style='font-weight: normal; color:black'> "+jsonVacantes[i].horario_vacante.toUpperCase() + "</label>"+
								"</td>"+
							"</tr>"+
							"<tr><td> </td>"+
								"<td align='left'>"+
									"<label  class='EPP_lb_size_12' style='font-weight: bold; color:#004085'>LUGAR DE TRABAJO:&nbsp;</label>	"+												
									"<label class='EPP_lb_size_12' style='font-weight: normal; color:black'>"+jsonVacantes[i].lugar_trabajo + "</label>"+
								"</td>	"+				
							"</tr>"+
						"</table>	"+		
						"<button class='btn btn-primary' onclick=\"mostrarFormularioPostulate(" + jsonVacantes[i].cve_vacante   +"," +jsonVacantes[i].cve_empresa + ", '" + jsonVacantes[i].nombre_puesto  +"' )\" style='position: absolute;right:10px;bottom:5px;'>Postularse</button>"+
					"</div>";
		item++;
	}
	if(item < 3)
	{
		contenido += "</div><div style='height: 20px; background-color: white'></div>";		
	} 
	$("#divVacantesDisponibles").append(contenido);
}


/*** MODULO DE POSTULATE ***/
function mostrarFormularioPostulate(cve_vacante, empresa, vacante)
{
	$("#txt_num_vacantePostulate").text(cve_vacante)
	$("#txt_num_empresaPostulate").text(empresa)
	$("#txt_nom_vacantePostulate").text(vacante)
	OcultarDiv('divMjsErrorPostulate');
	MostrarDiv('divFormularioPostulate');
	OcultarDiv('divMjsExitoPostulate');	
	OcultarDiv('divAdjuntaCVPostulate');
	limpiarDatosPostulate();
}

function limpiarDatosPostulate()
{
	$("#txtNombrePostulate").val("")
	$("#txtApellidoPPostulate").val("")
	$("#txtApellidoMPostulate").val("")
	$("#txtEmailPostulate").val("")
	$("#txtEdadPostulate").val("")
	$("#txtTelefonoPostulate").val("") 
	$("#cboNivelAcademicoPostulate").val("0") 
	$("#cboEstadoPostulate").val("0")
}

/*** ALTA DE ASPIRANTES ***/
function altaAspirantes()
{	
	document.getElementById('cargando').style.display = 'block';
	OcultarDiv('divMjsErrorPostulate');
	OcultarDiv('divMjsExitoPostulate');	
	let msjAlerta = validarDatosDeAspirante();
	
	if(msjAlerta == "")
	{
		let nombre = $("#txtNombrePostulate").val()
		let a_paterno = $("#txtApellidoPPostulate").val()
		let a_materno = $("#txtApellidoMPostulate").val()
		let e_mail = $("#txtEmailPostulate").val()
		let edad = $("#txtEdadPostulate").val()
		let telefono = $("#txtTelefonoPostulate").val() 
		let id_nivel_ac = $("#cboNivelAcademicoPostulate").val() 
		let id_cve_edo= $("#cboEstadoPostulate").val()	
		let id_cve_empresa= $("#txt_num_empresaPostulate").text()
		let id_vacante= $("#txt_num_vacantePostulate").text()	
		let nombreVacante =$("#txt_nom_vacantePostulate").text()					
		let nivelAcademico=$("#cboNivelAcademicoPostulate option:selected").text();
		let estado= $("#cboEstadoPostulate option:selected").text();
		
		let genero= "M";
		if($('#cboGeneroPostulateF').is(':checked'))
		{ 
			genero= "F";
		}
		
		 let fd = new FormData();
	     let files = $('#file')[0].files[0];
	     fd.append('file',files);
		
		$.ajax({
		    url :'BolsaDeTrabajo', 
		    data :  ponerTilde("vista=PaginaPrincipal.jsp&operacion=AltaAspirante" +"&nombre=" + nombre +"&a_paterno=" + a_paterno + "&a_materno=" + a_materno + 
				    "&e_mail=" + e_mail + "&edad=" + edad + "&telefono=" + telefono + "&genero=" + genero + "&id_nivel_ac=" + id_nivel_ac+ "&id_cve_edo=" + id_cve_edo  +
				    "&id_cve_empresa=" + id_cve_empresa + "&id_vacante=" + id_vacante  + "&nombreVacante=" + nombreVacante + "&nivelAcademico=" + nivelAcademico + "&estado=" + estado), 
		    type : 'POST',
		    dataType : 'Text',
		    success : function(respuesta)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if( respuesta == "true")
	        	{
		    		limpiarDatosPostulate();
		    		OcultarDiv('divRegistratePostulate')
		    		MostrarDiv('divAdjuntaCVPostulate')		    		
	        	}
		    	else
		    	{
		    		$('#lbErrorPostulate').text("Al enviar la informacion.")
		    		MostrarDiv('divMjsErrorPostulate');
		    		OcultarDiv('divMjsExitoPostulate');	
		    	}
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				alert('Error al enviar aspirantes')			
			}
		});
	}
	else
	{
		document.getElementById('cargando').style.display = 'none';
		if(msjAlerta == "Email")
		{
			$('#lbErrorPostulate').text(" La direcci\u00F3n de email no es valida.")
		}
		else
		{
			$('#lbErrorPostulate').text(" El campo  de  " + msjAlerta +  " no puede quedar vacio.")
		}
		MostrarDiv('divMjsErrorPostulate');
		OcultarDiv('divMjsExitoPostulate');	
	}
	
}

function validarDatosDeAspirante()
{
	if($("#txtNombrePostulate").val() == "")
	{
		return "Nombre";
	}
	
	if($("#txtApellidoPPostulate").val() == "")
	{
		return "Apellido Paterno";
	}
	
	if($("#txtApellidoMPostulate").val() == "")
	{
		return "Apellido Materno";
	}
	
	if($("#txtEmailPostulate").val() == "")
	{
		return "Email";
	}
	else
	{
		if(validarEstructuraEmail($("#txtEmailPostulate").val()) == false)
		{
			return "Email";
		}	
	}
	
	if($("#txtEdadPostulate").val() == "")
	{
		return "Edad";
	}
	
	if($("#txtTelefonoPostulate").val() == "")
	{
		return "Telefono";
	}
		
	if($("#cboNivelAcademicoPostulate").val() == "0")
	{
		return "Nivel Academico";
	}
	
	if($("#cboEstadoPostulate").val() == "0")
	{
		return "Estado";
	}
	return "";
}

function cargaArchivoCVAspirante()
{
	alert("Gracias por querer ser parte de nuestro equipo nos pondremos en contacto contigo.");
}

function ponerTilde(palabra){
	var letras=["a1","A2","e1","E2","i1","I2","o1","O2","u1","U2","n1","N2"];
	var codigo=["\u00e1","\u00c1","\u00e9","\u00c9","\u00ed","\u00cd","\u00f3","\u00d3","\u00fa","\u00da","\u00f1","\u00d1"];
	for (var i = 0; i <= codigo.length; i++) {
		   palabra=palabra.replaceAll(codigo[i],letras[i]);
		}
	return palabra;
}







