<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
		<title>Control de Ingresos CDO-ROA</title>
		
		<script  type="text/javascript" src="js/jquery-ui.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<script type="text/javascript" src="js/jquery.js"></script> 
		<script  type="text/javascript" src="js/bootstrap.min.js"></script>
		
		<!--  CSS BOOTSTRAP  y JQUERY-->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/jsgrid.css">
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom.css">
		
		
		<!--  JS PERSONALIZADO Y JQUERY -->
		<script  type="text/javascript" src="js/jsCortePanamericano.js"></script> 
		<script  type="text/javascript" src="js/jsGeneral.js"></script> 
		<script  type="text/javascript" src="js/jquery.min.js"></script>
		<script  type="text/javascript" src="js/jsjquery.min.js"></script>
		
		<!--  JS JSGRID -->
		<link rel='stylesheet prefetch' href="css/jsgrid.min.css"/> 
	    <link rel='stylesheet prefetch' href="css/jsgrid-theme.min.css"/> 
	    <script type="text/javascript" src="js/jsgrid.js"></script> 
	    <script type="text/javascript" src="js/jsgrid.min.js"></script> 
		
		<!--  JS BOOTSTRAP -->
		<script  type="text/javascript" src="js/bootstrap.js"></script> 
		
		<!--  CSS PERSONALIZADO -->
		<link rel="stylesheet" type="text/css" href="css/EstilosPieDePagina.css">
		<link rel="stylesheet" type="text/css" href="css/EstilosMenu.css">
		<link rel="stylesheet" type="text/css" href="css/EstilosGenerales.css">
		<link rel="stylesheet" type="text/css" href="css/EstilosCortePanamericano.css">
		
		<!--  CSS y JS CALENDARIO -->
		<link rel="stylesheet" href="css/jquery-ui.css"/>
		<script src="js/jquery-ui.js"></script>
		
		<script type="text/javascript">		
			  $( function() {
				  $( "#txt_fechaIni" ).datepicker();
				  $( "#txt_fechaFin" ).datepicker();
				  $( "#txt_fecha_polizaRecValores" ).datepicker();
			  });
		
			$(function () {
			    $(document).keydown(function (e) {
			        return (e.which || e.keyCode) != 116;
			    });
			});
		</script>
		
		<script type="text/javascript">
			 function Imprimir()
	         {
				 /*var divToPrint = document.getElementById('divAlertaCortePanamericano');
	             var newWin = window.open('', 'Print-Window');
	             newWin.document.open();
	             newWin.document.write('<html>' +
	                                  '<body onload="window.print()">' +
	                                  divToPrint.innerHTML +
	                                  '</body></html>');
	             newWin.document.close();
	             setTimeout(function () { newWin.close(); }, 10); */
	              
				 var mywinPan = window.open('', 'Print-Window', '');
		         mywinPan.document.write('<html><head><title>' + document.title  + '</title>');
		         mywinPan.document.write('</head><body >');
		         mywinPan.document.write('<h1>' + document.title  + '</h1>');
		         mywinPan.document.write(document.getElementById('divAlertaCortePanamericano').innerHTML);
		         mywinPan.document.write('</body></html>');
		         mywinPan.document.close(); // necessary for IE >= 10
		         mywinPan.focus(); // necessary for IE >= 10*/
		         mywinPan.print();
		         mywinPan.close();
				 return true;
	         }
	     </script>
		
</head>

	<body  onload="IniciaModuloDeCorteDePanamericano('divCortePanamericano', 'tdCorteDePanamericano')">
	 	<!-- PIE DE PAGINA  -->
		<%@include file="PieDePagina.html" %>
		
		 <!-- ENCABEZADO  -->
		<%@include file="Encabezado.html" %>
		
		<div class="EG_divPrincipal" style="text-align:center">
		
		<!-- ALERTA DE ESPERA -->
		<%@include file="AlertaMensajeDeEspera.html" %>
			
			
		<!-- ALERTA CORTE DE CAJA -->
		<%@include file="AlertaCortePanamericano.html" %>
			
			<table width="100%" align="center">
				<tr>
					<td width="10%"  valign="top" >
						<div style="background: #C0D9EF; height:860px; width:120px" >
						 	<%@include file="Menu.html" %>		 
						</div>
					</td>
					<td valign="top" width="90%">
						<div id="divCortePanamericano" style="width: 100%;">
						
							<div style="height: 10px"></div>
							<!--ENCABEZADO-->
							<div class="row">
								<div class="col-sm-12" >
									<table width="80%" align="center">
										<tr>
											<td width="100%" align="center">
												<label style="color:#439ED4" class="EG_lbTituloAzul"> Recolecci&oacute;n De Valores </label>
											</td>
										</tr>
									</table>
								</div>
							</div>
							<div style="height: 10px"></div>
							
							<!-- FILTROS DE BUSQUEDA  -->	
							<table align="center" width="98%" style="border: 1px solid #DDDDDD; background-color: #FBFBFB ;">
								<tr height="10px"></tr>
								<tr>
									<td>
                               			<label class="EG_lbtexto">F.Inicio:</label>
                               			<input type="text" id="txt_fechaIni" class="EG_calendario" style="width: 100px">
                               		</td>
                               		<td>
                               			<label class="EG_lbtexto">F.Fin:</label>
                               			<input type="text" id="txt_fechaFin" class="EG_calendario" style="width: 100px">
                               		</td>
                               		<td>
                               			<label for="id_bancoDeposito" class="EG_lbtexto"  >Estatus:</label>
                               			<select id="cmbEstatus"  name="cmbEstatus" class="EG_cmb" style="width: 120px">
			                       			<c:forEach var="sts" items="${listaEstatus}" >
			                       				<c:if test="${sts.id_estatus == '2' || sts.id_estatus == '3' }">
													<option value="${sts.id_estatus}" >${sts.nombre_estatus}</option>
												</c:if>
											</c:forEach>
										</select>
                               		</td>
                                   	<td>
                                   		<label class="EG_lbtexto">Papeleta:</label>
                               			<input type="text" id="txt_papeletaBuscar" class="EG_calendario" onkeypress="return EsNumero(event)" style="width: 50px">
                                   	</td>
                                   	<td>
                                   		<label class="EG_lbtexto">Plomo:</label>
                               			<input type="text" id="txt_plomoBuscar" class="EG_calendario" onkeypress="return EsNumero(event)" style="width: 50px">
                                   	</td>
                                   	<td>
                                   		<label class="EG_lbtexto">Folio C.Caja:</label>
                               			<input type="text" id="txt_folioCorte" class="EG_calendario" onkeypress="return EsNumero(event)" style="width: 50px">
                                   	</td>
                                   	 <td>
                                   		<label class="EG_lbtexto">Folio Rec. Val.:</label>
                               			<input type="text" id="txt_folioPanamericano" class="EG_calendario" onkeypress="return EsNumero(event)" style="width: 50px">
                                   	</td>
                                   	<td>
                                   		<button class="btn btn-primary" type="submit"  style="padding:3px; font-size:13px;  width: 80px" onclick="buscaCortesDeCajaEnBD(1)"  >
											<i class="glyphicon glyphicon-search"></i> Buscar
										</button>
                                   	</td>
								</tr>
								<tr height="10px"></tr>
							</table>
							
							<div style="height: 15px"></div>
							<!-- NUMERO DE PAPELETA Y PLOMO  -->
							<table  id="divGeneraCortePanamericano" width="90%"  align="center">
								<tr>
									<td valign="bottom">
										<div width ="80%" style="border: 1px solid #87CEEB; width:95%; border-radius: 4px; padding: 10px" >
										 	<table width ="85%" align="center">
										 		<tr>
										 			<td align="center"> 
										 				<label class="EG_lbtexto" style="font-size: 12px" >No. Papeleta:</label>
										 				<input type="text" id="txt_no_papeleta" class="EG_calendario" onkeypress="return EsNumero(event)">
										 			</td>
										 			<td align="center"> 
										 				<label class="EG_lbtexto" style="font-size: 12px" >No. Plomo:</label>
										 				<input type="text" id="txt_no_plomo" class="EG_calendario" onkeypress="return EsNumero(event)">
										 			</td>
										 			<td align="center"> 
										 				<label class="EG_lbtexto" style="font-size: 12px" >Fecha Poliza:</label>
										 				<input type="text" id="txt_fecha_polizaRecValores" class="EG_calendario">
										 			</td>										 			
										 			<td align="right">
										 				<button id="btn_NuevoEgreso" class="btn btn-info" type="submit"  style="padding:6px; font-size:13px;  width: 150px" onclick="generarCortePanamericano()"  >
															<i class="glyphicon glyphicon-ok"></i> Rec. Valores
														</button>
										 			</td>
										 		</tr>
										 	</table>
									 	</div>									
									</td>
									
						 			<td align="right" valign="bottom">
							 			<label style="font-family: arial; font-size: 18px; font-weight: bold; color:#00008B">Total: </label> 
							 			<label style="font-family: arial; font-size: 18px; font-weight: bold; color: #DC143C">$ </label>
										<label style="font-family: arial; font-size: 18px; font-weight: bold; color: #DC143C" id="lb_totalPanamericano"></label>
							 		</td>
								</tr>
							</table>
							
							<div style="height: 15px"></div>
							<!-- GRID CORTE DE PANAMERICANO -->	
						 	<table>
								<tr>
									<td align="center">
									 	<div id="dgCortePanamericano" class="EG_DivGrid"  style="font-size: 11px"></div>
									</td>
								</tr>   
						 	</table>
						 	<br>
												
						</div>	
					</td>
				</tr>
			</table>
		</div>	
	</body>
</html>