<%@ page language="java"%>
<%@ page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancelacion CFDIs</title>
 <link  href="jsp/logocdo.ico" rel="shortcut icon" type="image/x-icon"   />
		 
<!--  Hojas de Estilo -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/EstilosCancelacion.css">
<link rel="stylesheet" type="text/css" href="css/EstilosLogin.css">

<!--  Funciones Js -->
<script type="text/javascript" src="js/funciones.js"></script>
<script type="text/javascript" src="js/sha1.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	
	
	<STYLE TYPE="text/css" MEDIA=screen>


.popupEspera {
    left: 0;
    position: absolute;
    top: 0;
    width:100%;
    height:100%;
    z-index: 1001;
    background:rgba(0,0,0,0.20);
}

.content-popupEspera {
    margin:0px auto;
    margin-top:200px;
    position:relative;
    padding:10px;
    width:30%;
    min-height:200px;
    max-height:300px;
    
    border-radius:4px;
    background-color:#FFFFFF;
    box-shadow: 0 2px 5px #666666;
    overflow: auto;
}

.content-popupEspera h2 {
    color:#0066CC;
   /* border-bottom: 1px solid #4169E1;*/
    font-size: 100%;font-weight: bold;
	vertical-align: middle;
}

.popupEspera-overlay {
    left: 0;
    position: absolute;
    top: 0;
    width: 100%;
    z-index: 999;
    display:none;
    background-color: #777777;
    cursor: pointer;
    opacity: 0.7;
}

.close {
    position: absolute;
    right: 15px;
}

</STYLE>
	
	
<script type="text/javascript">
function cargando()
{
	
	var confirmarEnvio=confirm('CONFIRME PARA REALIZAR LA CANCELACION.');
	if (confirmarEnvio) {
		console.log("1")
		document.getElementById('cargando').style.display = 'block';
		console.log("2")
		$.ajax({
		    url :'ServidorCancelar', 
		    data : "accion=Cancelar", 
		    type : 'POST',
		    dataType : 'Json',
		    success : function(respuesta)
		    { 
		    	console.log("3")
		        if(respuesta)
	        	{
		        	document.getElementById('cargando').style.display = 'none';
		        	var data = respuesta;
		        	console.log("resp: "+data)

	        	}
		        else		        	
		        	document.getElementById('cargando').style.display = 'none';
			},
			error : function(xhr, status, error)
			{
				console.log("error")
			}
		});
		
	}

}

</script>	
	
</head>
<body>





<!-- MENSAJE DE ESPERA -->
<div id="cargando" style="display: none;" class="popupEspera">
    <div class="content-popupEspera">
        <div id="cargando2" >
      	    <div style="background:#F2F2F2;  border: 1px solid #CCCCCC" align="center">
   			    <br>
   			    <br></br>	
   			    <table width="100%" align="center">
   				    <tr>
   					    <td width="100%" class="tituloNegro" align="center" style=" font-size:120%;font-weight: bold;color:#0066CC;">	
   						    <p style="margin: 10px;">Espere un momento por favor, se esta realizando el proceso de cancelación...</p>      					
   					    </td>
   				    </tr>
   			    </table>		        			
   			    <br></br>	
   			    <img src="images/espera.gif" width="35"  ></img>
 				<br></br>
 				<br></br>
      	    </div>
    	</div>
    </div>
</div>





	<%@include file="Encabezado.html"%>
	<div class="header">
		<h5>CANCELACION CFDIs </h5>
	</div>
		<br>
		<div class="container-fluid">
			<div class="panel panel-primary class">
				<div class="panel-heading" style="background-color:#06226A;">CANCELACION DE CFDI 
				</div>
					<div class="panel-body">
						<div class="container-fluid">
							<form action="ServidorCancelar" method="post" id="frm_cancelacion">
								<div class="input-group">
									<label class="radio-inline">&nbsp;
										<input type="radio" value="1" name="tipo_doc" required>FACTURA
									</label>
									<label class="radio-inline">
										<input type="radio" value="2" name="tipo_doc"required >NOTA DE CREDITO
									</label>
									<label class="radio-inline">
										<input type="radio" value="3" name="tipo_doc"required>NOTA DE CARGO
									</label>
								</div>
								<div class="row">
									<div class="col-xs-12 col-md-11">
										<label class="">Documento:&nbsp;</label>
										<input id="txtDocumento" autocomplete="off" name="documento" type="text" size=20 width="10px"  placeholder="Ingrese documento..." aria-describedby="basic-addon1" onKeyUp="this.value=this.value.toUpperCase();"   onblur="validaCadena()"required>&nbsp;&nbsp;&nbsp;
										<input type="hidden" name="cancelar"id="idIndex" value="Mostrar"> 
										<input type="submit"name="botonCancelar" value="BUSCAR" class="btn btn-success btn-sm" style="border-radius: 10px;">
									</div>
									</form>
									
									<div class="col-xs-12 col-md-1">
									<script>
									function enviarF()
									{	 
										var confirmarEnvio=confirm('CONFIRME PARA REALIZAR LA CANCELACION.');
										if (confirmarEnvio) {
											return true;
										}
										else{
											return false;
										}
									}
									</script>
									<c:if test="${mostrarTabla ==1 }">	
									<form action="ServidorCancelar" method="post" id="frm_cancelacion" onsubmit="return enviarF()">
										<input type="hidden" name="cancelar"id="idIndex" value="Cancelar"> 
										<input type="submit"name="botonCancelar" value="CANCELAR" class="btn btn-danger btn-sm" onclick="cargando()" style="border-radius: 10px;">
									</form>
									</c:if>
									</div>
								</div>
							
						</div>
					</div>
			</div>
		</div>	
		<div class="container-fluid">
			<div align="center">
					<div class="table-responsive tablaWidth">
						<c:if test="${mostrarTabla ==1 }">
							<table class="table table-striped">
								<tr>
									<th class="coltb">CDO</th>
									<th class="coltb">Tipo Documento</th>
									<th class="coltb">Factura</th>
									<th class="coltb">Documento a cancelar</th>
									<th class="coltb">Referencia</th>
									<th class="coltb">AV</th>
									<th class="coltb">CTE</th>
									<th class="coltb">Nombre</th>
									<th class="coltb">Razon Social</th>
									<th class="coltb">Fecha Documento</th>
									<th class="coltb">Importe</th>
									<th class="coltb">UUID</th>
									<th class="coltb">Cancelado</th>
									<th class="coltb">Quitar</th>
								</tr>
								<c:forEach var="dato" items="${listaConsultaNota}">
									
									<tr class="td">
									<form action="ServidorCancelar" method="post" id="frm_cancelacion">
									
										<td class="td resultados">${dato.getCdo()}</td>
										<td class="td resultados">${dato.getTipodocumento()}</td>
										<td class="td resultados">${dato.getFactura()}</td>
										<td class="td resultados">${dato.getDocumentoacancelar()}</td>
										<td class="td resultados">${dato.getReferencia()}</td>
										<td class="td resultados">${dato.getAv()}</td>
										<td class="td resultados">${dato.getCte()}</td>
										<td class="td resultados">${dato.getNombre()}</td>
										<td class="td resultados">${dato.getRazonocial()}</td>
										<td class="td resultados">${dato.getFechadocumento()}</td>
										<td class="td resultados">${dato.getImporte()}</td>
										<td class="td resultados">${dato.getUuid()}</td>
										<td class="td resultados">${dato.getCancelado()}</td>
										<td class=" resultados">
										
											<input type="hidden" name="cancelar"id="idIndex" value="Eliminar"> 
											<input type="hidden" name="documentoEliminar"id="idIndex" value="${dato.getDocumentoacancelar()}"> 
											<button type="submit"name="botonCancelar" style="background: #e10e0e" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-trash"></span></button>
										</td>
										</form>
										<tr>
									
								</c:forEach>
							</table>
						</c:if>
					</div>
					<br>
			</div>
		</div>		
		<c:if test="${mostrarTabla ==1 }">					
		<div align="center">
			<form action="ServidorCancelar" method="post" id="frm_cancelacion">
				<input type="hidden" name="cancelar"id="idIndex" value="Limpiar"> 
				<button type="submit"name="botonCancelar" value="LIMPIAR" class="btn btn-warning btn-sm" style="border-radius: 10px;">Limpiar <span class="glyphicon glyphicon-trash"></span></button>
			</form>
		</div>
		<br>

				</c:if>
		<c:if test="${msj != '' }">
			<script>
				alert("${msj}");
			</script>
		</c:if>	 
</body>
</html>

