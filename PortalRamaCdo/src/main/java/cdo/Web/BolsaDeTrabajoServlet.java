package cdo.Web;

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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

import cdo.Datos.Aspirantes;
import cdo.Datos.Querys;
import cdo.Datos.Sucursales;
import cdo.Datos.Vacantes;
import cdo.Persistencia.GestorBolsaDeTrabajo;
import cdo.Persistencia.GestorPaginaPrincipal;



public class BolsaDeTrabajoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static  GestorBolsaDeTrabajo gestorBolsaTrabajo;
	GestorPaginaPrincipal gestorInicial;
	List<Querys> querys;
	/*  Definicion de tamaño de archivos  */
	private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    private  String RUTA_ARCHIVO  =  "";
    SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd-MM-yyyy");
    private File ARCHIVO;
    boolean SUBIO_ARCHIVO = false;
	
	
	public void init() throws ServletException 
	{
		Properties proper = new Properties();
        try 
        {
            InputStream input =this.getClass().getClassLoader().getResourceAsStream("/properties/configuracion.properties");
            proper.load(input);  
            this.RUTA_ARCHIVO = proper.getProperty("CV_BOLSA_TRABAJO");
        }
        catch (IOException ex)
        {
        	String sError= ex.getMessage().toString();
        }
	}
  
    public BolsaDeTrabajoServlet() {
        super();
        gestorBolsaTrabajo= new GestorBolsaDeTrabajo();
    	gestorInicial=new GestorPaginaPrincipal();
    	this.querys = null;
    	this.querys = GestorPaginaPrincipal.ConsultaTablaQuerysBD();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "-1"); // Proxies.
		verificaPeticionOrigen(request,response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void verificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String vistaOrigen= String.valueOf(request.getParameter("vista"));
		String operacion= String.valueOf(request.getParameter("operacion"));
		Gson gson = new Gson();
		
		switch(vistaOrigen)
		{
			case "PaginaPrincipal.jsp":
					
				switch(operacion)
				{
					case "ConsultaVacantesxEdo":
						List<Vacantes> ListVacantes = consultaBolsaDeTrabajo(request);
						String listaJson = gson.toJson(ListVacantes);
						enviarRespuestaJsonJS(request,response, listaJson);
						break;	
					
					case "AltaAspirante":						
						boolean respuesta= altaAspirantesBD(request,response, this.RUTA_ARCHIVO);
						enviarRespuestaTextoJS(request,response, String.valueOf(respuesta));
						break;

				}
									
			break;
		}
	}	
	
	
	/******   CONUSULTA BOLSA DE TRABAJO    ******/	
	private List<Vacantes> consultaBolsaDeTrabajo(HttpServletRequest request)
	{
		String cve_edo= String.valueOf(request.getParameter("cve_edo"));
		List<Vacantes> ListVacantes = gestorBolsaTrabajo.consultaVacantesXEstado(this.querys, cve_edo);	
		return ListVacantes;
	}
	
	/******   ALTA ASPIRANTES   ******/
	private boolean altaAspirantesBD(HttpServletRequest request, HttpServletResponse response, String rutaArchivoCV)
	{	
		boolean aspiranteEnviado=false;
		Aspirantes aspirante = new Aspirantes(	ponerTilde(request.getParameter("nombre")),
												ponerTilde(request.getParameter("a_paterno")),
												ponerTilde(request.getParameter("a_materno")),
												request.getParameter("e_mail"),
												Integer.parseInt(request.getParameter("edad")),
												request.getParameter("telefono"),
												request.getParameter("genero"),
												Integer.parseInt(request.getParameter("id_nivel_ac")),
												Integer.parseInt(request.getParameter("id_cve_edo")),
												Integer.parseInt(request.getParameter("id_cve_empresa")),
												Integer.parseInt(request.getParameter("id_vacante")),
												request.getParameter("nombreVacante"),
												request.getParameter("nivelAcademico"),
												request.getParameter("estado"));
		String nombreVacante= ponerTilde(request.getParameter("nombreVacante"));
		String nivelAcademico= request.getParameter("nivelAcademico");
		String estado= request.getParameter("estado");
		//aspiranteEnviado = gestorBolsaTrabajo.altaAspirantesBD(this.querys, aspirante,nombreVacante, nivelAcademico, estado, rutaArchivoCV);
		aspiranteEnviado = true;
		if(aspiranteEnviado)
		{
			HttpSession anteriorSession = request.getSession(false);
	        if (anteriorSession != null)
	        	anteriorSession.invalidate();
	        HttpSession session = request.getSession(true);
			if(session != null)
			{
				session.setAttribute("aspirante", aspirante);
				session.setAttribute("nombreVacante", nombreVacante);
				session.setAttribute("nivelAcademico", nivelAcademico);
				session.setAttribute("estado", estado);
			}
		}
		return aspiranteEnviado;	
	}
		
	
	/******  RESPUESTAS   AJAX  ******/	
	private void enviarRespuestaJsonJS(HttpServletRequest request, HttpServletResponse response, String listaJson)
	{
		try
		{
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(listaJson);	
		}
		catch(Exception ex)
		{
			//System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}

	private void enviarRespuestaTextoJS(HttpServletRequest request, HttpServletResponse response, String respuesta)
	{
		try
		{
			PrintWriter out = response.getWriter();
		    out.write(respuesta);
		}
		catch(Exception ex)
		{
		//	System.out.println(URL_ACTUALIZA_MENSAJES_WWW"Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
	private String ponerTilde(String palabra) {
		String[] letras= {"a1","A2","e1","E2","i1","I2","o1","O2","u1","U2","n1","N2"};
		String[] codigo= {"á","Á","é","É","í","Í","ó","Ó","ú","Ú","ñ","Ñ"};
		for (int i = 0; i < letras.length; i++) {
			   palabra=palabra.replaceAll(letras[i],codigo[i]);
			}
		return palabra;
		
	}

}
