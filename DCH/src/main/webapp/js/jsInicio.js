/********** FUNCION PARA VALIDAR CONTRASEÃ‘A **********/
function validaPsw(psw) 
{
	if(psw.value != null && psw.value != '')
		sha1(psw);
	else
	{
		alert('Ingresar una contraseÃ±a.');
		return false;
	}
}

/********** FUNCION PARA ENCRIPTAR CONTRASEÃ‘A EN FORMATO SHA1 **********/
function sha1(psw) 
{	
	psw.value = rstr2hex(rstr_sha1(psw.value));
}