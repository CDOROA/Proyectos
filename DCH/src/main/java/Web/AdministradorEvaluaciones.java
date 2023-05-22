package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import Datos.Areas;
import Datos.Correo;
import Datos.Empleados;
import Datos.Evaluacion;
import Datos.Evaluado;
import Datos.Querys;
import Datos.Usuario;
import Persistencia.GestorEvaluaciones;
import Persistencia.GestorResultados;
 
public class AdministradorEvaluaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AdministradorEvaluaciones() {
        super();
     
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session!=null)
		{
			request.setAttribute("nombre", session.getAttribute("nombre"));
			request.setAttribute("nombreCdo", session.getAttribute("nombreCdo"));
			request.setAttribute("departamento", session.getAttribute("departamento"));
			request.setAttribute("uname", session.getAttribute("uname"));
			validaPeticion(request, response, session);
	    }  
		else  
			if(session == null)
			{
				RequestDispatcher rdIndex = request.getRequestDispatcher("/inicio.jsp");			    	
				rdIndex.forward(request, response);
			}
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

	private void validaPeticion(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		 try {
			// System.out.println("ruta de proyecto:" + this.getServletContext().getRealPath("Images")); ;
			 @SuppressWarnings("unchecked")
			List<Querys> listaQuerys = (List<Querys>) session.getAttribute("querys");
			 String accion = String.valueOf(request.getParameter("accion"));
			 JSONObject listaEvaluacionesJson = new JSONObject();	
			  //System.out.println("accion:" + accion);
					switch (accion) {
					case "Inicio":
						session.setAttribute("accionServlet", "1");
						RedireccionarVista(request, response, "/AdministradorEvaluaciones.jsp");
						break;
					case "Cargar":
						listaEvaluacionesJson=consultaEvaluaciones(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargarAreas":
						listaEvaluacionesJson=consultaAreas(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						
						break;
					case "CargarEmpleados":
						listaEvaluacionesJson=consultaEmpleados(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargarEmpleadosEv":
						listaEvaluacionesJson=consultaEmpleadosEv(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargarEmpleadosEvS":
						listaEvaluacionesJson=consultaEmpleadosEvS(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargarEmpleadosC":
						listaEvaluacionesJson=consultaEmpleadosEvC(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargarEmpleadosCli":
						listaEvaluacionesJson=consultaEmpleadosEC(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "CargarEvaluados":
						listaEvaluacionesJson=consultaEvaluados(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "GuardarDatos":
						listaEvaluacionesJson=guardaDatos(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "BorrarDatos":
						listaEvaluacionesJson=BorraDatos(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "EnviarCorreo":
						listaEvaluacionesJson=EnviarCorreo(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "ConsultaEvaluaciones":
						listaEvaluacionesJson=consultaNumEvaluaciones(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "GeneraEncuestas":
						listaEvaluacionesJson=generaNuevaEncuesta(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
						
					}
		 }
		 catch(Exception ex)
		 {
	
		 }
		}
		



	private JSONObject generaNuevaEncuesta(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonResultado = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String numEncuestas=request.getParameter("numEncuestas");
		String nombre=request.getParameter("nombre");
		String idEvaluacion=request.getParameter("idEvaluacion");
		String fechaFin=request.getParameter("fechaFin");
		boolean valida=GestorEvaluaciones.generaNuevaEncuesta(listaQuerys,cdo,infoUsu,numEncuestas,nombre,fechaFin,idEvaluacion);
		
		JsonResultado.put("valida",valida);
		
		return JsonResultado;
	}
	
	private JSONObject consultaNumEvaluaciones(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonEmpleadosEv = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		int numEvaluaciones =  gstorEvaluaciones.consultaNumEvaluaciones(listaQuerys, cdo,infoUsu);
		
		JsonEmpleadosEv.put("numEvaluaciones",numEvaluaciones);
		
		return JsonEmpleadosEv;
		
	}


	private JSONObject EnviarCorreo(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject JsonEmpleadosEv = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		String idEmpleado=request.getParameter("idEmpleado");
		GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		Correo correo =  gstorEvaluaciones.enviarCorreo(listaQuerys, cdo,idEmpleado,infoUsu);
		//System.out.println(idEmpleado);
		//String tmp=request.getParameter("valida");
		boolean valida=true;
		if(request.getParameter("valida")==null||request.getParameter("valida").equals("false")) {
			valida=false;
		}
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "10.0.0.112");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.port","587");
		props.setProperty("mail.smtp.auth", "true");
			
		try {
			if(correo.getEstatus()==0||valida) {
			Session session2 = Session.getDefaultInstance(props, null);
			//session.setDebug(true);
			BodyPart texto = new MimeBodyPart();
			texto.setText(correo.getCuerpo());
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			MimeMessage message = new MimeMessage(session2);
			//message.setHeader("Content-Type", "text/html");
			// Se rellena el From
			message.setFrom(new InternetAddress("webadmin@cdoautopartes.com.mx"));
	
			// Se rellenan los destinatarios
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo.getDestinatario()));
	
			// Se rellena el subject
			message.setSubject("Evaluacion 360°");
	
			// Se mete el texto y el archivo adjunto.
			message.setContent(multiParte, "text/html;charset=UTF-8;");
			message.saveChanges();
			Transport t = session2.getTransport("smtp");
			t.connect("webadmin@cdoautopartes.com.mx","3at0pX7L");
			t.sendMessage(message,message.getAllRecipients());
			t.close();
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return JsonEmpleadosEv;
	}


	private JSONObject BorraDatos(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject JsonEmpleadosEv = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		String idEvaluado=request.getParameter("idEvaluado");
		String idEncuesta=request.getParameter("idEncuesta");
		GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<Evaluado> listEmpleados =  gstorEvaluaciones.borraEvaluacion(listaQuerys, cdo,idEvaluado,infoUsu,idEncuesta);
		
		JsonEmpleadosEv.put("listEvaluados",listEmpleados);
		
		return JsonEmpleadosEv;
	}


	private JSONObject guardaDatos(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject JsonEmpleadosEv = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		String idEvaluado=request.getParameter("idEvaluado");
		String idEvaluador=request.getParameter("idEvaluador");
		String pColaborador=request.getParameter("pColaborador");
		String idEncuesta=request.getParameter("idEncuesta");
		GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<Evaluado> listEmpleados =  gstorEvaluaciones.guardaEvaluacion(listaQuerys, cdo,idEvaluado,idEvaluador,pColaborador,idEncuesta,infoUsu);
		
		JsonEmpleadosEv.put("listEvaluados",listEmpleados);
		
		return JsonEmpleadosEv;
	}


	private JSONObject consultaEvaluados(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
			JSONObject JsonEmpleadosEv = new JSONObject();
			String cdo =  (String) session.getAttribute("uname");
			String idArea=request.getParameter("idArea");
			String idEncuesta=request.getParameter("idEncuesta");
			String depto=request.getParameter("idDepto");
			GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
			Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
			List<Evaluado> listEmpleados =  gstorEvaluaciones.consultaEvaluados(listaQuerys, cdo,idArea,idEncuesta,depto,infoUsu);
			
			JsonEmpleadosEv.put("listEvaluados",listEmpleados);
			
			return JsonEmpleadosEv;
	}


	private JSONObject consultaEmpleadosEC(HttpServletRequest request, HttpServletResponse response,
		List<Querys> listaQuerys, HttpSession session) {
			JSONObject JsonEmpleadosEv = new JSONObject();
			String cdo =  (String) session.getAttribute("uname");
			String idArea=request.getParameter("idArea");
			String idEvaluado=request.getParameter("idEvaluado");

			GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
			Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
			List<Empleados> listEmpleados =  gstorEvaluaciones.consultaEmpleadosEC(listaQuerys, cdo,idArea,idEvaluado,infoUsu);
			
			JsonEmpleadosEv.put("listEmpleadosEv",listEmpleados);
			
			return JsonEmpleadosEv;
	}


	private JSONObject consultaEmpleadosEvC(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonEmpleadosEv = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		String idJerarquia=request.getParameter("idJerarquia");
		String idArea=request.getParameter("idArea");
		String idEvaluado=request.getParameter("idEvaluado");
		GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<Empleados> listEmpleados =  gstorEvaluaciones.consultaEmpleadosEvC(listaQuerys, cdo, idJerarquia,idArea,idEvaluado,infoUsu);
		
		JsonEmpleadosEv.put("listEmpleadosEv",listEmpleados);
		
		return JsonEmpleadosEv;
	}


	private JSONObject consultaEmpleadosEvS(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonEmpleadosEv = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		String idJerarquia=request.getParameter("idJerarquia");
		String idArea=request.getParameter("idArea");
		GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<Empleados> listEmpleados =  gstorEvaluaciones.consultaEmpleadosEvS(listaQuerys, cdo, idJerarquia,idArea,infoUsu);
		
		JsonEmpleadosEv.put("listEmpleadosEv",listEmpleados);
		
		return JsonEmpleadosEv;
	}


	private JSONObject consultaEmpleadosEv(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonEmpleadosEv = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		String idJerarquia=request.getParameter("idJerarquia");
		String idArea=request.getParameter("idArea");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
		
		List<Empleados> listEmpleados =  gstorEvaluaciones.consultaEmpleadosEv(listaQuerys, cdo, idJerarquia,idArea, infoUsu);
		
		JsonEmpleadosEv.put("listEmpleadosEv",listEmpleados);
		
		return JsonEmpleadosEv;
	}


	private JSONObject consultaEmpleados(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonEmpleados = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		String idArea=request.getParameter("idArea");
		GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		
		List<Empleados> listEmpleados =  gstorEvaluaciones.consultaEmpleados(listaQuerys, cdo, idArea, infoUsu);
		
		JsonEmpleados.put("listEmpleados",listEmpleados);
		
		return JsonEmpleados;
	}


	private JSONObject consultaAreas(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject JsonAreas = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
		String idEncuesta=request.getParameter("idEncuesta");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<Areas> listAreas =  gstorEvaluaciones.consultaAreas(listaQuerys, cdo, infoUsu,idEncuesta) ;
		
		JsonAreas.put("listAreas",listAreas);
		
		return JsonAreas;
	}


	private JSONObject consultaEvaluaciones(HttpServletRequest request, HttpServletResponse response,List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonEvaluaciones = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<Evaluacion> listEvaluaciones =  gstorEvaluaciones.ConsultaEvaluaciones(listaQuerys, cdo, infoUsu) ;
		
		JsonEvaluaciones.put("listEvaluaciones",listEvaluaciones);
		return JsonEvaluaciones;
	}


	public void RedireccionarVista(HttpServletRequest request, HttpServletResponse response, String vista)
	{
		try
		{
			RequestDispatcher rdIndex = request.getRequestDispatcher("jsp/" + vista);			    	
		    rdIndex.forward(request, response);
		}
		catch(Exception ex)
		{
			try {
			RequestDispatcher rdIndex = request.getRequestDispatcher(vista);			    	
		    rdIndex.forward(request, response);
			}
			catch (Exception e) {
				System.out.println("Error al re-direccionar vista." + e.getMessage().toString());
			}
		}
	}
	
	private void EviarRespuestaJsonJS(HttpServletRequest request, HttpServletResponse response, String respuesta)
	{
		try
		{
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(respuesta);	
		}
		catch(Exception ex)
		{
			System.out.println("Error al re-direccionar vista." + ex.getMessage().toString());
		}
	}
}
