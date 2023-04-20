package com.cordina.PortalCordinaKwx;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.cordina.PortalCordinaKwx.Correo.SendEmailContactoNuevoMecanico;


public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	/*  Definicion de tamaño de archivos  */
	private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 2;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 2; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 2; // 50MB
    private  String RUTA_ARCHIVO  =  "";
    SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd-MM-yyyy");
   
              
    private File ARCHIVO;
    boolean SUBIO_ARCHIVO = false;
    
    public void init() throws ServletException 
	{
		Properties proper = new Properties();
        try 
        {
            InputStream input =this.getClass().getClassLoader().getResourceAsStream("/properties/kwx.properties");
            proper.load(input);  
            this.RUTA_ARCHIVO =proper.getProperty("RUTA_IMG_KWX")+"mecanicos/fachada/";
           // System.out.println("UploadFileServlet Ruta correcta: " + this.RUTA_ARCHIVO );
   		} 
   		catch  (Exception ex) 
   		{
   			ex.printStackTrace();
   			//Ruta = Ruta+"";
   			System.out.println("PortalRama KWX - UploadFileServlet Ruta Exception: " + ex );
   		}	
	}
    
    public UploadFileServlet() {
        super();
      
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.
   	
		 subirArchivoAlServidor(request, response);

		try{
    		String Estado = request.getParameter("cmbListaEstados");
			String Municipio = request.getParameter("cmbMunicipios");
			String Colonia = request.getParameter("txtColonia");
			String Cp = request.getParameter("txtCp");
			String Calle = request.getParameter("txtCalle");
			String NumExt = request.getParameter("txtNumExt");
			String NumInt = request.getParameter("txtNumInt");
			String NombreTaller = request.getParameter("txtNombreTaller");
			String NombreEncargado = request.getParameter("txtEncargado");
			String BrindaServisioDomicilio = request
					.getParameter("cmbBrindaServisioDomicilio");
			String Telefono = request.getParameter("txtTelefono");
			String Whatsapp = request.getParameter("txtWhatsapp");
			String Email = request.getParameter("txtEmail");
			String fotografia = request.getParameter("fotografia");
			String RecibirInfo = request.getParameter("chkRecibirInfo");
			String latitud = request.getParameter("lat");
			String longitud = request.getParameter("lon");
			
			String radio = request.getParameter("radio");
			String especialidad = request.getParameter("especialidad");
			
			//System.out.println("UploadFileServlet UploadFileServlet Estado: " + Estado);
			//System.out.println("UploadFileServlet UploadFileServlet Municipio: " + Municipio);
			//System.out.println("UploadFileServlet UploadFileServlet Colonia: " + Colonia);
			//System.out.println("UploadFileServlet UploadFileServlet Cp: " + Cp);
			//System.out.println("UploadFileServlet Calle: " + Calle);
			//System.out.println("UploadFileServlet NumExt:" + NumExt);
			//System.out.println("UploadFileServlet NumInt: " + NumInt);
			//System.out.println("UploadFileServlet NombreTaller: " + NombreTaller);
			//System.out.println("UploadFileServlet NombreEncargado: " + NombreEncargado);
			//System.out.println("UploadFileServlet BrindaServisioDomicilio: "
			//	+ BrindaServisioDomicilio);
			//System.out.println("UploadFileServlet Telefono: " + Telefono);
			//System.out.println("UploadFileServlet Whatsapp: " + Whatsapp);
			//System.out.println("UploadFileServlet Email: " + Email);
			//System.out.println("UploadFileServlet fotografia: " + fotografia);
			//System.out.println("UploadFileServlet RecibirInfo: " + RecibirInfo);
			//System.out.println("UploadFileServlet latitud: " + latitud);
			//System.out.println("UploadFileServlet longitud: " + longitud);
		
			SendEmailContactoNuevoMecanico.send(Estado, Municipio, Colonia, Cp,
					Calle, NumExt, NumInt, NombreTaller, NombreEncargado,
					BrindaServisioDomicilio, Telefono, Whatsapp, Email,especialidad, radio,
					fotografia, RecibirInfo, latitud, longitud);
					
			
    	}catch(Exception e)
    	{
    		System.out.println("PortalRama KWX - UploadFileServlet  1. INICIO UploadFileServlet error parametro= " + e	);
    	}

		redireccionarVista(request, response,"/ServletSoyMecanico?operacion=3");		
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
    private String subirArchivoAlServidor(HttpServletRequest request, HttpServletResponse response) 
	{
		String nombreArchivo = "";
	//	System.out.println("UploadFileServlet entro a UploadFileServlet");
		try
		{
			// Valida que el archivo seleccionado este en el request
						boolean isMultipart = ServletFileUpload.isMultipartContent(request);
						
						if (isMultipart) 
						{	
							try 
							{
                             //   System.out.println("UploadFileServlet 1.- crear fabrica para elementos de archivo basados en disco");
								DiskFileItemFactory factory = new DiskFileItemFactory();
								//System.out.println("UploadFileServlet 2.- crear un espacio en memoria para los archivos");
								factory.setSizeThreshold(MEMORY_THRESHOLD);
								//System.out.println("UploadFileServlet 3.- Coloca temporalmente el archivo en el servidor");
								factory.setRepository(new File(RUTA_ARCHIVO));
							//	System.out.println("UploadFileServlet 4.- Crear un nuevo controlador de carga de archivos");
								ServletFileUpload upload = new ServletFileUpload(factory);
								//System.out.println("UploadFileServlet 5.- Establece el tamaño maximo del archivo");
								upload.setFileSizeMax(MAX_FILE_SIZE);
							//	System.out.println("UploadFileServlet 6.- Establece el tamaño maximo de la solicitud (Inluye archivo y datos del fomulario)");
								upload.setSizeMax(MAX_REQUEST_SIZE);
								response.setContentType("text/html");
								PrintWriter out = response.getWriter( );
								//System.out.println("UploadFileServlet 7.-snaliza el contenido de la solicitud para extraer datos del archivo ");
								@SuppressWarnings("unchecked")
								List<FileItem> fileItems = upload.parseRequest(request);
								if (fileItems != null && fileItems.size() > 0) 
								{
									//System.out.println("UploadFileServlet 8.- Recorre los items del archivo");
									for (FileItem item : fileItems) 
									{
										//System.out.println("UploadFileServlet 9.-.Procesa cada uno de los items");
										
										if (!item.isFormField()) 
										{					
											nombreArchivo = new File(item.getName()).getName();							
											ARCHIVO = new File(RUTA_ARCHIVO.concat(nombreArchivo));								
											item.write( ARCHIVO );		
										}
									}
								}
							//	System.out.println("UploadFileServlet 10.-Proceso terminado");
							}
							catch(Exception ex)
							{
								String sError= ex.getMessage().toString();
								System.out.println("UploadFileServlet  error:"+ sError);
							}
						}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("PortalRama KWX - UploadFileServlet error en UploadFileServlet.subirArchivoAlServidor"+ sError);
		}
		return nombreArchivo;
	}
		
    private void redireccionarVista(HttpServletRequest request, HttpServletResponse response, String vista)
	{
		try
		{
			RequestDispatcher rdIndex = request.getRequestDispatcher(vista);			    	
		    rdIndex.forward(request, response);
		}
		catch(Exception ex)
		{
			System.out.println("PortalRama KWX - UploadFileServlet Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
}
