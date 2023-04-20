package cdo.Datos;

import org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.CancelarCFDIConValidacionResponse;
//import org.datacontract.schemas._2004._07.CancelarCFDIsConValidacion.ResponseCancelacionR;

public class RespuestaUsuario {
 String RespuestaString;
 CancelarCFDIConValidacionResponse respuestaObjeto41;
 
public String getRespuestaString() {
	return RespuestaString;
}
public void setRespuestaString(String respuestaString) {
	RespuestaString = respuestaString;
}
public CancelarCFDIConValidacionResponse getRespuestaObjeto41() {
	return respuestaObjeto41;
}
public void setRespuestaObjeto41(CancelarCFDIConValidacionResponse getRespuestaObjeto41) {
	this.respuestaObjeto41 = getRespuestaObjeto41;
}


public RespuestaUsuario( ) {
	super();
	RespuestaString = "";
	this.respuestaObjeto41 = null;
}
 

 
}
