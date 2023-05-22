package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import Datos.Empleado;
import Datos.Querys;
import Datos.Seguimiento;
import Datos.SeguimientoDetalle;
import Datos.Usuario;
import Persistencia.GestorEmpleados;
import Persistencia.GestorSeguimiento;

/**
 * Servlet implementation class EmpleadosServlet
 */
public class EmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			 JSONObject listaEmpleadosJson = new JSONObject();	
			  //System.out.println("accion:" + accion);
					switch (accion) {
					case "Inicio":
						session.setAttribute("accionServlet", "1");
						RedireccionarVista(request, response, "/Empleados.jsp");
						break;
					case "Cargar":
						listaEmpleadosJson=cargarEmpleados(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEmpleadosJson.toString()+"]");
						break;
					case "CambioCorreo":
						listaEmpleadosJson=cambiaCorreo(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaEmpleadosJson.toString()+"]");
						break;
						
						
					}
		 }
		 catch(Exception ex)
		 {
	
		 }
		}
		


	private JSONObject cambiaCorreo(HttpServletRequest request, HttpServletResponse response, List<Querys> listaQuerys,
			HttpSession session) {
		JSONObject JsonEmpleados = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		String correo=request.getParameter("correo");
		String idTipoEncuesta=request.getParameter("idTipoEncuesta");
		String idEmpleado=request.getParameter("idEmpleado");
		GestorEmpleados gs = new GestorEmpleados();
		String rsp=  gs.cambiaCorreo(listaQuerys,cdo,infoUsu,correo,idTipoEncuesta,idEmpleado);
		JsonEmpleados.put("rsp",rsp);
		
		return JsonEmpleados;
	}

	private JSONObject cargarEmpleados(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonEmpleados = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		GestorEmpleados gs = new GestorEmpleados();
		List<Empleado> listEmpleados=  gs.consultaEmpleados(listaQuerys,cdo,infoUsu);
		//System.out.println(listEmpleados.size());
		JsonEmpleados.put("listEmpleados",listEmpleados);
		
		return JsonEmpleados;
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
