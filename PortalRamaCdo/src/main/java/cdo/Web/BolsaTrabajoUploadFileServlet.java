package cdo.Web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.json.Json;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import cdo.Datos.Aspirantes;
import cdo.Datos.Querys;
import cdo.Persistencia.GestorBolsaDeTrabajo;
import cdo.Persistencia.GestorPaginaPrincipal;


public class BolsaTrabajoUploadFileServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	/*  Definicion de tamaño de archivos  */
	private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    private  String RUTA_ARCHIVO  =  "";
    private  String WS_COMPRIMIR  =  "";
    SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd-MM-yyyy");
    private File ARCHIVO;
    boolean SUBIO_ARCHIVO = false;
    List<Querys> querys;
    String nombreVacante;
	String nivelAcademico;
	String estado;
    GestorPaginaPrincipal gestorInicial;
    private static  GestorBolsaDeTrabajo gestorBolsaTrabajo;
        
    /*  Definicion de propiedades para correo */
    private  static Properties propertiesMail = null;
    
    public void init() throws ServletException 
	{
		Properties proper = new Properties();
        try 
        {
            InputStream input =this.getClass().getClassLoader().getResourceAsStream("/properties/configuracion.properties");
            proper.load(input);  
            this.RUTA_ARCHIVO = proper.getProperty("CV_BOLSA_TRABAJO");
            this.WS_COMPRIMIR=proper.getProperty("WS_COMPRIMIR");
            propertiesMail = new Properties();
		    InputStream  inputStream  = this.getClass().getResourceAsStream("/properties/mail.properties");
		    propertiesMail.load(inputStream);
            
        }
        catch (IOException ex)
        {
        	String sError= ex.getMessage().toString();
        }
        
        
	}
       
    public BolsaTrabajoUploadFileServlet() {
        super();
        gestorBolsaTrabajo= new GestorBolsaDeTrabajo();
    	gestorInicial=new GestorPaginaPrincipal();
    	this.querys = null;
    	this.querys = gestorInicial.ConsultaTablaQuerysBD();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "-1"); // Proxies.
		HttpSession session = request.getSession(true);
		if(session != null)
		{
		//	System.out.println("BolsaTrabajoUploadFileServlet...1");
			Aspirantes aspirante =  (Aspirantes) session.getAttribute("aspirante");
			nombreVacante= (String) session.getAttribute("nombreVacante");
			nivelAcademico= (String) session.getAttribute("nivelAcademico");
			estado= (String) session.getAttribute("estado");
		//	System.out.println("BolsaTrabajoUploadFileServlet...2");
			String nombreArchivo = subirArchivoAlServidor(request, response, aspirante,nombreVacante, nivelAcademico,estado);
		//	System.out.println("BolsaTrabajoUploadFileServlet...3");
			
	//		System.out.println("BolsaTrabajoUploadFileServlet...4");
			//Files.deleteIfExists(Paths.get(RUTA_ARCHIVO.concat(nombreArchivo)));
		//	System.out.println("BolsaTrabajoUploadFileServlet...FIN");
		}
		redireccionarVista(request, response,"index.jsp");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
		
	private String subirArchivoAlServidor(HttpServletRequest request, HttpServletResponse response, Aspirantes asp, String nombreVacante,String nivelAcademico, String estado) 
	{
		String nombreArchivo = "";
		try
		{
			// Valida que el archivo seleccionado este en el request
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) 
			{	
				try 
				{
					//1. Crear una fábrica para elementos de archivo basados ​​en disco
					DiskFileItemFactory factory = new DiskFileItemFactory();
					
					//2.crea un espacio en memoria para los archivos
					factory.setSizeThreshold(MEMORY_THRESHOLD);
					
					//3.Coloca temporalmente el archivo en el servidor 
					factory.setRepository(new File(RUTA_ARCHIVO));
					
					//4.Crear un nuevo controlador de carga de archivos
					ServletFileUpload upload = new ServletFileUpload(factory);
					
					//5.Establece el tamaño máximo del archivo de carga
					upload.setFileSizeMax(MAX_FILE_SIZE);
					
					//6.Establece el tamaño máximo de la solicitud (incluye archivo + datos del formulario)
					upload.setSizeMax(MAX_REQUEST_SIZE);
					response.setContentType("text/html");
					
					PrintWriter out = response.getWriter( );
					
					//7. Analiza el contenido de la solicitud para extraer datos del archivo
					List<FileItem> fileItems = upload.parseRequest(request);
					
					if (fileItems != null && fileItems.size() > 0) 
					{
						//8.Recorre los items del archivo
						for (FileItem item : fileItems) 
						{ 							
							//9.Procesa cada uno de los items
							if (!item.isFormField()) 
							{				
								nombreArchivo = new File(item.getName()).getName();
								nombreArchivo=nombreArchivo.replaceAll(" ", "");
								ARCHIVO = new File(RUTA_ARCHIVO.concat(nombreArchivo));	
								item.write( ARCHIVO );		
							}
						}
					}
//					 try {
//					      File file = new File(RUTA_ARCHIVO.concat(nombreArchivo));
//					      byte [] bytes = Files.readAllBytes(file.toPath());
//					      File txt=new File(RUTA_ARCHIVO.concat(nombreArchivo));//.replace(".pdf", ".txt")));
//					      FileWriter escribir=new FileWriter(txt,true);
//					      String b64 = Base64.getEncoder().encodeToString(bytes);
//					      escribir.write(b64);
//					      escribir.close();
//					      //comprimirTxt(nombreArchivo);
//					     
//					    } catch (Exception e) {
//					      e.printStackTrace();
//					    }
					 enviarVacantePorCorreo(asp, RUTA_ARCHIVO.concat(nombreArchivo), nombreArchivo);
					 subeArchivo(nombreArchivo, asp, nombreVacante, nivelAcademico,estado);
				} 
				catch(Exception ex)
				{
					ex.printStackTrace();
					throw new ServletException();
				}
			}
			else 
			{
				throw new Exception();
			}
		}
		catch(Exception ex)
		{
			String sError= ex.getMessage().toString();
			System.out.println("NuevoportalRamaCDO.- Error al BolsaTrabajoUploadFileServlet.subirArchivoAlServidor: " + ex);
		}
		return nombreArchivo;
	}

	private boolean enviarVacantePorCorreo(Aspirantes aspirante ,String rutaArchivoCV, String nombre_archivo)
	{
		String correoEmisor = propertiesMail.getProperty("mail.login.username");
		String correoReceptor = propertiesMail.getProperty("email.recursos.humanos.rama");
		String correoHost = propertiesMail.getProperty("mail.smtp.host");
		String correoPass=  propertiesMail.getProperty("mail.login.password");

		String asunto = "Candidato para la vacante de: " + aspirante.getNombre_vacante();
		
		String contenidoDelMensaje = "VACANTE: "  +aspirante.getNombre_vacante() + 
					"\n\nNombre: "+ aspirante.getNombre() + " " + aspirante.getA_paterno() + " " + aspirante.getA_materno() +
					"\nEmail: " + aspirante.getE_mail() + "\nEdad: " + aspirante.getEdad() + "\nTelefono: " + aspirante.getTelefono() +
					"\nGenero: " + aspirante.getGenero() + "\nNivel Academico: " + aspirante.getNombre_nAcademico() + "\nEstado: " + aspirante.getNombre_Estado() + "."+
					"\n\nCandidato registrado por https://www.cdoautopartes.com.mx/ " ;
		   
		Properties props = System.getProperties();
	    props.put("mail.smtp.host", correoHost);
	    props.put("mail.smtp.auth", "true"); 
	    props.put("mail.smtp.starttls.enable", "true"); 
	    props.put("mail.smtp.port", "587"); 
	    
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);
	    File file = new File(rutaArchivoCV);
	    try 
	  	{
	        BodyPart texto = new MimeBodyPart();
	        texto.setText(contenidoDelMensaje);
	         
	    	BodyPart adjunto = new MimeBodyPart();
	    	adjunto.setDataHandler(new DataHandler(new FileDataSource(file)));
			adjunto.setFileName(nombre_archivo);
            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);
            
	        message.setFrom(new InternetAddress(correoEmisor));
	        message.addRecipients(Message.RecipientType.TO, correoReceptor);
	        message.setSubject(asunto);
	        message.setContent(multiParte);
	        //session.setDebug(true);
	        //message.setContent(contenidoDelMensaje, "text/html");
	        Transport transport = session.getTransport("smtp");
	        transport.connect(correoEmisor,correoPass);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	        
	        return true;
	    }
	    catch (Exception me)
	    {
	        me.printStackTrace();  
	        
	        System.out.println("NuevoportalRamaCDO.- Error BolsaTrabajoUploadFileServlet.enviarVacantePorCorreo: " + me);
	    }
	    return false;
	}
	
	private String generarContenidoDeCorreoVacante(Aspirantes aspirante,String nombreVacante, String nivelAcademico, String estado ) 
	{		
		String sFechaHoraSistema = "";
		String contenidoDelMensaje = "";
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy hh:mm:ss aaa");
		Date fechaHoraSistema = Calendar.getInstance().getTime();
		sFechaHoraSistema = formatter.format(fechaHoraSistema);		
		
		contenidoDelMensaje += "<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\" pageEncoding=\"ISO-8859-1\"%>";
		contenidoDelMensaje += "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
		contenidoDelMensaje += "<html>";
		contenidoDelMensaje += "<b><font size =\"12px\" face=\"Arial\" color=#004099>" + sFechaHoraSistema + "</font><br><br>";
		contenidoDelMensaje += "<font size =\"18px\" face=\"Arial\" color=#004099>" + nombreVacante+ "</font></b><br><br>";
		contenidoDelMensaje += "<b><font size =\"12px\" face=\"Arial\" color=black>Nombre: </font></b>";
		contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>" +aspirante.getNombre()+ " " +aspirante.getA_paterno()+ " "+aspirante.getA_materno()+ "</font><br>";		
		contenidoDelMensaje += "<b><font size =\"12px\" face=\"Arial\" color=black>Edad:</font></b>";
		contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>" +aspirante.getEdad()+ "</font><br>";		
		contenidoDelMensaje += "<b><font size =\"12px\" face=\"Arial\" color=black>G&eacute;nero: </font></b>";
		contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>" +aspirante.getGenero()+ "</font><br>";
		contenidoDelMensaje += "<b><font size =\"12px\" face=\"Arial\" color=black>Tel&eacute;fono: </font></b>";
		contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>" +aspirante.getTelefono()+ "</font><br>";
		contenidoDelMensaje += "<b><font size =\"12px\" face=\"Arial\" color=black>E-mail: </font></b>";
		contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>" +aspirante.getE_mail()+ "</font><br>";
		contenidoDelMensaje += "<b><font size =\"12px\" face=\"Arial\" color=black>Nivel Acad&eacute;mico: </font></b>";
		contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>" +nivelAcademico+ "</font><br>";
		contenidoDelMensaje += "<b><font size =\"12px\" face=\"Arial\" color=black>Estado:</font></b>";	
		contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=black>" +estado+ "</font><br><br>";
		contenidoDelMensaje += "<font size =\"12px\" face=\"Arial\" color=#004099>Candidato registrado por www.cdoautopartes.com.mx</font><br><br>";
		
		contenidoDelMensaje += "</html>";
		return contenidoDelMensaje;
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
			//System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
	
	private void  comprimirTxt(String nombreArchivo)
	{
		
		try
		{
			URL url = new URL(WS_COMPRIMIR  + "?nombre="+nombreArchivo.replace(".pdf", "")+"&ruta="+RUTA_ARCHIVO);	
			System.out.println(url);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        

	        if (conn.getResponseCode() != 200) 
	        {	
	        	File file= new File(RUTA_ARCHIVO+nombreArchivo); 
	        	System.out.println("[NuevoportalRamaCDO.- Error: WScomprime ,  Clase: Bolsa Trabajo,  Detalle: " + conn.getResponseCode() +"]");
	        	file.delete();
	        	
            }
	        else
	        {
	        	 conn.connect();	 
	 			 
	        }
	        conn.disconnect();
	        //estadoCuentaGeneral.setListFacturasDia(listFacturasDelDia);
		}
		catch(Exception ex)
		{
			System.out.println("[NuevoportalRamaCDO.- Error: WScomprime ,  Clase: Bolsa Trabajo,  Detalle: " + ex.getMessage().toString() +"]");
			//Log log=new Log(1,infoCliente.getCve_cdo(),infoCliente.getCve_cliente() ,0, "[Error: Invocar wsFacturas para facturas del dia,  Clase: GestorEstadoDeCuenta,  Detalle: " + ex.getMessage().toString() +"]");
			//Cls_Log.insertaLog(log);
		}
		 
		//return estadoCuentaGeneral;
	}
	private void subeArchivo(String nombreArchivo, Aspirantes asp, String nombreVacante,String nivelAcademico,String estado) {
		//nombreArchivo=nombreArchivo.replace(".pdf", "");
		boolean aspiranteEnviado=false;
		File originalFile = new File(RUTA_ARCHIVO+nombreArchivo);//+".zip");
		String encodedBase64 = " ";
		try {
			byte[] bytes = Files.readAllBytes(originalFile.toPath());
			encodedBase64 = Base64.getEncoder().encodeToString(bytes);
			//System.out.print(encodedBase64);
			originalFile.delete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		asp.setCodigoCv(encodedBase64);
		aspiranteEnviado = gestorBolsaTrabajo.altaAspirantesBD(this.querys, asp,nombreVacante, nivelAcademico, estado);
	}

	
}
