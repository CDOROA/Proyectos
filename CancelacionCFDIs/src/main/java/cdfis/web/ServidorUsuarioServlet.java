package cdfis.web;


import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cdfis.Datos.Usuario;
import cdfis.Datos.DatosCancelacion;
import cdfis.Datos.DatosTemporales;
import cdfis.Datos.Querys;
import cdfis.Persistencia.GestorCancelacionCfdi;
import cdfis.Persistencia.GestorDatosUsuario;


public class ServidorUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ArchivoConfiguracion = "./configuracion.txt";
	GestorDatosUsuario gestorUsuario;
    GestorDatosUsuario gestorDatosUsuario = new GestorDatosUsuario();
    GestorCancelacionCfdi gestorCancelacioncfdi;
	Map<String,String> mapaCdos;
	List<Querys> querys;
     
    public ServidorUsuarioServlet() {
        super();
        this.mapaCdos = new TreeMap<>();
        gestorCancelacioncfdi = new GestorCancelacionCfdi();
       
        this.querys = gestorUsuario.ConsultaTablaQuerysBD("cdf");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);		
		String vistaOrigen= String.valueOf(request.getParameter("vista"));
		VerificaPeticionOrigen(request,response,vistaOrigen, session);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
		
	/*** Metodo inicial para identificar el origen de la peticion ***/
	public void VerificaPeticionOrigen(HttpServletRequest request, HttpServletResponse response, String vistaOrigen,HttpSession session)
	{		
		try
		{
			if(vistaOrigen.equals("Inicio.jsp"))
			{
				String vista = (validaCredencialesDeUsuario(request, session)) ? "Cancelacion.jsp" : "Inicio.jsp";
				RedireccionarVista(request, response, vista);
			}
			if(vistaOrigen.equals("Salir.jsp"))
			{
				if (session != null) {
			
				    session.invalidate();
				    RequestDispatcher rdIndex = request.getRequestDispatcher("index.jsp");			    	
				    rdIndex.forward(request, response);
				}
			}
			else
			{
				ObtieneCentros(session,request);
				RedireccionarVista(request, response, "Inicio.jsp");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener la petición origen." + ex.getMessage().toString());
		}
	}
		
	
	/*** Obtiene Centro de archivo de configuracion ***/
	public void ObtieneCentros( HttpSession session, HttpServletRequest request)
	{
		try
		{
			this.mapaCdos = this.gestorUsuario.ObtieneCentros(ArchivoConfiguracion);
		}
		catch(Exception ex)
		{
			System.out.println("Error al obtener los CDOs." + ex.getMessage().toString());
		}
		
		session.setAttribute("mapaCdos", this.mapaCdos);
		session.setAttribute("mensaje_respuesta", "");
	}
	
	
	/**** Reidrecciona a la pagina correspondiente ***/
	public void RedireccionarVista(HttpServletRequest request, HttpServletResponse response, String vista)
	{
		try
		{
			RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + vista);			    	
		    rdIndex.forward(request, response);
		}
		catch(Exception ex)
		{
	//		System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
	
	
	/*** Verifica si los datos de acceso del usuario son validos ***/
	public boolean validaCredencialesDeUsuario(HttpServletRequest request, HttpSession session)
	{
		 String mensajeRespuesta = "";
		 boolean credencialesCorrectas = false;
		
		 int valorIncorreto = validaDatosCapturados(request);	
		 	 
		 if(valorIncorreto > 0)
		 {
			 mensajeRespuesta =  GeneraMsjRespuesta(valorIncorreto);
		 }
		 else
		 {			 
			 String cdo= request.getParameter("cdo_macro");			 
			 Usuario infoUsuario = gestorUsuario.consultaInformacionDeUsuarioBD(request.getParameter("usuario").toUpperCase(), request.getParameter("password"),cdo );
					 
			 if(infoUsuario.getCve_usuario() != "" && infoUsuario.getCve_usuario() != null)
			 {
				 inicializaVariablesSession(infoUsuario, session, cdo);
				 return true;
			 }
			 else
			 {
				 mensajeRespuesta = GeneraMsjRespuesta(6);
			 }
		 }
		 session.setAttribute("mensaje_respuesta", mensajeRespuesta);
		 return credencialesCorrectas;
	}
		
	public int validaDatosCapturados(HttpServletRequest request)
	{
		try
		{
			if(request.getParameter("usuario").toString().length() <= 0)
				return 1;
			
			if(request.getParameter("password").toString().length() <= 0)
				return 2;
			
			if(request.getParameter("cdo_macro").toString().length() <= 0)
				return 3;
			
			if(request.getParameter("proceso_web").toString().length() <= 0)
				return 4;
		}
		catch(NullPointerException exa)
		{
			System.out.println("Datos Incorrectos: " + exa.getMessage());
			return 5;
		}
		return 0;
	}
				
	public String GeneraMsjRespuesta(int valor)
	{
		String msg = "";
		
		switch(valor)
		{
			case 1:
				msg = "El usuario no puede quedar vacío.";
				break;
			case 2:
				msg = "La contraseña no puede quedar vacía.";
				break;
			case 3:
				msg = "Selecciona un CDO valido.";
				break;
			case 4:
				msg = "Indicar el número de proceso del sistema.";
				break;				
			case 5:
				msg = "Los datos ingresados son incorrectos.";
				break;
			case 6:
				msg = "El usuario o contraseña no validos.";
				break;
		}
		return msg;
	}
	
	/******* Consulta informacion inicial para al menu del sistema *******/		
	public void inicializaVariablesSession(Usuario infoUsu,  HttpSession session, String cdo)
	{
		
		
		String msj="";
		session.setAttribute("msj", msj);
		session.setAttribute("querys", this.querys);
		session.setAttribute("infoUsu", infoUsu);
		String mostrarFactura="";
		session.setAttribute("mostrarFactura", mostrarFactura);
		List<DatosTemporales> datosTemporales = new ArrayList<>();
		session.setAttribute("listaConsultaNota", datosTemporales);
		session.setAttribute("cdo", cdo);
	}
}

