package cdfis.Datos;

import org.datacontract.schemas._2004._07.TES_V33_CFDI_Negocios.RespuestaCancelacionCR;

public class RespuestaUsuario {
 String RespuestaString;
 RespuestaCancelacionCR respuestaObjeto33;
 
public String getRespuestaString() {
	return RespuestaString;
}
public void setRespuestaString(String respuestaString) {
	RespuestaString = respuestaString;
}
public RespuestaCancelacionCR getRespuestaObjeto33() {
	return respuestaObjeto33;
}
public void setRespuestaObjeto33(RespuestaCancelacionCR respuestaObjeto33) {
	this.respuestaObjeto33 = respuestaObjeto33;
}


public RespuestaUsuario( ) {
	super();
	RespuestaString = "";
	this.respuestaObjeto33 = null;
}
 

 
}
