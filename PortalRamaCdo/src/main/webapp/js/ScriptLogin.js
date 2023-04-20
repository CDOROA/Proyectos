/****  MOSTRA LOGUIN  *****/
function mostrarLogin()
{
	OcultarDiv('divMenuPrincipal')	;
	OcultarDiv('divNuestraEmpresa')	;
	OcultarDiv('divMarcasExclusivas');
	OcultarDiv('divBoletines')	;
	OcultarDiv('divSucursales')	;
	OcultarDiv('divQueAutoBusca');
	OcultarDiv('divPoliticaPrivacidad');
	limpiarDatosDeLoguin()	
	if($("#divInicioSession").is(":visible")){
		$("#divInicioSession").slideUp(600);
	}
	else{
		$("#divInicioSession").slideDown(600);
	}		
	document.location.href = "#";
	
	$("#navbar1").collapse('hide');
	  $("#navbar1").removeClass("in");
}

function limpiarDatosDeLoguin()
{
	$('#txtUsuario').val("");
	$('#txtContrasena').val("");
	$('#txtNumCteRecuperaPsw').val("");		
	OcultarDiv('divOlvidoContrasena');
	OcultarDiv('divMjsErrorInicioSession');
}

function moseOverIngresar(div)
{
	document.getElementById(div).style.backgroundColor = "#F85058";		
}

function moseUpIngresar(div)
{
	document.getElementById(div).style.backgroundColor = "#DF040C";		
}


