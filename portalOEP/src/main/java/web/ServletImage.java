package web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletImage
 */
public class ServletImage extends HttpServlet {
	// private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = 8306532541569245956L;
	private static final int DEFAULT_BUFFER_SIZE = 10240;
	private String imagePath;
	 
	public void init() throws ServletException 
	{
	//   System.out.println("1.  ************* INICIA IMAGEN***********");
	   
		Properties proper = new Properties();
	        try 
	        {
	            InputStream in = this.getClass().getClassLoader().getResourceAsStream("/properties/oep.properties");	
	            proper.load(in);            
	            this.imagePath = proper.getProperty("RUTA_IMG_KWX");	
	         //  System.out.print("img: "+ this.imagePath);
	        }
	        catch (IOException ex)
	        {
	        	String sError= ex.getMessage().toString();
	        	System.out.println("PortalRama KWX - Error al cargar ruta imagenes ");
	        }
	}
	 
    public ServletImage() {
        super();
    }
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String requestedImage = request.getPathInfo();
        
        if (requestedImage == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }
        File image = new File(imagePath, URLDecoder.decode(requestedImage, "UTF-8"));
        
        if (!image.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }
        
        String contentType = getServletContext().getMimeType(image.getName());
        if (contentType == null || !contentType.startsWith("image")) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }
        response.reset();
        response.setBufferSize(DEFAULT_BUFFER_SIZE);
        response.setContentType(contentType);
        response.setHeader("Content-Length", String.valueOf(image.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + image.getName() + "\"");
        // Prepare streams.
        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            // Open streams.
            input = new BufferedInputStream(new FileInputStream(image), DEFAULT_BUFFER_SIZE);
            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

            // Write file contents to response.
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } finally {
            // Gently close streams.
            close(output);
            close(input);
        }
	}
	
	private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                // Do your thing with the exception. Print it, log it or mail it.
                e.printStackTrace();
            }
        }
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
