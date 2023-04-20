function EnviarInformacion() {
	var latitud = 0.0; // reference LatLng value
	var longitud = 0.0; // reference LatLng value

	if (validaDatos()) {
		var direccion = $('#txtCalle').val() + ", " + $('#txtNumExt').val()
				+ ", " + $('#txtCp').val() + ", " + $('#cmbListaEstados').val();

		var RecibirInformacion = "N";
		if ($("#chkRecibirInfo").is(':checked')) {
			RecibirInformacion = "S";
		} else {
			RecibirInformacion = "N";
		}

		 // Get form
        var form = $('#fileUploadForm')[0];

		// Create an FormData object
        var dataForm = new FormData(form);

        var  fileUp = document.getElementById("fileUp").files[0];

     //   var file = document.querySelector('#files > input[type="file"]').files[0];
        var  file = document.getElementById("fileUp").files[0];
       
        var fu1 = document.getElementById("fileUp");
      //  alert("You selected " + fu1.value.split("\\").pop());
        
    
        
		if (validateEmail($('#txtEmail').val()))
		{
			var radio = $("input[name='optradio']:checked").val();
			if(radio== 'Refaccionaria')
				{
				radio = radio +" - "+  $('#txtRefaccionaria').val();
				}else if (radio== 'Otro')
					{
					radio = radio + " - "+  $('#txtOtro').val();
					}
			
			// alert(radio);
			var especialidad = $("#cmbEspecialidad").val(); 
			
			var nombreEsp = $( "#cmbEspecialidad option:selected" ).text();
			
		//	alert(nombreEsp);
			
			latitud = $('#txt_lat').val();
			longitud = $('#txt_lon').val();
			
			var dataEnviar = 'operacion=2&cmbListaEstados='
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
				+ '&radio=' + radio
				+ '&especialidad='+especialidad 
				+ '&fotografia=' + fu1.value.split("\\").pop()
				+ '&chkRecibirInfo=' + RecibirInformacion + '&lat='
				+ latitud + '&lon=' + longitud + "&dataForm="+dataForm +"&fileUp="+$('#txt_base64').val();
			
			// alert("dataEnviar:" + dataEnviar);
			$.ajax({
				url : 'ServletSoyMecanico',
				data : dataEnviar,
				type : 'POST',
				dataType : 'json',
				 enctype: 'multipart/form-data',
			        processData: false,  // Important!
				success : function(json) {
					//alert("aqui...");
					// Get the modal
				
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

					//LimpiaCampos();

				},
				error : function(xhr, status, error) {
					//	alert("aqui error...");
				}
			});
		} else {
			alert('¡Correo electrónico no es válido!, por favor valide la información.');
			document.getElementById('txtCorreo').className = "form-control mi-input1";
		}
	}

}

function validaDatos() {
	if ($('#cmbListaEstados').val() == "" | $('#cmbMunicipios').val() == ""
			| $('#txtColonia').val() == "" | $('#txtCp').val() == ""
			| $('#txtCalle').val() == "" | $('#txtNumExt').val() == ""
			| $('#txtNombreTaller').val() == "" | $('#txtEncargado').val() == ""
			| $('#cmbBrindaServisioDomicilio').val() == ""
			| $('#txtTelefono').val() == "" | $('#txtWhatsapp').val() == ""
			| $('#txtEmail').val() == "" | $('#fileUp').val() == "") {
		$("#btn_espera").hide(100);
		$("#myBtn").show(100);

		var	msn = "¡Datos incompletos!, por favor valide que ninguno de los datos este en blanco.";
		if ($('#cmbListaEstados').val() == "") {
			msn = msn + "\n Seleccionar un Esatdo.";
			//$('#cmbListaEstados').css({'border': '#ed2525', 'border-style': 'groove'});
			document.getElementById('cmbListaEstados').style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#cmbMunicipios').val() == "") {
			msn = msn + "\n Ingrese una Delegacion o municipio.";
			document.getElementById("cmbMunicipios").style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#txtColonia').val() == "") {
			msn = msn + "\n Ingrese su Colonia.";
			document.getElementById("txtColonia").style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#txtCp').val() == "") {
			msn = msn + "\n Ingrese el Codigo Postal.";
			document.getElementById("txtCp").style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#txtCalle').val() == "") {
			msn = msn + "\n Ingrese la calle.";
			document.getElementById("txtCalle").style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#txtNumExt').val() == "") {
			msn = msn + "\n Ingrese el Numero Exterior.";
			document.getElementById("txtNumExt").style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#txtNombreTaller').val() == "") {
			msn = msn + "\n Ingrese El nombre del Taller.";
			document.getElementById("txtNombreTaller").style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#txtEncargado').val() == "") {
			msn = msn
					+ "\n Ingrese la nombre del Encargado o Dueño del taller.";
			document.getElementById("txtEncargado").style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#cmbBrindaServisioDomicilio').val() == "") {
			msn = msn + "\n Ingrese Si brinda servicio a domicilio";
			document.getElementById("cmbBrindaServisioDomicilio").style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#txtTelefono').val() == "") {
			msn = msn + "\n Ingrese su telefono.";
			document.getElementById("txtTelefono").style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#txtWhatsapp').val() == "") {
			msn = msn + "\n Ingrese un Numero de WhatsApp";
			document.getElementById("txtWhatsapp").style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#txtEmail').val() == "") {
			msn = msn + "\n Ingrese el correo Electronico";
			document.getElementById("txtEmail").style.border = "solid rgb(237, 37, 37)";
		}
		if ($('#fileUp').val() == "") {
			msn = msn + "\n Favor de Seleccionar una Fotografía de la fachada.";
			document.getElementById("fileUp").style.border = "solid rgb(237, 37, 37)";
		}
		alert(msn);
		return false;
	}

	else {
		return true;
	}
}

function validateEmail(email) {
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}

function Punteaubic() {
	//  var direccion = dir;
	if ($('#cmbListaEstados').val() != "" &&

	$('#txtCp').val() != "" && $('#txtCalle').val() != ""
			&& $('#txtNumExt').val() != "") {
		var direccion = $('#txtCalle').val() + ", " + $('#txtNumExt').val()
				+ ", " + $('#txtCp').val() + ", " + $('#cmbListaEstados').val();

		var latlng = "0|0";
		//alert("direccion:" + direccion);
		var geocoder = new google.maps.Geocoder();
		geocoder.geocode({
			address : direccion
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				var latitud = results[0].geometry.location.lat(); // reference LatLng value
				var longitud = results[0].geometry.location.lng(); // reference LatLng value

				document.getElementById('txt_lat').value = latitud;
				document.getElementById('txt_lon').value = longitud;
				latlng = latitud + "|" + longitud;
				// alert("Punteaubic.latlng:" + latlng);
			}
		});
		console.log("lat:" + $('#txt_lat').val());
		console.log("lon:" + $('#txt_lon').val());
		//  return latlng;
	}
}

function LimpiaCampos() {
	$('#cmbListaEstados').val(0);

	$('#cmbMunicipios').val("");
	$('#txtColonia').val("");
	$('#txtCp').val("");
	$('#txtCalle').val("");
	$('#txtNumExt').val("");
	$('#txtNombreTaller').val("");
	$('#txtEncargado').val("");
	$('txtEncargado').val("");
	$('#cmbBrindaServisioDomicilio').val(0);
	$('#txtTelefono').val("");
	$('#txtWhatsapp').val("");
	$('#txtEmail').val("");
	$('#chkRecibirInfo').val("");
	$("#btn_espera").hide(200);
	$("#myBtn").show(100);
}

function getBase64(file) {
	   var reader = new FileReader();
	   reader.readAsDataURL(file);
	   reader.onload = function () {
	     console.log(reader.result);
	     document.getElementById('txt_base64').value = reader.result;
	     
	   };
	   reader.onerror = function (error) {
	     console.log('Error: ', error);
	   };
	   return reader.result;
	}