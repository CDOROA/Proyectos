function RutinaInicioAspirantes() {
	$("#nemu_Candidatos").removeClass("Opc-Menu");
	$("#nemu_Candidatos").addClass("Opc-Menu-Activo");

	ConsultaInformacionAspirantes();
}


function ConsultaInformacionAspirantes() {
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorAspirantes',
		data : "accion=Cargar",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			 //alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					CargarInformcion(respuesta);
					document.getElementById('cargando').style.display = 'none';

				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error) {
			mostrarMsjError(" al cargar Aspirantes.xhr: " + JSON.stringify(xhr) + "\n status: " + status + "\n error: " + error  )
			document.getElementById('cargando').style.display = 'none';
		}
	});
}

function mostrarMsjError(mensaje) {

	$("#lbl_mensajeError").text(mensaje);

	$("#myModalError").modal();
}

function CargarInformcion(respuesta){
	var data = respuesta;
	
	//alert("data: " + JSON.stringify( data));
	var asp = data[0];
	var aspirantes = asp.listaAspirantes;
	/* Calculando el largo de Divs */
	var heightDivs = CalculaHeigthDivs();
	var db = {
			
			 loadData: function (filter)/** seccion de filtros **/
			    {
			    	
			    	return $.grep(aspirantes, function (client) {
			            return     (!filter.descriocionNivelEstudios.toUpperCase()|| client.descriocionNivelEstudios.toUpperCase() === filter.descriocionNivelEstudios.toUpperCase() || client.descriocionNivelEstudios.toUpperCase() == filter.descriocionNivelEstudios.toUpperCase() || client.descriocionNivelEstudios.toUpperCase().includes(filter.descriocionNivelEstudios.toUpperCase()))
			                     && (!filter.nombre.toUpperCase()|| client.nombre.toUpperCase() === filter.nombre.toUpperCase() || client.nombre.toUpperCase() == filter.nombre.toUpperCase() || client.nombre.toUpperCase().includes(filter.nombre.toUpperCase()))
			                     && (!filter.email.toUpperCase()|| client.email.toUpperCase() === filter.email.toUpperCase() || client.email.toUpperCase() == filter.email.toUpperCase()|| client.email.toUpperCase().includes(filter.email.toUpperCase()))
			                     && (!filter.telefono.toUpperCase()|| client.telefono.toUpperCase() === filter.telefono.toUpperCase() || client.telefono.toUpperCase() == filter.telefono.toUpperCase()|| client.telefono.toUpperCase().includes(filter.telefono.toUpperCase()))
			                     && (!filter.genero.toUpperCase()|| client.genero.toUpperCase() === filter.genero.toUpperCase() || client.genero.toUpperCase() == filter.genero.toUpperCase()|| client.genero.toUpperCase().includes(filter.genero.toUpperCase()))
			                     && (!filter.descripcionEmpresa.toUpperCase()|| client.descripcionEmpresa.toUpperCase() === filter.descripcionEmpresa.toUpperCase() || client.descripcionEmpresa.toUpperCase() == filter.descripcionEmpresa.toUpperCase()|| client.descripcionEmpresa.toUpperCase().includes(filter.descripcionEmpresa.toUpperCase()))
			                     && (!filter.nombreEstado.toUpperCase()|| client.nombreEstado.toUpperCase() === filter.nombreEstado.toUpperCase() || client.nombreEstado.toUpperCase() == filter.nombreEstado.toUpperCase() || client.nombreEstado.toUpperCase().includes(filter.nombreEstado.toUpperCase()))
			                     && (!filter.fechaRegistro.toUpperCase()|| client.fechaRegistro.toUpperCase() === filter.fechaRegistro.toUpperCase() || client.fechaRegistro.toUpperCase() == filter.fechaRegistro.toUpperCase() || client.fechaRegistro.toUpperCase().includes(filter.fechaRegistro.toUpperCase()))
			                     && (!filter.edad.toUpperCase()|| client.edad.toUpperCase() === filter.edad.toUpperCase() || client.edad.toUpperCase() == filter.edad.toUpperCase() || client.edad.toUpperCase().includes(filter.edad.toUpperCase()))
			                     && (!filter.nombrePuesto.toUpperCase()|| client.nombrePuesto.toUpperCase() === filter.nombrePuesto.toUpperCase() || client.nombrePuesto.toUpperCase() == filter.nombrePuesto.toUpperCase() || client.nombrePuesto.toUpperCase().includes(filter.nombrePuesto.toUpperCase()))
			                     && (!filter.status.toUpperCase()|| client.status.toUpperCase() === filter.status.toUpperCase() || client.status.toUpperCase() == filter.status.toUpperCase() || client.status.toUpperCase().includes(filter.status.toUpperCase()))
			        });
			}
		}
	window.db = db;
	db.data;
	$(function() {
		$("#divTablaAspirantes")
				.jsGrid(
						{
							height : heightDivs+"px",
							width : "1880px",
							filtering : true,
							editing : false,
							sorting : false,
							paging : false,
							autoload: true,
							noDataContent: "No se encontrar\u00f3n registros.",
							controller : {
								loadData : function() {
									dataType: "json"
									return Aspirantes;
								}
							},
							rowClass : function(item, itemIndex) // item is
							// the data
							// in a row,
							// index is
							// the row
							// number.
							{
								if ((item.status == "ACEPTADO ")) {
									return "bg-valido";
								}
								if ((item.status == "NO ACEPTADO")) {
									return "bg-rechazado";
								} 
								
							},
							autoload : true,
							controller : db,
							fields : [
								
									{
										name : "nombre",
										type : "text",
										title : "NOMBRE",
										align : 'center',
										width : 90,
										css : "labelfor"											
										
									},
									{
										name : "email",
										type : "text",
										title : "EMAIL",
										align : 'center',
										width : 95,
										css : "labelfor"
									},
									{
										name : "edad",
										type : "text",
										title : "EDAD",
										align : 'center',
										width : 20,
										css : "labelfor"
										
									},
									{
										name : "telefono",
										type : "text",
										title : "TEL\u00C9FONO",
										align : 'center',
										width : 50,
										css : "labelfor"
										
									},
									{
										name : "genero",
										type : "select",
										items: [{name:"",valor:""},{name:"FEMENINO", valor:"FEMENINO"},{name:"MASCULINO",valor:"MASCULINO"}],
										valueField: "valor",        
									    textField: "name",
										title : "G\u00C9NERO",
										align : 'center',
										width : 35,
										css : "labelfor"
									},
									{
										name : "descriocionNivelEstudios",
										type : "text",
										title : "NIVEL ACAD\u00C9MICO",
										align : 'center',
										width : 50,
										css : "labelfor"
									},
									{
										name : "nombreEstado",
										type : "text",
										title : "ESTADO",
										align : 'center',
										width : 50,
										css : "labelfor"
									},
									{
										name : "descripcionEmpresa",
										type : "text",
										title : "CDO",
										align : 'center',
										width : 40,
										css : "labelfor"
									},
									{
										name : "fechaRegistro",
										type : "text",
										title : "FECHA DE REGISTRO",
										align : 'center',
										width : 50,
										css : "labelfor"
									},
									{
										name : "nombrePuesto",
										type : "text",
										title : "PUESTO SOLICITADO",
										align : 'center',
										width : 50,
										css : "labelfor"
									},
									
									{
										align : 'center',
										css : "labelfor",
										title : "ESTATUS",
										type : "select",
										items: [{name:"",valor:""},{name:"Disponible", valor:"Disponible"},{name:"Aceptado",valor:"Aceptado "},{name:"No aceptado",valor:"No aceptado"}],
										valueField: "valor",        
									    textField: "name",
										width : 50,
										name:"status",
										autosearch: true,  
										css : "labelfor",
										itemTemplate : function(value, item) {
											return "<button type='submit'   class='btn btn-outline-info img-fluid centrar'  id='btnActualiza' onclick='actualizaEstatus2("
													+ JSON.stringify(item)
													+ ");' >"
													+ item.status
													+ "</button>"
													
										}
									},
									{
										type : "control",
										align : 'center',
										css : "labelfor",
										width : 26,
										itemTemplate : function(value, item) {
											return "<button type='submit'   class='btn btn-outline-info'  id='btnConsultarRegistro' onclick='ConsultaRegistro("
													+ JSON.stringify(item)
													+ ");' >"
													+ "<img  src='Images/btnEditar.png' class='img-fluid centrar' />"
													+ "</button>"
													
										}
									},
									
									{
										type : "control",
										align : 'center',
										css : "labelfor",
										width : 26,
										itemTemplate : function(value, item) {
											let String;
											if(item.codigoCv!=null){
												String= "<button type='disabled' class='btn btn-outline-info'  id='btnDescargaPdf' onclick='descargaPdf("
													+ JSON.stringify(item)	
													+ ");' >"
													+ "<img  src='Images/btnCvPDF.png' class='img-fluid centrar' />"
													+ "</button>"
											}else {
												String= "<button type='button' disabled='true' class='btn btn-outline-info'  id='btnDescargaPdf'>"
													+ "<img  src='Images/btnCvPDF.png' class='img-fluid centrar' />"
													+ "</button>"
											}
											return String;
										}
									
									},
									{
										type : "control",
										align : 'center',
										css : "labelfor",
										width : 26,
										itemTemplate : function(value, item) {
											let String;
											if(item.codigoCv!=null){
												String= "<button type='submit'   class='btn btn-outline-info'  id='btnEnviaPdf' onclick='enviaPdf("
													+ JSON.stringify(item)
													+ ");'>"
													+ "<img  src='Images/btnCorreoPdf.jpg' class='img-fluid centrar' />"
													+ "</button>"
											}else{
												String= "<button type='button' disabled='true' class='btn btn-outline-info'  id='btnEnviaPdf'>"
													+ "<img  src='Images/btnCorreoPdf.jpg' class='img-fluid centrar' />"
													+ "</button>"
											}
											return String;
											
										}
									},  ]
						});

	});
	
}

function CalculaHeigthDivs() {
	var f = window.innerHeight;
	var t = document.getElementById("header").offsetHeight;
	var d = f - (t + 80);
	//	document.getElementById("divCardInformacion").style.height = d + "px";
	//	document.getElementById("mi-mapa").style.height = ((d / 2) - 60) + "px";
	//	document.getElementById("divCarMapa").style.height = (d / 2) + "px";
	//	document.getElementById("divCarFoto").style.height = (d / 2) + "px";

	return d;
}

	function ConsultaRegistro(registroVacante) {
		$('#hiddenIDVacante').val(registroVacante.idVacante)
		$('#modalTituloVacante').html(registroVacante.nombrePuesto);
		$('#txtVacanteDescripcion').val(registroVacante.descripcionVacante);
		$('#txtVacanteHorario').val(registroVacante.horarioVacante);
		$('#txtVacanteLugarTrabajo').val(registroVacante.lugarTrabajo);
		$('#txtVacanteObservaciones').val(registroVacante.observaciones);
		$('#txtVacantefechaPublicacion').val(registroVacante.fechaRegistro);
		$("#cmbVacantePuesto").val(registroVacante.idPuesto);
		$("#cmbVacanteEstado").val(registroVacante.nombreEstado);
		$('#cmbVacanteEmpresa').val(registroVacante.nombreEmpresa);
	
		$('#ModalVacante').modal('show')
	}
	
	function descargaPdf(aspirantes){
		var data = JSON.stringify({"cadena": aspirantes.codigoCv, "nombre":"CV-"+aspirantes.nombre});
		var xhr = new XMLHttpRequest();
		var url = "http://ws1:8080/wsGeneraPDF/ws/PDF/generaPdf";
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.responseType = 'blob';
		xhr.onload = function (e) {
		    var blob = e.currentTarget.response;
		    //Obtiene el content-disposition de la response
		    //var contentDispo = e.currentTarget.getResponseHeader('Content-Disposition');
		   //var fileName = contentDispo.match(/filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/)[1];
		    //guarda el archivo
		    savePdf(blob, "CV-"+aspirantes.nombre+".pdf");
		}
		xhr.send(data);
		
	}
	function savePdf(blob, fileName) {
	    var a = document.createElement('a');
	    a.href = window.URL.createObjectURL(blob);
	    a.download = fileName;
	    a.dispatchEvent(new MouseEvent('click'));
	}
	function enviaPdf(aspirantes){
		$('#hidenCadena').val(aspirantes.codigoCv);
		$('#hidenNombre').val(aspirantes.nombre);
		$('#myModal').modal('show');
		
	}
	
	function enviaCorreoWs(){
		document.getElementById('cargando').style.display = 'none';
		var destinatario=$('#txtCorreo').val();
		var cadena=$('#hidenCadena').val();
		var nombre=$('#hidenNombre').val();
		if(destinatario!==""&&destinatario.match("@")){
		var data = JSON.stringify({"cadena": cadena, "nombre":"CV-"+nombre, "destinatario":destinatario, "cuerpo":"Se envia el curriculum de "+nombre});
		var xhr = new XMLHttpRequest();
		var url = "http://ws1:8080/wsGeneraPDF/ws/PDF/enviarPdf";
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.onload = function (e) {
			$('#myModal').modal('hide');
			$("#lbl_TituloOk").text("Envio de correo correcto");
			$("#lbl_mensajeOk").text("Se han enviado correctamente los datos.");
			$("#myModalOk").modal();
		}
			 xhr.send(data);
		}else{	
			$('#myModal').modal('hide');
			mostrarMsjError("No ingreso un correo")
			document.getElementById('cargando').style.display = 'none';
		}	
	}
	function actualizaEstatus2(aspirantes){
		$('#hidenIdAspirante').val(aspirantes.idAspirante);
		
		$('#Modalestatus').modal('show');
	}
	function actualizaEstatus() {
		var selected = document.querySelector('input[type=radio][name=rdEstatus]:checked');
		var data = "accion=Actualizar&id="+$('#hidenIdAspirante').val()+"&estatus="+selected.value;
		document.getElementById('cargando').style.display = 'Block';
		//document.getElementById('cargando').style.display = 'Block';
	$.ajax({
		url : 'AdministradorAspirantes',
		data : data,
		type : 'POST',
		dataType : 'Json',
			success : function(respuesta) {

				if (respuesta) {

					var data = respuesta;
					if (data.length > 0) {
						ConsultaInformacionAspirantes();
						
					}
					$("#myModalOk").modal('show');
					$("#lbl_TituloOk").text("Actualizacion de estatus correcta");
					$("#lbl_mensajeOk").text(
							"Se han guardado correctamente los datos.");
					$("#Modalestatus").modal('hide');
				} else {
					document.getElementById('cargando').style.display = 'none';
				}
			},
			error : function(xhr, status, error) {
				//alert("error..." + error);
				mostrarMsjError("Error: No se pudo actualizar el aspirante. Intentelo nuevamente")
				document.getElementById('cargando').style.display = 'none';
			}
		});

	}
	function validarCv(aspirante){
		
	}