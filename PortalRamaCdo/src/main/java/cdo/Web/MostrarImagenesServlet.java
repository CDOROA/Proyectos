package cdo.Web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MostrarImagenesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_BUFFER_SIZE = 10240;
	private String IMAGEN_PATH = "";   
	
	public void init() throws ServletException 
	{
		Properties proper = new Properties();
        try 
        {
            InputStream input =this.getClass().getClassLoader().getResourceAsStream("/properties/configuracion.properties");
            proper.load(input);  
            this.IMAGEN_PATH = proper.getProperty("IMG_PAG_INICIAL");
        }
        catch (IOException ex)
        {
        	String sError= ex.getMessage().toString();
        }
	}
  
    public MostrarImagenesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "-1"); // Proxies.
		mostrarImagen(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/******   MOSTRAR IMAGEN   ******/
	private void mostrarImagen(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		String requestedImage = request.getPathInfo();        
        if (requestedImage == null) 
        {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }
        File imagen =null;
        try
        {
        	imagen = new File(this.IMAGEN_PATH, URLDecoder.decode(requestedImage, "UTF-8"));
        }
        catch(Exception ex)
        {
        	//System.out.println("Error: " + ex.getMessage().toString());
        }
        
        if (!imagen.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }
        String contentType = getServletContext().getMimeType(imagen.getName());
        if (contentType == null || !contentType.startsWith("image")) 
        {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }
        response.reset();
        response.setBufferSize(DEFAULT_BUFFER_SIZE);
        response.setContentType(contentType);
        response.setHeader("Content-Length", String.valueOf(imagen.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + imagen.getName() + "\"");
       
        // Prepare streams.
        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try 
        {
            // Open streams.
            input = new BufferedInputStream(new FileInputStream(imagen), DEFAULT_BUFFER_SIZE);
            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

            // Write file contents to response.
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int length;
            while ((length = input.read(buffer)) > 0) 
            {
                output.write(buffer, 0, length);
            }
        } 
        finally 
        {
        	cerrarIamgen(output);
        	cerrarIamgen(input);
        }	
	}
	
	/******   CERRRA IMAGEN    ******/	
	private static void cerrarIamgen(Closeable resource)
	{
        if (resource != null) 
        {
            try 
            {
                resource.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
	

}
