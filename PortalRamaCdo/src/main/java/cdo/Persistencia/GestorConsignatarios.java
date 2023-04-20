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


import cdo.Datos.Consignatarios;
import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_MetodosGlobales;

public class GestorConsignatarios {
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
	public static List<Consignatarios> consultaConsignatariosWS(InfoCliente infoCliente) {
		
		List<Consignatarios> consignatrios =new ArrayList<>();	
		URL url = null;
		HttpURLConnection conn  = null;
		String parametros  ="";
		Log log = null;
		try
		{
			parametros = "consignatarios?cve_centro=" + infoCliente.getCentro() + "&num_cli=" + infoCliente.getCve_cliente();
			url = new URL(propertiesWs.getProperty("URL_WS_CONSIGNATARIOS")  + parametros);			
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
			
	        log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[URL_WS_CONSIGNATARIOS:" + propertiesWs.getProperty("URL_WS_CONSIGNATARIOS")  + parametros  + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");
			 Cls_Log.insertaLog(log);
	        	
			
	        if (conn.getResponseCode() != 200) 
	        {
	        
	        	// System.out.println("[NuevoportalRamaCDO.- URL_WS_BODEGA_CLIENTE: Error  Al conectar  Clase: GestorBodegaCliente.consultaRelacionBodegaCteWS , URL: "+ propertiesWs.getProperty("URL_WS_BODEGA_CLIENTE")  + "relacionBodega?cve_centro=" + infoCliente.getCentro() + "&cliente=" + infoCliente.getCve_cliente() + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");
	        	 log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[ URL_WS_CONSIGNATARIOS: Error  Al conectar  Clase: GestorConsignatarios.consultaConsignatariosWS , URL: "+ propertiesWs.getProperty("URL_WS_CONSIGNATARIOS")  +parametros + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");
				 Cls_Log.insertaLog(log);
            }
	        else
	        {
 
	        	 conn.connect();
	 	         InputStreamReader in = new InputStreamReader(conn.getInputStream());
	             BufferedReader br = new BufferedReader(in);
	             JsonReader lecturaJson = Json.createReader(new StringReader(br.readLine()));
	 			 JsonObject jsonBodegaCte = lecturaJson.readObject();
	 			 
	 			log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[URL_WS_CONSIGNATARIOS  Respuesta de URL: "+ jsonBodegaCte + "]");
				 Cls_Log.insertaLog(log);
				 
	 			 if(Cls_MetodosGlobales.lecturaValidacionJson(jsonBodegaCte, infoCliente, " consulta Consignatarios  ", "GestorConsignatarios.consultaConsignatariosWS","URL_WS_CONSIGNATARIOS"))
	 			 {
	 				 
	 				consignatrios =llenarClaseConsignatarios(infoCliente, jsonBodegaCte);
	 			 }	     
	        }
	        conn.disconnect();
         

		}
		catch(Exception ex)
		{
			log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "URL_WS_CONSIGNATARIOS, Error al Consultar lista de consignatarios,  Clase: GestorConsignatarios, Metodo: consultaConsignatariosWS, "+
                 " Url: "+ propertiesWs.getProperty("URL_WS_CONSIGNATARIOS")  + parametros );
			Cls_Log.insertaLog(log);
			
			Consignatarios consignatario=new Consignatarios();
			consignatrios.add(consignatario);
			
		}
		
		return consignatrios;		
	}
	
	
	private static List<Consignatarios> llenarClaseConsignatarios(InfoCliente infoCliente, JsonObject jsonConsignatarios)
	{
		List<Consignatarios> consignatrios =new ArrayList<>();			
		try 
		{		
			 JsonArray detalleJson = jsonConsignatarios.getJsonArray("datos");
			if(detalleJson.size() > 0)
			{
				for (int i = 0; i < detalleJson.size(); i++) 
				{	
					if(!detalleJson.getJsonObject(i).getString("numero").equals(""))
					{
						Consignatarios consignatario=new Consignatarios();
						consignatario.setNumeroConsignatario(detalleJson.getJsonObject(i).getString("numero"));
						consignatario.setDescripcionConsignatario(detalleJson.getJsonObject(i).getString("direccion"));
						consignatrios.add(consignatario);						
					}
				}
			}	 
		}
		catch(Exception ex)
		{ 
			Consignatarios consignatario=new Consignatarios();
			consignatrios.add(consignatario);
			throw ex;
		}
		
		return consignatrios;
	}
}
