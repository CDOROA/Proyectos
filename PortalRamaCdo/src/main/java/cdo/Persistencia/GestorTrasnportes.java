package cdo.Persistencia;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
import cdo.Datos.Transportes;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_MetodosGlobales;

public class GestorTrasnportes {
	 private  static Properties propertiesWs = null;
	 static 
	 {
	      try  
	      {
		      propertiesWs = new Properties();
		      InputStream  inputStreamWs  = GestorIniciaSessionV2.class.getClassLoader().getResourceAsStream("/properties/configuracion.properties");
		      propertiesWs.load(inputStreamWs);
	      }
	      catch  (Exception ex) 
	      {
	        ex.printStackTrace();
	      }
	 }	
	
	public static List<Transportes> consultaTransportesWS(InfoCliente infoCliente) throws Exception
	{
		List<Transportes> transportes = new ArrayList<>();		
		 Log log = null;
		URL url = null;
		HttpURLConnection conn  = null;
		try
		{
			url = new URL(propertiesWs.getProperty("URL_WS_TRANSPORTES")  + "transportes?cve_centro=" + infoCliente.getCentro() );			
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        
	        log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[URL_WS_TRANSPORTES  llamando a  URL: "+ propertiesWs.getProperty("URL_WS_TRANSPORTES")  + "transportes?cve_centro=" + infoCliente.getCentro()  + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");	
			Cls_Log.insertaLog(log);
	        
	       
	        if (conn.getResponseCode() != 200) 
	        {       
	        	 log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[URL_WS_TRANSPORTES: Error  Al conectar  Clase: GestorTransportes.consultaTransportesWS , URL: "+ propertiesWs.getProperty("URL_WS_TRANSPORTES")   + "transportes?cve_centro=" + infoCliente.getCentro()  + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");	
				 Cls_Log.insertaLog(log);
            }
	        else
	        {
 
	        	 conn.connect();
	 	         InputStreamReader in = new InputStreamReader(conn.getInputStream());
	             BufferedReader br = new BufferedReader(in);
	             JsonReader lecturaJson = Json.createReader(new StringReader(br.readLine()));
	 			 JsonObject jsonBodegaCte = lecturaJson.readObject();

	 			log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[URL_WS_TRANSPORTES  Respuesta de URL: "+ jsonBodegaCte + "]");
				 Cls_Log.insertaLog(log);
	 			 
	 			 
	 			 if(Cls_MetodosGlobales.lecturaValidacionJson(jsonBodegaCte, infoCliente, " consulta Trasnportes", "GestorTransportes.consultaTransportesWS","URL_WS_TRANSPORTES"))
	 			 {
	 				 
	 				transportes = llenarClaseTransportes(infoCliente, jsonBodegaCte);
	 			 }	     
	        }
	        conn.disconnect();
		}
		catch(Exception ex)
		{

			log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[URL_WS_TRANSPORTES   Realiza Segundo llamado Excepcion estatus de la conexion: "  + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");	
			Cls_Log.insertaLog(log);
			
			log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[URL_WS_TRANSPORTES   Realiza Segundo llamado  por Excepcion  ex: " + ex);	
			Cls_Log.insertaLog(log);
			try
			{
				url = new URL(propertiesWs.getProperty("URL_WS_TRANSPORTES")  + "transportes?cve_centro=" + infoCliente.getCentro() );		
		        conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Accept", "application/json");
		      
		        log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[URL_WS_TRANSPORTES  llamando a  URL: "+ propertiesWs.getProperty("URL_WS_TRANSPORTES")  + "transportes?cve_centro=" + infoCliente.getCentro() +  ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");	
				Cls_Log.insertaLog(log);
		        
		        
		        if (conn.getResponseCode() != 200) 
		        {
		        	log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO.- URL_WS_TRANSPORTES: Error  Al conectar  Clase: GestorTransportes.consultaTransportesWS , URL: "+ propertiesWs.getProperty("URL_WS_TRANSPORTES")   + "transportes?cve_centro=" + infoCliente.getCentro()  + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");	
					 Cls_Log.insertaLog(log);
	            }
		        else
		        {
	 
		        	 conn.connect();
		 	         InputStreamReader in = new InputStreamReader(conn.getInputStream());
		             BufferedReader br = new BufferedReader(in);
		             JsonReader lecturaJson = Json.createReader(new StringReader(br.readLine()));
		 			 JsonObject jsonBodegaCte = lecturaJson.readObject();

		 			log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO.- URL_WS_TRANSPORTES  Respuesta de URL: "+ jsonBodegaCte + "]");
					 Cls_Log.insertaLog(log);
		 			 
		 			 
		 			  if(Cls_MetodosGlobales.lecturaValidacionJson(jsonBodegaCte, infoCliente, " consulta Trasnportes", "GestorTransportes.consultaTransportesWS","URL_WS_TRANSPORTES"))
		 			  {
		 				 transportes = llenarClaseTransportes(infoCliente, jsonBodegaCte);
		 			   }	

		        }
		        conn.disconnect();
			}
			catch (Exception e) {
				 log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO.- URL_WS_TRANSPORTES: Error  Al llamar al Servicio WEB   Clase: GestorTansportes.consultaTransportesWS , URL: "+ propertiesWs.getProperty("URL_WS_BODEGA_CLIENTE")  + "relacionBodega?cve_centro=" + infoCliente.getCentro() + "&cliente=" + infoCliente.getCve_cliente() + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");
				 Cls_Log.insertaLog(log);
			}
		}
	 
		return transportes;		
	}
	
	
private static List<Transportes> llenarClaseTransportes(InfoCliente infoCliente, JsonObject jsonTransportes)
{
	List<Transportes> transportes = new ArrayList<>();		
	try 
	{		
		 JsonArray detalleJson = jsonTransportes.getJsonArray("datos");
		if(detalleJson.size() > 0)
		{
			for (int i = 0; i < detalleJson.size(); i++) 
			{	
				Transportes transporte=new Transportes();
				transporte.setCve_trasporte(detalleJson.getJsonObject(i).getInt("numero"));
				transporte.setNombre_trasporte(detalleJson.getJsonObject(i).getString("nombre"));
				transporte.setTipoTransporte(detalleJson.getJsonObject(i).getString("tipo_trans"));
				transportes.add(transporte);	
			//	System.out.println("transporte: " + transporte);
			}
		}	 
	}
	catch(Exception ex)
	{
		//System.out.println("[NuevoportalRamaCDO.- Error: LLenar clase transportes,  Clase: GestorIniciaSessionV2,  Detalle: " + ex.getMessage().toString() +"]");
		//Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: LLenar clase transportes,  Clase: GestorIniciaSession,  Detalle: " + ex.getMessage().toString() +"]");
		//Cls_Log.insertaLog(log);
		//throw ex;
		Transportes transporte=new Transportes();
		transportes.add(transporte);	
	}
	return transportes;
}

}
