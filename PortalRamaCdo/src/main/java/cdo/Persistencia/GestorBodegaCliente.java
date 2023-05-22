package cdo.Persistencia;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import cdo.Datos.InfoCliente;
import cdo.Datos.Log;
import cdo.Util.Cls_Log;
import cdo.Util.Cls_MetodosGlobales;

public class GestorBodegaCliente {
	 static DecimalFormat formatoDecimal = new DecimalFormat("#,###.00");
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
	 
	 public static  InfoCliente consultaRelacionBodegaCteWS(InfoCliente infoCliente) throws Exception
	{	
		 Log log = null;
		URL url = null;
		HttpURLConnection conn  = null;
		try
		{
			url = new URL(propertiesWs.getProperty("URL_WS_BODEGA_CLIENTE")  + "relacionBodega?cve_centro=" + infoCliente.getCentro() + "&cliente=" + infoCliente.getCve_cliente());			
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        
	        //System.out.println("url URL_WS_BODEGA_CLIENTE: "+ url);
	       
	        log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[URL_WS_BODEGA_CLIENTE  llamando a  URL: "+ propertiesWs.getProperty("URL_WS_BODEGA_CLIENTE")  + "relacionBodega?cve_centro=" + infoCliente.getCentro() + "&cliente=" + infoCliente.getCve_cliente() + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");
			Cls_Log.insertaLog(log);
	        
	        if (conn.getResponseCode() != 200) 
	        {
	        
	        	// System.out.println("[NuevoportalRamaCDO.- URL_WS_BODEGA_CLIENTE: Error  Al conectar  Clase: GestorBodegaCliente.consultaRelacionBodegaCteWS , URL: "+ propertiesWs.getProperty("URL_WS_BODEGA_CLIENTE")  + "relacionBodega?cve_centro=" + infoCliente.getCentro() + "&cliente=" + infoCliente.getCve_cliente() + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");
	        	  log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[URL_WS_BODEGA_CLIENTE: Error  Al conectar  Clase: GestorBodegaCliente.consultaRelacionBodegaCteWS , URL: "+ propertiesWs.getProperty("URL_WS_BODEGA_CLIENTE")  + "relacionBodega?cve_centro=" + infoCliente.getCentro() + "&cliente=" + infoCliente.getCve_cliente() + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");
				 Cls_Log.insertaLog(log);
            }
	        else
	        {
 
	        	 conn.connect();
	 	         InputStreamReader in = new InputStreamReader(conn.getInputStream());
	             BufferedReader br = new BufferedReader(in);
	             JsonReader lecturaJson = Json.createReader(new StringReader(br.readLine()));
	 			 JsonObject jsonBodegaCte = lecturaJson.readObject();

	 			 
	 			log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[URL_WS_BODEGA_CLIENTE  Respuesta de URL: "+ jsonBodegaCte + "]");
				 Cls_Log.insertaLog(log);
	 			 
	 			 if(Cls_MetodosGlobales.lecturaValidacionJson(jsonBodegaCte, infoCliente, " consulta de bodega cliente", "GestorBodegaCliente.consultaRelacionBodegaCteWS","URL_WS_BODEGA_CLIENTE"))
	 			 {
	 				 
	 				infoCliente = llenaClaseBodegaCliente(infoCliente, jsonBodegaCte);
	 			 }	     
	        }
	        
	        conn.disconnect();
		}
		catch(Exception ex)
		{
			
			try
			{
							
		        conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Accept", "application/json");
		        

		        log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO.- URL_WS_BODEGA_CLIENTE  llamando a  URL: "+ propertiesWs.getProperty("URL_WS_BODEGA_CLIENTE")  + "relacionBodega?cve_centro=" + infoCliente.getCentro() + "&cliente=" + infoCliente.getCve_cliente() + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");
				Cls_Log.insertaLog(log);

		        
		        if (conn.getResponseCode() != 200) 
		        {
		        
		        	// System.out.println("[NuevoportalRamaCDO.- URL_WS_BODEGA_CLIENTE: Error  Al conectar  Clase: GestorBodegaCliente.consultaRelacionBodegaCteWS , URL: "+ propertiesWs.getProperty("URL_WS_BODEGA_CLIENTE")  + "relacionBodega?cve_centro=" + infoCliente.getCentro() + "&cliente=" + infoCliente.getCve_cliente() + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");
		        	 log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO.- URL_WS_BODEGA_CLIENTE: Error  Al conectar  Clase: GestorBodegaCliente.consultaRelacionBodegaCteWS , URL: "+ propertiesWs.getProperty("URL_WS_BODEGA_CLIENTE")  + "relacionBodega?cve_centro=" + infoCliente.getCentro() + "&cliente=" + infoCliente.getCve_cliente() + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");
					 Cls_Log.insertaLog(log);
	            }
		        else
		        {
	 
		        	 conn.connect();
		 	         InputStreamReader in = new InputStreamReader(conn.getInputStream());
		             BufferedReader br = new BufferedReader(in);
		             JsonReader lecturaJson = Json.createReader(new StringReader(br.readLine()));
		 			 JsonObject jsonBodegaCte = lecturaJson.readObject();

		 			 
		 			log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO.- URL_WS_BODEGA_CLIENTE  Respuesta de URL: "+ jsonBodegaCte + "]");
					 Cls_Log.insertaLog(log);
		 			 
		 			  if(Cls_MetodosGlobales.lecturaValidacionJson(jsonBodegaCte, infoCliente, " consulta de bodega cliente  ", "GestorIniciaSession","wsBodegaClientes"))
		 			  {
		 				infoCliente = llenaClaseBodegaCliente(infoCliente, jsonBodegaCte);
		 			   }	

		        }
		        conn.disconnect();
			}
			catch (Exception e) {
				 log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[NuevoportalRamaCDO.- URL_WS_BODEGA_CLIENTE: Error  Al llamar al Servicio WEB   Clase: GestorBodegaCliente.consultaRelacionBodegaCteWS , URL: "+ propertiesWs.getProperty("URL_WS_BODEGA_CLIENTE")  + "relacionBodega?cve_centro=" + infoCliente.getCentro() + "&cliente=" + infoCliente.getCve_cliente() + ".  Detalle: " + conn.getResponseCode()+" -"+ conn.getResponseMessage() +"]");
				 Cls_Log.insertaLog(log);
			}
			
		}
	
		return infoCliente;		
	}
	
	
	private static InfoCliente llenaClaseBodegaCliente(InfoCliente infoCliente, JsonObject jsonBodegaCte)
	{
		Log log=new Log(01,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0,"");
		String dato="";
		try
		{
			JsonArray detalleJson = jsonBodegaCte.getJsonArray("datos");

			if(detalleJson.size() > 0)
			{
				for (int i = 0; i < detalleJson.size(); i++) 
				{	
					dato ="tipo";
					if(detalleJson.getJsonObject(i).getString("tipo").equals(""))
					{
						log=new Log(0,0,0 ,0, "[NuevoportalRamaCDO.- URL_WS_BODEGA_CLIENTE: El cliente no tiene Cofigurado el tipo [REG - CDO]: " + detalleJson.getJsonObject(i));
						Cls_Log.insertaLog(log);	
					}
					else if(detalleJson.getJsonObject(i).getString("tipo").equals("reg"))
					{
						dato ="cve_empresa - reg";
						infoCliente.setCve_bodega(String.valueOf(detalleJson.getJsonObject(i).getInt("cve_empresa")));
						
						dato ="uname_br - reg";
						infoCliente.setUname_bodega(detalleJson.getJsonObject(i).getString("uname_br"));
						
						dato ="nombre_cdo - reg";
						infoCliente.setNombre_bodega(detalleJson.getJsonObject(i).getString("nombre_cdo"));
						
						dato ="ruta - reg";
						infoCliente.setRuta_bodega(String.valueOf(detalleJson.getJsonObject(i).getInt("ruta")));
						
						dato ="syf - reg";
						infoCliente.setSyf_bodega(String.valueOf(detalleJson.getJsonObject(i).getInt("syf")));
						
						dato ="cond_pago - reg";
						infoCliente.setCond_pago_bodega(String.valueOf(detalleJson.getJsonObject(i).getInt("cond_pago")));
						
						dato ="vigencia - reg";
						infoCliente.setVigencia_bodega(detalleJson.getJsonObject(i).getString("vigencia"));
						
						dato ="distancia - reg";
						infoCliente.setDistancia_bodega(String.valueOf(detalleJson.getJsonObject(i).getInt("distancia")));
						
						dato ="tipo_lf - reg";
						infoCliente.setTipo_lf_bodega(detalleJson.getJsonObject(i).getString("tipo_lf"));
						
						dato ="transporte - reg";
						infoCliente.setTransporte_bodega(String.valueOf(detalleJson.getJsonObject(i).getInt("transporte")));
						
					}
					else if(detalleJson.getJsonObject(i).getString("tipo").equals("cdo"))
					{
						dato ="ruta - cdo";
						infoCliente.setRuta_cdo(String.valueOf(detalleJson.getJsonObject(i).getInt("ruta")));
						
						dato ="syf - cdo";
						infoCliente.setSyf_cdo(String.valueOf(detalleJson.getJsonObject(i).getInt("syf")));
						
						dato ="cond_pago - cdo";
						infoCliente.setCond_cdo(String.valueOf(detalleJson.getJsonObject(i).getInt("cond_pago")));
						
						dato ="vigencia - cdo";
						infoCliente.setVigencia_cdo(detalleJson.getJsonObject(i).getString("vigencia"));
						
						dato ="distancia - cdo";
						infoCliente.setDistancia_cdo(String.valueOf(detalleJson.getJsonObject(i).getInt("distancia")));
						
						dato ="tipo_lf - cdo";
						infoCliente.setTipo_lf_cdo(detalleJson.getJsonObject(i).getString("tipo_lf"));
						
						dato ="transporte - cdo";
						infoCliente.setTransporte_cdo(String.valueOf(detalleJson.getJsonObject(i).getInt("transporte")));
						
					}
					
					dato ="precio_con_descuento";
					infoCliente.setPrecioConDescuento(detalleJson.getJsonObject(i).getInt("precio_con_descuento"));
					
					dato ="desglosa_iva";
					infoCliente.setDesglosaIva(detalleJson.getJsonObject(i).getString("desglosa_iva"));
					
					dato ="letra_descuento";
					String letra_descuento[] = detalleJson.getJsonObject(i).getString("letra_descuento").split("-");
					infoCliente.setLetra_descuento(letra_descuento[0]);
					
					dato ="disponibleCte";
					double disponibleCte= Double.parseDouble(detalleJson.getJsonObject(i).getString("limite_credito")) - Double.parseDouble(detalleJson.getJsonObject(i).getString("saldo"));
					infoCliente.setDisponible_cte("$ " + formatoDecimal.format(disponibleCte));
					
					
					dato ="Saldo_total";
					infoCliente.setSaldo_total("$ " + formatoDecimal.format(Double.parseDouble(detalleJson.getJsonObject(i).getString("saldo"))));
					
					dato ="limite_credito";
					infoCliente.setLimite_credito(detalleJson.getJsonObject(i).getString("limite_credito"));
					
					dato ="referencia_deposito";
					infoCliente.setReferenciaBancaria( detalleJson.getJsonObject(i).getString("referencia_deposito") );
					
					dato ="bloqueo";
					infoCliente.setEstatus(detalleJson.getJsonObject(i).getString("bloqueo"));
					
					
					infoCliente.setColorBarra("#FFFFFF");
					infoCliente.setColorLetra("#007bff");
					if(disponibleCte <= 0)
					{
						infoCliente.setColorBarra("#ff010b");
						infoCliente.setColorLetra("#FFFFFF");
					}
					
					if(infoCliente.getEstatus().equalsIgnoreCase("S"))
					{
						infoCliente.setColorBarra("#ff010b");
						infoCliente.setColorLetra("#FFFFFF");
					}
				}
			}	 
		}
		catch(Exception ex)
		{
			//System.out.println("[NuevoportalRamaCDO.- NuevoportalRamaCDO.- Error: Llenar clase de infoCliente,  Clase: GestorIniciaSession,  Detalle: " + ex.getMessage().toString() +"]"); 
			log=new Log(0,0,0 ,0, "[NuevoportalRamaCDO.- URL_WS_BODEGA_CLIENTE Error al Llenar clase de infoCliente,  Clase: GestorIniciaSession, Ultimo Dato procesado: " + dato +"  Detalle: " + ex.getMessage().toString() +"]");
			Cls_Log.insertaLog(log);		
			throw ex;
		}
		return infoCliente;			
	}
	
 
}
