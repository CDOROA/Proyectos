function InicioPaginaPRincipal()
{
	// CargaCatalogo();
	//abrirVideoPrincipal('https://www.youtube.com/embed/stpzMyquUGE');
	obtenerVideoPrincipalBD(0)

}

function obtenerVideoPrincipalBD(status)
{
	$.ajax({
		url : 'PaginaPrincipal',
		data: "vista=PaginaPrincipal.jsp&operacion=4",
			type : 'POST',
			dataType : 'Json',
			success : function(jsonAbrirVideoPrincipalBD) {
				// LlenarVideoprincipalBD(jsonVideoPrincipalBD)
				console.log(JSON.stringify(jsonAbrirVideoPrincipalBD))
				abrirVideoPrincipal(jsonAbrirVideoPrincipalBD[0]);
			}
	
	});
	
}

function bigImg(id) {
	$("#"+id).css('display','block')  
	}
function CargaCatalogo()
{
	document.getElementById('contenedorPrincipal').style.display = 'none';
	var pageWidth  = document.documentElement.scrollWidth;
 
	if (pageWidth < 768)
		{
			window.location.href='Catalogo';
		}
	else
		{
			document.getElementById('contenedorPrincipal').style.display = 'block';
		
		}
	
	}

/** *** CONSULTA anios **** */
function consultaAnios() {
	
	$.ajax({
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
	// cmbAno.empty();

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

function verDivSubmenu(divSubMenu)
{

	let div =  divSubMenu;
	document.getElementById('panelBotonVideos').style.display = 'none';
	document.getElementById('panelVideos').style.display = 'block';
	window.location.hash = div;
}

function abrirVideoPrincipal(url_video)
{
	
	var scrollLeft = $(window).scrollLeft();
	
	var scrollTop = $(window).scrollTop();
	
	$("#etiquetaVideo").html("");
	//console.log("URL: "+url_video)
	let contenido = '<iframe name="frameVideo" id="frameVideo" src="'+url_video+'?&autoplay=1" class="embed-responsive-item" controls="true" allowfullscreen="true"></iframe>';
	//let contenido = '<iframe name="frameVideo" id="frameVideo" src="'+url_video+'" frameborder="0" allow="accelerometer; autoplay=1; clipboard-write; encrypted-media; gyroscope; picture-in-picture" controls="true" allowfullscreen="true"></iframe>';
	//let contenido = '<iframe name="frameVideo" id="frameVideo" src="https://www.youtube.com/embed/fgEv3n05xm4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay=1; clipboard-write; encrypted-media; gyroscope; picture-in-picture" controls="true" allowfullscreen="true"></iframe>';
	//let contenido = '<video src="'+url_video+'" controls="true" style="width: 100%"></video>';

	//let contenido = '<iframe name="frameVideo" id="frameVideo" src="'+url_video+'" class="embed-responsive-item" controls="true" allowfullscreen="true"></iframe';
	//console.log("contenido: "+contenido)
	$("#etiquetaVideo").html(contenido);
	$('#modalImagenes').modal('hide');
 
	$('#modalVideos').modal('toggle');
}

function CerraPanelVideos()
{

	let div =  "panelBotonVideos";
	document.getElementById('panelBotonVideos').style.display = 'block';
	document.getElementById('panelVideos').style.display = 'none';
	window.location.hash = div;
}
