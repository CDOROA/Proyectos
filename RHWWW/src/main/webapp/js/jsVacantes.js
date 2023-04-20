function RutinaInicioVacantes() {
	$("#menu-evaluacion").removeClass("Opc-Menu");
	$("#menu-evaluacion").addClass("Opc-Menu-Activo");

	ConsultaInformacion();
}

function ConsultaInformacion() {
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministadorVacantes',
		data : "accion=Cargar",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					CargarInformcionVacantes(respuesta);
					document.getElementById('cargando').style.display = 'none';

				}
			} else
				document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error) {
			mostrarMsjError("No se pudo cargar los registros. Intentelo nuevamente.")
			document.getElementById('cargando').style.display = 'none';
		}
	});
}

function CargarInformcionVacantes(json) {
	var data = json;
	// alert("data: " + JSON.stringify( data));
	var vac = data[0];
	var Vacantes = vac.listaVacantes;

	/* Calculando el largo de Divs */
	var heightDivs = CalculaHeigthDivs();

	// alert("Vacantes: " + Vacantes);
	var db = {

		loadData : function(filter) {
			return $.grep(Vacantes, function(client) {
				//alert(Vacantes);
				return (!filter.nombrePuesto.toUpperCase()|| client.nombrePuesto.toUpperCase() === filter.nombrePuesto.toUpperCase() || client.nombrePuesto.toUpperCase() == filter.nombrePuesto.toUpperCase() || client.nombrePuesto.toUpperCase().includes(filter.nombrePuesto.toUpperCase()))
			                     && (!filter.descripcionVacante.toUpperCase()|| client.descripcionVacante.toUpperCase() === filter.descripcionVacante.toUpperCase() || client.descripcionVacante.toUpperCase() == filter.descripcionVacante.toUpperCase() || client.descripcionVacante.toUpperCase().includes(filter.descripcionVacante.toUpperCase()))
			                     && (!filter.fechaPublicacion.toUpperCase()|| client.fechaPublicacion.toUpperCase() === filter.fechaPublicacion.toUpperCase() || client.fechaPublicacion.toUpperCase() == filter.fechaPublicacion.toUpperCase()|| client.fechaPublicacion.toUpperCase().includes(filter.fechaPublicacion.toUpperCase()))
			                     && (!filter.lugarTrabajo.toUpperCase()|| client.lugarTrabajo.toUpperCase() === filter.lugarTrabajo.toUpperCase() || client.lugarTrabajo.toUpperCase() == filter.lugarTrabajo.toUpperCase()|| client.lugarTrabajo.toUpperCase().includes(filter.lugarTrabajo.toUpperCase()))
			                     && (!filter.horarioVacante.toUpperCase()|| client.horarioVacante.toUpperCase() === filter.horarioVacante.toUpperCase() || client.horarioVacante.toUpperCase() == filter.horarioVacante.toUpperCase()|| client.horarioVacante.toUpperCase().includes(filter.horarioVacante.toUpperCase()))

			});
		}
	}
	window.db = db;
	db.data;
	$(function() {
		$("#divTablaVacantes")
				.jsGrid(
						{
							height : heightDivs+"px",
							width : "1880px",
							filtering : true,
							editing : false,
							sorting : false,
							paging : false,
							
							noDataContent: "No se encontrar\u00f3n registros.",
							controller : {
								loadData : function() {
									dataType: "json"
									return Vacantes;
								}
							},
							rowClass : function(item, itemIndex) // item is
							// the data
							// in a row,
							// index is
							// the row
							// number.
							{
								if ((item.estatus == "1")) {
									return "bg-rechazado";
								}
							},
							autoload : true,
							controller : db,
							fields : [
									{
										name : "nombrePuesto",
										type : "text",
										title : "VACANTE",
										width : 15,
										align : 'center',
										css : "labelfor"
									},
									{
										name : "descripcionVacante",
										type : "text",
										title : "DESCRIPCI\u00D3N",
										width : 100,
										css : "labelfor"
									},
									{
										name : "fechaPublicacion",
										type : "text",
										title : "FECHA DE PUBLICACI\u00D3N",
										align : 'center',
										width : 15,
										css : "labelfor"
									},
									{
										name : "lugarTrabajo",
										type : "text",
										title : "LUGAR DE TRABAJO",
										align : 'center',
										width : 15,
										css : "labelfor"
									},
									{
										name : "horarioVacante",
										type : "text",
										title : "HORARIO",
										align : 'center',
										width : 20,
										css : "labelfor"
									},
									{
										type : "control",
										width : 1,
										editButton : false,
										deleteButton : false,
										itemTemplate : function(value, item) {
											return "<button type='submit'   class='btn btn-outline-info '  id='btnConsultarRegistro' onclick='ConsultaRegistro("
													+ JSON.stringify(item)
													+ ");' >"
													+ "<img  src='Images/btnEditar.png' class='img-fluid centrar' />"
													+ "</button>"
										}
									},

									{
										type : "control",
										width : 1,
										editButton : false,
										deleteButton : false,
										itemTemplate : function(value, item) {
											return "<button type='submit'  class='btn btn-outline-danger'  id='btnConsultarEliminar' onclick='EliminarRegistroVacente("
													+ JSON.stringify(item)
													+ ");' >"
													+ "<img  src='Images/btnBorrar.png' class='img-fluid centrar' />"
													+ "</button>"
										}
									}, ]
						});

	});
}

function CalculaHeigthDivs() {
	var f = window.innerHeight;
	var t = document.getElementById("header").offsetHeight;
	var d = f - (t + 150);
	//	document.getElementById("divCardInformacion").style.height = d + "px";
	//	document.getElementById("mi-mapa").style.height = ((d / 2) - 60) + "px";
	//	document.getElementById("divCarMapa").style.height = (d / 2) + "px";
	//	document.getElementById("divCarFoto").style.height = (d / 2) + "px";

	return d;
}

function ConsultaRegistro(registroVacante) {

	document.getElementById('ImgAdvertencia').style.display = 'none';
	document.getElementById('divBonotesActualizar').style.display = 'block';
	document.getElementById('divConfirmarBaja').style.display = 'none';
	document.getElementById('divBonotesAgregar').style.display = 'none';

	$('#hiddenIDVacante').val(registroVacante.idVacante)
	$('#modalTituloVacante').html(registroVacante.nombrePuesto);
	$('#txtVacanteDescripcion').val(registroVacante.descripcionVacante);
	$('#txtVacanteHorario').val(registroVacante.horarioVacante);
	$('#txtVacanteLugarTrabajo').val(registroVacante.lugarTrabajo);
	$('#txtVacanteObservaciones').val(registroVacante.observaciones);
	$('#txtVacantefechaPublicacion').val(registroVacante.fechaPublicacion);
	$("#cmbVacantePuesto").val(registroVacante.idPuesto);
	$("#cmbVacanteEstatus").val(registroVacante.estatus);
	$("#cmbVacanteEstado").val(registroVacante.idEstado);
	$('#cmbVacanteEmpresa').val(registroVacante.cveEmpresa);

	$('#ModalVacante').modal('show')
}

function ConsultaEliminarRegistro(registroVacante) {

	document.getElementById('ImgAdvertencia').style.display = 'block';
	document.getElementById('divBonotesActualizar').style.display = 'none';
	document.getElementById('divBonotesAgregar').style.display = 'none';
	document.getElementById('divConfirmarBaja').style.display = 'block';

	$('#hiddenIDVacante').val(registroVacante.idVacante)
	$('#modalTituloVacante').html(
			"Esta Seguro de Querer Eliminar la siguiente Vacante:");
	$('#txtVacanteDescripcion').val(registroVacante.descripcionVacante);
	$('#txtVacanteHorario').val(registroVacante.horarioVacante);
	$('#txtVacanteLugarTrabajo').val(registroVacante.lugarTrabajo);
	$('#txtVacanteObservaciones').val(registroVacante.observaciones);
	$('#txtVacantefechaPublicacion').val(registroVacante.fechaPublicacion);
	$("#cmbVacantePuesto").val(registroVacante.idPuesto);
	$("#cmbVacanteEstatus").val(registroVacante.estatus);
	$("#cmbVacanteEstado").val(registroVacante.idEstado);
	$('#cmbVacanteEmpresa').val(registroVacante.cveEmpresa);

	//$('#ModalVacante').modal('show')
}

function LimpiarDatos() {

	document.getElementById('divBonotesActualizar').style.display = 'none';
	document.getElementById('divConfirmarBaja').style.display = 'none';
	document.getElementById('divBonotesAgregar').style.display = 'none';

	$('#hiddenIDVacante').val("")
	$('#modalTituloVacante').html("");
	$('#txtVacanteDescripcion').val("");
	$('#txtVacanteHorario').val("");
	$('#txtVacanteLugarTrabajo').val("");
	$('#txtVacanteObservaciones').val("");
	$('#txtVacantefechaPublicacion').val("");
	$("#cmbVacantePuesto").val(0);
	$("#cmbVacanteEstatus").val(0);
	$("#cmbVacanteEstado").val(0);
	$('#cmbVacanteEmpresa').val(0);

}

function ConfirmarBajaVacante() {
	document.getElementById('divBonotesEliminarActualizar').style.display = 'none';
	document.getElementById('divConfirmarBaja').style.display = 'block';
}

function CancelarEliminarRegistroVacante() {

	$('#ModalVacante').modal('hide')
	LimpiarDatos();
}

function ActualizarDatosVacante() {

	/*
	 alert("Actualiza..."  + $('#hiddenIDVacante').val() +
	 "\nhiddenIDVacante..."  + $('#hiddenIDVacante').val() +
	 "\nmodalTituloVacante..."  + $('#modalTituloVacante').html() + 
	 "\ntxtVacanteDescripcion..."  + $('#txtVacanteDescripcion').val() + 
	 "\ntxtVacanteHorario..."  + $('#txtVacanteHorario').val() +
	 "\ntxtVacanteLugarTrabajo..."  + $('#txtVacanteLugarTrabajo').val()+ 
	 "\ntxtVacanteObservaciones..."  + $('#txtVacanteObservaciones').val()+ 
	 "\ntxtVacantefechaPublicacion..."  + $('#txtVacantefechaPublicacion').val()+ 
	 "\ncmbVacantePuesto..."  + $("#cmbVacantePuesto").val()+
	 "\ncmbVacanteEstatus..."  + $("#cmbVacanteEstatus").val()+
	 "\ncmbVacanteEstado..."  + $("#cmbVacanteEstado").val()+
	 "\ncmbVacanteEmpresa..."  + $('#cmbVacanteEmpresa').val() 	
	 );
	*/
	

	var data = "accion=Actualizar&idVacante=" + $('#hiddenIDVacante').val()
			+ "&idPuesto=" + $("#cmbVacantePuesto").val()
			+ "&descripcionVacante=" + $('#txtVacanteDescripcion').val()
			+ "&horarioVacante=" + $('#txtVacanteHorario').val()
			+ "&lugarTrabajo=" + $('#txtVacanteLugarTrabajo').val()
			+ "&observaciones=" + $('#txtVacanteObservaciones').val()
			+ "&fecha_publicacion=" + $('#txtVacantefechaPublicacion').val()
			+ "&estatusVacante=" + $("#cmbVacanteEstatus").val()
			+ "&estadoVacante=" + $("#cmbVacanteEstado").val() + "&cveEmpresa="
			+ $('#cmbVacanteEmpresa').val() ;
	document.getElementById('cargando').style.display = 'Block';
	
$.ajax({
		url : 'AdministadorVacantes',
		data : ponerTilde(data),
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					ConsultaInformacion();
					document.getElementById('cargando').style.display = 'none';
					$("#lbl_TituloOk").text("Actualizacion Correcta");
					$("#lbl_mensajeOk").text(
							"Se han guardado correctamente los datos.");
					$("#myModalOk").modal();
					$('#ModalVacante').modal('hide');
				}
			} else {
				document.getElementById('cargando').style.display = 'none';
			}
		},
		error : function(xhr, status, error) {
			alert("Error: " + error);
			mostrarMsjError("No se pudo actualizar la vacante, intentelo nuevamente.")
			document.getElementById('cargando').style.display = 'none';
		}
	});

}

function mostrarMsjError(mensaje) {

	$("#lbl_mensajeError").text(mensaje);

	$("#myModalError").modal();
}

function MostrarFormParaCaptura() {
	document.getElementById('ImgAdvertencia').style.display = 'none';
	document.getElementById('divBonotesAgregar').style.display = 'block';
	document.getElementById('divBonotesActualizar').style.display = 'none';
	document.getElementById('divConfirmarBaja').style.display = 'none';

	$('#hiddenIDVacante').val("")
	$('#modalTituloVacante').html("Ingresar Datos de Vacante");
	$('#txtVacanteDescripcion').val("");
	$('#txtVacanteHorario').val("");
	$('#txtVacanteLugarTrabajo').val("");
	$('#txtVacanteObservaciones').val("");
	$('#txtVacantefechaPublicacion').val("");
	$("#cmbVacantePuesto").val(0);
	$("#cmbVacanteEstatus").val("");
	$("#cmbVacanteEstado").val(0);
	$('#cmbVacanteEmpresa').val(0);

	$('#ModalVacante').modal('show')
}

function AgregarNuevaVacante() {

	if (ValidarCampos()) {
		var data = "accion=Agregar&idPuesto=" + $("#cmbVacantePuesto").val()
				+ "&descripcionVacante=" + $('#txtVacanteDescripcion').val()
				+ "&horarioVacante=" + $('#txtVacanteHorario').val()
				+ "&lugarTrabajo=" + $('#txtVacanteLugarTrabajo').val()
				+ "&observaciones=" + $('#txtVacanteObservaciones').val()
				+ "&fecha_publicacion="
				+ $('#txtVacantefechaPublicacion').val() + "&estatusVacante="
				+ $("#cmbVacanteEstatus").val() + "&estadoVacante="
				+ $("#cmbVacanteEstado").val() + "&cveEmpresa="
				+ $('#cmbVacanteEmpresa').val() ;
		data=ponerTilde(data);


document.getElementById('cargando').style.display = 'Block';

$.ajax({
								url : 'AdministadorVacantes',
					data : data,
					type : 'POST',
					dataType : 'Json',
					success : function(respuesta) {

						if (respuesta) {

							var data = respuesta;

							if (data.length > 0) {
								ConsultaInformacion();
								document.getElementById('cargando').style.display = 'none';
								$("#lbl_TituloOk").text(
										"Actualizacion Correcta");
								$("#lbl_mensajeOk")
										.text(
												"Se han guardado correctamente los datos.");
								$("#myModalOk").modal();
								$('#ModalVacante').modal('hide');
							}
						} else {
							document.getElementById('cargando').style.display = 'none';
						}
					},
					error : function(xhr, status, error) {
						alert("Error: " + error);
						mostrarMsjError("No se pudo agregar la  vacante, intentelo nuevamente.")
						//document.getElementById('cargando').style.display = 'none';
					}
				});

	}
}

function ValidarCampos() {

	var Mensaje = "";

	if ($('#cmbVacantePuesto').val() == 0) {
		Mensaje += "Seleccionar el Puesto de la vacante;";

	} else if ($("#txtVacanteDescripcion").val().trim() == "") {
		Mensaje += "\nRedactar la descripcion de la Vacante;";
	} else if ($("#txtVacanteHorario").val().trim() == "") {
		Mensaje += "\nIngresar el horario de de la Vacante;";
	} else if ($("#txtVacanteLugarTrabajo").val().trim() == "") {
		Mensaje += "\nIngresar el Lugar de Trabajo;";
	} else if ($("#cmbVacanteEstado").val() == 0) {
		Mensaje += "\nSeleccionar el Estado de la Republica;";
	} else if ($("#cmbVacanteEmpresa").val() == 0) {
		Mensaje += "\nSeleccionar la empresa para la cual es esta vacante;";
	} else if ($('#txtVacantefechaPublicacion').val().trim() == "") {
		Mensaje += "\nSeleccionar la fecha de Publicacion;";
	} else if ($("#cmbVacanteEstatus").val() == "") {
		Mensaje += "\nSeleccionar si la vacante esta Vigente o No vigente;";
	}

	if (Mensaje.trim() != "") {
		mostrarMsjError(Mensaje);
		return false;
	} else {
		return true;
	}
}

function EliminarRegistroVacente(vacante) {
	var data = "accion=Eliminar&idVacante=" + vacante.idVacante;
	document.getElementById('cargando').style.display = 'Block';

	$.ajax({
		url : 'AdministadorVacantes',
		data : data,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {

			if (respuesta) {

				var data = respuesta;
				if (data.length > 0) {
					$("#myModalOk").modal('show');
					$("#lbl_TituloOk").text("Actualizacion de estatus correcta");
					$("#lbl_mensajeOk").text(
							"Se han guardado correctamente los datos.");
					ConsultaInformacion();
					
				}
				
			} else {
				document.getElementById('cargando').style.display = 'none';
			}
		},
		error : function(xhr, status, error) {
			alert("Error: " + error);
			mostrarMsjError("No se pudo actualizar el Estatus de la vacante, intentelo nuevamente.")
			//document.getElementById('cargando').style.display = 'none';
		}
	});

}
	function ponerTilde(palabra){
		var letras=["a1","A2","e1","E2","i1","I2","o1","O2","u1","U2","n1","N2"];
		var codigo=["\u00e1","\u00c1","\u00e9","\u00c9","\u00ed","\u00cd","\u00f3","\u00d3","\u00fa","\u00da","\u00f1","\u00d1"];
		for (var i = 0; i <= codigo.length; i++) {
			   palabra=palabra.replaceAll(codigo[i],letras[i]);
			}
		return palabra;
	}
	
