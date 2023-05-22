
/*** CONSULTA CATALOGO ARMADORAS ****/
function consultaArmadoras()
{
	document.getElementById('cargando').style.display = 'block';
	let desMarca = $('#cboMarcaQueAutoBusca').val();
	let desArticulo  = $('#txtProductoQueAutoBusca').val();	
	
	if(desMarca != "0")		
	{
		$.ajax({
		    url :'QueAutoparteBusca', 
		    data : "vista=PaginaPrincipal.jsp&operacion=consultaCatalogoArmadoras" +"&desMarca=" + desMarca  +"&desArticulo=" + desArticulo, 
		    type : 'POST',
		    dataType : 'Json',
		    success : function(jsonArmadoras)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if( jsonArmadoras.length > 0)
	        	{
		    		llenarComboArmadoras(jsonArmadoras)
		    		MostrarDiv('divArmadorasQueAutoBusca');
	        	}    	
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				alert('Error al consultar marcas')			
			}
		});
	}
	else
	{
		document.getElementById('cargando').style.display = 'none';
		OcultarDiv('divArmadorasQueAutoBusca');
		OcultarDiv('divSubMarcasQueAutoBusca');		
		$('#cboArmandoraQueAutoBusca').val("0")
		$('#cboSubMarcaQueAutoBusca').val("0")
	}
}

function llenarComboArmadoras(jsonArmadoras) 
{
	let combo = $('#cboArmandoraQueAutoBusca');
	combo.empty();
	
	$('<option>').val('0').text('--seleccione--').appendTo(combo);
	for (let i = 0; i < jsonArmadoras.length; i++) 
	{
		$('<option>').val(jsonArmadoras[i].nombre_armadora).text(jsonArmadoras[i].nombre_armadora).appendTo(combo);	
	}
}

/*** CONSULTA CATALOGO SUBMARCAS ***/
function consultaSubMarcas()
{
	document.getElementById('cargando').style.display = 'block';
	let desMarca = $('#cboMarcaQueAutoBusca').val();
	let desArticulo  = $('#txtProductoQueAutoBusca').val();	
	let desArmadora  = $('#cboArmandoraQueAutoBusca').val();	
	
	if(desMarca != "0" && desArmadora != "0")		
	{
		$.ajax({
		    url :'QueAutoparteBusca', 
		    data : "vista=PaginaPrincipal.jsp&operacion=consultaCatalogoSubMarcas" +"&desMarca=" + desMarca  +"&desArticulo=" + desArticulo +"&desArmadora=" + desArmadora, 
		    type : 'POST',
		    dataType : 'Json',
		    success : function(jsonSubMarcas)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if( jsonSubMarcas.length > 0)
	        	{
		    		llenarCombojsonSubMarcas(jsonSubMarcas)
		    		MostrarDiv('divSubMarcasQueAutoBusca');
	        	}    	
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				alert('Error al consultar Submarcas')			
			}
		});
	}
	else
	{
		document.getElementById('cargando').style.display = 'none';
		OcultarDiv('divSubMarcasQueAutoBusca');
		$('#cboSubMarcaQueAutoBusca').val("0")
	}
}

function llenarCombojsonSubMarcas(jsonSubMarcas) 
{
	let combo = $('#cboSubMarcaQueAutoBusca');
	combo.empty();
	
	$('<option>').val('0').text('--seleccione--').appendTo(combo);
	for (let i = 0; i < jsonSubMarcas.length; i++) 
	{
		$('<option>').val(jsonSubMarcas[i].nombre_submarca).text(jsonSubMarcas[i].nombre_submarca).appendTo(combo);	
	}
	
	
}


/*** CONSULTA ARTICULOS ***/
function consultaArticulos()
{
	document.getElementById('cargando').style.display = 'block';
	if(validaFiltrosSeleccionados)
	{
		let desMarca = "";
		let desArticulo  = "";
		let desArmadora  = "";
		let desSubmarca  = "";
		let desGrupo  = "";
		
		if($('#cboMarcaQueAutoBusca').val() != "0")	{
			desMarca = $('#cboMarcaQueAutoBusca').val();
		}
		
		if($('#txtProductoQueAutoBusca').val() != ""){
			desArticulo = $('#txtProductoQueAutoBusca').val();	
		}
		
		if($('#cboArmandoraQueAutoBusca').val() != "0"){
			desArmadora = $('#cboArmandoraQueAutoBusca').val();
		}
		
		if($('#cboSubMarcaQueAutoBusca').val() != "0"){
			desSubmarca = $('#cboSubMarcaQueAutoBusca').val() ;
		}
		
		if($('#cboGrupoQueAutoBusca').val() != "0")	{
			desGrupo = $('#cboGrupoQueAutoBusca').val();
		}
						
		$.ajax({
		    url :'QueAutoparteBusca', 
		    data : "vista=PaginaPrincipal.jsp&operacion=consultaArticulos" +"&desMarca=" + desMarca  +"&desArticulo=" + desArticulo +"&desArmadora=" + desArmadora +"&desSubmarca=" + desSubmarca +"&desGrupo=" + desGrupo, 
		    type : 'POST',
		    dataType : 'Json',
		    success : function(jsonArticulos)
		    { 
		    	document.getElementById('cargando').style.display = 'none';
		    	if(jsonArticulos.length > 0)
	        	{
		    		llenaGridAutopartesArticulos(jsonArticulos)
		    		llenaGridAutopartesArticulosMovil(jsonArticulos)
		    		OcultarDiv('div_autoparteBuscaSinResultados')
		    		MostrarDiv('div_autoparteBuscaConResultados')
	        	}    	
		    	else
		        {
		    		MostrarDiv('div_autoparteBuscaSinResultados')
		    		OcultarDiv('div_autoparteBuscaConResultados')
		        }
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				alert('Error al consultar articulos')			
			}
		});
		
	}
	else
	{
		document.getElementById('cargando').style.display = 'none';
		alert('Es necesario seleccionar algun filtro de busqueda')
	}
	
}

function validaFiltrosSeleccionados()
{
	if($('#cboMarcaQueAutoBusca').val() != "0" || $('#txtProductoQueAutoBusca').val() != "" || $('#cboArmandoraQueAutoBusca').val() != "0" || $('#cboSubMarcaQueAutoBusca').val() != "0" || $('#cboGrupoQueAutoBusca').val() != "0")
	{
		return  true;
	}
	else
	{
		return false;
	}
}

function llenaGridAutopartesArticulos(data)
{
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	        return $.grep(data, function (ingreso) {
	            return (!filter.desc_grupo || ingreso.desc_grupo.indexOf(filter.desc_grupo) > -1)
	             && (!filter.desc_aramdora || ingreso.desc_aramdora.indexOf(filter.desc_aramdora) > -1)
	             && (!filter.des_submarca || ingreso.des_submarca.indexOf(filter.des_submarca) > -1)
	             && (!filter.cve_articulo || ingreso.cve_articulo.indexOf(filter.cve_articulo) > -1)
	             && (!filter.des_marca || ingreso.des_marca.indexOf(filter.des_marca) > -1)
	             && (!filter.desc_articulo || ingreso.desc_articulo.indexOf(filter.desc_articulo) > -1)
	        });
	    },
	    insertItem: function (insertingClient) {
	        data.push(insertingClient);
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {
	    },
	 };
	
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#dgAutopartes").jsGrid({
    	    		 width: "100%",
    	             height: "400px",
    	             editing: true,
    	             filtering: true,
    	             sorting: true,
    	             paging: true,
    	             pageSize: 8,
    	             controller: {
    	                 loadData: function () {
    	                     dataType: "json"
    	                     return data;
    	                 }
    	             },
    	             onItemUpdating: function (args) {
    	            	 IPrevio = args.previousItem;
    	             },
    	             autoload: true,
    	             confirmDeleting: false,
    	             controller: db,
    	             onRefreshed: function (args) { 
    	            	
    	             },
    	             fields: 
    	             [
    	                 { name: "desc_grupo", title:"SIS AUTO", type: "text",  width:80, align: 'left', editing: false, inserting: false, filtering: true, },
    	                 { name: "desc_aramdora", title:"ARMADORA", type: "text",  width:80, align: 'left', editing: false, inserting: false, filtering: true, },
    	                 { name: "des_submarca", title:"SUBMARCA", type: "text",  width:80, align: 'left', editing: false, inserting: false, filtering: true, },
    	                 { name: "cve_articulo", title:"ARTICULO", type: "text",  width:60, align: 'left', editing: false, inserting: false, filtering: true, },
    	                 { name: "desc_articulo", title:"DESCRIPCION", type: "text",  width:120, align: 'left', editing: false, inserting: false, filtering: true, },
    	                 { name: "des_marca", title:"MARCA", type: "text",  width:80, align: 'left', editing: false, inserting: false, filtering: true, },
    	                 { name: "anio_ini", title:"A.I.", type: "text",  width:25, align: 'left', editing: false, inserting: false, filtering: false, },
    	                 { name: "anio_fin", title:"A.F.", type: "text",  width:25, align: 'left', editing: false, inserting: false, filtering: false, },
    	                 { name: "posicion", title:"POSICION", type: "text",  width:80, align: 'left', editing: false, inserting: false, filtering: false, },
    	                 { name: "cilindros", title:"CILINDROS", type: "text",  width:50, align: 'left', editing: false, inserting: false, filtering: false, },
    	                 { name: "caracteristicas", title:"CARACT.", type: "text",  width:40, align: 'left', editing: false, inserting: false, filtering: false, },
    	                 { name: "motor", title:"MOTOR", type: "text",  width:40, align: 'left', editing: false, inserting: false, filtering: false, },
	                 ],
	        	 });
	         });
}

function llenaGridAutopartesArticulosMovil(data)
{
	var db =
	{
	    loadData: function (filter)/** seccion de filtros **/
	    {
	        return $.grep(data, function (ingreso) {
	            return  (!filter.cve_articulo || ingreso.cve_articulo.indexOf(filter.cve_articulo) > -1)
	             && (!filter.des_marca || ingreso.des_marca.indexOf(filter.des_marca) > -1)
	             && (!filter.desc_articulo || ingreso.desc_articulo.indexOf(filter.desc_articulo) > -1)
	        });
	    },
	    insertItem: function (insertingClient) {
	        data.push(insertingClient);
	    },
	    updateItem: function (IActualizado) /** actualiza registro **/
	    {
	    },
	 };
	
	 window.db = db;
     db.data;
     $(function ()
    	     {
    	    	 $("#dgAutopartesMovil").jsGrid({
    	    		 width: "98%",
    	             height: "300px",
    	             editing: true,
    	             filtering: true,
    	             sorting: true,
    	             paging: true,
    	             pageSize: 8,
    	             controller: {
    	                 loadData: function () {
    	                     dataType: "json"
    	                     return data;
    	                 }
    	             },
    	             onItemUpdating: function (args) {
    	            	 IPrevio = args.previousItem;
    	             },
    	             autoload: true,
    	             confirmDeleting: false,
    	             controller: db,
    	             onRefreshed: function (args) { 
    	            	
    	             },
    	             fields: 
    	             [
    	            	 { name: "cve_articulo", title:"ARTICULO", type: "text",  width:60, align: 'left', editing: false, inserting: false, filtering: true, },
    	                 { name: "desc_articulo", title:"DESCRIPCION", type: "text",  width:120, align: 'left', editing: false, inserting: false, filtering: true, },
    	                 { name: "des_marca", title:"MARCA", type: "text",  width:80, align: 'left', editing: false, inserting: false, filtering: true, },    	                
	                 ],
	        	 });
	         });
}


/*** LIMPIAR FILTROS ***/
function limpiaFiltrosQuerAutoBusca()
{
	$('#cboMarcaQueAutoBusca').val("0") 
	$('#txtProductoQueAutoBusca').val("")
	OcultarDiv('divSubMarcasQueAutoBusca')
	OcultarDiv('divArmadorasQueAutoBusca')
	$('#cboGrupoQueAutoBusca').val("0") 

}