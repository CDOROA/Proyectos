package com.cordina.PortalCordinaKwx;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpenPdfDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String PDFPath;
	public void init() throws ServletException 
	{
	   //System.out.println("1.  ************* INICIA PDF***********");
	   
		Properties proper = new Properties();
	        try 
	        {
	            InputStream in = this.getClass().getClassLoader().getResourceAsStream("/properties/kwx.properties");	
	            proper.load(in);            
	            this.PDFPath = proper.getProperty("RUTA_IMG_KWX");	
	        
	        }
	        catch (IOException ex)
	        {
	        	String sError= ex.getMessage().toString();
	        }
	}
    public OpenPdfDemo() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		 String requestedPdf = request.getPathInfo();
			response.setContentType("text/html;charset=UTF-8");
			ServletOutputStream  outs =  response.getOutputStream ();
		
			response.setContentType( "application/pdf" ); 
		
			File file=new File(PDFPath, URLDecoder.decode(requestedPdf, "UTF-8"));
			
			response.setHeader("Content-disposition","inline; filename=" +"Folleto.pdf" );
			BufferedInputStream  bis = null; 
			BufferedOutputStream bos = null;
			try {
			InputStream isr=new FileInputStream(file);
			bis = new BufferedInputStream(isr);
			bos = new BufferedOutputStream(outs);
			byte[] buff = new byte[2048];
			int bytesRead;
			
			while(-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
			}
			} 
			catch(Exception e)
			{
			System.out.println("PortalRama KWX - Error: "+e);
			} finally {
			if (bis != null)
			bis.close();
			if (bos != null)
			bos.close();
			}
			
	}

}
