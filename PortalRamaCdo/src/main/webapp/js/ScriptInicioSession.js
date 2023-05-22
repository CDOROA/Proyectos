
/**** VALIDA ACCESO AL CARRITO DE COMPRAS ****/
function validaDatosIngresados()
{
	OcultarDiv('divMjsErrorInicioSession');	
	let usuario = $('#txtUsuario').val();
	let contrasena = $('#txtContrasena').val();
	
	if(validaDatosIngresadosPorElUsuario(usuario,contrasena))
	{
		document.getElementById('cargando').style.display = 'block';
		$.ajax({
		    url :'IniciaSession', 
		    data : "vista=PaginaInicio.jsp&operacion=EntrarAlCarrito" +"&usuario=" + usuario  +"&contrasena=" + contrasena, 
		    type : 'POST',
		    dataType : 'Text',
		    success : function(respuesta)
		    { 

		    	document.getElementById('cargando').style.display = 'none';
		    	if(respuesta =="PassworCaduco")
		    	{
		    		$('#lbMsjErrorInicioSession').text("Su contrase\u00f1a ha caducado.")
		    		MostrarDiv('divMjsErrorInicioSession');
		    	}
		    	else if(respuesta =="DatosCorrectos")
		    	{
		    		//window.location.href("jsp/CarritoDeCompras.jsp");
		    		
		    		window.location.href='/CarritoDeCompras.jsp/';
		    		
		    		
		    	}
		    	else
		    	{
		    		$('#lbMsjErrorInicioSession').text(respuesta)
		    		MostrarDiv('divMjsErrorInicioSession');
		    	}		    	
				
			},
			error : function(xhr, status, error)
			{
				document.getElementById('cargando').style.display = 'none';
				$('#lbMsjErrorInicioSession').text(" Al ingresar al carrito de compras")
				MostrarDiv('divMjsErrorInicioSession');
			}
		});
	}	
}

function validaDatosIngresadosPorElUsuario(usuario,contrasena)
{
	if (usuario.length <= 0)
	{
		$('#lbMsjErrorInicioSession').text("Ingrese su numero de usuario")
		MostrarDiv('divMjsErrorInicioSession');
		return false;
	}	
	if (contrasena.length <= 0) {
		$('#lbMsjErrorInicioSession').text("Ingrese su contrase\u00f1a")
		MostrarDiv('divMjsErrorInicioSession');
		return false;
	}
	return true;
}

/**** GENERA NUEVA CONTRASEÑA ****/
function generarNuevaContrasena()
{
	let cliente = $('#txtNumCteRecuperaPsw').val();
	let contrasena = generarPasswordAutomatico(8, true, true, true);
	let contrasena_encriptada = encriptarSha1(contrasena);
	
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
	    url :'IniciaSession', 
	    data : "vista=PaginaInicio.jsp&operacion=GenerarContrasenaNueva" +"&usuario=" + cliente  +"&contrasena=" + contrasena +"&contrasenaEncriptada=" + contrasena_encriptada, 
	    type : 'POST',
	    dataType : 'Text',
	    success : function(respuesta)
	    { 
	    	document.getElementById('cargando').style.display = 'none';
	    	if(respuesta =="TransaccionIncorrecta")
	    	{
	    		$('#lbMsjErrorGenerarContrasena').text("Al generar la nueva  contrase\u00f1a")
	    		MostrarDiv('divMjsErrorGenerarContrasena')
	    	}	
	    	else if(respuesta =="Psw_Actualizada_BD")
	    	{
	    		$('#lbMsjErrorGenerarContrasena').text("La contrase\u00f1a fue generada, pero no pudo ser enviada por correo eltr\u00f3nico.")
	    		MostrarDiv('divMjsErrorGenerarContrasena')
	    	}	
	    	else if(respuesta =="ContrasenaEnviada")
	    	{
	    		// $('#lbMsjExitoGenerarContrasena').text("La contrase\u00f1a fue generada y enviada a su correo. " )
	    		$('#lbMsjExitoGenerarContrasena').text("Se ha enviado un correo  a su cuenta para el cambio de contrase\u00f1a.");
	    		$("#txtNumCteRecuperaPsw").val("");
	    		MostrarDiv('divMjsExitoGenerarContrasena')
	    	}		    	
		},
		error : function(xhr, status, error)
		{
			document.getElementById('cargando').style.display = 'none';
			$('#lbMsjErrorInicioSession').text(" Al ingresar al carrito de compras")
			MostrarDiv('divMjsErrorInicioSession');
		}
	});
	
}

function generarPasswordAutomatico(Length, Upper, Numbers, Lower) 
{  
	Upper = typeof(Upper) != 'undefined' ? Upper : true;    
	Numbers = typeof(Numbers) != 'undefined' ? Numbers : true;     
	Lower = typeof(Lower) != 'undefined' ? Lower : true;
	
	if (!Upper && !Lower && !Numbers)         return ""; 
	
	var Ret = "";     var Num;     var Repeat;       
	Chars = 26 * 2 + 10;   
	
	for (i = 1; i <= Length; i++)     
	{       
		Repeat = false;           
		Num = Math.floor(Math.random()*Chars);          
		if (Num < 26)             
			if (Lower)                
				Ret = Ret + String.fromCharCode(Num + 97);            
			else               
				Repeat = true;         
		else if (Num < 52)             
			if (Upper)                 
				Ret = Ret + String.fromCharCode(Num - 26 + 65);            
			else                
				Repeat = true;         
		else if (Num < 62)            
			if (Numbers)                 
				Ret = Ret + String.fromCharCode(Num - 52 + 48);            
			else                
				Repeat = true;           
		if (Repeat)             
			i--;     
	}      
	return Ret; 
} 


/*** ENCRIPTACION  AUTOMATICA DE PASSWORD ***/
function aplicarPasswordV2(password)
{
	if(password.value != null && password.value != '')
	{
		return encriptacionEntxtSha1V2(password);
	}
	else
	{
		return false;
	}
}

function aplicarPassword(password)
{
	if(password.value != null && password.value != '')
	{
	 encriptacionEntxtSha1(password);
	}
	else
	{
		return false;
	}
}

function encriptacionEntxtSha1(password) {	

	password.value = rstr2hex(rstr_sha1(password.value));
}

function encriptacionEntxtSha1V2(password) {	

	return rstr2hex(rstr_sha1(password));
}

/***  OCULTAR -  MOSTRAR DIVS  ***/
function mostrarDivRecuperarContrasena()
{
	$("#divInicioSession").slideUp(600);
	$("#divOlvidoContrasena").slideDown(600);
	OcultarDiv('divMjsErrorGenerarContrasena');
	OcultarDiv('divMjsExitoGenerarContrasena');
}

function ocultarDivRecuperarContrasena()
{
	$("#divOlvidoContrasena").slideUp(600);
	$("#divInicioSession").slideDown(600);
	limpiarDatosDeLoguin()
}

