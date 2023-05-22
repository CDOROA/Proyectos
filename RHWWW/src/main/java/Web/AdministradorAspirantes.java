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

import Datos.Aspirante;
import Datos.Querys;
import Persistencia.GestorAspirantes;
import Util.ConexionBD;


public class AdministradorAspirantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdministradorAspirantes() {
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
		{  
			System.out.println("AdministradorAspirantes accion  no entra a validar peticion");
			if(session == null)
			{
				RequestDispatcher rdIndex = request.getRequestDispatcher("/inicio.jsp");	
				System.out.println("AdministradorAspirantes accion NO entra a validar  ");
				rdIndex.forward(request, response);
				return;
			}
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	private void validaPeticion(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		 try {
			 List<Querys> listaQuerys = (List<Querys>) session.getAttribute("querys");
			 String accion = String.valueOf(request.getParameter("accion"));
			 
			 JSONObject listaAspirantesJson = new JSONObject();	
			 switch (accion) {
					case "Inicio":
						
						session.setAttribute("accionServlet", "1");
//						session.setAttribute("listaCDOs", ConsultaEmpresas(request, response, listaQuerys) );
	//					session.setAttribute("listaPuestos", ConsultaPuestos(request, response, listaQuerys) );
						RedireccionarVista(request, response, "/AdministradorAspirantes.jsp");
						
						break;
					case "Cargar":
						
						listaAspirantesJson = ConsultaAspirantes(request, response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaAspirantesJson.toString()+"]");
						break;
					case "Actualizar":
						
						listaAspirantesJson =  ActualizaEstatus(request, response, listaQuerys);
						EviarRespuestaJsonJS(request,response, "["+ listaAspirantesJson.toString()+"]");
						
						break;
					}
		 }
		 catch(Exception ex)
		 {
			 System.out.println("Error en validar operacion: Aspirantes" + ex );
		 }
		}
	
	private JSONObject ConsultaAspirantes(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys,  HttpSession session) {
            JSONObject JsonAspirantes = new JSONObject();
            String cdo =  (String) session.getAttribute("uname");
		     GestorAspirantes gstorAsp = new GestorAspirantes();
		     List<Aspirante> listaAspirantes =  gstorAsp.ConsultaAspirantes(listaQuerys,cdo) ;
		     JsonAspirantes.put("listaAspirantes",listaAspirantes);
		return JsonAspirantes;
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
	private JSONObject ActualizaEstatus(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys) {
		Connection connBD = ConexionBD.abrirConexionBD();	
		JSONObject JsonAspirantes = new JSONObject();
		
		 try
		 {

			 Aspirante asp = new Aspirante();

			 asp.setIdAspirante(Integer.parseInt(request.getParameter("id")));
			 asp.setStatus((request.getParameter("estatus")));
			 
			 GestorAspirantes gstorAspirante= new GestorAspirantes();

			 List<Aspirante> ListAspirante = gstorAspirante.ActualizaEstatus(connBD, asp, listaQuerys);
			 JsonAspirantes.put("listaAspirante",ListAspirante);
			 
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
					System.out.println("ERROR al cerrar conexcion en AdministrarAspirantes.ActualizaEstatus: " + e);
				}
		}
		 return JsonAspirantes;
	}
	
	
}