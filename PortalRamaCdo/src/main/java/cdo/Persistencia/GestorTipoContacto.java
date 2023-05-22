package cdo.Persistencia;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class GestorTipoContacto  extends HttpServlet {
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
	
	   public GestorTipoContacto() {
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
	 
	 public String consultaTipoContacto(int centro, int cliente)
	 {
		String Parametros = "";
		String respuestaJson = "";

		try {
			 Parametros = "?cve_centro=" + centro;
			
		//	 Response cadUsisario = this.cliente.target(properties.getProperty("URL_TIPO_CONTACTO") + Parametros)
			//			.request(MediaType.APPLICATION_JSON).post(Entity.json("Row"));
			 
			 respuestaJson = this.cliente.target(properties.getProperty("URL_TIPO_CONTACTO") + Parametros)
							.request(MediaType.APPLICATION_JSON).get(String.class);
			 
			 
			 // System.out.println("URL_TIPO_CONTACTO: " + properties.getProperty("URL_TIPO_CONTACTO") + Parametros );
 
			// respuestaJson = cadUsisario.readEntity(String.class);
			 
		} catch (Exception ex) {
			throw ex;
			 
			}
		 // System.out.println("NuevoportalRamaCDO.- consultaTipoContacto  respuestaJson: " + respuestaJson );
		 return respuestaJson;
	 }
}
