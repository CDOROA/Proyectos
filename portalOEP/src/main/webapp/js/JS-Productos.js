function InicioProductos()
{
	AjustarTamanioDivArtiulos();
	
	if(window.addEventListener) {
		// navegadores que utilizan los estandares
		window.addEventListener("resize",AjustarTamanioDivArtiulos);
		window.addEventListener("scroll",AjustarTamanioDivArtiulos);
	}else{
		// Los navegadores de Microsoft... siempre ayudando a los desarrolladores...
		window.attachEvent("onresize",AjustarTamanioDivArtiulos);
		window.attachEvent("onscroll",AjustarTamanioDivArtiulos);
	}

}

function AjustarTamanioDivArtiulos()
{
	var screenWidth = screen.width;
	var screenHeight = screen.height;

	// Get the browser window size
	var windowWidth = window.innerWidth;
	var windowHeight = window.innerHeight;

	// Get the size of the entire webpage
	const pageWidth  = document.documentElement.scrollWidth;
	const pageHeight = document.documentElement.scrollHeight;
	
	 var tHeader = document.getElementById("CHeader").offsetHeight;
     var tFooter = document.getElementById("CFooter").offsetHeight; 
	
     var tamanioCatalogo = (pageHeight - ( tHeader + tFooter)) - 85;
     

	$("#div_ArticulosCarrito").height(tamanioCatalogo)
	//$("#div_ArticulosCarrito" ).scrollTop( tamanioCatalogo );
	}

/** ** CONSULTA SUGERENCIAS **** */
function consultaSugerencias(event) {
	if (event.keyCode === 13) {
	   consultaArticulos();
	} else {
		$
				.ajax({
					url : 'Productos',
					data : "vista=Productos.jsp&operacion=2&descBusqueda="
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
						
					/*
						if (xhr.status === 200) {
							alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
							window.location.href = 'http://www.cdoautopartes.com.mx/';
						} else
							alert('Error al consultar Estado de Cuenta.')
							window.location.href = 'http://www.cdoautopartes.com.mx/';
							*/
						
					}
				});
	}
}

function consultaArticulos() {

	if ($("#txt_buscar_productos").val() != "") {
		$('#tbSugerencias').empty();
		document.getElementById('cargando').style.display = 'block';
		$.ajax({
					url : 'Productos',
					data : "vista=Productos.jsp&operacion=3&desc_articulo="
							+ $("#txt_buscar_productos").val().replace('{','').replace('}','').replace('(','').replace(')','').replace('?','').replace('¿','').replace('!','').replace('¡','')
							+ "&marca="
							+ ""
							+ "&auto=" + "" + "&modelo=" + "",
					type : 'POST',
					dataType : 'Json',
					success : function(jsonArticulos) {

					 //	alert("lista del lado json: " + JSON.stringify(jsonArticulos));
						
					 	llenaGridArticulos(jsonArticulos)
					 	
						 document.getElementById('cargando').style.display = 'none';
/*
						$('#txtResultados').text(
								"Resultados de la busqueda para: "
										+ $("#txt_buscar_productos").val().replace('{','').replace('}','').replace('(','').replace(')','').replace('?','').replace('¿','').replace('!','').replace('¡','')
										+ " - " + jsonArticulos.length
										+ " Registros.");
						
						MostrarDiv('div_ArticulosXAplicacion')
						OcultarDiv('div_MarcasPrincipalesCdo');
						$('#tbSugerencias').empty();*/
					},
					error : function(xhr, status, error) {
						document.getElementById('cargando').style.display = 'none';
						/*if (xhr.status === 200) {
							
							alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
							window.location.href = 'http://www.cdoautopartes.com.mx/';
						} else
							alert('Error al buscar productos.')
							window.location.href = 'http://www.cdoautopartes.com.mx/';
						*/
						
					}
				});
	}
}

function llenaGridArticulos(jsonArticulos) {
	$('#div_ArticulosCarrito').empty();
	AjustarTamanioDivArtiulos();
	/** * Titulos ** */
	let contenido = generaTitulosDelCarrito();
	for (let i = 0; i < jsonArticulos.length; i++) {
//		/** * Aplica color segun Marca ** */
		contenido += "<tr id='tr_articulos'>";
//
//		/** * Foto articulo ** */
		contenido += generaColFotoInicialDeCarrito(jsonArticulos[i])
//
//		/** * Articulo y cambio de numero ** */
		contenido += generaColNumArticuloYCambioNumeroDeCarrito(
				jsonArticulos[i], i)
//
//		/** * Detalle del articulo ** */
		contenido += generaColDetalleDeArticulo(jsonArticulos[i], i)
//
//		/** * Informacion adicional** */
		contenido += generaColInformacionAdicional(jsonArticulos[i], i)
	}
	contenido += "</tbody>" + "</table>";
	$("#div_ArticulosCarrito").append(contenido);

	llenaCombosDeArticulo(jsonArticulos);
	
	aplicarEstiloTabla();
	
}

function llenaCombosDeArticulo(jsonArticulos){
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
}

function generaTitulosDelCarrito() {
	let contenido = "<table id='tb_articulos' class='table' align='center' cellpadding=0px; cellspacing=0px; class='table table-bordered' style='width:100%; background:white' data-page-length='30'>"
			+ "<thead  id='thd_articulos' style='background-color:#000000; color:white' >"
			+ "<tr id='tr_articulos'>"
			+ "<th id='th_articulos1' style='text-align: center;padding:2px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'>PRODUCTO </label></th>"
			+ "<th style='text-align: center;padding:2px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'> "
			+ " <select id='cbo_orden_productos' class= 'EPP_lb_size_12' style='padding:6px; width:100%; background-color: #000000;  color: white;border:1px solid #DCDCDC; border-radius: 3px'  onchange='ordenaArticulosCarrito()'>"
			+ "<option value='0' style='font-weight: bold'>-- ORDENAR --</option>"
			+ "<option value='1' >Grupo</option>"
			+ "<option value='2' >Marca</option>"
			+ "<option value='3' >Descripcion</option>"
			// + "<option value='4' >Precio Menor a Mayor</option>"
			// + "<option value='5' >Precio Mayor a Menor</option>"
			+ "<option value='6' >Mayor Demanda</option>"
			+ "</select>"
			+ "</th>"
			+ "</tr>" + "</thead>" + "<tbody id='tbd_articulos'>";
	return contenido;
}

function generaColFotoInicialDeCarrito(jsonArticulos) {
	let imgEcommerce = jsonArticulos.imagen_ecommerce;
	let arrayImg = jsonArticulos.imagen_bxa.split(',')

	let contenido = "<td id='td_articulos' class='tb_td_foto_articulo' align='center' style='padding:5px; '>";

	if (imgEcommerce.trim() != "") {
		contenido += "<img src='https://www.autorep.mx/konakart/images/"
				+ imgEcommerce
				+ "' class='ECC_img_articulos'  style='cursor: pointer;max-width:200px' onclick='consultaImagenesArticulos("
				+ JSON.stringify(jsonArticulos) + ")'>";
	} else {
		contenido += "<img src='https://webcdo.cdoautopartes.com.mx/image/"
				+ arrayImg[0]
				+ "' class='ECC_img_articulos'  style='cursor: pointer;max-width:200px' onclick='consultaImagenesArticulos("
				+ JSON.stringify(jsonArticulos) + ")'>";
	}

	contenido += "</td>";
	return contenido;
}

function generaColNumArticuloYCambioNumeroDeCarrito(jsonArticulos, aux) {
	let contenido = "<td id='td_articulos'   style='padding:5px;text-align: left; width: 70%; '>"
			+ "<div class='row'><div class='col-lg-12 col-md-12 col-sm-12'> ";

	if (jsonArticulos.tipo_catalogo == "1") {
		contenido += "<label class='ECC_lb_size_14' style='font-weight: bold;color: white;background: black;padding-right: 5px;padding-left: 5px;    border-radius: 6px;'>"
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
	contenido += "<button class = 'btn btn-primary' style= 'background-color: #e33842;border-color: #e33842; padding-top: 1px;padding-bottom: 1px; font-size: 10px;' onclick= 'cargarDetalleArticulo("
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
			+ '"' + ")'>Aplicacion</button><br>";

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

function cargarDetalleArticulo(descripcion, articulo, marca) {
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
				url : 'Productos',
				data : "vista=Productos.jsp&operacion=4&articulo="
						+ articulo,
				type : 'POST',
				dataType : 'Json',
				success : function(respuesta) {

					llenarGridDetalleArticulos(respuesta)
					$("#lbl_Articulo_detalle").text(
							"ARTICULO: " + articulo + " - " + descripcion
									+ " MARCA: " + marca);
					$('#modalDetalleArticulos').modal('toggle');
					document.getElementById('cargando').style.display = 'none';
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					/*document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al consultar detallede articulo.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					*/
				}
			});
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

function generaTitulosDetArt() {
	let contenido = "<table id='tb_articulosDetalle' class='table  table-striped table-hover table-bordered' align='center' cellpadding=0px; cellspacing=0px; style='width:100%;  height:100%;  background:white' data-page-length='50'>"
			+ "<thead  id='thd_articulosDetalle' style='background-color:#e33842; color:white' >"
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

function aplicarEstiloTablaDetalleArticulos() 
{
//		   $('#tb_articulosDetalle').DataTable();
	$('#tb_articulosDetalle').DataTable( {
		 ordering: true,
		  "paging": false,
        "language": {
            "lengthMenu": "Mostrar  _MENU_ productos.",
            "zeroRecords": "No se encontraron productos.",
            "infoEmpty": "No se encontraron productos.",
            "infoFiltered": "(Filtrando de _MAX_ registros totales)",
            "sSearch": "Buscar:",
            "dom" : "<'row' <'col-md-6 pull-left form-group' f>>" ,
    	    "sLoadingRecords": "Cargando..."
    	    ,
        }
    } );
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

function aplicarEstiloTabla() 
{
	$('#tb_articulos').DataTable( {
		"lengthMenu":[[5, 15, 30, 45, 60, 120], [5, 15, 30, 45, 60, 120]],
		
		"pageLength":30,
		 
        "language": {
            "lengthMenu": "Mostrar  _MENU_ productos.",
            "zeroRecords": "No se encontraron productos.",
            "info": " ",
            "infoEmpty": "No se encontraron productos.",
            "infoFiltered": "(Filtrando de _MAX_ registros totales)",
            "sSearch": "Buscar:",
    	    "sLoadingRecords": "Cargando...",
    	    "oPaginate": {
        	    "sFirst": "Primero",
        	    "sLast": "Último",
        	    "sNext": "Siguiente",
        	    "sPrevious": "Anterior"
    	   },
        }
    } );
}

/** *** ORDENAMIENTO DEL CARRITO DE COMPRAS **** */
function ordenaArticulosCarrito() {
	document.getElementById('cargando').style.display = 'block';

	$.ajax({
				url : 'CarritoDeCompras',
				data : "vista=CarritoDeCompras.jsp&operacion=5&ordenar="
						+ $("#cbo_orden_productos").val(),
				type : 'POST',
				dataType : 'Json',
				success : function(jsonArticulos) {

					llenaGridArticulos(jsonArticulos)
					document.getElementById('cargando').style.display = 'none';
				},
				error : function(xhr, status, error) {
					document.getElementById('cargando').style.display = 'none';
					/*
					document.getElementById('cargando').style.display = 'none';
					if (xhr.status === 200) {
						alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					} else
						alert('Error al ordenar articulos.')
						window.location.href = 'http://www.cdoautopartes.com.mx/';
					*/
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

/***   MOSTRAR / OCULTAR DIVS  ***/
function OcultarDiv(div)
{
	var divOcultar ="#" + div;
	$(divOcultar).hide();
}

function MostrarDiv(div)
{
	var divMostrar ="#" + div;
	$(divMostrar).show();
}

function consultaArticulosPorautomovil() {
	 window.location = "Productos?vista=Productos.jsp&operacion=6&desc_articulo="
			+ ""
			+ "&armadora="
			+ $("#cbo_marca_aplicacion option:selected").text()
			+ "&submarca="
			+ $("#cbo_auto_aplicacion").val()
			+ "&modelo="
			+ $("#cbo_modelo_aplicacion").val();
}