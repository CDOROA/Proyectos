package Persistencia;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class wsRfc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private Client cliente = null;

	   public wsRfc() {
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
	   public static String consultaRfc(String rfc)
	   {
		   String Parametros = "";
		   String rsp = "false";
		   try {
				Parametros = "&rfc=" + rfc;
				//Parametros = "?cdo=cdl&folio=1&serie=LELAN&correo=s";
				URL url= new URL("http://deswebcdo18.corprama.com.mx:8080/wsSelladoCFDIv4Prod/comprobante/validadorRFC?usuario=FYUFVHOH-CDSA&passwrod=9HKX3GU82"+Parametros);
		        URLConnection urlConnection = url.openConnection();
		        urlConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
		        BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());    
		        byte[] contents = new byte[1024];

		        int bytesRead = 0;
		        String strFileContents=""; 
		        while((bytesRead = in.read(contents)) != -1) { 
		            strFileContents += new String(contents, 0, bytesRead);              
		        }
				rsp=strFileContents;
				
				return rsp;
			} catch (Exception ex) {
				// this.invocarVistaError(ex, uri, request, response);
			//	System.out.println("error uri : " + url);
				System.out.println("error consultaProcesosUsuario : " + ex);
				return rsp;
			}
	   }
}
