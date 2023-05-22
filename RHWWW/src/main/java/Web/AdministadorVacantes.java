package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import Datos.Centro;
import Datos.Puesto;
import Datos.Querys;
import Datos.Vacante;
import Persistencia.GestorVacantes;
import Util.ConexionBD;
 
public class AdministadorVacantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AdministadorVacantes() {
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
			 JSONObject listaVacantesJson = new JSONObject();	
			  //System.out.println("accion:" + accion);
					switch (accion) {
					case "Inicio":
						
						session.setAttribute("accionServlet", "1");
						session.setAttribute("listaCDOs", ConsultaEmpresas(request, response, listaQuerys) );
						session.setAttribute("listaPuestos", ConsultaPuestos(request, response, listaQuerys) );
						RedireccionarVista(request, response, "/AdministradorVacantes.jsp");
						
						break;
					case "Cargar":
						
										
						listaVacantesJson = ConsultaVacantes(request, response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaVacantesJson.toString()+"]");
						break;
					case "Actualizar":
						listaVacantesJson =  ActualizaRegistroVacente(request, response, listaQuerys);
						EviarRespuestaJsonJS(request,response, "["+ listaVacantesJson.toString()+"]");
						
						break;
					case "Agregar":
						listaVacantesJson =  AgregarVacante(request, response, listaQuerys);
						EviarRespuestaJsonJS(request,response, "["+ listaVacantesJson.toString()+"]");
						
						break;
					case "Eliminar":
						listaVacantesJson =  EliminarVacante(request, response, listaQuerys);
						EviarRespuestaJsonJS(request,response, "["+ listaVacantesJson.toString()+"]");
						
						break;
					}
		 }
		 catch(Exception ex)
		 {
	
		 }
		}
		



	private JSONObject EliminarVacante(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys) {
		Connection connBD = ConexionBD.abrirConexionBD();	
		JSONObject JsonVacantes = new JSONObject();
		 try
		 {

			 Vacante vacante = new Vacante();
			 vacante.setIdVacante(  Integer.parseInt( request.getParameter("idVacante")  ) );
			
			 
			// System.out.println("vacante A Eliminar: " + vacante);
			 
			 GestorVacantes gstorVacante = new GestorVacantes();
			 
			 List<Vacante> ListVacantes = gstorVacante.EliminarVacante(connBD, vacante, listaQuerys);
			 
		
			 JsonVacantes.put("listaVacantes",ListVacantes);
				
		 }
		 catch (Exception e) {
			 System.out.println("Erro al Eliminar Vacante : " + e);
		}
		 finally {
			 try {
				 if(connBD != null) {
					connBD.close();
				 }
				} catch (Exception e) {
					System.out.println("ERROR al cerrar conexcion en AdministradorVacantes.EliminarVacante: " + e);
				}
		}
		 return JsonVacantes;
	}


	private JSONObject AgregarVacante(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys) {
		Connection connBD = ConexionBD.abrirConexionBD();	
		JSONObject JsonVacantes = new JSONObject();
		 try
		 {

			 Vacante vacante = new Vacante();
			 
			 vacante.setIdPuesto( Integer.parseInt( request.getParameter("idPuesto")  ) );
			 vacante.setCveEmpresa(Integer.parseInt( request.getParameter("cveEmpresa")  ) );
			 vacante.setDescripcionVacante( ponerTilde(request.getParameter("descripcionVacante")) );
			 vacante.setHorarioVacante( ponerTilde(request.getParameter("horarioVacante")) );
			 vacante.setLugarTrabajo(  ponerTilde(request.getParameter("lugarTrabajo")) );
			 vacante.setFechaPublicacion( request.getParameter("fecha_publicacion") );
			 vacante.setObservaciones( ponerTilde(request.getParameter("observaciones")) );
			 vacante.setIdEstado( Integer.parseInt( request.getParameter("estadoVacante")) );
			 vacante.setEstatus(Integer.parseInt( request.getParameter("estatusVacante")) );
			 
			// System.out.println("Nueva vacante: " + vacante);
			 
			GestorVacantes gstor = new GestorVacantes();
			
			 List<Vacante> ListVacantes = gstor.AgregarVacante(connBD, vacante, listaQuerys);
			 
				
			 JsonVacantes.put("listaVacantes",ListVacantes);
				
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
					System.out.println("ERROR al cerrar conexcion en GestorVacantes.ConsultaVacantes: " + e);
				}
		}
		 return JsonVacantes;
	}


	private JSONObject ActualizaRegistroVacente(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys) {
		Connection connBD = ConexionBD.abrirConexionBD();	
		JSONObject JsonVacantes = new JSONObject();
		 try
		 {

			 Vacante vacante = new Vacante();
			 vacante.setIdVacante(  Integer.parseInt( request.getParameter("idVacante")  ) );
			 vacante.setIdPuesto( Integer.parseInt( request.getParameter("idPuesto")  ) );
			 vacante.setCveEmpresa(Integer.parseInt( request.getParameter("cveEmpresa")  ) );
			 vacante.setDescripcionVacante( ponerTilde(request.getParameter("descripcionVacante")) );
			 vacante.setHorarioVacante( ponerTilde(request.getParameter("horarioVacante")) );
			 vacante.setLugarTrabajo(  ponerTilde(request.getParameter("lugarTrabajo")) );
			 vacante.setFechaPublicacion( request.getParameter("fecha_publicacion") );
			 vacante.setObservaciones( ponerTilde(request.getParameter("observaciones")) );
			 vacante.setIdEstado( Integer.parseInt( request.getParameter("estadoVacante")) );
			 vacante.setEstatus(Integer.parseInt( request.getParameter("estatusVacante")) );
			 
			//System.out.println("vacante: " + vacante);
			 
			 GestorVacantes gstorVacante = new GestorVacantes();
			 
			 List<Vacante> ListVacantes = gstorVacante.ActualizaVacante(connBD, vacante, listaQuerys);
			 
		
			 JsonVacantes.put("listaVacantes",ListVacantes);
				
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
					System.out.println("ERROR al cerrar conexcion en GestorVacantes.ConsultaVacantes: " + e);
				}
		}
		 return JsonVacantes;
	}


	private List<Puesto> ConsultaPuestos(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys) {
	JSONObject JsonPuestos= new JSONObject();
		
		GestorVacantes gstorVacantes = new GestorVacantes();
		
		List<Puesto> listaPuestos =  gstorVacantes.ConsultaPuestos(listaQuerys) ;
		// System.out.println("listaPuestos: "+ listaPuestos);
		JsonPuestos.put("listaPuestos",listaPuestos);
		 
		return listaPuestos;
	}


	private JSONObject ConsultaVacantes(HttpServletRequest request, HttpServletResponse response,List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonVacantes = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		GestorVacantes gstorVacantes = new GestorVacantes();
		
		List<Vacante> listaVacantes =  gstorVacantes.ConsultaVacantes(listaQuerys, cdo) ;
		
		JsonVacantes.put("listaVacantes",listaVacantes);
		return JsonVacantes;
	}

	
	private List<Centro> ConsultaEmpresas(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys) {
		List<Centro> listaEmpresas = new ArrayList<>();
		GestorVacantes vac = new GestorVacantes();
		listaEmpresas = vac.ConsultaCentros(listaQuerys);
		// System.out.println("listaEmpresas.json: "+listaEmpresas);
		return listaEmpresas;
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
