package cdo.Persistencia;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;


//import Datos.Usuario;

public class GestorSellado extends HttpServlet{
	private static final long serialVersionUID = 1L;

	 private Client cliente = null;
	   public GestorSellado() {
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
	   public String sellaFactura(String cdo, String serie,String folio)
	   {
		   String Parametros = "";
		   String rsp = "false";
		   try {
				Parametros = "?cdo=" + cdo.toLowerCase() + "&serie=" + serie + "&folio=" + folio +
						"&correo=s&grupo=3";
				//Parametros = "?cdo=cdl&folio=1&serie=LELAN&correo=s";
				//URL url= new URL("http://deswebcdo18.corprama.com.mx:8080/wsSelladoCFDIv4cdokwx/comprobante/documento"+Parametros);
				URL url= new URL("http://deswebcdo18.corprama.com.mx:8080/wsSelladoCFDIv4cdokwx/comprobante/documento"+Parametros);
		        URLConnection urlConnection = url.openConnection();
		        urlConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
		        BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());    

//				String cadUsisario = this.cliente.target(URI_WS + Parametros)
//						.request(MediaType.APPLICATION_JSON).get(String.class);
		        byte[] contents = new byte[1024];

		        int bytesRead = 0;
		        String strFileContents=""; 
		        while((bytesRead = in.read(contents)) != -1) { 
		            strFileContents += new String(contents, 0, bytesRead);              
		        }

		        System.out.print("SERIE: "+serie+" FOLIO: "+folio+" "+strFileContents);
				//JSONArray jsonArrayMenu = new JSONArray(cadUsisario);
			
					//System.out.println(usr);
				rsp="true";
				
				return rsp;
			} catch (Exception ex) {
//				// this.invocarVistaError(ex, uri, request, response);
				System.out.println("error consultaProcesosUsuario : " + ex);
				return rsp;
			}
	   }
}