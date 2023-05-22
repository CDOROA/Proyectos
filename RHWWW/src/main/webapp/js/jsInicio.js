
function RutinaInicio(contador){
	BotonEnviar();
	validaRespuesta(contador)
}

function validaPsw(psw) {
	if(psw.value != null && psw.value != '')
	{
		sha1(psw);
	}
	else
	{
		alert('Ingresar una contraseña.');
		return false;
	}
}

//función que encripta la contraseña de inicio de sesión
function sha1(psw) 
{	
	psw.value = rstr2hex(rstr_sha1(psw.value));
}

function BotonEnviar() {
    $("#btn_aceptar").click(function () {

        $("#btn_aceptar").hide(200);
        $("#btn_espera").prop("disabled", true);
        $("#btn_espera").show(100);

    });
}

function RutinaInicio(contador){
	BotonEnviar();
	validaRespuesta(contador)
}

function validaRespuesta(contador)
{
	//alert(contador);
	if (contador== 9) 
		{
		 $("#myModal").modal();
		}
}

