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
			<script  type="text/javascript" src="js/jsConsultaDeCortes.js"></script> 
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
			<link rel="stylesheet" type="text/css" href="css/EstilosCortePoliza.css">
			<link rel="stylesheet" type="text/css" href="css/EstilosConsultaCortes.css">
						
			<!--  CSS y JS CALENDARIO -->
			<link rel="stylesheet" href="css/jquery-ui.css"/>
			<script src="js/jquery-ui.js"></script>
			
			<script type="text/javascript">
		
			  $( function() {
				  $( "#txt_fechaCorteCaja" ).datepicker();
				  $( "#txt_fechaCortePoliza" ).datepicker();
				  $( "#txt_fechaCortePanamericano" ).datepicker();				  
			  });
				
			$(function () {
			    $(document).keydown(function (e) {
			        return (e.which || e.keyCode) != 116;
			    });
			});
		</script>
		<script type="text/javascript">
			 function ReImprimirPoliza()
	         {
	             /* var divToPrint = document.getElementById('divCortePolizaImpresion');
	              var newWin = window.open('', 'Print-Window');
	              newWin.document.open();
	              newWin.document.write('<html>' +
	                                  '<body onload="window.print()">' +
	                                  divToPrint.innerHTML +
	                                  '</body></html>');
	              newWin.document.close();
	              setTimeout(function () { newWin.close(); }, 10);  */
	              
				 var mywinPol = window.open('', 'Print-Window', '');
	             mywinPol.document.write('<html><head><title>' + document.title  + '</title>');
	             mywinPol.document.write('</head><body >');
	             mywinPol.document.write('<h1>' + document.title  + '</h1>');
	             mywinPol.document.write(document.getElementById('divCortePolizaImpresion').innerHTML);
	             mywinPol.document.write('</body></html>');
	             mywinPol.document.close(); // necessary for IE >= 10
	             mywinPol.focus(); // necessary for IE >= 10*/
	             mywinPol.print();
	             mywinPol.close();
				 return true;
	         }
			 
			 function ReImprimirPanamericano()
	         {
	            /*var divToPrint = document.getElementById('div_ficha_bancariaReimpresion');
	            var newWin = window.open('', 'Print-Window');
	            newWin.document.open();
	            newWin.document.write('<html>' +
	                                  '<body onload="window.print()">' +
	                                  divToPrint.innerHTML +
	                                  '</body></html>');
	            newWin.document.close();
	            setTimeout(function () { newWin.close(); }, 10);  */
			    var mywinPan = window.open('', 'Print-Window', '');
	            mywinPan.document.write('<html><head><title>' + document.title  + '</title>');
	            mywinPan.document.write('</head><body >');
	            mywinPan.document.write('<h1>' + document.title  + '</h1>');
	           	mywinPan.document.write(document.getElementById('div_ficha_bancariaReimpresion').innerHTML);
	            mywinPan.document.write('</body></html>');
	            mywinPan.document.close(); // necessary for IE >= 10
	            mywinPan.focus(); // necessary for IE >= 10*/
	            mywinPan.print();
	            mywinPan.close();
			    return true;
	         }
	     </script>
		
	</head>
	
	<body onload="IniciaModuloDeConsultaDeCortes('divConsultaDeCortes', 'tdConsultaPoliza')">
			
		 <!-- PIE DE PAGINA  -->
		<%@include file="PieDePagina.html" %>
		
		 <!-- ENCABEZADO  -->
		<%@include file="Encabezado.html" %>
		
		<!-- ALERTA DE ESPERA -->
		<%@include file="AlertaMensajeDeEspera.html" %>
				
		<div class="EG_divPrincipal" style="text-align:center">
			<table width="100%" align="center">
				<tr>
					<td width="10%"  valign="top" >
						<div style="background: #C0D9EF; height:860px; width:120px" >
						 	<%@include file="Menu.html" %>		 
						</div>
					</td>
					<td valign="top" width="90%" align=center>
					
						<div id="divConsultaDeCortes" style="display: none">
							<ul class="nav nav-tabs">
								<li id="li_CortesPoliza" class="active"><a data-toggle="tab" href="#divConsultaCortesPolizas">  CONSULTA DE POLIZAS </a> </li>
								<li id="li_CortesCaja" > <a data-toggle="tab" href="#divConsultaCortesCajas"> CORTES DE CAJA  </a> </li>
								<li id="li_CortesPanamericano"><a data-toggle="tab" href="#divRecoleccionDeValores"> REC. DE  VALORES </a> </li>	
							</ul>
						</div>
						<div class="tab-content" style="border:1px solid #D3D3D3; border-top: 0px">	
							<!--  CONSULTA DE POLIZA  -->		
							<div id="divConsultaCortesPolizas" class="tab-pane fade in active" >
								<%@include file="ConsultaDeCortesDePoliza.html" %>
							</div>										
							<!--  CORTE CAJA  -->		
							<div id="divConsultaCortesCajas" class="tab-pane fade" >
								<%@include file="ConsultaDeCortesDeCaja.html" %>
							</div>
							<!--  RECOLECCION DE VALORES  -->		
							<div id="divRecoleccionDeValores" class="tab-pane fade " >
								<%@include file="ConsultaDeCortesDePanamericano.html" %>
							</div>
												
						</div>					
					</td>
				</tr>
			</table>
		</div>	
	</body>
</html>