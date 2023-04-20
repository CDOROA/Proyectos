<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Expires" content="-1">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		
	<title>Contactenos</title>			
	<script  type="text/javascript" src="js/ScriptContactenos.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery-ui.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<link rel='stylesheet prefetch' href="css/jsgrid.min.css" />
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel='stylesheet prefetch' href="css/jsgrid-theme.min.css" />

</head>
<body>
		
		
<!-- Large modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-lg" onclick="ocultarMsj()">Contactenos</button>

<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    
      <div class="modal-header" style="    padding-bottom: 0px;padding-top: 0px;">
     	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 row" >
	     	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-4" style="text-align: center; padding: 0px"></div>
	     	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-4" style="text-align: center; padding: 0px">
		     	<h4 class="modal-title" id="myLargeModalLabel" style="color:#0095ff">Contactenos</h4>
		    </div>
		    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-4" style="text-align: center; padding: 0px"></div>
	    </div>
      </div>
      
      <div class="modal-body">
      <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 row" >
      <div class="col-12 col-sm-12 col-md-12 col-lg-12" style="text-align: center; padding: 0px">
      
      <div class="alert alert-warning alert-dismissible fade show" role="alert"  id="divAdvertencia" style="display: none;    padding-top: 6px;padding-bottom: 4px;">
  	<label id="msjAdvertencia"></label>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
      
      <div class="alert alert-danger alert-dismissible fade show" role="alert"  id="divError" style="display: none;    padding-top: 6px;padding-bottom: 4px;">
  	<label id="msjError"></label>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>	
    <div class="alert alert-success alert-dismissible fade show" role="alert"  id="divCorrecto" style="display: none;    padding-top: 6px;padding-bottom: 4px;">
  	<label id="msjCorrecto"></label>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>	
		
      </div>
      </div>
	  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 row" >
	  	<div class="col-xs-12 col-sm-6 col-md-6 col-lg-4" style="text-align: center; padding: 0px">
		<table width="100%">
      		<tr>
      			<td style="text-align: left">
 					<label>Nombre</label>
				</td>
			</tr>
			<tr>
				<td style="    padding-right: 20px;">
				<div class="input-group mb-2">
			        <div class="input-group-prepend">
			          <div class="input-group-text"><span><i class="fa fa-user fa  fa-lg "  style="color:#0095ff" aria-hidden="true"></i></span></div>
			        </div>
			        <input id="txt_nombre" name="txt_nombre" type="text" placeholder="Nombre" class="form-control">
			    </div> 
					
				</td>
			</tr>
		</table>
		</div>
		<div class="col-xs-12 col-sm-6 col-md-6 col-lg-4" style="text-align: center; padding: 0px">                            
      	<table width="100%">
      		<tr>
      			<td style="text-align: left">
 					<label>Apellido Paterno</label>
				</td>
			</tr>
			<tr>
				<td style="    padding-right: 20px;">
				<div class="input-group mb-2">
			        <div class="input-group-prepend">
			          <div class="input-group-text"><span><i class="fa fa-user fa  fa-lg "  style="color:#0095ff" aria-hidden="true"></i></span></div>
			        </div>
			        <input id="txt_paterno" name="txt_paterno" type="text" placeholder="Apellido paterno" class="form-control">
			    </div> 
				</td>
			</tr>
		</table>
		</div>
		<div class="col-xs-12 col-sm-6 col-md-6 col-lg-4" style="text-align: center; padding: 0px">
      	<table width="100%">
      		<tr>
      			<td style="text-align: left">
 					<label>Apellido Materno</label>
				</td>
			</tr>
			<tr>
				<td style="    padding-right: 20px;">
				<div class="input-group mb-2">
			        <div class="input-group-prepend">
			          <div class="input-group-text"><span><i class="fa fa-user fa  fa-lg "  style="color:#0095ff" aria-hidden="true"></i></span></div>
			        </div>
			        <input id="txt_materno" name="txt_materno" type="text" placeholder="Apellido materno" class="form-control">
			    </div> 
				</td>
			</tr>
		</table>	                            
        </div>                    
	</div>
	
		  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 row" >
	  	<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6" style="text-align: center; padding: 0px">
		<table width="100%">
      		<tr>
      			<td style="text-align: left">
 					<label>Email</label>
				</td>
			</tr>
			<tr>
				<td style="padding-right: 20px;"> 
				<div class="input-group mb-2">
			        <div class="input-group-prepend">
			          <div class="input-group-text"><span><i class="fa fa-envelope fa  fa-lg "  style="color:#0095ff" aria-hidden="true"></i></span></div>
			        </div>
			        <input id="txt_email" name="txt_email" type="text" placeholder="example12@gmail.com" class="form-control">
			    </div> 
					
				</td>
			</tr>
		</table>
		</div>
		<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2" style="text-align: center; padding: 0px">                            
      	
		</div>
		<div class="col-xs-12 col-sm-4  col-md-4 col-lg-4" style="text-align: center; padding: 0px">
      	<table width="100%">
      		<tr>
      			<td style="text-align: left">
 					<label>Telefono</label>
				</td>
			</tr>
			<tr>
				<td style="    padding-right: 20px;">
				<div class="input-group mb-2">
			        <div class="input-group-prepend">
			          <div class="input-group-text"><span><i class="fa fa-phone fa  fa-lg "  style="color:#0095ff" aria-hidden="true"></i></span></div>
			        </div>
			        <input id="txt_telefono" name="txt_telefono" type="text" placeholder="Numero a 10 digitos"   maxlength="10" onKeyPress="return soloNumeros(event);"class="form-control">
			    </div> 
				
				</td>
			</tr>
		</table>	                            
        </div>                    
	</div>
	
    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 row" >
	  	<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6" style="text-align: center; padding: 0px">
	      	<table width="100%">
	      		<tr>
	      			<td style="text-align: left">
	 					<label>Estado</label>
					</td>
				</tr>
				<tr>
					<td style="    padding-right: 20px;">
					<div class="input-group mb-2" >
			        <div class="input-group-prepend">
			          <div class="input-group-text"><span><i class="fa  fa-location-arrow fa  fa-lg "  style="color:#0095ff" aria-hidden="true"></i></span></div>
			        </div>
			        <select id="select_estado" class="form-control" onchange="valorSelect(value);">
					        <option selected>Guadalajara</option>
					        <option value="cdm">Monterrey</option>
					        <option value="cdf">CDMX</option>
					        <option value="cd2">Puebla</option>
					      </select>
					      <input type="hidden" id="txt_estado" value="gdl">
			    </div> 
						 
					</td>
				</tr>
			</table>
		</div>
		<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2" style="text-align: center; padding: 0px">                            
      	
		</div>
		<div class="col-xs-12 col-sm-4  col-md-4 col-lg-4" style="text-align: center; padding: 0px">

						<table width="100%">
	      		<tr>
	      			<td style="text-align: left">
	 					<label>Eres cliente</label>
					</td>
				</tr>
				<tr>
					<td style="padding-right: 20px; text-align: left;"> 
						<div class="form-check form-check-inline">
						  <input class="form-check-input" type="radio" name="radioCliente" id="radio_no" value="radio_no" checked="checked" onclick="ocultarCliente()">
						  <label class="form-check-label" for="inlineRadio1">No</label>
						</div>
						<div class="form-check form-check-inline">
						  <input class="form-check-input" type="radio" name="radioCliente" id="radio_si" value="radio_si" onclick="mostrarCliente()">
						  <label class="form-check-label" for="inlineRadio2">Si</label>
						</div>
					</td>
				</tr>
				<tr>
				<td>
				<div class="input-group mb-2" id="div_txt_cliente" style="display: none">
			        <div class="input-group-prepend">
			          <div class="input-group-text"><span><i class="fa  fa-address-card-o fa  fa-lg "  style="color:#0095ff" aria-hidden="true"></i></span></div>
			        </div>
			        <input id="txt_cliente" type="text" placeholder="Numero cliente" onKeyPress="return soloNumeros(event);" maxlength="5" class="form-control" size="10px" >
			    </div> 
				
				</td>
				</tr>
			</table>	                            
        </div>                    
	</div>
	
	    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 row" >
	  	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="text-align: center; padding: 0px">
	      	<table width="100%">
	      		<tr>
	      			<td style="text-align: left">
	 					<label>Mensaje</label>
					</td>
				</tr>
				<tr>
					<td style="    padding-right: 20px;">
						<div class="input-group mb-2" >
			        <div class="input-group-prepend">
			          <div class="input-group-text"><span><i class="fa  fa-pencil-square-o fa  fa-lg "  style="color:#0095ff" aria-hidden="true"></i></span></div>
			        </div>
			        <textarea class="form-control" id="txt_mensaje" rows="3" placeholder="Descripcion del mensaje"></textarea>
			    </div> 
						
					</td>
				</tr>
			</table>
		</div>
		
                  
	</div>
	
	
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <button type="button" class="btn btn-primary" onclick="validarValores()">Enviar correo</button>
      </div>
      
    </div>
  </div>
</div>

		
		
</body>
</html>