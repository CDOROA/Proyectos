package cdo.Web;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cdo.Datos.LogAlmacen;
import cdo.Datos.Querys;
import cdo.Datos.Usuario;
import cdo.Persistencia.GestorDatosUsuario;
import cdo.util.InsertarLogAlamacen;


public class ServidorUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ArchivoConfiguracion = "./configuracion.txt";
	GestorDatosUsuario gestorUsuario = new GestorDatosUsuario();
    GestorDatosUsuario gestorDatosUsuario = new GestorDatosUsuario();
	Map<String,String> mapaCdos;
	
     
  
	public ServidorUsuarioServlet() {
        super();
        this.mapaCdos = new TreeMap<>();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "-1"); // Proxies.

		
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
				String vista = (validaCredencialesDeUsuario(request, session)) ? "Monitor.jsp" : "Inicio.jsp";
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
	@SuppressWarnings("static-access")
	public void ObtieneCentros( HttpSession session, HttpServletRequest request)
	{
		try
		{
			this.mapaCdos = this.gestorUsuario.ObtieneCentros(ArchivoConfiguracion);
		}
		catch(Exception ex)
		{
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
	@SuppressWarnings("static-access")
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
	@SuppressWarnings("static-access")
	public void inicializaVariablesSession(Usuario infoUsu,  HttpSession session, String cdo)
	{
	
		String msj="";
		Gson gson = new Gson();
		session.setAttribute("msj", msj);
		session.setAttribute("querys", gestorUsuario.ConsultaTablaQuerysBD(infoUsu.getUname()));
		List<Querys> querys = (List<Querys>) session.getAttribute("querys");
		session.setAttribute("infoUsu", infoUsu);
		session.setAttribute("nivelUsu", infoUsu.getNivel_usuario());
		session.setAttribute("session_br", infoUsu.getUname_br());
		session.setAttribute("cdo", cdo);
		session.setAttribute("regionales", gestorDatosUsuario.obtenerRegionales(infoUsu,querys));
		session.setAttribute("regionales2", gestorDatosUsuario.obtenerRegionales2(infoUsu,session));
		session.setAttribute("tituloRegionales", gestorDatosUsuario.tituloRegionales(infoUsu,querys,session));
		
		if (infoUsu.getNivel_usuario() != 3)
		{
			session.setAttribute("hora", gestorDatosUsuario.obtenerHora(infoUsu.getUname(),session,querys,infoUsu));
			session.setAttribute("series", gestorDatosUsuario.obtenerSeries(infoUsu.getUname(),querys,infoUsu));
			session.setAttribute("choferes", gestorDatosUsuario.obtenerChoferes(infoUsu.getUname(),querys,infoUsu));
			session.setAttribute("trans", gestorDatosUsuario.obtenerTransportes(infoUsu.getUname(),querys,infoUsu));
			session.setAttribute("impresora", gestorDatosUsuario.obtenerImpresora(querys,infoUsu));
			session.setAttribute("clientesCredito", gestorDatosUsuario.obtenerClientesCredito(querys,infoUsu));
			session.setAttribute("rutasChofer", gestorDatosUsuario.obtenerRutas(querys,infoUsu));
			session.setAttribute("vehiculos", gestorDatosUsuario.obtenerVehiculos(querys,infoUsu));
			session.setAttribute("rutasParse", gson.toJson(session.getAttribute("rutasChofer")).replace("\"", "*"));
			
		}
		
		
		
		String computerName = "";
		try
		{
			computerName = InetAddress.getLocalHost().getHostName();
			session.setAttribute("maquina",computerName);
		}
		catch (Exception e) 
		{
			session.setAttribute("maquina", "");
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al obtener nombre de la maquina. DETALLE: "+Error(e),infoUsu.getCve_usuario());
		}
		
		
		String n = "";
		try
		{
		n = System.getProperty("user.name");
		session.setAttribute("name",n);
		}
		catch (Exception e) 
		{
			session.setAttribute("name","");
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al obtener nombre de la usuario. DETALLE: "+Error(e),infoUsu.getCve_usuario());
		}
		
		
		InetAddress address = null;
		try 
		{
			address = InetAddress.getLocalHost();
			session.setAttribute("ip",address);
			
		} catch (UnknownHostException e) 
		{
			session.setAttribute("ip","");
			InsertarLogAlamacen.insertarLog(new LogAlmacen("","",""),infoUsu.getUname(),infoUsu.getUname_br(),"Error al obtener ip. DETALLE: "+Error(e),infoUsu.getCve_usuario());
		}
	        
		
	}
	
	private String Error(Exception e) 
	{
		return e.toString().replace("'", "´");
	}
	
}

