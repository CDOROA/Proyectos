package com.cordina.PortalCordinaKwx;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.cordina.PortalCordinaKwx.Correo.SendEmailQuieroSerDistribuidor;
import com.cordina.PortalCordinaKwx.Persistencia.PersistenciaQuieroSerDistrinuidor;
import com.cordina.PortalCordinaKwx.dto.DelegacionDto;
import com.cordina.PortalCordinaKwx.dto.EstadosDto;
import com.cordina.PortalCordinaKwx.dto.Pais;
import com.cordina.PortalCordinaKwx.dto.clientesKwxDto;
import com.cordina.PortalCordinaKwx.dto.productosKwxDto;
import com.google.gson.Gson;
public class ServletQuieroSerDistribuidor extends HttpServlet {
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
            this.RUTA_ARCHIVO =proper.getProperty("RUTA_IMG_KWX")+"quieroSerDistribuidor/";
         //   System.out.println("UploadFileServlet Ruta correcta: " + this.RUTA_ARCHIVO );
   		} 
   		catch  (Exception ex) 
   		{
   			ex.printStackTrace();
   			//Ruta = Ruta+"";
   			System.out.println("PortalRama KWX - ServletQuieroSerDistribuidor Ruta Exception: " + ex );
   		}	
	}
    
	
    public ServletQuieroSerDistribuidor() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

    	main(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		main(request,response);
	}

	@SuppressWarnings("unchecked")
	public void main(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			// System.out.println(" ServletDondeComprar 1. INICIO");
			int operacion = 1;
			int producto = 0;
			int estado = 0;
			int idPais = 0;
			int delegacion = 0;
			List<Pais> listPaises = new ArrayList<Pais>();
			//List<EstadosDto> listEstados= new ArrayList<EstadosDto>();
			List<productosKwxDto> lisArticulos = new ArrayList<productosKwxDto>();
			List<DelegacionDto> listDelegaciones= new ArrayList<DelegacionDto>();
			
			List<clientesKwxDto> listClientes= new ArrayList<clientesKwxDto>();
			
		 	//System.out.println("ServletDondeComprar 2. INICIO");
			
			try
			{
				operacion = Integer.parseInt(request.getParameter("operacion"));
			}
			catch(Exception ex)
			{
				String sError= ex.getMessage().toString();
				System.out.println("PortalRama KWX - ERROR: " + sError);
			}
			
		      //  System.out.println("ServletDondeComprar: INICIO OPERACION= " + operacion);
			
			switch(operacion)
			{
				case 1:
					listPaises = ObtenerPaises();
					// System.out.println("Distrinuidor ListaPaises: "+ listPaises.size());
					// System.out.println("Distrinuidor ListaPaises: "+ listPaises);
					request.setAttribute("listaPais", listPaises);
					RequestDispatcher rd = request.getRequestDispatcher("/jsp/QuieroSerDistribuidor.jsp");
					rd.forward(request, response);
				break;
				case 2:
					 
						ProcesaInformacion(request, response);
						subirArchivoAlServidor(request, response);
						EnviarCorreo(request, response);
						RequestDispatcher rd2 = request.getRequestDispatcher("/jsp/QuieroSerDistribuidor2.jsp");
						rd2.forward(request, response);
						break;
				case 3:
					List<DelegacionDto> listDelagaciones= new ArrayList<DelegacionDto>();
					try
					{ 
						estado = Integer.parseInt(request.getParameter("cve_estado"));
					}
					catch(Exception ex)
					{
						String sError= ex.getMessage().toString();
					}
					
					//System.out.println(" 4. ESTADO = " + estado);
					listDelagaciones = ObtieneDelgacionPorEstado(estado);
					//System.out.println(" 4. listDelagaciones = " + listDelagaciones);
					request.setAttribute("listDelagaciones", listDelagaciones);
					Gson gson = new Gson();
					String listaJson2 =gson.toJson(listDelagaciones);
					response.setContentType("application/json");
					PrintWriter out = response.getWriter();
					out.write(listaJson2);
					//System.out.println(" 5. LIST DEL = " + listDelagaciones.size());
					
					break;
				case 4:
					RequestDispatcher rd4 = request.getRequestDispatcher("/jsp/QuieroSerDistribuidor2.jsp");
					rd4.forward(request, response);
					break;
				case 5:
					List<EstadosDto> listEstados= new ArrayList<EstadosDto>();
					try
					{ 
						idPais = Integer.parseInt(request.getParameter("cve_pais"));
					}
					catch(Exception ex)
					{
						String sError= ex.getMessage().toString();
					}
					
					//System.out.println(" 4. ESTADO = " + estado);
					listEstados = ObtieneEstados(idPais);
					// System.out.println("Distrinuidor listEstados: "+ listEstados.size());
					request.setAttribute("listEstadosDistribuidor", listEstados);
					Gson gsonEstados = new Gson();
					String listaJsonEstados =gsonEstados.toJson(listEstados);
					response.setContentType("application/json");
					PrintWriter outEst = response.getWriter();
					outEst.write(listaJsonEstados);
					//System.out.println(" 5. LIST DEL = " + listDelagaciones.size());
				break;
			default:
				break;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error en QuieroSerDistribuidor main: " + ex);
			String sError= ex.getMessage().toString();
		}
	}
	
	private void EnviarCorreo(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			SendEmailQuieroSerDistribuidor.send(request, response);
		}
		catch(Exception ex)
		{
			System.out.println("Error al enviar correo Quiero ser Distribuidor Servlet: " + ex);
			
		}
	}


	private void ProcesaInformacion(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			//System.out.println("...1");
			String nombreNegocio = request.getParameter("nombreNegocio");
			String giro = request.getParameter("giro");
			String nombreContacto = request.getParameter("nombreContacto");
			String puesto = request.getParameter("puesto");
			String correo = request.getParameter("correo");
			String whatsApp = request.getParameter("whatsApp");
		//	System.out.println("...2");
			String cvePais = request.getParameter("cvePais");
			String cveEstado = request.getParameter("cveEstado");
			String municipio = request.getParameter("municipio");
			String codigoPostal = request.getParameter("codigoPostal");
			//System.out.println("...3");
			String fotografia = request.getParameter("fotografia");
			//System.out.println("...4");
			
			PersistenciaQuieroSerDistrinuidor persistenciaDist = new PersistenciaQuieroSerDistrinuidor();
			//System.out.println("...4.1");
			int respuesta = persistenciaDist.InsertaRegistroEnBD(nombreNegocio, giro, nombreContacto, puesto, correo, whatsApp, cvePais, cveEstado, municipio, codigoPostal, fotografia);
		//	System.out.println("...5 respuesta: " + respuesta); 

		}
		catch(Exception ex)
		{
			System.out.println("Error en QuieroSerDistribuidor.ProcesaInformacion: " + ex) ;
			String sError= ex.getMessage().toString();
		}
		
	}

	private List<DelegacionDto> ObtieneDelgacionPorEstado(int estado) {
		List<DelegacionDto> listMunic = new ArrayList<DelegacionDto>();
		try {
			PersistenciaQuieroSerDistrinuidor persistenciaDist = new PersistenciaQuieroSerDistrinuidor();
			listMunic = persistenciaDist.ConsultaMunicipios(estado);

		} catch (Exception ex) {
			
			String sError = ex.getMessage().toString();
		}
		return listMunic;
	}

 
	public List<Pais> ObtenerPaises() {
		List<Pais> listPaises = new ArrayList<Pais>();

		try {
			PersistenciaQuieroSerDistrinuidor persistenciaDist = new PersistenciaQuieroSerDistrinuidor();
			listPaises = persistenciaDist.ConsultaListaPaises();
		
			
		} catch (Exception ex) {
			
			String sError = ex.getMessage().toString();
			System.out.println("Querio ser distribuidor. ObtenerPaises.- error: " + ex);
		}
		
		return listPaises;
	}
	
	public List<EstadosDto> ObtieneEstados(int idPais) {
		List<EstadosDto> listEstados = new ArrayList<EstadosDto>();

		try {
			PersistenciaQuieroSerDistrinuidor persistenciaDist = new PersistenciaQuieroSerDistrinuidor();
			listEstados = persistenciaDist.ConsultaEstatos(idPais);
		
			
		} catch (Exception ex) {
			
			String sError = ex.getMessage().toString();
			System.out.println("Queri ser distribuidor. ObtieneEstados.- error: " + ex);
		}
		
		return listEstados;
	}
	
	  private String subirArchivoAlServidor(HttpServletRequest request, HttpServletResponse response) 
		{
			String nombreArchivo = "";
			System.out.println("ServletQuieroSerDistribuidor entro a UploadFileServlet");
			try
			{
				// Valida que el archivo seleccionado este en el request
							boolean isMultipart = ServletFileUpload.isMultipartContent(request);
							
							if (isMultipart) 
							{	
								try 
								{
	                              //  System.out.println("ServletQuieroSerDistribuidor 1.- crear fabrica para elementos de archivo basados en disco");
									DiskFileItemFactory factory = new DiskFileItemFactory();
								//	System.out.println("ServletQuieroSerDistribuidor 2.- crear un espacio en memoria para los archivos");
									factory.setSizeThreshold(MEMORY_THRESHOLD);
								//	System.out.println("ServletQuieroSerDistribuidor 3.- Coloca temporalmente el archivo en el servidor");
									factory.setRepository(new File(RUTA_ARCHIVO));
								//	System.out.println("ServletQuieroSerDistribuidor 4.- Crear un nuevo controlador de carga de archivos");
									ServletFileUpload upload = new ServletFileUpload(factory);
								//	System.out.println("ServletQuieroSerDistribuidor 5.- Establece el tamaño maximo del archivo");
									upload.setFileSizeMax(MAX_FILE_SIZE);
								//	System.out.println("ServletQuieroSerDistribuidor 6.- Establece el tamaño maximo de la solicitud (Inluye archivo y datos del fomulario)");
									upload.setSizeMax(MAX_REQUEST_SIZE);
									response.setContentType("text/html");
									PrintWriter out = response.getWriter( );
								//	System.out.println("ServletQuieroSerDistribuidor 7.-snaliza el contenido de la solicitud para extraer datos del archivo ");
									@SuppressWarnings("unchecked")
									List<FileItem> fileItems = upload.parseRequest(request);
									if (fileItems != null && fileItems.size() > 0) 
									{
								//		System.out.println("ServletQuieroSerDistribuidor 8.- Recorre los items del archivo");
										for (FileItem item : fileItems) 
										{
								//			System.out.println("ServletQuieroSerDistribuidor 9.-.Procesa cada uno de los items");
											
											if (!item.isFormField()) 
											{					
												nombreArchivo = new File(item.getName()).getName();							
												ARCHIVO = new File(RUTA_ARCHIVO.concat(nombreArchivo));								
												item.write( ARCHIVO );		
											}
										}
									}
								//	System.out.println("ServletQuieroSerDistribuidor 10.-Proceso terminado");
								}
								catch(Exception ex)
								{
									String sError= ex.getMessage().toString();
									System.out.println("ServletQuieroSerDistribuidor  multipart error:"+ sError);
								}
							}
			}
			catch(Exception ex)
			{
				String sError= ex.getMessage().toString();
				System.out.println("PortalRama KWX - Error en ServletQuieroSerDistribuidor.subirArchivoAlServidor"+ sError);
			}
			return nombreArchivo;
		}
	
}
