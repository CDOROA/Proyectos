function asignacionInicialDist(){	
	
	$('#cmb_distribuidor_Pais').on('change', cargaEstados);	
	$('#cmb_distribuidor_Estado').on('change', CargaDelegacionesDist);	

/*agregando el evento para insertar en la base de datos*/
$("#Btn_enviarDist").click(function() {

	$("#Btn_enviarDist").hide(200);
	$("#btn_esperaDist").prop("disabled", true);
	$("#btn_esperaDist").show(100);
	EnviarInformacionDistribuidor();
});

/*Evento para codificar la foto*/
if (window.File && window.FileReader && window.FileList && window.Blob) {
	document.getElementById('fileUpDist').addEventListener('change',
			handleFileSelect, false);
}

function handleFileSelect(evt) {
	var f = evt.target.files[0]; // FileList object
	var reader = new FileReader();
	// Closure to capture the file information.
	reader.onload = (function(theFile) {
		return function(e) {
			var binaryData = e.target.result;
			//Converting Binary Data to base 64
			var base64String = window.btoa(binaryData);
			//showing file converted to base64
			document.getElementById('"txtbase64Dist"').value = base64String;
			//  alert('File converted to base64 successfuly!\nCheck in Textarea');
		};
	})(f);
	// Read in the image file as a data URL.
	reader.readAsBinaryString(f);
}

}

function cargaEstados(cve_pais)
{
	
		$('#cmb_distribuidor_Estado').empty();
		var cve_estado = $('#cmb_distribuidor_Pais').val();
		
		 //alert (cve_estado);
		$.ajax({
	        url :'QuieroSerDistribuidor', 
	        data : "operacion=5"+'&cve_pais='+cve_estado,
	        type : 'POST',
	        dataType : 'json',
	        success : function(json)
	        {	
	        	if( json.length > 0)
	    		{
	        		$("<option value="+""+">"+"- - - - -"+"</option>").appendTo("#cmb_distribuidor_Estado");
	        		for (var i = 0; i < json.length; i++) {
	        			
	        			$("<option value="+json[i].cve_estado+">"+json[i].descripcion+"</option>").appendTo("#cmb_distribuidor_Estado");
	        		}
	    		}
	        	if(cve_pais> 0)
	        	{$('#cmb_distribuidor_Pais').val(cve_del);}
	        	
	    	},
	    	error : function(xhr, status, error) {
	        	alert('Error');
	        }
	    }); 
}

function CargaDelegacionesDist(cve_del)
{
	// alert (cve_del);
	$('#cmb_distribuidor_municipio').empty();
	var cve_estado = $('#cmb_distribuidor_Estado').val();
	
	// alert ("cmb_distribuidor_Estado.val: " + cve_estado);
	$.ajax({
        url :'QuieroSerDistribuidor', 
        data : "operacion=3"+'&cve_estado='+cve_estado,
        type : 'POST',
        dataType : 'json',
        success : function(json)
        {	
        	if( json.length > 0)
    		{
        		$("<option value="+""+">"+"- - - - -"+"</option>").appendTo("#cmb_distribuidor_municipio");
        		for (var i = 0; i < json.length; i++) {
        			
        			$("<option value="+json[i].descripcion+">"+json[i].descripcion+"</option>").appendTo("#cmb_distribuidor_municipio");
        		}
    		}
        	if(cve_del> 0)
        	{$('#cmb_distribuidor_municipio').val(cve_del);}
        	
    	},
    	error : function(xhr, status, error) {
        	alert('Error');
        }
    }); 
	
}
function EnviarInformacionDistribuidor()
{
	if (validaDatosDist()) {

		var fu1 = document.getElementById("fileUpDist");
		
		var dataEnviar = 'QuieroSerDistribuidor?operacion=2&nombreNegocio=' + $('#txt_distribuidor_nombre_negocio').val() +  
		'&giro=' + $('#txt_distribuidor_giro').val() +
		'&nombreContacto='+ $('#txt_distribuidor_nombre_contacto').val() +
		'&puesto='+ $('#txt_distribuidor_puesto').val() +
		'&correo='+ $('#txt_distribuidor_correo').val() +
		'&whatsApp='+ $('#txt_distribuidor_whatsApp').val() +
		'&cvePais='+ $('#cmb_distribuidor_Pais').val() +
		'&descPais='+ $( "#cmb_distribuidor_Pais option:selected" ).text() +
		'&cveEstado='+ $('#cmb_distribuidor_Estado').val() +
		'&descEstado='+ $( "#cmb_distribuidor_Estado option:selected" ).text() +
		'&municipio='+ $('#cmb_distribuidor_municipio').val() +
		'&codigoPostal='+ $('#txt_distribuidor_codigo_postal').val() +
		'&fotografia='+ fu1.value.split("\\").pop() ;

		var formularioImagen =  document.getElementById("formEnviarFotoDistribuidor");
		formularioImagen.action = dataEnviar;
		formularioImagen.method = 'POST';
		formularioImagen.submit();
	}
}

function EnviaInformacionPorCorreo()
{
	var url = 'UploadFileServlet?&cmbListaEstados='
		+ $('#cmbListaEstados').val() + '&cmbMunicipios='
		+ $('#cmbMunicipios').val() + '&txtColonia='
		+ $('#txtColonia').val() + '&txtCp='
		+ $('#txtCp').val() + '&txtCalle='
		+ $('#txtCalle').val() + '&txtNumExt='
		+ $('#txtNumExt').val() + '&txtNumInt='
		+ $('#txtNumInt').val() + '&txtNombreTaller='
		+ $('#txtNombreTaller').val() + '&txtEncargado='
		+ $('#txtEncargado').val()
		+ '&cmbBrindaServisioDomicilio='
		+ $('#cmbBrindaServisioDomicilio').val()
		+ '&txtTelefono=' + $('#txtTelefono').val()
		+ '&txtWhatsapp=' + $('#txtWhatsapp').val()
		+ '&txtEmail=' + $('#txtEmail').val()
		+ '&fotografia=' + fu1.value.split("\\").pop()
		+ '&radio=' + radio
    	+ '&especialidad='+especialidad +" - " + nombreEsp
		+ '&chkRecibirInfo=' + RecibirInformacion + '&lat='
		+ latitud + '&lon=' + longitud;
	
	var formularioImagen =  document.getElementById("formEnviarFoto");
	formularioImagen.action = url;
	formularioImagen.method = 'POST';
	formularioImagen.submit();

}

function validaDatosDist() {

	if ($('#txt_distribuidor_nombre_negocio').val() == "" | $('#txt_distribuidor_giro').val() == ""
			| $('#txt_distribuidor_nombre_contacto').val() == "" | $('#txt_distribuidor_puesto').val() == ""
			| $('#txt_distribuidor_correo').val() == "" | $('#txt_distribuidor_whatsApp').val() == ""
			| $('#cmb_distribuidor_Estado').val() == "0" | $('#cmb_distribuidor_municipio').val() == ""
			| $('#fileUpDist').val() == "" | $('#txt_distribuidor_codigo_postal').val() == "") {
		
		$("#btn_esperaDist").hide(100);
		$("#Btn_enviarDist").show(100);

		var	msn = "¡Datos incompletos!, por favor valide que ninguno de los datos este en blanco.";
		if ($('#txt_distribuidor_nombre_negocio').val() == "") {
			msn = msn + "\n Ingrese el nombre de su negocio.";
			//$('#cmbListaEstados').css({'border': '#ed2525', 'border-style': 'groove'});
			document.getElementById('txt_distribuidor_nombre_negocio').style.border = "solid rgb(237, 37, 37)";
		}
		else
			{
			
			$("#txt_distribuidor_nombre_negocio").css('border', '1px solid #ccc');
			
			}
		if ($('#txt_distribuidor_giro').val() == "") {
			msn = msn + "\n Ingrese el giro de su negocio";
			document.getElementById("txt_distribuidor_giro").style.border = "solid rgb(237, 37, 37)";
		}
		else
		{
		
		$("#txt_distribuidor_giro").css('border', '1px solid #ccc');
		
		}
		if ($('#txt_distribuidor_nombre_contacto').val() == "") {
			msn = msn + "\n Ingrese El nombre del contacto.";
			document.getElementById("txt_distribuidor_nombre_contacto").style.border = "solid rgb(237, 37, 37)";
		}
		else
		{
		
		$("#txt_distribuidor_nombre_contacto").css('border', '1px solid #ccc');
		
		}
		if ($('#txt_distribuidor_puesto').val() == "") {
			msn = msn + "\n Ingrese Ingrese el puesto de la persona de contacto.";
			document.getElementById("txt_distribuidor_puesto").style.border = "solid rgb(237, 37, 37)";
		}
		else
		{
		
		$("#txt_distribuidor_puesto").css('border', '1px solid #ccc');
		
		}
		if ($('#txt_distribuidor_correo').val() == "") {
			msn = msn + "\n Ingrese una cuenta correo.";
			document.getElementById("txt_distribuidor_correo").style.border = "solid rgb(237, 37, 37)";
		}
		else
		{
		
		$("#txt_distribuidor_correo").css('border', '1px solid #ccc');
		
		}
		if ($('#txt_distribuidor_whatsApp').val() == "") {
			msn = msn + "\n Ingrese el Numero de WhatsApp.";
			document.getElementById("txt_distribuidor_whatsApp").style.border = "solid rgb(237, 37, 37)";
		}
		else
		{
		
		$("#txt_distribuidor_whatsApp").css('border', '1px solid #ccc');
		
		}
		if ($('#cmb_distribuidor_Estado').val() == "0") {
			msn = msn + "\n Seleccione un Estado.";
			document.getElementById("cmb_distribuidor_Estado").style.border = "solid rgb(237, 37, 37)";
		}
		else
		{
		
		$("#cmb_distribuidor_Estado").css('border', '1px solid #ccc');
		
		}
		if ($('#cmb_distribuidor_municipio').val() == "") {
			msn = msn
					+ "\n Seleccione el Municipio o Alcaldia.";
			document.getElementById("cmb_distribuidor_municipio").style.border = "solid rgb(237, 37, 37)";
		}
		else
		{
		
		$("#cmb_distribuidor_municipio").css('border', '1px solid #ccc');
		
		}
		if ($('#txt_distribuidor_codigo_postal').val() == "") {
			msn = msn + "\n Ingrese el Codigo postal.";
			document.getElementById("txt_distribuidor_codigo_postal").style.border = "solid rgb(237, 37, 37)";
		}
		else
		{
		
		$("#txt_distribuidor_codigo_postal").css('border', '1px solid #ccc');
		
		}
		if ($('#fileUpDist').val() == "") {
			msn = msn + "\n Favor de Seleccionar una Fotografía de la fachada.";
			document.getElementById("fileUpDist").style.border = "solid rgb(237, 37, 37)";
		}
		else
		{
		
		$("#fileUpDist").css('border', '1px solid #ccc');
		
		}
		alert(msn);
		return false;
	}
	else {
		return true;
	}
	
}

function isNumberKey(evt) {
		var charCode = (evt.which) ? evt.which : event.keyCode;
		if (charCode > 31 && (charCode < 48 || charCode > 57)) {
			return false;
		} else {
			//document.getElementById('txt_distribuidor_whatsApp').className = "form-control mi-input";

			return true;
		}
}

