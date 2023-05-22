package cdo.Persistencia;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonObject;

public class GestorCentroDeMensajes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Client cliente = null;
	private  static Properties properties = null;	
	static 
	{
	      try  
	      {
	    	  properties = new Properties();
		      InputStream  inputStreamWs  = GestorIniciaSessionV2.class.getClassLoader().getResourceAsStream("/properties/configuracion.properties");
		      properties.load(inputStreamWs);
	      }
	      catch  (Exception ex) 
	      {
	        ex.printStackTrace();
	      }
	 }
	
	   public GestorCentroDeMensajes() {
	         super();
	        
	     }
	     @Override
	     public void init() throws ServletException {
	     	super.init();
	     	this.cliente = ClientBuilder.newClient();
	     }
	     
	 @Override
	 public void destroy() {
			this.cliente.close();
			super.destroy();
	 }
	 
	 
	 
	 public String consultaMensajes(int centro, int cliente)
	 {
		String Parametros = "";
		String respuestaJson = "";

		try {
			 Parametros = "?cve_centro=" + centro + "&num_cli=" + cliente;
			
			 Response cadUsisario = this.cliente.target(properties.getProperty("URL_MENSAJES_WWW") + Parametros)
						.request(MediaType.APPLICATION_JSON).post(Entity.json("Row"));
			//  System.out.println(properties.getProperty("URL_MENSAJES_WWW") + Parametros);
			 respuestaJson = cadUsisario.readEntity(String.class);
			 
		} catch (Exception ex) {
		//	System.out.println("NuevoportalRamaCDO.- WS MENSAJES_WWW no disponible, GestorCentroDeMensajes.consultaMensajes(), URL: " +properties.getProperty("URL_MENSAJES_WWW") + Parametros);
			respuestaJson = "{\"registros\": 0,\"msjRespuesta\": \"Servicio no disponible\",\"status\": 5, \"datos\": [{\"leidos\":1,\"msjLeidos\":[ {\"id\": \"1\", \"mensaje\":\"Servicio no Disponible\" ,\"estatus\": \"No visto\"}],\"msjPendientes\":[],\"pendientes\":0}]}";
			
		}
		 return respuestaJson;
	 }
	 
	 public int RecuperaTotalMensajes(int centro, int cliente)
	 {
		 int mensajesPendientes =  0;
		 try
		 {
		String Resp= consultaMensajes(centro, cliente);
		
 		JSONObject json =  new JSONObject(Resp);  
		JSONArray jsonArr = json.getJSONArray("datos");
		
		for(int i=0; i < jsonArr.length(); i++)   
		{  
			JSONObject object = jsonArr.getJSONObject(i);  
			mensajesPendientes = object.getInt("pendientes");
		}  
		 }
		 catch (Exception e) {
            mensajesPendientes = 0;
		}
		 return mensajesPendientes;
	 }
	 
	 public String actualizaMensajes(int centro, int cliente, String mensajes, int estatus)
	 {
		String Parametros = "";
		String respuestaJson = "";
		JSONObject object = new JSONObject();
		try {
			
			// {"cve_centro":"7","cliente":"47201","mensajes":"[1,2,10,14]","estatus":"2"}
			object.put("cve_centro", Integer.toString(centro));
			object.put("cliente", Integer.toString(cliente));
			object.put("mensajes", "[" + mensajes.replace("-", ",") + "]" );
			object.put("estatus", Integer.toString(estatus));
			
			 // System.out.println("object a enviar: " + object);
			
			 Response cadUsisario = this.cliente.target(properties.getProperty("URL_ACTUALIZA_MENSAJES_WWW") + Parametros)
						.request(MediaType.APPLICATION_JSON).post(Entity.json(object.toString()));
 
			 respuestaJson = cadUsisario.readEntity(String.class);
			// System.out.println("actualizaMensajes respuestaJson : " + respuestaJson);
		} catch (Exception ex) {
			System.out.println("NuevoportalRamaCDO.- WS URL_ACTUALIZA_MENSAJES_WWW no disponible, GestorCentroDeMensajes.actualizaMensajes(), URL: " + properties.getProperty("URL_ACTUALIZA_MENSAJES_WWW") + object.toString());
			 
			}
		 return respuestaJson;
	 }
}
