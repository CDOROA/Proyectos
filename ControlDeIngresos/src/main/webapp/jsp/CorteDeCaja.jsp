<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<script  type="text/javascript" src="js/jsCorteDeCaja.js"></script> 
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
		<link rel="stylesheet" type="text/css" href="css/EstilosCorteCaja.css">
		
		<!--  CSS y JS CALENDARIO -->
		<link rel="stylesheet" href="css/jquery-ui.css"/>
		<script src="js/jquery-ui.js"></script>
		
		<script type="text/javascript">
			 function Imprimir()
	         {
	             /*var divToPrint = document.getElementById('divAlertaCorteCaja');
	             var newWin = window.open('', 'Print-Window');
	             newWin.document.open();
	             newWin.document.write('<html>' +
	                                  '<body onload="window.print()">' +
	                                  divToPrint.innerHTML +
	                                  '</body></html>');	
	             newWin.document.close();
	             setTimeout(function () { newWin.close(); }, 10); */
	             
				 var mywinCor = window.open('', 'Print-Window', '');
	             mywinCor.document.write('<html><head><title>' + document.title  + '</title>');
	             mywinCor.document.write('</head><body >');
	             mywinCor.document.write('<h1>' + document.title  + '</h1>');
	             mywinCor.document.write(document.getElementById('divAlertaCorteCaja').innerHTML);
	             mywinCor.document.write('</body></html>');
	             mywinCor.document.close(); // necessary for IE >= 10
	             mywinCor.focus(); // necessary for IE >= 10*/
	             mywinCor.print();
	             mywinCor.close();
				 return true;
	         }
	     </script>
</head>
<body onload="IniciaModuloDeCorteDeCaja('divCorteCaja', 'tdCorteDeCaja')">
	
		 <!-- PIE DE PAGINA  -->
		<%@include file="PieDePagina.html" %>
		
		 <!-- ENCABEZADO  -->
		<%@include file="Encabezado.html" %>
		
	<div class="EG_divPrincipal" style="text-align:center">
	
		<!-- ALERTA CORTE DE CAJA -->
		<%@include file="AlertaCorteDeCaja.html" %>
				
		 <!-- ALERTA FIRMA MANCOMUNADA DE EGRESO  -->
	 	<%@include file="AlertaFirmaMancomunada.html" %>
			
		 <!-- ALERTA FIRMA MANCOMUNADA DE EGRESO  -->
	 	<%@include file="AlertaRedondeoCentavos.html" %>
	 	
	 	<!-- ALERTA FIRMA MANCOMUNADA DE EGRESO  -->
	 	<%@include file="AlertaConfirmacionRedondeo.html" %>
	 	
	 	<!-- ALERTA DE ESPERA -->
		<%@include file="AlertaMensajeDeEspera.html" %>
	 	
	 	
	 	
		<table width="100%" align="center">
			<tr>
				<td width="10%"  valign="top" >
					<div style="background: #C0D9EF; height:860px; width:120px" >
					 	<%@include file="Menu.html" %>		 
					</div>
				</td>
				<td valign="top" width="90%">
					<div id="divCorteCaja" style="width: 100%;">
						<br>	
						<!-- TIPOS DE CORTE DE CAJA -->
						<div class="row">
							<div class="col-sm-12" >
								<table width="80%" align="center">
									<tr>
										<td width="100%" align="center">
											<label style="color:#439ED4" class="EG_lbTituloAzul"> Corte De Caja </label>
										</td>
									</tr>
								</table>
							</div>
						</div>
						<br>
						
						<c:if test="${MostrarCierreCaja == 'SI'}">
							<div id="divCorteDeCajacompleto">
								<!--PREVIO DE INGRESOS -->
								<div class="row content">
									<div class="col-sm-12 row">
										<div class="col-sm-6 center-text">
											<label class="ECDC_lbtextoTitulo" style="color: #229FC7;">Previo de Ingresos</label>
										</div>
										<div class="col-sm-6 row">
											<div class="col-sm-6 center-text ">
												<label class="ECDC_lbtextoTitulo" style="color: #229FC7;"> Tipo de Pago</label>
											</div>
											<div class="col-sm-6 center-text ">
												<label class="ECDC_lbtextoTitulo" style="color: #229FC7;"> Banco Deposito</label>
											</div>
										</div>
										<br>
										<div class="col-sm-6">
											<table align="center"class="table" style="width:70%; margin-bottom: 0px">
												<c:forEach var="previoFP" items="${ListPrevioIXFP}">
												 	<tr>
												 		<c:if test="${previoFP.forma_pago == 'EFECTIVO'}">
													 		<td align="left" class="ECDC_lbtexto" style="font-weight: bold; padding:5px; background-color: #F0F8FF">${previoFP.forma_pago}</td>
													 		<td align="right" class="ECDC_lbtexto" style="font-size: 12px; padding:5px; background-color: #F0F8FF" > $ ${previoFP.importe}</td>
													 	</c:if>
													 	<c:if test="${previoFP.forma_pago != 'EFECTIVO'}">
													 		<td align="left" class="ECDC_lbtexto" style="font-weight: normal; padding:5px">${previoFP.forma_pago}</td>
													 		<td align="right" class="ECDC_lbtexto" style="font-size: 12px; padding:5px" > $ ${previoFP.importe}</td>
													 	</c:if>
													 </tr>
												</c:forEach>
											</table>
											<table  width ="70%" align="center" >
												<tr>
													<td class="ECDC_tdIngresosLogo"  width="10%" align="center">
														<label class="ECDC_lbTotal" style="color:white; font-size:22px"> $</label>
													</td>
													<td   class="ECDC_tdIngresos" align="right">
														 <label class="ECDC_lbTotal"> $ ${importePrevioI} &nbsp;&nbsp;</label>
													</td>
												</tr>
											</table>
										</div>
										<div class="col-sm-6 row">
											<div class="col-sm-6">
												<table align="center"  class="table" style="width:90%">
													<c:forEach var="previoTP" items="${ListPrevioIXTP}">
													 	<tr>
													 		<td align="left" class="ECDC_lbtexto" style="font-weight: normal; padding:5px">${previoTP.tipo_pago}</td>
													 		<td align="right" class="ECDC_lbtexto" style="font-size: 12px; padding:5px">$ ${previoTP.importe}</td>
														 </tr>
													</c:forEach>
												</table>
											</div>	
											<div class="col-sm-6">
												<table align="center"  class="table" style="width:90%">
													<c:forEach var="previoB" items="${ListPrevioIXB}">
													 	<tr>
												 			<c:if test="${previoB.banco_nombre == 'SELECCIONA'}">
												 				<td align="left" class="ECDC_lbtexto" style="font-weight: normal; padding:5px">SIN BANCO</td>
												 			</c:if>
												 			<c:if test="${previoB.banco_nombre != 'SELECCIONA'}">
												 				<td align="left" class="ECDC_lbtexto" style="font-weight: normal; padding:5px">${previoB.banco_nombre}</td>
												 			</c:if>
													 		<td align="right" class="ECDC_lbtexto" style="font-size: 12px; padding:5px">$ ${previoB.importe}</td>
														 </tr>
													</c:forEach>
												</table>
											</div>	
											
										</div>
									</div>				
								</div>
							
								<hr width="90%" align="center">
								
								<!-- PREVIO DE EGRESOS -->
								<div class="row">
									<div class="col-sm-12 row"  >
										<div class="col-sm-6 center-text" >
											<label class="ECDC_lbtextoTitulo" style="color:#DC143C ;"> Previo de Egresos </label>
											<table align="center"  class="table" style="width:70%;">
												<c:forEach var="previoE" items="${ListPrevioE}">
												 	<tr>
												 		<td align="left" class="ECDC_lbtexto" style="font-weight: normal; padding:5px">${previoE.nombre_egreso}</td>
												 		<td align="right" class="ECDC_lbtexto" style="font-size: 12px; padding:5px" >$ ${previoE.importe_egreso}</td>
													 </tr>
												</c:forEach>
											</table>
											<table  width ="70%" align="center" >
												<tr>
													<td class="ECDC_tdEgresosLogo" width="10%" align="center">
														<label class="ECDC_lbtextoTitulo" style="color:white ; font-size:22px"> $</label>
													</td>
													<td class="ECDC_tdEgresos" align="right">
														 <label class="ECDC_lbTotal"> $ - ${importePrevioE}  &nbsp;&nbsp;</label>
													</td>
												</tr>
											</table>	
										</div>
										<div class="col-sm-6">
											<label class="ECDC_lbtextoTitulo" style="color:#DC143C ;"> Banco Deposito </label>
											<table align="center"  class="table" style="width:90%">
												<c:forEach var="previoEB" items="${ListPrevioEXB}">
												 	<tr>
												 		<td align="left" class="ECDC_lbtexto" style="font-weight: normal; padding:5px">${previoEB.banco_nombre}</td>
												 		<td align="right" class="ECDC_lbtexto" style="font-size: 12px; padding:5px">$ ${previoEB.importe}</td>
													 </tr>
												</c:forEach>
											</table>	
										</div>
									</div> 				
								</div>
								<hr width="90%" align="center">
								
								<!-- PREVIO DE CORTE DE CAJA  -->
								<div class="row">
									<div class="col-sm-12 row" >
										<div class="col-sm-6 center-text" >
											<label class="ECDC_lbtextoTitulo" style="color:#679E34 ;"> Previo Total </label>
											<table align="center"  class="table" style="width:70%">
											 	<tr>
											 		<td align="left" class="ECDC_lbtexto" style="font-weight: normal; padding:5px">Ingresos</td>
											 		<td align="right" class="ECDC_lbtexto" style="font-size: 12px; padding:5px" >$ ${importePrevioI}</td>
												 </tr>
												 <tr>
											 		<td align="left" class="ECDC_lbtexto" style="font-weight: normal; padding:5px">Egresos</td>
											 		<td align="right" class="ECDC_lbtexto" style="font-size: 12px; padding:5px" >$ - ${importePrevioE}</td>
												 </tr>
											</table>
											<table  width ="70%" align="center" >
												<tr>
													<td class="ECDC_tdTotalLogo" width="10%" align="center">
														<label class="ECDC_lbtextoTitulo" style="color:white ; font-size:22px"> $</label>
													</td>
													<td class="ECDC_tdTotal" align="right">
														 <label class="ECDC_lbTotal" >$ ${importePrevioTotal}  &nbsp;&nbsp;</label><br>
														 <label class="ECDC_lbTotalLetra"> Importe Total  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
													</td>
												</tr>
											</table>
										</div>
										<div class="col-sm-6">
											<br><br><br>	<br><br><br>								
											<button class="btn btn-primary" type="submit"  style="width:300px; padding:3px; font-size:13px; " onclick="muestraAlertaCorteCaja()">
					 							<i class="glyphicon glyphicon-ok"></i> &nbsp;Genera Corte De Caja
											</button>
										</div>
									</div> 
								</div>
								<br>
							</div>
						</c:if>
						<c:if test="${MostrarCierreCaja == 'NO'}">
							<div id="divCorteDeCajaVacio">
								<br><br><br>
								<table width="50%" align="center">
									<tr>
										<td>
											<div style=" padding:3px; width:100%;"  >	
												<div class="alert alert-danger alert-dismissible fade in" >
												    <strong >¡No Existe Informaci&oacute;n!</strong>&nbsp; <label style="font-weight: normal">para Realizar un Corte de Caja</label>
												</div>
											</div>
										</td>
									</tr>
								</table>
							</div>
						</c:if>	
					</div>	
				</td>
			</tr>
		</table>
	</div>
</body>
</html>