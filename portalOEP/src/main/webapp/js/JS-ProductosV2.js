function RutinaInicioProductos(contador)
{

	var pageWidth  = document.documentElement.scrollWidth;
	 
	if (pageWidth < 768)
		{
		document.getElementById('plecaImagenes').style.display = 'none';
		document.getElementById('dondeComprarProductos').style.display = 'none';
		}
	else
		{
			document.getElementById('plecaImagenes').style.display = 'block';
			document.getElementById('dondeComprarProductos').style.display = 'block';
		}
	
	 if( contador==9 )
		 {
		 consultaArticulosPorVehiulo(contador);
		 }
	 
	 InicioProductos();
}

function consultaArticulosPorVehiulo(contador) {
	document.getElementById('cargando').style.display = 'block';
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	// alert(  "marca: " +   urlParams.get('armadora') +  "\nsubmarca: " +   urlParams.get('submarca') + "\nmodelo: " +   urlParams.get('modelo') );
	var marca = "";
	var subMarca= "";
	var modelo= "";
	
	if(contador==9)
	{
		marca = urlParams.get('armadora') ;
		subMarca= urlParams.get('submarca');
		modelo= urlParams.get('modelo');
	}else{
		marca = $("#cbo_marca_aplicacion option:selected").text();
	
		subMarca = $("#cbo_auto_aplicacion").val();
	
		modelo = $("#cbo_modelo_aplicacion").val();
	}
	
	$.ajax({
		url : 'Productos',
		data : "vista=Productos.jsp&operacion=7&marca=" + marca  + "&submarca=" + subMarca + "&modelo=" +  modelo,
		type : 'POST',
		dataType : 'Json',
		success : function(jsonArticulos) {

			// alert("lista del lado json: " + JSON.stringify(jsonArticulos));

			llenaGridArticulos(jsonArticulos, true)

			document.getElementById('cargando').style.display = 'none';
			aplicarEstiloTabla();
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

function InicioProductos() {
	AjustarTamanioDivArtiulos();

	if (window.addEventListener) {
		// navegadores que utilizan los estandares
		window.addEventListener("resize", AjustarTamanioDivArtiulos);
		window.addEventListener("scroll", AjustarTamanioDivArtiulos);
	} else {
		// Los navegadores de Microsoft... siempre ayudando a los desarrolladores...
		window.attachEvent("onresize", AjustarTamanioDivArtiulos);
		window.attachEvent("onscroll", AjustarTamanioDivArtiulos);
	}

}

function AjustarTamanioDivArtiulos() {
	var screenWidth = screen.width;
	var screenHeight = screen.height;

	// Get the browser window size
	var windowWidth = window.innerWidth;
	var windowHeight = window.innerHeight;

	// Get the size of the entire webpage
	const pageWidth = document.documentElement.scrollWidth;
	const pageHeight = document.documentElement.scrollHeight;

	var tHeader = document.getElementById("CHeader").offsetHeight;
	var tFooter = document.getElementById("CFooter").offsetHeight;

	var tamanioCatalogo = (pageHeight - (tHeader + tFooter)) - 125;

	$("#div_ArticulosCarrito").height(tamanioCatalogo)
	//$("#div_ArticulosCarrito" ).scrollTop( tamanioCatalogo );
}

/** ** CONSULTA SUGERENCIAS **** */
function consultaSugerencias(event) {
	if (event.keyCode === 13) {
		consultaArticulos();
	} else {
		$.ajax({
			url : 'Productos',
			data : "vista=Productos.jsp&operacion=2&descBusqueda="
					+ $('#txt_buscar_productos').val().replace('{', '')
							.replace('}', '').replace('(', '').replace(')', '')
							.replace('?', '').replace('¿', '').replace('!', '')
							.replace('¡', ''),
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
					+ $("#txt_buscar_productos").val().replace('{', '')
							.replace('}', '').replace('(', '').replace(')', '')
							.replace('?', '').replace('¿', '').replace('!', '')
							.replace('¡', '') + "&marca=" + "" + "&auto=" + ""
					+ "&modelo=" + "",
			type : 'POST',
			dataType : 'Json',
			success : function(jsonArticulos) {

				// alert("lista del lado json: " + JSON.stringify(jsonArticulos));

				llenaGridArticulos(jsonArticulos,false)

				document.getElementById('cargando').style.display = 'none';
				aplicarEstiloTabla();
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

function llenaGridArticulos(jsonArticulos, mestraAuto) {
	$('#div_ArticulosCarrito').empty();
	AjustarTamanioDivArtiulos();

	let contenido = generaTitulosDelCarrito();
	var contador = 0;
	for (let i = 0; i < jsonArticulos.length; i++) {

		if (contador === 0) {
			contenido += "<tr id='tr_articulos'><td id='td_articulos' class='tb_td_foto_articulo' > <div class='row'>";
		}

	    contenido += generaImagen(jsonArticulos[i], mestraAuto)

		contador = contador + 1;

		if (contador === 4) {
			contenido += "</div></td></tr>";
			contador = 0;
		}
	}
	contenido += '</tbody>' + '</table>';
	$("#div_ArticulosCarrito").append(contenido);


}

function generaTitulosDelCarrito() {
	let contenido = "<table id='tb_articulos' class='table'  align='center' cellpadding=0px; cellspacing=0px; class='table table-bordered' style='width:100%; background:white' data-page-length='30'>"
		            
			+ "<thead  id='thd_articulos' style='background-color:#000000; color:white' >"
			+ "<tr id='tr_articulos'>"
			// + "<th id='th_articulos1' style='text-align: center;padding:2px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'>PRODUCTO </label></th>"
			+ "<th id='th_articulos1' style='text-align: center;padding:2px;position: sticky;'><label class='EPP_lb_size_12' style='font-weight: bold;'> "
			+ " <select id='cbo_orden_productos' class= 'EPP_lb_size_12' style='padding:6px; width:100%; background-color: #000000;  color: white;border:1px solid #DCDCDC; border-radius: 3px'  onchange='ordenaArticulosCarrito()'>"
			+ "<option value='0' style='font-weight: bold'>-- ORDENAR --</option>"
			+ "<option value='1' >Grupo</option>"
			+ "<option value='2' >Marca</option>"
			+ "<option value='3' >Descripcion</option>"
			+ "<option value='6' >Mayor Demanda</option>"
			+ "</select>"
			+ "</th>" 
			
			+ "</tr>" + "</thead>" + "<tbody id='tbd_articulos'>";
	return contenido;
}

function generaImagen(jsonArticulo, muestraAuto) {
	let contenido = "";
	try
	{
	
	let imgEcommerce = jsonArticulo.imagen_ecommerce;
	let arrayImg = jsonArticulo.imagen_bxa.split(',');
	let imgUrl = "";
	let litrosEdit = "";
	let cilindrosEdiit = "";
	
	let modeloEdit=jsonArticulo.modelo.replace("[", "").replace("]", "");
	
	let arrayModelo = jsonArticulo.modelo.split(',');
	if (arrayModelo.length >0) {
		modeloEdit= arrayModelo[0].replace("[", "").replace("]", "");
	}
	
	
	if (imgEcommerce.trim() != "") {
		imgUrl = "https://www.autorep.mx/konakart/images/" + imgEcommerce;
	} else {
		imgUrl += "https://webcdo.cdoautopartes.com.mx/image/" + arrayImg[0];
	}
//	console.log("sdfsdf")
//	console.log(jsonArticulo.litros) 
	litrosEdit = jsonArticulo.litros;
//	console.log("LITROS: "+litrosEdit) 
//	if (jsonArticulo.litros.length > 3) {
//		litrosEdit = jsonArticulo.litros.substring(0, 3).replace(",", "");;
//	} 

	cilindrosEdiit = jsonArticulo.cilindros;
//	if (jsonArticulo.cilindros.length > 3) {
//		cilindrosEdiit = jsonArticulo.cilindros.substring(0, 3).replace(",", "");
//	}
	contenido = '<div class="col-xl-3 col-lg-6 col-md-4 col-sm-12" style="margin-top: 8px;">'
			+ "<div class='hovereffect-D hovereffect-D-Shadow' style='border: 1px solid #bfbfbf;border-radius: 18px; margin-top: 0px;' onclick='GeneraVistaArticulo("
			+ JSON.stringify(jsonArticulo)
			+ ")'>"
			+ '<table style="width: 100%;"><tbody>'
			+ '<tr><td style="padding-top: 12px;padding-bottom: 0px;">'
			+ '<label class="EtiquetaUnderLineNoParte float-left" style="color:#000000;">No. de Parte</label>'
			+ '<label class="Etiqueta mr-auto" style="color:#000000;">'
			+ jsonArticulo.num_art_cdo.replace("[", "").replace("]", "")
			+ '</label>' ;
			if (jsonArticulo.tipo_catalogo == "1"){
			//alert(jsonArticulo.tipo_catalogo);
             
		     contenido += "<label id = 'etiquetatitulo' class='etiquetado_ACES' data-toggle='tooltip' data-placement='top' title='Est&aacute;ndar de informaci&oacute;n de la industria de aftermarket(Mercado de Repuestos) de autopartes.' onclick='alert('Est&aacute;ndar de informaci&oacute;n de la industria de aftermarket(Mercado de Repuestos) de autopartes.');' >  ACES </label></label> ";
	         
		    }
			contenido += '</td></tr>'
			// + '<tr><td style="padding-top: 0px;padding-bottom: 0px;">'
			// + '<div class="mr-auto">'
			// + '<label class="Etiqueta mr-auto" style="color:#000000;">'
			// + jsonArticulo.num_art_cdo.replace("[", "").replace("]", "")
			// + '</label>'
			// + '</div>'
			// + '</td></tr>'
			+ '<tr><td style="padding-top: 0px;padding-bottom: 0px;">'
			+ '<img class="img-fluid" src="'
			+ imgUrl
			+ '" alt="" style="display: inline-block; padding: 10px; width: 340px">'
			+ '</td></tr>'
			+ '<tr><td style="padding-top: 0px;padding-bottom: 0px;">'
			+ '<div class="overlay">'
			+ '<a class="info" href="#"></a>'
			+ '</div>'
			+ '</td></tr>'
			+ '<tr><td style="padding-top: 0px;padding-bottom: 0px;">'
			+ '<label class="Etiqueta mr-auto" style="color:#000000; margin-top: 8px;">'
			+ jsonArticulo.descripcion_producto.replace("[", "").replace("]",
					"")
			+ '</label>'
			+ '</td></tr>';
			if(muestraAuto == true)
			{
				contenido += '<tr><td style="padding-top: 0px;padding-bottom: 0px;">'
				+ '<ul class="mx-auto justify-content-center pagination pagination-sm">'
				+ '<li class="page-item disabled"><a class="page-link" href="#" style="color: black;">'
				+ jsonArticulo.armadora.replace("[", "").replace("]", "")
				+ '</a></li>'
				+ '<li class="page-item disabled"><a class="page-link" href="#" style="color: black;">'
				+ modeloEdit
				+ '</a></li>'
				/*+ '<li class="page-item disabled"><a class="page-link" href="#" style="color: black;">'
				+ jsonArticulo.anio
				+ '</a></li>'*/
				+ '</ul>'
				+ '</td></tr>';
			}
			contenido += '<tr><td style="padding-top: 0px;padding-bottom: 0px;">'
			+ '<table style="width: 100%; border: 1px solid #bfbfbf;border-radius: 18px; margin-top: 0px;  margin-bottom: 10px;" >'
			+ '<tr>'
			+ '<td style="width: 22%; border: 1px solid #bfbfbf;border-radius: 18px;padding: 3px;">A&ntilde;o</td>'
			+ '<td style="width: 39%; border: 1px solid #bfbfbf;border-radius: 18px;padding: 3px;">Cilindros</td>'
			+ '<td style="width: 39%; border: 1px solid #bfbfbf;border-radius: 18px;padding: 3px;">Litros</td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td style="width: 22%; border: 1px solid #bfbfbf;border-radius: 18px;padding: 3px;font-size: 12px;">'+ jsonArticulo.anio.replace("[", "").replace("]", "") +'</td>'
			+ '<td style="width: 39%; border: 1px solid #bfbfbf;border-radius: 18px;padding: 3px;font-size: 12px;">'+cilindrosEdiit +'</td>'
			+ '<td style="width: 39%; border: 1px solid #bfbfbf;border-radius: 18px;padding: 3px;font-size: 12px;">'+ litrosEdit +'</td>'
			+ '</tr>'
			+ '</table>'
			+ '</td></tr>'
			// se coloca en la pate superior 
			//if (jsonArticulo.tipo_catalogo == "1"){
				//alert(jsonArticulo.tipo_catalogo);
			//	contenido +=  '<tr><td style="padding-top: 0px;padding-bottom: 12px;">'
			//		contenido += "<label id = 'etiquetatitulo' class='etiquetado_ACES' data-toggle='tooltip' data-placement='top' title='Est&aacute;ndar de informaci&oacute;n de la industria de aftermarket(Mercado de Repuestos) de autopartes.' onclick='alert('Est&aacute;ndar de informaci&oacute;n de la industria de aftermarket(Mercado de Repuestos) de autopartes.');' >  ACES </label></label> ";
			//	contenido +=  '</td></tr>'
			//}
			contenido += '</tbody></table>' + '</div>' + '</div>';
	}
	catch (error) {
		  alert("Error :" + error);
		  // expected output: ReferenceError: nonExistentFunction is not defined
		  // Note - error messages will vary depending on browser
		}
	return contenido;
}

/***   MOSTRAR / OCULTAR DIVS  ***/
function OcultarDiv(div) {
	var divOcultar = "#" + div;
	$(divOcultar).hide();
}

function MostrarDiv(div) {
	var divMostrar = "#" + div;
	$(divMostrar).show();
}

function aplicarEstiloTabla() {
	$('#tb_articulos').DataTable(
			{
				"lengthMenu" : [ [ 5, 15, 30, 45, 60, 120 ],
						[ 5, 15, 30, 45, 60, 120 ] ],

				"pageLength" : 30,

				"language" : {
					"lengthMenu" : "Mostrar  _MENU_ renglones.",
					"zeroRecords" : "No se encontraron productos.",
					"info" : " ",
					"infoEmpty" : "No se encontraron productos.",
					"infoFiltered" : "(Filtrando de _MAX_ registros totales)",
					"sSearch" : "Buscar:",
					"sLoadingRecords" : "Cargando...",
					"oPaginate" : {
						"sFirst" : "Primero",
						"sLast" : "Último",
						"sNext" : "Siguiente",
						"sPrevious" : "Anterior"
					},
				}
			});
}

/** *** CONSULTA DE PANTALLA EMERGENTE DE IMAGENES **** */
function GeneraVistaArticulo(jsonArticulo) {
/*	cargarDetalleArticulo(jsonArticulo.descripcion_producto.replace("[", "").replace("]","") ,
				jsonArticulo.num_art_cdo.replace("[", "").replace("]", ""),
				jsonArticulo.marca.replace("[", "").replace("]", ""));
	*/
	$('#modalImagen').empty();
	$('#modalDescripcion').empty();
	let contenidoimg = "";
	let contenidoDesc = "";

	contenidoimg = GeneraDetalleDeImagen(jsonArticulo);
	$("#modalImagen").append(contenidoimg);

	contenidoDesc = generaDetalleDescripcion(jsonArticulo);
	$("#modalDescripcion").append(contenidoDesc);

	MostrarDiv('divGaleriaImagenes');
}

function GeneraDetalleDeImagen(jsonArticulo) {
	let imgEcommerce = jsonArticulo.imagen_ecommerce;
	let arrayImg = jsonArticulo.imagen_bxa.split(',');
	let imgUrl = "";

	if (imgEcommerce.trim() != "") {
		imgUrl = "https://www.autorep.mx/konakart/images/" + imgEcommerce;
	} else {
		imgUrl += "https://webcdo.cdoautopartes.com.mx/image/" + arrayImg[0];
	}

	let arrayModelo = jsonArticulo.modelo.split(',');
	if (arrayModelo.length >0) {
		modeloEdit= arrayModelo[0].replace("[", "").replace("]", "") + "...";
	}
	
	
	let contenido = '<table style="width: 100%;"><tbody>'
			+ '<tr><td style="padding-top: 12px;padding-bottom: 0px;">'
			+ '<label class="EtiquetaUnderLineNoParte float-left" style="color:#000000;">No. de Parte</label>'
			+ '</td></tr>'
			+ '<tr><td style="padding-top: 0px;padding-bottom: 0px;">'
			+ '<div class="mr-auto">'
			+ '<label class="Etiqueta mr-auto" style="color:#000000;">'
			+ jsonArticulo.num_art_cdo.replace("[", "").replace("]", "")
			+ '</label>'
			+ '</div>'
			+ '</td></tr>'
			+ '<tr><td style="padding-top: 0px;padding-bottom: 0px;">'
			+ '<img class="img-fluid" src="'
			+ imgUrl
			+ '" alt="" style="display: inline-block; padding: 10px; width: 340px">'
			+ '</td></tr>'
			+ '<tr><td style="padding-top: 0px;padding-bottom: 0px;">'
			+ '<div class="overlay">'
			+ '<a class="info" href="#"></a>'
			+ '</div>'
			+ '</td></tr>'
			+ '<tr><td style="padding-top: 0px;padding-bottom: 0px;">'
			+ '<label class="Etiqueta mr-auto" style="color:#000000; margin-top: 8px;">'
			+ jsonArticulo.descripcion_producto.replace("[", "").replace("]",
					"")
			+ '</label>'
			+ '</td></tr>'
			/*
			+ '<tr><td style="padding-top: 0px;padding-bottom: 0px;">'
			+ '<ul class="mx-auto justify-content-center pagination pagination-sm">'
			+ '<li class="page-item disabled"><a class="page-link" href="#" style="color: black;">'
			+ jsonArticulo.armadora.replace("[", "").replace("]", "")
			+ '</a></li>'
			+ '<li class="page-item disabled"><a class="page-link" href="#" style="color: black;">'
			+ modeloEdit
			+ '</a></li>'
			+ '<li class="page-item disabled"><a class="page-link" href="#" style="color: black;">'
			+ jsonArticulo.anio
			+ '</a></li>'
			+ '</ul>'
			+ '</td></tr>'
			*/
			+ '<tr><td style="padding-top: 0px;padding-bottom: 0px;">'
			+'<table style="width: 100%; border: 1px solid #bfbfbf;border-radius: 18px; margin-top: 0px;  margin-bottom: 16px;" ><tr><td style="width: 25%; border: 1px solid #bfbfbf;border-radius: 18px;">'
			+  '<label class="float-right" style="margin-bottom: 5px;margin-left: 10px;margin-right: 10px;margin-top: 5px;">A&ntilde;o:</label>'
			+'</td><td style="width: 75%; border: 1px solid #bfbfbf;border-radius: 18px;">'
			+ '<label class="float-left"  style="margin-bottom: 5px;margin-left: 10px;margin-right: 10px;margin-top: 5px;">'+ jsonArticulo.anio.replace("[", "").replace("]", "") +'</label>'
			+ '</td></tr>'
			+'<tr><td style="width: 25%; border: 1px solid #bfbfbf;border-radius: 18px;">'
			+  '<label class="float-right"  style="margin-bottom: 5px;margin-left: 10px;margin-right: 10px;margin-top: 5px;">Cilindros:</label>'
			+'</td><td style="width: 75%; border: 1px solid #bfbfbf;border-radius: 18px;">'
			+ '<label  class="float-left" style="margin-bottom: 5px;margin-left: 10px;margin-right: 10px;margin-top: 5px;">'+ jsonArticulo.cilindros +'</label>'
			+ '</td></tr>'
			+'<tr><td style="width: 25%; border: 1px solid #bfbfbf;border-radius: 18px;">'
			+  '<label class="float-right"  style="margin-bottom: 5px;margin-left: 10px;margin-right: 10px;margin-top: 5px;">Litros:</label>'
			+'</td><td style="width: 75%; border: 1px solid #bfbfbf;border-radius: 18px;">'
			+ '<label class="float-left"  style="margin-bottom: 5px;margin-left: 10px;margin-right: 10px;margin-top: 5px;">'+ jsonArticulo.litros +'</label>'
			+ '</td></tr></table>'
			+ '</td></tr>'
			+ '</tbody></table>';

	return contenido;
}

function generaDetalleDescripcion(jsonArticulo) {
	  
	let arrayCustomAttrs = jsonArticulo.customAttrs.replace("[", "").replace("]", "").split('|');
	
	// et arrayImg = jsonArticulo.imagen_bxa.split(','); 
	let contenido = '<div class="row">' +
	                '<div class="col-12">' +
	                '<table style="width: 100%;">'+
	                '<tr><td>'+
	                '<label class="EtiquetaUnderLineDetalle float-left">Informaci&oacute;n del producto:</label>'+
	                '</tr></td>'+
	                '<tr><td>'+
	                '<p class="text-justify font-weight-normal textoDetalle">'+ arrayCustomAttrs[1].replace("Aplicacion:", "").replace(new RegExp(",", "g"), "<br>") +'</p>'+ 
	                '</tr></td>'+
	                '<tr><td>'+
	                '<label class="EtiquetaUnderLineDetalle float-left">Caracter&iacute;sticas:</label>'+
	                '</tr></td>'+
	                '<tr><td>'+
	                '<p class="text-justify font-weight-normal textoDetalle">'+ arrayCustomAttrs[0].replace("Caracteristicas:", "").replace("3,000", "4,000").replace(new RegExp(";", "g"), "<br>") +'</p>'+
	                '</tr></td>';
	
	                if (jsonArticulo.tipo_catalogo == "1"){
						//alert(jsonArticulo.tipo_catalogo);
						contenido += '<tr><td style="padding-top: 0px;padding-bottom: 12px;">'
						contenido += "<label id = 'etiquetatitulo' class='etiquetado_ACES float-left' data-toggle='tooltip' data-placement='top' title='Est&aacute;ndar de informaci&oacute;n de la industria de aftermarket(Mercado de Repuestos) de autopartes.' onclick='alert('Est&aacute;ndar de informaci&oacute;n de la industria de aftermarket(Mercado de Repuestos) de autopartes.');' >  ACES </label></label> " +
									 "<label id = 'etiquetatitulo' class='float-left textoDetalle' style='margin-left: 8px;'>Est&aacute;ndar de informaci&oacute;n de la industria de aftermarket(Mercado de Repuestos) de autopartes.  </label></label>";
						contenido += '</td></tr>';
					}
	
	
					contenido += '<tr><td>'+
	                '<label class="EtiquetaUnderLineDetalle float-left">Donde comprar:</label>'+
	                '</tr></td>';
	                if(!jsonArticulo.produtcsId == "")
	        		{
	                	contenido += '<tr><td>'+
	                                 '<p class="text-justify font-weight-normal textoDetalle">Compra en l&iacute;nea' +
	                               	 '<a class="navbar-brand" href="https://www.autorep.mx/proddetail#!productDetail/p/'+jsonArticulo.produtcsId.replace("[", "").replace("]", "")  +'" target="_blank">'+
	        		                 '<img src="img/compraEnLinea/CompraEnlinea.png" style="max-width:32px;" >'+
	                                 '</a></p>'+
	                                 '</tr></td>';
	        		} 
	                // '<p class="text-justify font-weight-normal textoDetalle">Ambitioni dedisse scripsisse iudicaretur. Cras mattis iudicium purus sit amet fermentum. Donec sed odio operae, eu vulputate felis rhoncus. Praeterea iter est quasdam res quas ex communi. At nos hinc posthac, sitientis piros Afros. Petierunt uti sibi concilium totius Galliae in diem certam indicere. Cras mattis iudicium purus sit amet fermentum.</p>'+
	                
	                '</table>'+
	                '</div>';
	                '</div>';
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


/** *** CONSULTA SUBMARCAS **** */
function consultaSubmarcas() {
	$
			.ajax({
				url : 'PaginaPrincipal',
				data : "vista=PaginaPrincipal.jsp&operacion=2&cve_armadora="
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
	//cmbAno.empty();

	$('<option>').val('0').text('-- Selecciona --').appendTo(combo);
	for (let i = 0; i < jsonSubmarcas.length; i++) {
		$('<option>').val(jsonSubmarcas[i].nombre_submarca).text(
				jsonSubmarcas[i].nombre_submarca).appendTo(combo);
	}

	/*let fecha = new Date();
	let ano = fecha.getFullYear();
	$('<option>').val('0').text('-- Selecciona --').appendTo(cmbAno);
	for (let i = ano; i > 1950; i--) {
		$("<option value=" + i + ">" + i + "</option>").appendTo(cmbAno);
	}*/
}

/** *** CONSULTA anios **** */
function consultaAnios() {
	
	$
			.ajax({
				url : 'PaginaPrincipal',
				data : "vista=PaginaPrincipal.jsp&operacion=3&desc_sub_marca="
						+ $("#cbo_auto_aplicacion").val(),
				type : 'POST',
				dataType : 'Json',
				success : function(jsonSubMarcas) {
					llenarComboAnios(jsonSubMarcas)
				 
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

function llenarComboAnios(jsonSubmarcas) {
	 
	let cmbAno = $('#cbo_modelo_aplicacion');
 
	cmbAno.empty();

	$('<option>').val('0').text('-- Selecciona --').appendTo(cmbAno);
	for (let i = 0; i < jsonSubmarcas.length; i++) {
		$('<option>').val(jsonSubmarcas[i].anio).text(
				jsonSubmarcas[i].anio).appendTo(cmbAno);
	}
}

function consultaArticulosPorGrupo(grupo) {
	document.getElementById('cargando').style.display = 'block';

	$.ajax({
		url : 'Productos',
		data : "vista=Productos.jsp&operacion=8&grupo=" + grupo,
		type : 'POST',
		dataType : 'Json',
		success : function(jsonArticulos) {

			// alert("lista del lado json: " + JSON.stringify(jsonArticulos));

			llenaGridArticulos(jsonArticulos, false)

			document.getElementById('cargando').style.display = 'none';
			aplicarEstiloTabla();
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
function consultaArticulosPorautomovil() {
	 $.ajax({
			url : 'Productos',
			data : "vista=Productos.jsp&operacion=7&marca=" + $("#cbo_marca_aplicacion option:selected").text()  + "&submarca=" + $("#cbo_auto_aplicacion").val() + "&modelo=" +  $("#cbo_modelo_aplicacion").val(),
			type : 'POST',
			dataType : 'Json',
			success : function(jsonArticulos) {

				// alert("lista del lado json: " + JSON.stringify(jsonArticulos));

				llenaGridArticulos(jsonArticulos, true)

				document.getElementById('cargando').style.display = 'none';
				aplicarEstiloTabla();
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