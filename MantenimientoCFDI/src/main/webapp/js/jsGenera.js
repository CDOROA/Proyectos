function rutinaInicioGenera() {
	$("#menu-cfdi").removeClass("Opc-Menu-Activo");
	$("#menu-genera").addClass("Opc-Menu-Activo");
}
function correShell(){
	var fecha=$("#fechaFac").val().split("-");
	var pedido=$("#pedido").val();
	var seccion=$("#seccion").val();
	document.getElementById('cargando').style.display = 'block';
	$.ajax({
		url : 'AdministradorGenera',
		data : "accion=CorreShell&pedido="+(pedido).trim()+"&seccion="+(seccion).trim()+"&mes="+(fecha[1]).trim()+"&anio="+(fecha[0]).trim()+"&dia="+(fecha[2]).trim(),
		type : 'POST',
		dataType : 'Json',
		success : function(respuesta) {
			// alert("HOla: " + JSON.stringify(respuesta) );
			alert(respuesta[0].msj);
			$("#seccion").val("0");
			$("#pedido").val("");
			$("#fechaFac").val("")
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
            alert('Error al generar.')
    }
	});
}
function validaCampos(){
	var fecha=$("#fechaFac").val().split("-");
	var pedido=$("#pedido").val();
	var seccion=$("#seccion").val();
	if((fecha[0]!=undefined&&fecha[0].length>0)&&(pedido!=undefined&&pedido.length>0)&&(seccion!=undefined&&seccion.length>0)){
			//alert("si");
		correShell();
	}else{
		alert("Campos Vacios");
	}
}