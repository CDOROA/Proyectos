package cdo.Persistencia;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class GestorCuentasContacto  extends HttpServlet  {
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
	
	   public GestorCuentasContacto() {
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
	 
	 public String consultaCuentasDeposito(int centro, int cliente)
	 {
		String Parametros = "";
		String respuestaJson = "";

		try {
			 Parametros = "?cve_centro=" + centro;

			 respuestaJson = this.cliente.target(properties.getProperty("URL_CUENTAS_CONTACTO") + Parametros)
							.request(MediaType.APPLICATION_JSON).get(String.class);
			
			// System.out.println("URL_CUENTAS_CONTAC:" + properties.getProperty("URL_CUENTAS_CONTACTO") + Parametros);
			 
		} catch (Exception ex) {
			throw ex;
			 
			}
		//System.out.println("consultaTipoContacto  respuestaJson: " + respuestaJson );
		 return respuestaJson;
	 }
}
