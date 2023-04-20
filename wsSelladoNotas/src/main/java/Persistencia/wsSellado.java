package Persistencia;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class wsSellado extends HttpServlet{
	private static final long serialVersionUID = 1L;

	 private Client cliente = null;

	   public wsSellado() {
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
	   public String sella(String cdo, String serie,String folio)
	   {
		   String Parametros = "";
		   String rsp = "false";
		   try {
				Parametros = "?cdo=" + cdo.toLowerCase() + "&serie=" + serie + "&folio=" + folio + "&correo=s&grupo=4";
				//Parametros = "?cdo=cdl&folio=1&serie=LELAN&correo=s";
				URL url= new URL("http://172.16.251.88:8080/wsSelladoCFDIv4cdokwx/comprobante/documento"+Parametros);
				//System.out.println("url:"+ url);
		        URLConnection urlConnection = url.openConnection();
		        urlConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
		        BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());    
		        byte[] contents = new byte[1024];

		        int bytesRead = 0;
		        String strFileContents=""; 
		        while((bytesRead = in.read(contents)) != -1) { 
		            strFileContents += new String(contents, 0, bytesRead);              
		        }

		        System.out.println("SERIE: "+serie+" FOLIO: "+folio+" "+strFileContents);
				rsp="true";
				
				return rsp;
			} catch (Exception ex) {
				// this.invocarVistaError(ex, uri, request, response);
			//	System.out.println("error uri : " + url);
				System.out.println("error consultaProcesosUsuario : " + ex);
				return rsp;
			}
	   }
}