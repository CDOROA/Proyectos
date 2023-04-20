
function rutinaInicioResultados() {
	$("#menu-evaluacion").removeClass("Opc-Menu-Activo");
	$("#menu-seguimiento").removeClass("Opc-Menu-Activo");
	$("#menu-resultados").addClass("Opc-Menu-Activo");
	 cargaAreas();
}
function actualizaResultados(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet ',
		data : "accion=CargaResultados",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			alert(JSON.stringify(respuesta[0].rsp));
			cargaAreas();
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/DCH/';
        }
        else
            alert('Error al consultar resultados por area.')
    }
	});
}
function cargaAreas(){
	
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet ',
		data : "accion=CargaAreas",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//alert(respuesta);
					cargaInformacionAreas(respuesta);
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/DCH/';
        }
        else
            alert('Error al consultar resultados por area.')
    }
	});
}
function cargaInformacionAreas(respuesta){
	document.getElementById("imgResultados").style.marginLeft='35%';
	//console.log(JSON.stringify(respuesta))
	var promedios=[]
	
	document.getElementById('selectEmp').style.display = 'none';
	$("#nivelesbtn").removeClass("active");
	$("#deptosbtn").removeClass("active");
	$("#empleadosbtn").removeClass("active");
	$("#areasbtn").addClass("active");
	document.getElementById('areas').style.display = 'block';
	document.getElementById('departamentos').style.display = 'none';
	document.getElementById('niveles').style.display = 'none';
	document.getElementById('empleados').style.display = 'none';
	document.getElementById('btnAreas').style.display = 'block';
	document.getElementById('btnDepartamentos').style.display = 'none';
	document.getElementById('btnNiveles').style.display = 'none';
	document.getElementById('btnEmpleados').style.display = 'none';
	
	$("#areas").append("<br><br>");
	var res = respuesta[0];
	var resultados = res.listResultados;
	//alert(JSON.stringify(data));
	
	var db = {

			 loadData : function(filter) {
					var json= $.grep(resultados, function(client) {
						return (!filter.area.toUpperCase()|| client.area.toUpperCase() === filter.area.toUpperCase() || client.area.toUpperCase() == filter.area.toUpperCase() || client.area.toUpperCase().includes(filter.area.toUpperCase()))
					        && (!filter.promedioGral|| client.promedioGral.toFixed(1) === filter.promedioGral || client.promedioGral.toFixed(1) == filter.promedioGral)
					        && (!filter.uno|| client.uno.toFixed(1) === filter.uno || client.uno.toFixed(1) == filter.uno)
					        && (!filter.dos|| client.dos.toFixed(1) === filter.dos || client.dos.toFixed(1) == filter.dos)
					        && (!filter.tres|| client.tres.toFixed(1) === filter.tres || client.tres.toFixed(1) == filter.tres)
					        && (!filter.cuatro|| client.cuatro.toFixed(1) === filter.cuatro || client.cuatro.toFixed(1) == filter.cuatro)
					        && (!filter.cinco|| client.cinco.toFixed(1) === filter.cinco || client.cinco.toFixed(1) == filter.cinco)
					        && (!filter.seis|| client.seis.toFixed(1) === filter.seis || client.seis.toFixed(1) == filter.seis)
					        && (!filter.siete|| client.siete.toFixed(1) === filter.siete || client.siete.toFixed(1) == filter.siete)
					        && (!filter.ocho|| client.ocho.toFixed(1) === filter.ocho || client.ocho.toFixed(1) == filter.ocho)
					        && (!filter.nueve|| client.nueve.toFixed(1) === filter.nueve || client.nueve.toFixed(1) == filter.nueve)
					        && (!filter.diez|| client.diez.toFixed(1) === filter.diez || client.diez.toFixed(1) == filter.diez)
					        && (!filter.once|| client.once.toFixed(1) === filter.once || client.once.toFixed(1) == filter.once)
					        && (!filter.doce|| client.doce.toFixed(1) === filter.doce || client.doce.toFixed(1) == filter.doce)
					        && (!filter.trece|| client.trece.toFixed(1) === filter.trece || client.trece.toFixed(1) == filter.trece)
					});
					promedios=sacarPromedios(json);
					json.push({ "area":"RESULTADO", "promedioGral":Number(promedios[0]),"uno":Number(promedios[1]),
						"dos":Number(promedios[2]),"tres":Number(promedios[3]),
						"cuatro":Number(promedios[4]),"cinco":Number(promedios[5]),
						"seis":Number(promedios[6]),"siete":Number(promedios[7]),"ocho":Number(promedios[8]),
						"nueve":Number(promedios[9]),"diez":Number(promedios[10]),"once":Number(promedios[11]),
						"doce":Number(promedios[12]),"trece":Number(promedios[13]) });
					generaTabla(json,'#tablaAreas',"AREAS",promedios);
					return json;
				}
	 };
		    window.db = db;
		    db.res;
		    // alert(db.areas);
		    $("#areas").jsGrid({
		    	//data: db.areas,
		        height: "auto",
		        width: "100%",
		        controller: db,
		        
		        filtering: true,
		        autoload:true,
		        sorting:true,
		        fields: [
		            { title:"AREA",name: "area", type: "text", width: 44, cellRenderer: function(item, value){
    		            var contenido="<td>"+item+"</td>";
		            	if(item=="RESULTADO"){
		            		contenido="<td style='color:white; background:black; font-weight: bold; text-align:center;''>"+item+"</td>";
		            }
			                return $(contenido).addClass("promedioGral"); }},
		            { title:"PROMEDIO", name: "promedioGral", align:'center', type: "text", width: 20, cellRenderer: function(item, value){
						var contenido=obtenerCelda(item,"PROMEDIO GENERAL");
						return $(contenido).addClass("promedioGral"); }
						 },
						 { headerTemplate: function() { return $("<div>").prop("title", "LIDERAZGO").text(this.title); },
							 title:"1",name: "uno", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
			 					var contenido=obtenerCelda(item,"LIDERAZGO");
             return $(contenido).addClass("uno"); }},
         { headerTemplate: function() { return $("<div>").prop("title", "DESARROLLO DE PERSONAL").text(this.title); },title:"2",name: "dos", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
         	var contenido=obtenerCelda(item,"DESARROLLO DE PERSONAL");
             return $(contenido).addClass("dos"); }},
         { headerTemplate: function() { return $("<div>").prop("title", "APEGO A LINEAMIENTOS").text(this.title); },title:"3",name: "tres", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
         	var contenido=obtenerCelda(item,"APEGO A LINEAMIENTOS");
             return $(contenido).addClass("tres"); }},
         { headerTemplate: function() { return $("<div>").prop("title", "TRABAJO EN EQUIPO").text(this.title); },title:"4",name: "cuatro", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
         	var contenido=obtenerCelda(item,"TRABAJO EN EQUIPO");
             return $(contenido).addClass("cuatro"); }},
         { headerTemplate: function() { return $("<div>").prop("title", "COMUNICACI\u00D3N EFECTIVA").text(this.title); },title:"5",name: "cinco", type: "text", width: 10 , align : 'center', cellRenderer: function(item, value){
         	var contenido=obtenerCelda(item,"COMUNICACI\u00D3N EFECTIVA");
             return $(contenido).addClass("cinco"); }},
         { headerTemplate: function() { return $("<div>").prop("title", "ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS").text(this.title); },title:"6",name: "seis", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
         	var contenido=obtenerCelda(item,"ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS");
             return $(contenido).addClass("seis"); }},
         { headerTemplate: function() { return $("<div>").prop("title", "ORIENTACI\u00D3N A RESULTADOS").text(this.title); },title:"7",name: "siete", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
        	 var contenido=obtenerCelda(item,"ORIENTACI\u00D3N A RESULTADOS");
             return $(contenido).addClass("siete"); }},
         {headerTemplate: function() { return $("<div>").prop("title", "TRABAJO BAJO PRESI\u00D3N").text(this.title); },title:"8", name: "ocho", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
         	var contenido=obtenerCelda(item,"TRABAJO BAJO PRESI\u00D3N");
             return $(contenido).addClass("ocho"); }},
         { headerTemplate: function() { return $("<div>").prop("title", "ADAPTACI\u00D3N AL CAMBIO").text(this.title); },title:"9",name: "nueve", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
         	var contenido=obtenerCelda(item,"ADAPTACI\u00D3N AL CAMBIO");
             return $(contenido).addClass("nueve"); }},
         { headerTemplate: function() { return $("<div>").prop("title", "TOMA DE DECISIONES").text(this.title); },title:"10",name: "diez", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
         	var contenido=obtenerCelda(item,"TOMA DE DECISIONES");
             return $(contenido).addClass("diez"); }},
         {headerTemplate: function() { return $("<div>").prop("title", "PLANEACI\u00D3N Y ORGANIZACI\u00D3N").text(this.title); },title:"11", name: "once", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
         	var contenido=obtenerCelda(item,"PLANEACI\u00D3N Y ORGANIZACI\u00D3N");
             return $(contenido).addClass("once"); }},
         { headerTemplate: function() { return $("<div>").prop("title", "ACTITUD").text(this.title); },title:"12",name: "doce", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
         		var contenido=obtenerCelda(item,"ACTITUD");
             return $(contenido).addClass("doce"); }},
         {headerTemplate: function() { return $("<div>").prop("title", "CONOCIMIENTOS").text(this.title); }, title:"13",name: "trece", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
         	var contenido=obtenerCelda(item,"CONOCIMIENTOS");
             return $(contenido).addClass("trece");
             }},
             ],		       
		        rowClick: function (args) {
		        	cargaDeptos(args.item.id, args.item.area, args.item.idEncuesta);  
	            }
		    });
		    var contenido="	<table id='tablaC' class='tablaCompetencia'>";
			$("#divtablaCompetencia").empty();
				contenido+=ponerCompetencias(promedios);
				contenido+="</table>";
			$("#divtablaCompetencia").append(contenido);
		    ocultarVacias(promedios, "#areas");
}
function cargaDeptos(idArea, area, idEncuesta){
		document.getElementById('cargando').style.display = 'block';
		$.ajax({
			url : 'ResultadosServlet',
			data : "accion=CargarDeptosAreas&idArea="+idArea+"&idEncuesta="+idEncuesta,
			type : 'POST',
			dataType : 'Json',
			success : function(respuesta) {
				//alert("HOla: " + JSON.stringify(respuesta) );

				if (respuesta) {
					var data = respuesta;

					if (data.length > 0) {
						cargarInformacionDeptos(idArea,respuesta,area);
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
	                alert('Error al consultar empleados.')
	        }
		});
}
function cargarInformacionDeptos(idArea,respuesta,area, idEncuesta){
	document.getElementById("imgResultados").style.marginLeft='35%';
	var promedios=[];
	var res = respuesta[0];
	var resultados = res.listResultados;
	$('#tablaDeptos').empty();
	$('#divCompetenciasDeptos').empty();
	var contenido="<div class='text-center' id='imgResultados' style='width:100%;'><img src='images/normas.PNG'></div><div id='tablaDep'></div>";
$('#divCompetenciasDeptos').append(contenido);
$("#tituloModalDeptos").empty();
$("#tituloModalDeptos").append("DEPARTAMENTOS DE "+area);
var db = {

		 loadData : function(filter) {
				var json= $.grep(resultados, function(client) {
					return (!filter.area.toUpperCase()|| client.area.toUpperCase() === filter.area.toUpperCase() || client.area.toUpperCase() == filter.area.toUpperCase() || client.area.toUpperCase().includes(filter.area.toUpperCase()))
				        && (!filter.promedioGral|| client.promedioGral.toFixed(1) === filter.promedioGral || client.promedioGral.toFixed(1) == filter.promedioGral)
				        && (!filter.uno|| client.uno.toFixed(1) === filter.uno || client.uno.toFixed(1) == filter.uno)
				        && (!filter.dos|| client.dos.toFixed(1) === filter.dos || client.dos.toFixed(1) == filter.dos)
				        && (!filter.tres|| client.tres.toFixed(1) === filter.tres || client.tres.toFixed(1) == filter.tres)
				        && (!filter.cuatro|| client.cuatro.toFixed(1) === filter.cuatro || client.cuatro.toFixed(1) == filter.cuatro)
				        && (!filter.cinco|| client.cinco.toFixed(1) === filter.cinco || client.cinco.toFixed(1) == filter.cinco)
				        && (!filter.seis|| client.seis.toFixed(1) === filter.seis || client.seis.toFixed(1) == filter.seis)
				        && (!filter.siete|| client.siete.toFixed(1) === filter.siete || client.siete.toFixed(1) == filter.siete)
				        && (!filter.ocho|| client.ocho.toFixed(1) === filter.ocho || client.ocho.toFixed(1) == filter.ocho)
				        && (!filter.nueve|| client.nueve.toFixed(1) === filter.nueve || client.nueve.toFixed(1) == filter.nueve)
				        && (!filter.diez|| client.diez.toFixed(1) === filter.diez || client.diez.toFixed(1) == filter.diez)
				        && (!filter.once|| client.once.toFixed(1) === filter.once || client.once.toFixed(1) == filter.once)
				        && (!filter.doce|| client.doce.toFixed(1) === filter.doce || client.doce.toFixed(1) == filter.doce)
				        && (!filter.trece|| client.trece.toFixed(1) === filter.trece || client.trece.toFixed(1) == filter.trece)
				});
				promedios=sacarPromedios(json);
				json.push({ "area":"RESULTADO", "promedioGral":Number(promedios[0]),"uno":Number(promedios[1]),
					"dos":Number(promedios[2]),"tres":Number(promedios[3]),
					"cuatro":Number(promedios[4]),"cinco":Number(promedios[5]),
					"seis":Number(promedios[6]),"siete":Number(promedios[7]),"ocho":Number(promedios[8]),
					"nueve":Number(promedios[9]),"diez":Number(promedios[10]),"once":Number(promedios[11]),
					"doce":Number(promedios[12]),"trece":Number(promedios[13]) });
				generaTabla(json,'#deptosTabla',"DEPARTAMENTO",promedios);
				return json;
			}
 };
	    window.db = db;
	    db.res;
	    // alert(db.departamentos);
	    $("#tablaDeptos").jsGrid({
	    	//data: db.departamentos,
	        height: "auto",
	        width: "100%",
	        controller: db,
	        filtering: true,
	        sorting:true,
	        autoload:true,
	        fields: [
	            { title:"DEPARTAMENTO",name: "area", type: "text", width: 45, cellRenderer: function(item, value){
		            var contenido="<td>"+item+"</td>";
	            	if(item=="RESULTADO"){
	            		contenido="<td style='color:white; background:black; font-weight: bold; text-align:center;''>"+item+"</td>";
	            }
		                return $(contenido).addClass("promedioGral"); }},
	            { title:"PROMEDIO", name: "promedioGral", align:'center', type: "text", width: 20,sorter: "number", cellRenderer: function(item, value){
					var contenido=obtenerCelda(item,"PROMEDIO GENERAL");
					return $(contenido).addClass("promedioGral"); }
					 },{ headerTemplate: function() { return $("<div>").prop("title", "LIDERAZGO").text(this.title); },
						 title:"1",name: "uno", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
			 					var contenido=obtenerCelda(item,"LIDERAZGO");
          return $(contenido).addClass("uno"); }},
      { headerTemplate: function() { return $("<div>").prop("title", "DESARROLLO DE PERSONAL").text(this.title); },title:"2",name: "dos", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
      	var contenido=obtenerCelda(item,"DESARROLLO DE PERSONAL");
          return $(contenido).addClass("dos"); }},
      { headerTemplate: function() { return $("<div>").prop("title", "APEGO A LINEAMIENTOS").text(this.title); },title:"3",name: "tres", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
      	var contenido=obtenerCelda(item,"APEGO A LINEAMIENTOS");
          return $(contenido).addClass("tres"); }},
      { headerTemplate: function() { return $("<div>").prop("title", "TRABAJO EN EQUIPO").text(this.title); },title:"4",name: "cuatro", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
      	var contenido=obtenerCelda(item,"TRABAJO EN EQUIPO");
          return $(contenido).addClass("cuatro"); }},
      { headerTemplate: function() { return $("<div>").prop("title", "COMUNICACI\u00D3N EFECTIVA").text(this.title); },title:"5",name: "cinco", type: "text", width: 10 , align : 'center', cellRenderer: function(item, value){
      	var contenido=obtenerCelda(item,"COMUNICACI\u00D3N EFECTIVA");
          return $(contenido).addClass("cinco"); }},
      { headerTemplate: function() { return $("<div>").prop("title", "ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS").text(this.title); },title:"6",name: "seis", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
      	var contenido=obtenerCelda(item,"ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS");
          return $(contenido).addClass("seis"); }},
      { headerTemplate: function() { return $("<div>").prop("title", "ORIENTACI\u00D3N A RESULTADOS").text(this.title); },title:"7",name: "siete", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
     	 var contenido=obtenerCelda(item,"ORIENTACI\u00D3N A RESULTADOS");
          return $(contenido).addClass("siete"); }},
      {headerTemplate: function() { return $("<div>").prop("title", "TRABAJO BAJO PRESI\u00D3N").text(this.title); },title:"8", name: "ocho", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
      	var contenido=obtenerCelda(item,"TRABAJO BAJO PRESI\u00D3N");
          return $(contenido).addClass("ocho"); }},
      { headerTemplate: function() { return $("<div>").prop("title", "ADAPTACI\u00D3N AL CAMBIO").text(this.title); },title:"9",name: "nueve", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
      	var contenido=obtenerCelda(item,"ADAPTACI\u00D3N AL CAMBIO");
          return $(contenido).addClass("nueve"); }},
      { headerTemplate: function() { return $("<div>").prop("title", "TOMA DE DECISIONES").text(this.title); },title:"10",name: "diez", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
      	var contenido=obtenerCelda(item,"TOMA DE DECISIONES");
          return $(contenido).addClass("diez"); }},
      {headerTemplate: function() { return $("<div>").prop("title", "PLANEACI\u00D3N Y ORGANIZACI\u00D3N").text(this.title); },title:"11", name: "once", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
      	var contenido=obtenerCelda(item,"PLANEACI\u00D3N Y ORGANIZACI\u00D3N");
          return $(contenido).addClass("once"); }},
      { headerTemplate: function() { return $("<div>").prop("title", "ACTITUD").text(this.title); },title:"12",name: "doce", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
      		var contenido=obtenerCelda(item,"ACTITUD");
          return $(contenido).addClass("doce"); }},
      {headerTemplate: function() { return $("<div>").prop("title", "CONOCIMIENTOS").text(this.title); }, title:"13",name: "trece", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
      	var contenido=obtenerCelda(item,"CONOCIMIENTOS");
          return $(contenido).addClass("trece");
          }},
         ],	rowClick: function (args) {
						cargaEmpleadosDepto(idArea,args.item.id, args.item.area,args.item.idEncuesta);  
					}
					
	    	});
	    var contenido="	<table id='tablaC' class='tablaCompetencia'>";
		$("#tablaDep").empty();
			contenido+=ponerCompetencias(promedios);
			contenido+="</table>";
		$("#tablaDep").append(contenido);
    ocultarVacias(promedios, "#areas");
	   ocultarVacias(promedios,"#tablaDeptos");
		    $("#modalDeptos").modal("show");
}
function cargaDepartamentos(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet ',
		data : "accion=CargaDeptos",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			// alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//alert(respuesta);
					cargaInformacionDepartamentos(respuesta);
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/DCH/';
        }
        else
            alert('Error al consultar resultados por area.')
    }
	});
}
function cargaInformacionDepartamentos(respuesta){
	var promedios=[]
	document.getElementById('selectEmp').style.display = 'none';
	$("#nivelesbtn").removeClass("active");
	$("#deptosbtn").addClass("active");
	$("#empleadosbtn").removeClass("active");
	$("#areasbtn").removeClass("active");
	document.getElementById('areas').style.display = 'none';
	document.getElementById('departamentos').style.display = 'block';
	document.getElementById('niveles').style.display = 'none';
	document.getElementById('empleados').style.display = 'none';
	document.getElementById('btnAreas').style.display = 'none';
	document.getElementById('btnDepartamentos').style.display = 'block';
	document.getElementById('btnNiveles').style.display = 'none';
	document.getElementById('btnEmpleados').style.display = 'none';
	$("#departamentos").empty();
	$("#departamentos").append("<br><br>");
	var res = respuesta[0];
	var resultados = res.listResultados;
	$('#divtablaCompetenciadeptos').empty();
	var db = {

			 loadData : function(filter) {
					var json= $.grep(resultados, function(client) {
						return (!filter.area.toUpperCase()|| client.area.toUpperCase() === filter.area.toUpperCase() || client.area.toUpperCase() == filter.area.toUpperCase() || client.area.toUpperCase().includes(filter.area.toUpperCase()))
					        && (!filter.promedioGral|| client.promedioGral.toFixed(1) === filter.promedioGral || client.promedioGral.toFixed(1) == filter.promedioGral)
					        && (!filter.uno|| client.uno.toFixed(1) === filter.uno || client.uno.toFixed(1) == filter.uno)
					        && (!filter.dos|| client.dos.toFixed(1) === filter.dos || client.dos.toFixed(1) == filter.dos)
					        && (!filter.tres|| client.tres.toFixed(1) === filter.tres || client.tres.toFixed(1) == filter.tres)
					        && (!filter.cuatro|| client.cuatro.toFixed(1) === filter.cuatro || client.cuatro.toFixed(1) == filter.cuatro)
					        && (!filter.cinco|| client.cinco.toFixed(1) === filter.cinco || client.cinco.toFixed(1) == filter.cinco)
					        && (!filter.seis|| client.seis.toFixed(1) === filter.seis || client.seis.toFixed(1) == filter.seis)
					        && (!filter.siete|| client.siete.toFixed(1) === filter.siete || client.siete.toFixed(1) == filter.siete)
					        && (!filter.ocho|| client.ocho.toFixed(1) === filter.ocho || client.ocho.toFixed(1) == filter.ocho)
					        && (!filter.nueve|| client.nueve.toFixed(1) === filter.nueve || client.nueve.toFixed(1) == filter.nueve)
					        && (!filter.diez|| client.diez.toFixed(1) === filter.diez || client.diez.toFixed(1) == filter.diez)
					        && (!filter.once|| client.once.toFixed(1) === filter.once || client.once.toFixed(1) == filter.once)
					        && (!filter.doce|| client.doce.toFixed(1) === filter.doce || client.doce.toFixed(1) == filter.doce)
					        && (!filter.trece|| client.trece.toFixed(1) === filter.trece || client.trece.toFixed(1) == filter.trece)
					});
					 promedios=sacarPromedios(json);
					json.push({ "area":"RESULTADO", "promedioGral":Number(promedios[0]),"uno":Number(promedios[1]),
						"dos":Number(promedios[2]),"tres":Number(promedios[3]),
						"cuatro":Number(promedios[4]),"cinco":Number(promedios[5]),
						"seis":Number(promedios[6]),"siete":Number(promedios[7]),"ocho":Number(promedios[8]),
						"nueve":Number(promedios[9]),"diez":Number(promedios[10]),"once":Number(promedios[11]),
						"doce":Number(promedios[12]),"trece":Number(promedios[13]) });
					generaTabla(json,'#tablaDeptos',"DEPTO",promedios);
					return json;
				}
	 };
		    window.db = db;
		    db.res;
		    // alert(db.departamentos);
		    $("#departamentos").jsGrid({
		    	//data: db.departamentos,
		        height: "auto",
		        width: "100%",
		        controller: db,
		        filtering: true,
		        sorting:true,
		        autoload:true,
		        fields: [
		            { title:"DEPARTAMENTO",name: "area", type: "text", width: 45, cellRenderer: function(item, value){
    		            var contenido="<td>"+item+"</td>";
		            	if(item=="RESULTADO"){
		            		contenido="<td style='color:white; background:black; font-weight: bold; text-align:center;''>"+item+"</td>";
		            }
			                return $(contenido).addClass("promedioGral"); }},
		            { title:"PROMEDIO", name: "promedioGral", align:'center', type: "text", width: 20,sorter: "number", cellRenderer: function(item, value){
						var contenido=obtenerCelda(item,"PROMEDIO GENERAL");
						return $(contenido).addClass("promedioGral"); }
						 },{ headerTemplate: function() { return $("<div>").prop("title", "LIDERAZGO").text(this.title); },
							 title:"1",name: "uno", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
				 					var contenido=obtenerCelda(item,"LIDERAZGO");
	             return $(contenido).addClass("uno"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "DESARROLLO DE PERSONAL").text(this.title); },title:"2",name: "dos", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"DESARROLLO DE PERSONAL");
	             return $(contenido).addClass("dos"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "APEGO A LINEAMIENTOS").text(this.title); },title:"3",name: "tres", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"APEGO A LINEAMIENTOS");
	             return $(contenido).addClass("tres"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "TRABAJO EN EQUIPO").text(this.title); },title:"4",name: "cuatro", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"TRABAJO EN EQUIPO");
	             return $(contenido).addClass("cuatro"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "COMUNICACI\u00D3N EFECTIVA").text(this.title); },title:"5",name: "cinco", type: "text", width: 10 , align : 'center', cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"COMUNICACI\u00D3N EFECTIVA");
	             return $(contenido).addClass("cinco"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS").text(this.title); },title:"6",name: "seis", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS");
	             return $(contenido).addClass("seis"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "ORIENTACI\u00D3N A RESULTADOS").text(this.title); },title:"7",name: "siete", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	        	 var contenido=obtenerCelda(item,"ORIENTACI\u00D3N A RESULTADOS");
	             return $(contenido).addClass("siete"); }},
	         {headerTemplate: function() { return $("<div>").prop("title", "TRABAJO BAJO PRESI\u00D3N").text(this.title); },title:"8", name: "ocho", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"TRABAJO BAJO PRESI\u00D3N");
	             return $(contenido).addClass("ocho"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "ADAPTACI\u00D3N AL CAMBIO").text(this.title); },title:"9",name: "nueve", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"ADAPTACI\u00D3N AL CAMBIO");
	             return $(contenido).addClass("nueve"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "TOMA DE DECISIONES").text(this.title); },title:"10",name: "diez", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"TOMA DE DECISIONES");
	             return $(contenido).addClass("diez"); }},
	         {headerTemplate: function() { return $("<div>").prop("title", "PLANEACI\u00D3N Y ORGANIZACI\u00D3N").text(this.title); },title:"11", name: "once", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"PLANEACI\u00D3N Y ORGANIZACI\u00D3N");
	             return $(contenido).addClass("once"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "ACTITUD").text(this.title); },title:"12",name: "doce", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         		var contenido=obtenerCelda(item,"ACTITUD");
	             return $(contenido).addClass("doce"); }},
	         {headerTemplate: function() { return $("<div>").prop("title", "CONOCIMIENTOS").text(this.title); }, title:"13",name: "trece", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"CONOCIMIENTOS");
	             return $(contenido).addClass("trece");
	             }},
             ],	rowClick: function (args) {
							cargaEmpleadosDepto("",args.item.id, args.item.area,args.item.idEncuesta);  
						}
		   
		    	});
		    var contenido="	<table id='tablaC' class='tablaCompetencia'>";
			$("#divtablaCompetencia").empty();
				contenido+=ponerCompetencias(promedios);
				contenido+="</table>";
			$("#divtablaCompetencia").append(contenido);
		    ocultarVacias(promedios, "#departamentos");
}
function cargaNiveles(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet ',
		data : "accion=CargaNiveles",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			// alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					//alert(respuesta);
					cargaInformacionNiveles(respuesta);
					document.getElementById('cargando').style.display = 'none';
				}
			} else
				{
				document.getElementById('cargando').style.display = 'none';
				}
			document.getElementById('cargando').style.display = 'none';
		},
		error : function(xhr, status, error)
        {document.getElementById('cargando').style.display = 'none';
        if (xhr.status === 200)
        {
            alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion.')
            window.location.href='/DCH/';
        }
        else
            alert('Error al consultar resultados por area.')
    }
	});
}
function cargaInformacionNiveles(respuesta){
	document.getElementById("imgResultados").style.marginLeft='35%';
	var promedios=[]
	document.getElementById('selectEmp').style.display = 'none';
	$("#nivelesbtn").addClass("active");
	$("#deptosbtn").removeClass("active");
	$("#empleadosbtn").removeClass("active");
	$("#areasbtn").removeClass("active");
	document.getElementById('areas').style.display = 'none';
	document.getElementById('departamentos').style.display = 'none';
	document.getElementById('niveles').style.display = 'block';
	document.getElementById('empleados').style.display = 'none';
	document.getElementById('btnAreas').style.display = 'none';
	document.getElementById('btnDepartamentos').style.display = 'none';
	document.getElementById('btnNiveles').style.display = 'block';
	document.getElementById('btnEmpleados').style.display = 'none';
	$("#niveles").empty();
	$("#niveles").append("<br><br>");
	var res = respuesta[0];
	var resultados = res.listResultados;
	
	 var db = {

			 loadData : function(filter) {
					var json= $.grep(resultados, function(client) {
						return (!filter.area.toUpperCase()|| client.area.toUpperCase() === filter.area.toUpperCase() || client.area.toUpperCase() == filter.area.toUpperCase() || client.area.toUpperCase().includes(filter.area.toUpperCase()))
					        && (!filter.promedioGral|| client.promedioGral.toFixed(1) === filter.promedioGral || client.promedioGral.toFixed(1) == filter.promedioGral)
					        && (!filter.uno|| client.uno.toFixed(1) === filter.uno || client.uno.toFixed(1) == filter.uno)
					        && (!filter.dos|| client.dos.toFixed(1) === filter.dos || client.dos.toFixed(1) == filter.dos)
					        && (!filter.tres|| client.tres.toFixed(1) === filter.tres || client.tres.toFixed(1) == filter.tres)
					        && (!filter.cuatro|| client.cuatro.toFixed(1) === filter.cuatro || client.cuatro.toFixed(1) == filter.cuatro)
					        && (!filter.cinco|| client.cinco.toFixed(1) === filter.cinco || client.cinco.toFixed(1) == filter.cinco)
					        && (!filter.seis|| client.seis.toFixed(1) === filter.seis || client.seis.toFixed(1) == filter.seis)
					        && (!filter.siete|| client.siete.toFixed(1) === filter.siete || client.siete.toFixed(1) == filter.siete)
					        && (!filter.ocho|| client.ocho.toFixed(1) === filter.ocho || client.ocho.toFixed(1) == filter.ocho)
					        && (!filter.nueve|| client.nueve.toFixed(1) === filter.nueve || client.nueve.toFixed(1) == filter.nueve)
					        && (!filter.diez|| client.diez.toFixed(1) === filter.diez || client.diez.toFixed(1) == filter.diez)
					        && (!filter.once|| client.once.toFixed(1) === filter.once || client.once.toFixed(1) == filter.once)
					        && (!filter.doce|| client.doce.toFixed(1) === filter.doce || client.doce.toFixed(1) == filter.doce)
					        && (!filter.trece|| client.trece.toFixed(1) === filter.trece || client.trece.toFixed(1) == filter.trece)
					});
					promedios=sacarPromedios(json);
					json.push({ "area":"RESULTADO", "promedioGral":Number(promedios[0]),"uno":Number(promedios[1]),
						"dos":Number(promedios[2]),"tres":Number(promedios[3]),
						"cuatro":Number(promedios[4]),"cinco":Number(promedios[5]),
						"seis":Number(promedios[6]),"siete":Number(promedios[7]),"ocho":Number(promedios[8]),
						"nueve":Number(promedios[9]),"diez":Number(promedios[10]),"once":Number(promedios[11]),
						"doce":Number(promedios[12]),"trece":Number(promedios[13]) });
					generaTabla(json,'#tablaNiveles',"NIVEL",promedios);
					return json;
				}
	 };
		    window.db = db;
		    db.res;
		    // alert(db.departamentos);
		    $("#niveles").jsGrid({
		    	//data: db.departamentos,
		        height: "auto",
		        width: "100%",
		        controller: db,
		        filtering: true,
		        sorting:true,
		        autoload:true,
		        fields: [
		            { title:"NIVEL",name: "area", type: "text", width: 44, cellRenderer: function(item, value){
    		            var contenido="<td>"+item+"</td>";
		            	if(item=="RESULTADO"){
		            		contenido="<td style='color:white; background:black; font-weight: bold; text-align:center;''>"+item+"</td>";
		            }
			                return $(contenido).addClass("promedioGral"); }},
		            { title:"PROMEDIO", name: "promedioGral", align:'center', type: "text", width: 20,sorter: "number", cellRenderer: function(item, value){
						var contenido=obtenerCelda(item,"PROMEDIO GENERAL");
						return $(contenido).addClass("promedioGral"); }
						 },{ headerTemplate: function() { return $("<div>").prop("title", "LIDERAZGO").text(this.title); },
							 title:"1",name: "uno", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
				 					var contenido=obtenerCelda(item,"LIDERAZGO");
	             return $(contenido).addClass("uno"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "DESARROLLO DE PERSONAL").text(this.title); },title:"2",name: "dos", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"DESARROLLO DE PERSONAL");
	             return $(contenido).addClass("dos"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "APEGO A LINEAMIENTOS").text(this.title); },title:"3",name: "tres", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"APEGO A LINEAMIENTOS");
	             return $(contenido).addClass("tres"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "TRABAJO EN EQUIPO").text(this.title); },title:"4",name: "cuatro", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"TRABAJO EN EQUIPO");
	             return $(contenido).addClass("cuatro"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "COMUNICACI\u00D3N EFECTIVA").text(this.title); },title:"5",name: "cinco", type: "text", width: 10 , align : 'center', cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"COMUNICACI\u00D3N EFECTIVA");
	             return $(contenido).addClass("cinco"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS").text(this.title); },title:"6",name: "seis", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS");
	             return $(contenido).addClass("seis"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "ORIENTACI\u00D3N A RESULTADOS").text(this.title); },title:"7",name: "siete", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	        	 var contenido=obtenerCelda(item,"ORIENTACI\u00D3N A RESULTADOS");
	             return $(contenido).addClass("siete"); }},
	         {headerTemplate: function() { return $("<div>").prop("title", "TRABAJO BAJO PRESI\u00D3N").text(this.title); },title:"8", name: "ocho", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"TRABAJO BAJO PRESI\u00D3N");
	             return $(contenido).addClass("ocho"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "ADAPTACI\u00D3N AL CAMBIO").text(this.title); },title:"9",name: "nueve", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"ADAPTACI\u00D3N AL CAMBIO");
	             return $(contenido).addClass("nueve"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "TOMA DE DECISIONES").text(this.title); },title:"10",name: "diez", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"TOMA DE DECISIONES");
	             return $(contenido).addClass("diez"); }},
	         {headerTemplate: function() { return $("<div>").prop("title", "PLANEACI\u00D3N Y ORGANIZACI\u00D3N").text(this.title); },title:"11", name: "once", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"PLANEACI\u00D3N Y ORGANIZACI\u00D3N");
	             return $(contenido).addClass("once"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "ACTITUD").text(this.title); },title:"12",name: "doce", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         		var contenido=obtenerCelda(item,"ACTITUD");
	             return $(contenido).addClass("doce"); }},
	         {headerTemplate: function() { return $("<div>").prop("title", "CONOCIMIENTOS").text(this.title); }, title:"13",name: "trece", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"CONOCIMIENTOS");
	             return $(contenido).addClass("trece");
	             }},
             ],	rowClick: function (args) {
            		
            	 tipoEncuenta(args.item.id, args.item.idEncuesta);  
             }
							});
		    var contenido="	<table id='tablaC' class='tablaCompetencia'>";
			$("#divtablaCompetencia").empty();
				contenido+=ponerCompetencias(promedios);
				contenido+="</table>";
			$("#divtablaCompetencia").append(contenido);
ocultarVacias(promedios,"#niveles");
		   
}
function tipoEncuenta(idTipoEncuesta,idEncuesta){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet',
		data : "accion=CargarEmpleados&idTipoEncuesta="+idTipoEncuesta+"&idEncuesta="+idEncuesta,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					cargarInformacionEmpleadosArea(respuesta,idTipoEncuesta);
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
                alert('Error al consultar empleados.')
        }
	});
}
function cargaEmpleado(idTipoEncuesta,boton,idEncuesta){
	document.getElementById('selectEmp').style.display = 'block';
	var contenido="";
	if(boton){
		$("#selectEmp").empty();
		contenido+="<select id='tipoEncuesta' onchange='cargaEmpleado(this.value,false,0);'>"
			+"<option value=0>Todos</option>"
			+"<option value=1 selected>Gerencial</option>"
			+"<option value=2>Mandos Medios</option>"
			+"<option value=3>Administrativo</option>"
			+"<option value=4>Operativo</option>"
			+"</select>";
			$("#selectEmp").append(contenido);
	}
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet',
		data : "accion=CargarEmpleados&idTipoEncuesta="+idTipoEncuesta+"&idEncuesta="+idEncuesta,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					
					cargarInformacionEmpleados(respuesta,idTipoEncuesta);
					
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
                alert('Error al consultar empleados.')
        }
	});
}
function cargarInformacionEmpleados(respuesta,idTipoEncuesta){
	 document.getElementById("imgResultados").style.marginLeft='30%';
	var promedios=[]
	document.getElementById('selectEmp').style.display = 'block';
	$("#nivelesbtn").removeClass("active");
	$("#deptosbtn").removeClass("active");
	$("#empleadosbtn").addClass("active");
	$("#areasbtn").removeClass("active");
	document.getElementById('areas').style.display = 'none';
	document.getElementById('departamentos').style.display = 'none';
	document.getElementById('niveles').style.display = 'none';
	document.getElementById('empleados').style.display = 'block';
	document.getElementById('btnAreas').style.display = 'none';
	document.getElementById('btnDepartamentos').style.display = 'none';
	document.getElementById('btnNiveles').style.display = 'none';
	document.getElementById('btnEmpleados').style.display = 'block';
	$("#empleados").append("<br><br>");
	var res = respuesta[0];
	var resultados = res.listResultados;
	
	var db = {

			 loadData : function(filter) {
					var json= $.grep(resultados, function(client) {
						return (!filter.area.toUpperCase()|| client.area.toUpperCase() === filter.area.toUpperCase() || client.area.toUpperCase() == filter.area.toUpperCase() || client.area.toUpperCase().includes(filter.area.toUpperCase()))
									 &&(!filter.depto.toUpperCase()|| client.depto.toUpperCase() === filter.depto.toUpperCase() || client.depto.toUpperCase() == filter.depto.toUpperCase() || client.depto.toUpperCase().includes(filter.depto.toUpperCase()))
									 &&(!filter.puesto.toUpperCase()|| client.puesto.toUpperCase() === filter.puesto.toUpperCase() || client.puesto.toUpperCase() == filter.puesto.toUpperCase() || client.puesto.toUpperCase().includes(filter.puesto.toUpperCase()))
					        && (!filter.promedioGral|| client.promedioGral.toFixed(1) === filter.promedioGral || client.promedioGral.toFixed(1) == filter.promedioGral)
					        && (!filter.uno|| client.uno.toFixed(1) === filter.uno || client.uno.toFixed(1) == filter.uno)
					        && (!filter.dos|| client.dos.toFixed(1) === filter.dos || client.dos.toFixed(1) == filter.dos)
					        && (!filter.tres|| client.tres.toFixed(1) === filter.tres || client.tres.toFixed(1) == filter.tres)
					        && (!filter.cuatro|| client.cuatro.toFixed(1) === filter.cuatro || client.cuatro.toFixed(1) == filter.cuatro)
					        && (!filter.cinco|| client.cinco.toFixed(1) === filter.cinco || client.cinco.toFixed(1) == filter.cinco)
					        && (!filter.seis|| client.seis.toFixed(1) === filter.seis || client.seis.toFixed(1) == filter.seis)
					        && (!filter.siete|| client.siete.toFixed(1) === filter.siete || client.siete.toFixed(1) == filter.siete)
					        && (!filter.ocho|| client.ocho.toFixed(1) === filter.ocho || client.ocho.toFixed(1) == filter.ocho)
					        && (!filter.nueve|| client.nueve.toFixed(1) === filter.nueve || client.nueve.toFixed(1) == filter.nueve)
					        && (!filter.diez|| client.diez.toFixed(1) === filter.diez || client.diez.toFixed(1) == filter.diez)
					        && (!filter.once|| client.once.toFixed(1) === filter.once || client.once.toFixed(1) == filter.once)
					        && (!filter.doce|| client.doce.toFixed(1) === filter.doce || client.doce.toFixed(1) == filter.doce)
					        && (!filter.trece|| client.trece.toFixed(1) === filter.trece || client.trece.toFixed(1) == filter.trece)
					});
					promedios=sacarPromedios(json);
					json.push({"depto":"", "area":"","puesto":"RESULTADO", "promedioGral":Number(promedios[0]),"uno":Number(promedios[1]),
						"dos":Number(promedios[2]),"tres":Number(promedios[3]),
						"cuatro":Number(promedios[4]),"cinco":Number(promedios[5]),
						"seis":Number(promedios[6]),"siete":Number(promedios[7]),"ocho":Number(promedios[8]),
						"nueve":Number(promedios[9]),"diez":Number(promedios[10]),"once":Number(promedios[11]),
						"doce":Number(promedios[12]),"trece":Number(promedios[13]) });
					generaTabla2(json,'#tablaEmpleados',promedios);
					return json;
				}
	 };
		    window.db = db;
		    db.res;
		    // alert(db.departamentos);
		    $("#empleados").jsGrid({
		    	//data: db.departamentos,
		        height: "auto",
		        width: "100%",
		        controller: db,
		        filtering: true,
		        autoload:true,
		        sorting:true,
		        fields: [
		        			{ title:"DEPARTAMENTO",name: "depto", type: "text", cellRenderer: function(item, value){
		    		            var contenido="<td>"+item+"</td>";
				            	if(item==""){
				            		contenido="<td style='background:black;'></td>";
				            }
					                return $(contenido).addClass("promedioGral"); }},
		            { title:"NOMBRE EMPLEADO",name: "area", type: "text", cellRenderer: function(item, value){
		            	var nombre=item.split(',');
    		            var contenido="<td><div title='"+nombre[1]+"'>"+nombre[0]+"</div></td>";
		            	if(item==""){
		            		contenido="<td style='background:black;'></td>";
		            }
			                return $(contenido).addClass("promedioGral"); }},
		            { title:"PUESTO",name: "puesto", type: "text", cellRenderer: function(item, value){
    		            var contenido="<td>"+item+"</td>";
		            	if(item=="RESULTADO"){
		            		contenido="<td style='color:white; background:black; font-weight: bold; text-align:center;''>"+item+"</td>";
		            }
			                return $(contenido).addClass("promedioGral"); }},
		            { title:"P", name: "promedioGral", align:'center', type: "text", width: 5, cellRenderer: function(item, value){
										var contenido=obtenerCelda(item,"PROMEDIO GENERAL");
										return $(contenido).addClass("promedioGral"); }
										 },{ headerTemplate: function() { return $("<div>").prop("title", "LIDERAZGO").text(this.title); },
											 title:"1",name: "uno", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
								 					var contenido=obtenerCelda(item,"LIDERAZGO");
					             return $(contenido).addClass("uno"); }},
					         { headerTemplate: function() { return $("<div>").prop("title", "DESARROLLO DE PERSONAL").text(this.title); },title:"2",name: "dos", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
					         	var contenido=obtenerCelda(item,"DESARROLLO DE PERSONAL");
					             return $(contenido).addClass("dos"); }},
					         { headerTemplate: function() { return $("<div>").prop("title", "APEGO A LINEAMIENTOS").text(this.title); },title:"3",name: "tres", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
					         	var contenido=obtenerCelda(item,"APEGO A LINEAMIENTOS");
					             return $(contenido).addClass("tres"); }},
					         { headerTemplate: function() { return $("<div>").prop("title", "TRABAJO EN EQUIPO").text(this.title); },title:"4",name: "cuatro", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
					         	var contenido=obtenerCelda(item,"TRABAJO EN EQUIPO");
					             return $(contenido).addClass("cuatro"); }},
					         { headerTemplate: function() { return $("<div>").prop("title", "COMUNICACI\u00D3N EFECTIVA").text(this.title); },title:"5",name: "cinco", type: "text", width: 10 , align : 'center', cellRenderer: function(item, value){
					         	var contenido=obtenerCelda(item,"COMUNICACI\u00D3N EFECTIVA");
					             return $(contenido).addClass("cinco"); }},
					         { headerTemplate: function() { return $("<div>").prop("title", "ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS").text(this.title); },title:"6",name: "seis", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
					         	var contenido=obtenerCelda(item,"ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS");
					             return $(contenido).addClass("seis"); }},
					         { headerTemplate: function() { return $("<div>").prop("title", "ORIENTACI\u00D3N A RESULTADOS").text(this.title); },title:"7",name: "siete", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
					        	 var contenido=obtenerCelda(item,"ORIENTACI\u00D3N A RESULTADOS");
					             return $(contenido).addClass("siete"); }},
					         {headerTemplate: function() { return $("<div>").prop("title", "TRABAJO BAJO PRESI\u00D3N").text(this.title); },title:"8", name: "ocho", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
					         	var contenido=obtenerCelda(item,"TRABAJO BAJO PRESI\u00D3N");
					             return $(contenido).addClass("ocho"); }},
					         { headerTemplate: function() { return $("<div>").prop("title", "ADAPTACI\u00D3N AL CAMBIO").text(this.title); },title:"9",name: "nueve", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
					         	var contenido=obtenerCelda(item,"ADAPTACI\u00D3N AL CAMBIO");
					             return $(contenido).addClass("nueve"); }},
					         { headerTemplate: function() { return $("<div>").prop("title", "TOMA DE DECISIONES").text(this.title); },title:"10",name: "diez", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
					         	var contenido=obtenerCelda(item,"TOMA DE DECISIONES");
					             return $(contenido).addClass("diez"); }},
					         {headerTemplate: function() { return $("<div>").prop("title", "PLANEACI\u00D3N Y ORGANIZACI\u00D3N").text(this.title); },title:"11", name: "once", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
					         	var contenido=obtenerCelda(item,"PLANEACI\u00D3N Y ORGANIZACI\u00D3N");
					             return $(contenido).addClass("once"); }},
					         { headerTemplate: function() { return $("<div>").prop("title", "ACTITUD").text(this.title); },title:"12",name: "doce", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
					         		var contenido=obtenerCelda(item,"ACTITUD");
					             return $(contenido).addClass("doce"); }},
					         {headerTemplate: function() { return $("<div>").prop("title", "CONOCIMIENTOS").text(this.title); }, title:"13",name: "trece", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
					         	var contenido=obtenerCelda(item,"CONOCIMIENTOS");
					             return $(contenido).addClass("trece");
					             }},
				             ],	rowClick: function (args) {
				                	cargaDetalleEmpleados(args.item.id, args.item.area, args.item.promedioGral,args.item.puesto,args.item.idEncuesta);  
				                }
						    });
		    var contenido="	<table id='tablaC' class='tablaCompetencia'>";
		    $("#divtablaCompetencia").empty();
			contenido+=ponerCompetencias(promedios);
			contenido+="</table>";
		$("#divtablaCompetencia").append(contenido);
		    ocultarVacias(promedios, "#empleados");
		    }
	

function cargaEmpleadosDepto(idArea,idDepartamento,depto,idEncuesta){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet',
		data : "accion=CargarEmpleadosDepto&idDepartamento="+idDepartamento+"&idEncuesta="+idEncuesta+"&idArea="+idArea,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					
					cargarInformacionEmpleadosArea(respuesta, depto);
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
                alert('Error al consultar empleados.')
        }
	});
}
function cargarInformacionEmpleadosArea(respuesta, depto){
	var promedios=[];
	var res = respuesta[0];
	var resultados = res.listResultados;
	$('#tablaResultados').empty();
	$('#divCompetencias').empty();
	var contenido="<div style='display:flex; font-size:16px;'><div id='seleccionarArea'></div>&nbsp;<div id='selecccionarDepto'></div></div><br><div class='text-center' id='imgResultados' style='width:100%;'><img src='images/normas.PNG'></div>" +
			"<div id='tablaCompetencias'></div>";
$('#divCompetencias').append(contenido);
$("#tituloModalResultados").empty();
if(depto==1){
	$("#tituloModalResultados").append("EMPLEADOS GERENCIALES");
}else if(depto==2){
	$("#tituloModalResultados").append("EMPLEADOS MANDOS MEDIOS");
	todasAreas(2);	
	todosDeptos(2);
}else if(depto==3){
	$("#tituloModalResultados").append("EMPLEADOS ADMINISTRATIVOS");
	todasAreas(3);	
	todosDeptos(3);
}else if(depto==4){
	$("#tituloModalResultados").append("EMPLEADOS OPERACIONES");
	todasAreas(4);	
	todosDeptos(4);
}else{
	$("#tituloModalResultados").append("EMPLEADOS DE: "+depto);
}

var db = {

		 loadData : function(filter) {
				var json= $.grep(resultados, function(client) {
					return (!filter.area.toUpperCase()|| client.area.toUpperCase() === filter.area.toUpperCase() || client.area.toUpperCase() == filter.area.toUpperCase() || client.area.toUpperCase().includes(filter.area.toUpperCase()))
								 &&(!filter.puesto.toUpperCase()|| client.puesto.toUpperCase() === filter.puesto.toUpperCase() || client.puesto.toUpperCase() == filter.puesto.toUpperCase() || client.puesto.toUpperCase().includes(filter.puesto.toUpperCase()))
				        && (!filter.promedioGral|| client.promedioGral.toFixed(1) === filter.promedioGral || client.promedioGral.toFixed(1) == filter.promedioGral)
				        && (!filter.uno|| client.uno.toFixed(1) === filter.uno || client.uno.toFixed(1) == filter.uno)
				        && (!filter.dos|| client.dos.toFixed(1) === filter.dos || client.dos.toFixed(1) == filter.dos)
				        && (!filter.tres|| client.tres.toFixed(1) === filter.tres || client.tres.toFixed(1) == filter.tres)
				        && (!filter.cuatro|| client.cuatro.toFixed(1) === filter.cuatro || client.cuatro.toFixed(1) == filter.cuatro)
				        && (!filter.cinco|| client.cinco.toFixed(1) === filter.cinco || client.cinco.toFixed(1) == filter.cinco)
				        && (!filter.seis|| client.seis.toFixed(1) === filter.seis || client.seis.toFixed(1) == filter.seis)
				        && (!filter.siete|| client.siete.toFixed(1) === filter.siete || client.siete.toFixed(1) == filter.siete)
				        && (!filter.ocho|| client.ocho.toFixed(1) === filter.ocho || client.ocho.toFixed(1) == filter.ocho)
				        && (!filter.nueve|| client.nueve.toFixed(1) === filter.nueve || client.nueve.toFixed(1) == filter.nueve)
				        && (!filter.diez|| client.diez.toFixed(1) === filter.diez || client.diez.toFixed(1) == filter.diez)
				        && (!filter.once|| client.once.toFixed(1) === filter.once || client.once.toFixed(1) == filter.once)
				        && (!filter.doce|| client.doce.toFixed(1) === filter.doce || client.doce.toFixed(1) == filter.doce)
				        && (!filter.trece|| client.trece.toFixed(1) === filter.trece || client.trece.toFixed(1) == filter.trece)
				});
				 promedios=sacarPromedios(json);
				json.push({ "area":"","puesto":"RESULTADO", "promedioGral":Number(promedios[0]),"uno":Number(promedios[1]),
					"dos":Number(promedios[2]),"tres":Number(promedios[3]),
					"cuatro":Number(promedios[4]),"cinco":Number(promedios[5]),
					"seis":Number(promedios[6]),"siete":Number(promedios[7]),"ocho":Number(promedios[8]),
					"nueve":Number(promedios[9]),"diez":Number(promedios[10]),"once":Number(promedios[11]),
					"doce":Number(promedios[12]),"trece":Number(promedios[13]) });
				generaTabla2(json,'#tablaEmpleados',promedios);
				return json;
			}
};
		    window.db = db;
		    db.res;
		    // alert(db.departamentos);
		    $("#tablaResultados").jsGrid({
		    	//data: db.departamentos,
		        height: "auto",
		        width: "100%",
		        controller: db,
		        filtering: true,
		        autoload:true,
		        sorting: true,
		        fields: [
		            { title:"NOMBRE EMPLEADO",name: "area", type: "text", cellRenderer: function(item, value){
		            	var nombre=item.split(',');
		            var contenido="<td><div title='"+nombre[1]+"'>"+nombre[0]+"</div></td>";
		            	if(item==""){
		            		contenido="<td style='background:black;'></td>";
		            }
			                return $(contenido).addClass("promedioGral"); }},
		            { title:"PUESTO",name: "puesto", type: "text",cellRenderer: function(item, value){
		            var contenido="<td>"+item+"</td>";
		            	if(item=="RESULTADO"){
		            		contenido="<td style='color:white; background:black; font-weight: bold; text-align:center;'>"+item+"</td>";
		            }
			                return $(contenido).addClass("promedioGral"); },},
		            {headerTemplate: function() { return $("<div>").prop("title", "PROMEDIO GENERAL").text(this.title); }, title:"P", name: "promedioGral", align:'center', type: "text", width: 5, cellRenderer: function(item, value){
	 											var contenido=obtenerCelda(item,"PROMEDIO GENERAL");
		                return $(contenido).addClass("promedioGral"); }
		    			 },{ headerTemplate: function() { return $("<div>").prop("title", "LIDERAZGO").text(this.title); },
							 title:"1",name: "uno", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
				 					var contenido=obtenerCelda(item,"LIDERAZGO");
	             return $(contenido).addClass("uno"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "DESARROLLO DE PERSONAL").text(this.title); },title:"2",name: "dos", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"DESARROLLO DE PERSONAL");
	             return $(contenido).addClass("dos"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "APEGO A LINEAMIENTOS").text(this.title); },title:"3",name: "tres", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"APEGO A LINEAMIENTOS");
	             return $(contenido).addClass("tres"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "TRABAJO EN EQUIPO").text(this.title); },title:"4",name: "cuatro", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"TRABAJO EN EQUIPO");
	             return $(contenido).addClass("cuatro"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "COMUNICACI\u00D3N EFECTIVA").text(this.title); },title:"5",name: "cinco", type: "text", width: 10 , align : 'center', cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"COMUNICACI\u00D3N EFECTIVA");
	             return $(contenido).addClass("cinco"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS").text(this.title); },title:"6",name: "seis", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS");
	             return $(contenido).addClass("seis"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "ORIENTACI\u00D3N A RESULTADOS").text(this.title); },title:"7",name: "siete", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	        	 var contenido=obtenerCelda(item,"ORIENTACI\u00D3N A RESULTADOS");
	             return $(contenido).addClass("siete"); }},
	         {headerTemplate: function() { return $("<div>").prop("title", "TRABAJO BAJO PRESI\u00D3N").text(this.title); },title:"8", name: "ocho", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"TRABAJO BAJO PRESI\u00D3N");
	             return $(contenido).addClass("ocho"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "ADAPTACI\u00D3N AL CAMBIO").text(this.title); },title:"9",name: "nueve", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"ADAPTACI\u00D3N AL CAMBIO");
	             return $(contenido).addClass("nueve"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "TOMA DE DECISIONES").text(this.title); },title:"10",name: "diez", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"TOMA DE DECISIONES");
	             return $(contenido).addClass("diez"); }},
	         {headerTemplate: function() { return $("<div>").prop("title", "PLANEACI\u00D3N Y ORGANIZACI\u00D3N").text(this.title); },title:"11", name: "once", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"PLANEACI\u00D3N Y ORGANIZACI\u00D3N");
	             return $(contenido).addClass("once"); }},
	         { headerTemplate: function() { return $("<div>").prop("title", "ACTITUD").text(this.title); },title:"12",name: "doce", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
	         		var contenido=obtenerCelda(item,"ACTITUD");
	             return $(contenido).addClass("doce"); }},
	         {headerTemplate: function() { return $("<div>").prop("title", "CONOCIMIENTOS").text(this.title); }, title:"13",name: "trece", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
	         	var contenido=obtenerCelda(item,"CONOCIMIENTOS");
	             return $(contenido).addClass("trece");
	             }},
             ],	rowClick: function (args) {
		        	
		        	cargaDetalleEmpleados(args.item.id, args.item.area, args.item.promedioGral,args.item.puesto,args.item.idEncuesta);
		        	
	            }
		    });
		    var contenido="	<table id='tablaC' class='tablaCompetencia'>";
			$("#tablaCompetencias").empty();
				contenido+=ponerCompetencias(promedios);
				contenido+="</table>";
			$("#tablaCompetencias").append(contenido);
			ocultarVacias(promedios, "#tablaResultados");
		    $("#modalResultados").modal("show");
}
function todasAreas(idTipoEncuesta){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet',
		data : "accion=TodasAreas",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );
			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					$("#seleccionarArea").empty();
					var contenido="AREAS: <select id='selectArea' onchange='cargaEmpleadosTipoArea("+idTipoEncuesta+",this.value)'><option value=0>TODOS</option>";
					for(var i=0;i<respuesta[0].listResultados.length;i++){
						contenido+="<option value="+respuesta[0].listResultados[i].idArea+">"+respuesta[0].listResultados[i].descripcion+"</option>";
					}
					contenido+="</select>";
					$("#seleccionarArea").append(contenido);
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
                alert('Error al consultar empleados.')
        }
	});
}
function cargaEmpleadosTipoArea(idTipoEncuesta,idArea){
	todosDeptos(idTipoEncuesta);
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet',
		data : "accion=CargarEmpleadosTipoArea&idTipoEncuesta="+idTipoEncuesta+"&idArea="+idArea,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
		//	alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					
					cargarInformacionEmpleadosTipo(respuesta, idTipoEncuesta);
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
                alert('Error al consultar empleados.')
        }
	});
	
}
function cargarInformacionEmpleadosTipo(respuesta,idTipoEncuesta){
	var promedios=[];
	var res = respuesta[0];
	var resultados = res.listResultados;
	var db = {

			 loadData : function(filter) {
					var json= $.grep(resultados, function(client) {
						return (!filter.area.toUpperCase()|| client.area.toUpperCase() === filter.area.toUpperCase() || client.area.toUpperCase() == filter.area.toUpperCase() || client.area.toUpperCase().includes(filter.area.toUpperCase()))
									 &&(!filter.puesto.toUpperCase()|| client.puesto.toUpperCase() === filter.puesto.toUpperCase() || client.puesto.toUpperCase() == filter.puesto.toUpperCase() || client.puesto.toUpperCase().includes(filter.puesto.toUpperCase()))
					        && (!filter.promedioGral|| client.promedioGral.toFixed(1) === filter.promedioGral || client.promedioGral.toFixed(1) == filter.promedioGral)
					        && (!filter.uno|| client.uno.toFixed(1) === filter.uno || client.uno.toFixed(1) == filter.uno)
					        && (!filter.dos|| client.dos.toFixed(1) === filter.dos || client.dos.toFixed(1) == filter.dos)
					        && (!filter.tres|| client.tres.toFixed(1) === filter.tres || client.tres.toFixed(1) == filter.tres)
					        && (!filter.cuatro|| client.cuatro.toFixed(1) === filter.cuatro || client.cuatro.toFixed(1) == filter.cuatro)
					        && (!filter.cinco|| client.cinco.toFixed(1) === filter.cinco || client.cinco.toFixed(1) == filter.cinco)
					        && (!filter.seis|| client.seis.toFixed(1) === filter.seis || client.seis.toFixed(1) == filter.seis)
					        && (!filter.siete|| client.siete.toFixed(1) === filter.siete || client.siete.toFixed(1) == filter.siete)
					        && (!filter.ocho|| client.ocho.toFixed(1) === filter.ocho || client.ocho.toFixed(1) == filter.ocho)
					        && (!filter.nueve|| client.nueve.toFixed(1) === filter.nueve || client.nueve.toFixed(1) == filter.nueve)
					        && (!filter.diez|| client.diez.toFixed(1) === filter.diez || client.diez.toFixed(1) == filter.diez)
					        && (!filter.once|| client.once.toFixed(1) === filter.once || client.once.toFixed(1) == filter.once)
					        && (!filter.doce|| client.doce.toFixed(1) === filter.doce || client.doce.toFixed(1) == filter.doce)
					        && (!filter.trece|| client.trece.toFixed(1) === filter.trece || client.trece.toFixed(1) == filter.trece)
					});
					 promedios=sacarPromedios(json);
					json.push({ "area":"","puesto":"RESULTADO", "promedioGral":Number(promedios[0]),"uno":Number(promedios[1]),
						"dos":Number(promedios[2]),"tres":Number(promedios[3]),
						"cuatro":Number(promedios[4]),"cinco":Number(promedios[5]),
						"seis":Number(promedios[6]),"siete":Number(promedios[7]),"ocho":Number(promedios[8]),
						"nueve":Number(promedios[9]),"diez":Number(promedios[10]),"once":Number(promedios[11]),
						"doce":Number(promedios[12]),"trece":Number(promedios[13]) });
				
					return json;
				}
	};
			    window.db = db;
			    db.res;
			    // alert(db.departamentos);
			    $("#tablaResultados").jsGrid({
			    	//data: db.departamentos,
			        height: "auto",
			        width: "100%",
			        controller: db,
			        filtering: true,
			        autoload:true,
			        sorting: true,
			        fields: [
			            { title:"NOMBRE EMPLEADO",name: "area", type: "text", cellRenderer: function(item, value){
			            var nombre=item.split(",");
			            var contenido="<td><div title='"+nombre[1]+"'>"+nombre[0]+"</div></td>";
			            	if(item==""){
			            		contenido="<td style='background:black;'></td>";
			            }
				                return $(contenido).addClass("promedioGral"); }},
			            { title:"PUESTO",name: "puesto", type: "text",cellRenderer: function(item, value){
			            var contenido="<td>"+item+"</td>";
			            	if(item=="RESULTADO"){
			            		contenido="<td style='color:white; background:black; font-weight: bold; text-align:center;'>"+item+"</td>";
			            }
				                return $(contenido).addClass("promedioGral"); },},
			            {headerTemplate: function() { return $("<div>").prop("title", "PROMEDIO GENERAL").text(this.title); }, title:"P", name: "promedioGral", align:'center', type: "text", width: 5, cellRenderer: function(item, value){
		 											var contenido=obtenerCelda(item,"PROMEDIO GENERAL");
			                return $(contenido).addClass("promedioGral"); }
			    			 },{ headerTemplate: function() { return $("<div>").prop("title", "LIDERAZGO").text(this.title); },
								 title:"1",name: "uno", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
					 					var contenido=obtenerCelda(item,"LIDERAZGO");
		             return $(contenido).addClass("uno"); }},
		         { headerTemplate: function() { return $("<div>").prop("title", "DESARROLLO DE PERSONAL").text(this.title); },title:"2",name: "dos", type: "text", width: 10,align : 'center', cellRenderer: function(item, value){
		         	var contenido=obtenerCelda(item,"DESARROLLO DE PERSONAL");
		             return $(contenido).addClass("dos"); }},
		         { headerTemplate: function() { return $("<div>").prop("title", "APEGO A LINEAMIENTOS").text(this.title); },title:"3",name: "tres", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
		         	var contenido=obtenerCelda(item,"APEGO A LINEAMIENTOS");
		             return $(contenido).addClass("tres"); }},
		         { headerTemplate: function() { return $("<div>").prop("title", "TRABAJO EN EQUIPO").text(this.title); },title:"4",name: "cuatro", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
		         	var contenido=obtenerCelda(item,"TRABAJO EN EQUIPO");
		             return $(contenido).addClass("cuatro"); }},
		         { headerTemplate: function() { return $("<div>").prop("title", "COMUNICACI\u00D3N EFECTIVA").text(this.title); },title:"5",name: "cinco", type: "text", width: 10 , align : 'center', cellRenderer: function(item, value){
		         	var contenido=obtenerCelda(item,"COMUNICACI\u00D3N EFECTIVA");
		             return $(contenido).addClass("cinco"); }},
		         { headerTemplate: function() { return $("<div>").prop("title", "ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS").text(this.title); },title:"6",name: "seis", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
		         	var contenido=obtenerCelda(item,"ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS");
		             return $(contenido).addClass("seis"); }},
		         { headerTemplate: function() { return $("<div>").prop("title", "ORIENTACI\u00D3N A RESULTADOS").text(this.title); },title:"7",name: "siete", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
		        	 var contenido=obtenerCelda(item,"ORIENTACI\u00D3N A RESULTADOS");
		             return $(contenido).addClass("siete"); }},
		         {headerTemplate: function() { return $("<div>").prop("title", "TRABAJO BAJO PRESI\u00D3N").text(this.title); },title:"8", name: "ocho", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
		         	var contenido=obtenerCelda(item,"TRABAJO BAJO PRESI\u00D3N");
		             return $(contenido).addClass("ocho"); }},
		         { headerTemplate: function() { return $("<div>").prop("title", "ADAPTACI\u00D3N AL CAMBIO").text(this.title); },title:"9",name: "nueve", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
		         	var contenido=obtenerCelda(item,"ADAPTACI\u00D3N AL CAMBIO");
		             return $(contenido).addClass("nueve"); }},
		         { headerTemplate: function() { return $("<div>").prop("title", "TOMA DE DECISIONES").text(this.title); },title:"10",name: "diez", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
		         	var contenido=obtenerCelda(item,"TOMA DE DECISIONES");
		             return $(contenido).addClass("diez"); }},
		         {headerTemplate: function() { return $("<div>").prop("title", "PLANEACI\u00D3N Y ORGANIZACI\u00D3N").text(this.title); },title:"11", name: "once", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
		         	var contenido=obtenerCelda(item,"PLANEACI\u00D3N Y ORGANIZACI\u00D3N");
		             return $(contenido).addClass("once"); }},
		         { headerTemplate: function() { return $("<div>").prop("title", "ACTITUD").text(this.title); },title:"12",name: "doce", type: "text", width: 10, align : 'center' , cellRenderer: function(item, value){
		         		var contenido=obtenerCelda(item,"ACTITUD");
		             return $(contenido).addClass("doce"); }},
		         {headerTemplate: function() { return $("<div>").prop("title", "CONOCIMIENTOS").text(this.title); }, title:"13",name: "trece", type: "text", width: 10, align : 'center', cellRenderer: function(item, value){
		         	var contenido=obtenerCelda(item,"CONOCIMIENTOS");
		             return $(contenido).addClass("trece");
		             }},
	             ],	rowClick: function (args) {
			        	
			        	cargaDetalleEmpleados(args.item.id, args.item.area, args.item.promedioGral, args.item.puesto,args.item.idEncuesta);
			        	
		            }
			    });
				ocultarVacias(promedios, "#tablaResultados");
			    $("#modalResultados").modal("show");
}
function todosDeptos(idTipoEncuesta){
	
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet',
		data : "accion=TodosDeptos",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );
			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					$("#selecccionarDepto").empty();
					var contenido="DEPARTAMENTOS: <select id='selectDepto' onchange='cargaTipoDepto("+idTipoEncuesta+",this.value);'><option value=0>TODOS</option>";
					for(var i=0;i<respuesta[0].listResultados.length;i++){
						contenido+="<option value="+respuesta[0].listResultados[i].idArea+">"+respuesta[0].listResultados[i].descripcion+"</option>";
					}
					contenido+="</select>";
					$("#selecccionarDepto").append(contenido);
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
                alert('Error al consultar empleados.')
        }
	});
}
function cargaTipoDepto(idTipoEncuesta, idDepto){
	todasAreas(idTipoEncuesta);
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet',
		data : "accion=CargarEmpleadosTipoDepto&idTipoEncuesta="+idTipoEncuesta+"&idDepto="+idDepto,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					
					cargarInformacionEmpleadosTipo(respuesta, idTipoEncuesta);
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
                alert('Error al consultar empleados.')
        }
	});
	
}
function cargaDetalleEmpleados(idEmpleado, nombre, promedio,puesto,idEncuesta){
	
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet',
		data : "accion=CargarDetalleEmpleado&idEmpleado="+idEmpleado+"&idEncuesta="+idEncuesta,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );
			if (respuesta) { 

				var data = respuesta;

				if (data.length > 0) {
					recuperarDatos(idEmpleado,idEncuesta);
					$("#guardarRespuestas").empty();
					$("#guardarRespuestas").append("<button id='guardarRespuestas' type='button' class='btn btn-success' onclick='Javascript: guardaRetro("+idEncuesta+");'>Guardar</button>");
					cargarInformacionDetallEmpleado(respuesta, nombre, promedio, idEmpleado, puesto,idEncuesta);
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
                alert('Tu sesion actual ha expirado, para continuar vuelve a iniciar sesion2.')
                window.location.href='/DCH/';
            }
            else
                alert('Error al consultar empleados.')
        }
	});
}
function recuperarDatos(idEmpleado, idEncuesta){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet',
		data : "accion=CargaDatos&idEmpleado="+idEmpleado+"&idEncuesta="+idEncuesta,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta));
			//cargaDetalleEmpleados(idEmpleado, nombre, promedio);
			
			if(JSON.stringify(respuesta[0].listResultados[0])!=undefined){
				var fortalezas=JSON.stringify(respuesta[0].listResultados[0]).replaceAll('"',"");
				fortalezas=fortalezas.replaceAll('\\n',"\n");
				$("#fortalezas").val(fortalezas);
			}else{
				$("#fortalezas").val("");
			}
			if(JSON.stringify(respuesta[0].listResultados[1])!=undefined){
				var areas=JSON.stringify(respuesta[0].listResultados[1]).replaceAll('"',"");
				areas=areas.replaceAll("\\n","\n");
				$("#areastxt").val(areas);
			}else{
				$("#areastxt").val("");
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
                alert('Error al consultar empleados.')
        }
	});
}
function cargarInformacionDetallEmpleado(respuesta, nombre, promedio, idEmpleado, puesto, idEncuesta){
	var nombre=nombre.split(",");
	$("#tablaDetalleEmpleado").empty();
	var head=["","LIDERAZGO","DESARROLLO DE PERSONAL","APEGO A LINEAMIENTOS","TRABAJO EN EQUIPO","COMUNICACI\u00D3N EFECTIVA","ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS","ORIENTACI\u00D3N A RESULTADOS"
			,"TRABAJO BAJO PRESI\u00D3N","ADAPTACI\u00D3N AL CAMBIO","TOMA DE DECISIONES","PLANEACI\u00D3N Y ORGANIZACI\u00D3N","ACTITUD","CONOCIMIENTOS"];
	var promedios=sacarPromedios(respuesta[0].listResultados);
	promedios[0]=0.0;
	var contenido="";
	 contenido+="<table id='tablaEmpleados' class='tablaCompetencia'><tr><th colspan='5' style='background-color:#17375e; font-size:20px; color:white; border: black 1px solid;'>NOMBRE: "+nombre[0]+"</th>" +
	 		"<th colspan='5' style='background-color:#17375e; font-size:20px; color:white; border: black 1px solid;'>PUESTO: "+puesto+"</th>" +
	 		(obtenerCelda(promedio).replace("td","th")).replace("style='","style='font-size:20px;") +
	 		"<tr><th></th>";
	 for(var h=0;h<promedios.length;h++){
		 if(promedios[h]!=0){
			 contenido+="<th>"+head[h]+"</th>";
		 }
	 }
	 contenido+="</tr>"
	for(var i=0;i<respuesta[0].listResultados.length;i++){
		if(respuesta[0].listResultados[i].area=="AUTOEVALUACION"){
			contenido+="<tr><th style='background-color:#17375e; color:white; border: black 1px solid;'>PROMEDIO</th>";
			for(var p=0;p<promedios.length;p++){
				contenido+=obtenerCelda2(promedios[p]);
			}
			contenido+="</tr><td><br></td>";
		}
		if(respuesta[0].listResultados[i].area=="AUTOEVALUACION"){
			contenido+="<tr><th style='border: black 1px solid; background-color:#8F8F8F;color:white;'>"+respuesta[0].listResultados[i].area+"</th>";
		}else{
			contenido+="<tr><th style='border: black 1px solid;'>"+respuesta[0].listResultados[i].area+"</th>";
		}
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].uno);
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].dos);
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].tres);
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].cuatro);
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].cinco);
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].seis);
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].siete);
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].ocho);
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].nueve);
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].diez);
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].once);
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].doce);
		contenido+=obtenerCelda2(respuesta[0].listResultados[i].trece);
		contenido+="</tr>"
	}
	 contenido+="<script type='text/javascript'>jQuery(document).ready(function() {"
			+"jQuery('#fortalezas').on('change, keydown',function(e) {"
			 +"window.setTimeout(function() {"
			  +"jQuery('#fortalezas').css('height',jQuery('#fortalezas')[0].scrollHeight+'px');"
			   +"},50);"
			+"});"
			+"});"
		+"jQuery(document).ready(function() {"
			+"jQuery('#areastxt').on('change, keydown',function(e) {"
			 +"window.setTimeout(function() {"
			  +"jQuery('#areastxt').css('height',jQuery('#areastxt')[0].scrollHeight+'px');"
			  +"},80);"
			 +"});"
			+"});</script>";
	contenido+="</table><br><button type='button' onclick='consultaFortalezas("+'"'+"fortalezas"+'"'+","+'"FORTALEZAS DE '+nombre+'"'+","+idEncuesta+");' class='btn btn-dark'>FORTALEZAS</button><br><br><textarea class='form-control' id='fortalezas' rows='5'></textarea>" +
			"<br><button type='button' onclick='consultaFortalezas("+'"'+"areas"+'"'+","+'"AREAS DE OPORTUNIDAD DE '+nombre+'"'+","+idEncuesta+");' class='btn btn-dark'>\u00c1REAS DE OPORTUNIDAD</button><br><br><textarea class='form-control' id='areastxt' rows='5'></textarea><input type='hidden' id='idEmpleado' value='"+idEmpleado+"'>" +
					"<br><button type='button' onclick='cargaPreguntasAbiertas("+idEmpleado+","+'"'+nombre+'"'+","+idEncuesta+");' class='btn btn-dark'>PREGUNTAS ABIERTAS</button> ";
	
	$("#tablaDetalleEmpleado").append(contenido);
	
	$("#modalDetalleEmpleado").modal("show");
}

function obtenerCelda2(celda,titulo){
	var contenido="";
	if((Math.round(Number(celda) * 10) / 10).toFixed(1)<=10&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=9.0){
		contenido+="<td class='text-center' style='background:#00ff00; color:black; border: black 1px solid;'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</td>";
	}else if((Math.round(Number(celda) * 10) / 10).toFixed(1)<9.0&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=8.0){
		contenido+="<td class='text-center' style='background:#66ffff; color:black; border: black 1px solid;'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</td>";
	}else if((Math.round(Number(celda) * 10) / 10).toFixed(1)<8.0&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=7.0){
		contenido+="<td class='text-center' style='background:#ffff00; color:black; border: black 1px solid;'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</td>";
	}else if((Math.round(Number(celda) * 10) / 10).toFixed(1)<7.0&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=6.0){
		contenido+="<td class='text-center' style='background:#ff99ff; color:black; border: black 1px solid;'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</td>";
	}else if((Math.round(Number(celda) * 10) / 10).toFixed(1)<6.0&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=0.1){
		contenido+="<td class='text-center' style='background:#ff0000; color:white; border: black 1px solid;'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</td>";
	}
	return contenido;
}

function htmlExcel(tableID, filename = '') {
	var downloadLink;
    var dataType = 'application/vnd.ms-excel';
    var tableSelect = document.getElementById(tableID);
    var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
    
    // Specify file name
    filename = filename?filename+'.xls':'excel_data.xls';
    
    // Create download link element
    downloadLink = document.createElement("a");
    
    document.body.appendChild(downloadLink);
    
    if(navigator.msSaveOrOpenBlob){
        var blob = new Blob(['ufeff', tableHTML], {
            type: dataType
        });
        navigator.msSaveOrOpenBlob( blob, filename);
    }else{
        // Create a link to the file
        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
    
        // Setting the file name
        downloadLink.download = filename;
        
        //triggering the function
        downloadLink.click();
    }
	}
function obtenerCelda(celda,titulo){
	var contenido="<td class='text-center' style='background:#cecece'></td>";
	if((Math.round(Number(celda) * 10) / 10).toFixed(1)<=10&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=9.0){
		contenido="<td class='text-center' style='background:#00ff00; color:black; border: black 1px solid;'><div title='"+titulo+"'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</div></td>";
	}else if((Math.round(Number(celda) * 10) / 10).toFixed(1)<9.0&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=8.0){
		contenido="<td class='text-center' style='background:#66ffff; color:black; border: black 1px solid;'><div title='"+titulo+"'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</div></td>";
	}else if((Math.round(Number(celda) * 10) / 10).toFixed(1)<8.0&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=7.0){
		contenido="<td class='text-center' style='background:#ffff00; color:black; border: black 1px solid;'><div title='"+titulo+"'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</div></td>";
	}else if((Math.round(Number(celda) * 10) / 10).toFixed(1)<7.0&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=6.0){
		contenido="<td class='text-center' style='background:#ff99ff; color:black; border: black 1px solid;'><div title='"+titulo+"'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</div></td>";
	}else if((Math.round(Number(celda) * 10) / 10).toFixed(1)<6.0&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=0.1){
		contenido="<td class='text-center' style='background:#ff0000; color:white; border: black 1px solid;'><div title='"+titulo+"'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</div></td>";
	}
	return contenido;
}
function obtenerCelda3(celda){
	var contenido="<td class='text-center' style='background:#cecece'></td>";
	if((Math.round(Number(celda) * 10) / 10).toFixed(1)<=10&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=9.0){
		contenido="<td class='text-center' style='background:#00ff00; color:black; border: black 1px solid;'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</td>";
	}else if((Math.round(Number(celda) * 10) / 10).toFixed(1)<9.0&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=8.0){
		contenido="<td class='text-center' style='background:#66ffff; color:black; border: black 1px solid;'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</td>";
	}else if((Math.round(Number(celda) * 10) / 10).toFixed(1)<8.0&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=7.0){
		contenido="<td class='text-center' style='background:#ffff00; color:black; border: black 1px solid;'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</td>";
	}else if((Math.round(Number(celda) * 10) / 10).toFixed(1)<7.0&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=6.0){
		contenido="<td class='text-center' style='background:#ff99ff; color:black; border: black 1px solid;'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</td>";
	}else if((Math.round(Number(celda) * 10) / 10).toFixed(1)<6.0&&(Math.round(Number(celda) * 10) / 10).toFixed(1)>=0.1){
		contenido="<td class='text-center' style='background:#ff0000; color:white; border: black 1px solid;'>"+(Math.round(Number(celda) * 10) / 10).toFixed(1)+"</td>";
	}
	return contenido;
}
function sacarPromedios(resultados){
	var promedios=[0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0];
	var vmp=0,p=0,vm1=0, uno=0,dos=0,tres=0,cuatro=0,cinco=0,seis=0,siete=0,ocho=0,nueve=0,diez=0,once=0,doce=0,trece=0,vm2=0,vm3=0,vm4=0,vm5=0,vm6=0,vm7=0,vm8=0,vm9=0,vm10=0,vm11=0,vm12=0,vm13=0;
	for(var i=0;i<resultados.length;i++){
		if(resultados[i].vmp!=0){
			vmp+=Number(resultados[i].vmp);
			if(resultados[i].promedioGral!=0){
				var tmp=(resultados[i].promedioGral*resultados[i].vmp)*0.10;
				p+=Number(tmp);
			}
		}
			if(resultados[i].valorMaximoUno!=0){
				vm1+=Number(resultados[i].valorMaximoUno);
				if(resultados[i].uno!=0){
					var tmp=(resultados[i].uno*resultados[i].valorMaximoUno)*0.10;
					uno+=Number(tmp);
				}
			}
		if(resultados[i].valorMaximoDos!=0){
			vm2+=Number(resultados[i].valorMaximoDos);
			if(resultados[i].dos!=0){
				var tmp=(resultados[i].dos*resultados[i].valorMaximoDos)*0.10;
				dos+=Number(tmp);
			}
		}if(resultados[i].valorMaximoTres!=0){
			vm3+=Number(resultados[i].valorMaximoTres);
			if(resultados[i].tres!=0){
				var tmp=(resultados[i].tres*resultados[i].valorMaximoTres)*0.10;
				tres+=Number(tmp);
			}
		}if(resultados[i].valorMaximoCuatro!=0){
			vm4+=Number(resultados[i].valorMaximoCuatro);
			if(resultados[i].cuatro!=0){
				var tmp=(resultados[i].cuatro*resultados[i].valorMaximoCuatro)*0.10;
				cuatro+=Number(tmp);
			}
		}if(resultados[i].valorMaximoCinco!=0){
			vm5+=Number(resultados[i].valorMaximoCinco);
			if(resultados[i].cinco!=0){
				var tmp=(resultados[i].cinco*resultados[i].valorMaximoCinco)*0.10;
				cinco+=Number(tmp);
			}
		}if(resultados[i].valorMaximoSeis!=0){
			vm6+=Number(resultados[i].valorMaximoSeis);
			if(resultados[i].seis!=0){
				var tmp=(resultados[i].seis*resultados[i].valorMaximoSeis)*0.10;
				seis+=Number(tmp);
			}
		}if(resultados[i].valorMaximoSiete!=0){
			vm7+=Number(resultados[i].valorMaximoSiete);
			if(resultados[i].siete!=0){
				var tmp=(resultados[i].siete*resultados[i].valorMaximoSiete)*0.10;
				siete+=Number(tmp);
			}
		}if(resultados[i].valorMaximoOcho!=0){
			vm8+=Number(resultados[i].valorMaximoOcho);
			if(resultados[i].ocho!=0){
				var tmp=(resultados[i].ocho*resultados[i].valorMaximoOcho)*0.10;
				ocho+=Number(tmp);
			}
		}if(resultados[i].valorMaximoNueve!=0){
			vm9+=Number(resultados[i].valorMaximoNueve);
			if(resultados[i].nueve!=0){
				var tmp=(resultados[i].nueve*resultados[i].valorMaximoNueve)*0.10;
				nueve+=Number(tmp);
			}
		}if(resultados[i].valorMaximoDiez!=0){
			vm10+=Number(resultados[i].valorMaximoDiez);
			if(resultados[i].diez!=0){
				var tmp=(resultados[i].diez*resultados[i].valorMaximoDiez)*0.10;
				diez+=Number(tmp);
			}
		}if(resultados[i].valorMaximoOnce!=0){
			vm11+=Number(resultados[i].valorMaximoOnce);
			if(resultados[i].once!=0){
				var tmp=(resultados[i].once*resultados[i].valorMaximoOnce)*0.10;
				once+=Number(tmp);
			}
		}if(resultados[i].valorMaximoDoce!=0){
			vm12+=Number(resultados[i].valorMaximoDoce);
			if(resultados[i].doce!=0){
				var tmp=(resultados[i].doce*resultados[i].valorMaximoDoce)*0.10;
				doce+=Number(tmp);
			}
		}if(resultados[i].valorMaximoTrece!=0){
			vm13+=Number(resultados[i].valorMaximoTrece);
			if(resultados[i].trece!=0){
				var tmp=(resultados[i].trece*resultados[i].valorMaximoTrece)*0.10;
				trece+=Number(tmp);
			}
		}
	}
	if(vmp!=0){
		promedios[0]=((p/vmp)*10);
	}else{
		promedios[0]=0.0;
	}
	if(vm1!=0){
		promedios[1]=((uno/vm1)*10);
	}else{
		promedios[1]=0.0;
	}
	if(vm2!=0){
		promedios[2]=((dos/vm2)*10);
	}else{
		promedios[2]=0.0;
	}
	if(vm3!=0){
		promedios[3]=((tres/vm3)*10);
	}else{
		promedios[3]=0.0;
	}
	if(vm4!=0){
		promedios[4]=((cuatro/vm4)*10);
	}else{
		promedios[4]=0.0;
	}
	if(vm5!=0){
		promedios[5]=((cinco/vm5)*10);
	}else{
		promedios[5]=0.0;
	}
	if(vm6!=0){
		promedios[6]=((seis/vm6)*10);
	}else{
		promedios[6]=0.0;
	}
	if(vm7!=0){
		promedios[7]=((siete/vm7)*10);
	}else{
		promedios[7]=0.0;
	}
	if(vm8!=0){
		promedios[8]=((ocho/vm8)*10);
	}else{
		promedios[8]=0.0;
	}
	if(vm9!=0){
		promedios[9]=((nueve/vm9)*10);
	}else{
		promedios[9]=0.0;
	}
	if(vm10!=0){
		promedios[10]=((diez/vm10)*10);
	}else{
		promedios[10]=0.0;
	}
	if(vm11!=0){
		promedios[11]=((once/vm11)*10);
	}else{
		promedios[11]=0.0;
	}
	if(vm12!=0){
		promedios[12]=((doce/vm12)*10);
	}else{
		promedios[12]=0.0;
	}
	if(vm13!=0){
		promedios[13]=((trece/vm13)*10);
	}else{
		promedios[13]=0.0;
	}
	return promedios;
}
function crearPptx(){
	var pptx = new PptxGenJS();
	pptx.tableToSlides('areas',{ master: "MASTER_SLIDE" });
	pptx.writeFile("tables.pptx");
}
function guardaRetro(idEncuesta){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet',
		data : "accion=GuardaFortalezasyAreas&fortalezas="+ponerTilde($("#fortalezas").val())+"&areas="+ponerTilde($("#areastxt").val())+"&idEmpleado="+$("#idEmpleado").val()+"&idEncuesta="+idEncuesta,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					alert("Datos guardados correctamente");
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
                alert('Error al guardar retroalimentacion.')
        }
	});
}
function consultaFortalezas(consulta, nombre,idEncuesta){
	//alert(idEncuesta);
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet',
		data : "accion=ConsultaOportunidad&consulta="+consulta+"&idEmpleado="+$("#idEmpleado").val()+"&idEncuesta="+idEncuesta,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					cargaPreguntas(respuesta,true,nombre);
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
                alert('Error al guardar retroalimentacion.')
        }
	});
}
function cargaPreguntasAbiertas(idEmpleado, nombre,idEncuesta){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'ResultadosServlet',
		data : "accion=ConsultaPreguntasaAbiertas&idEmpleado="+idEmpleado+"&idEncuesta="+idEncuesta,
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			//alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					cargaPreguntas(respuesta,false,"PREGUNTAS ABIERTAS DE "+nombre);
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
                alert('Error al guardar retroalimentacion.')
        }
	});
}
function cargaPreguntas(respuesta,valida, nombre){
	$("#preguntasTitulo").empty();
	$("#preguntasTitulo").append(nombre)
	var contenido="<table id='preguntas'><tr>";
	if(valida){
			contenido+="<th>COMPETENCIA</th>";
	}
	contenido+="<th>PREGUNTA</th><th>COMENTARIOS</th>";
	if(valida){
	contenido+="<th>CALIFICACI\u00D3N</th>";
	}
	contenido+="</tr>";
	$("#tablaPreguntas").empty();
		for(var i=0;i<respuesta[0].listResultados.length;i++){
			if(valida){
			contenido+="<tr><td>"+respuesta[0].listResultados[i].competencia+"</td>";
			}
			contenido+="<td>"+respuesta[0].listResultados[i].preguntas+"</td><td>";
			for(var c=0;c<respuesta[0].listResultados[i].comentarios.length;c++){
				contenido+=respuesta[0].listResultados[i].comentarios[c];
			}
			contenido+="</td>"
				if(valida){
			contenido+=obtenerCelda(respuesta[0].listResultados[i].calif);
				}
			contenido+="</tr>"
		}
		contenido+="</table>";
		$("#tablaPreguntas").append(contenido);
		$("#modalPreguntas").modal("show");
}
function ponerTilde(palabra){
	var letras=["a1","A2","e1","E2","i1","I2","o1","O2","u1","U2","n1","N2","u3","u4"];
	var codigo=["\u00e1","\u00c1","\u00e9","\u00c9","\u00ed","\u00cd","\u00f3","\u00d3","\u00fa","\u00da","\u00f1","\u00d1","\u00FC","\u00DC"];
	for (var i = 0; i <= codigo.length; i++) {
		   palabra=palabra.replaceAll(codigo[i],letras[i]);
		}
	return palabra;
}
function ocultarVacias(promedios, tabla){
	 for(var i=1;i<promedios.length;i++){
	    	if(promedios[i]==0.0){
	    		switch (i){
	    				case 1:
	    					$(tabla).jsGrid("fieldOption", "uno", "visible", false);
	    					break;
	    				case 2:
	    					$(tabla).jsGrid("fieldOption", "dos", "visible", false);
	    					break;
	    				case 3:
	    					$(tabla).jsGrid("fieldOption", "tres", "visible", false);
	    					break;
	    				case 4:
	    					$(tabla).jsGrid("fieldOption", "cuatro", "visible", false);
	    					break;
	    				case 5:
	    					$(tabla).jsGrid("fieldOption", "cinco", "visible", false);
	    					break;
	    				case 6:
	    					$(tabla).jsGrid("fieldOption", "seis", "visible", false);
	    					break;
	    				case 7:
	    					$(tabla).jsGrid("fieldOption", "siete", "visible", false);
	    					break;
	    				case 8:
	    					$(tabla).jsGrid("fieldOption", "ocho", "visible", false);
	    					break;
	    				case 9:
	    					$(tabla).jsGrid("fieldOption", "nueve", "visible", false);
	    					break;
	    				case 10:
	    					$(tabla).jsGrid("fieldOption", "diez", "visible", false);
	    					break;
	    				case 11:
	    					$(tabla).jsGrid("fieldOption", "once", "visible", false);
	    					break;
	    				case 12:
	    					$(tabla).jsGrid("fieldOption", "doce", "visible", false);
	    					break;
	    				case 13:
	    					$(tabla).jsGrid("fieldOption", "trece", "visible", false);
	    					break;		
	    		}
	    	}
	    }
}
function ponerCompetencias(promedios){
	var competencias=["1.LIDERAZGO","2.DESARROLLO DE PERSONAL","3.APEGO A LINEAMIENTOS","4.TRABAJO EN EQUIPO","5.COMUNICACI\u00D3N EFECTIVA","6.ANALISIS Y SOLUCI\u00D3N DE PROBLEMAS","7.ORIENTACI\u00D3N A RESULTADOS"
		,"8.TRABAJO BAJO PRESI\u00D3N","9.ADAPTACI\u00D3N AL CAMBIO","10.TOMA DE DECISIONES","11.PLANEACI\u00D3N Y ORGANIZACI\u00D3N","12.ACTITUD","13.CONOCIMIENTOS"];
	var contenido=""
		for(var i=1;i<promedios.length;i++){
			if(promedios[i]!=0.0){
					contenido+="<th style='padding: 5px 5px;'>"+competencias[i-1]+"</th>"
			}
		}
	return contenido;
}
function generaTabla(json, idDiv, tabla, promedios){
	//alert(JSON.stringify(json));
	$(idDiv).empty();
	var head=["<th>PROMEDIO</th>","<th>1</th>","<th>2</th>","<th>3</th>","<th>4</th>","<th>5</th>","<th>6</th>","<th>7</th>","<th>8</th>","<th>9</th>","<th>10</th>","<th>11</th>","<th>12</th>","<th>13</th>"]
	var contenido="<table><tr><th>"+tabla+"</th>";
	for(var h=0;h<promedios.length;h++){
		if(promedios[h]!=0.0){
			contenido+=head[h];
		}
	}
	for(var i=0;i<json.length;i++){
		contenido+="<tr><td>"+json[i].area+"</td>";
		contenido+=obtenerCelda3(json[i].promedioGral.toFixed(1))
		contenido+=obtenerCelda3(json[i].uno.toFixed(1));
		contenido+=obtenerCelda3(json[i].dos.toFixed(1));
		contenido+=obtenerCelda3(json[i].tres.toFixed(1))
		contenido+=obtenerCelda3(json[i].cuatro.toFixed(1));
		contenido+=obtenerCelda3(json[i].cinco.toFixed(1));
		contenido+=obtenerCelda3(json[i].seis.toFixed(1))
		contenido+=obtenerCelda3(json[i].siete.toFixed(1));
		contenido+=obtenerCelda3(json[i].ocho.toFixed(1));
		contenido+=obtenerCelda3(json[i].nueve.toFixed(1));
		contenido+=obtenerCelda3(json[i].diez.toFixed(1));
		contenido+=obtenerCelda3(json[i].once.toFixed(1));
		contenido+=obtenerCelda3(json[i].doce.toFixed(1));
		contenido+=obtenerCelda3(json[i].trece.toFixed(1));
		contenido+="</tr>"
			}
		contenido+="</table>"
		$(idDiv).append(contenido);
	}

function generaTabla2(json, idDiv, promedios){
	//alert(JSON.stringify(json));
	$(idDiv).empty();
	var head=["<th>PROMEDIO</th>","<th>1</th>","<th>2</th>","<th>3</th>","<th>4</th>","<th>5</th>","<th>6</th>","<th>7</th>","<th>8</th>","<th>9</th>","<th>10</th>","<th>11</th>","<th>12</th>","<th>13</th>"]
	var contenido="<table><tr><th>DEPARTAMENTO</th><th>NOMBRE COMPLETO</th><th>PUESTO</th>";
	for(var h=0;h<promedios.length;h++){
		if(promedios[h]!=0.0){
			contenido+=head[h];
		}
	}
	for(var i=0;i<json.length;i++){
		contenido+="<tr><td>"+json[i].depto+"</td><td>"+json[i].area+"</td><td>"+json[i].puesto+"</td>";
		contenido+=obtenerCelda3(json[i].promedioGral.toFixed(1))
		contenido+=obtenerCelda3(json[i].uno.toFixed(1));
		contenido+=obtenerCelda3(json[i].dos.toFixed(1));
		contenido+=obtenerCelda3(json[i].tres.toFixed(1))
		contenido+=obtenerCelda3(json[i].cuatro.toFixed(1));
		contenido+=obtenerCelda3(json[i].cinco.toFixed(1));
		contenido+=obtenerCelda3(json[i].seis.toFixed(1));
		contenido+=obtenerCelda3(json[i].siete.toFixed(1));
		contenido+=obtenerCelda3(json[i].ocho.toFixed(1));
		contenido+=obtenerCelda3(json[i].nueve.toFixed(1));
		contenido+=obtenerCelda3(json[i].diez.toFixed(1));
		contenido+=obtenerCelda3(json[i].once.toFixed(1));
		contenido+=obtenerCelda3(json[i].doce.toFixed(1));
		contenido+=obtenerCelda3(json[i].trece.toFixed(1));
		contenido+="</tr>"
	}
	contenido+="</table>"
		$(idDiv).append(contenido);
	}
