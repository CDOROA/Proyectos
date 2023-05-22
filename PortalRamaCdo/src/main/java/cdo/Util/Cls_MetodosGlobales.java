package cdo.Util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.json.JsonObject;
import javax.servlet.http.HttpSession;

import cdo.Datos.InfoCliente;
import cdo.Datos.Log;

public class Cls_MetodosGlobales {

	public static String aplicarFormatoImporte(BigDecimal importe) 
	{
		DecimalFormat df = new DecimalFormat("#,###.00");
	    return  df.format(importe);
	}	
	
	public static void removerParametrosDeSession(HttpSession session, String pagina)
	{
		
	}
	
	public static boolean lecturaValidacionJson(JsonObject jsonObt, InfoCliente infoCliente , String accion, String clase , String nombre_ws)
	{
		 boolean  respuestaCorrecta  =false;
		  
		 if(jsonObt.getInt("status") != 5)
		 {			  
			 if(jsonObt.getInt("status") != 4)
			 {
				Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO: Estatus no valido al Invocar WS: " + nombre_ws + ". para: " + accion + ",  Clase: " + clase +". ESTATUS: " +  jsonObt.getInt("status")  + ",  Detalle: " + jsonObt.getString("msjRespuesta") +"]");
				Cls_Log.insertaLog(log);
			 }
			 else
			 {
				 Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO: Estatus no valido al Invocar WS: " + nombre_ws + ". para: " + accion + ",  Clase: " + clase +". ESTATUS: " +  jsonObt.getInt("status")  + ",  Detalle: " + jsonObt.getString("msjRespuesta") +"]");
				 Cls_Log.insertaLog(log);
			 }						 
		 }
		 else
		 {
			 respuestaCorrecta= true;
		 }
		 return respuestaCorrecta;
	}
}
