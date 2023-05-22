




package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import Datos.Empleado;
import Datos.Evaluacion;
import Datos.Querys;
import Persistencia.GestorEvaluaciones;
import Util.ConexionBD;
 
public class EvaluacionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public EvaluacionesServlet() {
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
			 List<Querys> listaQuerys = (List<Querys>) session.getAttribute("querys");
			 String accion = String.valueOf(request.getParameter("accion"));
			 JSONObject listaEvaluacionesJson = new JSONObject();	
			  //System.out.println("accion:" + accion);
					switch (accion) {
					case "Inicio":
						session.setAttribute("accionServlet", "1");
						RedireccionarVista(request, response, "/Evaluaciones.jsp");
						break;
					case "Cargar":
						listaEvaluacionesJson=consultaEvaluaciones(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					case "Actualizar":
						listaEvaluacionesJson=actualizaEvaluacion(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						
						break;
					case "ActualizarEncuesta":
						listaEvaluacionesJson=actualizaEncuesta(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						
						break;
					case "ValidaRespuestas":
						listaEvaluacionesJson=validaRespuesta(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEvaluacionesJson.toString()+"]");
						break;
					}
		 }
		 catch(Exception ex)
		 {
	
		 }
		}
		




	



	private JSONObject validaRespuesta(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonVacantes = new JSONObject();
		String cdo =  (String) session.getAttribute("cdo");
		String idEmpleadoEvaluado = request.getParameter("idEvaluado");
		String idTipoEncuesta =  request.getParameter("idTipoEncuesta");
		String idEmpleadoEvaluador = request.getParameter("idEvaluador");
		GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
		Empleado infoUsu=(Empleado) session.getAttribute("DatosUsr");
		boolean validaRespuesta =  gstorEvaluaciones.validaResultado(listaQuerys, cdo, idEmpleadoEvaluado,idEmpleadoEvaluador, idTipoEncuesta, infoUsu) ;
		
		JsonVacantes.put("respuesta",validaRespuesta);
		return JsonVacantes;
	}


	private JSONObject actualizaEncuesta(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		String cdo=(String) session.getAttribute("uname");
		String idEmpleadoer=(String) session.getAttribute("idEmpleado");
		Connection connBD = ConexionBD.AbrirConexionBDD(cdo);
	JSONObject listEvaluaciones = new JSONObject();
	 try
	 {
		
		String idEmpleadoev=request.getParameter("idEmpleadoev");
		String estatus=request.getParameter("estatus");
		 //System.out.println(" comentarios; "+comentarios+"preguntas: "+pregunta1+pregunta2+"resutado: "+resultado);
		GestorEvaluaciones gst= new GestorEvaluaciones();
		Empleado infoUsu=(Empleado) session.getAttribute("DatosUsr");
		List<Evaluacion> eva = gst.actualizaEstatus(estatus, idEmpleadoev,idEmpleadoer,listaQuerys,cdo, infoUsu);
		listEvaluaciones.put("listaVacantes",eva);
			
	 }
	 catch (Exception e) {
		 System.out.println("Erro al actualizar el registo : " + e);
	}
	 finally {
		 try {
			 if(connBD != null) {
				connBD.close();
			 }
			} catch (Exception e) {
				System.out.println("ERROR al cerrar conexcion en EvaluacionServlet.actualizaEvaluacion: " + e);
			}
	}
	 return listEvaluaciones;
	}


	private JSONObject consultaEvaluaciones(HttpServletRequest request, HttpServletResponse response,List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonVacantes = new JSONObject();
		String cdo =  (String) session.getAttribute("cdo");
		String idEmpleado =  (String) session.getAttribute("idEmpleado");
		GestorEvaluaciones gstorEvaluaciones = new GestorEvaluaciones();
		Empleado infoUsu=(Empleado) session.getAttribute("DatosUsr");
		List<Evaluacion> listEvaluaciones =  gstorEvaluaciones.consultaEvaluaciones(listaQuerys, cdo, idEmpleado, infoUsu) ;
		
		JsonVacantes.put("listEvaluaciones",listEvaluaciones);
		return JsonVacantes;
	}
	
	private JSONObject actualizaEvaluacion(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
			String cdo=(String) session.getAttribute("uname");
			String idEmpleadoer=(String) session.getAttribute("idEmpleado");
			Connection connBD = ConexionBD.AbrirConexionBDD(cdo);
		JSONObject listEvaluaciones = new JSONObject();
		 try
		 {
			String comentarios=ponerTilde(request.getParameter("comentarios"));
			String resultado=request.getParameter("resultado");
			String idPregunta=request.getParameter("idPregunta");
			String idEmpleadoev=request.getParameter("idEmpleadoev");
			String idEncuesta = request.getParameter("idEncuesta");
			 //System.out.println(" comentarios; "+comentarios+"preguntas: "+pregunta1+pregunta2+"resutado: "+resultado);
			GestorEvaluaciones gst= new GestorEvaluaciones();
			Empleado infoUsu=(Empleado) session.getAttribute("DatosUsr");
			List<Evaluacion> eva = gst.verificaRespuesta(idPregunta,comentarios,resultado, idEmpleadoev,idEmpleadoer,listaQuerys,cdo,infoUsu,idEncuesta);
			listEvaluaciones.put("listaVacantes",eva);
				
		 }
		 catch (Exception e) {
			 System.out.println("Erro al actualizar el registo : " + e);
		}
		 finally {
			 try {
				 if(connBD != null) {
					connBD.close();
				 }
				} catch (Exception e) {
					System.out.println("ERROR al cerrar conexcion en EvaluacionServlet.actualizaEvaluacion: " + e);
				}
		}
		 return listEvaluaciones;
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
	private String ponerTilde(String palabra) {
		String[] letras= {"a1","A2","e1","E2","i1","I2","o1","O2","u1","U2","n1","N2"};
		String[] codigo= {"á","Á","é","É","í","Í","ó","Ó","ú","Ú","ñ","Ñ"};
		for (int i = 0; i < letras.length; i++) {
			   palabra=palabra.replaceAll(letras[i],codigo[i]);
			  //alert(letras[i]+codigo[i]);
			}
		return palabra;
		
	}
}
