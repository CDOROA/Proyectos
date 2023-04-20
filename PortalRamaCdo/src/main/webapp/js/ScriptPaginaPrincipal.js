/*** INICIALIZA VALRIABLES PRIMERA CARGA  ***/
function cargarInicializaSistema()
{
	$('#cboMarcaQueAutoBusca').val("0")
	$('#txtProductoQueAutoBusca').val("")
	$('#cboGrupoQueAutoBusca').val("0")	
	$('#cboSucursalesEstado').val("0")	
	$('#cboBolsaTrabajoEstado').val("0")		
	OcultarDiv('divSeccionBolsaDeTrabajo')
	OcultarDiv('divSeccionAsistencia')
	OcultarDiv('divMjsErrorSucursales');
	

	$( "#btn_aviso" ).on( "click", function() {
		 
		 $( "#effect" ).toggle();
	    
	  } );
	$( "#btn_cerrar_aviso" ).on( "click", function() {
	 
		 
		 $( "#effect" ).toggle();
	    
	  } );
	
	//let  videoCdo = document.getElementById("myVideo");
	//videoCdo.data = "";	
	//let myVideoMovil = document.getElementById("myVideoMovil");
	//myVideoMovil.data = "";	
	
	
}

function getBrowserInfo() {
    var ua= navigator.userAgent, tem, 
    M= ua.match(/(opera|chrome|safari|firefox|msie|trident(?=\/))\/?\s*(\d+)/i) || [];
    if(/trident/i.test(M[1])){
        tem=  /\brv[ :]+(\d+)/g.exec(ua) || [];
        return 'IE, '+(tem[1] || '');
    }
    if(M[1]=== 'Chrome'){
        tem= ua.match(/\b(OPR|Edge)\/(\d+)/);
        if(tem!= null) return tem.slice(1).join(' ').replace('OPR', 'Opera');
    }
    M= M[2]? [M[1], M[2]]: [navigator.appName, navigator.appVersion, '-?'];
    if((tem= ua.match(/version\/(\d+)/i))!= null) M.splice(1, 1, tem[1]);
   // return M.join(' ');
    return M;
}




/**** HEADER / FOOTER  ****/
function regresarPaginaDeInicio(div)
{
	ocultarDivsPaginaPrincipal()
	MostrarDiv('divMenuPrincipal')	
	if(div != '')
	{
		window.location.hash = div;
	}
}


/**** MOSTRAR / OCULTAR LOS MODULOS DE PAGINA PRINICPAL  ****/
function mostrarNuestraEmpresa()
{
	ocultarDivsPaginaPrincipal()
	MostrarDiv('divNuestraEmpresa')	
	document.location.href = "#"; 
	  $("#navbar1").collapse('hide');
	  $("#navbar1").removeClass("in");
	
}

function mostrarQueAutoBusca()
{
	ocultarDivsPaginaPrincipal()
	limpiaFiltrosQuerAutoBusca()
	MostrarDiv('divQueAutoBusca')	
	document.location.href = "#"; 
	$("#navbar1").collapse('hide');
	  $("#navbar1").removeClass("in");
}

function mostrarPoliticasPrivacidad()
{
	ocultarDivsPaginaPrincipal()
	MostrarDiv('divPoliticaPrivacidad')	
	document.location.href = "#"; 
	$("#navbar1").collapse('hide');
	  $("#navbar1").removeClass("in");
}

function mostrarSucursales()
{
	consultaSucursalesCDOs()
	ocultarDivsPaginaPrincipal()
	OcultarDiv('divMjsErrorSucursales');
	OcultarDiv('divSucursalesResultados');
	MostrarDiv('divSucursalesMapa');
	MostrarDiv('divSucursales');
	document.location.href = "#"; 	
	$("#navbar1").collapse('hide');
	  $("#navbar1").removeClass("in");
}

function mostrarMarcasExclusivas()
{
	ocultarDivsPaginaPrincipal()
	MostrarDiv('divMarcasExclusivas')	
	document.location.href = "#"; 
	$("#navbar1").collapse('hide');
	  $("#navbar1").removeClass("in");
}

function mostrarVentajasCompetitivas()
{
	ocultarDivsPaginaPrincipal()
	MostrarDiv('divVentajasCompetitivas')	
}

function ocultarDivsPaginaPrincipal()
{
	OcultarDiv('divMenuPrincipal')	
	OcultarDiv('divNuestraEmpresa')	
	OcultarDiv('divMarcasExclusivas')
	OcultarDiv('divBoletines')	
	OcultarDiv('divSucursales')	
	OcultarDiv('divQueAutoBusca')
	OcultarDiv('divPoliticaPrivacidad')
	OcultarDiv('divInicioSession');
}


/**** BOLETINES INFORMATIVOS ****/
function mouseOverdivBoletines(div)
{
	document.getElementById(div).style.backgroundColor = "#E1E1E1";	
}

function mouseOutdivBoletines(div)
{
	document.getElementById(div).style.backgroundColor = "#F5F5F5";
}

function mostrarBoletinSeleccionado(id_boletin, listaBoletines)
{
	let id;
	for(let i=0; i<=listaBoletines; i++)
	{		
		if(i == id_boletin)
		{
			id = 'div_boletin_' + id_boletin;
			$("#" + id).slideDown(600);
		}
		else
		{
			id = 'div_boletin_' + i;
			document.getElementById(id).style.display='none';
		}
	}	
}


/**** PAGINA PRINCIPAL SUB-MENUS ****/
function mousOverSubMenus(div)
{
	div.style.backgroundColor = "#E1E1E1";	
}

function mousOutSubMenus(div)
{
	div.style.backgroundColor = "#F5F5F5";	
}

function verDivSubmenu(divSubMenu)
{
	//let  videoCdo = document.getElementById("myVideo");
	//videoCdo.data = "";	
	//let myVideoMovil = document.getElementById("myVideoMovil");
	//myVideoMovil.data = "";	
		
	if(divSubMenu == 'BolsaDeTrabajo')
	{
		OcultarDiv('divMjsErrorBolsaTrabajo');
		$('#cboBolsaTrabajoEstado').val("0")
		consultaVacantes(0)		
	}
	
	//if(divSubMenu == 'VideoCdo')
	//{
		//videoCdo.data = "https://www.youtube.com/embed/IspWlcAxWk4?autoplay=1";
		//myVideoMovil.data = "https://www.youtube.com/embed/IspWlcAxWk4?autoplay=1";
	//}
	
	limpiarControlesDeSubmenu();
	let div ="#divSeccion" + divSubMenu;
	let menu ="divSubMenu" + divSubMenu;	
	document.getElementById(menu).style.backgroundColor = "#E1E1E1";
	$(div).slideDown(600);
	window.location.hash = div;
}

function limpiarControlesDeSubmenu()
{
	document.getElementById("divSubMenuBolsaDeTrabajo").style.backgroundColor = "white";
	document.getElementById("divSubMenuVentajasCompetitivas").style.backgroundColor = "white";
	document.getElementById("divSubMenuVideoCdo").style.backgroundColor = "white";
	document.getElementById("divSubMenuContactenos").style.backgroundColor = "white";
	OcultarDiv('divSeccionBolsaDeTrabajo')
	OcultarDiv('divSeccionAsistencia')
	OcultarDiv('divSeccionVentajasCompetitivas')
	OcultarDiv('divSeccionVideoCdo')
	
}

function changeTypeInput(id)
{
const password = document.querySelector('#'+id+'');
const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
password.setAttribute('type', type);
}

function entrarACarrito()
{
	var password = $('#txtContrasena').val();
	var usuario = $('#txtUsuario').val();
	
	if (usuario.trim() == "" )
		{
		alert("Ingresar Usuario.");
	}
	else
	{
		if (password.trim() == "" )
		{
			alert("Ingresar password.");
		}else{
			var PassEncrip = encriptacionEntxtSha1V2(password);
			ingresarACarito(usuario, password, PassEncrip);
		}
	}
	
	 

	
}

function ingresarACarito(usuario, password, PassEncrip)
{
	 
	var navegador ="";
    var version = "";
    var versionNavgador;
    let ArrVersionNavegador = "";

 try
 {
    var versionNavgador=getBrowserInfo();

     ArrVersionNavegador = versionNavgador.toString().split(',')

    navegador = ArrVersionNavegador[0];
    version = ArrVersionNavegador[1];
	
 }
 catch (e) {
	  navegador = "no disponible";
	  version = 9999;
}
	document.getElementById('cargando').style.display = 'block';
	
	var url = "IniciaSession?&vista=PaginaInicio.jsp&operacion=EntrarAlCarrito" +"&txtUsuario=" + usuario  +
	          "&contrasena=" + password +"&txtContrasena=" + PassEncrip +"&navegador="+ navegador +
	          "&versionNavegador="+ version;

	var formularioImagen =  document.getElementById("formEnviarFoto");
	formularioImagen.action = url;
	formularioImagen.method = 'POST';
	formularioImagen.submit();
	}