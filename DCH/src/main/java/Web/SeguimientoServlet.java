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

import Datos.Querys;
import Datos.Seguimiento;
import Datos.SeguimientoDetalle;
import Datos.Usuario;
import Persistencia.GestorSeguimiento;

/**
 * Servlet implementation class SeguimientoServlet
 */
public class SeguimientoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeguimientoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
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
			 JSONObject listaSeguimientoJson = new JSONObject();	
			  //System.out.println("accion:" + accion);
					switch (accion) {
					case "Inicio":
						session.setAttribute("accionServlet", "1");
						RedireccionarVista(request, response, "/Seguimiento.jsp");
						break;
					case "Cargar":
						listaSeguimientoJson=cargaSegumiento(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaSeguimientoJson.toString()+"]");
						break;
					case "SeguimientoDetalle":
						listaSeguimientoJson=cargaSegumientoDetalle(request,response, listaQuerys, session);
						EviarRespuestaJsonJS(request,response, "["+ listaSeguimientoJson.toString()+"]");
						break;
					}
		 }
		 catch(Exception ex)
		 {
	
		 }
		}
		


	private JSONObject cargaSegumientoDetalle(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
		JSONObject JsonSeguimiento = new JSONObject();
		String cdo =  (String) session.getAttribute("uname");
		String idEmpleado=request.getParameter("idEmpleado");
		Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
		List<SeguimientoDetalle> listSegumiento =  GestorSeguimiento.consultaSeguimientoDetalle(listaQuerys,cdo,idEmpleado,infoUsu);
		
		JsonSeguimiento.put("listSegumiento",listSegumiento);
		
		return JsonSeguimiento;
	}

	private JSONObject cargaSegumiento(HttpServletRequest request, HttpServletResponse response,
			List<Querys> listaQuerys, HttpSession session) {
			JSONObject JsonSeguimiento = new JSONObject();
			String cdo =  (String) session.getAttribute("uname");
			Usuario infoUsu=(Usuario) session.getAttribute("DatosUsr");
			String idEncuesta=request.getParameter("idEncuesta");
			List<Seguimiento> listSegumiento =  GestorSeguimiento.consultaSeguimiento(listaQuerys,cdo,infoUsu,idEncuesta);
			
			JsonSeguimiento.put("listSegumiento",listSegumiento);
			
			return JsonSeguimiento;
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

