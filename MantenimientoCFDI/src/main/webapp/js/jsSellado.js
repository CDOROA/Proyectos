function rutinaSellado() {
	$("#menu-cfdi").removeClass("Opc-Menu-Activo");
	$("#menu-notas").removeClass("Opc-Menu-Activo");
	$("#menu-sellado").addClass("Opc-Menu-Activo");
	consultaSellado();
}
function consultaSellado(){
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorSellado',
		data : "accion=Cargar",
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			// alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					$("#st").val(respuesta[0].estatus);
					var contenido="";
					if(respuesta[0].estatus=="1")
					{
						contenido="<div class='form-check form-switch'>"+
							"<input class='form-check-input' type='checkbox' role='switch' id='estatus' checked onchange='abreModal()'>"+
							"<label id='lbestatus' class='form-check-label' for='flexSwitchCheckChecked'>ACTIVO</label>"+
						"</div>";
					}else{

						contenido="<div class='form-check form-switch'>"+
							"<input class='form-check-input' type='checkbox' role='switch' id='estatus' onchange='abreModal()'>"+
							"<label id='lbestatus' class='form-check-label' for='flexSwitchCheckChecked'>INACTIVO</label>"+
						"</div>";
					}
						$("#estatus").append(contenido);
				
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
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar Notas.')
    }
	});
}
function abreModal(){
	$("#sellado").modal('show');
}
function checaEstatus(){
	$("#sellado").modal('hide');
	if($("#st").val()=="1"){
		document.querySelectorAll('#estatus input[type=checkbox]').forEach(function(checkElement) {
	        checkElement.checked = true;
	    });
	}else{
		 document.querySelectorAll('#estatus input[type=checkbox]').forEach(function(checkElement) {
		        checkElement.checked = false;
		    });
	}
}
function cambiaEstatus(){
	$("#sellado").modal('hide');
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorSellado',
		data : "accion=CambiaEstatus&estatus="+$("#st").val(),
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			// alert("HOla: " + JSON.stringify(respuesta) );

			if (respuesta) {

				var data = respuesta;

				if (data.length > 0) {
					if($("#st").val()=="1"){
						$("#st").val("0");
						$('#lbestatus').text("INACTIVO");
					}else{
						$("#st").val("1");
						$('#lbestatus').text("ACTIVO");
					}
					alert("ESTATUS CAMBIADO");
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
            window.location.href='/MantenimientoCFDI/';
        }
        else
            alert('Error al consultar Notas.')
    }
	});
}