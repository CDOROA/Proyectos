/** * PANTALLA EMERGENTE - MENSAJE INICIAL ** */
function mostrarMensajesDeInicio() {
	 //MostrarDiv('divMensajeInicio');
	$("#lb_verOcultarVideo").text("Ocultar Video")

	setTimeout(function() {
		consultaHedarCentroMensajes()
	}, 10000);
}

function cerrarMensajeInicial(divMsjIni) {
	OcultarDiv(divMsjIni)
	// let vid = document.getElementById("videoCDO");
	// vid.play();
}

/** * VIDEO CDO-HEADER ** */
function mostrarQuitarVideoHeader() {
	let vid = document.getElementById("videoCDO");

	if ($("#lb_verOcultarVideo").text() == 'Ocultar Video') {
		MostrarDiv('div_imagenesEncabezado');
		OcultarDiv('videoCDO')
		vid.pause();
		$("#lb_verOcultarVideo").text("Ver Video")
	} else {
		MostrarDiv('videoCDO');
		OcultarDiv('div_imagenesEncabezado')
		$("#lb_verOcultarVideo").text("Ocultar Video")
		vid.play();
	}
}

/** ** CONSULTA SUGERENCIAS **** */
function consultaSugerencias2(event) {
	if (event.keyCode === 13) {
		consultaArticulos();
	} else {
		$
				.ajax({
					url : 'CarritoDeCompras',
					data : "vista=CarritoDeCompras.jsp&operacion=ConsultaSugerencias&descBusqueda="
							+ $('#txt_buscar_productos').val().replace('{','').replace('}','').replace('(','').replace(')','').replace('?','').replace('¿','').replace('!','').replace('¡',''),
					type : 'POST',
					dataType : 'Json',
					success : function(json) {

						let tabla = $('#tbSugerencias');
						var availableTags = [];
						for (var i = 0; i < json.length; i++) {
							availableTags.push(json[i].articulo);
						}

						$("#txt_buscar_productos").autocomplete({
							source : availableTags
						});

					},
					error : function(xhr, status, error) {
						document.getElementById('cargando').style.display = 'none';
						if (xhr.status === 200) {
							alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
							window.location.href = 'http://www.cdoautopartes.com.mx/';
						} else
							alert('Error al consultar Estado de Cuenta.')
							window.location.href = 'http://www.cdoautopartes.com.mx/';
					}
				});
	}
}

function consultaSugerencias(event) {
	if (event.keyCode === 13) {
		consultaArticulos();
	} else {
		$
				.ajax({
					url : 'CarritoDeCompras',
					data : "vista=CarritoDeCompras.jsp&operacion=ConsultaSugerencias&descBusqueda="
							+ $('#txt_buscar_productos').val().replace('{','').replace('}','').replace('(','').replace(')','').replace('?','').replace('¿','').replace('!','').replace('¡',''),
					type : 'POST',
					dataType : 'Json',
					success : function(json) {
						//alert(JSON.stringify(json));
						let tabla = $('#tbSugerencias');
						tabla.empty();
						tabla.show();
						for (var i = 0; i < json.length; i++) {
							$('<td align=left class=tdSugerencia>').on('click',
									autocompletaBusqueda)
									.text(json[i].articulo).appendTo(
											$('<tr>').appendTo(tabla));
						}
					},
					error : function(xhr, status, error) {
						document.getElementById('cargando').style.display = 'none';
						if (xhr.status === 200) {
							alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
							window.location.href = 'http://www.cdoautopartes.com.mx/';
						} else
							alert('Error al consultar Estado de Cuenta.')
							window.location.href = 'http://www.cdoautopartes.com.mx/';
					}
				});
	}
}

function autocompletaBusqueda() {
	let tabla = $('#tbSugerencias');
	tabla.empty();
	let $this = $(this);
	$('#txt_buscar_productos').val($this.text().replace('{','').replace('}','').replace('(','').replace(')','').replace('?','').replace('¿','').replace('!','').replace('¡',''));
	$('#tbSugerencias').empty();
	consultaArticulos();

}

/**
 * *** CONSULTA DE ARTICULOS POR APLICACION Y CREAR CONTENIDO DE CARRITO
 * BUSQUEDA ****
 */
function mostrarConsultaPorAplicacion() {
	$("#navbarsExample02").collapse('hide');
	$("#navbarsExample02").removeClass("in");
	ocultarControles();
	limpiaFiltrosArticulos();
	MostrarDiv("divConsultaPorAplicacion");
}
function LimpiaCampoBusqueda() {
	$("#txt_buscar_productos").val("");
}

function consultaArticulos() {
	$("#navbarsExample02").collapse('hide');
	$("#navbarsExample02").removeClass("in");

	if ($("#txt_buscar_productos").val() != "") {
		$('#tbSugerencias').empty();
		document.getElementById('cargando').style.display = 'block';
		ocultarControles()
		MostrarDiv("divConsultaPorAplicacion");

		$
				.ajax({
					url : 'CarritoDeCompras',
					data : "vista=CarritoDeCompras.jsp&operacion=ConsultaArticulos&desc_articulo="
							+ $("#txt_buscar_productos").val().replace('{','').replace('}','').replace('(','').replace(')','').replace('?','').replace('¿','').replace('!','').replace('¡','')
							+ "&marca="
							+ ""
							+ "&auto=" + "" + "&modelo=" + "",
					type : 'POST',
					dataType : 'Json',
					success : function(jsonArticulos) {

					//	alert("lista del lado json: " + JSON.stringify(jsonArticulos));
						
						document.getElementById('cargando').style.display = 'none';

						$('#txtResultados').text(
								"Resultados de la busqueda para: "
										+ $("#txt_buscar_productos").val().replace('{','').replace('}','').replace('(','').replace(')','').replace('?','').replace('¿','').replace('!','').replace('¡','')
										+ " - " + jsonArticulos.length
										+ " Registros.");
						llenaGridArticulos(jsonArticulos)
						MostrarDiv('div_ArticulosXAplicacion')
						OcultarDiv('div_MarcasPrincipalesCdo');
						$('#tbSugerencias').empty();
					},
					error : function(xhr, status, error) {
						document.getElementById('cargando').style.display = 'none';
						if (xhr.status === 200) {
							alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
							window.location.href = 'http://www.cdoautopartes.com.mx/';
						} else
							alert('Error al buscar productos.')
							window.location.href = 'http://www.cdoautopartes.com.mx/';
					}
				});
	}
}

function consultaArticulosMarcasCalidad(cveMarca) {
	document.getElementById('cargando').style.display = 'block';
	let marca = cveMarca.split('.');
	ocultarControles()
	MostrarDiv("divConsultaPorAplicacion");
	$
			.ajax({
				url : 'CarritoDeCompras',
				data : "vista=CarritoDeCompras.jsp&operacion=ConsultaArticulosMarcaCalidad&desc_articulo="
						+ ""
						+ "&marca="
						+ marca[0]
						+ "&auto="
						+ ""
						+ "&modelo=" + "",
				type : 'POST',
				dataType : 'Json',
				success : function(jsonArticulos) {

					$('#txtResultados').text(
							"Resultados de la busqueda para: " + marca[0]
									+ " - " + jsonArticulos.length
									+ " Registros.");
					document.getElementById('cargando').style.display = 'none';
					llenaGridArticulos(jsonArticulos)
					MostrarDiv('div_ArticulosXAplicacion')
					OcultarDiv('div_MarcasPrincipalesCdo');
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al buscar productos.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
				}
			});
}

function consultaArticulosPorautomovil() {
	document.getElementById('cargando').style.display = 'block';
	ocultarControles()
	MostrarDiv("divConsultaPorAplicacion");

	$
			.ajax({
				url : 'CarritoDeCompras',
				data : "vista=CarritoDeCompras.jsp&operacion=ConsultaPorVeiculo&desc_articulo="
						+ ""
						+ "&armadora="
						+ $("#cbo_marca_aplicacion option:selected").text()
						+ "&submarca="
						+ $("#cbo_auto_aplicacion").val()
						+ "&modelo="
						+ $("#cbo_modelo_aplicacion").val()
						+ "&cilindros="
						+ $("#cbo_cilindros_aplicacion").val()
						+ "&litros=" + $("#cbo_litros_aplicacion").val(),
				type : 'POST',
				dataType : 'Json',
				success : function(jsonArticulos) {

					colocarSintillo(jsonArticulos);
					document.getElementById('cargando').style.display = 'none';
					llenaGridArticulos(jsonArticulos)
					MostrarDiv('div_ArticulosXAplicacion');
					OcultarDiv('div_MarcasPrincipalesCdo');
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al buscar productos.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
				}
			});
}

function consultaArticulosNuevos() {
	document.getElementById('cargando').style.display = 'block';
	ocultarControles()
	MostrarDiv("divConsultaPorAplicacion");

	$
			.ajax({
				url : 'CarritoDeCompras',
				data : "vista=CarritoDeCompras.jsp&operacion=ArticulosNuevos&desc_articulo="
						+ ""
						+ "&armadora="
						+ $("#cbo_marca_aplicacion option:selected").text()
						+ "&submarca="
						+ $("#cbo_auto_aplicacion").val()
						+ "&modelo="
						+ $("#cbo_modelo_aplicacion").val()
						+ "&cilindros="
						+ $("#cbo_cilindros_aplicacion").val()
						+ "&litros=" + $("#cbo_litros_aplicacion").val(),
				type : 'POST',
				dataType : 'Json',
				success : function(jsonArticulos) {
					colocarSintillo(jsonArticulos);
					document.getElementById('cargando').style.display = 'none';
					llenaGridArticulos(jsonArticulos)
					MostrarDiv('div_ArticulosXAplicacion')
					OcultarDiv('div_MarcasPrincipalesCdo');
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al buscar productos.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
				}
			});

}

function colocarSintillo(jsonArticulos) {
	$('#txtResultados').text("");

	var mensaje = "Resultados de la busqueda para: ";

	if ($("#cbo_marca_aplicacion option:selected").text() != "0") {
		mensaje += $("#cbo_marca_aplicacion option:selected").text() + " "
	}
	if ($("#cbo_auto_aplicacion").val() != "0") {
		mensaje += $("#cbo_auto_aplicacion").val() + " "
	}
	if ($("#cbo_modelo_aplicacion").val() != "0") {
		mensaje += $("#cbo_modelo_aplicacion").val() + " "
	}
	if ($("#cbo_cilindros_aplicacion").val() != "0") {
		mensaje += $("#cbo_cilindros_aplicacion").val() + " "
	}
	if ($("#cbo_litros_aplicacion").val() != "0") {
		mensaje += $("#cbo_litros_aplicacion").val() + " "
	}

	$('#txtResultados').text(mensaje + " - " + jsonArticulos.length);
}

function llenarGridDetalleArticulos(json) {
	$('#div_DetalleArticulos').empty();
	/** * Titulos ** */
	let contenido = generaTitulosDetArt();
	for (let i = 0; i < json.length; i++) {
		/** * Aplica color segun Marca ** */
		contenido += "<tr id='tr_articulosDetalle' style='font-size:14px;'>";
		contenido += "<td id='td_articulosDetalle'> "
				+ json[i].armadora
				+ " </td>"
				+ "<td id='td_articulosDetalle1'> "
				+ json[i].modelo
				+ " </td>"
				+ "<td id='td_articulosDetalle2'> "
				+ json[i].submodelo
				+ " </td>"
				+ "<td id='td_articulosDetalle3' style= 'text-align: center;'> "
				+ json[i].anio
				+ " </td>"
				+ "<td id='td_articulosDetalle4' style= 'text-align: center;'> "
				+ json[i].litros
				+ " </td>"
				+ "<td id='td_articulosDetalle5' style= 'text-align: center;'> "
				+ json[i].cilindros + " </td>"
				+ "<td id='td_articulosDetalle6'>  " + json[i].caracteristicas
				+ " </td>" + "<td id='td_articulosDetalle7' >  "
				+ json[i].transmision + " </td>"
				+ "<td id='td_articulosDetalle8'> " + json[i].tipo_combustible
				+ " </td>" + "</tr>";

	}
	contenido += "</tbody>" + "</table>";
	$("#div_DetalleArticulos").append(contenido);

	aplicarEstiloTablaDetalleArticulos();

}

function llenaGridArticulos(jsonArticulos) {
	$('#div_ArticulosCarrito').empty();
	/** * Titulos ** */
	let contenido = generaTitulosDelCarrito();
	for (let i = 0; i < jsonArticulos.length; i++) {
		/** * Aplica color segun Marca ** */
		contenido += "<tr id='tr_articulos'>";

		/** * Foto articulo ** */
		contenido += generaColFotoInicialDeCarrito(jsonArticulos[i])

		/** * Articulo y cambio de numero ** */
		contenido += generaColNumArticuloYCambioNumeroDeCarrito(
				jsonArticulos[i], i)

		/** * Detalle del articulo ** */
		contenido += generaColDetalleDeArticulo(jsonArticulos[i], i)

		/** * Informacion adicional** */
		contenido += generaColInformacionAdicional(jsonArticulos[i], i)

		/** * Comprar y Disponibilidad** */
		contenido += generaColCompraExistencia(jsonArticulos[i])

	}
	contenido += "</tbody>" + "</table>";
	$("#div_ArticulosCarrito").append(contenido);

	for (let i = 0; i < jsonArticulos.length; i++) {

		if (jsonArticulos[i].cilindros.includes(",")) {
			let splitSubCilindros = jsonArticulos[i].cilindros.substring(0,
					jsonArticulos[i].cilindros.length).split(",");
			splitSubCilindros.reverse();
			for (var j = 0; j < splitSubCilindros.length; j++) {
				if (splitSubCilindros[j] != '' && splitSubCilindros[j] != ' ') {
					$('#selectExistenciasCilindros_' + i + '').prepend(
							"<option value='" + (parseInt(j) + 1)
									+ "' selected='selected' >"
									+ splitSubCilindros[j] + "</option>");
				}
			}
		} else {
			$('#selectExistenciasCilindros_' + i + '').prepend(
					"<option value='" + (parseInt(j) + 1) + "' >"
							+ jsonArticulos[i].cilindros + "</option>");
		}
		$(
				"#selectExistenciasCilindros_"
						+ i
						+ " > option[value="
						+ $('#selectExistenciasCilindros_' + i + ' option').length
						+ "]").attr("selected", true);

		if (jsonArticulos[i].descripcion.includes(",")) {

			let splitSinonimos = jsonArticulos[i].descripcion.substring(0,
					jsonArticulos[i].descripcion.length).split(",");

			splitSinonimos.reverse();
			for (var j = 0; j < splitSinonimos.length; j++) {
				if (splitSinonimos[j] != '' && splitSinonimos[j] != ' ') {
					$('#selectSinonimos_' + i + '').prepend(
							"<option value='" + (parseInt(j) + 1)
									+ "' selected='selected' >"
									+ splitSinonimos[j] + "</option>");
				}
			}
		} else {
			$('#selectSinonimos_' + i + '').prepend(
					"<option value='" + (parseInt(j) + 1) + "' >"
							+ jsonArticulos[i].descripcion + "</option>");
		}
		$(
				"#selectSinonimos_" + i + " > option[value="
						+ $('#selectSinonimos_' + i + ' option').length + "]")
				.attr("selected", true);

		if (jsonArticulos[i].tipo_gasolina.includes(",")) {
			let splitSinonimos = jsonArticulos[i].tipo_gasolina.substring(0,
					jsonArticulos[i].tipo_gasolina.length).split(",");
			splitSinonimos.reverse();
			for (var j = 0; j < splitSinonimos.length; j++) {
				if (splitSinonimos[j] != '' && splitSinonimos[j] != ' ') {
					$('#selectExistenciasGasolina_' + i + '').prepend(
							"<option value='" + (parseInt(j) + 1)
									+ "' selected='selected' >"
									+ splitSinonimos[j] + "</option>");
				}
			}
		} else {
			$('#selectExistenciasGasolina_' + i + '').prepend(
					"<option value='" + (parseInt(j) + 1) + "' >"
							+ jsonArticulos[i].tipo_gasolina + "</option>");
		}
		$(
				"#selectExistenciasGasolina_"
						+ i
						+ " > option[value="
						+ $('#selectExistenciasGasolina_' + i + ' option').length
						+ "]").attr("selected", true);

		if (jsonArticulos[i].modelo.includes(",")) {

			let splitSinonimos = jsonArticulos[i].modelo.substring(0,
					jsonArticulos[i].modelo.length).replace("[", "").replace(
					"]", "").split(",");
			splitSinonimos.reverse();
			for (var j = 0; j < splitSinonimos.length; j++) {
				if (splitSinonimos[j] != '' && splitSinonimos[j] != ' ') {
					$('#selectModelo_' + i + '').prepend(
							"<option value='" + (parseInt(j) + 1)
									+ "' selected='selected' >"
									+ splitSinonimos[j] + "</option>");
				}
			}
		} else {
			$('#selectModelo_' + i + '').prepend(
					"<option value='" + (parseInt(j) + 1) + "' >"
							+ jsonArticulos[i].modelo + "</option>");
		}
		$(
				"#selectModelo_" + i + " > option[value="
						+ $('#selectModelo_' + i + ' option').length + "]")
				.attr("selected", true);

		if (jsonArticulos[i].armadora.includes(",")) {
			let splitSinonimos = jsonArticulos[i].armadora.substring(0,
					jsonArticulos[i].armadora.length).replace("[", "").replace(
					"]", "").split(",");
			splitSinonimos.reverse();
			for (var j = 0; j < splitSinonimos.length; j++) {
				if (splitSinonimos[j] != '' && splitSinonimos[j] != ' ') {
					$('#selectArmadora_' + i + '').prepend(
							"<option value='" + (parseInt(j) + 1)
									+ "' selected='selected' >"
									+ splitSinonimos[j] + "</option>");
				}
			}
		} else {
			$('#selectArmadora_' + i + '').prepend(
					"<option value='" + (parseInt(j) + 1) + "' >"
							+ jsonArticulos[i].armadora + "</option>");
		}
		$(
				"#selectArmadora_" + i + " > option[value="
						+ $('#selectArmadora_' + i + ' option').length + "]")
				.attr("selected", true);

		if (jsonArticulos[i].caracteristicas.includes(",")) {
			let splitSinonimos = jsonArticulos[i].caracteristicas.substring(0,
					jsonArticulos[i].caracteristicas.length).split(",");
			splitSinonimos.reverse();
			for (var j = 0; j < splitSinonimos.length; j++) {
				if (splitSinonimos[j] != '' && splitSinonimos[j] != ' ') {
					$('#selectExistenciasCaracteristicas_' + i + '').prepend(
							"<option value='" + (parseInt(j) + 1)
									+ "' selected='selected' >"
									+ splitSinonimos[j] + "</option>");
				}
			}
		} else {
			$('#selectExistenciasCaracteristicas_' + i + '').prepend(
					"<option value='" + (parseInt(j) + 1) + "' >"
							+ jsonArticulos[i].caracteristicas + "</option>");
		}
		$(
				"#selectExistenciasCaracteristicas_"
						+ i
						+ " > option[value="
						+ $('#selectExistenciasCaracteristicas_' + i
								+ ' option').length + "]").attr("selected",
				true);

		if (jsonArticulos[i].litros.includes(",")) {
			let splitSubLitros = jsonArticulos[i].litros.substring(0,
					jsonArticulos[i].litros.length).split(",");
			splitSubLitros.reverse();
			for (var j = 0; j < splitSubLitros.length; j++) {
				if (splitSubLitros[j] != '' && splitSubLitros[j] != ' ') {
					$('#selectExistenciasMotor_' + i + '').prepend(
							"<option value='" + (parseInt(j) + 1) + "' >"
									+ splitSubLitros[j] + "</option>");
				}
			}
		} else {
			$('#selectExistenciasMotor_' + i + '').prepend(
					"<option value='" + (parseInt(j) + 1) + "'' >"
							+ jsonArticulos[i].litros + "</option>");
		}
		$(
				"#selectExistenciasMotor_" + i + " > option[value="
						+ $('#selectExistenciasMotor_' + i + ' option').length
						+ "]").attr("selected", true);

		if (jsonArticulos[i].transmision.includes(",")) {
			let splitSubLitros = jsonArticulos[i].transmision.substring(0,
					jsonArticulos[i].transmision.length).split(",");
			splitSubLitros.reverse();
			for (var j = 0; j < splitSubLitros.length; j++) {
				if (splitSubLitros[j] != '' && splitSubLitros[j] != ' ') {
					$('#selectExistenciasTransmision_' + i + '').prepend(
							"<option value='" + (parseInt(j) + 1) + "' >"
									+ splitSubLitros[j] + "</option>");
				}
			}
		} else {
			$('#selectExistenciasTransmision_' + i + '').prepend(
					"<option value='" + (parseInt(j) + 1) + "'' >"
							+ jsonArticulos[i].transmision + "</option>");
		}
		$(
				"#selectExistenciasTransmision_"
						+ i
						+ " > option[value="
						+ $('#selectExistenciasTransmision_' + i + ' option').length
						+ "]").attr("selected", true);

		if (jsonArticulos[i].posicion.includes(",")) {
			let splitSubLitros = jsonArticulos[i].posicion.substring(0,
					jsonArticulos[i].posicion.length).split(",");
			splitSubLitros.reverse();
			for (var j = 0; j < splitSubLitros.length; j++) {
				if (splitSubLitros[j] != '' && splitSubLitros[j] != ' ') {
					$('#selectExistenciasPosicion_' + i + '').prepend(
							"<option value='" + (parseInt(j) + 1) + "' >"
									+ splitSubLitros[j] + "</option>");
				}
			}
		} else {
			$('#selectExistenciasPosicion_' + i + '').prepend(
					"<option value='" + (parseInt(j) + 1) + "'' >"
							+ jsonArticulos[i].posicion + "</option>");
		}
		$(
				"#selectExistenciasPosicion_"
						+ i
						+ " > option[value="
						+ $('#selectExistenciasPosicion_' + i + ' option').length
						+ "]").attr("selected", true);

		if (jsonArticulos[i].submodelo.includes(",")) {
			let splitSubLitros = jsonArticulos[i].submodelo.substring(0,
					jsonArticulos[i].submodelo.length).split(",");
			splitSubLitros.reverse();
			for (var j = 0; j < splitSubLitros.length; j++) {
				if (splitSubLitros[j] != '' && splitSubLitros[j] != ' ') {
					$('#selectExistencias_' + i + '').prepend(
							"<option value='" + (parseInt(j) + 1) + "' >"
									+ splitSubLitros[j] + "</option>");
				}
			}
		} else {
			$('#selectExistencias_' + i + '').prepend(
					"<option value='" + (parseInt(j) + 1) + "'' >"
							+ jsonArticulos[i].submodelo + "</option>");
		}
		$(
				"#selectExistencias_" + i + " > option[value="
						+ $('#selectExistencias_' + i + ' option').length + "]")
				.attr("selected", true);

	}

	aplicarEstiloTabla();

}

function generaTitulosDelCarrito() {
	let contenido = "<table id='tb_articulos' class='table' align='center' cellpadding=0px; cellspacing=0px; class='table table-bordered' style='width:100%; background:white' data-page-length='50'>"
			+ "<thead  id='thd_articulos' style='background-color:#0054A2; color:white' >"
			+ "<tr id='tr_articulos'>"
			+ "<th style='text-align: center;padding:2px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'> "
			+ " <select id='cbo_orden_productos' style='font-size: 12px; font-family: arial;padding:6px; width:100%; background-color: #0054A2;  color: white;border:1px solid #DCDCDC; border-radius: 3px'  onchange='ordenaArticulosCarrito()'>"
			+ "<option value='0' style='font-weight: bold'>-- ORDENAR --</option>"
			+ "<option value='1' >Grupo</option>"
			+ "<option value='2' >Marca</option>"
			+ "<option value='3' >Descripcion</option>"
			+ "<option value='4' >Precio Menor a Mayor</option>"
			+ "<option value='5' >Precio Mayor a Menor</option>"
			+ "<option value='6' >Mayor Demanda</option>"
			+ "</select>"
			+ "</th>"
			+ "<th id='th_articulos1' style='text-align: center;padding:2px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'>PRODUCTO </label></th>"
			+ "<th id='th_articulos2' style='text-align: center;padding:2px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'>PRECIO </label></th>"
			+ "</tr>" + "</thead>" + "<tbody id='tbd_articulos'>";
	return contenido;
}

function generaTitulosDetArt() {
	let contenido = "<table id='tb_articulosDetalle' class='table  table-striped table-hover table-bordered' align='center' cellpadding=0px; cellspacing=0px; style='width:100%;  height:100%;  background:white' data-page-length='50'>"
			+ "<thead  id='thd_articulosDetalle' style='background-color:#0054A2; color:white' >"
			+ "<tr id='tr_articulosDetalle'>"
			+ "<th id='th_articulosDetalle1' style='text-align: center;padding:2px;position: sticky;' class='anchoThDetArtArmadora'><label class='EPP_lb_size_14' style='font-weight: bold;'>ARMADORA </label></th>"
			+ "<th id='th_articulosDetalle2' style='text-align: center;padding:2px;position: sticky;'class='anchoThDetArtModelos'><label class='EPP_lb_size_14' style='font-weight: bold;'>MODELO </label></th>"
			+ "<th id='th_articulosDetalle3' style='text-align: center;padding:2px;position: sticky;'class='anchoThDetArtModelos'><label class='EPP_lb_size_14' style='font-weight: bold;'>SUBMODELO </label></th>"
			+ "<th id='th_articulosDetalle4' style='text-align: center;padding:2px;position: sticky;' class='anchoThDetArt'><label class='EPP_lb_size_14' style='font-weight: bold;'>A&Ntilde;O </label></th>"
			+ "<th id='th_articulosDetalle5' style='text-align: center;padding:2px;position: sticky;' class='anchoThDetArt'><label class='EPP_lb_size_14' style='font-weight: bold;'>LITROS </label></th>"
			+ "<th id='th_articulosDetalle6' style='text-align: center;padding:2px;position: sticky;' class='anchoThDetArt'><label class='EPP_lb_size_14' style='font-weight: bold;'>CILINDROS </label></th>"
			+ "<th id='th_articulosDetalle7' style='text-align: center;padding:2px;position: sticky;' class='anchoThDetArtModelos'><label class='EPP_lb_size_14' style='font-weight: bold;'>CARACTERISTICAS </label></th>"
			+ "<th id='th_articulosDetalle8' style='text-align: center;padding:2px;position: sticky;' class='anchoThDetArt'><label class='EPP_lb_size_14' style='font-weight: bold; ' >TRANSMISION </label></th>"
			+ "<th id='th_articulosDetalle9' style='text-align: center;padding:2px;position: sticky;' class='anchoThDetArtCombustible'><label class='EPP_lb_size_14' style='font-weight: bold;'>COMBUSTIBLE </label></th>"
			+ "</tr>" + "</thead>" + "<tbody id='tbd_articulosDetalle'>";
	return contenido;
}

function aplicaColoresAlosResultadosBusqueda(jsonArticulos) {
	let contenido = "<tr id='tr_articulos'>";
	if (jsonArticulos.marca == "KWX" || jsonArticulos.marca == "OEP") {
		contenido = "<tr id='tr_articulos' style='background:#FBEAEA'>";
	}
	return contenido;
}

function generaColFotoInicialDeCarrito(jsonArticulos) {
	let imgEcommerce = jsonArticulos.imagen_ecommerce;
	let arrayImg = jsonArticulos.imagen_bxa.split(',')

	let contenido = "<td id='td_articulos' class='tb_td_foto_articulo' align='center' style='padding:5px; '>";

	if (imgEcommerce.trim() != "") {

		// contenido += "<img src='image/" + imgEcommerce+ "'
		// class='ECC_img_articulos' style='cursor: pointer;max-width:200px'
		// onclick=\"consultaImagenesArticulos('"
		// +jsonArticulos.imagen_ecommerce +"', '" + jsonArticulos.imagen_bxa
		// +"','" + jsonArticulos.descripcion + "','"+ jsonArticulos.num_art_cdo
		// +"','" +jsonArticulos.precio+ "')\">";
		contenido += "<img src='https://www.autorep.mx/konakart/images/"
				+ imgEcommerce
				+ "' class='ECC_img_articulos'  style='cursor: pointer;max-width:200px' onclick='consultaImagenesArticulos("
				+ JSON.stringify(jsonArticulos) + ")'>";
	} else {
		contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/"
				+ arrayImg[0]
				+ "' class='ECC_img_articulos'  style='cursor: pointer;max-width:200px' onclick='consultaImagenesArticulos("
				+ JSON.stringify(jsonArticulos) + ")'>";
		// contenido += "<img src='image/" + arrayImg[0]+ "'
		// class='ECC_img_articulos' style='cursor: pointer;max-width:200px'
		// onclick=\"consultaImagenesArticulos('"
		// +jsonArticulos.imagen_ecommerce +"', '" + jsonArticulos.imagen_bxa
		// +"','" +jsonArticulos.descripcion+ "','" + jsonArticulos.num_art_cdo
		// + "','" + jsonArticulos.precio + "')\">";

	}

	contenido += "</td>";
	return contenido;
}

function generaColNumArticuloYCambioNumeroDeCarrito(jsonArticulos, aux) {
	let contenido = "<td id='td_articulos'   style='padding:5px;text-align: left; width: 70%; '>"
			+ "<div class='row'><div class='col-lg-12 col-md-12 col-sm-12'> ";

	if (jsonArticulos.tipo_catalogo == "1") {
		contenido += "<label class='ECC_lb_size_12' style='font-weight: bold;color: white;background: black;padding-right: 5px;padding-left: 5px;    border-radius: 6px;'>"
				+ jsonArticulos.descripcion_producto
				+ "</label><label class='ECC_lb_size_12' > &nbsp; <b>Sinonimos: </b> <select id='selectSinonimos_"
				+ aux
				+ "'></select> <label id = 'etiquetatitulo' class='etiquetado_ACES' data-toggle='tooltip' data-placement='top' title='Est&aacute;ndar de informaci&oacute;n de la industria de aftermarket(Mercado de Repuestos) de autopartes.' onclick='alert('Est&aacute;ndar de informaci&oacute;n de la industria de aftermarket(Mercado de Repuestos) de autopartes.');' >  ACES </label></label> ";
	} else {
		contenido += "<label class='ECC_lb_size_12' style='font-weight: bold;color: white;background: black;padding-right: 5px;padding-left: 5px;    border-radius: 6px;'>"
				+ jsonArticulos.descripcion_producto
				+ "</label><label class='ECC_lb_size_12' >  &nbsp;<b>Sinonimos: </b> <select id='selectSinonimos_"
				+ aux + "'></select></label> ";
	}

	contenido += "<button class = 'btn btn-primary' style= 'color: white;margin-left: 10px;height: 22px;margin-right: 10px;     padding-top: 0px;    margin-right: 10px;padding-bottom: 0px;' onclick= 'cargarDetalleArticulo("
			+ '"'
			+ jsonArticulos.descripcion_producto.replace("[", "").replace("]",
					"")
			+ '"'
			+ ","
			+ '"'
			+ jsonArticulos.num_art_cdo.replace("[", "").replace("]", "")
			+ '"'
			+ ","
			+ '"'
			+ jsonArticulos.marca.replace("[", "").replace("]", "")
			+ '"'
			+ ","
			+ '"'
			+ jsonArticulos.num_art_prov.replace("[", "").replace("]", "")
			+ '"'
			+ ")'>Aplicacion</button><br>";

	if (jsonArticulos.num_art_anterior == "") {
		contenido += "<label class='ECC_lb_size_12' style='font-weight: bold; color:black;    font-size: 14px;'>Producto: </label> &nbsp; <label class='ECC_lb_size_12' style='color:#0040FF;font-weight: bold;    font-size: 14px;'>"
				+ jsonArticulos.num_art_cdo
				+ "</label> <label class='ECC_lb_size_12' style='color:black;padding-right:20px;    font-size: 14px;'><b>No. Proveedor:</b> "
				+ jsonArticulos.num_art_prov + "</label>   <br>";
	} else {
		contenido += "<label class='ECC_lb_size_12' style='font-weight: bold; color:black;    font-size: 14px;'>Producto: </label> &nbsp; <label class='ECC_lb_size_12' style='color:#0040FF;font-weight: bold;    font-size: 14px;'>"
				+ jsonArticulos.num_art_cdo
				+ "</label> <label class='ECC_lb_size_12' style='font-weight: bold; color:#8A0808;    font-size: 14px;'>(No. Anterior "
				+ jsonArticulos.num_art_anterior
				+ ")</label> <label class='ECC_lb_size_12' style='color:black;padding-right:20px;     font-size: 14px;'><b>No. Proveedor:</b> "
				+ jsonArticulos.num_art_prov + "</label> <br>";
	}
	return contenido;
}

function cargarDetalleArticulo(descripcion, articulo, marca,art_prov) {
	$
			.ajax({
				url : 'CarritoDeCompras',
				data : "vista=CarritoDeCompras.jsp&operacion=ConsultaDetalleArticulo&articulo="
						+ articulo+"&art_prov="+art_prov,
				type : 'POST',
				dataType : 'Json',
				success : function(respuesta) {

					llenarGridDetalleArticulos(respuesta)
					$("#lbl_Articulo_detalle").text(
							"ARTICULO: " + articulo + " - " + descripcion
									+ " MARCA: " + marca);
					$('#modalDetalleArticulos').modal('toggle');
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al consultar detallede articulo.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
				}
			});
}

function generaColDetalleDeArticulo(jsonArticulos, aux) {
	let contenido = "<div class='text-left: displya:block'>";

	if (jsonArticulos.marca == "OEP") {
		contenido += "<label class='ECC_lb_size_12' style='color:black;padding-right:20px'><b>Marca:</b> <b style='color:#0040FF'>"
				+ generaColMarcasKexOep(jsonArticulos) + "</b></label>";
	} else if (jsonArticulos.marca == "KWX") {
		contenido += "<label class='ECC_lb_size_12' style='color:black;padding-right:20px'><b>Marca:</b> <b style='color:#0040FF'>"
				+ generaColMarcasKexOep(jsonArticulos) + "</b></label>";
	} else {
		contenido += "<label class='ECC_lb_size_12' style='color:black;padding-right:20px'><b>Marca:</b> <b style='color:#0040FF'>"
				+ jsonArticulos.marca + "</b></label>";
	}

	contenido += "<label class='ECC_lb_size_12' style='color:black;padding-right:20px'><b>Grupo:</b> "
			+ jsonArticulos.grupo + "</label>";
	if (jsonArticulos.armadora.length > 120) {
		contenido += "<label class='ECC_lb_size_12' style='color:black;padding-right:20px'><b>Armadora:</b> <label style='    margin-bottom: 0px;'><select  style = '    width: 100px;' id='selectArmadora_"
				+ aux + "'></select></label></label>";
	} else {
		contenido += "<label class='ECC_lb_size_12' style='color:black;padding-right:20px; margin-bottom: 0px;'><b>Armadora:</b> "
				+ jsonArticulos.armadora + "</label>";
	}
	contenido += "</div>";
	return contenido;
}

function generaColInformacionAdicional(jsonArticulos, aux) {
	let contenido = "<div style='border:0px solid #B0C4DE'>";
	if (jsonArticulos.modelo.length > 130) {
		contenido += "<label class='ECC_lb_size_12_carrito' style='color:black;display: inline-block;'><b>Modelo: </b><label style='    margin-bottom: 0px;'><select  style = '    width: 100px;' id='selectModelo_"
				+ aux + "'></select></label></label></br>";
	} else {
		contenido += "<label class='ECC_lb_size_12_carrito' style='color:black;display: inline-block;'><b>Modelo: </b><label style = '    margin-bottom: 0px;'>"
				+ jsonArticulos.modelo + "</label></label></br>";
	}
	contenido += "<label class='ECC_lb_size_12_carrito' style='color:black;padding-right:20px; display: inline-block;'> <b>A&ntilde;o: </b>"
			+ jsonArticulos.anio
			+ "</label>"
			+ "<label class='ECC_lb_size_12_carrito' style='color:black;display: inline-block;'> <b>SubModelo: </b><select  style = '    width: 100px;' id='selectExistencias_"
			+ aux
			+ "'></select></label>"
			+ "<label class='ECC_lb_size_12' style='color:black;padding-right:20px'><b> &nbsp;Posici\u00F3n: </b> <select id='selectExistenciasPosicion_"
			+ aux
			+ "'></select></label>"
			+ "<label class='ECC_lb_size_12' style='color:black;padding-right:20px'><b>Transmision:</b> <select id='selectExistenciasTransmision_"
			+ aux
			+ "'></select></label>"
			+ "<label class='ECC_lb_size_12' style='color:black;padding-right:20px'><b>Cilindros:</b><select id='selectExistenciasCilindros_"
			+ aux
			+ "'></select></label>"
			+ "<label class='ECC_lb_size_12' style='color:black;padding-right:20px'><b>Motor:</b><select id='selectExistenciasMotor_"
			+ aux
			+ "'></select></label>"
			+ "<label class='ECC_lb_size_12' style='color:black;padding-right:20px'><b>Caracteristicas:</b><select id='selectExistenciasCaracteristicas_"
			+ aux
			+ "'></select></label>"
			+ "<label class='ECC_lb_size_12' style='color:black;padding-right:20px'><b>Tipo combustible:</b><select id='selectExistenciasGasolina_"
			+ aux + "'></select></label>";
	contenido += "</div>";
	let splitSubModelo = jsonArticulos.submodelo.substring(1,
			jsonArticulos.submodelo.length - 1).split(",");
	if (jsonArticulos.rk == "N") {
		contenido += "<label class='ECC_lb_size_14' style='color:#008000; background-color: #F0FFF0; padding:5px'><b>"
				+ " PRODUCTO NUEVO" + "</b></label>";
	}
	if (jsonArticulos.marcaIntercambio == "*") {
		contenido += "<label class='ECC_lb_size_14' style='color:#FF4500; background-color: #FAF0E6; padding:5px'><b>"
				+ " INTERCAMBIO " + "</b></label>";
	}
	// contenido += generaColMarcasKexOep(jsonArticulos) ;
	contenido += generaColComparativaMarcasCDOS(jsonArticulos);
	contenido += "</div></div></td>";
	return contenido;
}

function generaColCompraExistencia(jsonArticulos) {
	let contenido = "";
	if (jsonArticulos.vigencia == "*") {
		contenido += "<td id='td_articulos' align='center' class='align-middle'  style='padding:5px;width:14%;max-width:14% !important;'>"
				+ "<p style='margin:0px;padding:0px'><label class='EPP_lb_size_20' style='font-weight: bold; color:#DC143C;'> $ "
				+ jsonArticulos.precio.replace(/(\d)(?=(\d\d\d)+(?!\d))/g,
						'$1,')
				+ "</label></p>"
				+ "<p style='margin:0px;padding:0px'><label class='ECC_lb_size_12' style='color:black;min-width:200px'> Precio a pagar con IVA</label></p>"
				+ "</td>" + "</tr>";
	} else {

		contenido += "<td id='td_articulos' align='center' class='align-middle'  style='padding:5px; width: 4% !important;'>"
				+
				// "<label class='EPP_lb_size_20' style='font-weight: bold;
				// color:#DC143C;'> $ "+ jsonArticulos.precio +"</label><br>"+
				"<table class='bordes table-striped table-hover tabla_importes tabla_importes_Movil' >"
				+ "<tr class='bordes'>"
				+ "<td class='bordes clr' style='background:#007bff;color:white !important;'>S/IVA</td>"
				+ "<td class='bordes clr' style='background:#007bff;color:white !important;'>C/IVA</td>"
				+ "</tr>";
		contenido += "<tr class='bordes'>"
				+ "<td class='bordes'>$ "
				+ jsonArticulos.precio
				+ "</td>"
				+ "<td class='bordes'>$ "
				+ parseFloat(jsonArticulos.precio_iva).toFixed(2).replace(
						/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,') + "</td>" + "</tr>";
		contenido += "<tr class='bordes'>"
				+

				"<td  colspan=2 class='bordes'><label class='ECC_lb_size_12' style='font-weight: bold' > Mult. Vta.: "
				//+ jsonArticulos.multiplo_venta + " " + jsonArticulos.cve_venta + " " + jsonArticulos.multiplo_rc + " PZ" +"</label> </td>" +
				+ jsonArticulos.multiplo_venta + " - " + jsonArticulos.multiplo_rc + " PZ" +"</label> </td>" +
				// "<td class='bordes'>"+ jsonArticulos.multiplo_venta +"</td>"
				// +
				"</tr>";

		contenido += "</table>"
				+

				"<div style='display: inline-block;'>"
				+ "<label class='ECC_lb_size_12' style='font-weight: bold' > Cant.:</label>&nbsp;"
				+ "<input  type='text' id='txt_"
				+ jsonArticulos.num_art_cdo.replace("[", "").replace("]", "")
				+ "'  style='font-size: 12px; font-family: arial;  width: 50px' onkeypress='return EsNumero(event,"
				+ JSON.stringify(jsonArticulos)
				+ ")'  >&nbsp;"
				+ "<button class='btn btn-primary' onclick='validarExistenciasArticulo("
				+ JSON.stringify(jsonArticulos)
				+ ")' style='padding-left:10px; padding-right:10px; padding-top:2px; padding-bottom:2px; font-size: 12px; font-family: arial;'>Agregar</button>"
				+ "</div>" + "</td>" + "</tr>";

		// contenido +="<td id='td_articulos' align='center'
		// class='align-middle' style='padding:5px; width:14%;max-width:14%
		// !important;'>"+
		// "<label class='EPP_lb_size_20' style='font-weight: bold;
		// color:#DC143C;'> $ "+ jsonArticulos.precio +"</label><br>"+
		// "<label class='ECC_lb_size_12' style='color:black;min-width:200px'>
		// Precio a pagar con IVA</label><br>"+
		// "<div style='display: inline-block;'>" +
		// "<label class='ECC_lb_size_12' style='font-weight: bold' >
		// Cant.:</label>&nbsp;"+
		// "<input type='text' id='txt_" +jsonArticulos.num_art_cdo+ "'
		// style='font-size: 12px; font-family: arial; width: 50px'
		// onkeypress='return EsNumero(event)' >&nbsp;"+
		// "<button class='btn btn-primary'
		// onclick='validarExistenciasArticulo("+ JSON.stringify(jsonArticulos)
		// +")' style='padding-left:10px; padding-right:10px; padding-top:2px;
		// padding-bottom:2px; font-size: 12px; font-family:
		// arial;'>Agregar</button>"+
		// "</div>" +
		// "</td>"+
		// "</tr>";
	}
	return contenido;
}

function generaColMarcasKexOep(jsonArticulos) {
	let contenido = "";
	if (jsonArticulos.marca == "OEP") {
		contenido += "<div style='display: inline-block;' valign='bottom'>"
				+ "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/logoOep.png' class='ECC_img_logosKwxOep'>"
				+ "</div>" + '<br>';
	} else if (jsonArticulos.marca == "KWX") {
		contenido += "<div style='display: inline-block;' valign='bottom'>"
				+ "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/logoKwx.png' class='ECC_img_logosKwxOep'>"
				+ "</div>" + '<br>';
	}
	return contenido;
}

function generaColComparativaMarcasCDOS(jsonArticulos) {
	let contenido = "";
	if (jsonArticulos.num_art_marca_propia != "") {
		contenido += "<div style='display: inline; padding:5px' valign='middle'>"
				+ "<img src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/logoKwx.png' class='ECC_img_logosKwxOep'>"
				+ "<button onclick='consultaArtiuloMarcaCDO("
				+ '"'
				+ jsonArticulos.num_art_marca_propia
				+ '"'
				+ ")' type='button'  class='btn btn-link primary'  style='font-weight: bold; color:#DC143C;  background-color: #FDEDEC ; padding:3px; text-decoration: underline;'>"
				+ 'Producto: &nbsp;'
				+ jsonArticulos.num_art_marca_propia
				+ '&nbsp;Ahorra&nbsp; '
				+ jsonArticulos.varianza_marca_propia
				+ "% " + "</button>" + "</div>" + '<br>';
	}
	return contenido;
}

function consultaArtiuloMarcaCDO(num_art) {
	document.getElementById('cargando').style.display = 'block';
	$
			.ajax({
				url : 'CarritoDeCompras',
				data : "vista=CarritoDeCompras.jsp&operacion=ConsultaArticuloMarcaPropia&desc_articulo="
						+ num_art,
				type : 'POST',
				dataType : 'Json',
				success : function(jsonArticulosMarcaCdo) {
					var jsonMarcCdo;

					for (let i = 0; i < jsonArticulosMarcaCdo.length; i++) {

						jsonMarcCdo = jsonArticulosMarcaCdo[i];

					}

					consultaImagenesArticulos(jsonMarcCdo);
					document.getElementById('cargando').style.display = 'none';
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al buscar productos.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
				}
			});
}

/** *** CONSULTA DE PANTALLA EMERGENTE DE IMAGENES **** */
function consultaImagenesArticulos(jsonArticulos) {
	$('#divGaleriaImg').empty();
	$('#divGaleriaImgMini').empty();
	let imagenesEcomm = jsonArticulos.imagen_ecommerce;
	let arrayImagenes = jsonArticulos.imagen_bxa.split(',');
	let contenidoImgMini = "";
	let contenidoImg = "";
	$('#lb_productoFotoNombre').text(jsonArticulos.descripcion_producto);
	$('#lb_productoFotoClave').text(
			jsonArticulos.num_art_cdo.replace("[", "").replace("]", ""));
	// $('#lb_productoFotoPrecio').text("$ " +
	// jsonArticulos.precio.toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g,
	// '$1,'));
	// $('#lb_productoFotoPrecioIVA').text("$ " + ( jsonArticulos.precio *
	// 1.16).toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,') );
	$('#lb_productoFotoPrecio').text("$ " + jsonArticulos.precio);
	var precioN = jsonArticulos.precio.replace("$", "").replace(",", "");
	$('#lb_productoFotoPrecioIVA').text(
			"$ "
					+ (precioN * 1.16).toFixed(2).replace(
							/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));
	if (imagenesEcomm.trim() != "") {
		contenidoImgMini += "<div   class='col-xs-12 col-sm-12 col-md-12 col-lg-12' style='text-align:center;padding: 5px'  >"
				+ "<div  id='div_bol_"
				+ 0
				+ "' style='font-weight: bold;background-color: #F5F5F5 ; border: 1px solid #DDDDDD;' "
				+ "onmouseover='mostrarImgGaleriaSeleccionado("
				+ 0
				+ ","
				+ 1
				+ ")'>"
				+ "<img class='imgGaleriaMini' src='https://www.autorep.mx/konakart/images/"
				+ imagenesEcomm
				+ "' "
				+ "style=' width: 100%; border-radius: 8px; padding: 5px' "
				+ ")'> </img>" + "</div>" + "</div>";
		contenidoImg += "<div id='div_boletin_"
				+ 0
				+ "' class='col-0 col-sm-0 col-md-12 col-lg-12' style='text-align:center;'>"
				+ "<img  class='imgGaleriaGrande' src='https://www.autorep.mx/konakart/images/"
				+ imagenesEcomm + "'  style=' border-radius: 8px'></img>"
				+ "</div>";
	} else {
		for (let i = 0; i < arrayImagenes.length; i++) {
			contenidoImgMini += "<div   class='col-xs-12 col-sm-12 col-md-12 col-lg-12' style='text-align:center;padding: 5px'  >"
					+ "<div  id='div_bol_"
					+ i
					+ "' style='font-weight: bold;background-color: #F5F5F5 ; border: 1px solid #DDDDDD;' "
					+ "onmouseover='mostrarImgGaleriaSeleccionado("
					+ i
					+ ","
					+ arrayImagenes.length
					+ ")'>"
					+ "<img class='imgGaleriaMini' src='https://webcdo.cdoautopartes.com.mx/image/"
					+ arrayImagenes[i]
					+ "' "
					+ "style=' width: 100%; border-radius: 8px; padding: 5px' "
					+ ")'> </img>" + "</div>" + "</div>";
		}
		for (let i = 0; i < arrayImagenes.length; i++) {
			if (i <= 0) {
				contenidoImg += "<div id='div_boletin_"
						+ i
						+ "' class='col-0 col-sm-0 col-md-12 col-lg-12' style='text-align:center;'>"
						+ "<img  class='imgGaleriaGrande' src='https://webcdo.cdoautopartes.com.mx/image/"
						+ arrayImagenes[i]
						+ "'  style=' border-radius: 8px'></img>" + "</div>";
			} else {
				contenidoImg += "<div id='div_boletin_"
						+ i
						+ "' class='col-0 col-sm-0 col-md-12 col-lg-12' style='text-align:center;display:none'>"
						+ "<img  class='imgGaleriaGrande' src='https://webcdo.cdoautopartes.com.mx/image/"
						+ arrayImagenes[i]
						+ "'  style='border-radius: 8px'></img>" + "</div>";
			}
		}
	}

	$("#txt_divGaleriaImagenes_cantidad").attr(
			'onkeypress',
			'return EsNumeroDesdeImagen(event,' + JSON.stringify(jsonArticulos)
					+ ')');
	$("#btn_divGaleriaImagenes_agregar").attr(
			'onClick',
			'validarExistenciasArticuloDesdeImagen('
					+ JSON.stringify(jsonArticulos) + ');');
	$("#divGaleriaImg").append(contenidoImg);
	$("#divGaleriaImgMini").append(contenidoImgMini);
	MostrarDiv('divGaleriaImagenes');
}

function mostrarImgGaleriaSeleccionado(id_boletin, listaBoletines) {
	let id;
	for (let i = 0; i <= listaBoletines; i++) {
		if (i == id_boletin) {
			id = 'div_boletin_' + id_boletin;
			$("#" + id).slideDown(600);
		} else {
			id = 'div_boletin_' + i;
			document.getElementById(id).style.display = 'none';
		}
	}
}

/** *** CONSULTA SUBMARCAS **** */
function consultaSubmarcas() {
	$
			.ajax({
				url : 'CarritoDeCompras',
				data : "vista=CarritoDeCompras.jsp&operacion=ConsultaSubMarcas&cve_armadora="
						+ $("#cbo_marca_aplicacion").val(),
				type : 'POST',
				dataType : 'Json',
				success : function(jsonSubMarcas) {
					llenarComboSubMarcas(jsonSubMarcas)
					$('#cbo_auto_aplicacion').val("0");
					$('#cbo_modelo_aplicacion').val("0");
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al buscar marcas.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
				}
			});
}

function llenarComboSubMarcas(jsonSubmarcas) {
	let combo = $('#cbo_auto_aplicacion');
	let cmbAno = $('#cbo_modelo_aplicacion');
	combo.empty();
	cmbAno.empty();

	$('<option>').val('0').text('-- Selecciona --').appendTo(combo);
	for (let i = 0; i < jsonSubmarcas.length; i++) {
		$('<option>').val(jsonSubmarcas[i].nombre_submarca).text(
				jsonSubmarcas[i].nombre_submarca).appendTo(combo);
	}

	let fecha = new Date();
	let ano = fecha.getFullYear();
	$('<option>').val('0').text('-- Selecciona --').appendTo(cmbAno);
	for (let i = ano; i > 1950; i--) {
		$("<option value=" + i + ">" + i + "</option>").appendTo(cmbAno);
	}
}

/** *** ORDENAMIENTO DEL CARRITO DE COMPRAS **** */
function ordenaArticulosCarrito() {
	document.getElementById('cargando').style.display = 'block';
	ocultarControles()
	MostrarDiv("divConsultaPorAplicacion");
	$
			.ajax({
				url : 'CarritoDeCompras',
				data : "vista=CarritoDeCompras.jsp&operacion=OrdenarArticulosCarrito&ordenar="
						+ $("#cbo_orden_productos").val(),
				type : 'POST',
				dataType : 'Json',
				success : function(jsonArticulos) {
					document.getElementById('cargando').style.display = 'none';
					llenaGridArticulos(jsonArticulos)
					MostrarDiv('div_ArticulosXAplicacion')
					OcultarDiv('div_MarcasPrincipalesCdo');
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al ordenar articulos.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
				}
			});
}

/** *** ACCIONES GENERALES DEL CARRITO **** */
function ocultarControles() {
	OcultarDiv("divConsultaPorAplicacion");
	OcultarDiv("divEstadoDeCuenta");
	OcultarDiv("divSeguimientoDePedido");
	OcultarDiv("divSeguimientoOtrosPedido");
	OcultarDiv("divCarritoDeComprasArticulos");
	$('#tbSugerencias').empty();
}

function limpiaFiltrosArticulos() {
	$("#txt_num_articulo").val("")
	$('#div_ArticulosCarrito').empty();
	$("#cbo_marca_aplicacion").val("-1")
	$("#cbo_auto_aplicacion").val("0")
	$("#cbo_modelo_aplicacion").val("0")
	$("#cbo_cilindros_aplicacion").val("0")
	$("#cbo_litros_aplicacion").val("0")
	OcultarDiv('div_ArticulosXAplicacion');
	OcultarDiv('divBusquedaPorAutomovil');
	MostrarDiv('div_MarcasPrincipalesCdo');
	$('#tbSugerencias').empty();
}

function mostrarControles(div) {
	$("#navbarsExample02").collapse('hide');
	$("#navbarsExample02").removeClass("in");
	ocultarControles()
	limpiaFiltrosArticulos()
	MostrarDiv("divConsultaPorAplicacion");
	MostrarDiv(div);
}

/** *** VALIDA EXISTENCIASEN DB POR ARYICULO **** */
function validarExistenciasArticulo(jsonArticulos) {

	let txt = "#txt_"
			+ jsonArticulos.num_art_cdo.replace("[", "").replace("]", "");
	if ($(txt).val() == "" || $(txt).val() == 0) {
		alert("Ingresa una cantidad valida.")
	} else {
		validaExistenciasEnBD(jsonArticulos, $(txt).val())
	}
}

function validarExistenciasArticuloDesdeImagen(jsonArticulos) {
	if ($("#txt_divGaleriaImagenes_cantidad").val() == ""
			|| $("#txt_divGaleriaImagenes_cantidad").val() == 0) {
		alert("Ingresa una cantidad valida.")
	} else {
		OcultarDiv('divGaleriaImagenes');
		validaExistenciasEnBD(jsonArticulos, $(
				"#txt_divGaleriaImagenes_cantidad").val())
	}
}

function validarExistenciasArticuloDesdeImagenMod(jsonArticulos) {
	if ($("#txt_ModdivGaleriaImagenes_cantidad").val() == ""
			|| $("#txt_ModdivGaleriaImagenes_cantidad").val() == 0) {
		alert("Ingresa una cantidad valida.")
	} else {
		OcultarDiv('divModificaCantidad');
		validaExistenciasEnBDMOD(jsonArticulos, $(
				"#txt_ModdivGaleriaImagenes_cantidad").val())
	}
}

function validaExistenciasEnBD(jsonArticulos, cantidad) {
	cantidad = CalculaMultiplo(cantidad, jsonArticulos.multiplo_venta);

	document.getElementById('cargando').style.display = 'block';

	$
			.ajax({
				url : 'CarritoDeCompras',
				data : "vista=CarritoDeCompras.jsp&operacion=ConsultaExistenciaArticulo&num_articulo="
						+ jsonArticulos.num_art_cdo.replace("[", "").replace(
								"]", "") + "&cant_pedida=" + cantidad,
				type : 'POST',
				dataType : 'Json',
				success : function(jsonExistenciasArticulo) {

					llenaInformacionDeArticulo(jsonArticulos,
							jsonExistenciasArticulo);

					$("#ExistenciasArticulo_BotonComprar").attr(
							'onClick',
							'ComprarArticulo(' + JSON.stringify(jsonArticulos)
									+ ', '
									+ JSON.stringify(jsonExistenciasArticulo)
									+ ');');

					document.getElementById('cargando').style.display = 'none';
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al buscar marcas.')
					document.getElementById('cargando').style.display = 'none';
					window.location.href = 'http://www.cdoautopartes.com.mx/';
				}
			});
}

function validaExistenciasEnBDMOD(jsonArticulos, cantidad) {
	document.getElementById('cargando').style.display = 'block';

	$
			.ajax({
				url : 'CarritoDeCompras',
				data : "vista=CarritoDeCompras.jsp&operacion=ConsultaExistenciaArticulo&num_articulo="
						+ jsonArticulos.numArticuloCDO.replace("[", "")
								.replace("]", "") + "&cant_pedida=" + cantidad,
				type : 'POST',
				dataType : 'Json',
				success : function(jsonExistenciasArticulo) {
					llenaInformacionDeArticuloMOD(jsonArticulos,
							jsonExistenciasArticulo);

					$("#MODExistenciasArticulo_BotonComprar").attr(
							'onClick',
							'ActualizaCantidadesArticulo('
									+ JSON.stringify(jsonArticulos) + ', '
									+ JSON.stringify(jsonExistenciasArticulo)
									+ ');');

					document.getElementById('cargando').style.display = 'none';
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al buscar marcas.')
					document.getElementById('cargando').style.display = 'none';
					window.location.href = 'http://www.cdoautopartes.com.mx/';
				}
			});
}

function llenaInformacionDeArticulo(jsonArticulos, jsonExistenciasArticulo) {

	var src1 = '';

	let imgEcommerce = jsonArticulos.imagen_ecommerce;
	$('#div_mensaje_envio_expres').hide();
	var src1 = "";
	try {
		$("#ExistenciasArticulo_NumArt").html(
				"ARTICULO: "
						+ jsonArticulos.num_art_cdo.replace("[", "").replace(
								"]", ""));
		let arrayImg = jsonArticulos.imagen_bxa.split(',')

		if (imgEcommerce.trim() != "") {

			var src1 = 'https://www.autorep.mx/konakart/images/' + imgEcommerce;
			// contenido += "<img src='image/" + imgEcommerce+ "'
			// class='ECC_img_articulos' style='cursor: pointer;max-width:200px'
			// onclick=\"consultaImagenesArticulos('"
			// +jsonArticulos.imagen_ecommerce +"', '" +
			// jsonArticulos.imagen_bxa +"','" + jsonArticulos.descripcion +
			// "','"+ jsonArticulos.num_art_cdo +"','" +jsonArticulos.precio+
			// "')\">";
		} else {
			src1 = 'https://webcdo.cdoautopartes.com.mx/image/' + arrayImg[0];
			// contenido += "<img src='image/" + arrayImg[0]+ "'
			// class='ECC_img_articulos' style='cursor: pointer;max-width:200px'
			// onclick=\"consultaImagenesArticulos('"
			// +jsonArticulos.imagen_ecommerce +"', '" +
			// jsonArticulos.imagen_bxa +"','" +jsonArticulos.descripcion+ "','"
			// + jsonArticulos.num_art_cdo + "','" + jsonArticulos.precio +
			// "')\">";
		}
	} catch (e) {
		src1 = 'https://webcdo.cdoautopartes.com.mx/image'
				+ jsonArticulos.imagenArticulo;
		$("#ExistenciasArticulo_NumArt").html(
				"ARTICULO: "
						+ jsonArticulos.nombreArticulo.replace("[", "")
								.replace("]", ""));

	}
	$("#ExistenciasArticulo_Imagen").attr("src", src1);
	$("#ExistenciasArticulo_Descripcion").html(
			jsonArticulos.descripcion_producto);

	$('#ExistenciasArticulo_divTablaCantidades').empty();

	$("#solicitaTraspaso").prop('checked', false);

	$('#div_mensaje_traspaso').hide();
	var contenido = '<table   width="98%" align="center" class="table" >'
			+ '<thead  style="padding: 2px">'
			+ '<tr>'
			+ '<td width="25%" align="center"  style="padding: 2px"><label class="ECC_lb_size_12">Cantidad <br> Pedida</label></td>';
	
	if (jsonExistenciasArticulo.existenciaBR > 0) {
		contenido += '<td width="25%" align="center"  style="padding: 2px"><label class="ECC_lb_size_12">Surtido <br>  CDO - '
				+ jsonExistenciasArticulo.cdoBrDescripcion + '</label></td>';
	}

	if (jsonExistenciasArticulo.exietnciaCDO > 0) {
		contenido += '<td width="25%" align="center"  style="padding: 2px"><label class="ECC_lb_size_12">Surtido <br>  CDO - '
				+ jsonExistenciasArticulo.cdoMacroDescripcion
				+ ' </label> </td>';
	}

	if (jsonExistenciasArticulo.exietnciaTraspaso > 0) {
		if (jsonExistenciasArticulo.articuloBloqueo72hrs == "N") {
			$("#solicitaTraspaso").prop('checked', true);
			$('#div_mensaje_traspaso').show();
			contenido += '<td width="25%" align="center"  style="padding: 2px"><label class="ECC_lb_size_12">Surtido <br>  72 Hrs -'
					+ jsonExistenciasArticulo.cdoTraspasoDescripcion
					+ '</label></td>';
		} else {
			$("#solicitaTraspaso").prop('checked', false);
			$('#div_mensaje_traspaso').hide();
		}
	}
	contenido += '</thead>'
			+ '<tbody>'
			+ '<tr>'
			+ '<td align="center"><strong><label class="ECC_lb_size_16" style="font-weight: bold; color:black">'
			+ jsonExistenciasArticulo.cantidadPedida.toLocaleString("en-US")
			+ '</label></strong></td>';
	if (jsonExistenciasArticulo.existenciaBR > 0) {
		contenido += '<td align="center"><strong><label class="ECC_lb_size_16" style="font-weight: bold; color:black">'
				+ jsonExistenciasArticulo.existenciaBR.toLocaleString("en-US");
		+'</label></strong></td>';
	}
	
	if (jsonExistenciasArticulo.exietnciaCDO > 0) {
		contenido += '<td align="center"><strong><label class="ECC_lb_size_16" style="font-weight: bold; color:black">'
				+ jsonExistenciasArticulo.exietnciaCDO.toLocaleString("en-US");
		+'</label></strong></td>';
	}
	
	if (jsonExistenciasArticulo.exietnciaTraspaso > 0) {
		if (jsonExistenciasArticulo.articuloBloqueo72hrs == "N") {
			contenido += '<td align="center"><strong><label class="ECC_lb_size_16" style="font-weight: bold; color:black">'
					+ jsonExistenciasArticulo.exietnciaTraspaso
							.toLocaleString("en-US");
			+'</label></strong></td>';
		}
	}
	contenido += '</tr>' + '</tbody>' + '</table>';

	if (jsonExistenciasArticulo.articuloBloqueoExpress == "S") {
		$('#div_mensaje_envio_expres').show();
	} else {
		$('#div_mensaje_envio_expres').hide();
	}

	document.getElementById('div_sin_existencia').style.display = 'none';
	if (jsonExistenciasArticulo.existenciaBR == 0 && jsonExistenciasArticulo.exietnciaCDO == 0 && jsonExistenciasArticulo.exietnciaTraspaso == 0)
	{
		document.getElementById('div_sin_existencia').style.display = 'block';
		 
	}
	
	
	$("#ExistenciasArticulo_divTablaCantidades").append(contenido);

	MostrarDiv('divExistenciasArticulo');
}

/** *** CONSULTA PEDIDO ACTUAL EN EL CARRITO DE COMPRAS **** */
function consultaPedidoEnCarrito() {
	document.getElementById('cargando').style.display = 'block';

	$("#navbarsExample02").collapse('hide');
	$("#navbarsExample02").removeClass("in");

	$
			.ajax({
				url : 'MantenimientoCarritoCompras',
				data : "vista=MantenimientoCarritoCompras.jsp&operacion=ConsultaDetallePedidoEnCarrito",
				type : 'POST',
				dataType : 'Json',
				success : function(json) {
					document.getElementById('cargando').style.display = 'none';
					let jsonHeaderPedido = json.encabezadoPedido;
					let jsonDetallePedido = json.detallePedido;
					let jsonConsignatrios = json.listConsignatarios;
					let jsonTransportes = json.listTransportes;
					let jsonDistancias = json.listaDistancias;

					let InfoCliente = json.infoCte;

					cargaEncabezadoPedidoCarrito(jsonHeaderPedido, InfoCliente);
					cargaDetallePedidoCarrito(jsonDetallePedido, InfoCliente)
					ocultarControles();
					cargarDistancias(jsonDistancias);
					cargarTransportes(jsonTransportes, InfoCliente);
					cargarConsintarios(jsonConsignatrios)
					OcultarDiv('divSeguimientoPEdidoActual');
					MostrarDiv('divCarritoDeComprasArticulos');
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al consultar carrito de compras.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
				}
			});
}

function cargaEncabezadoPedidoCarrito(jsonHeaderPedido, InfoCliente) {

	$("#btnArticulosEnElCarrito").html(
			" ( " + jsonHeaderPedido.totalArticulosEnCarrito + " ) ");

	if (jsonHeaderPedido.totalArticulosEnCarrito > 0) {
		$("#btnArticulosEnElCarrito").removeClass("estiloCarritoProductosCERO");
		$("#btnArticulosEnElCarrito").addClass('estiloCarritoProductosLleno');

	} else {
		$("#btnArticulosEnElCarrito")
				.removeClass('estiloCarritoProductosLleno');
		$("#btnArticulosEnElCarrito").addClass("estiloCarritoProductosCERO");
	}
	$("#lb_numeroPedidoEnCarro").text(jsonHeaderPedido.num_pedido);
	$("#lb_seguro_maniobra_cte").text(InfoCliente.syf_cdo);
	$("#lb_distancia_cte").text(InfoCliente.distancia_cdo);
	$("#hide_desglosaIva").text(InfoCliente.desglosaIva);
	// alert("InfoCliente.fac_descuento: " + InfoCliente.fac_descuento)
	$("#hide_facDescuento").text(InfoCliente.fac_descuento);

	$("#lb_rfcliente").text("");
	if (InfoCliente.desglosaIva == "N") {
		$("#lb_rfcliente").text(InfoCliente.rfc);
	}
}

function cargaDetallePedidoCarrito(jsonArticulos, InfoCliente) {
	$('#div_tranpsote_expres').show();
	$('#div_mensaje_expres_termina_compra').hide();
	$('#dgDetalleConsultaArticulos').empty();
	let contenido = generaTitulosDePedidoCarrito();

	var desglosaIva = $("#hide_desglosaIva").text();
	var facDescuento = $("#hide_facDescuento").text();

	var importe = 0.00;
	var importeArt = 0.00;
	var iva = 0.00;
	var subTotal = 0.00;
	var total = 0.00;
	var descuentos = 0.00;
	for (let i = 0; i < jsonArticulos.length; i++) {
		contenido += "<tr id='tr_articulosPedCarrito'>";
		/** * Foto articulo ** */
		contenido += generaColFotoInicialPedidoCarrito(jsonArticulos[i])

		/** * Detalle articulo ** */
		contenido += generaColDetalleProductoPedidoCarrito(jsonArticulos[i])

		if (desglosaIva == "S") {
			importe = importe + parseFloat(jsonArticulos[i].importe);
			importeArt = parseFloat(jsonArticulos[i].importe);
		} else {
			importe = importe + parseFloat(jsonArticulos[i].importe * 1.16);
			importeArt = parseFloat(jsonArticulos[i].importe * 1.16);
		}
		// alert("jsonArticulos[i].descuentoXMarca: " +
		// jsonArticulos[i].descuentoXMarca);
		if (jsonArticulos[i].descuentoXMarca == "S") {
			// alert( "jsonArticulos[i].descuentoXMarca: " +
			// jsonArticulos[i].descuentoXMarca + "\n descuentos: " + descuentos
			// + " : " + importeArt + " menos [ " + importeArt + " por "+
			// jsonArticulos[i].porcDescuento + "] " ) ;
			descuentos = descuentos + importeArt
					- (importeArt * parseFloat(jsonArticulos[i].porcDescuento));
		} else {
			// alert( "jsonArticulos[i].descuentoXMarca: " +
			// jsonArticulos[i].descuentoXMarca + "\n descuentos: " + descuentos
			 //+ " : " + importeArt + " menos [ " + importeArt + " por "+
			 //parseFloat(facDescuento) + "] " ) ;
			descuentos = descuentos + importeArt
					- (importeArt * parseFloat(facDescuento));
		}

		if (jsonArticulos[i].bloqueoExpres == "S") {
			$('#div_mensaje_expres_termina_compra').show();
			$('#div_tranpsote_expres').hide();
		}
	}
	// alert("Total descuentos: " + descuentos)
	// calcuando importes. //
	subTotal = importe - descuentos;

	if (desglosaIva == "S") {
		iva = subTotal * 0.16;
	} else {
		iva = 0.00;
	}

	total = subTotal + iva;

	$("#lb_subtotalCarritoCompras").text(
			"$ "
					+ importe.toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g,
							'$1,'));
	$("#lb_descuentos").text(
			"$ "
					+ descuentos.toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g,
							'$1,'));
	$("#lb_seguro_cte").text("$ 0.00");
	$("#lb_maniobra_cte").text("$ 0.00");
	$("#lb_subtotalCarritoComprasSyM").text(
			"$ "
					+ subTotal.toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g,
							'$1,'));
	$("#lb_IvaCarritoCompras").text(
			"$ " + iva.toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));
	$("#lb_TOTALCarritoCompras").text(
			"$ " + total.toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));
	// $("#tr_Seguro").hide();
	// $("#tr_Maniobra").hide();

	contenido += "</tbody>" + "</table>";
	$("#dgDetalleConsultaArticulos").append(contenido);
	aplicarEstiloTablaPedidoCarrito();
}

function generaTitulosDePedidoCarrito() {
	let contenido = "<table id='tb_articulosPedCarrito' align='left' cellpadding=0px; cellspacing=0px; class='table table-hover' style='width:100%; background:white' data-page-length='5'>"
			+ "<thead  id='thd_articulosPedCarrito' style='background-color:white; color:#0054A2' >"
			+ "<tr id='tr_articulosPedCarrito'>"
			+ "<th style='text-align: center;padding:2px;position: sticky; width: 10%;'><label class='EPP_lb_size_12' style='font-weight: bold; '>PRODUCTO</label> </th>"
			+ "<th id='th_articulosPedCarrito1'style='text-align: center;padding:2px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'></label></th>"
			+ "<th id='th_articulosPedCarrito1'style='text-align: center;padding:2px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'>CANTIDAD</label></th>"
			+ "<th id='th_articulosPedCarrito1' style='text-align: center;padding:2px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'>POR SURTIR</label></th>"
			+ "<th id='th_articulosPedCarrito1' style='text-align: center;padding:2px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'>IMPORTE</label></th>"
			+ "<th id='th_articulosPedCarrito1'style='text-align: center;padding:2px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'></label></th>"
			+ "</tr>" + "</thead>" + "<tbody id='tbd_articulosPedCarrito'>";
	return contenido;
}

function generaColFotoInicialPedidoCarrito(jsonArticulos) {
	let imgEcommerce = jsonArticulos.imagen_ecommerce;
	let arrayImg = jsonArticulos.imagen_bxa.split(',')
	let contenido = "";
	if (imgEcommerce.trim() != "") {
		contenido = "<td  id='td_articulosPedCarrito' align='center' style='width: 10%;padding:5px;background-color:#FAFAFA '>";
		contenido += "<img src='https://www.autorep.mx/konakart/images/"
				+ imgEcommerce + "' class='ECC_img_articulos_carrito' \">";
		contenido += "</td>";
	} else {
		contenido = "<td  id='td_articulosPedCarrito' align='center' style='width: 10%;padding:5px;background-color:#FAFAFA '>";
		contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/"
				+ arrayImg[0] + "' class='ECC_img_articulos_carrito' \">";
		contenido += "</td>";
	}

	return contenido;
}

function generaColDetalleProductoPedidoCarrito(jsonArticulos) {
	// alert(JSON.stringify(jsonArticulos));
	let contenido = "<td  id='td_articulosPedCarrito' style='padding:5px' align='left'>"
			+ "<label class='ECC_lb_size_16' style='color:#00498A; font-weight: bold'>"
			+ jsonArticulos.nombreArticulo.replace("[", "").replace("]", "")
			+ "</label><br>"
			+
			// "<label class='EPP_vista_movil' style='font-weight: bold;
			// color:black;'> "+ "Producto: " + "</label>"+
			"<label class='ECC_lb_size_14' style='font-weight: bold;color: white;background: black;padding-right: 5px;padding-left: 5px; border-radius: 6px;'> ARTICULO: "
			+ jsonArticulos.numArticuloCDO
			+ "</label><br class='EPP_vista_normal'>"
			+ "<label class='EPP_vista_movil' style='font-weight: bold; color:black;'> "
			+ "Precio: "
			+ "</label>"
			+ "<label class='ECC_lb_size_14' style='color:black;font-weight: normal;'> $ "
			+ parseFloat(jsonArticulos.precioArticulo).toFixed(2).replace(
					/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,') + "</label>";

	if (jsonArticulos.bloqueoExpres == "S") {
		contenido += "<br/><br/><label class='ECC_lb_size_12' style='font-weight: normal;color: red;'> Este articulo no se envia por Servicio Expres</label>";
	}
	contenido += "</td>";

	contenido += "<td id='td_articulosPedCarrito'  style='padding:5px;diplay:inline;'  align='center'>"
			+ "<label class='EPP_vista_movil' style='font-weight: bold; color:black;'> "
			+ "Cantidad: "
			+ "</label>"
			+ "<input  type='text'  id='formGroupExampleInput'  style='font-size: 12px; font-family: arial;  width: 60px; text-align:center;'  value='"
			+ jsonArticulos.cantidadPedida.toLocaleString("en-US")
			+ "' disabled>"
			+ "<button type='button' class='btn btn-outline-dark' style='padding-top: 0px;padding-bottom: 0px;padding-left: 0px;padding-right: 0px; margin-left: 3px;' onclick='modificaCantidad("
			+ JSON.stringify(jsonArticulos) + ")' > + / - </button>" +
			// "<img
			// src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/edit_carrito.png'
			// onclick='modificaCantidad(" + JSON.stringify(jsonArticulos) + ")'
			// \">"+
			// "<img
			// src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/edit_carrito.png'
			// \">"+
			"</td>";

	contenido += "<td  id='td_articulosPedCarrito'  style='padding:5px' align='left'>"
			+ "<label class='EPP_vista_movil' style='font-weight: bold; color:black;'> "
			+ "Por surtir: " + "</label>";
	
	if (jsonArticulos.cantidadPorSurtirBr > 0) {
		contenido += "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> CDO - "
				+ jsonArticulos.cdoBr
				+ ": </label>"
				+ "<label class='ECC_lb_size_12' style='font-weight: bold; color:black;'> "
				+ jsonArticulos.cantidadPorSurtirBr + "</label><br>";
	}
	
	if (jsonArticulos.cantidadPorSurtirCdo > 0) {

		contenido += "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> CDO - "
				+ jsonArticulos.cdoMacro
				+ ": </label>"
				+ "<label class='ECC_lb_size_12' style='font-weight: bold; color:black;'> "
				+ jsonArticulos.cantidadPorSurtirCdo + "</label><br>";
	}

	if (jsonArticulos.cantidadPorSurtir72 > 0) {
		contenido += "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> 72 Hrs - "
				+ jsonArticulos.cdoTraspaso
				+ " : </label>"
				+ "<label class='ECC_lb_size_12' style='font-weight: bold; color:black;'> "
				+ jsonArticulos.cantidadPorSurtir72 + "</label>";
	}
	if (jsonArticulos.cantidadPorSurtirBr == 0  && jsonArticulos.cantidadPorSurtirCdo == 0 && jsonArticulos.cantidadPorSurtir72 == 0)
		{
		contenido += "<label class='ECC_lb_size_12' style='font-weight: normal; color:black;'> Sin Existencia </label><br>";
		}
	contenido += "</td>";

	contenido += "<td id='td_articulosPedCarrito'  style='padding:5px' align='right' >"
			+ "<label class='EPP_vista_movil' style='font-weight: bold; color:black;'> "
			+ "Importe:"
			+ "</label>"
			+
			// "<label class='ECC_lb_size_14' style='font-weight: normal;
			// color:black;'>$ " +
			// parseFloat(jsonArticulos.importe.toLocaleString('en-IN')).toFixed(2)
			// + "</label>"+
			"<label class='ECC_lb_size_14' style='font-weight: normal; color:black;'> $ "
			+ parseFloat(jsonArticulos.importe).toFixed(2).replace(
					/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,') + "</label>" + "</td>";

	contenido += "<td id='td_articulosPedCarrito'  style='padding:5px' align='right' >"
			+
			// "<img class='EPP_vista_normal'
			// src='https://webcdo.cdoautopartes.com.mx/image/paginaInicio/delete_carrito.png'
			// onclick='cargarInfoEliminarArticulo("+
			// JSON.stringify(jsonArticulos) +")'>"+
			"<button class='btn btn-danger EPP_vista_normal'  style='padding-left: 2px;padding-right: 2px;padding-top:2px;padding-bottom:2px;font-size: 12px;font-family: arial;width:50%;' onclick='cargarInfoEliminarArticulo("
			+ JSON.stringify(jsonArticulos)
			+ ")'> X </button>"
			+ "<button class='btn btn-danger EPP_vista_movil'  style='padding-left:10px; padding-right:10px; padding-top:2px; padding-bottom:2px; font-size: 12px; font-family: arial; width:50%' onclick='cargarInfoEliminarArticulo("
			+ JSON.stringify(jsonArticulos)
			+ ")'>Eliminar Producto</button>"
			+ "</td>";

	return contenido;
}

function cargarTransportes(jsonTransportes, InfoCliente) {

	$('#rdoTransporte2').val(InfoCliente.transporte_cdo);
    // alert("jsonTransportes.length" + JSON.stringify(InfoCliente));
	//alert("jsonTransportes.length" + JSON.stringify(jsonTransportes));
	$('#cboTransportes').empty();
	let items = "<option value='0'>-- Selecciona --</option>";

	for (let i = 0; i < jsonTransportes.length; i++) {
		items += "<option value='" + jsonTransportes[i].cve_trasporte + "-" 
				+ jsonTransportes[i].tipoTransporte + "' > "
				+ jsonTransportes[i].nombre_trasporte + " </option>";
	}
	$("#cboTransportes").append(items);

	$("#cboTransportes").on('change', CalculaSeguroYManiobra);
}

function CalculaSeguroYManiobra() {
	// $("#tr_Seguro").hide();
	// $("#tr_Maniobra").hide();
	var transporteArr = $("#cboTransportes").val().split("-");

	$("#cboDistancias option").each(
			function() {
				var distanciaArr = $(this).text().split("-");
				if (transporteArr[1].trim() == distanciaArr[0].trim()) {
					if ($("#lb_distancia_cte").text().trim() == distanciaArr[1]
							.trim()) {
						var valores = $(this).attr('value');
						CalculaValoresSeguroManiobra(valores);
					}
				}
			});
}

function CalculaCteRecoge() {

	var importe = parseFloat($("#lb_subtotalCarritoCompras").text().replace(
			"$", "").replace(",", ""));
	var descuentos = parseFloat($("#lb_descuentos").text().replace("$", "")
			.replace(",", ""));
	$("#lb_seguro_cte").text("$ 0.00");
	$("#lb_maniobra_cte").text("$ 0.00");
	var iva = 0.00;
	var subTotal = 0.00;
	var total = 0.00;

	subTotal = importe - descuentos;
	iva = subTotal * 0.16;
	total = subTotal + iva;

	$("#lb_subtotalCarritoComprasSyM").text(
			"$ "
					+ subTotal.toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g,
							'$1,'));
	$("#lb_IvaCarritoCompras").text(
			"$ " + iva.toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));
	$("#lb_TOTALCarritoCompras").text(
			"$ " + total.toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));

	$("#cboTransportes").hide();

}

function seleccionaPaquetera() {
	$("#cboTransportes").val('0');

	$("#cboTransportes").show();

}

function CalculaValoresSeguroManiobra(cadenaValores) {
	var ValoresARR = cadenaValores.split("-");
	var importe = parseFloat($("#lb_subtotalCarritoCompras").text().replace(
			"$", ""));
	var descuentos = parseFloat($("#lb_descuentos").text().replace("$", ""));
	var totalSeguro = 0.00;
	var subtotal = importe - descuentos;
	var totalManiobra = 0.00;
	var iva = 0.00;

	var total = 0.00;

	var seguro = parseFloat(ValoresARR[0]) - 1;
	var maniobra = parseFloat(ValoresARR[1]) - 1;
   // alert("seguro: " + seguro + ".   maniobra: " + maniobra +"SyF_cte: "+ $("#lb_seguro_maniobra_cte").text() );
//	maniobra = maniobra.toFixed(4);
//	seguro = seguro.toFixed(4);

	var subtotalConSyM = 0.00;
	switch ($("#lb_seguro_maniobra_cte").text()) {
	case "1":
		var maniobra_cte = (importe * maniobra).toFixed(2)
		$("#lb_maniobra_cte").text( "$ " + 
				maniobra_cte.replace(/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));
		subtotalConSyM = subtotal + maniobra_cte;
		break;
	case "2":
		var seguro_cte = (importe * seguro).toFixed(2);
		// alert("seguro_cte: " + importe + " * " + seguro +" = " + seguro_cte);
		$("#lb_seguro_cte").text("$ " + 
				seguro_cte.replace(/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));
		subtotalConSyM = subtotal + seguro_cte;
		break;
	case "3":
		var maniobra_cte = (importe * (maniobra + seguro)).toFixed(2);
		$("#lb_maniobra_cte").text("$ " + 
				maniobra_cte.replace(/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));
		subtotalConSyM = subtotal + maniobra_cte;
		break;
	case "4":
		var maniobra_cte = (importe * maniobra).toFixed(2);
		var seguro_cte = (importe * seguro).toFixed(2);
		$("#lb_maniobra_cte").text("$ " + 
				maniobra_cte.replace(/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));
		$("#lb_seguro_cte").text("$ " + 
				seguro_cte.replace(/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));
		subtotalConSyM = subtotal + maniobra_cte + seguro_cte;
		break;
	default:
		$("#lb_maniobra_cte").text("$ 0.00");
		$("#lb_seguro_cte").text("$ 0.00");
	}

	$("#lb_subtotalCarritoComprasSyM").text(
			"$ "
					+ subtotalConSyM.toFixed(2).replace(
							/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));

	var iva = subtotalConSyM.toFixed(2) * .16;
	$("#lb_IvaCarritoCompras").text(
			"$ " + iva.toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));
	var total = subtotalConSyM + iva;
	$("#lb_TOTALCarritoCompras").text(
			"$ " + total.toFixed(2).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, '$1,'));
}

function cargarDistancias(jsonDistancias) {
	$('#cboDistancias').empty();
	let items = "<option value='0'>-- Selecciona --</option>";

	for (let i = 0; i < jsonDistancias.length; i++) {
		items += "<option value='" + jsonDistancias[i].porcSeguro + "-"
				+ jsonDistancias[i].porcManiobra + "' >"
				+ jsonDistancias[i].tipo + "-" + jsonDistancias[i].distancia
				+ "</option>";
	}
	$("#cboDistancias").append(items);
}

function cargarConsintarios(jsonConsignatrios) {

	if (jsonConsignatrios.length == 0) {
		$('#div_consignatarios').hide();
	} else {
		$('#div_consignatarios').show();
		$('#cboConsignatarios').empty();
		let items = "<option value='0'>-- Selecciona --</option>";

		for (let i = 0; i < jsonConsignatrios.length; i++) {
			if (jsonConsignatrios[i].numeroConsignatario.trim() != "") {
				items += "<option value='"
						+ jsonConsignatrios[i].numeroConsignatario + "' > "
						+ jsonConsignatrios[i].descripcionConsignatario
						+ " </option>";
			}
		}
		$("#cboConsignatarios").append(items);
	}
}

function cargarInfoEliminarArticulo(jsonArticulos) {

	let imagenesEcomm = jsonArticulos.imagen_ecommerce;
	let arrayImagenes = jsonArticulos.imagen_bxa.split(',');
	var src1 = "";

	if (imagenesEcomm.trim() != "") {
		src1 = "https://www.autorep.mx/konakart/images/" + imagenesEcomm;
		$("#EliminarArticulo_Imagen").attr("src", src1);
	} else {
		for (let i = 0; i < arrayImagenes.length; i++) {
			src1 = "https://webcdo.cdoautopartes.com.mx/image/"
					+ arrayImagenes[i];
			$("#EliminarArticulo_Imagen").attr("src", src1);
		}
	}

	$("#EliminarArticulo_Descripcion").html(jsonArticulos.nombreArticulo);
	$("#EliminarArticulo_NumArt").html(jsonArticulos.numArticuloCDO);
	$('#divTablaCantidades').empty();

	var contenido = '<table   width="98%" align="center" class="table" >'
			+ '<thead  style="padding: 2px">'
			+ '<tr>'
			+ '<td width="25%" align="center"  style="padding: 2px"><label class="ECC_lb_size_12">Cantidad <br> Pedida</label></td>';
	if (jsonArticulos.cantidadPorSurtirBr > 0) {
		contenido += '<td width="25%" align="center"  style="padding: 2px"><label class="ECC_lb_size_12">Surtido <br>  CDO - '
				+ jsonArticulos.cdoBr + '</label></td>';
	}
	
	if (jsonArticulos.cantidadPorSurtirCdo > 0) {
		contenido += '<td width="25%" align="center"  style="padding: 2px"><label class="ECC_lb_size_12">Surtido <br>  CDO - '
				+ jsonArticulos.cdoMacro + ' </label> </td>';
	}
	
	if (jsonArticulos.cantidadPorSurtir72 > 0) {
		contenido += '<td width="25%" align="center"  style="padding: 2px"><label class="ECC_lb_size_12">Surtido <br>  72 Hrs -'
				+ jsonArticulos.cdoTraspaso + '</label></td>';
	}
	contenido += '</thead>'
			+ '<tbody>'
			+ '<tr>'
			+ '<td align="center"><strong><label class="ECC_lb_size_16" style="font-weight: bold; color:black">'
			+ jsonArticulos.cantidadPedida.toLocaleString("en-US")
			+ '</label></strong></td>';
	if (jsonArticulos.cantidadPorSurtirBr > 0) {
		contenido += '<td align="center"><strong><label class="ECC_lb_size_16" style="font-weight: bold; color:black">'
				+ jsonArticulos.cantidadPorSurtirBr.toLocaleString("en-US")
				+ '</label></strong></td>';
	}
	
	if (jsonArticulos.cantidadPorSurtirCdo > 0) {
		contenido += '<td align="center"><strong><label class="ECC_lb_size_16" style="font-weight: bold; color:black">'
				+ jsonArticulos.cantidadPorSurtirCdo.toLocaleString("en-US")
				+ '</label></strong></td>';
	}
	
	if (jsonArticulos.cantidadPorSurtir72 > 0) {
		contenido += '<td align="center"><strong><label class="ECC_lb_size_16" style="font-weight: bold; color:black">'
				+ jsonArticulos.cantidadPorSurtir72.toLocaleString("en-US")
				+ '</label></strong></td>';
	}
	contenido += '</tr>' + '</tbody>' + '</table>';
	$("#divTablaCantidades").append(contenido);

	$("#EliminarArticulo_BotonEiminar").click(function() {
		EliminarArticulo(jsonArticulos);
	});

	MostrarDiv('divEliminarArticulo');

}

function EliminarArticulo(jsonArticulos) {
	document.getElementById('cargando').style.display = 'block';

	OcultarDiv('divEliminarArticulo');

	$.ajax({
				url : 'MantenimientoCarritoCompras',
				data : "vista=MantenimientoCarritoCompras.jsp&operacion=EliminaArticulo&num_articulo="
						+ jsonArticulos.numArticuloCDO
						+ "&pedido="
						+ jsonArticulos.num_pedido,
				type : 'POST',
				dataType : 'Json',
				success : function(json) {

					document.getElementById('cargando').style.display = 'none';
					let jsonHeaderPedido = json.encabezadoPedido;
					let jsonDetallePedido = json.detallePedido;
					let jsonConsignatrios = json.listConsignatarios;
					let jsonTransportes = json.listTransportes;
					let InfoCliente = json.infoCte
					cargaEncabezadoPedidoCarrito(jsonHeaderPedido, InfoCliente);
					cargaDetallePedidoCarrito(jsonDetallePedido)
					ocultarControles();
					cargarTransportes(jsonTransportes, InfoCliente);
					cargarConsintarios(jsonConsignatrios)
					OcultarDiv('divSeguimientoPEdidoActual');
					MostrarDiv('divCarritoDeComprasArticulos');
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al consultar carrito de compras.')
				}
			});
}

function ComprarArticulo(jsonArticulos, jsonExistenciasArticulo) {
	datos = "num_art=" + jsonExistenciasArticulo.num_art + "&cantidadPedida="
			+ jsonExistenciasArticulo.cantidadPedida + "&exietnciaCDO="
			+ jsonExistenciasArticulo.exietnciaCDO + "&existenciaBR="
			+ jsonExistenciasArticulo.existenciaBR + "&exietnciaTraspaso="
			+ jsonExistenciasArticulo.exietnciaTraspaso + "&cdoTraspaso="
			+ jsonExistenciasArticulo.cdoTraspaso + "&importe="
			+ jsonArticulos.precio.replace("$", "").replace(",", "")
			+ "&GeneraTraspaso=" + $('#solicitaTraspaso').prop("checked")
// alert(datos);
	OcultarDiv('divExistenciasArticulo');

	document.getElementById('cargando').style.display = 'block';

	$
			.ajax({
				url : 'MantenimientoCarritoCompras',
				data : "vista=MantenimientoCarritoCompras.jsp&operacion=AgregarACarrito&"
						+ datos,
				type : 'POST',
				dataType : 'text',
				success : function(artEnCarrito) {

					let txt = "#txt_"
							+ jsonArticulos.num_art_cdo.replace("[", "")
									.replace("]", "");
					$(txt).val("");
					$("#txt_divGaleriaImagenes_cantidad").val("");
					$("#btnArticulosEnElCarrito").html(
							" ( " + artEnCarrito + " ) ");

					if (artEnCarrito > 0) {
						$("#btnArticulosEnElCarrito").removeClass(
								"estiloCarritoProductosCERO");
						$("#btnArticulosEnElCarrito").addClass(
								'estiloCarritoProductosLleno');

					} else {
						$("#btnArticulosEnElCarrito").removeClass(
								'estiloCarritoProductosLleno');
						$("#btnArticulosEnElCarrito").addClass(
								"estiloCarritoProductosCERO");
					}
					OcultarDiv('divExistenciasArticulo');
					document.getElementById('cargando').style.display = 'none';

					alert("El Articulo se agrego al Carrito.");
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al consultar carrito de compras.')
				}
			});
}

function TerminarCompra() {
	var transporte = 0;

	if ($('input:radio[name=rdoTransporte]:checked').val() === undefined) {
		alert("Seleccionar El tipo de Transporte");
	} else {

		if ($('input:radio[name=rdoTransporte]:checked').val() === 'P') {
			if ($("#cboTransportes").val() === 0) {
				alert("Seleccionar El tipo de Transporte");
			} else {

				transporte = $("#cboTransportes").val();
			}
		} else {

			transporte = $('input:radio[name=rdoTransporte]:checked').val();
		}
	}
	 // alert("transporte: " + transporte);
	var transporteArr = transporte.split("-");

	if (transporteArr[0] > 0) {
		var consignatario = $('input:radio[name=rdoSucursal]:checked').val();
		if (consignatario == "S") {
			consignatario = $("#cboConsignatarios").val()
		}
		ActualizaEstatusPedido(transporteArr[0], consignatario);
	}
}

function ActualizaEstatusPedido(transporte, consignatario) {
	
	document.getElementById('cargando').style.display = 'block';
	var pedido = $("#lb_numeroPedidoEnCarro").text();
	var datos = "transporte=" + transporte + "&consignatario=" + consignatario
			+ "&pedido=" + pedido;
	$
			.ajax({
				url : 'MantenimientoCarritoCompras',
				data : "vista=MantenimientoCarritoCompras.jsp&operacion=TerminarPedido&"
						+ datos,
				type : 'POST',
				dataType : 'text',
				success : function(artEnCarrito) {
					document.getElementById('cargando').style.display = 'none';

					alert("Se actualizo el pedido.");
					cargaInicialDeLosPedidos(false);
					OcultarDiv("divCarritoDeComprasArticulos");

					$("#btnArticulosEnElCarrito").html("( 0 )");

					$("#btnArticulosEnElCarrito").removeClass(
							'estiloCarritoProductosLleno');
					$("#btnArticulosEnElCarrito").addClass(
							"estiloCarritoProductosCERO");

				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al Actualizar el pedido.')
				}
			});
}

function modificaCantidad(jsonArticulos) {

	$("#ModdivGaleriaImg").empty();
	$("#ModdivGaleriaImgMini").empty();
	let imagenesEcomm = jsonArticulos.imagen_ecommerce;
	let arrayImagenes = jsonArticulos.imagen_bxa.split(',');
	let contenidoImgMini = "";
	let contenidoImg = "";
	$('#lb_ModproductoFotoNombre').text(
			jsonArticulos.nombreArticulo.replace("[", "").replace("]", ""));
	$('#lb_ModproductoFotoClave').text(
			jsonArticulos.numArticuloCDO.replace("[", "").replace("]", ""));
	$('#lb_ModproductoFotoPrecio').text("$ " + jsonArticulos.precioArticulo);
	$('#lb_ModproductoFotoPrecioIVA').text(
			"$ " + (jsonArticulos.precioArticulo * 1.16).toFixed(2));
	$('#txt_ModdivGaleriaImagenes_cantidad').val(
			jsonArticulos.cantidadPedida.toLocaleString("en-US"));

	if (imagenesEcomm.trim() != "") {
		contenidoImgMini += "<div   class='col-xs-12 col-sm-12 col-md-12 col-lg-12' style='text-align:center;padding: 5px'  >"
				+ "<div  id='div_bol_"
				+ 0
				+ "' style='font-weight: bold;background-color: #F5F5F5 ; border: 1px solid #DDDDDD;' "
				+ "onmouseover='mostrarImgGaleriaSeleccionado("
				+ 0
				+ ","
				+ 1
				+ ")'>"
				+ "<img class='imgGaleriaMini' src='https://www.autorep.mx/konakart/images/"
				+ imagenesEcomm
				+ "' "
				+ "style=' width: 100%; border-radius: 8px; padding: 5px' "
				+ ")'> </img>" + "</div>" + "</div>";
		contenidoImg += "<div id='div_boletin_"
				+ 0
				+ "' class='col-0 col-sm-0 col-md-12 col-lg-12' style='text-align:center;'>"
				+ "<img  class='imgGaleriaGrande' src='https://www.autorep.mx/konakart/images/"
				+ imagenesEcomm + "'  style=' border-radius: 8px'></img>"
				+ "</div>";
	} else {
		for (let i = 0; i < arrayImagenes.length; i++) {
			contenidoImgMini += "<div   class='col-xs-12 col-sm-12 col-md-12 col-lg-12' style='text-align:center;padding: 5px'  >"
					+ "<div  id='div_bol_"
					+ i
					+ "' style='font-weight: bold;background-color: #F5F5F5 ; border: 1px solid #DDDDDD;' "
					+ "onmouseover='mostrarImgGaleriaSeleccionado("
					+ i
					+ ","
					+ arrayImagenes.length
					+ ")'>"
					+ "<img class='imgGaleriaMini' src='https://webcdo.cdoautopartes.com.mx/image/"
					+ arrayImagenes[i]
					+ "' "
					+ "style=' width: 100%; border-radius: 8px; padding: 5px' "
					+ ")'> </img>" + "</div>" + "</div>";
		}
		for (let i = 0; i < arrayImagenes.length; i++) {
			if (i <= 0) {
				contenidoImg += "<div id='div_boletin_"
						+ i
						+ "' class='col-0 col-sm-0 col-md-12 col-lg-12' style='text-align:center;'>"
						+ "<img  class='imgGaleriaGrande' src='https://webcdo.cdoautopartes.com.mx/image/"
						+ arrayImagenes[i]
						+ "'  style=' border-radius: 8px'></img>" + "</div>";
			} else {
				contenidoImg += "<div id='div_boletin_"
						+ i
						+ "' class='col-0 col-sm-0 col-md-12 col-lg-12' style='text-align:center;display:none'>"
						+ "<img  class='imgGaleriaGrande' src='https://webcdo.cdoautopartes.com.mx/image/"
						+ arrayImagenes[i]
						+ "'  style='border-radius: 8px'></img>" + "</div>";
			}
		}
	}

	$("#txt_ModdivGaleriaImagenes_cantidad").attr('onkeypress',
			'return EsNumeroMOD(event,' + JSON.stringify(jsonArticulos) + ')');

	$("#btn_ModdivGaleriaImagenes_agregar").attr(
			'onClick',
			'validarExistenciasArticuloDesdeImagenMod('
					+ JSON.stringify(jsonArticulos) + ');');
	$("#ModdivGaleriaImg").append(contenidoImg);
	$("#ModdivGaleriaImgMini").append(contenidoImgMini);

	MostrarDiv('divModificaCantidad');
}

function llenaInformacionDeArticuloMOD(jsonArticulos, jsonExistenciasArticulo) {
	var src1 = "";

	let imgEcommerce = jsonArticulos.imagen_ecommerce;
	let arrayImg = jsonArticulos.imagen_bxa.split(',')

	if (imgEcommerce.trim() != "") {
		src1 = 'https://www.autorep.mx/konakart/images/' + imgEcommerce;
	} else {
		src1 = 'https://webcdo.cdoautopartes.com.mx/image/' + arrayImg[0];
	}

	$("#MODExistenciasArticulo_Imagen").attr("src", src1);
	$("#MODExistenciasArticulo_NumArt").html(
			"ARTICULO: "
					+ jsonArticulos.nombreArticulo.replace("[", "").replace(
							"]", ""));

	$("#MODExistenciasArticulo_Descripcion").html(jsonArticulos.nombreArticulo);

	$('#MODExistenciasArticulo_divTablaCantidades').empty();

	$("#MODsolicitaTraspaso").prop('checked', false);
	$('#div_MOD_mensaje_traspaso').hide();
	var contenido = '<table   width="98%" align="center" class="table" >'
			+ '<thead  style="padding: 2px">'
			+ '<tr>'
			+ '<td width="25%" align="center"  style="padding: 2px"><label class="ECC_lb_size_12">Cantidad <br> Pedida</label></td>';
	if (jsonExistenciasArticulo.existenciaBR > 0) {
		contenido += '<td width="25%" align="center"  style="padding: 2px"><label class="ECC_lb_size_12">Surtido <br>  CDO - '
				+ jsonExistenciasArticulo.cdoBrDescripcion + '</label></td>';
	}
	if (jsonExistenciasArticulo.exietnciaCDO > 0) {
		contenido += '<td width="25%" align="center"  style="padding: 2px"><label class="ECC_lb_size_12">Surtido <br>  CDO - '
				+ jsonExistenciasArticulo.cdoMacroDescripcion
				+ ' </label> </td>';
	}
	
	if (jsonExistenciasArticulo.exietnciaTraspaso > 0) {
		$("#MODsolicitaTraspaso").prop('checked', true);
		$('#div_MOD_mensaje_traspaso').show();
		contenido += '<td width="25%" align="center"  style="padding: 2px"><label class="ECC_lb_size_12">Surtido <br>  72 Hrs -'
				+ jsonExistenciasArticulo.cdoTraspasoDescripcion
				+ '</label></td>';
	}

	contenido += '</thead>'
			+ '<tbody>'
			+ '<tr>'
			+ '<td align="center"><strong><label class="ECC_lb_size_16" style="font-weight: bold; color:black">'
			+ jsonExistenciasArticulo.cantidadPedida.toLocaleString("en-US")
			+ '</label></strong></td>';
	if (jsonExistenciasArticulo.existenciaBR > 0) {
		contenido += '<td width="25%" align="center"><strong><label class="ECC_lb_size_16" style="font-weight: bold; color:black">'
				+ jsonExistenciasArticulo.existenciaBR.toLocaleString("en-US")
				+ '</label></strong></td>';
	}
	if (jsonExistenciasArticulo.exietnciaCDO > 0) {
		contenido += '<td width="25%" align="center"><strong><label class="ECC_lb_size_16" style="font-weight: bold; color:black">'
				+ jsonExistenciasArticulo.exietnciaCDO.toLocaleString("en-US")
				+ '</label></strong></td>';
	}
	
	if (jsonExistenciasArticulo.exietnciaTraspaso > 0) {
		contenido += '<td width="25%" align="center"><strong><label class="ECC_lb_size_16" style="font-weight: bold; color:black">'
				+ jsonExistenciasArticulo.exietnciaTraspaso
						.toLocaleString("en-US") + '</label></strong></td>';
	}
	contenido += '</tr>' + '</tbody>' + '</table>';
	
	
	
	
	$("#MODExistenciasArticulo_divTablaCantidades").append(contenido);

	MostrarDiv('divMODExistenciasArticulo');
}

function ActualizaCantidadesArticulo(jsonArticulos, jsonExistenciasArticulo) {

	datos = "num_art=" + jsonExistenciasArticulo.num_art + "&cantidadPedida="
			+ jsonExistenciasArticulo.cantidadPedida + "&exietnciaCDO="
			+ jsonExistenciasArticulo.exietnciaCDO + "&existenciaBR="
			+ jsonExistenciasArticulo.existenciaBR + "&exietnciaTraspaso="
			+ jsonExistenciasArticulo.exietnciaTraspaso + "&cdoTraspaso="
			+ jsonExistenciasArticulo.cdoTraspaso + "&importe="
			+ jsonArticulos.precioArticulo + "&pedido="
			+ $('#lb_numeroPedidoEnCarro').text() + "&GeneraTraspaso="
			+ $('#MODsolicitaTraspaso').prop("checked")

	OcultarDiv('divMODExistenciasArticulo');

	document.getElementById('cargando').style.display = 'block';

	$
			.ajax({
				url : 'MantenimientoCarritoCompras',
				data : "vista=MantenimientoCarritoCompras.jsp&operacion=ActualizaCantidadesArticulo&"
						+ datos,
				type : 'POST',
				dataType : 'Json',
				success : function(json) {

					document.getElementById('cargando').style.display = 'none';
					let jsonHeaderPedido = json.encabezadoPedido;
					let jsonDetallePedido = json.detallePedido;
					let jsonConsignatrios = json.listConsignatarios;
					let jsonTransportes = json.listTransportes;
					let jsonDistancias = json.listaDistancias;
					let InfoCliente = json.infoCte

					cargaEncabezadoPedidoCarrito(jsonHeaderPedido, InfoCliente);
					cargaDetallePedidoCarrito(jsonDetallePedido, InfoCliente)
					ocultarControles();
					cargarDistancias(jsonDistancias);
					cargarTransportes(jsonTransportes, InfoCliente);
					cargarConsintarios(jsonConsignatrios)
					OcultarDiv('divSeguimientoPEdidoActual');
					MostrarDiv('divCarritoDeComprasArticulos');

				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al consultar carrito de compras.')
				}
			});
}

function CalculaMultiplo(pedCantP, multiplo) {
	if (multiplo > 1) {
		var Cociente = pedCantP / multiplo;
		var residuo = pedCantP % multiplo;

		if (residuo > 0)
			Cociente++;
		pedCantP = Math.trunc(Cociente) * multiplo;
	}
	return pedCantP;
}
